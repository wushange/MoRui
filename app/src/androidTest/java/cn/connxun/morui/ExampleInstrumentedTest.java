package cn.connxun.morui;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <HttpManager href="http://d.android.com/tools/testing">Testing documentation</HttpManager>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("cn.connxun.morui", appContext.getPackageName());
    }

    @Test
    public void str2json(){
        Gson   gson = new Gson();
        String jj   = gson.toJson("上传成功");
    }
}
