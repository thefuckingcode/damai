package com.youku.arch.v3.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.log.BaseLog;
import com.youku.arch.v3.util.log.JsonLog;
import com.youku.arch.v3.util.log.XmlLog;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import tb.jl1;

/* compiled from: Taobao */
public class LogUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int A = 6;
    public static final int D = 2;
    public static final boolean DEBUG;
    private static final String DEFAULT_MESSAGE = "execute";
    public static final int E = 5;
    public static final int I = 3;
    private static final boolean IS_SHOW_LOG;
    private static final int JSON = 7;
    public static final int JSON_INDENT = 4;
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String NULL = "null";
    public static final String NULL_TIPS = "Log with null object";
    private static final String PARAM = "Param";
    private static final int STACK_TRACE_INDEX_4 = 4;
    private static final int STACK_TRACE_INDEX_5 = 5;
    private static final String SUFFIX = ".java";
    private static final String TAG = "OneArch";
    private static final String TAG_DEFAULT = "OneArch";
    public static final int V = 1;
    public static final int W = 4;
    private static final int XML = 8;
    private static String globalTag;
    private static boolean isGlobalTagEmpty = true;
    private static final boolean sUseFormatLog = false;

    static {
        boolean isDebuggable = AppInfoProviderProxy.isDebuggable();
        DEBUG = isDebuggable;
        IS_SHOW_LOG = isDebuggable;
        init(false, "OneArch");
    }

    public static void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185395602")) {
            ipChange.ipc$dispatch("-1185395602", new Object[0]);
            return;
        }
        printLog(6, null, DEFAULT_MESSAGE);
    }

    public static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185306229")) {
            ipChange.ipc$dispatch("-1185306229", new Object[0]);
        } else {
            Log.d("OneArch", DEFAULT_MESSAGE);
        }
    }

    public static void debug() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1207399364")) {
            ipChange.ipc$dispatch("-1207399364", new Object[0]);
            return;
        }
        printDebug(null, DEFAULT_MESSAGE);
    }

    public static void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185276438")) {
            ipChange.ipc$dispatch("-1185276438", new Object[0]);
        } else {
            Log.e("OneArch", DEFAULT_MESSAGE);
        }
    }

    private static String format(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1113959101")) {
            return String.format(Locale.US, str, objArr);
        }
        return (String) ipChange.ipc$dispatch("1113959101", new Object[]{str, objArr});
    }

    private static String getObjectsString(Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-289038885")) {
            return (String) ipChange.ipc$dispatch("-289038885", new Object[]{objArr});
        } else if (objArr.length > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(StringUtils.LF);
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (obj == null) {
                    sb.append(PARAM);
                    sb.append(jl1.ARRAY_START_STR);
                    sb.append(i);
                    sb.append(jl1.ARRAY_END_STR);
                    sb.append(" = ");
                    sb.append(NULL);
                    sb.append(StringUtils.LF);
                } else {
                    sb.append(PARAM);
                    sb.append(jl1.ARRAY_START_STR);
                    sb.append(i);
                    sb.append(jl1.ARRAY_END_STR);
                    sb.append(" = ");
                    sb.append(obj.toString());
                    sb.append(StringUtils.LF);
                }
            }
            return sb.substring(0);
        } else {
            Object obj2 = objArr[0];
            if (obj2 == null) {
                return NULL;
            }
            return obj2.toString();
        }
    }

    public static void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185157274")) {
            ipChange.ipc$dispatch("-1185157274", new Object[0]);
        } else {
            Log.i("OneArch", DEFAULT_MESSAGE);
        }
    }

    public static void init(boolean z, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1307789459")) {
            ipChange.ipc$dispatch("1307789459", new Object[]{Boolean.valueOf(z), str});
            return;
        }
        globalTag = str;
        isGlobalTagEmpty = TextUtils.isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-645242214")) {
            return TextUtils.isEmpty(str) || StringUtils.LF.equals(str) || "\t".equals(str) || TextUtils.isEmpty(str.trim());
        }
        return ((Boolean) ipChange.ipc$dispatch("-645242214", new Object[]{str})).booleanValue();
    }

    public static boolean isIsShowLog() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "660401824") ? ((Boolean) ipChange.ipc$dispatch("660401824", new Object[0])).booleanValue() : IS_SHOW_LOG;
    }

    public static void json(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1717957283")) {
            ipChange.ipc$dispatch("-1717957283", new Object[]{str});
            return;
        }
        printLog(7, null, str);
    }

    private static void printDebug(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2020691982")) {
            ipChange.ipc$dispatch("-2020691982", new Object[]{str, objArr});
            return;
        }
        String[] wrapperContent = wrapperContent(5, str, objArr);
        String str2 = wrapperContent[0];
        String str3 = wrapperContent[1];
        String str4 = wrapperContent[2];
        BaseLog.printDefault(2, str2, str4 + str3);
    }

    public static void printLine(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "95976700")) {
            ipChange.ipc$dispatch("95976700", new Object[]{str, Boolean.valueOf(z)});
        } else if (z) {
            Log.d(str, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.d(str, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }

    private static void printLog(int i, String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "689737096")) {
            ipChange.ipc$dispatch("689737096", new Object[]{Integer.valueOf(i), str, objArr});
        } else if (IS_SHOW_LOG) {
            String[] wrapperContent = wrapperContent(5, str, objArr);
            String str2 = wrapperContent[0];
            String str3 = wrapperContent[1];
            String str4 = wrapperContent[2];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    BaseLog.printDefault(i, str2, str4 + str3);
                    return;
                case 7:
                    JsonLog.printJson(str2, str3, str4);
                    return;
                case 8:
                    XmlLog.printXml(str2, str3, str4);
                    return;
                default:
                    return;
            }
        }
    }

    public static void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1184769991")) {
            ipChange.ipc$dispatch("-1184769991", new Object[0]);
        } else {
            Log.v("OneArch", DEFAULT_MESSAGE);
        }
    }

    public static void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1184740200")) {
            ipChange.ipc$dispatch("-1184740200", new Object[0]);
        } else {
            Log.w("OneArch", DEFAULT_MESSAGE);
        }
    }

    private static String[] wrapperContent(int i, String str, Object... objArr) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "74284648")) {
            return (String[]) ipChange.ipc$dispatch("74284648", new Object[]{Integer.valueOf(i), str, objArr});
        }
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[i];
        String className = stackTraceElement.getClassName();
        String[] split = className.split("\\.");
        if (split.length > 0) {
            className = split[split.length - 1] + SUFFIX;
        }
        if (className.contains("$")) {
            className = className.split("\\$")[0] + SUFFIX;
        }
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        if (lineNumber < 0) {
            lineNumber = 0;
        }
        if (str == null) {
            str = className;
        }
        if (isGlobalTagEmpty && TextUtils.isEmpty(str)) {
            str = "OneArch";
        }
        if (objArr == null) {
            str2 = NULL_TIPS;
        } else {
            str2 = getObjectsString(objArr);
        }
        return new String[]{str, str2, "[ (" + className + ":" + lineNumber + ")#" + methodName + " ] "};
    }

    public static void xml(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1209598398")) {
            ipChange.ipc$dispatch("-1209598398", new Object[]{str});
            return;
        }
        printLog(8, null, str);
    }

    public static void a(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1020738762")) {
            ipChange.ipc$dispatch("1020738762", new Object[]{obj});
            return;
        }
        printLog(6, null, obj);
    }

    public static void d(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-798462809")) {
            ipChange.ipc$dispatch("-798462809", new Object[]{obj});
        } else if (obj != null) {
            Log.d("OneArch", obj.toString());
        }
    }

    public static void debug(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1555064088")) {
            ipChange.ipc$dispatch("1555064088", new Object[]{obj});
            return;
        }
        printDebug(null, obj);
    }

    public static void e(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1458448198")) {
            ipChange.ipc$dispatch("1458448198", new Object[]{obj});
        } else if (obj != null) {
            Log.e("OneArch", obj.toString());
        }
    }

    public static void i(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896157634")) {
            ipChange.ipc$dispatch("1896157634", new Object[]{obj});
        } else if (obj != null) {
            Log.i("OneArch", obj.toString());
        }
    }

    public static void json(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "129726951")) {
            ipChange.ipc$dispatch("129726951", new Object[]{str, str2});
            return;
        }
        printLog(7, str, str2);
    }

    public static void v(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1171229653")) {
            ipChange.ipc$dispatch("1171229653", new Object[]{obj});
        } else if (obj != null) {
            Log.v("OneArch", obj.toString());
        }
    }

    public static void w(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-866826636")) {
            ipChange.ipc$dispatch("-866826636", new Object[]{obj});
        } else if (obj != null) {
            Log.w("OneArch", obj.toString());
        }
    }

    public static void xml(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1612045196")) {
            ipChange.ipc$dispatch("1612045196", new Object[]{str, str2});
            return;
        }
        printLog(8, str, str2);
    }

    public static void a(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112716153")) {
            ipChange.ipc$dispatch("112716153", new Object[]{str, objArr});
            return;
        }
        printLog(6, str, objArr);
    }

    public static void d(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399297412")) {
            ipChange.ipc$dispatch("-1399297412", new Object[]{str, objArr});
            return;
        }
        StringBuilder obtainStringBuilder = SynchronizedPoolHelper.obtainStringBuilder();
        for (Object obj : objArr) {
            obtainStringBuilder.append(obj);
            obtainStringBuilder.append(" ");
        }
        String substring = obtainStringBuilder.substring(0);
        SynchronizedPoolHelper.recycleStringBuilder(obtainStringBuilder);
        Log.d(str, substring);
    }

    public static void debug(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453841515")) {
            ipChange.ipc$dispatch("453841515", new Object[]{str, objArr});
            return;
        }
        printDebug(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960009597")) {
            ipChange.ipc$dispatch("960009597", new Object[]{str, objArr});
            return;
        }
        StringBuilder obtainStringBuilder = SynchronizedPoolHelper.obtainStringBuilder();
        for (Object obj : objArr) {
            obtainStringBuilder.append(obj);
            obtainStringBuilder.append(" ");
        }
        String substring = obtainStringBuilder.substring(0);
        SynchronizedPoolHelper.recycleStringBuilder(obtainStringBuilder);
        Log.e(str, substring);
    }

    public static void i(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807303041")) {
            ipChange.ipc$dispatch("1807303041", new Object[]{str, objArr});
            return;
        }
        StringBuilder obtainStringBuilder = SynchronizedPoolHelper.obtainStringBuilder();
        for (Object obj : objArr) {
            obtainStringBuilder.append(obj);
            obtainStringBuilder.append(" ");
        }
        String substring = obtainStringBuilder.substring(0);
        SynchronizedPoolHelper.recycleStringBuilder(obtainStringBuilder);
        Log.i(str, substring);
    }

    public static void v(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1881444210")) {
            ipChange.ipc$dispatch("-1881444210", new Object[]{str, objArr});
            return;
        }
        StringBuilder obtainStringBuilder = SynchronizedPoolHelper.obtainStringBuilder();
        for (Object obj : objArr) {
            obtainStringBuilder.append(obj);
            obtainStringBuilder.append(" ");
        }
        String substring = obtainStringBuilder.substring(0);
        SynchronizedPoolHelper.recycleStringBuilder(obtainStringBuilder);
        Log.v(str, substring);
    }

    public static void w(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "477862799")) {
            ipChange.ipc$dispatch("477862799", new Object[]{str, objArr});
            return;
        }
        StringBuilder obtainStringBuilder = SynchronizedPoolHelper.obtainStringBuilder();
        for (Object obj : objArr) {
            obtainStringBuilder.append(obj);
            obtainStringBuilder.append(" ");
        }
        String substring = obtainStringBuilder.substring(0);
        SynchronizedPoolHelper.recycleStringBuilder(obtainStringBuilder);
        Log.w(str, substring);
    }

    public static void d(Throwable th, String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2024787997")) {
            ipChange.ipc$dispatch("2024787997", new Object[]{th, str, objArr});
            return;
        }
        Log.d("OneArch", format(str, objArr), th);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216940476")) {
            ipChange.ipc$dispatch("216940476", new Object[]{th, str, objArr});
            return;
        }
        Log.e("OneArch", format(str, objArr), th);
    }

    public static void i(Throwable th, String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575484984")) {
            ipChange.ipc$dispatch("1575484984", new Object[]{th, str, objArr});
            return;
        }
        Log.i("OneArch", format(str, objArr), th);
    }

    public static void v(Throwable th, String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-451696309")) {
            ipChange.ipc$dispatch("-451696309", new Object[]{th, str, objArr});
            return;
        }
        Log.v("OneArch", format(str, objArr), th);
    }

    public static void w(Throwable th, String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035423466")) {
            ipChange.ipc$dispatch("2035423466", new Object[]{th, str, objArr});
            return;
        }
        Log.w("OneArch", format(str, objArr), th);
    }
}
