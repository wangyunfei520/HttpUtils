package cn.wyf.httptest.di.modules;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cn.wyf.httptest.di.bean.BaseBean;
import cn.wyf.httptest.di.bean.BaseResponse;
import cn.wyf.httptest.di.bean.Request_206;
import cn.wyf.httptest.di.bean.Response_206;
import cn.wyf.httptest.di.bean.Trade;


public class RequestHelperTest {

    @Test
    public void TestJiexi(){
        long payAmount = 100;
        String amount = String.format("%012d", payAmount);
        System.out.println(amount);
//        String test = "{\"statementInfo\":[{\"sumActualAmount\":2,\"sumRefundAmount\":0,\"sumTransAmount\":2,\"totalCount\":2,\"transTypeId\":\"2225\"}],\"response\":{\"resultCode\":\"0\",\"resultMessage\":\"交易成功\"},\"merchantInfo\":{\"cashierNo\":\"01\",\"merchantNo\":\"95162011520P006\"},\"terminalInfo\":{\"terminalNo\":\"2006A000\",\"batchNo\":\"000003\",\"traceNo\":\"000011\"}}";
//        TestObjct objct = new Gson().fromJson(test, TestObjct.class);
//        System.out.println(objct);
    }

    @Test
    public void jiexi() {
        JsonObject object = new JsonObject();
        object.addProperty("minType","1");
        object.addProperty("tradeType", "212");
        object.addProperty("inputParameter", "{\"receptionIds\":\"492002899191328876\",\"patientId\":\"489142110918983225\",\"chargeCode\":null,\"payTypeComposes\":[{\"chargeTypeId\":\"160\",\"charge\":\"15\"},{\"chargeTypeId\":\"160\",\"charge\":\"400\"}]," +
                "\"chargeList\":[{\"chargeItemTypeName\":\"诊疗费\",\"unitName\":null,\"unitNum\":null,\"minUnitNum\":null,\"minUnitName\":null,\"medicalInsuranceNum\":null,\"disPlayNum\":\"1人次\",\"dosageForm\":null,\"dosage\":null,\"frequency\":null,\"usage\":null,\"medicineDose\":null,\"medicineDosageNum\":null,\"doseUnitName\":null,\"chargeChildId\":\"492002899191328883\",\"receptionId\":\"492002899191328876\",\"chargeId\":\"0\",\"patientId\":\"489142110918983225\",\"patientName\":\"联迪自助机\",\"chargeItemType\":\"0\",\"chargeObjId\":\"492002899191328882\",\"hospitalId\":\"73\",\"chargeTypeId\":\"644\",\"chargeItemId\":\"42299\",\"itemCode\":\"S0040\",\"itemName\":\"面神经功能电脑检测\",\"itemCharge\":\"15\",\"itemUnitPrice\":\"15\",\"itemUnitName\":\"人次\",\"itemNum\":\"1\",\"discountRate\":\"1\",\"discountType\":\"29\",\"discountCode\":\"29\",\"discountCharge\":\"15\",\"selfChargeUp\":\"15\",\"medicalInsuranceType\":\"0\",\"chargeStatus\":\"0\",\"source\":\"1\",\"storehouseId\":null,\"doctorId\":\"359847664042564111\",\"doctorName\":\"欧凤芳\",\"officeId\":\"275\",\"officeName\":\"口腔儿科\",\"operatorId\":\"1523\",\"chargeCommitTime\":\"1586416700198\",\"createTime\":\"1585878551951\",\"isDiscount\":\"True\",\"isDiscounted\":null,\"medicareTypeName\":\"丙\",\"medicareType\":\"3\",\"minItemType\":\"2\",\"minPrescriptionNo\":\"492002899191328882\",\"minPrescriptionSubNo\":\"492002899191328883\",\"isOut\":\"False\",\"itemStandardPrice\":\"15\",\"childExchanges\":null},{\"chargeItemTypeName\":\"诊疗费\",\"unitName\":null,\"unitNum\":null,\"minUnitNum\":null,\"minUnitName\":null,\"medicalInsuranceNum\":null,\"disPlayNum\":\"1每副\",\"dosageForm\":null,\"dosage\":null,\"frequency\":null,\"usage\":null,\"medicineDose\":null,\"medicineDosageNum\":null,\"doseUnitName\":null,\"chargeChildId\":\"492002899191328884\",\"receptionId\":\"492002899191328876\",\"chargeId\":\"0\",\"patientId\":\"489142110918983225\",\"patientName\":\"联迪自助机\",\"chargeItemType\":\"0\",\"chargeObjId\":\"492002899191328882\",\"hospitalId\":\"73\",\"chargeTypeId\":\"717\",\"chargeItemId\":\"44351\",\"itemCode\":\"T0003\",\"itemName\":\"精功改良式哈氏保持器\",\"itemCharge\":\"400\",\"itemUnitPrice\":\"400\",\"itemUnitName\":\"每副\",\"itemNum\":\"1\",\"discountRate\":\"1\",\"discountType\":\"29\",\"discountCode\":\"29\",\"discountCharge\":\"400\",\"selfChargeUp\":\"400\",\"medicalInsuranceType\":\"0\",\"chargeStatus\":\"0\",\"source\":\"1\",\"storehouseId\":null,\"doctorId\":\"359847664042564111\",\"doctorName\":\"欧凤芳\",\"officeId\":\"275\",\"officeName\":\"口腔儿科\",\"operatorId\":\"1523\",\"chargeCommitTime\":\"1586416700198\",\"createTime\":\"1585878551984\",\"isDiscount\":\"False\",\"isDiscounted\":null,\"medicareTypeName\":\"丙\",\"medicareType\":\"3\",\"minItemType\":\"2\",\"minPrescriptionNo\":\"492002899191328882\",\"minPrescriptionSubNo\":\"492002899191328884\",\"isOut\":\"False\",\"itemStandardPrice\":\"400\",\"childExchanges\":null}]," +
                "\"prescriptionInfo\":null}");

        System.out.println(object.toString());

        String test = "{\"result\":{\"officetRegisterInfo\":[{\"officeType\":\"1\",\"officeCode\":\"002\",\"officeId\":\"205\",\"officeName\":\"正畸中心1\",\"spell\":\"zjzx1\",\"minAge\":\"39\",\"maxAge\":\"39\",\"registerChargeItemIds\":[],\"doctors\":[{\"officeId\":\"205\",\"doctorId\":\"589\",\"doctorCode\":\"080\",\"doctorName\":\"范丰燕\",\"spell\":\"ffy\",\"isStopTreatAM\":null,\"isStopTreatPM\":\"False\",\"registerChargeItemIdAM\":null,\"registerChargeItemIdPM\":\"47135\"}]},{\"officeType\":\"1\",\"officeCode\":\"003\",\"officeId\":\"267\",\"officeName\":\"特需专家（18F）\",\"spell\":\"txzj18f\",\"minAge\":\"0\",\"maxAge\":\"99\",\"registerChargeItemIds\":[\"47143\"],\"doctors\":[{\"officeId\":\"267\",\"doctorId\":\"7179\",\"doctorCode\":\"9876\",\"doctorName\":\"黄统\",\"spell\":\"ht\",\"isStopTreatAM\":null,\"isStopTreatPM\":\"False\",\"registerChargeItemIdAM\":null,\"registerChargeItemIdPM\":\"47175\"},{\"officeId\":\"267\",\"doctorId\":\"980\",\"doctorCode\":\"202\",\"doctorName\":\"李进红\",\"spell\":\"ljh\",\"isStopTreatAM\":\"False\",\"isStopTreatPM\":\"False\",\"registerChargeItemIdAM\":null,\"registerChargeItemIdPM\":\"47143\"}]},{\"officeType\":\"1\",\"officeCode\":\"005\",\"officeId\":\"269\",\"officeName\":\"洁牙美牙中心\",\"spell\":\"jymyzx\",\"minAge\":null,\"maxAge\":null,\"registerChargeItemIds\":[],\"doctors\":[{\"officeId\":\"269\",\"doctorId\":\"1500\",\"doctorCode\":\"6104\",\"doctorName\":\"唐艳\",\"spell\":\"ty\",\"isStopTreatAM\":null,\"isStopTreatPM\":\"False\",\"registerChargeItemIdAM\":null,\"registerChargeItemIdPM\":\"47175\"},{\"officeId\":\"269\",\"doctorId\":\"587\",\"doctorCode\":\"9991\",\"doctorName\":\"杭州口腔医院有限公司\",\"spell\":\"hzkqyyyxgs\",\"isStopTreatAM\":null,\"isStopTreatPM\":\"False\",\"registerChargeItemIdAM\":null,\"registerChargeItemIdPM\":\"47175\"}]},{\"officeType\":\"1\",\"officeCode\":\"007\",\"officeId\":\"271\",\"officeName\":\"口腔外科\",\"spell\":\"kqwk\",\"minAge\":\"0\",\"maxAge\":\"69\",\"registerChargeItemIds\":[\"47175\"],\"doctors\":[{\"officeId\":\"271\",\"doctorId\":\"587\",\"doctorCode\":\"9991\",\"doctorName\":\"杭州口腔医院有限公司\",\"spell\":\"hzkqyyyxgs\",\"isStopTreatAM\":\"False\",\"isStopTreatPM\":\"False\",\"registerChargeItemIdAM\":null,\"registerChargeItemIdPM\":\"47139\"},{\"officeId\":\"271\",\"doctorId\":\"1025\",\"doctorCode\":\"576\",\"doctorName\":\"唐燕\",\"spell\":\"ty\",\"isStopTreatAM\":\"False\",\"isStopTreatPM\":\"False\",\"registerChargeItemIdAM\":null,\"registerChargeItemIdPM\":\"47143\"}]},{\"officeType\":\"1\",\"officeCode\":\"008\",\"officeId\":\"272\",\"officeName\":\"口腔综合二科\",\"spell\":\"kqzhek\",\"minAge\":\"10\",\"maxAge\":\"50\",\"registerChargeItemIds\":[],\"doctors\":[{\"officeId\":\"272\",\"doctorId\":\"1456\",\"doctorCode\":\"\",\"doctorName\":\"陆昉舟\",\"spell\":\"lfz\",\"isStopTreatAM\":null,\"isStopTreatPM\":\"False\",\"registerChargeItemIdAM\":null,\"registerChargeItemIdPM\":\"47175\"},{\"officeId\":\"272\",\"doctorId\":\"1093\",\"doctorCode\":\"446\",\"doctorName\":\"倪娜\",\"spell\":\"nn\",\"isStopTreatAM\":\"False\",\"isStopTreatPM\":\"False\",\"registerChargeItemIdAM\":null,\"registerChargeItemIdPM\":\"47175\"}]},{\"officeType\":\"1\",\"officeCode\":\"010\",\"officeId\":\"274\",\"officeName\":\"口腔修复科\",\"spell\":\"kqxfk\",\"minAge\":null,\"maxAge\":null,\"registerChargeItemIds\":[\"47143\"],\"doctors\":[]},{\"officeType\":\"1\",\"officeCode\":\"011\",\"officeId\":\"275\",\"officeName\":\"口腔儿科\",\"spell\":\"kqek\",\"minAge\":null,\"maxAge\":null,\"registerChargeItemIds\":[],\"doctors\":[{\"officeId\":\"275\",\"doctorId\":\"359847664042564111\",\"doctorCode\":\"5214\",\"doctorName\":\"欧凤芳\",\"spell\":\"off\",\"isStopTreatAM\":\"False\",\"isStopTreatPM\":\"False\",\"registerChargeItemIdAM\":null,\"registerChargeItemIdPM\":\"47031\"}]},{\"officeType\":\"1\",\"officeCode\":\"015\",\"officeId\":\"277\",\"officeName\":\"综合科\",\"spell\":\"zhk\",\"minAge\":null,\"maxAge\":null,\"registerChargeItemIds\":[],\"doctors\":[{\"officeId\":\"277\",\"doctorId\":\"1093\",\"doctorCode\":\"446\",\"doctorName\":\"倪娜\",\"spell\":\"nn\",\"isStopTreatAM\":\"False\",\"isStopTreatPM\":\"False\",\"registerChargeItemIdAM\":null,\"registerChargeItemIdPM\":\"47143\"}]}],\"registerChargeItems\":[{\"chargeItemId\":\"47143\",\"itemName\":\"特需门诊（18F）初诊\",\"itemCode\":\"1818\",\"itemUnit\":\"人次\",\"unitPrice\":\"20\",\"totalPrice\":\"20\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"otherChargeItemIds\":[]},{\"chargeItemId\":\"47139\",\"itemName\":\"特需门诊（17F）复诊\",\"itemCode\":\"2425\",\"itemUnit\":\"人次\",\"unitPrice\":\"0.01\",\"totalPrice\":\"0.01\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"otherChargeItemIds\":[]},{\"chargeItemId\":\"47031\",\"itemName\":\"儿科双休日节假日诊疗费加收\",\"itemCode\":\"S0280\",\"itemUnit\":\"每次\",\"unitPrice\":\"30\",\"totalPrice\":\"20\",\"treatmentFee\":\"-10\",\"treatmentFeeChargeItemId\":\"320936703160386111\",\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"otherChargeItemIds\":[\"320936703160386111\"]},{\"chargeItemId\":\"47175\",\"itemName\":\"普通号\",\"itemCode\":\"pth\",\"itemUnit\":\"人次\",\"unitPrice\":\"1\",\"totalPrice\":\"1\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":\"08:00\",\"endTime\":\"23:59\",\"otherChargeItemIds\":[]},{\"chargeItemId\":\"47135\",\"itemName\":\"特需门诊（17F）初诊\",\"itemCode\":\"2424\",\"itemUnit\":\"人次\",\"unitPrice\":\"5\",\"totalPrice\":\"5\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"otherChargeItemIds\":[]},{\"chargeItemId\":\"92302\",\"itemName\":\"新的挂号费\",\"itemCode\":\"1\",\"itemUnit\":\"人次\",\"unitPrice\":\"0.01\",\"totalPrice\":\"0.01\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"otherChargeItemIds\":[]},{\"chargeItemId\":\"315561159770142950\",\"itemName\":\"MINI假日增收\",\"itemCode\":\"TESTmini\",\"itemUnit\":\"次\",\"unitPrice\":\"2.67\",\"totalPrice\":\"3.69\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":\"00:00\",\"endTime\":\"23:00\",\"otherChargeItemIds\":[\"33987\",\"57238704690983332\"]},{\"chargeItemId\":\"35762\",\"itemName\":\"挂号费（正畸特需）\",\"itemCode\":\"GHFFZJTX\",\"itemUnit\":\"人次\",\"unitPrice\":\"20\",\"totalPrice\":\"20\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":null,\"endTime\":null,\"otherChargeItemIds\":[]},{\"chargeItemId\":\"47147\",\"itemName\":\"特需门诊（18F）复诊\",\"itemCode\":\"1819\",\"itemUnit\":\"人次\",\"unitPrice\":\"15\",\"totalPrice\":\"17.02\",\"treatmentFee\":\"2\",\"treatmentFeeChargeItemId\":\"316225092852021718\",\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"otherChargeItemIds\":[\"57238704690983332\",\"316225092852021718\"]},{\"chargeItemId\":\"47131\",\"itemName\":\"特需专家复诊\",\"itemCode\":\"2526\",\"itemUnit\":\"人次\",\"unitPrice\":\"15\",\"totalPrice\":\"15\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":null,\"endTime\":null,\"otherChargeItemIds\":[]},{\"chargeItemId\":\"47127\",\"itemName\":\"特需专家初诊\",\"itemCode\":\"2525\",\"itemUnit\":\"人次\",\"unitPrice\":\"20\",\"totalPrice\":\"22\",\"treatmentFee\":\"2\",\"treatmentFeeChargeItemId\":\"316225092852021718\",\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"otherChargeItemIds\":[\"316225092852021718\"]},{\"chargeItemId\":\"41559\",\"itemName\":\"种植维护\",\"itemCode\":\"zzwh\",\"itemUnit\":\"人次\",\"unitPrice\":\"1\",\"totalPrice\":\"1\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":null,\"endTime\":null,\"otherChargeItemIds\":[]},{\"chargeItemId\":\"34375\",\"itemName\":\"免号\",\"itemCode\":\"322\",\"itemUnit\":\"人次\",\"unitPrice\":\"0\",\"totalPrice\":\"0\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":\"00:00\",\"endTime\":\"23:59\",\"otherChargeItemIds\":[]},{\"chargeItemId\":\"365289553680073076\",\"itemName\":\"新的诊疗费\",\"itemCode\":\"302\",\"itemUnit\":\"人次\",\"unitPrice\":\"1\",\"totalPrice\":\"1\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":null,\"endTime\":null,\"otherChargeItemIds\":null},{\"chargeItemId\":\"33987\",\"itemName\":\"诊疗费\",\"itemCode\":\"zlf\",\"itemUnit\":\"人次\",\"unitPrice\":\"1\",\"totalPrice\":\"1\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":null,\"endTime\":null,\"otherChargeItemIds\":null},{\"chargeItemId\":\"57238704690983332\",\"itemName\":\"磁卡费\",\"itemCode\":\"ckf\",\"itemUnit\":\"人次\",\"unitPrice\":\"0.02\",\"totalPrice\":\"0.02\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":null,\"endTime\":null,\"otherChargeItemIds\":null},{\"chargeItemId\":\"386607151663220892\",\"itemName\":\"可打折shirley\",\"itemCode\":\"TEST001\",\"itemUnit\":\"1.0g\",\"unitPrice\":\"780\",\"totalPrice\":\"780\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":null,\"endTime\":null,\"otherChargeItemIds\":null},{\"chargeItemId\":\"316225092852021718\",\"itemName\":\"20151205收费\",\"itemCode\":\"20181205\",\"itemUnit\":\"每人次\",\"unitPrice\":\"2\",\"totalPrice\":\"2\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":null,\"endTime\":null,\"otherChargeItemIds\":null},{\"chargeItemId\":\"320936703160386111\",\"itemName\":\"1218诊疗费\",\"itemCode\":\"20181218001\",\"itemUnit\":\"0.25ｇ\",\"unitPrice\":\"-10\",\"totalPrice\":\"-10\",\"treatmentFee\":null,\"treatmentFeeChargeItemId\":null,\"startTime\":null,\"endTime\":null,\"otherChargeItemIds\":null}],\"appointment\":null},\"errorNo\":0,\"errorMsg\":null}";
        Trade trade = new Gson().fromJson(test, Trade.class);
        System.out.println(trade);
        System.out.println(trade.getErrorNo());
        List<Trade.ResultBean.OfficetRegisterInfoBean> of = trade.getResult().getOfficetRegisterInfo();
        System.out.println("=========科室数============ " + of.size());
        for (Trade.ResultBean.OfficetRegisterInfoBean be :of) {
            System.out.println(be);
        }
        System.out.println("=====================");
        List<Trade.ResultBean.RegisterChargeItemsBean> list = trade.getResult().getRegisterChargeItems();
        System.out.println("=========收费项目数============ " + list.size());
        for (Trade.ResultBean.RegisterChargeItemsBean be :list) {
            System.out.println(be);
        }
        System.out.println("=====================");
    }

