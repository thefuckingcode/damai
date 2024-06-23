package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.k21;
import tb.p50;
import tb.r01;
import tb.rf;
import tb.vo2;
import tb.xo2;

/* compiled from: Taobao */
public final class CapturedTypeConstructorKt {

    /* compiled from: Taobao */
    public static final class a extends p50 {
        final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(boolean z, xo2 xo2) {
            super(xo2);
            this.b = z;
        }

        @Override // tb.xo2
        public boolean b() {
            return this.b;
        }

        @Override // tb.p50, tb.xo2
        @Nullable
        public TypeProjection e(@NotNull g61 g61) {
            k21.i(g61, "key");
            TypeProjection e = super.e(g61);
            TypeParameterDescriptor typeParameterDescriptor = null;
            if (e == null) {
                return null;
            }
            ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
            if (declarationDescriptor instanceof TypeParameterDescriptor) {
                typeParameterDescriptor = (TypeParameterDescriptor) declarationDescriptor;
            }
            return CapturedTypeConstructorKt.b(e, typeParameterDescriptor);
        }
    }

    /* access modifiers changed from: private */
    public static final TypeProjection b(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || typeProjection.getProjectionKind() == Variance.INVARIANT) {
            return typeProjection;
        }
        if (typeParameterDescriptor.getVariance() != typeProjection.getProjectionKind()) {
            return new vo2(c(typeProjection));
        }
        if (!typeProjection.isStarProjection()) {
            return new vo2(typeProjection.getType());
        }
        StorageManager storageManager = LockBasedStorageManager.NO_LOCKS;
        k21.h(storageManager, "NO_LOCKS");
        return new vo2(new LazyWrappedType(storageManager, new CapturedTypeConstructorKt$createCapturedIfNeeded$1(typeProjection)));
    }

    @NotNull
    public static final g61 c(@NotNull TypeProjection typeProjection) {
        k21.i(typeProjection, "typeProjection");
        return new rf(typeProjection, null, false, null, 14, null);
    }

    public static final boolean d(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        return g61.c() instanceof CapturedTypeConstructor;
    }

    @NotNull
    public static final xo2 e(@NotNull xo2 xo2, boolean z) {
        k21.i(xo2, "<this>");
        if (!(xo2 instanceof r01)) {
            return new a(z, xo2);
        }
        r01 r01 = (r01) xo2;
        TypeParameterDescriptor[] i = r01.i();
        List<Pair> list = ArraysKt___ArraysKt.l0(r01.h(), r01.i());
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (Pair pair : list) {
            arrayList.add(b((TypeProjection) pair.getFirst(), (TypeParameterDescriptor) pair.getSecond()));
        }
        Object[] array = arrayList.toArray(new TypeProjection[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return new r01(i, (TypeProjection[]) array, z);
    }

    public static /* synthetic */ xo2 f(xo2 xo2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return e(xo2, z);
    }
}
