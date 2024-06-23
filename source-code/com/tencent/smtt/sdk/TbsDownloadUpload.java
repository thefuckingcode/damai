package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.smtt.sdk.TbsListener;
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

public class TbsDownloadUpload {
    private static TbsDownloadUpload b;
    Map<String, Object> a = new HashMap();
    private Context c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    public SharedPreferences mPreferences;

    public interface TbsUploadKey {
        public static final String KEY_LOCAL_CORE_VERSION = "tbs_local_core_version";
        public static final String KEY_NEEDDOWNLOAD_CODE = "tbs_needdownload_code";
        public static final String KEY_NEEDDOWNLOAD_RETURN = "tbs_needdownload_return";
        public static final String KEY_NEEDDOWNLOAD_SENT = "tbs_needdownload_sent";
        public static final String KEY_STARTDOWNLOAD_CODE = "tbs_startdownload_code";
        public static final String KEY_STARTDOWNLOAD_SENT = "tbs_startdownload_sent";
    }

    public TbsDownloadUpload(Context context) {
        this.mPreferences = context.getSharedPreferences("tbs_download_upload", 4);
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        if (applicationContext == null) {
            this.c = context;
        }
    }

    public static synchronized TbsDownloadUpload getInstance(Context context) {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            if (b == null) {
                b = new TbsDownloadUpload(context);
            }
            tbsDownloadUpload = b;
        }
        return tbsDownloadUpload;
    }

    public static synchronized TbsDownloadUpload getInstance() {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            tbsDownloadUpload = b;
        }
        return tbsDownloadUpload;
    }

    public static synchronized void clear() {
        synchronized (TbsDownloadUpload.class) {
            b = null;
        }
    }

    public void clearUploadCode() {
        this.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 0);
        this.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 0);
        this.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, 0);
        this.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, 0);
        this.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, 0);
        this.a.put(TbsUploadKey.KEY_LOCAL_CORE_VERSION, 0);
        writeTbsDownloadInfo();
    }

    public synchronized int getNeedDownloadCode() {
        if (this.g == 1) {
            return TbsListener.ErrorCode.NEEDDOWNLOAD_9;
        }
        return this.d;
    }

    public synchronized int getLocalCoreVersion() {
        return this.i;
    }

    public synchronized int getStartDownloadCode() {
        if (this.h == 1) {
            return TbsListener.ErrorCode.STARTDOWNLOAD_9;
        }
        return this.e;
    }

    public synchronized int getNeedDownloadReturn() {
        return this.f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1 A[SYNTHETIC, Splitter:B:38:0x00d1] */
    public synchronized void readTbsDownloadInfo(Context context) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        try {
            File a2 = a(this.c, "download_upload");
            if (a2 != null) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(a2));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    String property = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, "");
                    if (!"".equals(property)) {
                        this.d = Math.max(Integer.parseInt(property), 0);
                    }
                    String property2 = properties.getProperty(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, "");
                    if (!"".equals(property2)) {
                        this.e = Math.max(Integer.parseInt(property2), 0);
                    }
                    String property3 = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, "");
                    if (!"".equals(property3)) {
                        this.f = Math.max(Integer.parseInt(property3), 0);
                    }
                    String property4 = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, "");
                    if (!"".equals(property4)) {
                        this.g = Math.max(Integer.parseInt(property4), 0);
                    }
                    String property5 = properties.getProperty(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, "");
                    if (!"".equals(property5)) {
                        this.h = Math.max(Integer.parseInt(property5), 0);
                    }
                    String property6 = properties.getProperty(TbsUploadKey.KEY_LOCAL_CORE_VERSION, "");
                    if (!"".equals(property6)) {
                        this.i = Math.max(Integer.parseInt(property6), 0);
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
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
            bufferedInputStream = null;
            th = th4;
            th.printStackTrace();
            if (bufferedInputStream != null) {
            }
        }
        e.printStackTrace();
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
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.io.BufferedInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: java.util.Properties */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a9 A[SYNTHETIC, Splitter:B:37:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b3 A[SYNTHETIC, Splitter:B:42:0x00b3] */
    public synchronized void writeTbsDownloadInfo() {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        Properties properties;
        TbsLog.i("TbsDownloadUpload", "writeTbsDownloadInfo #1");
        BufferedInputStream bufferedInputStream = 0;
        try {
            File a2 = a(this.c, "download_upload");
            if (a2 != null) {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(a2));
                try {
                    properties = new Properties();
                    properties.load(bufferedInputStream2);
                    for (String str : this.a.keySet()) {
                        Object obj = this.a.get(str);
                        properties.setProperty(str, "" + obj);
                        TbsLog.i("TbsDownloadUpload", "writeTbsDownloadInfo key is " + str + " value is " + obj);
                    }
                    this.a.clear();
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a2));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedInputStream;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (bufferedInputStream != 0) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
                try {
                    properties.store(bufferedOutputStream, (String) bufferedInputStream);
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e5) {
                        e = e5;
                    }
                } catch (Throwable th3) {
                    th = th3;
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
