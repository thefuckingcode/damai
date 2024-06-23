package tb;

import com.taobao.android.dinamicx.eventchain.DXAtomicEventNode;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class mx {
    private String a;
    private Map<String, DXAtomicEventNode> b;

    public mx(String str, int i) {
        this.a = str;
        this.b = new HashMap(i);
    }

    public void a(String str, DXAtomicEventNode dXAtomicEventNode) {
        this.b.put(str, dXAtomicEventNode);
    }

    public mx b() {
        mx mxVar = new mx(this.a, this.b.size());
        for (Map.Entry<String, DXAtomicEventNode> entry : this.b.entrySet()) {
            mxVar.a(entry.getKey(), entry.getValue().h());
        }
        return mxVar;
    }

    public DXAtomicEventNode c(String str) {
        return this.b.get(str);
    }

    public String d() {
        return this.a;
    }
}
