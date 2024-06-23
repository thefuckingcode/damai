package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a41;
import tb.ae0;
import tb.b41;
import tb.bp2;
import tb.ck1;
import tb.cp2;
import tb.cv1;
import tb.dj0;
import tb.do2;
import tb.e6;
import tb.en0;
import tb.es1;
import tb.g61;
import tb.gj0;
import tb.h61;
import tb.hk1;
import tb.k21;
import tb.kf2;
import tb.ku2;
import tb.l31;
import tb.m40;
import tb.mj1;
import tb.mo2;
import tb.no2;
import tb.o31;
import tb.od1;
import tb.om;
import tb.pd1;
import tb.ta2;
import tb.u31;
import tb.v41;
import tb.vt2;
import tb.w50;
import tb.x31;
import tb.x50;
import tb.x61;
import tb.xu2;
import tb.y5;
import tb.z31;
import tb.z61;

/* compiled from: Taobao */
public final class SignatureEnhancement {
    @NotNull
    private final AnnotationTypeQualifierResolver a;
    @NotNull
    private final JavaTypeEnhancementState b;
    @NotNull
    private final z31 c;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        @NotNull
        private final g61 a;
        private final boolean b;
        private final boolean c;

        public a(@NotNull g61 g61, boolean z, boolean z2) {
            k21.i(g61, "type");
            this.a = g61;
            this.b = z;
            this.c = z2;
        }

        public final boolean a() {
            return this.c;
        }

        @NotNull
        public final g61 b() {
            return this.a;
        }

        public final boolean c() {
            return this.b;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b extends a {
        private final boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull g61 g61, boolean z, boolean z2, boolean z3) {
            super(g61, z2, z3);
            k21.i(g61, "type");
            this.d = z;
        }

        public final boolean d() {
            return this.d;
        }
    }

