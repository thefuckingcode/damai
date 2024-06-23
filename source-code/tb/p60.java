package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class p60 extends in1 {
    @NotNull
    private final StorageManager f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p60(@NotNull en0 en0, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor) {
        super(moduleDescriptor, en0);
        k21.i(en0, "fqName");
        k21.i(storageManager, "storageManager");
        k21.i(moduleDescriptor, "module");
        this.f = storageManager;
    }

    @NotNull
    public abstract ClassDataFinder d();

    public boolean e(@NotNull og1 og1) {
        k21.i(og1, "name");
        MemberScope memberScope = getMemberScope();
        return (memberScope instanceof DeserializedMemberScope) && ((DeserializedMemberScope) memberScope).k().contains(og1);
    }

    public abstract void f(@NotNull j60 j60);
}
