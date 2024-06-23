package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.m;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.s82;
import tb.ur2;

/* compiled from: Taobao */
public final class DebugCoroutineInfoImpl {
    @JvmField
    public final long a;
    @NotNull
    private final WeakReference<CoroutineContext> b;
    @NotNull
    private String c;
    @JvmField
    @Nullable
    public Thread d;
    @Nullable
    private WeakReference<CoroutineStackFrame> e;

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    public final Object f(s82<? super StackTraceElement> s82, CoroutineStackFrame coroutineStackFrame, Continuation<? super ur2> continuation) {
        DebugCoroutineInfoImpl$yieldFrames$1 debugCoroutineInfoImpl$yieldFrames$1;
        int i;
        DebugCoroutineInfoImpl debugCoroutineInfoImpl;
        s82<? super StackTraceElement> s822;
        CoroutineStackFrame coroutineStackFrame2;
        if (continuation instanceof DebugCoroutineInfoImpl$yieldFrames$1) {
            debugCoroutineInfoImpl$yieldFrames$1 = (DebugCoroutineInfoImpl$yieldFrames$1) continuation;
            int i2 = debugCoroutineInfoImpl$yieldFrames$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                debugCoroutineInfoImpl$yieldFrames$1.label = i2 - Integer.MIN_VALUE;
                Object obj = debugCoroutineInfoImpl$yieldFrames$1.result;
                Object obj2 = b.d();
                i = debugCoroutineInfoImpl$yieldFrames$1.label;
                if (i != 0) {
                    k12.b(obj);
                    debugCoroutineInfoImpl = this;
                } else if (i == 1) {
                    coroutineStackFrame2 = (CoroutineStackFrame) debugCoroutineInfoImpl$yieldFrames$1.L$2;
                    s822 = (s82) debugCoroutineInfoImpl$yieldFrames$1.L$1;
                    debugCoroutineInfoImpl = (DebugCoroutineInfoImpl) debugCoroutineInfoImpl$yieldFrames$1.L$0;
                    k12.b(obj);
                    coroutineStackFrame = coroutineStackFrame2;
                    s82 = s822;
                    coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                    if (coroutineStackFrame == null) {
                        return ur2.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (coroutineStackFrame != null) {
                    StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
                    if (stackTraceElement != null) {
                        debugCoroutineInfoImpl$yieldFrames$1.L$0 = debugCoroutineInfoImpl;
                        debugCoroutineInfoImpl$yieldFrames$1.L$1 = s82;
                        debugCoroutineInfoImpl$yieldFrames$1.L$2 = coroutineStackFrame;
                        debugCoroutineInfoImpl$yieldFrames$1.label = 1;
                        if (s82.a(stackTraceElement, debugCoroutineInfoImpl$yieldFrames$1) == obj2) {
                            return obj2;
                        }
                        s822 = s82;
                        coroutineStackFrame2 = coroutineStackFrame;
                        coroutineStackFrame = coroutineStackFrame2;
                        s82 = s822;
                        return obj2;
                    }
                    coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                    if (coroutineStackFrame == null) {
                    }
                    if (coroutineStackFrame != null) {
                    }
                }
                return ur2.INSTANCE;
            }
        }
        debugCoroutineInfoImpl$yieldFrames$1 = new DebugCoroutineInfoImpl$yieldFrames$1(this, continuation);
        Object obj3 = debugCoroutineInfoImpl$yieldFrames$1.result;
        Object obj22 = b.d();
        i = debugCoroutineInfoImpl$yieldFrames$1.label;
        if (i != 0) {
        }
        if (coroutineStackFrame != null) {
        }
        return ur2.INSTANCE;
    }

    @Nullable
    public final CoroutineContext b() {
        return this.b.get();
    }

    @Nullable
    public final CoroutineStackFrame c() {
        WeakReference<CoroutineStackFrame> weakReference = this.e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @NotNull
    public final String d() {
        return this.c;
    }

    @NotNull
    public final List<StackTraceElement> e() {
        CoroutineStackFrame c2 = c();
        if (c2 == null) {
            return m.g();
        }
        ArrayList arrayList = new ArrayList();
        while (c2 != null) {
            StackTraceElement stackTraceElement = c2.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            c2 = c2.getCallerFrame();
        }
        return arrayList;
    }

    @NotNull
    public String toString() {
        return "DebugCoroutineInfo(state=" + d() + ",context=" + b() + ')';
    }
}
