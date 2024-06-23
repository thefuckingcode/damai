package kotlin;

import java.io.Serializable;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@SinceKotlin(version = "1.3")
@JvmInline
/* compiled from: Taobao */
public final class Result<T> implements Serializable {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private final Object value;

    /* compiled from: Taobao */
    public static final class Failure implements Serializable {
        @JvmField
        @NotNull
        public final Throwable exception;

        public Failure(@NotNull Throwable th) {
            k21.i(th, "exception");
            this.exception = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Failure) && k21.d(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Result m912boximpl(Object obj) {
        return new Result(obj);
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> Object m913constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m914equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && k21.d(obj, ((Result) obj2).m922unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m915equalsimpl0(Object obj, Object obj2) {
        return k21.d(obj, obj2);
    }

    @Nullable
    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m916exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: getOrNull-impl  reason: not valid java name */
    private static final T m917getOrNullimpl(Object obj) {
        if (m919isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    @PublishedApi
    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m918hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m919isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m920isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m921toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m914equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m918hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m921toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m922unboximpl() {
        return this.value;
    }
}
