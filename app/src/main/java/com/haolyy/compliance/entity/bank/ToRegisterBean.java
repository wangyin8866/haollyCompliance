package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/6/28.
 */

public class ToRegisterBean {
    /**
     * code : 200
     * msg : 成功
     * model : {"data":{"order_no_":"17071620564300181","MerCustId":"6000060007051718","UsrName":"伏凌蝶","AreaId":"1100","CharSet":"UTF-8","CardId":"6228223211212310095","huifu_url":"http://mertest.chinapnr.com/muser/publicRequests","UsrId":"1873a8a2","IdType":"00","BgRetUrl":"http://116.236.225.158:8010/yqs/huifush/register.html?MerPriv=17071620564300181","SmsSeq":"AAAAAAAA","UsrMp":null,"Version":"10","CmdId":"UserRegister","ProvId":"0011","RetUrl":"http://www.chinazyjr.com/","SmsCode":"666666","PageType":"","BankId":"ABC","ChkValue":"06D84D8AFD6B7129F2E1495ADEC2A5D7B0284CD935C9C217F3E3A42646FAE17F2E03295B9AAEA432660DE633370BBE6EEE52BEA612219DE144D9F8B49B6977DCC12DFFB3FAC597F9111A756643ACA16FD7727E166809570C1FD67B26EFEDC8F09111E638E2E552FBCEFD372FE53934D11E3534EE3E79318A5C6802BAE914655F","IdNo":"13018219900819412"}}
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
         * data : {"order_no_":"17071620564300181","MerCustId":"6000060007051718","UsrName":"伏凌蝶","AreaId":"1100","CharSet":"UTF-8","CardId":"6228223211212310095","huifu_url":"http://mertest.chinapnr.com/muser/publicRequests","UsrId":"1873a8a2","IdType":"00","BgRetUrl":"http://116.236.225.158:8010/yqs/huifush/register.html?MerPriv=17071620564300181","SmsSeq":"AAAAAAAA","UsrMp":null,"Version":"10","CmdId":"UserRegister","ProvId":"0011","RetUrl":"http://www.chinazyjr.com/","SmsCode":"666666","PageType":"","BankId":"ABC","ChkValue":"06D84D8AFD6B7129F2E1495ADEC2A5D7B0284CD935C9C217F3E3A42646FAE17F2E03295B9AAEA432660DE633370BBE6EEE52BEA612219DE144D9F8B49B6977DCC12DFFB3FAC597F9111A756643ACA16FD7727E166809570C1FD67B26EFEDC8F09111E638E2E552FBCEFD372FE53934D11E3534EE3E79318A5C6802BAE914655F","IdNo":"13018219900819412"}
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
             * order_no_ : 17071620564300181
             * MerCustId : 6000060007051718
             * UsrName : 伏凌蝶
             * AreaId : 1100
             * CharSet : UTF-8
             * CardId : 6228223211212310095
             * huifu_url : http://mertest.chinapnr.com/muser/publicRequests
             * UsrId : 1873a8a2
             * IdType : 00
             * BgRetUrl : http://116.236.225.158:8010/yqs/huifush/register.html?MerPriv=17071620564300181
             * SmsSeq : AAAAAAAA
             * UsrMp : null
             * Version : 10
             * CmdId : UserRegister
             * ProvId : 0011
             * RetUrl : http://www.chinazyjr.com/
             * SmsCode : 666666
             * PageType :
             * BankId : ABC
             * ChkValue : 06D84D8AFD6B7129F2E1495ADEC2A5D7B0284CD935C9C217F3E3A42646FAE17F2E03295B9AAEA432660DE633370BBE6EEE52BEA612219DE144D9F8B49B6977DCC12DFFB3FAC597F9111A756643ACA16FD7727E166809570C1FD67B26EFEDC8F09111E638E2E552FBCEFD372FE53934D11E3534EE3E79318A5C6802BAE914655F
             * IdNo : 13018219900819412
             */

            private String order_no_;
            private String MerCustId;
            private String UsrName;
            private String AreaId;
            private String CharSet;
            private String CardId;
            private String huifu_url;
            private String UsrId;
            private String IdType;
            private String BgRetUrl;
            private String SmsSeq;
            private Object UsrMp;
            private String Version;
            private String CmdId;
            private String ProvId;
            private String RetUrl;
            private String SmsCode;
            private String PageType;
            private String BankId;
            private String ChkValue;
            private String IdNo;

            public String getOrder_no_() {
                return order_no_;
            }

            public void setOrder_no_(String order_no_) {
                this.order_no_ = order_no_;
            }

            public String getMerCustId() {
                return MerCustId;
            }

            public void setMerCustId(String MerCustId) {
                this.MerCustId = MerCustId;
            }

            public String getUsrName() {
                return UsrName;
            }

            public void setUsrName(String UsrName) {
                this.UsrName = UsrName;
            }

            public String getAreaId() {
                return AreaId;
            }

            public void setAreaId(String AreaId) {
                this.AreaId = AreaId;
            }

            public String getCharSet() {
                return CharSet;
            }

            public void setCharSet(String CharSet) {
                this.CharSet = CharSet;
            }

            public String getCardId() {
                return CardId;
            }

            public void setCardId(String CardId) {
                this.CardId = CardId;
            }

            public String getHuifu_url() {
                return huifu_url;
            }

            public void setHuifu_url(String huifu_url) {
                this.huifu_url = huifu_url;
            }

            public String getUsrId() {
                return UsrId;
            }

            public void setUsrId(String UsrId) {
                this.UsrId = UsrId;
            }

            public String getIdType() {
                return IdType;
            }

            public void setIdType(String IdType) {
                this.IdType = IdType;
            }

            public String getBgRetUrl() {
                return BgRetUrl;
            }

            public void setBgRetUrl(String BgRetUrl) {
                this.BgRetUrl = BgRetUrl;
            }

            public String getSmsSeq() {
                return SmsSeq;
            }

            public void setSmsSeq(String SmsSeq) {
                this.SmsSeq = SmsSeq;
            }

            public Object getUsrMp() {
                return UsrMp;
            }

            public void setUsrMp(Object UsrMp) {
                this.UsrMp = UsrMp;
            }

            public String getVersion() {
                return Version;
            }

            public void setVersion(String Version) {
                this.Version = Version;
            }

            public String getCmdId() {
                return CmdId;
            }

            public void setCmdId(String CmdId) {
                this.CmdId = CmdId;
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

            public String getPageType() {
                return PageType;
            }

            public void setPageType(String PageType) {
                this.PageType = PageType;
            }

            public String getBankId() {
                return BankId;
            }

            public void setBankId(String BankId) {
                this.BankId = BankId;
            }

            public String getChkValue() {
                return ChkValue;
            }

            public void setChkValue(String ChkValue) {
                this.ChkValue = ChkValue;
            }

            public String getIdNo() {
                return IdNo;
            }

            public void setIdNo(String IdNo) {
                this.IdNo = IdNo;
            }
        }
    }
}
