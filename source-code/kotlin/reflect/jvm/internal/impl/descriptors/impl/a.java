package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.youku.live.dago.liveplayback.widget.pip.PipUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ac2;
import tb.by0;
import tb.d60;
import tb.e6;
import tb.g60;
import tb.g61;
import tb.gg0;
import tb.h60;
import tb.lx1;
import tb.og1;
import tb.w30;
import tb.xo2;

/* compiled from: Taobao */
public abstract class a extends w30 implements FunctionDescriptor {
    private final CallableMemberDescriptor.Kind A;
    @Nullable
    private FunctionDescriptor B;
    protected Map<CallableDescriptor.UserDataKey<?>, Object> C;
    private List<TypeParameterDescriptor> e;
    private List<ValueParameterDescriptor> f;
    private g61 g;
    private ReceiverParameterDescriptor h;
    private ReceiverParameterDescriptor i;
    private Modality j;
    private h60 k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private Collection<? extends FunctionDescriptor> x;
    private volatile Function0<Collection<FunctionDescriptor>> y;
    private final FunctionDescriptor z;

    /* access modifiers changed from: package-private */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0270a implements Function0<Collection<FunctionDescriptor>> {
        final /* synthetic */ TypeSubstitutor a;

        C0270a(TypeSubstitutor typeSubstitutor) {
            this.a = typeSubstitutor;
        }

        /* renamed from: a */
        public Collection<FunctionDescriptor> invoke() {
            ac2 ac2 = new ac2();
            for (FunctionDescriptor functionDescriptor : a.this.getOverriddenDescriptors()) {
                ac2.add(functionDescriptor.substitute(this.a));
            }
            return ac2;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b implements Function0<List<VariableDescriptor>> {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        /* renamed from: a */
        public List<VariableDescriptor> invoke() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    public class c implements FunctionDescriptor.CopyBuilder<FunctionDescriptor> {
        @NotNull
        protected xo2 a;
        @NotNull
        protected DeclarationDescriptor b;
        @NotNull
        protected Modality c;
        @NotNull
        protected h60 d;
        @Nullable
        protected FunctionDescriptor e;
        @NotNull
        protected CallableMemberDescriptor.Kind f;
        @NotNull
        protected List<ValueParameterDescriptor> g;
        @Nullable
        protected ReceiverParameterDescriptor h;
        @Nullable
        protected ReceiverParameterDescriptor i;
        @NotNull
        protected g61 j;
        @Nullable
        protected og1 k;
        protected boolean l;
        protected boolean m;
        protected boolean n;
        protected boolean o;
        private boolean p;
        private List<TypeParameterDescriptor> q;
        private Annotations r;
        private boolean s;
        private Map<CallableDescriptor.UserDataKey<?>, Object> t;
        private Boolean u;
        protected boolean v;
        final /* synthetic */ a w;

        public c(@NotNull a aVar, @NotNull xo2 xo2, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull h60 h60, @NotNull CallableMemberDescriptor.Kind kind, @Nullable List<ValueParameterDescriptor> list, @NotNull ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable g61 g61, og1 og1) {
            if (xo2 == null) {
                a(0);
            }
            if (declarationDescriptor == null) {
                a(1);
            }
            if (modality == null) {
                a(2);
            }
            if (h60 == null) {
                a(3);
            }
            if (kind == null) {
                a(4);
            }
            if (list == null) {
                a(5);
            }
            if (g61 == null) {
                a(6);
            }
            this.w = aVar;
            this.e = null;
            this.i = aVar.i;
            this.l = true;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = aVar.isHiddenToOvercomeSignatureClash();
            this.q = null;
            this.r = null;
            this.s = aVar.isHiddenForResolutionEverywhereBesideSupercalls();
            this.t = new LinkedHashMap();
            this.u = null;
            this.v = false;
            this.a = xo2;
            this.b = declarationDescriptor;
            this.c = modality;
            this.d = h60;
            this.f = kind;
            this.g = list;
            this.h = receiverParameterDescriptor;
            this.j = g61;
            this.k = og1;
        }

        private static /* synthetic */ void a(int i2) {
            String str;
            int i3;
            switch (i2) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i3 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = "owner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "name";
                    break;
                case 18:
                case 20:
                    objArr[0] = PushConstants.PARAMS;
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i2) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i2) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    throw new IllegalStateException(format);
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        @NotNull
        /* renamed from: A */
        public c setValueParameters(@NotNull List<ValueParameterDescriptor> list) {
            if (list == null) {
                a(18);
            }
            this.g = list;
            return this;
        }

        @NotNull
        /* renamed from: B */
        public c setVisibility(@NotNull h60 h60) {
            if (h60 == null) {
                a(11);
            }
            this.d = h60;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @Nullable
        public FunctionDescriptor build() {
            return this.w.g(this);
        }

        @NotNull
        /* renamed from: h */
        public c setAdditionalAnnotations(@NotNull Annotations annotations) {
            if (annotations == null) {
                a(32);
            }
            this.r = annotations;
            return this;
        }

        @NotNull
        /* renamed from: i */
        public c setCopyOverrides(boolean z) {
            this.l = z;
            return this;
        }

        @NotNull
        /* renamed from: j */
        public c setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.i = receiverParameterDescriptor;
            return this;
        }

        @NotNull
        /* renamed from: k */
        public c setDropOriginalInContainingParts() {
            this.o = true;
            return this;
        }

        @NotNull
        /* renamed from: l */
        public c setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.h = receiverParameterDescriptor;
            return this;
        }

        public c m(boolean z) {
            this.u = Boolean.valueOf(z);
            return this;
        }

        @NotNull
        /* renamed from: n */
        public c setHiddenForResolutionEverywhereBesideSupercalls() {
            this.s = true;
            return this;
        }

        @NotNull
        /* renamed from: o */
        public c setHiddenToOvercomeSignatureClash() {
            this.p = true;
            return this;
        }

        @NotNull
        public c p(boolean z) {
            this.v = z;
            return this;
        }

        @NotNull
        /* renamed from: q */
        public c setKind(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                a(13);
            }
            this.f = kind;
            return this;
        }

        @NotNull
        /* renamed from: r */
        public c setModality(@NotNull Modality modality) {
            if (modality == null) {
                a(9);
            }
            this.c = modality;
            return this;
        }

        @NotNull
        /* renamed from: s */
        public c setName(@NotNull og1 og1) {
            if (og1 == null) {
                a(16);
            }
            this.k = og1;
            return this;
        }

        @NotNull
        /* renamed from: t */
        public c setOriginal(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.e = (FunctionDescriptor) callableMemberDescriptor;
            return this;
        }

        @NotNull
        /* renamed from: u */
        public c setOwner(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                a(7);
            }
            this.b = declarationDescriptor;
            return this;
        }

