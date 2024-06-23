package tb;

import com.alibaba.poplayer.layermanager.config.ConfigItem;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public final class ac {
    public Map<String, ConfigItem> a = new HashMap();

    public ConfigItem a(String str) {
        return this.a.get(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(jl1.BLOCK_START_STR);
        for (String str : this.a.keySet()) {
            sb.append(jl1.BLOCK_START_STR);
            sb.append(str);
            sb.append(":");
            sb.append(this.a.get(str).toString());
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}
