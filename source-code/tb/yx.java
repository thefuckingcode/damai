package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.StageType;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXBuiltinProvider;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprDxMethodProxy;
import com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class yx {
    private static final Map<String, ey> b = new HashMap();
    private final ConcurrentHashMap<String, dy> a = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    public static class a {
        public final boolean a;
        public final String b;
        public final ey c;

        public a(boolean z, String str, ey eyVar) {
            this.a = z;
            this.b = str;
            this.c = eyVar;
        }

        public String toString() {
            return "EngineResult{success=" + this.a + ", errorMsg='" + this.b + '\'' + ", result=" + this.c + '}';
        }
    }

    static {
        d("parseInt", new lo1());
        d("parseFloat", new ko1());
        d("substring", new ng2());
        d("slice", new u7());
        d("length", new wv());
        qb1 qb1 = new qb1();
        e("Math", "abs", new qn0(qb1, "abs"));
        e("Math", "ceil", new qn0(qb1, "ceil"));
        e("Math", "exp", new qn0(qb1, "exp"));
        e("Math", "floor", new qn0(qb1, "floor"));
        e("Math", "max", new qn0(qb1, "max"));
        e("Math", "min", new qn0(qb1, "min"));
        e("Math", "round", new qn0(qb1, "round"));
        d31 d31 = new d31();
        e("JSON", StageType.PARSE, new qn0(d31, StageType.PARSE));
        e("JSON", "stringify", new qn0(d31, "stringify"));
        d("comboEventHandler", new zs());
    }

    public static ey c(String str) {
        return b.get(str);
    }

    public static void d(String str, IDXFunction iDXFunction) {
        b.put(str, ey.I(iDXFunction));
    }

    public static void e(String str, String str2, IDXFunction iDXFunction) {
        Map<String, ey> map = b;
        ey eyVar = map.get(str);
        if (eyVar == null) {
            eyVar = ey.G(new fy());
            map.put(str, eyVar);
        }
        if (eyVar.u()) {
            eyVar.j().b(str2, ey.I(iDXFunction));
            return;
        }
        throw new IllegalStateException("objectName is not a builtin obj");
    }

    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && this.a.containsKey(str);
    }

    public a b(String str, byte[] bArr, int i) {
        this.a.remove(str);
        dy dyVar = new dy();
        dyVar.o(this);
        try {
            dyVar.a(bArr, i);
            this.a.put(str, dyVar);
            return new a(true, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return new a(false, th.getMessage(), null);
        }
    }

    public a f(DXRuntimeContext dXRuntimeContext, lx lxVar, String str, int i, Object obj, Object obj2, Integer num, Map<String, ey> map, DXJSMethodProxy dXJSMethodProxy, DXExprDxMethodProxy dXExprDxMethodProxy, DXBuiltinProvider dXBuiltinProvider) {
        dy dyVar = this.a.get(str);
        if (dyVar == null) {
            return new a(false, "template engine not exist: " + str, null);
        }
        try {
            HashMap hashMap = new HashMap();
            if (obj != null && (obj instanceof JSONObject)) {
                hashMap.put("data", ey.M((JSONObject) obj));
            } else if (obj != null && dXRuntimeContext.supportDataProxy()) {
                hashMap.put("data", ey.K(obj));
            }
            if (obj2 != null && (obj2 instanceof JSONObject)) {
                hashMap.put("dataSource", ey.M((JSONObject) obj2));
            } else if (obj2 != null && dXRuntimeContext.supportDataProxy()) {
                hashMap.put("dataSource", ey.K(obj2));
            }
            if (dXRuntimeContext.getSubData() instanceof JSONObject) {
                hashMap.put(o70.SUBDATA_PREFIX, ey.M((JSONObject) dXRuntimeContext.getSubData()));
            } else if (dXRuntimeContext.getSubData() != null && dXRuntimeContext.supportDataProxy() && (dXRuntimeContext.getSubData() instanceof Object)) {
                hashMap.put(o70.SUBDATA_PREFIX, ey.K(dXRuntimeContext.getSubData()));
            }
            if (num != null) {
                hashMap.put("i", ey.J((long) num.intValue()));
            }
            if (map != null) {
                hashMap.putAll(map);
            }
            return new a(true, null, dyVar.m(dXRuntimeContext, lxVar, i, hashMap, dXJSMethodProxy, dXExprDxMethodProxy, dXBuiltinProvider));
        } catch (Throwable th) {
            vx.b(th);
            return new a(false, th.getMessage(), null);
        }
    }
}
