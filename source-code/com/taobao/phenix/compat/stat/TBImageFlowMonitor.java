package com.taobao.phenix.compat.stat;

import android.os.Build;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import anet.channel.fulltrace.IFullTraceAnalysisV3;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.analysis.abtest.ABTestCenter;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import com.taobao.analysis.fulltrace.RequestInfo;
import com.taobao.analysis.scene.SceneIdentifier;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.mimetype.MimeType;
import com.taobao.phenix.cache.disk.OnlyCacheFailedException;
import com.taobao.phenix.decode.DecodeException;
import com.taobao.phenix.loader.network.HttpCodeResponseException;
import com.taobao.phenix.loader.network.IncompleteResponseException;
import com.taobao.phenix.loader.network.NetworkResponseException;
import com.taobao.phenix.request.ImageFlowMonitor;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.rxm.schedule.PairingThrottlingScheduler;
import com.taobao.weex.annotation.JSMethod;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Map;
import tb.ge2;
import tb.j22;
import tb.jl1;
import tb.ke1;
import tb.kg0;
import tb.ln0;
import tb.qk2;
import tb.tp1;
import tb.uh2;
import tb.vr2;

/* compiled from: Taobao */
public class TBImageFlowMonitor extends uh2 implements Pexode.ForcedDegradationListener, ImageFlowMonitor, PairingThrottlingScheduler.DegradationListener {
    private boolean c;
    private boolean d;
    private final NetworkAnalyzer e;
    private boolean f;
    private NavigationInfoObtainer g;
    private NonCriticalErrorReporter h;
    private int i;
    protected int j;
    private int k;
    private TBImageRetrieveABListener l;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class ImageSizeWarningException extends NetworkResponseException {
        private static int sImageWarningSize;
        private final int exceededTimes;

        public ImageSizeWarningException(int i) {
            super(200, "image size[" + i + "] exceeded " + (i / sImageWarningSize) + " times");
            this.exceededTimes = i / sImageWarningSize;
        }

        /* access modifiers changed from: private */
        public static ImageSizeWarningException newWarningExceptionIfExceeded(int i) {
            int i2 = sImageWarningSize;
            if (i2 <= 0 || i < i2) {
                return null;
            }
            return new ImageSizeWarningException(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[ImageStatistics.FromType.values().length];
            a = iArr;
            iArr[ImageStatistics.FromType.FROM_LOCAL_FILE.ordinal()] = 1;
            a[ImageStatistics.FromType.FROM_DISK_CACHE.ordinal()] = 2;
            a[ImageStatistics.FromType.FROM_LARGE_SCALE.ordinal()] = 3;
            try {
                a[ImageStatistics.FromType.FROM_NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public TBImageFlowMonitor(int i2, int i3, NetworkAnalyzer networkAnalyzer, TBImageRetrieveABListener tBImageRetrieveABListener) {
        this.e = networkAnalyzer;
        this.j = i2;
        this.k = i3;
        this.l = tBImageRetrieveABListener;
    }

    private void D(ImageStatistics imageStatistics) {
        if (imageStatistics != null && imageStatistics.i() != null) {
            try {
                Map<String, Integer> e2 = imageStatistics.e();
                String str = imageStatistics.i().get("DXImageViewOnCreateTimestampKey");
                String str2 = imageStatistics.i().get("DXImageViewOnRenderTimestampKey");
                String str3 = imageStatistics.i().get("DXImageViewIsReuseKey");
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    boolean booleanValue = Boolean.valueOf(str3).booleanValue();
                    long longValue = Long.valueOf(str).longValue();
                    long longValue2 = Long.valueOf(str2).longValue();
                    long n = imageStatistics.n();
                    if (booleanValue) {
                        longValue = longValue2;
                    }
                    int i2 = 0;
                    int i3 = longValue > 0 ? (int) (n - longValue) : 0;
                    int o = o(e2, ImageStatistics.KEY_TOTAL_TIME) + i3;
                    e2.put("processTimeOfContainer", Integer.valueOf(i3));
                    e2.put("totalTimeOfContainer", Integer.valueOf(o));
                    if (booleanValue) {
                        i2 = 1;
                    }
                    e2.put("isReuseOfContainer", Integer.valueOf(i2));
                }
            } catch (Exception unused) {
            }
        }
    }

    private int E(MeasureValueSet measureValueSet, String str, Map<String, Integer> map) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        measureValueSet.setValue(str, (double) num.intValue());
        return num.intValue();
    }

    private String g(Throwable th) {
        if (th instanceof IncompleteResponseException) {
            return "101010";
        }
        if (th instanceof HttpCodeResponseException) {
            int httpCode = ((HttpCodeResponseException) th).getHttpCode();
            if (httpCode == 404) {
                return "102010";
            }
            return httpCode == 503 ? "103010" : "104000";
        }
        if (th instanceof ImageSizeWarningException) {
            int i2 = ((ImageSizeWarningException) th).exceededTimes;
            if (i2 >= 1 && i2 < 2) {
                return "801010";
            }
            if (i2 >= 2 && i2 < 4) {
                return "801020";
            }
            if (i2 >= 4) {
                return "801090";
            }
        }
        NetworkAnalyzer networkAnalyzer = this.e;
        if (networkAnalyzer == null) {
            return null;
        }
        if (networkAnalyzer.isReadTimeoutException(th)) {
            return "101011";
        }
        if (this.e.isCertificateException(th)) {
            return "103011";
        }
        if (this.e.isInvalidHostException(th)) {
            return "201010";
        }
        if (this.e.isConnectTimeoutException(th)) {
            return "201011";
        }
        if (this.e.isInvalidUrlException(th)) {
            return "201012";
        }
        if (this.e.isIndifferentException(th)) {
            return "901000";
        }
        if (!(th instanceof DecodeException)) {
            return null;
        }
        DecodeException decodeException = (DecodeException) th;
        return decodeException.getDecodedError() + "[Local?" + decodeException.isLocalUri() + ", Disk?" + decodeException.isDataFromDisk() + jl1.ARRAY_END_STR;
    }

    private String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.length() > 256 ? str.substring(0, 256) : str;
    }

    private void i(String str, int i2, int i3, String str2) {
        for (int i4 = 0; i4 < i2; i4++) {
            if (str2 == null) {
                AppMonitor.Alarm.commitSuccess("ImageLib_Rx", str);
            } else {
                AppMonitor.Alarm.commitSuccess("ImageLib_Rx", str, str2);
            }
        }
        for (int i5 = 0; i5 < i3; i5++) {
            if (str2 == null) {
                AppMonitor.Alarm.commitFail("ImageLib_Rx", str, null, null);
            } else {
                AppMonitor.Alarm.commitFail("ImageLib_Rx", str, str2, null, null);
            }
        }
    }

    private boolean j(ImageStatistics imageStatistics, int i2, String str) {
        if (!ge2.a || imageStatistics == null || TextUtils.isEmpty(imageStatistics.q)) {
            return false;
        }
        boolean z = imageStatistics.y;
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.ret = i2;
        requestInfo.bizId = imageStatistics.r;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        requestInfo.bizErrorCode = str;
        if (imageStatistics.i() != null) {
            String str3 = imageStatistics.i().get("eagleid");
            if (str3 != null) {
                str2 = str3;
            }
            requestInfo.serverTraceId = str2;
        }
        if (imageStatistics.k() != ImageStatistics.FromType.FROM_NETWORK) {
            requestInfo.protocolType = "cache";
            if (imageStatistics.k() == ImageStatistics.FromType.FROM_DISK_CACHE || imageStatistics.k() == ImageStatistics.FromType.FROM_LOCAL_FILE) {
                requestInfo.rspDeflateSize = imageStatistics.x;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[traceId:");
            sb.append(imageStatistics.q);
            sb.append(jl1.ARRAY_END_STR);
            sb.append("|end");
            sb.append(",ret=");
            sb.append(i2);
            Map<String, Integer> e2 = imageStatistics.e();
            if (e2 != null) {
                sb.append(",totalTime=");
                sb.append(o(e2, ImageStatistics.KEY_TOTAL_TIME));
                sb.append(",wait2Main=");
                sb.append(o(e2, ImageStatistics.KEY_WAIT_FOR_MAIN));
                int o = o(e2, ImageStatistics.KEY_SCHEDULE_TIME);
                sb.append(",scheduleTime=");
                sb.append(o);
                sb.append(",decodeTime=");
                sb.append(o(e2, ImageStatistics.KEY_BITMAP_DECODE));
                sb.append(",networkConnect=");
                sb.append(o(e2, "connect"));
                sb.append(",networkDownload=");
                sb.append(o(e2, "download"));
                sb.append(",cacheLookup=");
                sb.append(o(e2, ImageStatistics.KEY_READ_DISK_CACHE));
                sb.append(",memoryLookup=");
                sb.append(o(e2, ImageStatistics.KEY_READ_MEMORY_CACHE));
                int o2 = o(e2, "totalTimeOfContainer");
                if (o2 > 0) {
                    sb.append(",processTimeOfContainer=");
                    sb.append(o(e2, "processTimeOfContainer"));
                    sb.append(",totalTimeOfContainer=");
                    sb.append(o2);
                    sb.append(",dxIsReuse=");
                    sb.append(o(e2, "isReuseOfContainer"));
                }
                if (o > 5000 && tp1.o().schedulerBuilder().c()) {
                    sb.append("|");
                    sb.append(tp1.o().schedulerBuilder().build().forDecode().getStatus());
                }
            }
            ln0.d(imageStatistics, sb.toString());
        }
        Map<String, Integer> e3 = imageStatistics.e();
        if (e3 != null && e3.containsKey(ImageStatistics.KEY_BITMAP_DECODE)) {
            requestInfo.deserializeTime = (long) e3.get(ImageStatistics.KEY_BITMAP_DECODE).intValue();
        }
        requestInfo.url = imageStatistics.p().k();
        requestInfo.bizReqStart = imageStatistics.n();
        requestInfo.bizReqProcessStart = imageStatistics.s;
        requestInfo.bizRspProcessStart = imageStatistics.t;
        requestInfo.bizRspCbDispatch = imageStatistics.u;
        requestInfo.bizRspCbStart = imageStatistics.v;
        requestInfo.bizRspCbEnd = imageStatistics.w;
        requestInfo.pTraceId = s(imageStatistics.i());
        FullTraceAnalysis.getInstance().commitRequest(imageStatistics.q, "picture", requestInfo);
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k(ImageStatistics imageStatistics) {
        if (ge2.a) {
            j(imageStatistics, 2, "");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l(ImageStatistics imageStatistics, Throwable th) {
        NetworkAnalyzer networkAnalyzer;
        String str;
        Object obj;
        String str2;
        String str3;
        String str4;
        Object obj2;
        String str5;
        String str6;
        String str7;
        char c2;
        Throwable th2;
        char c3;
        String str8;
        String str9;
        String str10;
        NetworkAnalyzer networkAnalyzer2;
        String str11;
        if (!j(imageStatistics, 0, p(th))) {
            String str12 = "unknown";
            if (imageStatistics == null || imageStatistics.q() || (th instanceof OnlyCacheFailedException) || ((networkAnalyzer = this.e) != null && networkAnalyzer.isNoNetworkException(th))) {
                Object[] objArr = new Object[2];
                objArr[0] = imageStatistics;
                if (imageStatistics != null) {
                    str12 = imageStatistics.p().k();
                }
                objArr[1] = str12;
                vr2.a("FlowMonitor", "skipped commit onFail, statistics=%s, path=%s", objArr);
                return;
            }
            y(imageStatistics);
            String k2 = imageStatistics.p().k();
            boolean z = th instanceof NetworkResponseException;
            boolean z2 = th instanceof DecodeException;
            String q = q(k2);
            String n = n(imageStatistics.i());
            MimeType j2 = imageStatistics.j();
            if (j2 != null) {
                str12 = j2.b();
            }
            String t = t(imageStatistics.i());
            if ((th instanceof ImageSizeWarningException) || a(this.j)) {
                obj = "domain";
                str = q;
            } else {
                DimensionValueSet create = DimensionValueSet.create();
                MeasureValueSet create2 = MeasureValueSet.create();
                create.setValue("domain", q);
                obj = "domain";
                str = q;
                String str13 = "1";
                create.setValue("error", str13);
                create.setValue("bizName", n);
                create.setValue("format", str12);
                create.setValue("dataFrom", "0");
                create.setValue("pageURL", t);
                if (!imageStatistics.C) {
                    str13 = "0";
                }
                create.setValue("hasIcc", str13);
                AppMonitor.Stat.commit("ImageLib_Rx", "ImageFlow", create, create2);
                if (ge2.a && SceneIdentifier.getDeviceLevel() == 3) {
                    AppMonitor.Stat.commit("ImageLib_Rx", "ImageFlowForLowDevice", create, create2);
                }
            }
            NavigationInfoObtainer navigationInfoObtainer = this.g;
            if (navigationInfoObtainer != null) {
                str3 = navigationInfoObtainer.getCurrentWindowName();
                str2 = this.g.getCurrentUrl();
            } else {
                str3 = null;
                str2 = null;
            }
            if (z || z2) {
                String g2 = g(th);
                if (g2 != null) {
                    v();
                    DimensionValueSet create3 = DimensionValueSet.create();
                    MeasureValueSet create4 = MeasureValueSet.create();
                    str6 = k2;
                    create3.setValue("url", str6);
                    create3.setValue("bizName", n);
                    obj2 = "bizName";
                    create3.setValue("analysisErrorCode", g2);
                    str11 = g2;
                    str4 = n;
                    if (z) {
                        create3.setValue("originErrorCode", String.valueOf(((NetworkResponseException) th).getHttpCode()));
                        create3.setValue(SocialConstants.PARAM_APP_DESC, "analysisReason::" + th.getMessage());
                    } else {
                        create3.setValue("originErrorCode", "200");
                        create3.setValue(SocialConstants.PARAM_APP_DESC, "analysisReason::" + th.toString());
                    }
                    create3.setValue("format", str12);
                    create3.setValue("dataFrom", String.valueOf(imageStatistics.k().value));
                    create3.setValue("originUrl", r(imageStatistics.i()));
                    if (!(str3 == null && str2 == null)) {
                        create3.setValue("windowName", str3);
                        create3.setValue("naviUrl", str2);
                    }
                    create3.setValue("pageURL", t);
                    AppMonitor.Stat.commit("ImageLib_Rx", "ImageError", create3, create4);
                } else {
                    str4 = n;
                    str11 = g2;
                    str6 = k2;
                    obj2 = "bizName";
                }
                str5 = str11;
            } else {
                str4 = n;
                str6 = k2;
                str5 = null;
                obj2 = "bizName";
            }
            if (z || a(this.k) || this.h == null) {
                th2 = th;
                str7 = "FlowMonitor";
                c3 = 0;
                c2 = 1;
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("url", str6);
                hashMap.put(obj, str);
                hashMap.put("format", str12);
                hashMap.put(obj2, str4);
                hashMap.put("size", Integer.valueOf(imageStatistics.o()));
                hashMap.put("windowName", str3);
                hashMap.put("naviUrl", str2);
                hashMap.put("isRetrying", Boolean.valueOf(imageStatistics.r()));
                hashMap.put("supportAshmem", Boolean.valueOf(Pexode.j()));
                hashMap.put("supportInBitmap", Boolean.valueOf(Pexode.l()));
                hashMap.put("degradationBits", Integer.valueOf(this.i));
                hashMap.put("statusOfTBReal", tp1.o().schedulerBuilder().build().forCpuBound().getStatus());
                hashMap.put("sdkInt", Integer.valueOf(Build.VERSION.SDK_INT));
                Map<String, String> i2 = imageStatistics.i();
                if (i2 == null || (networkAnalyzer2 = this.e) == null) {
                    str10 = null;
                    str9 = null;
                    str8 = null;
                } else {
                    str8 = i2.get(networkAnalyzer2.keyOfCdnIpPort());
                    str9 = i2.get(this.e.keyOfConnectType());
                    str10 = i2.get(this.e.keyOfHitCdnCache());
                }
                if (str8 == null) {
                    str8 = "";
                }
                hashMap.put("cdnIpPort", str8);
                if (str9 == null) {
                    str9 = "";
                }
                hashMap.put("connectType", str9);
                if (str10 == null) {
                    str10 = "";
                }
                hashMap.put("hitCdnCache", str10);
                String a2 = j22.a(th.getClass());
                th2 = th;
                if (th2 instanceof DecodeException) {
                    DecodeException decodeException = (DecodeException) th2;
                    a2 = a2 + ":" + decodeException.getDecodedError() + "[Local?" + decodeException.isLocalUri() + ", Disk?" + decodeException.isDataFromDisk() + jl1.ARRAY_END_STR;
                    Throwable cause = decodeException.getCause();
                    if (cause != null) {
                        str5 = a2;
                        th2 = cause;
                        this.h.onNonCriticalErrorHappen(str5, th2, hashMap);
                        c3 = 0;
                        c2 = 1;
                        str7 = "FlowMonitor";
                        vr2.i(str7, "report non-critical error, details=%s, path=%s", hashMap, str6);
                    }
                }
                str5 = a2;
                this.h.onNonCriticalErrorHappen(str5, th2, hashMap);
                c3 = 0;
                c2 = 1;
                str7 = "FlowMonitor";
                vr2.i(str7, "report non-critical error, details=%s, path=%s", hashMap, str6);
            }
            Object[] objArr2 = new Object[5];
            objArr2[c3] = str5;
            objArr2[c2] = th2;
            objArr2[2] = str3;
            objArr2[3] = str2;
            objArr2[4] = str6;
            vr2.i(str7, "commit complete onFail, analysisCode=%s, throwable=%s, window=%s, navi=%s, path=%s", objArr2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x03d9  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    private void m(ImageStatistics imageStatistics) {
        String str;
        String str2;
        String str3;
        ImageSizeWarningException imageSizeWarningException;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        NetworkAnalyzer networkAnalyzer;
        String str11;
        String str12;
        int i2;
        D(imageStatistics);
        if (!j(imageStatistics, 1, "")) {
            z(imageStatistics);
            y(imageStatistics);
            if (imageStatistics == null || imageStatistics.q() || imageStatistics.k() == ImageStatistics.FromType.FROM_UNKNOWN || imageStatistics.e() == null) {
                vr2.a("FlowMonitor", "skipped commit onSuccess, statistic=%s", imageStatistics);
            } else if (!a(this.j)) {
                String k2 = imageStatistics.p().k();
                u();
                String h2 = h(k2);
                String h3 = h(r(imageStatistics.i()));
                ImageStatistics.FromType k3 = imageStatistics.k();
                DimensionValueSet create = DimensionValueSet.create();
                MeasureValueSet create2 = MeasureValueSet.create();
                create.setValue("domain", q(k2));
                String str13 = "0";
                create.setValue("error", str13);
                create.setValue("bizName", n(imageStatistics.i()));
                MimeType j2 = imageStatistics.j();
                create.setValue("format", j2 != null ? j2.b() : "unknown");
                create.setValue("dataFrom", String.valueOf(k3.value));
                create.setValue("pageURL", t(imageStatistics.i()));
                create.setValue("newThreadModel", ge2.b ? "1" : str13);
                create.setValue("sdkInitTime", String.valueOf(ge2.c));
                create.setValue("requestStartTime", String.valueOf(imageStatistics.n()));
                create.setValue("RequestUrl", h2);
                create.setValue("originalUrl", h3);
                create.setValue("ttlGetTime", String.valueOf(imageStatistics.z));
                create.setValue("ttlPutTime", String.valueOf(imageStatistics.A));
                if (imageStatistics.C) {
                    str = "1";
                } else {
                    str = str13;
                }
                create.setValue("hasIcc", str);
                NavigationInfoObtainer navigationInfoObtainer = this.g;
                if (navigationInfoObtainer != null) {
                    str2 = navigationInfoObtainer.getCurrentWindowName();
                    create.setValue("windowName", str2);
                    create.setValue("naviUrl", this.g.getCurrentUrl());
                } else {
                    str2 = null;
                }
                TBImageRetrieveABListener tBImageRetrieveABListener = this.l;
                if (tBImageRetrieveABListener != null) {
                    long experimentId = tBImageRetrieveABListener.getExperimentId();
                    if (experimentId > 0) {
                        create.setValue("ttlExperimentId", String.valueOf(experimentId));
                    }
                }
                Map<String, Integer> e2 = imageStatistics.e();
                E(create2, ImageStatistics.KEY_WAIT_FOR_MAIN, e2);
                E(create2, ImageStatistics.KEY_TOTAL_TIME, e2);
                E(create2, ImageStatistics.KEY_READ_MEMORY_CACHE, e2);
                E(create2, "processTimeOfContainer", e2);
                E(create2, "totalTimeOfContainer", e2);
                int E = E(create2, ImageStatistics.KEY_SCHEDULE_TIME, e2) / getMinimumScheduleTime2StatWaitSize();
                create.setValue("scheduleFactor", String.valueOf(E));
                if (E > 0) {
                    E(create2, ImageStatistics.KEY_MASTER_WAIT_SIZE, e2);
                    E(create2, ImageStatistics.KEY_NETWORK_WAIT_SIZE, e2);
                    E(create2, ImageStatistics.KEY_DECODE_WAIT_SIZE, e2);
                }
                if (ge2.a) {
                    create.setValue("launchType", String.valueOf(SceneIdentifier.getStartType()));
                    if (SceneIdentifier.isUrlLaunch()) {
                        str13 = "1";
                    }
                    create.setValue("appLaunchExternal", str13);
                    create.setValue("sinceAppLaunchInterval", String.valueOf(imageStatistics.n() - SceneIdentifier.getAppLaunchTime()));
                    create.setValue("deviceLevel", String.valueOf(SceneIdentifier.getDeviceLevel()));
                    create.setValue("bucketInfo", SceneIdentifier.getBucketInfo());
                    create.setValue("yixiuBucket", ABTestCenter.getUTABTestBucketId("PHENIX"));
                    if (SceneIdentifier.getStartType() != 1) {
                        create.setValue("sinceLastLaunchInternal", String.valueOf((int) (SceneIdentifier.getAppLaunchTime() - SceneIdentifier.getLastLaunchTime())));
                    }
                }
                boolean z = k3 != ImageStatistics.FromType.FROM_MEMORY_CACHE;
                if (z) {
                    int o = imageStatistics.o();
                    E(create2, ImageStatistics.KEY_BITMAP_DECODE, e2);
                    create2.setValue("size", (double) o);
                    if (o <= 20480) {
                        str4 = "0_20K";
                    } else if (o <= 51200) {
                        str4 = "20_50K";
                    } else if (o <= 102400) {
                        str4 = "50_100K";
                    } else if (o <= 204800) {
                        str4 = "100_200K";
                    } else if (o <= 512000) {
                        str4 = "200_500K";
                    } else {
                        if (o % 512000 == 0) {
                            i2 = o;
                        } else {
                            i2 = ((o + 512000) / 512000) * 512000;
                        }
                        str4 = ((i2 - 512000) / 1024) + JSMethod.NOT_SET + (i2 / 1024) + "K";
                    }
                    create.setValue("sizeRange", str4);
                    int i3 = a.a[imageStatistics.k().ordinal()];
                    if (i3 == 1) {
                        str3 = str2;
                        E(create2, ImageStatistics.KEY_READ_LOCAL_FILE, e2);
                    } else if (i3 == 2) {
                        str3 = str2;
                        E(create2, ImageStatistics.KEY_READ_DISK_CACHE, e2);
                    } else if (i3 == 3) {
                        str3 = str2;
                        E(create2, ImageStatistics.KEY_READ_DISK_CACHE, e2);
                        E(create2, ImageStatistics.KEY_BITMAP_SCALE, e2);
                    } else if (i3 == 4) {
                        E(create2, ImageStatistics.KEY_READ_DISK_CACHE, e2);
                        int E2 = E(create2, "connect", e2);
                        int E3 = E(create2, "download", e2);
                        Map<String, String> i4 = imageStatistics.i();
                        if (i4 == null || (networkAnalyzer = this.e) == null) {
                            str3 = str2;
                            str10 = null;
                            str9 = null;
                            str8 = null;
                            str7 = null;
                            str6 = null;
                            str5 = null;
                        } else {
                            str7 = i4.get(networkAnalyzer.keyOfHitCdnCache());
                            if (str7 != null) {
                                create.setValue("hitCdnCache", str7);
                            }
                            String str14 = i4.get(this.e.keyOfConnectType());
                            if (str14 != null) {
                                create.setValue("connectType", str14);
                            }
                            str8 = i4.get(this.e.keyOfCdnIpPort());
                            if (str8 != null) {
                                create.setValue("cdnIpPort", str8);
                            }
                            String str15 = i4.get(this.e.keyOfFirstData());
                            if (str15 != null) {
                                str12 = str14;
                                str3 = str2;
                                str11 = str15;
                                create2.setValue("firstData", (double) Long.parseLong(str15));
                            } else {
                                str11 = str15;
                                str12 = str14;
                                str3 = str2;
                            }
                            String str16 = i4.get(this.e.keyOfSendBefore());
                            if (str16 != null) {
                                str6 = str16;
                                create2.setValue("sendBefore", (double) Long.parseLong(str16));
                            } else {
                                str6 = str16;
                            }
                            String str17 = i4.get(this.e.keyOfResponseCode());
                            if (str17 != null) {
                                str5 = str17;
                                create2.setValue("responseCode", (double) Long.parseLong(str17));
                            } else {
                                str5 = str17;
                            }
                            String str18 = i4.get(this.e.keyOfServerRt());
                            if (str18 != null) {
                                create2.setValue(IFullTraceAnalysisV3.Stage.SERVE_RT, (double) Long.parseLong(str18));
                            }
                            str9 = str12;
                            str10 = str11;
                        }
                        vr2.a("FlowMonitor", "network sub-stats: node=%s hit=%s type=%s connect=%d download=%d firstData=%s sendBefore=%s responseCode=%s size=%d, PATH=%s", str8, str7, str9, Integer.valueOf(E2), Integer.valueOf(E3), str10, str6, str5, Integer.valueOf(o), k2);
                        int i5 = E3 + E2;
                        if (i5 > 0) {
                            create2.setValue("speed", (double) (o / i5));
                        }
                        imageSizeWarningException = ImageSizeWarningException.newWarningExceptionIfExceeded(o);
                        AppMonitor.Stat.commit("ImageLib_Rx", "ImageFlow", create, create2);
                        if (ge2.a && SceneIdentifier.getDeviceLevel() == 3) {
                            AppMonitor.Stat.commit("ImageLib_Rx", "ImageFlowForLowDevice", create, create2);
                        }
                        vr2.a("FlowMonitor", "commit complete onSuccess, statistics=%s, path=%s", imageStatistics, k2);
                        if (z) {
                            i("DiskCacheHit", imageStatistics.f(), imageStatistics.g(), String.valueOf(imageStatistics.h()));
                            i("BitmapPoolHit", imageStatistics.c(), imageStatistics.d(), str3);
                        }
                        i("MemCacheHit", imageStatistics.l(), imageStatistics.m(), null);
                        if (imageSizeWarningException != null) {
                            onFail(imageStatistics, imageSizeWarningException);
                            return;
                        }
                        return;
                    }
                    imageSizeWarningException = null;
                    AppMonitor.Stat.commit("ImageLib_Rx", "ImageFlow", create, create2);
                    AppMonitor.Stat.commit("ImageLib_Rx", "ImageFlowForLowDevice", create, create2);
                    vr2.a("FlowMonitor", "commit complete onSuccess, statistics=%s, path=%s", imageStatistics, k2);
                    if (z) {
                    }
                    i("MemCacheHit", imageStatistics.l(), imageStatistics.m(), null);
                    if (imageSizeWarningException != null) {
                    }
                }
                str3 = str2;
                imageSizeWarningException = null;
                AppMonitor.Stat.commit("ImageLib_Rx", "ImageFlow", create, create2);
                AppMonitor.Stat.commit("ImageLib_Rx", "ImageFlowForLowDevice", create, create2);
                vr2.a("FlowMonitor", "commit complete onSuccess, statistics=%s, path=%s", imageStatistics, k2);
                if (z) {
                }
                i("MemCacheHit", imageStatistics.l(), imageStatistics.m(), null);
                if (imageSizeWarningException != null) {
                }
            } else if (kg0.g(3)) {
                vr2.a("FlowMonitor", "filter this stat cause of sampling, statistic=%s ", imageStatistics);
            }
        }
    }

    private String n(Map<String, String> map) {
        String str;
        return (map == null || (str = map.get("bundle_biz_code")) == null) ? "" : str;
    }

    private int o(Map<String, Integer> map, String str) {
        if (map == null || !map.containsKey(str)) {
            return 0;
        }
        return map.get(str).intValue();
    }

    private static String q(String str) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(WVUtils.URL_SEPARATOR)) {
            i2 = 2;
        } else {
            int indexOf = str.indexOf(ke1.SCHEME_SLASH);
            i2 = indexOf < 0 ? 0 : indexOf + 3;
        }
        if (i2 >= str.length()) {
            return "";
        }
        int indexOf2 = str.indexOf(47, i2);
        if (indexOf2 < 0) {
            indexOf2 = str.length();
        }
        String substring = str.substring(i2, indexOf2);
        if (substring.contains(jl1.BLOCK_START_STR) || substring.contains(",") || !substring.contains(".")) {
            return "";
        }
        return substring;
    }

    private String r(Map<String, String> map) {
        String str;
        return (map == null || (str = map.get("origin_url")) == null) ? "" : str;
    }

    private String s(Map<String, String> map) {
        String str;
        return (map == null || (str = map.get("p_trace_id")) == null) ? "" : str;
    }

    private String t(Map<String, String> map) {
        String str;
        if (map == null || (str = map.get("pageURL")) == null || TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(63, 0);
        if (indexOf < 0) {
            indexOf = str.length();
        }
        return str.substring(0, indexOf);
    }

    private synchronized void w() {
        if (!this.d) {
            DimensionSet create = DimensionSet.create();
            create.addDimension("bizName");
            create.addDimension("pageName");
            create.addDimension("pageURL");
            create.addDimension("originalURL");
            create.addDimension("errorCode");
            AppMonitor.register("ImageLib_Rx", "InvalidParam", (MeasureSet) null, create);
            this.d = true;
        }
    }

    private synchronized void x() {
        if (!this.c) {
            vr2.a("FlowMonitor", "TTL exception register start", new Object[0]);
            DimensionSet create = DimensionSet.create();
            create.addDimension("url");
            create.addDimension("eagleId");
            create.addDimension("maxAge");
            AppMonitor.register("ImageLib_Rx", "ImageTTLException", (MeasureSet) null, create);
            this.c = true;
            vr2.a("FlowMonitor", "TTL exception register end", new Object[0]);
        }
    }

    private void y(ImageStatistics imageStatistics) {
        int i2;
        if (!this.d) {
            w();
        }
        if (imageStatistics != null) {
            String h2 = h(r(imageStatistics.i()));
            String h3 = h(imageStatistics.p().k());
            if (!TextUtils.isEmpty(h2) || !TextUtils.isEmpty(h3)) {
                i2 = (TextUtils.isEmpty(h2) || !h2.equals(h3)) ? -1 : 1;
            } else {
                i2 = 0;
            }
            if (i2 != -1) {
                DimensionValueSet create = DimensionValueSet.create();
                MeasureValueSet create2 = MeasureValueSet.create();
                create.setValue("bizName", imageStatistics.r);
                NavigationInfoObtainer navigationInfoObtainer = this.g;
                if (navigationInfoObtainer != null) {
                    create.setValue("pageName", navigationInfoObtainer.getCurrentWindowName());
                    create.setValue("pageURL", this.g.getCurrentUrl());
                }
                create.setValue("originalURL", h2);
                create.setValue("errorCode", String.valueOf(i2));
                AppMonitor.Stat.commit("ImageLib_Rx", "InvalidParam", create, create2);
            }
        }
    }

    private void z(ImageStatistics imageStatistics) {
        if (imageStatistics.B) {
            if (!this.c) {
                x();
            }
            if (imageStatistics.i() != null && !TextUtils.isEmpty(imageStatistics.i().get("max-age"))) {
                String h2 = h(imageStatistics.p().k());
                DimensionValueSet create = DimensionValueSet.create();
                MeasureValueSet create2 = MeasureValueSet.create();
                create.setValue("maxAge", imageStatistics.i().get("max-age"));
                create.setValue("eagleId", imageStatistics.i().get("eagleid"));
                create.setValue("url", h2);
                AppMonitor.Stat.commit("ImageLib_Rx", "ImageTTLException", create, create2);
            }
        }
    }

    public void A(int i2) {
        int unused = ImageSizeWarningException.sImageWarningSize = i2;
        vr2.f("FlowMonitor", "set image warning size=%d", Integer.valueOf(i2));
    }

    public void B(NavigationInfoObtainer navigationInfoObtainer) {
        this.g = navigationInfoObtainer;
        vr2.f("FlowMonitor", "set navigation info obtainer=%s", navigationInfoObtainer);
    }

    public void C(NonCriticalErrorReporter nonCriticalErrorReporter) {
        this.h = nonCriticalErrorReporter;
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public int getMinimumScheduleTime2StatWaitSize() {
        return 150;
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public void onCancel(final ImageStatistics imageStatistics) {
        qk2.a(new Runnable() {
            /* class com.taobao.phenix.compat.stat.TBImageFlowMonitor.AnonymousClass3 */

            public void run() {
                TBImageFlowMonitor.this.k(imageStatistics);
            }
        });
    }

    @Override // com.taobao.rxm.schedule.PairingThrottlingScheduler.DegradationListener
    public void onDegrade2Unlimited() {
        this.i = (this.i & -9) + 8;
        AppMonitor.Counter.commit("ImageLib_Rx", "Forced2UnlimitedNetwork", 1.0d);
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public void onFail(final ImageStatistics imageStatistics, final Throwable th) {
        qk2.a(new Runnable() {
            /* class com.taobao.phenix.compat.stat.TBImageFlowMonitor.AnonymousClass2 */

            public void run() {
                TBImageFlowMonitor.this.l(imageStatistics, th);
            }
        });
    }

    @Override // com.taobao.pexode.Pexode.ForcedDegradationListener
    public void onForcedDegrade2NoAshmem() {
        this.i = (this.i & -3) + 2;
        AppMonitor.Counter.commit("ImageLib_Rx", "Forced2NoAshmem", 1.0d);
    }

    @Override // com.taobao.pexode.Pexode.ForcedDegradationListener
    public void onForcedDegrade2NoInBitmap() {
        this.i = (this.i & -5) + 4;
        AppMonitor.Counter.commit("ImageLib_Rx", "Forced2NoInBitmap", 1.0d);
    }

    @Override // com.taobao.pexode.Pexode.ForcedDegradationListener
    public void onForcedDegrade2System() {
        this.i = (this.i & -2) + 1;
        AppMonitor.Counter.commit("ImageLib_Rx", "Forced2System", 1.0d);
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public void onProcess(ImageStatistics imageStatistics, String str, String str2) {
        if (ge2.a) {
            try {
                String str3 = imageStatistics.q;
                if (TextUtils.isEmpty(str3)) {
                    str3 = FullTraceAnalysis.getInstance().createRequest("picture");
                    imageStatistics.q = str3;
                }
                FullTraceAnalysis.getInstance().log(str3, "picture", str, str2);
            } catch (Throwable th) {
                vr2.c("analysis.FullTraceAnalysis", "log " + imageStatistics.q + AVFSCacheConstants.COMMA_SEP + "picture" + AVFSCacheConstants.COMMA_SEP + str + AVFSCacheConstants.COMMA_SEP + str2 + AVFSCacheConstants.COMMA_SEP, th);
            }
        }
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public void onStart(ImageStatistics imageStatistics) {
        if (ge2.a && TextUtils.isEmpty(imageStatistics.q)) {
            imageStatistics.q = FullTraceAnalysis.getInstance().createRequest("picture");
        }
    }

    @Override // com.taobao.phenix.request.ImageFlowMonitor
    public void onSuccess(final ImageStatistics imageStatistics) {
        qk2.a(new Runnable() {
            /* class com.taobao.phenix.compat.stat.TBImageFlowMonitor.AnonymousClass1 */

            public void run() {
                TBImageFlowMonitor.this.m(imageStatistics);
            }
        });
    }

    public String p(Throwable th) {
        boolean z = th instanceof NetworkResponseException;
        if ((th instanceof DecodeException) || z) {
            return g(th);
        }
        return "";
    }

    /* access modifiers changed from: protected */
    public synchronized void u() {
        if (!this.a) {
            vr2.a("FlowMonitor", "image flow register start", new Object[0]);
            DimensionSet create = DimensionSet.create();
            create.addDimension("domain");
            create.addDimension("error");
            create.addDimension("bizName");
            create.addDimension("format");
            create.addDimension("dataFrom");
            create.addDimension("scheduleFactor");
            create.addDimension("hitCdnCache");
            create.addDimension("connectType");
            create.addDimension("cdnIpPort");
            create.addDimension("windowName");
            create.addDimension("naviUrl");
            create.addDimension("pageURL");
            create.addDimension("launchType");
            create.addDimension("appLaunchExternal");
            create.addDimension("sinceLastLaunchInternal");
            create.addDimension("sinceAppLaunchInterval");
            create.addDimension("deviceLevel");
            create.addDimension("bucketInfo");
            create.addDimension("yixiuBucket");
            create.addDimension("newThreadModel");
            create.addDimension("sdkInitTime");
            create.addDimension("requestStartTime");
            create.addDimension("RequestUrl");
            create.addDimension("originalUrl");
            create.addDimension("ttlExperimentId");
            create.addDimension("ttlGetTime");
            create.addDimension("ttlPutTime");
            create.addDimension("hasIcc");
            MeasureSet create2 = MeasureSet.create();
            b(create2, ImageStatistics.KEY_READ_MEMORY_CACHE, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, ImageStatistics.KEY_READ_DISK_CACHE, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, ImageStatistics.KEY_READ_LOCAL_FILE, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, "connect", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, "download", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, ImageStatistics.KEY_BITMAP_DECODE, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, ImageStatistics.KEY_BITMAP_SCALE, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, ImageStatistics.KEY_SCHEDULE_TIME, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, ImageStatistics.KEY_WAIT_FOR_MAIN, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, ImageStatistics.KEY_TOTAL_TIME, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(60000.0d));
            b(create2, "size", Double.valueOf(0.0d), null, null);
            b(create2, "speed", Double.valueOf(0.0d), null, null);
            b(create2, ImageStatistics.KEY_MASTER_WAIT_SIZE, Double.valueOf(0.0d), null, null);
            b(create2, ImageStatistics.KEY_NETWORK_WAIT_SIZE, Double.valueOf(0.0d), null, null);
            b(create2, ImageStatistics.KEY_DECODE_WAIT_SIZE, Double.valueOf(0.0d), null, null);
            b(create2, "firstData", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, "sendBefore", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, "responseCode", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, IFullTraceAnalysisV3.Stage.SERVE_RT, Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, "processTimeOfContainer", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(30000.0d));
            b(create2, "totalTimeOfContainer", Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(60000.0d));
            AppMonitor.register("ImageLib_Rx", "ImageFlow", create2, create);
            AppMonitor.register("ImageLib_Rx", "ImageFlowForLowDevice", create2, create);
            this.a = true;
            vr2.a("FlowMonitor", "image flow register end", new Object[0]);
        }
    }

    public synchronized void v() {
        if (!this.f) {
            vr2.a("FlowMonitor", "image error register start", new Object[0]);
            DimensionSet create = DimensionSet.create();
            create.addDimension("url");
            create.addDimension("windowName");
            create.addDimension("naviUrl");
            create.addDimension("bizName");
            create.addDimension("analysisErrorCode");
            create.addDimension("originErrorCode");
            create.addDimension(SocialConstants.PARAM_APP_DESC);
            create.addDimension("format");
            create.addDimension("dataFrom");
            create.addDimension("originUrl");
            create.addDimension("pageURL");
            AppMonitor.register("ImageLib_Rx", "ImageError", (MeasureSet) null, create);
            this.f = true;
            vr2.a("FlowMonitor", "image error register end", new Object[0]);
        }
    }
}
