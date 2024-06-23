package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.av1;
import tb.bc2;
import tb.bv1;
import tb.f60;
import tb.g60;
import tb.g61;
import tb.gj0;
import tb.gn1;
import tb.h60;
import tb.h61;
import tb.i61;
import tb.ii1;
import tb.og1;
import tb.rw2;
import tb.ti;
import tb.ur2;

/* compiled from: Taobao */
public class OverridingUtil {
    public static final OverridingUtil DEFAULT;
    private static final List<ExternalOverridabilityCondition> c = CollectionsKt___CollectionsKt.y0(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
    private static final KotlinTypeChecker.TypeConstructorEquality d;
    private final i61 a;
    private final KotlinTypeChecker.TypeConstructorEquality b;

    /* compiled from: Taobao */
    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo b = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        private final Result a;

        /* compiled from: Taobao */
        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public OverrideCompatibilityInfo(@NotNull Result result, @NotNull String str) {
            if (result == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.a = result;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x003b  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x005a  */
        private static /* synthetic */ void a(int i) {
            String format;
            String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[((i == 1 || i == 2 || i == 3 || i == 4) ? 3 : 2)];
            if (!(i == 1 || i == 2)) {
                if (i == 3) {
                    objArr[0] = "success";
                } else if (i != 4) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                }
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                        break;
                    case 5:
                        objArr[1] = "getResult";
                        break;
                    case 6:
                        objArr[1] = "getDebugMessage";
                        break;
                    default:
                        objArr[1] = "success";
                        break;
                }
                if (i != 1) {
                    objArr[2] = "incompatible";
                } else if (i == 2) {
                    objArr[2] = "conflict";
                } else if (i == 3 || i == 4) {
                    objArr[2] = "<init>";
                }
                format = String.format(str, objArr);
                if (i != 1 || i == 2 || i == 3 || i == 4) {
                    throw new IllegalArgumentException(format);
                }
                throw new IllegalStateException(format);
            }
            objArr[0] = "debugMessage";
            switch (i) {
            }
            if (i != 1) {
            }
            format = String.format(str, objArr);
            if (i != 1) {
            }
            throw new IllegalArgumentException(format);
        }

        @NotNull
        public static OverrideCompatibilityInfo b(@NotNull String str) {
            if (str == null) {
                a(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        @NotNull
        public static OverrideCompatibilityInfo d(@NotNull String str) {
            if (str == null) {
                a(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        @NotNull
        public static OverrideCompatibilityInfo e() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = b;
            if (overrideCompatibilityInfo == null) {
                a(0);
            }
            return overrideCompatibilityInfo;
        }

        @NotNull
        public Result c() {
            Result result = this.a;
            if (result == null) {
                a(5);
            }
            return result;
        }
    }

    /* compiled from: Taobao */
    static class a implements KotlinTypeChecker.TypeConstructorEquality {
        a() {
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
        public boolean equals(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
            if (typeConstructor == null) {
                a(0);
            }
            if (typeConstructor2 == null) {
                a(1);
            }
            return typeConstructor.equals(typeConstructor2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b implements Function2<D, D, Pair<CallableDescriptor, CallableDescriptor>> {
        b() {
        }

        /* renamed from: a */
        public Pair<CallableDescriptor, CallableDescriptor> invoke(D d, D d2) {
            return new Pair<>(d, d2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c implements Function1<CallableMemberDescriptor, Boolean> {
        final /* synthetic */ DeclarationDescriptor a;

        c(DeclarationDescriptor declarationDescriptor) {
            this.a = declarationDescriptor;
        }

        /* renamed from: a */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(callableMemberDescriptor.getContainingDeclaration() == this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class d implements Function1<CallableMemberDescriptor, CallableDescriptor> {
        d() {
        }

        /* renamed from: a */
        public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class e implements Function1<CallableMemberDescriptor, Boolean> {
        final /* synthetic */ ClassDescriptor a;

        e(ClassDescriptor classDescriptor) {
            this.a = classDescriptor;
        }

        /* renamed from: a */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(!g60.g(callableMemberDescriptor.getVisibility()) && g60.h(callableMemberDescriptor, this.a));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class f implements Function1<CallableMemberDescriptor, CallableDescriptor> {
        f() {
        }

        /* renamed from: a */
        public CallableDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class g implements Function1<CallableMemberDescriptor, ur2> {
        final /* synthetic */ gn1 a;
        final /* synthetic */ CallableMemberDescriptor b;

        g(gn1 gn1, CallableMemberDescriptor callableMemberDescriptor) {
            this.a = gn1;
            this.b = callableMemberDescriptor;
        }

        /* renamed from: a */
        public ur2 invoke(CallableMemberDescriptor callableMemberDescriptor) {
            this.a.b(this.b, callableMemberDescriptor);
            return ur2.INSTANCE;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class h {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007d */
        static {
            int[] iArr = new int[Modality.values().length];
            c = iArr;
            try {
                iArr[Modality.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[Modality.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[Modality.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[Modality.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[OverrideCompatibilityInfo.Result.values().length];
            b = iArr2;
            iArr2[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            b[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;
            try {
                b[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[ExternalOverridabilityCondition.Result.values().length];
            a = iArr3;
            iArr3[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;
            a[ExternalOverridabilityCondition.Result.CONFLICT.ordinal()] = 2;
            a[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 3;
            try {
                a[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class i extends ti {
        @Nullable
        private final Map<TypeConstructor, TypeConstructor> i;

        public i(@Nullable Map<TypeConstructor, TypeConstructor> map) {
            super(true, true, true, OverridingUtil.this.a);
            this.i = map;
        }

        private static /* synthetic */ void A(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1 || i2 == 3) {
                objArr[0] = "b";
            } else {
                objArr[0] = "a";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverridingUtilTypeCheckerContext";
            if (i2 == 2 || i2 == 3) {
                objArr[2] = "areEqualTypeConstructorsByAxioms";
            } else {
                objArr[2] = "areEqualTypeConstructors";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean B(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
            if (typeConstructor == null) {
                A(2);
            }
            if (typeConstructor2 == null) {
                A(3);
            }
            if (OverridingUtil.this.b.equals(typeConstructor, typeConstructor2)) {
                return true;
            }
            Map<TypeConstructor, TypeConstructor> map = this.i;
            if (map == null) {
                return false;
            }
            TypeConstructor typeConstructor3 = map.get(typeConstructor);
            TypeConstructor typeConstructor4 = this.i.get(typeConstructor2);
            if (typeConstructor3 != null && typeConstructor3.equals(typeConstructor2)) {
                return true;
            }
            if (typeConstructor4 == null || !typeConstructor4.equals(typeConstructor)) {
                return false;
            }
            return true;
        }

        @Override // tb.ti
        public boolean y(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
            if (typeConstructor == null) {
                A(0);
            }
            if (typeConstructor2 == null) {
                A(1);
            }
            return super.y(typeConstructor, typeConstructor2) || B(typeConstructor, typeConstructor2);
        }
    }

    static {
        a aVar = new a();
        d = aVar;
        DEFAULT = new OverridingUtil(aVar, i61.a.INSTANCE);
    }

    private OverridingUtil(@NotNull KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality, @NotNull i61 i61) {
        if (typeConstructorEquality == null) {
            a(4);
        }
        if (i61 == null) {
            a(5);
        }
        this.b = typeConstructorEquality;
        this.a = i61;
    }

    @Nullable
    public static OverrideCompatibilityInfo.Result A(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil overridingUtil = DEFAULT;
        OverrideCompatibilityInfo.Result c2 = overridingUtil.G(callableDescriptor2, callableDescriptor, null).c();
        OverrideCompatibilityInfo.Result c3 = overridingUtil.G(callableDescriptor, callableDescriptor2, null).c();
        OverrideCompatibilityInfo.Result result = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (c2 == result && c3 == result) {
            return result;
        }
        OverrideCompatibilityInfo.Result result2 = OverrideCompatibilityInfo.Result.CONFLICT;
        return (c2 == result2 || c3 == result2) ? result2 : OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }

    @NotNull
    private static Modality B(@NotNull Collection<CallableMemberDescriptor> collection, boolean z, @NotNull Modality modality) {
        if (collection == null) {
            a(91);
        }
        if (modality == null) {
            a(92);
        }
        Modality modality2 = Modality.ABSTRACT;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            Modality modality3 = (!z || callableMemberDescriptor.getModality() != Modality.ABSTRACT) ? callableMemberDescriptor.getModality() : modality;
            if (modality3.compareTo((Enum) modality2) < 0) {
                modality2 = modality3;
            }
        }
        if (modality2 == null) {
            a(93);
        }
        return modality2;
    }

    @NotNull
    public static Set<CallableMemberDescriptor> C(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(13);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        h(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    private static boolean D(@Nullable PropertyAccessorDescriptor propertyAccessorDescriptor, @Nullable PropertyAccessorDescriptor propertyAccessorDescriptor2) {
        if (propertyAccessorDescriptor == null || propertyAccessorDescriptor2 == null) {
            return true;
        }
        return K(propertyAccessorDescriptor, propertyAccessorDescriptor2);
    }

    public static boolean E(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            a(65);
        }
        if (callableDescriptor2 == null) {
            a(66);
        }
        g61 returnType = callableDescriptor.getReturnType();
        g61 returnType2 = callableDescriptor2.getReturnType();
        if (!K(callableDescriptor, callableDescriptor2)) {
            return false;
        }
        Pair<ii1, ti> n = DEFAULT.n(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters());
        if (callableDescriptor instanceof FunctionDescriptor) {
            return J(callableDescriptor, returnType, callableDescriptor2, returnType2, n);
        }
        if (callableDescriptor instanceof PropertyDescriptor) {
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
            PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
            if (!D(propertyDescriptor.getSetter(), propertyDescriptor2.getSetter())) {
                return false;
            }
            if (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) {
                return n.getFirst().a(n.getSecond(), returnType.f(), returnType2.f());
            }
            if ((propertyDescriptor.isVar() || !propertyDescriptor2.isVar()) && J(callableDescriptor, returnType, callableDescriptor2, returnType2, n)) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Unexpected callable: " + callableDescriptor.getClass());
    }

    private static boolean F(@NotNull CallableDescriptor callableDescriptor, @NotNull Collection<CallableDescriptor> collection) {
        if (callableDescriptor == null) {
            a(69);
        }
        if (collection == null) {
            a(70);
        }
        for (CallableDescriptor callableDescriptor2 : collection) {
            if (!E(callableDescriptor, callableDescriptor2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean J(@NotNull CallableDescriptor callableDescriptor, @NotNull g61 g61, @NotNull CallableDescriptor callableDescriptor2, @NotNull g61 g612, @NotNull Pair<ii1, ti> pair) {
        if (callableDescriptor == null) {
            a(71);
        }
        if (g61 == null) {
            a(72);
        }
        if (callableDescriptor2 == null) {
            a(73);
        }
        if (g612 == null) {
            a(74);
        }
        if (pair == null) {
            a(75);
        }
        return pair.getFirst().b(pair.getSecond(), g61.f(), g612.f());
    }

    private static boolean K(@NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        if (declarationDescriptorWithVisibility == null) {
            a(67);
        }
        if (declarationDescriptorWithVisibility2 == null) {
            a(68);
        }
        Integer d2 = g60.d(declarationDescriptorWithVisibility.getVisibility(), declarationDescriptorWithVisibility2.getVisibility());
        return d2 == null || d2.intValue() >= 0;
    }

    public static boolean L(@NotNull MemberDescriptor memberDescriptor, @NotNull MemberDescriptor memberDescriptor2) {
        if (memberDescriptor == null) {
            a(55);
        }
        if (memberDescriptor2 == null) {
            a(56);
        }
        return !g60.g(memberDescriptor2.getVisibility()) && g60.h(memberDescriptor2, memberDescriptor);
    }

    public static <D extends CallableDescriptor> boolean M(@NotNull D d2, @NotNull D d3, boolean z, boolean z2) {
        if (d2 == null) {
            a(11);
        }
        if (d3 == null) {
            a(12);
        }
        if (!d2.equals(d3) && DescriptorEquivalenceForOverrides.INSTANCE.e(d2.getOriginal(), d3.getOriginal(), z, z2)) {
            return true;
        }
        CallableDescriptor original = d3.getOriginal();
        for (CallableDescriptor callableDescriptor : f60.d(d2)) {
            if (DescriptorEquivalenceForOverrides.INSTANCE.e(original, callableDescriptor, z, z2)) {
                return true;
            }
        }
        return false;
    }

    public static void N(@NotNull CallableMemberDescriptor callableMemberDescriptor, @Nullable Function1<CallableMemberDescriptor, ur2> function1) {
        h60 h60;
        if (callableMemberDescriptor == null) {
            a(105);
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor2.getVisibility() == g60.INHERITED) {
                N(callableMemberDescriptor2, function1);
            }
        }
        if (callableMemberDescriptor.getVisibility() == g60.INHERITED) {
            h60 j = j(callableMemberDescriptor);
            if (j == null) {
                if (function1 != null) {
                    function1.invoke(callableMemberDescriptor);
                }
                h60 = g60.PUBLIC;
            } else {
                h60 = j;
            }
            if (callableMemberDescriptor instanceof bv1) {
                ((bv1) callableMemberDescriptor).u(h60);
                for (PropertyAccessorDescriptor propertyAccessorDescriptor : ((PropertyDescriptor) callableMemberDescriptor).getAccessors()) {
                    N(propertyAccessorDescriptor, j == null ? null : function1);
                }
            } else if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.a) {
                ((kotlin.reflect.jvm.internal.impl.descriptors.impl.a) callableMemberDescriptor).D(h60);
            } else {
                av1 av1 = (av1) callableMemberDescriptor;
                av1.i(h60);
                if (h60 != av1.getCorrespondingProperty().getVisibility()) {
                    av1.g(false);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.jvm.functions.Function1<H, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <H> H O(@NotNull Collection<H> collection, @NotNull Function1<H, CallableDescriptor> function1) {
        if (collection == null) {
            a(76);
        }
        if (function1 == 0) {
            a(77);
        }
        if (collection.size() == 1) {
            H h2 = (H) k.O(collection);
            if (h2 == null) {
                a(78);
            }
            return h2;
        }
        ArrayList arrayList = new ArrayList(2);
        List list = CollectionsKt___CollectionsKt.e0(collection, function1);
        H h3 = (H) k.O(collection);
        CallableDescriptor callableDescriptor = (CallableDescriptor) function1.invoke(h3);
        for (H h4 : collection) {
            CallableDescriptor callableDescriptor2 = (CallableDescriptor) function1.invoke(h4);
            if (F(callableDescriptor2, list)) {
                arrayList.add(h4);
            }
            if (E(callableDescriptor2, callableDescriptor) && !E(callableDescriptor, callableDescriptor2)) {
                h3 = h4;
            }
        }
        if (arrayList.isEmpty()) {
            if (h3 == null) {
                a(79);
            }
            return h3;
        } else if (arrayList.size() == 1) {
            H h5 = (H) k.O(arrayList);
            if (h5 == null) {
                a(80);
            }
            return h5;
        } else {
            H h6 = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!gj0.b(((CallableDescriptor) function1.invoke(next)).getReturnType())) {
                    h6 = next;
                    break;
                }
            }
            if (h6 != null) {
                return h6;
            }
            H h7 = (H) k.O(arrayList);
            if (h7 == null) {
                a(82);
            }
            return h7;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0157 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01a1  */
    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        Object[] objArr;
        if (!(i2 == 9 || i2 == 10 || i2 == 14 || i2 == 19 || i2 == 93 || i2 == 96 || i2 == 101)) {
            switch (i2) {
                default:
                    switch (i2) {
                        default:
                            switch (i2) {
                                default:
                                    switch (i2) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                    }
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
            }
            if (!(i2 == 9 || i2 == 10 || i2 == 14 || i2 == 19 || i2 == 93 || i2 == 96 || i2 == 101)) {
                switch (i2) {
                    default:
                        switch (i2) {
                            default:
                                switch (i2) {
                                    default:
                                        switch (i2) {
                                            case 88:
                                            case 89:
                                            case 90:
                                                break;
                                            default:
                                                i3 = 3;
                                                break;
                                        }
                                    case 78:
                                    case 79:
                                    case 80:
                                    case 81:
                                    case 82:
                                        i3 = 2;
                                        break;
                                }
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                                break;
                        }
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                        break;
                }
                objArr = new Object[i3];
                switch (i2) {
                    case 1:
                    case 2:
                    case 5:
                        objArr[0] = "kotlinTypeRefiner";
                        break;
                    case 3:
                    default:
                        objArr[0] = "equalityAxioms";
                        break;
                    case 4:
                        objArr[0] = "axioms";
                        break;
                    case 6:
                    case 7:
                        objArr[0] = "candidateSet";
                        break;
                    case 8:
                        objArr[0] = "transformFirst";
                        break;
                    case 9:
                    case 10:
                    case 14:
                    case 19:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 88:
                    case 89:
                    case 90:
                    case 93:
                    case 96:
                    case 101:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                        break;
                    case 11:
                        objArr[0] = "f";
                        break;
                    case 12:
                        objArr[0] = "g";
                        break;
                    case 13:
                    case 15:
                        objArr[0] = "descriptor";
                        break;
                    case 16:
                        objArr[0] = "result";
                        break;
                    case 17:
                    case 20:
                    case 28:
                    case 38:
                        objArr[0] = "superDescriptor";
                        break;
                    case 18:
                    case 21:
                    case 29:
                    case 39:
                        objArr[0] = "subDescriptor";
                        break;
                    case 40:
                    case 42:
                        objArr[0] = "firstParameters";
                        break;
                    case 41:
                    case 43:
                        objArr[0] = "secondParameters";
                        break;
                    case 44:
                        objArr[0] = "typeInSuper";
                        break;
                    case 45:
                        objArr[0] = "typeInSub";
                        break;
                    case 46:
                    case 49:
                    case 75:
                        objArr[0] = "typeChecker";
                        break;
                    case 47:
                        objArr[0] = "superTypeParameter";
                        break;
                    case 48:
                        objArr[0] = "subTypeParameter";
                        break;
                    case 50:
                        objArr[0] = "name";
                        break;
                    case 51:
                        objArr[0] = "membersFromSupertypes";
                        break;
                    case 52:
                        objArr[0] = "membersFromCurrent";
                        break;
                    case 53:
                    case 59:
                    case 62:
                    case 84:
                    case 87:
                    case 94:
                        objArr[0] = "current";
                        break;
                    case 54:
                    case 60:
                    case 64:
                    case 85:
                    case 104:
                        objArr[0] = "strategy";
                        break;
                    case 55:
                        objArr[0] = "overriding";
                        break;
                    case 56:
                        objArr[0] = "fromSuper";
                        break;
                    case 57:
                        objArr[0] = "fromCurrent";
                        break;
                    case 58:
                        objArr[0] = "descriptorsFromSuper";
                        break;
                    case 61:
                    case 63:
                        objArr[0] = "notOverridden";
                        break;
                    case 65:
                    case 67:
                    case 71:
                        objArr[0] = "a";
                        break;
                    case 66:
                    case 68:
                    case 73:
                        objArr[0] = "b";
                        break;
                    case 69:
                        objArr[0] = "candidate";
                        break;
                    case 70:
                    case 86:
                    case 91:
                    case 107:
                        objArr[0] = "descriptors";
                        break;
                    case 72:
                        objArr[0] = "aReturnType";
                        break;
                    case 74:
                        objArr[0] = "bReturnType";
                        break;
                    case 76:
                    case 83:
                        objArr[0] = "overridables";
                        break;
                    case 77:
                    case 99:
                        objArr[0] = "descriptorByHandle";
                        break;
                    case 92:
                        objArr[0] = "classModality";
                        break;
                    case 95:
                        objArr[0] = "toFilter";
                        break;
                    case 97:
                    case 102:
                        objArr[0] = "overrider";
                        break;
                    case 98:
                    case 103:
                        objArr[0] = "extractFrom";
                        break;
                    case 100:
                        objArr[0] = "onConflict";
                        break;
                    case 105:
                    case 106:
                        objArr[0] = "memberDescriptor";
                        break;
                }
                if (i2 != 9 || i2 == 10) {
                    objArr[1] = "filterOverrides";
                } else if (i2 != 14) {
                    if (i2 != 19) {
                        if (i2 == 93) {
                            objArr[1] = "getMinimalModality";
                        } else if (i2 == 96) {
                            objArr[1] = "filterVisibleFakeOverrides";
                        } else if (i2 != 101) {
                            switch (i2) {
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                    break;
                                default:
                                    switch (i2) {
                                        case 30:
                                        case 31:
                                        case 32:
                                        case 33:
                                        case 34:
                                        case 35:
                                        case 36:
                                        case 37:
                                            objArr[1] = "isOverridableByWithoutExternalConditions";
                                            break;
                                        default:
                                            switch (i2) {
                                                case 78:
                                                case 79:
                                                case 80:
                                                case 81:
                                                case 82:
                                                    objArr[1] = "selectMostSpecificMember";
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case 88:
                                                        case 89:
                                                        case 90:
                                                            objArr[1] = "determineModalityForFakeOverride";
                                                            break;
                                                        default:
                                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                                            break;
                                                    }
                                            }
                                    }
                            }
                        } else {
                            objArr[1] = "extractMembersOverridableInBothWays";
                        }
                    }
                    objArr[1] = "isOverridableBy";
                } else {
                    objArr[1] = "getOverriddenDeclarations";
                }
                switch (i2) {
                    case 1:
                        objArr[2] = "createWithTypeRefiner";
                        break;
                    case 2:
                    case 3:
                        objArr[2] = "create";
                        break;
                    case 4:
                    case 5:
                        objArr[2] = "<init>";
                        break;
                    case 6:
                        objArr[2] = "filterOutOverridden";
                        break;
                    case 7:
                    case 8:
                        objArr[2] = "filterOverrides";
                        break;
                    case 9:
                    case 10:
                    case 14:
                    case 19:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 88:
                    case 89:
                    case 90:
                    case 93:
                    case 96:
                    case 101:
                        break;
                    case 11:
                    case 12:
                        objArr[2] = "overrides";
                        break;
                    case 13:
                        objArr[2] = "getOverriddenDeclarations";
                        break;
                    case 15:
                    case 16:
                        objArr[2] = "collectOverriddenDeclarations";
                        break;
                    case 17:
                    case 18:
                    case 20:
                    case 21:
                        objArr[2] = "isOverridableBy";
                        break;
                    case 28:
                    case 29:
                        objArr[2] = "isOverridableByWithoutExternalConditions";
                        break;
                    case 38:
                    case 39:
                        objArr[2] = "getBasicOverridabilityProblem";
                        break;
                    case 40:
                    case 41:
                        objArr[2] = "createTypeChecker";
                        break;
                    case 42:
                    case 43:
                        objArr[2] = "createTypeCheckerContext";
                        break;
                    case 44:
                    case 45:
                    case 46:
                        objArr[2] = "areTypesEquivalent";
                        break;
                    case 47:
                    case 48:
                    case 49:
                        objArr[2] = "areTypeParametersEquivalent";
                        break;
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                        objArr[2] = "generateOverridesInFunctionGroup";
                        break;
                    case 55:
                    case 56:
                        objArr[2] = "isVisibleForOverride";
                        break;
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                        objArr[2] = "extractAndBindOverridesForMember";
                        break;
                    case 61:
                        objArr[2] = "allHasSameContainingDeclaration";
                        break;
                    case 62:
                    case 63:
                    case 64:
                        objArr[2] = "createAndBindFakeOverrides";
                        break;
                    case 65:
                    case 66:
                        objArr[2] = "isMoreSpecific";
                        break;
                    case 67:
                    case 68:
                        objArr[2] = "isVisibilityMoreSpecific";
                        break;
                    case 69:
                    case 70:
                        objArr[2] = "isMoreSpecificThenAllOf";
                        break;
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                        objArr[2] = "isReturnTypeMoreSpecific";
                        break;
                    case 76:
                    case 77:
                        objArr[2] = "selectMostSpecificMember";
                        break;
                    case 83:
                    case 84:
                    case 85:
                        objArr[2] = "createAndBindFakeOverride";
                        break;
                    case 86:
                    case 87:
                        objArr[2] = "determineModalityForFakeOverride";
                        break;
                    case 91:
                    case 92:
                        objArr[2] = "getMinimalModality";
                        break;
                    case 94:
                    case 95:
                        objArr[2] = "filterVisibleFakeOverrides";
                        break;
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 102:
                    case 103:
                    case 104:
                        objArr[2] = "extractMembersOverridableInBothWays";
                        break;
                    case 105:
                        objArr[2] = "resolveUnknownVisibilityForMember";
                        break;
                    case 106:
                        objArr[2] = "computeVisibilityToInherit";
                        break;
                    case 107:
                        objArr[2] = "findMaxVisibility";
                        break;
                    default:
                        objArr[2] = "createWithEqualityAxioms";
                        break;
                }
                String format = String.format(str, objArr);
                if (!(i2 == 9 || i2 == 10 || i2 == 14 || i2 == 19 || i2 == 93 || i2 == 96 || i2 == 101)) {
                    switch (i2) {
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                            break;
                        default:
                            switch (i2) {
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                    break;
                                default:
                                    switch (i2) {
                                        case 78:
                                        case 79:
                                        case 80:
                                        case 81:
                                        case 82:
                                            break;
                                        default:
                                            switch (i2) {
                                                case 88:
                                                case 89:
                                                case 90:
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(format);
                                            }
                                    }
                            }
                    }
                }
                throw new IllegalStateException(format);
            }
            i3 = 2;
            objArr = new Object[i3];
            switch (i2) {
            }
            if (i2 != 9) {
            }
            objArr[1] = "filterOverrides";
            switch (i2) {
            }
            String format2 = String.format(str, objArr);
            switch (i2) {
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        switch (i2) {
        }
        objArr = new Object[i3];
        switch (i2) {
        }
        if (i2 != 9) {
        }
        objArr[1] = "filterOverrides";
        switch (i2) {
        }
        String format22 = String.format(str, objArr);
        switch (i2) {
        }
        throw new IllegalStateException(format22);
    }

    private static boolean d(@NotNull Collection<CallableMemberDescriptor> collection) {
        if (collection == null) {
            a(61);
        }
        if (collection.size() < 2) {
            return true;
        }
        return CollectionsKt___CollectionsKt.H(collection, new c(collection.iterator().next().getContainingDeclaration()));
    }

    private boolean e(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeParameterDescriptor typeParameterDescriptor2, @NotNull Pair<ii1, ti> pair) {
        if (typeParameterDescriptor == null) {
            a(47);
        }
        if (typeParameterDescriptor2 == null) {
            a(48);
        }
        if (pair == null) {
            a(49);
        }
        List<g61> upperBounds = typeParameterDescriptor.getUpperBounds();
        ArrayList arrayList = new ArrayList(typeParameterDescriptor2.getUpperBounds());
        if (upperBounds.size() != arrayList.size()) {
            return false;
        }
        for (g61 g61 : upperBounds) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (f(g61, (g61) listIterator.next(), pair)) {
                    listIterator.remove();
                }
            }
            return false;
        }
        return true;
    }

    private boolean f(@NotNull g61 g61, @NotNull g61 g612, @NotNull Pair<ii1, ti> pair) {
        if (g61 == null) {
            a(44);
        }
        if (g612 == null) {
            a(45);
        }
        if (pair == null) {
            a(46);
        }
        if (h61.a(g61) && h61.a(g612)) {
            return true;
        }
        return pair.getFirst().a(pair.getSecond(), g61.f(), g612.f());
    }

    @Nullable
    private static OverrideCompatibilityInfo g(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        boolean z = true;
        boolean z2 = callableDescriptor.getExtensionReceiverParameter() == null;
        if (callableDescriptor2.getExtensionReceiverParameter() != null) {
            z = false;
        }
        if (z2 != z) {
            return OverrideCompatibilityInfo.d("Receiver presence mismatch");
        }
        if (callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size()) {
            return OverrideCompatibilityInfo.d("Value parameter number mismatch");
        }
        return null;
    }

    private static void h(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            a(15);
        }
        if (set == null) {
            a(16);
        }
        if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
        } else if (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
                h(callableMemberDescriptor2, set);
            }
        } else {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
    }

    private static List<g61> i(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        for (ValueParameterDescriptor valueParameterDescriptor : callableDescriptor.getValueParameters()) {
            arrayList.add(valueParameterDescriptor.getType());
        }
        return arrayList;
    }

    @Nullable
    private static h60 j(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(106);
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        h60 x = x(overriddenDescriptors);
        if (x == null) {
            return null;
        }
        if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return x.f();
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
            if (!(callableMemberDescriptor2.getModality() == Modality.ABSTRACT || callableMemberDescriptor2.getVisibility().equals(x))) {
                return null;
            }
        }
        return x;
    }

    @NotNull
    public static OverridingUtil k(@NotNull i61 i61, @NotNull KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality) {
        if (i61 == null) {
            a(2);
        }
        if (typeConstructorEquality == null) {
            a(3);
        }
        return new OverridingUtil(typeConstructorEquality, i61);
    }

    private static void l(@NotNull Collection<CallableMemberDescriptor> collection, @NotNull ClassDescriptor classDescriptor, @NotNull gn1 gn1) {
        if (collection == null) {
            a(83);
        }
        if (classDescriptor == null) {
            a(84);
        }
        if (gn1 == null) {
            a(85);
        }
        Collection<CallableMemberDescriptor> w = w(classDescriptor, collection);
        boolean isEmpty = w.isEmpty();
        if (!isEmpty) {
            collection = w;
        }
        CallableMemberDescriptor copy = ((CallableMemberDescriptor) O(collection, new d())).copy(classDescriptor, q(collection, classDescriptor), isEmpty ? g60.INVISIBLE_FAKE : g60.INHERITED, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        gn1.d(copy, collection);
        gn1.a(copy);
    }

    private static void m(@NotNull ClassDescriptor classDescriptor, @NotNull Collection<CallableMemberDescriptor> collection, @NotNull gn1 gn1) {
        if (classDescriptor == null) {
            a(62);
        }
        if (collection == null) {
            a(63);
        }
        if (gn1 == null) {
            a(64);
        }
        if (d(collection)) {
            for (CallableMemberDescriptor callableMemberDescriptor : collection) {
                l(Collections.singleton(callableMemberDescriptor), classDescriptor, gn1);
            }
            return;
        }
        LinkedList linkedList = new LinkedList(collection);
        while (!linkedList.isEmpty()) {
            l(t(rw2.a(linkedList), linkedList, gn1), classDescriptor, gn1);
        }
    }

    @NotNull
    private Pair<ii1, ti> n(@NotNull List<TypeParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2) {
        if (list == null) {
            a(40);
        }
        if (list2 == null) {
            a(41);
        }
        return new Pair<>(new ii1(this.a), o(list, list2));
    }

    @NotNull
    private i o(@NotNull List<TypeParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2) {
        if (list == null) {
            a(42);
        }
        if (list2 == null) {
            a(43);
        }
        if (list.isEmpty()) {
            return new i(null);
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashMap.put(list.get(i2).getTypeConstructor(), list2.get(i2).getTypeConstructor());
        }
        return new i(hashMap);
    }

    @NotNull
    public static OverridingUtil p(@NotNull i61 i61) {
        if (i61 == null) {
            a(1);
        }
        return new OverridingUtil(d, i61);
    }

    @NotNull
    private static Modality q(@NotNull Collection<CallableMemberDescriptor> collection, @NotNull ClassDescriptor classDescriptor) {
        if (collection == null) {
            a(86);
        }
        if (classDescriptor == null) {
            a(87);
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            int i2 = h.c[callableMemberDescriptor.getModality().ordinal()];
            if (i2 == 1) {
                Modality modality = Modality.FINAL;
                if (modality == null) {
                    a(88);
                }
                return modality;
            } else if (i2 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + callableMemberDescriptor);
            } else if (i2 == 3) {
                z2 = true;
            } else if (i2 == 4) {
                z3 = true;
            }
        }
        if (!(!classDescriptor.isExpect() || classDescriptor.getModality() == Modality.ABSTRACT || classDescriptor.getModality() == Modality.SEALED)) {
            z = true;
        }
        if (z2 && !z3) {
            Modality modality2 = Modality.OPEN;
            if (modality2 == null) {
                a(89);
            }
            return modality2;
        } else if (z2 || !z3) {
            HashSet hashSet = new HashSet();
            for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
                hashSet.addAll(C(callableMemberDescriptor2));
            }
            return B(u(hashSet), z, classDescriptor.getModality());
        } else {
            Modality modality3 = z ? classDescriptor.getModality() : Modality.ABSTRACT;
            if (modality3 == null) {
                a(90);
            }
            return modality3;
        }
    }

    private Collection<CallableMemberDescriptor> r(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> collection, @NotNull ClassDescriptor classDescriptor, @NotNull gn1 gn1) {
        if (callableMemberDescriptor == null) {
            a(57);
        }
        if (collection == null) {
            a(58);
        }
        if (classDescriptor == null) {
            a(59);
        }
        if (gn1 == null) {
            a(60);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        bc2 a2 = bc2.a();
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            OverrideCompatibilityInfo.Result c2 = G(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor).c();
            boolean L = L(callableMemberDescriptor, callableMemberDescriptor2);
            int i2 = h.b[c2.ordinal()];
            if (i2 == 1) {
                if (L) {
                    a2.add(callableMemberDescriptor2);
                }
                arrayList.add(callableMemberDescriptor2);
            } else if (i2 == 2) {
                if (L) {
                    gn1.c(callableMemberDescriptor2, callableMemberDescriptor);
                }
                arrayList.add(callableMemberDescriptor2);
            }
        }
        gn1.d(callableMemberDescriptor, a2);
        return arrayList;
    }

    @NotNull
    public static <H> Collection<H> s(@NotNull H h2, @NotNull Collection<H> collection, @NotNull Function1<H, CallableDescriptor> function1, @NotNull Function1<H, ur2> function12) {
        if (h2 == null) {
            a(97);
        }
        if (collection == null) {
            a(98);
        }
        if (function1 == null) {
            a(99);
        }
        if (function12 == null) {
            a(100);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h2);
        CallableDescriptor invoke = function1.invoke(h2);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            CallableDescriptor invoke2 = function1.invoke(next);
            if (h2 == next) {
                it.remove();
            } else {
                OverrideCompatibilityInfo.Result A = A(invoke, invoke2);
                if (A == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (A == OverrideCompatibilityInfo.Result.CONFLICT) {
                    function12.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> t(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Queue<CallableMemberDescriptor> queue, @NotNull gn1 gn1) {
        if (callableMemberDescriptor == null) {
            a(102);
        }
        if (queue == null) {
            a(103);
        }
        if (gn1 == null) {
            a(104);
        }
        return s(callableMemberDescriptor, queue, new f(), new g(gn1, callableMemberDescriptor));
    }

    @NotNull
    public static <D extends CallableDescriptor> Set<D> u(@NotNull Set<D> set) {
        if (set == null) {
            a(6);
        }
        return v(set, !set.isEmpty() && DescriptorUtilsKt.q(DescriptorUtilsKt.l(set.iterator().next())), null, new b());
    }

    @NotNull
    public static <D> Set<D> v(@NotNull Set<D> set, boolean z, @Nullable Function0<?> function0, @NotNull Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> function2) {
        if (set == null) {
            a(7);
        }
        if (function2 == null) {
            a(8);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (D d2 : set) {
            if (function0 != null) {
                function0.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(d2);
                    break;
                }
                Pair<CallableDescriptor, CallableDescriptor> invoke = function2.invoke(d2, (Object) it.next());
                CallableDescriptor component1 = invoke.component1();
                CallableDescriptor component2 = invoke.component2();
                if (M(component1, component2, z, true)) {
                    it.remove();
                } else if (M(component2, component1, z, true)) {
                    break;
                }
            }
        }
        return linkedHashSet;
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> w(@NotNull ClassDescriptor classDescriptor, @NotNull Collection<CallableMemberDescriptor> collection) {
        if (classDescriptor == null) {
            a(94);
        }
        if (collection == null) {
            a(95);
        }
        List list = CollectionsKt___CollectionsKt.N(collection, new e(classDescriptor));
        if (list == null) {
            a(96);
        }
        return list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
    @Nullable
    public static h60 x(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        h60 h60;
        if (collection == null) {
            a(107);
        }
        if (collection.isEmpty()) {
            return g60.DEFAULT_VISIBILITY;
        }
        Iterator<? extends CallableMemberDescriptor> it = collection.iterator();
        loop0:
        while (true) {
            h60 = null;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                h60 visibility = ((CallableMemberDescriptor) it.next()).getVisibility();
                if (h60 != null) {
                    Integer d2 = g60.d(visibility, h60);
                    if (d2 != null) {
                        if (d2.intValue() <= 0) {
                        }
                    }
                }
                h60 = visibility;
            }
        }
        if (h60 == null) {
            return null;
        }
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            Integer d3 = g60.d(h60, callableMemberDescriptor.getVisibility());
            if (d3 == null || d3.intValue() < 0) {
                return null;
            }
            while (r5.hasNext()) {
            }
        }
        return h60;
    }

    @Nullable
    public static OverrideCompatibilityInfo z(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
        boolean z;
        if (callableDescriptor == null) {
            a(38);
        }
        if (callableDescriptor2 == null) {
            a(39);
        }
        boolean z2 = callableDescriptor instanceof FunctionDescriptor;
        if ((z2 && !(callableDescriptor2 instanceof FunctionDescriptor)) || (((z = callableDescriptor instanceof PropertyDescriptor)) && !(callableDescriptor2 instanceof PropertyDescriptor))) {
            return OverrideCompatibilityInfo.d("Member kind mismatch");
        }
        if (!z2 && !z) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
        } else if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
            return OverrideCompatibilityInfo.d("Name mismatch");
        } else {
            OverrideCompatibilityInfo g2 = g(callableDescriptor, callableDescriptor2);
            if (g2 != null) {
                return g2;
            }
            return null;
        }
    }

    @NotNull
    public OverrideCompatibilityInfo G(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            a(17);
        }
        if (callableDescriptor2 == null) {
            a(18);
        }
        OverrideCompatibilityInfo H = H(callableDescriptor, callableDescriptor2, classDescriptor, false);
        if (H == null) {
            a(19);
        }
        return H;
    }

    @NotNull
    public OverrideCompatibilityInfo H(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor, boolean z) {
        if (callableDescriptor == null) {
            a(20);
        }
        if (callableDescriptor2 == null) {
            a(21);
        }
        OverrideCompatibilityInfo I = I(callableDescriptor, callableDescriptor2, z);
        boolean z2 = I.c() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition externalOverridabilityCondition : c) {
            if (externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z2 || externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                int i2 = h.a[externalOverridabilityCondition.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i2 == 1) {
                    z2 = true;
                } else if (i2 == 2) {
                    OverrideCompatibilityInfo b2 = OverrideCompatibilityInfo.b("External condition failed");
                    if (b2 == null) {
                        a(22);
                    }
                    return b2;
                } else if (i2 == 3) {
                    OverrideCompatibilityInfo d2 = OverrideCompatibilityInfo.d("External condition");
                    if (d2 == null) {
                        a(23);
                    }
                    return d2;
                }
            }
        }
        if (!z2) {
            return I;
        }
        for (ExternalOverridabilityCondition externalOverridabilityCondition2 : c) {
            if (externalOverridabilityCondition2.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                int i3 = h.a[externalOverridabilityCondition2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i3 == 1) {
                    throw new IllegalStateException("Contract violation in " + externalOverridabilityCondition2.getClass().getName() + " condition. It's not supposed to end with success");
                } else if (i3 == 2) {
                    OverrideCompatibilityInfo b3 = OverrideCompatibilityInfo.b("External condition failed");
                    if (b3 == null) {
                        a(25);
                    }
                    return b3;
                } else if (i3 == 3) {
                    OverrideCompatibilityInfo d3 = OverrideCompatibilityInfo.d("External condition");
                    if (d3 == null) {
                        a(26);
                    }
                    return d3;
                }
            }
        }
        OverrideCompatibilityInfo e2 = OverrideCompatibilityInfo.e();
        if (e2 == null) {
            a(27);
        }
        return e2;
    }

    @NotNull
    public OverrideCompatibilityInfo I(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, boolean z) {
        if (callableDescriptor == null) {
            a(28);
        }
        if (callableDescriptor2 == null) {
            a(29);
        }
        OverrideCompatibilityInfo z2 = z(callableDescriptor, callableDescriptor2);
        if (z2 != null) {
            return z2;
        }
        List<g61> i2 = i(callableDescriptor);
        List<g61> i3 = i(callableDescriptor2);
        List<TypeParameterDescriptor> typeParameters = callableDescriptor.getTypeParameters();
        List<TypeParameterDescriptor> typeParameters2 = callableDescriptor2.getTypeParameters();
        int i4 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i4 < i2.size()) {
                if (!KotlinTypeChecker.DEFAULT.equalTypes(i2.get(i4), i3.get(i4))) {
                    OverrideCompatibilityInfo d2 = OverrideCompatibilityInfo.d("Type parameter number mismatch");
                    if (d2 == null) {
                        a(31);
                    }
                    return d2;
                }
                i4++;
            }
            OverrideCompatibilityInfo b2 = OverrideCompatibilityInfo.b("Type parameter number mismatch");
            if (b2 == null) {
                a(32);
            }
            return b2;
        }
        Pair<ii1, ti> n = n(typeParameters, typeParameters2);
        for (int i5 = 0; i5 < typeParameters.size(); i5++) {
            if (!e(typeParameters.get(i5), typeParameters2.get(i5), n)) {
                OverrideCompatibilityInfo d3 = OverrideCompatibilityInfo.d("Type parameter bounds mismatch");
                if (d3 == null) {
                    a(33);
                }
                return d3;
            }
        }
        for (int i6 = 0; i6 < i2.size(); i6++) {
            if (!f(i2.get(i6), i3.get(i6), n)) {
                OverrideCompatibilityInfo d4 = OverrideCompatibilityInfo.d("Value parameter type mismatch");
                if (d4 == null) {
                    a(34);
                }
                return d4;
            }
        }
        if (!(callableDescriptor instanceof FunctionDescriptor) || !(callableDescriptor2 instanceof FunctionDescriptor) || ((FunctionDescriptor) callableDescriptor).isSuspend() == ((FunctionDescriptor) callableDescriptor2).isSuspend()) {
            if (z) {
                g61 returnType = callableDescriptor.getReturnType();
                g61 returnType2 = callableDescriptor2.getReturnType();
                if (!(returnType == null || returnType2 == null)) {
                    if (h61.a(returnType2) && h61.a(returnType)) {
                        i4 = 1;
                    }
                    if (i4 == 0 && !n.getFirst().b(n.getSecond(), returnType2.f(), returnType.f())) {
                        OverrideCompatibilityInfo b3 = OverrideCompatibilityInfo.b("Return type mismatch");
                        if (b3 == null) {
                            a(36);
                        }
                        return b3;
                    }
                }
            }
            OverrideCompatibilityInfo e2 = OverrideCompatibilityInfo.e();
            if (e2 == null) {
                a(37);
            }
            return e2;
        }
        OverrideCompatibilityInfo b4 = OverrideCompatibilityInfo.b("Incompatible suspendability");
        if (b4 == null) {
            a(35);
        }
        return b4;
    }

    public void y(@NotNull og1 og1, @NotNull Collection<? extends CallableMemberDescriptor> collection, @NotNull Collection<? extends CallableMemberDescriptor> collection2, @NotNull ClassDescriptor classDescriptor, @NotNull gn1 gn1) {
        if (og1 == null) {
            a(50);
        }
        if (collection == null) {
            a(51);
        }
        if (collection2 == null) {
            a(52);
        }
        if (classDescriptor == null) {
            a(53);
        }
        if (gn1 == null) {
            a(54);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        for (CallableMemberDescriptor callableMemberDescriptor : collection2) {
            linkedHashSet.removeAll(r(callableMemberDescriptor, collection, classDescriptor, gn1));
        }
        m(classDescriptor, linkedHashSet, gn1);
    }
}
