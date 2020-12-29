package com.rain.rainapp.entity;

import java.io.Serializable;
import java.util.List;

//备件管理
public class GoodsEntity implements Serializable {

    /**
     * msg : 查询成功
     * code : 0
     * data : [{"addTime":"2020-11-25 14:22:04.0","goodsName":"螺丝刀","id":2,"number":20,"qrCode":"eaf542792gfbg8086f","remarks":"小件","sType":"小件"},{"addTime":"2020-11-25 14:22:07.0","goodsName":"屏幕","id":3,"number":5,"qrCode":"59126252cg22328g07","remarks":"大件","sType":"大件"},{"addTime":"2020-11-25 14:22:10.0","goodsName":"扫描器","id":4,"number":10,"qrCode":"34g7f9egg00c2530f7","remarks":"配件","sType":"配件"},{"addTime":"2020-11-25 14:22:13.0","goodsName":"钥匙","id":5,"number":10,"qrCode":"0de8143f48b585f9ab","remarks":"小件","sType":"小件"},{"addTime":"2020-11-25 14:22:16.0","goodsName":"读卡器","id":6,"number":5,"qrCode":"eg8g4aaf4d2aa7d608","remarks":"配件","sType":"配件"},{"addTime":"2020-11-26 12:22:19.0","goodsName":"控制板","id":7,"number":10,"qrCode":"12e09e4e16332fac72","remarks":"大件","sType":"大件"}]
     * count : 6
     */

    private String msg;
    private int code;
    private int count;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * addTime : 2020-11-25 14:22:04.0
         * goodsName : 螺丝刀
         * id : 2
         * number : 20
         * qrCode : eaf542792gfbg8086f
         * remarks : 小件
         * sType : 小件
         */

        private String addTime;
        private String goodsName;
        private int id;
        private int number;
        private String qrCode;
        private String remarks;
        private String sType;

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getsType() {
            return sType;
        }

        public void setsType(String sType) {
            this.sType = sType;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "addTime='" + addTime + '\'' +
                    ", goodsName='" + goodsName + '\'' +
                    ", id=" + id +
                    ", number=" + number +
                    ", qrCode='" + qrCode + '\'' +
                    ", remarks='" + remarks + '\'' +
                    ", sType='" + sType + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}