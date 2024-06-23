package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.mi;
import tb.og1;
import tb.oi;
import tb.w61;
import tb.x61;
import tb.zd0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements Function1<og1, mi> {
    final /* synthetic */ x61 $c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, x61 x61) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
        this.$c = x61;
    }

    @Nullable
    public final mi invoke(@NotNull og1 og1) {
        k21.i(og1, "name");
        if (!((Set) this.this$0.q.invoke()).contains(og1)) {
            JavaField javaField = (JavaField) ((Map) this.this$0.r.invoke()).get(og1);
            if (javaField == null) {
                return null;
            }
            return zd0.f(this.$c.e(), this.this$0.v(), og1, this.$c.e().createLazyValue(new LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(this.this$0)), w61.a(this.$c, javaField), this.$c.a().s().source(javaField));
        }
        JavaClassFinder d = this.$c.a().d();
        oi h = DescriptorUtilsKt.h(this.this$0.v());
        k21.f(h);
        oi d2 = h.d(og1);
        k21.h(d2, "ownerDescriptor.classId!!.createNestedClassId(name)");
        JavaClass findClass = d.findClass(new JavaClassFinder.a(d2, null, this.this$0.n, 2, null));
        if (findClass == null) {
            return null;
        }
        x61 x61 = this.$c;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(x61, this.this$0.v(), findClass, null, 8, null);
        x61.a().e().reportClass(lazyJavaClassDescriptor);
        return lazyJavaClassDescriptor;
    }
}
