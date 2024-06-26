package tb;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.ta.audid.Constants;
import com.ut.device.UTDevice;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Taobao */
public class yq2 extends vq2 {
    private static yq2 d;
    private int a = 0;
    private Random b = null;
    private Map<String, b> c = null;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private int a;
        private Map<String, Integer> b;

        private b() {
            this.a = 0;
            this.b = new HashMap();
        }

        private boolean d(int i, int i2) {
            return i != 0 && i2 < i;
        }

        public boolean c(String str, int i) {
            if (str != null) {
                try {
                    Iterator<String> it = this.b.keySet().iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next.startsWith("%") && next.endsWith("%")) {
                            next = next.substring(1, next.length() - 1);
                        }
                        if (str.equals(next)) {
                            return d(this.b.get(next).intValue(), i);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            return d(this.a, i);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c {
        private boolean a;
        private boolean b;

        private c() {
            this.a = false;
            this.b = false;
        }

        public boolean a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }

        public void c(boolean z) {
            this.b = z;
        }

        public void d(boolean z) {
            this.a = z;
        }
    }

    private yq2() {
        String utdid = UTDevice.getUtdid(Variables.n().j());
        if (utdid == null || utdid.equals(Constants.UTDID_INVALID)) {
            this.a = 0;
        } else {
            this.a = Math.abs(zf2.d(utdid)) % 10000;
        }
        Logger.f("UTSampleConfBiz", "deviceSample", Integer.valueOf(this.a));
        this.b = new Random();
        this.c = new HashMap();
    }

    public static yq2 d() {
        if (d == null) {
            d = new yq2();
        }
        return d;
    }

    private c e(int i, String str, int i2) {
        String valueOf = String.valueOf(i);
        c cVar = new c();
        if (this.c.containsKey(valueOf)) {
            cVar.c(true);
            cVar.d(this.c.get(valueOf).c(str, i2));
            return cVar;
        }
        cVar.d(false);
        return cVar;
    }

    private static b h(String str) {
        try {
            b bVar = new b();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("cp")) {
                bVar.a = jSONObject.optInt("cp");
            }
            if (jSONObject.has("arg1")) {
                HashMap hashMap = new HashMap();
                JSONObject optJSONObject = jSONObject.optJSONObject("arg1");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, Integer.valueOf(Integer.parseInt(optJSONObject.optString(next))));
                    }
                }
                bVar.b = hashMap;
            }
            return bVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // tb.vq2
    public String[] a() {
        return new String[]{"ut_sample"};
    }

    @Override // tb.vq2
    public void b(String str) {
        super.b(str);
    }

    @Override // tb.vq2
    public synchronized void c(String str, Map<String, String> map) {
        b h;
        this.c.clear();
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            if (!(str3 == null || (h = h(str3)) == null)) {
                this.c.put(str2, h);
            }
        }
    }

    public synchronized boolean f(int i, String str) {
        int i2;
        if (Variables.n().m()) {
            return true;
        }
        if (this.c.size() == 0) {
            return true;
        }
        if (i == 19998 || i == 19997) {
            i2 = this.a;
        } else {
            i2 = this.b.nextInt(10000);
        }
        c e = e(i, str, i2);
        if (e.a()) {
            return true;
        }
        if (e.b()) {
            return false;
        }
        c e2 = e(i - (i % 10), str, i2);
        if (e2.a()) {
            return true;
        }
        if (e2.b()) {
            return false;
        }
        c e3 = e(i - (i % 100), str, i2);
        if (e3.a()) {
            return true;
        }
        if (e3.b()) {
            return false;
        }
        c e4 = e(i - (i % 1000), str, i2);
        if (e4.a()) {
            return true;
        }
        if (e4.b()) {
            return false;
        }
        c e5 = e(-1, str, i2);
        if (e5.a()) {
            return true;
        }
        return e5.b() ? false : false;
    }

    public synchronized boolean g(Map<String, String> map) {
        try {
        } catch (Exception e) {
            Logger.h("UTSampleConfBiz", e, new Object[0]);
            return false;
        }
        return f(Integer.parseInt(map.get(LogField.EVENTID.toString())), map.get(LogField.ARG1.toString()));
    }
}
