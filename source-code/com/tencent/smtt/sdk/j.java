package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.lzy.okgo.model.HttpHeaders;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.q;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.SSLHandshakeException;

/* access modifiers changed from: package-private */
/* compiled from: TbsApkDownloader */
public class j {
    private static int d = 5;
    private static int e = 1;
    private static final String[] f = {"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private Set<String> A;
    private int B = d;
    private boolean C;
    String a;
    String[] b = null;
    int c = 0;
    private Context g;
    private String h;
    private String i;
    private String j;
    private File k;
    private long l;
    private int m = 30000;
    private int n = 20000;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private HttpURLConnection t;
    private String u;
    private TbsLogReport.TbsLogInfo v;
    private String w;
    private int x;
    private boolean y;
    private Handler z;

    public j(Context context) throws NullPointerException {
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.v = TbsLogReport.getInstance(applicationContext).tbsLogInfo();
        this.A = new HashSet();
        this.u = "tbs_downloading_" + this.g.getPackageName();
        m.a();
        File s2 = m.s(this.g);
        this.k = s2;
        if (s2 != null) {
            e();
            this.w = null;
            this.x = -1;
            return;
        }
        throw new NullPointerException("TbsCorePrivateDir is null!");
    }

    private void e() {
        this.p = 0;
        this.q = 0;
        this.l = -1;
        this.j = null;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
    }

    private void a(String str) throws Exception {
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = this.t;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
        this.t = httpURLConnection2;
        httpURLConnection2.setRequestProperty(HttpHeaders.HEAD_KEY_USER_AGENT, TbsDownloader.b(this.g));
        this.t.setRequestProperty(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING, "identity");
        this.t.setRequestMethod("GET");
        this.t.setInstanceFollowRedirects(false);
        this.t.setConnectTimeout(this.n);
        this.t.setReadTimeout(this.m);
    }

    private void f() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        HttpURLConnection httpURLConnection = this.t;
        if (httpURLConnection != null) {
            if (!this.r) {
                this.v.setResolveIp(a(httpURLConnection.getURL()));
            }
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
            this.t = null;
        }
        int i2 = this.v.a;
        if (this.r || !this.y) {
            TbsDownloader.a = false;
            return;
        }
        this.v.setEventTime(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.g);
        if (apnInfo == null) {
            apnInfo = "";
        }
        int apnType = Apn.getApnType(this.g);
        this.v.setApn(apnInfo);
        this.v.setNetworkType(apnType);
        if (apnType != this.x || !apnInfo.equals(this.w)) {
            this.v.setNetworkChange(0);
        }
        if ((this.v.a == 0 || this.v.a == 107) && this.v.getDownFinalFlag() == 0) {
            if (!Apn.isNetworkAvailable(this.g)) {
                a(101, (String) null, true);
            } else if (!k()) {
                a(101, (String) null, true);
            }
        }
        if (TbsDownloader.a(this.g)) {
            TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
        } else {
            TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
        }
        this.v.resetArgs();
        if (i2 != 100) {
            QbSdk.m.onDownloadFinish(i2);
        }
    }

