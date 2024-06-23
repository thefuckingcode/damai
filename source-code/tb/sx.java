package tb;

import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
public class sx {
    public static final int FAILURE = 1;
    public static final int FINISH = 0;
    public static final int INTERRUPT = 2;
    private int a = 0;
    private JSONObject b = null;

    /* compiled from: Taobao */
    public static class a {
        public int a;
        public String b;

        public a(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public String toString() {
            return "DXAtomicEventError{errorCode=" + this.a + ", errorMsg='" + this.b + '\'' + '}';
        }
    }

    public static sx a(int i, String str) {
        sx sxVar = new sx();
        sxVar.a = 1;
        new a(i, str);
        return sxVar;
    }

    public static sx b(ox oxVar) {
        sx sxVar = new sx();
        sxVar.a = 1;
        new a(oxVar.a, oxVar.b);
        return sxVar;
    }

    public static sx c(JSONObject jSONObject) {
        sx sxVar = new sx();
        sxVar.a = 0;
        sxVar.b = jSONObject;
        return sxVar;
    }

    public static sx d(int i, String str) {
        sx sxVar = new sx();
        sxVar.a = 2;
        new a(i, str);
        return sxVar;
    }

    public static sx e(l lVar) {
        if (lVar == null) {
            return b(ox.EVENT_CHAIN_ERROR_ABILITY_EXEC_RESULT_IS_NULL);
        }
        if (!lVar.b()) {
            return c((JSONObject) ((o) lVar).a());
        }
        k kVar = (k) lVar;
        if (lVar.c()) {
            return d(((j) kVar.a()).a(), ((j) kVar.a()).b());
        }
        return a(((j) kVar.a()).a(), ((j) kVar.a()).b());
    }

    public JSONObject f() {
        return this.b;
    }

    public int g() {
        return this.a;
    }
}
