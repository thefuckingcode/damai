package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.i61;
import tb.k21;
import tb.me0;

/* compiled from: Taobao */
public abstract class AbstractTypeConstructor implements TypeConstructor {
    @NotNull
    private final NotNullLazyValue<a> a;
    private final boolean b;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class ModuleViewTypeConstructor implements TypeConstructor {
        @NotNull
        private final i61 a;
        @NotNull
        private final Lazy b;
        final /* synthetic */ AbstractTypeConstructor c;

        public ModuleViewTypeConstructor(@NotNull AbstractTypeConstructor abstractTypeConstructor, i61 i61) {
            k21.i(abstractTypeConstructor, "this$0");
            k21.i(i61, "kotlinTypeRefiner");
            this.c = abstractTypeConstructor;
            this.a = i61;
            this.b = b.a(LazyThreadSafetyMode.PUBLICATION, new AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(this, abstractTypeConstructor));
        }

        private final List<g61> b() {
            return (List) this.b.getValue();
        }

        @NotNull
        /* renamed from: c */
        public List<g61> getSupertypes() {
            return b();
        }

        public boolean equals(@Nullable Object obj) {
            return this.c.equals(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.b getBuiltIns() {
            kotlin.reflect.jvm.internal.impl.builtins.b builtIns = this.c.getBuiltIns();
            k21.h(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.c.getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.c.getParameters();
            k21.h(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.c.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull i61 i61) {
            k21.i(i61, "kotlinTypeRefiner");
            return this.c.refine(i61);
        }

        @NotNull
        public String toString() {
            return this.c.toString();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        private final Collection<g61> a;
        @NotNull
        private List<? extends g61> b = l.e(me0.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES);

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends tb.g61> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull Collection<? extends g61> collection) {
            k21.i(collection, "allSupertypes");
            this.a = collection;
        }

        @NotNull
        public final Collection<g61> a() {
            return this.a;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends tb.g61>, java.util.List<tb.g61> */
        @NotNull
        public final List<g61> b() {
            return this.b;
        }

        public final void c(@NotNull List<? extends g61> list) {
            k21.i(list, "<set-?>");
            this.b = list;
        }
    }

    public AbstractTypeConstructor(@NotNull StorageManager storageManager) {
        k21.i(storageManager, "storageManager");
        this.a = storageManager.createLazyValueWithPostCompute(new AbstractTypeConstructor$supertypes$1(this), AbstractTypeConstructor$supertypes$2.INSTANCE, new AbstractTypeConstructor$supertypes$3(this));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final Collection<g61> b(TypeConstructor typeConstructor, boolean z) {
        List list = null;
        AbstractTypeConstructor abstractTypeConstructor = typeConstructor instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) typeConstructor : null;
        if (abstractTypeConstructor != null) {
            list = CollectionsKt___CollectionsKt.k0(((a) abstractTypeConstructor.a.invoke()).a(), abstractTypeConstructor.e(z));
        }
        if (list != null) {
            return list;
        }
        Collection<g61> supertypes = typeConstructor.getSupertypes();
        k21.h(supertypes, "supertypes");
        return supertypes;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract Collection<g61> c();

    /* access modifiers changed from: protected */
    @Nullable
    public g61 d() {
        return null;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Collection<g61> e(boolean z) {
        return m.g();
    }

    /* access modifiers changed from: protected */
    public boolean f() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract SupertypeLoopChecker g();

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public abstract ClassifierDescriptor getDeclarationDescriptor();

    @NotNull
    /* renamed from: h */
    public List<g61> getSupertypes() {
        return ((a) this.a.invoke()).b();
    }

    /* access modifiers changed from: protected */
    @NotNull
    public List<g61> i(@NotNull List<g61> list) {
        k21.i(list, "supertypes");
        return list;
    }

    /* access modifiers changed from: protected */
    public void j(@NotNull g61 g61) {
        k21.i(g61, "type");
    }

    /* access modifiers changed from: protected */
    public void k(@NotNull g61 g61) {
        k21.i(g61, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public TypeConstructor refine(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, i61);
    }
}
