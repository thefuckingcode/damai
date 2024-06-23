package com.youku.httpcommunication;

import java.io.File;
import java.io.FileOutputStream;

/* compiled from: Taobao */
class Utils$2 extends Thread {
    final /* synthetic */ String val$content;
    final /* synthetic */ String val$filename;

    Utils$2(String str, String str2) {
        this.val$filename = str;
        this.val$content = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e A[SYNTHETIC, Splitter:B:33:0x006e] */
    public void run() {
        Throwable th;
        File file;
        File file2;
        Exception e;
        FileOutputStream fileOutputStream = null;
        try {
            file2 = new File(c.a);
            try {
                if (!file2.exists()) {
                    a.b("HttpCommunication.Utils", "make dir " + file2.mkdir());
                }
                file = new File(c.a, this.val$filename);
            } catch (Exception e2) {
                e = e2;
                file = null;
                try {
                    a.a("HttpCommunication.Utils", "saveUrlCacheToLocal()", e);
                    if (fileOutputStream != null) {
                    }
                    c.a(file2, file);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            }
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(this.val$content.getBytes("utf-8"));
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e3) {
                        a.a("HttpCommunication.Utils", "saveUrlCacheToLocal()", e3);
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = fileOutputStream2;
                    a.a("HttpCommunication.Utils", "saveUrlCacheToLocal()", e);
                    if (fileOutputStream != null) {
                    }
                    c.a(file2, file);
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                            a.a("HttpCommunication.Utils", "saveUrlCacheToLocal()", e5);
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                a.a("HttpCommunication.Utils", "saveUrlCacheToLocal()", e);
                if (fileOutputStream != null) {
                }
                c.a(file2, file);
            }
        } catch (Exception e7) {
            file2 = null;
            e = e7;
            file = null;
            a.a("HttpCommunication.Utils", "saveUrlCacheToLocal()", e);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            c.a(file2, file);
        }
        c.a(file2, file);
    }
}
