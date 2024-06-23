package com.youku.gaiax.impl.register;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.po0;
import tb.yo0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionDataBinding;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDataBinding;", "", "expVersion", "", "data", "Ltb/po0;", "createDataBinding", "value", "create", "<init>", "()V", "GaiaXYKDataBinding", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXExtensionDataBinding implements GXRegisterCenter.GXIExtensionDataBinding {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\tR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionDataBinding$GaiaXYKDataBinding;", "Ltb/po0;", "Lcom/alibaba/fastjson/JSONObject;", "templateData", "getData", "Lcom/alibaba/gaiax/template/GXIExpression;", "url", "Lcom/alibaba/gaiax/template/GXIExpression;", "getUrl", "()Lcom/alibaba/gaiax/template/GXIExpression;", "summary", "getSummary", "summaryType", "getSummaryType", "summaryColor", "getSummaryColor", "rank", "getRank", "mark", "getMark", "value", "accessibilityDesc", "accessibilityEnable", Constants.Name.PLACEHOLDER, "", "", "extend", "<init>", "(Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Lcom/alibaba/gaiax/template/GXIExpression;Ljava/util/Map;)V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class GaiaXYKDataBinding extends po0 {
        @Nullable
        private final GXIExpression mark;
        @Nullable
        private final GXIExpression rank;
        @Nullable
        private final GXIExpression summary;
        @Nullable
        private final GXIExpression summaryColor;
        @Nullable
        private final GXIExpression summaryType;
        @Nullable
        private final GXIExpression url;

        public GaiaXYKDataBinding() {
            this(null, null, null, null, null, null, null, null, null, null, null, UCCore.SPEEDUP_DEXOPT_POLICY_ALL, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GaiaXYKDataBinding(GXIExpression gXIExpression, GXIExpression gXIExpression2, GXIExpression gXIExpression3, GXIExpression gXIExpression4, GXIExpression gXIExpression5, GXIExpression gXIExpression6, GXIExpression gXIExpression7, GXIExpression gXIExpression8, GXIExpression gXIExpression9, GXIExpression gXIExpression10, Map map, int i, m40 m40) {
            this((i & 1) != 0 ? null : gXIExpression, (i & 2) != 0 ? null : gXIExpression2, (i & 4) != 0 ? null : gXIExpression3, (i & 8) != 0 ? null : gXIExpression4, (i & 16) != 0 ? null : gXIExpression5, (i & 32) != 0 ? null : gXIExpression6, (i & 64) != 0 ? null : gXIExpression7, (i & 128) != 0 ? null : gXIExpression8, (i & 256) != 0 ? null : gXIExpression9, (i & 512) != 0 ? null : gXIExpression10, (i & 1024) == 0 ? map : null);
        }

        @Override // tb.po0
        @Nullable
        public JSONObject getData(@NotNull JSONObject jSONObject) {
            JSONObject jSONObject2;
            Object value;
            Object value2;
            Object value3;
            Object value4;
            Object value5;
            Object value6;
            Object value7;
            Object value8;
            Object value9;
            Object value10;
            k21.i(jSONObject, "templateData");
            GXIExpression gXIExpression = this.url;
            if (gXIExpression == null || (value10 = gXIExpression.value(jSONObject)) == null) {
                jSONObject2 = null;
            } else {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("value", value10);
                jSONObject2 = jSONObject3;
            }
            GXIExpression gXIExpression2 = this.summary;
            if (!(gXIExpression2 == null || (value9 = gXIExpression2.value(jSONObject)) == null)) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject2.put("summary", value9);
            }
            GXIExpression gXIExpression3 = this.summaryType;
            if (!(gXIExpression3 == null || (value8 = gXIExpression3.value(jSONObject)) == null)) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject2.put("summary-type", value8);
            }
            GXIExpression gXIExpression4 = this.summaryColor;
            if (!(gXIExpression4 == null || (value7 = gXIExpression4.value(jSONObject)) == null)) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject2.put("summary-color", value7);
            }
            GXIExpression gXIExpression5 = this.rank;
            if (!(gXIExpression5 == null || (value6 = gXIExpression5.value(jSONObject)) == null)) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject2.put("rank", value6);
            }
            GXIExpression gXIExpression6 = this.mark;
            if (!(gXIExpression6 == null || (value5 = gXIExpression6.value(jSONObject)) == null || !(value5 instanceof JSONObject))) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = (JSONObject) value5;
                String string = jSONObject5.getString("type");
                if (string != null) {
                    jSONObject4.put((Object) "type", (Object) string);
                }
                JSONObject jSONObject6 = new JSONObject();
                String string2 = jSONObject5.getString("text");
                if (string2 != null) {
                    jSONObject6.put((Object) "text", (Object) string2);
                }
                String string3 = jSONObject5.getString("color");
                if (string3 != null) {
                    jSONObject6.put((Object) "color", (Object) string3);
                }
                String string4 = jSONObject5.getString("img");
                if (string4 != null) {
                    jSONObject6.put((Object) "img", (Object) string4);
                }
                if (!jSONObject6.isEmpty()) {
                    jSONObject4.put((Object) "data", (Object) jSONObject6);
                }
                if (!jSONObject4.isEmpty()) {
                    jSONObject2.put("mark", (Object) jSONObject4);
                }
            }
            GXIExpression value11 = getValue();
            if (!(value11 == null || (value4 = value11.value(jSONObject)) == null)) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject2.put("value", value4);
            }
            GXIExpression placeholder = getPlaceholder();
            if (!(placeholder == null || (value3 = placeholder.value(jSONObject)) == null)) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject2.put(Constants.Name.PLACEHOLDER, value3);
            }
            GXIExpression accessibilityEnable = getAccessibilityEnable();
            if (!(accessibilityEnable == null || (value2 = accessibilityEnable.value(jSONObject)) == null)) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject2.put("accessibilityEnable", value2);
            }
            GXIExpression accessibilityDesc = getAccessibilityDesc();
            if (!(accessibilityDesc == null || (value = accessibilityDesc.value(jSONObject)) == null)) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject2.put("accessibilityDesc", value);
            }
            return jSONObject2;
        }

        @Nullable
        public final GXIExpression getMark() {
            return this.mark;
        }

        @Nullable
        public final GXIExpression getRank() {
            return this.rank;
        }

        @Nullable
        public final GXIExpression getSummary() {
            return this.summary;
        }

        @Nullable
        public final GXIExpression getSummaryColor() {
            return this.summaryColor;
        }

        @Nullable
        public final GXIExpression getSummaryType() {
            return this.summaryType;
        }

        @Nullable
        public final GXIExpression getUrl() {
            return this.url;
        }

        public GaiaXYKDataBinding(@Nullable GXIExpression gXIExpression, @Nullable GXIExpression gXIExpression2, @Nullable GXIExpression gXIExpression3, @Nullable GXIExpression gXIExpression4, @Nullable GXIExpression gXIExpression5, @Nullable GXIExpression gXIExpression6, @Nullable GXIExpression gXIExpression7, @Nullable GXIExpression gXIExpression8, @Nullable GXIExpression gXIExpression9, @Nullable GXIExpression gXIExpression10, @Nullable Map<String, GXIExpression> map) {
            super(gXIExpression7, gXIExpression8, gXIExpression9, gXIExpression10, map);
            this.url = gXIExpression;
            this.summary = gXIExpression2;
            this.summaryType = gXIExpression3;
            this.summaryColor = gXIExpression4;
            this.rank = gXIExpression5;
            this.mark = gXIExpression6;
        }
    }

    private final po0 createDataBinding(String str, Object obj) {
        GXIExpression b;
        LinkedHashMap linkedHashMap = null;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString("url");
            String string2 = jSONObject.getString("summary");
            String string3 = jSONObject.getString("summary-type");
            String string4 = jSONObject.getString("summary-color");
            String string5 = jSONObject.getString("rank");
            JSONObject jSONObject2 = jSONObject.getJSONObject("mark");
            String string6 = jSONObject.getString("value");
            String string7 = jSONObject.getString(Constants.Name.PLACEHOLDER);
            String string8 = jSONObject.getString("accessibilityDesc");
            String string9 = jSONObject.getString("accessibilityEnable");
            JSONObject jSONObject3 = jSONObject.getJSONObject("extend");
            yo0 yo0 = yo0.INSTANCE;
            GXIExpression b2 = yo0.b(str, string);
            GXIExpression b3 = yo0.b(str, string2);
            GXIExpression b4 = yo0.b(str, string3);
            GXIExpression b5 = yo0.b(str, string4);
            GXIExpression b6 = yo0.b(str, string5);
            GXIExpression b7 = yo0.b(str, jSONObject2);
            GXIExpression b8 = yo0.b(str, string6);
            GXIExpression b9 = yo0.b(str, string7);
            GXIExpression b10 = yo0.b(str, string8);
            GXIExpression b11 = yo0.b(str, string9);
            if (jSONObject3 != null && (!jSONObject3.isEmpty())) {
                linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : jSONObject3.entrySet()) {
                    if (!(entry.getKey() == null || entry.getValue() == null || (b = yo0.INSTANCE.b(str, entry.getValue())) == null)) {
                        Object key = entry.getKey();
                        k21.h(key, "entry.key");
                        linkedHashMap.put(key, b);
                    }
                }
            }
            return new GaiaXYKDataBinding(b2, b3, b4, b5, b6, b7, b8, b10, b11, b9, linkedHashMap);
        } else if (obj instanceof String) {
            return new GaiaXYKDataBinding(yo0.INSTANCE.b(str, obj), null, null, null, null, null, null, null, null, null, null, 2046, null);
        } else {
            return null;
        }
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionDataBinding
    @Nullable
    public po0 create(@Nullable String str, @NotNull Object obj) {
        k21.i(obj, "value");
        return createDataBinding(str, obj);
    }
}
