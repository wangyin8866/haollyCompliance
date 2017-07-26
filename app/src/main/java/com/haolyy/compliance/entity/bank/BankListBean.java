package com.haolyy.compliance.entity.bank;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niudeyang on 2017/7/26.
 */

public class BankListBean implements Serializable{

    /**
     * code : 200
     * msg : 成功
     * model : {"code":"200","msg":"成功","model":[{"id":77,"bankNo":"124","bankName":"上海农村商业银行","mapUrl":"http://192.168.7.114/pictures/color/SRCB.png","singerMaxAmount":"50000.00","singerDayAmount":"50000.00","bankCode":"SRCB","status":"1","channel":null},{"id":76,"bankNo":"123","bankName":"浦发银行","mapUrl":"http://192.168.7.114/pictures/color/SPDB.png","singerMaxAmount":"50000.00","singerDayAmount":"50000.00","bankCode":"SPDB","status":"1","channel":null}]}
     */

    private String code;
    private String msg;
    private ModelBeanX model;

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

    public ModelBeanX getModel() {
        return model;
    }

    public void setModel(ModelBeanX model) {
        this.model = model;
    }

    public static class ModelBeanX implements Serializable{
        /**
         * code : 200
         * msg : 成功
         * model : [{"id":77,"bankNo":"124","bankName":"上海农村商业银行","mapUrl":"http://192.168.7.114/pictures/color/SRCB.png","singerMaxAmount":"50000.00","singerDayAmount":"50000.00","bankCode":"SRCB","status":"1","channel":null},{"id":76,"bankNo":"123","bankName":"浦发银行","mapUrl":"http://192.168.7.114/pictures/color/SPDB.png","singerMaxAmount":"50000.00","singerDayAmount":"50000.00","bankCode":"SPDB","status":"1","channel":null}]
         */

        private String code;
        private String msg;
        private List<ModelBean> model;

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

        public List<ModelBean> getModel() {
            return model;
        }

        public void setModel(List<ModelBean> model) {
            this.model = model;
        }

        public static class ModelBean implements Serializable{
            /**
             * id : 77
             * bankNo : 124
             * bankName : 上海农村商业银行
             * mapUrl : http://192.168.7.114/pictures/color/SRCB.png
             * singerMaxAmount : 50000.00
             * singerDayAmount : 50000.00
             * bankCode : SRCB
             * status : 1
             * channel : null
             */

            private int id;
            private String bankNo;
            private String bankName;
            private String mapUrl;
            private String singerMaxAmount;
            private String singerDayAmount;
            private String bankCode;
            private String status;
            private Object channel;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getBankNo() {
                return bankNo;
            }

            public void setBankNo(String bankNo) {
                this.bankNo = bankNo;
            }

            public String getBankName() {
                return bankName;
            }

            public void setBankName(String bankName) {
                this.bankName = bankName;
            }

            public String getMapUrl() {
                return mapUrl;
            }

            public void setMapUrl(String mapUrl) {
                this.mapUrl = mapUrl;
            }

            public String getSingerMaxAmount() {
                return singerMaxAmount;
            }

            public void setSingerMaxAmount(String singerMaxAmount) {
                this.singerMaxAmount = singerMaxAmount;
            }

            public String getSingerDayAmount() {
                return singerDayAmount;
            }

            public void setSingerDayAmount(String singerDayAmount) {
                this.singerDayAmount = singerDayAmount;
            }

            public String getBankCode() {
                return bankCode;
            }

            public void setBankCode(String bankCode) {
                this.bankCode = bankCode;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Object getChannel() {
                return channel;
            }

            public void setChannel(Object channel) {
                this.channel = channel;
            }
        }
    }
}
