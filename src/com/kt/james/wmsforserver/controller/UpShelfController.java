package com.kt.james.wmsforserver.controller;

import com.kt.james.wmsforserver.bean.UpShelfBean;
import com.kt.james.wmsforserver.core.StringWrapper;
import com.kt.james.wmsforserver.core.UpShelfCore;
import com.kt.james.wmsforserver.dao.CompanyDao;
import com.kt.james.wmsforserver.dao.ItemLocDao;
import com.kt.james.wmsforserver.dao.ShelfListDao;
import com.kt.james.wmsforserver.dao.UserDao;
import com.kt.james.wmsforserver.dto.UpShelfDto;
import com.kt.james.wmsforserver.po.*;
import com.kt.james.wmsforserver.util.StringUtil;

import java.util.List;

public class UpShelfController {


    public UpShelfDto doUpShelf(String company_id, String user_id, String shelfListId,
                                String pos_x, String pos_y, String item_id, String loc_id,
                                String num) {
        Integer realCompanyId = StringUtil.parseInt(company_id);
        Integer realUserId = StringUtil.parseInt(user_id);
        Integer realShelfListId = StringUtil.parseInt(shelfListId);
        Integer realX = StringUtil.parseInt(pos_x);
        Integer realY = StringUtil.parseInt(pos_y);
        Integer realItemId = StringUtil.parseInt(item_id);
        Integer realLoc = StringUtil.parseInt(loc_id);
        Float realNum = StringUtil.parseFloat(num);
        UpShelfDto dto = new UpShelfDto();
        if (realCompanyId == null || realUserId == null || realShelfListId == null
        || realX == null || realY == null || realItemId == null || realNum == null
        || realLoc == null) {
            dto.setResult(null);
            dto.setResponseCode(404);
            dto.setResponseMsg("参数不合法");
            return dto;
        }
        Company company = CompanyDao.getCompanyById(realCompanyId);
        User user = UserDao.findUserById(realUserId);
        if (company == null || user == null) {
            dto.setResult(null);
            dto.setResponseCode(404);
            dto.setResponseMsg("未验证的登陆态");
            return dto;
        }
        ShelfList shelfList = ShelfListDao.findShelfListById(realShelfListId);
        if (shelfList == null) {
            dto.setResult(null);
            dto.setResponseCode(404);
            dto.setResponseMsg("找不到对应的上架单");
            return dto;
        }
        //上架已完成
        int state = shelfList.getState();
        if (state == ShelfList.STATE_FINISH) {
            UpShelfBean upShelfBean = new UpShelfBean();
            upShelfBean.setShelfListState(ShelfList.STATE_FINISH);
            dto.setResult(upShelfBean);
            dto.setResponseCode(200);
            dto.setResponseMsg("此上架单已经完成");
            return dto;
        }
        //初始化模式
        if (state == ShelfList.STATE_INIT) {
            List<UpShelfBean> upShelfList = ShelfListDao.findShelfItemListByListId(shelfList.getId());
            if (upShelfList == null || upShelfList.size() == 0) {
                dto.setResult(null);
                dto.setResponseCode(404);
                dto.setResponseMsg("找不到此上架单对应的信息");
                return dto;
            }
            //动线规划，计算离当前最近的曼哈顿距离
            UpShelfBean result = UpShelfCore.getNearLoc(upShelfList, realX, realY);
            //已经完成
            if (result == null) {
                result = new UpShelfBean();
                result.setShelfListState(ShelfList.STATE_FINISH);
                //同步信息
                shelfList.setState(ShelfList.STATE_FINISH);
                if (!ShelfListDao.updateShelfList(shelfList)) {
                    dto.setResult(null);
                    dto.setResponseCode(404);
                    dto.setResponseMsg("同步信息失败，请重试");
                    return dto;
                }
                dto.setResult(result);
                dto.setResponseCode(200);
                dto.setResponseMsg("此上架单已经完成");
                return dto;
            }
            result.setShelfListState(ShelfList.STATE_PROC);
            shelfList.setState(ShelfList.STATE_PROC);
            shelfList.setOper_id(user.getId());
            if (!ShelfListDao.updateShelfList(shelfList)) {
                dto.setResult(null);
                dto.setResponseCode(404);
                dto.setResponseMsg("同步信息失败，请重试");
                return dto;
            }
            dto.setResult(result);
            dto.setResponseCode(200);
            dto.setResponseMsg("调用成功");
            return dto;
        } else { //进行中
            //校验用户
            if (realUserId != shelfList.getOper_id()) {
                dto.setResult(null);
                dto.setResponseCode(404);
                dto.setResponseMsg("该上架单已经被占用，用户ID为" + shelfList.getOper_id());
                return dto;
            }

            //校验商品
            List<UpShelfBean> upShelfList = ShelfListDao.findShelfItemListByListId(shelfList.getId());
            if (upShelfList == null || upShelfList.size() == 0) {
                dto.setResult(null);
                dto.setResponseCode(404);
                dto.setResponseMsg("找不到此上架单对应的信息");
                return dto;
            }
            StringWrapper error = new StringWrapper();
            UpShelfBean checkResult = UpShelfCore.checkUpShelfInfo(upShelfList, realItemId,
                    realLoc, realNum, error);
            if (checkResult == null) {
                dto.setResult(null);
                dto.setResponseCode(404);
                dto.setResponseMsg(error.getValue());
                return dto;
            }

            //更新上架信息
            ShelfItem shelfItem = new ShelfItem();
            shelfItem.setId(checkResult.getShelfId());
            shelfItem.setShelf_list_id(checkResult.getShelfListId());
            shelfItem.setItem_id(checkResult.getItemId());
            shelfItem.setLoc_id(checkResult.getLocId());
            shelfItem.setState(ShelfItem.STATE_FINISH);
            shelfItem.setNum(checkResult.getNum());
            //更新库存信息
            ItemLoc itemLoc = ItemLocDao.findItemLoc(company.getId(), realItemId, realLoc);
            if (itemLoc == null) {
                ItemLocDao.insertItemLoc(company.getId(), realItemId, realLoc, checkResult.getNum());
            } else {
                ItemLocDao.updateItemLoc(company.getId(), realItemId, realLoc, itemLoc.getStock_count() + checkResult.getNum());
            }
            //更新上架任务状态
            ShelfListDao.updateShelfItem(shelfItem);

            //获取新的上架任务
            //动线规划，计算离当前最近的曼哈顿距离
            upShelfList = ShelfListDao.findShelfItemListByListId(shelfList.getId());
            UpShelfBean result = UpShelfCore.getNearLoc(upShelfList, realX, realY);
            //已经完成
            if (result == null) {
                result = new UpShelfBean();
                result.setShelfListState(ShelfList.STATE_FINISH);
                //同步信息
                shelfList.setState(ShelfList.STATE_FINISH);
                if (!ShelfListDao.updateShelfList(shelfList)) {
                    dto.setResult(null);
                    dto.setResponseCode(404);
                    dto.setResponseMsg("同步信息失败，请重试");
                    return dto;
                }
                dto.setResult(result);
                dto.setResponseCode(200);
                dto.setResponseMsg("此上架单已经完成");
                return dto;
            }
            result.setShelfListState(ShelfList.STATE_PROC);
            if (!ShelfListDao.updateShelfList(shelfList)) {
                dto.setResult(null);
                dto.setResponseCode(404);
                dto.setResponseMsg("同步信息失败，请重试");
                return dto;
            }
            dto.setResult(result);
            dto.setResponseCode(200);
            dto.setResponseMsg("调用成功");
            return dto;
        }
    }


}
