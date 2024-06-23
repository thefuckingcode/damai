package tb;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.g;
import kotlinx.coroutines.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class qn {
    @NotNull
    public static final String COROUTINES_SCHEDULER_PROPERTY_NAME = "kotlinx.coroutines.scheduler";
    private static final boolean a;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r0.equals("on") != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        if (r0.equals("") != false) goto L_0x0053;
     */
    static {
        boolean z;
        String d = mh2.d(COROUTINES_SCHEDULER_PROPERTY_NAME);
        if (d != null) {
            int hashCode = d.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode == 109935 && d.equals("off")) {
                        z = false;
                        a = z;
                    }
                }
            }
            throw new IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + ((Object) d) + '\'').toString());
        }
        z = true;
        a = z;
    }

    @NotNull
    public static final CoroutineDispatcher a() {
        return a ? g50.INSTANCE : g.INSTANCE;
    }

    @Nullable
    public static final String b(@NotNull CoroutineContext coroutineContext) {
        un unVar;
        String name;
        if (!n30.c() || (unVar = (un) coroutineContext.get(un.Key)) == null) {
            return null;
        }
        vn vnVar = (vn) coroutineContext.get(vn.Key);
        String str = "coroutine";
        if (!(vnVar == null || (name = vnVar.getName()) == null)) {
            str = name;
        }
        return str + '#' + unVar.a();
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final CoroutineContext c(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext) {
        CoroutineContext plus = coroutineScope.getCoroutineContext().plus(coroutineContext);
        CoroutineContext plus2 = n30.c() ? plus.plus(new un(n30.b().incrementAndGet())) : plus;
        f90 f90 = f90.INSTANCE;
        return (plus == f90.a() || plus.get(ContinuationInterceptor.Key) != null) ? plus2 : plus2.plus(f90.a());
    }

    @Nullable
    public static final or2<?> d(@NotNull CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof i) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof or2) {
                return (or2) coroutineStackFrame;
            }
        }
        return null;
    }

    @Nullable
    public static final or2<?> e(@NotNull Continuation<?> continuation, @NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (!(coroutineContext.get(qr2.INSTANCE) != null)) {
            return null;
        }
        or2<?> d = d((CoroutineStackFrame) continuation);
        if (d != null) {
            d.b(coroutineContext, obj);
        }
        return d;
    }
}
