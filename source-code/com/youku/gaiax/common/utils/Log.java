package com.youku.gaiax.common.utils;

import com.youku.gaiax.impl.utils.PropUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\t¨\u0006\u0011"}, d2 = {"Lcom/youku/gaiax/common/utils/Log;", "", "", "tag", "msg", "Ltb/ur2;", "longE", "d", "e", "", "isLog", "isJSLog", "isLaunchLog", "isMonitorLog", "isTimeLog", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class Log {
    @NotNull
    public static final Log INSTANCE = new Log();

    private Log() {
    }

    private final void longE(String str, String str2) {
        int length = str2.length() / 1000;
        if (length >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                int i3 = i * 1000;
                int i4 = i2 * 1000;
                if (i4 > str2.length()) {
                    i4 = str2.length();
                }
                String substring = str2.substring(i3, i4);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                android.util.Log.e(str, substring);
                if (i != length) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    public final void d(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            str = "[GaiaX]";
        }
        if (str2 == null) {
            str2 = "";
        }
        longE(str, str2);
    }

    public final void e(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            str = "[GaiaX]";
        }
        if (str2 == null) {
            str2 = "";
        }
        longE(str, str2);
    }

    public final boolean isJSLog() {
        return PropUtils.INSTANCE.isJSLog();
    }

    public final boolean isLaunchLog() {
        return PropUtils.INSTANCE.isLaunchLog();
    }

    public final boolean isLog() {
        return PropUtils.INSTANCE.isLog();
    }

    public final boolean isMonitorLog() {
        return PropUtils.INSTANCE.isMonitorLog();
    }

    public final boolean isTimeLog() {
        return PropUtils.INSTANCE.isTimeLog();
    }
}
