package cn.wyf.httptest.view;

import android.os.Bundle;
import android.view.View;

import net.wyf.library.observe.ApiCallback;

import cn.wyf.httptest.R;
import cn.wyf.httptest.SpeekUtilOffline;
import cn.wyf.httptest.application.BaseActivity;
import cn.wyf.httptest.di.modules.RequestHelper;
import cn.wyf.httptest.util.MoneyUtil;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        findViewById(R.id.testButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                testHttp();
                testHttp2();
//                testSpeak();
            }
        });
    }

    private void testSpeak() {
        SpeekUtilOffline.getInstance().speek("支付宝交易成功" + MoneyUtil.toChinese("0.01"));
    }

    private void testHttp2(){
        addSubscription(RequestHelper.getInstance().requestTest(
                "http://39.98.84.149:8200/third-party-transaction/originalUndoData/selectCardBalance?sign=7d30744d482df0004ffea721cac96bd7ff9d57d6&requestTime=1600219935",
                "{\"track\":\"6100024106614751=000000101010000842\",\"stationCode\":\"4A5FC7CDEA20D5C85C65CEDAAFC3360B\"}"),
                new ApiCallback<String>() {
                    @Override
                    public void onHandleSuccess(String response) {

                    }

                    @Override
                    public void onHandleFailure(String msg) {

                    }

                    @Override
                    public void onHandleFinish() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }
                });
    }

    private void testHttp() {
        addSubscription(RequestHelper.getInstance().request("{\"timestamp\": \"2020-03-19 16:03:34\",\"router\": \"trade\",\"tradeId\": \"getPOSInfo\",\"deviceSN\": \"83733281\",\"msg\": \"eyJCcmFuY2hJZCI6IjMzMDAyIiwicGlkIjoiQVBPUyBBOCIsInBvc19zbiI6IjgzNzMzMjgxIiwicmFuZG9tc3RyIjoiZmM5OGRlZjNhNDJmZjE0ZjlmNDNmMDc4OTcwZjZiMDgiLCJ2aWQiOiIwMDAzIiwic2lnbiI6IjJkMDg1NDlhOGM1MmY5N2IzYTMxMTMyOTk2Y2NmYmQ4YzIxNzg3ZjAxMjcxZDE5YWIzOTcxMGZlYTA2Y2ZmODIwMTY0ZGZkN2M0MDZiYzYyYzRiZmVmYzRiMmYxYmEwN2UyNjBmYmUwMDBlODBjZjQwNTI5ODAyZmM4YTdlMTRmMjA5OTVmOTdkMDZhMWRhZTI2ZDczYzBiZDhkNjc1NjE4ZWRmMjc4N2FjNmFjNzQxZDRhNDhkZGIwYTg0NmY0MDg4NjI5ZDE2MjJlMmM4NjZlZjAwNGE4OGI5N2Q0YzhlZDAyZWFkYzJjZmI4NTM2ZjJiOWVkYjg3NTZlYWQzNDMifQ==\"}"),
                new ApiCallback<String>() {
                    @Override
                    public void onHandleSuccess(String response) {

                    }

                    @Override
                    public void onHandleFailure(String msg) {

                    }

                    @Override
                    public void onHandleFinish() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }
                });
    }

}
