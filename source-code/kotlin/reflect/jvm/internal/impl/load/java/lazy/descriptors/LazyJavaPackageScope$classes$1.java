package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d61;
import tb.en0;
import tb.k21;
import tb.oi;
import tb.x61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaPackageScope$classes$1 extends Lambda implements Function1<LazyJavaPackageScope.a, ClassDescriptor> {
    final /* synthetic */ x61 $c;
    final /* synthetic */ LazyJavaPackageScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaPackageScope$classes$1(LazyJavaPackageScope lazyJavaPackageScope, x61 x61) {
        super(1);
        this.this$0 = lazyJavaPackageScope;
        this.$c = x61;
    }

    @Nullable
    public final ClassDescriptor invoke(@NotNull LazyJavaPackageScope.a aVar) {
        KotlinClassFinder.a aVar2;
        KotlinJvmBinaryClass kotlinJvmBinaryClass;
        oi oiVar;
        LightClassOriginKind lightClassOriginKind;
        en0 en0;
        byte[] bArr;
        k21.i(aVar, "request");
        oi oiVar2 = new oi(this.this$0.v().getFqName(), aVar.b());
        if (aVar.a() != null) {
            aVar2 = this.$c.a().i().findKotlinClassOrContent(aVar.a());
        } else {
            aVar2 = this.$c.a().i().findKotlinClassOrContent(oiVar2);
        }
        if (aVar2 == null) {
            kotlinJvmBinaryClass = null;
        } else {
            kotlinJvmBinaryClass = aVar2.a();
        }
        if (kotlinJvmBinaryClass == null) {
            oiVar = null;
        } else {
            oiVar = kotlinJvmBinaryClass.getClassId();
        }
        if (oiVar != null && (oiVar.l() || oiVar.k())) {
            return null;
        }
        LazyJavaPackageScope.b bVar = this.this$0.K(kotlinJvmBinaryClass);
        if (bVar instanceof LazyJavaPackageScope.b.a) {
            return ((LazyJavaPackageScope.b.a) bVar).a();
        }
        if (bVar instanceof LazyJavaPackageScope.b.c) {
            return null;
        }
        if (bVar instanceof LazyJavaPackageScope.b.C0272b) {
            JavaClass a = aVar.a();
            if (a == null) {
                JavaClassFinder d = this.$c.a().d();
                if (aVar2 != null) {
                    if (!(aVar2 instanceof KotlinClassFinder.a.C0275a)) {
                        aVar2 = null;
                    }
                    KotlinClassFinder.a.C0275a aVar3 = (KotlinClassFinder.a.C0275a) aVar2;
                    if (aVar3 != null) {
                        bArr = aVar3.b();
                        a = d.findClass(new JavaClassFinder.a(oiVar2, bArr, null, 4, null));
                    }
                }
                bArr = null;
                a = d.findClass(new JavaClassFinder.a(oiVar2, bArr, null, 4, null));
            }
            if (a == null) {
                lightClassOriginKind = null;
            } else {
                lightClassOriginKind = a.getLightClassOriginKind();
            }
            if (lightClassOriginKind != LightClassOriginKind.BINARY) {
                if (a == null) {
                    en0 = null;
                } else {
                    en0 = a.getFqName();
                }
                if (en0 == null || en0.d() || !k21.d(en0.e(), this.this$0.v().getFqName())) {
                    return null;
                }
                LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.$c, this.this$0.v(), a, null, 8, null);
                this.$c.a().e().reportClass(lazyJavaClassDescriptor);
                return lazyJavaClassDescriptor;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + a + "\nClassId: " + oiVar2 + "\nfindKotlinClass(JavaClass) = " + d61.a(this.$c.a().i(), a) + "\nfindKotlinClass(ClassId) = " + d61.b(this.$c.a().i(), oiVar2) + '\n');
        }
        throw new NoWhenBranchMatchedException();
    }
}
