package cn.connxun.morui.api;

import com.blankj.utilcode.util.SPUtils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import cn.connxun.morui.components.retrofit.MoRuiGsonConverterFactory;
import cn.connxun.morui.components.retrofit.RequestHelper;
import cn.connxun.morui.constants.Constants;
import cn.connxun.morui.entity.InspectionRectification;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Query;

/**
 * Created by wushange on 2017/7/11.
 */

public class RectificationApi implements RectificationApiService {
    public static final String BASE_URL = SPUtils.getInstance().getString(Constants.HOSTKEY, Constants.HOST) + "/api/";
    private RectificationApiService service;
    private RequestHelper           helper;

    public RectificationApi(RequestHelper helper, OkHttpClient.Builder mOkHttpClient) {
        this.helper = helper;
        mOkHttpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .addHeader("accessToken", helper.getToken())
                    .build();
            return chain.proceed(request);
        });
        Retrofit retrofit =
                new Retrofit.Builder()
                        .client(mOkHttpClient.build())
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(MoRuiGsonConverterFactory.create())
                        .build();
        service = retrofit.create(RectificationApiService.class);
    }

    @Override
    public Observable<List<InspectionRectification>> getList() {
        return service.getList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<String>> getDetail(@Query("id") String id) {
        return service.getDetail(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Response<String>> changeTask(@Body Object o) {
        return service.changeTask(o).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
