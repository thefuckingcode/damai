package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.analyze.GXAnalyze;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import java.math.BigDecimal;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class vn0 implements GXIExpression {
    @NotNull
    public static final b Companion = new b(null);
    @NotNull
    private static final GXAnalyze b;
    @NotNull
    private final Object a;

    /* compiled from: Taobao */
    public static final class a implements GXAnalyze.IComputeExtend {
        a() {
        }

        @Override // com.alibaba.gaiax.analyze.GXAnalyze.IComputeExtend
        public long computeFunctionExpression(@NotNull String str, @NotNull long[] jArr) {
            k21.i(str, "functionName");
            k21.i(jArr, "params");
            if (k21.d(str, "size") && jArr.length == 1) {
                return vn0.Companion.d(jArr);
            }
            if (!k21.d(str, "env") || jArr.length != 1) {
                return 0;
            }
            return vn0.Companion.c(jArr);
        }

        @Override // com.alibaba.gaiax.analyze.GXAnalyze.IComputeExtend
        public long computeValueExpression(@NotNull String str, @Nullable Object obj) {
            k21.i(str, "valuePath");
            if (k21.d(str, "$$")) {
                if (obj instanceof JSONArray) {
                    return GXAnalyze.Companion.createValueArray(obj);
                }
                if (obj instanceof JSONObject) {
                    return GXAnalyze.Companion.createValueMap(obj);
                }
            }
            if (!(obj instanceof JSONObject)) {
                return 0;
            }
            Object c = zo0.c((JSON) obj, str);
            if (c instanceof JSONArray) {
                return GXAnalyze.Companion.createValueArray(c);
            }
            if (c instanceof JSONObject) {
                return GXAnalyze.Companion.createValueMap(c);
            }
            if (c instanceof Boolean) {
                return GXAnalyze.Companion.createValueBool(((Boolean) c).booleanValue());
            }
            if (c instanceof String) {
                return GXAnalyze.Companion.createValueString((String) c);
            }
            if (c instanceof Integer) {
                return GXAnalyze.Companion.createValueLong((long) ((Number) c).intValue());
            }
            if (c instanceof Float) {
                return GXAnalyze.Companion.createValueFloat64(((Number) c).floatValue());
            }
            if (c instanceof Double) {
                return GXAnalyze.Companion.createValueFloat64((float) ((Number) c).doubleValue());
            }
            if (c instanceof BigDecimal) {
                return GXAnalyze.Companion.createValueFloat64(((BigDecimal) c).floatValue());
            }
            if (c instanceof Long) {
                return GXAnalyze.Companion.createValueLong(((Number) c).longValue());
            }
            if (c == null) {
                return GXAnalyze.Companion.createValueNull();
            }
            throw new IllegalArgumentException(k21.r("Not recognize value = ", c));
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final long c(long[] jArr) {
            GXAnalyze.Companion companion = GXAnalyze.Companion;
            br0 h = companion.h(jArr[0]);
            if (!(h instanceof tq0)) {
                return 0;
            }
            String b = ((tq0) h).b();
            if (o.w("isAndroid", b, true)) {
                return companion.createValueBool(true);
            }
            if (o.w("isiOS", b, true)) {
                return companion.createValueBool(false);
            }
            return 0;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final long d(long[] jArr) {
            GXAnalyze.Companion companion = GXAnalyze.Companion;
            br0 h = companion.h(jArr[0]);
            if (h instanceof tq0) {
                String b = ((tq0) h).b();
                if (b == null) {
                    return 0;
                }
                return companion.createValueFloat64((float) b.length());
            }
            JSONArray jSONArray = null;
            JSONObject jSONObject = null;
            if (h instanceof np0) {
                Object a = ((np0) h).a();
                if (a instanceof JSONObject) {
                    jSONObject = (JSONObject) a;
                }
                if (jSONObject == null) {
                    return 0;
                }
                return companion.createValueFloat64((float) jSONObject.size());
            } else if (!(h instanceof xn0)) {
                return companion.createValueFloat64(0.0f);
            } else {
                Object a2 = ((xn0) h).a();
                if (a2 instanceof JSONArray) {
                    jSONArray = (JSONArray) a2;
                }
                if (jSONArray == null) {
                    return 0;
                }
                return companion.createValueFloat64((float) jSONArray.size());
            }
        }
    }

    static {
        GXAnalyze gXAnalyze = new GXAnalyze();
        b = gXAnalyze;
        gXAnalyze.initComputeExtend(new a());
    }

    public vn0(@NotNull Object obj) {
        k21.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
        this.a = obj;
    }

    @Override // com.alibaba.gaiax.template.GXIExpression
    @NotNull
    public Object expression() {
        return this.a;
    }

    @Override // com.alibaba.gaiax.template.GXIExpression
    @Nullable
    public Object value(@Nullable JSON json) {
        return b.getResult(this.a, json);
    }
}
