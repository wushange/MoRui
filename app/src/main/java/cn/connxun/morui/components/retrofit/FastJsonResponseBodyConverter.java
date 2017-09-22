package cn.connxun.morui.components.retrofit;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by sll on 2016/3/31.
 */
public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

  private Type type;
  private Charset charset;

  public FastJsonResponseBodyConverter() {
  }

  public FastJsonResponseBodyConverter(Type type, Charset charset) {
    this.type = type;
    this.charset = charset;
  }

  @Override
  public T convert(ResponseBody value) throws IOException {
      try {
          String     body    = value.string();
          JSONObject json    = new JSONObject(body);
          boolean    success = json.optBoolean("success");
          String     msg     = json.optString("message", "");
          if (success) {
              if (json.has("data")) {
                  Object data = json.get("data");
                  return JSON.parseObject(data.toString(),type);
              } else {
                  throw new RuntimeException(msg);
              }
          } else {
              LogUtils.e("-" + msg);
              throw new RuntimeException(msg);
          }
      } catch (Exception e) {
          LogUtils.e(e.getMessage());
          throw new RuntimeException(e.getMessage());
      } finally {
          value.close();
      }

  }
}
