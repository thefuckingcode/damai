package tb;

import java.lang.reflect.Field;
import kotlin.SinceKotlin;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class o30 {
    private static final void a(int i, int i2) {
        if (i2 > i) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
        }
    }

    private static final DebugMetadata b(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getStackTraceElement")
    @Nullable
    public static final StackTraceElement d(@NotNull BaseContinuationImpl baseContinuationImpl) {
        int i;
        String str;
        k21.i(baseContinuationImpl, "<this>");
        DebugMetadata b = b(baseContinuationImpl);
        if (b == null) {
            return null;
        }
        a(1, b.v());
        int c = c(baseContinuationImpl);
        if (c < 0) {
            i = -1;
        } else {
            i = b.l()[c];
        }
        String b2 = df1.INSTANCE.b(baseContinuationImpl);
        if (b2 == null) {
            str = b.c();
        } else {
            str = b2 + v00.DIR + b.c();
        }
        return new StackTraceElement(str, b.m(), b.f(), i);
    }
}
