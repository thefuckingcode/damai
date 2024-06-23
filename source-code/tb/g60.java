package tb;

import cn.damai.common.app.ShareperfenceConstants;
import com.youku.live.dago.liveplayback.ApiConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pw2;

/* compiled from: Taobao */
public class g60 {
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER = new b();
    public static final h60 DEFAULT_VISIBILITY;
    @Deprecated
    public static final ReceiverValue FALSE_IF_PROTECTED = new c();
    @NotNull
    public static final h60 INHERITED;
    @NotNull
    public static final h60 INTERNAL;
    @NotNull
    public static final h60 INVISIBLE_FAKE;
    public static final Set<h60> INVISIBLE_FROM_OTHER_MODULES;
    @NotNull
    public static final h60 LOCAL;
    @NotNull
    public static final h60 PRIVATE;
    @NotNull
    public static final h60 PRIVATE_TO_THIS;
    @NotNull
    public static final h60 PROTECTED;
    @NotNull
    public static final h60 PUBLIC;
    @NotNull
    public static final h60 UNKNOWN;
    private static final Map<h60, Integer> a;
    private static final ReceiverValue b = new a();
    @NotNull
    private static final ModuleVisibilityHelper c;
    @NotNull
    private static final Map<qw2, h60> d = new HashMap();

