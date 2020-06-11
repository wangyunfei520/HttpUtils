package cn.wyf.httptest.di.bean;

public class BaseBean {

    /**
     * minType : 1
     * tradeType : 206
     * inputParameter : {"patientId":"489142110918983225","officeId":"003","officeName":"特需专家（18F）","doctorId":"980","doctorName":"李进红","chargeItemId":"47143","childRegisterList":[],"registerPeriod":"1","totalCharge":"20","medicalInsuranceCharge":"0","payTypeComposes":[{"chargeTypeId":"120","charge":"20"}],"chargeCode":"","appointmentId":"","prescriptionInfo":[]}
     */

    private String minType = "1";
    private String tradeType;
    private String inputParameter;

    public String getMinType() {
        return minType;
    }

    public void setMinType(String minType) {
        this.minType = minType;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getInputParameter() {
        return inputParameter;
    }

    public void setInputParameter(String inputParameter) {
        this.inputParameter = inputParameter;
    }
}
