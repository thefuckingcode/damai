package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1 implements DFS.Neighbors<ClassDescriptor> {
    public static final LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1 INSTANCE = new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1();

    LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1() {
    }

    @NotNull
    /* renamed from: a */
    public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor) {
        Collection<g61> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
        k21.h(supertypes, "it.typeConstructor.supertypes");
        return SequencesKt___SequencesKt.l(SequencesKt___SequencesKt.w(CollectionsKt___CollectionsKt.I(supertypes), AnonymousClass1.INSTANCE));
    }
}
