package net.wyf.library.request;

import android.content.Context;

import net.wyf.library.utils.HttpsFactroy;
import net.wyf.library.utils.NetworkUtils;
import net.wyf.library.utils.Utils;
import net.wyf.library.utils.log.XLogger;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 网络请求类
 */

public class Requester {
    private static final int CONNECT_TIMEOUT = 10;  //请求超时时间，单位：s
    private static final int READ_TIMEOUT = 40;       //读写超时时间，单位：s

    private static OkHttpClient.Builder builder;

    /**
     * 初始化OkHttpClient.Builder()
     */
    public static void initBuilder(Context context, String[] certificates, String[] hosts, boolean isDebug) {
        builder = new OkHttpClient.Builder();
        if (isDebug) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }

        //配置缓存选项
        File cacheFile = new File(Utils.getContext().getCacheDir(), "responses");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);// 50 MiB
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetworkUtils.isConnected(Utils.getContext())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (NetworkUtils.isConnected(Utils.getContext())) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
        Interceptor retry = new Interceptor() {
            public int maxRetry = 3;//最大重试次数
            private int retryNum = 0;//假如设置为3次重试的话，则最大可能请求4次（默认1次+3次重试）

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                XLogger.v("Retry num:" + retryNum);
                while (!response.isSuccessful() && retryNum < maxRetry) {
                    retryNum++;
                    XLogger.v("Retry num:" + retryNum);
                    response = chain.proceed(request);
                }
                return response;
            }
        };
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.addInterceptor(retry);
//        SSLSocketFactory sslSocketFactory = HttpsFactroy.getSSLSocketFactory(context, certificates);
//        if (sslSocketFactory != null) {
//            builder.sslSocketFactory(sslSocketFactory);
//
//        }
        if (certificates != null && certificates.length > 0) {
            //证书验证
            try {
                XLogger.v("有加载证书");
                TrustManager[] trustManagers = HttpsFactroy.getTrustManager(context, certificates);
                X509TrustManager trustManager = (X509TrustManager) trustManagers[0];
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
                builder.sslSocketFactory(sslContext.getSocketFactory(), trustManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (hosts != null && hosts.length > 0) {
            XLogger.v("有域名验证");
            builder.hostnameVerifier(HttpsFactroy.getHostnameVerifier(hosts));
        } else {
            XLogger.v("没有域名验证");
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        }
        builder.cache(cache);
        //设置文件下载监听
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                return originalResponse
                        .newBuilder()
                        .body(new FileResponseBody(originalResponse))
                        .build();
            }
        });
        //设置超时
        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
//        builder.writeTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
    }

    /**
     * 构造retrofit请求api
     *
     * @param host    host地址
     * @param service retrofit请求api
     * @param <T>     retrofit请求api
     * @return retrofit请求api
     */
    public static <T> T getRequestAPI(String host, Class<T> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())//此converter放在最后，因为不确定返回的数据是否为json
                .build();
        return retrofit.create(service);
    }
}
