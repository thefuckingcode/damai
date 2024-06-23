package com.youku.gaiax.impl;

import com.ali.user.mobile.app.constant.UTConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.d;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.by0;
import tb.jl1;
import tb.k21;
import tb.m40;
import tb.o70;
import tb.zo0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0014\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eB\t\b\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&\u0001\u0013\u001f !\"#$%&'()*+,-./01¨\u00062"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/gaiax/template/GXIExpression;", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "Lcom/alibaba/fastjson/JSON;", "templateData", "value", "rawJson", "desireData", "<init>", "()V", "Companion", "GBool", "GEnv", "GEval", "GFloat", "GInt", "GJsonArrayObj", "GJsonObj", "GNull", "GScroll", "GSize", "GString", "GTernaryValue1", "GTernaryValue2", "GTernaryValue3", "GText", "GTextValue", "GValue", "Self", "Undefined", "Lcom/youku/gaiax/impl/GaiaXExpression$Undefined;", "Lcom/youku/gaiax/impl/GaiaXExpression$Self;", "Lcom/youku/gaiax/impl/GaiaXExpression$GEval;", "Lcom/youku/gaiax/impl/GaiaXExpression$GEnv;", "Lcom/youku/gaiax/impl/GaiaXExpression$GScroll;", "Lcom/youku/gaiax/impl/GaiaXExpression$GSize;", "Lcom/youku/gaiax/impl/GaiaXExpression$GJsonObj;", "Lcom/youku/gaiax/impl/GaiaXExpression$GJsonArrayObj;", "Lcom/youku/gaiax/impl/GaiaXExpression$GBool;", "Lcom/youku/gaiax/impl/GaiaXExpression$GString;", "Lcom/youku/gaiax/impl/GaiaXExpression$GFloat;", "Lcom/youku/gaiax/impl/GaiaXExpression$GInt;", "Lcom/youku/gaiax/impl/GaiaXExpression$GNull;", "Lcom/youku/gaiax/impl/GaiaXExpression$GText;", "Lcom/youku/gaiax/impl/GaiaXExpression$GValue;", "Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue1;", "Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue2;", "Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue3;", "Lcom/youku/gaiax/impl/GaiaXExpression$GTextValue;", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public abstract class GaiaXExpression implements GXIExpression {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final Pattern valueFullRegex = Pattern.compile("^\\$\\{(.*?)\\}$");
    private static final Pattern valueRegex = Pattern.compile("\\$\\{(.*?)\\}");

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0001R'\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0006@\u0006¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0006@\u0006¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$Companion;", "", "", "condition", "", "isFitContentCondition", "isCondition", DXTraceUtil.TYPE_EXPRESSION_STRING, "Lcom/youku/gaiax/impl/GaiaXExpression;", "create", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "valueFullRegex", "Ljava/util/regex/Pattern;", "getValueFullRegex", "()Ljava/util/regex/Pattern;", "getValueFullRegex$annotations", "()V", "valueRegex", "getValueRegex", "getValueRegex$annotations", "<init>", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        public static /* synthetic */ void getValueFullRegex$annotations() {
        }

        public static /* synthetic */ void getValueRegex$annotations() {
        }

        @NotNull
        public final GaiaXExpression create(@NotNull Object obj) {
            GaiaXExpression gFloat;
            k21.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
            if (obj instanceof JSON) {
                GJsonObj.Companion companion = GJsonObj.Companion;
                if (companion.isExpression(obj)) {
                    return companion.create((JSONObject) obj);
                }
                GJsonArrayObj.Companion companion2 = GJsonArrayObj.Companion;
                if (companion2.isExpression(obj)) {
                    return companion2.create((JSONArray) obj);
                }
                return Undefined.INSTANCE;
            } else if (obj instanceof String) {
                String obj2 = StringsKt__StringsKt.T0((String) obj).toString();
                Self self = Self.INSTANCE;
                if (self.isExpression(obj2)) {
                    return self;
                }
                GNull.Companion companion3 = GNull.Companion;
                if (companion3.isExpression(obj2)) {
                    return companion3.create();
                }
                GBool.Companion companion4 = GBool.Companion;
                if (companion4.isExpression(obj2)) {
                    return companion4.create(obj2);
                }
                GInt.Companion companion5 = GInt.Companion;
                if (companion5.isExpression(obj2)) {
                    return companion5.create(obj2);
                }
                GFloat.Companion companion6 = GFloat.Companion;
                if (companion6.isExpression(obj2)) {
                    return companion6.create(obj2);
                }
                GString.Companion companion7 = GString.Companion;
                if (companion7.isExpression(obj2)) {
                    return companion7.create(obj2);
                }
                GEval.Companion companion8 = GEval.Companion;
                if (companion8.isExpression(obj2)) {
                    return companion8.create(obj2);
                }
                GEnv.Companion companion9 = GEnv.Companion;
                if (companion9.isExpression(obj2)) {
                    return companion9.create(obj2);
                }
                GScroll.Companion companion10 = GScroll.Companion;
                if (companion10.isExpression(obj2)) {
                    return companion10.create(obj2);
                }
                GSize.Companion companion11 = GSize.Companion;
                if (companion11.isExpression(obj2)) {
                    return companion11.create(obj2);
                }
                GTextValue.Companion companion12 = GTextValue.Companion;
                if (companion12.isExpression(obj2)) {
                    return companion12.create(obj2);
                }
                GValue.Companion companion13 = GValue.Companion;
                if (companion13.isExpression(obj2)) {
                    return companion13.create(obj2);
                }
                GTernaryValue3.Companion companion14 = GTernaryValue3.Companion;
                if (companion14.isExpression(obj2)) {
                    return companion14.create(obj2);
                }
                GTernaryValue1.Companion companion15 = GTernaryValue1.Companion;
                if (companion15.isExpression(obj2)) {
                    return companion15.create(obj2);
                }
                GTernaryValue2.Companion companion16 = GTernaryValue2.Companion;
                if (companion16.isExpression(obj2)) {
                    return companion16.create(obj2);
                }
                GText.Companion companion17 = GText.Companion;
                if (companion17.isExpression(obj2)) {
                    return companion17.create(obj2);
                }
                if (k21.d(obj, StringUtils.LF)) {
                    return companion17.create(StringUtils.LF);
                }
                return Undefined.INSTANCE;
            } else {
                if (obj instanceof Boolean) {
                    gFloat = new GBool(((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    gFloat = new GInt(((Number) obj).intValue());
                } else if (!(obj instanceof Float)) {
                    return Undefined.INSTANCE;
                } else {
                    gFloat = new GFloat(((Number) obj).floatValue());
                }
                return gFloat;
            }
        }

        public final Pattern getValueFullRegex() {
            return GaiaXExpression.valueFullRegex;
        }

        public final Pattern getValueRegex() {
            return GaiaXExpression.valueRegex;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
            if ((((java.lang.Number) r5).floatValue() == 0.0f) == false) goto L_0x000e;
         */
        public final boolean isCondition(@Nullable Object obj) {
            boolean z;
            if (!(obj instanceof Boolean) || !k21.d(obj, Boolean.TRUE)) {
                if (obj instanceof Number) {
                }
                if (k21.d(obj, "0") || k21.d(obj, "false") || k21.d(obj, Boolean.FALSE) || k21.d(obj, 0) || k21.d(obj, Float.valueOf(0.0f))) {
                    return false;
                }
                return k21.d(obj, "1") || k21.d(obj, "true") || (((z = obj instanceof String)) && (o.y((CharSequence) obj) ^ true)) || ((!z || !(o.y((CharSequence) obj))) && obj != null);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0032 A[RETURN, SYNTHETIC] */
        public final boolean isFitContentCondition(@NotNull String str) {
            String str2;
            k21.i(str, "condition");
            switch (str.hashCode()) {
                case 48:
                    str2 = "0";
                    str.equals(str2);
                    return false;
                case 49:
                    return str.equals("1");
                case 47602:
                    str2 = "0.0";
                    str.equals(str2);
                    return false;
                case 48563:
                    if (!str.equals("1.0")) {
                        return false;
                    }
                    break;
                case 3569038:
                    if (!str.equals("true")) {
                        return false;
                    }
                    break;
                case 97196323:
                    str2 = "false";
                    str.equals(str2);
                    return false;
                default:
                    return false;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GBool;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "", "component1", "value", by0.ARG_COPY, "", "hashCode", "other", "equals", "Z", "getValue", "()Z", "<init>", "(Z)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GBool extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        private final boolean value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GBool$Companion;", "", "", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GBool;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GBool create(@NotNull String str) {
                k21.i(str, "value");
                return new GBool(Boolean.parseBoolean(str));
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return k21.d(str, "true") || k21.d(str, "false");
            }
        }

        public GBool(boolean z) {
            super(null);
            this.value = z;
        }

        public static /* synthetic */ GBool copy$default(GBool gBool, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = gBool.value;
            }
            return gBool.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        @NotNull
        public final GBool copy(boolean z) {
            return new GBool(z);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return Boolean.valueOf(this.value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GBool) && this.value == ((GBool) obj).value;
        }

        public final boolean getValue() {
            return this.value;
        }

        public int hashCode() {
            boolean z = this.value;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "GBool(value=" + this.value + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\t\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GEnv;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "value", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GEnv extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GEnv$Companion;", "", "", "value", "", "isExpression", "Lcom/youku/gaiax/impl/GaiaXExpression$GEnv;", "create", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GEnv create(@NotNull String str) {
                k21.i(str, "value");
                String substring = str.substring(4, str.length() - 1);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return new GEnv(substring);
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, "value");
                return (o.L(str, "env(", false, 2, null)) && (o.v(str, jl1.BRACKET_END_STR, false, 2, null));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GEnv(@NotNull String str) {
            super(null);
            k21.i(str, "value");
            this.value = str;
        }

        public static /* synthetic */ GEnv copy$default(GEnv gEnv, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gEnv.value;
            }
            return gEnv.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        @NotNull
        public final GEnv copy(@NotNull String str) {
            k21.i(str, "value");
            return new GEnv(str);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
            if (features == null) {
                return null;
            }
            return features.getEnvExpressionResult(this.value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GEnv) && k21.d(this.value, ((GEnv) obj).value);
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GEnv(value='" + this.value + "')";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\b&\u0010'J\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\t\u0010\u0013\u001a\u00020\u0011HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0001HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0001HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0017\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0018\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b%\u0010$¨\u0006)"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GEval;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "", "left", "right", "mod", "doubleOr", "doubleAnd", "lessThan", "lessThanOrEqual", "greaterThanOrEqual", "greaterThan", "notEqual", "equal", "Lcom/alibaba/fastjson/JSON;", "rawJson", "desireData", "", "toString", "component1", "component2", "component3", "operate", "leftValue", "rightValue", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getOperate", "()Ljava/lang/String;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "getLeftValue", "()Lcom/youku/gaiax/impl/GaiaXExpression;", "getRightValue", "<init>", "(Ljava/lang/String;Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GEval extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final GaiaXExpression leftValue;
        @NotNull
        private final String operate;
        @NotNull
        private final GaiaXExpression rightValue;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GEval$Companion;", "", "", "operate", "realValue", "Lcom/youku/gaiax/impl/GaiaXExpression$GEval;", "createEval", "value", "", "isExpression", "create", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            private final GEval createEval(String str, String str2) {
                List list = StringsKt__StringsKt.z0(str2, new String[]{str}, false, 0, 6, null);
                if (list.size() != 2) {
                    return null;
                }
                Companion companion = GaiaXExpression.Companion;
                return new GEval(str, companion.create((String) list.get(0)), companion.create((String) list.get(1)));
            }

            @NotNull
            public final GEval create(@NotNull String str) {
                k21.i(str, "value");
                String substring = str.substring(5, str.length() - 1);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                GEval createEval = createEval(jl1.EQUAL2, substring);
                if (createEval != null || (createEval = createEval(jl1.GE, substring)) != null || (createEval = createEval(jl1.G, substring)) != null || (createEval = createEval(jl1.LE, substring)) != null || (createEval = createEval(jl1.L, substring)) != null || (createEval = createEval(jl1.NOT_EQUAL2, substring)) != null || (createEval = createEval(jl1.OR, substring)) != null || (createEval = createEval(jl1.AND, substring)) != null) {
                    return createEval;
                }
                GEval createEval2 = createEval("%", substring);
                if (createEval2 != null) {
                    return createEval2;
                }
                Undefined undefined = Undefined.INSTANCE;
                return new GEval("", undefined, undefined);
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, "value");
                return (o.L(str, "eval(", false, 2, null)) && (o.v(str, jl1.BRACKET_END_STR, false, 2, null));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GEval(@NotNull String str, @NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2) {
            super(null);
            k21.i(str, "operate");
            k21.i(gaiaXExpression, "leftValue");
            k21.i(gaiaXExpression2, "rightValue");
            this.operate = str;
            this.leftValue = gaiaXExpression;
            this.rightValue = gaiaXExpression2;
        }

        public static /* synthetic */ GEval copy$default(GEval gEval, String str, GaiaXExpression gaiaXExpression, GaiaXExpression gaiaXExpression2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gEval.operate;
            }
            if ((i & 2) != 0) {
                gaiaXExpression = gEval.leftValue;
            }
            if ((i & 4) != 0) {
                gaiaXExpression2 = gEval.rightValue;
            }
            return gEval.copy(str, gaiaXExpression, gaiaXExpression2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
            if (((java.lang.Boolean) r7).booleanValue() != false) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0060, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) == false) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007a, code lost:
            if (((java.lang.Boolean) r7).booleanValue() != false) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0098, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d1, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L_0x00d3;
         */
        private final Object doubleAnd(Object obj, Object obj2) {
            boolean z = obj instanceof Number;
            boolean z2 = true;
            if (z && (obj2 instanceof Number)) {
                if (!(((Number) obj).floatValue() == 0.0f)) {
                }
            } else if (z && (obj2 instanceof Boolean)) {
                if (!(((Number) obj).floatValue() == 0.0f)) {
                }
            } else if (!z || !(obj2 instanceof String)) {
                boolean z3 = obj instanceof Boolean;
                if (!z3 || !(obj2 instanceof Boolean)) {
                    if (!z3 || !(obj2 instanceof Number)) {
                        if (!z3 || !(obj2 instanceof String)) {
                            boolean z4 = obj instanceof String;
                            if (!z4 || !(obj2 instanceof String)) {
                                if (z4 && (obj2 instanceof Boolean)) {
                                    z2 = ((Boolean) obj2).booleanValue();
                                } else if (z4 && (obj2 instanceof Number)) {
                                }
                            }
                            return Boolean.valueOf(z2);
                        }
                        z2 = ((Boolean) obj).booleanValue();
                        return Boolean.valueOf(z2);
                    } else if (((Boolean) obj).booleanValue()) {
                    }
                } else if (((Boolean) obj).booleanValue()) {
                }
            }
            z2 = false;
            return Boolean.valueOf(z2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
            if (((java.lang.Boolean) r7).booleanValue() == false) goto L_0x00f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0067, code lost:
            if (((java.lang.Boolean) r7).booleanValue() == false) goto L_0x00f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0085, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c4, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00ca, code lost:
            if ((r7 instanceof java.lang.String) != false) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x00ec, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) == false) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x00f2, code lost:
            if ((r6 instanceof java.lang.String) != false) goto L_0x004e;
         */
        private final Object doubleOr(Object obj, Object obj2) {
            boolean z;
            boolean z2 = obj instanceof Number;
            boolean z3 = false;
            if (z2 && (obj2 instanceof Number)) {
                if (((Number) obj).floatValue() == 0.0f) {
                }
            } else if (z2 && (obj2 instanceof Boolean)) {
                if (((Number) obj).floatValue() == 0.0f) {
                }
            } else if (!z2 || !(obj2 instanceof String)) {
                boolean z4 = obj instanceof Boolean;
                if (!z4 || !(obj2 instanceof Boolean)) {
                    if (!z4 || !(obj2 instanceof Number)) {
                        if ((!z4 || !(obj2 instanceof String)) && ((!((z = obj instanceof String)) || !(obj2 instanceof String)) && ((!z || !(obj2 instanceof Boolean)) && (!z || !(obj2 instanceof Number))))) {
                            if (obj == null) {
                                if (obj2 instanceof Boolean) {
                                    z3 = ((Boolean) obj2).booleanValue();
                                } else if (obj2 instanceof Number) {
                                }
                                return Boolean.valueOf(z3);
                            }
                            if (obj2 == null) {
                                if (obj instanceof Boolean) {
                                    z3 = ((Boolean) obj).booleanValue();
                                } else if (obj instanceof Number) {
                                }
                            }
                            return Boolean.valueOf(z3);
                        }
                    } else if (!((Boolean) obj).booleanValue()) {
                    }
                } else if (!((Boolean) obj).booleanValue()) {
                }
            }
            z3 = true;
            return Boolean.valueOf(z3);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
            if (((java.lang.Number) r6).floatValue() == ((java.lang.Number) r7).floatValue()) goto L_0x00ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0058, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) != false) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x006f, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) != false) goto L_0x00ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x008e, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) != false) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a5, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) != false) goto L_0x00ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00aa, code lost:
            if (r7 == null) goto L_0x00ac;
         */
        private final Object equal(Object obj, Object obj2) {
            boolean z = true;
            if (!(obj instanceof String) || !(obj2 instanceof String)) {
                boolean z2 = obj instanceof Number;
                if (!z2 || !(obj2 instanceof Number)) {
                    boolean z3 = obj instanceof Boolean;
                    if (z3 && (obj2 instanceof Boolean)) {
                        z = k21.d(obj, obj2);
                    } else if (z2 && (obj2 instanceof Boolean)) {
                        if (k21.d(obj2, Boolean.TRUE)) {
                        }
                        if (k21.d(obj2, Boolean.FALSE)) {
                        }
                    } else if (z3 && (obj2 instanceof Number)) {
                        if (k21.d(obj, Boolean.TRUE)) {
                        }
                        if (k21.d(obj, Boolean.FALSE)) {
                        }
                    } else if (obj == null) {
                    }
                }
                z = false;
            } else {
                z = k21.d(obj, obj2);
            }
            return Boolean.valueOf(z);
        }

        private final Object greaterThan(Object obj, Object obj2) {
            boolean z = false;
            if ((obj instanceof Number) && (obj2 instanceof Number) && ((Number) obj).floatValue() > ((Number) obj2).floatValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        private final Object greaterThanOrEqual(Object obj, Object obj2) {
            boolean z = false;
            if ((obj instanceof Number) && (obj2 instanceof Number) && ((Number) obj).floatValue() >= ((Number) obj2).floatValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        private final Object lessThan(Object obj, Object obj2) {
            boolean z = false;
            if ((obj instanceof Number) && (obj2 instanceof Number) && ((Number) obj).floatValue() < ((Number) obj2).floatValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        private final Object lessThanOrEqual(Object obj, Object obj2) {
            boolean z = false;
            if ((obj instanceof Number) && (obj2 instanceof Number) && ((Number) obj).floatValue() <= ((Number) obj2).floatValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        private final Object mod(Object obj, Object obj2) {
            if (!(obj instanceof Number) || !(obj2 instanceof Number)) {
                return Boolean.FALSE;
            }
            if ((obj instanceof Integer) && (obj2 instanceof Integer)) {
                return Integer.valueOf(((Number) obj).intValue() % ((Number) obj2).intValue());
            }
            if (!(obj instanceof Float) || !(obj2 instanceof Float)) {
                return Float.valueOf(((Number) obj).floatValue() % ((Number) obj2).floatValue());
            }
            return Float.valueOf(((Number) obj).floatValue() % ((Number) obj2).floatValue());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
            if ((((java.lang.Number) r6).floatValue() == ((java.lang.Number) r7).floatValue()) == false) goto L_0x00af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            if (tb.k21.d(r6, r7) == false) goto L_0x00af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0060, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) == false) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0077, code lost:
            if ((((java.lang.Number) r6).floatValue() == 0.0f) == false) goto L_0x00af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0096, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ad, code lost:
            if ((((java.lang.Number) r7).floatValue() == 0.0f) == false) goto L_0x00af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
            if (tb.k21.d(r6, r7) == false) goto L_0x00af;
         */
        private final Object notEqual(Object obj, Object obj2) {
            boolean z = true;
            if (!(obj instanceof String) || !(obj2 instanceof String)) {
                boolean z2 = obj instanceof Number;
                if (!z2 || !(obj2 instanceof Number)) {
                    boolean z3 = obj instanceof Boolean;
                    if (!z3 || !(obj2 instanceof Boolean)) {
                        if (z2 && (obj2 instanceof Boolean)) {
                            if (k21.d(obj2, Boolean.TRUE)) {
                            }
                            if (k21.d(obj2, Boolean.FALSE)) {
                            }
                        } else if (z3 && (obj2 instanceof Number)) {
                            if (k21.d(obj, Boolean.TRUE)) {
                            }
                            if (k21.d(obj, Boolean.FALSE)) {
                            }
                        }
                    }
                }
            }
            z = false;
            return Boolean.valueOf(z);
        }

        @NotNull
        public final String component1() {
            return this.operate;
        }

        @NotNull
        public final GaiaXExpression component2() {
            return this.leftValue;
        }

        @NotNull
        public final GaiaXExpression component3() {
            return this.rightValue;
        }

        @NotNull
        public final GEval copy(@NotNull String str, @NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2) {
            k21.i(str, "operate");
            k21.i(gaiaXExpression, "leftValue");
            k21.i(gaiaXExpression2, "rightValue");
            return new GEval(str, gaiaXExpression, gaiaXExpression2);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            Object desireData = this.leftValue.desireData(json);
            Object desireData2 = this.rightValue.desireData(json);
            String str = this.operate;
            int hashCode = str.hashCode();
            if (hashCode != 37) {
                if (hashCode != 60) {
                    if (hashCode != 62) {
                        if (hashCode != 1084) {
                            if (hashCode != 1216) {
                                if (hashCode != 1921) {
                                    if (hashCode != 1952) {
                                        if (hashCode != 1983) {
                                            if (hashCode == 3968 && str.equals(jl1.OR)) {
                                                return doubleOr(desireData, desireData2);
                                            }
                                        } else if (str.equals(jl1.GE)) {
                                            return greaterThanOrEqual(desireData, desireData2);
                                        }
                                    } else if (str.equals(jl1.EQUAL2)) {
                                        return equal(desireData, desireData2);
                                    }
                                } else if (str.equals(jl1.LE)) {
                                    return lessThanOrEqual(desireData, desireData2);
                                }
                            } else if (str.equals(jl1.AND)) {
                                return doubleAnd(desireData, desireData2);
                            }
                        } else if (str.equals(jl1.NOT_EQUAL2)) {
                            return notEqual(desireData, desireData2);
                        }
                    } else if (str.equals(jl1.G)) {
                        return greaterThan(desireData, desireData2);
                    }
                } else if (str.equals(jl1.L)) {
                    return lessThan(desireData, desireData2);
                }
            } else if (str.equals("%")) {
                return mod(desireData, desireData2);
            }
            return Boolean.FALSE;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GEval)) {
                return false;
            }
            GEval gEval = (GEval) obj;
            return k21.d(this.operate, gEval.operate) && k21.d(this.leftValue, gEval.leftValue) && k21.d(this.rightValue, gEval.rightValue);
        }

        @NotNull
        public final GaiaXExpression getLeftValue() {
            return this.leftValue;
        }

        @NotNull
        public final String getOperate() {
            return this.operate;
        }

        @NotNull
        public final GaiaXExpression getRightValue() {
            return this.rightValue;
        }

        public int hashCode() {
            return (((this.operate.hashCode() * 31) + this.leftValue.hashCode()) * 31) + this.rightValue.hashCode();
        }

        @NotNull
        public String toString() {
            return "GEval(operate='" + this.operate + "', leftValue=" + this.leftValue + ", rightValue=" + this.rightValue + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GFloat;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "", "component1", "value", by0.ARG_COPY, "", "hashCode", "other", "", "equals", UTConstant.Args.UT_SUCCESS_F, "getValue", "()F", "<init>", "(F)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GFloat extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        private final float value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GFloat$Companion;", "", "", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GFloat;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GFloat create(@NotNull String str) {
                k21.i(str, "value");
                return new GFloat(Float.parseFloat(str));
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                try {
                    return k21.d(String.valueOf(Float.parseFloat(str)), str);
                } catch (Exception unused) {
                    return false;
                }
            }
        }

        public GFloat(float f) {
            super(null);
            this.value = f;
        }

        public static /* synthetic */ GFloat copy$default(GFloat gFloat, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = gFloat.value;
            }
            return gFloat.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        @NotNull
        public final GFloat copy(float f) {
            return new GFloat(f);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return Float.valueOf(this.value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GFloat) && k21.d(Float.valueOf(this.value), Float.valueOf(((GFloat) obj).value));
        }

        public final float getValue() {
            return this.value;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        @NotNull
        public String toString() {
            return "GFloat(value=" + this.value + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010\f\u001a\u00020\bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GInt;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "", "component1", "value", by0.ARG_COPY, "hashCode", "other", "", "equals", "I", "getValue", "()I", "<init>", "(I)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GInt extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        private final int value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GInt$Companion;", "", "", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GInt;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GInt create(@NotNull String str) {
                k21.i(str, "value");
                return new GInt(Integer.parseInt(str));
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                try {
                    return k21.d(String.valueOf(Integer.parseInt(str)), str);
                } catch (Exception unused) {
                    return false;
                }
            }
        }

        public GInt(int i) {
            super(null);
            this.value = i;
        }

        public static /* synthetic */ GInt copy$default(GInt gInt, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = gInt.value;
            }
            return gInt.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        @NotNull
        public final GInt copy(int i) {
            return new GInt(i);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return Integer.valueOf(this.value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GInt) && this.value == ((GInt) obj).value;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value;
        }

        @NotNull
        public String toString() {
            return "GInt(value=" + this.value + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GJsonArrayObj;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "Lcom/alibaba/fastjson/JSONArray;", "component1", "value", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/alibaba/fastjson/JSONArray;", "getValue", "()Lcom/alibaba/fastjson/JSONArray;", "<init>", "(Lcom/alibaba/fastjson/JSONArray;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GJsonArrayObj extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final JSONArray value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GJsonArrayObj$Companion;", "", "Lcom/alibaba/fastjson/JSONArray;", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GJsonArrayObj;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GJsonArrayObj create(@NotNull JSONArray jSONArray) {
                k21.i(jSONArray, "value");
                JSONArray jSONArray2 = new JSONArray();
                for (Object obj : jSONArray) {
                    if (obj != null) {
                        jSONArray2.add(GaiaXExpression.Companion.create(obj));
                    }
                }
                return new GJsonArrayObj(jSONArray2);
            }

            public final boolean isExpression(@NotNull Object obj) {
                k21.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return obj instanceof JSONArray;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GJsonArrayObj(@NotNull JSONArray jSONArray) {
            super(null);
            k21.i(jSONArray, "value");
            this.value = jSONArray;
        }

        public static /* synthetic */ GJsonArrayObj copy$default(GJsonArrayObj gJsonArrayObj, JSONArray jSONArray, int i, Object obj) {
            if ((i & 1) != 0) {
                jSONArray = gJsonArrayObj.value;
            }
            return gJsonArrayObj.copy(jSONArray);
        }

        @NotNull
        public final JSONArray component1() {
            return this.value;
        }

        @NotNull
        public final GJsonArrayObj copy(@NotNull JSONArray jSONArray) {
            k21.i(jSONArray, "value");
            return new GJsonArrayObj(jSONArray);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            JSONArray jSONArray = new JSONArray();
            if (!this.value.isEmpty()) {
                for (Object obj : this.value) {
                    if (obj != null && (obj instanceof GaiaXExpression)) {
                        jSONArray.add(((GaiaXExpression) obj).desireData(json));
                    }
                }
            }
            return jSONArray;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GJsonArrayObj) && k21.d(this.value, ((GJsonArrayObj) obj).value);
        }

        @NotNull
        public final JSONArray getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GJsonArrayObj(value=" + this.value + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GJsonObj;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "Lcom/alibaba/fastjson/JSONObject;", "component1", "value", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/alibaba/fastjson/JSONObject;", "getValue", "()Lcom/alibaba/fastjson/JSONObject;", "<init>", "(Lcom/alibaba/fastjson/JSONObject;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GJsonObj extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final JSONObject value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GJsonObj$Companion;", "", "Lcom/alibaba/fastjson/JSONObject;", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GJsonObj;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GJsonObj create(@NotNull JSONObject jSONObject) {
                k21.i(jSONObject, "value");
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry entry : jSONObject.entrySet()) {
                    if (!(entry.getKey() == null || entry.getValue() == null)) {
                        if ((entry.getValue() instanceof Integer) || (entry.getValue() instanceof Boolean)) {
                            jSONObject2.put(entry.getKey(), entry.getValue());
                        } else {
                            Object key = entry.getKey();
                            Companion companion = GaiaXExpression.Companion;
                            Object value = entry.getValue();
                            k21.h(value, "it.value");
                            jSONObject2.put(key, companion.create(value));
                        }
                    }
                }
                return new GJsonObj(jSONObject2);
            }

            public final boolean isExpression(@NotNull Object obj) {
                k21.i(obj, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return obj instanceof JSONObject;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GJsonObj(@NotNull JSONObject jSONObject) {
            super(null);
            k21.i(jSONObject, "value");
            this.value = jSONObject;
        }

        public static /* synthetic */ GJsonObj copy$default(GJsonObj gJsonObj, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                jSONObject = gJsonObj.value;
            }
            return gJsonObj.copy(jSONObject);
        }

        @NotNull
        public final JSONObject component1() {
            return this.value;
        }

        @NotNull
        public final GJsonObj copy(@NotNull JSONObject jSONObject) {
            k21.i(jSONObject, "value");
            return new GJsonObj(jSONObject);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            JSONObject jSONObject = new JSONObject();
            if (!this.value.isEmpty()) {
                for (Map.Entry entry : this.value.entrySet()) {
                    if (!(entry.getKey() == null || entry.getValue() == null)) {
                        if (entry.getValue() instanceof GaiaXExpression) {
                            Object key = entry.getKey();
                            Object value2 = entry.getValue();
                            Objects.requireNonNull(value2, "null cannot be cast to non-null type com.youku.gaiax.impl.GaiaXExpression");
                            jSONObject.put(key, ((GaiaXExpression) value2).desireData(json));
                        } else {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
            return jSONObject;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GJsonObj) && k21.d(this.value, ((GJsonObj) obj).value);
        }

        @NotNull
        public final JSONObject getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GJsonObj(value=" + this.value + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GNull;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "<init>", "()V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GNull extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GNull$Companion;", "", "Lcom/youku/gaiax/impl/GaiaXExpression$GNull;", "create", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GNull create() {
                return new GNull();
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return k21.d(str, "null");
            }
        }

        public GNull() {
            super(null);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return null;
        }

        @NotNull
        public String toString() {
            return "GNull()";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\t\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GScroll;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "value", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GScroll extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GScroll$Companion;", "", "", "value", "", "isExpression", "Lcom/youku/gaiax/impl/GaiaXExpression$GScroll;", "create", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GScroll create(@NotNull String str) {
                k21.i(str, "value");
                String substring = str.substring(7, str.length() - 1);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return new GScroll(substring);
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, "value");
                return (o.L(str, "scroll(", false, 2, null)) && (o.v(str, jl1.BRACKET_END_STR, false, 2, null));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GScroll(@NotNull String str) {
            super(null);
            k21.i(str, "value");
            this.value = str;
        }

        public static /* synthetic */ GScroll copy$default(GScroll gScroll, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gScroll.value;
            }
            return gScroll.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        @NotNull
        public final GScroll copy(@NotNull String str) {
            k21.i(str, "value");
            return new GScroll(str);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @NotNull
        public Object desireData(@Nullable JSON json) {
            return Integer.valueOf(json == null ? -1 : zo0.e(json, GaiaXKey.GAIAX_SCROLL_POSITION));
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GScroll) && k21.d(this.value, ((GScroll) obj).value);
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GScroll(value='" + this.value + "')";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0001HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\t\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GSize;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "value", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/youku/gaiax/impl/GaiaXExpression;", "getValue", "()Lcom/youku/gaiax/impl/GaiaXExpression;", "<init>", "(Lcom/youku/gaiax/impl/GaiaXExpression;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GSize extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final GaiaXExpression value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GSize$Companion;", "", "", "value", "", "isExpression", "Lcom/youku/gaiax/impl/GaiaXExpression$GSize;", "create", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GSize create(@NotNull String str) {
                k21.i(str, "value");
                String substring = str.substring(5, str.length() - 1);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return new GSize(GaiaXExpression.Companion.create(substring));
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, "value");
                return (o.L(str, "size(", false, 2, null)) && (o.v(str, jl1.BRACKET_END_STR, false, 2, null));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GSize(@NotNull GaiaXExpression gaiaXExpression) {
            super(null);
            k21.i(gaiaXExpression, "value");
            this.value = gaiaXExpression;
        }

        public static /* synthetic */ GSize copy$default(GSize gSize, GaiaXExpression gaiaXExpression, int i, Object obj) {
            if ((i & 1) != 0) {
                gaiaXExpression = gSize.value;
            }
            return gSize.copy(gaiaXExpression);
        }

        @NotNull
        public final GaiaXExpression component1() {
            return this.value;
        }

        @NotNull
        public final GSize copy(@NotNull GaiaXExpression gaiaXExpression) {
            k21.i(gaiaXExpression, "value");
            return new GSize(gaiaXExpression);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            int i;
            Object desireData = this.value.desireData(json);
            if (desireData instanceof String) {
                i = ((String) desireData).length();
            } else if (desireData instanceof JSONArray) {
                i = ((JSONArray) desireData).size();
            } else {
                i = desireData instanceof JSONObject ? ((JSONObject) desireData).size() : 0;
            }
            return Integer.valueOf(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GSize) && k21.d(this.value, ((GSize) obj).value);
        }

        @NotNull
        public final GaiaXExpression getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GSize(value=" + this.value + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\t\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GString;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "value", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GString extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GString$Companion;", "", "", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GString;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GString create(@NotNull String str) {
                k21.i(str, "value");
                String substring = str.substring(1, str.length() - 1);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return new GString(substring);
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return (o.L(str, "'", false, 2, null)) && (o.v(str, "'", false, 2, null)) && !(StringsKt__StringsKt.Q(str, " + ", false, 2, null));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GString(@NotNull String str) {
            super(null);
            k21.i(str, "value");
            this.value = str;
        }

        public static /* synthetic */ GString copy$default(GString gString, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gString.value;
            }
            return gString.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        @NotNull
        public final GString copy(@NotNull String str) {
            k21.i(str, "value");
            return new GString(str);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return this.value;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GString) && k21.d(this.value, ((GString) obj).value);
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GString(value='" + this.value + "')";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\t\u0010\t\u001a\u00020\u0001HÆ\u0003J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u0001HÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\u000b\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0019\u0010\r\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue1;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "component2", "component3", "condition", "trueBranch", "falseBranch", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/youku/gaiax/impl/GaiaXExpression;", "getCondition", "()Lcom/youku/gaiax/impl/GaiaXExpression;", "getTrueBranch", "getFalseBranch", "<init>", "(Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GTernaryValue1 extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final GaiaXExpression condition;
        @NotNull
        private final GaiaXExpression falseBranch;
        @NotNull
        private final GaiaXExpression trueBranch;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue1$Companion;", "", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExp", "isExp2", "getExpressionValue", "conditionValue", "trueValue", "falseValue", "Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue1;", "create", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            private final String conditionValue(String str) {
                List list = StringsKt__StringsKt.z0(str, new String[]{" ? "}, false, 0, 6, null);
                return list.isEmpty() ^ true ? (String) list.get(0) : "";
            }

            private final String falseValue(String str) {
                List list = StringsKt__StringsKt.z0(str, new String[]{" ? "}, false, 0, 6, null);
                if (list.size() < 2) {
                    return "";
                }
                List list2 = StringsKt__StringsKt.z0((CharSequence) list.get(1), new String[]{" : "}, false, 0, 6, null);
                if (list2.size() == 2) {
                    return (String) list2.get(1);
                }
                if (list2.size() <= 2) {
                    return "";
                }
                List list3 = StringsKt__StringsKt.z0((CharSequence) list.get(1), new String[]{" : "}, false, 0, 6, null);
                return list3.size() == 2 ? (String) list3.get(1) : "";
            }

            private final String getExpressionValue(String str) {
                int i = StringsKt__StringsKt.f0(str, jl1.BLOCK_START_STR, 0, false, 6, null);
                int i2 = StringsKt__StringsKt.l0(str, "}", 0, false, 6, null);
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(i + 1, i2);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }

            private final boolean isExp(String str) {
                if (!(StringsKt__StringsKt.Q(str, "${", false, 2, null)) || !(o.L(str, "@{", false, 2, null)) || !(o.v(str, "}", false, 2, null)) || !(StringsKt__StringsKt.Q(str, " ? ", false, 2, null)) || !(StringsKt__StringsKt.Q(str, " : ", false, 2, null)) || (StringsKt__StringsKt.Q(str, " ?: ", false, 2, null))) {
                    return false;
                }
                return true;
            }

            private final boolean isExp2(String str) {
                if (!(o.L(str, "@{", false, 2, null)) || !(o.v(str, "}", false, 2, null)) || !(StringsKt__StringsKt.Q(str, " ? ", false, 2, null)) || !(StringsKt__StringsKt.Q(str, " : ", false, 2, null)) || (StringsKt__StringsKt.Q(str, " ?: ", false, 2, null))) {
                    return false;
                }
                return true;
            }

            private final String trueValue(String str) {
                List list = StringsKt__StringsKt.z0(str, new String[]{" ? "}, false, 0, 6, null);
                if (list.size() != 2) {
                    return "";
                }
                List list2 = StringsKt__StringsKt.z0((CharSequence) list.get(1), new String[]{" : "}, false, 0, 6, null);
                if (list2.size() == 2) {
                    return (String) list2.get(0);
                }
                if (list2.size() <= 2) {
                    return "";
                }
                List list3 = StringsKt__StringsKt.z0((CharSequence) list.get(1), new String[]{" : "}, false, 0, 6, null);
                return list3.size() == 2 ? (String) list3.get(0) : "";
            }

            @NotNull
            public final GTernaryValue1 create(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                String expressionValue = getExpressionValue(str);
                Companion companion = GaiaXExpression.Companion;
                return new GTernaryValue1(companion.create(conditionValue(expressionValue)), companion.create(trueValue(expressionValue)), companion.create(falseValue(expressionValue)));
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return isExp(str) || isExp2(str);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GTernaryValue1(@NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2, @NotNull GaiaXExpression gaiaXExpression3) {
            super(null);
            k21.i(gaiaXExpression, "condition");
            k21.i(gaiaXExpression2, "trueBranch");
            k21.i(gaiaXExpression3, "falseBranch");
            this.condition = gaiaXExpression;
            this.trueBranch = gaiaXExpression2;
            this.falseBranch = gaiaXExpression3;
        }

        public static /* synthetic */ GTernaryValue1 copy$default(GTernaryValue1 gTernaryValue1, GaiaXExpression gaiaXExpression, GaiaXExpression gaiaXExpression2, GaiaXExpression gaiaXExpression3, int i, Object obj) {
            if ((i & 1) != 0) {
                gaiaXExpression = gTernaryValue1.condition;
            }
            if ((i & 2) != 0) {
                gaiaXExpression2 = gTernaryValue1.trueBranch;
            }
            if ((i & 4) != 0) {
                gaiaXExpression3 = gTernaryValue1.falseBranch;
            }
            return gTernaryValue1.copy(gaiaXExpression, gaiaXExpression2, gaiaXExpression3);
        }

        @NotNull
        public final GaiaXExpression component1() {
            return this.condition;
        }

        @NotNull
        public final GaiaXExpression component2() {
            return this.trueBranch;
        }

        @NotNull
        public final GaiaXExpression component3() {
            return this.falseBranch;
        }

        @NotNull
        public final GTernaryValue1 copy(@NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2, @NotNull GaiaXExpression gaiaXExpression3) {
            k21.i(gaiaXExpression, "condition");
            k21.i(gaiaXExpression2, "trueBranch");
            k21.i(gaiaXExpression3, "falseBranch");
            return new GTernaryValue1(gaiaXExpression, gaiaXExpression2, gaiaXExpression3);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            if (GaiaXExpression.Companion.isCondition(this.condition.desireData(json))) {
                return this.trueBranch.desireData(json);
            }
            return this.falseBranch.desireData(json);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GTernaryValue1)) {
                return false;
            }
            GTernaryValue1 gTernaryValue1 = (GTernaryValue1) obj;
            return k21.d(this.condition, gTernaryValue1.condition) && k21.d(this.trueBranch, gTernaryValue1.trueBranch) && k21.d(this.falseBranch, gTernaryValue1.falseBranch);
        }

        @NotNull
        public final GaiaXExpression getCondition() {
            return this.condition;
        }

        @NotNull
        public final GaiaXExpression getFalseBranch() {
            return this.falseBranch;
        }

        @NotNull
        public final GaiaXExpression getTrueBranch() {
            return this.trueBranch;
        }

        public int hashCode() {
            return (((this.condition.hashCode() * 31) + this.trueBranch.hashCode()) * 31) + this.falseBranch.hashCode();
        }

        @NotNull
        public String toString() {
            return "GTernaryValue1(condition=" + this.condition + ", trueBranch=" + this.trueBranch + ", falseBranch=" + this.falseBranch + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\t\u0010\t\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u0001HÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\n\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u000b\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue2;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "component2", "conditionAndTrueBranch", "falseBranch", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/youku/gaiax/impl/GaiaXExpression;", "getConditionAndTrueBranch", "()Lcom/youku/gaiax/impl/GaiaXExpression;", "getFalseBranch", "<init>", "(Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GTernaryValue2 extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final GaiaXExpression conditionAndTrueBranch;
        @NotNull
        private final GaiaXExpression falseBranch;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue2$Companion;", "", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "getExpressionValue", "trueValue", "falseValue", "", "isExp", "isExp2", "Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue2;", "create", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            private final String falseValue(String str) {
                List list = StringsKt__StringsKt.z0(str, new String[]{" ?: "}, false, 0, 6, null);
                return list.size() == 2 ? (String) list.get(1) : "";
            }

            private final String getExpressionValue(String str) {
                int i = StringsKt__StringsKt.f0(str, jl1.BLOCK_START_STR, 0, false, 6, null);
                int i2 = StringsKt__StringsKt.l0(str, "}", 0, false, 6, null);
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(i + 1, i2);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }

            private final boolean isExp(String str) {
                if (!(StringsKt__StringsKt.Q(str, "${", false, 2, null)) || !(o.L(str, "@{", false, 2, null)) || !(o.v(str, "}", false, 2, null)) || !(StringsKt__StringsKt.Q(str, " ?: ", false, 2, null))) {
                    return false;
                }
                return true;
            }

            private final boolean isExp2(String str) {
                if (!(o.L(str, "@{", false, 2, null)) || !(o.v(str, "}", false, 2, null)) || !(StringsKt__StringsKt.Q(str, " ?: ", false, 2, null))) {
                    return false;
                }
                return true;
            }

            private final String trueValue(String str) {
                List list = StringsKt__StringsKt.z0(str, new String[]{" ?: "}, false, 0, 6, null);
                return list.size() == 2 ? (String) list.get(0) : "";
            }

            @NotNull
            public final GTernaryValue2 create(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                String expressionValue = getExpressionValue(str);
                Companion companion = GaiaXExpression.Companion;
                return new GTernaryValue2(companion.create(trueValue(expressionValue)), companion.create(falseValue(expressionValue)));
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return isExp(str) || isExp2(str);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GTernaryValue2(@NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2) {
            super(null);
            k21.i(gaiaXExpression, "conditionAndTrueBranch");
            k21.i(gaiaXExpression2, "falseBranch");
            this.conditionAndTrueBranch = gaiaXExpression;
            this.falseBranch = gaiaXExpression2;
        }

        public static /* synthetic */ GTernaryValue2 copy$default(GTernaryValue2 gTernaryValue2, GaiaXExpression gaiaXExpression, GaiaXExpression gaiaXExpression2, int i, Object obj) {
            if ((i & 1) != 0) {
                gaiaXExpression = gTernaryValue2.conditionAndTrueBranch;
            }
            if ((i & 2) != 0) {
                gaiaXExpression2 = gTernaryValue2.falseBranch;
            }
            return gTernaryValue2.copy(gaiaXExpression, gaiaXExpression2);
        }

        @NotNull
        public final GaiaXExpression component1() {
            return this.conditionAndTrueBranch;
        }

        @NotNull
        public final GaiaXExpression component2() {
            return this.falseBranch;
        }

        @NotNull
        public final GTernaryValue2 copy(@NotNull GaiaXExpression gaiaXExpression, @NotNull GaiaXExpression gaiaXExpression2) {
            k21.i(gaiaXExpression, "conditionAndTrueBranch");
            k21.i(gaiaXExpression2, "falseBranch");
            return new GTernaryValue2(gaiaXExpression, gaiaXExpression2);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            Object desireData = this.conditionAndTrueBranch.desireData(json);
            return GaiaXExpression.Companion.isCondition(desireData) ? desireData : this.falseBranch.desireData(json);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GTernaryValue2)) {
                return false;
            }
            GTernaryValue2 gTernaryValue2 = (GTernaryValue2) obj;
            return k21.d(this.conditionAndTrueBranch, gTernaryValue2.conditionAndTrueBranch) && k21.d(this.falseBranch, gTernaryValue2.falseBranch);
        }

        @NotNull
        public final GaiaXExpression getConditionAndTrueBranch() {
            return this.conditionAndTrueBranch;
        }

        @NotNull
        public final GaiaXExpression getFalseBranch() {
            return this.falseBranch;
        }

        public int hashCode() {
            return (this.conditionAndTrueBranch.hashCode() * 31) + this.falseBranch.hashCode();
        }

        @NotNull
        public String toString() {
            return "GTernaryValue2(conditionAndTrueBranch=" + this.conditionAndTrueBranch + ", falseBranch=" + this.falseBranch + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\u000b\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue3;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "component2", "component3", "value", "trueBranch", "falseBranch", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Lcom/youku/gaiax/impl/GaiaXExpression;", "getValue", "()Lcom/youku/gaiax/impl/GaiaXExpression;", "getTrueBranch", "getFalseBranch", "<init>", "(Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;Lcom/youku/gaiax/impl/GaiaXExpression;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GTernaryValue3 extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private static final Regex regex = new Regex("@\\{(.*)\\}");
        @Nullable
        private final GaiaXExpression falseBranch;
        @Nullable
        private final GaiaXExpression trueBranch;
        @NotNull
        private final GaiaXExpression value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\"\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002R\u001c\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTernaryValue3$Companion;", "", "", "expressionSpace", "Lkotlin/Pair;", "splitBranch", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExp", "isExp2", "isExp3", "Lcom/youku/gaiax/impl/GaiaXExpression;", "create", "isExpression", "Lkotlin/text/Regex;", "regex", "Lkotlin/text/Regex;", "getRegex$annotations", "()V", "<init>", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            private static /* synthetic */ void getRegex$annotations() {
            }

            private final boolean isExp(String str) {
                if (!(StringsKt__StringsKt.Q(str, "${", false, 2, null)) || !(o.L(str, "@{", false, 2, null)) || !(o.v(str, "}", false, 2, null)) || !(StringsKt__StringsKt.Q(str, " ? ", false, 2, null)) || !(StringsKt__StringsKt.Q(str, " : ", false, 2, null)) || (StringsKt__StringsKt.Q(str, " ?: ", false, 2, null))) {
                    return false;
                }
                return true;
            }

            private final boolean isExp2(String str) {
                if (!(o.L(str, "@{", false, 2, null)) || !(o.v(str, "}", false, 2, null)) || !(StringsKt__StringsKt.Q(str, " ? ", false, 2, null)) || !(StringsKt__StringsKt.Q(str, " : ", false, 2, null)) || (StringsKt__StringsKt.Q(str, " ?: ", false, 2, null))) {
                    return false;
                }
                return true;
            }

            private final boolean isExp3(String str) {
                return StringsKt__StringsKt.z0(str, new String[]{"@{"}, false, 0, 6, null).size() > 2;
            }

            private final Pair<String, String> splitBranch(String str) {
                int length = str.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = k21.k(str.charAt(!z ? i : length), 32) <= 0;
                    if (!z) {
                        if (!z2) {
                            z = true;
                        } else {
                            i++;
                        }
                    } else if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                }
                String obj = str.subSequence(i, length + 1).toString();
                int i2 = StringsKt__StringsKt.f0(obj, "@{", 0, false, 6, null);
                if (i2 == -1) {
                    Object[] array = StringsKt__StringsKt.z0(obj, new String[]{" : "}, false, 0, 6, null).toArray(new String[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    String[] strArr = (String[]) array;
                    return new Pair<>(strArr[0], strArr[1]);
                }
                int i3 = StringsKt__StringsKt.f0(obj, " : ", 0, false, 6, null);
                if (i3 < i2) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                    String substring = obj.substring(0, i3);
                    k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String substring2 = obj.substring(i3 + 2);
                    k21.h(substring2, "(this as java.lang.String).substring(startIndex)");
                    return new Pair<>(substring, substring2);
                }
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                String substring3 = obj.substring(i2);
                k21.h(substring3, "(this as java.lang.String).substring(startIndex)");
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= substring3.length()) {
                        i4 = -1;
                        break;
                    }
                    if ('@' == substring3.charAt(i4) || '$' == substring3.charAt(i4)) {
                        i5++;
                        i4++;
                    }
                    if ('}' == substring3.charAt(i4)) {
                        i5--;
                    }
                    if (i5 == 0) {
                        break;
                    }
                    i4++;
                }
                if (i4 != -1) {
                    int i6 = i4 + 1;
                    int i7 = StringsKt__StringsKt.f0(substring3, " : ", i6, false, 4, null);
                    if (i7 != -1) {
                        String substring4 = substring3.substring(0, i6);
                        k21.h(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        String substring5 = substring3.substring(i7 + 2, substring3.length());
                        k21.h(substring5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        return new Pair<>(substring4, substring5);
                    }
                }
                return null;
            }

            @NotNull
            public final GaiaXExpression create(@NotNull String str) {
                String str2;
                String second;
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                Sequence findAll$default = Regex.findAll$default(GTernaryValue3.regex, str, 0, 2, null);
                if (SequencesKt___SequencesKt.m(findAll$default) <= 0 || ((MatchResult) d.r(findAll$default)).getGroupValues().size() <= 1) {
                    return GaiaXExpression.Companion.create(str);
                }
                String str3 = ((MatchResult) d.r(findAll$default)).getGroupValues().get(1);
                int i = StringsKt__StringsKt.f0(str3, " ? ", 0, false, 6, null);
                if (i == -1) {
                    return GaiaXExpression.Companion.create(str3);
                }
                Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                String substring = str3.substring(0, i);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Companion companion = GaiaXExpression.Companion;
                GaiaXExpression create = companion.create(substring);
                if (StringsKt__StringsKt.f0(str3, " : ", 0, false, 6, null) == -1) {
                    return companion.create(create);
                }
                String substring2 = str3.substring(i + 3);
                k21.h(substring2, "(this as java.lang.String).substring(startIndex)");
                Pair<String, String> splitBranch = splitBranch(substring2);
                String str4 = "";
                if (splitBranch == null || (str2 = splitBranch.getFirst()) == null) {
                    str2 = str4;
                }
                GaiaXExpression create2 = companion.create(str2);
                if (!(splitBranch == null || (second = splitBranch.getSecond()) == null)) {
                    str4 = second;
                }
                return new GTernaryValue3(create, create2, companion.create(str4));
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return (isExp(str) || isExp2(str)) && isExp3(str);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GTernaryValue3(@NotNull GaiaXExpression gaiaXExpression, @Nullable GaiaXExpression gaiaXExpression2, @Nullable GaiaXExpression gaiaXExpression3) {
            super(null);
            k21.i(gaiaXExpression, "value");
            this.value = gaiaXExpression;
            this.trueBranch = gaiaXExpression2;
            this.falseBranch = gaiaXExpression3;
        }

        public static /* synthetic */ GTernaryValue3 copy$default(GTernaryValue3 gTernaryValue3, GaiaXExpression gaiaXExpression, GaiaXExpression gaiaXExpression2, GaiaXExpression gaiaXExpression3, int i, Object obj) {
            if ((i & 1) != 0) {
                gaiaXExpression = gTernaryValue3.value;
            }
            if ((i & 2) != 0) {
                gaiaXExpression2 = gTernaryValue3.trueBranch;
            }
            if ((i & 4) != 0) {
                gaiaXExpression3 = gTernaryValue3.falseBranch;
            }
            return gTernaryValue3.copy(gaiaXExpression, gaiaXExpression2, gaiaXExpression3);
        }

        @NotNull
        public final GaiaXExpression component1() {
            return this.value;
        }

        @Nullable
        public final GaiaXExpression component2() {
            return this.trueBranch;
        }

        @Nullable
        public final GaiaXExpression component3() {
            return this.falseBranch;
        }

        @NotNull
        public final GTernaryValue3 copy(@NotNull GaiaXExpression gaiaXExpression, @Nullable GaiaXExpression gaiaXExpression2, @Nullable GaiaXExpression gaiaXExpression3) {
            k21.i(gaiaXExpression, "value");
            return new GTernaryValue3(gaiaXExpression, gaiaXExpression2, gaiaXExpression3);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            if (this.falseBranch == null || this.trueBranch == null) {
                return this.value.desireData(json);
            }
            if (GaiaXExpression.Companion.isCondition(this.value.desireData(json))) {
                return this.trueBranch.desireData(json);
            }
            return this.falseBranch.desireData(json);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GTernaryValue3)) {
                return false;
            }
            GTernaryValue3 gTernaryValue3 = (GTernaryValue3) obj;
            return k21.d(this.value, gTernaryValue3.value) && k21.d(this.trueBranch, gTernaryValue3.trueBranch) && k21.d(this.falseBranch, gTernaryValue3.falseBranch);
        }

        @Nullable
        public final GaiaXExpression getFalseBranch() {
            return this.falseBranch;
        }

        @Nullable
        public final GaiaXExpression getTrueBranch() {
            return this.trueBranch;
        }

        @NotNull
        public final GaiaXExpression getValue() {
            return this.value;
        }

        public int hashCode() {
            int hashCode = this.value.hashCode() * 31;
            GaiaXExpression gaiaXExpression = this.trueBranch;
            int i = 0;
            int hashCode2 = (hashCode + (gaiaXExpression == null ? 0 : gaiaXExpression.hashCode())) * 31;
            GaiaXExpression gaiaXExpression2 = this.falseBranch;
            if (gaiaXExpression2 != null) {
                i = gaiaXExpression2.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            return "GTernaryValue3(value=" + this.value + ", trueBranch=" + this.trueBranch + ", falseBranch=" + this.falseBranch + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\t\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GText;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "component1", "value", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GText extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GText$Companion;", "", "", "value", "Lcom/youku/gaiax/impl/GaiaXExpression$GText;", "create", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GText create(@NotNull String str) {
                k21.i(str, "value");
                return new GText(str);
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return str.length() > 0;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GText(@NotNull String str) {
            super(null);
            k21.i(str, "value");
            this.value = str;
        }

        public static /* synthetic */ GText copy$default(GText gText, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gText.value;
            }
            return gText.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        @NotNull
        public final GText copy(@NotNull String str) {
            k21.i(str, "value");
            return new GText(str);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            if (k21.d(this.value, "null")) {
                return null;
            }
            return this.value;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GText) && k21.d(this.value, ((GText) obj).value);
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "GText(value='" + this.value + "')";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bHÆ\u0003J\u0019\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\bHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTextValue;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "", "component1", "values", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/util/List;", "getValues", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GTextValue extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final List<GaiaXExpression> values;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GTextValue$Companion;", "", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "Lcom/youku/gaiax/impl/GaiaXExpression$GTextValue;", "create", "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GTextValue create(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                GTextValue gTextValue = new GTextValue(null, 1, null);
                for (String str2 : StringsKt__StringsKt.z0(str, new String[]{" + "}, false, 0, 6, null)) {
                    gTextValue.getValues().add(GaiaXExpression.Companion.create(str2));
                }
                return gTextValue;
            }

            public final boolean isExpression(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                return !(o.L(str, o70.DINAMIC_PREFIX_AT, false, 2, null)) && (StringsKt__StringsKt.Q(str, " + ", false, 2, null));
            }
        }

        public GTextValue() {
            this(null, 1, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GTextValue(List list, int i, m40 m40) {
            this((i & 1) != 0 ? new ArrayList() : list);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.youku.gaiax.impl.GaiaXExpression$GTextValue */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GTextValue copy$default(GTextValue gTextValue, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = gTextValue.values;
            }
            return gTextValue.copy(list);
        }

        @NotNull
        public final List<GaiaXExpression> component1() {
            return this.values;
        }

        @NotNull
        public final GTextValue copy(@NotNull List<GaiaXExpression> list) {
            k21.i(list, "values");
            return new GTextValue(list);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            StringBuilder sb = new StringBuilder();
            Iterator<T> it = this.values.iterator();
            while (it.hasNext()) {
                Object desireData = it.next().desireData(json);
                if (desireData != null) {
                    sb.append(desireData);
                }
            }
            return sb.toString();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GTextValue) && k21.d(this.values, ((GTextValue) obj).values);
        }

        @NotNull
        public final List<GaiaXExpression> getValues() {
            return this.values;
        }

        public int hashCode() {
            return this.values.hashCode();
        }

        @NotNull
        public String toString() {
            return "GTextValue(values=" + this.values + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GTextValue(@NotNull List<GaiaXExpression> list) {
            super(null);
            k21.i(list, "values");
            this.values = list;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\nH\u0016J\t\u0010\f\u001a\u00020\nHÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÖ\u0003R\u0019\u0010\r\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GValue;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", DXTraceUtil.TYPE_EXPRESSION_STRING, "target", "Ltb/ur2;", "setData", "", "toString", "component1", "value", by0.ARG_COPY, "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GValue extends GaiaXExpression {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String value;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$GValue$Companion;", "", "", DXTraceUtil.TYPE_EXPRESSION_STRING, "Lcom/youku/gaiax/impl/GaiaXExpression$GValue;", "create", "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(m40 m40) {
                this();
            }

            @NotNull
            public final GValue create(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                Matcher matcher = GaiaXExpression.Companion.getValueRegex().matcher(str);
                if (!matcher.find()) {
                    return new GValue("");
                }
                String group = matcher.group(1);
                k21.h(group, "matcher.group(1)");
                return new GValue(group);
            }

            /* JADX WARNING: Removed duplicated region for block: B:5:0x0026  */
            public final boolean isExpression(@NotNull String str) {
                k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
                Companion companion = GaiaXExpression.Companion;
                if (companion.getValueFullRegex().matcher(str).find()) {
                    Matcher matcher = companion.getValueRegex().matcher(str);
                    int i = 0;
                    while (matcher.find() && (i = i + 1) < 2) {
                        while (matcher.find()) {
                            while (matcher.find()) {
                            }
                        }
                    }
                    if (i == 1) {
                        return true;
                    }
                }
                return false;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GValue(@NotNull String str) {
            super(null);
            k21.i(str, "value");
            this.value = str;
        }

        public static /* synthetic */ GValue copy$default(GValue gValue, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gValue.value;
            }
            return gValue.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.value;
        }

        @NotNull
        public final GValue copy(@NotNull String str) {
            k21.i(str, "value");
            return new GValue(str);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            if (json == null) {
                return null;
            }
            return zo0.c(json, this.value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GValue) && k21.d(this.value, ((GValue) obj).value);
        }

        @Override // com.alibaba.gaiax.template.GXIExpression, com.youku.gaiax.impl.GaiaXExpression
        @NotNull
        public Object expression() {
            return this.value;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public final void setData(@Nullable JSON json, @NotNull Object obj) {
            k21.i(obj, "target");
            if (json != null) {
                zo0.l(json, this.value, obj);
            }
        }

        @NotNull
        public String toString() {
            return "GValue(value='" + this.value + "')";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$Self;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "", "toString", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", DXTraceUtil.TYPE_EXPRESSION_STRING, "", "isExpression", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Self extends GaiaXExpression {
        @NotNull
        public static final Self INSTANCE = new Self();

        private Self() {
            super(null);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return json;
        }

        public final boolean isExpression(@NotNull String str) {
            k21.i(str, DXTraceUtil.TYPE_EXPRESSION_STRING);
            return k21.d("$$", str);
        }

        @NotNull
        public String toString() {
            return "Self()";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExpression$Undefined;", "Lcom/youku/gaiax/impl/GaiaXExpression;", "Lcom/alibaba/fastjson/JSON;", "rawJson", "", "desireData", "", "toString", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Undefined extends GaiaXExpression {
        @NotNull
        public static final Undefined INSTANCE = new Undefined();

        private Undefined() {
            super(null);
        }

        @Override // com.youku.gaiax.impl.GaiaXExpression
        @Nullable
        public Object desireData(@Nullable JSON json) {
            return null;
        }

        @NotNull
        public String toString() {
            return "Undefined()";
        }
    }

    private GaiaXExpression() {
    }

    public /* synthetic */ GaiaXExpression(m40 m40) {
        this();
    }

    public static /* synthetic */ Object desireData$default(GaiaXExpression gaiaXExpression, JSON json, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                json = null;
            }
            return gaiaXExpression.desireData(json);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: desireData");
    }

    @Nullable
    public abstract Object desireData(@Nullable JSON json);

    @Override // com.alibaba.gaiax.template.GXIExpression
    @NotNull
    public Object expression() {
        return "";
    }

    @Override // com.alibaba.gaiax.template.GXIExpression
    @Nullable
    public Object value(@Nullable JSON json) {
        return desireData(json);
    }
}
