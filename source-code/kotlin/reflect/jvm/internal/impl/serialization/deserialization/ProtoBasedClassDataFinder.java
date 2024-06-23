package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: ProtoBasedClassDataFinder.kt */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    private final Map<ClassId, ProtoBuf.Class> classIdToProto;
    private final Function1<ClassId, SourceElement> classSource;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.ClassId, ? extends kotlin.reflect.jvm.internal.impl.descriptors.SourceElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBasedClassDataFinder(ProtoBuf.PackageFragment packageFragment, NameResolver nameResolver2, BinaryVersion binaryVersion, Function1<? super ClassId, ? extends SourceElement> function1) {
        Intrinsics.checkParameterIsNotNull(packageFragment, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver2, "nameResolver");
        Intrinsics.checkParameterIsNotNull(binaryVersion, "metadataVersion");
        Intrinsics.checkParameterIsNotNull(function1, "classSource");
        this.nameResolver = nameResolver2;
        this.metadataVersion = binaryVersion;
        this.classSource = function1;
        List<ProtoBuf.Class> class_List = packageFragment.getClass_List();
        Intrinsics.checkExpressionValueIsNotNull(class_List, "proto.class_List");
        List<ProtoBuf.Class> list = class_List;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (T t : list) {
            T t2 = t;
            NameResolver nameResolver3 = this.nameResolver;
            Intrinsics.checkExpressionValueIsNotNull(t2, "klass");
            linkedHashMap.put(NameResolverUtilKt.getClassId(nameResolver3, t2.getFqName()), t);
        }
        this.classIdToProto = linkedHashMap;
    }

    public final Collection<ClassId> getAllClassIds() {
        return this.classIdToProto.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        ProtoBuf.Class r0 = this.classIdToProto.get(classId);
        if (r0 != null) {
            return new ClassData(this.nameResolver, r0, this.metadataVersion, this.classSource.invoke(classId));
        }
        return null;
    }
}
