package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import tb.aj1;
import tb.al;
import tb.bj0;
import tb.cv1;
import tb.dh2;
import tb.dv1;
import tb.ev2;
import tb.fv2;
import tb.g61;
import tb.gv1;
import tb.h60;
import tb.hv1;
import tb.iv1;
import tb.jv1;
import tb.k21;
import tb.l60;
import tb.lh0;
import tb.m60;
import tb.n60;
import tb.og1;
import tb.qg1;
import tb.r60;
import tb.rn0;
import tb.s60;
import tb.t60;
import tb.z5;
import tb.z50;

/* compiled from: Taobao */
public final class MemberDeserializer {
    @NotNull
    private final l60 a;
    @NotNull
    private final z5 b;

    public MemberDeserializer(@NotNull l60 l60) {
        k21.i(l60, c.a);
        this.a = l60;
        this.b = new z5(l60.c().p(), l60.c().q());
    }

    /* access modifiers changed from: private */
    public final gv1 c(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new gv1.b(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.a.g(), this.a.j(), this.a.d());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).v();
        }
        return null;
    }

    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode d(DeserializedMemberDescriptor deserializedMemberDescriptor, TypeDeserializer typeDeserializer) {
        if (!s(deserializedMemberDescriptor)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        g(typeDeserializer);
        if (typeDeserializer.j()) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
        }
        return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00b3 A[SYNTHETIC] */
    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode e(DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, Collection<? extends ValueParameterDescriptor> collection, Collection<? extends TypeParameterDescriptor> collection2, g61 g61, boolean z) {
        boolean z2;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode2;
        boolean z3;
        boolean z4;
        if (!s(deserializedCallableMemberDescriptor)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        if (k21.d(DescriptorUtilsKt.e(deserializedCallableMemberDescriptor), dh2.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        ArrayList arrayList = new ArrayList(n.q(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        Boolean bool = null;
        List<g61> list = CollectionsKt___CollectionsKt.k0(arrayList, m.k(receiverParameterDescriptor == null ? null : receiverParameterDescriptor.getType()));
        if (g61 != null) {
            bool = Boolean.valueOf(f(g61));
        }
        if (k21.d(bool, Boolean.TRUE)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
        }
        if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
            Iterator<T> it2 = collection2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                List<g61> upperBounds = it2.next().getUpperBounds();
                k21.h(upperBounds, "typeParameter.upperBounds");
                if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                    Iterator<T> it3 = upperBounds.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        T next = it3.next();
                        k21.h(next, AdvanceSetting.NETWORK_TYPE);
                        if (f(next)) {
                            z4 = true;
                            continue;
                            break;
                        }
                    }
                    if (z4) {
                        z2 = true;
                        break;
                    }
                }
                z4 = false;
                continue;
                if (z4) {
                }
            }
        }
        z2 = false;
        if (z2) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
        }
        ArrayList arrayList2 = new ArrayList(n.q(list, 10));
        for (g61 g612 : list) {
            k21.h(g612, "type");
            if (rn0.o(g612) && g612.b().size() <= 3) {
                List<TypeProjection> b2 = g612.b();
                if (!(b2 instanceof Collection) || !b2.isEmpty()) {
                    Iterator<T> it4 = b2.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        g61 type = it4.next().getType();
                        k21.h(type, "it.type");
                        if (f(type)) {
                            z3 = true;
                            break;
                        }
                    }
                    if (!z3) {
                        coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
                    } else {
                        coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
                    }
                }
                z3 = false;
                if (!z3) {
                }
            } else if (f(g612)) {
                coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            } else {
                coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
            }
            arrayList2.add(coroutinesCompatibilityMode2);
        }
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode3 = (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) k.f0(arrayList2);
        if (coroutinesCompatibilityMode3 == null) {
            coroutinesCompatibilityMode3 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        if (z) {
            coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
        } else {
            coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        return (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) al.b(coroutinesCompatibilityMode, coroutinesCompatibilityMode3);
    }

    private final boolean f(g61 g61) {
        return TypeUtilsKt.b(g61, MemberDeserializer$containsSuspendFunctionType$1.INSTANCE);
    }

    private final void g(TypeDeserializer typeDeserializer) {
        Iterator<T> it = typeDeserializer.k().iterator();
        while (it.hasNext()) {
            it.next().getUpperBounds();
        }
    }

    private final Annotations h(MessageLite messageLite, int i, AnnotatedCallableKind annotatedCallableKind) {
        if (!bj0.HAS_ANNOTATIONS.d(i).booleanValue()) {
            return Annotations.Companion.b();
        }
        return new aj1(this.a.h(), new MemberDeserializer$getAnnotations$1(this, messageLite, annotatedCallableKind));
    }

    private final ReceiverParameterDescriptor i() {
        DeclarationDescriptor e = this.a.e();
        ClassDescriptor classDescriptor = e instanceof ClassDescriptor ? (ClassDescriptor) e : null;
        if (classDescriptor == null) {
            return null;
        }
        return classDescriptor.getThisAsReceiverParameter();
    }

    private final Annotations j(ProtoBuf$Property protoBuf$Property, boolean z) {
        if (!bj0.HAS_ANNOTATIONS.d(protoBuf$Property.getFlags()).booleanValue()) {
            return Annotations.Companion.b();
        }
        return new aj1(this.a.h(), new MemberDeserializer$getPropertyFieldAnnotations$1(this, z, protoBuf$Property));
    }

    private final Annotations k(MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        return new m60(this.a.h(), new MemberDeserializer$getReceiverParameterAnnotations$1(this, messageLite, annotatedCallableKind));
    }

    private final void l(s60 s60, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<? extends ValueParameterDescriptor> list2, g61 g61, Modality modality, h60 h60, Map<? extends CallableDescriptor.UserDataKey<?>, ?> map, boolean z) {
        s60.L(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, g61, modality, h60, map, e(s60, receiverParameterDescriptor, list2, list, g61, z));
    }

    private final int o(int i) {
        return (i & 63) + ((i >> 8) << 6);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00e3  */
    private final List<ValueParameterDescriptor> r(List<ProtoBuf$ValueParameter> list, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        aj1 aj1;
        CallableDescriptor callableDescriptor = (CallableDescriptor) this.a.e();
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        k21.h(containingDeclaration, "callableDescriptor.containingDeclaration");
        gv1 c = c(containingDeclaration);
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            T t2 = t;
            int flags = t2.hasFlags() ? t2.getFlags() : 0;
            if (c != null) {
                Boolean g = bj0.HAS_ANNOTATIONS.d(flags);
                k21.h(g, "HAS_ANNOTATIONS.get(flags)");
                if (g.booleanValue()) {
                    aj1 = new aj1(this.a.h(), new MemberDeserializer$valueParameters$1$annotations$1(this, c, messageLite, annotatedCallableKind, i, t2));
                    og1 b2 = qg1.b(this.a.g(), t2.getName());
                    g61 p = this.a.i().p(jv1.m(t2, this.a.j()));
                    Boolean g2 = bj0.DECLARES_DEFAULT_VALUE.d(flags);
                    k21.h(g2, "DECLARES_DEFAULT_VALUE.get(flags)");
                    boolean booleanValue = g2.booleanValue();
                    Boolean g3 = bj0.IS_CROSSINLINE.d(flags);
                    k21.h(g3, "IS_CROSSINLINE.get(flags)");
                    boolean booleanValue2 = g3.booleanValue();
                    Boolean g4 = bj0.IS_NOINLINE.d(flags);
                    k21.h(g4, "IS_NOINLINE.get(flags)");
                    boolean booleanValue3 = g4.booleanValue();
                    ProtoBuf$Type p2 = jv1.p(t2, this.a.j());
                    g61 p3 = p2 != null ? null : this.a.i().p(p2);
                    SourceElement sourceElement = SourceElement.NO_SOURCE;
                    k21.h(sourceElement, "NO_SOURCE");
                    arrayList.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i, aj1, b2, p, booleanValue, booleanValue2, booleanValue3, p3, sourceElement));
                    arrayList = arrayList;
                    i = i2;
                }
            }
            aj1 = Annotations.Companion.b();
            og1 b22 = qg1.b(this.a.g(), t2.getName());
            g61 p4 = this.a.i().p(jv1.m(t2, this.a.j()));
            Boolean g22 = bj0.DECLARES_DEFAULT_VALUE.d(flags);
            k21.h(g22, "DECLARES_DEFAULT_VALUE.get(flags)");
            boolean booleanValue4 = g22.booleanValue();
            Boolean g32 = bj0.IS_CROSSINLINE.d(flags);
            k21.h(g32, "IS_CROSSINLINE.get(flags)");
            boolean booleanValue22 = g32.booleanValue();
            Boolean g42 = bj0.IS_NOINLINE.d(flags);
            k21.h(g42, "IS_NOINLINE.get(flags)");
            boolean booleanValue32 = g42.booleanValue();
            ProtoBuf$Type p22 = jv1.p(t2, this.a.j());
            if (p22 != null) {
            }
            SourceElement sourceElement2 = SourceElement.NO_SOURCE;
            k21.h(sourceElement2, "NO_SOURCE");
            arrayList.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i, aj1, b22, p4, booleanValue4, booleanValue22, booleanValue32, p3, sourceElement2));
            arrayList = arrayList;
            i = i2;
        }
        return CollectionsKt___CollectionsKt.y0(arrayList);
    }

    private final boolean s(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        boolean z;
        boolean z2;
        if (!this.a.c().g().getReleaseCoroutines()) {
            return false;
        }
        List<ev2> versionRequirements = deserializedMemberDescriptor.getVersionRequirements();
        if (!(versionRequirements instanceof Collection) || !versionRequirements.isEmpty()) {
            Iterator<T> it = versionRequirements.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (!k21.d(next.b(), new ev2.b(1, 3, 0, 4, null)) || next.a() != ProtoBuf$VersionRequirement.VersionKind.LANGUAGE_VERSION) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
                if (z2) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ClassConstructorDescriptor m(@NotNull ProtoBuf$Constructor protoBuf$Constructor, boolean z) {
        l60 l60;
        n60 n60;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode;
        TypeDeserializer i;
        k21.i(protoBuf$Constructor, "proto");
        ClassDescriptor classDescriptor = (ClassDescriptor) this.a.e();
        int flags = protoBuf$Constructor.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        n60 n602 = new n60(classDescriptor, null, h(protoBuf$Constructor, flags, annotatedCallableKind), z, CallableMemberDescriptor.Kind.DECLARATION, protoBuf$Constructor, this.a.g(), this.a.j(), this.a.k(), this.a.d(), null, 1024, null);
        MemberDeserializer f = l60.b(this.a, n602, m.g(), null, null, null, null, 60, null).f();
        List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Constructor.getValueParameterList();
        k21.h(valueParameterList, "proto.valueParameterList");
        n602.J(f.r(valueParameterList, protoBuf$Constructor, annotatedCallableKind), iv1.a(hv1.INSTANCE, bj0.VISIBILITY.d(protoBuf$Constructor.getFlags())));
        n602.A(classDescriptor.getDefaultType());
        boolean z2 = true;
        n602.s(!bj0.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.d(protoBuf$Constructor.getFlags()).booleanValue());
        DeclarationDescriptor e = this.a.e();
        Boolean bool = null;
        DeserializedClassDescriptor deserializedClassDescriptor = e instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) e : null;
        if (deserializedClassDescriptor == null) {
            l60 = null;
        } else {
            l60 = deserializedClassDescriptor.q();
        }
        if (!(l60 == null || (i = l60.i()) == null)) {
            bool = Boolean.valueOf(i.j());
        }
        if (!k21.d(bool, Boolean.TRUE) || !s(n602)) {
            z2 = false;
        }
        if (z2) {
            coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            n60 = n602;
        } else {
            Collection<? extends ValueParameterDescriptor> valueParameters = n602.getValueParameters();
            k21.h(valueParameters, "descriptor.valueParameters");
            Collection<? extends TypeParameterDescriptor> typeParameters = n602.getTypeParameters();
            k21.h(typeParameters, "descriptor.typeParameters");
            n60 = n602;
            coroutinesCompatibilityMode = e(n602, null, valueParameters, typeParameters, n602.getReturnType(), false);
        }
        n60.O(coroutinesCompatibilityMode);
        return n60;
    }

    @NotNull
    public final SimpleFunctionDescriptor n(@NotNull ProtoBuf$Function protoBuf$Function) {
        Annotations annotations;
        fv2 fv2;
        g61 p;
        k21.i(protoBuf$Function, "proto");
        int flags = protoBuf$Function.hasFlags() ? protoBuf$Function.getFlags() : o(protoBuf$Function.getOldFlags());
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        Annotations h = h(protoBuf$Function, flags, annotatedCallableKind);
        if (jv1.d(protoBuf$Function)) {
            annotations = k(protoBuf$Function, annotatedCallableKind);
        } else {
            annotations = Annotations.Companion.b();
        }
        if (k21.d(DescriptorUtilsKt.i(this.a.e()).c(qg1.b(this.a.g(), protoBuf$Function.getName())), dh2.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            fv2 = fv2.Companion.b();
        } else {
            fv2 = this.a.k();
        }
        DeclarationDescriptor e = this.a.e();
        og1 b2 = qg1.b(this.a.g(), protoBuf$Function.getName());
        hv1 hv1 = hv1.INSTANCE;
        s60 s60 = new s60(e, null, h, b2, iv1.b(hv1, bj0.MEMBER_KIND.d(flags)), protoBuf$Function, this.a.g(), this.a.j(), fv2, this.a.d(), null, 1024, null);
        l60 l60 = this.a;
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$Function.getTypeParameterList();
        k21.h(typeParameterList, "proto.typeParameterList");
        l60 b3 = l60.b(l60, s60, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf$Type g = jv1.g(protoBuf$Function, this.a.j());
        ReceiverParameterDescriptor receiverParameterDescriptor = null;
        if (!(g == null || (p = b3.i().p(g)) == null)) {
            receiverParameterDescriptor = z50.f(s60, p, annotations);
        }
        ReceiverParameterDescriptor i = i();
        List<TypeParameterDescriptor> k = b3.i().k();
        MemberDeserializer f = b3.f();
        List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Function.getValueParameterList();
        k21.h(valueParameterList, "proto.valueParameterList");
        List<ValueParameterDescriptor> r = f.r(valueParameterList, protoBuf$Function, annotatedCallableKind);
        g61 p2 = b3.i().p(jv1.i(protoBuf$Function, this.a.j()));
        Modality b4 = hv1.b(bj0.MODALITY.d(flags));
        h60 a2 = iv1.a(hv1, bj0.VISIBILITY.d(flags));
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> map = x.i();
        bj0.b bVar = bj0.IS_SUSPEND;
        Boolean g2 = bVar.d(flags);
        k21.h(g2, "IS_SUSPEND.get(flags)");
        l(s60, receiverParameterDescriptor, i, k, r, p2, b4, a2, map, g2.booleanValue());
        Boolean g3 = bj0.IS_OPERATOR.d(flags);
        k21.h(g3, "IS_OPERATOR.get(flags)");
        s60.z(g3.booleanValue());
        Boolean g4 = bj0.IS_INFIX.d(flags);
        k21.h(g4, "IS_INFIX.get(flags)");
        s60.w(g4.booleanValue());
        Boolean g5 = bj0.IS_EXTERNAL_FUNCTION.d(flags);
        k21.h(g5, "IS_EXTERNAL_FUNCTION.get(flags)");
        s60.r(g5.booleanValue());
        Boolean g6 = bj0.IS_INLINE.d(flags);
        k21.h(g6, "IS_INLINE.get(flags)");
        s60.y(g6.booleanValue());
        Boolean g7 = bj0.IS_TAILREC.d(flags);
        k21.h(g7, "IS_TAILREC.get(flags)");
        s60.C(g7.booleanValue());
        Boolean g8 = bVar.d(flags);
        k21.h(g8, "IS_SUSPEND.get(flags)");
        s60.B(g8.booleanValue());
        Boolean g9 = bj0.IS_EXPECT_FUNCTION.d(flags);
        k21.h(g9, "IS_EXPECT_FUNCTION.get(flags)");
        s60.q(g9.booleanValue());
        s60.s(!bj0.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.d(flags).booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction = this.a.c().h().deserializeContractFromFunction(protoBuf$Function, s60, this.a.j(), b3.i());
        if (deserializeContractFromFunction != null) {
            s60.o(deserializeContractFromFunction.getFirst(), deserializeContractFromFunction.getSecond());
        }
        return s60;
    }

    @NotNull
    public final PropertyDescriptor p(@NotNull ProtoBuf$Property protoBuf$Property) {
        ProtoBuf$Property protoBuf$Property2;
        Annotations annotations;
        r60 r60;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        bj0.d<ProtoBuf$Visibility> dVar;
        cv1 cv1;
        bj0.d<ProtoBuf$Modality> dVar2;
        r60 r602;
        boolean z;
        dv1 dv1;
        int i;
        ProtoBuf$Property protoBuf$Property3;
        cv1 cv12;
        g61 p;
        k21.i(protoBuf$Property, "proto");
        int flags = protoBuf$Property.hasFlags() ? protoBuf$Property.getFlags() : o(protoBuf$Property.getOldFlags());
        DeclarationDescriptor e = this.a.e();
        Annotations h = h(protoBuf$Property, flags, AnnotatedCallableKind.PROPERTY);
        hv1 hv1 = hv1.INSTANCE;
        bj0.d<ProtoBuf$Modality> dVar3 = bj0.MODALITY;
        Modality b2 = hv1.b(dVar3.d(flags));
        bj0.d<ProtoBuf$Visibility> dVar4 = bj0.VISIBILITY;
        h60 a2 = iv1.a(hv1, dVar4.d(flags));
        Boolean g = bj0.IS_VAR.d(flags);
        k21.h(g, "IS_VAR.get(flags)");
        boolean booleanValue = g.booleanValue();
        og1 b3 = qg1.b(this.a.g(), protoBuf$Property.getName());
        CallableMemberDescriptor.Kind b4 = iv1.b(hv1, bj0.MEMBER_KIND.d(flags));
        Boolean g2 = bj0.IS_LATEINIT.d(flags);
        k21.h(g2, "IS_LATEINIT.get(flags)");
        boolean booleanValue2 = g2.booleanValue();
        Boolean g3 = bj0.IS_CONST.d(flags);
        k21.h(g3, "IS_CONST.get(flags)");
        boolean booleanValue3 = g3.booleanValue();
        Boolean g4 = bj0.IS_EXTERNAL_PROPERTY.d(flags);
        k21.h(g4, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean booleanValue4 = g4.booleanValue();
        Boolean g5 = bj0.IS_DELEGATED.d(flags);
        k21.h(g5, "IS_DELEGATED.get(flags)");
        boolean booleanValue5 = g5.booleanValue();
        Boolean g6 = bj0.IS_EXPECT_PROPERTY.d(flags);
        k21.h(g6, "IS_EXPECT_PROPERTY.get(flags)");
        hv1 hv12 = hv1;
        r60 r603 = new r60(e, null, h, b2, a2, booleanValue, b3, b4, booleanValue2, booleanValue3, booleanValue4, booleanValue5, g6.booleanValue(), protoBuf$Property, this.a.g(), this.a.j(), this.a.k(), this.a.d());
        l60 l60 = this.a;
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$Property.getTypeParameterList();
        k21.h(typeParameterList, "proto.typeParameterList");
        l60 b5 = l60.b(l60, r603, typeParameterList, null, null, null, null, 60, null);
        Boolean g7 = bj0.HAS_GETTER.d(flags);
        k21.h(g7, "HAS_GETTER.get(flags)");
        boolean booleanValue6 = g7.booleanValue();
        if (!booleanValue6 || !jv1.e(protoBuf$Property)) {
            protoBuf$Property2 = protoBuf$Property;
            annotations = Annotations.Companion.b();
        } else {
            protoBuf$Property2 = protoBuf$Property;
            annotations = k(protoBuf$Property2, AnnotatedCallableKind.PROPERTY_GETTER);
        }
        g61 p2 = b5.i().p(jv1.j(protoBuf$Property2, this.a.j()));
        List<TypeParameterDescriptor> k = b5.i().k();
        ReceiverParameterDescriptor i2 = i();
        ProtoBuf$Type h2 = jv1.h(protoBuf$Property2, this.a.j());
        if (h2 == null || (p = b5.i().p(h2)) == null) {
            r60 = r603;
            receiverParameterDescriptor = null;
        } else {
            r60 = r603;
            receiverParameterDescriptor = z50.f(r60, p, annotations);
        }
        r60.t(p2, k, i2, receiverParameterDescriptor);
        Boolean g8 = bj0.HAS_ANNOTATIONS.d(flags);
        k21.h(g8, "HAS_ANNOTATIONS.get(flags)");
        int b6 = bj0.b(g8.booleanValue(), dVar4.d(flags), dVar3.d(flags), false, false, false);
        if (booleanValue6) {
            int getterFlags = protoBuf$Property.hasGetterFlags() ? protoBuf$Property.getGetterFlags() : b6;
            Boolean g9 = bj0.IS_NOT_DEFAULT.d(getterFlags);
            k21.h(g9, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean booleanValue7 = g9.booleanValue();
            Boolean g10 = bj0.IS_EXTERNAL_ACCESSOR.d(getterFlags);
            k21.h(g10, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean booleanValue8 = g10.booleanValue();
            Boolean g11 = bj0.IS_INLINE_ACCESSOR.d(getterFlags);
            k21.h(g11, "IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean booleanValue9 = g11.booleanValue();
            Annotations h3 = h(protoBuf$Property2, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue7) {
                hv12 = hv12;
                dVar2 = dVar3;
                dVar = dVar4;
                cv12 = new cv1(r60, h3, hv12.b(dVar3.d(getterFlags)), iv1.a(hv12, dVar4.d(getterFlags)), !booleanValue7, booleanValue8, booleanValue9, r60.getKind(), null, SourceElement.NO_SOURCE);
            } else {
                dVar2 = dVar3;
                dVar = dVar4;
                cv12 = z50.b(r60, h3);
                k21.h(cv12, "{\n                DescriptorFactory.createDefaultGetter(property, annotations)\n            }");
            }
            cv12.k(r60.getReturnType());
            cv1 = cv12;
        } else {
            dVar2 = dVar3;
            dVar = dVar4;
            cv1 = null;
        }
        Boolean g12 = bj0.HAS_SETTER.d(flags);
        k21.h(g12, "HAS_SETTER.get(flags)");
        if (g12.booleanValue()) {
            if (protoBuf$Property.hasSetterFlags()) {
                b6 = protoBuf$Property.getSetterFlags();
            }
            Boolean g13 = bj0.IS_NOT_DEFAULT.d(b6);
            k21.h(g13, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean booleanValue10 = g13.booleanValue();
            Boolean g14 = bj0.IS_EXTERNAL_ACCESSOR.d(b6);
            k21.h(g14, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean booleanValue11 = g14.booleanValue();
            Boolean g15 = bj0.IS_INLINE_ACCESSOR.d(b6);
            k21.h(g15, "IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean booleanValue12 = g15.booleanValue();
            AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_SETTER;
            Annotations h4 = h(protoBuf$Property2, b6, annotatedCallableKind);
            if (booleanValue10) {
                dv1 dv12 = new dv1(r60, h4, hv12.b(dVar2.d(b6)), iv1.a(hv12, dVar.d(b6)), !booleanValue10, booleanValue11, booleanValue12, r60.getKind(), null, SourceElement.NO_SOURCE);
                z = true;
                r602 = r60;
                protoBuf$Property3 = protoBuf$Property2;
                i = flags;
                dv12.l((ValueParameterDescriptor) k.o0(l60.b(b5, dv12, m.g(), null, null, null, null, 60, null).f().r(l.e(protoBuf$Property.getSetterValueParameter()), protoBuf$Property3, annotatedCallableKind)));
                dv1 = dv12;
            } else {
                r602 = r60;
                protoBuf$Property3 = protoBuf$Property2;
                i = flags;
                z = true;
                dv1 = z50.c(r602, h4, Annotations.Companion.b());
                k21.h(dv1, "{\n                DescriptorFactory.createDefaultSetter(\n                    property, annotations,\n                    Annotations.EMPTY /* Otherwise the setter is not default, see DescriptorResolver.resolvePropertySetterDescriptor */\n                )\n            }");
            }
        } else {
            r602 = r60;
            protoBuf$Property3 = protoBuf$Property2;
            i = flags;
            z = true;
            dv1 = null;
        }
        Boolean g16 = bj0.HAS_CONSTANT.d(i);
        k21.h(g16, "HAS_CONSTANT.get(flags)");
        if (g16.booleanValue()) {
            r602.e(this.a.h().createNullableLazyValue(new MemberDeserializer$loadProperty$3(this, protoBuf$Property3, r602)));
        }
        r602.w(cv1, dv1, new lh0(j(protoBuf$Property3, false), r602), new lh0(j(protoBuf$Property3, z), r602), d(r602, b5.i()));
        return r602;
    }

    @NotNull
    public final TypeAliasDescriptor q(@NotNull ProtoBuf$TypeAlias protoBuf$TypeAlias) {
        k21.i(protoBuf$TypeAlias, "proto");
        Annotations.a aVar = Annotations.Companion;
        List<ProtoBuf$Annotation> annotationList = protoBuf$TypeAlias.getAnnotationList();
        k21.h(annotationList, "proto.annotationList");
        ArrayList arrayList = new ArrayList(n.q(annotationList, 10));
        for (T t : annotationList) {
            z5 z5Var = this.b;
            k21.h(t, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(z5Var.a(t, this.a.g()));
        }
        t60 t60 = new t60(this.a.h(), this.a.e(), aVar.a(arrayList), qg1.b(this.a.g(), protoBuf$TypeAlias.getName()), iv1.a(hv1.INSTANCE, bj0.VISIBILITY.d(protoBuf$TypeAlias.getFlags())), protoBuf$TypeAlias, this.a.g(), this.a.j(), this.a.k(), this.a.d());
        l60 l60 = this.a;
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$TypeAlias.getTypeParameterList();
        k21.h(typeParameterList, "proto.typeParameterList");
        l60 b2 = l60.b(l60, t60, typeParameterList, null, null, null, null, 60, null);
        t60.k(b2.i().k(), b2.i().l(jv1.n(protoBuf$TypeAlias, this.a.j()), false), b2.i().l(jv1.b(protoBuf$TypeAlias, this.a.j()), false), d(t60, b2.i()));
        return t60;
    }
}
