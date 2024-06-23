package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

public class JavaVisibilities {
    public static final Visibility PACKAGE_VISIBILITY = new Visibility("package", false) {
        /* class kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities.AnonymousClass1 */

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 3 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 3 || i == 5) ? 2 : 3)];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        objArr[0] = "classDescriptor";
                    } else if (i != 5) {
                        objArr[0] = "what";
                    }
                }
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1";
            } else {
                objArr[0] = "visibility";
            }
            if (i == 3) {
                objArr[1] = "normalize";
            } else if (i != 5) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1";
            } else {
                objArr[1] = "effectiveVisibility";
            }
            if (i == 2) {
                objArr[2] = "compareTo";
            } else if (i != 3) {
                if (i == 4) {
                    objArr[2] = "effectiveVisibility";
                } else if (i != 5) {
                    objArr[2] = "isVisible";
                }
            }
            String format = String.format(str, objArr);
            if (i == 3 || i == 5) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "public/*package*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            return JavaVisibilities.areInSamePackage(declarationDescriptorWithVisibility, declarationDescriptor);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Integer compareTo(Visibility visibility) {
            if (visibility == null) {
                $$$reportNull$$$0(2);
            }
            if (this == visibility) {
                return 0;
            }
            if (Visibilities.isPrivate(visibility)) {
                return 1;
            }
            return -1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Visibility normalize() {
            Visibility visibility = Visibilities.PROTECTED;
            if (visibility == null) {
                $$$reportNull$$$0(3);
            }
            return visibility;
        }
    };
    public static final Visibility PROTECTED_AND_PACKAGE = new Visibility("protected_and_package", true) {
        /* class kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities.AnonymousClass3 */

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 3 ? 3 : 2)];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i == 2) {
                objArr[0] = "visibility";
            } else if (i != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3";
            } else {
                objArr[1] = "normalize";
            }
            if (i == 2) {
                objArr[2] = "compareTo";
            } else if (i != 3) {
                objArr[2] = "isVisible";
            }
            String format = String.format(str, objArr);
            if (i != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "protected/*protected and package*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            return JavaVisibilities.isVisibleForProtectedAndPackage(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Integer compareTo(Visibility visibility) {
            if (visibility == null) {
                $$$reportNull$$$0(2);
            }
            if (this == visibility) {
                return 0;
            }
            if (visibility == Visibilities.INTERNAL) {
                return null;
            }
            if (Visibilities.isPrivate(visibility)) {
                return 1;
            }
            return -1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Visibility normalize() {
            Visibility visibility = Visibilities.PROTECTED;
            if (visibility == null) {
                $$$reportNull$$$0(3);
            }
            return visibility;
        }
    };
    public static final Visibility PROTECTED_STATIC_VISIBILITY = new Visibility("protected_static", true) {
        /* class kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities.AnonymousClass2 */

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 2 ? 3 : 2)];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i != 2) {
                objArr[0] = "what";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2";
            } else {
                objArr[1] = "normalize";
            }
            if (i != 2) {
                objArr[2] = "isVisible";
            }
            String format = String.format(str, objArr);
            if (i != 2) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "protected/*protected static*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            return JavaVisibilities.isVisibleForProtectedAndPackage(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Visibility normalize() {
            Visibility visibility = Visibilities.PROTECTED;
            if (visibility == null) {
                $$$reportNull$$$0(2);
            }
            return visibility;
        }
    };

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "from";
        } else if (i == 2) {
            objArr[0] = "first";
        } else if (i != 3) {
            objArr[0] = "what";
        } else {
            objArr[0] = "second";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities";
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* access modifiers changed from: private */
    public static boolean isVisibleForProtectedAndPackage(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(0);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(1);
        }
        if (areInSamePackage(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility), declarationDescriptor)) {
            return true;
        }
        return Visibilities.PROTECTED.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
    }

    /* access modifiers changed from: private */
    public static boolean areInSamePackage(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(2);
        }
        if (declarationDescriptor2 == null) {
            $$$reportNull$$$0(3);
        }
        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor2, PackageFragmentDescriptor.class, false);
        if (packageFragmentDescriptor2 == null || packageFragmentDescriptor == null || !packageFragmentDescriptor.getFqName().equals(packageFragmentDescriptor2.getFqName())) {
            return false;
        }
        return true;
    }
}
