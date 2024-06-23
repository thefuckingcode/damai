package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class lf2 {
    @Nullable
    public static final JSONObject a(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return JSON.parseObject(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
