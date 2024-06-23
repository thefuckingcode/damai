package kotlin.reflect.jvm.internal.impl.renderer;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.bridge.WXBridgeManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import kotlin.text.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bp2;
import tb.c6;
import tb.dd2;
import tb.dj0;
import tb.ed2;
import tb.en0;
import tb.es2;
import tb.f60;
import tb.fn0;
import tb.g60;
import tb.g61;
import tb.h60;
import tb.h61;
import tb.ib2;
import tb.jl1;
import tb.k21;
import tb.le0;
import tb.m0;
import tb.me0;
import tb.n51;
import tb.o70;
import tb.og1;
import tb.om;
import tb.rn0;
import tb.sz1;
import tb.sz2;
import tb.tr1;
import tb.ur2;
import tb.w7;
import tb.zr2;

/* compiled from: Taobao */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    @NotNull
    private final DescriptorRendererOptionsImpl a;
    @NotNull
    private final Lazy b = kotlin.b.b(new DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(this));

    /* compiled from: Taobao */
    private final class a implements DeclarationDescriptorVisitor<ur2, StringBuilder> {
        final /* synthetic */ DescriptorRendererImpl a;

        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public /* synthetic */ class C0283a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PropertyAccessorRenderingPolicy.values().length];
                iArr[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                iArr[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                iArr[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(DescriptorRendererImpl descriptorRendererImpl) {
            k21.i(descriptorRendererImpl, "this$0");
            this.a = descriptorRendererImpl;
        }

        private final void g(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb, String str) {
            int i = C0283a.$EnumSwitchMapping$0[this.a.W().ordinal()];
            if (i == 1) {
                this.a.C0(propertyAccessorDescriptor, sb);
                sb.append(k21.r(str, " for "));
                DescriptorRendererImpl descriptorRendererImpl = this.a;
                PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
                k21.h(correspondingProperty, "descriptor.correspondingProperty");
                descriptorRendererImpl.j1(correspondingProperty, sb);
            } else if (i == 2) {
                c(propertyAccessorDescriptor, sb);
            }
        }

        public void a(@NotNull ClassDescriptor classDescriptor, @NotNull StringBuilder sb) {
            k21.i(classDescriptor, "descriptor");
            k21.i(sb, "builder");
            this.a.I0(classDescriptor, sb);
        }

        public void b(@NotNull ConstructorDescriptor constructorDescriptor, @NotNull StringBuilder sb) {
            k21.i(constructorDescriptor, "constructorDescriptor");
            k21.i(sb, "builder");
            this.a.N0(constructorDescriptor, sb);
        }

        public void c(@NotNull FunctionDescriptor functionDescriptor, @NotNull StringBuilder sb) {
            k21.i(functionDescriptor, "descriptor");
            k21.i(sb, "builder");
            this.a.R0(functionDescriptor, sb);
        }

        public void d(@NotNull ModuleDescriptor moduleDescriptor, @NotNull StringBuilder sb) {
            k21.i(moduleDescriptor, "descriptor");
            k21.i(sb, "builder");
            this.a.b1(moduleDescriptor, sb, true);
        }

        public void e(@NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull StringBuilder sb) {
            k21.i(packageFragmentDescriptor, "descriptor");
            k21.i(sb, "builder");
            this.a.f1(packageFragmentDescriptor, sb);
        }

        public void f(@NotNull PackageViewDescriptor packageViewDescriptor, @NotNull StringBuilder sb) {
            k21.i(packageViewDescriptor, "descriptor");
            k21.i(sb, "builder");
            this.a.h1(packageViewDescriptor, sb);
        }

        public void h(@NotNull PropertyDescriptor propertyDescriptor, @NotNull StringBuilder sb) {
            k21.i(propertyDescriptor, "descriptor");
            k21.i(sb, "builder");
            this.a.j1(propertyDescriptor, sb);
        }

        public void i(@NotNull PropertyGetterDescriptor propertyGetterDescriptor, @NotNull StringBuilder sb) {
            k21.i(propertyGetterDescriptor, "descriptor");
            k21.i(sb, "builder");
            g(propertyGetterDescriptor, sb, "getter");
        }

        public void j(@NotNull PropertySetterDescriptor propertySetterDescriptor, @NotNull StringBuilder sb) {
            k21.i(propertySetterDescriptor, "descriptor");
            k21.i(sb, "builder");
            g(propertySetterDescriptor, sb, "setter");
        }

        public void k(@NotNull ReceiverParameterDescriptor receiverParameterDescriptor, @NotNull StringBuilder sb) {
            k21.i(receiverParameterDescriptor, "descriptor");
            k21.i(sb, "builder");
            sb.append(receiverParameterDescriptor.getName());
        }

        public void l(@NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull StringBuilder sb) {
            k21.i(typeAliasDescriptor, "descriptor");
            k21.i(sb, "builder");
            this.a.r1(typeAliasDescriptor, sb);
        }

        public void m(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull StringBuilder sb) {
            k21.i(typeParameterDescriptor, "descriptor");
            k21.i(sb, "builder");
            this.a.w1(typeParameterDescriptor, sb, true);
        }

        public void n(@NotNull ValueParameterDescriptor valueParameterDescriptor, @NotNull StringBuilder sb) {
            k21.i(valueParameterDescriptor, "descriptor");
            k21.i(sb, "builder");
            this.a.B1(valueParameterDescriptor, true, sb, true);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitClassDescriptor(ClassDescriptor classDescriptor, StringBuilder sb) {
            a(classDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
            b(constructorDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitFunctionDescriptor(FunctionDescriptor functionDescriptor, StringBuilder sb) {
            c(functionDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitModuleDeclaration(ModuleDescriptor moduleDescriptor, StringBuilder sb) {
            d(moduleDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
            e(packageFragmentDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
            f(packageViewDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
            h(propertyDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb) {
            i(propertyGetterDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb) {
            j(propertySetterDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb) {
            k(receiverParameterDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
            l(typeAliasDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb) {
            m(typeParameterDescriptor, sb);
            return ur2.INSTANCE;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, java.lang.Object] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ ur2 visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb) {
            n(valueParameterDescriptor, sb);
            return ur2.INSTANCE;
        }
    }

    /* compiled from: Taobao */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            iArr[RenderingFormat.PLAIN.ordinal()] = 1;
            iArr[RenderingFormat.HTML.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ParameterNameRenderingPolicy.values().length];
            iArr2[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            iArr2[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            iArr2[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DescriptorRendererImpl(@NotNull DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        k21.i(descriptorRendererOptionsImpl, WXBridgeManager.OPTIONS);
        this.a = descriptorRendererOptionsImpl;
        descriptorRendererOptionsImpl.U();
    }

    private final boolean A0(CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.getOverriddenDescriptors().isEmpty();
    }

    static /* synthetic */ void A1(DescriptorRendererImpl descriptorRendererImpl, VariableDescriptor variableDescriptor, StringBuilder sb, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        descriptorRendererImpl.z1(variableDescriptor, sb, z);
    }

    private final void B0(StringBuilder sb, m0 m0Var) {
        RenderingFormat k0 = k0();
        RenderingFormat renderingFormat = RenderingFormat.HTML;
        if (k0 == renderingFormat) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        d1(sb, m0Var.getExpandedType());
        sb.append(" */");
        if (k0() == renderingFormat) {
            sb.append("</i></font>");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0095, code lost:
        if ((getDebugMode() ? r10.declaresDefaultValue() : kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.a(r10)) != false) goto L_0x0099;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    private final void B1(ValueParameterDescriptor valueParameterDescriptor, boolean z, StringBuilder sb, boolean z2) {
        boolean z3;
        if (z2) {
            sb.append(U0("value-parameter"));
            sb.append(" ");
        }
        if (p0()) {
            sb.append("/*");
            sb.append(valueParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        G0(this, sb, valueParameterDescriptor, null, 2, null);
        a1(sb, valueParameterDescriptor.isCrossinline(), "crossinline");
        a1(sb, valueParameterDescriptor.isNoinline(), "noinline");
        boolean z4 = true;
        if (e0()) {
            CallableDescriptor containingDeclaration = valueParameterDescriptor.getContainingDeclaration();
            Boolean bool = null;
            ClassConstructorDescriptor classConstructorDescriptor = containingDeclaration instanceof ClassConstructorDescriptor ? (ClassConstructorDescriptor) containingDeclaration : null;
            if (classConstructorDescriptor != null) {
                bool = Boolean.valueOf(classConstructorDescriptor.isPrimary());
            }
            if (k21.d(bool, Boolean.TRUE)) {
                z3 = true;
                if (z3) {
                    a1(sb, A(), "actual");
                }
                D1(valueParameterDescriptor, z, sb, z2, z3);
                if (G() != null) {
                }
                z4 = false;
                if (!z4) {
                    Function1<ValueParameterDescriptor, String> G = G();
                    k21.f(G);
                    sb.append(k21.r(" = ", G.invoke(valueParameterDescriptor)));
                    return;
                }
                return;
            }
        }
        z3 = false;
        if (z3) {
        }
        D1(valueParameterDescriptor, z, sb, z2, z3);
        if (G() != null) {
        }
        z4 = false;
        if (!z4) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void C0(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb) {
        W0(propertyAccessorDescriptor, sb);
    }

    private final void C1(Collection<? extends ValueParameterDescriptor> collection, boolean z, StringBuilder sb) {
        boolean I1 = I1(z);
        int size = collection.size();
        o0().appendBeforeValueParameters(size, sb);
        int i = 0;
        for (ValueParameterDescriptor valueParameterDescriptor : collection) {
            o0().appendBeforeValueParameter(valueParameterDescriptor, i, size, sb);
            B1(valueParameterDescriptor, I1, sb, false);
            o0().appendAfterValueParameter(valueParameterDescriptor, i, size, sb);
            i++;
        }
        o0().appendAfterValueParameters(size, sb);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    private final void D0(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (functionDescriptor.isOperator()) {
            Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
            k21.h(overriddenDescriptors, "functionDescriptor.overriddenDescriptors");
            if (!overriddenDescriptors.isEmpty()) {
                Iterator<T> it = overriddenDescriptors.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().isOperator()) {
                            z3 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z3 || B()) {
                    z = true;
                    if (functionDescriptor.isInfix()) {
                        Collection<? extends FunctionDescriptor> overriddenDescriptors2 = functionDescriptor.getOverriddenDescriptors();
                        k21.h(overriddenDescriptors2, "functionDescriptor.overriddenDescriptors");
                        if (!overriddenDescriptors2.isEmpty()) {
                            Iterator<T> it2 = overriddenDescriptors2.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (it2.next().isInfix()) {
                                        z2 = false;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        z2 = true;
                        if (z2 || B()) {
                            z4 = true;
                        }
                    }
                    a1(sb, functionDescriptor.isTailrec(), "tailrec");
                    q1(functionDescriptor, sb);
                    a1(sb, functionDescriptor.isInline(), "inline");
                    a1(sb, z4, "infix");
                    a1(sb, z, "operator");
                }
            }
            z3 = true;
            z = true;
            if (functionDescriptor.isInfix()) {
            }
            a1(sb, functionDescriptor.isTailrec(), "tailrec");
            q1(functionDescriptor, sb);
            a1(sb, functionDescriptor.isInline(), "inline");
            a1(sb, z4, "infix");
            a1(sb, z, "operator");
        }
        z = false;
        if (functionDescriptor.isInfix()) {
        }
        a1(sb, functionDescriptor.isTailrec(), "tailrec");
        q1(functionDescriptor, sb);
        a1(sb, functionDescriptor.isInline(), "inline");
        a1(sb, z4, "infix");
        a1(sb, z, "operator");
    }

    private final void D1(VariableDescriptor variableDescriptor, boolean z, StringBuilder sb, boolean z2, boolean z3) {
        g61 type = variableDescriptor.getType();
        k21.h(type, "variable.type");
        g61 g61 = null;
        ValueParameterDescriptor valueParameterDescriptor = variableDescriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) variableDescriptor : null;
        if (valueParameterDescriptor != null) {
            g61 = valueParameterDescriptor.getVarargElementType();
        }
        g61 g612 = g61 == null ? type : g61;
        a1(sb, g61 != null, "vararg");
        if (z3 || (z2 && !j0())) {
            z1(variableDescriptor, sb, z3);
        }
        if (z) {
            b1(variableDescriptor, sb, z2);
            sb.append(": ");
        }
        sb.append(g(g612));
        T0(variableDescriptor, sb);
        if (p0() && g61 != null) {
            sb.append(" /*");
            sb.append(g(type));
            sb.append("*/");
        }
    }

    private final List<String> E0(AnnotationDescriptor annotationDescriptor) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        Map<og1, om<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
        List list = null;
        ClassDescriptor f = b0() ? DescriptorUtilsKt.f(annotationDescriptor) : null;
        List<ValueParameterDescriptor> valueParameters = (f == null || (unsubstitutedPrimaryConstructor = f.getUnsubstitutedPrimaryConstructor()) == null) ? null : unsubstitutedPrimaryConstructor.getValueParameters();
        if (valueParameters != null) {
            ArrayList<ValueParameterDescriptor> arrayList = new ArrayList();
            for (T t : valueParameters) {
                if (t.declaresDefaultValue()) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(n.q(arrayList, 10));
            for (ValueParameterDescriptor valueParameterDescriptor : arrayList) {
                arrayList2.add(valueParameterDescriptor.getName());
            }
            list = arrayList2;
        }
        if (list == null) {
            list = m.g();
        }
        ArrayList<og1> arrayList3 = new ArrayList();
        for (Object obj : list) {
            og1 og1 = (og1) obj;
            k21.h(og1, AdvanceSetting.NETWORK_TYPE);
            if (!allValueArguments.containsKey(og1)) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = new ArrayList(n.q(arrayList3, 10));
        for (og1 og12 : arrayList3) {
            arrayList4.add(k21.r(og12.b(), " = ..."));
        }
        Set<Map.Entry<og1, om<?>>> entrySet = allValueArguments.entrySet();
        ArrayList arrayList5 = new ArrayList(n.q(entrySet, 10));
        for (T t2 : entrySet) {
            og1 og13 = (og1) t2.getKey();
            om<?> omVar = (om) t2.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(og13.b());
            sb.append(" = ");
            sb.append(!list.contains(og13) ? M0(omVar) : "...");
            arrayList5.add(sb.toString());
        }
        return CollectionsKt___CollectionsKt.r0(CollectionsKt___CollectionsKt.k0(arrayList4, arrayList5));
    }

    private final boolean E1(h60 h60, StringBuilder sb) {
        if (!P().contains(DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        if (Q()) {
            h60 = h60.f();
        }
        if (!d0() && k21.d(h60, g60.DEFAULT_VISIBILITY)) {
            return false;
        }
        sb.append(U0(h60.c()));
        sb.append(" ");
        return true;
    }

    private final void F0(StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget) {
        if (P().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Set<en0> excludedTypeAnnotationClasses = annotated instanceof g61 ? getExcludedTypeAnnotationClasses() : I();
            Function1<AnnotationDescriptor, Boolean> C = C();
            for (AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
                if (!(CollectionsKt___CollectionsKt.J(excludedTypeAnnotationClasses, annotationDescriptor.getFqName())) && !y0(annotationDescriptor)) {
                    if (C == null || C.invoke(annotationDescriptor).booleanValue()) {
                        sb.append(b(annotationDescriptor, annotationUseSiteTarget));
                        if (H()) {
                            sb.append('\n');
                            k21.h(sb, "append('\\n')");
                        } else {
                            sb.append(" ");
                        }
                    }
                }
            }
        }
    }

    private final void F1(List<? extends TypeParameterDescriptor> list, StringBuilder sb) {
        if (!u0()) {
            ArrayList arrayList = new ArrayList(0);
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                List<g61> upperBounds = typeParameterDescriptor.getUpperBounds();
                k21.h(upperBounds, "typeParameter.upperBounds");
                for (g61 g61 : CollectionsKt___CollectionsKt.L(upperBounds, 1)) {
                    StringBuilder sb2 = new StringBuilder();
                    og1 name = typeParameterDescriptor.getName();
                    k21.h(name, "typeParameter.name");
                    sb2.append(f(name, false));
                    sb2.append(" : ");
                    k21.h(g61, AdvanceSetting.NETWORK_TYPE);
                    sb2.append(g(g61));
                    arrayList.add(sb2.toString());
                }
            }
            if (!arrayList.isEmpty()) {
                sb.append(" ");
                sb.append(U0("where"));
                sb.append(" ");
                Appendable unused = CollectionsKt___CollectionsKt.X(arrayList, sb, AVFSCacheConstants.COMMA_SEP, null, null, 0, null, null, 124, null);
            }
        }
    }

    static /* synthetic */ void G0(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget, int i, Object obj) {
        if ((i & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.F0(sb, annotated, annotationUseSiteTarget);
    }

    private final String G1(String str, String str2, String str3, String str4, String str5) {
        if ((o.L(str, str2, false, 2, null)) && (o.L(str3, str4, false, 2, null))) {
            int length = str2.length();
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(length);
            k21.h(substring, "(this as java.lang.String).substring(startIndex)");
            int length2 = str4.length();
            Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
            String substring2 = str3.substring(length2);
            k21.h(substring2, "(this as java.lang.String).substring(startIndex)");
            String r = k21.r(str5, substring);
            if (k21.d(substring, substring2)) {
                return r;
            }
            if (y(substring, substring2)) {
                return k21.r(r, jl1.AND_NOT);
            }
        }
        return null;
    }

    private final void H0(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        k21.h(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        k21.h(parameters, "classifier.typeConstructor.parameters");
        if (p0() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            x1(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    private final boolean H1(g61 g61) {
        boolean z;
        if (!rn0.m(g61)) {
            return false;
        }
        List<TypeProjection> b2 = g61.b();
        if (!(b2 instanceof Collection) || !b2.isEmpty()) {
            Iterator<T> it = b2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().isStarProjection()) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                return true;
            }
            return false;
        }
        z = true;
        if (!z) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void I0(ClassDescriptor classDescriptor, StringBuilder sb) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        boolean z = classDescriptor.getKind() == ClassKind.ENUM_ENTRY;
        if (!j0()) {
            G0(this, sb, classDescriptor, null, 2, null);
            if (!z) {
                h60 visibility = classDescriptor.getVisibility();
                k21.h(visibility, "klass.visibility");
                E1(visibility, sb);
            }
            if (!(classDescriptor.getKind() == ClassKind.INTERFACE && classDescriptor.getModality() == Modality.ABSTRACT) && (!classDescriptor.getKind().isSingleton() || classDescriptor.getModality() != Modality.FINAL)) {
                Modality modality = classDescriptor.getModality();
                k21.h(modality, "klass.modality");
                Y0(modality, sb, x0(classDescriptor));
            }
            W0(classDescriptor, sb);
            a1(sb, P().contains(DescriptorRendererModifier.INNER) && classDescriptor.isInner(), "inner");
            a1(sb, P().contains(DescriptorRendererModifier.DATA) && classDescriptor.isData(), "data");
            a1(sb, P().contains(DescriptorRendererModifier.INLINE) && classDescriptor.isInline(), "inline");
            a1(sb, P().contains(DescriptorRendererModifier.VALUE) && classDescriptor.isValue(), "value");
            a1(sb, P().contains(DescriptorRendererModifier.FUN) && classDescriptor.isFun(), "fun");
            J0(classDescriptor, sb);
        }
        if (!f60.x(classDescriptor)) {
            if (!j0()) {
                o1(sb);
            }
            b1(classDescriptor, sb, true);
        } else {
            L0(classDescriptor, sb);
        }
        if (!z) {
            List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
            k21.h(declaredTypeParameters, "klass.declaredTypeParameters");
            y1(declaredTypeParameters, sb, false);
            H0(classDescriptor, sb);
            if (!classDescriptor.getKind().isSingleton() && E() && (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) != null) {
                sb.append(" ");
                G0(this, sb, unsubstitutedPrimaryConstructor, null, 2, null);
                h60 visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
                k21.h(visibility2, "primaryConstructor.visibility");
                E1(visibility2, sb);
                sb.append(U0("constructor"));
                List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
                k21.h(valueParameters, "primaryConstructor.valueParameters");
                C1(valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
            }
            p1(classDescriptor, sb);
            F1(declaredTypeParameters, sb);
        }
    }

    private final boolean I1(boolean z) {
        int i = b.$EnumSwitchMapping$1[T().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            } else if (!z) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    private final DescriptorRendererImpl J() {
        return (DescriptorRendererImpl) this.b.getValue();
    }

    private final void J0(ClassDescriptor classDescriptor, StringBuilder sb) {
        sb.append(U0(DescriptorRenderer.Companion.a(classDescriptor)));
    }

    private final void L0(DeclarationDescriptor declarationDescriptor, StringBuilder sb) {
        if (Y()) {
            if (j0()) {
                sb.append("companion object");
            }
            o1(sb);
            DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            if (containingDeclaration != null) {
                sb.append("of ");
                og1 name = containingDeclaration.getName();
                k21.h(name, "containingDeclaration.name");
                sb.append(f(name, false));
            }
        }
        if (p0() || !k21.d(declarationDescriptor.getName(), dd2.DEFAULT_NAME_FOR_COMPANION_OBJECT)) {
            if (!j0()) {
                o1(sb);
            }
            og1 name2 = declarationDescriptor.getName();
            k21.h(name2, "descriptor.name");
            sb.append(f(name2, true));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final String M0(om<?> omVar) {
        if (omVar instanceof w7) {
            return CollectionsKt___CollectionsKt.Z((Iterable) ((w7) omVar).b(), AVFSCacheConstants.COMMA_SEP, jl1.BLOCK_START_STR, "}", 0, null, new DescriptorRendererImpl$renderConstant$1(this), 24, null);
        }
        if (omVar instanceof c6) {
            return StringsKt__StringsKt.u0(DescriptorRenderer.c(this, (AnnotationDescriptor) ((c6) omVar).b(), null, 2, null), o70.DINAMIC_PREFIX_AT);
        }
        if (!(omVar instanceof n51)) {
            return omVar.toString();
        }
        n51.b bVar = (n51.b) ((n51) omVar).b();
        if (bVar instanceof n51.b.a) {
            return ((n51.b.a) bVar).a() + "::class";
        } else if (bVar instanceof n51.b.C0307b) {
            n51.b.C0307b bVar2 = (n51.b.C0307b) bVar;
            String b2 = bVar2.b().b().b();
            k21.h(b2, "classValue.classId.asSingleFqName().asString()");
            for (int i = 0; i < bVar2.a(); i++) {
                b2 = "kotlin.Array<" + b2 + '>';
            }
            return k21.r(b2, "::class");
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    private final void N0(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
        boolean z;
        boolean z2;
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        ArrayList arrayList;
        G0(this, sb, constructorDescriptor, null, 2, null);
        if (this.a.C() || constructorDescriptor.getConstructedClass().getModality() != Modality.SEALED) {
            h60 visibility = constructorDescriptor.getVisibility();
            k21.h(visibility, "constructor.visibility");
            if (E1(visibility, sb)) {
                z = true;
                V0(constructorDescriptor, sb);
                z2 = !a0() || !constructorDescriptor.isPrimary() || z;
                if (z2) {
                    sb.append(U0("constructor"));
                }
                ClassifierDescriptorWithTypeParameters containingDeclaration = constructorDescriptor.getContainingDeclaration();
                k21.h(containingDeclaration, "constructor.containingDeclaration");
                if (h0()) {
                    if (z2) {
                        sb.append(" ");
                    }
                    b1(containingDeclaration, sb, true);
                    List<TypeParameterDescriptor> typeParameters = constructorDescriptor.getTypeParameters();
                    k21.h(typeParameters, "constructor.typeParameters");
                    y1(typeParameters, sb, false);
                }
                List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
                k21.h(valueParameters, "constructor.valueParameters");
                C1(valueParameters, constructorDescriptor.hasSynthesizedParameterNames(), sb);
                if (Z() && !constructorDescriptor.isPrimary() && (containingDeclaration instanceof ClassDescriptor) && (unsubstitutedPrimaryConstructor = ((ClassDescriptor) containingDeclaration).getUnsubstitutedPrimaryConstructor()) != null) {
                    List<ValueParameterDescriptor> valueParameters2 = unsubstitutedPrimaryConstructor.getValueParameters();
                    k21.h(valueParameters2, "primaryConstructor.valueParameters");
                    arrayList = new ArrayList();
                    for (T t : valueParameters2) {
                        T t2 = t;
                        if (!t2.declaresDefaultValue() && t2.getVarargElementType() == null) {
                            arrayList.add(t);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        sb.append(" : ");
                        sb.append(U0("this"));
                        sb.append(CollectionsKt___CollectionsKt.Z(arrayList, AVFSCacheConstants.COMMA_SEP, jl1.BRACKET_START_STR, jl1.BRACKET_END_STR, 0, null, DescriptorRendererImpl$renderConstructor$1.INSTANCE, 24, null));
                    }
                }
                if (!h0()) {
                    List<TypeParameterDescriptor> typeParameters2 = constructorDescriptor.getTypeParameters();
                    k21.h(typeParameters2, "constructor.typeParameters");
                    F1(typeParameters2, sb);
                    return;
                }
                return;
            }
        }
        z = false;
        V0(constructorDescriptor, sb);
        if (!a0()) {
        }
        if (z2) {
        }
        ClassifierDescriptorWithTypeParameters containingDeclaration2 = constructorDescriptor.getContainingDeclaration();
        k21.h(containingDeclaration2, "constructor.containingDeclaration");
        if (h0()) {
        }
        List<ValueParameterDescriptor> valueParameters3 = constructorDescriptor.getValueParameters();
        k21.h(valueParameters3, "constructor.valueParameters");
        C1(valueParameters3, constructorDescriptor.hasSynthesizedParameterNames(), sb);
        List<ValueParameterDescriptor> valueParameters22 = unsubstitutedPrimaryConstructor.getValueParameters();
        k21.h(valueParameters22, "primaryConstructor.valueParameters");
        arrayList = new ArrayList();
        while (r0.hasNext()) {
        }
        if (!arrayList.isEmpty()) {
        }
        if (!h0()) {
        }
    }

    private final void O0(StringBuilder sb, g61 g61) {
        G0(this, sb, g61, null, 2, null);
        if (h61.a(g61)) {
            if ((g61 instanceof zr2) && V()) {
                sb.append(((zr2) g61).l());
            } else if (!(g61 instanceof le0) || O()) {
                sb.append(g61.c().toString());
            } else {
                sb.append(((le0) g61).l());
            }
            sb.append(s1(g61.b()));
        } else {
            v1(this, sb, g61, null, 2, null);
        }
        if (g61.d()) {
            sb.append("?");
        }
        if (ed2.c(g61)) {
            sb.append("!!");
        }
    }

    private final String P0(String str) {
        int i = b.$EnumSwitchMapping$0[k0().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i == 2) {
            return "<font color=red><b>" + str + "</b></font>";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String Q0(List<og1> list) {
        return z(sz1.c(list));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void R0(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        if (!j0()) {
            if (!i0()) {
                G0(this, sb, functionDescriptor, null, 2, null);
                h60 visibility = functionDescriptor.getVisibility();
                k21.h(visibility, "function.visibility");
                E1(visibility, sb);
                Z0(functionDescriptor, sb);
                if (K()) {
                    W0(functionDescriptor, sb);
                }
                e1(functionDescriptor, sb);
                if (K()) {
                    D0(functionDescriptor, sb);
                } else {
                    q1(functionDescriptor, sb);
                }
                V0(functionDescriptor, sb);
                if (p0()) {
                    if (functionDescriptor.isHiddenToOvercomeSignatureClash()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(U0("fun"));
            sb.append(" ");
            List<TypeParameterDescriptor> typeParameters = functionDescriptor.getTypeParameters();
            k21.h(typeParameters, "function.typeParameters");
            y1(typeParameters, sb, true);
            l1(functionDescriptor, sb);
        }
        b1(functionDescriptor, sb, true);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        k21.h(valueParameters, "function.valueParameters");
        C1(valueParameters, functionDescriptor.hasSynthesizedParameterNames(), sb);
        m1(functionDescriptor, sb);
        g61 returnType = functionDescriptor.getReturnType();
        if (!s0() && (n0() || returnType == null || !kotlin.reflect.jvm.internal.impl.builtins.b.J0(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : g(returnType));
        }
        List<TypeParameterDescriptor> typeParameters2 = functionDescriptor.getTypeParameters();
        k21.h(typeParameters2, "function.typeParameters");
        F1(typeParameters2, sb);
    }

    private final void S0(StringBuilder sb, g61 g61) {
        og1 og1;
        int length = sb.length();
        G0(J(), sb, g61, null, 2, null);
        boolean z = true;
        boolean z2 = sb.length() != length;
        boolean o = rn0.o(g61);
        boolean d = g61.d();
        g61 h = rn0.h(g61);
        boolean z3 = d || (z2 && h != null);
        if (z3) {
            if (o) {
                sb.insert(length, '(');
            } else {
                if (z2) {
                    char unused = q.V0(sb);
                    if (sb.charAt(StringsKt__StringsKt.Z(sb) - 1) != ')') {
                        sb.insert(StringsKt__StringsKt.Z(sb), "()");
                    }
                }
                sb.append(jl1.BRACKET_START_STR);
            }
        }
        a1(sb, o, "suspend");
        if (h != null) {
            if ((!H1(h) || h.d()) && !w0(h)) {
                z = false;
            }
            if (z) {
                sb.append(jl1.BRACKET_START_STR);
            }
            c1(sb, h);
            if (z) {
                sb.append(jl1.BRACKET_END_STR);
            }
            sb.append(".");
        }
        sb.append(jl1.BRACKET_START_STR);
        int i = 0;
        for (TypeProjection typeProjection : rn0.j(g61)) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            if (U()) {
                g61 type = typeProjection.getType();
                k21.h(type, "typeProjection.type");
                og1 = rn0.c(type);
            } else {
                og1 = null;
            }
            if (og1 != null) {
                sb.append(f(og1, false));
                sb.append(": ");
            }
            sb.append(h(typeProjection));
            i = i2;
        }
        sb.append(") ");
        sb.append(x());
        sb.append(" ");
        c1(sb, rn0.i(g61));
        if (z3) {
            sb.append(jl1.BRACKET_END_STR);
        }
        if (d) {
            sb.append("?");
        }
    }

    private final void T0(VariableDescriptor variableDescriptor, StringBuilder sb) {
        om<?> compileTimeInitializer;
        if (N() && (compileTimeInitializer = variableDescriptor.getCompileTimeInitializer()) != null) {
            sb.append(" = ");
            sb.append(z(M0(compileTimeInitializer)));
        }
    }

    private final String U0(String str) {
        int i = b.$EnumSwitchMapping$0[k0().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else if (D()) {
            return str;
        } else {
            return "<b>" + str + "</b>";
        }
    }

    private final void V0(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (P().contains(DescriptorRendererModifier.MEMBER_KIND) && p0() && callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb.append("/*");
            String name = callableMemberDescriptor.getKind().name();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase();
            k21.h(lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append("*/ ");
        }
    }

    private final void W0(MemberDescriptor memberDescriptor, StringBuilder sb) {
        a1(sb, memberDescriptor.isExternal(), "external");
        boolean z = true;
        a1(sb, P().contains(DescriptorRendererModifier.EXPECT) && memberDescriptor.isExpect(), "expect");
        if (!P().contains(DescriptorRendererModifier.ACTUAL) || !memberDescriptor.isActual()) {
            z = false;
        }
        a1(sb, z, "actual");
    }

    private final void Y0(Modality modality, StringBuilder sb, Modality modality2) {
        if (c0() || modality != modality2) {
            boolean contains = P().contains(DescriptorRendererModifier.MODALITY);
            String name = modality.name();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase();
            k21.h(lowerCase, "(this as java.lang.String).toLowerCase()");
            a1(sb, contains, lowerCase);
        }
    }

    private final void Z0(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (f60.J(callableMemberDescriptor) && callableMemberDescriptor.getModality() == Modality.FINAL) {
            return;
        }
        if (S() != OverrideRenderingPolicy.RENDER_OVERRIDE || callableMemberDescriptor.getModality() != Modality.OPEN || !A0(callableMemberDescriptor)) {
            Modality modality = callableMemberDescriptor.getModality();
            k21.h(modality, "callable.modality");
            Y0(modality, sb, x0(callableMemberDescriptor));
        }
    }

    private final void a1(StringBuilder sb, boolean z, String str) {
        if (z) {
            sb.append(U0(str));
            sb.append(" ");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void b1(DeclarationDescriptor declarationDescriptor, StringBuilder sb, boolean z) {
        og1 name = declarationDescriptor.getName();
        k21.h(name, "descriptor.name");
        sb.append(f(name, z));
    }

    private final void c1(StringBuilder sb, g61 g61) {
        es2 f = g61.f();
        m0 m0Var = f instanceof m0 ? (m0) f : null;
        if (m0Var == null) {
            d1(sb, g61);
        } else if (f0()) {
            d1(sb, m0Var.getExpandedType());
        } else {
            d1(sb, m0Var.o());
            if (g0()) {
                B0(sb, m0Var);
            }
        }
    }

    private final void d1(StringBuilder sb, g61 g61) {
        if (!(g61 instanceof sz2) || !getDebugMode() || ((sz2) g61).h()) {
            es2 f = g61.f();
            if (f instanceof dj0) {
                sb.append(((dj0) f).m(this, this));
            } else if (f instanceof ib2) {
                n1(sb, (ib2) f);
            }
        } else {
            sb.append("<Not computed yet>");
        }
    }

    private final void e1(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (P().contains(DescriptorRendererModifier.OVERRIDE) && A0(callableMemberDescriptor) && S() != OverrideRenderingPolicy.RENDER_OPEN) {
            a1(sb, true, "override");
            if (p0()) {
                sb.append("/*");
                sb.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                sb.append("*/ ");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void f1(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
        g1(packageFragmentDescriptor.getFqName(), "package-fragment", sb);
        if (getDebugMode()) {
            sb.append(" in ");
            b1(packageFragmentDescriptor.getContainingDeclaration(), sb, false);
        }
    }

    private final void g1(en0 en0, String str, StringBuilder sb) {
        sb.append(U0(str));
        fn0 j = en0.j();
        k21.h(j, "fqName.toUnsafe()");
        String e = e(j);
        if (e.length() > 0) {
            sb.append(" ");
            sb.append(e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void h1(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
        g1(packageViewDescriptor.getFqName(), "package", sb);
        if (getDebugMode()) {
            sb.append(" in context of ");
            b1(packageViewDescriptor.getModule(), sb, false);
        }
    }

    private final void i1(StringBuilder sb, tr1 tr1) {
        StringBuilder sb2;
        tr1 c = tr1.c();
        if (c == null) {
            sb2 = null;
        } else {
            i1(sb, c);
            sb.append('.');
            og1 name = tr1.b().getName();
            k21.h(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(f(name, false));
            sb2 = sb;
        }
        if (sb2 == null) {
            TypeConstructor typeConstructor = tr1.b().getTypeConstructor();
            k21.h(typeConstructor, "possiblyInnerType.classifierDescriptor.typeConstructor");
            sb.append(t1(typeConstructor));
        }
        sb.append(s1(tr1.a()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void j1(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (!j0()) {
            if (!i0()) {
                k1(propertyDescriptor, sb);
                h60 visibility = propertyDescriptor.getVisibility();
                k21.h(visibility, "property.visibility");
                E1(visibility, sb);
                boolean z = false;
                a1(sb, P().contains(DescriptorRendererModifier.CONST) && propertyDescriptor.isConst(), o70.CONSTANT_PREFIX);
                W0(propertyDescriptor, sb);
                Z0(propertyDescriptor, sb);
                e1(propertyDescriptor, sb);
                if (P().contains(DescriptorRendererModifier.LATEINIT) && propertyDescriptor.isLateInit()) {
                    z = true;
                }
                a1(sb, z, "lateinit");
                V0(propertyDescriptor, sb);
            }
            A1(this, propertyDescriptor, sb, false, 4, null);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            k21.h(typeParameters, "property.typeParameters");
            y1(typeParameters, sb, true);
            l1(propertyDescriptor, sb);
        }
        b1(propertyDescriptor, sb, true);
        sb.append(": ");
        g61 type = propertyDescriptor.getType();
        k21.h(type, "property.type");
        sb.append(g(type));
        m1(propertyDescriptor, sb);
        T0(propertyDescriptor, sb);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        k21.h(typeParameters2, "property.typeParameters");
        F1(typeParameters2, sb);
    }

    private final void k1(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (P().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            G0(this, sb, propertyDescriptor, null, 2, null);
            FieldDescriptor backingField = propertyDescriptor.getBackingField();
            if (backingField != null) {
                F0(sb, backingField, AnnotationUseSiteTarget.FIELD);
            }
            FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
            if (delegateField != null) {
                F0(sb, delegateField, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (W() == PropertyAccessorRenderingPolicy.NONE) {
                PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
                if (getter != null) {
                    F0(sb, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                }
                PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                if (setter != null) {
                    F0(sb, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                    List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                    k21.h(valueParameters, "setter.valueParameters");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) k.o0(valueParameters);
                    k21.h(valueParameterDescriptor, AdvanceSetting.NETWORK_TYPE);
                    F0(sb, valueParameterDescriptor, AnnotationUseSiteTarget.SETTER_PARAMETER);
                }
            }
        }
    }

    private final void l1(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            F0(sb, extensionReceiverParameter, AnnotationUseSiteTarget.RECEIVER);
            g61 type = extensionReceiverParameter.getType();
            k21.h(type, "receiver.type");
            String g = g(type);
            if (H1(type) && !bp2.l(type)) {
                g = '(' + g + ')';
            }
            sb.append(g);
            sb.append(".");
        }
    }

    private final void m1(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter;
        if (X() && (extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            g61 type = extensionReceiverParameter.getType();
            k21.h(type, "receiver.type");
            sb.append(g(type));
        }
    }

    private final void n1(StringBuilder sb, ib2 ib2) {
        if (k21.d(ib2, bp2.CANT_INFER_FUNCTION_PARAM_TYPE) || bp2.k(ib2)) {
            sb.append("???");
        } else if (me0.t(ib2)) {
            if (m0()) {
                String og1 = ((me0.f) ib2.c()).b().getName().toString();
                k21.h(og1, "type.constructor as UninferredParameterTypeConstructor).typeParameterDescriptor.name.toString()");
                sb.append(P0(og1));
                return;
            }
            sb.append("???");
        } else if (h61.a(ib2)) {
            O0(sb, ib2);
        } else if (H1(ib2)) {
            S0(sb, ib2);
        } else {
            O0(sb, ib2);
        }
    }

    private final void o1(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    private final void p1(ClassDescriptor classDescriptor, StringBuilder sb) {
        if (!t0() && !kotlin.reflect.jvm.internal.impl.builtins.b.t0(classDescriptor.getDefaultType())) {
            Collection<g61> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            k21.h(supertypes, "klass.typeConstructor.supertypes");
            if (supertypes.isEmpty()) {
                return;
            }
            if (supertypes.size() != 1 || !kotlin.reflect.jvm.internal.impl.builtins.b.a0(supertypes.iterator().next())) {
                o1(sb);
                sb.append(": ");
                Appendable unused = CollectionsKt___CollectionsKt.X(supertypes, sb, AVFSCacheConstants.COMMA_SEP, null, null, 0, null, new DescriptorRendererImpl$renderSuperTypes$1(this), 60, null);
            }
        }
    }

    private final void q1(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        a1(sb, functionDescriptor.isSuspend(), "suspend");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void r1(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
        G0(this, sb, typeAliasDescriptor, null, 2, null);
        h60 visibility = typeAliasDescriptor.getVisibility();
        k21.h(visibility, "typeAlias.visibility");
        E1(visibility, sb);
        W0(typeAliasDescriptor, sb);
        sb.append(U0("typealias"));
        sb.append(" ");
        b1(typeAliasDescriptor, sb, true);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
        k21.h(declaredTypeParameters, "typeAlias.declaredTypeParameters");
        y1(declaredTypeParameters, sb, false);
        H0(typeAliasDescriptor, sb);
        sb.append(" = ");
        sb.append(g(typeAliasDescriptor.getUnderlyingType()));
    }

    private final void u1(StringBuilder sb, g61 g61, TypeConstructor typeConstructor) {
        tr1 a2 = TypeParameterUtilsKt.a(g61);
        if (a2 == null) {
            sb.append(t1(typeConstructor));
            sb.append(s1(g61.b()));
            return;
        }
        i1(sb, a2);
    }

    private final void v(StringBuilder sb, DeclarationDescriptor declarationDescriptor) {
        String name;
        if (!(declarationDescriptor instanceof PackageFragmentDescriptor) && !(declarationDescriptor instanceof PackageViewDescriptor)) {
            if (declarationDescriptor instanceof ModuleDescriptor) {
                sb.append(" is a module");
                return;
            }
            DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            if (containingDeclaration != null && !(containingDeclaration instanceof ModuleDescriptor)) {
                sb.append(" ");
                sb.append(X0("defined in"));
                sb.append(" ");
                fn0 m = f60.m(containingDeclaration);
                k21.h(m, "getFqName(containingDeclaration)");
                sb.append(m.e() ? "root package" : e(m));
                if (r0() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource) && (name = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile().getName()) != null) {
                    sb.append(" ");
                    sb.append(X0("in file"));
                    sb.append(" ");
                    sb.append(name);
                }
            }
        }
    }

    private final String v0() {
        return z(jl1.G);
    }

    static /* synthetic */ void v1(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, g61 g61, TypeConstructor typeConstructor, int i, Object obj) {
        if ((i & 2) != 0) {
            typeConstructor = g61.c();
        }
        descriptorRendererImpl.u1(sb, g61, typeConstructor);
    }

    private final void w(StringBuilder sb, List<? extends TypeProjection> list) {
        Appendable unused = CollectionsKt___CollectionsKt.X(list, sb, AVFSCacheConstants.COMMA_SEP, null, null, 0, null, new DescriptorRendererImpl$appendTypeProjections$1(this), 60, null);
    }

    private final boolean w0(g61 g61) {
        return rn0.o(g61) || !g61.getAnnotations().isEmpty();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void w1(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb, boolean z) {
        if (z) {
            sb.append(z0());
        }
        if (p0()) {
            sb.append("/*");
            sb.append(typeParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        a1(sb, typeParameterDescriptor.isReified(), "reified");
        String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z2 = true;
        a1(sb, label.length() > 0, label);
        G0(this, sb, typeParameterDescriptor, null, 2, null);
        b1(typeParameterDescriptor, sb, z);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            g61 next = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (!kotlin.reflect.jvm.internal.impl.builtins.b.j0(next)) {
                sb.append(" : ");
                k21.h(next, "upperBound");
                sb.append(g(next));
            }
        } else if (z) {
            for (g61 g61 : typeParameterDescriptor.getUpperBounds()) {
                if (!kotlin.reflect.jvm.internal.impl.builtins.b.j0(g61)) {
                    if (z2) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    k21.h(g61, "upperBound");
                    sb.append(g(g61));
                    z2 = false;
                }
            }
        }
        if (z) {
            sb.append(v0());
        }
    }

    private final String x() {
        int i = b.$EnumSwitchMapping$0[k0().ordinal()];
        if (i == 1) {
            return z("->");
        }
        if (i == 2) {
            return "&rarr;";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Modality x0(MemberDescriptor memberDescriptor) {
        if (memberDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) memberDescriptor).getKind() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            return Modality.FINAL;
        }
        if (!(memberDescriptor instanceof CallableMemberDescriptor)) {
            return Modality.FINAL;
        }
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        k21.h(overriddenDescriptors, "this.overriddenDescriptors");
        if ((!overriddenDescriptors.isEmpty()) && classDescriptor.getModality() != Modality.FINAL) {
            return Modality.OPEN;
        }
        if (classDescriptor.getKind() != ClassKind.INTERFACE || k21.d(callableMemberDescriptor.getVisibility(), g60.PRIVATE)) {
            return Modality.FINAL;
        }
        Modality modality = callableMemberDescriptor.getModality();
        Modality modality2 = Modality.ABSTRACT;
        if (modality == modality2) {
            return modality2;
        }
        return Modality.OPEN;
    }

    private final void x1(StringBuilder sb, List<? extends TypeParameterDescriptor> list) {
        Iterator<? extends TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            w1((TypeParameterDescriptor) it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
        }
    }

    private final boolean y(String str, String str2) {
        if (!k21.d(str, o.F(str2, "?", "", false, 4, null)) && (!(o.v(str2, "?", false, 2, null)) || !k21.d(k21.r(str, "?"), str2))) {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(str);
            sb.append(")?");
            return k21.d(sb.toString(), str2);
        }
    }

    private final boolean y0(AnnotationDescriptor annotationDescriptor) {
        return k21.d(annotationDescriptor.getFqName(), c.a.parameterName);
    }

    private final void y1(List<? extends TypeParameterDescriptor> list, StringBuilder sb, boolean z) {
        if (!u0() && (!list.isEmpty())) {
            sb.append(z0());
            x1(sb, list);
            sb.append(v0());
            if (z) {
                sb.append(" ");
            }
        }
    }

    private final String z(String str) {
        return k0().escape(str);
    }

    private final String z0() {
        return z(jl1.L);
    }

    private final void z1(VariableDescriptor variableDescriptor, StringBuilder sb, boolean z) {
        if (z || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            sb.append(U0(variableDescriptor.isVar() ? "var" : "val"));
            sb.append(" ");
        }
    }

    public boolean A() {
        return this.a.b();
    }

    public boolean B() {
        return this.a.c();
    }

    @Nullable
    public Function1<AnnotationDescriptor, Boolean> C() {
        return this.a.d();
    }

    public boolean D() {
        return this.a.e();
    }

    public boolean E() {
        return this.a.f();
    }

    @NotNull
    public ClassifierNamePolicy F() {
        return this.a.g();
    }

    @Nullable
    public Function1<ValueParameterDescriptor, String> G() {
        return this.a.h();
    }

    public boolean H() {
        return this.a.i();
    }

    @NotNull
    public Set<en0> I() {
        return this.a.j();
    }

    public boolean K() {
        return this.a.k();
    }

    @NotNull
    public String K0(@NotNull ClassifierDescriptor classifierDescriptor) {
        k21.i(classifierDescriptor, "klass");
        if (me0.r(classifierDescriptor)) {
            return classifierDescriptor.getTypeConstructor().toString();
        }
        return F().renderClassifier(classifierDescriptor, this);
    }

    public boolean L() {
        return this.a.l();
    }

    public boolean M() {
        return this.a.m();
    }

    public boolean N() {
        return this.a.n();
    }

    public boolean O() {
        return this.a.o();
    }

    @NotNull
    public Set<DescriptorRendererModifier> P() {
        return this.a.p();
    }

    public boolean Q() {
        return this.a.q();
    }

    @NotNull
    public final DescriptorRendererOptionsImpl R() {
        return this.a;
    }

    @NotNull
    public OverrideRenderingPolicy S() {
        return this.a.r();
    }

    @NotNull
    public ParameterNameRenderingPolicy T() {
        return this.a.s();
    }

    public boolean U() {
        return this.a.t();
    }

    public boolean V() {
        return this.a.u();
    }

    @NotNull
    public PropertyAccessorRenderingPolicy W() {
        return this.a.v();
    }

    public boolean X() {
        return this.a.w();
    }

    @NotNull
    public String X0(@NotNull String str) {
        k21.i(str, "message");
        int i = b.$EnumSwitchMapping$0[k0().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i == 2) {
            return "<i>" + str + "</i>";
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean Y() {
        return this.a.x();
    }

    public boolean Z() {
        return this.a.y();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String a(@NotNull DeclarationDescriptor declarationDescriptor) {
        k21.i(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.accept(new a(this), sb);
        if (q0()) {
            v(sb, declarationDescriptor);
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean a0() {
        return this.a.z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String b(@NotNull AnnotationDescriptor annotationDescriptor, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget) {
        k21.i(annotationDescriptor, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (annotationUseSiteTarget != null) {
            sb.append(k21.r(annotationUseSiteTarget.getRenderName(), ":"));
        }
        g61 type = annotationDescriptor.getType();
        sb.append(g(type));
        if (L()) {
            List<String> E0 = E0(annotationDescriptor);
            if (M() || (!E0.isEmpty())) {
                Appendable unused = CollectionsKt___CollectionsKt.X(E0, sb, AVFSCacheConstants.COMMA_SEP, jl1.BRACKET_START_STR, jl1.BRACKET_END_STR, 0, null, null, 112, null);
            }
        }
        if (p0() && (h61.a(type) || (type.c().getDeclarationDescriptor() instanceof NotFoundClasses.b))) {
            sb.append(" /* annotation class not found */");
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean b0() {
        return this.a.A();
    }

    public boolean c0() {
        return this.a.B();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String d(@NotNull String str, @NotNull String str2, @NotNull kotlin.reflect.jvm.internal.impl.builtins.b bVar) {
        k21.i(str, "lowerRendered");
        k21.i(str2, "upperRendered");
        k21.i(bVar, "builtIns");
        if (!y(str, str2)) {
            ClassifierNamePolicy F = F();
            ClassDescriptor w = bVar.w();
            k21.h(w, "builtIns.collection");
            String str3 = StringsKt__StringsKt.Q0(F.renderClassifier(w, this), "Collection", null, 2, null);
            String r = k21.r(str3, "Mutable");
            String G1 = G1(str, r, str2, str3, str3 + '(' + "Mutable" + ')');
            if (G1 != null) {
                return G1;
            }
            String G12 = G1(str, k21.r(str3, "MutableMap.MutableEntry"), str2, k21.r(str3, "Map.Entry"), k21.r(str3, "(Mutable)Map.(Mutable)Entry"));
            if (G12 != null) {
                return G12;
            }
            ClassifierNamePolicy F2 = F();
            ClassDescriptor j = bVar.j();
            k21.h(j, "builtIns.array");
            String str4 = StringsKt__StringsKt.Q0(F2.renderClassifier(j, this), "Array", null, 2, null);
            String G13 = G1(str, k21.r(str4, z("Array<")), str2, k21.r(str4, z("Array<out ")), k21.r(str4, z("Array<(out) ")));
            if (G13 != null) {
                return G13;
            }
            return '(' + str + ".." + str2 + ')';
        } else if (!(o.L(str2, jl1.BRACKET_START_STR, false, 2, null))) {
            return k21.r(str, jl1.AND_NOT);
        } else {
            return '(' + str + ")!";
        }
    }

    public boolean d0() {
        return this.a.C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String e(@NotNull fn0 fn0) {
        k21.i(fn0, "fqName");
        List<og1> h = fn0.h();
        k21.h(h, "fqName.pathSegments()");
        return Q0(h);
    }

    public boolean e0() {
        return this.a.D();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String f(@NotNull og1 og1, boolean z) {
        k21.i(og1, "name");
        String z2 = z(sz1.b(og1));
        if (!D() || k0() != RenderingFormat.HTML || !z) {
            return z2;
        }
        return "<b>" + z2 + "</b>";
    }

    public boolean f0() {
        return this.a.E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String g(@NotNull g61 g61) {
        k21.i(g61, "type");
        StringBuilder sb = new StringBuilder();
        c1(sb, l0().invoke(g61));
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean g0() {
        return this.a.F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    @NotNull
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.a.getAnnotationArgumentsRenderingPolicy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getDebugMode() {
        return this.a.getDebugMode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getEnhancedTypes() {
        return this.a.getEnhancedTypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    @NotNull
    public Set<en0> getExcludedTypeAnnotationClasses() {
        return this.a.getExcludedTypeAnnotationClasses();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String h(@NotNull TypeProjection typeProjection) {
        k21.i(typeProjection, "typeProjection");
        StringBuilder sb = new StringBuilder();
        w(sb, l.e(typeProjection));
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean h0() {
        return this.a.G();
    }

    public boolean i0() {
        return this.a.H();
    }

    public boolean j0() {
        return this.a.I();
    }

    @NotNull
    public RenderingFormat k0() {
        return this.a.J();
    }

    @NotNull
    public Function1<g61, g61> l0() {
        return this.a.K();
    }

    public boolean m0() {
        return this.a.L();
    }

    public boolean n0() {
        return this.a.M();
    }

    @NotNull
    public DescriptorRenderer.ValueParametersHandler o0() {
        return this.a.N();
    }

    public boolean p0() {
        return this.a.O();
    }

    public boolean q0() {
        return this.a.P();
    }

    public boolean r0() {
        return this.a.Q();
    }

    public boolean s0() {
        return this.a.R();
    }

    @NotNull
    public String s1(@NotNull List<? extends TypeProjection> list) {
        k21.i(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z0());
        w(sb, list);
        sb.append(v0());
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        k21.i(annotationArgumentsRenderingPolicy, "<set-?>");
        this.a.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy) {
        k21.i(classifierNamePolicy, "<set-?>");
        this.a.setClassifierNamePolicy(classifierNamePolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean z) {
        this.a.setDebugMode(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(@NotNull Set<en0> set) {
        k21.i(set, "<set-?>");
        this.a.setExcludedTypeAnnotationClasses(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set) {
        k21.i(set, "<set-?>");
        this.a.setModifiers(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        k21.i(parameterNameRenderingPolicy, "<set-?>");
        this.a.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean z) {
        this.a.setReceiverAfterName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean z) {
        this.a.setRenderCompanionObjectName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean z) {
        this.a.setStartFromName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(@NotNull RenderingFormat renderingFormat) {
        k21.i(renderingFormat, "<set-?>");
        this.a.setTextFormat(renderingFormat);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean z) {
        this.a.setVerbose(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean z) {
        this.a.setWithDefinedIn(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean z) {
        this.a.setWithoutSuperTypes(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean z) {
        this.a.setWithoutTypeParameters(z);
    }

    public boolean t0() {
        return this.a.S();
    }

    @NotNull
    public String t1(@NotNull TypeConstructor typeConstructor) {
        k21.i(typeConstructor, "typeConstructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        boolean z = true;
        if (!(declarationDescriptor instanceof TypeParameterDescriptor ? true : declarationDescriptor instanceof ClassDescriptor)) {
            z = declarationDescriptor instanceof TypeAliasDescriptor;
        }
        if (z) {
            return K0(declarationDescriptor);
        }
        if (declarationDescriptor == null) {
            return typeConstructor.toString();
        }
        throw new IllegalStateException(k21.r("Unexpected classifier: ", declarationDescriptor.getClass()).toString());
    }

    public boolean u0() {
        return this.a.T();
    }
}
