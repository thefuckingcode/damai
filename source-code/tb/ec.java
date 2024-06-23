package tb;

import com.alibaba.fastjson.JSONArray;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ec extends vm2 {
    private List<vm2> c;

    public ec(List<vm2> list, int i) {
        super("", i);
        this.c = list;
    }

    @Override // tb.vm2
    public Object a(Object obj) {
        if (c() == 7) {
            List<vm2> list = this.c;
            if (list == null || list.size() == 0) {
                return new JSONArray(4);
            }
            JSONArray jSONArray = new JSONArray(this.c.size());
            for (int i = 0; i < this.c.size(); i++) {
                vm2 vm2 = this.c.get(i);
                if (vm2 == null) {
                    jSONArray.add(null);
                } else {
                    jSONArray.add(vm2.a(obj));
                }
            }
            return jSONArray;
        }
        List<vm2> list2 = this.c;
        if (list2 == null || list2.size() == 0) {
            return null;
        }
        return this.c.get(0).a(obj);
    }

    @Override // tb.vm2
    public String toString() {
        if (c() == 7) {
            return "" + this.c + "";
        }
        List<vm2> list = this.c;
        if (list == null || list.size() != 1) {
            return jl1.BLOCK_START_STR + this.c + '}';
        }
        return jl1.BLOCK_START_STR + this.c.get(0) + '}';
    }
}
