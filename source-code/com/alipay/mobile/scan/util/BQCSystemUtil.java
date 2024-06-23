package com.alipay.mobile.scan.util;

import com.alipay.mobile.bqcscanservice.MPaasLogger;
import java.lang.reflect.InvocationTargetException;
import tb.gl1;

/* compiled from: Taobao */
public class BQCSystemUtil {
    public static String reflectSystemProperties(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(null, str);
        } catch (IllegalAccessException unused) {
            MPaasLogger.e("reflectSystemProperties", new Object[]{"IllegalAccessException error"});
            return null;
        } catch (InvocationTargetException unused2) {
            MPaasLogger.e("reflectSystemProperties", new Object[]{"InvocationTargetException error"});
            return null;
        } catch (ClassNotFoundException unused3) {
            MPaasLogger.e("reflectSystemProperties", new Object[]{"ClassNotFoundException error"});
            return null;
        } catch (NoSuchMethodException unused4) {
            MPaasLogger.e("reflectSystemProperties", new Object[]{"NoSuchMethodException error"});
            return null;
        } catch (Exception e) {
            MPaasLogger.e("reflectSystemProperties", new Object[]{"error "}, e);
            return null;
        }
    }
}
