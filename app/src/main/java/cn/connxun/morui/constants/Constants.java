package cn.connxun.morui.constants;

import com.blankj.utilcode.util.SDCardUtils;

import java.io.File;

/**
 * Created by wushange on 2017/7/12.
 */

public class Constants {
    public static String HOSTKEY      = "host_key";
    public static String HOSTKEY_POS      = "HOSTKEY_POS";
    public static String SERVER_IP    = "123.131.86.170";
    public static String SERVER_PORT  = "8013";
    public static String SERVER_IP_LOCAL    = "192.168.3.240";
    public static String SERVER_PORT_LOCAL  = "8012";
    public static String HOST         = "http://" + SERVER_IP + ":" + SERVER_PORT + "/moris";//服务器地址
    
    
    public static String BUGLY_APPID  = "1f2ab5caa7";//buglyid
    public static String DCS_KEY      = "http://dcsapi.com/?k=181712547&url=";//永中云转换
    public static int    ROLE_MANAGER = 4;//管理人员
    public static int    ROLE_WORKER  = 3;//巡检员

    public static String USER_NAME = "USER_NAME";
    public static String USER_PWD  = "USER_PWD";
    public static String USER_ID   = "USER_ID";


    public static final String ROOT_PATH = SDCardUtils.getSDCardPath() + "MoRui" + File.separator;

}
