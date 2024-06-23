package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.youku.arch.v3.data.Constants;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.d0;
import kotlin.collections.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.e51;
import tb.f51;
import tb.f61;
import tb.g51;
import tb.i51;
import tb.j60;
import tb.k21;
import tb.k60;
import tb.li;
import tb.m40;
import tb.q01;
import tb.q60;

/* compiled from: Taobao */
public final class DeserializedDescriptorResolver {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final Set<KotlinClassHeader.Kind> b = d0.c(KotlinClassHeader.Kind.CLASS);
    @NotNull
    private static final Set<KotlinClassHeader.Kind> c = e0.g(KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
    @NotNull
    private static final e51 d = new e51(1, 1, 2);
    @NotNull
    private static final e51 e = new e51(1, 1, 11);
    @NotNull
    private static final e51 f = new e51(1, 1, 13);
    public j60 a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final e51 a() {
            return DeserializedDescriptorResolver.f;
        }

        @NotNull
        public final Set<KotlinClassHeader.Kind> b() {
            return DeserializedDescriptorResolver.b;
        }
    }

    private final DeserializedContainerAbiStability e(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (f().g().getAllowUnstableDependencies()) {
            return DeserializedContainerAbiStability.STABLE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().j()) {
            return DeserializedContainerAbiStability.FIR_UNSTABLE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().k()) {
            return DeserializedContainerAbiStability.IR_UNSTABLE;
        }
        return DeserializedContainerAbiStability.STABLE;
    }

    private final q01<e51> g(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (h() || kotlinJvmBinaryClass.getClassHeader().d().h()) {
            return null;
        }
        return new q01<>(kotlinJvmBinaryClass.getClassHeader().d(), e51.INSTANCE, kotlinJvmBinaryClass.getLocation(), kotlinJvmBinaryClass.getClassId());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean h() {
        return f().g().getSkipMetadataVersionCheck();
    }

    private final boolean i(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        return !f().g().getSkipPrereleaseCheck() && kotlinJvmBinaryClass.getClassHeader().i() && k21.d(kotlinJvmBinaryClass.getClassHeader().d(), e);
    }

    private final boolean j(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        return (f().g().getReportErrorsOnPreReleaseDependencies() && (kotlinJvmBinaryClass.getClassHeader().i() || k21.d(kotlinJvmBinaryClass.getClassHeader().d(), d))) || i(kotlinJvmBinaryClass);
    }

    private final String[] l(KotlinJvmBinaryClass kotlinJvmBinaryClass, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader classHeader = kotlinJvmBinaryClass.getClassHeader();
        String[] a2 = classHeader.a();
        if (a2 == null) {
            a2 = classHeader.b();
        }
        if (a2 != null && set.contains(classHeader.c())) {
            return a2;
        }
        return null;
    }

    @Nullable
    public final MemberScope d(@NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] g;
        Pair<f51, ProtoBuf$Package> pair;
        k21.i(packageFragmentDescriptor, "descriptor");
        k21.i(kotlinJvmBinaryClass, "kotlinClass");
        String[] l = l(kotlinJvmBinaryClass, c);
        if (l == null || (g = kotlinJvmBinaryClass.getClassHeader().g()) == null) {
            return null;
        }
        try {
            i51 i51 = i51.INSTANCE;
            pair = i51.m(l, g);
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalStateException(k21.r("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e2);
        } catch (Throwable th) {
            if (h() || kotlinJvmBinaryClass.getClassHeader().d().h()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        f51 component1 = pair.component1();
        ProtoBuf$Package component2 = pair.component2();
        return new q60(packageFragmentDescriptor, component2, component1, kotlinJvmBinaryClass.getClassHeader().d(), new g51(kotlinJvmBinaryClass, component2, component1, g(kotlinJvmBinaryClass), j(kotlinJvmBinaryClass), e(kotlinJvmBinaryClass)), f(), DeserializedDescriptorResolver$createKotlinPackagePartScope$2.INSTANCE);
    }

    @NotNull
    public final j60 f() {
        j60 j60 = this.a;
        if (j60 != null) {
            return j60;
        }
        k21.A(Constants.COMPONENT);
        throw null;
    }

    @Nullable
    public final li k(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String[] g;
        Pair<f51, ProtoBuf$Class> pair;
        k21.i(kotlinJvmBinaryClass, "kotlinClass");
        String[] l = l(kotlinJvmBinaryClass, Companion.b());
        if (l == null || (g = kotlinJvmBinaryClass.getClassHeader().g()) == null) {
            return null;
        }
        try {
            i51 i51 = i51.INSTANCE;
            pair = i51.i(l, g);
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalStateException(k21.r("Could not read data from ", kotlinJvmBinaryClass.getLocation()), e2);
        } catch (Throwable th) {
            if (h() || kotlinJvmBinaryClass.getClassHeader().d().h()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        return new li(pair.component1(), pair.component2(), kotlinJvmBinaryClass.getClassHeader().d(), new f61(kotlinJvmBinaryClass, g(kotlinJvmBinaryClass), j(kotlinJvmBinaryClass), e(kotlinJvmBinaryClass)));
    }

    @Nullable
    public final ClassDescriptor m(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        k21.i(kotlinJvmBinaryClass, "kotlinClass");
        li k = k(kotlinJvmBinaryClass);
        if (k == null) {
            return null;
        }
        return f().f().d(kotlinJvmBinaryClass.getClassId(), k);
    }

    public final void n(@NotNull j60 j60) {
        k21.i(j60, "<set-?>");
        this.a = j60;
    }

    public final void o(@NotNull k60 k60) {
        k21.i(k60, Constants.COMPONENT);
        n(k60.a());
    }
}
