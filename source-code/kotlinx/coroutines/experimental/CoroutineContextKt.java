package kotlinx.coroutines.experimental;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.coroutines.experimental.ContinuationInterceptor;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007\u001a\b\u0010\u0019\u001a\u00020\u001aH\u0000\u001a\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0001\u001a*\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u0016\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0 H\b¢\u0006\u0002\u0010!\u001a\u000e\u0010\"\u001a\u0004\u0018\u00010\u0007*\u00020\u0012H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0007*\u00020\u00128@X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "", "getDEBUG", "()Z", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "DefaultDispatcher", "Lkotlinx/coroutines/experimental/CoroutineDispatcher;", "DefaultDispatcher$annotations", "()V", "getDefaultDispatcher", "()Lkotlinx/coroutines/experimental/CoroutineDispatcher;", "coroutineName", "Lkotlin/coroutines/experimental/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/experimental/CoroutineContext;)Ljava/lang/String;", "newCoroutineContext", "context", "parent", "Lkotlinx/coroutines/experimental/Job;", "resetCoroutineId", "", "restoreThreadContext", "oldName", "withCoroutineContext", "T", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateThreadContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: CoroutineContext.kt */
public final class CoroutineContextKt {
    private static final AtomicLong COROUTINE_ID = new AtomicLong();
    private static final boolean DEBUG;
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    private static final CoroutineDispatcher DefaultDispatcher = CommonPool.INSTANCE;

    public static /* synthetic */ void DefaultDispatcher$annotations() {
    }

    public static final CoroutineContext newCoroutineContext(CoroutineContext coroutineContext) {
        return newCoroutineContext$default(coroutineContext, null, 2, null);
    }

    public static /* bridge */ /* synthetic */ CoroutineContext newCoroutineContext$default(CoroutineContext coroutineContext, Job job, int i, Object obj) {
        if ((i & 2) != 0) {
            job = null;
        }
        return newCoroutineContext(coroutineContext, job);
    }

    public static final boolean getDEBUG() {
        return DEBUG;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r0.equals(kotlinx.coroutines.experimental.CoroutineContextKt.DEBUG_PROPERTY_VALUE_AUTO) != false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r0.equals(kotlinx.coroutines.experimental.CoroutineContextKt.DEBUG_PROPERTY_VALUE_OFF) != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r0.equals(kotlinx.coroutines.experimental.CoroutineContextKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (r0.equals("") != false) goto L_0x0045;
     */
    static {
        String str;
        try {
            str = System.getProperty(DEBUG_PROPERTY_NAME);
        } catch (SecurityException unused) {
            str = null;
        }
        boolean z = false;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode != 109935) {
                        if (hashCode == 3005871) {
                        }
                    }
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + str + '\'').toString());
            }
            z = true;
            DEBUG = z;
        }
        DEBUG = z;
    }

    public static final void resetCoroutineId() {
        COROUTINE_ID.set(0);
    }

    public static final CoroutineDispatcher getDefaultDispatcher() {
        return DefaultDispatcher;
    }

    public static final CoroutineContext newCoroutineContext(CoroutineContext coroutineContext, Job job) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        CoroutineContext plus = DEBUG ? coroutineContext.plus(new CoroutineId(COROUTINE_ID.incrementAndGet())) : coroutineContext;
        if (job != null) {
            plus = plus.plus(job);
        }
        CoroutineDispatcher coroutineDispatcher = DefaultDispatcher;
        return (coroutineContext == coroutineDispatcher || coroutineContext.get(ContinuationInterceptor.Key) != null) ? plus : plus.plus(coroutineDispatcher);
    }

    public static final <T> T withCoroutineContext(CoroutineContext coroutineContext, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        String updateThreadContext = updateThreadContext(coroutineContext);
        try {
            return (T) function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            restoreThreadContext(updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final String updateThreadContext(CoroutineContext coroutineContext) {
        CoroutineId coroutineId;
        String str;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "$receiver");
        if (!DEBUG || (coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.Key)) == null) {
            return null;
        }
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.Key);
        if (coroutineName == null || (str = coroutineName.getName()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "currentThread");
        String name = currentThread.getName();
        StringBuilder sb = new StringBuilder(name.length() + str.length() + 10);
        sb.append(name);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(coroutineId.getId());
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name;
    }

    public static final String getCoroutineName(CoroutineContext coroutineContext) {
        CoroutineId coroutineId;
        String str;
        Intrinsics.checkParameterIsNotNull(coroutineContext, "$receiver");
        if (!DEBUG || (coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.Key)) == null) {
            return null;
        }
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.Key);
        if (coroutineName == null || (str = coroutineName.getName()) == null) {
            str = "coroutine";
        }
        return str + '#' + coroutineId.getId();
    }

    public static final void restoreThreadContext(String str) {
        if (str != null) {
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            currentThread.setName(str);
        }
    }
}
