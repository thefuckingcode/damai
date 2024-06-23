package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ac2;
import tb.b60;
import tb.dz1;
import tb.k21;
import tb.oc1;
import tb.og1;
import tb.te2;

/* compiled from: Taobao */
public final class StaticScopeForKotlinEnum extends oc1 {
    static final /* synthetic */ KProperty<Object>[] c = {dz1.i(new PropertyReference1Impl(dz1.b(StaticScopeForKotlinEnum.class), "functions", "getFunctions()Ljava/util/List;"))};
    @NotNull
    private final ClassDescriptor a;
    @NotNull
    private final NotNullLazyValue b;

    public StaticScopeForKotlinEnum(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor) {
        k21.i(storageManager, "storageManager");
        k21.i(classDescriptor, "containingClass");
        this.a = classDescriptor;
        classDescriptor.getKind();
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.b = storageManager.createLazyValue(new StaticScopeForKotlinEnum$functions$2(this));
    }

    private final List<SimpleFunctionDescriptor> e() {
        return (List) te2.a(this.b, this, c[0]);
    }

    @Nullable
    public Void b(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return null;
    }

    @NotNull
    /* renamed from: c */
    public List<SimpleFunctionDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        return e();
    }

    @NotNull
    /* renamed from: d */
    public ac2<SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        List<SimpleFunctionDescriptor> e = e();
        ac2<SimpleFunctionDescriptor> ac2 = new ac2<>();
        for (T t : e) {
            if (k21.d(t.getName(), og1)) {
                ac2.add(t);
            }
        }
        return ac2;
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ ClassifierDescriptor getContributedClassifier(og1 og1, LookupLocation lookupLocation) {
        return (ClassifierDescriptor) b(og1, lookupLocation);
    }
}
