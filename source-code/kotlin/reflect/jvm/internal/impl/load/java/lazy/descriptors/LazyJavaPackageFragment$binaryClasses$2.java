package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import org.jetbrains.annotations.NotNull;
import tb.a51;
import tb.d61;
import tb.do2;
import tb.k21;
import tb.oi;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaPackageFragment$binaryClasses$2 extends Lambda implements Function0<Map<String, ? extends KotlinJvmBinaryClass>> {
    final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaPackageFragment$binaryClasses$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    /* Return type fixed from 'java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Map<String, ? extends KotlinJvmBinaryClass> invoke() {
        PackagePartProvider n = this.this$0.g.a().n();
        String b = this.this$0.getFqName().b();
        k21.h(b, "fqName.asString()");
        List<String> findPackageParts = n.findPackageParts(b);
        LazyJavaPackageFragment lazyJavaPackageFragment = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (T t : findPackageParts) {
            oi m = oi.m(a51.d(t).e());
            k21.h(m, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
            KotlinJvmBinaryClass b2 = d61.b(lazyJavaPackageFragment.g.a().i(), m);
            Pair a = b2 == null ? null : do2.a(t, b2);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return x.r(arrayList);
    }
}
