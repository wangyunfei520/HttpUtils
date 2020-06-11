package cn.wyf.httptest.di.modules;


import android.content.Context;

import net.wyf.library.request.Requester;
import net.wyf.library.utils.log.XLogger;


import cn.wyf.httptest.BuildConfig;
import cn.wyf.httptest.di.api.RequestApiService;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 网络请求管理类，基于Request对retrofit的二次封装
 */

public class RequestHelper {
    private volatile static RequestHelper instance = null;

    // private String url;

    private RequestHelper() {
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            synchronized (RequestHelper.class) {
                if (instance == null) instance = new RequestHelper();
            }
        }
        return instance;
    }

    private static RequestApiService requestAPI;

    /**
     * 初始化网络请求
     */
    public void init(Context context, boolean isDebug) {
        Requester.initBuilder(context, new String[]{"certificate/gsyh.crt"}, new String[]{"124.152.62.181", "posp.gsbankchina.com"}, isDebug);
//        Requester.initBuilder(context, null, null, isDebug);
        requestAPI = Requester.getRequestAPI(BuildConfig.hostUrl, RequestApiService.class);
    }

    public Observable<String> request(String data) {
        XLogger.printJson(data);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), data);
        return requestAPI.request(requestBody).map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                XLogger.printJson(s);
                return "";
            }
        });
    }

}
