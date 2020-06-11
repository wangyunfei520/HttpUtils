package cn.wyf.httptest.di.bean;

public  class Response_206 {
    /**
     * chargeCode : 600043200402000118
     * queueNo : 1
     * floor :
     */

    private String chargeCode;
    private String queueNo;
    private String floor;

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getQueueNo() {
        return queueNo;
    }

    public void setQueueNo(String queueNo) {
        this.queueNo = queueNo;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Response_206{" +
                "chargeCode='" + chargeCode + '\'' +
                ", queueNo='" + queueNo + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
