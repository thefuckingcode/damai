package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: JvmBuiltInsSettings.kt */
public final class JvmBuiltInsSettings$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1 extends PackageFragmentDescriptorImpl {
    final /* synthetic */ JvmBuiltInsSettings this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsSettings$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1(JvmBuiltInsSettings jvmBuiltInsSettings, ModuleDescriptor moduleDescriptor, FqName fqName) {
        super(moduleDescriptor, fqName);
        this.this$0 = jvmBuiltInsSettings;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public MemberScope.Empty getMemberScope() {
        return MemberScope.Empty.INSTANCE;
    }
}
