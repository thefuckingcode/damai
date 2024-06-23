package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.k21;
import tb.og1;
import tb.oi;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class NotFoundClasses$classes$1 extends Lambda implements Function1<NotFoundClasses.a, ClassDescriptor> {
    final /* synthetic */ NotFoundClasses this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotFoundClasses$classes$1(NotFoundClasses notFoundClasses) {
        super(1);
        this.this$0 = notFoundClasses;
    }

    @NotNull
    public final ClassDescriptor invoke(@NotNull NotFoundClasses.a aVar) {
        ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor;
        k21.i(aVar, "$dstr$classId$typeParametersCount");
        oi a = aVar.a();
        List<Integer> b = aVar.b();
        if (!a.k()) {
            oi g = a.g();
            if (g == null) {
                classOrPackageFragmentDescriptor = null;
            } else {
                classOrPackageFragmentDescriptor = this.this$0.d(g, CollectionsKt___CollectionsKt.L(b, 1));
            }
            if (classOrPackageFragmentDescriptor == null) {
                MemoizedFunctionToNotNull memoizedFunctionToNotNull = this.this$0.c;
                en0 h = a.h();
                k21.h(h, "classId.packageFqName");
                classOrPackageFragmentDescriptor = (ClassOrPackageFragmentDescriptor) memoizedFunctionToNotNull.invoke(h);
            }
            boolean l = a.l();
            StorageManager storageManager = this.this$0.a;
            og1 j = a.j();
            k21.h(j, "classId.shortClassName");
            Integer num = (Integer) k.R(b);
            return new NotFoundClasses.b(storageManager, classOrPackageFragmentDescriptor, j, l, num == null ? 0 : num.intValue());
        }
        throw new UnsupportedOperationException(k21.r("Unresolved local class: ", a));
    }
}
