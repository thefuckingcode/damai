package com.ut.mini.crashhandler;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.lang3.StringUtils;
import tb.ua1;

/* compiled from: Taobao */
public class UTExceptionParser {

    /* compiled from: Taobao */
    public static class UTExceptionItem {
        String mCrashDetail = null;
        boolean mCrashedByUT = false;
        String mExpName = null;
        String mMd5 = null;

        public String getCrashDetail() {
            return this.mCrashDetail;
        }

        public String getExpName() {
            return this.mExpName;
        }

        public String getMd5() {
            return this.mMd5;
        }

        public boolean isCrashedByUT() {
            return this.mCrashedByUT;
        }

        public void setCrashDetail(String str) {
            this.mCrashDetail = str;
        }

        public void setExpName(String str) {
            this.mExpName = str;
        }

        public void setMd5(String str) {
            this.mMd5 = str;
        }

        public void setmCrashedByUT(boolean z) {
            this.mCrashedByUT = z;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0040 */
    public static UTExceptionItem parse(Throwable th) {
        StringWriter stringWriter;
        PrintWriter printWriter;
        String str;
        if (th == null) {
            return null;
        }
        UTExceptionItem uTExceptionItem = new UTExceptionItem();
        Throwable cause = th.getCause();
        if (cause == null) {
            cause = th;
        }
        StackTraceElement[] stackTrace = cause.getStackTrace();
        if (stackTrace.length > 0 && stackTrace[0] != null) {
            String th2 = cause.toString();
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
            try {
                th.printStackTrace(printWriter);
                str = stringWriter.toString();
                try {
                    printWriter.close();
                    stringWriter.close();
                } catch (Exception unused) {
                }
            } catch (Exception unknown) {
                try {
                    printWriter.close();
                    stringWriter.close();
                } catch (Exception unused2) {
                }
                str = "";
            } catch (Throwable th3) {
                try {
                    printWriter.close();
                    stringWriter.close();
                } catch (Exception unused3) {
                }
                throw th3;
            }
            int indexOf = th2.indexOf("}:");
            if (indexOf > 0) {
                th2 = th2.substring(indexOf + 2).trim();
            } else {
                int indexOf2 = th2.indexOf(":");
                if (indexOf2 > 0) {
                    th2 = th2.substring(0, indexOf2);
                }
            }
            uTExceptionItem.setExpName(th2);
            if (!TextUtils.isEmpty(str)) {
                str = str.replaceAll(StringUtils.LF, "++");
            }
            uTExceptionItem.setCrashDetail(str);
            uTExceptionItem.setMd5(ua1.b(str.getBytes()));
            if (str.contains("com.taobao.statistic") || str.contains("com.ut") || str.contains("org.usertrack")) {
                uTExceptionItem.setmCrashedByUT(true);
            } else {
                uTExceptionItem.setmCrashedByUT(false);
            }
        }
        return uTExceptionItem;
    }
}
