package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.lzy.okgo.model.HttpHeaders;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.h;
import com.tencent.smtt.utils.l;
import com.tencent.smtt.utils.n;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;

public class TbsLogReport {
    private static TbsLogReport a;
    private Handler b = null;
    private Context c;
    private boolean d = false;

    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5),
        TYPE_SDK_REPORT_INFO(6);
        
        int a;

        private EventType(int i) {
            this.a = i;
        }
    }

    private TbsLogReport(Context context) {
        this.c = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper()) {
            /* class com.tencent.smtt.sdk.TbsLogReport.AnonymousClass1 */

            public void handleMessage(Message message) {
                if (message.what == 600) {
                    if (message.obj instanceof TbsLogInfo) {
                        try {
                            int i = message.arg1;
                            TbsLogReport.this.a(i, (TbsLogInfo) message.obj);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (message.what == 601) {
                    TbsLogReport.this.b();
                }
            }
        };
    }

    public static TbsLogReport getInstance(Context context) {
        if (a == null) {
            synchronized (TbsLogReport.class) {
                if (a == null) {
                    a = new TbsLogReport(context);
                }
            }
        }
        return a;
    }

    public static class TbsLogInfo implements Cloneable {
        int a;
        private long b;
        private String c;
        private String d;
        private int e;
        private int f;
        private int g;
        private int h;
        private String i;
        private int j;
        private int k;
        private long l;
        private long m;
        private int n;
        private String o;
        private String p;
        private long q;

        private TbsLogInfo() {
            resetArgs();
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.Object
        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException unused) {
                return this;
            }
        }

        public void resetArgs() {
            this.b = 0;
            this.c = null;
            this.d = null;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 2;
            this.i = EnvironmentCompat.MEDIA_UNKNOWN;
            this.j = 0;
            this.k = 2;
            this.l = 0;
            this.m = 0;
            this.n = 1;
            this.a = 0;
            this.o = null;
            this.p = null;
            this.q = 0;
        }

        public void setEventTime(long j2) {
            this.b = j2;
        }

        public void setDownloadUrl(String str) {
            if (this.c == null) {
                this.c = str;
                return;
            }
            this.c += ";" + str;
        }

        public void setResolveIp(String str) {
            this.d = str;
        }

        public void setHttpCode(int i2) {
            this.e = i2;
        }

        public void setPatchUpdateFlag(int i2) {
            this.f = i2;
        }

        public void setDownloadCancel(int i2) {
            this.g = i2;
        }

        public void setUnpkgFlag(int i2) {
            this.h = i2;
        }

        public void setApn(String str) {
            this.i = str;
        }

        public void setNetworkType(int i2) {
            this.j = i2;
        }

        public void setDownFinalFlag(int i2) {
            this.k = i2;
        }

        public int getDownFinalFlag() {
            return this.k;
        }

        public void setPkgSize(long j2) {
            this.l = j2;
        }

        public void setDownConsumeTime(long j2) {
            this.m += j2;
        }

        public void setNetworkChange(int i2) {
            this.n = i2;
        }

        public void setErrorCode(int i2) {
            if (!(i2 == 100 || i2 == 110 || i2 == 120 || i2 == 111 || i2 >= 400)) {
                TbsLog.i(TbsDownloader.LOGTAG, "error occured, errorCode:" + i2, true);
            }
            if (i2 == 111) {
                TbsLog.i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.a = i2;
        }

        public void setCheckErrorDetail(String str) {
            setErrorCode(108);
            this.o = str;
        }

        public void setFailDetail(String str) {
            if (str != null) {
                if (str.length() > 1024) {
                    str = str.substring(0, 1024);
                }
                this.p = str;
            }
        }

        public void setFailDetail(Throwable th) {
            if (th == null) {
                this.p = "";
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > 1024) {
                stackTraceString = stackTraceString.substring(0, 1024);
            }
            this.p = stackTraceString;
        }

        public void setDownloadSize(long j2) {
            this.q += j2;
        }
    }

    public TbsLogInfo tbsLogInfo() {
        return new TbsLogInfo();
    }

    public void setInstallErrorCode(int i, String str) {
        setInstallErrorCode(i, str, EventType.TYPE_INSTALL);
    }

    public void setInstallErrorCode(int i, String str, EventType eventType) {
        if (!(i == 200 || i == 220 || i == 221)) {
            TbsLog.i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:" + i, true);
        }
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        a(i, tbsLogInfo, eventType);
    }

    private void a(int i, TbsLogInfo tbsLogInfo, EventType eventType) {
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.m.onInstallFinish(i);
        eventReport(eventType, tbsLogInfo);
    }

    public void setInstallErrorCode(int i, Throwable th) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th);
        a(i, tbsLogInfo, EventType.TYPE_INSTALL);
    }

    public void setLoadErrorCode(int i, String str) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(EventType.TYPE_LOAD, tbsLogInfo);
    }

    public void setLoadErrorCode(int i, Throwable th) {
        String str;
        if (th != null) {
            str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
        } else {
            str = "NULL";
        }
        setLoadErrorCode(i, str);
    }

    public void dailyReport() {
        this.b.sendEmptyMessage(601);
    }

    public void eventReport(EventType eventType, TbsLogInfo tbsLogInfo) {
        try {
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 600;
            obtainMessage.arg1 = eventType.a;
            obtainMessage.obj = (TbsLogInfo) tbsLogInfo.clone();
            this.b.sendMessage(obtainMessage);
        } catch (Throwable th) {
            TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(int i, TbsLogInfo tbsLogInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(i));
        sb.append(a(b.d(this.c)));
        sb.append(a(l.a(this.c)));
        sb.append(a(m.a().i(this.c)));
        String str = Build.MODEL;
        try {
            str = new String(str.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        sb.append(a(str));
        String packageName = this.c.getPackageName();
        sb.append(a(packageName));
        if (TbsConfig.APP_WX.equals(packageName)) {
            sb.append(a(b.a(this.c, TbsDownloader.TBS_METADATA)));
        } else {
            sb.append(a(b.b(this.c)));
        }
        sb.append(a(a(tbsLogInfo.b)));
        sb.append(a(tbsLogInfo.c));
        sb.append(a(tbsLogInfo.d));
        sb.append(a(tbsLogInfo.e));
        sb.append(a(tbsLogInfo.f));
        sb.append(a(tbsLogInfo.g));
        sb.append(a(tbsLogInfo.h));
        sb.append(a(tbsLogInfo.i));
        sb.append(a(tbsLogInfo.j));
        sb.append(a(tbsLogInfo.k));
        sb.append(b(tbsLogInfo.q));
        sb.append(b(tbsLogInfo.l));
        sb.append(b(tbsLogInfo.m));
        sb.append(a(tbsLogInfo.n));
        sb.append(a(tbsLogInfo.a));
        sb.append(a(tbsLogInfo.o));
        sb.append(a(tbsLogInfo.p));
        sb.append(a(TbsDownloadConfig.getInstance(this.c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        sb.append(a(b.g(this.c)));
        sb.append(a("4.3.0.3_43903"));
        sb.append(false);
        SharedPreferences d2 = d();
        JSONArray a2 = a();
        JSONArray jSONArray = new JSONArray();
        if (jSONArray.length() >= 5) {
            for (int i2 = 4; i2 >= 1; i2--) {
                try {
                    jSONArray.put(a2.get(jSONArray.length() - i2));
                } catch (Exception unused2) {
                    TbsLog.e("upload", "JSONArray transform error!");
                }
            }
            a2 = jSONArray;
        }
        a2.put(sb.toString());
        SharedPreferences.Editor edit = d2.edit();
        edit.putString("tbs_download_upload", a2.toString());
        edit.commit();
        if (this.d || i != EventType.TYPE_LOAD.a) {
            b();
        }
    }

    private JSONArray a() {
        String string = d().getString("tbs_download_upload", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() > 5) {
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length() - 1;
                if (length > jSONArray.length() - 5) {
                    jSONArray2.put(jSONArray.get(length));
                    return jSONArray2;
                }
            }
            return jSONArray;
        } catch (Exception unused) {
            return new JSONArray();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0130, code lost:
        if (r0 != null) goto L_0x0105;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0102 */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0124 A[SYNTHETIC, Splitter:B:54:0x0124] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012b A[SYNTHETIC, Splitter:B:58:0x012b] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0154 A[SYNTHETIC, Splitter:B:67:0x0154] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x015b A[SYNTHETIC, Splitter:B:71:0x015b] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0162  */
    public void reportTbsLog() {
        String tbsLogFilePath;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        File file;
        FileInputStream fileInputStream;
        Exception e;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        if (QbSdk.n != null && QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("upload", "[TbsLogReport.reportTbsLog] -- SET_SENDREQUEST_AND_UPLOAD is false");
        } else if (Apn.getApnType(this.c) == 3 && (tbsLogFilePath = TbsLog.getTbsLogFilePath()) != null) {
            String b2 = h.a().b();
            String d2 = b.d(this.c);
            String g = b.g(this.c);
            byte[] bytes = d2.getBytes();
            byte[] bytes2 = g.getBytes();
            try {
                bytes = h.a().a(bytes);
                bytes2 = h.a().a(bytes2);
            } catch (Exception unused) {
            }
            String str = n.a(this.c).e() + h.b(bytes) + "&aid=" + h.b(bytes2);
            HashMap hashMap = new HashMap();
            hashMap.put(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/octet-stream");
            hashMap.put("Charset", "UTF-8");
            hashMap.put("QUA2", l.a(this.c));
            byte[] bArr = null;
            r5 = null;
            FileInputStream fileInputStream3 = null;
            bArr = null;
            try {
                new File(f.a);
                new a(tbsLogFilePath, f.a + "/tbslog_temp.zip").a();
                file = new File(f.a, "tbslog_temp.zip");
                try {
                    FileInputStream fileInputStream4 = new FileInputStream(file);
                    try {
                        byte[] bArr2 = new byte[8192];
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = fileInputStream4.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (Exception e2) {
                                e = e2;
                                fileInputStream2 = fileInputStream4;
                                try {
                                    e.printStackTrace();
                                    if (fileInputStream2 != 0) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    fileInputStream3 = fileInputStream;
                                    if (fileInputStream3 != null) {
                                        try {
                                            fileInputStream3.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    if (file != null) {
                                        file.delete();
                                    }
                                    throw th;
                                }
                            }
                        }
                        byteArrayOutputStream.flush();
                        bArr = h.a().a(byteArrayOutputStream.toByteArray());
                        fileInputStream4.close();
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused4) {
                        }
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayOutputStream = null;
                        fileInputStream2 = fileInputStream4;
                        e.printStackTrace();
                        if (fileInputStream2 != 0) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                        fileInputStream = fileInputStream4;
                        fileInputStream3 = fileInputStream;
                        if (fileInputStream3 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        if (file != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    byteArrayOutputStream2 = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    fileInputStream2 = byteArrayOutputStream2;
                    e.printStackTrace();
                    if (fileInputStream2 != 0) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused6) {
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    if (fileInputStream3 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (file != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                file = null;
                byteArrayOutputStream2 = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                fileInputStream2 = byteArrayOutputStream2;
                e.printStackTrace();
                if (fileInputStream2 != 0) {
                }
                if (byteArrayOutputStream != null) {
                }
            } catch (Throwable th5) {
                th = th5;
                file = null;
                byteArrayOutputStream = null;
                if (fileInputStream3 != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                if (file != null) {
                }
                throw th;
            }
            file.delete();
            g.a(str + "&ek=" + b2, hashMap, bArr, new g.a() {
                /* class com.tencent.smtt.sdk.TbsLogReport.AnonymousClass2 */

                @Override // com.tencent.smtt.utils.g.a
                public void a(int i) {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=" + i);
                }
            }, false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b() {
        if (QbSdk.n == null || !QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) || !QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
            JSONArray a2 = a();
            if (a2 == null || a2.length() == 0) {
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] no data");
                return;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + a2);
            try {
                String a3 = g.a(n.a(this.c).c(), a2.toString().getBytes("utf-8"), new g.a() {
                    /* class com.tencent.smtt.sdk.TbsLogReport.AnonymousClass3 */

                    @Override // com.tencent.smtt.utils.g.a
                    public void a(int i) {
                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
                        if (i < 300) {
                            TbsLogReport.this.c();
                        }
                    }
                }, true);
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + a3 + " testcase: " + -1);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        SharedPreferences.Editor edit = d().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
    }

    private String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception unused) {
            return null;
        }
    }

    private SharedPreferences d() {
        return this.c.getSharedPreferences("tbs_download_stat", 4);
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append("|");
        return sb.toString();
    }

    private String a(int i) {
        return i + "|";
    }

    private String b(long j) {
        return j + "|";
    }

    public void clear() {
        try {
            SharedPreferences.Editor edit = d().edit();
            edit.clear();
            edit.commit();
        } catch (Exception unused) {
        }
    }

    private static class a {
        private final String a;
        private final String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x006f A[SYNTHETIC, Splitter:B:40:0x006f] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0079 A[SYNTHETIC, Splitter:B:45:0x0079] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0098 A[SYNTHETIC, Splitter:B:57:0x0098] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x00a2 A[SYNTHETIC, Splitter:B:62:0x00a2] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x00c5 A[SYNTHETIC, Splitter:B:79:0x00c5] */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x00db A[SYNTHETIC, Splitter:B:89:0x00db] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x00e5 A[SYNTHETIC, Splitter:B:94:0x00e5] */
        public void a() {
            ZipOutputStream zipOutputStream;
            FileOutputStream fileOutputStream;
            Throwable th;
            Exception e;
            BufferedInputStream bufferedInputStream;
            FileInputStream fileInputStream;
            Throwable th2;
            Exception e2;
            Exception e3;
            Throwable th3;
            try {
                fileOutputStream = new FileOutputStream(this.b);
                try {
                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                    try {
                        byte[] bArr = new byte[2048];
                        String str = this.a;
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                bufferedInputStream = new BufferedInputStream(fileInputStream, 2048);
                            } catch (Exception e4) {
                                e3 = e4;
                                bufferedInputStream = null;
                                e2 = e3;
                                try {
                                    e2.printStackTrace();
                                    if (bufferedInputStream != null) {
                                    }
                                    if (fileInputStream != null) {
                                    }
                                    a(new File(this.b));
                                    zipOutputStream.close();
                                    fileOutputStream.close();
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    throw th2;
                                }
                            } catch (Throwable th5) {
                                th3 = th5;
                                bufferedInputStream = null;
                                th2 = th3;
                                if (bufferedInputStream != null) {
                                }
                                if (fileInputStream != null) {
                                }
                                throw th2;
                            }
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
                                while (true) {
                                    int read = bufferedInputStream.read(bArr, 0, 2048);
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                }
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                                try {
                                    fileInputStream.close();
                                } catch (IOException e8) {
                                    e = e8;
                                }
                            } catch (Exception e9) {
                                e2 = e9;
                                e2.printStackTrace();
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e11) {
                                        e = e11;
                                    }
                                }
                                a(new File(this.b));
                                zipOutputStream.close();
                                fileOutputStream.close();
                            }
                        } catch (Exception e12) {
                            e3 = e12;
                            fileInputStream = null;
                            bufferedInputStream = null;
                            e2 = e3;
                            e2.printStackTrace();
                            if (bufferedInputStream != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            a(new File(this.b));
                            zipOutputStream.close();
                            fileOutputStream.close();
                        } catch (Throwable th6) {
                            th3 = th6;
                            fileInputStream = null;
                            bufferedInputStream = null;
                            th2 = th3;
                            if (bufferedInputStream != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            throw th2;
                        }
                        a(new File(this.b));
                        try {
                            zipOutputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                            return;
                        }
                        e.printStackTrace();
                        a(new File(this.b));
                        zipOutputStream.close();
                        fileOutputStream.close();
                    } catch (Exception e15) {
                        e = e15;
                        try {
                            e.printStackTrace();
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            if (zipOutputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Exception e17) {
                    zipOutputStream = null;
                    e = e17;
                    e.printStackTrace();
                    if (zipOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                } catch (Throwable th8) {
                    zipOutputStream = null;
                    th = th8;
                    if (zipOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e18) {
                zipOutputStream = null;
                e = e18;
                fileOutputStream = null;
                e.printStackTrace();
                if (zipOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
            } catch (Throwable th9) {
                zipOutputStream = null;
                th = th9;
                fileOutputStream = null;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e20) {
                        e20.printStackTrace();
                    }
                }
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[SYNTHETIC, Splitter:B:23:0x0044] */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        private static void a(File file) throws IOException {
            Throwable th;
            Exception e;
            RandomAccessFile randomAccessFile = null;
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    int parseInt = Integer.parseInt("00001000", 2);
                    randomAccessFile2.seek(7);
                    int read = randomAccessFile2.read();
                    if ((read & parseInt) > 0) {
                        randomAccessFile2.seek(7);
                        randomAccessFile2.write((parseInt ^ -1) & 255 & read);
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    try {
                        e.printStackTrace();
                        if (randomAccessFile == null) {
                            randomAccessFile.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (randomAccessFile == null) {
                }
            }
        }
    }

    public void setShouldUploadEventReport(boolean z) {
        this.d = z;
    }

    public boolean getShouldUploadEventReport() {
        return this.d;
    }
}
