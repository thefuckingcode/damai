package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class bh0 {
    @NotNull
    public static final bh0 INSTANCE = new bh0();

    private bh0() {
    }

    @NotNull
    public final JSONObject a(@Nullable String str) {
        try {
            JSONObject parseObject = JSON.parseObject(str);
            k21.h(parseObject, "{\n            JSON.parseObject(text)\n        }");
            return parseObject;
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public final <T> T b(@Nullable String str, @Nullable TypeReference<T> typeReference) {
        return (T) JSON.parseObject(str, typeReference, new Feature[0]);
    }

    public final <T> T c(@Nullable String str, @Nullable Class<T> cls) {
        return (T) JSON.parseObject(str, cls);
    }

    @NotNull
    public final <T> String d(T t) {
        String jSONString = JSON.toJSONString(t);
        k21.h(jSONString, "toJSONString(`object`)");
        return jSONString;
    }

    @NotNull
    public final String e(@Nullable Object obj) {
        String str;
        if (obj == null) {
            str = null;
        } else {
            try {
                str = JSON.toJSONString(obj);
            } catch (Exception unused) {
                return "";
            }
        }
        return str == null ? "" : str;
    }

    @Nullable
    public final <T> T f(@Nullable JSON json, @Nullable Class<T> cls) {
        if (json == null) {
            return null;
        }
        try {
            return (T) INSTANCE.c(json.toJSONString(), cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
