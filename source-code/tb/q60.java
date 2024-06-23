package tb;

import com.youku.arch.v3.data.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e0;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fv2;

/* compiled from: Taobao */
public class q60 extends DeserializedMemberScope {
    @NotNull
    private final PackageFragmentDescriptor f;
    @NotNull
    private final en0 g;

    /* JADX WARNING: Illegal instructions before constructor call */
    public q60(@NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull ProtoBuf$Package protoBuf$Package, @NotNull NameResolver nameResolver, @NotNull nb nbVar, @Nullable DeserializedContainerSource deserializedContainerSource, @NotNull j60 j60, @NotNull Function0<? extends Collection<og1>> function0) {
        super(r2, r3, r4, r7, function0);
        k21.i(packageFragmentDescriptor, "packageDescriptor");
        k21.i(protoBuf$Package, "proto");
        k21.i(nameResolver, "nameResolver");
        k21.i(nbVar, "metadataVersion");
        k21.i(j60, Constants.COMPONENT);
        k21.i(function0, "classNames");
        ProtoBuf$TypeTable typeTable = protoBuf$Package.getTypeTable();
        k21.h(typeTable, "proto.typeTable");
        ap2 ap2 = new ap2(typeTable);
        fv2.a aVar = fv2.Companion;
        ProtoBuf$VersionRequirementTable versionRequirementTable = protoBuf$Package.getVersionRequirementTable();
        k21.h(versionRequirementTable, "proto.versionRequirementTable");
        l60 a = j60.a(packageFragmentDescriptor, nameResolver, ap2, aVar.a(versionRequirementTable), nbVar, deserializedContainerSource);
        List<ProtoBuf$Function> functionList = protoBuf$Package.getFunctionList();
        k21.h(functionList, "proto.functionList");
        List<ProtoBuf$Property> propertyList = protoBuf$Package.getPropertyList();
        k21.h(propertyList, "proto.propertyList");
        List<ProtoBuf$TypeAlias> typeAliasList = protoBuf$Package.getTypeAliasList();
        k21.h(typeAliasList, "proto.typeAliasList");
        this.f = packageFragmentDescriptor;
        this.g = packageFragmentDescriptor.getFqName();
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public void c(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(collection, "result");
        k21.i(function1, "nameFilter");
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @NotNull
    public oi g(@NotNull og1 og1) {
        k21.i(og1, "name");
        return new oi(this.g, og1);
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        recordLookup(og1, lookupLocation);
        return super.getContributedClassifier(og1, lookupLocation);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @Nullable
    public Set<og1> m() {
        return e0.d();
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @NotNull
    public Set<og1> n() {
        return e0.d();
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @NotNull
    public Set<og1> o() {
        return e0.d();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public boolean q(@NotNull og1 og1) {
        boolean z;
        k21.i(og1, "name");
        if (super.q(og1)) {
            return true;
        }
        Iterable<ClassDescriptorFactory> k = j().c().k();
        if (!(k instanceof Collection) || !((Collection) k).isEmpty()) {
            Iterator<ClassDescriptorFactory> it = k.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().shouldCreateClass(this.g, og1)) {
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

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        mu2.b(j().c().o(), lookupLocation, this.f, og1);
    }

    @NotNull
    /* renamed from: s */
    public List<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        Collection<DeclarationDescriptor> d = d(b60, function1, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<ClassDescriptorFactory> k = j().c().k();
        ArrayList arrayList = new ArrayList();
        for (ClassDescriptorFactory classDescriptorFactory : k) {
            boolean unused = r.v(arrayList, classDescriptorFactory.getAllContributedClassesIfPossible(this.g));
        }
        return CollectionsKt___CollectionsKt.k0(d, arrayList);
    }
}
