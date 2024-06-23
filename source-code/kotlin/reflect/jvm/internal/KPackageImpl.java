package kotlin.reflect.jvm.internal;

import java.util.Collection;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.m;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import tb.ap2;
import tb.az1;
import tb.dz1;
import tb.e51;
import tb.f51;
import tb.fv1;
import tb.k21;
import tb.og1;
import tb.wt2;
import tb.wy1;

public final class KPackageImpl extends KDeclarationContainerImpl {
    private final az1.b<Data> c;
    private final Class<?> d;

    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty[] j = {dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "metadata", "getMetadata()Lkotlin/Triple;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "members", "getMembers()Ljava/util/Collection;"))};
        private final az1.a d = az1.d(new KPackageImpl$Data$kotlinClass$2(this));
        private final az1.a e = az1.d(new KPackageImpl$Data$scope$2(this));
        private final az1.b f = az1.b(new KPackageImpl$Data$multifileFacade$2(this));
        private final az1.b g = az1.b(new KPackageImpl$Data$metadata$2(this));
        private final az1.a h = az1.d(new KPackageImpl$Data$members$2(this));

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Data() {
            super();
            KPackageImpl.this = r1;
        }

        /* access modifiers changed from: public */
        private final wy1 c() {
            return (wy1) this.d.b(this, j[0]);
        }

        public final Collection<KCallableImpl<?>> d() {
            return (Collection) this.h.b(this, j[4]);
        }

        public final Triple<f51, ProtoBuf$Package, e51> e() {
            return (Triple) this.g.b(this, j[3]);
        }

        public final Class<?> f() {
            return (Class) this.f.b(this, j[2]);
        }

        public final MemberScope g() {
            return (MemberScope) this.e.b(this, j[1]);
        }
    }

    public KPackageImpl(Class<?> cls, String str) {
        k21.i(cls, "jClass");
        this.d = cls;
        az1.b<Data> b = az1.b(new KPackageImpl$data$1(this));
        k21.h(b, "ReflectProperties.lazy { Data() }");
        this.c = b;
    }

    private final MemberScope u() {
        return this.c.invoke().g();
    }

    public boolean equals(Object obj) {
        return (obj instanceof KPackageImpl) && k21.d(getJClass(), ((KPackageImpl) obj).getJClass());
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.d;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        return this.c.invoke().d();
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> i() {
        return m.g();
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> */
    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> j(og1 og1) {
        k21.i(og1, "name");
        return u().getContributedFunctions(og1, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor k(int i) {
        Triple<f51, ProtoBuf$Package, e51> e = this.c.invoke().e();
        if (e == null) {
            return null;
        }
        f51 component1 = e.component1();
        ProtoBuf$Package component2 = e.component2();
        e51 component3 = e.component3();
        GeneratedMessageLite.c<ProtoBuf$Package, List<ProtoBuf$Property>> cVar = JvmProtoBuf.packageLocalVariable;
        k21.h(cVar, "JvmProtoBuf.packageLocalVariable");
        ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) fv1.b(component2, cVar, i);
        if (protoBuf$Property == null) {
            return null;
        }
        Class<?> jClass = getJClass();
        ProtoBuf$TypeTable typeTable = component2.getTypeTable();
        k21.h(typeTable, "packageProto.typeTable");
        return (PropertyDescriptor) wt2.f(jClass, protoBuf$Property, component1, new ap2(typeTable), component3, KPackageImpl$getLocalProperty$1$1$1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Class<?> m() {
        Class<?> f = this.c.invoke().f();
        return f != null ? f : getJClass();
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> */
    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> n(og1 og1) {
        k21.i(og1, "name");
        return u().getContributedVariables(og1, NoLookupLocation.FROM_REFLECTION);
    }

    public String toString() {
        return "file class " + ReflectClassUtilKt.b(getJClass()).b();
    }
}
