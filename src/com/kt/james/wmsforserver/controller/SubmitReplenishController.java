package com.kt.james.wmsforserver.controller;

import com.google.gson.Gson;
import com.kt.james.wmsforserver.bean.SubmitReplenishBean;
import com.kt.james.wmsforserver.dao.ItemLocDao;
import com.kt.james.wmsforserver.dao.LocationDao;
import com.kt.james.wmsforserver.dao.ShelfListDao;
import com.kt.james.wmsforserver.dto.SubmitReplenishDto;
import com.kt.james.wmsforserver.po.Location;
import com.kt.james.wmsforserver.po.ShelfItem;
import com.kt.james.wmsforserver.po.ShelfList;
import com.kt.james.wmsforserver.util.StringUtil;
import com.kt.james.wmsforserver.util.VerificationUtil;

import java.util.ArrayList;
import java.util.List;

public class SubmitReplenishController {

    public SubmitReplenishDto submitReplenish(String company_id, String user_id, String data) {
        SubmitReplenishDto dto = new SubmitReplenishDto();
        Integer realCompanyId = StringUtil.parseInt(company_id);
        Integer realUserId = StringUtil.parseInt(user_id);
        if (realCompanyId == null || realUserId == null || data == null || data.length() == 0) {
            dto.setResponseCode(404);
            dto.setResponseMsg("参数不合法");
            return dto;
        }
        if (!VerificationUtil.verifityLogin(realCompanyId, realUserId)) {
            dto.setResponseCode(404);
            dto.setResponseMsg("未验证的登陆态");
            return dto;
        }
        SubmitReplenishBean bean = new Gson().fromJson(data, SubmitReplenishBean.class);
        if (bean == null || bean.getSubmitInfos() == null || bean.getSubmitInfos().size() == 0) {
            dto.setResponseCode(404);
            dto.setResponseMsg("提交数据不能为空");
            return dto;
        }
        List<SubmitReplenishBean.SubmitItem> submitItems = bean.getSubmitInfos();
        List<ShelfItem> realSubmitData = new ArrayList<>();
        //获取所有的库位列表
        List<Location> locList = LocationDao.getLocationList(realCompanyId);
        //选择应上架的库位
        boolean flag = true;
        for (SubmitReplenishBean.SubmitItem submitItem : submitItems) {
            ShelfItem shelfItem = new ShelfItem();
            shelfItem.setNum(submitItem.getReplenishCount());
            shelfItem.setItem_id(submitItem.getItemId());
            shelfItem.setState(0);
            shelfItem.setLoc_id(-1); //设置初始值

            //获取商品所在的所有库位
            List<Location> itemLoc = ItemLocDao.findItemLocList(realCompanyId, submitItem.getItemId());
            float num = submitItem.getReplenishCount();
            if (itemLoc != null) {
                Location location = findItemLocation(num, itemLoc);
                if (location != null) {
                    location.setAvailable_num(location.getAvailable_num() - num);
                    shelfItem.setLoc_id(location.getId());
                }
            }
            //todo:改为与已知最近的库位排序后搜索
            //如果找不到，则依次寻找
            if (shelfItem.getLoc_id() == -1) {
                Location location = findItemLocation(num, locList);
                if (location != null) {
                    location.setAvailable_num(location.getAvailable_num() - num);
                    shelfItem.setLoc_id(location.getId());
                }
            }
            //如果还是找不到，说明库存不够
            if (shelfItem.getLoc_id() == -1) {
                flag = false;
                break;
            }

            realSubmitData.add(shelfItem);
        }
        //说明库存不够
        if (!flag) {
            dto.setResponseCode(404);
            dto.setResponseMsg("库位容量未能满足此次补货要求！");
            return dto;
        }

        //创建补货单
        boolean isCreateListSuccess = ShelfListDao.createShelfList(realCompanyId);
        if (!isCreateListSuccess) {
            dto.setResponseCode(404);
            dto.setResponseMsg("创建补货单失败！");
            return dto;
        }
        //获取新创建的补货单
        ShelfList maxShelfList = ShelfListDao.getMaxShelfList(realCompanyId);
        if (maxShelfList == null) {
            dto.setResponseCode(404);
            dto.setResponseMsg("获取不到补货单！");
            return dto;
        }
        //设置子项的补货单号
        for (ShelfItem shelfItem : realSubmitData) {
            shelfItem.setShelf_list_id(maxShelfList.getId());
        }
        //创建补货单子项
        boolean isCreateItemSuccess = ShelfListDao.createShelfItems(realSubmitData);
        if (!isCreateItemSuccess) {
            dto.setResponseCode(404);
            dto.setResponseMsg("创建补货单子项失败！");
            return dto;
        }
        dto.setResponseCode(200);
        dto.setResponseMsg("调用成功");
        return dto;
    }

    private Location findItemLocation(float itemSize, List<Location> locations) {
        for (Location location: locations) {
            float avaCount = location.getAvailable_num();
            if (avaCount > itemSize) {
                return location;
            }
        }
        return null;
    }

}
