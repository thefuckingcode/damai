package tb;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/* compiled from: Taobao */
public class oz extends lx {
    protected Object d;

    public oz(long j, int i, Object obj, long j2) {
        super(j);
        this.d = obj;
        HashMap hashMap = new HashMap();
        hashMap.put("index", ey.J((long) i));
        if (obj instanceof JSONObject) {
            hashMap.put("data", ey.M((JSONObject) obj));
        } else if (obj instanceof Object) {
            hashMap.put("data", ey.K(obj));
        }
        hashMap.put("duration", ey.J(j2));
        d(hashMap);
    }
}
