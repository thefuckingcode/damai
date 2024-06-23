package com.tencent.open.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.huawei.hms.adapter.internal.CommonCode;
import com.taobao.orange.OConstant;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class h {
    protected static h a;
    protected Random b = new SecureRandom();
    protected List<Serializable> c = Collections.synchronizedList(new ArrayList());
    protected List<Serializable> d = Collections.synchronizedList(new ArrayList());
    protected HandlerThread e = null;
    protected Handler f;
    protected Executor g = l.b();
    protected Executor h = l.b();

    private h() {
        if (this.e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e = handlerThread;
            handlerThread.start();
        }
        if (this.e.isAlive() && this.e.getLooper() != null) {
            this.f = new Handler(this.e.getLooper()) {
                /* class com.tencent.open.b.h.AnonymousClass1 */

                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 1000) {
                        h.this.b();
                    } else if (i == 1001) {
                        h.this.d();
                    }
                    super.handleMessage(message);
                }
            };
        }
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (a == null) {
                a = new h();
            }
            hVar = a;
        }
        return hVar;
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public Map<String, String> c() {
        List<Serializable> b2 = g.b("report_via");
        if (b2 != null) {
            this.d.addAll(b2);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<Serializable> it = this.d.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = new JSONObject();
            c cVar = (c) it.next();
            for (String str : cVar.a.keySet()) {
                try {
                    String str2 = cVar.a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e2) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject2.toString());
            return hashMap;
        } catch (JSONException e3) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e3);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (m.b(g.a())) {
            this.g.execute(new Runnable() {
                /* class com.tencent.open.b.h.AnonymousClass3 */

                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
                    r0 = -4;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x0096, code lost:
                    r0 = e;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
                    r11 = 0;
                    r8 = -6;
                    r0 = r4;
                    r9 = 0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bd, code lost:
                    continue;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Removed duplicated region for block: B:26:0x0096 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:11:0x0068] */
                /* JADX WARNING: Removed duplicated region for block: B:28:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:8:0x0032] */
                /* JADX WARNING: Removed duplicated region for block: B:39:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:11:0x0068] */
                /* JADX WARNING: Removed duplicated region for block: B:55:0x00bf A[SYNTHETIC] */
                public void run() {
                    long j;
                    long j2;
                    long j3;
                    boolean z;
                    long j4;
                    long j5;
                    int i;
                    try {
                        Map<String, String> c = h.this.c();
                        if (c != null) {
                            SLog.d("openSDK_LOG.ReportManager", "-->doReportVia, params: " + c.toString());
                            int a2 = f.a();
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            int i2 = 0;
                            int i3 = 0;
                            while (true) {
                                int i4 = i2 + 1;
                                try {
                                    com.tencent.open.a.g b = f.a().b("https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", c);
                                    SLog.i("openSDK_LOG.ReportManager", "-->reportVia: statusCode " + b.d());
                                    JSONObject d = m.d(b.a());
                                    long c2 = (long) b.c();
                                    i = i4;
                                    j5 = (long) b.b();
                                    if (b.d() == 200) {
                                        int i5 = d.getInt("ret");
                                        if (i5 != 0 && j5 == 0) {
                                            j4 = c2;
                                            i2 = i;
                                            continue;
                                            if (i2 >= a2) {
                                                j3 = elapsedRealtime;
                                                j = j5;
                                                j2 = j4;
                                                break;
                                            }
                                        } else {
                                            j3 = elapsedRealtime;
                                            j = j5;
                                            j2 = c2;
                                            z = true;
                                        }
                                    } else {
                                        i3 = b.d();
                                        j3 = elapsedRealtime;
                                        j = j5;
                                        j2 = c2;
                                        break;
                                    }
                                } catch (SocketTimeoutException unused) {
                                    i = i4;
                                    j4 = 0;
                                    elapsedRealtime = SystemClock.elapsedRealtime();
                                    i3 = -8;
                                    j5 = j4;
                                    i2 = i;
                                    continue;
                                    if (i2 >= a2) {
                                    }
                                } catch (JSONException unused2) {
                                    i = i4;
                                    j4 = 0;
                                    j5 = 0;
                                    i2 = i;
                                    i3 = -4;
                                    continue;
                                    if (i2 >= a2) {
                                    }
                                } catch (IOException e) {
                                    IOException e2 = e;
                                    i = i4;
                                    j4 = 0;
                                    i3 = HttpUtils.getErrorCodeFromException(e2);
                                    j5 = j4;
                                    i2 = i;
                                    continue;
                                    if (i2 >= a2) {
                                    }
                                } catch (Exception unused3) {
                                }
                            }
                            z = false;
                            h.this.a("mapp_apptrace_sdk", j3, j2, j, i3, null, false);
                            if (z) {
                                g.a("report_via");
                            } else {
                                g.a("report_via", h.this.d);
                            }
                            h.this.d.clear();
                            SLog.i("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z + " resultCode: " + i3);
                        }
                    } catch (Exception e3) {
                        SLog.e("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e3);
                    }
                }
            });
        }
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle != null) {
            SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
            if (a("report_via", str) || z) {
                this.g.execute(new Runnable() {
                    /* class com.tencent.open.b.h.AnonymousClass2 */

                    public void run() {
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putString("uin", "1000");
                            bundle.putString("platform", "1");
                            bundle.putString(OConstant.CANDIDATE_OSVER, Build.VERSION.getRELEASE());
                            bundle.putString("position", "");
                            bundle.putString("network", a.a(g.a()));
                            bundle.putString("language", d.a());
                            bundle.putString(CommonCode.MapKey.HAS_RESOLUTION, d.a(g.a()));
                            bundle.putString("apn", a.b(g.a()));
                            bundle.putString(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().c(g.a()));
                            bundle.putString("timezone", TimeZone.getDefault().getID());
                            bundle.putString("sdk_ver", Constants.SDK_VERSION);
                            bundle.putString("qz_ver", m.d(g.a(), Constants.PACKAGE_QZONE));
                            bundle.putString(Constants.PARAM_QQ_VER, m.c(g.a(), "com.tencent.mobileqq"));
                            bundle.putString("qua", m.e(g.a(), g.b()));
                            bundle.putString("packagename", g.b());
                            bundle.putString("app_ver", m.d(g.a(), g.b()));
                            Bundle bundle2 = bundle;
                            if (bundle2 != null) {
                                bundle.putAll(bundle2);
                            }
                            h.this.d.add(new c(bundle));
                            int size = h.this.d.size();
                            int a2 = i.a(g.a(), (String) null).a("Agent_ReportTimeInterval");
                            if (a2 == 0) {
                                a2 = 10000;
                            }
                            if (!h.this.a("report_via", size)) {
                                if (!z) {
                                    if (!h.this.f.hasMessages(1001)) {
                                        Message obtain = Message.obtain();
                                        obtain.what = 1001;
                                        h.this.f.sendMessageDelayed(obtain, (long) a2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            h.this.d();
                            h.this.f.removeMessages(1001);
                        } catch (Exception e) {
                            SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                        }
                    }
                });
            }
        }
    }

    public void a(String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, "", false);
    }

    public void a(String str, long j, long j2, long j3, int i, String str2, boolean z) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
    }

    /* access modifiers changed from: protected */
    public boolean a(String str, String str2) {
        int i;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 100;
        if (str.equals("report_cgi")) {
            try {
                i = a(Integer.parseInt(str2));
                if (this.b.nextInt(100) < i) {
                    z = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                i = f.a(str2);
                if (this.b.nextInt(100) < i) {
                    i2 = i;
                    z = true;
                }
            }
            SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i2);
            return z;
        }
        i2 = i;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i2);
        return z;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (r0 == 0) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0034, code lost:
        if (r0 == 0) goto L_0x0038;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0060 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0062 A[RETURN] */
    public boolean a(String str, int i) {
        int a2;
        int i2 = 5;
        if (str.equals("report_cgi")) {
            a2 = i.a(g.a(), (String) null).a("Common_CGIReportMaxcount");
        } else {
            if (str.equals("report_via")) {
                a2 = i.a(g.a(), (String) null).a("Agent_ReportBatchCount");
            } else {
                i2 = 0;
            }
            SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
            if (i < i2) {
                return true;
            }
            return false;
        }
        i2 = a2;
        SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
        if (i < i2) {
        }
    }

    /* access modifiers changed from: protected */
    public int a(int i) {
        if (i == 0) {
            int a2 = i.a(g.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (a2 == 0) {
                return 10;
            }
            return a2;
        }
        int a3 = i.a(g.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (a3 == 0) {
            return 100;
        }
        return a3;
    }

    public void a(final String str, final Map<String, String> map) {
        if (m.b(g.a())) {
            l.b(new Runnable() {
                /* class com.tencent.open.b.h.AnonymousClass4 */

                public void run() {
                    int i = 0;
                    try {
                        int a2 = f.a();
                        if (a2 == 0) {
                            a2 = 3;
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + a2);
                        do {
                            i++;
                            try {
                                int d = f.a().a(str, map).d();
                                SLog.i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + d);
                                return;
                            } catch (SocketTimeoutException e) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e);
                                if (i >= a2) {
                                }
                            } catch (Exception e2) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e2);
                                return;
                            }
                        } while (i >= a2);
                    } catch (Exception e3) {
                        SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e3);
                    }
                }
            });
        }
    }
}
