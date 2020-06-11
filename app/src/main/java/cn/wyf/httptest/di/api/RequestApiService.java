package cn.wyf.httptest.di.api;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * user request interface
 */

public interface RequestApiService {

    @POST("pay_router/router")
    Observable<String> request(@Body RequestBody request);
}
