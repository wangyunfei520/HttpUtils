package cn.wyf.httptest.di.bean;

import java.util.List;

public class Request_206 {

    /**
     * patientId : 489142110918983225
     * officeId : 003
     * officeName : 特需专家（18F）
     * doctorId : 980
     * doctorName : 李进红
     * chargeItemId : 47143
     * childRegisterList : []
     * registerPeriod : 1
     * totalCharge : 20
     * medicalInsuranceCharge : 0
     * payTypeComposes : [{"chargeTypeId":"160","charge":"20"}]
     * chargeCode :
     * appointmentId :
     * prescriptionInfo : []
     */

    private String patientId;
    private String officeId;
    private String officeName;
    private String doctorId;
    private String doctorName;
    private String chargeItemId;
    private String registerPeriod;
    private String totalCharge;
    private String medicalInsuranceCharge;
    private String chargeCode;
    private String appointmentId;
    private List<?> childRegisterList;
    private List<PayTypeComposesBean> payTypeComposes;
    private List<?> prescriptionInfo;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(String chargeItemId) {
        this.chargeItemId = chargeItemId;
    }

    public String getRegisterPeriod() {
        return registerPeriod;
    }

    public void setRegisterPeriod(String registerPeriod) {
        this.registerPeriod = registerPeriod;
    }

    public String getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(String totalCharge) {
        this.totalCharge = totalCharge;
    }

    public String getMedicalInsuranceCharge() {
        return medicalInsuranceCharge;
    }

    public void setMedicalInsuranceCharge(String medicalInsuranceCharge) {
        this.medicalInsuranceCharge = medicalInsuranceCharge;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public List<?> getChildRegisterList() {
        return childRegisterList;
    }

    public void setChildRegisterList(List<?> childRegisterList) {
        this.childRegisterList = childRegisterList;
    }

    public List<PayTypeComposesBean> getPayTypeComposes() {
        return payTypeComposes;
    }

    public void setPayTypeComposes(List<PayTypeComposesBean> payTypeComposes) {
        this.payTypeComposes = payTypeComposes;
    }

    public List<?> getPrescriptionInfo() {
        return prescriptionInfo;
    }

    public void setPrescriptionInfo(List<?> prescriptionInfo) {
        this.prescriptionInfo = prescriptionInfo;
    }

    public static class PayTypeComposesBean {

        /**
         * chargeTypeId : 160
         * charge : 20
         */

        public PayTypeComposesBean() {
        }


        public PayTypeComposesBean(String chargeTypeId, String charge) {
            this.chargeTypeId = chargeTypeId;
            this.charge = charge;
        }

        private String chargeTypeId;
        private String charge;

        public String getChargeTypeId() {
            return chargeTypeId;
        }

        public void setChargeTypeId(String chargeTypeId) {
            this.chargeTypeId = chargeTypeId;
        }

        public String getCharge() {
            return charge;
        }

        public void setCharge(String charge) {
            this.charge = charge;
        }
    }
}
