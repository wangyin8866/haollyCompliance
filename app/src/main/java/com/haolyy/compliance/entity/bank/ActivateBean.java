package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/6/30.
 */

public class ActivateBean {

    /**
     * data : {"data":{"BgRetUrl":"http://116.236.225.158:8010/zjh/huifush/bosAcctActivate.html","ChkValue":"226CE7F684ECDCD03625FAA4533860635FDC4C3973512317AA420FD46F7176B820D500C4B6BC30A8B3DE73C6F2C17F9A24F92D274B32A22DCB539D7EB6B5363A89004EF6CED90E3D471BB439C198D54D2A714EE097A748F6C57D802B313A63BE4A515C761C497C8EE55080373745F47A995A957689161F06F11AFF5BC5F9C620","CmdId":"BosAcctActivate","MerCustId":"6000060007051718","OrdDate":"20170630","OrdId":"17063014403001209","PageType":"","RetUrl":"http://www.chinazyjr.com","UsrCustId":"6000060007299550","Version":"40","huifu_url":"http://mertest.chinapnr.com/muser/publicRequests"}}
     * msg : 系统正常
     * status : 200
     */

    private DataBeanX model;
    private String msg;
    private String code;

    public DataBeanX getModel() {
        return model;
    }

    public void setModel(DataBeanX model) {
        this.model = model;
    }

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

    public static class DataBeanX {
        /**
         * data : {"BgRetUrl":"http://116.236.225.158:8010/zjh/huifush/bosAcctActivate.html","ChkValue":"226CE7F684ECDCD03625FAA4533860635FDC4C3973512317AA420FD46F7176B820D500C4B6BC30A8B3DE73C6F2C17F9A24F92D274B32A22DCB539D7EB6B5363A89004EF6CED90E3D471BB439C198D54D2A714EE097A748F6C57D802B313A63BE4A515C761C497C8EE55080373745F47A995A957689161F06F11AFF5BC5F9C620","CmdId":"BosAcctActivate","MerCustId":"6000060007051718","OrdDate":"20170630","OrdId":"17063014403001209","PageType":"","RetUrl":"http://www.chinazyjr.com","UsrCustId":"6000060007299550","Version":"40","huifu_url":"http://mertest.chinapnr.com/muser/publicRequests"}
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
             * BgRetUrl : http://116.236.225.158:8010/zjh/huifush/bosAcctActivate.html
             * ChkValue : 226CE7F684ECDCD03625FAA4533860635FDC4C3973512317AA420FD46F7176B820D500C4B6BC30A8B3DE73C6F2C17F9A24F92D274B32A22DCB539D7EB6B5363A89004EF6CED90E3D471BB439C198D54D2A714EE097A748F6C57D802B313A63BE4A515C761C497C8EE55080373745F47A995A957689161F06F11AFF5BC5F9C620
             * CmdId : BosAcctActivate
             * MerCustId : 6000060007051718
             * OrdDate : 20170630
             * OrdId : 17063014403001209
             * PageType :
             * RetUrl : http://www.chinazyjr.com
             * UsrCustId : 6000060007299550
             * Version : 40
             * huifu_url : http://mertest.chinapnr.com/muser/publicRequests
             */

            private String BgRetUrl;
            private String ChkValue;
            private String CmdId;
            private String MerCustId;
            private String OrdDate;
            private String OrdId;
            private String PageType;
            private String RetUrl;
            private String UsrCustId;
            private String Version;
            private String huifu_url;

            public String getBgRetUrl() {
                return BgRetUrl;
            }

            public void setBgRetUrl(String BgRetUrl) {
                this.BgRetUrl = BgRetUrl;
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

            public String getMerCustId() {
                return MerCustId;
            }

            public void setMerCustId(String MerCustId) {
                this.MerCustId = MerCustId;
            }

            public String getOrdDate() {
                return OrdDate;
            }

            public void setOrdDate(String OrdDate) {
                this.OrdDate = OrdDate;
            }

            public String getOrdId() {
                return OrdId;
            }

            public void setOrdId(String OrdId) {
                this.OrdId = OrdId;
            }

            public String getPageType() {
                return PageType;
            }

            public void setPageType(String PageType) {
                this.PageType = PageType;
            }

            public String getRetUrl() {
                return RetUrl;
            }

            public void setRetUrl(String RetUrl) {
                this.RetUrl = RetUrl;
            }

            public String getUsrCustId() {
                return UsrCustId;
            }

            public void setUsrCustId(String UsrCustId) {
                this.UsrCustId = UsrCustId;
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
        }
    }
}