    /* compiled from: Taobao */
    static class a implements ReceiverValue {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        @NotNull
        public g61 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: Taobao */
    static class b implements ReceiverValue {
        b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        @NotNull
        public g61 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: Taobao */
    static class c implements ReceiverValue {
        c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        @NotNull
        public g61 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: Taobao */
    static class d extends o50 {
        d(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else if (i != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i == 1 || i == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                g(0);
            }
            return f60.j(declarationDescriptor) != SourceFile.NO_SOURCE_FILE;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0049 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x005d */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility */
        /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor */
        /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor */
        /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb.h60
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == 0) {
                g(1);
            }
            if (declarationDescriptor == null) {
                g(2);
            }
            if (f60.J(declarationDescriptorWithVisibility) && h(declarationDescriptor)) {
                return g60.f(declarationDescriptorWithVisibility, declarationDescriptor);
            }
            if (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) {
                ClassifierDescriptorWithTypeParameters containingDeclaration = ((ConstructorDescriptor) declarationDescriptorWithVisibility).getContainingDeclaration();
                if (f60.G(containingDeclaration) && f60.J(containingDeclaration) && (declarationDescriptor instanceof ConstructorDescriptor) && f60.J(declarationDescriptor.getContainingDeclaration()) && g60.f(declarationDescriptorWithVisibility, declarationDescriptor)) {
                    return true;
                }
            }
            while (declarationDescriptorWithVisibility != 0) {
                declarationDescriptorWithVisibility = declarationDescriptorWithVisibility.getContainingDeclaration();
                if (declarationDescriptorWithVisibility instanceof ClassDescriptor) {
                    if (!f60.x(declarationDescriptorWithVisibility)) {
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
                } else if (!(declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor) || !((PackageFragmentDescriptor) declarationDescriptorWithVisibility).getFqName().equals(((PackageFragmentDescriptor) declarationDescriptor).getFqName()) || !f60.b(declarationDescriptor, declarationDescriptorWithVisibility)) {
                    return false;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    static class e extends o50 {
        e(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // tb.h60
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            DeclarationDescriptor q;
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            if (g60.PRIVATE.e(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor)) {
                if (receiverValue == g60.ALWAYS_SUITABLE_RECEIVER) {
                    return true;
                }
                if (!(receiverValue == g60.b || (q = f60.q(declarationDescriptorWithVisibility, ClassDescriptor.class)) == null || !(receiverValue instanceof ThisClassReceiver))) {
                    return ((ThisClassReceiver) receiverValue).getClassDescriptor().getOriginal().equals(q.getOriginal());
                }
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    static class f extends o50 {
        f(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i != 3) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i == 2 || i == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull ClassDescriptor classDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                g(2);
            }
            if (classDescriptor == null) {
                g(3);
            }
            if (receiverValue == g60.FALSE_IF_PROTECTED) {
                return false;
            }
            if (!(declarationDescriptorWithVisibility instanceof CallableMemberDescriptor) || (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) || receiverValue == g60.ALWAYS_SUITABLE_RECEIVER) {
                return true;
            }
            if (receiverValue == g60.b || receiverValue == null) {
                return false;
            }
            g61 thisType = receiverValue instanceof SuperCallReceiverValue ? ((SuperCallReceiverValue) receiverValue).getThisType() : receiverValue.getType();
            if (f60.I(thisType, classDescriptor) || oc0.a(thisType)) {
                return true;
            }
            return false;
        }

        @Override // tb.h60
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            ClassDescriptor classDescriptor;
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            ClassDescriptor classDescriptor2 = (ClassDescriptor) f60.q(declarationDescriptorWithVisibility, ClassDescriptor.class);
            ClassDescriptor classDescriptor3 = (ClassDescriptor) f60.r(declarationDescriptor, ClassDescriptor.class, false);
            if (classDescriptor3 == null) {
                return false;
            }
            if (classDescriptor2 != null && f60.x(classDescriptor2) && (classDescriptor = (ClassDescriptor) f60.q(classDescriptor2, ClassDescriptor.class)) != null && f60.H(classDescriptor3, classDescriptor)) {
                return true;
            }
            DeclarationDescriptorWithVisibility M = f60.M(declarationDescriptorWithVisibility);
            ClassDescriptor classDescriptor4 = (ClassDescriptor) f60.q(M, ClassDescriptor.class);
            if (classDescriptor4 == null) {
                return false;
            }
            if (!f60.H(classDescriptor3, classDescriptor4) || !h(receiverValue, M, classDescriptor3)) {
                return e(receiverValue, declarationDescriptorWithVisibility, classDescriptor3.getContainingDeclaration());
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    static class g extends o50 {
        g(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
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
            if (!f60.g(declarationDescriptor).shouldSeeInternalsOf(f60.g(declarationDescriptorWithVisibility))) {
                return false;
            }
            return g60.c.isInFriendModule(declarationDescriptorWithVisibility, declarationDescriptor);
        }
    }

    /* compiled from: Taobao */
    static class h extends o50 {
        h(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
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
            return true;
        }
    }

    /* compiled from: Taobao */
    static class i extends o50 {
        i(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
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
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    /* compiled from: Taobao */
    static class j extends o50 {
        j(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
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
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    /* compiled from: Taobao */
    static class k extends o50 {
        k(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
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
            return false;
        }
    }

    /* compiled from: Taobao */
    static class l extends o50 {
        l(qw2 qw2) {
            super(qw2);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
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
            return false;
        }
    }

    static {
        d dVar = new d(pw2.e.INSTANCE);
        PRIVATE = dVar;
        e eVar = new e(pw2.f.INSTANCE);
        PRIVATE_TO_THIS = eVar;
        f fVar = new f(pw2.g.INSTANCE);
        PROTECTED = fVar;
        g gVar = new g(pw2.b.INSTANCE);
        INTERNAL = gVar;
        h hVar = new h(pw2.h.INSTANCE);
        PUBLIC = hVar;
        i iVar = new i(pw2.d.INSTANCE);
        LOCAL = iVar;
        j jVar = new j(pw2.a.INSTANCE);
        INHERITED = jVar;
        k kVar = new k(pw2.c.INSTANCE);
        INVISIBLE_FAKE = kVar;
        l lVar = new l(pw2.i.INSTANCE);
        UNKNOWN = lVar;
        INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(e0.g(dVar, eVar, gVar, iVar));
        HashMap e2 = qj.e(4);
        e2.put(eVar, 0);
        e2.put(dVar, 0);
        e2.put(gVar, 1);
        e2.put(fVar, 1);
        e2.put(hVar, 2);
        a = Collections.unmodifiableMap(e2);
        DEFAULT_VISIBILITY = hVar;
        Iterator it = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        c = it.hasNext() ? (ModuleVisibilityHelper) it.next() : ModuleVisibilityHelper.a.INSTANCE;
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0080  */
    private static /* synthetic */ void a(int i2) {
        String str = i2 != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i2 != 16 ? 3 : 2)];
        if (!(i2 == 1 || i2 == 3 || i2 == 5 || i2 == 7)) {
            switch (i2) {
                case 9:
                    break;
                case 10:
                case 12:
                    objArr[0] = ShareperfenceConstants.FIRST;
                    break;
                case 11:
                case 13:
                    objArr[0] = "second";
                    break;
                case 14:
                case 15:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = ApiConstants.EventParams.WHAT;
                    break;
            }
            if (i2 == 16) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
            } else {
                objArr[1] = "toDescriptorVisibility";
            }
            switch (i2) {
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
                case 15:
                    objArr[2] = "toDescriptorVisibility";
                    break;
                case 16:
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
            String format = String.format(str, objArr);
            if (i2 == 16) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }
        objArr[0] = "from";
        if (i2 == 16) {
        }
        switch (i2) {
        }
        String format2 = String.format(str, objArr);
        if (i2 == 16) {
        }
    }

    @Nullable
    public static Integer d(@NotNull h60 h60, @NotNull h60 h602) {
        if (h60 == null) {
            a(12);
        }
        if (h602 == null) {
            a(13);
        }
        Integer a2 = h60.a(h602);
        if (a2 != null) {
            return a2;
        }
        Integer a3 = h602.a(h60);
        if (a3 != null) {
            return Integer.valueOf(-a3.intValue());
        }
        return null;
    }

    @Nullable
    public static DeclarationDescriptorWithVisibility e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptorWithVisibility e2;
        if (declarationDescriptorWithVisibility == null) {
            a(8);
        }
        if (declarationDescriptor == null) {
            a(9);
        }
        DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) declarationDescriptorWithVisibility.getOriginal();
        while (declarationDescriptorWithVisibility2 != null && declarationDescriptorWithVisibility2.getVisibility() != LOCAL) {
            if (!declarationDescriptorWithVisibility2.getVisibility().e(receiverValue, declarationDescriptorWithVisibility2, declarationDescriptor)) {
                return declarationDescriptorWithVisibility2;
            }
            declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) f60.q(declarationDescriptorWithVisibility2, DeclarationDescriptorWithVisibility.class);
        }
        if (!(declarationDescriptorWithVisibility instanceof TypeAliasConstructorDescriptor) || (e2 = e(receiverValue, ((TypeAliasConstructorDescriptor) declarationDescriptorWithVisibility).getUnderlyingConstructorDescriptor(), declarationDescriptor)) == null) {
            return null;
        }
        return e2;
    }

    public static boolean f(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            a(6);
        }
        if (declarationDescriptor2 == null) {
            a(7);
        }
        SourceFile j2 = f60.j(declarationDescriptor2);
        if (j2 != SourceFile.NO_SOURCE_FILE) {
            return j2.equals(f60.j(declarationDescriptor));
        }
        return false;
    }

    public static boolean g(@NotNull h60 h60) {
        if (h60 == null) {
            a(14);
        }
        return h60 == PRIVATE || h60 == PRIVATE_TO_THIS;
    }

    public static boolean h(@NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            a(2);
        }
        if (declarationDescriptor == null) {
            a(3);
        }
        return e(ALWAYS_SUITABLE_RECEIVER, declarationDescriptorWithVisibility, declarationDescriptor) == null;
    }

    private static void i(h60 h60) {
        d.put(h60.b(), h60);
    }

    @NotNull
    public static h60 j(@NotNull qw2 qw2) {
        if (qw2 == null) {
            a(15);
        }
        h60 h60 = d.get(qw2);
        if (h60 != null) {
            return h60;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + qw2);
    }
}