        @NotNull
        /* renamed from: v */
        public c setPreserveSourceElement() {
            this.n = true;
            return this;
        }

        @NotNull
        /* renamed from: w */
        public c setReturnType(@NotNull g61 g61) {
            if (g61 == null) {
                a(22);
            }
            this.j = g61;
            return this;
        }

        @NotNull
        /* renamed from: x */
        public c setSignatureChange() {
            this.m = true;
            return this;
        }

        @NotNull
        /* renamed from: y */
        public c setSubstitution(@NotNull xo2 xo2) {
            if (xo2 == null) {
                a(34);
            }
            this.a = xo2;
            return this;
        }

        @NotNull
        /* renamed from: z */
        public c setTypeParameters(@NotNull List<TypeParameterDescriptor> list) {
            if (list == null) {
                a(20);
            }
            this.q = list;
            return this;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected a(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement) {
        super(declarationDescriptor, annotations, og1, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (og1 == null) {
            a(2);
        }
        if (kind == null) {
            a(3);
        }
        if (sourceElement == null) {
            a(4);
        }
        this.k = g60.UNKNOWN;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = null;
        this.y = null;
        this.B = null;
        this.C = null;
        this.z = functionDescriptor == null ? this : functionDescriptor;
        this.A = kind;
    }

    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i3 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = PipUtils.DAGO_PIP_MODE_CONFIGURATION;
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = by0.ARG_COPY;
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(format);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @NotNull
    private SourceElement h(boolean z2, @Nullable FunctionDescriptor functionDescriptor) {
        SourceElement sourceElement;
        if (z2) {
            if (functionDescriptor == null) {
                functionDescriptor = getOriginal();
            }
            sourceElement = functionDescriptor.getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        if (sourceElement == null) {
            a(25);
        }
        return sourceElement;
    }

    @Nullable
    public static List<ValueParameterDescriptor> i(FunctionDescriptor functionDescriptor, @NotNull List<ValueParameterDescriptor> list, @NotNull TypeSubstitutor typeSubstitutor) {
        if (list == null) {
            a(26);
        }
        if (typeSubstitutor == null) {
            a(27);
        }
        return j(functionDescriptor, list, typeSubstitutor, false, false, null);
    }

    @Nullable
    public static List<ValueParameterDescriptor> j(FunctionDescriptor functionDescriptor, @NotNull List<ValueParameterDescriptor> list, @NotNull TypeSubstitutor typeSubstitutor, boolean z2, boolean z3, @Nullable boolean[] zArr) {
        if (list == null) {
            a(28);
        }
        if (typeSubstitutor == null) {
            a(29);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ValueParameterDescriptor valueParameterDescriptor : list) {
            g61 type = valueParameterDescriptor.getType();
            Variance variance = Variance.IN_VARIANCE;
            g61 q2 = typeSubstitutor.q(type, variance);
            g61 varargElementType = valueParameterDescriptor.getVarargElementType();
            g61 q3 = varargElementType == null ? null : typeSubstitutor.q(varargElementType, variance);
            if (q2 == null) {
                return null;
            }
            if (!((q2 == valueParameterDescriptor.getType() && varargElementType == q3) || zArr == null)) {
                zArr[0] = true;
            }
            arrayList.add(ValueParameterDescriptorImpl.e(functionDescriptor, z2 ? null : valueParameterDescriptor, valueParameterDescriptor.getIndex(), valueParameterDescriptor.getAnnotations(), valueParameterDescriptor.getName(), q2, valueParameterDescriptor.declaresDefaultValue(), valueParameterDescriptor.isCrossinline(), valueParameterDescriptor.isNoinline(), q3, z3 ? valueParameterDescriptor.getSource() : SourceElement.NO_SOURCE, valueParameterDescriptor instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration ? new b(((ValueParameterDescriptorImpl.WithDestructuringDeclaration) valueParameterDescriptor).h()) : null));
        }
        return arrayList;
    }

    private void n() {
        Function0<Collection<FunctionDescriptor>> function0 = this.y;
        if (function0 != null) {
            this.x = function0.invoke();
            this.y = null;
        }
    }

    private void u(boolean z2) {
        this.t = z2;
    }

    private void v(boolean z2) {
        this.s = z2;
    }

    private void x(@Nullable FunctionDescriptor functionDescriptor) {
        this.B = functionDescriptor;
    }

    public void A(@NotNull g61 g61) {
        if (g61 == null) {
            a(10);
        }
        this.g = g61;
    }

    public void B(boolean z2) {
        this.u = z2;
    }

    public void C(boolean z2) {
        this.p = z2;
    }

    public void D(@NotNull h60 h60) {
        if (h60 == null) {
            a(9);
        }
        this.k = h60;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitFunctionDescriptor(this, d);
    }

    @NotNull
    /* renamed from: e */
    public FunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, h60 h60, CallableMemberDescriptor.Kind kind, boolean z2) {
        FunctionDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(h60).setKind(kind).setCopyOverrides(z2).build();
        if (build == null) {
            a(24);
        }
        return build;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract a f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable og1 og1, @NotNull Annotations annotations, @NotNull SourceElement sourceElement);

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Nullable
    public FunctionDescriptor g(@NotNull c cVar) {
        lx1 lx1;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        g61 q2;
        if (cVar == null) {
            a(23);
        }
        boolean[] zArr = new boolean[1];
        Annotations a = cVar.r != null ? e6.a(getAnnotations(), cVar.r) : getAnnotations();
        DeclarationDescriptor declarationDescriptor = cVar.b;
        FunctionDescriptor functionDescriptor = cVar.e;
        a f2 = f(declarationDescriptor, functionDescriptor, cVar.f, cVar.k, a, h(cVar.n, functionDescriptor));
        List<TypeParameterDescriptor> typeParameters = cVar.q == null ? getTypeParameters() : cVar.q;
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor c2 = d60.c(typeParameters, cVar.a, f2, arrayList, zArr);
        if (c2 == null) {
            return null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = cVar.h;
        if (receiverParameterDescriptor2 != null) {
            g61 q3 = c2.q(receiverParameterDescriptor2.getType(), Variance.IN_VARIANCE);
            if (q3 == null) {
                return null;
            }
            lx1 lx12 = new lx1(f2, new gg0(f2, q3, cVar.h.getValue()), cVar.h.getAnnotations());
            zArr[0] = (q3 != cVar.h.getType()) | zArr[0];
            lx1 = lx12;
        } else {
            lx1 = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor3 = cVar.i;
        if (receiverParameterDescriptor3 != 0) {
            ReceiverParameterDescriptor substitute = receiverParameterDescriptor3.substitute(c2);
            if (substitute == null) {
                return null;
            }
            zArr[0] = zArr[0] | (substitute != cVar.i);
            receiverParameterDescriptor = substitute;
        } else {
            receiverParameterDescriptor = null;
        }
        List<ValueParameterDescriptor> j2 = j(f2, cVar.g, c2, cVar.o, cVar.n, zArr);
        if (j2 == null || (q2 = c2.q(cVar.j, Variance.OUT_VARIANCE)) == null) {
            return null;
        }
        zArr[0] = zArr[0] | (q2 != cVar.j);
        if (!zArr[0] && cVar.v) {
            return this;
        }
        f2.l(lx1, receiverParameterDescriptor, arrayList, j2, q2, cVar.c, cVar.d);
        f2.z(this.l);
        f2.w(this.m);
        f2.r(this.n);
        f2.y(this.o);
        f2.C(this.p);
        f2.B(this.u);
        f2.q(this.q);
        f2.p(this.r);
        f2.s(this.v);
        f2.v(cVar.p);
        f2.u(cVar.s);
        f2.t(cVar.u != null ? cVar.u.booleanValue() : this.w);
        if (!cVar.t.isEmpty() || this.C != null) {
            Map<CallableDescriptor.UserDataKey<?>, Object> map = cVar.t;
            Map<CallableDescriptor.UserDataKey<?>, Object> map2 = this.C;
            if (map2 != null) {
                for (Map.Entry<CallableDescriptor.UserDataKey<?>, Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                f2.C = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                f2.C = map;
            }
        }
        if (cVar.m || getInitialSignatureDescriptor() != null) {
            f2.x((getInitialSignatureDescriptor() != null ? getInitialSignatureDescriptor() : this).substitute(c2));
        }
        if (cVar.l && !getOriginal().getOverriddenDescriptors().isEmpty()) {
            if (cVar.a.f()) {
                Function0<Collection<FunctionDescriptor>> function0 = this.y;
                if (function0 != null) {
                    f2.y = function0;
                } else {
                    f2.setOverriddenDescriptors(getOverriddenDescriptors());
                }
            } else {
                f2.y = new C0270a(c2);
            }
        }
        return f2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @Nullable
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.A;
        if (kind == null) {
            a(19);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = this.j;
        if (modality == null) {
            a(13);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @NotNull
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        n();
        Collection<? extends FunctionDescriptor> collection = this.x;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            a(12);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public g61 getReturnType() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        Map<CallableDescriptor.UserDataKey<?>, Object> map = this.C;
        if (map == null) {
            return null;
        }
        return (V) map.get(userDataKey);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.f;
        if (list == null) {
            a(17);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public h60 getVisibility() {
        h60 h60 = this.k;
        if (h60 == null) {
            a(14);
        }
        return h60;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInfix() {
        if (this.m) {
            return true;
        }
        for (FunctionDescriptor functionDescriptor : getOriginal().getOverriddenDescriptors()) {
            if (functionDescriptor.isInfix()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return this.o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isOperator() {
        if (this.l) {
            return true;
        }
        for (FunctionDescriptor functionDescriptor : getOriginal().getOverriddenDescriptors()) {
            if (functionDescriptor.isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return this.p;
    }

    public boolean k() {
        return this.v;
    }

    @NotNull
    public a l(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull List<ValueParameterDescriptor> list2, @Nullable g61 g61, @Nullable Modality modality, @NotNull h60 h60) {
        if (list == null) {
            a(5);
        }
        if (list2 == null) {
            a(6);
        }
        if (h60 == null) {
            a(7);
        }
        this.e = CollectionsKt___CollectionsKt.y0(list);
        this.f = CollectionsKt___CollectionsKt.y0(list2);
        this.g = g61;
        this.j = modality;
        this.k = h60;
        this.h = receiverParameterDescriptor;
        this.i = receiverParameterDescriptor2;
        for (int i2 = 0; i2 < list.size(); i2++) {
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) list.get(i2);
            if (typeParameterDescriptor.getIndex() != i2) {
                throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i2);
            }
        }
        for (int i3 = 0; i3 < list2.size(); i3++) {
            ValueParameterDescriptor valueParameterDescriptor = list2.get(i3);
            if (valueParameterDescriptor.getIndex() != i3 + 0) {
                throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i3);
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public c m(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            a(22);
        }
        return new c(this, typeSubstitutor.j(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getExtensionReceiverParameter(), getReturnType(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        c m2 = m(TypeSubstitutor.EMPTY);
        if (m2 == null) {
            a(21);
        }
        return m2;
    }

    public <V> void o(CallableDescriptor.UserDataKey<V> userDataKey, Object obj) {
        if (this.C == null) {
            this.C = new LinkedHashMap();
        }
        this.C.put(userDataKey, obj);
    }

    public void p(boolean z2) {
        this.r = z2;
    }

    public void q(boolean z2) {
        this.q = z2;
    }

    public void r(boolean z2) {
        this.n = z2;
    }

    public void s(boolean z2) {
        this.v = z2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            a(15);
        }
        this.x = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((FunctionDescriptor) it.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
                this.t = true;
                return;
            }
        }
    }

    public void t(boolean z2) {
        this.w = z2;
    }

    public void w(boolean z2) {
        this.m = z2;
    }

    public void y(boolean z2) {
        this.o = z2;
    }

    public void z(boolean z2) {
        this.l = z2;
    }

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public CallableDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            a(20);
        }
        if (typeSubstitutor.k()) {
            return this;
        }
        return m(typeSubstitutor).setOriginal(getOriginal()).setPreserveSourceElement().p(true).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, tb.w30, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, tb.v30
    @NotNull
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = this.z;
        FunctionDescriptor original = functionDescriptor == this ? this : functionDescriptor.getOriginal();
        if (original == null) {
            a(18);
        }
        return original;
    }
}
