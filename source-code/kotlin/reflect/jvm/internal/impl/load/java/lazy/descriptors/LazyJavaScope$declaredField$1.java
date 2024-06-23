package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaScope$declaredField$1 extends Lambda implements Function1<og1, PropertyDescriptor> {
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaScope$declaredField$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.this$0 = lazyJavaScope;
    }

    @Nullable
    public final PropertyDescriptor invoke(@NotNull og1 og1) {
        k21.i(og1, "name");
        if (this.this$0.u() != null) {
            return (PropertyDescriptor) this.this$0.u().f.invoke(og1);
        }
        JavaField findFieldByName = ((DeclaredMemberIndex) this.this$0.r().invoke()).findFieldByName(og1);
        if (findFieldByName == null || findFieldByName.isEnumEntry()) {
            return null;
        }
        return this.this$0.C(findFieldByName);
    }
}
