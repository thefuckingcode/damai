package tb;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.text.o;
import kotlinx.coroutines.internal.ExceptionsConstuctorKt;

public final class sd2 {
    private static final String a;
    private static final String b;

    static {
        Object obj;
        Object obj2;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m913constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m913constructorimpl(k12.a(th));
        }
        if (Result.m916exceptionOrNullimpl(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) obj;
        try {
            Result.a aVar3 = Result.Companion;
            obj2 = Result.m913constructorimpl(sd2.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar4 = Result.Companion;
            obj2 = Result.m913constructorimpl(k12.a(th2));
        }
        if (Result.m916exceptionOrNullimpl(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        b = (String) obj2;
    }

    public static final StackTraceElement b(String str) {
        return new StackTraceElement(k21.r("\b\b\b(", str), "\b", "\b", -1);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> c(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause == null || !k21.d(cause.getClass(), e.getClass())) {
            return do2.a(e, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (h(stackTrace[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return do2.a(cause, stackTrace);
        }
        return do2.a(e, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E d(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(b("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int g = g(stackTrace, a);
        int i = 0;
        if (g == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            e2.setStackTrace((StackTraceElement[]) array);
            return e2;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[(arrayDeque.size() + g)];
        if (g > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                stackTraceElementArr[i2] = stackTrace[i2];
                if (i3 >= g) {
                    break;
                }
                i2 = i3;
            }
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            int i4 = i + 1;
            stackTraceElementArr[i + g] = it.next();
            i = i4;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    private static final ArrayDeque<StackTraceElement> e(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    private static final boolean f(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && k21.d(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && k21.d(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && k21.d(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int g(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (k21.d(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean h(StackTraceElement stackTraceElement) {
        return o.L(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
    }

    private static final void i(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (h(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i2 <= length2) {
            while (true) {
                int i3 = length2 - 1;
                if (f(stackTraceElementArr[length2], arrayDeque.getLast())) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 != i2) {
                    length2 = i3;
                } else {
                    return;
                }
            }
        }
    }

    public static final <E extends Throwable> E j(E e, CoroutineStackFrame coroutineStackFrame) {
        Pair c = c(e);
        Throwable th = (Throwable) c.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) c.component2();
        Throwable e2 = ExceptionsConstuctorKt.e(th);
        if (e2 == null || !k21.d(e2.getMessage(), th.getMessage())) {
            return e;
        }
        ArrayDeque<StackTraceElement> e3 = e(coroutineStackFrame);
        if (e3.isEmpty()) {
            return e;
        }
        if (th != e) {
            i(stackTraceElementArr, e3);
        }
        return (E) d(th, e2, e3);
    }

    public static final <E extends Throwable> E k(E e) {
        Throwable e2;
        return (n30.d() && (e2 = ExceptionsConstuctorKt.e(e)) != null) ? (E) l(e2) : e;
    }

    private static final <E extends Throwable> E l(E e) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int g = g(stackTrace, b);
        int i = g + 1;
        int g2 = g(stackTrace, a);
        int i2 = (length - g) - (g2 == -1 ? 0 : length - g2);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stackTraceElement = b("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i + i3) - 1];
            }
            stackTraceElementArr[i3] = stackTraceElement;
        }
        e.setStackTrace(stackTraceElementArr);
        return e;
    }

    public static final <E extends Throwable> E m(E e) {
        E e2 = (E) e.getCause();
        if (e2 != null && k21.d(e2.getClass(), e.getClass())) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (h(stackTrace[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return e2;
            }
        }
        return e;
    }
}
