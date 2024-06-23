package tb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.x;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedType;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class cs2 {
    @NotNull
    public static final cs2 INSTANCE = new cs2();
    @NotNull
    private static final Set<og1> a;
    @NotNull
    private static final HashMap<oi, oi> b = new HashMap<>();
    @NotNull
    private static final HashMap<oi, oi> c = new HashMap<>();
    @NotNull
    private static final Set<og1> d;

    static {
        UnsignedType[] values = UnsignedType.values();
        ArrayList arrayList = new ArrayList(values.length);
        int i = 0;
        for (UnsignedType unsignedType : values) {
            arrayList.add(unsignedType.getTypeName());
        }
        a = CollectionsKt___CollectionsKt.C0(arrayList);
        UnsignedArrayType[] values2 = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (UnsignedArrayType unsignedArrayType : values2) {
            arrayList2.add(unsignedArrayType.getTypeName());
        }
        Set<T> unused = CollectionsKt___CollectionsKt.C0(arrayList2);
        HashMap<K, V> unused2 = x.k(do2.a(UnsignedArrayType.UBYTEARRAY, og1.f("ubyteArrayOf")), do2.a(UnsignedArrayType.USHORTARRAY, og1.f("ushortArrayOf")), do2.a(UnsignedArrayType.UINTARRAY, og1.f("uintArrayOf")), do2.a(UnsignedArrayType.ULONGARRAY, og1.f("ulongArrayOf")));
        UnsignedType[] values3 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType unsignedType2 : values3) {
            linkedHashSet.add(unsignedType2.getArrayClassId().j());
        }
        d = linkedHashSet;
        UnsignedType[] values4 = UnsignedType.values();
        int length = values4.length;
        while (i < length) {
            UnsignedType unsignedType3 = values4[i];
            i++;
            b.put(unsignedType3.getArrayClassId(), unsignedType3.getClassId());
            c.put(unsignedType3.getClassId(), unsignedType3.getArrayClassId());
        }
    }

    private cs2() {
    }

    @JvmStatic
    public static final boolean d(@NotNull g61 g61) {
        ClassifierDescriptor declarationDescriptor;
        k21.i(g61, "type");
        if (!bp2.v(g61) && (declarationDescriptor = g61.c().getDeclarationDescriptor()) != null) {
            return INSTANCE.c(declarationDescriptor);
        }
        return false;
    }

    @Nullable
    public final oi a(@NotNull oi oiVar) {
        k21.i(oiVar, "arrayClassId");
        return b.get(oiVar);
    }

    public final boolean b(@NotNull og1 og1) {
        k21.i(og1, "name");
        return d.contains(og1);
    }

    public final boolean c(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "descriptor");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        return (containingDeclaration instanceof PackageFragmentDescriptor) && k21.d(((PackageFragmentDescriptor) containingDeclaration).getFqName(), c.BUILT_INS_PACKAGE_FQ_NAME) && a.contains(declarationDescriptor.getName());
    }
}
