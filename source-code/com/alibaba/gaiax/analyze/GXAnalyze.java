package com.alibaba.gaiax.analyze;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bq0;
import tb.br0;
import tb.ep0;
import tb.io0;
import tb.k21;
import tb.lp0;
import tb.m40;
import tb.np0;
import tb.tq0;
import tb.xn0;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0001H J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001R\u001c\u0010\u0010\u001a\u00020\b8\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/alibaba/gaiax/analyze/GXAnalyze;", "", "Lcom/alibaba/fastjson/JSONObject;", DXTraceUtil.TYPE_EXPRESSION_STRING, "data", "getJsonResult", "self", "", "", "getResultNative", "Ltb/ur2;", "initNative", "Lcom/alibaba/gaiax/analyze/GXAnalyze$IComputeExtend;", "computeExtend", "initComputeExtend", "getResult", "pointer", "J", "getPointer", "()J", "Lcom/alibaba/gaiax/analyze/GXAnalyze$IComputeExtend;", "getComputeExtend", "()Lcom/alibaba/gaiax/analyze/GXAnalyze$IComputeExtend;", "setComputeExtend", "(Lcom/alibaba/gaiax/analyze/GXAnalyze$IComputeExtend;)V", "<init>", "()V", "Companion", "IComputeExtend", "GaiaX-Analyze"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXAnalyze {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int TYPE_ARRAY = 6;
    private static final int TYPE_BOOLEAN = 1;
    private static final int TYPE_EXCEPTION = 9;
    private static final int TYPE_FLOAT = 0;
    private static final int TYPE_LONG = 8;
    private static final int TYPE_MAP = 7;
    private static final int TYPE_NULL = 2;
    private static final int TYPE_OBJECT = 5;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VALUE = 3;
    @Nullable
    private IComputeExtend computeExtend;
    private final long pointer;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H J\u0013\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H J\u0013\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H J\u0011\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H J\u0011\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\nH J\u0011\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006H J\u0011\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH J\u0013\u0010\u0012\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H J\u0013\u0010\u0013\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H J\t\u0010\u0014\u001a\u00020\u0002H J\u0011\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H J\u0011\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H ¨\u0006\u001a"}, d2 = {"Lcom/alibaba/gaiax/analyze/GXAnalyze$Companion;", "", "", "value", "", "getValueTag", "", "getValueString", "", "getValueBoolean", "", "getValueFloat", "getValueArray", "getValueMap", "getValueLong", "createValueFloat64", "createValueString", "createValueBool", "createValueArray", "createValueMap", "createValueNull", "createValueLong", "Ltb/ur2;", "releaseGXValue", "<init>", "()V", "GaiaX-Analyze"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        public final int a() {
            return GXAnalyze.TYPE_ARRAY;
        }

        public final int b() {
            return GXAnalyze.TYPE_BOOLEAN;
        }

        public final int c() {
            return GXAnalyze.TYPE_FLOAT;
        }

        public final native long createValueArray(@Nullable Object obj);

        public final native long createValueBool(boolean z);

        public final native long createValueFloat64(float f);

        public final native long createValueLong(long j);

        public final native long createValueMap(@Nullable Object obj);

        public final native long createValueNull();

        public final native long createValueString(@NotNull String str);

        public final int d() {
            return GXAnalyze.TYPE_LONG;
        }

        public final int e() {
            return GXAnalyze.TYPE_MAP;
        }

        public final int f() {
            return GXAnalyze.TYPE_NULL;
        }

        public final int g() {
            return GXAnalyze.TYPE_STRING;
        }

        @Nullable
        public final native Object getValueArray(long j);

        public final native boolean getValueBoolean(long j);

        public final native float getValueFloat(long j);

        public final native long getValueLong(long j);

        @Nullable
        public final native Object getValueMap(long j);

        @NotNull
        public final native String getValueString(long j);

        public final native int getValueTag(long j);

        @Nullable
        public final br0 h(long j) {
            br0 br0;
            if (j != 0) {
                try {
                    int valueTag = getValueTag(j);
                    if (valueTag == f()) {
                        br0 = new bq0();
                    } else if (valueTag == g()) {
                        br0 = new tq0(getValueString(j));
                    } else if (valueTag == a()) {
                        br0 = new xn0(getValueArray(j));
                    } else if (valueTag == e()) {
                        br0 = new np0(getValueMap(j));
                    } else if (valueTag == b()) {
                        br0 = new io0(getValueBoolean(j));
                    } else if (valueTag == c()) {
                        br0 = new ep0(getValueFloat(j));
                    } else {
                        br0 = valueTag == d() ? new lp0(getValueLong(j)) : null;
                    }
                    releaseGXValue(j);
                    return br0;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                throw new IllegalStateException("Can't wrap null pointer as GXValue".toString());
            }
        }

        public final native void releaseGXValue(long j);
    }

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/analyze/GXAnalyze$IComputeExtend;", "", "", "valuePath", "source", "", "computeValueExpression", "functionName", "", "params", "computeFunctionExpression", "GaiaX-Analyze"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface IComputeExtend {
        long computeFunctionExpression(@NotNull String str, @NotNull long[] jArr);

        long computeValueExpression(@NotNull String str, @Nullable Object obj);
    }

    static {
        System.loadLibrary("GXAnalyzeAndroid");
    }

    public GXAnalyze() {
        initNative(this);
    }

    private final Object getJsonResult(JSONObject jSONObject, Object obj) {
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry entry : jSONObject.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                Object key = entry.getKey();
                k21.h(value, "value");
                jSONObject2.put(key, getResult(value, obj));
            } else if (value instanceof Integer) {
                jSONObject2.put(entry.getKey(), value);
            } else if (value instanceof Float) {
                jSONObject2.put(entry.getKey(), value);
            } else if (value instanceof Boolean) {
                jSONObject2.put(entry.getKey(), value);
            } else if (value instanceof JSONObject) {
                Object key2 = entry.getKey();
                k21.h(value, "value");
                jSONObject2.put(key2, getJsonResult((JSONObject) value, obj));
            }
        }
        return jSONObject2;
    }

    private final native long getResultNative(Object obj, String str, Object obj2);

    private final native void initNative(Object obj);

    @Nullable
    public final IComputeExtend getComputeExtend() {
        return this.computeExtend;
    }

    public final long getPointer() {
        return this.pointer;
    }

    @Nullable
    public final Object getResult(@NotNull Object obj, @Nullable Object obj2) {
        br0 h;
        k21.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
        if (obj instanceof String) {
            String str = (String) obj;
            if (k21.d(StringsKt__StringsKt.T0(str).toString(), "$$")) {
                return obj2;
            }
            if (!k21.d(StringsKt__StringsKt.T0(str).toString(), "") && (h = Companion.h(getResultNative(this, str, obj2))) != null) {
                return h.a();
            }
            return null;
        } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Boolean)) {
            return obj;
        } else {
            if (obj instanceof JSONObject) {
                return getJsonResult((JSONObject) obj, obj2);
            }
            return null;
        }
    }

    public final void initComputeExtend(@NotNull IComputeExtend iComputeExtend) {
        k21.i(iComputeExtend, "computeExtend");
        this.computeExtend = iComputeExtend;
    }

    public final void setComputeExtend(@Nullable IComputeExtend iComputeExtend) {
        this.computeExtend = iComputeExtend;
    }
}
