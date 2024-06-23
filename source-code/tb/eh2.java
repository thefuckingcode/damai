package tb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.l;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class eh2 {
    @NotNull
    private static final eg1 a;
    @NotNull
    private static final eg1 b;

    static {
        ModuleDescriptor q = me0.q();
        k21.h(q, "getErrorModule()");
        kd0 kd0 = new kd0(q, c.COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL);
        ClassKind classKind = ClassKind.INTERFACE;
        og1 g = c.CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL.g();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        StorageManager storageManager = LockBasedStorageManager.NO_LOCKS;
        eg1 eg1 = new eg1(kd0, classKind, false, false, g, sourceElement, storageManager);
        Modality modality = Modality.ABSTRACT;
        eg1.g(modality);
        h60 h60 = g60.PUBLIC;
        eg1.i(h60);
        Annotations.a aVar = Annotations.Companion;
        Annotations b2 = aVar.b();
        Variance variance = Variance.IN_VARIANCE;
        eg1.h(l.e(so2.l(eg1, b2, false, variance, og1.f("T"), 0, storageManager)));
        eg1.e();
        a = eg1;
        ModuleDescriptor q2 = me0.q();
        k21.h(q2, "getErrorModule()");
        eg1 eg12 = new eg1(new kd0(q2, c.COROUTINES_PACKAGE_FQ_NAME_RELEASE), classKind, false, false, c.CONTINUATION_INTERFACE_FQ_NAME_RELEASE.g(), sourceElement, storageManager);
        eg12.g(modality);
        eg12.i(h60);
        eg12.h(l.e(so2.l(eg12, aVar.b(), false, variance, og1.f("T"), 0, storageManager)));
        eg12.e();
        b = eg12;
    }

    public static final boolean a(@Nullable en0 en0, boolean z) {
        if (z) {
            return k21.d(en0, c.CONTINUATION_INTERFACE_FQ_NAME_RELEASE);
        }
        return k21.d(en0, c.CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL);
    }

    @NotNull
    public static final ib2 b(@NotNull g61 g61, boolean z) {
        TypeConstructor typeConstructor;
        k21.i(g61, "suspendFunType");
        rn0.o(g61);
        b e = TypeUtilsKt.e(g61);
        Annotations annotations = g61.getAnnotations();
        g61 h = rn0.h(g61);
        List<TypeProjection> j = rn0.j(g61);
        ArrayList arrayList = new ArrayList(n.q(j, 10));
        Iterator<T> it = j.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        Annotations b2 = Annotations.Companion.b();
        if (z) {
            typeConstructor = b.getTypeConstructor();
        } else {
            typeConstructor = a.getTypeConstructor();
        }
        k21.h(typeConstructor, "if (isReleaseCoroutines) FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.typeConstructor\n                    else FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.typeConstructor");
        List list = CollectionsKt___CollectionsKt.l0(arrayList, KotlinTypeFactory.i(b2, typeConstructor, l.e(TypeUtilsKt.a(rn0.i(g61))), false, null, 16, null));
        ib2 I = TypeUtilsKt.e(g61).I();
        k21.h(I, "suspendFunType.builtIns.nullableAnyType");
        return rn0.b(e, annotations, h, list, null, I, false, 64, null).j(g61.d());
    }
}
