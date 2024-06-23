package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.youku.arch.v3.data.Constants;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.ev1;
import tb.j60;
import tb.k21;
import tb.nb;
import tb.p60;
import tb.pg1;
import tb.q60;

/* compiled from: Taobao */
public abstract class DeserializedPackageFragmentImpl extends p60 {
    @NotNull
    private final nb g;
    @Nullable
    private final DeserializedContainerSource h;
    @NotNull
    private final pg1 i;
    @NotNull
    private final ev1 j;
    @Nullable
    private ProtoBuf$PackageFragment k;
    private MemberScope l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl(@NotNull en0 en0, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull ProtoBuf$PackageFragment protoBuf$PackageFragment, @NotNull nb nbVar, @Nullable DeserializedContainerSource deserializedContainerSource) {
        super(en0, storageManager, moduleDescriptor);
        k21.i(en0, "fqName");
        k21.i(storageManager, "storageManager");
        k21.i(moduleDescriptor, "module");
        k21.i(protoBuf$PackageFragment, "proto");
        k21.i(nbVar, "metadataVersion");
        this.g = nbVar;
        this.h = deserializedContainerSource;
        ProtoBuf$StringTable strings = protoBuf$PackageFragment.getStrings();
        k21.h(strings, "proto.strings");
        ProtoBuf$QualifiedNameTable qualifiedNames = protoBuf$PackageFragment.getQualifiedNames();
        k21.h(qualifiedNames, "proto.qualifiedNames");
        pg1 pg1 = new pg1(strings, qualifiedNames);
        this.i = pg1;
        this.j = new ev1(protoBuf$PackageFragment, pg1, nbVar, new DeserializedPackageFragmentImpl$classDataFinder$1(this));
        this.k = protoBuf$PackageFragment;
    }

    @Override // tb.p60
    public void f(@NotNull j60 j60) {
        k21.i(j60, Constants.COMPONENT);
        ProtoBuf$PackageFragment protoBuf$PackageFragment = this.k;
        if (protoBuf$PackageFragment != null) {
            this.k = null;
            ProtoBuf$Package protoBuf$Package = protoBuf$PackageFragment.getPackage();
            k21.h(protoBuf$Package, "proto.`package`");
            this.l = new q60(this, protoBuf$Package, this.i, this.g, this.h, j60, new DeserializedPackageFragmentImpl$initialize$1(this));
            return;
        }
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    @NotNull
    public MemberScope getMemberScope() {
        MemberScope memberScope = this.l;
        if (memberScope != null) {
            return memberScope;
        }
        k21.A("_memberScope");
        throw null;
    }

    @NotNull
    /* renamed from: h */
    public ev1 d() {
        return this.j;
    }
}
