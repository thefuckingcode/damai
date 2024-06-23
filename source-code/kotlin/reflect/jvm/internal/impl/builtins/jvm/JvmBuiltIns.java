package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import tb.dz1;
import tb.k21;
import tb.te2;

public final class JvmBuiltIns extends kotlin.reflect.jvm.internal.impl.builtins.b {
    static final /* synthetic */ KProperty<Object>[] h = {dz1.i(new PropertyReference1Impl(dz1.b(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    private Function0<a> f;
    private final NotNullLazyValue g;

    public enum Kind {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    public static final class a {
        private final ModuleDescriptor a;
        private final boolean b;

        public a(ModuleDescriptor moduleDescriptor, boolean z) {
            k21.i(moduleDescriptor, "ownerModuleDescriptor");
            this.a = moduleDescriptor;
            this.b = z;
        }

        public final ModuleDescriptor a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Kind.values().length];
            iArr[Kind.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[Kind.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[Kind.FALLBACK.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns(StorageManager storageManager, Kind kind) {
        super(storageManager);
        k21.i(storageManager, "storageManager");
        k21.i(kind, "kind");
        this.g = storageManager.createLazyValue(new JvmBuiltIns$customizer$2(this, storageManager));
        int i = b.$EnumSwitchMapping$0[kind.ordinal()];
        if (i == 2) {
            f(false);
        } else if (i == 3) {
            f(true);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.b
    public PlatformDependentDeclarationFilter M() {
        return P0();
    }

    /* renamed from: O0 */
    public List<ClassDescriptorFactory> v() {
        Iterable<ClassDescriptorFactory> v = super.v();
        k21.h(v, "super.getClassDescriptorFactories()");
        StorageManager T = T();
        k21.h(T, "storageManager");
        ModuleDescriptorImpl r = r();
        k21.h(r, "builtInsModule");
        return CollectionsKt___CollectionsKt.j0(v, new JvmBuiltInClassDescriptorFactory(T, r, null, 4, null));
    }

    public final JvmBuiltInsCustomizer P0() {
        return (JvmBuiltInsCustomizer) te2.a(this.g, this, h[0]);
    }

    public final void Q0(ModuleDescriptor moduleDescriptor, boolean z) {
        k21.i(moduleDescriptor, "moduleDescriptor");
        R0(new JvmBuiltIns$initialize$1(moduleDescriptor, z));
    }

    public final void R0(Function0<a> function0) {
        k21.i(function0, "computation");
        this.f = function0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.b
    public AdditionalClassPartsProvider g() {
        return P0();
    }
}
