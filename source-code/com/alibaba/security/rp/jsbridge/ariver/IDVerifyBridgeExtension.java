package com.alibaba.security.rp.jsbridge.ariver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.commonability.file.proxy.LocalIdTool;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.NativePermissionRequire;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.d.i;
import com.alibaba.security.common.d.j;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.track.model.a;
import com.alibaba.security.realidentity.RPConfig;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.activity.RPTakePhotoActivity;
import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.business.RPBusinessHeadParams;
import com.alibaba.security.realidentity.utils.ImageData;
import com.uploader.export.UploaderGlobal;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tb.at2;
import tb.bt2;
import tb.ws2;
import tb.ys2;

/* compiled from: Taobao */
public class IDVerifyBridgeExtension implements BridgeExtension {
    private static final String LOW_MEMORY = "LOW_MEMORY";
    private static final String NO_PHOTO_ID = "0";
    private static final String TAG = IDVerifyBridgeExtension.class.getSimpleName();
    private static final String TAG_TAKE_PHOTO = "rpTakePhoto";

    private static void collectUsingLog(String str, String str2) {
        TrackLog createClassInvokedMonitor = TrackLog.createClassInvokedMonitor(str, str2);
        createClassInvokedMonitor.setVerifyToken(g.a.a.d);
        createClassInvokedMonitor.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        createClassInvokedMonitor.addTag10("Android");
        a.C0102a.a.a(createClassInvokedMonitor);
        a.C0102a.a.a(false);
    }

    private String filePathToApUrl(String str, String str2) {
        return filePathToApUrl(str, str2, "image");
    }

