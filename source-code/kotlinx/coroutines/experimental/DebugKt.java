package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\u001a\u000e\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\n"}, d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/experimental/Continuation;", "toSafeString", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Debug.kt */
public final class DebugKt {
    public static final String getHexAddress(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$receiver");
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        Intrinsics.checkExpressionValueIsNotNull(hexString, "Integer.toHexString(System.identityHashCode(this))");
        return hexString;
    }

    public static final String toSafeString(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Throwable th) {
            return "toString() failed with " + th;
        }
    }

    public static final String toDebugString(Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "$receiver");
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        return continuation.getClass().getName() + '@' + getHexAddress(continuation);
    }

    public static final String getClassSimpleName(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$receiver");
        String simpleName = obj.getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName");
        return simpleName;
    }
}
