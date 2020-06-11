package cn.wyf.httptest.di.bean;

public class BaseResponse<T> {

    /**
     * result : {"chargeCode":"600043200402000118","queueNo":"1","floor":""}
     * errorNo : 0
     * errorMsg : null
     */

    private T result;
    private int errorNo;
    private Object errorMsg;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "result=" + result +
                ", errorNo=" + errorNo +
                ", errorMsg=" + errorMsg +
                '}';
    }
}
