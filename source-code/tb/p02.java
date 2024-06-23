package tb;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashSet;
import java.util.Set;
import tb.p02;

/* compiled from: Taobao */
public abstract class p02<T extends p02> extends h20<T> {
    private String h;
    private String i;

    protected p02(String str, String str2) {
        super(str, str2);
    }

    /* access modifiers changed from: protected */
    @Override // tb.h20
    public void a(Set<String> set, Set<String> set2) {
        if (set == null) {
            set = new HashSet<>(2);
        }
        set.add("name");
        set.add("version");
        super.a(set, set2);
    }

    /* access modifiers changed from: protected */
    @Override // tb.h20
    public void b(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        if (dimensionValueSet == null) {
            dimensionValueSet = DimensionValueSet.create();
        }
        String str = this.h;
        if (str != null) {
            dimensionValueSet.setValue("name", str);
        } else {
            dimensionValueSet.setValue("name", "-");
        }
        String str2 = this.i;
        if (str2 != null) {
            dimensionValueSet.setValue("version", str2);
        } else {
            dimensionValueSet.setValue("version", "-");
        }
        super.b(dimensionValueSet, measureValueSet);
    }
}
