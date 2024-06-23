package kotlin.reflect.jvm.internal.impl.descriptors;

import androidx.core.os.EnvironmentCompat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

public class Visibilities {
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER = new ReceiverValue() {
        /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass11 */

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    public static final Visibility DEFAULT_VISIBILITY;
    @Deprecated
    public static final ReceiverValue FALSE_IF_PROTECTED = new ReceiverValue() {
        /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass12 */

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    public static final Visibility INHERITED = new Visibility("inherited", false) {
        /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass7 */

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    };
    public static final Visibility INTERNAL;
    public static final Visibility INVISIBLE_FAKE = new Visibility("invisible_fake", false) {
        /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass8 */

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            return false;
        }
    };
    public static final Set<Visibility> INVISIBLE_FROM_OTHER_MODULES;
    private static final ReceiverValue IRRELEVANT_RECEIVER = new ReceiverValue() {
        /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass10 */

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    public static final Visibility LOCAL;
    private static final ModuleVisibilityHelper MODULE_VISIBILITY_HELPER;
    private static final Map<Visibility, Integer> ORDERED_VISIBILITIES;
    public static final Visibility PRIVATE;
    public static final Visibility PRIVATE_TO_THIS;
    public static final Visibility PROTECTED;
    public static final Visibility PUBLIC;
    public static final Visibility UNKNOWN = new Visibility(EnvironmentCompat.MEDIA_UNKNOWN, false) {
        /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass9 */

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            return false;
        }
    };

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (!(i == 1 || i == 3 || i == 5 || i == 7)) {
            switch (i) {
                case 9:
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = "second";
                    break;
                case 14:
                    objArr[0] = "visibility";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities";
            switch (i) {
                case 2:
                case 3:
                    objArr[2] = "isVisibleIgnoringReceiver";
                    break;
                case 4:
                case 5:
                    objArr[2] = "isVisibleWithAnyReceiver";
                    break;
                case 6:
                case 7:
                    objArr[2] = "inSameFile";
                    break;
                case 8:
                case 9:
                    objArr[2] = "findInvisibleMember";
                    break;
                case 10:
                case 11:
                    objArr[2] = "compareLocal";
                    break;
                case 12:
                case 13:
                    objArr[2] = "compare";
                    break;
                case 14:
                    objArr[2] = "isPrivate";
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
        objArr[0] = "from";
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities";
        switch (i) {
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    static {
        AnonymousClass1 r0 = new Visibility("private", false) {
            /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass1 */

            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i == 1) {
                    objArr[0] = "what";
                } else if (i != 2) {
                    objArr[0] = "descriptor";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1";
                if (i == 1 || i == 2) {
                    objArr[2] = "isVisible";
                } else {
                    objArr[2] = "hasContainingSourceFile";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            private boolean hasContainingSourceFile(DeclarationDescriptor declarationDescriptor) {
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(0);
                }
                return DescriptorUtils.getContainingSourceFile(declarationDescriptor) != SourceFile.NO_SOURCE_FILE;
            }

            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0049 */
            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x005d */
            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility */
            /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor */
            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor */
            /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
            public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
                if (declarationDescriptorWithVisibility == 0) {
                    $$$reportNull$$$0(1);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(2);
                }
                if (DescriptorUtils.isTopLevelDeclaration(declarationDescriptorWithVisibility) && hasContainingSourceFile(declarationDescriptor)) {
                    return Visibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor);
                }
                if (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) {
                    ClassifierDescriptorWithTypeParameters containingDeclaration = ((ConstructorDescriptor) declarationDescriptorWithVisibility).getContainingDeclaration();
                    if (DescriptorUtils.isSealedClass(containingDeclaration) && DescriptorUtils.isTopLevelDeclaration(containingDeclaration) && (declarationDescriptor instanceof ConstructorDescriptor) && DescriptorUtils.isTopLevelDeclaration(declarationDescriptor.getContainingDeclaration()) && Visibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor)) {
                        return true;
                    }
                }
                while (declarationDescriptorWithVisibility != 0) {
                    declarationDescriptorWithVisibility = declarationDescriptorWithVisibility.getContainingDeclaration();
                    if (declarationDescriptorWithVisibility instanceof ClassDescriptor) {
                        if (!DescriptorUtils.isCompanionObject(declarationDescriptorWithVisibility)) {
                            break;
                        }
                    }
                    if (declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor) {
                        break;
                    }
                }
                if (declarationDescriptorWithVisibility == 0) {
                    return false;
                }
                while (declarationDescriptor != null) {
                    if (declarationDescriptorWithVisibility == declarationDescriptor) {
                        return true;
                    }
                    if (!(declarationDescriptor instanceof PackageFragmentDescriptor)) {
                        declarationDescriptor = declarationDescriptor.getContainingDeclaration();
                    } else if (!(declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor) || !((PackageFragmentDescriptor) declarationDescriptorWithVisibility).getFqName().equals(((PackageFragmentDescriptor) declarationDescriptor).getFqName()) || !DescriptorUtils.areInSameModule(declarationDescriptor, declarationDescriptorWithVisibility)) {
                        return false;
                    } else {
                        return true;
                    }
                }
                return false;
            }
        };
        PRIVATE = r0;
        AnonymousClass2 r1 = new Visibility("private_to_this", false) {
            /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass2 */

            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$2";
                objArr[2] = "isVisible";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
            public String getInternalDisplayName() {
                return "private/*private to this*/";
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
            public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
                DeclarationDescriptor parentOfType;
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                if (Visibilities.PRIVATE.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor)) {
                    if (receiverValue == Visibilities.ALWAYS_SUITABLE_RECEIVER) {
                        return true;
                    }
                    if (!(receiverValue == Visibilities.IRRELEVANT_RECEIVER || (parentOfType = DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, ClassDescriptor.class)) == null || !(receiverValue instanceof ThisClassReceiver))) {
                        return ((ThisClassReceiver) receiverValue).getClassDescriptor().getOriginal().equals(parentOfType.getOriginal());
                    }
                }
                return false;
            }
        };
        PRIVATE_TO_THIS = r1;
        AnonymousClass3 r4 = new Visibility("protected", true) {
            /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass3 */

            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i == 1) {
                    objArr[0] = "from";
                } else if (i == 2) {
                    objArr[0] = "whatDeclaration";
                } else if (i != 3) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "fromClass";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$3";
                if (i == 2 || i == 3) {
                    objArr[2] = "doesReceiverFitForProtectedVisibility";
                } else {
                    objArr[2] = "isVisible";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
            public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
                ClassDescriptor classDescriptor;
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                ClassDescriptor classDescriptor2 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, ClassDescriptor.class);
                ClassDescriptor classDescriptor3 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor, ClassDescriptor.class, false);
                if (classDescriptor3 == null) {
                    return false;
                }
                if (classDescriptor2 != null && DescriptorUtils.isCompanionObject(classDescriptor2) && (classDescriptor = (ClassDescriptor) DescriptorUtils.getParentOfType(classDescriptor2, ClassDescriptor.class)) != null && DescriptorUtils.isSubclass(classDescriptor3, classDescriptor)) {
                    return true;
                }
                DeclarationDescriptorWithVisibility unwrapFakeOverrideToAnyDeclaration = DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility);
                ClassDescriptor classDescriptor4 = (ClassDescriptor) DescriptorUtils.getParentOfType(unwrapFakeOverrideToAnyDeclaration, ClassDescriptor.class);
                if (classDescriptor4 == null) {
                    return false;
                }
                if (!DescriptorUtils.isSubclass(classDescriptor3, classDescriptor4) || !doesReceiverFitForProtectedVisibility(receiverValue, unwrapFakeOverrideToAnyDeclaration, classDescriptor3)) {
                    return isVisible(receiverValue, declarationDescriptorWithVisibility, classDescriptor3.getContainingDeclaration());
                }
                return true;
            }

            private boolean doesReceiverFitForProtectedVisibility(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, ClassDescriptor classDescriptor) {
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(2);
                }
                if (classDescriptor == null) {
                    $$$reportNull$$$0(3);
                }
                if (receiverValue == Visibilities.FALSE_IF_PROTECTED) {
                    return false;
                }
                if (!(declarationDescriptorWithVisibility instanceof CallableMemberDescriptor) || (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) || receiverValue == Visibilities.ALWAYS_SUITABLE_RECEIVER) {
                    return true;
                }
                if (receiverValue == Visibilities.IRRELEVANT_RECEIVER || receiverValue == null) {
                    return false;
                }
                KotlinType thisType = receiverValue instanceof SuperCallReceiverValue ? ((SuperCallReceiverValue) receiverValue).getThisType() : receiverValue.getType();
                if (DescriptorUtils.isSubtypeOfClass(thisType, classDescriptor) || DynamicTypesKt.isDynamic(thisType)) {
                    return true;
                }
                return false;
            }
        };
        PROTECTED = r4;
        AnonymousClass4 r5 = new Visibility("internal", false) {
            /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass4 */

            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$4";
                objArr[2] = "isVisible";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
            public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                if (!DescriptorUtils.getContainingModule(declarationDescriptor).shouldSeeInternalsOf(DescriptorUtils.getContainingModule(declarationDescriptorWithVisibility))) {
                    return false;
                }
                return Visibilities.MODULE_VISIBILITY_HELPER.isInFriendModule(declarationDescriptorWithVisibility, declarationDescriptor);
            }
        };
        INTERNAL = r5;
        AnonymousClass5 r8 = new Visibility("public", true) {
            /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass5 */

            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$5";
                objArr[2] = "isVisible";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
            public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                return true;
            }
        };
        PUBLIC = r8;
        AnonymousClass6 r9 = new Visibility("local", false) {
            /* class kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.AnonymousClass6 */

            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$6";
                objArr[2] = "isVisible";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
            public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            }
        };
        LOCAL = r9;
        INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(SetsKt.setOf((Object[]) new Visibility[]{r0, r1, r5, r9}));
        HashMap newHashMapWithExpectedSize = CollectionsKt.newHashMapWithExpectedSize(4);
        newHashMapWithExpectedSize.put(r1, 0);
        newHashMapWithExpectedSize.put(r0, 0);
        newHashMapWithExpectedSize.put(r5, 1);
        newHashMapWithExpectedSize.put(r4, 1);
        newHashMapWithExpectedSize.put(r8, 2);
        ORDERED_VISIBILITIES = Collections.unmodifiableMap(newHashMapWithExpectedSize);
        DEFAULT_VISIBILITY = r8;
        Iterator it = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        MODULE_VISIBILITY_HELPER = it.hasNext() ? (ModuleVisibilityHelper) it.next() : ModuleVisibilityHelper.EMPTY.INSTANCE;
    }

    public static boolean isVisibleIgnoringReceiver(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(2);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(3);
        }
        return findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, declarationDescriptorWithVisibility, declarationDescriptor) == null;
    }

    public static boolean inSameFile(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(6);
        }
        if (declarationDescriptor2 == null) {
            $$$reportNull$$$0(7);
        }
        SourceFile containingSourceFile = DescriptorUtils.getContainingSourceFile(declarationDescriptor2);
        if (containingSourceFile != SourceFile.NO_SOURCE_FILE) {
            return containingSourceFile.equals(DescriptorUtils.getContainingSourceFile(declarationDescriptor));
        }
        return false;
    }

    public static DeclarationDescriptorWithVisibility findInvisibleMember(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptorWithVisibility findInvisibleMember;
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(8);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(9);
        }
        DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) declarationDescriptorWithVisibility.getOriginal();
        while (declarationDescriptorWithVisibility2 != null && declarationDescriptorWithVisibility2.getVisibility() != LOCAL) {
            if (!declarationDescriptorWithVisibility2.getVisibility().isVisible(receiverValue, declarationDescriptorWithVisibility2, declarationDescriptor)) {
                return declarationDescriptorWithVisibility2;
            }
            declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility2, DeclarationDescriptorWithVisibility.class);
        }
        if (!(declarationDescriptorWithVisibility instanceof TypeAliasConstructorDescriptor) || (findInvisibleMember = findInvisibleMember(receiverValue, ((TypeAliasConstructorDescriptor) declarationDescriptorWithVisibility).getUnderlyingConstructorDescriptor(), declarationDescriptor)) == null) {
            return null;
        }
        return findInvisibleMember;
    }

    static Integer compareLocal(Visibility visibility, Visibility visibility2) {
        if (visibility == null) {
            $$$reportNull$$$0(10);
        }
        if (visibility2 == null) {
            $$$reportNull$$$0(11);
        }
        if (visibility == visibility2) {
            return 0;
        }
        Map<Visibility, Integer> map = ORDERED_VISIBILITIES;
        Integer num = map.get(visibility);
        Integer num2 = map.get(visibility2);
        if (num == null || num2 == null || num.equals(num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public static Integer compare(Visibility visibility, Visibility visibility2) {
        if (visibility == null) {
            $$$reportNull$$$0(12);
        }
        if (visibility2 == null) {
            $$$reportNull$$$0(13);
        }
        Integer compareTo = visibility.compareTo(visibility2);
        if (compareTo != null) {
            return compareTo;
        }
        Integer compareTo2 = visibility2.compareTo(visibility);
        if (compareTo2 != null) {
            return Integer.valueOf(-compareTo2.intValue());
        }
        return null;
    }

    public static boolean isPrivate(Visibility visibility) {
        if (visibility == null) {
            $$$reportNull$$$0(14);
        }
        return visibility == PRIVATE || visibility == PRIVATE_TO_THIS;
    }
}
