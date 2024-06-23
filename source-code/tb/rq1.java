package tb;

import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import kotlin.collections.e;
import kotlin.jvm.JvmField;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class rq1 {

    /* compiled from: Taobao */
    private static final class a {
        @NotNull
        public static final a INSTANCE = new a();
        @JvmField
        @Nullable
        public static final Method addSuppressed;
        @JvmField
        @Nullable
        public static final Method getSuppressed;

        /* JADX WARNING: Removed duplicated region for block: B:10:0x003f A[LOOP:0: B:1:0x0015->B:10:0x003f, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0043 A[EDGE_INSN: B:21:0x0043->B:12:0x0043 ?: BREAK  , SYNTHETIC] */
        static {
            Method method;
            Method method2;
            boolean z;
            Method[] methods = Throwable.class.getMethods();
            k21.h(methods, "throwableMethods");
            int length = methods.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i2];
                if (k21.d(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    k21.h(parameterTypes, "it.parameterTypes");
                    if (k21.d(e.M(parameterTypes), Throwable.class)) {
                        z = true;
                        if (!z) {
                            break;
                        }
                        i2++;
                    }
                }
                z = false;
                if (!z) {
                }
            }
            addSuppressed = method2;
            int length2 = methods.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                Method method3 = methods[i];
                if (k21.d(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i++;
            }
            getSuppressed = method;
        }

        private a() {
        }
    }

    public void a(@NotNull Throwable th, @NotNull Throwable th2) {
        k21.i(th, "cause");
        k21.i(th2, "exception");
        Method method = a.addSuppressed;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    @NotNull
    public Random b() {
        return new tg0();
    }

    @Nullable
    public pb1 c(@NotNull MatchResult matchResult, @NotNull String str) {
        k21.i(matchResult, "matchResult");
        k21.i(str, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
