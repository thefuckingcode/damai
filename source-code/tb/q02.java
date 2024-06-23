package tb;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public class q02 extends p02<q02> {
    private String j;

    private q02(String str) {
        super("ResourceUse", str);
    }

    public static q02 f(String str) {
        return new q02(str);
    }

    public void g(Set<String> set, Set<String> set2) {
        HashSet hashSet = new HashSet();
        if (set != null) {
            hashSet.addAll(set);
        }
        hashSet.add("action");
        HashSet hashSet2 = new HashSet();
        if (set2 != null) {
            hashSet2.addAll(set2);
        }
        a(hashSet, hashSet2);
    }

    public void h() {
        DimensionValueSet create = DimensionValueSet.create();
        String str = this.j;
        if (str != null) {
            create.setValue("action", str);
        } else {
            create.setValue("action", "-");
        }
        b(create, null);
    }
}
