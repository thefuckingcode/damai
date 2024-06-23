package tb;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: Taobao */
public class h11 extends va {
    @Override // tb.va
    public void h(jn2 jn2) {
        CharSequence charSequence = (CharSequence) f(0);
        CharSequence charSequence2 = (CharSequence) f(1);
        if (!TextUtils.isEmpty(charSequence) && charSequence2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("value", charSequence2.toString());
            jn2.o(new f50(this.e, this.c));
            j(hashMap);
            l(hashMap);
            if ("dialog".equalsIgnoreCase(charSequence.toString()) && g()) {
                this.c.getDataManager().respondToLinkage(this.e, jn2);
            }
        }
    }
}
