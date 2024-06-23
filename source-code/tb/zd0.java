package tb;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class zd0 extends mi {
    private final TypeConstructor h;
    private final MemberScope i;
    private final NotNullLazyValue<Set<og1>> j;
    private final Annotations k;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class a extends oc1 {
        private final MemoizedFunctionToNotNull<og1, Collection<? extends SimpleFunctionDescriptor>> a;
        private final MemoizedFunctionToNotNull<og1, Collection<? extends PropertyDescriptor>> b;
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> c;
        final /* synthetic */ zd0 d;

        /* renamed from: tb.zd0$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        class C0313a implements Function1<og1, Collection<? extends SimpleFunctionDescriptor>> {
            C0313a(zd0 zd0) {
            }

            /* renamed from: a */
            public Collection<? extends SimpleFunctionDescriptor> invoke(og1 og1) {
                return a.this.f(og1);
            }
        }

        /* compiled from: Taobao */
        class b implements Function1<og1, Collection<? extends PropertyDescriptor>> {
            b(zd0 zd0) {
            }

            /* renamed from: a */
            public Collection<? extends PropertyDescriptor> invoke(og1 og1) {
                return a.this.g(og1);
            }
        }

        /* compiled from: Taobao */
        class c implements Function0<Collection<DeclarationDescriptor>> {
            c(zd0 zd0) {
            }

            /* renamed from: a */
            public Collection<DeclarationDescriptor> invoke() {
                return a.this.e();
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class d extends fj1 {
            final /* synthetic */ Set a;

            d(a aVar, Set set) {
                this.a = set;
            }

            private static /* synthetic */ void f(int i) {
                Object[] objArr = new Object[3];
                if (i == 1) {
                    objArr[0] = "fromSuper";
                } else if (i != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i == 1 || i == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // tb.gn1
            public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    f(0);
                }
                OverridingUtil.N(callableMemberDescriptor, null);
                this.a.add(callableMemberDescriptor);
            }

            /* access modifiers changed from: protected */
            @Override // tb.fj1
            public void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
                if (callableMemberDescriptor == null) {
                    f(1);
                }
                if (callableMemberDescriptor2 == null) {
                    f(2);
                }
            }
        }

        public a(@NotNull zd0 zd0, StorageManager storageManager) {
            if (storageManager == null) {
                a(0);
            }
            this.d = zd0;
            this.a = storageManager.createMemoizedFunction(new C0313a(zd0));
            this.b = storageManager.createMemoizedFunction(new b(zd0));
            this.c = storageManager.createLazyValue(new c(zd0));
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00be  */
        private static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (!(i == 3 || i == 7 || i == 9 || i == 12)) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
                if (!(i == 3 || i == 7 || i == 9 || i == 12)) {
                    switch (i) {
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            break;
                        default:
                            i2 = 3;
                            break;
                    }
                    Object[] objArr = new Object[i2];
                    switch (i) {
                        case 1:
                        case 4:
                        case 5:
                        case 8:
                        case 10:
                            objArr[0] = "name";
                            break;
                        case 2:
                        case 6:
                            objArr[0] = "location";
                            break;
                        case 3:
                        case 7:
                        case 9:
                        case 12:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                            break;
                        case 11:
                            objArr[0] = "fromSupertypes";
                            break;
                        case 13:
                            objArr[0] = "kindFilter";
                            break;
                        case 14:
                            objArr[0] = "nameFilter";
                            break;
                        case 20:
                            objArr[0] = "p";
                            break;
                        default:
                            objArr[0] = "storageManager";
                            break;
                    }
                    if (i == 3) {
                        objArr[1] = "getContributedVariables";
                    } else if (i == 7) {
                        objArr[1] = "getContributedFunctions";
                    } else if (i == 9) {
                        objArr[1] = "getSupertypeScope";
                    } else if (i != 12) {
                        switch (i) {
                            case 15:
                                objArr[1] = "getContributedDescriptors";
                                break;
                            case 16:
                                objArr[1] = "computeAllDeclarations";
                                break;
                            case 17:
                                objArr[1] = "getFunctionNames";
                                break;
                            case 18:
                                objArr[1] = "getClassifierNames";
                                break;
                            case 19:
                                objArr[1] = "getVariableNames";
                                break;
                            default:
                                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                                break;
                        }
                    } else {
                        objArr[1] = "resolveFakeOverrides";
                    }
                    switch (i) {
                        case 1:
                        case 2:
                            objArr[2] = "getContributedVariables";
                            break;
                        case 3:
                        case 7:
                        case 9:
                        case 12:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            break;
                        case 4:
                            objArr[2] = "computeProperties";
                            break;
                        case 5:
                        case 6:
                            objArr[2] = "getContributedFunctions";
                            break;
                        case 8:
                            objArr[2] = "computeFunctions";
                            break;
                        case 10:
                        case 11:
                            objArr[2] = "resolveFakeOverrides";
                            break;
                        case 13:
                        case 14:
                            objArr[2] = "getContributedDescriptors";
                            break;
                        case 20:
                            objArr[2] = "printScopeStructure";
                            break;
                        default:
                            objArr[2] = "<init>";
                            break;
                    }
                    String format = String.format(str, objArr);
                    if (!(i == 3 || i == 7 || i == 9 || i == 12)) {
                        switch (i) {
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                                break;
                            default:
                                throw new IllegalArgumentException(format);
                        }
                    }
                    throw new IllegalStateException(format);
                }
                i2 = 2;
                Object[] objArr2 = new Object[i2];
                switch (i) {
                }
                if (i == 3) {
                }
                switch (i) {
                }
                String format2 = String.format(str, objArr2);
                switch (i) {
                }
                throw new IllegalStateException(format2);
            }
            str = "@NotNull method %s.%s must not return null";
            switch (i) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    i2 = 2;
                    break;
            }
            Object[] objArr22 = new Object[i2];
            switch (i) {
            }
            if (i == 3) {
            }
            switch (i) {
            }
            String format22 = String.format(str, objArr22);
            switch (i) {
            }
            throw new IllegalStateException(format22);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @NotNull
        private Collection<DeclarationDescriptor> e() {
            HashSet hashSet = new HashSet();
            for (og1 og1 : (Set) this.d.j.invoke()) {
                NoLookupLocation noLookupLocation = NoLookupLocation.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(getContributedFunctions(og1, noLookupLocation));
                hashSet.addAll(getContributedVariables(og1, noLookupLocation));
            }
            return hashSet;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @NotNull
        private Collection<? extends SimpleFunctionDescriptor> f(@NotNull og1 og1) {
            if (og1 == null) {
                a(8);
            }
            return i(og1, h().getContributedFunctions(og1, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @NotNull
        private Collection<? extends PropertyDescriptor> g(@NotNull og1 og1) {
            if (og1 == null) {
                a(4);
            }
            return i(og1, h().getContributedVariables(og1, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        @NotNull
        private MemberScope h() {
            MemberScope memberScope = this.d.getTypeConstructor().getSupertypes().iterator().next().getMemberScope();
            if (memberScope == null) {
                a(9);
            }
            return memberScope;
        }

        @NotNull
        private <D extends CallableMemberDescriptor> Collection<? extends D> i(@NotNull og1 og1, @NotNull Collection<? extends D> collection) {
            if (og1 == null) {
                a(10);
            }
            if (collection == null) {
                a(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            OverridingUtil.DEFAULT.y(og1, collection, Collections.emptySet(), this.d, new d(this, linkedHashSet));
            return linkedHashSet;
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<og1> getClassifierNames() {
            Set<og1> emptySet = Collections.emptySet();
            if (emptySet == null) {
                a(18);
            }
            return emptySet;
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
            if (b60 == null) {
                a(13);
            }
            if (function1 == null) {
                a(14);
            }
            Collection<DeclarationDescriptor> collection = (Collection) this.c.invoke();
            if (collection == null) {
                a(15);
            }
            return collection;
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            if (og1 == null) {
                a(5);
            }
            if (lookupLocation == null) {
                a(6);
            }
            Collection<? extends SimpleFunctionDescriptor> invoke = this.a.invoke(og1);
            if (invoke == null) {
                a(7);
            }
            return invoke;
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            if (og1 == null) {
                a(1);
            }
            if (lookupLocation == null) {
                a(2);
            }
            Collection<? extends PropertyDescriptor> invoke = this.b.invoke(og1);
            if (invoke == null) {
                a(3);
            }
            return invoke;
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<og1> getFunctionNames() {
            Set<og1> set = (Set) this.d.j.invoke();
            if (set == null) {
                a(17);
            }
            return set;
        }

        @Override // tb.oc1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<og1> getVariableNames() {
            Set<og1> set = (Set) this.d.j.invoke();
            if (set == null) {
                a(19);
            }
            return set;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zd0(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor, @NotNull g61 g61, @NotNull og1 og1, @NotNull NotNullLazyValue<Set<og1>> notNullLazyValue, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        super(storageManager, classDescriptor, og1, sourceElement, false);
        if (storageManager == null) {
            c(6);
        }
        if (classDescriptor == null) {
            c(7);
        }
        if (g61 == null) {
            c(8);
        }
        if (og1 == null) {
            c(9);
        }
        if (notNullLazyValue == null) {
            c(10);
        }
        if (annotations == null) {
            c(11);
        }
        if (sourceElement == null) {
            c(12);
        }
        this.k = annotations;
        this.h = new si(this, Collections.emptyList(), Collections.singleton(g61), storageManager);
        this.i = new a(this, storageManager);
        this.j = notNullLazyValue;
    }

    private static /* synthetic */ void c(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @NotNull
    public static zd0 f(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor, @NotNull og1 og1, @NotNull NotNullLazyValue<Set<og1>> notNullLazyValue, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (storageManager == null) {
            c(0);
        }
        if (classDescriptor == null) {
            c(1);
        }
        if (og1 == null) {
            c(2);
        }
        if (notNullLazyValue == null) {
            c(3);
        }
        if (annotations == null) {
            c(4);
        }
        if (sourceElement == null) {
            c(5);
        }
        return new zd0(storageManager, classDescriptor, classDescriptor.getDefaultType(), og1, notNullLazyValue, annotations, sourceElement);
    }

    @Override // tb.xe1
    @NotNull
    public MemberScope b(@NotNull i61 i61) {
        if (i61 == null) {
            c(13);
        }
        MemberScope memberScope = this.i;
        if (memberScope == null) {
            c(14);
        }
        return memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations = this.k;
        if (annotations == null) {
            c(21);
        }
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            c(16);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            c(22);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind == null) {
            c(18);
        }
        return classKind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = Modality.FINAL;
        if (modality == null) {
            c(19);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            c(23);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getStaticScope() {
        MemberScope.b bVar = MemberScope.b.INSTANCE;
        if (bVar == null) {
            c(15);
        }
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.h;
        if (typeConstructor == null) {
            c(17);
        }
        return typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public h60 getVisibility() {
        h60 h60 = g60.PUBLIC;
        if (h60 == null) {
            c(20);
        }
        return h60;
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
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public String toString() {
        return "enum entry " + getName();
    }
}
