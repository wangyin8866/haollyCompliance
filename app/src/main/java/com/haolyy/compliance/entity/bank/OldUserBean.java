package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/7/17.
 */

public class OldUserBean {

    /**
     * code : 200
     * msg : 成功
     * model : {"msg":"数据信息同步完成！","realName":"吕芷波","bank_name":"农业银行","bank_card_no":"6228223211212310096","bank_no":"101","idno":"35062719940128888X"}
     */

    private String code;
    private String msg;
    private ModelBean model;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public static class ModelBean {
        /**
         * msg : 数据信息同步完成！
         * realName : 吕芷波
         * bank_name : 农业银行
         * bank_card_no : 6228223211212310096
         * bank_no : 101
         * idno : 35062719940128888X
         */

        private String msg;
        private String realName;
        private String bank_name;
        private String bank_card_no;
        private String bank_no;
        private String idno;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getBank_name() {
            return bank_name;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        public String getBank_card_no() {
            return bank_card_no;
        }

        public void setBank_card_no(String bank_card_no) {
            this.bank_card_no = bank_card_no;
        }

        public String getBank_no() {
            return bank_no;
        }

        public void setBank_no(String bank_no) {
            this.bank_no = bank_no;
        }

        public String getIdno() {
            return idno;
        }

        public void setIdno(String idno) {
            this.idno = idno;
        }
    }
}
