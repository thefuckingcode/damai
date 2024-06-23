package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.d0;
import kotlin.collections.e0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.en0;
import tb.fn0;
import tb.k21;
import tb.m40;
import tb.ni;
import tb.og1;
import tb.oi;
import tb.te2;

/* compiled from: Taobao */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {
    @NotNull
    public static final a Companion = new a(null);
    static final /* synthetic */ KProperty<Object>[] d = {dz1.i(new PropertyReference1Impl(dz1.b(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    @NotNull
    private static final en0 e = c.BUILT_INS_PACKAGE_FQ_NAME;
    @NotNull
    private static final og1 f;
    @NotNull
    private static final oi g;
    @NotNull
    private final ModuleDescriptor a;
    @NotNull
    private final Function1<ModuleDescriptor, DeclarationDescriptor> b;
    @NotNull
    private final NotNullLazyValue c;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final oi a() {
            return JvmBuiltInClassDescriptorFactory.g;
        }
    }

    static {
        fn0 fn0 = c.a.cloneable;
        og1 i = fn0.i();
        k21.h(i, "cloneable.shortName()");
        f = i;
        oi m = oi.m(fn0.l());
        k21.h(m, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        g = m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, ? extends kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> function1) {
        k21.i(storageManager, "storageManager");
        k21.i(moduleDescriptor, "moduleDescriptor");
        k21.i(function1, "computeContainingDeclaration");
        this.a = moduleDescriptor;
        this.b = function1;
        this.c = storageManager.createLazyValue(new JvmBuiltInClassDescriptorFactory$cloneable$2(this, storageManager));
    }

    private final ni f() {
        return (ni) te2.a(this.c, this, d[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @Nullable
    public ClassDescriptor createClass(@NotNull oi oiVar) {
        k21.i(oiVar, "classId");
        if (k21.d(oiVar, Companion.a())) {
            return f();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @NotNull
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull en0 en0) {
        k21.i(en0, "packageFqName");
        if (k21.d(en0, e)) {
            return d0.c(f());
        }
        return e0.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(@NotNull en0 en0, @NotNull og1 og1) {
        k21.i(en0, "packageFqName");
        k21.i(og1, "name");
        return k21.d(og1, f) && k21.d(en0, e);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1 function1, int i, m40 m40) {
        this(storageManager, moduleDescriptor, (i & 4) != 0 ? AnonymousClass1.INSTANCE : function1);
    }
}
