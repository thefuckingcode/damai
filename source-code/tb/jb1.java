package tb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import tb.ko2;

/* compiled from: Taobao */
public final class jb1 {
    @NotNull
    public static final ko2 a(@NotNull ClassDescriptor classDescriptor, @NotNull ClassDescriptor classDescriptor2) {
        k21.i(classDescriptor, "from");
        k21.i(classDescriptor2, "to");
        classDescriptor.getDeclaredTypeParameters().size();
        classDescriptor2.getDeclaredTypeParameters().size();
        ko2.a aVar = ko2.Companion;
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        k21.h(declaredTypeParameters, "from.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(n.q(declaredTypeParameters, 10));
        Iterator<T> it = declaredTypeParameters.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTypeConstructor());
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classDescriptor2.getDeclaredTypeParameters();
        k21.h(declaredTypeParameters2, "to.declaredTypeParameters");
        ArrayList arrayList2 = new ArrayList(n.q(declaredTypeParameters2, 10));
        Iterator<T> it2 = declaredTypeParameters2.iterator();
        while (it2.hasNext()) {
            ib2 defaultType = it2.next().getDefaultType();
            k21.h(defaultType, "it.defaultType");
            arrayList2.add(TypeUtilsKt.a(defaultType));
        }
        return ko2.a.e(aVar, x.r(CollectionsKt___CollectionsKt.F0(arrayList, arrayList2)), false, 2, null);
    }
}
