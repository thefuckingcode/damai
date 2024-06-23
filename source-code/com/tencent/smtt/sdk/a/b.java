package com.tencent.smtt.sdk.a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.lzy.okgo.model.HttpHeaders;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.h;
import com.tencent.smtt.utils.l;
import com.tencent.smtt.utils.n;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import kotlin.UByte;
import org.json.JSONObject;

/* compiled from: HttpUtils */
public class b {
    public static byte[] a;

    static {
        try {
            a = "65dRa93L".getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public static void a(final ThirdAppInfoNew thirdAppInfoNew, final Context context) {
        new Thread("HttpUtils") {
            /* class com.tencent.smtt.sdk.a.b.AnonymousClass1 */

            public void run() {
                String str;
                String str2;
                String str3;
                byte[] bArr;
                com.tencent.smtt.utils.b.b(context, thirdAppInfoNew.sGuid);
                thirdAppInfoNew.sCpu = com.tencent.smtt.utils.b.a();
                if (Build.VERSION.SDK_INT >= 8) {
                    JSONObject jSONObject = null;
                    if (b.a == null) {
                        try {
                            b.a = "65dRa93L".getBytes("utf-8");
                        } catch (UnsupportedEncodingException unused) {
                            b.a = null;
                            TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                        }
                    }
                    if (b.a == null) {
                        TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
                        return;
                    }
                    String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "");
                    if (!TextUtils.isEmpty(string)) {
                        str = string.substring(0, string.indexOf("&"));
                        str2 = string.substring(string.indexOf("&") + 1, string.length());
                    } else {
                        str2 = "";
                        str = str2;
                    }
                    boolean z = TextUtils.isEmpty(str) || str.length() != 96 || TextUtils.isEmpty(str2) || str2.length() != 24;
                    try {
                        n a2 = n.a();
                        if (z) {
                            str3 = a2.b() + h.a().b();
                        } else {
                            str3 = a2.f() + str;
                        }
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setConnectTimeout(20000);
                        if (Build.VERSION.SDK_INT > 13) {
                            httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE);
                        }
                        try {
                            jSONObject = b.c(thirdAppInfoNew, context);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (jSONObject == null) {
                            TbsLog.e("sdkreport", "post -- jsonData is null!");
                            return;
                        }
                        try {
                            byte[] bytes = jSONObject.toString().getBytes("utf-8");
                            if (z) {
                                bArr = h.a().a(bytes);
                            } else {
                                bArr = h.a(bytes, str2);
                            }
                            httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded");
                            httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONTENT_LENGTH, String.valueOf(bArr.length));
                            try {
                                OutputStream outputStream = httpURLConnection.getOutputStream();
                                outputStream.write(bArr);
                                outputStream.flush();
                                if (httpURLConnection.getResponseCode() == 200) {
                                    TbsLog.i("sdkreport", "Post successful!");
                                    TbsLog.i("sdkreport", "SIGNATURE is " + jSONObject.getString("SIGNATURE"));
                                    b.b(context, b.b(httpURLConnection, str2, z));
                                    new TbsDownloadUpload(context).clearUploadCode();
                                    return;
                                }
                                TbsLog.e("sdkreport", "Post failed -- not 200 code is " + httpURLConnection.getResponseCode());
                                TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                                tbsLogInfo.setErrorCode(126);
                                tbsLogInfo.setFailDetail("" + httpURLConnection.getResponseCode());
                                TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                            } catch (Throwable th) {
                                TbsLog.e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                                TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(context).tbsLogInfo();
                                tbsLogInfo2.setErrorCode(126);
                                tbsLogInfo2.setFailDetail(th);
                                TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
                            }
                        } catch (Throwable unused2) {
                        }
                    } catch (IOException e2) {
                        TbsLog.e("sdkreport", "Post failed -- IOException:" + e2);
                    } catch (AssertionError e3) {
                        TbsLog.e("sdkreport", "Post failed -- AssertionError:" + e3);
                    } catch (NoClassDefFoundError e4) {
                        TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:" + e4);
                    }
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public static JSONObject c(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", thirdAppInfoNew.sAppName);
            jSONObject.put("TIME", thirdAppInfoNew.sTime);
            jSONObject.put("QUA2", thirdAppInfoNew.sQua2);
            jSONObject.put("LC", thirdAppInfoNew.sLc);
            jSONObject.put("GUID", thirdAppInfoNew.sGuid);
            jSONObject.put("IMEI", thirdAppInfoNew.sImei);
            jSONObject.put("IMSI", thirdAppInfoNew.sImsi);
            jSONObject.put("MAC", thirdAppInfoNew.sMac);
            jSONObject.put("PV", thirdAppInfoNew.iPv);
            jSONObject.put("CORETYPE", thirdAppInfoNew.iCoreType);
            jSONObject.put("APPVN", thirdAppInfoNew.sAppVersionName);
            jSONObject.put("APPMETADATA", thirdAppInfoNew.sMetaData);
            jSONObject.put("VERSION_CODE", thirdAppInfoNew.sVersionCode);
            jSONObject.put("CPU", thirdAppInfoNew.sCpu);
            if (TbsConfig.APP_WX.equals(thirdAppInfoNew.sAppName) || TbsConfig.APP_QQ.equals(thirdAppInfoNew.sAppName) || TbsConfig.APP_DEMO.equals(thirdAppInfoNew.sAppName)) {
                TbsDownloadUpload tbsDownloadUpload = new TbsDownloadUpload(context);
                tbsDownloadUpload.readTbsDownloadInfo(context);
                int needDownloadCode = tbsDownloadUpload.getNeedDownloadCode();
                int startDownloadCode = tbsDownloadUpload.getStartDownloadCode();
                int needDownloadReturn = tbsDownloadUpload.getNeedDownloadReturn();
                int localCoreVersion = tbsDownloadUpload.getLocalCoreVersion();
                jSONObject.put("SIGNATURE", "" + needDownloadCode + ":" + startDownloadCode + ":" + needDownloadReturn + ":" + localCoreVersion);
            } else if (thirdAppInfoNew.sAppSignature == null) {
                jSONObject.put("SIGNATURE", "0");
            } else {
                jSONObject.put("SIGNATURE", thirdAppInfoNew.sAppSignature);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
            if (TbsShareManager.isThirdPartyApp(context)) {
                jSONObject.put("HOST_COREVERSION", TbsShareManager.getHostCoreVersions(context));
            } else {
                jSONObject.put("HOST_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
                jSONObject.put("DECOUPLE_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
            }
            if (thirdAppInfoNew.iCoreType == 0) {
                jSONObject.put("WIFICONNECTEDTIME", thirdAppInfoNew.sWifiConnectedTime);
                jSONObject.put("CORE_EXIST", thirdAppInfoNew.localCoreVersion);
                int i = TbsCoreLoadStat.mLoadErrorCode;
                if (thirdAppInfoNew.localCoreVersion <= 0) {
                    jSONObject.put("TBS_ERROR_CODE", TbsDownloadConfig.getInstance(context).getDownloadInterruptCode());
                } else {
                    jSONObject.put("TBS_ERROR_CODE", i);
                }
                if (i == -1) {
                    TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
                }
            }
            TbsDownloadConfig.getInstance(context).uploadDownloadInterruptCodeIfNeeded(context);
            try {
                if (QbSdk.getTID() != null) {
                    if (thirdAppInfoNew.sAppName.equals(TbsConfig.APP_QQ)) {
                        jSONObject.put("TID", QbSdk.getTID());
                        jSONObject.put("TIDTYPE", 0);
                    } else if (thirdAppInfoNew.sAppName.equals(TbsConfig.APP_WX)) {
                        jSONObject.put("TID", QbSdk.getTID());
                        jSONObject.put("TIDTYPE", 0);
                    }
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            TbsLog.e("sdkreport", "getPostData exception!");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b9 A[Catch:{ all -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bf A[Catch:{ all -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4 A[Catch:{ all -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f6 A[Catch:{ all -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010d A[Catch:{ all -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0123 A[Catch:{ all -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0138 A[Catch:{ all -> 0x0148 }] */
    public static void a(Context context, String str, String str2, String str3, int i, boolean z, long j, boolean z2) {
        String str4;
        ThirdAppInfoNew thirdAppInfoNew;
        String a2;
        String f;
        String d;
        String e;
        String g;
        Exception e2;
        if (QbSdk.getSettings() == null || !QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) || !QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            int i2 = 0;
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (TbsConfig.APP_QQ.equals(applicationInfo.packageName)) {
                    str4 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                    try {
                        if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                            str4 = str4 + "." + QbSdk.getQQBuildNumber();
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        thirdAppInfoNew = new ThirdAppInfoNew();
                        thirdAppInfoNew.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
                        n.a(context);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                        thirdAppInfoNew.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
                        thirdAppInfoNew.sVersionCode = com.tencent.smtt.utils.b.b(context);
                        a2 = com.tencent.smtt.utils.b.a(context, TbsDownloader.TBS_METADATA);
                        if (!TextUtils.isEmpty(a2)) {
                        }
                        thirdAppInfoNew.sGuid = str;
                        if (z) {
                        }
                        thirdAppInfoNew.sLc = str3;
                        f = com.tencent.smtt.utils.b.f(context);
                        d = com.tencent.smtt.utils.b.d(context);
                        e = com.tencent.smtt.utils.b.e(context);
                        g = com.tencent.smtt.utils.b.g(context);
                        thirdAppInfoNew.sImei = d;
                        thirdAppInfoNew.sImsi = e;
                        if (!TextUtils.isEmpty(g)) {
                        }
                        thirdAppInfoNew.sMac = f;
                        thirdAppInfoNew.iPv = (long) i;
                        if (!TbsShareManager.isThirdPartyApp(context)) {
                        }
                        thirdAppInfoNew.sAppVersionName = str4;
                        thirdAppInfoNew.sAppSignature = a(context);
                        if (!z) {
                        }
                        a(thirdAppInfoNew, context.getApplicationContext());
                    }
                } else {
                    str4 = "";
                }
            } catch (Exception e4) {
                e2 = e4;
                str4 = "";
                e2.printStackTrace();
                thirdAppInfoNew = new ThirdAppInfoNew();
                thirdAppInfoNew.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
                n.a(context);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                thirdAppInfoNew.sTime = simpleDateFormat2.format(Calendar.getInstance().getTime());
                thirdAppInfoNew.sVersionCode = com.tencent.smtt.utils.b.b(context);
                a2 = com.tencent.smtt.utils.b.a(context, TbsDownloader.TBS_METADATA);
                if (!TextUtils.isEmpty(a2)) {
                }
                thirdAppInfoNew.sGuid = str;
                if (z) {
                }
                thirdAppInfoNew.sLc = str3;
                f = com.tencent.smtt.utils.b.f(context);
                d = com.tencent.smtt.utils.b.d(context);
                e = com.tencent.smtt.utils.b.e(context);
                g = com.tencent.smtt.utils.b.g(context);
                thirdAppInfoNew.sImei = d;
                thirdAppInfoNew.sImsi = e;
                if (!TextUtils.isEmpty(g)) {
                }
                thirdAppInfoNew.sMac = f;
                thirdAppInfoNew.iPv = (long) i;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                }
                thirdAppInfoNew.sAppVersionName = str4;
                thirdAppInfoNew.sAppSignature = a(context);
                if (!z) {
                }
                a(thirdAppInfoNew, context.getApplicationContext());
            }
            try {
                thirdAppInfoNew = new ThirdAppInfoNew();
                thirdAppInfoNew.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
                n.a(context);
                SimpleDateFormat simpleDateFormat22 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                simpleDateFormat22.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                thirdAppInfoNew.sTime = simpleDateFormat22.format(Calendar.getInstance().getTime());
                thirdAppInfoNew.sVersionCode = com.tencent.smtt.utils.b.b(context);
                a2 = com.tencent.smtt.utils.b.a(context, TbsDownloader.TBS_METADATA);
                if (!TextUtils.isEmpty(a2)) {
                    thirdAppInfoNew.sMetaData = a2;
                }
                thirdAppInfoNew.sGuid = str;
                if (z) {
                    thirdAppInfoNew.sQua2 = str2;
                    thirdAppInfoNew.bIsSandboxMode = z2;
                } else {
                    thirdAppInfoNew.sQua2 = l.a(context);
                }
                thirdAppInfoNew.sLc = str3;
                f = com.tencent.smtt.utils.b.f(context);
                d = com.tencent.smtt.utils.b.d(context);
                e = com.tencent.smtt.utils.b.e(context);
                g = com.tencent.smtt.utils.b.g(context);
                if (d != null && !"".equals(d)) {
                    thirdAppInfoNew.sImei = d;
                }
                if (e != null && !"".equals(e)) {
                    thirdAppInfoNew.sImsi = e;
                }
                if (!TextUtils.isEmpty(g)) {
                    thirdAppInfoNew.sAndroidID = g;
                }
                if (f != null && !"".equals(f)) {
                    thirdAppInfoNew.sMac = f;
                }
                thirdAppInfoNew.iPv = (long) i;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    if (z) {
                        i2 = 1;
                    }
                    thirdAppInfoNew.iCoreType = i2;
                    if (z && z2) {
                        thirdAppInfoNew.iCoreType = 3;
                    }
                } else if (z) {
                    if (TbsShareManager.getCoreFormOwn()) {
                        thirdAppInfoNew.iCoreType = 2;
                    } else {
                        thirdAppInfoNew.iCoreType = 1;
                    }
                    if (z2) {
                        thirdAppInfoNew.iCoreType = 3;
                    }
                } else {
                    thirdAppInfoNew.iCoreType = 0;
                }
                thirdAppInfoNew.sAppVersionName = str4;
                thirdAppInfoNew.sAppSignature = a(context);
                if (!z) {
                    thirdAppInfoNew.sWifiConnectedTime = j;
                    thirdAppInfoNew.localCoreVersion = QbSdk.getTbsVersion(context);
                }
                a(thirdAppInfoNew, context.getApplicationContext());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
        }
    }

    private static String a(Context context) {
        try {
            byte[] byteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (byteArray != null) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(byteArray);
                byte[] digest = instance.digest();
                if (digest != null) {
                    StringBuilder sb = new StringBuilder("");
                    if (digest != null) {
                        if (digest.length > 0) {
                            for (int i = 0; i < digest.length; i++) {
                                String upperCase = Integer.toHexString(digest[i] & UByte.MAX_VALUE).toUpperCase();
                                if (i > 0) {
                                    sb.append(":");
                                }
                                if (upperCase.length() < 2) {
                                    sb.append(0);
                                }
                                sb.append(upperCase);
                            }
                            return sb.toString();
                        }
                    }
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A[Catch:{ Exception -> 0x007e, all -> 0x007a }, LOOP:0: B:17:0x0039->B:19:0x0040, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0047 A[Catch:{ Exception -> 0x007e, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059 A[Catch:{ Exception -> 0x007e, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071 A[SYNTHETIC, Splitter:B:29:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e A[SYNTHETIC, Splitter:B:45:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0098 A[SYNTHETIC, Splitter:B:50:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c4 A[SYNTHETIC, Splitter:B:59:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ce A[SYNTHETIC, Splitter:B:64:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0045 A[EDGE_INSN: B:69:0x0045->B:20:0x0045 ?: BREAK  , SYNTHETIC] */
    public static String b(HttpURLConnection httpURLConnection, String str, boolean z) {
        Throwable th;
        InputStream inputStream;
        String str2;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int read;
        InputStream inflaterInputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            String contentEncoding = httpURLConnection.getContentEncoding();
            if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                if (contentEncoding != null && contentEncoding.equalsIgnoreCase("deflate")) {
                    inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                }
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bArr = new byte[128];
                    while (true) {
                        read = inputStream.read(bArr);
                        if (read != -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!z) {
                        str2 = new String(h.a().c(byteArrayOutputStream.toByteArray()));
                    } else {
                        str2 = new String(h.b(byteArrayOutputStream.toByteArray(), str));
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Exception e4) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    e = e4;
                    try {
                        e.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        str2 = "";
                        TbsLog.i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    th = th3;
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
                TbsLog.i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
                return str2;
            }
            inflaterInputStream = new GZIPInputStream(inputStream);
            inputStream = inflaterInputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                bArr = new byte[128];
                while (true) {
                    read = inputStream.read(bArr);
                    if (read != -1) {
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (!z) {
                }
                byteArrayOutputStream.close();
                if (inputStream != null) {
                }
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                str2 = "";
                TbsLog.i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
                return str2;
            }
        } catch (Exception e10) {
            e = e10;
            inputStream = null;
            e.printStackTrace();
            if (byteArrayOutputStream2 != null) {
            }
            if (inputStream != null) {
            }
            str2 = "";
            TbsLog.i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
            return str2;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            if (byteArrayOutputStream2 != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
        TbsLog.i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z);
        return str2;
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            TbsPVConfig.releaseInstance();
            TbsPVConfig.getInstance(context).clear();
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split("\\|")) {
                    try {
                        String[] split = str2.split("=");
                        if (split.length == 2) {
                            a(context, split[0], split[1]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                TbsPVConfig.getInstance(context).commit();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(Context context, String str, String str2) {
        if (!"reset".equals(str) || !"true".equals(str2)) {
            TbsPVConfig.getInstance(context).putData(str, str2);
        } else {
            QbSdk.reset(context);
        }
    }
}
