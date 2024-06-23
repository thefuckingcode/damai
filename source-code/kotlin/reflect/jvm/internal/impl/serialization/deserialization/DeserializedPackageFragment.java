package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedPackageFragment.kt */
public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {
    private final StorageManager storageManager;

    public abstract ClassDataFinder getClassDataFinder();

    public abstract void initialize(DeserializationComponents deserializationComponents);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragment(FqName fqName, StorageManager storageManager2, ModuleDescriptor moduleDescriptor) {
        super(moduleDescriptor, fqName);
        Intrinsics.checkParameterIsNotNull(fqName, "fqName");
        Intrinsics.checkParameterIsNotNull(storageManager2, "storageManager");
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        this.storageManager = storageManager2;
    }

    public boolean hasTopLevelClass(Name name) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        MemberScope memberScope = getMemberScope();
        return (memberScope instanceof DeserializedMemberScope) && ((DeserializedMemberScope) memberScope).getClassNames$deserialization().contains(name);
    }
}