    private boolean b(int i2) {
        try {
            File file = new File(this.k, "x5.tbs");
            File a2 = a(this.g);
            if (a2 == null) {
                return false;
            }
            File file2 = new File(a2, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
            file.delete();
            f.b(file2, file);
            if (a.a(this.g, file, 0, i2)) {
                return true;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e2.getMessage());
            return false;
        }
    }

    public boolean a(boolean z2, boolean z3) {
        boolean z4;
        File g2;
        if (Build.VERSION.SDK_INT == 23) {
            return false;
        }
        int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        int i3 = m.a().i(this.g);
        if (i2 == 0) {
            i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            this.a = "by default key";
        } else {
            this.a = "by new key";
        }
        if (!(i2 == 0 || i2 == i3)) {
            if (z3) {
                File a2 = TbsDownloader.a(i2);
                if (a2 != null && a2.exists()) {
                    File file = new File(f.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                    try {
                        if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1) {
                            f.b(a2, file);
                            z4 = true;
                            g2 = g();
                            if (g2 != null || !g2.exists() || !a(g2)) {
                                h();
                                if (a2 != null && a2.exists() && !a.a(this.g, a2, 0, i2) && a2 != null && a2.exists()) {
                                    f.b(a2);
                                }
                            } else if (b(i2)) {
                                TbsDownloadConfig.getInstance(this.g).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -214);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                                c(false);
                                if (z4) {
                                    a(100, "use local backup apk in startDownload" + this.a, true);
                                    if (TbsDownloader.a(this.g)) {
                                        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
                                    } else {
                                        TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
                                    }
                                    this.v.resetArgs();
                                }
                                return true;
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                z4 = false;
                g2 = g();
                if (g2 != null) {
                }
                h();
                f.b(a2);
            }
            if (c(false, z3)) {
                TbsDownloadConfig.getInstance(this.g).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -214);
                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                c(false);
                return true;
            } else if (!d(true) && !d(true)) {
                TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader] delete file failed!");
                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-301);
            }
        }
        return false;
    }

    public boolean a() {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
        try {
            File file = new File(f.a(this.g, 4), TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            } else {
                File b2 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1));
                if (b2 != null && b2.exists()) {
                    f.b(b2, file);
                }
            }
            Context context = this.g;
            if (!a.a(context, file, 0, TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1))) {
                return false;
            }
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
            return m.a().e(this.g);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:153:0x041e, code lost:
        r2.put(r13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x04bb, code lost:
        if (r40 == false) goto L_0x04db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x04d9, code lost:
        if (r40 == false) goto L_0x04db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x04db, code lost:
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.g).mSyncMap;
        r3 = java.lang.Long.valueOf(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04ed, code lost:
        if (r40 == false) goto L_0x04ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0532, code lost:
        if (r40 == false) goto L_0x04db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0535, code lost:
        if (r40 == false) goto L_0x04ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x055e, code lost:
        if (r40 == false) goto L_0x04db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0562, code lost:
        if (r40 == false) goto L_0x04ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x057a, code lost:
        if (r40 == false) goto L_0x04ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0589, code lost:
        if (r40 != false) goto L_0x0698;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0685, code lost:
        if (r40 != false) goto L_0x0698;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0687, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.g).mSyncMap.put(r10, java.lang.Long.valueOf(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0698, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:?, code lost:
        com.tencent.smtt.utils.TbsLog.i(r11, "STEP 1/2 begin downloading...Canceled!", true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.g).setDownloadInterruptCode(-309);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x0731, code lost:
        r33 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0733, code lost:
        r10 = r11;
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0737, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x073a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x073b, code lost:
        r5 = r0;
        r7 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x0740, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x0741, code lost:
        r5 = r0;
        r8 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x0754, code lost:
        if (r39.b == null) goto L_0x0772;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x075b, code lost:
        if (c(true, r4) != false) goto L_0x0772;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x075d, code lost:
        if (r40 != false) goto L_0x0768;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x0763, code lost:
        if (a(false) == false) goto L_0x0768;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x0765, code lost:
        r10 = r11;
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x0768, code lost:
        r39.s = true;
        r10 = r11;
        r5 = false;
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x0772, code lost:
        r39.s = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0777, code lost:
        if (r39.b == null) goto L_0x077b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0779, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x077b, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.g).setDownloadInterruptCode(-311);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:?, code lost:
        com.tencent.smtt.utils.TbsLog.i(r11, r28, true);
        r3 = new java.lang.StringBuilder();
        r3.append("downloadFlow=");
        r3.append(r10);
        r3.append(" downloadMaxflow=");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:?, code lost:
        r3.append(r26);
        a(112, r3.toString(), true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.g).setDownloadInterruptCode(-307);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x07e1, code lost:
        r26 = r26;
        r31 = r10;
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x07e8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x07ec, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x07ed, code lost:
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x07f0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x07f1, code lost:
        r7 = r15;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x07fa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x07fb, code lost:
        r8 = r10;
        r11 = r4;
        r10 = r11;
        r4 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:482:0x0add, code lost:
        if (r40 == false) goto L_0x0b01;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x0aff, code lost:
        if (r40 != false) goto L_0x0b19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0215, code lost:
        if (r40 == false) goto L_0x0217;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0217, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.g).mSyncMap.put(r14, java.lang.Long.valueOf(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0252, code lost:
        if (r40 == false) goto L_0x0217;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x035b A[Catch:{ all -> 0x0b50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x035d A[Catch:{ all -> 0x0b50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0423  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0747  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0908 A[SYNTHETIC, Splitter:B:389:0x0908] */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0942  */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x0a3f A[Catch:{ all -> 0x0b32 }] */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x0b65 A[ADDED_TO_REGION, Catch:{ all -> 0x0ca6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:526:0x0bdb  */
    /* JADX WARNING: Removed duplicated region for block: B:546:0x0c34  */
    /* JADX WARNING: Removed duplicated region for block: B:547:0x0c48  */
    /* JADX WARNING: Removed duplicated region for block: B:553:0x0c73  */
    /* JADX WARNING: Removed duplicated region for block: B:566:0x0403 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:581:0x023b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:582:0x0bb9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:586:0x0720 A[EDGE_INSN: B:586:0x0720->B:301:0x0720 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x026d A[Catch:{ all -> 0x0b58 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x026e A[Catch:{ all -> 0x0b58 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0299 A[SYNTHETIC, Splitter:B:95:0x0299] */
    public void b(boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        int i2;
        long j2;
        String str;
        String str2;
        Throwable th;
        String str3;
        long j3;
        String str4;
        Throwable th2;
        String str5;
        String str6;
        String str7;
        String str8;
        long j4;
        long j5;
        int apnType;
        String apnInfo;
        String str9;
        String str10;
        String str11;
        InputStream inputStream;
        InputStream inputStream2;
        Closeable closeable;
        Throwable th3;
        FileOutputStream fileOutputStream;
        Throwable th4;
        IOException iOException;
        long j6;
        Throwable th5;
        Map<String, Object> map;
        Long valueOf;
        long j7;
        long j8;
        String str12;
        boolean z6;
        String str13;
        IOException e2;
        Throwable th6;
        String str14;
        long j9;
        String str15;
        String str16;
        String str17;
        Throwable th7;
        String str18 = TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME;
        if (!m.a().c(this.g) || z2) {
            int i3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
            boolean z7 = true;
            boolean z8 = i3 == 1 || i3 == 2 || i3 == 4;
            if (z3 || !a(z2, z8)) {
                this.C = z2;
                String str19 = null;
                this.h = TbsDownloadConfig.getInstance(this.g).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null);
                String string = TbsDownloadConfig.getInstance(this.g).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, null);
                String str20 = TbsDownloader.LOGTAG;
                TbsLog.i(str20, "backupUrlStrings:" + string, true);
                this.b = null;
                this.c = 0;
                if (!z2 && string != null && !"".equals(string.trim())) {
                    this.b = string.trim().split(";");
                }
                TbsLog.i(str20, "[TbsApkDownloader.startDownload] mDownloadUrl=" + this.h + " backupUrlStrings=" + string + " mLocation=" + this.j + " mCanceled=" + this.r + " mHttpRequest=" + this.t);
                if (this.h == null && this.j == null) {
                    QbSdk.m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-302);
                } else if (this.t != null && !this.r) {
                    QbSdk.m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-303);
                } else if (z2 || !this.A.contains(Apn.getWifiSSID(this.g))) {
                    e();
                    TbsLog.i(str20, "STEP 1/2 begin downloading...", true);
                    long downloadMaxflow = TbsDownloadConfig.getInstance(this.g).getDownloadMaxflow();
                    SharedPreferences sharedPreferences = TbsDownloadConfig.getInstance(this.g).mPreferences;
                    String str21 = TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW;
                    long j10 = sharedPreferences.getLong(str21, 0);
                    if (z2) {
                        this.B = e;
                    } else {
                        this.B = d;
                    }
                    long j11 = j10;
                    boolean z9 = false;
                    while (true) {
                        if (this.p > this.B) {
                            break;
                        } else if (this.q > 8) {
                            a(123, str19, z7);
                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-306);
                            break;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (!z2) {
                                try {
                                    try {
                                        if (currentTimeMillis - TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(str18, 0) > 86400000) {
                                            try {
                                                TbsLog.i(str20, "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD");
                                                TbsDownloadConfig.getInstance(this.g).mSyncMap.put(str18, Long.valueOf(currentTimeMillis));
                                                TbsDownloadConfig.getInstance(this.g).mSyncMap.put(str21, 0L);
                                                TbsDownloadConfig.getInstance(this.g).commit();
                                                j11 = 0;
                                                if (!f.b(this.g)) {
                                                    TbsLog.i(str20, "DownloadBegin FreeSpace too small", true);
                                                    a(105, (String) null, true);
                                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                str2 = str20;
                                                j2 = downloadMaxflow;
                                                j11 = j11;
                                                str = str18;
                                                z4 = z8;
                                                str3 = str21;
                                                try {
                                                    if (th instanceof SSLHandshakeException) {
                                                    }
                                                    str4 = null;
                                                    th.printStackTrace();
                                                    j3 = 0;
                                                    a(0L);
                                                    a(107, a(th), false);
                                                    if (!this.r) {
                                                    }
                                                } finally {
                                                    if (!z2) {
                                                        TbsDownloadConfig.getInstance(this.g).mSyncMap.put(str3, Long.valueOf(j11));
                                                        TbsDownloadConfig.getInstance(this.g).commit();
                                                    }
                                                }
                                            }
                                            try {
                                                this.y = true;
                                                str5 = this.j;
                                                if (str5 == null) {
                                                    str5 = this.h;
                                                }
                                                StringBuilder sb = new StringBuilder();
                                                str = str18;
                                                try {
                                                    sb.append("try url:");
                                                    sb.append(str5);
                                                    sb.append(",mRetryTimes:");
                                                    sb.append(this.p);
                                                    TbsLog.i(str20, sb.toString(), true);
                                                    if (!str5.equals(this.i)) {
                                                        try {
                                                            this.v.setDownloadUrl(str5);
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                        }
                                                    }
                                                    this.i = str5;
                                                    a(str5);
                                                    str6 = "/";
                                                    if (!this.o) {
                                                        j4 = currentTimeMillis;
                                                        j5 = j();
                                                        TbsLog.i(str20, "[TbsApkDownloader.startDownload] range=" + j5);
                                                        j2 = downloadMaxflow;
                                                        try {
                                                            str8 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";
                                                            if (this.l <= 0) {
                                                                TbsLog.i(str20, "STEP 1/2 begin downloading...current" + j5, true);
                                                                this.t.setRequestProperty(HttpHeaders.HEAD_KEY_RANGE, "bytes=" + j5 + "-");
                                                                str7 = str21;
                                                            } else {
                                                                StringBuilder sb2 = new StringBuilder();
                                                                sb2.append("#1 STEP 1/2 begin downloading...current/total=");
                                                                sb2.append(j5);
                                                                sb2.append(str6);
                                                                str7 = str21;
                                                                try {
                                                                    sb2.append(this.l);
                                                                    TbsLog.i(str20, sb2.toString(), true);
                                                                    this.t.setRequestProperty(HttpHeaders.HEAD_KEY_RANGE, "bytes=" + j5 + "-" + this.l);
                                                                } catch (Throwable th10) {
                                                                    th = th10;
                                                                    str2 = str20;
                                                                    z4 = z8;
                                                                    str3 = str7;
                                                                }
                                                            }
                                                        } catch (Throwable th11) {
                                                            th = th11;
                                                            str2 = str20;
                                                            z4 = z8;
                                                            str3 = str21;
                                                            if (th instanceof SSLHandshakeException) {
                                                            }
                                                            str4 = null;
                                                            th.printStackTrace();
                                                            j3 = 0;
                                                            a(0L);
                                                            a(107, a(th), false);
                                                            if (!this.r) {
                                                            }
                                                        }
                                                    } else {
                                                        j4 = currentTimeMillis;
                                                        str8 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";
                                                        j2 = downloadMaxflow;
                                                        str7 = str21;
                                                        j5 = 0;
                                                    }
                                                } catch (Throwable th12) {
                                                    th2 = th12;
                                                    str2 = str20;
                                                    j2 = downloadMaxflow;
                                                    z4 = z8;
                                                    str3 = str21;
                                                    th = th2;
                                                    if (th instanceof SSLHandshakeException) {
                                                    }
                                                    str4 = null;
                                                    th.printStackTrace();
                                                    j3 = 0;
                                                    a(0L);
                                                    a(107, a(th), false);
                                                    if (!this.r) {
                                                    }
                                                }
                                            } catch (Throwable th13) {
                                                th2 = th13;
                                                str = str18;
                                                str2 = str20;
                                                j2 = downloadMaxflow;
                                                z4 = z8;
                                                str3 = str21;
                                                th = th2;
                                                if (th instanceof SSLHandshakeException) {
                                                }
                                                str4 = null;
                                                th.printStackTrace();
                                                j3 = 0;
                                                a(0L);
                                                a(107, a(th), false);
                                                if (!this.r) {
                                                }
                                            }
                                            try {
                                                this.v.setDownloadCancel(j5 == 0 ? 0 : 1);
                                                apnType = Apn.getApnType(this.g);
                                                apnInfo = Apn.getApnInfo(this.g);
                                                str9 = this.w;
                                                if (str9 != null && this.x == -1) {
                                                    this.w = apnInfo;
                                                    this.x = apnType;
                                                } else if (apnType != this.x || !apnInfo.equals(str9)) {
                                                    this.v.setNetworkChange(0);
                                                    this.w = apnInfo;
                                                    this.x = apnType;
                                                    if (this.p >= 1) {
                                                        this.t.addRequestProperty("Referer", this.h);
                                                    }
                                                    int responseCode = this.t.getResponseCode();
                                                    TbsLog.i(str20, "[TbsApkDownloader.startDownload] responseCode=" + responseCode);
                                                    this.v.setHttpCode(responseCode);
                                                    if (!z2 && !TbsDownloader.getOverSea(this.g) && ((Apn.getApnType(this.g) != 3 || Apn.getApnType(this.g) == 0) && !QbSdk.getDownloadWithoutWifi())) {
                                                        b();
                                                        if (QbSdk.m != null) {
                                                            QbSdk.m.onDownloadFinish(111);
                                                        }
                                                        TbsLog.i(str20, "Download is canceled due to NOT_WIFI error!", false);
                                                    }
                                                    if (!this.r) {
                                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                        if (!z2) {
                                                            Map<String, Object> map2 = TbsDownloadConfig.getInstance(this.g).mSyncMap;
                                                            Long valueOf2 = Long.valueOf(j11);
                                                            str10 = str7;
                                                        }
                                                    } else {
                                                        str10 = str7;
                                                        if (responseCode == 200 || responseCode == 206) {
                                                            try {
                                                                this.l = ((long) this.t.getContentLength()) + j5;
                                                                TbsLog.i(str20, "[TbsApkDownloader.startDownload] mContentLength=" + this.l);
                                                                this.v.setPkgSize(this.l);
                                                                long j12 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
                                                                if (j12 == 0 || this.l == j12) {
                                                                    String str22 = str10;
                                                                    try {
                                                                        TbsLog.i(str20, "[TbsApkDownloader.startDownload] begin readResponse");
                                                                        try {
                                                                            inputStream2 = this.t.getInputStream();
                                                                            if (inputStream2 != null) {
                                                                                try {
                                                                                    String contentEncoding = this.t.getContentEncoding();
                                                                                    if (contentEncoding != null) {
                                                                                        try {
                                                                                            if (contentEncoding.contains("gzip")) {
                                                                                                inputStream = new GZIPInputStream(inputStream2);
                                                                                                byte[] bArr = new byte[8192];
                                                                                                j7 = j5;
                                                                                                fileOutputStream = new FileOutputStream(new File(this.k, "x5.tbs.temp"), true);
                                                                                                long currentTimeMillis2 = System.currentTimeMillis();
                                                                                                long j13 = j11;
                                                                                                j8 = j4;
                                                                                                long j14 = j7;
                                                                                                while (true) {
                                                                                                    try {
                                                                                                        if (!this.r) {
                                                                                                            break;
                                                                                                        }
                                                                                                        str12 = str22;
                                                                                                        try {
                                                                                                            int read = inputStream.read(bArr, 0, 8192);
                                                                                                            if (read <= 0) {
                                                                                                                try {
                                                                                                                    break;
                                                                                                                } catch (IOException e3) {
                                                                                                                    iOException = e3;
                                                                                                                    str2 = str20;
                                                                                                                    j11 = j13;
                                                                                                                    z4 = z8;
                                                                                                                    str3 = str12;
                                                                                                                    try {
                                                                                                                        iOException.printStackTrace();
                                                                                                                        if (!(iOException instanceof SocketTimeoutException)) {
                                                                                                                        }
                                                                                                                        j6 = j11;
                                                                                                                        this.m = 100000;
                                                                                                                        a(0L);
                                                                                                                        a(103, a(iOException), false);
                                                                                                                        a(fileOutputStream);
                                                                                                                        a(inputStream);
                                                                                                                        a(inputStream2);
                                                                                                                    } catch (Throwable th14) {
                                                                                                                        th4 = th14;
                                                                                                                        th3 = th4;
                                                                                                                        closeable = fileOutputStream;
                                                                                                                        a(closeable);
                                                                                                                        a(inputStream);
                                                                                                                        a(inputStream2);
                                                                                                                        throw th3;
                                                                                                                    }
                                                                                                                } catch (Throwable th15) {
                                                                                                                    th3 = th15;
                                                                                                                    closeable = fileOutputStream;
                                                                                                                    a(closeable);
                                                                                                                    a(inputStream);
                                                                                                                    a(inputStream2);
                                                                                                                    throw th3;
                                                                                                                }
                                                                                                            } else {
                                                                                                                fileOutputStream.write(bArr, 0, read);
                                                                                                                fileOutputStream.flush();
                                                                                                                if (!z2) {
                                                                                                                    long j15 = j13 + ((long) read);
                                                                                                                    if (j15 >= j2) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                    j13 = j15;
                                                                                                                    str2 = str20;
                                                                                                                    str14 = str8;
                                                                                                                    try {
                                                                                                                        if (!f.b(this.g)) {
                                                                                                                            TbsLog.i(str2, "DownloadEnd FreeSpace too small ", true);
                                                                                                                            a(105, "freespace=" + q.a() + ",and minFreeSpace=" + TbsDownloadConfig.getInstance(this.g).getDownloadMinFreeSpace(), true);
                                                                                                                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                                                                                                            break;
                                                                                                                        }
                                                                                                                    } catch (IOException e4) {
                                                                                                                        iOException = e4;
                                                                                                                        z4 = z8;
                                                                                                                        j11 = j13;
                                                                                                                        str3 = str12;
                                                                                                                        iOException.printStackTrace();
                                                                                                                        if (!(iOException instanceof SocketTimeoutException)) {
                                                                                                                        }
                                                                                                                        j6 = j11;
                                                                                                                        this.m = 100000;
                                                                                                                        a(0L);
                                                                                                                        a(103, a(iOException), false);
                                                                                                                        a(fileOutputStream);
                                                                                                                        a(inputStream);
                                                                                                                        a(inputStream2);
                                                                                                                    } catch (Throwable th16) {
                                                                                                                        th3 = th16;
                                                                                                                        closeable = fileOutputStream;
                                                                                                                        a(closeable);
                                                                                                                        a(inputStream);
                                                                                                                        a(inputStream2);
                                                                                                                        throw th3;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str2 = str20;
                                                                                                                    str14 = str8;
                                                                                                                }
                                                                                                                z4 = z8;
                                                                                                                long j16 = (long) read;
                                                                                                                try {
                                                                                                                    long a2 = a(j8, j16);
                                                                                                                    long currentTimeMillis3 = System.currentTimeMillis();
                                                                                                                    long j17 = j7 + j16;
                                                                                                                    if (currentTimeMillis3 - currentTimeMillis2 > 1000) {
                                                                                                                        StringBuilder sb3 = new StringBuilder();
                                                                                                                        sb3.append("#2 STEP 1/2 begin downloading...current/total=");
                                                                                                                        sb3.append(j17);
                                                                                                                        sb3.append(str6);
                                                                                                                        str15 = str6;
                                                                                                                        sb3.append(this.l);
                                                                                                                        TbsLog.i(str2, sb3.toString(), true);
                                                                                                                        if (QbSdk.m != null) {
                                                                                                                            double d2 = (double) j17;
                                                                                                                            j9 = a2;
                                                                                                                            double d3 = (double) this.l;
                                                                                                                            Double.isNaN(d2);
                                                                                                                            Double.isNaN(d3);
                                                                                                                            QbSdk.m.onDownloadProgress((int) ((d2 / d3) * 100.0d));
                                                                                                                        } else {
                                                                                                                            j9 = a2;
                                                                                                                        }
                                                                                                                        if (z2 || j17 - j14 <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                                                                                                                            str16 = str12;
                                                                                                                        } else if (TbsDownloader.getOverSea(this.g) || ((Apn.getApnType(this.g) == 3 && Apn.getApnType(this.g) != 0) || QbSdk.getDownloadWithoutWifi())) {
                                                                                                                            str16 = str12;
                                                                                                                            j14 = j17;
                                                                                                                        } else {
                                                                                                                            b();
                                                                                                                            if (QbSdk.m != null) {
                                                                                                                                QbSdk.m.onDownloadFinish(111);
                                                                                                                            }
                                                                                                                            TbsLog.i(str2, "Download is paused due to NOT_WIFI error!", false);
                                                                                                                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
                                                                                                                            z6 = false;
                                                                                                                        }
                                                                                                                        currentTimeMillis2 = currentTimeMillis3;
                                                                                                                    } else {
                                                                                                                        str15 = str6;
                                                                                                                        j9 = a2;
                                                                                                                        str16 = str12;
                                                                                                                    }
                                                                                                                    str6 = str15;
                                                                                                                    str8 = str14;
                                                                                                                    str22 = str16;
                                                                                                                    j8 = j9;
                                                                                                                    j7 = j17;
                                                                                                                    z8 = z4;
                                                                                                                    str20 = str2;
                                                                                                                } catch (IOException e5) {
                                                                                                                    e2 = e5;
                                                                                                                    iOException = e2;
                                                                                                                    j11 = j13;
                                                                                                                    str3 = str12;
                                                                                                                    iOException.printStackTrace();
                                                                                                                    if (!(iOException instanceof SocketTimeoutException)) {
                                                                                                                    }
                                                                                                                    j6 = j11;
                                                                                                                    this.m = 100000;
                                                                                                                    a(0L);
                                                                                                                    a(103, a(iOException), false);
                                                                                                                    a(fileOutputStream);
                                                                                                                    a(inputStream);
                                                                                                                    a(inputStream2);
                                                                                                                } catch (Throwable th17) {
                                                                                                                    th6 = th17;
                                                                                                                    th3 = th6;
                                                                                                                    closeable = fileOutputStream;
                                                                                                                    a(closeable);
                                                                                                                    a(inputStream);
                                                                                                                    a(inputStream2);
                                                                                                                    throw th3;
                                                                                                                }
                                                                                                            }
                                                                                                        } catch (IOException e6) {
                                                                                                            e2 = e6;
                                                                                                            str2 = str20;
                                                                                                            z4 = z8;
                                                                                                            iOException = e2;
                                                                                                            j11 = j13;
                                                                                                            str3 = str12;
                                                                                                            iOException.printStackTrace();
                                                                                                            if (!(iOException instanceof SocketTimeoutException)) {
                                                                                                            }
                                                                                                            j6 = j11;
                                                                                                            this.m = 100000;
                                                                                                            a(0L);
                                                                                                            a(103, a(iOException), false);
                                                                                                            a(fileOutputStream);
                                                                                                            a(inputStream);
                                                                                                            a(inputStream2);
                                                                                                        } catch (Throwable th18) {
                                                                                                            th6 = th18;
                                                                                                            th3 = th6;
                                                                                                            closeable = fileOutputStream;
                                                                                                            a(closeable);
                                                                                                            a(inputStream);
                                                                                                            a(inputStream2);
                                                                                                            throw th3;
                                                                                                        }
                                                                                                    } catch (IOException e7) {
                                                                                                        str2 = str20;
                                                                                                        z4 = z8;
                                                                                                        iOException = e7;
                                                                                                        str3 = str22;
                                                                                                        j11 = j13;
                                                                                                        iOException.printStackTrace();
                                                                                                        if (!(iOException instanceof SocketTimeoutException)) {
                                                                                                        }
                                                                                                        j6 = j11;
                                                                                                        this.m = 100000;
                                                                                                        a(0L);
                                                                                                        a(103, a(iOException), false);
                                                                                                        a(fileOutputStream);
                                                                                                        a(inputStream);
                                                                                                        a(inputStream2);
                                                                                                    } catch (Throwable th19) {
                                                                                                        th3 = th19;
                                                                                                        closeable = fileOutputStream;
                                                                                                        a(closeable);
                                                                                                        a(inputStream);
                                                                                                        a(inputStream2);
                                                                                                        throw th3;
                                                                                                    }
                                                                                                }
                                                                                                z4 = z8;
                                                                                                z6 = false;
                                                                                                if (!z6) {
                                                                                                    try {
                                                                                                        a(fileOutputStream);
                                                                                                        a(inputStream);
                                                                                                        a(inputStream2);
                                                                                                        if (!z2) {
                                                                                                            str13 = str12;
                                                                                                            TbsDownloadConfig.getInstance(this.g).mSyncMap.put(str13, Long.valueOf(j13));
                                                                                                            TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                        } else {
                                                                                                            str13 = str12;
                                                                                                        }
                                                                                                        str21 = str13;
                                                                                                        z8 = z4;
                                                                                                        str18 = str;
                                                                                                        downloadMaxflow = j2;
                                                                                                        j11 = j13;
                                                                                                        z7 = true;
                                                                                                        str20 = str2;
                                                                                                        str19 = null;
                                                                                                    } catch (Throwable th20) {
                                                                                                        th = th20;
                                                                                                        j11 = j13;
                                                                                                        str3 = str12;
                                                                                                        if (th instanceof SSLHandshakeException) {
                                                                                                        }
                                                                                                        str4 = null;
                                                                                                        th.printStackTrace();
                                                                                                        j3 = 0;
                                                                                                        a(0L);
                                                                                                        a(107, a(th), false);
                                                                                                        if (!this.r) {
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    j11 = j13;
                                                                                                    str3 = str12;
                                                                                                }
                                                                                            }
                                                                                        } catch (IOException e8) {
                                                                                            iOException = e8;
                                                                                            inputStream = null;
                                                                                            fileOutputStream = null;
                                                                                            z4 = z8;
                                                                                            str3 = str22;
                                                                                            str2 = str20;
                                                                                            iOException.printStackTrace();
                                                                                            if (!(iOException instanceof SocketTimeoutException)) {
                                                                                            }
                                                                                            j6 = j11;
                                                                                            this.m = 100000;
                                                                                            a(0L);
                                                                                            a(103, a(iOException), false);
                                                                                            a(fileOutputStream);
                                                                                            a(inputStream);
                                                                                            a(inputStream2);
                                                                                        } catch (Throwable th21) {
                                                                                            th3 = th21;
                                                                                            closeable = null;
                                                                                            inputStream = null;
                                                                                            a(closeable);
                                                                                            a(inputStream);
                                                                                            a(inputStream2);
                                                                                            throw th3;
                                                                                        }
                                                                                    }
                                                                                    inputStream = (contentEncoding == null || !contentEncoding.contains("deflate")) ? inputStream2 : new InflaterInputStream(inputStream2, new Inflater(true));
                                                                                    try {
                                                                                        byte[] bArr2 = new byte[8192];
                                                                                        j7 = j5;
                                                                                        fileOutputStream = new FileOutputStream(new File(this.k, "x5.tbs.temp"), true);
                                                                                    } catch (IOException e9) {
                                                                                        z4 = z8;
                                                                                        str3 = str22;
                                                                                        str2 = str20;
                                                                                        iOException = e9;
                                                                                        fileOutputStream = null;
                                                                                        iOException.printStackTrace();
                                                                                        if (!(iOException instanceof SocketTimeoutException)) {
                                                                                        }
                                                                                        j6 = j11;
                                                                                        this.m = 100000;
                                                                                        a(0L);
                                                                                        a(103, a(iOException), false);
                                                                                        a(fileOutputStream);
                                                                                        a(inputStream);
                                                                                        a(inputStream2);
                                                                                    } catch (Throwable th22) {
                                                                                        th3 = th22;
                                                                                        closeable = null;
                                                                                        a(closeable);
                                                                                        a(inputStream);
                                                                                        a(inputStream2);
                                                                                        throw th3;
                                                                                    }
                                                                                } catch (IOException e10) {
                                                                                    z4 = z8;
                                                                                    str3 = str22;
                                                                                    str2 = str20;
                                                                                    iOException = e10;
                                                                                    inputStream = null;
                                                                                    fileOutputStream = null;
                                                                                    iOException.printStackTrace();
                                                                                    if (!(iOException instanceof SocketTimeoutException) || (iOException instanceof SocketException)) {
                                                                                        j6 = j11;
                                                                                        this.m = 100000;
                                                                                        a(0L);
                                                                                        a(103, a(iOException), false);
                                                                                        a(fileOutputStream);
                                                                                        a(inputStream);
                                                                                        a(inputStream2);
                                                                                    } else {
                                                                                        if (!z2) {
                                                                                            try {
                                                                                                if (!f.b(this.g)) {
                                                                                                    StringBuilder sb4 = new StringBuilder();
                                                                                                    sb4.append("freespace=");
                                                                                                    str7 = str3;
                                                                                                    try {
                                                                                                        sb4.append(q.a());
                                                                                                        sb4.append(",and minFreeSpace=");
                                                                                                        sb4.append(TbsDownloadConfig.getInstance(this.g).getDownloadMinFreeSpace());
                                                                                                        a(105, sb4.toString(), true);
                                                                                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                                                                                        try {
                                                                                                            a(fileOutputStream);
                                                                                                            a(inputStream);
                                                                                                            a(inputStream2);
                                                                                                            if (!z2) {
                                                                                                                map = TbsDownloadConfig.getInstance(this.g).mSyncMap;
                                                                                                                valueOf = Long.valueOf(j11);
                                                                                                                str3 = str7;
                                                                                                                map.put(str3, valueOf);
                                                                                                                TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                            }
                                                                                                        } catch (Throwable th23) {
                                                                                                            th2 = th23;
                                                                                                        }
                                                                                                        z5 = z9;
                                                                                                        if (!this.r) {
                                                                                                        }
                                                                                                        f();
                                                                                                    } catch (Throwable th24) {
                                                                                                        th4 = th24;
                                                                                                        th3 = th4;
                                                                                                        closeable = fileOutputStream;
                                                                                                        a(closeable);
                                                                                                        a(inputStream);
                                                                                                        a(inputStream2);
                                                                                                        throw th3;
                                                                                                    }
                                                                                                }
                                                                                            } catch (Throwable th25) {
                                                                                                th4 = th25;
                                                                                                th3 = th4;
                                                                                                closeable = fileOutputStream;
                                                                                                a(closeable);
                                                                                                a(inputStream);
                                                                                                a(inputStream2);
                                                                                                throw th3;
                                                                                            }
                                                                                        }
                                                                                        j6 = j11;
                                                                                        try {
                                                                                            a(0L);
                                                                                            if (!i()) {
                                                                                                try {
                                                                                                    a(106, a(iOException), false);
                                                                                                } catch (Throwable th26) {
                                                                                                    th5 = th26;
                                                                                                    th3 = th5;
                                                                                                    closeable = fileOutputStream;
                                                                                                    a(closeable);
                                                                                                    a(inputStream);
                                                                                                    a(inputStream2);
                                                                                                    throw th3;
                                                                                                }
                                                                                            } else {
                                                                                                a(104, a(iOException), false);
                                                                                            }
                                                                                        } catch (Throwable th27) {
                                                                                            th5 = th27;
                                                                                            th3 = th5;
                                                                                            closeable = fileOutputStream;
                                                                                            a(closeable);
                                                                                            a(inputStream);
                                                                                            a(inputStream2);
                                                                                            throw th3;
                                                                                        }
                                                                                        try {
                                                                                            a(fileOutputStream);
                                                                                            a(inputStream);
                                                                                            a(inputStream2);
                                                                                        } catch (Throwable th28) {
                                                                                            th = th28;
                                                                                            j11 = j6;
                                                                                            if ((th instanceof SSLHandshakeException) || z2 || this.b == null || !a(false)) {
                                                                                                str4 = null;
                                                                                                th.printStackTrace();
                                                                                                j3 = 0;
                                                                                                a(0L);
                                                                                                a(107, a(th), false);
                                                                                                if (!this.r) {
                                                                                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                                                    if (!z2) {
                                                                                                        TbsDownloadConfig.getInstance(this.g).mSyncMap.put(str3, Long.valueOf(j11));
                                                                                                        TbsDownloadConfig.getInstance(this.g).commit();
                                                                                                    }
                                                                                                    z5 = z9;
                                                                                                    if (!this.r) {
                                                                                                    }
                                                                                                    f();
                                                                                                }
                                                                                                z7 = true;
                                                                                            } else {
                                                                                                TbsLog.e(str2, "[startdownload]url:" + this.j + " download exception：" + th.toString());
                                                                                                str4 = null;
                                                                                                a(TbsListener.ErrorCode.DOWNLOAD_THROWABLE, (String) null, true);
                                                                                                z7 = true;
                                                                                                j3 = 0;
                                                                                            }
                                                                                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-316);
                                                                                            str21 = str3;
                                                                                            z8 = z4;
                                                                                            str18 = str;
                                                                                            str20 = str2;
                                                                                            str19 = str4;
                                                                                            downloadMaxflow = j2;
                                                                                        }
                                                                                    }
                                                                                    TbsDownloadConfig.getInstance(this.g).mSyncMap.put(str3, Long.valueOf(j6));
                                                                                    TbsDownloadConfig.getInstance(this.g).commit();
                                                                                    str21 = str3;
                                                                                    z8 = z4;
                                                                                    j11 = j6;
                                                                                    str18 = str;
                                                                                    downloadMaxflow = j2;
                                                                                    z7 = true;
                                                                                    str20 = str2;
                                                                                    str19 = null;
                                                                                } catch (Throwable th29) {
                                                                                    th3 = th29;
                                                                                    closeable = null;
                                                                                    inputStream = null;
                                                                                    a(closeable);
                                                                                    a(inputStream);
                                                                                    a(inputStream2);
                                                                                    throw th3;
                                                                                }
                                                                                try {
                                                                                    long currentTimeMillis22 = System.currentTimeMillis();
                                                                                    long j132 = j11;
                                                                                    j8 = j4;
                                                                                    long j142 = j7;
                                                                                    while (true) {
                                                                                        if (!this.r) {
                                                                                        }
                                                                                        str6 = str15;
                                                                                        str8 = str14;
                                                                                        str22 = str16;
                                                                                        j8 = j9;
                                                                                        j7 = j17;
                                                                                        z8 = z4;
                                                                                        str20 = str2;
                                                                                    }
                                                                                    z4 = z8;
                                                                                    z6 = false;
                                                                                    if (!z6) {
                                                                                    }
                                                                                } catch (IOException e11) {
                                                                                    IOException e12 = e11;
                                                                                    z4 = z8;
                                                                                    str3 = str22;
                                                                                    str2 = str20;
                                                                                    iOException = e12;
                                                                                    iOException.printStackTrace();
                                                                                    if (!(iOException instanceof SocketTimeoutException)) {
                                                                                    }
                                                                                    j6 = j11;
                                                                                    this.m = 100000;
                                                                                    a(0L);
                                                                                    a(103, a(iOException), false);
                                                                                    a(fileOutputStream);
                                                                                    a(inputStream);
                                                                                    a(inputStream2);
                                                                                } catch (Throwable th30) {
                                                                                    th4 = th30;
                                                                                    th3 = th4;
                                                                                    closeable = fileOutputStream;
                                                                                    a(closeable);
                                                                                    a(inputStream);
                                                                                    a(inputStream2);
                                                                                    throw th3;
                                                                                }
                                                                            } else {
                                                                                z4 = z8;
                                                                                str3 = str22;
                                                                                str2 = str20;
                                                                                inputStream = null;
                                                                                fileOutputStream = null;
                                                                            }
                                                                        } catch (IOException e13) {
                                                                            z4 = z8;
                                                                            str3 = str22;
                                                                            str2 = str20;
                                                                            iOException = e13;
                                                                            inputStream2 = null;
                                                                            inputStream = null;
                                                                            fileOutputStream = null;
                                                                            iOException.printStackTrace();
                                                                            if (!(iOException instanceof SocketTimeoutException)) {
                                                                            }
                                                                            j6 = j11;
                                                                            this.m = 100000;
                                                                            a(0L);
                                                                            a(103, a(iOException), false);
                                                                            a(fileOutputStream);
                                                                            a(inputStream);
                                                                            a(inputStream2);
                                                                        } catch (Throwable th31) {
                                                                            th3 = th31;
                                                                            closeable = null;
                                                                            inputStream2 = null;
                                                                            inputStream = null;
                                                                            a(closeable);
                                                                            a(inputStream);
                                                                            a(inputStream2);
                                                                            throw th3;
                                                                        }
                                                                    } catch (Throwable th32) {
                                                                        th2 = th32;
                                                                        z4 = z8;
                                                                        str3 = str22;
                                                                        str2 = str20;
                                                                        th = th2;
                                                                        if (th instanceof SSLHandshakeException) {
                                                                        }
                                                                        str4 = null;
                                                                        th.printStackTrace();
                                                                        j3 = 0;
                                                                        a(0L);
                                                                        a(107, a(th), false);
                                                                        if (!this.r) {
                                                                        }
                                                                    }
                                                                    try {
                                                                        a(fileOutputStream);
                                                                        a(inputStream);
                                                                        a(inputStream2);
                                                                        if (!this.s) {
                                                                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-319);
                                                                        }
                                                                        if (!z2) {
                                                                            map = TbsDownloadConfig.getInstance(this.g).mSyncMap;
                                                                            valueOf = Long.valueOf(j11);
                                                                        }
                                                                    } catch (Throwable th33) {
                                                                        th2 = th33;
                                                                        th = th2;
                                                                        if (th instanceof SSLHandshakeException) {
                                                                        }
                                                                        str4 = null;
                                                                        th.printStackTrace();
                                                                        j3 = 0;
                                                                        a(0L);
                                                                        a(107, a(th), false);
                                                                        if (!this.r) {
                                                                        }
                                                                    }
                                                                } else {
                                                                    TbsLog.i(str20, "DownloadBegin tbsApkFileSize=" + j12 + "  but contentLength=" + this.l, true);
                                                                    if (z2 || (!m() && (!QbSdk.getDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.g)))) {
                                                                        str17 = str10;
                                                                        a(101, "WifiNetworkUnAvailable", true);
                                                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
                                                                    } else if (this.b == null || !a(false)) {
                                                                        str17 = str10;
                                                                        try {
                                                                            a(113, "tbsApkFileSize=" + j12 + "  but contentLength=" + this.l, true);
                                                                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-310);
                                                                            break;
                                                                        } catch (Throwable th34) {
                                                                            th = th34;
                                                                            z4 = z8;
                                                                            str3 = str17;
                                                                            str2 = str20;
                                                                            if (th instanceof SSLHandshakeException) {
                                                                            }
                                                                            str4 = null;
                                                                            th.printStackTrace();
                                                                            j3 = 0;
                                                                            a(0L);
                                                                            a(107, a(th), false);
                                                                            if (!this.r) {
                                                                            }
                                                                        }
                                                                    } else if (!z2) {
                                                                        str11 = str10;
                                                                        TbsDownloadConfig.getInstance(this.g).mSyncMap.put(str11, Long.valueOf(j11));
                                                                        TbsDownloadConfig.getInstance(this.g).commit();
                                                                    } else {
                                                                        str11 = str10;
                                                                    }
                                                                }
                                                            } catch (Throwable th35) {
                                                                th2 = th35;
                                                                str2 = str20;
                                                                z4 = z8;
                                                                str3 = str10;
                                                                th = th2;
                                                                if (th instanceof SSLHandshakeException) {
                                                                }
                                                                str4 = null;
                                                                th.printStackTrace();
                                                                j3 = 0;
                                                                a(0L);
                                                                a(107, a(th), false);
                                                                if (!this.r) {
                                                                }
                                                            }
                                                        } else if (responseCode < 300 || responseCode > 307) {
                                                            a(102, String.valueOf(responseCode), false);
                                                            if (responseCode == 416) {
                                                                if (c(true, z8)) {
                                                                    try {
                                                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                                                                        if (!z2) {
                                                                            TbsDownloadConfig.getInstance(this.g).mSyncMap.put(str10, Long.valueOf(j11));
                                                                            TbsDownloadConfig.getInstance(this.g).commit();
                                                                        }
                                                                        z4 = z8;
                                                                        z5 = true;
                                                                    } catch (Throwable th36) {
                                                                        th = th36;
                                                                        str2 = str20;
                                                                        z9 = true;
                                                                    }
                                                                } else {
                                                                    d(false);
                                                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-313);
                                                                }
                                                            } else if ((responseCode == 403 || responseCode == 406) && this.l == -1) {
                                                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-314);
                                                            } else if (responseCode != 202) {
                                                                int i4 = this.p;
                                                                int i5 = this.B;
                                                                if (i4 < i5 && responseCode == 503) {
                                                                    a(Long.parseLong(this.t.getHeaderField("Retry-After")));
                                                                    if (this.r) {
                                                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                    }
                                                                } else if (i4 < i5 && (responseCode == 408 || responseCode == 504 || responseCode == 502 || responseCode == 408)) {
                                                                    a(0L);
                                                                    if (this.r) {
                                                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                                    }
                                                                } else if (j() > 0 || this.o || responseCode == 410) {
                                                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-315);
                                                                } else {
                                                                    this.o = true;
                                                                }
                                                            }
                                                        } else {
                                                            try {
                                                                String headerField = this.t.getHeaderField(HttpHeaders.HEAD_KEY_LOCATION);
                                                                if (!TextUtils.isEmpty(headerField)) {
                                                                    this.j = headerField;
                                                                    this.q++;
                                                                    if (!z2) {
                                                                        TbsDownloadConfig.getInstance(this.g).mSyncMap.put(str10, Long.valueOf(j11));
                                                                        TbsDownloadConfig.getInstance(this.g).commit();
                                                                    }
                                                                    str11 = str10;
                                                                } else {
                                                                    a(124, (String) null, true);
                                                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-312);
                                                                    if (!z2) {
                                                                    }
                                                                }
                                                            } catch (Throwable th37) {
                                                                th = th37;
                                                                str2 = str20;
                                                                z4 = z8;
                                                                str3 = str10;
                                                                if (th instanceof SSLHandshakeException) {
                                                                }
                                                                str4 = null;
                                                                th.printStackTrace();
                                                                j3 = 0;
                                                                a(0L);
                                                                a(107, a(th), false);
                                                                if (!this.r) {
                                                                }
                                                            }
                                                        }
                                                        str21 = str11;
                                                        str18 = str;
                                                        downloadMaxflow = j2;
                                                        z7 = true;
                                                        str19 = null;
                                                    }
                                                }
                                                if (this.p >= 1) {
                                                }
                                                int responseCode2 = this.t.getResponseCode();
                                                TbsLog.i(str20, "[TbsApkDownloader.startDownload] responseCode=" + responseCode2);
                                                this.v.setHttpCode(responseCode2);
                                                b();
                                                if (QbSdk.m != null) {
                                                }
                                                TbsLog.i(str20, "Download is canceled due to NOT_WIFI error!", false);
                                                if (!this.r) {
                                                }
                                            } catch (Throwable th38) {
                                                th2 = th38;
                                                str2 = str20;
                                                z4 = z8;
                                                str3 = str7;
                                                th = th2;
                                                if (th instanceof SSLHandshakeException) {
                                                }
                                                str4 = null;
                                                th.printStackTrace();
                                                j3 = 0;
                                                a(0L);
                                                a(107, a(th), false);
                                                if (!this.r) {
                                                }
                                            }
                                        } else {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("[TbsApkDownloader.startDownload] downloadFlow=");
                                            j11 = j11;
                                            sb5.append(j11);
                                            TbsLog.i(str20, sb5.toString());
                                            if (j11 >= downloadMaxflow) {
                                                TbsLog.i(str20, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                                                a(112, (String) null, true);
                                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-307);
                                            } else {
                                                if (!f.b(this.g)) {
                                                }
                                                this.y = true;
                                                str5 = this.j;
                                                if (str5 == null) {
                                                }
                                                StringBuilder sb6 = new StringBuilder();
                                                str = str18;
                                                sb6.append("try url:");
                                                sb6.append(str5);
                                                sb6.append(",mRetryTimes:");
                                                sb6.append(this.p);
                                                TbsLog.i(str20, sb6.toString(), true);
                                                if (!str5.equals(this.i)) {
                                                }
                                                this.i = str5;
                                                a(str5);
                                                str6 = "/";
                                                if (!this.o) {
                                                }
                                                this.v.setDownloadCancel(j5 == 0 ? 0 : 1);
                                                apnType = Apn.getApnType(this.g);
                                                apnInfo = Apn.getApnInfo(this.g);
                                                str9 = this.w;
                                                if (str9 != null) {
                                                }
                                                this.v.setNetworkChange(0);
                                                this.w = apnInfo;
                                                this.x = apnType;
                                                if (this.p >= 1) {
                                                }
                                                int responseCode22 = this.t.getResponseCode();
                                                TbsLog.i(str20, "[TbsApkDownloader.startDownload] responseCode=" + responseCode22);
                                                this.v.setHttpCode(responseCode22);
                                                b();
                                                if (QbSdk.m != null) {
                                                }
                                                TbsLog.i(str20, "Download is canceled due to NOT_WIFI error!", false);
                                                if (!this.r) {
                                                }
                                            }
                                        }
                                    } catch (Throwable th39) {
                                        th7 = th39;
                                        j11 = j11;
                                        th = th7;
                                        str = str18;
                                        str2 = str20;
                                        j2 = downloadMaxflow;
                                        z4 = z8;
                                        str3 = str21;
                                        if (th instanceof SSLHandshakeException) {
                                        }
                                        str4 = null;
                                        th.printStackTrace();
                                        j3 = 0;
                                        a(0L);
                                        a(107, a(th), false);
                                        if (!this.r) {
                                        }
                                    }
                                } catch (Throwable th40) {
                                    th7 = th40;
                                    th = th7;
                                    str = str18;
                                    str2 = str20;
                                    j2 = downloadMaxflow;
                                    z4 = z8;
                                    str3 = str21;
                                    if (th instanceof SSLHandshakeException) {
                                    }
                                    str4 = null;
                                    th.printStackTrace();
                                    j3 = 0;
                                    a(0L);
                                    a(107, a(th), false);
                                    if (!this.r) {
                                    }
                                }
                            } else {
                                this.y = true;
                                str5 = this.j;
                                if (str5 == null) {
                                }
                                StringBuilder sb62 = new StringBuilder();
                                str = str18;
                                sb62.append("try url:");
                                sb62.append(str5);
                                sb62.append(",mRetryTimes:");
                                sb62.append(this.p);
                                TbsLog.i(str20, sb62.toString(), true);
                                if (!str5.equals(this.i)) {
                                }
                                this.i = str5;
                                a(str5);
                                str6 = "/";
                                if (!this.o) {
                                }
                                this.v.setDownloadCancel(j5 == 0 ? 0 : 1);
                                apnType = Apn.getApnType(this.g);
                                apnInfo = Apn.getApnInfo(this.g);
                                str9 = this.w;
                                if (str9 != null) {
                                }
                                this.v.setNetworkChange(0);
                                this.w = apnInfo;
                                this.x = apnType;
                                if (this.p >= 1) {
                                }
                                int responseCode222 = this.t.getResponseCode();
                                TbsLog.i(str20, "[TbsApkDownloader.startDownload] responseCode=" + responseCode222);
                                this.v.setHttpCode(responseCode222);
                                b();
                                if (QbSdk.m != null) {
                                }
                                TbsLog.i(str20, "Download is canceled due to NOT_WIFI error!", false);
                                if (!this.r) {
                                }
                            }
                            TbsDownloadConfig.getInstance(this.g).commit();
                        }
                    }
                    TbsDownloadConfig.getInstance(this.g).commit();
                    z5 = z9;
                    if (!this.r) {
                        if (this.s) {
                            if (this.b == null && !z5) {
                                z5 = c(true, z4);
                            }
                            TbsLogReport.TbsLogInfo tbsLogInfo = this.v;
                            int i6 = z5 ? 1 : 0;
                            int i7 = z5 ? 1 : 0;
                            int i8 = z5 ? 1 : 0;
                            int i9 = z5 ? 1 : 0;
                            int i10 = z5 ? 1 : 0;
                            tbsLogInfo.setUnpkgFlag(i6);
                            if (!z4) {
                                this.v.setPatchUpdateFlag(z5 ? 1 : 2);
                            } else {
                                this.v.setPatchUpdateFlag(0);
                            }
                            if (z5) {
                                c(true);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                a(100, "success", true);
                            } else {
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                i2 = 0;
                                d(false);
                                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(this.g);
                                if (!z5) {
                                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, Integer.valueOf(instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i2) + 1));
                                } else {
                                    int i11 = instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i2) + 1;
                                    instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, Integer.valueOf(i11));
                                    if (i11 == instance.getDownloadFailedMaxRetrytimes()) {
                                        this.v.setDownloadCancel(2);
                                    }
                                }
                                instance.commit();
                                TbsLogReport.TbsLogInfo tbsLogInfo2 = this.v;
                                int i12 = z5 ? 1 : 0;
                                int i13 = z5 ? 1 : 0;
                                tbsLogInfo2.setDownFinalFlag(i12);
                            }
                        }
                        i2 = 0;
                        TbsDownloadConfig instance2 = TbsDownloadConfig.getInstance(this.g);
                        if (!z5) {
                        }
                        instance2.commit();
                        TbsLogReport.TbsLogInfo tbsLogInfo22 = this.v;
                        int i122 = z5 ? 1 : 0;
                        int i132 = z5 ? 1 : 0;
                        tbsLogInfo22.setDownFinalFlag(i122);
                    }
                    f();
                } else {
                    TbsLog.i(str20, "[TbsApkDownloader.startDownload] WIFI Unavailable");
                    QbSdk.m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
                }
            } else {
                TbsDownloader.a = false;
            }
        } else {
            TbsDownloader.a = false;
            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-322);
        }
    }

    public boolean a(boolean z2) {
        String[] strArr;
        int i2;
        if ((z2 && !m() && (!QbSdk.getDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.g))) || (strArr = this.b) == null || (i2 = this.c) < 0 || i2 >= strArr.length) {
            return false;
        }
        this.c = i2 + 1;
        this.j = strArr[i2];
        this.p = 0;
        this.q = 0;
        this.l = -1;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
        return true;
    }

    private long a(long j2, long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        this.v.setDownConsumeTime(currentTimeMillis - j2);
        this.v.setDownloadSize(j3);
        return currentTimeMillis;
    }

    private void a(int i2, String str, boolean z2) {
        if (z2 || this.p > this.B) {
            this.v.setErrorCode(i2);
            this.v.setFailDetail(str);
        }
    }

    private String a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, 1024) : stackTraceString;
    }

    private void c(boolean z2) {
        q.a(this.g);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(this.g);
        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -123);
        instance.commit();
        QbSdk.m.onDownloadFinish(z2 ? 100 : 120);
        int i2 = instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        boolean a2 = TbsDownloader.a(this.g);
        if (i2 == 5) {
            Bundle a3 = a(i2, a2);
            if (a3 != null) {
                m.a().b(this.g, a3);
            }
        } else if (i2 == 3 || i2 > 10000) {
            File a4 = a(this.g);
            if (a4 != null) {
                m.a().b(this.g, a(i2, a4, a2));
                return;
            }
            c();
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, true);
            instance.commit();
        } else {
            m.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
            a(new File(this.k, "x5.tbs"), this.g);
        }
    }

    public Bundle a(int i2, boolean z2) {
        int i3;
        File file;
        File file2;
        if (z2) {
            file = m.a().p(this.g);
            i3 = m.a().h(this.g);
        } else {
            file = m.a().q(this.g);
            i3 = m.a().i(this.g);
        }
        File file3 = new File(this.k, "x5.tbs");
        String absolutePath = file3.exists() ? file3.getAbsolutePath() : null;
        if (absolutePath == null) {
            return null;
        }
        int i4 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        if (z2) {
            file2 = m.a().f(this.g, 6);
        } else {
            file2 = m.a().f(this.g, 5);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("operation", i2);
        bundle.putInt("old_core_ver", i3);
        bundle.putInt("new_core_ver", i4);
        bundle.putString("old_apk_location", file.getAbsolutePath());
        bundle.putString("new_apk_location", file2.getAbsolutePath());
        bundle.putString("diff_file_location", absolutePath);
        String a2 = f.a(this.g, 7);
        File file4 = new File(a2);
        if (!file4.exists()) {
            file4.mkdirs();
        }
        bundle.putString("backup_apk", new File(a2, i4 + ".tbs").getAbsolutePath());
        return bundle;
    }

    public Bundle a(int i2, File file, boolean z2) {
        File file2;
        if (z2) {
            file2 = new File(file, TbsDownloader.getBackupFileName(true));
        } else {
            file2 = new File(file, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
        }
        int a2 = a.a(this.g, file2);
        File file3 = new File(this.k, "x5.tbs");
        String absolutePath = file3.exists() ? file3.getAbsolutePath() : null;
        int i3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        Bundle bundle = new Bundle();
        bundle.putInt("operation", i2);
        bundle.putInt("old_core_ver", a2);
        bundle.putInt("new_core_ver", i3);
        bundle.putString("old_apk_location", file2.getAbsolutePath());
        bundle.putString("new_apk_location", absolutePath);
        bundle.putString("diff_file_location", absolutePath);
        return bundle;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void a(long j2) {
        this.p++;
        if (j2 <= 0) {
            try {
                j2 = l();
            } catch (Exception unused) {
                return;
            }
        }
        Thread.sleep(j2);
    }

    private File g() {
        return TbsDownloader.a(this.g) ? new File(f.a(this.g, 4), TbsDownloader.getBackupFileName(true)) : new File(f.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
    }

    private boolean a(File file) {
        int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        if (i2 == 0) {
            i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        }
        return a.a(this.g, file, 0, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
        if (r10 != r8) goto L_0x0087;
     */
    private boolean c(boolean z2, boolean z3) {
        boolean z4;
        int i2;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z2);
        File file = new File(this.k, !z2 ? "x5.tbs" : "x5.tbs.temp");
        boolean z5 = false;
        if (!file.exists()) {
            return false;
        }
        Exception exc = null;
        String string = TbsDownloadConfig.getInstance(this.g).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, null);
        String a2 = a.a(file);
        if (string == null || !string.equals(a2)) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z2 + " md5 failed");
            if (z2) {
                this.v.setCheckErrorDetail("fileMd5 not match");
            }
            return false;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] md5(" + a2 + ") successful!");
        long j2 = 0;
        if (z2) {
            long j3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
            if (file.exists()) {
                if (j3 > 0) {
                    j2 = file.length();
                }
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z2 + " filelength failed");
            TbsLogReport.TbsLogInfo tbsLogInfo = this.v;
            tbsLogInfo.setCheckErrorDetail("fileLength:" + j2 + ",contentLength:" + j3);
            return false;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] length(" + j2 + ") successful!");
        int i3 = -1;
        if (!z3 || z2 || (i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)) == (i3 = a.a(this.g, file))) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i3 + ") successful!");
            if (z3 && !z2) {
                String a3 = b.a(this.g, false, file);
                if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(a3)) {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z2 + " signature failed");
                    if (z2) {
                        TbsLogReport.TbsLogInfo tbsLogInfo2 = this.v;
                        StringBuilder sb = new StringBuilder();
                        sb.append("signature:");
                        sb.append(a3 == null ? "null" : Integer.valueOf(a3.length()));
                        tbsLogInfo2.setCheckErrorDetail(sb.toString());
                    }
                    return false;
                }
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] signature successful!");
            if (z2) {
                try {
                    z4 = file.renameTo(new File(this.k, "x5.tbs"));
                } catch (Exception e2) {
                    exc = e2;
                    z4 = false;
                }
                if (!z4) {
                    a(109, a(exc), true);
                    return false;
                }
                z5 = z4;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] rename(" + z5 + ") successful!");
            return true;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z2 + " versionCode failed");
        if (z2) {
            TbsLogReport.TbsLogInfo tbsLogInfo3 = this.v;
            tbsLogInfo3.setCheckErrorDetail("fileVersion:" + i3 + ",configVersion:" + i2);
        }
        return false;
    }

    private boolean d(boolean z2) {
        File file;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=" + z2);
        if (z2) {
            file = new File(this.k, "x5.tbs");
        } else {
            file = new File(this.k, "x5.tbs.temp");
        }
        if (file.exists()) {
            f.b(file);
        }
        return true;
    }

    private void h() {
        try {
            File g2 = g();
            if (g2 != null && g2.exists()) {
                f.b(g2);
                File[] listFiles = g2.getParentFile().listFiles();
                Pattern compile = Pattern.compile(a.a(TbsDownloader.a(this.g)) + "(.*)");
                for (File file : listFiles) {
                    if (compile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                        f.b(file);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean i() {
        return new File(this.k, "x5.tbs.temp").exists();
    }

    private long j() {
        File file = new File(this.k, "x5.tbs.temp");
        if (file.exists()) {
            return file.length();
        }
        return 0;
    }

    private boolean k() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        InputStream inputStream;
        Throwable th;
        boolean z2 = false;
        try {
            inputStream = Runtime.getRuntime().exec("ping " + "www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i2 = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                if (!readLine.contains("TTL") && !readLine.contains("ttl")) {
                                    i2++;
                                    if (i2 >= 5) {
                                        break;
                                    }
                                } else {
                                    z2 = true;
                                }
                            } else {
                                break;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                                a(inputStream);
                                a(inputStreamReader);
                                a(bufferedReader);
                                return z2;
                            } catch (Throwable th3) {
                                a(inputStream);
                                a(inputStreamReader);
                                a(bufferedReader);
                                throw th3;
                            }
                        }
                    }
                    z2 = true;
                } catch (Throwable th4) {
                    bufferedReader = null;
                    th = th4;
                    th.printStackTrace();
                    a(inputStream);
                    a(inputStreamReader);
                    a(bufferedReader);
                    return z2;
                }
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
                inputStreamReader = null;
                th.printStackTrace();
                a(inputStream);
                a(inputStreamReader);
                a(bufferedReader);
                return z2;
            }
        } catch (Throwable th6) {
            inputStreamReader = null;
            bufferedReader = null;
            th = th6;
            inputStream = null;
            th.printStackTrace();
            a(inputStream);
            a(inputStreamReader);
            a(bufferedReader);
            return z2;
        }
        a(inputStream);
        a(inputStreamReader);
        a(bufferedReader);
        return z2;
    }

    private String a(URL url) {
        try {
            return InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Error e3) {
            e3.printStackTrace();
        }
        return "";
    }

    private long l() {
        int i2 = this.p;
        if (i2 == 1 || i2 == 2) {
            return ((long) i2) * 20000;
        }
        return (i2 == 3 || i2 == 4) ? 100000 : 200000;
    }

    static File a(Context context) {
        try {
            File file = Build.VERSION.SDK_INT >= 8 ? new File(f.a(context, 4)) : null;
            if (file != null && !file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
            return file;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            return null;
        }
    }

    static File b(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 8) {
                return null;
            }
            File a2 = a(context, 4);
            if (a2 == null) {
                a2 = a(context, 3);
            }
            if (a2 == null) {
                a2 = a(context, 2);
            }
            return a2 == null ? a(context, 1) : a2;
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            return null;
        }
    }

    private static File a(Context context, int i2) {
        String str;
        File file = new File(f.a(context, i2));
        if (file.exists() && file.isDirectory()) {
            if (TbsDownloader.getOverSea(context)) {
                str = "x5.oversea.tbs.org";
            } else {
                str = TbsDownloader.getBackupFileName(false);
            }
            if (new File(file, str).exists()) {
                return file;
            }
        }
        return null;
    }

    public int b(boolean z2) {
        File a2 = a(this.g);
        if (z2) {
            if (a2 == null) {
                return 0;
            }
            return a.a(this.g, new File(a2, TbsDownloader.getBackupFileName(true)));
        } else if (a2 == null) {
            return 0;
        } else {
            return a.a(this.g, new File(a2, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false)));
        }
    }

    public void b() {
        this.r = true;
        if (TbsShareManager.isThirdPartyApp(this.g)) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(this.g).tbsLogInfo();
            tbsLogInfo.setErrorCode(-309);
            tbsLogInfo.setFailDetail(new Exception());
            if (TbsDownloader.a(this.g)) {
                TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, tbsLogInfo);
            } else {
                TbsLogReport.getInstance(this.g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
            }
        }
    }

    public void c() {
        b();
        d(false);
        d(true);
    }

    public void a(int i2) {
        if (m.a().t(this.g)) {
            m.a().b();
            try {
                File file = new File(this.k, "x5.tbs");
                int a2 = a.a(this.g, file);
                if (-1 == a2 || (i2 > 0 && i2 == a2)) {
                    f.b(file);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(File file, Context context) {
        File file2;
        synchronized (a.class) {
            if (file != null) {
                if (file.exists()) {
                    try {
                        File a2 = a(context);
                        if (a2 != null) {
                            if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                file2 = new File(a2, TbsDownloader.getBackupFileName(true));
                            } else {
                                file2 = new File(a2, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                            }
                            file2.delete();
                            f.b(file, file2);
                            boolean contains = file2.getName().contains("tbs.org");
                            boolean contains2 = file2.getName().contains("x5.tbs.decouple");
                            if (contains2 || contains) {
                                File[] listFiles = a2.listFiles();
                                Pattern compile = Pattern.compile(a.a(contains2) + "(.*)");
                                for (File file3 : listFiles) {
                                    if (compile.matcher(file3.getName()).find() && file3.isFile() && file3.exists()) {
                                        file3.delete();
                                    }
                                }
                                File file4 = new File(a2, a.a(contains2) + "." + TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                if (file4.exists()) {
                                    TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
                                    return;
                                }
                                file4.createNewFile();
                            }
                            if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1 && TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0) == a.a(context, file)) {
                                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                                if (i2 == 5 || i2 == 3) {
                                    TbsLog.i("TbsApkDownloader", "response code=" + i2 + "return backup decouple apk");
                                }
                                File file5 = new File(a2, TbsDownloader.getBackupFileName(true));
                                if (a.a(context, file) != a.a(context, file5)) {
                                    file5.delete();
                                    f.b(file, file5);
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public static void c(Context context) {
        try {
            m.a();
            File s2 = m.s(context);
            new File(s2, "x5.tbs").delete();
            new File(s2, "x5.tbs.temp").delete();
            File a2 = a(context);
            if (a2 != null) {
                new File(a2, TbsDownloader.getBackupFileName(false)).delete();
                new File(a2, "x5.oversea.tbs.org").delete();
                File[] listFiles = a2.listFiles();
                Pattern compile = Pattern.compile(a.a(true) + "(.*)");
                for (File file : listFiles) {
                    if (compile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                        file.delete();
                    }
                }
                Pattern compile2 = Pattern.compile(a.a(false) + "(.*)");
                for (File file2 : listFiles) {
                    if (compile2.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008e A[SYNTHETIC, Splitter:B:25:0x008e] */
    private boolean m() {
        Throwable th;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = Apn.getApnType(this.g) == 3;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z4);
        String str = null;
        HttpURLConnection httpURLConnection = null;
        if (z4) {
            String wifiSSID = Apn.getWifiSSID(this.g);
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=" + wifiSSID);
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("http://pms.mb.qq.com/rsp204").openConnection();
                try {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(10000);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.getInputStream();
                    int responseCode = httpURLConnection2.getResponseCode();
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                    if (responseCode != 204) {
                        z2 = false;
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                    str = wifiSSID;
                    z3 = z2;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        th.printStackTrace();
                        str = wifiSSID;
                        this.A.add(str);
                        n();
                        this.z.sendMessageDelayed(this.z.obtainMessage(150, str), 120000);
                        this.A.remove(str);
                        return z3;
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                str = wifiSSID;
                this.A.add(str);
                n();
                this.z.sendMessageDelayed(this.z.obtainMessage(150, str), 120000);
                this.A.remove(str);
                return z3;
            }
        }
        if (!z3 && !TextUtils.isEmpty(str) && !this.A.contains(str)) {
            this.A.add(str);
            n();
            this.z.sendMessageDelayed(this.z.obtainMessage(150, str), 120000);
        }
        if (z3 && this.A.contains(str)) {
            this.A.remove(str);
        }
        return z3;
    }

    private void n() {
        if (this.z == null) {
            this.z = new Handler(l.a().getLooper()) {
                /* class com.tencent.smtt.sdk.j.AnonymousClass1 */

                public void handleMessage(Message message) {
                    if (message.what == 150) {
                        j.this.m();
                    }
                }
            };
        }
    }

    public boolean d() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
        return this.C;
    }
}
