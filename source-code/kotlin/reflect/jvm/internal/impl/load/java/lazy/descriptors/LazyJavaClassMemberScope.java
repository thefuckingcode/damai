package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f0;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b60;
import tb.bc2;
import tb.bp2;
import tb.c60;
import tb.cv1;
import tb.dv1;
import tb.en0;
import tb.f60;
import tb.fb2;
import tb.fn0;
import tb.g60;
import tb.g61;
import tb.h60;
import tb.j31;
import tb.k21;
import tb.ki;
import tb.ku2;
import tb.m40;
import tb.mi;
import tb.mu2;
import tb.o31;
import tb.og1;
import tb.p31;
import tb.pd1;
import tb.qj;
import tb.r31;
import tb.s31;
import tb.t41;
import tb.u31;
import tb.u41;
import tb.vt2;
import tb.w61;
import tb.x61;
import tb.xu2;
import tb.y31;
import tb.z50;
import tb.zu1;

/* compiled from: Taobao */
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    @NotNull
    private final ClassDescriptor m;
    @NotNull
    private final JavaClass n;
    private final boolean o;
    @NotNull
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> p;
    @NotNull
    private final NotNullLazyValue<Set<og1>> q;
    @NotNull
    private final NotNullLazyValue<Map<og1, JavaField>> r;
    @NotNull
    private final MemoizedFunctionToNullable<og1, mi> s;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaClassMemberScope(x61 x61, ClassDescriptor classDescriptor, JavaClass javaClass, boolean z, LazyJavaClassMemberScope lazyJavaClassMemberScope, int i, m40 m40) {
        this(x61, classDescriptor, javaClass, z, (i & 16) != 0 ? null : lazyJavaClassMemberScope);
    }

    /* access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> A0(og1 og1) {
        Collection<JavaMethod> findMethodsByName = ((DeclaredMemberIndex) r().invoke()).findMethodsByName(og1);
        ArrayList arrayList = new ArrayList(n.q(findMethodsByName, 10));
        Iterator<T> it = findMethodsByName.iterator();
        while (it.hasNext()) {
            arrayList.add(B(it.next()));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x000d A[SYNTHETIC] */
    public final Collection<SimpleFunctionDescriptor> B0(og1 og1) {
        boolean z;
        Set<SimpleFunctionDescriptor> q0 = q0(og1);
        ArrayList arrayList = new ArrayList();
        for (T t : q0) {
            T t2 = t;
            if (!SpecialBuiltinMembers.a(t2)) {
                BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
                if (BuiltinMethodsWithSpecialGenericSignature.k(t2) == null) {
                    z = false;
                    if (z) {
                        arrayList.add(t);
                    }
                }
            }
            z = true;
            if (z) {
            }
        }
        return arrayList;
    }

    private final boolean C0(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        og1 name = simpleFunctionDescriptor.getName();
        k21.h(name, "name");
        if (!builtinMethodsWithSpecialGenericSignature.l(name)) {
            return false;
        }
        og1 name2 = simpleFunctionDescriptor.getName();
        k21.h(name2, "name");
        Set<SimpleFunctionDescriptor> q0 = q0(name2);
        ArrayList<FunctionDescriptor> arrayList = new ArrayList();
        Iterator<T> it = q0.iterator();
        while (it.hasNext()) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature2 = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
            FunctionDescriptor k = BuiltinMethodsWithSpecialGenericSignature.k(it.next());
            if (k != null) {
                arrayList.add(k);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (FunctionDescriptor functionDescriptor : arrayList) {
            if (t0(simpleFunctionDescriptor, functionDescriptor)) {
                return true;
            }
        }
        return false;
    }

    private final void N(List<ValueParameterDescriptor> list, ConstructorDescriptor constructorDescriptor, int i, JavaMethod javaMethod, g61 g61, g61 g612) {
        g61 g613;
        Annotations b = Annotations.Companion.b();
        og1 name = javaMethod.getName();
        g61 n2 = bp2.n(g61);
        k21.h(n2, "makeNotNullable(returnType)");
        boolean hasAnnotationParameterDefaultValue = javaMethod.getHasAnnotationParameterDefaultValue();
        if (g612 == null) {
            g613 = null;
        } else {
            g613 = bp2.n(g612);
        }
        list.add(new ValueParameterDescriptorImpl(constructorDescriptor, null, i, b, name, n2, hasAnnotationParameterDefaultValue, false, false, g613, p().a().s().source(javaMethod)));
    }

    private final void O(Collection<SimpleFunctionDescriptor> collection, og1 og1, Collection<? extends SimpleFunctionDescriptor> collection2, boolean z) {
        Collection<? extends SimpleFunctionDescriptor> d = c60.d(og1, collection2, collection, v(), p().a().c(), p().a().j().getOverridingUtil());
        k21.h(d, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, result, ownerDescriptor, c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        if (!z) {
            collection.addAll(d);
            return;
        }
        List list = CollectionsKt___CollectionsKt.k0(collection, d);
        ArrayList arrayList = new ArrayList(n.q(d, 10));
        for (T t : d) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) SpecialBuiltinMembers.e(t);
            if (simpleFunctionDescriptor == null) {
                k21.h(t, "resolvedOverride");
            } else {
                k21.h(t, "resolvedOverride");
                t = Y(t, simpleFunctionDescriptor, list);
            }
            arrayList.add(t);
        }
        collection.addAll(arrayList);
    }

    private final void P(og1 og1, Collection<? extends SimpleFunctionDescriptor> collection, Collection<? extends SimpleFunctionDescriptor> collection2, Collection<SimpleFunctionDescriptor> collection3, Function1<? super og1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : collection2) {
            qj.a(collection3, w0(simpleFunctionDescriptor, function1, og1, collection));
            qj.a(collection3, v0(simpleFunctionDescriptor, function1, collection));
            qj.a(collection3, x0(simpleFunctionDescriptor, function1));
        }
    }

    private final void Q(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Set<PropertyDescriptor> set2, Function1<? super og1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (PropertyDescriptor propertyDescriptor : set) {
            u31 a0 = a0(propertyDescriptor, function1);
            if (a0 != null) {
                collection.add(a0);
                if (set2 != null) {
                    set2.add(propertyDescriptor);
                    return;
                }
                return;
            }
        }
    }

    private final void R(og1 og1, Collection<PropertyDescriptor> collection) {
        JavaMethod javaMethod = (JavaMethod) k.p0(((DeclaredMemberIndex) r().invoke()).findMethodsByName(og1));
        if (javaMethod != null) {
            collection.add(c0(this, javaMethod, null, Modality.FINAL, 2, null));
        }
    }

    private final Collection<g61> U() {
        if (!this.o) {
            return p().a().j().getKotlinTypeRefiner().f(v());
        }
        Collection<g61> supertypes = v().getTypeConstructor().getSupertypes();
        k21.h(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        return supertypes;
    }

    private final List<ValueParameterDescriptor> V(ki kiVar) {
        Pair pair;
        Collection<JavaMethod> methods = this.n.getMethods();
        ArrayList arrayList = new ArrayList(methods.size());
        int i = 1;
        y31 f = JavaTypeResolverKt.f(TypeUsage.COMMON, true, null, 2, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (T t : methods) {
            if (k21.d(t.getName(), u41.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                arrayList2.add(t);
            } else {
                arrayList3.add(t);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.component1();
        List<JavaMethod> list2 = (List) pair2.component2();
        list.size();
        JavaMethod javaMethod = (JavaMethod) k.R(list);
        if (javaMethod != null) {
            JavaType returnType = javaMethod.getReturnType();
            if (returnType instanceof JavaArrayType) {
                JavaArrayType javaArrayType = (JavaArrayType) returnType;
                pair = new Pair(p().g().j(javaArrayType, f, true), p().g().n(javaArrayType.getComponentType(), f));
            } else {
                pair = new Pair(p().g().n(returnType, f), null);
            }
            N(arrayList, kiVar, 0, javaMethod, (g61) pair.component1(), (g61) pair.component2());
        }
        int i2 = 0;
        if (javaMethod == null) {
            i = 0;
        }
        for (JavaMethod javaMethod2 : list2) {
            N(arrayList, kiVar, i2 + i, javaMethod2, p().g().n(javaMethod2.getReturnType(), f), null);
            i2++;
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final ClassConstructorDescriptor W() {
        List<ValueParameterDescriptor> list;
        boolean isAnnotationType = this.n.isAnnotationType();
        if ((this.n.isInterface() || !this.n.hasDefaultConstructor()) && !isAnnotationType) {
            return null;
        }
        ClassDescriptor r0 = v();
        j31 M = j31.M(r0, Annotations.Companion.b(), true, p().a().s().source(this.n));
        k21.h(M, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        if (isAnnotationType) {
            list = V(M);
        } else {
            list = Collections.emptyList();
        }
        M.t(false);
        M.J(list, o0(r0));
        M.s(true);
        M.A(r0.getDefaultType());
        p().a().g().recordConstructor(this.n, M);
        return M;
    }

    /* access modifiers changed from: private */
    public final ClassConstructorDescriptor X() {
        ClassDescriptor r0 = v();
        j31 M = j31.M(r0, Annotations.Companion.b(), true, p().a().s().source(this.n));
        k21.h(M, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        List<ValueParameterDescriptor> d0 = d0(M);
        M.t(false);
        M.J(d0, o0(r0));
        M.s(false);
        M.A(r0.getDefaultType());
        return M;
    }

    private final SimpleFunctionDescriptor Y(SimpleFunctionDescriptor simpleFunctionDescriptor, CallableDescriptor callableDescriptor, Collection<? extends SimpleFunctionDescriptor> collection) {
        boolean z;
        boolean z2 = false;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (k21.d(simpleFunctionDescriptor, next) || next.getInitialSignatureDescriptor() != null || !h0(next, callableDescriptor)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = true;
        if (z2) {
            return simpleFunctionDescriptor;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        k21.f(simpleFunctionDescriptor2);
        return simpleFunctionDescriptor2;
    }

    private final SimpleFunctionDescriptor Z(FunctionDescriptor functionDescriptor, Function1<? super og1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        Object obj;
        og1 name = functionDescriptor.getName();
        k21.h(name, "overridden.name");
        Iterator it = ((Iterable) function1.invoke(name)).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (t0((SimpleFunctionDescriptor) obj, functionDescriptor)) {
                break;
            }
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        k21.h(valueParameters, "overridden.valueParameters");
        ArrayList arrayList = new ArrayList(n.q(valueParameters, 10));
        for (T t : valueParameters) {
            g61 type = t.getType();
            k21.h(type, "it.type");
            arrayList.add(new xu2(type, t.declaresDefaultValue()));
        }
        List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
        k21.h(valueParameters2, "override.valueParameters");
        newCopyBuilder.setValueParameters(vt2.a(arrayList, valueParameters2, functionDescriptor));
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        return (SimpleFunctionDescriptor) newCopyBuilder.build();
    }

    private final u31 a0(PropertyDescriptor propertyDescriptor, Function1<? super og1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        dv1 dv1 = null;
        if (!g0(propertyDescriptor, function1)) {
            return null;
        }
        SimpleFunctionDescriptor m0 = m0(propertyDescriptor, function1);
        k21.f(m0);
        if (propertyDescriptor.isVar()) {
            simpleFunctionDescriptor = n0(propertyDescriptor, function1);
            k21.f(simpleFunctionDescriptor);
        } else {
            simpleFunctionDescriptor = null;
        }
        if (simpleFunctionDescriptor != null) {
            simpleFunctionDescriptor.getModality();
            m0.getModality();
        }
        r31 r31 = new r31(v(), m0, simpleFunctionDescriptor, propertyDescriptor);
        g61 returnType = m0.getReturnType();
        k21.f(returnType);
        r31.t(returnType, m.g(), s(), null);
        cv1 h = z50.h(r31, m0.getAnnotations(), false, false, false, m0.getSource());
        h.h(m0);
        h.k(r31.getType());
        k21.h(h, "createGetter(\n            propertyDescriptor, getterMethod.annotations, /* isDefault = */false,\n            /* isExternal = */ false, /* isInline = */ false, getterMethod.source\n        ).apply {\n            initialSignatureDescriptor = getterMethod\n            initialize(propertyDescriptor.type)\n        }");
        if (simpleFunctionDescriptor != null) {
            List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
            k21.h(valueParameters, "setterMethod.valueParameters");
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) k.R(valueParameters);
            if (valueParameterDescriptor != null) {
                dv1 = z50.k(r31, simpleFunctionDescriptor.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, false, false, simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor.getSource());
                dv1.h(simpleFunctionDescriptor);
            } else {
                throw new AssertionError(k21.r("No parameter found for ", simpleFunctionDescriptor));
            }
        }
        r31.n(h, dv1);
        return r31;
    }

    private final u31 b0(JavaMethod javaMethod, g61 g61, Modality modality) {
        u31 v = u31.v(v(), w61.a(p(), javaMethod), modality, ku2.b(javaMethod.getVisibility()), false, javaMethod.getName(), p().a().s().source(javaMethod), false);
        k21.h(v, "create(\n            ownerDescriptor, annotations, modality, method.visibility.toDescriptorVisibility(),\n            /* isVar = */ false, method.name, c.components.sourceElementFactory.source(method),\n            /* isStaticFinal = */ false\n        )");
        cv1 b = z50.b(v, Annotations.Companion.b());
        k21.h(b, "createDefaultGetter(propertyDescriptor, Annotations.EMPTY)");
        v.n(b, null);
        g61 j = g61 == null ? j(javaMethod, ContextKt.f(p(), v, javaMethod, 0, 4, null)) : g61;
        v.t(j, m.g(), s(), null);
        b.k(j);
        return v;
    }

    static /* synthetic */ u31 c0(LazyJavaClassMemberScope lazyJavaClassMemberScope, JavaMethod javaMethod, g61 g61, Modality modality, int i, Object obj) {
        if ((i & 2) != 0) {
            g61 = null;
        }
        return lazyJavaClassMemberScope.b0(javaMethod, g61, modality);
    }

    private final List<ValueParameterDescriptor> d0(ki kiVar) {
        Collection<JavaRecordComponent> recordComponents = this.n.getRecordComponents();
        ArrayList arrayList = new ArrayList(recordComponents.size());
        g61 g61 = null;
        y31 f = JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 2, null);
        int i = 0;
        for (JavaRecordComponent javaRecordComponent : recordComponents) {
            int i2 = i + 1;
            g61 n2 = p().g().n(javaRecordComponent.getType(), f);
            arrayList.add(new ValueParameterDescriptorImpl(kiVar, null, i, Annotations.Companion.b(), javaRecordComponent.getName(), n2, false, false, false, javaRecordComponent.isVararg() ? p().a().l().getBuiltIns().k(n2) : g61, p().a().s().source(javaRecordComponent)));
            i = i2;
            g61 = null;
        }
        return arrayList;
    }

    private final SimpleFunctionDescriptor e0(SimpleFunctionDescriptor simpleFunctionDescriptor, og1 og1) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setName(og1);
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) newCopyBuilder.build();
        k21.f(simpleFunctionDescriptor2);
        return simpleFunctionDescriptor2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        if (tb.eh2.a(r3, p().a().p().isReleaseCoroutines()) == false) goto L_0x0012;
     */
    private final SimpleFunctionDescriptor f0(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        en0 en0;
        List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
        k21.h(valueParameters, "valueParameters");
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) k.d0(valueParameters);
        if (valueParameterDescriptor != null) {
            ClassifierDescriptor declarationDescriptor = valueParameterDescriptor.getType().c().getDeclarationDescriptor();
            fn0 j = declarationDescriptor == null ? null : DescriptorUtilsKt.j(declarationDescriptor);
            if (j != null) {
                if (!j.f()) {
                    j = null;
                }
                if (j != null) {
                    en0 = j.l();
                }
            }
            en0 = null;
        }
        valueParameterDescriptor = null;
        if (valueParameterDescriptor == null) {
            return null;
        }
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
        k21.h(valueParameters2, "valueParameters");
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) newCopyBuilder.setValueParameters(CollectionsKt___CollectionsKt.M(valueParameters2, 1)).setReturnType(valueParameterDescriptor.getType().b().get(0).getType()).build();
        fb2 fb2 = (fb2) simpleFunctionDescriptor2;
        if (fb2 != null) {
            fb2.B(true);
        }
        return simpleFunctionDescriptor2;
    }

    private final boolean g0(PropertyDescriptor propertyDescriptor, Function1<? super og1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (o31.a(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor m0 = m0(propertyDescriptor, function1);
        SimpleFunctionDescriptor n0 = n0(propertyDescriptor, function1);
        if (m0 == null) {
            return false;
        }
        if (!propertyDescriptor.isVar()) {
            return true;
        }
        if (n0 == null || n0.getModality() != m0.getModality()) {
            return false;
        }
        return true;
    }

    private final boolean h0(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil.OverrideCompatibilityInfo.Result c = OverridingUtil.DEFAULT.I(callableDescriptor2, callableDescriptor, true).c();
        k21.h(c, "DEFAULT.isOverridableByWithoutExternalConditions(superDescriptor, this, true).result");
        if (c != OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE || s31.Companion.a(callableDescriptor2, callableDescriptor)) {
            return false;
        }
        return true;
    }

    private final boolean i0(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        boolean z;
        BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.INSTANCE;
        og1 name = simpleFunctionDescriptor.getName();
        k21.h(name, "name");
        List<og1> i = builtinMethodsWithDifferentJvmName.i(name);
        if (!(i instanceof Collection) || !i.isEmpty()) {
            for (T t : i) {
                Set<SimpleFunctionDescriptor> q0 = q0(t);
                ArrayList arrayList = new ArrayList();
                for (T t2 : q0) {
                    if (SpecialBuiltinMembers.a(t2)) {
                        arrayList.add(t2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    SimpleFunctionDescriptor e0 = e0(simpleFunctionDescriptor, t);
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (j0((SimpleFunctionDescriptor) it.next(), e0)) {
                                    z = true;
                                    continue;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
                z = false;
                continue;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean j0(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        if (BuiltinMethodsWithDifferentJvmName.INSTANCE.m(simpleFunctionDescriptor)) {
            functionDescriptor = functionDescriptor.getOriginal();
        }
        k21.h(functionDescriptor, "if (superDescriptor.isRemoveAtByIndex) subDescriptor.original else subDescriptor");
        return h0(functionDescriptor, simpleFunctionDescriptor);
    }

    private final boolean k0(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        boolean z;
        SimpleFunctionDescriptor f0 = f0(simpleFunctionDescriptor);
        if (f0 == null) {
            return false;
        }
        og1 name = simpleFunctionDescriptor.getName();
        k21.h(name, "name");
        Set<SimpleFunctionDescriptor> q0 = q0(name);
        if ((q0 instanceof Collection) && q0.isEmpty()) {
            return false;
        }
        for (T t : q0) {
            if (!t.isSuspend() || !h0(f0, t)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private final SimpleFunctionDescriptor l0(PropertyDescriptor propertyDescriptor, String str, Function1<? super og1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        og1 f = og1.f(str);
        k21.h(f, "identifier(getterName)");
        Iterator it = ((Iterable) function1.invoke(f)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                g61 returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null ? false : kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor m0(PropertyDescriptor propertyDescriptor, Function1<? super og1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        String str = null;
        PropertyGetterDescriptor propertyGetterDescriptor = getter == null ? null : (PropertyGetterDescriptor) SpecialBuiltinMembers.d(getter);
        if (propertyGetterDescriptor != null) {
            str = ClassicBuiltinSpecialProperties.INSTANCE.a(propertyGetterDescriptor);
        }
        if (str != null && !SpecialBuiltinMembers.f(v(), propertyGetterDescriptor)) {
            return l0(propertyDescriptor, str, function1);
        }
        t41 t41 = t41.INSTANCE;
        String b = propertyDescriptor.getName().b();
        k21.h(b, "name.asString()");
        return l0(propertyDescriptor, t41.a(b), function1);
    }

    private final SimpleFunctionDescriptor n0(PropertyDescriptor propertyDescriptor, Function1<? super og1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        g61 returnType;
        t41 t41 = t41.INSTANCE;
        String b = propertyDescriptor.getName().b();
        k21.h(b, "name.asString()");
        og1 f = og1.f(t41.d(b));
        k21.h(f, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator it = ((Iterable) function1.invoke(f)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1 && (returnType = simpleFunctionDescriptor2.getReturnType()) != null && b.J0(returnType)) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                k21.h(valueParameters, "descriptor.valueParameters");
                if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) k.o0(valueParameters)).getType(), propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final h60 o0(ClassDescriptor classDescriptor) {
        h60 visibility = classDescriptor.getVisibility();
        k21.h(visibility, "classDescriptor.visibility");
        if (!k21.d(visibility, p31.PROTECTED_STATIC_VISIBILITY)) {
            return visibility;
        }
        h60 h60 = p31.PROTECTED_AND_PACKAGE;
        k21.h(h60, "PROTECTED_AND_PACKAGE");
        return h60;
    }

    private final Set<SimpleFunctionDescriptor> q0(og1 og1) {
        Collection<g61> U = U();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = U.iterator();
        while (it.hasNext()) {
            boolean unused = r.v(linkedHashSet, it.next().getMemberScope().getContributedFunctions(og1, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    private final Set<PropertyDescriptor> s0(og1 og1) {
        Collection<g61> U = U();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = U.iterator();
        while (it.hasNext()) {
            Collection<? extends PropertyDescriptor> contributedVariables = it.next().getMemberScope().getContributedVariables(og1, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(n.q(contributedVariables, 10));
            Iterator<T> it2 = contributedVariables.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next());
            }
            boolean unused = r.v(arrayList, arrayList2);
        }
        return CollectionsKt___CollectionsKt.C0(arrayList);
    }

    private final boolean t0(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        String c = pd1.c(simpleFunctionDescriptor, false, false, 2, null);
        FunctionDescriptor original = functionDescriptor.getOriginal();
        k21.h(original, "builtinWithErasedParameters.original");
        if (!k21.d(c, pd1.c(original, false, false, 2, null)) || h0(simpleFunctionDescriptor, functionDescriptor)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        if (tb.t41.c(r4) == false) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0079 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    private final boolean u0(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        og1 name = simpleFunctionDescriptor.getName();
        k21.h(name, "function.name");
        List<og1> a = zu1.a(name);
        if (!(a instanceof Collection) || !a.isEmpty()) {
            Iterator<T> it = a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Set<PropertyDescriptor> s0 = s0(it.next());
                if (!(s0 instanceof Collection) || !s0.isEmpty()) {
                    Iterator<T> it2 = s0.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        T next = it2.next();
                        if (g0(next, new LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1(simpleFunctionDescriptor, this))) {
                            if (!next.isVar()) {
                                t41 t41 = t41.INSTANCE;
                                String b = simpleFunctionDescriptor.getName().b();
                                k21.h(b, "function.name.asString()");
                            }
                            z3 = true;
                            continue;
                            if (z3) {
                                z2 = true;
                                continue;
                                break;
                            }
                        }
                        z3 = false;
                        continue;
                        if (z3) {
                        }
                    }
                    if (z2) {
                        z = true;
                        break;
                    }
                }
                z2 = false;
                continue;
                if (z2) {
                }
            }
            if (z || i0(simpleFunctionDescriptor) || C0(simpleFunctionDescriptor) || k0(simpleFunctionDescriptor)) {
                return false;
            }
        }
        z = false;
        return z;
    }

    private final SimpleFunctionDescriptor v0(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super og1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor Z;
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        FunctionDescriptor k = BuiltinMethodsWithSpecialGenericSignature.k(simpleFunctionDescriptor);
        if (k == null || (Z = Z(k, function1)) == null) {
            return null;
        }
        if (!u0(Z)) {
            Z = null;
        }
        if (Z == null) {
            return null;
        }
        return Y(Z, k, collection);
    }

    private final SimpleFunctionDescriptor w0(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super og1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, og1 og1, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.d(simpleFunctionDescriptor);
        if (simpleFunctionDescriptor2 == null) {
            return null;
        }
        String b = SpecialBuiltinMembers.b(simpleFunctionDescriptor2);
        k21.f(b);
        og1 f = og1.f(b);
        k21.h(f, "identifier(nameInJava)");
        for (SimpleFunctionDescriptor simpleFunctionDescriptor3 : (Collection) function1.invoke(f)) {
            SimpleFunctionDescriptor e0 = e0(simpleFunctionDescriptor3, og1);
            if (j0(simpleFunctionDescriptor2, e0)) {
                return Y(e0, simpleFunctionDescriptor2, collection);
            }
        }
        return null;
    }

    private final SimpleFunctionDescriptor x0(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super og1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (!simpleFunctionDescriptor.isSuspend()) {
            return null;
        }
        og1 name = simpleFunctionDescriptor.getName();
        k21.h(name, "descriptor.name");
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : (Iterable) function1.invoke(name)) {
            SimpleFunctionDescriptor f0 = f0(simpleFunctionDescriptor2);
            if (f0 == null || !h0(f0, simpleFunctionDescriptor)) {
                f0 = null;
                continue;
            }
            if (f0 != null) {
                return f0;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final j31 y0(JavaConstructor javaConstructor) {
        ClassDescriptor r0 = v();
        j31 M = j31.M(r0, w61.a(p(), javaConstructor), false, p().a().s().source(javaConstructor));
        k21.h(M, "createJavaConstructor(\n            classDescriptor,\n            c.resolveAnnotations(constructor), /* isPrimary = */\n            false,\n            c.components.sourceElementFactory.source(constructor)\n        )");
        x61 e = ContextKt.e(p(), M, javaConstructor, r0.getDeclaredTypeParameters().size());
        LazyJavaScope.b D = D(e, M, javaConstructor.getValueParameters());
        List<TypeParameterDescriptor> declaredTypeParameters = r0.getDeclaredTypeParameters();
        k21.h(declaredTypeParameters, "classDescriptor.declaredTypeParameters");
        List<JavaTypeParameter> typeParameters = javaConstructor.getTypeParameters();
        ArrayList arrayList = new ArrayList(n.q(typeParameters, 10));
        for (JavaTypeParameter javaTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter = e.f().resolveTypeParameter(javaTypeParameter);
            k21.f(resolveTypeParameter);
            arrayList.add(resolveTypeParameter);
        }
        M.K(D.a(), ku2.b(javaConstructor.getVisibility()), CollectionsKt___CollectionsKt.k0(declaredTypeParameters, arrayList));
        M.s(false);
        M.t(D.b());
        M.A(r0.getDefaultType());
        e.a().g().recordConstructor(javaConstructor, M);
        return M;
    }

    private final JavaMethodDescriptor z0(JavaRecordComponent javaRecordComponent) {
        JavaMethodDescriptor J = JavaMethodDescriptor.J(v(), w61.a(p(), javaRecordComponent), javaRecordComponent.getName(), p().a().s().source(javaRecordComponent), true);
        k21.h(J, "createJavaMethod(\n            ownerDescriptor, annotations, recordComponent.name, c.components.sourceElementFactory.source(recordComponent), true\n        )");
        J.I(null, s(), m.g(), m.g(), p().g().n(javaRecordComponent.getType(), JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 2, null)), Modality.Companion.a(false, false, true), g60.PUBLIC, null);
        J.M(false, false);
        p().a().g().recordMethod(javaRecordComponent, J);
        return J;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public LazyJavaScope.a A(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull g61 g61, @NotNull List<? extends ValueParameterDescriptor> list2) {
        k21.i(javaMethod, "method");
        k21.i(list, "methodTypeParameters");
        k21.i(g61, "returnType");
        k21.i(list2, "valueParameters");
        SignaturePropagator.b resolvePropagatedSignature = p().a().r().resolvePropagatedSignature(javaMethod, v(), g61, null, list2, list);
        k21.h(resolvePropagatedSignature, "c.components.signaturePropagator.resolvePropagatedSignature(\n            method, ownerDescriptor, returnType, null, valueParameters, methodTypeParameters\n        )");
        g61 d = resolvePropagatedSignature.d();
        k21.h(d, "propagated.returnType");
        g61 c = resolvePropagatedSignature.c();
        List<ValueParameterDescriptor> f = resolvePropagatedSignature.f();
        k21.h(f, "propagated.valueParameters");
        List<TypeParameterDescriptor> e = resolvePropagatedSignature.e();
        k21.h(e, "propagated.typeParameters");
        boolean g = resolvePropagatedSignature.g();
        List<String> b = resolvePropagatedSignature.b();
        k21.h(b, "propagated.errors");
        return new LazyJavaScope.a(d, c, f, e, g, b);
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: S */
    public LinkedHashSet<og1> g(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        Collection<g61> supertypes = v().getTypeConstructor().getSupertypes();
        k21.h(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<og1> linkedHashSet = new LinkedHashSet<>();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            boolean unused = r.v(linkedHashSet, it.next().getMemberScope().getFunctionNames());
        }
        linkedHashSet.addAll(((DeclaredMemberIndex) r().invoke()).getMethodNames());
        linkedHashSet.addAll(((DeclaredMemberIndex) r().invoke()).getRecordComponentNames());
        linkedHashSet.addAll(e(b60, function1));
        return linkedHashSet;
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: T */
    public ClassDeclaredMemberIndex i() {
        return new ClassDeclaredMemberIndex(this.n, LazyJavaClassMemberScope$computeMemberIndex$1.INSTANCE);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<og1> e(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        return f0.i((Set) this.q.invoke(), ((Map) this.r.invoke()).keySet());
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        MemoizedFunctionToNullable<og1, mi> memoizedFunctionToNullable;
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        recordLookup(og1, lookupLocation);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = (LazyJavaClassMemberScope) u();
        mi miVar = null;
        if (!(lazyJavaClassMemberScope == null || (memoizedFunctionToNullable = lazyJavaClassMemberScope.s) == null)) {
            miVar = memoizedFunctionToNullable.invoke(og1);
        }
        return miVar == null ? this.s.invoke(og1) : miVar;
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        recordLookup(og1, lookupLocation);
        return super.getContributedFunctions(og1, lookupLocation);
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        recordLookup(og1, lookupLocation);
        return super.getContributedVariables(og1, lookupLocation);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void h(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull og1 og1) {
        k21.i(collection, "result");
        k21.i(og1, "name");
        if (this.n.isRecord() && ((DeclaredMemberIndex) r().invoke()).findRecordComponentByName(og1) != null) {
            boolean z = true;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getValueParameters().isEmpty()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z) {
                JavaRecordComponent findRecordComponentByName = ((DeclaredMemberIndex) r().invoke()).findRecordComponentByName(og1);
                k21.f(findRecordComponentByName);
                collection.add(z0(findRecordComponentByName));
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void k(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull og1 og1) {
        boolean z;
        k21.i(collection, "result");
        k21.i(og1, "name");
        Set<SimpleFunctionDescriptor> q0 = q0(og1);
        if (!BuiltinMethodsWithDifferentJvmName.INSTANCE.k(og1) && !BuiltinMethodsWithSpecialGenericSignature.INSTANCE.l(og1)) {
            if (!(q0 instanceof Collection) || !q0.isEmpty()) {
                Iterator<T> it = q0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().isSuspend()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                ArrayList arrayList = new ArrayList();
                for (T t : q0) {
                    if (u0(t)) {
                        arrayList.add(t);
                    }
                }
                O(collection, og1, arrayList, false);
                return;
            }
        }
        bc2 a = bc2.Companion.a();
        Collection<? extends SimpleFunctionDescriptor> d = c60.d(og1, q0, m.g(), v(), ErrorReporter.DO_NOTHING, p().a().j().getOverridingUtil());
        k21.h(d, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, emptyList(), ownerDescriptor, ErrorReporter.DO_NOTHING,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        P(og1, collection, d, collection, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(this));
        P(og1, collection, d, a, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(this));
        ArrayList arrayList2 = new ArrayList();
        for (T t2 : q0) {
            if (u0(t2)) {
                arrayList2.add(t2);
            }
        }
        O(collection, og1, CollectionsKt___CollectionsKt.k0(arrayList2, a), true);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void l(@NotNull og1 og1, @NotNull Collection<PropertyDescriptor> collection) {
        k21.i(og1, "name");
        k21.i(collection, "result");
        if (this.n.isAnnotationType()) {
            R(og1, collection);
        }
        Set<PropertyDescriptor> s0 = s0(og1);
        if (!s0.isEmpty()) {
            bc2.b bVar = bc2.Companion;
            bc2 a = bVar.a();
            bc2 a2 = bVar.a();
            Q(s0, collection, a, new LazyJavaClassMemberScope$computeNonDeclaredProperties$1(this));
            Q(f0.h(s0, a), a2, null, new LazyJavaClassMemberScope$computeNonDeclaredProperties$2(this));
            Collection<? extends PropertyDescriptor> d = c60.d(og1, f0.i(s0, a2), collection, v(), p().a().c(), p().a().j().getOverridingUtil());
            k21.h(d, "resolveOverridesForNonStaticMembers(\n                name,\n                propertiesFromSupertypes + propertiesOverridesFromSuperTypes,\n                result,\n                ownerDescriptor,\n                c.components.errorReporter,\n                c.components.kotlinTypeChecker.overridingUtil\n            )");
            collection.addAll(d);
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<og1> m(@NotNull b60 b60, @Nullable Function1<? super og1, Boolean> function1) {
        k21.i(b60, "kindFilter");
        if (this.n.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((DeclaredMemberIndex) r().invoke()).getFieldNames());
        Collection<g61> supertypes = v().getTypeConstructor().getSupertypes();
        k21.h(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            boolean unused = r.v(linkedHashSet, it.next().getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    @NotNull
    public final NotNullLazyValue<List<ClassConstructorDescriptor>> p0() {
        return this.p;
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: r0 */
    public ClassDescriptor v() {
        return this.m;
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        mu2.a(p().a().k(), lookupLocation, v(), og1);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @Nullable
    public ReceiverParameterDescriptor s() {
        return f60.l(v());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public String toString() {
        return k21.r("Lazy Java member scope for ", this.n.getFqName());
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public boolean z(@NotNull JavaMethodDescriptor javaMethodDescriptor) {
        k21.i(javaMethodDescriptor, "<this>");
        if (this.n.isAnnotationType()) {
            return false;
        }
        return u0(javaMethodDescriptor);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope(@NotNull x61 x61, @NotNull ClassDescriptor classDescriptor, @NotNull JavaClass javaClass, boolean z, @Nullable LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(x61, lazyJavaClassMemberScope);
        k21.i(x61, c.a);
        k21.i(classDescriptor, "ownerDescriptor");
        k21.i(javaClass, "jClass");
        this.m = classDescriptor;
        this.n = javaClass;
        this.o = z;
        this.p = x61.e().createLazyValue(new LazyJavaClassMemberScope$constructors$1(this, x61));
        this.q = x61.e().createLazyValue(new LazyJavaClassMemberScope$nestedClassIndex$1(this));
        this.r = x61.e().createLazyValue(new LazyJavaClassMemberScope$enumEntryIndex$1(this));
        this.s = x61.e().createMemoizedFunctionWithNullableValues(new LazyJavaClassMemberScope$nestedClasses$1(this, x61));
    }
}
