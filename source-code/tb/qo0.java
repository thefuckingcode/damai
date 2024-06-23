package tb;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.weex.common.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class qo0 {
    @NotNull
    public static final qo0 INSTANCE = new qo0();

    private qo0() {
    }

    private final po0 b(String str, Object obj) {
        LinkedHashMap linkedHashMap;
        GXIExpression b;
        if (!(obj instanceof JSONObject)) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        String string = jSONObject.getString("value");
        String string2 = jSONObject.getString(Constants.Name.PLACEHOLDER);
        String string3 = jSONObject.getString("accessibilityDesc");
        String string4 = jSONObject.getString("accessibilityEnable");
        JSONObject jSONObject2 = jSONObject.getJSONObject("extend");
        yo0 yo0 = yo0.INSTANCE;
        GXIExpression b2 = yo0.b(str, string);
        GXIExpression b3 = yo0.b(str, string2);
        GXIExpression b4 = yo0.b(str, string3);
        GXIExpression b5 = yo0.b(str, string4);
        if (jSONObject2 == null || !(!jSONObject2.isEmpty())) {
            linkedHashMap = null;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : jSONObject2.entrySet()) {
                if (!(entry.getKey() == null || entry.getValue() == null || (b = yo0.INSTANCE.b(str, entry.getValue())) == null)) {
                    Object key = entry.getKey();
                    k21.h(key, "entry.key");
                    linkedHashMap2.put(key, b);
                }
            }
            linkedHashMap = linkedHashMap2;
        }
        if (b2 == null && b3 == null && b4 == null && b5 == null && linkedHashMap == null) {
            return null;
        }
        return new po0(b2, b4, b5, b3, linkedHashMap);
    }

    @Nullable
    public final po0 a(@Nullable String str, @NotNull Object obj) {
        po0 create;
        k21.i(obj, "data");
        GXRegisterCenter.GXIExtensionDataBinding g = GXRegisterCenter.Companion.a().g();
        return (g == null || (create = g.create(str, obj)) == null) ? b(str, obj) : create;
    }
}
