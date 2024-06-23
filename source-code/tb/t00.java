package tb;

import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class t00 {
    private int a;
    private Map<String, Integer> b = new HashMap();

    public t00(int i) {
        this.a = i;
    }

    public DXTemplateItem a(String str, long j, DXTemplateItem dXTemplateItem) {
        int i;
        if (this.a == 1) {
            return u00.f().h(str, j, dXTemplateItem);
        }
        Integer num = this.b.get(dXTemplateItem.name);
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        if (i >= this.a) {
            return u00.f().h(str, j, dXTemplateItem);
        }
        return u00.f().e(str, j, dXTemplateItem);
    }

    public void b(int i) {
        this.a = i;
    }

    public void c(String str, long j, DXTemplateItem dXTemplateItem) {
        int i;
        Integer num = this.b.get(dXTemplateItem.name);
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        int a2 = u00.f().a(str, j, dXTemplateItem);
        if (a2 == 1) {
            this.b.put(dXTemplateItem.name, Integer.valueOf(i + 1));
        } else if (a2 == 2) {
            this.b.put(dXTemplateItem.name, Integer.valueOf(this.a));
        }
    }
}
