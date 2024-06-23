package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;

/* compiled from: DeserializedPackageMemberScope.kt */
public class DeserializedPackageMemberScope extends DeserializedMemberScope {
    private final PackageFragmentDescriptor packageDescriptor;
    private final FqName packageFqName;

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(collection, "result");
        Intrinsics.checkParameterIsNotNull(function1, "nameFilter");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public DeserializedPackageMemberScope(PackageFragmentDescriptor packageFragmentDescriptor, ProtoBuf.Package r17, NameResolver nameResolver, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource, DeserializationComponents deserializationComponents, Function0<? extends Collection<Name>> function0) {
        super(r2, r3, r4, r0, function0);
        Intrinsics.checkParameterIsNotNull(packageFragmentDescriptor, "packageDescriptor");
        Intrinsics.checkParameterIsNotNull(r17, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(binaryVersion, "metadataVersion");
        Intrinsics.checkParameterIsNotNull(deserializationComponents, "components");
        Intrinsics.checkParameterIsNotNull(function0, "classNames");
        ProtoBuf.TypeTable typeTable = r17.getTypeTable();
        Intrinsics.checkExpressionValueIsNotNull(typeTable, "proto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable versionRequirementTable = r17.getVersionRequirementTable();
        Intrinsics.checkExpressionValueIsNotNull(versionRequirementTable, "proto.versionRequirementTable");
        DeserializationContext createContext = deserializationComponents.createContext(packageFragmentDescriptor, nameResolver, typeTable2, companion.create(versionRequirementTable), binaryVersion, deserializedContainerSource);
        List<ProtoBuf.Function> functionList = r17.getFunctionList();
        Intrinsics.checkExpressionValueIsNotNull(functionList, "proto.functionList");
        List<ProtoBuf.Function> list = functionList;
        List<ProtoBuf.Property> propertyList = r17.getPropertyList();
        Intrinsics.checkExpressionValueIsNotNull(propertyList, "proto.propertyList");
        List<ProtoBuf.Property> list2 = propertyList;
        List<ProtoBuf.TypeAlias> typeAliasList = r17.getTypeAliasList();
        Intrinsics.checkExpressionValueIsNotNull(typeAliasList, "proto.typeAliasList");
        this.packageDescriptor = packageFragmentDescriptor;
        this.packageFqName = packageFragmentDescriptor.getFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(descriptorKindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(function1, "nameFilter");
        Collection<DeclarationDescriptor> computeDescriptors = computeDescriptors(descriptorKindFilter, function1, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories = getC().getComponents().getFictitiousClassDescriptorFactories();
        ArrayList arrayList = new ArrayList();
        for (ClassDescriptorFactory classDescriptorFactory : fictitiousClassDescriptorFactories) {
            CollectionsKt.addAll(arrayList, classDescriptorFactory.getAllContributedClassesIfPossible(this.packageFqName));
        }
        return CollectionsKt.plus((Collection) computeDescriptors, (Iterable) arrayList);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public boolean hasClass(Name name) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        if (super.hasClass(name)) {
            return true;
        }
        Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories = getC().getComponents().getFictitiousClassDescriptorFactories();
        if (!(fictitiousClassDescriptorFactories instanceof Collection) || !((Collection) fictitiousClassDescriptorFactories).isEmpty()) {
            Iterator<ClassDescriptorFactory> it = fictitiousClassDescriptorFactories.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().shouldCreateClass(this.packageFqName, name)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                return true;
            }
            return false;
        }
        z = false;
        if (!z) {
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public ClassId createClassId(Name name) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        return new ClassId(this.packageFqName, name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        return super.getContributedClassifier(name, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl
    public void recordLookup(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(lookupLocation, "location");
        UtilsKt.record(getC().getComponents().getLookupTracker(), lookupLocation, this.packageDescriptor, name);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public Set<Name> getNonDeclaredFunctionNames() {
        return SetsKt.emptySet();
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public Set<Name> getNonDeclaredVariableNames() {
        return SetsKt.emptySet();
    }
}
