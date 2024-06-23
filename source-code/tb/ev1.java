package tb;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ev1 implements ClassDataFinder {
    @NotNull
    private final NameResolver a;
    @NotNull
    private final nb b;
    @NotNull
    private final Function1<oi, SourceElement> c;
    @NotNull
    private final Map<oi, ProtoBuf$Class> d;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super tb.oi, ? extends kotlin.reflect.jvm.internal.impl.descriptors.SourceElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public ev1(@NotNull ProtoBuf$PackageFragment protoBuf$PackageFragment, @NotNull NameResolver nameResolver, @NotNull nb nbVar, @NotNull Function1<? super oi, ? extends SourceElement> function1) {
        k21.i(protoBuf$PackageFragment, "proto");
        k21.i(nameResolver, "nameResolver");
        k21.i(nbVar, "metadataVersion");
        k21.i(function1, "classSource");
        this.a = nameResolver;
        this.b = nbVar;
        this.c = function1;
        List<ProtoBuf$Class> class_List = protoBuf$PackageFragment.getClass_List();
        k21.h(class_List, "proto.class_List");
        LinkedHashMap linkedHashMap = new LinkedHashMap(ww1.a(w.e(n.q(class_List, 10)), 16));
        for (T t : class_List) {
            linkedHashMap.put(qg1.a(this.a, t.getFqName()), t);
        }
        this.d = linkedHashMap;
    }

    @NotNull
    public final Collection<oi> a() {
        return this.d.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    @Nullable
    public li findClassData(@NotNull oi oiVar) {
        k21.i(oiVar, "classId");
        ProtoBuf$Class protoBuf$Class = this.d.get(oiVar);
        if (protoBuf$Class == null) {
            return null;
        }
        return new li(this.a, protoBuf$Class, this.b, this.c.invoke(oiVar));
    }
}
