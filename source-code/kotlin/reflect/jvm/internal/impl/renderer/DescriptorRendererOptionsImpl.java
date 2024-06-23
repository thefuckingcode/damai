package kotlin.reflect.jvm.internal.impl.renderer;

import com.taobao.weex.common.WXConfig;
import java.lang.reflect.Field;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.en0;
import tb.g61;
import tb.gl1;
import tb.k21;
import tb.kf0;
import tb.q50;
import tb.sk1;

/* compiled from: Taobao */
public final class DescriptorRendererOptionsImpl implements DescriptorRendererOptions {
    static final /* synthetic */ KProperty<Object>[] X = {dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "withDefinedIn", "getWithDefinedIn()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "modifiers", "getModifiers()Ljava/util/Set;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "startFromName", "getStartFromName()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), WXConfig.debugMode, "getDebugMode()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "verbose", "getVerbose()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "unitReturnType", "getUnitReturnType()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "withoutReturnType", "getWithoutReturnType()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "enhancedTypes", "getEnhancedTypes()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "renderDefaultModality", "getRenderDefaultModality()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "receiverAfterName", "getReceiverAfterName()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), dz1.f(new MutablePropertyReference1Impl(dz1.b(DescriptorRendererOptionsImpl.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    @NotNull
    private final ReadWriteProperty A;
    @NotNull
    private final ReadWriteProperty B;
    @NotNull
    private final ReadWriteProperty C;
    @NotNull
    private final ReadWriteProperty D;
    @NotNull
    private final ReadWriteProperty E;
    @NotNull
    private final ReadWriteProperty F;
    @NotNull
    private final ReadWriteProperty G;
    @NotNull
    private final ReadWriteProperty H;
    @NotNull
    private final ReadWriteProperty I;
    @NotNull
    private final ReadWriteProperty J;
    @NotNull
    private final ReadWriteProperty K;
    @NotNull
    private final ReadWriteProperty L;
    @NotNull
    private final ReadWriteProperty M;
    @NotNull
    private final ReadWriteProperty N;
    @NotNull
    private final ReadWriteProperty O;
    @NotNull
    private final ReadWriteProperty P;
    @NotNull
    private final ReadWriteProperty Q;
    @NotNull
    private final ReadWriteProperty R;
    @NotNull
    private final ReadWriteProperty S;
    @NotNull
    private final ReadWriteProperty T;
    @NotNull
    private final ReadWriteProperty U;
    @NotNull
    private final ReadWriteProperty V;
    @NotNull
    private final ReadWriteProperty W;
    private boolean a;
    @NotNull
    private final ReadWriteProperty b = W(ClassifierNamePolicy.c.INSTANCE);
    @NotNull
    private final ReadWriteProperty c;
    @NotNull
    private final ReadWriteProperty d;
    @NotNull
    private final ReadWriteProperty e;
    @NotNull
    private final ReadWriteProperty f;
    @NotNull
    private final ReadWriteProperty g;
    @NotNull
    private final ReadWriteProperty h;
    @NotNull
    private final ReadWriteProperty i;
    @NotNull
    private final ReadWriteProperty j;
    @NotNull
    private final ReadWriteProperty k;
    @NotNull
    private final ReadWriteProperty l;
    @NotNull
    private final ReadWriteProperty m;
    @NotNull
    private final ReadWriteProperty n;
    @NotNull
    private final ReadWriteProperty o;
    @NotNull
    private final ReadWriteProperty p;
    @NotNull
    private final ReadWriteProperty q;
    @NotNull
    private final ReadWriteProperty r;
    @NotNull
    private final ReadWriteProperty s;
    @NotNull
    private final ReadWriteProperty t;
    @NotNull
    private final ReadWriteProperty u;
    @NotNull
    private final ReadWriteProperty v;
    @NotNull
    private final ReadWriteProperty w;
    @NotNull
    private final ReadWriteProperty x;
    @NotNull
    private final ReadWriteProperty y;
    @NotNull
    private final ReadWriteProperty z;

    /* compiled from: Taobao */
    public static final class a extends sk1<T> {
        final /* synthetic */ Object b;
        final /* synthetic */ DescriptorRendererOptionsImpl c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object obj, Object obj2, DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
            super(obj2);
            this.b = obj;
            this.c = descriptorRendererOptionsImpl;
        }

        /* access modifiers changed from: protected */
        @Override // tb.sk1
        public boolean b(@NotNull KProperty<?> kProperty, T t, T t2) {
            k21.i(kProperty, "property");
            if (!this.c.U()) {
                return true;
            }
            throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        }
    }

    public DescriptorRendererOptionsImpl() {
        Boolean bool = Boolean.TRUE;
        this.c = W(bool);
        this.d = W(bool);
        this.e = W(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        Boolean bool2 = Boolean.FALSE;
        this.f = W(bool2);
        this.g = W(bool2);
        this.h = W(bool2);
        this.i = W(bool2);
        this.j = W(bool2);
        this.k = W(bool);
        this.l = W(bool2);
        this.m = W(bool2);
        this.n = W(bool2);
        this.o = W(bool);
        this.p = W(bool);
        this.q = W(bool2);
        this.r = W(bool2);
        this.s = W(bool2);
        this.t = W(bool2);
        this.u = W(bool2);
        this.v = W(bool2);
        this.w = W(bool2);
        this.x = W(DescriptorRendererOptionsImpl$typeNormalizer$2.INSTANCE);
        this.y = W(DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2.INSTANCE);
        this.z = W(bool);
        this.A = W(OverrideRenderingPolicy.RENDER_OPEN);
        this.B = W(DescriptorRenderer.ValueParametersHandler.a.INSTANCE);
        this.C = W(RenderingFormat.PLAIN);
        this.D = W(ParameterNameRenderingPolicy.ALL);
        this.E = W(bool2);
        this.F = W(bool2);
        this.G = W(PropertyAccessorRenderingPolicy.DEBUG);
        this.H = W(bool2);
        this.I = W(bool2);
        this.J = W(e0.d());
        this.K = W(kf0.INSTANCE.a());
        this.L = W(null);
        this.M = W(AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);
        this.N = W(bool2);
        this.O = W(bool);
        this.P = W(bool);
        this.Q = W(bool2);
        this.R = W(bool);
        this.S = W(bool);
        this.T = W(bool2);
        this.U = W(bool2);
        this.V = W(bool2);
        this.W = W(bool);
    }

    private final <T> ReadWriteProperty<DescriptorRendererOptionsImpl, T> W(T t2) {
        q50 q50 = q50.INSTANCE;
        return new a(t2, t2, this);
    }

    public boolean A() {
        return ((Boolean) this.H.getValue(this, X[32])).booleanValue();
    }

    public boolean B() {
        return ((Boolean) this.p.getValue(this, X[14])).booleanValue();
    }

    public boolean C() {
        return ((Boolean) this.o.getValue(this, X[13])).booleanValue();
    }

    public boolean D() {
        return ((Boolean) this.r.getValue(this, X[16])).booleanValue();
    }

    public boolean E() {
        return ((Boolean) this.Q.getValue(this, X[41])).booleanValue();
    }

    public boolean F() {
        return ((Boolean) this.P.getValue(this, X[40])).booleanValue();
    }

    public boolean G() {
        return ((Boolean) this.z.getValue(this, X[24])).booleanValue();
    }

    public boolean H() {
        return ((Boolean) this.g.getValue(this, X[5])).booleanValue();
    }

    public boolean I() {
        return ((Boolean) this.f.getValue(this, X[4])).booleanValue();
    }

    @NotNull
    public RenderingFormat J() {
        return (RenderingFormat) this.C.getValue(this, X[27]);
    }

    @NotNull
    public Function1<g61, g61> K() {
        return (Function1) this.x.getValue(this, X[22]);
    }

    public boolean L() {
        return ((Boolean) this.t.getValue(this, X[18])).booleanValue();
    }

    public boolean M() {
        return ((Boolean) this.k.getValue(this, X[9])).booleanValue();
    }

    @NotNull
    public DescriptorRenderer.ValueParametersHandler N() {
        return (DescriptorRenderer.ValueParametersHandler) this.B.getValue(this, X[26]);
    }

    public boolean O() {
        return ((Boolean) this.j.getValue(this, X[8])).booleanValue();
    }

    public boolean P() {
        return ((Boolean) this.c.getValue(this, X[1])).booleanValue();
    }

    public boolean Q() {
        return ((Boolean) this.d.getValue(this, X[2])).booleanValue();
    }

    public boolean R() {
        return ((Boolean) this.l.getValue(this, X[10])).booleanValue();
    }

    public boolean S() {
        return ((Boolean) this.w.getValue(this, X[21])).booleanValue();
    }

    public boolean T() {
        return ((Boolean) this.v.getValue(this, X[20])).booleanValue();
    }

    public final boolean U() {
        return this.a;
    }

    public final void V() {
        this.a = true;
    }

    @NotNull
    public final DescriptorRendererOptionsImpl a() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
        Field[] declaredFields = DescriptorRendererOptionsImpl.class.getDeclaredFields();
        k21.h(declaredFields, "this::class.java.declaredFields");
        int length = declaredFields.length;
        int i2 = 0;
        while (i2 < length) {
            Field field = declaredFields[i2];
            i2++;
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                sk1 sk1 = obj instanceof sk1 ? (sk1) obj : null;
                if (sk1 != null) {
                    String name = field.getName();
                    k21.h(name, "field.name");
                    boolean unused = o.L(name, "is", false, 2, null);
                    KClass b2 = dz1.b(DescriptorRendererOptionsImpl.class);
                    String name2 = field.getName();
                    String name3 = field.getName();
                    k21.h(name3, "field.name");
                    field.set(descriptorRendererOptionsImpl, descriptorRendererOptionsImpl.W(sk1.getValue(this, new PropertyReference1Impl(b2, name2, k21.r(gl1.TYPE_OPEN_URL_METHOD_GET, o.p(name3))))));
                }
            }
        }
        return descriptorRendererOptionsImpl;
    }

    public boolean b() {
        return ((Boolean) this.s.getValue(this, X[17])).booleanValue();
    }

    public boolean c() {
        return ((Boolean) this.N.getValue(this, X[38])).booleanValue();
    }

    @Nullable
    public Function1<AnnotationDescriptor, Boolean> d() {
        return (Function1) this.L.getValue(this, X[36]);
    }

    public boolean e() {
        return ((Boolean) this.V.getValue(this, X[46])).booleanValue();
    }

    public boolean f() {
        return ((Boolean) this.i.getValue(this, X[7])).booleanValue();
    }

    @NotNull
    public ClassifierNamePolicy g() {
        return (ClassifierNamePolicy) this.b.getValue(this, X[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    @NotNull
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return (AnnotationArgumentsRenderingPolicy) this.M.getValue(this, X[37]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getDebugMode() {
        return ((Boolean) this.h.getValue(this, X[6])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getEnhancedTypes() {
        return ((Boolean) this.m.getValue(this, X[11])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    @NotNull
    public Set<en0> getExcludedTypeAnnotationClasses() {
        return (Set) this.K.getValue(this, X[35]);
    }

    @Nullable
    public Function1<ValueParameterDescriptor, String> h() {
        return (Function1) this.y.getValue(this, X[23]);
    }

    public boolean i() {
        return ((Boolean) this.I.getValue(this, X[33])).booleanValue();
    }

    @NotNull
    public Set<en0> j() {
        return (Set) this.J.getValue(this, X[34]);
    }

    public boolean k() {
        return ((Boolean) this.R.getValue(this, X[42])).booleanValue();
    }

    public boolean l() {
        return DescriptorRendererOptions.a.a(this);
    }

    public boolean m() {
        return DescriptorRendererOptions.a.b(this);
    }

    public boolean n() {
        return ((Boolean) this.u.getValue(this, X[19])).booleanValue();
    }

    public boolean o() {
        return ((Boolean) this.W.getValue(this, X[47])).booleanValue();
    }

    @NotNull
    public Set<DescriptorRendererModifier> p() {
        return (Set) this.e.getValue(this, X[3]);
    }

    public boolean q() {
        return ((Boolean) this.n.getValue(this, X[12])).booleanValue();
    }

    @NotNull
    public OverrideRenderingPolicy r() {
        return (OverrideRenderingPolicy) this.A.getValue(this, X[25]);
    }

    @NotNull
    public ParameterNameRenderingPolicy s() {
        return (ParameterNameRenderingPolicy) this.D.getValue(this, X[28]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        k21.i(annotationArgumentsRenderingPolicy, "<set-?>");
        this.M.setValue(this, X[37], annotationArgumentsRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy) {
        k21.i(classifierNamePolicy, "<set-?>");
        this.b.setValue(this, X[0], classifierNamePolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean z2) {
        this.h.setValue(this, X[6], Boolean.valueOf(z2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(@NotNull Set<en0> set) {
        k21.i(set, "<set-?>");
        this.K.setValue(this, X[35], set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set) {
        k21.i(set, "<set-?>");
        this.e.setValue(this, X[3], set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        k21.i(parameterNameRenderingPolicy, "<set-?>");
        this.D.setValue(this, X[28], parameterNameRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean z2) {
        this.E.setValue(this, X[29], Boolean.valueOf(z2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean z2) {
        this.F.setValue(this, X[30], Boolean.valueOf(z2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean z2) {
        this.f.setValue(this, X[4], Boolean.valueOf(z2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(@NotNull RenderingFormat renderingFormat) {
        k21.i(renderingFormat, "<set-?>");
        this.C.setValue(this, X[27], renderingFormat);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean z2) {
        this.j.setValue(this, X[8], Boolean.valueOf(z2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean z2) {
        this.c.setValue(this, X[1], Boolean.valueOf(z2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean z2) {
        this.w.setValue(this, X[21], Boolean.valueOf(z2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean z2) {
        this.v.setValue(this, X[20], Boolean.valueOf(z2));
    }

    public boolean t() {
        return ((Boolean) this.S.getValue(this, X[43])).booleanValue();
    }

    public boolean u() {
        return ((Boolean) this.U.getValue(this, X[45])).booleanValue();
    }

    @NotNull
    public PropertyAccessorRenderingPolicy v() {
        return (PropertyAccessorRenderingPolicy) this.G.getValue(this, X[31]);
    }

    public boolean w() {
        return ((Boolean) this.E.getValue(this, X[29])).booleanValue();
    }

    public boolean x() {
        return ((Boolean) this.F.getValue(this, X[30])).booleanValue();
    }

    public boolean y() {
        return ((Boolean) this.q.getValue(this, X[15])).booleanValue();
    }

    public boolean z() {
        return ((Boolean) this.O.getValue(this, X[39])).booleanValue();
    }
}
