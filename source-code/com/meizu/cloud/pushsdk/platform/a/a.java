package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.b;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.io.File;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
public class a {
    private String a = "https://api-push.meizu.com/garcia/api/client/";
    private String b = (this.a + "message/registerPush");
    private String c = (this.a + "message/unRegisterPush");
    private String d = (this.a + "advance/unRegisterPush");
    private String e = (this.a + "message/getRegisterSwitch");
    private String f = (this.a + "message/changeRegisterSwitch");
    private String g = (this.a + "message/changeAllSwitch");
    private String h = (this.a + "message/subscribeTags");
    private String i = (this.a + "message/unSubscribeTags");
    private String j = (this.a + "message/unSubAllTags");
    private String k = (this.a + "message/getSubTags");
    private String l = (this.a + "message/subscribeAlias");
    private String m = (this.a + "message/unSubscribeAlias");
    private String n = (this.a + "message/getSubAlias");
    private String o = (this.a + "advance/changeRegisterSwitch");

    public a(Context context) {
        com.meizu.cloud.pushsdk.c.a.a();
        if (MzSystemUtils.isOverseas()) {
            this.a = "https://api-push.in.meizu.com/garcia/api/client/";
            this.b = this.a + "message/registerPush";
            this.c = this.a + "message/unRegisterPush";
            this.d = this.a + "advance/unRegisterPush";
            this.e = this.a + "message/getRegisterSwitch";
            this.f = this.a + "message/changeRegisterSwitch";
            this.g = this.a + "message/changeAllSwitch";
            this.h = this.a + "message/subscribeTags";
            this.i = this.a + "message/unSubscribeTags";
            this.j = this.a + "message/unSubAllTags";
            this.k = this.a + "message/getSubTags";
            this.l = this.a + "message/subscribeAlias";
            this.m = this.a + "message/unSubscribeAlias";
            this.n = this.a + "message/getSubAlias";
            this.o = this.a + "advance/changeRegisterSwitch";
        }
    }

    public c a(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "register post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.b).a(linkedHashMap2).a().a();
    }

    public c a(String str, String str2, String str3, int i2, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("msgType", String.valueOf(i2));
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", this.f + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.f).a(linkedHashMap2).a().a();
    }

    public c<String> a(String str, String str2, String str3, File file) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RemoteMessageConst.MSGID, str);
        linkedHashMap.put("deviceId", str2);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, "4a2ca769d79f4856bb3bd982d30de790"));
        if (!TextUtils.isEmpty(str3)) {
            linkedHashMap2.put("errorMsg", str3);
        }
        DebugLogger.i("PushAPI", "uploadLogFile post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.c("https://api-push.meizu.com/garcia/api/client/log/upload").a(linkedHashMap2).a("logFile", file).a().a();
    }

    public c a(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(IRequestConst.TAGS, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.h).a(linkedHashMap2).a().a();
    }

    public c a(String str, String str2, String str3, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", this.g + " switchPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.g).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "unregister post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.a(this.c).a(linkedHashMap2).a().a();
    }

    public c b(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(IRequestConst.TAGS, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.i).a(linkedHashMap2).a().a();
    }

    public c c(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.a(this.e).a(linkedHashMap2).a().a();
    }

    public c c(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put("appKey", str2);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.l).a(linkedHashMap2).a().a();
    }

    public c d(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeAllTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.j).a(linkedHashMap2).a().a();
    }

    public c d(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.b(this.m).a(linkedHashMap2).a().a();
    }

    public c e(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "checkPush post map " + linkedHashMap2);
        return com.meizu.cloud.pushsdk.c.a.a(this.k).a(linkedHashMap2).a().a();
    }
}
