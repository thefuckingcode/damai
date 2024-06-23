package tb;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class z21 extends rq1 {

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
    public void a(@NotNull Throwable th, @NotNull Throwable th2) {
        k21.i(th, "cause");
        k21.i(th2, "exception");
        if (d(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
