package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import tb.bc2;
import tb.dz1;
import tb.e60;
import tb.en0;
import tb.fn0;
import tb.g60;
import tb.g61;
import tb.ib2;
import tb.in1;
import tb.jb1;
import tb.k21;
import tb.ni;
import tb.od1;
import tb.og1;
import tb.oi;
import tb.pd1;
import tb.qg1;
import tb.qq1;
import tb.te2;
import tb.ue1;
import tb.w31;
import tb.x31;
import tb.x41;
import tb.zi;

/* compiled from: Taobao */
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty<Object>[] h = {dz1.i(new PropertyReference1Impl(dz1.b(JvmBuiltInsCustomizer.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), dz1.i(new PropertyReference1Impl(dz1.b(JvmBuiltInsCustomizer.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), dz1.i(new PropertyReference1Impl(dz1.b(JvmBuiltInsCustomizer.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    @NotNull
    private final ModuleDescriptor a;
    @NotNull
    private final x31 b = x31.INSTANCE;
    @NotNull
    private final NotNullLazyValue c;
    @NotNull
    private final g61 d;
    @NotNull
    private final NotNullLazyValue e;
    @NotNull
    private final CacheWithNotNullValues<en0, ClassDescriptor> f;
    @NotNull
    private final NotNullLazyValue g;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum JDKMemberStatus {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JDKMemberStatus.values().length];
            iArr[JDKMemberStatus.HIDDEN.ordinal()] = 1;
            iArr[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 2;
            iArr[JDKMemberStatus.DROP.ordinal()] = 3;
            iArr[JDKMemberStatus.VISIBLE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Taobao */
    public static final class b extends in1 {
        b(ModuleDescriptor moduleDescriptor, en0 en0) {
            super(moduleDescriptor, en0);
        }

        @NotNull
        /* renamed from: d */
        public MemberScope.b getMemberScope() {
            return MemberScope.b.INSTANCE;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class c implements DFS.Neighbors<ClassDescriptor> {
        final /* synthetic */ JvmBuiltInsCustomizer a;

        c(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
            this.a = jvmBuiltInsCustomizer;
        }

        @NotNull
        /* renamed from: a */
        public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor) {
            Collection<g61> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            k21.h(supertypes, "it.typeConstructor.supertypes");
            JvmBuiltInsCustomizer jvmBuiltInsCustomizer = this.a;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                ClassifierDescriptor declarationDescriptor = it.next().c().getDeclarationDescriptor();
                LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
                ClassifierDescriptor original = declarationDescriptor == null ? null : declarationDescriptor.getOriginal();
                ClassDescriptor classDescriptor2 = original instanceof ClassDescriptor ? (ClassDescriptor) original : null;
                if (classDescriptor2 != null) {
                    lazyJavaClassDescriptor = jvmBuiltInsCustomizer.k(classDescriptor2);
                }
                if (lazyJavaClassDescriptor != null) {
                    arrayList.add(lazyJavaClassDescriptor);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: Taobao */
    public static final class d extends DFS.b<ClassDescriptor, JDKMemberStatus> {
        final /* synthetic */ String a;
        final /* synthetic */ Ref$ObjectRef<JDKMemberStatus> b;

        d(String str, Ref$ObjectRef<JDKMemberStatus> ref$ObjectRef) {
            this.a = str;
            this.b = ref$ObjectRef;
        }

        /* renamed from: a */
        public boolean beforeChildren(@NotNull ClassDescriptor classDescriptor) {
            k21.i(classDescriptor, "javaClassDescriptor");
            String a2 = od1.a(SignatureBuildingComponents.INSTANCE, classDescriptor, this.a);
            x41 x41 = x41.INSTANCE;
            if (x41.e().contains(a2)) {
                this.b.element = (T) JDKMemberStatus.HIDDEN;
            } else if (x41.h().contains(a2)) {
                this.b.element = (T) JDKMemberStatus.VISIBLE;
            } else if (x41.c().contains(a2)) {
                this.b.element = (T) JDKMemberStatus.DROP;
            }
            return this.b.element == null;
        }

        @NotNull
        /* renamed from: b */
        public JDKMemberStatus result() {
            T t = this.b.element;
            return t == null ? JDKMemberStatus.NOT_CONSIDERED : t;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class e implements DFS.Neighbors<CallableMemberDescriptor> {
        public static final e INSTANCE = new e();

        e() {
        }

        @NotNull
        /* renamed from: a */
        public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor.getOriginal().getOverriddenDescriptors();
        }
    }

    public JvmBuiltInsCustomizer(@NotNull ModuleDescriptor moduleDescriptor, @NotNull StorageManager storageManager, @NotNull Function0<JvmBuiltIns.a> function0) {
        k21.i(moduleDescriptor, "moduleDescriptor");
        k21.i(storageManager, "storageManager");
        k21.i(function0, "settingsComputation");
        this.a = moduleDescriptor;
        this.c = storageManager.createLazyValue(function0);
        this.d = f(storageManager);
        this.e = storageManager.createLazyValue(new JvmBuiltInsCustomizer$cloneableType$2(this, storageManager));
        this.f = storageManager.createCacheWithNotNullValues();
        this.g = storageManager.createLazyValue(new JvmBuiltInsCustomizer$notConsideredDeprecation$2(this));
    }

    private final SimpleFunctionDescriptor e(DeserializedClassDescriptor deserializedClassDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setOwner(deserializedClassDescriptor);
        newCopyBuilder.setVisibility(g60.PUBLIC);
        newCopyBuilder.setReturnType(deserializedClassDescriptor.getDefaultType());
        newCopyBuilder.setDispatchReceiverParameter(deserializedClassDescriptor.getThisAsReceiverParameter());
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) newCopyBuilder.build();
        k21.f(simpleFunctionDescriptor2);
        return simpleFunctionDescriptor2;
    }

    private final g61 f(StorageManager storageManager) {
        ni niVar = new ni(new b(this.a, new en0("java.io")), og1.f("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, l.e(new LazyWrappedType(storageManager, new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1(this))), SourceElement.NO_SOURCE, false, storageManager);
        niVar.e(MemberScope.b.INSTANCE, e0.d(), null);
        ib2 defaultType = niVar.getDefaultType();
        k21.h(defaultType, "mockSerializableClass.defaultType");
        return defaultType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e7, code lost:
        if (o(r3, r10) == false) goto L_0x00e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e3  */
    private final Collection<SimpleFunctionDescriptor> g(ClassDescriptor classDescriptor, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        boolean z;
        LazyJavaClassDescriptor k = k(classDescriptor);
        if (k == null) {
            return m.g();
        }
        Collection<ClassDescriptor> i = this.b.i(DescriptorUtilsKt.i(k), a.Companion.a());
        ClassDescriptor classDescriptor2 = (ClassDescriptor) k.c0(i);
        if (classDescriptor2 == null) {
            return m.g();
        }
        bc2.b bVar = bc2.Companion;
        ArrayList arrayList = new ArrayList(n.q(i, 10));
        Iterator<T> it = i.iterator();
        while (it.hasNext()) {
            arrayList.add(DescriptorUtilsKt.i(it.next()));
        }
        bc2 b2 = bVar.b(arrayList);
        boolean c2 = this.b.c(classDescriptor);
        MemberScope unsubstitutedMemberScope = this.f.computeIfAbsent(DescriptorUtilsKt.i(k), new JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1(k, classDescriptor2)).getUnsubstitutedMemberScope();
        k21.h(unsubstitutedMemberScope, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : (Iterable) function1.invoke(unsubstitutedMemberScope)) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
            boolean z2 = true;
            if (simpleFunctionDescriptor.getKind() == CallableMemberDescriptor.Kind.DECLARATION && simpleFunctionDescriptor.getVisibility().d() && !kotlin.reflect.jvm.internal.impl.builtins.b.k0(simpleFunctionDescriptor)) {
                Collection<? extends FunctionDescriptor> overriddenDescriptors = simpleFunctionDescriptor.getOverriddenDescriptors();
                k21.h(overriddenDescriptors, "analogueMember.overriddenDescriptors");
                if (!overriddenDescriptors.isEmpty()) {
                    Iterator<T> it2 = overriddenDescriptors.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        DeclarationDescriptor containingDeclaration = it2.next().getContainingDeclaration();
                        k21.h(containingDeclaration, "it.containingDeclaration");
                        if (b2.contains(DescriptorUtilsKt.i(containingDeclaration))) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                    }
                }
                z = false;
                if (!z) {
                }
            }
            z2 = false;
            if (z2) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private final ib2 h() {
        return (ib2) te2.a(this.e, this, h[1]);
    }

    private static final boolean i(ConstructorDescriptor constructorDescriptor, TypeSubstitutor typeSubstitutor, ConstructorDescriptor constructorDescriptor2) {
        return OverridingUtil.A(constructorDescriptor, constructorDescriptor2.substitute(typeSubstitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final LazyJavaClassDescriptor k(ClassDescriptor classDescriptor) {
        if (kotlin.reflect.jvm.internal.impl.builtins.b.Z(classDescriptor) || !kotlin.reflect.jvm.internal.impl.builtins.b.I0(classDescriptor)) {
            return null;
        }
        fn0 j = DescriptorUtilsKt.j(classDescriptor);
        if (!j.f()) {
            return null;
        }
        oi o = w31.INSTANCE.o(j);
        en0 b2 = o == null ? null : o.b();
        if (b2 == null) {
            return null;
        }
        ClassDescriptor a2 = e60.a(n().a(), b2, NoLookupLocation.FROM_BUILTINS);
        if (a2 instanceof LazyJavaClassDescriptor) {
            return (LazyJavaClassDescriptor) a2;
        }
        return null;
    }

    private final JDKMemberStatus l(FunctionDescriptor functionDescriptor) {
        Object b2 = DFS.b(l.e((ClassDescriptor) functionDescriptor.getContainingDeclaration()), new c(this), new d(pd1.c(functionDescriptor, false, false, 3, null), new Ref$ObjectRef()));
        k21.h(b2, "private fun FunctionDescriptor.getJdkMethodStatus(): JDKMemberStatus {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n        var result: JDKMemberStatus? = null\n        return DFS.dfs<ClassDescriptor, JDKMemberStatus>(\n            listOf(owner),\n            {\n                // Search through mapped supertypes to determine that Set.toArray should be invisible, while we have only\n                // Collection.toArray there explicitly\n                // Note, that we can't find j.u.Collection.toArray within overriddenDescriptors of j.u.Set.toArray\n                it.typeConstructor.supertypes.mapNotNull {\n                    (it.constructor.declarationDescriptor?.original as? ClassDescriptor)?.getJavaAnalogue()\n                }\n            },\n            object : DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() {\n                override fun beforeChildren(javaClassDescriptor: ClassDescriptor): Boolean {\n                    val signature = SignatureBuildingComponents.signature(javaClassDescriptor, jvmDescriptor)\n                    when (signature) {\n                        in HIDDEN_METHOD_SIGNATURES -> result = JDKMemberStatus.HIDDEN\n                        in VISIBLE_METHOD_SIGNATURES -> result = JDKMemberStatus.VISIBLE\n                        in DROP_LIST_METHOD_SIGNATURES -> result = JDKMemberStatus.DROP\n                    }\n\n                    return result == null\n                }\n\n                override fun result() = result ?: JDKMemberStatus.NOT_CONSIDERED\n            })\n    }");
        return (JDKMemberStatus) b2;
    }

    private final Annotations m() {
        return (Annotations) te2.a(this.g, this, h[2]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final JvmBuiltIns.a n() {
        return (JvmBuiltIns.a) te2.a(this.c, this, h[0]);
    }

    private final boolean o(SimpleFunctionDescriptor simpleFunctionDescriptor, boolean z) {
        String c2 = pd1.c(simpleFunctionDescriptor, false, false, 3, null);
        if (z ^ x41.INSTANCE.f().contains(od1.a(SignatureBuildingComponents.INSTANCE, (ClassDescriptor) simpleFunctionDescriptor.getContainingDeclaration(), c2))) {
            return true;
        }
        Boolean e2 = DFS.e(l.e(simpleFunctionDescriptor), e.INSTANCE, new JvmBuiltInsCustomizer$isMutabilityViolation$2(this));
        k21.h(e2, "private fun SimpleFunctionDescriptor.isMutabilityViolation(isMutable: Boolean): Boolean {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n\n        if ((SignatureBuildingComponents.signature(owner, jvmDescriptor) in MUTABLE_METHOD_SIGNATURES) xor isMutable) return true\n\n        return DFS.ifAny<CallableMemberDescriptor>(\n            listOf(this),\n            { it.original.overriddenDescriptors }\n        ) { overridden ->\n            overridden.kind == CallableMemberDescriptor.Kind.DECLARATION &&\n                    j2kClassMapper.isMutable(overridden.containingDeclaration as ClassDescriptor)\n        }\n    }");
        return e2.booleanValue();
    }

    private final boolean p(ConstructorDescriptor constructorDescriptor, ClassDescriptor classDescriptor) {
        if (constructorDescriptor.getValueParameters().size() == 1) {
            List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
            k21.h(valueParameters, "valueParameters");
            ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) k.o0(valueParameters)).getType().c().getDeclarationDescriptor();
            if (k21.d(declarationDescriptor == null ? null : DescriptorUtilsKt.j(declarationDescriptor), DescriptorUtilsKt.j(classDescriptor))) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor) {
        boolean z;
        k21.i(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() != ClassKind.CLASS || !n().b()) {
            return m.g();
        }
        LazyJavaClassDescriptor k = k(classDescriptor);
        if (k == null) {
            return m.g();
        }
        ClassDescriptor h2 = x31.h(this.b, DescriptorUtilsKt.i(k), a.Companion.a(), null, 4, null);
        if (h2 == null) {
            return m.g();
        }
        TypeSubstitutor c2 = jb1.a(h2, k).c();
        List<ClassConstructorDescriptor> i = k.getConstructors();
        ArrayList<ClassConstructorDescriptor> arrayList = new ArrayList();
        Iterator<T> it = i.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            T t = next;
            if (t.getVisibility().d()) {
                Collection<ClassConstructorDescriptor> constructors = h2.getConstructors();
                k21.h(constructors, "defaultKotlinVersion.constructors");
                if (!constructors.isEmpty()) {
                    Iterator<T> it2 = constructors.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        T next2 = it2.next();
                        k21.h(next2, AdvanceSetting.NETWORK_TYPE);
                        if (i(next2, c2, t)) {
                            z = false;
                            break;
                        }
                    }
                    if (z && !p(t, classDescriptor) && !kotlin.reflect.jvm.internal.impl.builtins.b.k0(t) && !x41.INSTANCE.d().contains(od1.a(SignatureBuildingComponents.INSTANCE, k, pd1.c(t, false, false, 3, null)))) {
                        z2 = true;
                    }
                }
                z = true;
                z2 = true;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(n.q(arrayList, 10));
        for (ClassConstructorDescriptor classConstructorDescriptor : arrayList) {
            FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder = classConstructorDescriptor.newCopyBuilder();
            newCopyBuilder.setOwner(classDescriptor);
            newCopyBuilder.setReturnType(classDescriptor.getDefaultType());
            newCopyBuilder.setPreserveSourceElement();
            newCopyBuilder.setSubstitution(c2.j());
            if (!x41.INSTANCE.g().contains(od1.a(SignatureBuildingComponents.INSTANCE, k, pd1.c(classConstructorDescriptor, false, false, 3, null)))) {
                newCopyBuilder.setAdditionalAnnotations(m());
            }
            FunctionDescriptor build = newCopyBuilder.build();
            Objects.requireNonNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            arrayList2.add((ClassConstructorDescriptor) build);
        }
        return arrayList2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f7, code lost:
        if (r2 != 3) goto L_0x010c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ae A[SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    @NotNull
    public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull og1 og1, @NotNull ClassDescriptor classDescriptor) {
        k21.i(og1, "name");
        k21.i(classDescriptor, "classDescriptor");
        boolean z = true;
        if (k21.d(og1, zi.Companion.a()) && (classDescriptor instanceof DeserializedClassDescriptor) && kotlin.reflect.jvm.internal.impl.builtins.b.c0(classDescriptor)) {
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) classDescriptor;
            List<ProtoBuf$Function> functionList = deserializedClassDescriptor.r().getFunctionList();
            k21.h(functionList, "classDescriptor.classProto.functionList");
            if (!(functionList instanceof Collection) || !functionList.isEmpty()) {
                Iterator<T> it = functionList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (k21.d(qg1.b(deserializedClassDescriptor.q().g(), it.next().getName()), zi.Companion.a())) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    return m.g();
                }
                return l.e(e(deserializedClassDescriptor, (SimpleFunctionDescriptor) k.n0(h().getMemberScope().getContributedFunctions(og1, NoLookupLocation.FROM_BUILTINS))));
            }
            z = false;
            if (!z) {
            }
        } else if (!n().b()) {
            return m.g();
        } else {
            Collection<SimpleFunctionDescriptor> g2 = g(classDescriptor, new JvmBuiltInsCustomizer$getFunctions$2(og1));
            ArrayList arrayList = new ArrayList();
            for (T t : g2) {
                FunctionDescriptor substitute = t.substitute(jb1.a((ClassDescriptor) t.getContainingDeclaration(), classDescriptor).c());
                Objects.requireNonNull(substitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
                FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = ((SimpleFunctionDescriptor) substitute).newCopyBuilder();
                newCopyBuilder.setOwner(classDescriptor);
                newCopyBuilder.setDispatchReceiverParameter(classDescriptor.getThisAsReceiverParameter());
                newCopyBuilder.setPreserveSourceElement();
                int i = a.$EnumSwitchMapping$0[l(t).ordinal()];
                SimpleFunctionDescriptor simpleFunctionDescriptor = null;
                if (i == 1) {
                    if (!ue1.a(classDescriptor)) {
                        newCopyBuilder.setHiddenForResolutionEverywhereBesideSupercalls();
                    }
                    if (simpleFunctionDescriptor == null) {
                        arrayList.add(simpleFunctionDescriptor);
                    }
                } else if (i == 2) {
                    newCopyBuilder.setAdditionalAnnotations(m());
                }
                simpleFunctionDescriptor = (SimpleFunctionDescriptor) newCopyBuilder.build();
                k21.f(simpleFunctionDescriptor);
                if (simpleFunctionDescriptor == null) {
                }
            }
            return arrayList;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    @NotNull
    public Collection<g61> getSupertypes(@NotNull ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "classDescriptor");
        fn0 j = DescriptorUtilsKt.j(classDescriptor);
        x41 x41 = x41.INSTANCE;
        if (x41.i(j)) {
            ib2 h2 = h();
            k21.h(h2, "cloneableType");
            return m.j(h2, this.d);
        } else if (x41.j(j)) {
            return l.e(this.d);
        } else {
            return m.g();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(@NotNull ClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        k21.i(classDescriptor, "classDescriptor");
        k21.i(simpleFunctionDescriptor, "functionDescriptor");
        LazyJavaClassDescriptor k = k(classDescriptor);
        if (k == null || !simpleFunctionDescriptor.getAnnotations().hasAnnotation(qq1.a())) {
            return true;
        }
        if (!n().b()) {
            return false;
        }
        String c2 = pd1.c(simpleFunctionDescriptor, false, false, 3, null);
        LazyJavaClassMemberScope k2 = k.getUnsubstitutedMemberScope();
        og1 name = simpleFunctionDescriptor.getName();
        k21.h(name, "functionDescriptor.name");
        Collection<SimpleFunctionDescriptor> contributedFunctions = k2.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
        if (!(contributedFunctions instanceof Collection) || !contributedFunctions.isEmpty()) {
            Iterator<T> it = contributedFunctions.iterator();
            while (it.hasNext()) {
                if (k21.d(pd1.c(it.next(), false, false, 3, null), c2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: j */
    public Set<og1> getFunctionsNames(@NotNull ClassDescriptor classDescriptor) {
        LazyJavaClassMemberScope k;
        k21.i(classDescriptor, "classDescriptor");
        if (!n().b()) {
            return e0.d();
        }
        LazyJavaClassDescriptor k2 = k(classDescriptor);
        Set<og1> set = null;
        if (!(k2 == null || (k = k2.getUnsubstitutedMemberScope()) == null)) {
            set = k.getFunctionNames();
        }
        return set == null ? e0.d() : set;
    }
}
