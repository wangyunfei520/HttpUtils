package cn.wyf.httptest;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.wyf.httptest.util.SM4Utils;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("cn.wyf.httptest", appContext.getPackageName());
    }

    @Test
    public void sm4Util(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String  SysDate = dateFormat.format(now);
        Log.v("===",SysDate);
        String  Msg = "1000000000";
//    	Msg = "6HvOewA515dTXbuWwM6VQ+7mLjoGHZO435dxeeL8aTDDV0d79Z0EJltTbOwzoTft";
        Log.v("===","Msg(withoutDecod) = "+Msg);
//    	Msg = new String(ThreeDES.decrypt((new BASE64Decoder()).decodeBuffer(Msg)));
        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = SysDate+SysDate;

        Msg = sm4.encryptData_ECB(Msg);
        Log.v("===","Msg(withDecod) = "+Msg);
    }
}
