package cn.connxun.morui.components.retrofit;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.util.HashMap;
import java.util.Map;

import cn.connxun.morui.data.local.UserStorge;

/**
 * Created by gzsll on 2014/9/23 0023.
 */
public class RequestHelper {

    private Context mContext;

    private UserStorge userStorge ;
    public RequestHelper(Context mContext,UserStorge userStorge) {
        this.userStorge = userStorge;
        this.mContext = mContext;
    }

    public Map<String, String> getHttpRequestMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("client", getDeviceId());
        return map;
    }

    public String getAndroidId() {
        return Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public String getToken() {
        return userStorge.getUser().getToken();
    }

    public String getDeviceId() {
        String deviceId;
        TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm.getDeviceId() == null) {
            deviceId = getAndroidId();
        } else {
            deviceId = tm.getDeviceId();
        }
        return deviceId;
    }

}
