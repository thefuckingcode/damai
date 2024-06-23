package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.weex.common.Constants;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class po0 {
    @Nullable
    private final GXIExpression accessibilityDesc;
    @Nullable
    private final GXIExpression accessibilityEnable;
    @Nullable
    private final Map<String, GXIExpression> extend;
    @Nullable
    private final GXIExpression placeholder;
    @Nullable
    private GXIExpression value;

    public po0() {
        this(null, null, null, null, null, 31, null);
    }

    public po0(@Nullable GXIExpression gXIExpression, @Nullable GXIExpression gXIExpression2, @Nullable GXIExpression gXIExpression3, @Nullable GXIExpression gXIExpression4, @Nullable Map<String, GXIExpression> map) {
        this.value = gXIExpression;
        this.accessibilityDesc = gXIExpression2;
        this.accessibilityEnable = gXIExpression3;
        this.placeholder = gXIExpression4;
        this.extend = map;
    }

    @Nullable
    public final GXIExpression getAccessibilityDesc() {
        return this.accessibilityDesc;
    }

    @Nullable
    public final GXIExpression getAccessibilityEnable() {
        return this.accessibilityEnable;
    }

    @Nullable
    public JSONObject getData(@NotNull JSONObject jSONObject) {
        JSONObject jSONObject2;
        Object value2;
        Object value3;
        Object value4;
        Object value5;
        k21.i(jSONObject, "templateData");
        GXIExpression gXIExpression = this.value;
        if (gXIExpression == null || (value5 = gXIExpression.value(jSONObject)) == null) {
            jSONObject2 = null;
        } else {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("value", value5);
            jSONObject2 = jSONObject3;
        }
        GXIExpression gXIExpression2 = this.placeholder;
        if (!(gXIExpression2 == null || (value4 = gXIExpression2.value(jSONObject)) == null)) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put(Constants.Name.PLACEHOLDER, value4);
        }
        GXIExpression gXIExpression3 = this.accessibilityDesc;
        if (!(gXIExpression3 == null || (value3 = gXIExpression3.value(jSONObject)) == null)) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("accessibilityDesc", value3);
        }
        GXIExpression gXIExpression4 = this.accessibilityEnable;
        if (!(gXIExpression4 == null || (value2 = gXIExpression4.value(jSONObject)) == null)) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("accessibilityEnable", value2);
        }
        JSONObject extend2 = getExtend(jSONObject);
        if (extend2 != null) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("extend", (Object) extend2);
        }
        return jSONObject2;
    }

    @Nullable
    public final Map<String, GXIExpression> getExtend() {
        return this.extend;
    }

    @Nullable
    public final GXIExpression getPlaceholder() {
        return this.placeholder;
    }

    @Nullable
    public final GXIExpression getValue() {
        return this.value;
    }

    public final void setValue(@Nullable GXIExpression gXIExpression) {
        this.value = gXIExpression;
    }

    @Nullable
    public JSONObject getExtend(@Nullable JSON json) {
        Map<String, GXIExpression> map = this.extend;
        JSONObject jSONObject = null;
        if (map != null) {
            for (Map.Entry<String, GXIExpression> entry : map.entrySet()) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                jSONObject.put((Object) entry.getKey(), entry.getValue().value(json));
            }
        }
        return jSONObject;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ po0(GXIExpression gXIExpression, GXIExpression gXIExpression2, GXIExpression gXIExpression3, GXIExpression gXIExpression4, Map map, int i, m40 m40) {
        this((i & 1) != 0 ? null : gXIExpression, (i & 2) != 0 ? null : gXIExpression2, (i & 4) != 0 ? null : gXIExpression3, (i & 8) != 0 ? null : gXIExpression4, (i & 16) != 0 ? null : map);
    }
}
