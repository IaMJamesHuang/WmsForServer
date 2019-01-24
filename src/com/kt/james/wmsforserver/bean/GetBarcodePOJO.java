package com.kt.james.wmsforserver.bean;

import java.util.List;

public class GetBarcodePOJO {


    /**
     * error_code : 0
     * data : {"showapi_res_body":{"code":"6938166920785","goodsName":"苹果醋","goodsType":"","img":"http://app2.showapi.com/img/barCode_img/2f7e639b-aa2f-4248-ae79-f0acc6ea56e6.jpg","imgList":[],"manuAddress":"河南省新乡市原阳县新城开发区","manuName":"新乡市和丝露饮品有限公司","note":"备注：经查，该厂商识别代码已在中国物品编码中心注册，但编码信息未按规定通报","price":"3.00","remark":"查询成功！","ret_code":"0","spec":"268ml","sptmImg":"","trademark":"醋美人生","ycg":""},"showapi_res_code":"0","showapi_res_error":""}
     * reason : success
     */

    private int error_code;
    private DataBean data;
    private String reason;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class DataBean {
        /**
         * showapi_res_body : {"code":"6938166920785","goodsName":"苹果醋","goodsType":"","img":"http://app2.showapi.com/img/barCode_img/2f7e639b-aa2f-4248-ae79-f0acc6ea56e6.jpg","imgList":[],"manuAddress":"河南省新乡市原阳县新城开发区","manuName":"新乡市和丝露饮品有限公司","note":"备注：经查，该厂商识别代码已在中国物品编码中心注册，但编码信息未按规定通报","price":"3.00","remark":"查询成功！","ret_code":"0","spec":"268ml","sptmImg":"","trademark":"醋美人生","ycg":""}
         * showapi_res_code : 0
         * showapi_res_error :
         */

        private ShowapiResBodyBean showapi_res_body;
        private String showapi_res_code;
        private String showapi_res_error;

        public ShowapiResBodyBean getShowapi_res_body() {
            return showapi_res_body;
        }

        public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
            this.showapi_res_body = showapi_res_body;
        }

        public String getShowapi_res_code() {
            return showapi_res_code;
        }

        public void setShowapi_res_code(String showapi_res_code) {
            this.showapi_res_code = showapi_res_code;
        }

        public String getShowapi_res_error() {
            return showapi_res_error;
        }

        public void setShowapi_res_error(String showapi_res_error) {
            this.showapi_res_error = showapi_res_error;
        }

        public static class ShowapiResBodyBean {
            /**
             * code : 6938166920785
             * goodsName : 苹果醋
             * goodsType :
             * img : http://app2.showapi.com/img/barCode_img/2f7e639b-aa2f-4248-ae79-f0acc6ea56e6.jpg
             * imgList : []
             * manuAddress : 河南省新乡市原阳县新城开发区
             * manuName : 新乡市和丝露饮品有限公司
             * note : 备注：经查，该厂商识别代码已在中国物品编码中心注册，但编码信息未按规定通报
             * price : 3.00
             * remark : 查询成功！
             * ret_code : 0
             * spec : 268ml
             * sptmImg :
             * trademark : 醋美人生
             * ycg :
             */

            private String code;
            private String goodsName;
            private String goodsType;
            private String img;
            private String manuAddress;
            private String manuName;
            private String note;
            private String price;
            private String remark;
            private String ret_code;
            private String spec;
            private String sptmImg;
            private String trademark;
            private String ycg;
            private List<?> imgList;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public String getGoodsType() {
                return goodsType;
            }

            public void setGoodsType(String goodsType) {
                this.goodsType = goodsType;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getManuAddress() {
                return manuAddress;
            }

            public void setManuAddress(String manuAddress) {
                this.manuAddress = manuAddress;
            }

            public String getManuName() {
                return manuName;
            }

            public void setManuName(String manuName) {
                this.manuName = manuName;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getRet_code() {
                return ret_code;
            }

            public void setRet_code(String ret_code) {
                this.ret_code = ret_code;
            }

            public String getSpec() {
                return spec;
            }

            public void setSpec(String spec) {
                this.spec = spec;
            }

            public String getSptmImg() {
                return sptmImg;
            }

            public void setSptmImg(String sptmImg) {
                this.sptmImg = sptmImg;
            }

            public String getTrademark() {
                return trademark;
            }

            public void setTrademark(String trademark) {
                this.trademark = trademark;
            }

            public String getYcg() {
                return ycg;
            }

            public void setYcg(String ycg) {
                this.ycg = ycg;
            }

            public List<?> getImgList() {
                return imgList;
            }

            public void setImgList(List<?> imgList) {
                this.imgList = imgList;
            }
        }
    }
}
