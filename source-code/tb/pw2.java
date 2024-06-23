package tb;

import cn.damai.common.app.ShareperfenceConstants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Map;
import kotlin.collections.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class pw2 {
    @NotNull
    public static final pw2 INSTANCE = new pw2();
    @NotNull
    private static final Map<qw2, Integer> a;

    /* compiled from: Taobao */
    public static final class a extends qw2 {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
            super("inherited", false);
        }
    }

    /* compiled from: Taobao */
    public static final class b extends qw2 {
        @NotNull
        public static final b INSTANCE = new b();

        private b() {
            super("internal", false);
        }
    }

    /* compiled from: Taobao */
    public static final class c extends qw2 {
        @NotNull
        public static final c INSTANCE = new c();

        private c() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: Taobao */
    public static final class d extends qw2 {
        @NotNull
        public static final d INSTANCE = new d();

        private d() {
            super("local", false);
        }
    }

    /* compiled from: Taobao */
    public static final class e extends qw2 {
        @NotNull
        public static final e INSTANCE = new e();

        private e() {
            super(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, false);
        }
    }

    /* compiled from: Taobao */
    public static final class f extends qw2 {
        @NotNull
        public static final f INSTANCE = new f();

        private f() {
            super("private_to_this", false);
        }

        @Override // tb.qw2
        @NotNull
        public String b() {
            return "private/*private to this*/";
        }
    }

    /* compiled from: Taobao */
    public static final class g extends qw2 {
        @NotNull
        public static final g INSTANCE = new g();

        private g() {
            super("protected", true);
        }
    }

    /* compiled from: Taobao */
    public static final class h extends qw2 {
        @NotNull
        public static final h INSTANCE = new h();

        private h() {
            super("public", true);
        }
    }

    /* compiled from: Taobao */
    public static final class i extends qw2 {
        @NotNull
        public static final i INSTANCE = new i();

        private i() {
            super("unknown", false);
        }
    }

    static {
        Map map = w.c();
        map.put(f.INSTANCE, 0);
        map.put(e.INSTANCE, 0);
        map.put(b.INSTANCE, 1);
        map.put(g.INSTANCE, 1);
        map.put(h.INSTANCE, 2);
        a = w.b(map);
    }

    private pw2() {
    }

    @Nullable
    public final Integer a(@NotNull qw2 qw2, @NotNull qw2 qw22) {
        k21.i(qw2, ShareperfenceConstants.FIRST);
        k21.i(qw22, "second");
        if (qw2 == qw22) {
            return 0;
        }
        Map<qw2, Integer> map = a;
        Integer num = map.get(qw2);
        Integer num2 = map.get(qw22);
        if (num == null || num2 == null || k21.d(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(@NotNull qw2 qw2) {
        k21.i(qw2, "visibility");
        return qw2 == e.INSTANCE || qw2 == f.INSTANCE;
    }
}
