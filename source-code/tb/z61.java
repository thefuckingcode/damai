package tb;

import com.huawei.hms.opendevice.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class z61 extends r1 {
    @NotNull
    private final x61 k;
    @NotNull
    private final JavaTypeParameter l;
    @NotNull
    private final LazyJavaAnnotations m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z61(@NotNull x61 x61, @NotNull JavaTypeParameter javaTypeParameter, int i, @NotNull DeclarationDescriptor declarationDescriptor) {
        super(x61.e(), declarationDescriptor, javaTypeParameter.getName(), Variance.INVARIANT, false, i, SourceElement.NO_SOURCE, x61.a().u());
        k21.i(x61, c.a);
        k21.i(javaTypeParameter, "javaTypeParameter");
        k21.i(declarationDescriptor, "containingDeclaration");
        this.k = x61;
        this.l = javaTypeParameter;
        this.m = new LazyJavaAnnotations(x61, javaTypeParameter, false, 4, null);
    }

    private final List<g61> g() {
        Collection<JavaClassifierType> upperBounds = this.l.getUpperBounds();
        if (upperBounds.isEmpty()) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            ib2 i = this.k.d().getBuiltIns().i();
            k21.h(i, "c.module.builtIns.anyType");
            ib2 I = this.k.d().getBuiltIns().I();
            k21.h(I, "c.module.builtIns.nullableAnyType");
            return l.e(KotlinTypeFactory.d(i, I));
        }
        ArrayList arrayList = new ArrayList(n.q(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(this.k.g().n(it.next(), JavaTypeResolverKt.f(TypeUsage.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // tb.n2
    @NotNull
    public List<g61> d(@NotNull List<? extends g61> list) {
        k21.i(list, "bounds");
        return this.k.a().q().g(this, list, this.k);
    }

    /* access modifiers changed from: protected */
    @Override // tb.n2
    public void e(@NotNull g61 g61) {
        k21.i(g61, "type");
    }

    /* access modifiers changed from: protected */
    @Override // tb.n2
    @NotNull
    public List<g61> f() {
        return g();
    }

    @NotNull
    /* renamed from: h */
    public LazyJavaAnnotations getAnnotations() {
        return this.m;
    }
}
