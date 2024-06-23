package tb;

import com.taobao.weex.utils.WXLogUtils;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
public class th1 {
    private static th1 c;
    private Object a;
    private ExecutorService b;

    private th1() {
        try {
            Method method = Class.forName("com.taobao.weex.devtools.inspector.network.GeneralEventReporter").getMethod("getInstance", new Class[0]);
            if (method != null) {
                this.a = method.invoke(null, new Object[0]);
                this.b = Executors.newSingleThreadExecutor();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static th1 d() {
        if (c == null) {
            synchronized (th1.class) {
                if (c == null) {
                    c = new th1();
                }
            }
        }
        return c;
    }

    public void a(String str, int i, int i2) {
        Class cls;
        Method b2;
        Object obj = this.a;
        if (obj != null && (b2 = iz1.b(obj.getClass(), "dataReceived", String.class, (cls = Integer.TYPE), cls)) != null) {
            iz1.c(this.a, b2, str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void b(String str, int i, int i2) {
        Class cls;
        Method b2;
        Object obj = this.a;
        if (obj != null && (b2 = iz1.b(obj.getClass(), "dataSent", String.class, (cls = Integer.TYPE), cls)) != null) {
            iz1.c(this.a, b2, str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void c(Runnable runnable) {
        ExecutorService executorService = this.b;
        if (executorService != null) {
            try {
                executorService.execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void e(String str, String str2) {
        Method b2;
        Object obj = this.a;
        if (obj != null && (b2 = iz1.b(obj.getClass(), "httpExchangeFailed", String.class, String.class)) != null) {
            iz1.c(this.a, b2, str, str2);
        }
    }

    public InputStream f(String str, String str2, String str3, InputStream inputStream, boolean z) {
        Method b2;
        Object obj = this.a;
        return (obj == null || (b2 = iz1.b(obj.getClass(), "interpretResponseStream", new Class[]{String.class, String.class, String.class, InputStream.class, Boolean.TYPE})) == null) ? inputStream : (InputStream) iz1.c(this.a, b2, str, str2, str3, inputStream, Boolean.valueOf(z));
    }

    public boolean g() {
        Object invoke;
        try {
            Class<?> a2 = iz1.a("com.taobao.weex.devtools.inspector.network.NetworkEventReporterImpl");
            if (a2 != null) {
                Method b2 = iz1.b(a2, gl1.TYPE_OPEN_URL_METHOD_GET, new Class[0]);
                Method b3 = iz1.b(a2, "isEnabled", new Class[0]);
                if (!(b2 == null || (invoke = b2.invoke(null, new Object[0])) == null || b3 == null)) {
                    boolean booleanValue = ((Boolean) iz1.c(invoke, b3, new Object[0])).booleanValue();
                    WXLogUtils.d("NetworkEventReporterProxy", "Is reporter enabled ? " + booleanValue);
                    return booleanValue;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public void h(j11 j11) {
        Method b2;
        Object obj = this.a;
        if (obj != null && (b2 = iz1.b(obj.getClass(), "requestWillBeSent", Map.class)) != null) {
            iz1.c(this.a, b2, j11.f());
        }
    }

    public void i(k11 k11) {
        Method b2;
        Object obj = this.a;
        if (obj != null && (b2 = iz1.b(obj.getClass(), "responseHeadersReceived", Map.class)) != null) {
            iz1.c(this.a, b2, k11.f());
        }
    }

    public void j(String str, String str2) {
        Method b2;
        Object obj = this.a;
        if (obj != null && (b2 = iz1.b(obj.getClass(), "responseReadFailed", String.class, String.class)) != null) {
            iz1.c(this.a, b2, str, str2);
        }
    }

    public void k(String str) {
        Method b2;
        Object obj = this.a;
        if (obj != null && (b2 = iz1.b(obj.getClass(), "responseReadFinished", String.class)) != null) {
            iz1.c(this.a, b2, str);
        }
    }
}
