package com.kt.james.wmsforserver.core;

import com.kt.james.wmsforserver.bean.UpShelfBean;

import java.util.List;

public class UpShelfCore {


    public static UpShelfBean checkUpShelfInfo(List<UpShelfBean> items, int itemId,
                                           int locId, float num, StringWrapper errorMsg) {
        UpShelfBean result = null;
        boolean found = false;
        for (int i = 0; i<items.size(); i++) {
            UpShelfBean item = items.get(i);
            if (item.getItemId() == itemId) {
                found = true;
                if (item.getLocId() == locId) {
                    if (item.getNum() == num) {
                        result = item;
                    } else {
                        errorMsg.setValue("上架数量错误");
                    }
                } else {
                    errorMsg.setValue("上架库位错误");
                }
                break;
            }
        }
        if (result == null && !found) {
            errorMsg.setValue("商品信息错误");
        }
        return result;
    }

    /**
     * 上架动线规划
     * @param locs
     * @param curX
     * @param curY
     * @return Null表示全部上架完成
     */
    public static UpShelfBean getNearLoc(List<UpShelfBean> locs, int curX, int curY) {
        int near = -1;
        int minDis = Integer.MAX_VALUE;
        for (int i=0; i<locs.size(); i++) {
            UpShelfBean upShelfBean = locs.get(i);
            if (upShelfBean.getState() == UpShelfBean.STATE_INIT) {
                int mDis = getMDistance(upShelfBean.getLoc_x(), upShelfBean.getLoc_y(),
                        curX, curY);
                if (mDis < minDis) {
                    minDis = mDis;
                    near = i;
                }
            }
        }
        if (near == -1) {
            return null;
        }
        return locs.get(near);
    }

    private static int getMDistance(int targetX, int targetY, int curX, int curY) {
        return Math.abs(targetX - curX) + Math.abs(targetY - curY);
    }

}
