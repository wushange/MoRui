package cn.connxun.morui.api;

import com.blankj.utilcode.util.SPUtils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.json.JSONException;
import org.json.JSONObject;

import cn.connxun.morui.components.retrofit.MoRuiGsonConverterFactory;
import cn.connxun.morui.components.retrofit.RequestHelper;
import cn.connxun.morui.constants.Constants;
import cn.connxun.morui.entity.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;

/**
 * Created by wushange on 2017/7/11.
 */

public class AccountApi {
    public static final String BASE_URL = SPUtils.getInstance().getString(Constants.HOSTKEY,Constants.HOST) + "/api/user/";
    private AccountApiService mAccountService;
    private RequestHelper     helper;

    public AccountApi(RequestHelper helper, OkHttpClient.Builder mOkHttpClient) {
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
        mAccountService = retrofit.create(AccountApiService.class);
    }

    public Observable<User> getUserInfo() {
        return mAccountService.getUserInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public void updatePassword() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("oldPassword", "");
            jsonObject.put("newPassword_phone", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mAccountService.updatePassword(jsonObject);

    }
}
