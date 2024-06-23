package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public abstract class TbsBaseConfig {
    public static final String TAG = "TbsBaseConfig";
    Map<String, String> a;
    private Context b;

    public abstract String getConfigFileName();

    public void init(Context context) {
        this.a = new HashMap();
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        if (applicationContext == null) {
            this.b = context;
        }
        refreshSyncMap(context);
    }

    private static File a(Context context, String str) {
        m.a();
        File s = m.s(context);
        if (s == null) {
            return null;
        }
        File file = new File(s, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clear() {
        this.a.clear();
        commit();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059 A[SYNTHETIC, Splitter:B:24:0x0059] */
    public synchronized void refreshSyncMap(Context context) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        try {
            File a2 = a(this.b, getConfigFileName());
            if (a2 != null) {
                this.a.clear();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(a2));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    for (String str : properties.stringPropertyNames()) {
                        this.a.put(str, properties.getProperty(str));
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                        }
                    } catch (Throwable th3) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th3;
                    }
                }
            }
            return;
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            th.printStackTrace();
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e3) {
                    e = e3;
                }
            }
        }
        e.printStackTrace();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: java.util.Properties */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ae A[SYNTHETIC, Splitter:B:37:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8 A[SYNTHETIC, Splitter:B:42:0x00b8] */
    public synchronized void writeTbsDownloadInfo() {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        TbsLog.i(TAG, "writeTbsDownloadInfo #1");
        BufferedInputStream bufferedInputStream = 0;
        try {
            File a2 = a(this.b, getConfigFileName());
            if (a2 != null) {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(a2));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    properties.clear();
                    for (String str : this.a.keySet()) {
                        String str2 = this.a.get(str);
                        properties.setProperty(str, "" + ((Object) str2));
                        TbsLog.i(TAG, "writeTbsDownloadInfo key is " + str + " value is " + ((Object) str2));
                    }
                    this.a.clear();
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a2));
                    try {
                        properties.store(bufferedOutputStream, (String) bufferedInputStream);
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            th.printStackTrace();
                        } finally {
                            if (bufferedInputStream != 0) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = bufferedInputStream;
                    bufferedInputStream = bufferedInputStream2;
                    th.printStackTrace();
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = bufferedInputStream;
            th.printStackTrace();
        }
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }
}