    public SignatureEnhancement(@NotNull AnnotationTypeQualifierResolver annotationTypeQualifierResolver, @NotNull JavaTypeEnhancementState javaTypeEnhancementState, @NotNull z31 z31) {
        k21.i(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        k21.i(javaTypeEnhancementState, "javaTypeEnhancementState");
        k21.i(z31, "typeEnhancement");
        this.a = annotationTypeQualifierResolver;
        this.b = javaTypeEnhancementState;
        this.c = z31;
    }

    private final hk1 c(en0 en0, AnnotationDescriptor annotationDescriptor, boolean z) {
        if (v41.l().contains(en0)) {
            return new hk1(NullabilityQualifier.NULLABLE, z);
        }
        if (v41.k().contains(en0)) {
            return new hk1(NullabilityQualifier.NOT_NULL, z);
        }
        if (k21.d(en0, v41.f())) {
            return j(annotationDescriptor, z);
        }
        if (k21.d(en0, v41.d()) && this.b.c()) {
            return new hk1(NullabilityQualifier.NULLABLE, z);
        }
        if (k21.d(en0, v41.c()) && this.b.c()) {
            return new hk1(NullabilityQualifier.NOT_NULL, z);
        }
        if (k21.d(en0, v41.a())) {
            return new hk1(NullabilityQualifier.NOT_NULL, true);
        }
        if (k21.d(en0, v41.b())) {
            return new hk1(NullabilityQualifier.NULLABLE, true);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01c3  */
    private final <D extends CallableMemberDescriptor> D d(D d, x61 x61) {
        cv1 cv1;
        JavaCallableMemberDescriptor javaCallableMemberDescriptor;
        a aVar;
        es1 es1;
        ArrayList<b> arrayList;
        Boolean valueOf;
        Boolean bool;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        no2 no2;
        Boolean bool2;
        boolean z;
        Boolean bool3;
        g61 g61;
        boolean z2;
        boolean z3;
        g61 g612;
        List<no2> a2;
        String a3;
        if (!(d instanceof JavaCallableMemberDescriptor)) {
            return d;
        }
        JavaCallableMemberDescriptor javaCallableMemberDescriptor2 = (JavaCallableMemberDescriptor) d;
        if (javaCallableMemberDescriptor2.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && javaCallableMemberDescriptor2.getOriginal().getOverriddenDescriptors().size() == 1) {
            return d;
        }
        x61 h = ContextKt.h(x61, d.getAnnotations());
        if (d instanceof u31) {
            u31 u31 = (u31) d;
            cv1 k = u31.getGetter();
            if (k21.d(k == null ? null : Boolean.valueOf(k.isDefault()), Boolean.FALSE)) {
                cv1 k2 = u31.getGetter();
                k21.f(k2);
                cv1 = k2;
                javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) d;
                if (javaCallableMemberDescriptor.getExtensionReceiverParameter() == null) {
                    FunctionDescriptor functionDescriptor = (FunctionDescriptor) (!(cv1 instanceof FunctionDescriptor) ? null : cv1);
                    aVar = SignatureParts.f(n(d, functionDescriptor == null ? null : (ValueParameterDescriptor) functionDescriptor.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER), h, SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1.INSTANCE), null, 1, null);
                } else {
                    aVar = null;
                }
                JavaMethodDescriptor javaMethodDescriptor = !(d instanceof JavaMethodDescriptor) ? (JavaMethodDescriptor) d : null;
                es1 = (javaMethodDescriptor == null || (a3 = od1.a(SignatureBuildingComponents.INSTANCE, (ClassDescriptor) javaMethodDescriptor.getContainingDeclaration(), pd1.c(javaMethodDescriptor, false, false, 3, null))) == null) ? null : PredefinedEnhancementInfoKt.d().get(a3);
                if (es1 != null) {
                    es1.a().size();
                    javaCallableMemberDescriptor.getValueParameters().size();
                }
                List<ValueParameterDescriptor> valueParameters = cv1.getValueParameters();
                k21.h(valueParameters, "annotationOwnerForMember.valueParameters");
                arrayList = new ArrayList(n.q(valueParameters, 10));
                for (T t : valueParameters) {
                    a e = n(d, t, h, new SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1(t)).e((es1 == null || (a2 = es1.a()) == null) ? null : (no2) k.S(a2, t.getIndex()));
                    if (e.c()) {
                        g612 = e.b();
                    } else {
                        g612 = t.getType();
                        k21.h(g612, "p.type");
                    }
                    k21.h(t, "p");
                    boolean k3 = k(t, g612);
                    arrayList.add(new b(e.b(), k3, e.c() || k3 != t.declaresDefaultValue(), e.a()));
                }
                PropertyDescriptor propertyDescriptor = (PropertyDescriptor) (!(d instanceof PropertyDescriptor) ? null : d);
                valueOf = propertyDescriptor == null ? null : Boolean.valueOf(o31.a(propertyDescriptor));
                bool = Boolean.TRUE;
                if (k21.d(valueOf, bool)) {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.FIELD;
                } else {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE;
                }
                SignatureParts m = m(d, cv1, true, h, annotationQualifierApplicabilityType, SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1.INSTANCE);
                if (es1 == null) {
                    no2 = null;
                } else {
                    no2 = es1.b();
                }
                a e2 = m.e(no2);
                if (aVar == null) {
                    bool2 = null;
                } else {
                    bool2 = Boolean.valueOf(aVar.a());
                }
                if (!k21.d(bool2, bool) && !e2.a()) {
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((b) it.next()).a()) {
                                    z3 = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    z3 = false;
                    if (!z3) {
                        z = false;
                        if (aVar != null) {
                            bool3 = null;
                        } else {
                            bool3 = Boolean.valueOf(aVar.c());
                        }
                        if (!k21.d(bool3, Boolean.TRUE) && !e2.c()) {
                            if (!arrayList.isEmpty()) {
                                Iterator it2 = arrayList.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        if (((b) it2.next()).c()) {
                                            z2 = true;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            z2 = false;
                            if (!z2 && !z) {
                                return d;
                            }
                        }
                        Pair<CallableDescriptor.UserDataKey<?>, ?> a4 = z ? do2.a(x50.a(), new w50(d)) : null;
                        if (aVar == null) {
                            g61 = null;
                        } else {
                            g61 = aVar.b();
                        }
                        ArrayList arrayList2 = new ArrayList(n.q(arrayList, 10));
                        for (b bVar : arrayList) {
                            arrayList2.add(new xu2(bVar.b(), bVar.d()));
                        }
                        return javaCallableMemberDescriptor.enhance(g61, arrayList2, e2.b(), a4);
                    }
                }
                z = true;
                if (aVar != null) {
                }
                if (!arrayList.isEmpty()) {
                }
                z2 = false;
                return d;
            }
        }
        cv1 = d;
        javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) d;
        if (javaCallableMemberDescriptor.getExtensionReceiverParameter() == null) {
        }
        if (!(d instanceof JavaMethodDescriptor)) {
        }
        if (javaMethodDescriptor == null) {
            if (es1 != null) {
            }
            List<ValueParameterDescriptor> valueParameters2 = cv1.getValueParameters();
            k21.h(valueParameters2, "annotationOwnerForMember.valueParameters");
            arrayList = new ArrayList(n.q(valueParameters2, 10));
            while (r0.hasNext()) {
            }
            PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) (!(d instanceof PropertyDescriptor) ? null : d);
            if (propertyDescriptor2 == null) {
            }
            bool = Boolean.TRUE;
            if (k21.d(valueOf, bool)) {
            }
            SignatureParts m2 = m(d, cv1, true, h, annotationQualifierApplicabilityType, SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1.INSTANCE);
            if (es1 == null) {
            }
            a e22 = m2.e(no2);
            if (aVar == null) {
            }
            if (!arrayList.isEmpty()) {
            }
            z3 = false;
            if (!z3) {
            }
            z = true;
            if (aVar != null) {
            }
            if (!arrayList.isEmpty()) {
            }
            z2 = false;
            return d;
        }
        if (es1 != null) {
        }
        List<ValueParameterDescriptor> valueParameters22 = cv1.getValueParameters();
        k21.h(valueParameters22, "annotationOwnerForMember.valueParameters");
        arrayList = new ArrayList(n.q(valueParameters22, 10));
        while (r0.hasNext()) {
        }
        PropertyDescriptor propertyDescriptor22 = (PropertyDescriptor) (!(d instanceof PropertyDescriptor) ? null : d);
        if (propertyDescriptor22 == null) {
        }
        bool = Boolean.TRUE;
        if (k21.d(valueOf, bool)) {
        }
        SignatureParts m22 = m(d, cv1, true, h, annotationQualifierApplicabilityType, SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1.INSTANCE);
        if (es1 == null) {
        }
        a e222 = m22.e(no2);
        if (aVar == null) {
        }
        if (!arrayList.isEmpty()) {
        }
        z3 = false;
        if (!z3) {
        }
        z = true;
        if (aVar != null) {
        }
        if (!arrayList.isEmpty()) {
        }
        z2 = false;
        return d;
    }

    private final hk1 i(AnnotationDescriptor annotationDescriptor, boolean z, boolean z2) {
        en0 fqName = annotationDescriptor.getFqName();
        if (fqName == null) {
            return null;
        }
        boolean z3 = (annotationDescriptor instanceof LazyJavaAnnotationDescriptor) && (((LazyJavaAnnotationDescriptor) annotationDescriptor).h() || z2) && !z;
        hk1 l = l(fqName);
        if (l == null && (l = c(fqName, annotationDescriptor, z3)) == null) {
            return null;
        }
        return (l.d() || !(annotationDescriptor instanceof PossiblyExternalAnnotationDescriptor) || !((PossiblyExternalAnnotationDescriptor) annotationDescriptor).isIdeExternalAnnotation()) ? l : hk1.b(l, null, true, 1, null);
    }

    private final hk1 j(AnnotationDescriptor annotationDescriptor, boolean z) {
        om<?> b2 = DescriptorUtilsKt.b(annotationDescriptor);
        ae0 ae0 = b2 instanceof ae0 ? (ae0) b2 : null;
        if (ae0 == null) {
            return new hk1(NullabilityQualifier.NOT_NULL, z);
        }
        String b3 = ae0.c().b();
        switch (b3.hashCode()) {
            case 73135176:
                if (!b3.equals("MAYBE")) {
                    return null;
                }
                break;
            case 74175084:
                if (!b3.equals("NEVER")) {
                    return null;
                }
                break;
            case 433141802:
                if (!b3.equals("UNKNOWN")) {
                    return null;
                }
                return new hk1(NullabilityQualifier.FORCE_FLEXIBILITY, z);
            case 1933739535:
                if (!b3.equals("ALWAYS")) {
                    return null;
                }
                return new hk1(NullabilityQualifier.NOT_NULL, z);
            default:
                return null;
        }
        return new hk1(NullabilityQualifier.NULLABLE, z);
    }

    private final boolean k(ValueParameterDescriptor valueParameterDescriptor, g61 g61) {
        boolean z;
        y5 b2 = vt2.b(valueParameterDescriptor);
        if (b2 instanceof kf2) {
            z = ku2.a(g61, ((kf2) b2).a()) != null;
        } else if (k21.d(b2, ck1.INSTANCE)) {
            z = bp2.b(g61);
        } else if (b2 == null) {
            z = valueParameterDescriptor.declaresDefaultValue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (!z || !valueParameterDescriptor.getOverriddenDescriptors().isEmpty()) {
            return false;
        }
        return true;
    }

    private final hk1 l(en0 en0) {
        if (this.b.e() == ReportLevel.IGNORE) {
            return null;
        }
        boolean z = this.b.e() == ReportLevel.WARN;
        if (k21.d(en0, v41.h())) {
            return new hk1(NullabilityQualifier.NULLABLE, z);
        }
        if (k21.d(en0, v41.i())) {
            return new hk1(NullabilityQualifier.FORCE_FLEXIBILITY, z);
        }
        return null;
    }

    private final SignatureParts m(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, x61 x61, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, Function1<? super CallableMemberDescriptor, ? extends g61> function1) {
        g61 g61 = (g61) function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        k21.h(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(n.q(overriddenDescriptors, 10));
        for (T t : overriddenDescriptors) {
            k21.h(t, AdvanceSetting.NETWORK_TYPE);
            arrayList.add((g61) function1.invoke(t));
        }
        return new SignatureParts(annotated, g61, arrayList, z, ContextKt.h(x61, ((g61) function1.invoke(callableMemberDescriptor)).getAnnotations()), annotationQualifierApplicabilityType, false, 64, null);
    }

    private final SignatureParts n(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, x61 x61, Function1<? super CallableMemberDescriptor, ? extends g61> function1) {
        x61 h;
        return m(callableMemberDescriptor, valueParameterDescriptor, false, (valueParameterDescriptor == null || (h = ContextKt.h(x61, valueParameterDescriptor.getAnnotations())) == null) ? x61 : h, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, function1);
    }

    @NotNull
    public final <D extends CallableMemberDescriptor> Collection<D> e(@NotNull x61 x61, @NotNull Collection<? extends D> collection) {
        k21.i(x61, c.a);
        k21.i(collection, "platformSignatures");
        ArrayList arrayList = new ArrayList(n.q(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(d(it.next(), x61));
        }
        return arrayList;
    }

    @NotNull
    public final g61 f(@NotNull g61 g61, @NotNull x61 x61) {
        k21.i(g61, "type");
        k21.i(x61, WPKFactory.INIT_KEY_CONTEXT);
        return SignatureParts.f(new SignatureParts(null, g61, m.g(), false, x61, AnnotationQualifierApplicabilityType.TYPE_USE, false, 64, null), null, 1, null).b();
    }

    @NotNull
    public final List<g61> g(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull List<? extends g61> list, @NotNull x61 x61) {
        k21.i(typeParameterDescriptor, "typeParameter");
        k21.i(list, "bounds");
        k21.i(x61, WPKFactory.INIT_KEY_CONTEXT);
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (T t : list) {
            if (!TypeUtilsKt.b(t, SignatureEnhancement$enhanceTypeParameterBounds$1$1.INSTANCE)) {
                t = SignatureParts.f(new SignatureParts(this, typeParameterDescriptor, t, m.g(), false, x61, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, true), null, 1, null).b();
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    @Nullable
    public final hk1 h(@NotNull AnnotationDescriptor annotationDescriptor, boolean z, boolean z2) {
        hk1 i;
        k21.i(annotationDescriptor, "annotationDescriptor");
        hk1 i2 = i(annotationDescriptor, z, z2);
        if (i2 != null) {
            return i2;
        }
        AnnotationDescriptor m = this.a.m(annotationDescriptor);
        if (m == null) {
            return null;
        }
        ReportLevel j = this.a.j(annotationDescriptor);
        if (!j.isIgnore() && (i = i(m, z, z2)) != null) {
            return hk1.b(i, null, j.isWarning(), 1, null);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class SignatureParts {
        @Nullable
        private final Annotated a;
        @NotNull
        private final g61 b;
        @NotNull
        private final Collection<g61> c;
        private final boolean d;
        @NotNull
        private final x61 e;
        @NotNull
        private final AnnotationQualifierApplicabilityType f;
        private final boolean g;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Collection<? extends tb.g61> */
        /* JADX WARN: Multi-variable type inference failed */
        public SignatureParts(@Nullable SignatureEnhancement signatureEnhancement, @NotNull Annotated annotated, @NotNull g61 g61, Collection<? extends g61> collection, @NotNull boolean z, @NotNull x61 x61, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2) {
            k21.i(signatureEnhancement, "this$0");
            k21.i(g61, "fromOverride");
            k21.i(collection, "fromOverridden");
            k21.i(x61, "containerContext");
            k21.i(annotationQualifierApplicabilityType, "containerApplicabilityType");
            SignatureEnhancement.this = signatureEnhancement;
            this.a = annotated;
            this.b = g61;
            this.c = collection;
            this.d = z;
            this.e = x61;
            this.f = annotationQualifierApplicabilityType;
            this.g = z2;
        }

        private final NullabilityQualifier a(TypeParameterDescriptor typeParameterDescriptor) {
            boolean z;
            boolean z2;
            if (!(typeParameterDescriptor instanceof z61)) {
                return null;
            }
            z61 z61 = (z61) typeParameterDescriptor;
            List<g61> upperBounds = z61.getUpperBounds();
            k21.h(upperBounds, "upperBounds");
            boolean z3 = false;
            if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                Iterator<T> it = upperBounds.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!h61.a(it.next())) {
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
                return null;
            }
            List<g61> upperBounds2 = z61.getUpperBounds();
            k21.h(upperBounds2, "upperBounds");
            if (!(upperBounds2 instanceof Collection) || !upperBounds2.isEmpty()) {
                Iterator<T> it2 = upperBounds2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!ta2.a(it2.next())) {
                            z2 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                return null;
            }
            List<g61> upperBounds3 = z61.getUpperBounds();
            k21.h(upperBounds3, "upperBounds");
            if (!(upperBounds3 instanceof Collection) || !upperBounds3.isEmpty()) {
                Iterator<T> it3 = upperBounds3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    T next = it3.next();
                    k21.h(next, AdvanceSetting.NETWORK_TYPE);
                    if (!h61.b(next)) {
                        z3 = true;
                        break;
                    }
                }
            }
            if (z3) {
                return NullabilityQualifier.NOT_NULL;
            }
            return NullabilityQualifier.NULLABLE;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0065  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
        private final Function1<Integer, a41> b() {
            boolean z;
            int i;
            int i2;
            boolean z2;
            Collection<g61> collection = this.c;
            ArrayList<List> arrayList = new ArrayList(n.q(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(o(it.next()));
            }
            List<b> o = o(this.b);
            if (this.d) {
                Collection<g61> collection2 = this.c;
                if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                    Iterator<T> it2 = collection2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (!KotlinTypeChecker.DEFAULT.equalTypes(it2.next(), this.b)) {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        z = true;
                        if (!z) {
                            i = 1;
                        } else {
                            i = o.size();
                        }
                        a41[] a41Arr = new a41[i];
                        i2 = 0;
                        while (i2 < i) {
                            boolean z3 = i2 == 0;
                            b bVar = o.get(i2);
                            g61 a2 = bVar.a();
                            l31 b2 = bVar.b();
                            TypeParameterDescriptor c2 = bVar.c();
                            boolean d2 = bVar.d();
                            ArrayList arrayList2 = new ArrayList();
                            for (List list : arrayList) {
                                b bVar2 = (b) k.S(list, i2);
                                g61 e2 = bVar2 == null ? null : bVar2.e();
                                if (e2 != null) {
                                    arrayList2.add(e2);
                                }
                            }
                            a41Arr[i2] = d(a2, arrayList2, b2, z3, c2, d2);
                            i2++;
                        }
                        return new SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1(a41Arr);
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            z = false;
            if (!z) {
            }
            a41[] a41Arr2 = new a41[i];
            i2 = 0;
            while (i2 < i) {
            }
            return new SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1(a41Arr2);
        }

        private final hk1 c(hk1 hk1, l31 l31, TypeParameterDescriptor typeParameterDescriptor) {
            NullabilityQualifier nullabilityQualifier;
            hk1 e2;
            if (hk1 == null) {
                if (l31 == null || (e2 = l31.e()) == null) {
                    hk1 = null;
                } else {
                    hk1 = new hk1(e2.c(), e2.d());
                }
            }
            if (typeParameterDescriptor == null) {
                nullabilityQualifier = null;
            } else {
                nullabilityQualifier = a(typeParameterDescriptor);
            }
            if (nullabilityQualifier == null) {
                return hk1;
            }
            if (hk1 == null) {
                return new hk1(nullabilityQualifier, false, 2, null);
            }
            return new hk1(m(nullabilityQualifier, hk1.c()), false, 2, null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:70:0x012e  */
        private final a41 d(g61 g61, Collection<? extends g61> collection, l31 l31, boolean z, TypeParameterDescriptor typeParameterDescriptor, boolean z2) {
            boolean z3;
            boolean z4;
            ArrayList<a41> arrayList = new ArrayList(n.q(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(h(it.next()));
            }
            ArrayList arrayList2 = new ArrayList();
            for (a41 a41 : arrayList) {
                MutabilityQualifier b2 = a41.b();
                if (b2 != null) {
                    arrayList2.add(b2);
                }
            }
            Set set = CollectionsKt___CollectionsKt.C0(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            for (a41 a412 : arrayList) {
                NullabilityQualifier c2 = a412.c();
                if (c2 != null) {
                    arrayList3.add(c2);
                }
            }
            Set set2 = CollectionsKt___CollectionsKt.C0(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            Iterator<T> it2 = collection.iterator();
            while (it2.hasNext()) {
                NullabilityQualifier c3 = h(cp2.c(it2.next())).c();
                if (c3 != null) {
                    arrayList4.add(c3);
                }
            }
            Set set3 = CollectionsKt___CollectionsKt.C0(arrayList4);
            a41 i = i(g61, z, l31, typeParameterDescriptor, z2);
            boolean z5 = true;
            NullabilityQualifier nullabilityQualifier = null;
            a41 a413 = i.e() ^ true ? i : null;
            NullabilityQualifier c4 = a413 == null ? null : a413.c();
            NullabilityQualifier c5 = i.c();
            boolean z6 = this.d && z;
            NullabilityQualifier d2 = mo2.d(set2, c4, z6);
            if (d2 != null) {
                if (!(l() && z && d2 == NullabilityQualifier.NULLABLE)) {
                    nullabilityQualifier = d2;
                }
            }
            MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) mo2.c(set, MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, i.b(), z6);
            boolean z7 = c5 != c4 || !k21.d(set3, set2);
            if (!i.d()) {
                if (!arrayList.isEmpty()) {
                    Iterator it3 = arrayList.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (((a41) it3.next()).d()) {
                                z4 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z4 = false;
                if (!z4) {
                    z3 = false;
                    if (nullabilityQualifier != null && z7) {
                        return mo2.a(mo2.d(set3, c5, z6), mutabilityQualifier, true, z3);
                    }
                    if (nullabilityQualifier != null) {
                        z5 = false;
                    }
                    return mo2.a(nullabilityQualifier, mutabilityQualifier, z5, z3);
                }
            }
            z3 = true;
            if (nullabilityQualifier != null) {
            }
            if (nullabilityQualifier != null) {
            }
            return mo2.a(nullabilityQualifier, mutabilityQualifier, z5, z3);
        }

        public static /* synthetic */ a f(SignatureParts signatureParts, no2 no2, int i, Object obj) {
            if ((i & 1) != 0) {
                no2 = null;
            }
            return signatureParts.e(no2);
        }

        private final hk1 g(Annotations annotations, boolean z, boolean z2) {
            SignatureEnhancement signatureEnhancement = SignatureEnhancement.this;
            Iterator it = annotations.iterator();
            while (it.hasNext()) {
                hk1 h2 = signatureEnhancement.h((AnnotationDescriptor) it.next(), z, z2);
                if (h2 != null) {
                    return h2;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
        private final a41 h(g61 g61) {
            Pair pair;
            NullabilityQualifier nullabilityQualifier;
            MutabilityQualifier mutabilityQualifier;
            NullabilityQualifier nullabilityQualifier2;
            if (gj0.b(g61)) {
                dj0 a2 = gj0.a(g61);
                pair = new Pair(a2.k(), a2.l());
            } else {
                pair = new Pair(g61, g61);
            }
            g61 g612 = (g61) pair.component1();
            g61 g613 = (g61) pair.component2();
            x31 x31 = x31.INSTANCE;
            if (g612.d()) {
                nullabilityQualifier2 = NullabilityQualifier.NULLABLE;
            } else if (!g613.d()) {
                nullabilityQualifier2 = NullabilityQualifier.NOT_NULL;
            } else {
                nullabilityQualifier = null;
                if (!x31.f(g612)) {
                    mutabilityQualifier = MutabilityQualifier.READ_ONLY;
                } else {
                    mutabilityQualifier = x31.d(g613) ? MutabilityQualifier.MUTABLE : null;
                }
                return new a41(nullabilityQualifier, mutabilityQualifier, g61.f() instanceof mj1, false, 8, null);
            }
            nullabilityQualifier = nullabilityQualifier2;
            if (!x31.f(g612)) {
            }
            return new a41(nullabilityQualifier, mutabilityQualifier, g61.f() instanceof mj1, false, 8, null);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a4, code lost:
            if ((r12.c() || !kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.i(r10)) != false) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d6, code lost:
            if (r0.c() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL) goto L_0x00f1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ef, code lost:
            if (tb.k21.d(r11, java.lang.Boolean.TRUE) != false) goto L_0x00f1;
         */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00f6  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00f8  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0123  */
        private final a41 i(g61 g61, boolean z, l31 l31, TypeParameterDescriptor typeParameterDescriptor, boolean z2) {
            Annotations annotations;
            boolean z3;
            Annotated annotated;
            Annotated annotated2;
            boolean z4;
            boolean typeEnhancementImprovements = this.e.a().p().getTypeEnhancementImprovements();
            boolean z5 = true;
            if (z && (annotated2 = this.a) != null && !(annotated2 instanceof TypeParameterDescriptor) && typeEnhancementImprovements) {
                Annotations annotations2 = annotated2.getAnnotations();
                SignatureEnhancement signatureEnhancement = SignatureEnhancement.this;
                ArrayList arrayList = new ArrayList();
                for (Object obj : annotations2) {
                    AnnotationTypeQualifierResolver.a h2 = signatureEnhancement.a.h((AnnotationDescriptor) obj);
                    if (h2 != null && !h2.b().contains(AnnotationQualifierApplicabilityType.TYPE_USE)) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        arrayList.add(obj);
                    }
                }
                annotations = e6.a(Annotations.Companion.a(arrayList), g61.getAnnotations());
            } else if (!z || (annotated = this.a) == null) {
                annotations = g61.getAnnotations();
            } else {
                annotations = e6.a(annotated.getAnnotations(), g61.getAnnotations());
            }
            Boolean bool = null;
            if (z) {
                b41 b2 = this.e.b();
                l31 = b2 == null ? null : b2.a(this.f);
            }
            if (l31 != null) {
            }
            l31 = null;
            Pair<hk1, Boolean> n = n(g61);
            hk1 component1 = n.component1();
            boolean booleanValue = n.component2().booleanValue();
            hk1 g2 = g(annotations, typeEnhancementImprovements, this.g);
            if (g2 == null || z2) {
                g2 = null;
            }
            hk1 c2 = g2 == null ? c(component1, l31, typeParameterDescriptor) : g2;
            if (g2 == null) {
                if (!booleanValue) {
                }
                z3 = true;
                NullabilityQualifier c3 = c2 != null ? null : c2.c();
                MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) k(j(v41.m(), annotations, MutabilityQualifier.READ_ONLY), j(v41.j(), annotations, MutabilityQualifier.MUTABLE));
                if (!z3 || !TypeUtilsKt.i(g61)) {
                    z5 = false;
                }
                if (c2 != null) {
                    bool = Boolean.valueOf(c2.d());
                }
                return new a41(c3, mutabilityQualifier, z5, k21.d(bool, Boolean.TRUE));
            }
            z3 = false;
            if (c2 != null) {
            }
            MutabilityQualifier mutabilityQualifier2 = (MutabilityQualifier) k(j(v41.m(), annotations, MutabilityQualifier.READ_ONLY), j(v41.j(), annotations, MutabilityQualifier.MUTABLE));
            z5 = false;
            if (c2 != null) {
            }
            return new a41(c3, mutabilityQualifier2, z5, k21.d(bool, Boolean.TRUE));
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        private static final <T> T j(List<en0> list, Annotations annotations, T t) {
            boolean z;
            boolean z2 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (annotations.findAnnotation(it.next()) != null) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                if (!z2) {
                    return t;
                }
                return null;
            }
            z2 = false;
            if (!z2) {
            }
        }

        private static final <T> T k(T t, T t2) {
            if (t == null || t2 == null || k21.d(t, t2)) {
                return t == null ? t2 : t;
            }
            return null;
        }

        private final boolean l() {
            Annotated annotated = this.a;
            g61 g61 = null;
            if (!(annotated instanceof ValueParameterDescriptor)) {
                annotated = null;
            }
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) annotated;
            if (valueParameterDescriptor != null) {
                g61 = valueParameterDescriptor.getVarargElementType();
            }
            return g61 != null;
        }

        private final NullabilityQualifier m(NullabilityQualifier nullabilityQualifier, NullabilityQualifier nullabilityQualifier2) {
            NullabilityQualifier nullabilityQualifier3 = NullabilityQualifier.FORCE_FLEXIBILITY;
            if (nullabilityQualifier == nullabilityQualifier3) {
                return nullabilityQualifier2;
            }
            if (nullabilityQualifier2 == nullabilityQualifier3) {
                return nullabilityQualifier;
            }
            NullabilityQualifier nullabilityQualifier4 = NullabilityQualifier.NULLABLE;
            if (nullabilityQualifier == nullabilityQualifier4) {
                return nullabilityQualifier2;
            }
            if (nullabilityQualifier2 == nullabilityQualifier4) {
                return nullabilityQualifier;
            }
            if (nullabilityQualifier == nullabilityQualifier2) {
                NullabilityQualifier nullabilityQualifier5 = NullabilityQualifier.NOT_NULL;
            }
            return NullabilityQualifier.NOT_NULL;
        }

        private final Pair<hk1, Boolean> n(g61 g61) {
            ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
            TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
            NullabilityQualifier a2 = typeParameterDescriptor == null ? null : a(typeParameterDescriptor);
            if (a2 == null) {
                return new Pair<>(null, Boolean.FALSE);
            }
            NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
            boolean z = false;
            hk1 hk1 = new hk1(nullabilityQualifier, false, 2, null);
            if (a2 == nullabilityQualifier) {
                z = true;
            }
            return new Pair<>(hk1, Boolean.valueOf(z));
        }

        private final List<b> o(g61 g61) {
            ArrayList arrayList = new ArrayList(1);
            p(this, arrayList, g61, this.e, null);
            return arrayList;
        }

        private static final void p(SignatureParts signatureParts, ArrayList<b> arrayList, g61 g61, x61 x61, TypeParameterDescriptor typeParameterDescriptor) {
            l31 l31;
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
            x61 h2 = ContextKt.h(x61, g61.getAnnotations());
            b41 b2 = h2.b();
            if (b2 == null) {
                l31 = null;
            } else {
                if (signatureParts.g) {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
                } else {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
                }
                l31 = b2.a(annotationQualifierApplicabilityType);
            }
            arrayList.add(new b(g61, l31, typeParameterDescriptor, false));
            List<TypeProjection> b3 = g61.b();
            List<TypeParameterDescriptor> parameters = g61.c().getParameters();
            k21.h(parameters, "type.constructor.parameters");
            for (Pair pair : CollectionsKt___CollectionsKt.F0(b3, parameters)) {
                TypeProjection typeProjection = (TypeProjection) pair.component1();
                TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) pair.component2();
                if (typeProjection.isStarProjection()) {
                    g61 type = typeProjection.getType();
                    k21.h(type, "arg.type");
                    arrayList.add(new b(type, l31, typeParameterDescriptor2, true));
                } else {
                    g61 type2 = typeProjection.getType();
                    k21.h(type2, "arg.type");
                    p(signatureParts, arrayList, type2, h2, typeParameterDescriptor2);
                }
            }
        }

        @NotNull
        public final a e(@Nullable no2 no2) {
            SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 signatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1;
            Function1<Integer, a41> b2 = b();
            a aVar = null;
            if (no2 == null) {
                signatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 = null;
            } else {
                signatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 = new SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1(no2, b2);
            }
            boolean c2 = bp2.c(this.b, SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1.INSTANCE);
            z31 z31 = SignatureEnhancement.this.c;
            g61 g61 = this.b;
            if (signatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 != null) {
                b2 = signatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1;
            }
            g61 b3 = z31.b(g61, b2);
            if (b3 != null) {
                aVar = new a(b3, true, c2);
            }
            return aVar == null ? new a(this.b, false, c2) : aVar;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SignatureParts(Annotated annotated, g61 g61, Collection collection, boolean z, x61 x61, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2, int i, m40 m40) {
            this(SignatureEnhancement.this, annotated, g61, collection, z, x61, annotationQualifierApplicabilityType, (i & 64) != 0 ? false : z2);
        }
    }
}
