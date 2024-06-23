package tb;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: Taobao */
public class et {
    public Object a;
    public String b;
    public Map<Object, Object> c;

    public boolean a(et etVar) {
        return etVar != null && !TextUtils.isEmpty(this.b) && this.b.equals(etVar.b) && this.a == etVar.a;
    }
}