    @Test
    public void trade206(){
        Gson gson = new Gson();
        Request_206 request_206 = new Request_206();
        request_206.setAppointmentId("");
        request_206.setDoctorId("980");
        request_206.setDoctorName("李进红");
        request_206.setChargeCode("");
        request_206.setPatientId("489142110918983225");
        request_206.setOfficeId("003");
        request_206.setOfficeName("特需专家（18F）");
        request_206.setChargeItemId("47143");
        request_206.setRegisterPeriod("1");
        request_206.setTotalCharge("20");
        request_206.setMedicalInsuranceCharge("0");
        List<Request_206.PayTypeComposesBean> list = new ArrayList<>();
        list.add(new Request_206.PayTypeComposesBean("160","20"));
        request_206.setPayTypeComposes(list);
        request_206.setPrescriptionInfo(new ArrayList<>());
        request_206.setChildRegisterList(new ArrayList<>());
        String in = gson.toJson(request_206);
        System.out.println(in);
        BaseBean baseBean = new BaseBean();
        baseBean.setInputParameter(in);
        baseBean.setTradeType("206");
        System.out.println(gson.toJson(baseBean));
        System.out.println("====================================");
        String response = "{\"result\":{\"chargeCode\":\"600043200402000118\",\"queueNo\":\"1\",\"floor\":\"\"},\"errorNo\":0,\"errorMsg\":null}";
        System.out.println(response);
        BaseResponse<Response_206> baseResponse206 = gson.fromJson(response, BaseResponse.class);
        System.out.println(baseResponse206);
        System.out.println("返回码：" + baseResponse206.getErrorNo());
        if (baseResponse206.getErrorNo() == 0){
            System.out.println(baseResponse206.getResult());
        }else {
            System.out.println(baseResponse206.getErrorMsg());
        }
    }
}