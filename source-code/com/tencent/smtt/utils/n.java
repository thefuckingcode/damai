package com.tencent.smtt.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/* compiled from: TbsCommonConfig */
public class n {
    private static n c;
    private Context a = null;
    private File b = null;
    private String d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    private String e = "http://log.tbs.qq.com/ajax?c=pu&tk=";
    private String f = "http://wup.imtt.qq.com:8080";
    private String g = "http://log.tbs.qq.com/ajax?c=dl&k=";
    private String h = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    private String i = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    private String j = "http://mqqad.html5.qq.com/adjs";
    private String k = "http://log.tbs.qq.com/ajax?c=ucfu&k=";

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (c == null) {
                c = new n(context);
            }
            nVar = c;
        }
        return nVar;
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            nVar = c;
        }
        return nVar;
    }

    private n(Context context) {
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.a = context.getApplicationContext();
        g();
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00eb A[SYNTHETIC, Splitter:B:45:0x00eb] */
    private synchronized void g() {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        try {
            File h2 = h();
            if (h2 == null) {
                TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
                return;
            }
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(h2));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                String property = properties.getProperty("pv_post_url", "");
                if (!"".equals(property)) {
                    this.d = property;
                }
                String property2 = properties.getProperty("wup_proxy_domain", "");
                if (!"".equals(property2)) {
                    this.f = property2;
                }
                String property3 = properties.getProperty("tbs_download_stat_post_url", "");
                if (!"".equals(property3)) {
                    this.g = property3;
                }
                String property4 = properties.getProperty("tbs_downloader_post_url", "");
                if (!"".equals(property4)) {
                    this.h = property4;
                }
                String property5 = properties.getProperty("tbs_log_post_url", "");
                if (!"".equals(property5)) {
                    this.i = property5;
                }
                String property6 = properties.getProperty("tips_url", "");
                if (!"".equals(property6)) {
                    this.j = property6;
                }
                String property7 = properties.getProperty("tbs_cmd_post_url", "");
                if (!"".equals(property7)) {
                    this.k = property7;
                }
                String property8 = properties.getProperty("pv_post_url_tk", "");
                if (!"".equals(property8)) {
                    this.e = property8;
                }
                try {
                    bufferedInputStream2.close();
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                try {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    TbsLog.e("TbsCommonConfig", "exceptions occurred1:" + stringWriter.toString());
                    if (bufferedInputStream != null) {
                    }
                } catch (Throwable th3) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            StringWriter stringWriter2 = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter2));
            TbsLog.e("TbsCommonConfig", "exceptions occurred1:" + stringWriter2.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e4) {
                    e = e4;
                }
            }
        }
        e.printStackTrace();
    }

    private File h() {
        Throwable th;
        File file = null;
        try {
            if (this.b == null) {
                String str = this.a.getApplicationContext().getApplicationInfo().packageName;
                if (!TextUtils.isEmpty(str)) {
                    boolean z = true;
                    boolean z2 = this.a.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", str) == 0;
                    if (this.a.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", str) != 0) {
                        z = false;
                    }
                    if (!z2) {
                        if (!z) {
                            this.b = new File(f.a(this.a, 8));
                        }
                    }
                    TbsLog.i("TbsCommonConfig", "no permission,use sdcard default folder");
                    this.b = new File(f.a(this.a, 5));
                } else {
                    this.b = new File(f.a(this.a, 8));
                }
                File file2 = this.b;
                if (file2 == null || !file2.isDirectory()) {
                    return null;
                }
            }
            File file3 = new File(this.b, "tbsnet.conf");
            if (!file3.exists()) {
                TbsLog.e("TbsCommonConfig", "Get file(" + file3.getCanonicalPath() + ") failed!");
                return null;
            }
            try {
                TbsLog.w("TbsCommonConfig", "pathc:" + file3.getCanonicalPath());
                return file3;
            } catch (Throwable th2) {
                th = th2;
                file = file3;
            }
        } catch (Throwable th3) {
            th = th3;
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
            return file;
        }
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public String e() {
        return this.i;
    }

    public String f() {
        return this.e;
    }
}
