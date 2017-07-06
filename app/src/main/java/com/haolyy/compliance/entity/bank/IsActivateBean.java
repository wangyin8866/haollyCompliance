package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/6/30.
 */

public class IsActivateBean {


    /**
     * data : {"bank_card_no":"6225801240711077","idno":"430522198203153974","message":"该用户已经在卓投平台开户！","mobile":"15001230056","open_account_time":1499225014000,"platform":2,"realname":"雷桢国","type":"3"}
     * msg : 系统正常
     * status : 200
     */

    private DataBean data;
    private String msg;
    private String status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * bank_card_no : 6225801240711077
         * idno : 430522198203153974
         * message : 该用户已经在卓投平台开户！
         * mobile : 15001230056
         * open_account_time : 1499225014000
         * platform : 2
         * realname : 雷桢国
         * type : 3
         */

        private String bank_card_no;
        private String idno;
        private String message;
        private String mobile;
        private long open_account_time;
        private int platform;
        private String realname;
        private String type;

        public String getBank_name() {
            return bank_name;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        private String bank_name;
        public String getBank_card_no() {
            return bank_card_no;
        }

        public void setBank_card_no(String bank_card_no) {
            this.bank_card_no = bank_card_no;
        }

        public String getIdno() {
            return idno;
        }

        public void setIdno(String idno) {
            this.idno = idno;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public long getOpen_account_time() {
            return open_account_time;
        }

        public void setOpen_account_time(long open_account_time) {
            this.open_account_time = open_account_time;
        }

        public int getPlatform() {
            return platform;
        }

        public void setPlatform(int platform) {
            this.platform = platform;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
