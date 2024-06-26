package com.alibaba.security.common.track.model;

import com.ali.ha.fulltrace.dump.DumpManager;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.a;
import com.vivo.push.PushClientConstants;
import com.youku.vpm.data.ExtrasInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class TrackLog implements Serializable {
    private int code = 0;
    private String layer;
    private String method;
    private String msg;
    private String params;
    private String result;
    private long rt = 0;
    private String service;
    private List<String> tags;
    private long ts = System.currentTimeMillis();
    private String verifyToken;

    /* compiled from: Taobao */
    public static final class a {
        public static final int a = 0;
        public static final int b = -1;
        public static final int c = -2;
    }

    public static TrackLog create(String str, String str2, String str3, String str4, String str5, String str6) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = str;
        trackLog.service = str2;
        trackLog.method = str3;
        trackLog.msg = str4;
        trackLog.params = str5;
        trackLog.result = str6;
        return trackLog;
    }

    public static TrackLog createBioActivityEnterLog(String str, String str2) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod("enter");
        trackLog.setParams(str);
        trackLog.setMsg(str2);
        return trackLog;
    }

    public static TrackLog createBioActivityExitLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod("exit");
        trackLog.setMsg(str);
        return trackLog;
    }

    public static TrackLog createBioGuidePageLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.m);
        trackLog.setParams(str);
        return trackLog;
    }

    public static TrackLog createBioMonitorAlgoStartLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.b);
        trackLog.setParams(str);
        return trackLog;
    }

    public static TrackLog createBioMonitorExpLog(int i, String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod("exception");
        trackLog.addTag1(String.valueOf(i));
        trackLog.setMsg(str);
        return trackLog;
    }

    public static TrackLog createBioMonitorStartLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod("start");
        return trackLog;
    }

    public static TrackLog createBioMonitorUploadFinishLog(CommonTrackResult commonTrackResult, boolean z, long j) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.d);
        trackLog.setResult(h.a(commonTrackResult));
        trackLog.setCode(z ? 0 : -1);
        trackLog.setRt(j);
        return trackLog;
    }

    public static TrackLog createBioMonitorUploadStartLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.c);
        return trackLog;
    }

    public static TrackLog createBioPrivacyPageLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.n);
        trackLog.setParams(str);
        return trackLog;
    }

    public static TrackLog createClassInvokedMonitor(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(PushClientConstants.TAG_CLASS_NAME, str);
        hashMap.put("methodName", str2);
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.V);
        trackLog.setParams(h.a((Object) hashMap));
        return trackLog;
    }

    public static TrackLog createCollectSensorEndLog(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("activityName", str);
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.a);
        trackLog.setMethod(a.b.Z);
        trackLog.setResult(h.a((Map) hashMap));
        return trackLog;
    }

    public static TrackLog createCollectSensorStartLog(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("activityName", str);
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.a);
        trackLog.setMethod(a.b.Y);
        trackLog.setCode(0);
        trackLog.setParams(h.a((Map) hashMap));
        return trackLog;
    }

    public static TrackLog createCtidAppEndLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.a;
        trackLog.method = a.b.R;
        trackLog.result = str;
        return trackLog;
    }

    public static TrackLog createCtidAppStartLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.a;
        trackLog.method = a.b.Q;
        trackLog.params = str;
        return trackLog;
    }

    public static TrackLog createDataCollectionExceptionLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService("exception");
        trackLog.setMethod(a.b.F);
        trackLog.setMsg(str);
        return trackLog;
    }

    public static TrackLog createDynamicBegin(String str, String str2, String str3) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.a;
        trackLog.method = a.b.u;
        trackLog.msg = str;
        trackLog.params = str2;
        trackLog.result = str3;
        return trackLog;
    }

    public static TrackLog createDynamicEnd(String str, String str2, String str3) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.a;
        trackLog.method = a.b.v;
        trackLog.msg = str;
        trackLog.params = str2;
        trackLog.result = str3;
        return trackLog;
    }

    public static TrackLog createFinishCameraParametersLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.r);
        trackLog.setParams(str);
        return trackLog;
    }

    public static TrackLog createNetWorkCostMonitor(String str, long j, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("api", str);
        hashMap.put("costTime", Long.valueOf(j));
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.h);
        trackLog.setMethod("costTime");
        trackLog.setRt(j);
        trackLog.setMsg(str2);
        trackLog.setParams(h.a((Object) hashMap));
        return trackLog;
    }

    public static TrackLog createOssUploadFileBeginLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.a;
        trackLog.method = a.b.M;
        trackLog.msg = "";
        trackLog.params = str;
        trackLog.result = "";
        return trackLog;
    }

    public static TrackLog createOssUploadFileEndLog(String str, String str2, long j) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.a;
        trackLog.method = a.b.N;
        trackLog.msg = "";
        trackLog.params = str;
        trackLog.result = str2;
        trackLog.setRt(j);
        return trackLog;
    }

    public static TrackLog createRiskEndLog(int i, boolean z, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("isNetworkError", Boolean.valueOf(z));
        hashMap.put("errorCode", str);
        hashMap.put("errorMsg", str2);
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.a);
        trackLog.setMethod(a.b.X);
        trackLog.setCode(i);
        trackLog.setResult(h.a((Map) hashMap));
        return trackLog;
    }

    public static TrackLog createRiskStartLog(boolean z, List<String> list, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("isSessionless", Boolean.valueOf(z));
        hashMap.put("actionLogKeys", h.a(list));
        hashMap.put("eventCode", str);
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.a);
        trackLog.setMethod(a.b.W);
        trackLog.setCode(0);
        trackLog.setParams(h.a((Map) hashMap));
        return trackLog;
    }

    public static TrackLog createSdkExceptionLog(String str, String str2, String str3) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = "exception";
        trackLog.method = "exception";
        trackLog.msg = str;
        trackLog.params = str2;
        trackLog.result = str3;
        return trackLog;
    }

    public static TrackLog createSdkWebViewEnterLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.d;
        trackLog.method = "enter";
        trackLog.params = str;
        return trackLog;
    }

    public static TrackLog createSdkWebViewErrorLog(String str, String str2, String str3) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.d;
        trackLog.method = "error";
        trackLog.msg = str;
        trackLog.params = str2;
        trackLog.result = str3;
        return trackLog;
    }

    public static TrackLog createSdkWebViewExitLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.d;
        trackLog.method = "exit";
        return trackLog;
    }

    public static TrackLog createSdkWebViewLoadLog(String str, String str2, String str3) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.d;
        trackLog.method = "load";
        trackLog.msg = str;
        trackLog.params = str2;
        trackLog.result = str3;
        return trackLog;
    }

    public static TrackLog createSimpleSdk(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("class", str);
        hashMap.put("method", str2);
        hashMap.put(ExtrasInfo.EXTRAS, str3);
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.g;
        trackLog.method = "";
        trackLog.msg = "";
        trackLog.params = h.a((Object) hashMap);
        trackLog.result = "";
        return trackLog;
    }

    public static TrackLog createSoundClickLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.e;
        trackLog.method = a.b.f;
        trackLog.msg = "";
        trackLog.params = str;
        trackLog.result = "";
        return trackLog;
    }

    public static TrackLog createStartBeginLog(String str, String str2, boolean z) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.a);
        trackLog.setMethod(a.b.s);
        HashMap hashMap = new HashMap();
        hashMap.put("startType", str);
        hashMap.put("fromSouce", str2);
        hashMap.put("isCustomUi", Integer.valueOf(z ? 1 : 0));
        trackLog.setParams(h.a((Map) hashMap));
        trackLog.setMsg("call start");
        trackLog.setResult("");
        trackLog.addTag1(str);
        return trackLog;
    }

    public static TrackLog createStartCameraParametersLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.q);
        trackLog.setParams(str);
        return trackLog;
    }

    public static TrackLog createStartEndLog(String str, String str2, long j, String str3, String str4, String str5) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.a);
        trackLog.setMethod(a.b.t);
        trackLog.setParams("{\"startType\":" + str + "}");
        trackLog.setMsg(str2);
        HashMap hashMap = new HashMap();
        hashMap.put(com.alibaba.security.realidentity.jsbridge.a.af, a.C0102a.a.a);
        hashMap.put("state", str3);
        hashMap.put("errorCode", str4);
        hashMap.put("subCode", str5);
        hashMap.put("message", str2);
        trackLog.setResult(h.a((Object) hashMap));
        trackLog.setRt(System.currentTimeMillis() - j);
        trackLog.addTag1(str);
        trackLog.addTag2(str3);
        trackLog.addTag3(str4);
        return trackLog;
    }

    public static TrackLog createTakePhotoFinishLog(CommonTrackResult commonTrackResult, boolean z) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService("takePhoto");
        trackLog.setMethod("finish");
        trackLog.setResult(h.a(commonTrackResult));
        trackLog.setCode(z ? 0 : -1);
        return trackLog;
    }

    public static TrackLog createTakePhotoStartLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService("takePhoto");
        trackLog.setMethod("start");
        return trackLog;
    }

    public static TrackLog createTakePhotoUploadLog(CommonTrackResult commonTrackResult) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService("takePhoto");
        trackLog.setMethod(a.b.d);
        return trackLog;
    }

    public static TrackLog createVmEncryptLog(int i, String str, String str2) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = a.c.a;
        trackLog.method = a.b.P;
        trackLog.code = i;
        trackLog.msg = str;
        trackLog.result = str2;
        return trackLog;
    }

    public static TrackLog dazzleFailedTrack(String str, String str2, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put(DumpManager.LOG_PATH, str2);
        hashMap.put("timestamp", String.valueOf(j));
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.aa);
        trackLog.setMsg(str);
        trackLog.setParams(h.a((Map) hashMap));
        return trackLog;
    }

    private void initTags() {
        if (this.tags == null) {
            ArrayList arrayList = new ArrayList(10);
            this.tags = arrayList;
            arrayList.addAll(Arrays.asList("", "", "", "", "", "", "", "", "", ""));
        }
    }

    public static TrackLog recordException(boolean z, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("isEmpty", Boolean.toString(z));
        hashMap.put("size", Integer.toString(i));
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod("exception");
        trackLog.setMsg("record exception");
        trackLog.setParams(h.a((Map) hashMap));
        return trackLog;
    }

    public static TrackLog startRecordVideo(String str, String str2, String str3, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("stackTrace", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("isRecording", str3);
        hashMap2.put("costTime", String.valueOf(j));
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.T);
        trackLog.setMsg(str);
        trackLog.setParams(h.a((Map) hashMap));
        trackLog.setResult(h.a((Map) hashMap2));
        trackLog.setRt(j);
        return trackLog;
    }

    public static TrackLog startShowDazzleView(String str, String str2, String str3) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.o);
        trackLog.setMsg(str3);
        trackLog.setParams(str);
        trackLog.setResult(str2);
        return trackLog;
    }

    public static TrackLog stopRecordVideo(String str, String str2, String str3, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("stackTrace", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("isRecording", str3);
        hashMap2.put("costTime", String.valueOf(j));
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.U);
        trackLog.setMsg(str);
        trackLog.setParams(h.a((Map) hashMap));
        trackLog.setResult(h.a((Map) hashMap2));
        trackLog.setRt(j);
        return trackLog;
    }

    public static TrackLog stopShowDazzleView(String str, String str2) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer(a.C0103a.a);
        trackLog.setService(a.c.e);
        trackLog.setMethod(a.b.p);
        trackLog.setParams(str2);
        trackLog.setMsg(str);
        return trackLog;
    }

    public void addTag1(String str) {
        initTags();
        this.tags.add(0, str);
    }

    public void addTag10(String str) {
        initTags();
        this.tags.add(9, str);
    }

    public void addTag2(String str) {
        initTags();
        this.tags.add(1, str);
    }

    public void addTag3(String str) {
        initTags();
        this.tags.add(2, str);
    }

    public void addTag4(String str) {
        initTags();
        this.tags.add(3, str);
    }

    public void addTag5(String str) {
        initTags();
        this.tags.add(4, str);
    }

    public void addTag6(String str) {
        initTags();
        this.tags.add(5, str);
    }

    public void addTag7(String str) {
        initTags();
        this.tags.add(6, str);
    }

    public void addTag8(String str) {
        initTags();
        this.tags.add(7, str);
    }

    public void addTag9(String str) {
        initTags();
        this.tags.add(8, str);
    }

    public int getCode() {
        return this.code;
    }

    public String getLayer() {
        return this.layer;
    }

    public String getMethod() {
        return this.method;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getParams() {
        return this.params;
    }

    public String getResult() {
        return this.result;
    }

    public long getRt() {
        return this.rt;
    }

    public String getService() {
        return this.service;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public long getTs() {
        return this.ts;
    }

    public String getVerifyToken() {
        return this.verifyToken;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setLayer(String str) {
        this.layer = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setRt(long j) {
        this.rt = j;
    }

    public void setService(String str) {
        this.service = str;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public void setTs(long j) {
        this.ts = j;
    }

    public void setVerifyToken(String str) {
        this.verifyToken = str;
    }

    public static TrackLog createSdkExceptionLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = a.C0103a.a;
        trackLog.service = "exception";
        trackLog.method = "exception";
        trackLog.msg = "";
        trackLog.params = str;
        trackLog.result = "";
        return trackLog;
    }
}
