package kotlin.reflect.jvm.internal.impl.load.java;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: specialBuiltinMembers.kt */
public final class BuiltinSpecialProperties {
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    private static final Set<FqName> SPECIAL_FQ_NAMES;
    private static final Set<Name> SPECIAL_SHORT_NAMES;

    static {
        FqNameUnsafe fqNameUnsafe = KotlinBuiltIns.FQ_NAMES._enum;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe, "BUILTIN_NAMES._enum");
        FqNameUnsafe fqNameUnsafe2 = KotlinBuiltIns.FQ_NAMES._enum;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe2, "BUILTIN_NAMES._enum");
        FqName fqName = KotlinBuiltIns.FQ_NAMES.collection;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "BUILTIN_NAMES.collection");
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "BUILTIN_NAMES.map");
        FqNameUnsafe fqNameUnsafe3 = KotlinBuiltIns.FQ_NAMES.charSequence;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe3, "BUILTIN_NAMES.charSequence");
        FqName fqName3 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "BUILTIN_NAMES.map");
        FqName fqName4 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName4, "BUILTIN_NAMES.map");
        FqName fqName5 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName5, "BUILTIN_NAMES.map");
        Map<FqName, Name> mapOf = MapsKt.mapOf(TuplesKt.to(SpecialBuiltinMembers.childSafe(fqNameUnsafe, SerializableCookie.NAME), Name.identifier(SerializableCookie.NAME)), TuplesKt.to(SpecialBuiltinMembers.childSafe(fqNameUnsafe2, "ordinal"), Name.identifier("ordinal")), TuplesKt.to(SpecialBuiltinMembers.child(fqName, "size"), Name.identifier("size")), TuplesKt.to(SpecialBuiltinMembers.child(fqName2, "size"), Name.identifier("size")), TuplesKt.to(SpecialBuiltinMembers.childSafe(fqNameUnsafe3, "length"), Name.identifier("length")), TuplesKt.to(SpecialBuiltinMembers.child(fqName3, "keys"), Name.identifier("keySet")), TuplesKt.to(SpecialBuiltinMembers.child(fqName4, "values"), Name.identifier("values")), TuplesKt.to(SpecialBuiltinMembers.child(fqName5, "entries"), Name.identifier("entrySet")));
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = mapOf;
        Set<Map.Entry<FqName, Name>> entrySet = mapOf.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entrySet, 10));
        for (T t : entrySet) {
            arrayList.add(new Pair(((FqName) t.getKey()).shortName(), t.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            Name name = (Name) pair.getSecond();
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add((Name) pair.getFirst());
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = linkedHashMap;
        Set<FqName> keySet = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = keySet;
        Set<FqName> set = keySet;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().shortName());
        }
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet(arrayList2);
    }

    private BuiltinSpecialProperties() {
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES$descriptors_jvm() {
        return SPECIAL_SHORT_NAMES;
    }

    public final boolean hasBuiltinSpecialPropertyFqName(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "callableMemberDescriptor");
        if (!SPECIAL_SHORT_NAMES.contains(callableMemberDescriptor.getName())) {
            return false;
        }
        return hasBuiltinSpecialPropertyFqNameImpl(callableMemberDescriptor);
    }

    private final boolean hasBuiltinSpecialPropertyFqNameImpl(CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
        if (CollectionsKt.contains(SPECIAL_FQ_NAMES, DescriptorUtilsKt.fqNameOrNull(callableMemberDescriptor2)) && callableMemberDescriptor.getValueParameters().isEmpty()) {
            return true;
        }
        if (!KotlinBuiltIns.isBuiltIn(callableMemberDescriptor2)) {
            return false;
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkExpressionValueIsNotNull(overriddenDescriptors, "overriddenDescriptors");
        Collection<? extends CallableMemberDescriptor> collection = overriddenDescriptors;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            for (T t : collection) {
                BuiltinSpecialProperties builtinSpecialProperties = INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(t, "it");
                if (builtinSpecialProperties.hasBuiltinSpecialPropertyFqName(t)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name name) {
        Intrinsics.checkParameterIsNotNull(name, "name1");
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name);
        return list != null ? list : CollectionsKt.emptyList();
    }

    public final String getBuiltinSpecialPropertyGetterName(CallableMemberDescriptor callableMemberDescriptor) {
        Name name;
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "$this$getBuiltinSpecialPropertyGetterName");
        KotlinBuiltIns.isBuiltIn(callableMemberDescriptor);
        CallableMemberDescriptor firstOverridden$default = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor), false, BuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1.INSTANCE, 1, null);
        if (firstOverridden$default == null || (name = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.get(DescriptorUtilsKt.getFqNameSafe(firstOverridden$default))) == null) {
            return null;
        }
        return name.asString();
    }
}
