package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.l;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.sg;

/* compiled from: Taobao */
public final class kn1 {
    @NotNull
    private final DeserializedDescriptorResolver a;
    @NotNull
    private final xy1 b;
    @NotNull
    private final ConcurrentHashMap<oi, MemberScope> c = new ConcurrentHashMap<>();

    public kn1(@NotNull DeserializedDescriptorResolver deserializedDescriptorResolver, @NotNull xy1 xy1) {
        k21.i(deserializedDescriptorResolver, "resolver");
        k21.i(xy1, "kotlinClassFinder");
        this.a = deserializedDescriptorResolver;
        this.b = xy1;
    }

    @NotNull
    public final MemberScope a(@NotNull wy1 wy1) {
        Collection<KotlinJvmBinaryClass> collection;
        k21.i(wy1, "fileClass");
        ConcurrentHashMap<oi, MemberScope> concurrentHashMap = this.c;
        oi classId = wy1.getClassId();
        MemberScope memberScope = concurrentHashMap.get(classId);
        if (memberScope == null) {
            en0 h = wy1.getClassId().h();
            k21.h(h, "fileClass.classId.packageFqName");
            if (wy1.getClassHeader().c() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                List<String> f = wy1.getClassHeader().f();
                collection = new ArrayList();
                Iterator<T> it = f.iterator();
                while (it.hasNext()) {
                    oi m = oi.m(a51.d(it.next()).e());
                    k21.h(m, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                    KotlinJvmBinaryClass b2 = d61.b(this.b, m);
                    if (b2 != null) {
                        collection.add(b2);
                    }
                }
            } else {
                collection = l.e(wy1);
            }
            kd0 kd0 = new kd0(this.a.f().p(), h);
            ArrayList arrayList = new ArrayList();
            for (KotlinJvmBinaryClass kotlinJvmBinaryClass : collection) {
                MemberScope d = this.a.d(kd0, kotlinJvmBinaryClass);
                if (d != null) {
                    arrayList.add(d);
                }
            }
            List list = CollectionsKt___CollectionsKt.y0(arrayList);
            sg.a aVar = sg.Companion;
            MemberScope a2 = aVar.a("package " + h + " (" + wy1 + ')', list);
            MemberScope putIfAbsent = concurrentHashMap.putIfAbsent(classId, a2);
            memberScope = putIfAbsent != null ? putIfAbsent : a2;
        }
        k21.h(memberScope, "cache.getOrPut(fileClass.classId) {\n        val fqName = fileClass.classId.packageFqName\n\n        val parts =\n            if (fileClass.classHeader.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS)\n                fileClass.classHeader.multifilePartNames.mapNotNull { partName ->\n                    val classId = ClassId.topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)\n                    kotlinClassFinder.findKotlinClass(classId)\n                }\n            else listOf(fileClass)\n\n        val packageFragment = EmptyPackageFragmentDescriptor(resolver.components.moduleDescriptor, fqName)\n\n        val scopes = parts.mapNotNull { part ->\n            resolver.createKotlinPackagePartScope(packageFragment, part)\n        }.toList()\n\n        ChainedMemberScope.create(\"package $fqName ($fileClass)\", scopes)\n    }");
        return memberScope;
    }
}
