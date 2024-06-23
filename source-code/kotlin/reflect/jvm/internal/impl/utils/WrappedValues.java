package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ef0;

/* compiled from: Taobao */
public class WrappedValues {
    private static final Object a = new a();
    public static volatile boolean b = false;

    /* compiled from: Taobao */
    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        a() {
        }

        public String toString() {
            return "NULL_VALUE";
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b {
        private final Throwable a;

        /* synthetic */ b(Throwable th, a aVar) {
            this(th);
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 1 ? 3 : 2)];
            if (i != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i != 1) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @NotNull
        public Throwable b() {
            Throwable th = this.a;
            if (th == null) {
                a(1);
            }
            return th;
        }

        public String toString() {
            return this.a.toString();
        }

        private b(@NotNull Throwable th) {
            if (th == null) {
                a(0);
            }
            this.a = th;
        }
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2) ? 2 : 3)];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i != 3) {
            objArr[0] = "value";
        } else {
            objArr[0] = "throwable";
        }
        if (i == 1 || i == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String format = String.format(str, objArr);
        if (i == 1 || i == 2) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static <V> Object b(@Nullable V v) {
        if (v == null && (v = (V) a) == null) {
            a(1);
        }
        return v;
    }

    @NotNull
    public static Object c(@NotNull Throwable th) {
        if (th == null) {
            a(3);
        }
        return new b(th, null);
    }

    @Nullable
    public static <V> V d(@NotNull Object obj) {
        if (obj == null) {
            a(4);
        }
        return (V) e(f(obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <V> V e(@NotNull Object obj) {
        if (obj == 0) {
            a(0);
        }
        if (obj == a) {
            return null;
        }
        return obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <V> V f(@Nullable Object obj) {
        if (!(obj instanceof b)) {
            return obj;
        }
        Throwable b2 = ((b) obj).b();
        if (!b || !ef0.a(b2)) {
            throw ef0.b(b2);
        }
        throw new WrappedProcessCanceledException(b2);
    }
}
