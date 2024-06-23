package tb;

import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Printer;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Objects;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
final class x91 implements Printer {
    private String a;
    private final ThreadLocal<String> b = new ThreadLocal<>();
    private final ThreadLocal<Integer> c = new ThreadLocal<>();
    private final k92 d = new k92();

    public x91() {
        init("PRETTYLOGGER");
    }

    private String a(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    private String b(String str) {
        if (bv0.c(str) || bv0.a(this.a, str)) {
            return this.a;
        }
        return this.a + "-" + str;
    }

    private int c() {
        Integer num = this.c.get();
        int c2 = this.d.c();
        if (num != null) {
            this.c.remove();
            c2 = num.intValue();
        }
        if (c2 >= 0) {
            return c2;
        }
        throw new IllegalStateException("methodCount cannot be negative");
    }

    private String f(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private int g(StackTraceElement[] stackTraceElementArr) {
        for (int i = 3; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!(className.equals(x91.class.getName()) || className.equals(r91.class.getName()))) {
                return i - 1;
            }
        }
        return -1;
    }

    private String h() {
        String str = this.b.get();
        if (str == null) {
            return this.a;
        }
        this.b.remove();
        return str;
    }

    private synchronized void j(int i, String str, Object... objArr) {
        if (this.d.b() != LogLevel.NONE) {
            String h = h();
            String a2 = a(str, objArr);
            int c2 = c();
            if (bv0.c(a2)) {
                a2 = "Empty/NULL log message";
            }
            p(i, h);
            o(i, h, c2);
            byte[] bytes = a2.getBytes();
            int length = bytes.length;
            if (length <= 4000) {
                if (c2 > 0) {
                    n(i, h);
                }
                m(i, h, a2);
                k(i, h);
                return;
            }
            if (c2 > 0) {
                n(i, h);
            }
            for (int i2 = 0; i2 < length; i2 += 4000) {
                m(i, h, new String(bytes, i2, Math.min(length - i2, 4000)));
            }
            k(i, h);
        }
    }

    private void k(int i, String str) {
        l(i, str, "╚════════════════════════════════════════════════════════════════════════════════════════");
    }

    private void l(int i, String str, String str2) {
        String b2 = b(str);
        if (i == 2) {
            this.d.a().v(b2, str2);
        } else if (i == 4) {
            this.d.a().i(b2, str2);
        } else if (i == 5) {
            this.d.a().w(b2, str2);
        } else if (i == 6) {
            this.d.a().e(b2, str2);
        } else if (i != 7) {
            this.d.a().d(b2, str2);
        } else {
            this.d.a().wtf(b2, str2);
        }
    }

    private void m(int i, String str, String str2) {
        String[] split = str2.split(System.getProperty("line.separator"));
        for (String str3 : split) {
            l(i, str, "║ " + str3);
        }
    }

    private void n(int i, String str) {
        l(i, str, "╟────────────────────────────────────────────────────────────────────────────────────────");
    }

    private void o(int i, String str, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.d.e()) {
            l(i, str, "║ Thread: " + Thread.currentThread().getName());
            n(i, str);
        }
        int g = g(stackTrace) + this.d.d();
        if (i2 + g > stackTrace.length) {
            i2 = (stackTrace.length - g) - 1;
        }
        String str2 = "";
        while (i2 > 0) {
            int i3 = i2 + g;
            if (i3 < stackTrace.length) {
                str2 = str2 + "   ";
                l(i, str, "║ " + str2 + f(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + " " + " (" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + jl1.BRACKET_END_STR);
            }
            i2--;
        }
    }

    private void p(int i, String str) {
        l(i, str, "╔════════════════════════════════════════════════════════════════════════════════════════");
    }

    @Override // com.orhanobut.logger.Printer
    public void clear() {
        this.d.f();
    }

    @Override // com.orhanobut.logger.Printer
    public void d(String str, Object... objArr) {
        j(3, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public void e(String str, Object... objArr) {
        e(null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public k92 getSettings() {
        return this.d;
    }

    @Override // com.orhanobut.logger.Printer
    public void i(String str, Object... objArr) {
        j(4, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public k92 init(String str) {
        Objects.requireNonNull(str, "tag may not be null");
        if (str.trim().length() != 0) {
            this.a = str;
            return this.d;
        }
        throw new IllegalStateException("tag may not be empty");
    }

    @Override // com.orhanobut.logger.Printer
    public void json(String str) {
        if (bv0.c(str)) {
            d("Empty/Null json content", new Object[0]);
            return;
        }
        try {
            String trim = str.trim();
            if (trim.startsWith(jl1.BLOCK_START_STR)) {
                d(new JSONObject(trim).toString(4), new Object[0]);
            } else if (trim.startsWith(jl1.ARRAY_START_STR)) {
                d(new JSONArray(trim).toString(4), new Object[0]);
            }
        } catch (JSONException e) {
            e(e.getCause().getMessage() + StringUtils.LF + str, new Object[0]);
        }
    }

    @Override // com.orhanobut.logger.Printer
    public Printer t(String str, int i) {
        if (str != null) {
            this.b.set(str);
        }
        this.c.set(Integer.valueOf(i));
        return this;
    }

    @Override // com.orhanobut.logger.Printer
    public void v(String str, Object... objArr) {
        j(2, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public void w(String str, Object... objArr) {
        j(5, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public void wtf(String str, Object... objArr) {
        j(7, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    public void xml(String str) {
        if (bv0.c(str)) {
            d("Empty/Null xml content", new Object[0]);
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", BQCCameraParam.VALUE_YES);
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            d(streamResult.getWriter().toString().replaceFirst(jl1.G, ">\n"), new Object[0]);
        } catch (TransformerException e) {
            e(e.getCause().getMessage() + StringUtils.LF + str, new Object[0]);
        }
    }

    @Override // com.orhanobut.logger.Printer
    public void e(Throwable th, String str, Object... objArr) {
        if (!(th == null || str == null)) {
            str = str + " : " + bv0.b(th);
        }
        if (th != null && str == null) {
            str = th.toString();
        }
        if (str == null) {
            str = "No message/exception is set";
        }
        j(6, str, objArr);
    }
}
