package com.haolyy.compliance.entity.product;

/**
 * Created by wangyin on 2017/7/18.
 */

public class Invest {

    /**
     * code : 200
     * msg : 投资成功
     * model : {"data":{"UsrCustId":"6000060007303260","MaxTenderRate":"0.01","MerCustId":"6000060007051718","IsFreeze":"Y","huifu_url":"http://mertest.chinapnr.com/muser/publicRequests","FreezeOrdId":"17071819464600216","BgRetUrl":"http://116.236.225.158:8010/new/huifush/initiativeTender.html","OrdId":"17071819464600216","TransAmt":"100.00","BorrowerDetails":"[{\"BorrowerAmt\":\"100.00\",\"BorrowerRate\":\"1.00\",\"BorrowerCustId\":\"6000060007106321\",\"ProId\":\"6141010000041\"}]","Version":"20","CmdId":"InitiativeTender","OrdDate":"20170718","ChkValue":"3D49668B760446B03EA62307CCB76129A75621D88F6B35E0D281E6B232F0858594272EC0E238185C5AE7FFB4CB492889CA20B73ACCACB9926DD0E3064FA5286D2E62C94B14393C0B9D1A6B6D6D39788A42B67CBF8F7502DF633ABC9F1D3EED1E949211EDDABBFFADEDDA65761EDE57ECE10F2AF43E1627C12C77BB57B99BABAD"}}
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
         * data : {"UsrCustId":"6000060007303260","MaxTenderRate":"0.01","MerCustId":"6000060007051718","IsFreeze":"Y","huifu_url":"http://mertest.chinapnr.com/muser/publicRequests","FreezeOrdId":"17071819464600216","BgRetUrl":"http://116.236.225.158:8010/new/huifush/initiativeTender.html","OrdId":"17071819464600216","TransAmt":"100.00","BorrowerDetails":"[{\"BorrowerAmt\":\"100.00\",\"BorrowerRate\":\"1.00\",\"BorrowerCustId\":\"6000060007106321\",\"ProId\":\"6141010000041\"}]","Version":"20","CmdId":"InitiativeTender","OrdDate":"20170718","ChkValue":"3D49668B760446B03EA62307CCB76129A75621D88F6B35E0D281E6B232F0858594272EC0E238185C5AE7FFB4CB492889CA20B73ACCACB9926DD0E3064FA5286D2E62C94B14393C0B9D1A6B6D6D39788A42B67CBF8F7502DF633ABC9F1D3EED1E949211EDDABBFFADEDDA65761EDE57ECE10F2AF43E1627C12C77BB57B99BABAD"}
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
             * UsrCustId : 6000060007303260
             * MaxTenderRate : 0.01
             * MerCustId : 6000060007051718
             * IsFreeze : Y
             * huifu_url : http://mertest.chinapnr.com/muser/publicRequests
             * FreezeOrdId : 17071819464600216
             * BgRetUrl : http://116.236.225.158:8010/new/huifush/initiativeTender.html
             * OrdId : 17071819464600216
             * TransAmt : 100.00
             * BorrowerDetails : [{"BorrowerAmt":"100.00","BorrowerRate":"1.00","BorrowerCustId":"6000060007106321","ProId":"6141010000041"}]
             * Version : 20
             * CmdId : InitiativeTender
             * OrdDate : 20170718
             * ChkValue : 3D49668B760446B03EA62307CCB76129A75621D88F6B35E0D281E6B232F0858594272EC0E238185C5AE7FFB4CB492889CA20B73ACCACB9926DD0E3064FA5286D2E62C94B14393C0B9D1A6B6D6D39788A42B67CBF8F7502DF633ABC9F1D3EED1E949211EDDABBFFADEDDA65761EDE57ECE10F2AF43E1627C12C77BB57B99BABAD
             */

            private String UsrCustId;
            private String MaxTenderRate;
            private String MerCustId;
            private String IsFreeze;
            private String huifu_url;
            private String FreezeOrdId;
            private String BgRetUrl;
            private String OrdId;
            private String TransAmt;
            private String BorrowerDetails;
            private String Version;
            private String CmdId;
            private String OrdDate;
            private String ChkValue;

            public String getUsrCustId() {
                return UsrCustId;
            }

            public void setUsrCustId(String UsrCustId) {
                this.UsrCustId = UsrCustId;
            }

            public String getMaxTenderRate() {
                return MaxTenderRate;
            }

            public void setMaxTenderRate(String MaxTenderRate) {
                this.MaxTenderRate = MaxTenderRate;
            }

            public String getMerCustId() {
                return MerCustId;
            }

            public void setMerCustId(String MerCustId) {
                this.MerCustId = MerCustId;
            }

            public String getIsFreeze() {
                return IsFreeze;
            }

            public void setIsFreeze(String IsFreeze) {
                this.IsFreeze = IsFreeze;
            }

            public String getHuifu_url() {
                return huifu_url;
            }

            public void setHuifu_url(String huifu_url) {
                this.huifu_url = huifu_url;
            }

            public String getFreezeOrdId() {
                return FreezeOrdId;
            }

            public void setFreezeOrdId(String FreezeOrdId) {
                this.FreezeOrdId = FreezeOrdId;
            }

            public String getBgRetUrl() {
                return BgRetUrl;
            }

            public void setBgRetUrl(String BgRetUrl) {
                this.BgRetUrl = BgRetUrl;
            }

            public String getOrdId() {
                return OrdId;
            }

            public void setOrdId(String OrdId) {
                this.OrdId = OrdId;
            }

            public String getTransAmt() {
                return TransAmt;
            }

            public void setTransAmt(String TransAmt) {
                this.TransAmt = TransAmt;
            }

            public String getBorrowerDetails() {
                return BorrowerDetails;
            }

            public void setBorrowerDetails(String BorrowerDetails) {
                this.BorrowerDetails = BorrowerDetails;
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

            public String getOrdDate() {
                return OrdDate;
            }

            public void setOrdDate(String OrdDate) {
                this.OrdDate = OrdDate;
            }

            public String getChkValue() {
                return ChkValue;
            }

            public void setChkValue(String ChkValue) {
                this.ChkValue = ChkValue;
            }
        }
    }
}
