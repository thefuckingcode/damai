package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.lzy.okgo.cookie.SerializableCookie;
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
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class EnumEntrySyntheticClassDescriptor extends ClassDescriptorBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Annotations annotations;
    private final NotNullLazyValue<Set<Name>> enumMemberNames;
    private final MemberScope scope;
    private final TypeConstructor typeConstructor;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
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
        switch (i) {
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
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = SerializableCookie.NAME;
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
        switch (i) {
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
        switch (i) {
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
        switch (i) {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    public static EnumEntrySyntheticClassDescriptor create(StorageManager storageManager, ClassDescriptor classDescriptor, Name name, NotNullLazyValue<Set<Name>> notNullLazyValue, Annotations annotations2, SourceElement sourceElement) {
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(1);
        }
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        if (notNullLazyValue == null) {
            $$$reportNull$$$0(3);
        }
        if (annotations2 == null) {
            $$$reportNull$$$0(4);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(5);
        }
        return new EnumEntrySyntheticClassDescriptor(storageManager, classDescriptor, classDescriptor.getDefaultType(), name, notNullLazyValue, annotations2, sourceElement);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private EnumEntrySyntheticClassDescriptor(StorageManager storageManager, ClassDescriptor classDescriptor, KotlinType kotlinType, Name name, NotNullLazyValue<Set<Name>> notNullLazyValue, Annotations annotations2, SourceElement sourceElement) {
        super(storageManager, classDescriptor, name, sourceElement, false);
        if (storageManager == null) {
            $$$reportNull$$$0(6);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(7);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(8);
        }
        if (name == null) {
            $$$reportNull$$$0(9);
        }
        if (notNullLazyValue == null) {
            $$$reportNull$$$0(10);
        }
        if (annotations2 == null) {
            $$$reportNull$$$0(11);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(12);
        }
        this.annotations = annotations2;
        this.typeConstructor = new ClassTypeConstructorImpl(this, Collections.emptyList(), Collections.singleton(kotlinType), storageManager);
        this.scope = new EnumEntryScope(this, storageManager);
        this.enumMemberNames = notNullLazyValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(13);
        }
        MemberScope memberScope = this.scope;
        if (memberScope == null) {
            $$$reportNull$$$0(14);
        }
        return memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getStaticScope() {
        MemberScope.Empty empty = MemberScope.Empty.INSTANCE;
        if (empty == null) {
            $$$reportNull$$$0(15);
        }
        return empty;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(16);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = this.typeConstructor;
        if (typeConstructor2 == null) {
            $$$reportNull$$$0(17);
        }
        return typeConstructor2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind == null) {
            $$$reportNull$$$0(18);
        }
        return classKind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Modality getModality() {
        Modality modality = Modality.FINAL;
        if (modality == null) {
            $$$reportNull$$$0(19);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Visibility getVisibility() {
        Visibility visibility = Visibilities.PUBLIC;
        if (visibility == null) {
            $$$reportNull$$$0(20);
        }
        return visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        Annotations annotations2 = this.annotations;
        if (annotations2 == null) {
            $$$reportNull$$$0(21);
        }
        return annotations2;
    }

    public String toString() {
        return "enum entry " + getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(22);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(23);
        }
        return emptyList;
    }

    /* access modifiers changed from: private */
    public class EnumEntryScope extends MemberScopeImpl {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        private final MemoizedFunctionToNotNull<Name, Collection<? extends SimpleFunctionDescriptor>> functions;
        private final MemoizedFunctionToNotNull<Name, Collection<? extends PropertyDescriptor>> properties;
        final /* synthetic */ EnumEntrySyntheticClassDescriptor this$0;

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
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
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
                            objArr[0] = SerializableCookie.NAME;
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

        public EnumEntryScope(final EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor, StorageManager storageManager) {
            if (storageManager == null) {
                $$$reportNull$$$0(0);
            }
            this.this$0 = enumEntrySyntheticClassDescriptor;
            this.functions = storageManager.createMemoizedFunction(new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>() {
                /* class kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.EnumEntryScope.AnonymousClass1 */

                public Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
                    return EnumEntryScope.this.computeFunctions(name);
                }
            });
            this.properties = storageManager.createMemoizedFunction(new Function1<Name, Collection<? extends PropertyDescriptor>>() {
                /* class kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.EnumEntryScope.AnonymousClass2 */

                public Collection<? extends PropertyDescriptor> invoke(Name name) {
                    return EnumEntryScope.this.computeProperties(name);
                }
            });
            this.allDescriptors = storageManager.createLazyValue(new Function0<Collection<DeclarationDescriptor>>() {
                /* class kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.EnumEntryScope.AnonymousClass3 */

                @Override // kotlin.jvm.functions.Function0
                public Collection<DeclarationDescriptor> invoke() {
                    return EnumEntryScope.this.computeAllDeclarations();
                }
            });
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl
        public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(1);
            }
            if (lookupLocation == null) {
                $$$reportNull$$$0(2);
            }
            Collection<? extends PropertyDescriptor> invoke = this.properties.invoke(name);
            if (invoke == null) {
                $$$reportNull$$$0(3);
            }
            return invoke;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private Collection<? extends PropertyDescriptor> computeProperties(Name name) {
            if (name == null) {
                $$$reportNull$$$0(4);
            }
            return resolveFakeOverrides(name, getSupertypeScope().getContributedVariables(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(5);
            }
            if (lookupLocation == null) {
                $$$reportNull$$$0(6);
            }
            Collection<? extends SimpleFunctionDescriptor> invoke = this.functions.invoke(name);
            if (invoke == null) {
                $$$reportNull$$$0(7);
            }
            return invoke;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private Collection<? extends SimpleFunctionDescriptor> computeFunctions(Name name) {
            if (name == null) {
                $$$reportNull$$$0(8);
            }
            return resolveFakeOverrides(name, getSupertypeScope().getContributedFunctions(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        private MemberScope getSupertypeScope() {
            MemberScope memberScope = this.this$0.getTypeConstructor().getSupertypes().iterator().next().getMemberScope();
            if (memberScope == null) {
                $$$reportNull$$$0(9);
            }
            return memberScope;
        }

        private <D extends CallableMemberDescriptor> Collection<? extends D> resolveFakeOverrides(Name name, Collection<? extends D> collection) {
            if (name == null) {
                $$$reportNull$$$0(10);
            }
            if (collection == null) {
                $$$reportNull$$$0(11);
            }
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            OverridingUtil.DEFAULT.generateOverridesInFunctionGroup(name, collection, Collections.emptySet(), this.this$0, new NonReportingOverrideStrategy() {
                /* class kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.EnumEntryScope.AnonymousClass4 */

                private static /* synthetic */ void $$$reportNull$$$0(int i) {
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

                /* access modifiers changed from: protected */
                @Override // kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
                public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                    if (callableMemberDescriptor == null) {
                        $$$reportNull$$$0(1);
                    }
                    if (callableMemberDescriptor2 == null) {
                        $$$reportNull$$$0(2);
                    }
                }

                @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
                public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
                    if (callableMemberDescriptor == null) {
                        $$$reportNull$$$0(0);
                    }
                    OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
                    linkedHashSet.add(callableMemberDescriptor);
                }
            });
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                $$$reportNull$$$0(13);
            }
            if (function1 == null) {
                $$$reportNull$$$0(14);
            }
            Collection<DeclarationDescriptor> collection = (Collection) this.allDescriptors.invoke();
            if (collection == null) {
                $$$reportNull$$$0(15);
            }
            return collection;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private Collection<DeclarationDescriptor> computeAllDeclarations() {
            HashSet hashSet = new HashSet();
            for (Name name : (Set) this.this$0.enumMemberNames.invoke()) {
                hashSet.addAll(getContributedFunctions(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
                hashSet.addAll(getContributedVariables(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
            }
            return hashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl
        public Set<Name> getFunctionNames() {
            Set<Name> set = (Set) this.this$0.enumMemberNames.invoke();
            if (set == null) {
                $$$reportNull$$$0(17);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl
        public Set<Name> getVariableNames() {
            Set<Name> set = (Set) this.this$0.enumMemberNames.invoke();
            if (set == null) {
                $$$reportNull$$$0(19);
            }
            return set;
        }
    }
}
