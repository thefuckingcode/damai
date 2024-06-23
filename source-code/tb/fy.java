package tb;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class fy {
    private Map<String, ey> a = new HashMap();

    public ey a(String str) {
        ey eyVar = this.a.get(str);
        return eyVar == null ? ey.L() : eyVar;
    }

    public void b(String str, ey eyVar) {
        if (str != null) {
            if (eyVar == null) {
                this.a.remove(str);
            } else {
                this.a.put(str, eyVar);
            }
        }
    }

    public String toString() {
        return "DXScriptVarObject" + this.a.toString();
    }
}
