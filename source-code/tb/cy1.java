package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.zx1;

/* compiled from: Taobao */
public final class cy1 extends zx1 implements JavaArrayAnnotationArgument {
    @NotNull
    private final Object[] b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cy1(@Nullable og1 og1, @NotNull Object[] objArr) {
        super(og1);
        k21.i(objArr, "values");
        this.b = objArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument
    @NotNull
    public List<zx1> getElements() {
        Object[] objArr = this.b;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            zx1.a aVar = zx1.Factory;
            k21.f(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
