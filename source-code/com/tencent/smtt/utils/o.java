package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/* compiled from: TbsConfigFile */
public class o {
    private static o e;
    public boolean a = false;
    private Context b = null;
    private File c = null;
    private boolean d = false;
    private File f = null;

    public static synchronized o a(Context context) {
        o oVar;
        synchronized (o.class) {
            if (e == null) {
                e = new o(context);
            }
            oVar = e;
        }
        return oVar;
    }

    private o(Context context) {
        this.b = context.getApplicationContext();
        b();
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            oVar = e;
        }
        return oVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e A[SYNTHETIC, Splitter:B:26:0x004e] */
    public synchronized void b() {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        try {
            if (this.f == null) {
                this.f = d();
            }
            if (this.f != null) {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(this.f));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("setting_forceUseSystemWebview", "");
                    if (!"".equals(property)) {
                        this.a = Boolean.parseBoolean(property);
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e3) {
                                e = e3;
                            }
                        }
                    } catch (Throwable th3) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th3;
                    }
                }
            }
            return;
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            if (bufferedInputStream != null) {
            }
        }
        e.printStackTrace();
    }

    private File d() {
        try {
            if (this.c == null) {
                File file = new File(QbSdk.getTbsFolderDir(this.b), "core_private");
                this.c = file;
                if (file == null || !file.isDirectory()) {
                    return null;
                }
            }
            File file2 = new File(this.c, "debug.conf");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a(boolean z) {
        this.d = z;
        c();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.BufferedInputStream, java.io.BufferedOutputStream] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void c() {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        ?? r0 = 0;
        try {
            File d2 = d();
            if (d2 == null) {
                try {
                    r0.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    r0.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } else {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(d2));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.a));
                    properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.d));
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(d2));
                    try {
                        properties.store(bufferedOutputStream, (String) null);
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                            bufferedOutputStream.close();
                        } catch (Throwable th3) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e8) {
                                e8.printStackTrace();
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    bufferedOutputStream = null;
                    th = th4;
                    th.printStackTrace();
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                }
            }
        } catch (Throwable th5) {
            bufferedInputStream = null;
            th = th5;
            bufferedOutputStream = null;
            th.printStackTrace();
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }
}
