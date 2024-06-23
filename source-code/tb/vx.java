package tb;

import com.taobao.android.dinamicx.DinamicXEngine;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: Taobao */
public class vx {
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002a A[SYNTHETIC, Splitter:B:21:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0032 A[Catch:{ IOException -> 0x002e }] */
    public static String a(Throwable th) {
        StringWriter stringWriter;
        PrintWriter printWriter;
        if (th == null) {
            return "";
        }
        PrintWriter printWriter2 = null;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
            } catch (Throwable unused) {
                if (printWriter2 != null) {
                }
                if (stringWriter != null) {
                }
                return "DXExceptionUtil getStackTrace Exception";
            }
            try {
                th.printStackTrace(printWriter);
                String stringWriter2 = stringWriter.toString();
                try {
                    printWriter.close();
                    stringWriter.close();
                } catch (IOException e) {
                    b(e);
                }
                return stringWriter2;
            } catch (Throwable unused2) {
                printWriter2 = printWriter;
                if (printWriter2 != null) {
                    try {
                        printWriter2.close();
                    } catch (IOException e2) {
                        b(e2);
                        return "DXExceptionUtil getStackTrace Exception";
                    }
                }
                if (stringWriter != null) {
                    stringWriter.close();
                }
                return "DXExceptionUtil getStackTrace Exception";
            }
        } catch (Throwable unused3) {
            stringWriter = null;
            if (printWriter2 != null) {
            }
            if (stringWriter != null) {
            }
            return "DXExceptionUtil getStackTrace Exception";
        }
    }

    public static void b(Throwable th) {
        c(th, true);
    }

    public static void c(Throwable th, boolean z) {
        if (DinamicXEngine.x() && th != null) {
            th.printStackTrace();
            if (z && at.n0()) {
                throw new RuntimeException(th);
            }
        }
    }
}
