package kotlin.reflect.jvm.internal.impl.builtins;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: UnsignedType.kt */
public final class UnsignedTypes {
    public static final UnsignedTypes INSTANCE = new UnsignedTypes();
    private static final HashMap<ClassId, ClassId> arrayClassIdToUnsignedClassId = new HashMap<>();
    private static final Set<Name> arrayClassesShortNames;
    private static final HashMap<ClassId, ClassId> unsignedClassIdToArrayClassId = new HashMap<>();
    private static final Set<Name> unsignedTypeNames;

    static {
        UnsignedType[] values = UnsignedType.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (UnsignedType unsignedType : values) {
            arrayList.add(unsignedType.getTypeName());
        }
        unsignedTypeNames = CollectionsKt.toSet(arrayList);
        UnsignedType[] values2 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType unsignedType2 : values2) {
            linkedHashSet.add(unsignedType2.getArrayClassId().getShortClassName());
        }
        arrayClassesShortNames = linkedHashSet;
        UnsignedType[] values3 = UnsignedType.values();
        for (UnsignedType unsignedType3 : values3) {
            arrayClassIdToUnsignedClassId.put(unsignedType3.getArrayClassId(), unsignedType3.getClassId());
            unsignedClassIdToArrayClassId.put(unsignedType3.getClassId(), unsignedType3.getArrayClassId());
        }
    }

    private UnsignedTypes() {
    }

    public final boolean isShortNameOfUnsignedArray(Name name) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        return arrayClassesShortNames.contains(name);
    }

    public final ClassId getUnsignedClassIdByArrayClassId(ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "arrayClassId");
        return arrayClassIdToUnsignedClassId.get(classId);
    }

    public final boolean isUnsignedType(KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor;
        Intrinsics.checkParameterIsNotNull(kotlinType, "type");
        if (TypeUtils.noExpectedType(kotlinType) || (declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor()) == null) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(declarationDescriptor, "type.constructor.declara…escriptor ?: return false");
        return isUnsignedClass(declarationDescriptor);
    }

    public final boolean isUnsignedClass(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkParameterIsNotNull(declarationDescriptor, "descriptor");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        return (containingDeclaration instanceof PackageFragmentDescriptor) && Intrinsics.areEqual(((PackageFragmentDescriptor) containingDeclaration).getFqName(), KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME) && unsignedTypeNames.contains(declarationDescriptor.getName());
    }
}
