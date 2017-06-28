package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/6/28.
 */

public class ToRegisterBean {

    /**
     * data : {"data":{"AreaId":"1100","BankId":"ABC","BgRetUrl":"http://116.236.225.158:8010/yqs/huifush/register.html?MerPriv=1059451948592","CardId":"6228229339910333","CharSet":"UTF-8","ChkValue":"C8619FC069EC69777D01883995F463A357BB302DA35EB62762F96CEEA65C7EE3629E34CC84DE9EB5AF609B3F4DF4458D666542035D8ADF7F9E937E671232FFA081EC3BD0CBE86B9055B3784A16F90945BA739CD18E4A93DC994F80926CE0A1FDEA49D55D4301486D101DB93619723751BA2CB145E93D0D0A6ED93788AF058C1E","CmdId":"UserRegister","IdNo":"141002199203241329","IdType":"00","MerCustId":"6000060007051718","PageType":"","ProvId":"0011","RetUrl":"http://www.baidu.com","SmsCode":"666666","SmsSeq":"AAAAAAAA","UsrId":"1059451948592","UsrMp":"13856989634","UsrName":"禄博丹","Version":"10","huifu_url":"http://mertest.chinapnr.com/muser/publicRequests","order_no_":"17062819252901144"}}
     * msg : 系统正常
     * status : 200
     */

    private DataBeanX data;
    private String msg;
    private String status;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
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

    public static class DataBeanX {

        /**
         * data : {"AreaId":"1100","BankId":"ABC","BgRetUrl":"http://116.236.225.158:8010/yqs/huifush/register.html?MerPriv=1059451948592","CardId":"6228229339910333","CharSet":"UTF-8","ChkValue":"C8619FC069EC69777D01883995F463A357BB302DA35EB62762F96CEEA65C7EE3629E34CC84DE9EB5AF609B3F4DF4458D666542035D8ADF7F9E937E671232FFA081EC3BD0CBE86B9055B3784A16F90945BA739CD18E4A93DC994F80926CE0A1FDEA49D55D4301486D101DB93619723751BA2CB145E93D0D0A6ED93788AF058C1E","CmdId":"UserRegister","IdNo":"141002199203241329","IdType":"00","MerCustId":"6000060007051718","PageType":"","ProvId":"0011","RetUrl":"http://www.baidu.com","SmsCode":"666666","SmsSeq":"AAAAAAAA","UsrId":"1059451948592","UsrMp":"13856989634","UsrName":"禄博丹","Version":"10","huifu_url":"http://mertest.chinapnr.com/muser/publicRequests","order_no_":"17062819252901144"}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * AreaId : 1100
             * BankId : ABC
             * BgRetUrl : http://116.236.225.158:8010/yqs/huifush/register.html?MerPriv=1059451948592
             * CardId : 6228229339910333
             * CharSet : UTF-8
             * ChkValue : C8619FC069EC69777D01883995F463A357BB302DA35EB62762F96CEEA65C7EE3629E34CC84DE9EB5AF609B3F4DF4458D666542035D8ADF7F9E937E671232FFA081EC3BD0CBE86B9055B3784A16F90945BA739CD18E4A93DC994F80926CE0A1FDEA49D55D4301486D101DB93619723751BA2CB145E93D0D0A6ED93788AF058C1E
             * CmdId : UserRegister
             * IdNo : 141002199203241329
             * IdType : 00
             * MerCustId : 6000060007051718
             * PageType :
             * ProvId : 0011
             * RetUrl : http://www.baidu.com
             * SmsCode : 666666
             * SmsSeq : AAAAAAAA
             * UsrId : 1059451948592
             * UsrMp : 13856989634
             * UsrName : 禄博丹
             * Version : 10
             * huifu_url : http://mertest.chinapnr.com/muser/publicRequests
             * order_no_ : 17062819252901144
             */

            private String AreaId;
            private String BankId;
            private String BgRetUrl;
            private String CardId;
            private String CharSet;
            private String ChkValue;
            private String CmdId;
            private String IdNo;
            private String IdType;
            private String MerCustId;
            private String PageType;
            private String ProvId;
            private String RetUrl;
            private String SmsCode;
            private String SmsSeq;
            private String UsrId;
            private String UsrMp;
            private String UsrName;
            private String Version;
            private String huifu_url;
            private String order_no_;

            public String getAreaId() {
                return AreaId;
            }

            public void setAreaId(String AreaId) {
                this.AreaId = AreaId;
            }

            public String getBankId() {
                return BankId;
            }

            public void setBankId(String BankId) {
                this.BankId = BankId;
            }

            public String getBgRetUrl() {
                return BgRetUrl;
            }

            public void setBgRetUrl(String BgRetUrl) {
                this.BgRetUrl = BgRetUrl;
            }

            public String getCardId() {
                return CardId;
            }

            public void setCardId(String CardId) {
                this.CardId = CardId;
            }

            public String getCharSet() {
                return CharSet;
            }

            public void setCharSet(String CharSet) {
                this.CharSet = CharSet;
            }

            public String getChkValue() {
                return ChkValue;
            }

            public void setChkValue(String ChkValue) {
                this.ChkValue = ChkValue;
            }

            public String getCmdId() {
                return CmdId;
            }

            public void setCmdId(String CmdId) {
                this.CmdId = CmdId;
            }

            public String getIdNo() {
                return IdNo;
            }

            public void setIdNo(String IdNo) {
                this.IdNo = IdNo;
            }

            public String getIdType() {
                return IdType;
            }

            public void setIdType(String IdType) {
                this.IdType = IdType;
            }

            public String getMerCustId() {
                return MerCustId;
            }

            public void setMerCustId(String MerCustId) {
                this.MerCustId = MerCustId;
            }

            public String getPageType() {
                return PageType;
            }

            public void setPageType(String PageType) {
                this.PageType = PageType;
            }

            public String getProvId() {
                return ProvId;
            }

            public void setProvId(String ProvId) {
                this.ProvId = ProvId;
            }

            public String getRetUrl() {
                return RetUrl;
            }

            public void setRetUrl(String RetUrl) {
                this.RetUrl = RetUrl;
            }

            public String getSmsCode() {
                return SmsCode;
            }

            public void setSmsCode(String SmsCode) {
                this.SmsCode = SmsCode;
            }

            public String getSmsSeq() {
                return SmsSeq;
            }

            public void setSmsSeq(String SmsSeq) {
                this.SmsSeq = SmsSeq;
            }

            public String getUsrId() {
                return UsrId;
            }

            public void setUsrId(String UsrId) {
                this.UsrId = UsrId;
            }

            public String getUsrMp() {
                return UsrMp;
            }

            public void setUsrMp(String UsrMp) {
                this.UsrMp = UsrMp;
            }

            public String getUsrName() {
                return UsrName;
            }

            public void setUsrName(String UsrName) {
                this.UsrName = UsrName;
            }

            public String getVersion() {
                return Version;
            }

            public void setVersion(String Version) {
                this.Version = Version;
            }

            public String getHuifu_url() {
                return huifu_url;
            }

            public void setHuifu_url(String huifu_url) {
                this.huifu_url = huifu_url;
            }

            public String getOrder_no_() {
                return order_no_;
            }

            public void setOrder_no_(String order_no_) {
                this.order_no_ = order_no_;
            }
        }
    }
}
