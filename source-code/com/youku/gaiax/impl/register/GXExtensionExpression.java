package com.youku.gaiax.impl.register;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.analyze.GXAnalyze;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.impl.GaiaXExpression;
import com.youku.gaiax.impl.GaiaXProxy;
import java.math.BigDecimal;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.br0;
import tb.k21;
import tb.m40;
import tb.np0;
import tb.tq0;
import tb.xn0;
import tb.zo0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionExpression;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionExpression;", "", "value", "Lcom/alibaba/gaiax/template/GXIExpression;", "create", "", "isTrue", "", "expVersion", "<init>", "()V", "Companion", "GXAnalyzeWrapper", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXExtensionExpression implements GXRegisterCenter.GXIExtensionExpression {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<GXExtensionExpression> instance$delegate = b.b(GXExtensionExpression$Companion$instance$2.INSTANCE);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionExpression$Companion;", "", "Lcom/youku/gaiax/impl/register/GXExtensionExpression;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/impl/register/GXExtensionExpression;", "instance", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final GXExtensionExpression getInstance() {
            return (GXExtensionExpression) GXExtensionExpression.instance$delegate.getValue();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionExpression$GXAnalyzeWrapper;", "Lcom/alibaba/gaiax/template/GXIExpression;", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "Lcom/alibaba/fastjson/JSON;", "templateData", "value", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GXAnalyzeWrapper implements GXIExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private static final GXAnalyze analyze;
        @NotNull
        private final Object expression;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionExpression$GXAnalyzeWrapper$Companion;", "", "value", "", "createByAny", "Lcom/alibaba/gaiax/analyze/GXAnalyze;", "analyze", "Lcom/alibaba/gaiax/analyze/GXAnalyze;", "getAnalyze", "()Lcom/alibaba/gaiax/analyze/GXAnalyze;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final long createByAny(Object obj) {
                if (obj instanceof JSONArray) {
                    return GXAnalyze.Companion.createValueArray(obj);
                }
                if (obj instanceof JSONObject) {
                    return GXAnalyze.Companion.createValueMap(obj);
                }
                if (obj instanceof Boolean) {
                    return GXAnalyze.Companion.createValueBool(((Boolean) obj).booleanValue());
                }
                if (obj instanceof String) {
                    return GXAnalyze.Companion.createValueString((String) obj);
                }
                if (obj instanceof Integer) {
                    return GXAnalyze.Companion.createValueFloat64((float) ((Number) obj).intValue());
                }
                if (obj instanceof Float) {
                    return GXAnalyze.Companion.createValueFloat64(((Number) obj).floatValue());
                }
                if (obj instanceof Double) {
                    return GXAnalyze.Companion.createValueFloat64((float) ((Number) obj).doubleValue());
                }
                if (obj instanceof BigDecimal) {
                    return GXAnalyze.Companion.createValueFloat64(((BigDecimal) obj).floatValue());
                }
                if (obj == null) {
                    return GXAnalyze.Companion.createValueNull();
                }
                throw new IllegalArgumentException(k21.r("Not recognize value = ", obj));
            }

            @NotNull
            public final GXAnalyze getAnalyze() {
                return GXAnalyzeWrapper.analyze;
            }
        }

        static {
            GXAnalyze gXAnalyze = new GXAnalyze();
            analyze = gXAnalyze;
            gXAnalyze.initComputeExtend(new GXAnalyze.IComputeExtend() {
                /* class com.youku.gaiax.impl.register.GXExtensionExpression.GXAnalyzeWrapper.Companion.AnonymousClass1 */

                @Override // com.alibaba.gaiax.analyze.GXAnalyze.IComputeExtend
                public long computeFunctionExpression(@NotNull String str, @NotNull long[] jArr) {
                    String b;
                    IProxyFeatures features;
                    Object envExpressionResult;
                    k21.i(str, "functionName");
                    k21.i(jArr, "params");
                    if (k21.d(str, "size") && jArr.length == 1) {
                        GXAnalyze.Companion companion = GXAnalyze.Companion;
                        br0 h = companion.h(jArr[0]);
                        if (h instanceof tq0) {
                            String b2 = ((tq0) h).b();
                            if (b2 == null) {
                                return 0;
                            }
                            return companion.createValueFloat64((float) b2.length());
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
                            return 0;
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
                    } else if (!k21.d(str, "env") || jArr.length != 1) {
                        return 0;
                    } else {
                        br0 h2 = GXAnalyze.Companion.h(jArr[0]);
                        if (!(h2 instanceof tq0) || (b = ((tq0) h2).b()) == null || (features = GaiaXProxy.Companion.getInstance().getFeatures()) == null || (envExpressionResult = features.getEnvExpressionResult(b)) == null) {
                            return 0;
                        }
                        return GXAnalyzeWrapper.Companion.createByAny(envExpressionResult);
                    }
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
                    if (obj instanceof JSONObject) {
                        return GXAnalyzeWrapper.Companion.createByAny(zo0.c((JSON) obj, str));
                    }
                    return 0;
                }
            });
        }

        public GXAnalyzeWrapper(@NotNull Object obj) {
            k21.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
            this.expression = obj;
        }

        @Override // com.alibaba.gaiax.template.GXIExpression
        @NotNull
        public Object expression() {
            return this.expression;
        }

        @Override // com.alibaba.gaiax.template.GXIExpression
        @Nullable
        public Object value(@Nullable JSON json) {
            return analyze.getResult(this.expression, json);
        }
    }

    @NotNull
    public final GXIExpression create(@NotNull Object obj) {
        k21.i(obj, "value");
        return create(null, obj);
    }

    public final boolean isTrue(@Nullable Object obj) {
        return isTrue(null, obj);
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionExpression
    @NotNull
    public GXIExpression create(@Nullable String str, @NotNull Object obj) {
        k21.i(obj, "value");
        if (k21.d(str, "V2")) {
            return new GXAnalyzeWrapper(obj);
        }
        return GaiaXExpression.Companion.create(obj);
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionExpression
    public boolean isTrue(@Nullable String str, @Nullable Object obj) {
        if (k21.d(str, "V2")) {
            return k21.d(Boolean.TRUE, obj);
        }
        return GaiaXExpression.Companion.isCondition(obj);
    }
}
