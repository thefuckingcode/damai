package tb;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/* compiled from: Taobao */
public class pi2 extends lx {
    public pi2(long j, int i, int i2, JSONObject jSONObject, boolean z, boolean z2) {
        super(j);
        HashMap hashMap = new HashMap();
        hashMap.put("index", ey.J((long) i));
        hashMap.put("fromIndex", ey.J((long) i2));
        hashMap.put("data", ey.M(jSONObject));
        hashMap.put("isFirstSelected", ey.F(z));
        hashMap.put("isTapEvent", ey.F(z2));
        d(hashMap);
    }
}
