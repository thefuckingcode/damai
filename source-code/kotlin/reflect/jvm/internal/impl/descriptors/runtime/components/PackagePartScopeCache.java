package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: PackagePartScopeCache.kt */
public final class PackagePartScopeCache {
    private final ConcurrentHashMap<ClassId, MemberScope> cache = new ConcurrentHashMap<>();
    private final ReflectKotlinClassFinder kotlinClassFinder;
    private final DeserializedDescriptorResolver resolver;

    public PackagePartScopeCache(DeserializedDescriptorResolver deserializedDescriptorResolver, ReflectKotlinClassFinder reflectKotlinClassFinder) {
        Intrinsics.checkParameterIsNotNull(deserializedDescriptorResolver, "resolver");
        Intrinsics.checkParameterIsNotNull(reflectKotlinClassFinder, "kotlinClassFinder");
        this.resolver = deserializedDescriptorResolver;
        this.kotlinClassFinder = reflectKotlinClassFinder;
    }

    public final MemberScope getPackagePartScope(ReflectKotlinClass reflectKotlinClass) {
        List<KotlinJvmBinaryClass> list;
        Intrinsics.checkParameterIsNotNull(reflectKotlinClass, "fileClass");
        ConcurrentHashMap<ClassId, MemberScope> concurrentHashMap = this.cache;
        ClassId classId = reflectKotlinClass.getClassId();
        MemberScope memberScope = concurrentHashMap.get(classId);
        if (memberScope == null) {
            FqName packageFqName = reflectKotlinClass.getClassId().getPackageFqName();
            Intrinsics.checkExpressionValueIsNotNull(packageFqName, "fileClass.classId.packageFqName");
            if (reflectKotlinClass.getClassHeader().getKind() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = reflectKotlinClass.getClassHeader().getMultifilePartNames().iterator();
                while (it.hasNext()) {
                    JvmClassName byInternalName = JvmClassName.byInternalName(it.next());
                    Intrinsics.checkExpressionValueIsNotNull(byInternalName, "JvmClassName.byInternalName(partName)");
                    ClassId classId2 = ClassId.topLevel(byInternalName.getFqNameForTopLevelClassMaybeWithDollars());
                    Intrinsics.checkExpressionValueIsNotNull(classId2, "ClassId.topLevel(JvmClas…velClassMaybeWithDollars)");
                    KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, classId2);
                    if (findKotlinClass != null) {
                        arrayList.add(findKotlinClass);
                    }
                }
                list = arrayList;
            } else {
                list = CollectionsKt.listOf(reflectKotlinClass);
            }
            EmptyPackageFragmentDescriptor emptyPackageFragmentDescriptor = new EmptyPackageFragmentDescriptor(this.resolver.getComponents().getModuleDescriptor(), packageFqName);
            ArrayList arrayList2 = new ArrayList();
            for (KotlinJvmBinaryClass kotlinJvmBinaryClass : list) {
                MemberScope createKotlinPackagePartScope = this.resolver.createKotlinPackagePartScope(emptyPackageFragmentDescriptor, kotlinJvmBinaryClass);
                if (createKotlinPackagePartScope != null) {
                    arrayList2.add(createKotlinPackagePartScope);
                }
            }
            List<? extends MemberScope> list2 = CollectionsKt.toList(arrayList2);
            ChainedMemberScope.Companion companion = ChainedMemberScope.Companion;
            memberScope = companion.create("package " + packageFqName + " (" + reflectKotlinClass + ')', list2);
            MemberScope putIfAbsent = concurrentHashMap.putIfAbsent(classId, memberScope);
            if (putIfAbsent != null) {
                memberScope = putIfAbsent;
            }
        }
        Intrinsics.checkExpressionValueIsNotNull(memberScope, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
        return memberScope;
    }
}
