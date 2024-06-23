package okhttp3.internal.platform.android;

import android.util.Log;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"MAX_LOG_LENGTH", "", "androidLog", "", "level", "message", "", "t", "", "okhttp"}, k = 2, mv = {1, 1, 16})
/* compiled from: util.kt */
public final class UtilKt {
    private static final int MAX_LOG_LENGTH = 4000;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0054, code lost:
        r7 = r2 + 1;
     */
    public static final void androidLog(int i, String str, Throwable th) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            str = str + "\n" + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '\n', i3, false, 4, (Object) null);
            if (indexOf$default == -1) {
                indexOf$default = length;
            }
            while (true) {
                int min = Math.min(indexOf$default, i3 + MAX_LOG_LENGTH);
                if (str != null) {
                    String substring = str.substring(i3, min);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i2, "OkHttp", substring);
                    if (min >= indexOf$default) {
                        break;
                    }
                    i3 = min;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
        }
    }
}
