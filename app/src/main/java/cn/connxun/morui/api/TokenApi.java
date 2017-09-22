package cn.connxun.morui.api;

import com.blankj.utilcode.util.SPUtils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import cn.connxun.morui.components.retrofit.MoRuiGsonConverterFactory;
import cn.connxun.morui.constants.Constants;
import cn.connxun.morui.entity.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.http.Field;

/**
 * Created by wushange on 2017/8/14.
 */

public class TokenApi implements  TokenApiService{
    public static final String BASE_URL = SPUtils.getInstance().getString(Constants.HOSTKEY,Constants.HOST) + "/oauthToken/";
    private TokenApiService tokenApiService;

    public TokenApi(OkHttpClient mOkHttpClient) {
        Retrofit retrofit =
                new Retrofit.Builder()
                        .client(mOkHttpClient)
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(MoRuiGsonConverterFactory.create())
                        .build();
        tokenApiService = retrofit.create(TokenApiService.class);
    }


    @Override
    public Observable<User> getToken(@Field("userName") String userName, @Field("password") String password) {
        return tokenApiService.getToken(userName, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
