package org.jetbrains.anko;

import android.util.Log;
import com.lzy.okgo.model.Progress;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\b\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001ag\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u00122\u001e\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u0014H\b\u001a\u001d\u0010\u0015\u001a\u00020\n*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016H\b\u001a \u0010\u0015\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u001d\u0010\u0017\u001a\u00020\n*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016H\b\u001a \u0010\u0017\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\r\u0010\u0018\u001a\u00020\u0007*\u00020\u000eH\b\u001a\u001d\u0010\u0019\u001a\u00020\n*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016H\b\u001a \u0010\u0019\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u001d\u0010\u001a\u001a\u00020\n*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016H\b\u001a \u0010\u001a\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u001d\u0010\u001b\u001a\u00020\n*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016H\b\u001a \u0010\u001b\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a \u0010\u001c\u001a\u00020\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u001d"}, d2 = {"AnkoLogger", "Lorg/jetbrains/anko/AnkoLogger;", "T", "", "clazz", "Ljava/lang/Class;", Progress.TAG, "", "getTag", "log", "", "logger", "message", "thr", "", "level", "", "f", "Lkotlin/Function2;", "fThrowable", "Lkotlin/Function3;", "debug", "Lkotlin/Function0;", "error", "getStackTraceString", "info", "verbose", "warn", "wtf", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Logging.kt */
public final class Logging {
    public static final AnkoLogger AnkoLogger(Class<?> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        return new Logging$AnkoLogger$1(cls);
    }

    public static final AnkoLogger AnkoLogger(String str) {
        Intrinsics.checkParameterIsNotNull(str, Progress.TAG);
        return new Logging$AnkoLogger$2(str);
    }

