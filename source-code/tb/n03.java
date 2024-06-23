package tb;

import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public class n03 extends n20 {
    public Set<String> b;

    public void a(String str) {
        if (str != null) {
            if (this.b == null) {
                this.b = new HashSet();
            }
            if (!this.b.contains(str)) {
                this.b.add(str);
            }
        }
    }
}
