package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/7/5.
 */

public class WithDrawBean {

    /**
     * data : {"data":{"BgRetUrl":"http://116.236.225.158:8010/yqs/huifush/cash.html","ChkValue":"9EEB9538AA6F05E09681C3245358CE6FE15F9FBC195BD8DF9AAF8F423FEEAA5FB2413160B247DFAF07C43DF7F7838DD1E3FC49264D0DA97FBA2CA87F87ED33499DA027239BF0063DE847984D87279BCB308044C729ED1DA73CE9FA44ACAB65DB376DCCEDD16EE4DDFF445B7D3E7DB16C49EE49E8F505DBF30AD309186BCAC1E3","CmdId":"Cash","MerCustId":"6000060007051718","OrdId":"17070514235301817","PageType":"","Remark":"","ReqExt":"[{\"FeeAcctId\":\"MDT000002\",\"CashChl\":\"GENERAL\"}]","RetUrl":"http://www.chinazyjr.com","ServFee":"3.00","ServFeeAcctId":"MDT000002","TransAmt":"1000.00","UsrCustId":"6000060007336733","Version":"20"},"huifu_url":"http://mertest.chinapnr.com/muser/publicRequests"}
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
         * data : {"BgRetUrl":"http://116.236.225.158:8010/yqs/huifush/cash.html","ChkValue":"9EEB9538AA6F05E09681C3245358CE6FE15F9FBC195BD8DF9AAF8F423FEEAA5FB2413160B247DFAF07C43DF7F7838DD1E3FC49264D0DA97FBA2CA87F87ED33499DA027239BF0063DE847984D87279BCB308044C729ED1DA73CE9FA44ACAB65DB376DCCEDD16EE4DDFF445B7D3E7DB16C49EE49E8F505DBF30AD309186BCAC1E3","CmdId":"Cash","MerCustId":"6000060007051718","OrdId":"17070514235301817","PageType":"","Remark":"","ReqExt":"[{\"FeeAcctId\":\"MDT000002\",\"CashChl\":\"GENERAL\"}]","RetUrl":"http://www.chinazyjr.com","ServFee":"3.00","ServFeeAcctId":"MDT000002","TransAmt":"1000.00","UsrCustId":"6000060007336733","Version":"20"}
         * huifu_url : http://mertest.chinapnr.com/muser/publicRequests
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
             * BgRetUrl : http://116.236.225.158:8010/yqs/huifush/cash.html
             * ChkValue : 9EEB9538AA6F05E09681C3245358CE6FE15F9FBC195BD8DF9AAF8F423FEEAA5FB2413160B247DFAF07C43DF7F7838DD1E3FC49264D0DA97FBA2CA87F87ED33499DA027239BF0063DE847984D87279BCB308044C729ED1DA73CE9FA44ACAB65DB376DCCEDD16EE4DDFF445B7D3E7DB16C49EE49E8F505DBF30AD309186BCAC1E3
             * CmdId : Cash
             * MerCustId : 6000060007051718
             * OrdId : 17070514235301817
             * PageType :
             * Remark :
             * ReqExt : [{"FeeAcctId":"MDT000002","CashChl":"GENERAL"}]
             * RetUrl : http://www.chinazyjr.com
             * ServFee : 3.00
             * ServFeeAcctId : MDT000002
             * TransAmt : 1000.00
             * UsrCustId : 6000060007336733
             * Version : 20
             */
            private String huifu_url;
            private String BgRetUrl;
            private String ChkValue;
            private String CmdId;
            private String MerCustId;
            private String OrdId;
            private String PageType;
            private String Remark;
            private String ReqExt;
            private String RetUrl;
            private String ServFee;
            private String ServFeeAcctId;
            private String TransAmt;
            private String UsrCustId;
            private String Version;

            public String getHuifu_url() {
                return huifu_url;
            }

            public void setHuifu_url(String huifu_url) {
                this.huifu_url = huifu_url;
            }

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

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
            }

            public String getReqExt() {
                return ReqExt;
            }

            public void setReqExt(String ReqExt) {
                this.ReqExt = ReqExt;
            }

            public String getRetUrl() {
                return RetUrl;
            }

            public void setRetUrl(String RetUrl) {
                this.RetUrl = RetUrl;
            }

            public String getServFee() {
                return ServFee;
            }

            public void setServFee(String ServFee) {
                this.ServFee = ServFee;
            }

            public String getServFeeAcctId() {
                return ServFeeAcctId;
            }

            public void setServFeeAcctId(String ServFeeAcctId) {
                this.ServFeeAcctId = ServFeeAcctId;
            }

            public String getTransAmt() {
                return TransAmt;
            }

            public void setTransAmt(String TransAmt) {
                this.TransAmt = TransAmt;
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
        }
    }
}