    private String getFileLocalId(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return LocalIdTool.get().encodeToLocalId(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private String getFileMd5(String str) {
        return str != null ? j.a(new File(str)) : "";
    }

    private static String getUserName(String str) {
        JSONObject parseObject;
        if (str == null || str.isEmpty() || (parseObject = JSON.parseObject(str)) == null) {
            return null;
        }
        return parseObject.getString("name");
    }

    private void handleTakePhotoResult(Intent intent, BridgeCallback bridgeCallback) {
        String stringExtra = intent.getStringExtra("errorMsg");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.alibaba.security.realidentity.jsbridge.a.K);
        int[] intArrayExtra = intent.getIntArrayExtra(com.alibaba.security.realidentity.jsbridge.a.C);
        JSONObject jSONObject = new JSONObject();
        if (intArrayExtra != null) {
            if (parcelableArrayListExtra != null) {
                int i = 0;
                while (i < parcelableArrayListExtra.size()) {
                    ImageData imageData = (ImageData) parcelableArrayListExtra.get(i);
                    String str = imageData.a;
                    String str2 = imageData.c;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(com.alibaba.security.realidentity.jsbridge.a.N, (Object) String.valueOf(imageData.b));
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject2.put(com.alibaba.security.realidentity.jsbridge.a.W, (Object) str2);
                    }
                    if (str == null || "0".equals(str)) {
                        jSONObject2.put("errorMsg", (Object) LOW_MEMORY);
                        jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.X + imageData.b, (Object) jSONObject2);
                        jSONObject.put("errorCode", (Object) 1);
                        bridgeCallback.sendJSONResponse(jSONObject);
                        return;
                    }
                    jSONObject2.put("photoPath", (Object) str);
                    String fileLocalId = getFileLocalId(str);
                    jSONObject2.put(com.alibaba.security.realidentity.jsbridge.a.r, (Object) fileLocalId);
                    jSONObject2.put("photoMd5", (Object) getFileMd5(str));
                    jSONObject2.put(com.alibaba.security.realidentity.jsbridge.a.Y, (Object) filePathToApUrl(str, fileLocalId));
                    jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.X + imageData.b, (Object) jSONObject2);
                    i++;
                    stringExtra = stringExtra;
                }
            }
            if (parcelableArrayListExtra == null || intArrayExtra.length != parcelableArrayListExtra.size()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= intArrayExtra.length) {
                        break;
                    } else if (intArrayExtra[i2] >= 0) {
                        com.alibaba.security.common.c.a.b(TAG, String.valueOf(i2));
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put(com.alibaba.security.realidentity.jsbridge.a.N, (Object) Integer.valueOf(intArrayExtra[i2]));
                            jSONObject3.put("errorMsg", (Object) stringExtra);
                            jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.X + intArrayExtra[i2], (Object) jSONObject3);
                            break;
                        } catch (JSONException e) {
                            com.alibaba.security.common.c.a.d(TAG, e.getLocalizedMessage());
                        }
                    } else {
                        i2++;
                    }
                }
            }
            if (parcelableArrayListExtra == null || intArrayExtra.length != parcelableArrayListExtra.size()) {
                jSONObject.put("errorCode", (Object) 1);
                bridgeCallback.sendJSONResponse(jSONObject);
                return;
            }
            jSONObject.put("errorCode", (Object) 0);
            bridgeCallback.sendJSONResponse(jSONObject);
            return;
        }
        bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(106, ""));
    }

    private void initArupUpload(Context context) {
        initArupUpload(context, 0);
    }

    private void listenBroadcast(Context context, final String str, final BridgeCallback bridgeCallback) {
        final i a = i.a(context);
        a.a(new BroadcastReceiver() {
            /* class com.alibaba.security.rp.jsbridge.ariver.IDVerifyBridgeExtension.AnonymousClass2 */

            public void onReceive(Context context, Intent intent) {
                if (str.equals(intent.getAction())) {
                    IDVerifyBridgeExtension.this.onActivityResult(intent, bridgeCallback);
                    a.a(this);
                }
            }
        }, new IntentFilter(str));
    }

    private List<Integer> normalizeActionSteps(JSONArray jSONArray) {
        ArrayList arrayList = null;
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.size(); i++) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                try {
                    String string = jSONArray.getString(i);
                    if ("BLINK".equals(string)) {
                        arrayList.add(i, 1);
                    } else if ("MOUTH".equals(string)) {
                        arrayList.add(i, 2);
                    } else if ("NOD".equals(string)) {
                        arrayList.add(i, 9);
                    } else if ("SHAKE_HEAD".equals(string)) {
                        arrayList.add(i, 3);
                    } else {
                        arrayList.add(i, Integer.valueOf(Integer.parseInt(string)));
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    private String normalizeUrl(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("https://")) {
            return str;
        }
        if (str.startsWith(WVUtils.URL_SEPARATOR)) {
            return "https:".concat(str);
        }
        return "https://".concat(str);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(Intent intent, BridgeCallback bridgeCallback) {
        if (bridgeCallback != null) {
            if (intent.getIntExtra("ret", -1) != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(intent.getIntExtra("ret", -1));
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(105, sb.toString()));
            } else if (TAG_TAKE_PHOTO.equals(intent.getAction())) {
                handleTakePhotoResult(intent, bridgeCallback);
            }
        }
    }

    public void onFinalized() {
        collectUsingLog(TAG, "onFinalized");
    }

    public void onInitialized() {
        collectUsingLog(TAG, "onInitialized");
    }

    public Permission permit() {
        collectUsingLog(TAG, "permit");
        return null;
    }

    @NativePermissionRequire({"android.permission.CAMERA"})
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void rpBiometrics(@BindingNode(App.class) App app2, @BindingParam(name = {"verifyToken"}, required = true) String str, @BindingParam(name = {"identityInfo"}) String str2, @BindingParam(name = {"skinColor"}, stringDefault = "rpsdk_blue") String str3, @BindingParam(name = {"showNav"}) boolean z, @BindingParam(name = {"retryCount"}) int i, @BindingParam(name = {"needGaze"}) boolean z2, @BindingParam(intDefault = 2, name = {"actionCount"}) int i2, @BindingParam(name = {"actionSteps"}) String str4, @BindingParam(booleanDefault = true, name = {"needActionImage"}) boolean z3, @BindingParam(name = {"extras"}) String str5, @BindingCallback final BridgeCallback bridgeCallback) {
        collectUsingLog(TAG, "rpBiometrics");
        try {
            if (TextUtils.isEmpty(str)) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(102, "invalid verifyToken"));
                return;
            }
            JSONArray jSONArray = null;
            if (TextUtils.isEmpty(str4) || (jSONArray = JSON.parseArray(str4)) != null) {
                Context context = app2.getAppContext().getContext();
                initArupUpload(context.getApplicationContext());
                g.a.a.d = str;
                g.a.a.g = new RPConfig.Builder().build();
                RPBusinessHeadParams rPBusinessHeadParams = new RPBusinessHeadParams();
                RPBusinessHeadParams.IdentityInfoBean identityInfoBean = new RPBusinessHeadParams.IdentityInfoBean();
                String userName = getUserName(str2);
                identityInfoBean.name = userName;
                rPBusinessHeadParams.verifyToken = str;
                boolean z4 = false;
                rPBusinessHeadParams.serviceType = 0;
                rPBusinessHeadParams.identityInfo = identityInfoBean;
                rPBusinessHeadParams.userName = userName;
                rPBusinessHeadParams.skinColor = str3;
                rPBusinessHeadParams.livenessConfig = str5;
                rPBusinessHeadParams.showNav = z;
                rPBusinessHeadParams.needGaze = z2;
                rPBusinessHeadParams.retryCount = i;
                if (i2 <= 0) {
                    z4 = true;
                }
                rPBusinessHeadParams.onlyGaze = z4;
                if (jSONArray != null) {
                    rPBusinessHeadParams.bioStepsEx = normalizeActionSteps(jSONArray);
                }
                rPBusinessHeadParams.needActionImage = z3;
                if (str5 != null && !str5.isEmpty()) {
                    rPBusinessHeadParams.livenessConfig = str5;
                }
                new com.alibaba.security.realidentity.business.a(context, str, new RPEventListener() {
                    /* class com.alibaba.security.rp.jsbridge.ariver.IDVerifyBridgeExtension.AnonymousClass1 */

                    @Override // com.alibaba.security.realidentity.RPEventListener
                    public void onFinish(RPResult rPResult, String str, String str2) {
                        try {
                            if (rPResult == RPResult.AUDIT_PASS) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("errorCode", (Object) 0);
                                bridgeCallback.sendJSONResponse(jSONObject);
                            } else if (TextUtils.equals(str, "4")) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("errorCode", (Object) 4);
                                bridgeCallback.sendJSONResponse(jSONObject2);
                            } else {
                                JSONObject jSONObject3 = new JSONObject();
                                boolean isEmpty = TextUtils.isEmpty(str);
                                Object obj = str;
                                if (isEmpty) {
                                    obj = 2;
                                }
                                jSONObject3.put("errorCode", obj);
                                bridgeCallback.sendJSONResponse(jSONObject3);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(104, th.getMessage()));
                        }
                    }
                }, true).a(rPBusinessHeadParams);
                return;
            }
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(103, "invalid actionSteps"));
        } catch (Throwable th) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(101, th.getMessage()));
        }
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void rpDeviceInfo(@BindingNode(Page.class) Page page, @BindingParam(name = {"verifyToken"}, required = true) String str, @BindingCallback BridgeCallback bridgeCallback) {
        collectUsingLog(TAG, "rpDeviceInfo");
        try {
            if (TextUtils.isEmpty(str)) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(102, "invalid verifyToken"));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                String a = com.alibaba.security.common.d.a.a(ALBiometricsJni.genVersionTag(g.a.a.c, str));
                jSONObject.put("versionTag", (Object) a);
                ClientInfo clientInfo = new ClientInfo();
                clientInfo.setClientType(com.alibaba.security.realidentity.jsbridge.a.ai);
                clientInfo.setVersionTag(a);
                jSONObject.putAll(JSON.parseObject(h.a(clientInfo)));
                if (jSONObject.isEmpty()) {
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(104, "empty deviceInfo"));
                } else {
                    bridgeCallback.sendJSONResponse(jSONObject);
                }
            } catch (Throwable unused) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(103, "invalid versionTag"));
            }
        } catch (Throwable th) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(101, th.getMessage()));
        }
    }

    @NativePermissionRequire({"android.permission.CAMERA"})
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void rpStartByH5(@BindingNode(Page.class) Page page, @BindingParam(name = {"verifyToken"}, required = true) String str, @BindingCallback final BridgeCallback bridgeCallback) {
        String str2 = TAG;
        collectUsingLog(str2, "rpStartByH5");
        com.alibaba.security.common.c.a.a(str2, ">>>>>>>>>>>> rpStartByH5: ".concat(String.valueOf(str)));
        try {
            if (TextUtils.isEmpty(str)) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(102, "invalid verifyToken"));
            } else {
                RPVerify.start(page.getApp().getAppContext().getContext(), str, new RPEventListener() {
                    /* class com.alibaba.security.rp.jsbridge.ariver.IDVerifyBridgeExtension.AnonymousClass3 */

                    @Override // com.alibaba.security.realidentity.RPEventListener
                    public void onFinish(RPResult rPResult, RPDetail rPDetail) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("state", (Object) Integer.valueOf(rPResult.code));
                        jSONObject.put("errorCode", (Object) (TextUtils.isEmpty(rPDetail.getCode()) ? "invalidParams" : rPDetail.getCode()));
                        jSONObject.put("subErrorCode", (Object) (TextUtils.isEmpty(rPDetail.getSubCode()) ? null : rPDetail.getSubCode()));
                        jSONObject.put("message", (Object) rPDetail.getMsg());
                        bridgeCallback.sendJSONResponse(jSONObject);
                    }
                });
            }
        } catch (Exception e) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(102, e.getMessage()));
        }
    }

    @NativePermissionRequire({"android.permission.CAMERA"})
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void rpTakePhoto(@BindingNode(Page.class) Page page, @BindingParam(name = {"takePhotoType"}, required = true) String str, @BindingParam(name = {"gestureUrlArray"}) String str2, @BindingCallback BridgeCallback bridgeCallback) {
        collectUsingLog(TAG, TAG_TAKE_PHOTO);
        try {
            if (TextUtils.isEmpty(str)) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(102, "invalid takePhotoType"));
                return;
            }
            JSONArray parseArray = JSON.parseArray(str);
            if (parseArray == null) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(103, "invalid takePhotoType"));
                return;
            }
            JSONArray jSONArray = null;
            if (TextUtils.isEmpty(str2) || (jSONArray = JSON.parseArray(str2)) != null) {
                int size = parseArray.size();
                int[] iArr = new int[size];
                for (int i = 0; i < parseArray.size(); i++) {
                    iArr[i] = parseArray.getIntValue(i);
                }
                String[] strArr = new String[jSONArray.size()];
                for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                    strArr[i2] = normalizeUrl(jSONArray.getString(i2));
                }
                if (size <= 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errorCode", (Object) 0);
                    bridgeCallback.sendJSONResponse(jSONObject);
                    return;
                }
                Context context = page.getApp().getAppContext().getContext();
                Intent intent = new Intent();
                intent.setClass(context, RPTakePhotoActivity.class);
                intent.putExtra("type", 1);
                intent.putExtra(com.alibaba.security.realidentity.jsbridge.a.B, strArr);
                intent.putExtra(com.alibaba.security.realidentity.jsbridge.a.C, iArr);
                intent.putExtra("fileSuffix", ".jpeg");
                startActivity(context, intent, TAG_TAKE_PHOTO, bridgeCallback);
                return;
            }
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(104, "invalid gestureUrlArray"));
        } catch (Throwable th) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(101, th.getMessage()));
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void rpTraceLink(@BindingNode(Page.class) Page page, @BindingParam(name = {"token"}) String str, @BindingParam(name = {"service"}) String str2, @BindingParam(name = {"method"}) String str3, @BindingParam(name = {"code"}) int i, @BindingParam(name = {"msg"}) String str4, @BindingParam(name = {"params"}) String str5, @BindingParam(name = {"result"}) String str6, @BindingParam(name = {"tags"}) List<String> list, @BindingCallback BridgeCallback bridgeCallback) {
        String str7 = TAG;
        collectUsingLog(str7, "rpTraceLink");
        com.alibaba.security.common.c.a.a(str7, ">>>>>>>>>>>> rpTraceLink: ".concat(String.valueOf(str)));
        try {
            TrackLog trackLog = new TrackLog();
            trackLog.setVerifyToken(str);
            trackLog.setService(str2);
            trackLog.setMethod(str3);
            trackLog.setCode(i);
            trackLog.setParams(str5);
            trackLog.setResult(str6);
            trackLog.setTags(list);
            trackLog.setMsg(str4);
            trackLog.setLayer(a.C0103a.c);
            g.a.a.d = str;
            g.a.a.a(trackLog);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", (Object) 0);
            jSONObject.put("message", (Object) "success");
            bridgeCallback.sendJSONResponse(jSONObject);
        } catch (Exception e) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(102, e.getMessage()));
        }
    }

    /* access modifiers changed from: protected */
    public void startActivity(Context context, Intent intent) {
        collectUsingLog(TAG, "startActivity");
        startActivity(context, intent, null);
    }

    private String filePathToApUrl(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = LocalIdTool.get().encodeToLocalId(str);
            }
            if (TextUtils.isEmpty(str3)) {
                String[] split = str.split("\\.");
                if (split == null || split.length <= 1) {
                    return "https://resource/".concat(String.valueOf(str2));
                }
                String str4 = split[split.length - 1];
                return "https://resource/" + str2 + "." + str4;
            }
            return "https://resource/" + str2 + "." + str3;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private void initArupUpload(Context context, int i) {
        String str = TAG;
        com.alibaba.security.common.c.a.a(str, "AUS init appContext->" + context + " env->" + i);
        UploaderGlobal.g(context);
        ys2 ys2 = new ys2(context);
        ys2.setEnvironment(i);
        UploaderGlobal.c(new ws2(context, ys2, new at2(), new bt2()));
    }

    /* access modifiers changed from: protected */
    public void startActivity(Context context, Intent intent, String str) {
        startActivity(context, intent, str, null);
    }

    /* access modifiers changed from: protected */
    public void startActivity(Context context, Intent intent, String str, BridgeCallback bridgeCallback) {
        if (str != null) {
            intent.putExtra(com.alibaba.security.realidentity.jsbridge.a.J, str);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        if (str != null) {
            listenBroadcast(context, str, bridgeCallback);
        }
    }
}
