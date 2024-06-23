package tb;

import cn.damai.common.app.ShareperfenceConstants;
import com.youku.live.dago.liveplayback.ApiConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class p31 {
    @NotNull
    public static final h60 PACKAGE_VISIBILITY;
    @NotNull
    public static final h60 PROTECTED_AND_PACKAGE;
    @NotNull
    public static final h60 PROTECTED_STATIC_VISIBILITY;
    @NotNull
    private static final Map<qw2, h60> a = new HashMap();

    /* compiled from: Taobao */
    static class a extends o50 {
        a(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // tb.h60
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            return p31.d(declarationDescriptorWithVisibility, declarationDescriptor);
        }
    }

    /* compiled from: Taobao */
    static class b extends o50 {
        b(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // tb.h60
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            return p31.e(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
        }
    }

    /* compiled from: Taobao */
    static class c extends o50 {
        c(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // tb.h60
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            return p31.e(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
        }
    }

    static {
        a aVar = new a(c41.INSTANCE);
        PACKAGE_VISIBILITY = aVar;
        b bVar = new b(e41.INSTANCE);
        PROTECTED_STATIC_VISIBILITY = bVar;
        c cVar = new c(d41.INSTANCE);
        PROTECTED_AND_PACKAGE = cVar;
        f(aVar);
        f(bVar);
        f(cVar);
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 5 || i == 6) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = ShareperfenceConstants.FIRST;
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = ApiConstants.EventParams.WHAT;
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (!(i == 5 || i == 6)) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String format = String.format(str, objArr);
        if (i == 5 || i == 6) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    /* access modifiers changed from: private */
    public static boolean d(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            a(2);
        }
        if (declarationDescriptor2 == null) {
            a(3);
        }
        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) f60.r(declarationDescriptor, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) f60.r(declarationDescriptor2, PackageFragmentDescriptor.class, false);
        if (packageFragmentDescriptor2 == null || packageFragmentDescriptor == null || !packageFragmentDescriptor.getFqName().equals(packageFragmentDescriptor2.getFqName())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            a(0);
        }
        if (declarationDescriptor == null) {
            a(1);
        }
        if (d(f60.M(declarationDescriptorWithVisibility), declarationDescriptor)) {
            return true;
        }
        return g60.PROTECTED.e(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
    }

    private static void f(h60 h60) {
        a.put(h60.b(), h60);
    }

    @NotNull
    public static h60 g(@NotNull qw2 qw2) {
        if (qw2 == null) {
            a(4);
        }
        h60 h60 = a.get(qw2);
        if (h60 != null) {
            return h60;
        }
        h60 j = g60.j(qw2);
        if (j == null) {
            a(5);
        }
        return j;
    }
}