    private static final <T> AnkoLogger AnkoLogger() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return AnkoLogger(Object.class);
    }

    public static /* bridge */ /* synthetic */ void verbose$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        verbose(ankoLogger, obj, th);
    }

    public static /* bridge */ /* synthetic */ void debug$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        debug(ankoLogger, obj, th);
    }

    public static /* bridge */ /* synthetic */ void info$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        info(ankoLogger, obj, th);
    }

    public static /* bridge */ /* synthetic */ void warn$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        warn(ankoLogger, obj, th);
    }

    public static /* bridge */ /* synthetic */ void error$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        error(ankoLogger, obj, th);
    }

    public static /* bridge */ /* synthetic */ void wtf$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        wtf(ankoLogger, obj, th);
    }

    public static final void wtf(AnkoLogger ankoLogger, Object obj, Throwable th) {
        String obj2;
        String obj3;
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        String str = "null";
        if (th != null) {
            String loggerTag = ankoLogger.getLoggerTag();
            if (!(obj == null || (obj3 = obj.toString()) == null)) {
                str = obj3;
            }
            Log.wtf(loggerTag, str, th);
            return;
        }
        String loggerTag2 = ankoLogger.getLoggerTag();
        if (!(obj == null || (obj2 = obj.toString()) == null)) {
            str = obj2;
        }
        Log.wtf(loggerTag2, str);
    }

    public static final void verbose(AnkoLogger ankoLogger, Function0<? extends Object> function0) {
        String str;
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "message");
        String loggerTag = ankoLogger.getLoggerTag();
        if (Log.isLoggable(loggerTag, 2)) {
            Object invoke = function0.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            Log.v(loggerTag, str);
        }
    }

    public static final void debug(AnkoLogger ankoLogger, Function0<? extends Object> function0) {
        String str;
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "message");
        String loggerTag = ankoLogger.getLoggerTag();
        if (Log.isLoggable(loggerTag, 3)) {
            Object invoke = function0.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            Log.d(loggerTag, str);
        }
    }

    public static final void info(AnkoLogger ankoLogger, Function0<? extends Object> function0) {
        String str;
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "message");
        String loggerTag = ankoLogger.getLoggerTag();
        if (Log.isLoggable(loggerTag, 4)) {
            Object invoke = function0.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            Log.i(loggerTag, str);
        }
    }

    public static final void warn(AnkoLogger ankoLogger, Function0<? extends Object> function0) {
        String str;
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "message");
        String loggerTag = ankoLogger.getLoggerTag();
        if (Log.isLoggable(loggerTag, 5)) {
            Object invoke = function0.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            Log.w(loggerTag, str);
        }
    }

    public static final void error(AnkoLogger ankoLogger, Function0<? extends Object> function0) {
        String str;
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        Intrinsics.checkParameterIsNotNull(function0, "message");
        String loggerTag = ankoLogger.getLoggerTag();
        if (Log.isLoggable(loggerTag, 6)) {
            Object invoke = function0.invoke();
            if (invoke == null || (str = invoke.toString()) == null) {
                str = "null";
            }
            Log.e(loggerTag, str);
        }
    }

    public static final String getStackTraceString(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "$receiver");
        String stackTraceString = Log.getStackTraceString(th);
        Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(this)");
        return stackTraceString;
    }

    private static final void log(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Function2<? super String, ? super String, Unit> function2, Function3<? super String, ? super String, ? super Throwable, Unit> function3) {
        String obj2;
        String obj3;
        String loggerTag = ankoLogger.getLoggerTag();
        if (Log.isLoggable(loggerTag, i)) {
            String str = "null";
            if (th != null) {
                if (!(obj == null || (obj3 = obj.toString()) == null)) {
                    str = obj3;
                }
                function3.invoke(loggerTag, str, th);
                return;
            }
            if (!(obj == null || (obj2 = obj.toString()) == null)) {
                str = obj2;
            }
            function2.invoke(loggerTag, str);
        }
    }

    /* access modifiers changed from: private */
    public static final String getTag(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        if (simpleName.length() <= 23) {
            Intrinsics.checkExpressionValueIsNotNull(simpleName, Progress.TAG);
            return simpleName;
        }
        Intrinsics.checkExpressionValueIsNotNull(simpleName, Progress.TAG);
        if (simpleName != null) {
            String substring = simpleName.substring(0, 23);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final void verbose(AnkoLogger ankoLogger, Object obj, Throwable th) {
        String obj2;
        String obj3;
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        String loggerTag = ankoLogger.getLoggerTag();
        if (Log.isLoggable(loggerTag, 2)) {
            String str = "null";
            if (th != null) {
                if (!(obj == null || (obj3 = obj.toString()) == null)) {
                    str = obj3;
                }
                Log.v(loggerTag, str, th);
                return;
            }
            if (!(obj == null || (obj2 = obj.toString()) == null)) {
                str = obj2;
            }
            Log.v(loggerTag, str);
        }
    }

    public static final void debug(AnkoLogger ankoLogger, Object obj, Throwable th) {
        String obj2;
        String obj3;
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        String loggerTag = ankoLogger.getLoggerTag();
        if (Log.isLoggable(loggerTag, 3)) {
            String str = "null";
            if (th != null) {
                if (!(obj == null || (obj3 = obj.toString()) == null)) {
                    str = obj3;
                }
                Log.d(loggerTag, str, th);
                return;
            }
            if (!(obj == null || (obj2 = obj.toString()) == null)) {
                str = obj2;
            }
            Log.d(loggerTag, str);
        }
    }

    public static final void info(AnkoLogger ankoLogger, Object obj, Throwable th) {
        String obj2;
        String obj3;
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        String loggerTag = ankoLogger.getLoggerTag();
        if (Log.isLoggable(loggerTag, 4)) {
            String str = "null";
            if (th != null) {
                if (!(obj == null || (obj3 = obj.toString()) == null)) {
                    str = obj3;
                }
                Log.i(loggerTag, str, th);
                return;
            }
            if (!(obj == null || (obj2 = obj.toString()) == null)) {
                str = obj2;
            }
            Log.i(loggerTag, str);
        }
    }

    public static final void warn(AnkoLogger ankoLogger, Object obj, Throwable th) {
        String obj2;
        String obj3;
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        String loggerTag = ankoLogger.getLoggerTag();
        if (Log.isLoggable(loggerTag, 5)) {
            String str = "null";
            if (th != null) {
                if (!(obj == null || (obj3 = obj.toString()) == null)) {
                    str = obj3;
                }
                Log.w(loggerTag, str, th);
                return;
            }
            if (!(obj == null || (obj2 = obj.toString()) == null)) {
                str = obj2;
            }
            Log.w(loggerTag, str);
        }
    }

    public static final void error(AnkoLogger ankoLogger, Object obj, Throwable th) {
        String obj2;
        String obj3;
        Intrinsics.checkParameterIsNotNull(ankoLogger, "$receiver");
        String loggerTag = ankoLogger.getLoggerTag();
        if (Log.isLoggable(loggerTag, 6)) {
            String str = "null";
            if (th != null) {
                if (!(obj == null || (obj3 = obj.toString()) == null)) {
                    str = obj3;
                }
                Log.e(loggerTag, str, th);
                return;
            }
            if (!(obj == null || (obj2 = obj.toString()) == null)) {
                str = obj2;
            }
            Log.e(loggerTag, str);
        }
    }
}
