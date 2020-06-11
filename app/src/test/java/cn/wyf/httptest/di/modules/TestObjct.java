package cn.wyf.httptest.di.modules;

import java.util.List;

public class TestObjct {

    /**
     * statementInfo : [{"sumActualAmount":2,"sumRefundAmount":0,"sumTransAmount":2,"totalCount":2,"transTypeId":"2225"}]
     * response : {"resultCode":"0","resultMessage":"交易成功"}
     * merchantInfo : {"cashierNo":"01","merchantNo":"95162011520P006"}
     * terminalInfo : {"terminalNo":"2006A000","batchNo":"000003","traceNo":"000011"}
     */

    private ResponseBean response;
    private MerchantInfoBean merchantInfo;
    private TerminalInfoBean terminalInfo;
    private List<StatementInfoBean> statementInfo;

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public MerchantInfoBean getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(MerchantInfoBean merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public TerminalInfoBean getTerminalInfo() {
        return terminalInfo;
    }

    public void setTerminalInfo(TerminalInfoBean terminalInfo) {
        this.terminalInfo = terminalInfo;
    }

    public List<StatementInfoBean> getStatementInfo() {
        return statementInfo;
    }

    public void setStatementInfo(List<StatementInfoBean> statementInfo) {
        this.statementInfo = statementInfo;
    }

    public static class ResponseBean {
        /**
         * resultCode : 0
         * resultMessage : 交易成功
         */

        private String resultCode;
        private String resultMessage;

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultMessage() {
            return resultMessage;
        }

        public void setResultMessage(String resultMessage) {
            this.resultMessage = resultMessage;
        }

        @Override
        public String toString() {
            return "ResponseBean{" +
                    "resultCode='" + resultCode + '\'' +
                    ", resultMessage='" + resultMessage + '\'' +
                    '}';
        }
    }

    public static class MerchantInfoBean {
        /**
         * cashierNo : 01
         * merchantNo : 95162011520P006
         */

        private String cashierNo;
        private String merchantNo;

        public String getCashierNo() {
            return cashierNo;
        }

        public void setCashierNo(String cashierNo) {
            this.cashierNo = cashierNo;
        }

        public String getMerchantNo() {
            return merchantNo;
        }

        public void setMerchantNo(String merchantNo) {
            this.merchantNo = merchantNo;
        }

        @Override
        public String toString() {
            return "MerchantInfoBean{" +
                    "cashierNo='" + cashierNo + '\'' +
                    ", merchantNo='" + merchantNo + '\'' +
                    '}';
        }
    }

    public static class TerminalInfoBean {
        /**
         * terminalNo : 2006A000
         * batchNo : 000003
         * traceNo : 000011
         */

        private String terminalNo;
        private String batchNo;
        private String traceNo;

        public String getTerminalNo() {
            return terminalNo;
        }

        public void setTerminalNo(String terminalNo) {
            this.terminalNo = terminalNo;
        }

        public String getBatchNo() {
            return batchNo;
        }

        public void setBatchNo(String batchNo) {
            this.batchNo = batchNo;
        }

        public String getTraceNo() {
            return traceNo;
        }

        public void setTraceNo(String traceNo) {
            this.traceNo = traceNo;
        }

        @Override
        public String toString() {
            return "TerminalInfoBean{" +
                    "terminalNo='" + terminalNo + '\'' +
                    ", batchNo='" + batchNo + '\'' +
                    ", traceNo='" + traceNo + '\'' +
                    '}';
        }
    }

    public static class StatementInfoBean {
        /**
         * sumActualAmount : 2
         * sumRefundAmount : 0
         * sumTransAmount : 2
         * totalCount : 2
         * transTypeId : 2225
         */

        private int sumActualAmount;
        private int sumRefundAmount;
        private int sumTransAmount;
        private int totalCount;
        private String transTypeId;

        public int getSumActualAmount() {
            return sumActualAmount;
        }

        public void setSumActualAmount(int sumActualAmount) {
            this.sumActualAmount = sumActualAmount;
        }

        public int getSumRefundAmount() {
            return sumRefundAmount;
        }

        public void setSumRefundAmount(int sumRefundAmount) {
            this.sumRefundAmount = sumRefundAmount;
        }

        public int getSumTransAmount() {
            return sumTransAmount;
        }

        public void setSumTransAmount(int sumTransAmount) {
            this.sumTransAmount = sumTransAmount;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public String getTransTypeId() {
            return transTypeId;
        }

        public void setTransTypeId(String transTypeId) {
            this.transTypeId = transTypeId;
        }

        @Override
        public String toString() {
            return "StatementInfoBean{" +
                    "sumActualAmount=" + sumActualAmount +
                    ", sumRefundAmount=" + sumRefundAmount +
                    ", sumTransAmount=" + sumTransAmount +
                    ", totalCount=" + totalCount +
                    ", transTypeId='" + transTypeId + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Test{" +
                "response=" + response +
                ", merchantInfo=" + merchantInfo +
                ", terminalInfo=" + terminalInfo +
                ", statementInfo=" + statementInfo +
                '}';
    }
}
