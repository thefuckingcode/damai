package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* access modifiers changed from: package-private */
/* compiled from: TbsCoreVerManager */
public class k {
    private static k a;
    private static Context b;

    private k() {
    }

    static k a(Context context) {
        if (a == null) {
            synchronized (k.class) {
                if (a == null) {
                    a = new k();
                }
            }
        }
        b = context.getApplicationContext();
        return a;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, int i2) {
        a("copy_core_ver", i);
        a("copy_status", i2);
    }

    /* access modifiers changed from: package-private */
    public void b(int i, int i2) {
        a("tpatch_ver", i);
        a("tpatch_status", i2);
    }

    /* access modifiers changed from: package-private */
    public File a() {
        m.a();
        File file = new File(m.s(b), "tbscoreinstall.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        r1 = null;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        r2 = null;
        r0 = r1;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0040, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d A[ExcHandler: all (r1v5 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0001] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003b A[SYNTHETIC, Splitter:B:25:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0047 A[SYNTHETIC, Splitter:B:32:0x0047] */
    private Properties e() {
        BufferedInputStream bufferedInputStream;
        Properties properties;
        Exception e;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File a2 = a();
            properties = new Properties();
            if (a2 != null) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(a2));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream2 = bufferedInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                        }
                        return properties;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            return properties;
        } catch (Exception e5) {
            bufferedInputStream = null;
            e = e5;
            e.printStackTrace();
            if (bufferedInputStream != null) {
            }
            return properties;
        } catch (Throwable th3) {
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return c("install_core_ver");
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return b("install_status");
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        a("dexopt_retry_num", i);
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        a("unzip_retry_num", i);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        a("install_apk_path", str);
    }

    /* access modifiers changed from: package-private */
    public void c(int i, int i2) {
        a("install_core_ver", i);
        a("install_status", i2);
    }

    /* access modifiers changed from: package-private */
    public void c(int i) {
        a("incrupdate_status", i);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return b("incrupdate_status");
    }

    /* access modifiers changed from: package-private */
    public void d(int i) {
        a("unlzma_status", i);
    }

    /* access modifiers changed from: package-private */
    public int b(String str) {
        Properties e = e();
        if (e == null || e.getProperty(str) == null) {
            return -1;
        }
        return Integer.parseInt(e.getProperty(str));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f A[SYNTHETIC, Splitter:B:26:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    public void a(String str, String str2) {
        Throwable th;
        Exception e;
        FileOutputStream fileOutputStream = null;
        try {
            Properties e2 = e();
            if (e2 != null) {
                e2.setProperty(str, str2);
                File a2 = a();
                if (a2 != null) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                    try {
                        e2.store(fileOutputStream2, "update " + str + " and status!");
                        fileOutputStream = fileOutputStream2;
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream == null) {
                                fileOutputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            if (fileOutputStream == null) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, int i) {
        a(str, String.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public int c(String str) {
        Properties e = e();
        if (e == null || e.getProperty(str) == null) {
            return 0;
        }
        return Integer.parseInt(e.getProperty(str));
    }

    /* access modifiers changed from: package-private */
    public String d(String str) {
        Properties e = e();
        if (e == null || e.getProperty(str) == null) {
            return null;
        }
        return e.getProperty(str);
    }
}
