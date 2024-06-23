package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.az1;
import tb.dz1;
import tb.en0;
import tb.fv1;
import tb.h60;
import tb.i22;
import tb.k21;
import tb.m51;
import tb.og1;
import tb.oi;
import tb.po2;
import tb.wt2;
import tb.wy1;
import tb.z41;

/* compiled from: Taobao */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KClassifierImpl, KTypeParameterOwnerImpl {
    public static final /* synthetic */ int e = 0;
    @NotNull
    private final az1.b<KClassImpl<T>.Data> c;
    @NotNull
    private final Class<T> d;

    /* compiled from: Taobao */
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty[] v = {dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "annotations", "getAnnotations()Ljava/util/List;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), dz1.i(new PropertyReference1Impl(dz1.b(Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        @NotNull
        private final az1.a d = az1.d(new KClassImpl$Data$descriptor$2(this));
        @NotNull
        private final az1.a e = az1.d(new KClassImpl$Data$annotations$2(this));
        @Nullable
        private final az1.a f = az1.d(new KClassImpl$Data$simpleName$2(this));
        @Nullable
        private final az1.a g = az1.d(new KClassImpl$Data$qualifiedName$2(this));
        @NotNull
        private final az1.a h = az1.d(new KClassImpl$Data$constructors$2(this));
        @NotNull
        private final az1.a i = az1.d(new KClassImpl$Data$nestedClasses$2(this));
        @Nullable
        private final az1.b j = az1.b(new KClassImpl$Data$objectInstance$2(this));
        @NotNull
        private final az1.a k = az1.d(new KClassImpl$Data$typeParameters$2(this));
        @NotNull
        private final az1.a l = az1.d(new KClassImpl$Data$supertypes$2(this));
        @NotNull
        private final az1.a m = az1.d(new KClassImpl$Data$sealedSubclasses$2(this));
        @NotNull
        private final az1.a n = az1.d(new KClassImpl$Data$declaredNonStaticMembers$2(this));
        private final az1.a o = az1.d(new KClassImpl$Data$declaredStaticMembers$2(this));
        private final az1.a p = az1.d(new KClassImpl$Data$inheritedNonStaticMembers$2(this));
        private final az1.a q = az1.d(new KClassImpl$Data$inheritedStaticMembers$2(this));
        @NotNull
        private final az1.a r = az1.d(new KClassImpl$Data$allNonStaticMembers$2(this));
        @NotNull
        private final az1.a s = az1.d(new KClassImpl$Data$allStaticMembers$2(this));
        @NotNull
        private final az1.a t;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public Data() {
            super();
            az1.d(new KClassImpl$Data$declaredMembers$2(this));
            this.t = az1.d(new KClassImpl$Data$allMembers$2(this));
        }

        /* access modifiers changed from: private */
        public final String f(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                k21.h(simpleName, "name");
                return StringsKt__StringsKt.K0(simpleName, enclosingMethod.getName() + "$", null, 2, null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                k21.h(simpleName, "name");
                return StringsKt__StringsKt.K0(simpleName, enclosingConstructor.getName() + "$", null, 2, null);
            }
            k21.h(simpleName, "name");
            return StringsKt__StringsKt.J0(simpleName, '$', null, 2, null);
        }

        /* access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> m() {
            return (Collection) this.o.b(this, v[11]);
        }

        /* access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> o() {
            return (Collection) this.p.b(this, v[12]);
        }

        /* access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> p() {
            return (Collection) this.q.b(this, v[13]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> g() {
            return (Collection) this.t.b(this, v[17]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> h() {
            return (Collection) this.r.b(this, v[14]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> i() {
            return (Collection) this.s.b(this, v[15]);
        }

        @NotNull
        public final List<Annotation> j() {
            return (List) this.e.b(this, v[1]);
        }

        @NotNull
        public final Collection<KFunction<T>> k() {
            return (Collection) this.h.b(this, v[4]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> l() {
            return (Collection) this.n.b(this, v[10]);
        }

        @NotNull
        public final ClassDescriptor n() {
            return (ClassDescriptor) this.d.b(this, v[0]);
        }

        @NotNull
        public final Collection<KClass<?>> q() {
            return (Collection) this.i.b(this, v[5]);
        }

        @Nullable
        public final T r() {
            return (T) this.j.b(this, v[6]);
        }

        @Nullable
        public final String s() {
            return (String) this.g.b(this, v[3]);
        }

        @NotNull
        public final List<KClass<? extends T>> t() {
            return (List) this.m.b(this, v[9]);
        }

        @Nullable
        public final String u() {
            return (String) this.f.b(this, v[2]);
        }

        @NotNull
        public final List<KType> v() {
            return (List) this.l.b(this, v[8]);
        }

        @NotNull
        public final List<KTypeParameter> w() {
            return (List) this.k.b(this, v[7]);
        }
    }

    public KClassImpl(@NotNull Class<T> cls) {
        k21.i(cls, "jClass");
        this.d = cls;
        az1.b<KClassImpl<T>.Data> b = az1.b(new KClassImpl$data$1(this));
        k21.h(b, "ReflectProperties.lazy { Data() }");
        this.c = b;
    }

    /* access modifiers changed from: private */
    public final Void B() {
        KotlinClassHeader classHeader;
        wy1 a = wy1.Factory.a(getJClass());
        KotlinClassHeader.Kind c2 = (a == null || (classHeader = a.getClassHeader()) == null) ? null : classHeader.c();
        if (c2 != null) {
            switch (m51.$EnumSwitchMapping$0[c2.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    throw new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. " + "Meanwhile please use Java reflection to inspect this class: " + getJClass());
                case 4:
                    throw new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection " + "library has no idea what declarations does it have. Please use Java reflection to inspect this class: " + getJClass());
                case 5:
                    throw new KotlinReflectionInternalError("Unknown class: " + getJClass() + " (kind = " + c2 + ')');
                case 6:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        throw new KotlinReflectionInternalError("Unresolved class: " + getJClass());
    }

    /* access modifiers changed from: private */
    public final oi w() {
        return i22.INSTANCE.c(getJClass());
    }

    @NotNull
    public final MemberScope A() {
        MemberScope staticScope = getDescriptor().getStaticScope();
        k21.h(staticScope, "descriptor.staticScope");
        return staticScope;
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof KClassImpl) && k21.d(z41.c(this), z41.c((KClass) obj));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return this.c.invoke().j();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KFunction<T>> getConstructors() {
        return this.c.invoke().k();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    public Class<T> getJClass() {
        return this.d;
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        return this.c.invoke().g();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        return this.c.invoke().q();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public T getObjectInstance() {
        return (T) this.c.invoke().r();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getQualifiedName() {
        return this.c.invoke().s();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KClass<? extends T>> getSealedSubclasses() {
        return this.c.invoke().t();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getSimpleName() {
        return this.c.invoke().u();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KType> getSupertypes() {
        return this.c.invoke().v();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        return this.c.invoke().w();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public KVisibility getVisibility() {
        h60 visibility = getDescriptor().getVisibility();
        k21.h(visibility, "descriptor.visibility");
        return wt2.o(visibility);
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return z41.c(this).hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<ConstructorDescriptor> i() {
        ClassDescriptor y = getDescriptor();
        if (y.getKind() == ClassKind.INTERFACE || y.getKind() == ClassKind.OBJECT) {
            return m.g();
        }
        Collection<ClassConstructorDescriptor> constructors = y.getConstructors();
        k21.h(constructors, "descriptor.constructors");
        return constructors;
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        return getDescriptor().isCompanionObject();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        return getDescriptor().isData();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        return getDescriptor().isFun();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        return getDescriptor().isInner();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(@Nullable Object obj) {
        Integer d2 = ReflectClassUtilKt.d(getJClass());
        if (d2 != null) {
            return po2.k(obj, d2.intValue());
        }
        Class h = ReflectClassUtilKt.h(getJClass());
        if (h == null) {
            h = getJClass();
        }
        return h.isInstance(obj);
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        return getDescriptor().getModality() == Modality.SEALED;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<FunctionDescriptor> j(@NotNull og1 og1) {
        k21.i(og1, "name");
        MemberScope z = z();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt___CollectionsKt.k0(z.getContributedFunctions(og1, noLookupLocation), A().getContributedFunctions(og1, noLookupLocation));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @Nullable
    public PropertyDescriptor k(int i) {
        Class<?> declaringClass;
        if (!k21.d(getJClass().getSimpleName(), "DefaultImpls") || (declaringClass = getJClass().getDeclaringClass()) == null || !declaringClass.isInterface()) {
            ClassDescriptor y = getDescriptor();
            if (!(y instanceof DeserializedClassDescriptor)) {
                y = null;
            }
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) y;
            if (deserializedClassDescriptor == null) {
                return null;
            }
            ProtoBuf$Class r = deserializedClassDescriptor.r();
            GeneratedMessageLite.c<ProtoBuf$Class, List<ProtoBuf$Property>> cVar = JvmProtoBuf.classLocalVariable;
            k21.h(cVar, "JvmProtoBuf.classLocalVariable");
            ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) fv1.b(r, cVar, i);
            if (protoBuf$Property != null) {
                return (PropertyDescriptor) wt2.f(getJClass(), protoBuf$Property, deserializedClassDescriptor.q().g(), deserializedClassDescriptor.q().j(), deserializedClassDescriptor.t(), KClassImpl$getLocalProperty$2$1$1.INSTANCE);
            }
            return null;
        }
        KClass e2 = z41.e(declaringClass);
        Objects.requireNonNull(e2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        return ((KClassImpl) e2).k(i);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<PropertyDescriptor> n(@NotNull og1 og1) {
        k21.i(og1, "name");
        MemberScope z = z();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return CollectionsKt___CollectionsKt.k0(z.getContributedVariables(og1, noLookupLocation), A().getContributedVariables(og1, noLookupLocation));
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        oi w = w();
        en0 h = w.h();
        k21.h(h, "classId.packageFqName");
        if (h.d()) {
            str = "";
        } else {
            str = h.b() + ".";
        }
        String b = w.i().b();
        k21.h(b, "classId.relativeClassName.asString()");
        sb.append(str + o.E(b, '.', '$', false, 4, null));
        return sb.toString();
    }

    @NotNull
    public final az1.b<KClassImpl<T>.Data> x() {
        return this.c;
    }

    @NotNull
    /* renamed from: y */
    public ClassDescriptor getDescriptor() {
        return this.c.invoke().n();
    }

    @NotNull
    public final MemberScope z() {
        return getDescriptor().getDefaultType().getMemberScope();
    }
}
