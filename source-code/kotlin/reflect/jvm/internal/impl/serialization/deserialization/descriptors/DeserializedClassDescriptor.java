package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.event.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f0;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.r;
import kotlin.collections.w;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.aj1;
import tb.ap2;
import tb.b60;
import tb.bj0;
import tb.en0;
import tb.fj1;
import tb.fv2;
import tb.g61;
import tb.gv1;
import tb.h60;
import tb.hv1;
import tb.i61;
import tb.iv1;
import tb.j1;
import tb.j60;
import tb.jv1;
import tb.k1;
import tb.k21;
import tb.ki;
import tb.l60;
import tb.mu2;
import tb.nb;
import tb.oc1;
import tb.og1;
import tb.oi;
import tb.qg1;
import tb.wi;
import tb.ww1;
import tb.z50;

/* compiled from: Taobao */
public final class DeserializedClassDescriptor extends j1 implements DeserializedDescriptor {
    @NotNull
    private final ProtoBuf$Class e;
    @NotNull
    private final nb f;
    @NotNull
    private final SourceElement g;
    @NotNull
    private final oi h;
    @NotNull
    private final Modality i;
    @NotNull
    private final h60 j;
    @NotNull
    private final ClassKind k;
    @NotNull
    private final l60 l;
    @NotNull
    private final oc1 m;
    @NotNull
    private final DeserializedClassTypeConstructor n;
    @NotNull
    private final ScopesHolderForClass<DeserializedClassMemberScope> o;
    @Nullable
    private final EnumEntryClassDescriptors p;
    @NotNull
    private final DeclarationDescriptor q;
    @NotNull
    private final NullableLazyValue<ClassConstructorDescriptor> r;
    @NotNull
    private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> s;
    @NotNull
    private final NullableLazyValue<ClassDescriptor> t;
    @NotNull
    private final NotNullLazyValue<Collection<ClassDescriptor>> u;
    @NotNull
    private final gv1.a v;
    @NotNull
    private final Annotations w;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class DeserializedClassMemberScope extends DeserializedMemberScope {
        @NotNull
        private final i61 f;
        @NotNull
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> g;
        @NotNull
        private final NotNullLazyValue<Collection<g61>> h;
        final /* synthetic */ DeserializedClassDescriptor i;

        /* compiled from: Taobao */
        public static final class a extends fj1 {
            final /* synthetic */ List<D> a;

            a(List<D> list) {
                this.a = list;
            }

            @Override // tb.gn1
            public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                k21.i(callableMemberDescriptor, "fakeOverride");
                OverridingUtil.N(callableMemberDescriptor, null);
                this.a.add(callableMemberDescriptor);
            }

            /* access modifiers changed from: protected */
            @Override // tb.fj1
            public void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
                k21.i(callableMemberDescriptor, "fromSuper");
                k21.i(callableMemberDescriptor2, "fromCurrent");
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        public DeserializedClassMemberScope(@NotNull DeserializedClassDescriptor deserializedClassDescriptor, i61 i61) {
            super(r2, r3, r4, r5, new DeserializedClassDescriptor$DeserializedClassMemberScope$2$1(r1));
            k21.i(deserializedClassDescriptor, "this$0");
            k21.i(i61, "kotlinTypeRefiner");
            this.i = deserializedClassDescriptor;
            l60 q = deserializedClassDescriptor.q();
            List<ProtoBuf$Function> functionList = deserializedClassDescriptor.r().getFunctionList();
            k21.h(functionList, "classProto.functionList");
            List<ProtoBuf$Property> propertyList = deserializedClassDescriptor.r().getPropertyList();
            k21.h(propertyList, "classProto.propertyList");
            List<ProtoBuf$TypeAlias> typeAliasList = deserializedClassDescriptor.r().getTypeAliasList();
            k21.h(typeAliasList, "classProto.typeAliasList");
            List<Integer> nestedClassNameList = deserializedClassDescriptor.r().getNestedClassNameList();
            k21.h(nestedClassNameList, "classProto.nestedClassNameList");
            NameResolver g2 = deserializedClassDescriptor.q().g();
            ArrayList arrayList = new ArrayList(n.q(nestedClassNameList, 10));
            Iterator<T> it = nestedClassNameList.iterator();
            while (it.hasNext()) {
                arrayList.add(qg1.b(g2, it.next().intValue()));
            }
            this.f = i61;
            this.g = j().h().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1(this));
            this.h = j().h().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1(this));
        }

        private final <D extends CallableMemberDescriptor> void u(og1 og1, Collection<? extends D> collection, List<D> list) {
            j().c().m().getOverridingUtil().y(og1, collection, new ArrayList(list), v(), new a(list));
        }

        /* access modifiers changed from: private */
        public final DeserializedClassDescriptor v() {
            return this.i;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void c(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super og1, Boolean> function1) {
            k21.i(collection, "result");
            k21.i(function1, "nameFilter");
            EnumEntryClassDescriptors enumEntryClassDescriptors = v().p;
            Collection<ClassDescriptor> d = enumEntryClassDescriptors == null ? null : enumEntryClassDescriptors.d();
            if (d == null) {
                d = m.g();
            }
            collection.addAll(d);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void e(@NotNull og1 og1, @NotNull List<SimpleFunctionDescriptor> list) {
            k21.i(og1, "name");
            k21.i(list, "functions");
            ArrayList arrayList = new ArrayList();
            for (g61 g61 : (Collection) this.h.invoke()) {
                arrayList.addAll(g61.getMemberScope().getContributedFunctions(og1, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            list.addAll(j().c().c().getFunctions(og1, this.i));
            u(og1, arrayList, list);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void f(@NotNull og1 og1, @NotNull List<PropertyDescriptor> list) {
            k21.i(og1, "name");
            k21.i(list, "descriptors");
            ArrayList arrayList = new ArrayList();
            for (g61 g61 : (Collection) this.h.invoke()) {
                arrayList.addAll(g61.getMemberScope().getContributedVariables(og1, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            u(og1, arrayList, list);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        public oi g(@NotNull og1 og1) {
            k21.i(og1, "name");
            oi d = this.i.h.d(og1);
            k21.h(d, "classId.createNestedClassId(name)");
            return d;
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            ClassDescriptor f2;
            k21.i(og1, "name");
            k21.i(lookupLocation, "location");
            recordLookup(og1, lookupLocation);
            EnumEntryClassDescriptors enumEntryClassDescriptors = v().p;
            return (enumEntryClassDescriptors == null || (f2 = enumEntryClassDescriptors.f(og1)) == null) ? super.getContributedClassifier(og1, lookupLocation) : f2;
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
            k21.i(b60, "kindFilter");
            k21.i(function1, "nameFilter");
            return (Collection) this.g.invoke();
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            k21.i(og1, "name");
            k21.i(lookupLocation, "location");
            recordLookup(og1, lookupLocation);
            return super.getContributedFunctions(og1, lookupLocation);
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            k21.i(og1, "name");
            k21.i(lookupLocation, "location");
            recordLookup(og1, lookupLocation);
            return super.getContributedVariables(og1, lookupLocation);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @Nullable
        public Set<og1> m() {
            List<g61> h2 = v().n.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = h2.iterator();
            while (it.hasNext()) {
                Set<og1> classifierNames = it.next().getMemberScope().getClassifierNames();
                if (classifierNames == null) {
                    return null;
                }
                boolean unused = r.v(linkedHashSet, classifierNames);
            }
            return linkedHashSet;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        public Set<og1> n() {
            List<g61> h2 = v().n.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = h2.iterator();
            while (it.hasNext()) {
                boolean unused = r.v(linkedHashSet, it.next().getMemberScope().getFunctionNames());
            }
            linkedHashSet.addAll(j().c().c().getFunctionsNames(this.i));
            return linkedHashSet;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        public Set<og1> o() {
            List<g61> h2 = v().n.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = h2.iterator();
            while (it.hasNext()) {
                boolean unused = r.v(linkedHashSet, it.next().getMemberScope().getVariableNames());
            }
            return linkedHashSet;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public boolean r(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
            k21.i(simpleFunctionDescriptor, Subject.FUNCTION);
            return j().c().s().isFunctionAvailable(this.i, simpleFunctionDescriptor);
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public void recordLookup(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            k21.i(og1, "name");
            k21.i(lookupLocation, "location");
            mu2.a(j().c().o(), lookupLocation, v(), og1);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class DeserializedClassTypeConstructor extends k1 {
        @NotNull
        private final NotNullLazyValue<List<TypeParameterDescriptor>> d;
        final /* synthetic */ DeserializedClassDescriptor e;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeserializedClassTypeConstructor(DeserializedClassDescriptor deserializedClassDescriptor) {
            super(deserializedClassDescriptor.q().h());
            k21.i(deserializedClassDescriptor, "this$0");
            this.e = deserializedClassDescriptor;
            this.d = deserializedClassDescriptor.q().h().createLazyValue(new DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1(deserializedClassDescriptor));
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public Collection<g61> c() {
            en0 b;
            List<ProtoBuf$Type> k = jv1.k(this.e.r(), this.e.q().j());
            DeserializedClassDescriptor deserializedClassDescriptor = this.e;
            ArrayList arrayList = new ArrayList(n.q(k, 10));
            Iterator<T> it = k.iterator();
            while (it.hasNext()) {
                arrayList.add(deserializedClassDescriptor.q().i().p(it.next()));
            }
            List list = CollectionsKt___CollectionsKt.k0(arrayList, this.e.q().c().c().getSupertypes(this.e));
            ArrayList<NotFoundClasses.b> arrayList2 = new ArrayList();
            Iterator it2 = list.iterator();
            while (true) {
                NotFoundClasses.b bVar = null;
                if (!it2.hasNext()) {
                    break;
                }
                ClassifierDescriptor declarationDescriptor = ((g61) it2.next()).c().getDeclarationDescriptor();
                if (declarationDescriptor instanceof NotFoundClasses.b) {
                    bVar = (NotFoundClasses.b) declarationDescriptor;
                }
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
            if (!arrayList2.isEmpty()) {
                ErrorReporter i = this.e.q().c().i();
                DeserializedClassDescriptor deserializedClassDescriptor2 = this.e;
                ArrayList arrayList3 = new ArrayList(n.q(arrayList2, 10));
                for (NotFoundClasses.b bVar2 : arrayList2) {
                    oi h = DescriptorUtilsKt.h(bVar2);
                    String b2 = (h == null || (b = h.b()) == null) ? null : b.b();
                    if (b2 == null) {
                        b2 = bVar2.getName().b();
                    }
                    arrayList3.add(b2);
                }
                i.reportIncompleteHierarchy(deserializedClassDescriptor2, arrayList3);
            }
            return CollectionsKt___CollectionsKt.y0(list);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public SupertypeLoopChecker g() {
            return SupertypeLoopChecker.a.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return (List) this.d.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @NotNull
        /* renamed from: p */
        public DeserializedClassDescriptor n() {
            return this.e;
        }

        @NotNull
        public String toString() {
            String og1 = this.e.getName().toString();
            k21.h(og1, "name.toString()");
            return og1;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class EnumEntryClassDescriptors {
        @NotNull
        private final Map<og1, ProtoBuf$EnumEntry> a;
        @NotNull
        private final MemoizedFunctionToNullable<og1, ClassDescriptor> b;
        @NotNull
        private final NotNullLazyValue<Set<og1>> c;
        final /* synthetic */ DeserializedClassDescriptor d;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public EnumEntryClassDescriptors(DeserializedClassDescriptor deserializedClassDescriptor) {
            k21.i(deserializedClassDescriptor, "this$0");
            this.d = deserializedClassDescriptor;
            List<ProtoBuf$EnumEntry> enumEntryList = deserializedClassDescriptor.r().getEnumEntryList();
            k21.h(enumEntryList, "classProto.enumEntryList");
            LinkedHashMap linkedHashMap = new LinkedHashMap(ww1.a(w.e(n.q(enumEntryList, 10)), 16));
            for (T t : enumEntryList) {
                linkedHashMap.put(qg1.b(deserializedClassDescriptor.q().g(), t.getName()), t);
            }
            this.a = linkedHashMap;
            this.b = this.d.q().h().createMemoizedFunctionWithNullableValues(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(this, this.d));
            this.c = this.d.q().h().createLazyValue(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(this));
        }

        /* access modifiers changed from: private */
        public final Set<og1> e() {
            HashSet hashSet = new HashSet();
            for (g61 g61 : this.d.getTypeConstructor().getSupertypes()) {
                for (DeclarationDescriptor declarationDescriptor : ResolutionScope.a.a(g61.getMemberScope(), null, null, 3, null)) {
                    if ((declarationDescriptor instanceof SimpleFunctionDescriptor) || (declarationDescriptor instanceof PropertyDescriptor)) {
                        hashSet.add(declarationDescriptor.getName());
                    }
                }
            }
            List<ProtoBuf$Function> functionList = this.d.r().getFunctionList();
            k21.h(functionList, "classProto.functionList");
            DeserializedClassDescriptor deserializedClassDescriptor = this.d;
            Iterator<T> it = functionList.iterator();
            while (it.hasNext()) {
                hashSet.add(qg1.b(deserializedClassDescriptor.q().g(), it.next().getName()));
            }
            List<ProtoBuf$Property> propertyList = this.d.r().getPropertyList();
            k21.h(propertyList, "classProto.propertyList");
            DeserializedClassDescriptor deserializedClassDescriptor2 = this.d;
            Iterator<T> it2 = propertyList.iterator();
            while (it2.hasNext()) {
                hashSet.add(qg1.b(deserializedClassDescriptor2.q().g(), it2.next().getName()));
            }
            return f0.i(hashSet, hashSet);
        }

        @NotNull
        public final Collection<ClassDescriptor> d() {
            Set<og1> keySet = this.a.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = keySet.iterator();
            while (it.hasNext()) {
                ClassDescriptor f = f(it.next());
                if (f != null) {
                    arrayList.add(f);
                }
            }
            return arrayList;
        }

        @Nullable
        public final ClassDescriptor f(@NotNull og1 og1) {
            k21.i(og1, "name");
            return this.b.invoke(og1);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor(@NotNull l60 l60, @NotNull ProtoBuf$Class protoBuf$Class, @NotNull NameResolver nameResolver, @NotNull nb nbVar, @NotNull SourceElement sourceElement) {
        super(l60.h(), qg1.a(nameResolver, protoBuf$Class.getFqName()).j());
        Annotations annotations;
        k21.i(l60, "outerContext");
        k21.i(protoBuf$Class, "classProto");
        k21.i(nameResolver, "nameResolver");
        k21.i(nbVar, "metadataVersion");
        k21.i(sourceElement, "sourceElement");
        this.e = protoBuf$Class;
        this.f = nbVar;
        this.g = sourceElement;
        this.h = qg1.a(nameResolver, protoBuf$Class.getFqName());
        hv1 hv1 = hv1.INSTANCE;
        this.i = hv1.b(bj0.MODALITY.d(protoBuf$Class.getFlags()));
        this.j = iv1.a(hv1, bj0.VISIBILITY.d(protoBuf$Class.getFlags()));
        ClassKind a = hv1.a(bj0.CLASS_KIND.d(protoBuf$Class.getFlags()));
        this.k = a;
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$Class.getTypeParameterList();
        k21.h(typeParameterList, "classProto.typeParameterList");
        ProtoBuf$TypeTable typeTable = protoBuf$Class.getTypeTable();
        k21.h(typeTable, "classProto.typeTable");
        ap2 ap2 = new ap2(typeTable);
        fv2.a aVar = fv2.Companion;
        ProtoBuf$VersionRequirementTable versionRequirementTable = protoBuf$Class.getVersionRequirementTable();
        k21.h(versionRequirementTable, "classProto.versionRequirementTable");
        l60 a2 = l60.a(this, typeParameterList, nameResolver, ap2, aVar.a(versionRequirementTable), nbVar);
        this.l = a2;
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.m = a == classKind ? new StaticScopeForKotlinEnum(a2.h(), this) : MemberScope.b.INSTANCE;
        this.n = new DeserializedClassTypeConstructor(this);
        this.o = ScopesHolderForClass.Companion.a(this, a2.h(), a2.c().m().getKotlinTypeRefiner(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        gv1.a aVar2 = null;
        this.p = a == classKind ? new EnumEntryClassDescriptors(this) : null;
        DeclarationDescriptor e2 = l60.e();
        this.q = e2;
        this.r = a2.h().createNullableLazyValue(new DeserializedClassDescriptor$primaryConstructor$1(this));
        this.s = a2.h().createLazyValue(new DeserializedClassDescriptor$constructors$1(this));
        this.t = a2.h().createNullableLazyValue(new DeserializedClassDescriptor$companionObjectDescriptor$1(this));
        this.u = a2.h().createLazyValue(new DeserializedClassDescriptor$sealedSubclasses$1(this));
        NameResolver g2 = a2.g();
        ap2 j2 = a2.j();
        DeserializedClassDescriptor deserializedClassDescriptor = e2 instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) e2 : null;
        this.v = new gv1.a(protoBuf$Class, g2, j2, sourceElement, deserializedClassDescriptor != null ? deserializedClassDescriptor.v : aVar2);
        if (!bj0.HAS_ANNOTATIONS.d(protoBuf$Class.getFlags()).booleanValue()) {
            annotations = Annotations.Companion.b();
        } else {
            annotations = new aj1(a2.h(), new DeserializedClassDescriptor$annotations$1(this));
        }
        this.w = annotations;
    }

    /* access modifiers changed from: private */
    public final ClassDescriptor l() {
        if (!this.e.hasCompanionObjectName()) {
            return null;
        }
        ClassifierDescriptor contributedClassifier = s().getContributedClassifier(qg1.b(this.l.g(), this.e.getCompanionObjectName()), NoLookupLocation.FROM_DESERIALIZATION);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final Collection<ClassConstructorDescriptor> m() {
        return CollectionsKt___CollectionsKt.k0(CollectionsKt___CollectionsKt.k0(o(), m.k(getUnsubstitutedPrimaryConstructor())), this.l.c().c().getConstructors(this));
    }

    /* access modifiers changed from: private */
    public final ClassConstructorDescriptor n() {
        T t2;
        if (this.k.isSingleton()) {
            ki i2 = z50.i(this, SourceElement.NO_SOURCE);
            i2.A(getDefaultType());
            return i2;
        }
        List<ProtoBuf$Constructor> constructorList = this.e.getConstructorList();
        k21.h(constructorList, "classProto.constructorList");
        Iterator<T> it = constructorList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (!bj0.IS_SECONDARY.d(t2.getFlags()).booleanValue()) {
                break;
            }
        }
        T t3 = t2;
        if (t3 == null) {
            return null;
        }
        return q().f().m(t3, true);
    }

    private final List<ClassConstructorDescriptor> o() {
        List<ProtoBuf$Constructor> constructorList = this.e.getConstructorList();
        k21.h(constructorList, "classProto.constructorList");
        ArrayList<ProtoBuf$Constructor> arrayList = new ArrayList();
        for (T t2 : constructorList) {
            Boolean g2 = bj0.IS_SECONDARY.d(t2.getFlags());
            k21.h(g2, "IS_SECONDARY.get(it.flags)");
            if (g2.booleanValue()) {
                arrayList.add(t2);
            }
        }
        ArrayList arrayList2 = new ArrayList(n.q(arrayList, 10));
        for (ProtoBuf$Constructor protoBuf$Constructor : arrayList) {
            MemberDeserializer f2 = q().f();
            k21.h(protoBuf$Constructor, AdvanceSetting.NETWORK_TYPE);
            arrayList2.add(f2.m(protoBuf$Constructor, false));
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public final Collection<ClassDescriptor> p() {
        if (this.i != Modality.SEALED) {
            return m.g();
        }
        List<Integer> sealedSubclassFqNameList = this.e.getSealedSubclassFqNameList();
        k21.h(sealedSubclassFqNameList, "fqNames");
        if (!(!sealedSubclassFqNameList.isEmpty())) {
            return wi.INSTANCE.a(this, false);
        }
        ArrayList arrayList = new ArrayList();
        for (T t2 : sealedSubclassFqNameList) {
            j60 c = q().c();
            NameResolver g2 = q().g();
            k21.h(t2, "index");
            ClassDescriptor b = c.b(qg1.a(g2, t2.intValue()));
            if (b != null) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    private final DeserializedClassMemberScope s() {
        return this.o.c(this.l.c().m().getKotlinTypeRefiner());
    }

    /* access modifiers changed from: protected */
    @Override // tb.xe1
    @NotNull
    public MemberScope b(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return this.o.c(i61);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) this.t.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        return (Collection) this.s.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        return this.q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.l.i().k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        return this.k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Modality getModality() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        return (Collection) this.u.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    @NotNull
    public SourceElement getSource() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) this.r.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public h60 getVisibility() {
        return this.j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return bj0.CLASS_KIND.d(this.e.getFlags()) == ProtoBuf$Class.Kind.COMPANION_OBJECT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        Boolean g2 = bj0.IS_DATA.d(this.e.getFlags());
        k21.h(g2, "IS_DATA.get(classProto.flags)");
        return g2.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        Boolean g2 = bj0.IS_EXPECT_CLASS.d(this.e.getFlags());
        k21.h(g2, "IS_EXPECT_CLASS.get(classProto.flags)");
        return g2.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        Boolean g2 = bj0.IS_EXTERNAL_CLASS.d(this.e.getFlags());
        k21.h(g2, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return g2.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        Boolean g2 = bj0.IS_FUN_INTERFACE.d(this.e.getFlags());
        k21.h(g2, "IS_FUN_INTERFACE.get(classProto.flags)");
        return g2.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        Boolean g2 = bj0.IS_INLINE_CLASS.d(this.e.getFlags());
        k21.h(g2, "IS_INLINE_CLASS.get(classProto.flags)");
        return g2.booleanValue() && this.f.e(1, 4, 1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        Boolean g2 = bj0.IS_INNER.d(this.e.getFlags());
        k21.h(g2, "IS_INNER.get(classProto.flags)");
        return g2.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        Boolean g2 = bj0.IS_INLINE_CLASS.d(this.e.getFlags());
        k21.h(g2, "IS_INLINE_CLASS.get(classProto.flags)");
        return g2.booleanValue() && this.f.c(1, 4, 2);
    }

    @NotNull
    public final l60 q() {
        return this.l;
    }

    @NotNull
    public final ProtoBuf$Class r() {
        return this.e;
    }

    @NotNull
    public final nb t() {
        return this.f;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("deserialized ");
        sb.append(isExpect() ? "expect " : "");
        sb.append("class ");
        sb.append(getName());
        return sb.toString();
    }

    @NotNull
    /* renamed from: u */
    public oc1 getStaticScope() {
        return this.m;
    }

    @NotNull
    public final gv1.a v() {
        return this.v;
    }

    public final boolean w(@NotNull og1 og1) {
        k21.i(og1, "name");
        return s().k().contains(og1);
    }
}
