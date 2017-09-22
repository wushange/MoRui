package cn.connxun.morui.api;

import org.json.JSONObject;

import cn.connxun.morui.entity.User;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by wushange on 2017/7/11.
 */

public interface AccountApiService {
    /**
     * 获取当前用户信息
     *
     * @return
     */
    @GET("userInfo.do")
    Observable<User> getUserInfo();

    /**
     * 修改密码
     *
     * @return
     */
    @FormUrlEncoded
    @POST("updatePassword")
    Observable<Object> updatePassword(
                                @Body JSONObject jsonObject);
}
