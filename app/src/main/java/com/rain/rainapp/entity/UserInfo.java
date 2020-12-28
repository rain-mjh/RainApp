package com.rain.rainapp.entity;

import java.io.Serializable;
import java.util.List;

//用户信息
public class UserInfo implements Serializable {


    /**
     * success : [{"id":18,"userName":"666","phone":"13800138000","passWord":"123456","addTime":1599728443000,"uppTime":1599728443000,"vRemarks":"测试数据","nType":1,"typePer":null}]
     * errMsg : 管理员登录！
     * status : 200
     */

    private String errMsg;
    private int status;
    private List<SuccessBean> success;


    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<SuccessBean> getSuccess() {
        return success;
    }

    public void setSuccess(List<SuccessBean> success) {
        this.success = success;
    }

    public static class SuccessBean {
        /**
         * id : 18
         * userName : 666
         * phone : 13800138000
         * passWord : 123456
         * addTime : 1599728443000
         * uppTime : 1599728443000
         * vRemarks : 测试数据
         * nType : 1
         * typePer : null
         */

        private int id;
        private String userName;
        private String phone;
        private String passWord;
        private long addTime;
        private long uppTime;
        private String vRemarks;
        private int nType;
        private Object typePer;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }

        public long getAddTime() {
            return addTime;
        }

        public void setAddTime(long addTime) {
            this.addTime = addTime;
        }

        public long getUppTime() {
            return uppTime;
        }

        public void setUppTime(long uppTime) {
            this.uppTime = uppTime;
        }

        public String getvRemarks() {
            return vRemarks;
        }

        public void setvRemarks(String vRemarks) {
            this.vRemarks = vRemarks;
        }

        public int getnType() {
            return nType;
        }

        public void setnType(int nType) {
            this.nType = nType;
        }

        public Object getTypePer() {
            return typePer;
        }

        public void setTypePer(Object typePer) {
            this.typePer = typePer;
        }

        @Override
        public String toString() {
            return "SuccessBean{" +
                    "id=" + id +
                    ", userName='" + userName + '\'' +
                    ", phone='" + phone + '\'' +
                    ", passWord='" + passWord + '\'' +
                    ", addTime=" + addTime +
                    ", uppTime=" + uppTime +
                    ", vRemarks='" + vRemarks + '\'' +
                    ", nType=" + nType +
                    ", typePer=" + typePer +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserName{" +
                "errMsg='" + errMsg + '\'' +
                ", status=" + status +
                ", success=" + success +
                '}';
    }
}