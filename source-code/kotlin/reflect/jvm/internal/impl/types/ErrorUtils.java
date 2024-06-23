package kotlin.reflect.jvm.internal.impl.types;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorSimpleFunctionDescriptorImpl;

public class ErrorUtils {
    private static final ErrorClassDescriptor ERROR_CLASS = new ErrorClassDescriptor(Name.special("<ERROR CLASS>"));
    private static final ModuleDescriptor ERROR_MODULE = new ModuleDescriptor() {
        /* class kotlin.reflect.jvm.internal.impl.types.ErrorUtils.AnonymousClass1 */

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 1 || i == 4 || i == 5 || i == 6 || i == 8 || i == 9 || i == 12 || i == 13) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 1 || i == 4 || i == 5 || i == 6 || i == 8 || i == 9 || i == 12 || i == 13) ? 2 : 3)];
            switch (i) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 12:
                case 13:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                    break;
                case 2:
                case 7:
                    objArr[0] = "fqName";
                    break;
                case 3:
                    objArr[0] = "nameFilter";
                    break;
                case 10:
                    objArr[0] = "visitor";
                    break;
                case 11:
                    objArr[0] = "targetModule";
                    break;
                default:
                    objArr[0] = "capability";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getAnnotations";
            } else if (i == 4) {
                objArr[1] = "getSubPackagesOf";
            } else if (i == 5) {
                objArr[1] = "getName";
            } else if (i == 6) {
                objArr[1] = "getStableName";
            } else if (i == 8) {
                objArr[1] = "getAllDependencyModules";
            } else if (i == 9) {
                objArr[1] = "getExpectedByModules";
            } else if (i == 12) {
                objArr[1] = "getOriginal";
            } else if (i != 13) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
            } else {
                objArr[1] = "getBuiltIns";
            }
            switch (i) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 12:
                case 13:
                    break;
                case 2:
                case 3:
                    objArr[2] = "getSubPackagesOf";
                    break;
                case 7:
                    objArr[2] = "getPackage";
                    break;
                case 10:
                    objArr[2] = "accept";
                    break;
                case 11:
                    objArr[2] = "shouldSeeInternalsOf";
                    break;
                default:
                    objArr[2] = "getCapability";
                    break;
            }
            String format = String.format(str, objArr);
            if (i == 1 || i == 4 || i == 5 || i == 6 || i == 8 || i == 9 || i == 12 || i == 13) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            if (declarationDescriptorVisitor != null) {
                return null;
            }
            $$$reportNull$$$0(10);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        public <T> T getCapability(ModuleDescriptor.Capability<T> capability) {
            if (capability != null) {
                return null;
            }
            $$$reportNull$$$0(0);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        public DeclarationDescriptor getContainingDeclaration() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        public DeclarationDescriptor getOriginal() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        public boolean shouldSeeInternalsOf(ModuleDescriptor moduleDescriptor) {
            if (moduleDescriptor != null) {
                return false;
            }
            $$$reportNull$$$0(11);
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        public Annotations getAnnotations() {
            Annotations empty = Annotations.Companion.getEMPTY();
            if (empty == null) {
                $$$reportNull$$$0(1);
            }
            return empty;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
            if (fqName == null) {
                $$$reportNull$$$0(2);
            }
            if (function1 == null) {
                $$$reportNull$$$0(3);
            }
            List emptyList = CollectionsKt.emptyList();
            if (emptyList == null) {
                $$$reportNull$$$0(4);
            }
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
        public Name getName() {
            Name special = Name.special("<ERROR MODULE>");
            if (special == null) {
                $$$reportNull$$$0(5);
            }
            return special;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        public PackageViewDescriptor getPackage(FqName fqName) {
            if (fqName == null) {
                $$$reportNull$$$0(7);
            }
            throw new IllegalStateException("Should not be called!");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        public List<ModuleDescriptor> getExpectedByModules() {
            List<ModuleDescriptor> emptyList = CollectionsKt.emptyList();
            if (emptyList == null) {
                $$$reportNull$$$0(9);
            }
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        public KotlinBuiltIns getBuiltIns() {
            DefaultBuiltIns instance = DefaultBuiltIns.getInstance();
            if (instance == null) {
                $$$reportNull$$$0(13);
            }
            return instance;
        }
    };
    private static final PropertyDescriptor ERROR_PROPERTY;
    private static final Set<PropertyDescriptor> ERROR_PROPERTY_GROUP;
    private static final KotlinType ERROR_PROPERTY_TYPE = createErrorType("<ERROR PROPERTY TYPE>");
    public static final SimpleType ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES = createErrorType("<LOOP IN SUPERTYPES>");

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 4 || i == 6 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 6 || i == 19) ? 2 : 3)];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        if (i == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 4 || i == 6 || i == 19) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    static {
        PropertyDescriptorImpl createErrorProperty = createErrorProperty();
        ERROR_PROPERTY = createErrorProperty;
        ERROR_PROPERTY_GROUP = Collections.singleton(createErrorProperty);
    }

    public static class ErrorScope implements MemberScope {
        private final String debugMessage;

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0087  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x009e  */
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            if (!(i == 7 || i == 18)) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
                if (!(i == 7 || i == 18)) {
                    switch (i) {
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            i2 = 3;
                            break;
                    }
                    Object[] objArr = new Object[i2];
                    switch (i) {
                        case 1:
                        case 3:
                        case 5:
                        case 8:
                        case 14:
                        case 19:
                            objArr[0] = SerializableCookie.NAME;
                            break;
                        case 2:
                        case 4:
                        case 6:
                        case 9:
                        case 15:
                            objArr[0] = "location";
                            break;
                        case 7:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 18:
                            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                            break;
                        case 16:
                            objArr[0] = "kindFilter";
                            break;
                        case 17:
                            objArr[0] = "nameFilter";
                            break;
                        case 20:
                            objArr[0] = "p";
                            break;
                        default:
                            objArr[0] = "debugMessage";
                            break;
                    }
                    if (i == 7) {
                        objArr[1] = "getContributedVariables";
                    } else if (i != 18) {
                        switch (i) {
                            case 10:
                                objArr[1] = "getContributedFunctions";
                                break;
                            case 11:
                                objArr[1] = "getFunctionNames";
                                break;
                            case 12:
                                objArr[1] = "getVariableNames";
                                break;
                            case 13:
                                objArr[1] = "getClassifierNames";
                                break;
                            default:
                                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                                break;
                        }
                    } else {
                        objArr[1] = "getContributedDescriptors";
                    }
                    switch (i) {
                        case 1:
                        case 2:
                            objArr[2] = "getContributedClassifier";
                            break;
                        case 3:
                        case 4:
                            objArr[2] = "getContributedClassifierIncludeDeprecated";
                            break;
                        case 5:
                        case 6:
                            objArr[2] = "getContributedVariables";
                            break;
                        case 7:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 18:
                            break;
                        case 8:
                        case 9:
                            objArr[2] = "getContributedFunctions";
                            break;
                        case 14:
                        case 15:
                            objArr[2] = "recordLookup";
                            break;
                        case 16:
                        case 17:
                            objArr[2] = "getContributedDescriptors";
                            break;
                        case 19:
                            objArr[2] = "definitelyDoesNotContainName";
                            break;
                        case 20:
                            objArr[2] = "printScopeStructure";
                            break;
                        default:
                            objArr[2] = "<init>";
                            break;
                    }
                    String format = String.format(str, objArr);
                    if (!(i == 7 || i == 18)) {
                        switch (i) {
                            case 10:
                            case 11:
                            case 12:
                            case 13:
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
                if (i == 7) {
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
                case 10:
                case 11:
                case 12:
                case 13:
                    i2 = 2;
                    break;
            }
            Object[] objArr22 = new Object[i2];
            switch (i) {
            }
            if (i == 7) {
            }
            switch (i) {
            }
            String format22 = String.format(str, objArr22);
            switch (i) {
            }
            throw new IllegalStateException(format22);
        }

        private ErrorScope(String str) {
            if (str == null) {
                $$$reportNull$$$0(0);
            }
            this.debugMessage = str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(1);
            }
            if (lookupLocation == null) {
                $$$reportNull$$$0(2);
            }
            return ErrorUtils.createErrorClass(name.asString());
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(5);
            }
            if (lookupLocation == null) {
                $$$reportNull$$$0(6);
            }
            Set<? extends PropertyDescriptor> set = ErrorUtils.ERROR_PROPERTY_GROUP;
            if (set == null) {
                $$$reportNull$$$0(7);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Set<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(8);
            }
            if (lookupLocation == null) {
                $$$reportNull$$$0(9);
            }
            Set<? extends SimpleFunctionDescriptor> singleton = Collections.singleton(ErrorUtils.createErrorFunction(this));
            if (singleton == null) {
                $$$reportNull$$$0(10);
            }
            return singleton;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getFunctionNames() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet == null) {
                $$$reportNull$$$0(11);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getVariableNames() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet == null) {
                $$$reportNull$$$0(12);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                $$$reportNull$$$0(16);
            }
            if (function1 == null) {
                $$$reportNull$$$0(17);
            }
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                $$$reportNull$$$0(18);
            }
            return emptyList;
        }

        public String toString() {
            return "ErrorScope{" + this.debugMessage + '}';
        }
    }

    /* access modifiers changed from: private */
    public static class ThrowingScope implements MemberScope {
        private final String debugMessage;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = SerializableCookie.NAME;
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = "location";
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private ThrowingScope(String str) {
            if (str == null) {
                $$$reportNull$$$0(0);
            }
            this.debugMessage = str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(1);
            }
            if (lookupLocation == null) {
                $$$reportNull$$$0(2);
            }
            throw new IllegalStateException(this.debugMessage + ", required name: " + name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(5);
            }
            if (lookupLocation == null) {
                $$$reportNull$$$0(6);
            }
            throw new IllegalStateException(this.debugMessage + ", required name: " + name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(7);
            }
            if (lookupLocation == null) {
                $$$reportNull$$$0(8);
            }
            throw new IllegalStateException(this.debugMessage + ", required name: " + name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                $$$reportNull$$$0(9);
            }
            if (function1 == null) {
                $$$reportNull$$$0(10);
            }
            throw new IllegalStateException(this.debugMessage);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getFunctionNames() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getVariableNames() {
            throw new IllegalStateException();
        }

        public String toString() {
            return "ThrowingScope{" + this.debugMessage + '}';
        }
    }

    /* access modifiers changed from: private */
    public static class ErrorClassDescriptor extends ClassDescriptorImpl {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 2 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 2 || i == 5 || i == 8) ? 2 : 3)];
            switch (i) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = SerializableCookie.NAME;
                    break;
            }
            if (i == 2) {
                objArr[1] = "substitute";
            } else if (i == 5 || i == 8) {
                objArr[1] = "getMemberScope";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            }
            switch (i) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i == 2 || i == 5 || i == 8) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
        public ClassifierDescriptorWithTypeParameters substitute(TypeSubstitutor typeSubstitutor) {
            if (typeSubstitutor == null) {
                $$$reportNull$$$0(1);
            }
            return this;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ErrorClassDescriptor(Name name) {
            super(ErrorUtils.getErrorModule(), name, Modality.OPEN, ClassKind.CLASS, Collections.emptyList(), SourceElement.NO_SOURCE, false, LockBasedStorageManager.NO_LOCKS);
            if (name == null) {
                $$$reportNull$$$0(0);
            }
            ClassConstructorDescriptorImpl create = ClassConstructorDescriptorImpl.create(this, Annotations.Companion.getEMPTY(), true, SourceElement.NO_SOURCE);
            create.initialize(Collections.emptyList(), Visibilities.INTERNAL);
            MemberScope createErrorScope = ErrorUtils.createErrorScope(getName().asString());
            create.setReturnType(new ErrorType(ErrorUtils.createErrorTypeConstructorWithCustomDebugName("<ERROR>", this), createErrorScope));
            initialize(createErrorScope, Collections.singleton(create), create);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl
        public String toString() {
            return getName().asString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
        public MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(6);
            }
            if (kotlinTypeRefiner == null) {
                $$$reportNull$$$0(7);
            }
            MemberScope createErrorScope = ErrorUtils.createErrorScope("Error scope for class " + getName() + " with arguments: " + typeSubstitution);
            if (createErrorScope == null) {
                $$$reportNull$$$0(8);
            }
            return createErrorScope;
        }
    }

    public static ClassDescriptor createErrorClass(String str) {
        if (str == null) {
            $$$reportNull$$$0(1);
        }
        return new ErrorClassDescriptor(Name.special("<ERROR CLASS: " + str + ">"));
    }

    public static MemberScope createErrorScope(String str) {
        if (str == null) {
            $$$reportNull$$$0(2);
        }
        return createErrorScope(str, false);
    }

    public static MemberScope createErrorScope(String str, boolean z) {
        if (str == null) {
            $$$reportNull$$$0(3);
        }
        if (z) {
            return new ThrowingScope(str);
        }
        return new ErrorScope(str);
    }

    private static PropertyDescriptorImpl createErrorProperty() {
        PropertyDescriptorImpl create = PropertyDescriptorImpl.create(ERROR_CLASS, Annotations.Companion.getEMPTY(), Modality.OPEN, Visibilities.PUBLIC, true, Name.special("<ERROR PROPERTY>"), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE, false, false, false, false, false, false);
        create.setType(ERROR_PROPERTY_TYPE, Collections.emptyList(), null, null);
        if (create == null) {
            $$$reportNull$$$0(4);
        }
        return create;
    }

    /* access modifiers changed from: private */
    public static SimpleFunctionDescriptor createErrorFunction(ErrorScope errorScope) {
        if (errorScope == null) {
            $$$reportNull$$$0(5);
        }
        ErrorSimpleFunctionDescriptorImpl errorSimpleFunctionDescriptorImpl = new ErrorSimpleFunctionDescriptorImpl(ERROR_CLASS, errorScope);
        errorSimpleFunctionDescriptorImpl.initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.emptyList(), (KotlinType) createErrorType("<ERROR FUNCTION RETURN TYPE>"), Modality.OPEN, Visibilities.PUBLIC);
        return errorSimpleFunctionDescriptorImpl;
    }

    public static SimpleType createErrorType(String str) {
        if (str == null) {
            $$$reportNull$$$0(7);
        }
        return createErrorTypeWithArguments(str, Collections.emptyList());
    }

    public static SimpleType createErrorTypeWithCustomDebugName(String str) {
        if (str == null) {
            $$$reportNull$$$0(8);
        }
        return createErrorTypeWithCustomConstructor(str, createErrorTypeConstructorWithCustomDebugName(str));
    }

    public static SimpleType createErrorTypeWithCustomConstructor(String str, TypeConstructor typeConstructor) {
        if (str == null) {
            $$$reportNull$$$0(9);
        }
        if (typeConstructor == null) {
            $$$reportNull$$$0(10);
        }
        return new ErrorType(typeConstructor, createErrorScope(str));
    }

    public static SimpleType createErrorTypeWithArguments(String str, List<TypeProjection> list) {
        if (str == null) {
            $$$reportNull$$$0(11);
        }
        if (list == null) {
            $$$reportNull$$$0(12);
        }
        return new ErrorType(createErrorTypeConstructor(str), createErrorScope(str), list, false);
    }

    public static TypeConstructor createErrorTypeConstructor(String str) {
        if (str == null) {
            $$$reportNull$$$0(15);
        }
        return createErrorTypeConstructorWithCustomDebugName("[ERROR : " + str + "]", ERROR_CLASS);
    }

    public static TypeConstructor createErrorTypeConstructorWithCustomDebugName(String str) {
        if (str == null) {
            $$$reportNull$$$0(16);
        }
        return createErrorTypeConstructorWithCustomDebugName(str, ERROR_CLASS);
    }

    /* access modifiers changed from: private */
    public static TypeConstructor createErrorTypeConstructorWithCustomDebugName(final String str, final ErrorClassDescriptor errorClassDescriptor) {
        if (str == null) {
            $$$reportNull$$$0(17);
        }
        if (errorClassDescriptor == null) {
            $$$reportNull$$$0(18);
        }
        return new TypeConstructor() {
            /* class kotlin.reflect.jvm.internal.impl.types.ErrorUtils.AnonymousClass2 */

            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                String str = i != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                Object[] objArr = new Object[(i != 3 ? 2 : 3)];
                if (i != 3) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
                } else {
                    objArr[0] = "kotlinTypeRefiner";
                }
                if (i == 1) {
                    objArr[1] = "getSupertypes";
                } else if (i == 2) {
                    objArr[1] = "getBuiltIns";
                } else if (i == 3) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
                } else if (i != 4) {
                    objArr[1] = "getParameters";
                } else {
                    objArr[1] = "refine";
                }
                if (i == 3) {
                    objArr[2] = "refine";
                }
                String format = String.format(str, objArr);
                if (i != 3) {
                    throw new IllegalStateException(format);
                }
                throw new IllegalArgumentException(format);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public boolean isDenotable() {
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
                if (kotlinTypeRefiner == null) {
                    $$$reportNull$$$0(3);
                }
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public List<TypeParameterDescriptor> getParameters() {
                List<TypeParameterDescriptor> emptyList = CollectionsKt.emptyList();
                if (emptyList == null) {
                    $$$reportNull$$$0(0);
                }
                return emptyList;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public Collection<KotlinType> getSupertypes() {
                List emptyList = CollectionsKt.emptyList();
                if (emptyList == null) {
                    $$$reportNull$$$0(1);
                }
                return emptyList;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public ClassifierDescriptor getDeclarationDescriptor() {
                return errorClassDescriptor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public KotlinBuiltIns getBuiltIns() {
                DefaultBuiltIns instance = DefaultBuiltIns.getInstance();
                if (instance == null) {
                    $$$reportNull$$$0(2);
                }
                return instance;
            }

            public String toString() {
                return str;
            }
        };
    }

    public static boolean isError(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            return false;
        }
        return isErrorClass(declarationDescriptor) || isErrorClass(declarationDescriptor.getContainingDeclaration()) || declarationDescriptor == ERROR_MODULE;
    }

    private static boolean isErrorClass(DeclarationDescriptor declarationDescriptor) {
        return declarationDescriptor instanceof ErrorClassDescriptor;
    }

    public static ModuleDescriptor getErrorModule() {
        ModuleDescriptor moduleDescriptor = ERROR_MODULE;
        if (moduleDescriptor == null) {
            $$$reportNull$$$0(19);
        }
        return moduleDescriptor;
    }

    public static boolean isUninferredParameter(KotlinType kotlinType) {
        return kotlinType != null && (kotlinType.getConstructor() instanceof UninferredParameterTypeConstructor);
    }

    public static class UninferredParameterTypeConstructor implements TypeConstructor {
        private final TypeConstructor errorTypeConstructor;
        private final TypeParameterDescriptor typeParameterDescriptor;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? 2 : 3)];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 5:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getTypeParameterDescriptor";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getSupertypes";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i != 6) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
            } else {
                objArr[1] = "refine";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    break;
                case 5:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 6) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner == null) {
                $$$reportNull$$$0(5);
            }
            return this;
        }

        public TypeParameterDescriptor getTypeParameterDescriptor() {
            TypeParameterDescriptor typeParameterDescriptor2 = this.typeParameterDescriptor;
            if (typeParameterDescriptor2 == null) {
                $$$reportNull$$$0(1);
            }
            return typeParameterDescriptor2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.errorTypeConstructor.getParameters();
            if (parameters == null) {
                $$$reportNull$$$0(2);
            }
            return parameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public Collection<KotlinType> getSupertypes() {
            Collection<KotlinType> supertypes = this.errorTypeConstructor.getSupertypes();
            if (supertypes == null) {
                $$$reportNull$$$0(3);
            }
            return supertypes;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.errorTypeConstructor.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.errorTypeConstructor.getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = DescriptorUtilsKt.getBuiltIns(this.typeParameterDescriptor);
            if (builtIns == null) {
                $$$reportNull$$$0(4);
            }
            return builtIns;
        }
    }
}
