package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.qj2;

/* compiled from: Taobao */
public class er2 {
    private static Map<String, er2> f = new HashMap();
    private final qj2 a;
    private volatile List<String> b;
    private final LruCache<String, JSONObject> c = new LruCache<>(16);
    private final LruCache<String, de> d = new LruCache<>(4);
    private final Object e = new Object();

    private er2(Context context, String str) {
        String str2 = str + "_ultron_template_cache";
        this.a = new qj2.b().h(context.getApplicationContext()).i(str2 + ".db").l(str2).k(1).j(16777216).g();
    }

    public static er2 d(Context context, @NonNull String str) {
        er2 er2 = f.get(str);
        if (er2 == null) {
            synchronized (er2.class) {
                er2 = f.get(str);
                if (er2 == null) {
                    Map<String, er2> map = f;
                    er2 er22 = new er2(context, str);
                    map.put(str, er22);
                    er2 = er22;
                }
            }
        }
        return er2;
    }

    public void a(String str) {
        synchronized (this.e) {
            this.d.remove(str);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.e) {
                if (this.b != null) {
                    this.b.remove(str);
                }
                this.c.remove(str);
            }
            this.a.c(str);
        }
    }

    public de c(String str) {
        return this.d.get(str);
    }

    public JSONObject e(String str) {
        JSONObject jSONObject;
        byte[] d2;
        synchronized (this.e) {
            jSONObject = this.c.get(str);
        }
        if (!(jSONObject != null || (d2 = this.a.d(str)) == null || (jSONObject = JSON.parseObject(new String(d2, Charset.forName("UTF-8")))) == null)) {
            synchronized (this.e) {
                this.c.put(str, jSONObject);
            }
        }
        return jSONObject;
    }

    public List<String> f() {
        if (this.b == null) {
            List<String> f2 = this.a.f();
            synchronized (this.e) {
                if (this.b == null) {
                    this.b = f2;
                }
            }
        }
        return this.b == null ? Collections.emptyList() : this.b;
    }

    public void g(String str, de deVar) {
        if (!TextUtils.isEmpty(str) && deVar != null) {
            synchronized (this.e) {
                this.d.put(str, deVar);
            }
        }
    }

    public void h(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                synchronized (this.e) {
                    if (this.b != null && !this.b.contains(str)) {
                        this.b.add(str);
                    }
                    if (this.c.get(str) == null) {
                        this.c.put(str, jSONObject);
                    }
                }
                this.a.i(str, jSONObject.toJSONString().getBytes(Charset.forName("UTF-8")));
            } catch (Throwable th) {
                tr2.b("UltronTemplateManager", "saveTemplate", Log.getStackTraceString(th));
            }
        }
    }
}
