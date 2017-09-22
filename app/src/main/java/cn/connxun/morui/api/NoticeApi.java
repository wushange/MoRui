package cn.connxun.morui.api;

import com.blankj.utilcode.util.SPUtils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import cn.connxun.morui.components.retrofit.MoRuiGsonConverterFactory;
import cn.connxun.morui.components.retrofit.RequestHelper;
import cn.connxun.morui.constants.Constants;
import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.Notice;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.http.Query;

/**
 * Created by wushange on 2017/8/14.
 */

public class NoticeApi implements  NoticeApiService {
    public static final String BASE_URL = SPUtils.getInstance().getString(Constants.HOSTKEY,Constants.HOST) + "/api/base/notice/";
    private NoticeApiService mNoticeApiService;
    private RequestHelper    helper;

    public NoticeApi(RequestHelper helper, OkHttpClient.Builder mOkHttpClient) {
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
        mNoticeApiService = retrofit.create(NoticeApiService.class);
    }

    @Override
    public Observable<ListBean<Notice>> getListByUser(@Query("page") String page, @Query("length") String length, @Query("type") String type) {
        return mNoticeApiService.getListByUser(page, length, type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
