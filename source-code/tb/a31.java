package tb;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.JvmField;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class a31 extends z21 {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        public static final a INSTANCE = new a();
        @JvmField
        @Nullable
        public static final Integer sdkVersion;

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                if (obj instanceof Integer) {
                    num = (Integer) obj;
                    if (num != null) {
                        if (num.intValue() > 0) {
                            num2 = num;
                        }
                    }
                    sdkVersion = num2;
                }
            } catch (Throwable unused) {
            }
            num = null;
            if (num != null) {
            }
            sdkVersion = num2;
        }

        private a() {
        }
    }

    private final boolean d(int i) {
        Integer num = a.sdkVersion;
        return num == null || num.intValue() >= i;
    }

    @Override // tb.rq1
    @NotNull
    public Random b() {
        return d(24) ? new uq1() : super.b();
    }

    @Override // tb.rq1
    @Nullable
    public pb1 c(@NotNull MatchResult matchResult, @NotNull String str) {
        k21.i(matchResult, "matchResult");
        k21.i(str, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher != null) {
            w11 w11 = new w11(matcher.start(str), matcher.end(str) - 1);
            if (w11.getStart().intValue() < 0) {
                return null;
            }
            String group = matcher.group(str);
            k21.h(group, "matcher.group(name)");
            return new pb1(group, w11);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
