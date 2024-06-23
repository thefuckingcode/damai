package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.text.StringsKt;

/* compiled from: FunctionClassDescriptor.kt */
public final class FunctionClassDescriptor extends AbstractClassDescriptor {
    public static final Companion Companion = new Companion(null);
    private static final ClassId functionClassId = new ClassId(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, Name.identifier("Function"));
    private static final ClassId kFunctionClassId = new ClassId(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), Name.identifier("KFunction"));
    private final int arity;
    private final PackageFragmentDescriptor containingDeclaration;
    private final Kind functionKind;
    private final FunctionClassScope memberScope;
    private final List<TypeParameterDescriptor> parameters;
    private final StorageManager storageManager;
    private final FunctionTypeConstructor typeConstructor = new FunctionTypeConstructor();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Void getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Void getUnsubstitutedPrimaryConstructor() {
        return null;
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    public final Kind getFunctionKind() {
        return this.functionKind;
    }

    public final int getArity() {
        return this.arity;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionClassDescriptor(StorageManager storageManager2, PackageFragmentDescriptor packageFragmentDescriptor, Kind kind, int i) {
        super(storageManager2, kind.numberedClassName(i));
        Intrinsics.checkParameterIsNotNull(storageManager2, "storageManager");
        Intrinsics.checkParameterIsNotNull(packageFragmentDescriptor, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(kind, "functionKind");
        this.storageManager = storageManager2;
        this.containingDeclaration = packageFragmentDescriptor;
        this.functionKind = kind;
        this.arity = i;
        this.memberScope = new FunctionClassScope(storageManager2, this);
        final ArrayList arrayList = new ArrayList();
        AnonymousClass1 r6 = new Function2<Variance, String, Unit>(this) {
            /* class kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.AnonymousClass1 */
            final /* synthetic */ FunctionClassDescriptor this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Variance variance, String str) {
                invoke(variance, str);
                return Unit.INSTANCE;
            }

            public final void invoke(Variance variance, String str) {
                Intrinsics.checkParameterIsNotNull(variance, "variance");
                Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
                arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(this.this$0, Annotations.Companion.getEMPTY(), false, variance, Name.identifier(str), arrayList.size(), this.this$0.storageManager));
            }
        };
        IntRange intRange = new IntRange(1, i);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            Variance variance = Variance.IN_VARIANCE;
            StringBuilder sb = new StringBuilder();
            sb.append('P');
            sb.append(nextInt);
            r6.invoke(variance, sb.toString());
            arrayList2.add(Unit.INSTANCE);
        }
        r6.invoke(Variance.OUT_VARIANCE, "R");
        this.parameters = CollectionsKt.toList(arrayList);
    }

    /* JADX WARN: Init of enum Function can be incorrect */
    /* JADX WARN: Init of enum SuspendFunction can be incorrect */
    /* compiled from: FunctionClassDescriptor.kt */
    public enum Kind {
        Function(r2, "Function"),
        SuspendFunction(r2, "SuspendFunction"),
        KFunction(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), "KFunction"),
        KSuspendFunction(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), "KSuspendFunction");
        
        public static final Companion Companion = new Companion(null);
        private final String classNamePrefix;
        private final FqName packageFqName;

        private Kind(FqName fqName, String str) {
            this.packageFqName = fqName;
            this.classNamePrefix = str;
        }

        public final String getClassNamePrefix() {
            return this.classNamePrefix;
        }

        public final FqName getPackageFqName() {
            return this.packageFqName;
        }

        static {
            Intrinsics.checkExpressionValueIsNotNull(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, "BUILT_INS_PACKAGE_FQ_NAME");
            Intrinsics.checkExpressionValueIsNotNull(DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
        }

        public final Name numberedClassName(int i) {
            Name identifier = Name.identifier(this.classNamePrefix + i);
            Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(\"$classNamePrefix$arity\")");
            return identifier;
        }

        /* compiled from: FunctionClassDescriptor.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Kind byClassNamePrefix(FqName fqName, String str) {
                Intrinsics.checkParameterIsNotNull(fqName, "packageFqName");
                Intrinsics.checkParameterIsNotNull(str, "className");
                Kind[] values = Kind.values();
                for (Kind kind : values) {
                    if (Intrinsics.areEqual(kind.getPackageFqName(), fqName) && StringsKt.startsWith$default(str, kind.getClassNamePrefix(), false, 2, null)) {
                        return kind;
                    }
                }
                return null;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope.Empty getStaticScope() {
        return MemberScope.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public FunctionClassScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Visibility getVisibility() {
        Visibility visibility = Visibilities.PUBLIC;
        Intrinsics.checkExpressionValueIsNotNull(visibility, "Visibilities.PUBLIC");
        return visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
        return sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassDescriptor> getSealedSubclasses() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.parameters;
    }

    /* compiled from: FunctionClassDescriptor.kt */
    private final class FunctionTypeConstructor extends AbstractClassTypeConstructor {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Kind.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[Kind.Function.ordinal()] = 1;
                iArr[Kind.KFunction.ordinal()] = 2;
                iArr[Kind.SuspendFunction.ordinal()] = 3;
                iArr[Kind.KSuspendFunction.ordinal()] = 4;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public FunctionTypeConstructor() {
            super(FunctionClassDescriptor.this.storageManager);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public Collection<KotlinType> computeSupertypes() {
            List list;
            int i = WhenMappings.$EnumSwitchMapping$0[FunctionClassDescriptor.this.getFunctionKind().ordinal()];
            if (i == 1) {
                list = CollectionsKt.listOf(FunctionClassDescriptor.functionClassId);
            } else if (i == 2) {
                list = CollectionsKt.listOf((Object[]) new ClassId[]{FunctionClassDescriptor.kFunctionClassId, new ClassId(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, Kind.Function.numberedClassName(FunctionClassDescriptor.this.getArity()))});
            } else if (i == 3) {
                list = CollectionsKt.listOf(FunctionClassDescriptor.functionClassId);
            } else if (i == 4) {
                list = CollectionsKt.listOf((Object[]) new ClassId[]{FunctionClassDescriptor.kFunctionClassId, new ClassId(DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE, Kind.SuspendFunction.numberedClassName(FunctionClassDescriptor.this.getArity()))});
            } else {
                throw new NoWhenBranchMatchedException();
            }
            ModuleDescriptor containingDeclaration = FunctionClassDescriptor.this.containingDeclaration.getContainingDeclaration();
            List<ClassId> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (ClassId classId : list2) {
                ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(containingDeclaration, classId);
                if (findClassAcrossModuleDependencies != null) {
                    List<TypeParameterDescriptor> parameters = getParameters();
                    TypeConstructor typeConstructor = findClassAcrossModuleDependencies.getTypeConstructor();
                    Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "descriptor.typeConstructor");
                    List<TypeParameterDescriptor> takeLast = CollectionsKt.takeLast(parameters, typeConstructor.getParameters().size());
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(takeLast, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor : takeLast) {
                        arrayList2.add(new TypeProjectionImpl(typeParameterDescriptor.getDefaultType()));
                    }
                    arrayList.add(KotlinTypeFactory.simpleNotNullType(Annotations.Companion.getEMPTY(), findClassAcrossModuleDependencies, arrayList2));
                } else {
                    throw new IllegalStateException(("Built-in class " + classId + " not found").toString());
                }
            }
            return CollectionsKt.toList(arrayList);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return FunctionClassDescriptor.this.parameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public FunctionClassDescriptor getDeclarationDescriptor() {
            return FunctionClassDescriptor.this;
        }

        public String toString() {
            return getDeclarationDescriptor().toString();
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }
    }

    public String toString() {
        String asString = getName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
        return asString;
    }

    /* compiled from: FunctionClassDescriptor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
