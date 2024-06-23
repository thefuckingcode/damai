package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.loc.e1;
import com.loc.l1;
import com.loc.m1;
import com.loc.p1;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class w53 {
    private static w53 h;
    private static long i;
    private LinkedHashMap<String, Long> a = new LinkedHashMap<>();
    private File b;
    private String c = null;
    private Context d;
    private boolean e;
    String f = "";
    String g = null;

    private w53(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        String path = applicationContext.getFilesDir().getPath();
        if (this.c == null) {
            this.c = m1.e0(this.d);
        }
        try {
            this.b = new File(path, "reportRecorder");
        } catch (Throwable th) {
            y43.a(th);
        }
        f();
    }

    public static synchronized w53 a(Context context) {
        w53 w53;
        synchronized (w53.class) {
            if (h == null) {
                h = new w53(context);
            }
            w53 = h;
        }
        return w53;
    }

    private boolean e(Context context) {
        if (this.g == null) {
            this.g = x53.e(context, "pref", "lastavedate", "0");
        }
        if (this.g.equals(this.f)) {
            return false;
        }
        SharedPreferences.Editor c2 = x53.c(context, "pref");
        x53.j(c2, "lastavedate", this.f);
        x53.f(c2);
        this.g = this.f;
        return true;
    }

    private synchronized void f() {
        LinkedHashMap<String, Long> linkedHashMap = this.a;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            try {
                this.f = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
                for (String str : m1.l(this.b)) {
                    try {
                        String[] split = new String(e1.h(p1.g(str), this.c), "UTF-8").split(",");
                        if (split != null && split.length > 1) {
                            this.a.put(split[0], Long.valueOf(Long.parseLong(split[1])));
                        }
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void g() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Long> entry : this.a.entrySet()) {
                try {
                    String str = entry.getKey() + "," + entry.getValue();
                    sb.append(p1.f(e1.e(str.getBytes("UTF-8"), this.c)) + StringUtils.LF);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                m1.m(this.b, sb2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void b() {
        if (this.e) {
            g();
            this.e = false;
        }
    }

    public final synchronized void c(AMapLocation aMapLocation) {
        try {
            if ((!this.a.containsKey(this.f) && this.a.size() >= 8) || (this.a.containsKey(this.f) && this.a.size() >= 9)) {
                ArrayList<String> arrayList = new ArrayList();
                for (Map.Entry<String, Long> entry : this.a.entrySet()) {
                    try {
                        arrayList.add(entry.getKey());
                        if (arrayList.size() == this.a.size() - 7) {
                            break;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                for (String str : arrayList) {
                    this.a.remove(str);
                }
            }
            if (aMapLocation.getErrorCode() == 0) {
                if (!(aMapLocation.getLocationType() == 6 || aMapLocation.getLocationType() == 5)) {
                    if (this.a.containsKey(this.f)) {
                        long longValue = this.a.get(this.f).longValue() + 1;
                        i = longValue;
                        this.a.put(this.f, Long.valueOf(longValue));
                    } else {
                        this.a.put(this.f, 1L);
                        i = 1;
                    }
                    long j = i;
                    if (j != 0 && j % 100 == 0) {
                        b();
                    }
                    this.e = true;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final synchronized void d() {
        try {
            if (e(this.d)) {
                for (Map.Entry<String, Long> entry : this.a.entrySet()) {
                    try {
                        if (!this.f.equals(entry.getKey())) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("param_long_first", entry.getKey());
                            jSONObject.put("param_long_second", entry.getValue());
                            l1.n(this.d, "O023", jSONObject);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
