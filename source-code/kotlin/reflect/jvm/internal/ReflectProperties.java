package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

public class ReflectProperties {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i == 1 || i == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static abstract class Val<T> {
        private static final Object NULL_VALUE = new Object() {
            /* class kotlin.reflect.jvm.internal.ReflectProperties.Val.AnonymousClass1 */
        };

        public abstract T invoke();

        public final T getValue(Object obj, Object obj2) {
            return invoke();
        }

        /* access modifiers changed from: protected */
        public Object escape(T t) {
            return t == null ? NULL_VALUE : t;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: protected */
        public T unescape(Object obj) {
            if (obj == NULL_VALUE) {
                return null;
            }
            return obj;
        }
    }

    public static class LazyVal<T> extends Val<T> {
        private final Function0<T> initializer;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        public LazyVal(Function0<T> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = function0;
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val
        public T invoke() {
            Object obj = this.value;
            if (obj != null) {
                return unescape(obj);
            }
            T invoke = this.initializer.invoke();
            this.value = escape(invoke);
            return invoke;
        }
    }

    public static class LazySoftVal<T> extends Val<T> {
        private final Function0<T> initializer;
        private volatile SoftReference<Object> value;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        public LazySoftVal(T t, Function0<T> function0) {
            if (function0 == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = function0;
            if (t != null) {
                this.value = new SoftReference<>(escape(t));
            }
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.value;
            if (softReference != null && (obj = softReference.get()) != null) {
                return unescape(obj);
            }
            T invoke = this.initializer.invoke();
            this.value = new SoftReference<>(escape(invoke));
            return invoke;
        }
    }

    public static <T> LazyVal<T> lazy(Function0<T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(0);
        }
        return new LazyVal<>(function0);
    }

    public static <T> LazySoftVal<T> lazySoft(T t, Function0<T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(1);
        }
        return new LazySoftVal<>(t, function0);
    }

    public static <T> LazySoftVal<T> lazySoft(Function0<T> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(2);
        }
        return lazySoft(null, function0);
    }
}
