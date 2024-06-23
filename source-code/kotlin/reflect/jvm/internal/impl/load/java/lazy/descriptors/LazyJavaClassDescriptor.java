package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e0;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bg2;
import tb.c11;
import tb.en0;
import tb.g60;
import tb.g61;
import tb.h60;
import tb.i61;
import tb.jb1;
import tb.k1;
import tb.k21;
import tb.ku2;
import tb.m40;
import tb.mi;
import tb.p31;
import tb.qj;
import tb.qw2;
import tb.r11;
import tb.sg0;
import tb.u41;
import tb.vo2;
import tb.w11;
import tb.w61;
import tb.x61;
import tb.y31;

/* compiled from: Taobao */
public final class LazyJavaClassDescriptor extends mi implements JavaClassDescriptor {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final x61 h;
    @NotNull
    private final JavaClass i;
    @Nullable
    private final ClassDescriptor j;
    @NotNull
    private final x61 k;
    @NotNull
    private final ClassKind l;
    @NotNull
    private final Modality m;
    @NotNull
    private final qw2 n;
    private final boolean o;
    @NotNull
    private final LazyJavaClassTypeConstructor p;
    @NotNull
    private final LazyJavaClassMemberScope q;
    @NotNull
    private final ScopesHolderForClass<LazyJavaClassMemberScope> r;
    @NotNull
    private final c11 s;
    @NotNull
    private final LazyJavaStaticClassScope t;
    @NotNull
    private final Annotations u;
    @NotNull
    private final NotNullLazyValue<List<TypeParameterDescriptor>> v;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class LazyJavaClassTypeConstructor extends k1 {
        @NotNull
        private final NotNullLazyValue<List<TypeParameterDescriptor>> d;
        final /* synthetic */ LazyJavaClassDescriptor e;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LazyJavaClassTypeConstructor(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            super(lazyJavaClassDescriptor.k.e());
            k21.i(lazyJavaClassDescriptor, "this$0");
            this.e = lazyJavaClassDescriptor;
            this.d = lazyJavaClassDescriptor.k.e().createLazyValue(new LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1(lazyJavaClassDescriptor));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
            if ((!r0.d() && r0.i(kotlin.reflect.jvm.internal.impl.builtins.c.BUILT_INS_PACKAGE_NAME)) != false) goto L_0x001d;
         */
        private final g61 p() {
            en0 en0;
            ArrayList arrayList;
            en0 q = q();
            if (q != null) {
            }
            q = null;
            if (q == null) {
                en0 = sg0.INSTANCE.b(DescriptorUtilsKt.i(this.e));
                if (en0 == null) {
                    return null;
                }
            } else {
                en0 = q;
            }
            ClassDescriptor r = DescriptorUtilsKt.r(this.e.k.d(), en0, NoLookupLocation.FROM_JAVA_LOADER);
            if (r == null) {
                return null;
            }
            int size = r.getTypeConstructor().getParameters().size();
            List<TypeParameterDescriptor> parameters = this.e.getTypeConstructor().getParameters();
            k21.h(parameters, "getTypeConstructor().parameters");
            int size2 = parameters.size();
            if (size2 == size) {
                arrayList = new ArrayList(n.q(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new vo2(Variance.INVARIANT, it.next().getDefaultType()));
                }
            } else if (size2 != 1 || size <= 1 || q != null) {
                return null;
            } else {
                vo2 vo2 = new vo2(Variance.INVARIANT, ((TypeParameterDescriptor) k.o0(parameters)).getDefaultType());
                w11 w11 = new w11(1, size);
                ArrayList arrayList2 = new ArrayList(n.q(w11, 10));
                Iterator it2 = w11.iterator();
                while (it2.hasNext()) {
                    ((r11) it2).nextInt();
                    arrayList2.add(vo2);
                }
                arrayList = arrayList2;
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return KotlinTypeFactory.g(Annotations.Companion.b(), r, arrayList);
        }

        private final en0 q() {
            Annotations annotations = this.e.getAnnotations();
            en0 en0 = u41.PURELY_IMPLEMENTS_ANNOTATION;
            k21.h(en0, "PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor findAnnotation = annotations.findAnnotation(en0);
            if (findAnnotation == null) {
                return null;
            }
            Object p0 = k.p0(findAnnotation.getAllValueArguments().values());
            bg2 bg2 = p0 instanceof bg2 ? (bg2) p0 : null;
            String str = bg2 == null ? null : (String) bg2.b();
            if (str != null && kotlin.reflect.jvm.internal.impl.name.a.c(str)) {
                return new en0(str);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public Collection<g61> c() {
            Object obj;
            Collection<JavaClassifierType> supertypes = this.e.j().getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            ArrayList<JavaType> arrayList2 = new ArrayList(0);
            g61 p = p();
            Iterator<JavaClassifierType> it = supertypes.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                JavaClassifierType next = it.next();
                g61 n = this.e.k.g().n(next, JavaTypeResolverKt.f(TypeUsage.SUPERTYPE, false, null, 3, null));
                if (this.e.k.a().p().getTypeEnhancementImprovements()) {
                    n = this.e.k.a().q().f(n, this.e.k);
                }
                if (n.c().getDeclarationDescriptor() instanceof NotFoundClasses.b) {
                    arrayList2.add(next);
                }
                TypeConstructor c = n.c();
                if (p != null) {
                    obj = p.c();
                }
                if (!k21.d(c, obj) && !b.a0(n)) {
                    arrayList.add(n);
                }
            }
            ClassDescriptor classDescriptor = this.e.j;
            if (classDescriptor != null) {
                obj = jb1.a(classDescriptor, this.e).c().q(classDescriptor.getDefaultType(), Variance.INVARIANT);
            }
            qj.a(arrayList, obj);
            qj.a(arrayList, p);
            if (!arrayList2.isEmpty()) {
                ErrorReporter c2 = this.e.k.a().c();
                ClassDescriptor n2 = getDeclarationDescriptor();
                ArrayList arrayList3 = new ArrayList(n.q(arrayList2, 10));
                for (JavaType javaType : arrayList2) {
                    arrayList3.add(((JavaClassifierType) javaType).getPresentableText());
                }
                c2.reportIncompleteHierarchy(n2, arrayList3);
            }
            return arrayList.isEmpty() ^ true ? CollectionsKt___CollectionsKt.y0(arrayList) : l.e(this.e.k.d().getBuiltIns().i());
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public SupertypeLoopChecker g() {
            return this.e.k.a().u();
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

        @Override // tb.k1
        @NotNull
        /* renamed from: n */
        public ClassDescriptor getDeclarationDescriptor() {
            return this.e;
        }

        @NotNull
        public String toString() {
            String b = this.e.getName().b();
            k21.h(b, "name.asString()");
            return b;
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    static {
        Set<T> unused = e0.g("equals", "hashCode", "getClass", "wait", AgooConstants.MESSAGE_NOTIFICATION, "notifyAll", "toString");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaClassDescriptor(x61 x61, DeclarationDescriptor declarationDescriptor, JavaClass javaClass, ClassDescriptor classDescriptor, int i2, m40 m40) {
        this(x61, declarationDescriptor, javaClass, (i2 & 8) != 0 ? null : classDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return (List) this.v.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        return this.l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Modality getModality() {
        return this.m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        if (this.m != Modality.SEALED) {
            return m.g();
        }
        y31 f = JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 3, null);
        Collection<JavaClassifierType> permittedTypes = this.i.getPermittedTypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = permittedTypes.iterator();
        while (it.hasNext()) {
            ClassifierDescriptor declarationDescriptor = this.k.g().n(it.next(), f).c().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null) {
                arrayList.add(classDescriptor);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getStaticScope() {
        return this.t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.p;
    }

    @Override // tb.j1, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public h60 getVisibility() {
        if (!k21.d(this.n, g60.PRIVATE) || this.i.getOuterClass() != null) {
            return ku2.b(this.n);
        }
        h60 h60 = p31.PACKAGE_VISIBILITY;
        k21.h(h60, "{\n            JavaDescriptorVisibilities.PACKAGE_VISIBILITY\n        }");
        return h60;
    }

    @NotNull
    public final LazyJavaClassDescriptor h(@NotNull JavaResolverCache javaResolverCache, @Nullable ClassDescriptor classDescriptor) {
        k21.i(javaResolverCache, "javaResolverCache");
        x61 x61 = this.k;
        x61 j2 = ContextKt.j(x61, x61.a().v(javaResolverCache));
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        k21.h(containingDeclaration, "containingDeclaration");
        return new LazyJavaClassDescriptor(j2, containingDeclaration, this.i, classDescriptor);
    }

    @NotNull
    /* renamed from: i */
    public List<ClassConstructorDescriptor> getConstructors() {
        return (List) this.q.p0().invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    @NotNull
    public final JavaClass j() {
        return this.i;
    }

    @NotNull
    /* renamed from: k */
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        return (LazyJavaClassMemberScope) super.getUnsubstitutedMemberScope();
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: l */
    public LazyJavaClassMemberScope b(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        return this.r.c(i61);
    }

    @NotNull
    public String toString() {
        return k21.r("Lazy Java class ", DescriptorUtilsKt.j(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor(@NotNull x61 x61, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull JavaClass javaClass, @Nullable ClassDescriptor classDescriptor) {
        super(x61.e(), declarationDescriptor, javaClass.getName(), x61.a().s().source(javaClass), false);
        ClassKind classKind;
        Modality modality;
        k21.i(x61, "outerContext");
        k21.i(declarationDescriptor, "containingDeclaration");
        k21.i(javaClass, "jClass");
        this.h = x61;
        this.i = javaClass;
        this.j = classDescriptor;
        x61 d = ContextKt.d(x61, this, javaClass, 0, 4, null);
        this.k = d;
        d.a().g().recordClass(javaClass, this);
        javaClass.getLightClassOriginKind();
        if (javaClass.isAnnotationType()) {
            classKind = ClassKind.ANNOTATION_CLASS;
        } else if (javaClass.isInterface()) {
            classKind = ClassKind.INTERFACE;
        } else if (javaClass.isEnum()) {
            classKind = ClassKind.ENUM_CLASS;
        } else {
            classKind = ClassKind.CLASS;
        }
        this.l = classKind;
        if (javaClass.isAnnotationType() || javaClass.isEnum()) {
            modality = Modality.FINAL;
        } else {
            modality = Modality.Companion.a(false, javaClass.isSealed() || javaClass.isAbstract() || javaClass.isInterface(), !javaClass.isFinal());
        }
        this.m = modality;
        this.n = javaClass.getVisibility();
        this.o = javaClass.getOuterClass() != null && !javaClass.isStatic();
        this.p = new LazyJavaClassTypeConstructor(this);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = new LazyJavaClassMemberScope(d, this, javaClass, classDescriptor != null, null, 16, null);
        this.q = lazyJavaClassMemberScope;
        this.r = ScopesHolderForClass.Companion.a(this, d.e(), d.a().j().getKotlinTypeRefiner(), new LazyJavaClassDescriptor$scopeHolder$1(this));
        this.s = new c11(lazyJavaClassMemberScope);
        this.t = new LazyJavaStaticClassScope(d, javaClass, this);
        this.u = w61.a(d, javaClass);
        this.v = d.e().createLazyValue(new LazyJavaClassDescriptor$declaredParameters$1(this));
    }
}
