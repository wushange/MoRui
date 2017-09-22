package cn.connxun.morui.api;

import cn.connxun.morui.entity.User;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wushange on 2017/8/14.
 */

public interface TokenApiService {
    @FormUrlEncoded
    @POST("getToken.do")
    Observable<User> getToken(@Field("userName") String userName,
                              @Field("password") String password);
}
