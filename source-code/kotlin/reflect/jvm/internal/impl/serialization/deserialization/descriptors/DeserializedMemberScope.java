package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.event.Subject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.q;
import kotlin.collections.r;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b60;
import tb.dz1;
import tb.jc1;
import tb.k21;
import tb.l60;
import tb.oc1;
import tb.og1;
import tb.oi;
import tb.qg1;
import tb.qj;
import tb.te2;
import tb.ur2;

/* compiled from: Taobao */
public abstract class DeserializedMemberScope extends oc1 {
    static final /* synthetic */ KProperty<Object>[] e = {dz1.i(new PropertyReference1Impl(dz1.b(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), dz1.i(new PropertyReference1Impl(dz1.b(DeserializedMemberScope.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    @NotNull
    private final l60 a;
    @NotNull
    private final Implementation b;
    @NotNull
    private final NotNullLazyValue c;
    @NotNull
    private final NullableLazyValue d;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface Implementation {
        void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> collection, @NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1, @NotNull LookupLocation lookupLocation);

        @NotNull
        Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation);

        @NotNull
        Collection<PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation);

        @NotNull
        Set<og1> getFunctionNames();

        @Nullable
        TypeAliasDescriptor getTypeAliasByName(@NotNull og1 og1);

        @NotNull
        Set<og1> getTypeAliasNames();

        @NotNull
        Set<og1> getVariableNames();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class NoReorderImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] o = {dz1.i(new PropertyReference1Impl(dz1.b(NoReorderImplementation.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), dz1.i(new PropertyReference1Impl(dz1.b(NoReorderImplementation.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), dz1.i(new PropertyReference1Impl(dz1.b(NoReorderImplementation.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), dz1.i(new PropertyReference1Impl(dz1.b(NoReorderImplementation.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), dz1.i(new PropertyReference1Impl(dz1.b(NoReorderImplementation.class), "allProperties", "getAllProperties()Ljava/util/List;")), dz1.i(new PropertyReference1Impl(dz1.b(NoReorderImplementation.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), dz1.i(new PropertyReference1Impl(dz1.b(NoReorderImplementation.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), dz1.i(new PropertyReference1Impl(dz1.b(NoReorderImplementation.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), dz1.i(new PropertyReference1Impl(dz1.b(NoReorderImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), dz1.i(new PropertyReference1Impl(dz1.b(NoReorderImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        @NotNull
        private final List<ProtoBuf$Function> a;
        @NotNull
        private final List<ProtoBuf$Property> b;
        @NotNull
        private final List<ProtoBuf$TypeAlias> c;
        @NotNull
        private final NotNullLazyValue d;
        @NotNull
        private final NotNullLazyValue e;
        @NotNull
        private final NotNullLazyValue f;
        @NotNull
        private final NotNullLazyValue g;
        @NotNull
        private final NotNullLazyValue h;
        @NotNull
        private final NotNullLazyValue i;
        @NotNull
        private final NotNullLazyValue j;
        @NotNull
        private final NotNullLazyValue k;
        @NotNull
        private final NotNullLazyValue l;
        @NotNull
        private final NotNullLazyValue m;
        final /* synthetic */ DeserializedMemberScope n;

        public NoReorderImplementation(@NotNull DeserializedMemberScope deserializedMemberScope, @NotNull List<ProtoBuf$Function> list, @NotNull List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3) {
            k21.i(deserializedMemberScope, "this$0");
            k21.i(list, "functionList");
            k21.i(list2, "propertyList");
            k21.i(list3, "typeAliasList");
            this.n = deserializedMemberScope;
            this.a = list;
            this.b = list2;
            this.c = !deserializedMemberScope.j().c().g().getTypeAliasesAllowed() ? m.g() : list3;
            this.d = deserializedMemberScope.j().h().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredFunctions$2(this));
            this.e = deserializedMemberScope.j().h().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredProperties$2(this));
            this.f = deserializedMemberScope.j().h().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2(this));
            this.g = deserializedMemberScope.j().h().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allFunctions$2(this));
            this.h = deserializedMemberScope.j().h().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allProperties$2(this));
            this.i = deserializedMemberScope.j().h().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(this));
            this.j = deserializedMemberScope.j().h().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionsByName$2(this));
            this.k = deserializedMemberScope.j().h().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$propertiesByName$2(this));
            this.l = deserializedMemberScope.j().h().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionNames$2(this, deserializedMemberScope));
            this.m = deserializedMemberScope.j().h().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$variableNames$2(this, deserializedMemberScope));
        }

        private final Map<og1, TypeAliasDescriptor> A() {
            return (Map) te2.a(this.i, this, o[5]);
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> m() {
            Set<og1> n2 = this.n.n();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = n2.iterator();
            while (it.hasNext()) {
                boolean unused = r.v(arrayList, p(it.next()));
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> n() {
            Set<og1> o2 = this.n.o();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = o2.iterator();
            while (it.hasNext()) {
                boolean unused = r.v(arrayList, q(it.next()));
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> o() {
            List<ProtoBuf$Function> list = this.a;
            DeserializedMemberScope deserializedMemberScope = this.n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                SimpleFunctionDescriptor n2 = deserializedMemberScope.a.f().n(it.next());
                if (!deserializedMemberScope.r(n2)) {
                    n2 = null;
                }
                if (n2 != null) {
                    arrayList.add(n2);
                }
            }
            return arrayList;
        }

        private final List<SimpleFunctionDescriptor> p(og1 og1) {
            List<SimpleFunctionDescriptor> w = w();
            DeserializedMemberScope deserializedMemberScope = this.n;
            ArrayList arrayList = new ArrayList();
            for (T t : w) {
                if (k21.d(t.getName(), og1)) {
                    arrayList.add(t);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.e(og1, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        private final List<PropertyDescriptor> q(og1 og1) {
            List<PropertyDescriptor> x = x();
            DeserializedMemberScope deserializedMemberScope = this.n;
            ArrayList arrayList = new ArrayList();
            for (T t : x) {
                if (k21.d(t.getName(), og1)) {
                    arrayList.add(t);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.f(og1, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> r() {
            List<ProtoBuf$Property> list = this.b;
            DeserializedMemberScope deserializedMemberScope = this.n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                PropertyDescriptor p = deserializedMemberScope.a.f().p(it.next());
                if (p != null) {
                    arrayList.add(p);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final List<TypeAliasDescriptor> s() {
            List<ProtoBuf$TypeAlias> list = this.c;
            DeserializedMemberScope deserializedMemberScope = this.n;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                TypeAliasDescriptor q = deserializedMemberScope.a.f().q(it.next());
                if (q != null) {
                    arrayList.add(q);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> t() {
            return (List) te2.a(this.g, this, o[3]);
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> u() {
            return (List) te2.a(this.h, this, o[4]);
        }

        /* access modifiers changed from: private */
        public final List<TypeAliasDescriptor> v() {
            return (List) te2.a(this.f, this, o[2]);
        }

        /* access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> w() {
            return (List) te2.a(this.d, this, o[0]);
        }

        /* access modifiers changed from: private */
        public final List<PropertyDescriptor> x() {
            return (List) te2.a(this.e, this, o[1]);
        }

        private final Map<og1, Collection<SimpleFunctionDescriptor>> y() {
            return (Map) te2.a(this.j, this, o[6]);
        }

        private final Map<og1, Collection<PropertyDescriptor>> z() {
            return (Map) te2.a(this.k, this, o[7]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> collection, @NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1, @NotNull LookupLocation lookupLocation) {
            k21.i(collection, "result");
            k21.i(b60, "kindFilter");
            k21.i(function1, "nameFilter");
            k21.i(lookupLocation, "location");
            if (b60.a(b60.Companion.k())) {
                for (DeclarationDescriptor declarationDescriptor : u()) {
                    og1 name = ((PropertyDescriptor) declarationDescriptor).getName();
                    k21.h(name, "it.name");
                    if (function1.invoke(name).booleanValue()) {
                        collection.add(declarationDescriptor);
                    }
                }
            }
            if (b60.a(b60.Companion.e())) {
                for (DeclarationDescriptor declarationDescriptor2 : t()) {
                    og1 name2 = ((SimpleFunctionDescriptor) declarationDescriptor2).getName();
                    k21.h(name2, "it.name");
                    if (function1.invoke(name2).booleanValue()) {
                        collection.add(declarationDescriptor2);
                    }
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            k21.i(og1, "name");
            k21.i(lookupLocation, "location");
            if (!getFunctionNames().contains(og1)) {
                return m.g();
            }
            Collection<SimpleFunctionDescriptor> collection = y().get(og1);
            return collection != null ? collection : m.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            k21.i(og1, "name");
            k21.i(lookupLocation, "location");
            if (!getVariableNames().contains(og1)) {
                return m.g();
            }
            Collection<PropertyDescriptor> collection = z().get(og1);
            return collection != null ? collection : m.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<og1> getFunctionNames() {
            return (Set) te2.a(this.l, this, o[8]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @Nullable
        public TypeAliasDescriptor getTypeAliasByName(@NotNull og1 og1) {
            k21.i(og1, "name");
            return A().get(og1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<og1> getTypeAliasNames() {
            List<ProtoBuf$TypeAlias> list = this.c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this.n;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(qg1.b(deserializedMemberScope.a.g(), it.next().getName()));
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<og1> getVariableNames() {
            return (Set) te2.a(this.m, this, o[9]);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class OptimizedImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] j = {dz1.i(new PropertyReference1Impl(dz1.b(OptimizedImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), dz1.i(new PropertyReference1Impl(dz1.b(OptimizedImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        @NotNull
        private final Map<og1, byte[]> a;
        @NotNull
        private final Map<og1, byte[]> b;
        @NotNull
        private final Map<og1, byte[]> c;
        @NotNull
        private final MemoizedFunctionToNotNull<og1, Collection<SimpleFunctionDescriptor>> d;
        @NotNull
        private final MemoizedFunctionToNotNull<og1, Collection<PropertyDescriptor>> e;
        @NotNull
        private final MemoizedFunctionToNullable<og1, TypeAliasDescriptor> f;
        @NotNull
        private final NotNullLazyValue g;
        @NotNull
        private final NotNullLazyValue h;
        final /* synthetic */ DeserializedMemberScope i;

        public OptimizedImplementation(@NotNull DeserializedMemberScope deserializedMemberScope, @NotNull List<ProtoBuf$Function> list, @NotNull List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3) {
            Map<og1, byte[]> map;
            k21.i(deserializedMemberScope, "this$0");
            k21.i(list, "functionList");
            k21.i(list2, "propertyList");
            k21.i(list3, "typeAliasList");
            this.i = deserializedMemberScope;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (T t : list) {
                og1 b2 = qg1.b(deserializedMemberScope.a.g(), t.getName());
                Object obj = linkedHashMap.get(b2);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(b2, obj);
                }
                ((List) obj).add(t);
            }
            this.a = i(linkedHashMap);
            DeserializedMemberScope deserializedMemberScope2 = this.i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (T t2 : list2) {
                og1 b3 = qg1.b(deserializedMemberScope2.a.g(), t2.getName());
                Object obj2 = linkedHashMap2.get(b3);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap2.put(b3, obj2);
                }
                ((List) obj2).add(t2);
            }
            this.b = i(linkedHashMap2);
            if (this.i.j().c().g().getTypeAliasesAllowed()) {
                DeserializedMemberScope deserializedMemberScope3 = this.i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (T t3 : list3) {
                    og1 b4 = qg1.b(deserializedMemberScope3.a.g(), t3.getName());
                    Object obj3 = linkedHashMap3.get(b4);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap3.put(b4, obj3);
                    }
                    ((List) obj3).add(t3);
                }
                map = i(linkedHashMap3);
            } else {
                map = x.i();
            }
            this.c = map;
            this.d = this.i.j().h().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$functions$1(this));
            this.e = this.i.j().h().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$properties$1(this));
            this.f = this.i.j().h().createMemoizedFunctionWithNullableValues(new DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1(this));
            this.g = this.i.j().h().createLazyValue(new DeserializedMemberScope$OptimizedImplementation$functionNames$2(this, this.i));
            this.h = this.i.j().h().createLazyValue(new DeserializedMemberScope$OptimizedImplementation$variableNames$2(this, this.i));
        }

        /* access modifiers changed from: private */
        public final Collection<SimpleFunctionDescriptor> f(og1 og1) {
            Map<og1, byte[]> map = this.a;
            Parser<ProtoBuf$Function> parser = ProtoBuf$Function.PARSER;
            k21.h(parser, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.i;
            byte[] bArr = map.get(og1);
            List<ProtoBuf$Function> list = bArr == null ? null : SequencesKt___SequencesKt.B(SequencesKt__SequencesKt.i(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(parser, new ByteArrayInputStream(bArr), this.i)));
            if (list == null) {
                list = m.g();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ProtoBuf$Function protoBuf$Function : list) {
                MemberDeserializer f2 = deserializedMemberScope.j().f();
                k21.h(protoBuf$Function, AdvanceSetting.NETWORK_TYPE);
                SimpleFunctionDescriptor n = f2.n(protoBuf$Function);
                if (!deserializedMemberScope.r(n)) {
                    n = null;
                }
                if (n != null) {
                    arrayList.add(n);
                }
            }
            deserializedMemberScope.e(og1, arrayList);
            return qj.c(arrayList);
        }

        /* access modifiers changed from: private */
        public final Collection<PropertyDescriptor> g(og1 og1) {
            List<ProtoBuf$Property> list;
            Map<og1, byte[]> map = this.b;
            Parser<ProtoBuf$Property> parser = ProtoBuf$Property.PARSER;
            k21.h(parser, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.i;
            byte[] bArr = map.get(og1);
            if (bArr == null) {
                list = null;
            } else {
                list = SequencesKt___SequencesKt.B(SequencesKt__SequencesKt.i(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(parser, new ByteArrayInputStream(bArr), this.i)));
            }
            if (list == null) {
                list = m.g();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ProtoBuf$Property protoBuf$Property : list) {
                MemberDeserializer f2 = deserializedMemberScope.j().f();
                k21.h(protoBuf$Property, AdvanceSetting.NETWORK_TYPE);
                PropertyDescriptor p = f2.p(protoBuf$Property);
                if (p != null) {
                    arrayList.add(p);
                }
            }
            deserializedMemberScope.f(og1, arrayList);
            return qj.c(arrayList);
        }

        /* access modifiers changed from: private */
        public final TypeAliasDescriptor h(og1 og1) {
            ProtoBuf$TypeAlias parseDelimitedFrom;
            byte[] bArr = this.c.get(og1);
            if (bArr == null || (parseDelimitedFrom = ProtoBuf$TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), this.i.j().c().j())) == null) {
                return null;
            }
            return this.i.j().f().q(parseDelimitedFrom);
        }

        private final Map<og1, byte[]> i(Map<og1, ? extends Collection<? extends AbstractMessageLite>> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(w.e(map.size()));
            for (T t : map.entrySet()) {
                Object key = t.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable<AbstractMessageLite> iterable = (Iterable) t.getValue();
                ArrayList arrayList = new ArrayList(n.q(iterable, 10));
                for (AbstractMessageLite abstractMessageLite : iterable) {
                    abstractMessageLite.writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(ur2.INSTANCE);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> collection, @NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1, @NotNull LookupLocation lookupLocation) {
            k21.i(collection, "result");
            k21.i(b60, "kindFilter");
            k21.i(function1, "nameFilter");
            k21.i(lookupLocation, "location");
            if (b60.a(b60.Companion.k())) {
                Set<og1> variableNames = getVariableNames();
                ArrayList arrayList = new ArrayList();
                for (og1 og1 : variableNames) {
                    if (function1.invoke(og1).booleanValue()) {
                        arrayList.addAll(getContributedVariables(og1, lookupLocation));
                    }
                }
                jc1 jc1 = jc1.INSTANCE;
                k21.h(jc1, "INSTANCE");
                q.u(arrayList, jc1);
                collection.addAll(arrayList);
            }
            if (b60.a(b60.Companion.e())) {
                Set<og1> functionNames = getFunctionNames();
                ArrayList arrayList2 = new ArrayList();
                for (og1 og12 : functionNames) {
                    if (function1.invoke(og12).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(og12, lookupLocation));
                    }
                }
                jc1 jc12 = jc1.INSTANCE;
                k21.h(jc12, "INSTANCE");
                q.u(arrayList2, jc12);
                collection.addAll(arrayList2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            k21.i(og1, "name");
            k21.i(lookupLocation, "location");
            if (!getFunctionNames().contains(og1)) {
                return m.g();
            }
            return this.d.invoke(og1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            k21.i(og1, "name");
            k21.i(lookupLocation, "location");
            if (!getVariableNames().contains(og1)) {
                return m.g();
            }
            return this.e.invoke(og1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<og1> getFunctionNames() {
            return (Set) te2.a(this.g, this, j[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @Nullable
        public TypeAliasDescriptor getTypeAliasByName(@NotNull og1 og1) {
            k21.i(og1, "name");
            return this.f.invoke(og1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<og1> getTypeAliasNames() {
            return this.c.keySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<og1> getVariableNames() {
            return (Set) te2.a(this.h, this, j[1]);
        }
    }

    protected DeserializedMemberScope(@NotNull l60 l60, @NotNull List<ProtoBuf$Function> list, @NotNull List<ProtoBuf$Property> list2, @NotNull List<ProtoBuf$TypeAlias> list3, @NotNull Function0<? extends Collection<og1>> function0) {
        k21.i(l60, c.a);
        k21.i(list, "functionList");
        k21.i(list2, "propertyList");
        k21.i(list3, "typeAliasList");
        k21.i(function0, "classNames");
        this.a = l60;
        this.b = h(list, list2, list3);
        this.c = l60.h().createLazyValue(new DeserializedMemberScope$classNames$2(function0));
        this.d = l60.h().createNullableLazyValue(new DeserializedMemberScope$classifierNamesLazy$2(this));
    }

    private final Implementation h(List<ProtoBuf$Function> list, List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3) {
        if (this.a.c().g().getPreserveDeclarationsOrdering()) {
            return new NoReorderImplementation(this, list, list2, list3);
        }
        return new OptimizedImplementation(this, list, list2, list3);
    }

    private final ClassDescriptor i(og1 og1) {
        return this.a.c().b(g(og1));
    }

    private final Set<og1> l() {
        return (Set) te2.b(this.d, this, e[1]);
    }

    private final TypeAliasDescriptor p(og1 og1) {
        return this.b.getTypeAliasByName(og1);
    }

    /* access modifiers changed from: protected */
    public abstract void c(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super og1, Boolean> function1);

    /* access modifiers changed from: protected */
    @NotNull
    public final Collection<DeclarationDescriptor> d(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1, @NotNull LookupLocation lookupLocation) {
        k21.i(b60, "kindFilter");
        k21.i(function1, "nameFilter");
        k21.i(lookupLocation, "location");
        ArrayList arrayList = new ArrayList(0);
        b60.a aVar = b60.Companion;
        if (b60.a(aVar.h())) {
            c(arrayList, function1);
        }
        this.b.addFunctionsAndPropertiesTo(arrayList, b60, function1, lookupLocation);
        if (b60.a(aVar.d())) {
            for (og1 og1 : k()) {
                if (function1.invoke(og1).booleanValue()) {
                    qj.a(arrayList, i(og1));
                }
            }
        }
        if (b60.a(b60.Companion.i())) {
            for (og1 og12 : this.b.getTypeAliasNames()) {
                if (function1.invoke(og12).booleanValue()) {
                    qj.a(arrayList, this.b.getTypeAliasByName(og12));
                }
            }
        }
        return qj.c(arrayList);
    }

    /* access modifiers changed from: protected */
    public void e(@NotNull og1 og1, @NotNull List<SimpleFunctionDescriptor> list) {
        k21.i(og1, "name");
        k21.i(list, "functions");
    }

    /* access modifiers changed from: protected */
    public void f(@NotNull og1 og1, @NotNull List<PropertyDescriptor> list) {
        k21.i(og1, "name");
        k21.i(list, "descriptors");
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract oi g(@NotNull og1 og1);

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<og1> getClassifierNames() {
        return l();
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        if (q(og1)) {
            return i(og1);
        }
        if (this.b.getTypeAliasNames().contains(og1)) {
            return p(og1);
        }
        return null;
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return this.b.getContributedFunctions(og1, lookupLocation);
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
        k21.i(og1, "name");
        k21.i(lookupLocation, "location");
        return this.b.getContributedVariables(og1, lookupLocation);
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getFunctionNames() {
        return this.b.getFunctionNames();
    }

    @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<og1> getVariableNames() {
        return this.b.getVariableNames();
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final l60 j() {
        return this.a;
    }

    @NotNull
    public final Set<og1> k() {
        return (Set) te2.a(this.c, this, e[0]);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Set<og1> m();

    /* access modifiers changed from: protected */
    @NotNull
    public abstract Set<og1> n();

    /* access modifiers changed from: protected */
    @NotNull
    public abstract Set<og1> o();

    /* access modifiers changed from: protected */
    public boolean q(@NotNull og1 og1) {
        k21.i(og1, "name");
        return k().contains(og1);
    }

    /* access modifiers changed from: protected */
    public boolean r(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        k21.i(simpleFunctionDescriptor, Subject.FUNCTION);
        return true;
    }
}
