package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e0;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b60;
import tb.c60;
import tb.k21;
import tb.og1;
import tb.ur2;
import tb.vt2;
import tb.x61;
import tb.y61;
import tb.z50;

/* compiled from: Taobao */
public final class LazyJavaStaticClassScope extends y61 {
    @NotNull
    private final JavaClass m;
    @NotNull
    private final LazyJavaClassDescriptor n;

    /* compiled from: Taobao */
    public static final class a extends DFS.b<ClassDescriptor, ur2> {
        final /* synthetic */ ClassDescriptor a;
        final /* synthetic */ Set<R> b;
        final /* synthetic */ Function1<MemberScope, Collection<R>> c;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, ? extends java.util.Collection<? extends R>> */
        /* JADX WARN: Multi-variable type inference failed */
        a(ClassDescriptor classDescriptor, Set<R> set, Function1<? super MemberScope, ? extends Collection<? extends R>> function1) {
            this.a = classDescriptor;
            this.b = set;
            this.c = function1;
        }

        /* renamed from: a */
        public boolean beforeChildren(@NotNull ClassDescriptor classDescriptor) {
            k21.i(classDescriptor, "current");
            if (classDescriptor == this.a) {
                return true;
            }
            MemberScope staticScope = classDescriptor.getStaticScope();
            k21.h(staticScope, "current.staticScope");
            if (!(staticScope instanceof y61)) {
                return true;
            }
            this.b.addAll(this.c.invoke(staticScope));
            return false;
        }

        public void b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public /* bridge */ /* synthetic */ Object result() {
            b();
            return ur2.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticClassScope(@NotNull x61 x61, @NotNull JavaClass javaClass, @NotNull LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(x61);
        k21.i(x61, c.a);
        k21.i(javaClass, "jClass");
        k21.i(lazyJavaClassDescriptor, "ownerDescriptor");
        this.m = javaClass;
        this.n = lazyJavaClassDescriptor;
    }

    private final <R> Set<R> G(ClassDescriptor classDescriptor, Set<R> set, Function1<? super MemberScope, ? extends Collection<? extends R>> function1) {
        DFS.b(l.e(classDescriptor), LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1.INSTANCE, new a(classDescriptor, set, function1));
        return set;
    }

    private final PropertyDescriptor I(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor.getKind().isReal()) {
            return propertyDescriptor;
        }
        Collection<? extends PropertyDescriptor> overriddenDescriptors = propertyDescriptor.getOverriddenDescriptors();
        k21.h(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(n.q(overriddenDescriptors, 10));
        for (T t : overriddenDescriptors) {
            k21.h(t, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(I(t));
        }
        return (PropertyDescriptor) k.o0(CollectionsKt___CollectionsKt.K(arrayList));
    }

    private final Set<SimpleFunctionDescriptor> J(og1 og1, ClassDescriptor classDescriptor) {
        LazyJavaStaticClassScope c = vt2.c(classDescriptor);
        if (c == null) {
            return e0.d();
        }
        return CollectionsKt___CollectionsKt.C0(c.getContributedFunctions(og1, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: F */
    public ClassDeclaredMemberIndex i() {
        return new ClassDeclaredMemberIndex(this.m, LazyJavaStaticClassScope$computeMemberIndex$1.INSTANCE);
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: H */
    public LazyJavaClassDescriptor v() {
        return this.n;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<og1> e(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        return e0.d();
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<og1> g(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        Set<og1> set = CollectionsKt___CollectionsKt.B0(((DeclaredMemberIndex) r().invoke()).getMethodNames());
        LazyJavaStaticClassScope c = vt2.c(v());
        Set<og1> functionNames = c == null ? null : c.getFunctionNames();
        if (functionNames == null) {
            functionNames = e0.d();
        }
        set.addAll(functionNames);
        if (this.m.isEnum()) {
            set.addAll(m.j(kotlin.reflect.jvm.internal.impl.builtins.c.ENUM_VALUE_OF, kotlin.reflect.jvm.internal.impl.builtins.c.ENUM_VALUES));
        }
        return set;
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void k(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull og1 og1) {
        k21.i(collection, "result");
        k21.i(og1, "name");
        Collection<? extends SimpleFunctionDescriptor> e = c60.e(og1, J(og1, v()), collection, v(), p().a().c(), p().a().j().getOverridingUtil());
        k21.h(e, "resolveOverridesForStaticMembers(\n            name,\n            functionsFromSupertypes,\n            result,\n            ownerDescriptor,\n            c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        collection.addAll(e);
        if (!this.m.isEnum()) {
            return;
        }
        if (k21.d(og1, kotlin.reflect.jvm.internal.impl.builtins.c.ENUM_VALUE_OF)) {
            SimpleFunctionDescriptor d = z50.d(v());
            k21.h(d, "createEnumValueOfMethod(ownerDescriptor)");
            collection.add(d);
        } else if (k21.d(og1, kotlin.reflect.jvm.internal.impl.builtins.c.ENUM_VALUES)) {
            SimpleFunctionDescriptor e2 = z50.e(v());
            k21.h(e2, "createEnumValuesMethod(ownerDescriptor)");
            collection.add(e2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.y61, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void l(@NotNull og1 og1, @NotNull Collection<PropertyDescriptor> collection) {
        k21.i(og1, "name");
        k21.i(collection, "result");
        Set G = G(v(), new LinkedHashSet(), new LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(og1));
        if (!collection.isEmpty()) {
            Collection<? extends PropertyDescriptor> e = c60.e(og1, G, collection, v(), p().a().c(), p().a().j().getOverridingUtil());
            k21.h(e, "resolveOverridesForStaticMembers(\n                    name,\n                    propertiesFromSupertypes,\n                    result,\n                    ownerDescriptor,\n                    c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            collection.addAll(e);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : G) {
            PropertyDescriptor I = I((PropertyDescriptor) obj);
            Object obj2 = linkedHashMap.get(I);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(I, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Collection e2 = c60.e(og1, (Collection) entry.getValue(), collection, v(), p().a().c(), p().a().j().getOverridingUtil());
            k21.h(e2, "resolveOverridesForStaticMembers(\n                    name, it.value, result, ownerDescriptor, c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            boolean unused = r.v(arrayList, e2);
        }
        collection.addAll(arrayList);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<og1> m(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        Set<og1> set = CollectionsKt___CollectionsKt.B0(((DeclaredMemberIndex) r().invoke()).getFieldNames());
        G(v(), set, LazyJavaStaticClassScope$computePropertyNames$1$1.INSTANCE);
        return set;
    }
}
