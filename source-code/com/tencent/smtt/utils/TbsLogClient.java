package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TbsLogClient {
    static TbsLogClient a = null;
    static File c = null;
    static String d = null;
    static byte[] e = null;
    private static boolean i = true;
    TextView b;
    private SimpleDateFormat f = null;
    private Context g = null;
    private StringBuffer h = new StringBuffer();

    public void d(String str, String str2) {
    }

    public void e(String str, String str2) {
    }

    public void i(String str, String str2) {
    }

    public void v(String str, String str2) {
    }

    public void w(String str, String str2) {
    }

    public TbsLogClient(Context context) {
        try {
            this.g = context.getApplicationContext();
            this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception unused) {
            this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
    }

    private void a() {
        try {
            if (c != null) {
                return;
            }
            if (Environment.getExternalStorageState().equals("mounted")) {
                String a2 = f.a(this.g, 6);
                if (a2 == null) {
                    c = null;
                    return;
                }
                c = new File(a2, "tbslog.txt");
                d = LogFileUtils.createKey();
                e = LogFileUtils.createHeaderText(c.getName(), d);
                return;
            }
            c = null;
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (NullPointerException e3) {
            e3.printStackTrace();
        }
    }

    public void writeLog(String str) {
        try {
            String format = this.f.format(Long.valueOf(System.currentTimeMillis()));
            StringBuffer stringBuffer = this.h;
            stringBuffer.append(format);
            stringBuffer.append(" pid=");
            stringBuffer.append(Process.myPid());
            stringBuffer.append(" tid=");
            stringBuffer.append(Process.myTid());
            stringBuffer.append(str);
            stringBuffer.append("\n");
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || i) {
                writeLogToDisk();
            }
            if (this.h.length() > 524288) {
                StringBuffer stringBuffer2 = this.h;
                stringBuffer2.delete(0, stringBuffer2.length());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void writeLogToDisk() {
        try {
            a();
            File file = c;
            if (file != null) {
                LogFileUtils.writeDataToStorage(file, d, e, this.h.toString(), true);
                StringBuffer stringBuffer = this.h;
                stringBuffer.delete(0, stringBuffer.length());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public class a implements Runnable {
        String a = null;

        a(String str) {
            this.a = str;
        }

        public void run() {
            if (TbsLogClient.this.b != null) {
                TextView textView = TbsLogClient.this.b;
                textView.append(this.a + "\n");
            }
        }
    }

    public void showLog(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.post(new a(str));
        }
    }

    public void setLogView(TextView textView) {
        this.b = textView;
    }

    public static void setWriteLogJIT(boolean z) {
        i = z;
    }
}
