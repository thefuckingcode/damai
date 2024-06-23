package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.c;
import com.youku.arch.v3.event.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a60;
import tb.b60;
import tb.bg2;
import tb.bp2;
import tb.bv1;
import tb.do2;
import tb.dz1;
import tb.en0;
import tb.f60;
import tb.g61;
import tb.h60;
import tb.k21;
import tb.ku2;
import tb.m40;
import tb.oc1;
import tb.og1;
import tb.om;
import tb.pd1;
import tb.qj;
import tb.s01;
import tb.te2;
import tb.u31;
import tb.u41;
import tb.w61;
import tb.x61;
import tb.y31;
import tb.z50;

/* compiled from: Taobao */
public abstract class LazyJavaScope extends oc1 {
    static final /* synthetic */ KProperty<Object>[] l = {dz1.i(new PropertyReference1Impl(dz1.b(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), dz1.i(new PropertyReference1Impl(dz1.b(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), dz1.i(new PropertyReference1Impl(dz1.b(LazyJavaScope.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    @NotNull
    private final x61 a;
    @Nullable
    private final LazyJavaScope b;
    @NotNull
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> c;
    @NotNull
    private final NotNullLazyValue<DeclaredMemberIndex> d;
    @NotNull
    private final MemoizedFunctionToNotNull<og1, Collection<SimpleFunctionDescriptor>> e;
    @NotNull
    private final MemoizedFunctionToNullable<og1, PropertyDescriptor> f;
    @NotNull
    private final MemoizedFunctionToNotNull<og1, Collection<SimpleFunctionDescriptor>> g;
    @NotNull
    private final NotNullLazyValue h;
    @NotNull
    private final NotNullLazyValue i;
    @NotNull
    private final NotNullLazyValue j;
    @NotNull
    private final MemoizedFunctionToNotNull<og1, List<PropertyDescriptor>> k;

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        private final g61 a;
        @Nullable
        private final g61 b;
        @NotNull
        private final List<ValueParameterDescriptor> c;
        @NotNull
        private final List<TypeParameterDescriptor> d;
        private final boolean e;
        @NotNull
        private final List<String> f;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull g61 g61, @Nullable g61 g612, @NotNull List<? extends ValueParameterDescriptor> list, @NotNull List<? extends TypeParameterDescriptor> list2, boolean z, @NotNull List<String> list3) {
            k21.i(g61, "returnType");
            k21.i(list, "valueParameters");
            k21.i(list2, "typeParameters");
            k21.i(list3, "errors");
            this.a = g61;
            this.b = g612;
            this.c = list;
            this.d = list2;
            this.e = z;
            this.f = list3;
        }

        @NotNull
        public final List<String> a() {
            return this.f;
        }

        public final boolean b() {
            return this.e;
        }

        @Nullable
        public final g61 c() {
            return this.b;
        }

        @NotNull
        public final g61 d() {
            return this.a;
        }

        @NotNull
        public final List<TypeParameterDescriptor> e() {
            return this.d;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return k21.d(this.a, aVar.a) && k21.d(this.b, aVar.b) && k21.d(this.c, aVar.c) && k21.d(this.d, aVar.d) && this.e == aVar.e && k21.d(this.f, aVar.f);
        }

        @NotNull
        public final List<ValueParameterDescriptor> f() {
            return this.c;
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            g61 g61 = this.b;
            int hashCode2 = (((((hashCode + (g61 == null ? 0 : g61.hashCode())) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            boolean z = this.e;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return ((hashCode2 + i) * 31) + this.f.hashCode();
        }

        @NotNull
        public String toString() {
            return "MethodSignatureData(returnType=" + this.a + ", receiverType=" + this.b + ", valueParameters=" + this.c + ", typeParameters=" + this.d + ", hasStableParameterNames=" + this.e + ", errors=" + this.f + ')';
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public static final class b {
        @NotNull
        private final List<ValueParameterDescriptor> a;
        private final boolean b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull List<? extends ValueParameterDescriptor> list, boolean z) {
            k21.i(list, "descriptors");
            this.a = list;
            this.b = z;
        }

        @NotNull
        public final List<ValueParameterDescriptor> a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaScope(x61 x61, LazyJavaScope lazyJavaScope, int i2, m40 m40) {
        this(x61, (i2 & 2) != 0 ? null : lazyJavaScope);
    }

    /* access modifiers changed from: private */
    public final PropertyDescriptor C(JavaField javaField) {
        bv1 n = n(javaField);
        n.o(null, null, null, null);
        n.t(x(javaField), m.g(), s(), null);
        if (f60.K(n, n.getType())) {
            n.e(this.a.e().createNullableLazyValue(new LazyJavaScope$resolveProperty$1(this, javaField, n)));
        }
        this.a.a().g().recordField(javaField, n);
        return n;
    }

    /* access modifiers changed from: private */
    public final void E(Set<SimpleFunctionDescriptor> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String c2 = pd1.c((SimpleFunctionDescriptor) obj, false, false, 2, null);
            Object obj2 = linkedHashMap.get(c2);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(c2, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection<? extends SimpleFunctionDescriptor> a2 = OverridingUtilsKt.a(list, LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1.INSTANCE);
                set.removeAll(list);
                set.addAll(a2);
            }
        }
    }

    private final bv1 n(JavaField javaField) {
        u31 v = u31.v(v(), w61.a(this.a, javaField), Modality.FINAL, ku2.b(javaField.getVisibility()), !javaField.isFinal(), javaField.getName(), this.a.a().s().source(javaField), y(javaField));
        k21.h(v, "create(\n            ownerDescriptor, annotations, Modality.FINAL, field.visibility.toDescriptorVisibility(), isVar, field.name,\n            c.components.sourceElementFactory.source(field), /* isConst = */ field.isFinalStatic\n        )");
        return v;
    }

    private final Set<og1> q() {
        return (Set) te2.a(this.j, this, l[2]);
    }

    private final Set<og1> t() {
        return (Set) te2.a(this.h, this, l[0]);
    }

    private final Set<og1> w() {
        return (Set) te2.a(this.i, this, l[1]);
    }

    private final g61 x(JavaField javaField) {
        boolean z = false;
        g61 n = this.a.g().n(javaField.getType(), JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 3, null));
        if ((kotlin.reflect.jvm.internal.impl.builtins.b.y0(n) || kotlin.reflect.jvm.internal.impl.builtins.b.C0(n)) && y(javaField) && javaField.getHasConstantNotNullInitializer()) {
            z = true;
        }
        if (!z) {
            return n;
        }
        g61 n2 = bp2.n(n);
        k21.h(n2, "makeNotNullable(propertyType)");
        return n2;
    }

    private final boolean y(JavaField javaField) {
        return javaField.isFinal() && javaField.isStatic();
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract a A(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull g61 g61, @NotNull List<? extends ValueParameterDescriptor> list2);

    /* access modifiers changed from: protected */
    @NotNull
    public final JavaMethodDescriptor B(@NotNull JavaMethod javaMethod) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> map;
        k21.i(javaMethod, "method");
        JavaMethodDescriptor J = JavaMethodDescriptor.J(v(), w61.a(this.a, javaMethod), javaMethod.getName(), this.a.a().s().source(javaMethod), ((DeclaredMemberIndex) this.d.invoke()).findRecordComponentByName(javaMethod.getName()) != null && javaMethod.getValueParameters().isEmpty());
        k21.h(J, "createJavaMethod(\n            ownerDescriptor, annotations, method.name, c.components.sourceElementFactory.source(method),\n            declaredMemberIndex().findRecordComponentByName(method.name) != null && method.valueParameters.isEmpty()\n        )");
        x61 f2 = ContextKt.f(this.a, J, javaMethod, 0, 4, null);
        List<JavaTypeParameter> typeParameters = javaMethod.getTypeParameters();
        List<? extends TypeParameterDescriptor> arrayList = new ArrayList<>(n.q(typeParameters, 10));
        for (JavaTypeParameter javaTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter = f2.f().resolveTypeParameter(javaTypeParameter);
            k21.f(resolveTypeParameter);
            arrayList.add(resolveTypeParameter);
        }
        b D = D(f2, J, javaMethod.getValueParameters());
        a A = A(javaMethod, arrayList, j(javaMethod, f2), D.a());
        g61 c2 = A.c();
        if (c2 == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = z50.f(J, c2, Annotations.Companion.b());
        }
        ReceiverParameterDescriptor s = s();
        List<TypeParameterDescriptor> e2 = A.e();
        List<ValueParameterDescriptor> f3 = A.f();
        g61 d2 = A.d();
        Modality a2 = Modality.Companion.a(false, javaMethod.isAbstract(), !javaMethod.isFinal());
        h60 b2 = ku2.b(javaMethod.getVisibility());
        if (A.c() != null) {
            map = w.f(do2.a(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, k.P(D.a())));
        } else {
            map = x.i();
        }
        J.I(receiverParameterDescriptor, s, e2, f3, d2, a2, b2, map);
        J.M(A.b(), D.b());
        if (!A.a().isEmpty()) {
            f2.a().r().reportSignatureErrors(J, A.a());
        }
        return J;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0122  */
    @NotNull
    public final b D(@NotNull x61 x61, @NotNull FunctionDescriptor functionDescriptor, @NotNull List<? extends JavaValueParameter> list) {
        String str;
        Pair pair;
        og1 name;
        x61 x612 = x61;
        k21.i(x612, c.a);
        k21.i(functionDescriptor, Subject.FUNCTION);
        k21.i(list, "jValueParameters");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterable<s01> iterable = CollectionsKt___CollectionsKt.E0(list);
        ArrayList arrayList = new ArrayList(n.q(iterable, 10));
        boolean z = false;
        boolean z2 = false;
        for (s01 s01 : iterable) {
            int a2 = s01.a();
            JavaValueParameter javaValueParameter = (JavaValueParameter) s01.b();
            Annotations a3 = w61.a(x612, javaValueParameter);
            JavaArrayType javaArrayType = null;
            y31 f2 = JavaTypeResolverKt.f(TypeUsage.COMMON, z, null, 3, null);
            en0 en0 = u41.PARAMETER_NAME_FQ_NAME;
            k21.h(en0, "PARAMETER_NAME_FQ_NAME");
            AnnotationDescriptor findAnnotation = a3.findAnnotation(en0);
            om<?> b2 = findAnnotation == null ? null : DescriptorUtilsKt.b(findAnnotation);
            if (b2 != null) {
                if (!(b2 instanceof bg2)) {
                    b2 = null;
                }
                bg2 bg2 = (bg2) b2;
                if (bg2 != null) {
                    str = (String) bg2.b();
                    if (!javaValueParameter.isVararg()) {
                        JavaType type = javaValueParameter.getType();
                        if (type instanceof JavaArrayType) {
                            javaArrayType = (JavaArrayType) type;
                        }
                        if (javaArrayType != null) {
                            g61 j2 = x61.g().j(javaArrayType, f2, true);
                            pair = do2.a(j2, x61.d().getBuiltIns().k(j2));
                        } else {
                            throw new AssertionError(k21.r("Vararg parameter should be an array: ", javaValueParameter));
                        }
                    } else {
                        pair = do2.a(x61.g().n(javaValueParameter.getType(), f2), null);
                    }
                    g61 g61 = (g61) pair.component1();
                    g61 g612 = (g61) pair.component2();
                    if (k21.d(functionDescriptor.getName().b(), "equals") || list.size() != 1 || !k21.d(x61.d().getBuiltIns().I(), g61)) {
                        if (str != null) {
                            if ((str.length() > 0) && linkedHashSet.add(str)) {
                                name = og1.f(str);
                            }
                        }
                        name = javaValueParameter.getName();
                        if (name == null) {
                            z2 = true;
                        }
                        if (name == null) {
                            name = og1.f(k21.r("p", Integer.valueOf(a2)));
                            k21.h(name, "identifier(\"p$index\")");
                        }
                    } else {
                        name = og1.f("other");
                    }
                    k21.h(name, "if (function.name.asString() == \"equals\" &&\n                jValueParameters.size == 1 &&\n                c.module.builtIns.nullableAnyType == outType\n            ) {\n                // This is a hack to prevent numerous warnings on Kotlin classes that inherit Java classes: if you override \"equals\" in such\n                // class without this hack, you'll be warned that in the superclass the name is \"p0\" (regardless of the fact that it's\n                // \"other\" in Any)\n                // TODO: fix Java parameter name loading logic somehow (don't always load \"p0\", \"p1\", etc.)\n                Name.identifier(\"other\")\n            } else if (parameterName != null && parameterName.isNotEmpty() && usedNames.add(parameterName)) {\n                Name.identifier(parameterName)\n            } else {\n                // TODO: parameter names may be drawn from attached sources, which is slow; it's better to make them lazy\n                val javaName = javaParameter.name\n                if (javaName == null) synthesizedNames = true\n                javaName ?: Name.identifier(\"p$index\")\n            }");
                    arrayList.add(new ValueParameterDescriptorImpl(functionDescriptor, null, a2, a3, name, g61, false, false, false, g612, x61.a().s().source(javaValueParameter)));
                    arrayList = arrayList;
                    z2 = z2;
                    z = false;
                    x612 = x61;
                }
            }
            str = null;
            if (!javaValueParameter.isVararg()) {
            }
            g61 g613 = (g61) pair.component1();
            g61 g6122 = (g61) pair.component2();
            if (k21.d(functionDescriptor.getName().b(), "equals")) {
            }
            if (str != null) {
            }
            name = javaValueParameter.getName();
            if (name == null) {
            }
            if (name == null) {
            }
            k21.h(name, "if (function.name.asString() == \"equals\" &&\n                jValueParameters.size == 1 &&\n                c.module.builtIns.nullableAnyType == outType\n            ) {\n                // This is a hack to prevent numerous warnings on Kotlin classes that inherit Java classes: if you override \"equals\" in such\n                // class without this hack, you'll be warned that in the superclass the name is \"p0\" (regardless of the fact that it's\n                // \"other\" in Any)\n                // TODO: fix Java parameter name loading logic somehow (don't always load \"p0\", \"p1\", etc.)\n                Name.identifier(\"other\")\n            } else if (parameterName != null && parameterName.isNotEmpty() && usedNames.add(parameterName)) {\n                Name.identifier(parameterName)\n            } else {\n                // TODO: parameter names may be drawn from attached sources, which is slow; it's better to make them lazy\n                val javaName = javaParameter.name\n                if (javaName == null) synthesizedNames = true\n                javaName ?: Name.identifier(\"p$index\")\n            }");
            arrayList.add(new ValueParameterDescriptorImpl(functionDescriptor, null, a2, a3, name, g613, false, false, false, g6122, x61.a().s().source(javaValueParameter)));
            arrayList = arrayList;
            z2 = z2;
            z = false;
            x612 = x61;
        }
        return new b(CollectionsKt___CollectionsKt.y0(arrayList), z2);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract Set<og1> e(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1);

    /* access modifiers changed from: protected */
    @NotNull
    public final List<DeclarationDescriptor> f(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (b60.a(b60.Companion.d())) {
            for (og1 og1 : e(b60, function1)) {
                if (function1.invoke(og1).booleanValue()) {
                    qj.a(linkedHashSet, getContributedClassifier(og1, noLookupLocation));
                }
            }
        }
        if (b60.a(b60.Companion.e()) && !b60.n().contains(a60.a.INSTANCE)) {
            for (og1 og12 : g(b60, function1)) {
                if (function1.invoke(og12).booleanValue()) {
                    linkedHashSet.addAll(getContributedFunctions(og12, noLookupLocation));
                }
            }
        }
        if (b60.a(b60.Companion.k()) && !b60.n().contains(a60.a.INSTANCE)) {
            for (og1 og13 : m(b60, function1)) {
                if (function1.invoke(og13).booleanValue()) {
                    linkedHashSet.addAll(getContributedVariables(og13, noLookupLocation));
                }
            }
        }
        return CollectionsKt___CollectionsKt.y0(linkedHashSet);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract Set<og1> g(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1);

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getClassifierNames() {
        return q();
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        return (Collection) this.c.invoke();
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        if (!getFunctionNames().contains(og1)) {
            return m.g();
        }
        return this.g.invoke(og1);
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        if (!getVariableNames().contains(og1)) {
            return m.g();
        }
        return this.k.invoke(og1);
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getFunctionNames() {
        return t();
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getVariableNames() {
        return w();
    }

    /* access modifiers changed from: protected */
    public void h(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull og1 og1) {
        k21.i(collection, "result");
        k21.i(og1, "name");
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract DeclaredMemberIndex i();

    /* access modifiers changed from: protected */
    @NotNull
    public final g61 j(@NotNull JavaMethod javaMethod, @NotNull x61 x61) {
        k21.i(javaMethod, "method");
        k21.i(x61, c.a);
        return x61.g().n(javaMethod.getReturnType(), JavaTypeResolverKt.f(TypeUsage.COMMON, javaMethod.getContainingClass().isAnnotationType(), null, 2, null));
    }

    /* access modifiers changed from: protected */
    public abstract void k(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull og1 og1);

    /* access modifiers changed from: protected */
    public abstract void l(@NotNull og1 og1, @NotNull Collection<PropertyDescriptor> collection);

    /* access modifiers changed from: protected */
    @NotNull
    public abstract Set<og1> m(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1);

    /* access modifiers changed from: protected */
    @NotNull
    public final NotNullLazyValue<Collection<DeclarationDescriptor>> o() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final x61 p() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final NotNullLazyValue<DeclaredMemberIndex> r() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract ReceiverParameterDescriptor s();

    @NotNull
    public String toString() {
        return k21.r("Lazy scope for ", v());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final LazyJavaScope u() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract DeclarationDescriptor v();

    /* access modifiers changed from: protected */
    public boolean z(@NotNull JavaMethodDescriptor javaMethodDescriptor) {
        k21.i(javaMethodDescriptor, "<this>");
        return true;
    }

    public LazyJavaScope(@NotNull x61 x61, @Nullable LazyJavaScope lazyJavaScope) {
        k21.i(x61, c.a);
        this.a = x61;
        this.b = lazyJavaScope;
        this.c = x61.e().createRecursionTolerantLazyValue(new LazyJavaScope$allDescriptors$1(this), m.g());
        this.d = x61.e().createLazyValue(new LazyJavaScope$declaredMemberIndex$1(this));
        this.e = x61.e().createMemoizedFunction(new LazyJavaScope$declaredFunctions$1(this));
        this.f = x61.e().createMemoizedFunctionWithNullableValues(new LazyJavaScope$declaredField$1(this));
        this.g = x61.e().createMemoizedFunction(new LazyJavaScope$functions$1(this));
        this.h = x61.e().createLazyValue(new LazyJavaScope$functionNamesLazy$2(this));
        this.i = x61.e().createLazyValue(new LazyJavaScope$propertyNamesLazy$2(this));
        this.j = x61.e().createLazyValue(new LazyJavaScope$classNamesLazy$2(this));
        this.k = x61.e().createMemoizedFunction(new LazyJavaScope$properties$1(this));
    }
}
