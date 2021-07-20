package cn.wyf.httptest.di.api;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * user request interface
 */

public interface RequestApiService {

    @POST("pay_router/router")
    Observable<String> request(@Body RequestBody request);

    @POST()
    Observable<String> requesttest(@Url String url, @Body RequestBody request);
}
