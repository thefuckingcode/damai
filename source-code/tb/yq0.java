package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m70;
import tb.nq0;

/* compiled from: Taobao */
public final class yq0 {
    @NotNull
    public static final yq0 INSTANCE = new yq0();

    private yq0() {
    }

    @Nullable
    public final ox1<m70> a(@Nullable ox1<m70> ox1, @Nullable ox1<m70> ox12) {
        m70 m70;
        m70 m702;
        m70 m703;
        m70 m704;
        if (ox12 != null && ox1 != null) {
            if ((ox1.c() instanceof m70.d) || (ox1.c() instanceof m70.a)) {
                m70 = zq0.a(ox12.c());
            } else {
                m70 = zq0.a(ox1.c());
            }
            if ((ox1.b() instanceof m70.d) || (ox1.b() instanceof m70.a)) {
                m702 = zq0.a(ox12.b());
            } else {
                m702 = zq0.a(ox1.b());
            }
            if ((ox1.d() instanceof m70.d) || (ox1.d() instanceof m70.a)) {
                m703 = zq0.a(ox12.d());
            } else {
                m703 = zq0.a(ox1.d());
            }
            if ((ox1.a() instanceof m70.d) || (ox1.a() instanceof m70.a)) {
                m704 = zq0.a(ox12.a());
            } else {
                m704 = zq0.a(ox1.a());
            }
            return new ox1<>(m70, m702, m703, m704);
        } else if (ox1 == null && ox12 != null) {
            return new ox1<>(zq0.a(ox12.c()), zq0.a(ox12.b()), zq0.a(ox12.d()), zq0.a(ox12.a()));
        } else {
            if (ox12 != null || ox1 == null) {
                return null;
            }
            return new ox1<>(zq0.a(ox1.c()), zq0.a(ox1.b()), zq0.a(ox1.d()), zq0.a(ox1.a()));
        }
    }

    @Nullable
    public final ox1<nq0> b(@Nullable ox1<nq0> ox1, @Nullable ox1<nq0> ox12) {
        nq0 nq0;
        nq0 nq02;
        nq0 nq03;
        nq0 nq04;
        if (ox12 != null && ox1 != null) {
            if ((ox1.c() instanceof nq0.f) || (ox1.c() instanceof nq0.a)) {
                nq0 = zq0.b(ox12.c());
            } else {
                nq0 = zq0.b(ox1.c());
            }
            if ((ox1.b() instanceof nq0.f) || (ox1.b() instanceof nq0.a)) {
                nq02 = zq0.b(ox12.b());
            } else {
                nq02 = zq0.b(ox1.b());
            }
            if ((ox1.d() instanceof nq0.f) || (ox1.d() instanceof nq0.a)) {
                nq03 = zq0.b(ox12.d());
            } else {
                nq03 = zq0.b(ox1.d());
            }
            if ((ox1.a() instanceof nq0.f) || (ox1.a() instanceof nq0.a)) {
                nq04 = zq0.b(ox12.a());
            } else {
                nq04 = zq0.b(ox1.a());
            }
            return new ox1<>(nq0, nq02, nq03, nq04);
        } else if (ox1 == null && ox12 != null) {
            return new ox1<>(zq0.b(ox12.c()), zq0.b(ox12.b()), zq0.b(ox12.d()), zq0.b(ox12.a()));
        } else {
            if (ox12 != null || ox1 == null) {
                return null;
            }
            return new ox1<>(zq0.b(ox1.c()), zq0.b(ox1.b()), zq0.b(ox1.d()), zq0.b(ox1.a()));
        }
    }

    @Nullable
    public final ob2<m70> c(@Nullable ob2<m70> ob2, @Nullable ob2<m70> ob22) {
        m70 m70;
        m70 m702;
        if (ob22 != null && ob2 != null) {
            if ((ob2.b() instanceof m70.d) || (ob2.b() instanceof m70.a)) {
                m70 = zq0.a(ob22.b());
            } else {
                m70 = zq0.a(ob2.b());
            }
            if ((ob2.a() instanceof m70.d) || (ob2.a() instanceof m70.a)) {
                m702 = zq0.a(ob22.a());
            } else {
                m702 = zq0.a(ob2.a());
            }
            return new ob2<>(m70, m702);
        } else if (ob2 == null && ob22 != null) {
            return new ob2<>(zq0.a(ob22.b()), zq0.a(ob22.a()));
        } else {
            if (ob22 != null || ob2 == null) {
                return null;
            }
            return new ob2<>(zq0.a(ob2.b()), zq0.a(ob2.a()));
        }
    }

    public final void d(@NotNull ox1<m70> ox1, @NotNull ox1<m70> ox12) {
        k21.i(ox1, AdvanceSetting.NETWORK_TYPE);
        k21.i(ox12, "targetDimension");
        if (!(ox1.c() instanceof m70.d)) {
            ox12.g(ox1.c());
        }
        if (!(ox1.b() instanceof m70.d)) {
            ox12.f(ox1.b());
        }
        if (!(ox1.d() instanceof m70.d)) {
            ox12.h(ox1.d());
        }
        if (!(ox1.a() instanceof m70.d)) {
            ox12.e(ox1.a());
        }
    }

    public final void e(@NotNull ob2<m70> ob2, @NotNull ob2<m70> ob22) {
        k21.i(ob2, "src");
        k21.i(ob22, "target");
        if (!(ob2.b() instanceof m70.d)) {
            ob22.d(ob2.b());
        }
        if (!(ob2.a() instanceof m70.d)) {
            ob22.c(ob2.a());
        }
    }
}
