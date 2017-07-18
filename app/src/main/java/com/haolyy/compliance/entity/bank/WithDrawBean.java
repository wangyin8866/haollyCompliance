package com.haolyy.compliance.entity.bank;

/**
 * Created by niudeyang on 2017/7/5.
 */

public class WithDrawBean {

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

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }


        public static class DataBean {
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
