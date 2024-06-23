package com.alibaba.security.realidentity.jsbridge;

import android.os.Bundle;
import android.taobao.windvane.jsbridge.WVResult;
import android.util.Pair;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.ALBiometricsNavigator;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.c.a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.b;
import com.alibaba.security.realidentity.a.g;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@f(a = "livenessEx")
/* compiled from: Taobao */
public class j extends a {
    private static final String as = "LivenessExJSApi";
    private static final int at = 2;
    private static final int au = 3;
    private static final int av = 6;
    private static final int aw = 10;
    private static final int ax = 11;
    private static final int ay = 159;
    private static final int az = 100;

    static /* synthetic */ String a(int i) {
        if (i == 2) {
            return "OpenMouth";
        }
        if (i == 3) {
            return "ShakeHead";
        }
        if (i == 6) {
            return "None";
        }
        if (i == 10) {
            return "RaiseHeadDown";
        }
        if (i != 11) {
            return null;
        }
        return "KeepStill";
    }

    private static String b(int i) {
        if (i == 2) {
            return "OpenMouth";
        }
        if (i == 3) {
            return "ShakeHead";
        }
        if (i == 6) {
            return "None";
        }
        if (i == 10) {
            return "RaiseHeadDown";
        }
        if (i != 11) {
            return null;
        }
        return "KeepStill";
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return "livenessEx";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, final h hVar) {
        final int i;
        int i2;
        int i3;
        int i4;
        if (a.a()) {
            a.a(as, "LivenessExApi execute params: ".concat(String.valueOf(str)));
        }
        String str2 = null;
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                i3 = jSONObject.getInt("poseDetectInterval");
            } catch (JSONException unused) {
                i3 = 0;
            }
            try {
                str2 = jSONObject.getString(ALBiometricsKeys.KEY_USERNAME);
            } catch (JSONException unused2) {
            }
            try {
                i2 = jSONObject.getInt("showTip");
            } catch (JSONException unused3) {
                i2 = 0;
            }
            try {
                i = jSONObject.getInt("needBase64Image");
            } catch (JSONException unused4) {
                i = 0;
            }
            try {
                i4 = jSONObject.getInt(ALBiometricsKeys.KEY_LESS_IMAGE_MODE);
            } catch (JSONException unused5) {
                i4 = 0;
            }
        } catch (JSONException unused6) {
            a.b();
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        final Bundle bundle = new Bundle();
        bundle.putBoolean("STEP_NAV", false);
        bundle.putInt(ALBiometricsKeys.KEY_SENSORDATA_INTERVALS, i3);
        bundle.putBoolean(ALBiometricsKeys.KEY_SHOW_CHECK_DIALOG, true);
        bundle.putString(ALBiometricsKeys.KEY_BIOMETRICS_CONFIG, str);
        if (i4 == 1) {
            bundle.putBoolean(ALBiometricsKeys.KEY_LESS_IMAGE_MODE, true);
        }
        if (str2 != null) {
            bundle.putString(ALBiometricsKeys.KEY_USERNAME, str2);
        }
        if (i2 != 0) {
            z = true;
        }
        bundle.putBoolean(ALBiometricsKeys.KEY_STEP_NAV, z);
        new ALBiometricsNavigator(this.ao) {
            /* class com.alibaba.security.realidentity.jsbridge.j.AnonymousClass1 */

            @Override // com.alibaba.security.biometrics.ALBiometricsNavigator
            public final ALBiometricsEventListener getEventListener() {
                return new ALBiometricsEventListener() {
                    /* class com.alibaba.security.realidentity.jsbridge.j.AnonymousClass1.AnonymousClass1 */

                    @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
                    public final String getAppKey() {
                        return null;
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onBeforeRetry(OnRetryListener onRetryListener, String str, String str2) {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onBiometricsFinish(int i) {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onBiometricsStart() {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onBusinessOk() {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onCancel(int i, String str, String str2) {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onError(int i, Bundle bundle) {
                        WVResult wVResult = new WVResult();
                        a.d(j.as, "onError.r: ".concat(String.valueOf(i)));
                        if (i == 159) {
                            i = 100;
                        }
                        wVResult.addData("errorMsg", String.valueOf(i));
                        hVar.a(wVResult);
                        j.this.a(wVResult, false);
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onFinish(int i, boolean z) {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onFrameResult(byte[] bArr, int i, int i2) {
                    }

                    @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
                    public final void onLogTrack(TrackLog trackLog) {
                        g.a.a.a(trackLog);
                    }

                    @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
                    public final void onOldLogRecord(Bundle bundle) {
                        HashMap hashMap = new HashMap();
                        if (bundle != null) {
                            for (String str : bundle.keySet()) {
                                hashMap.put(str, bundle.get(str));
                            }
                            b.a().a(hashMap);
                        }
                    }

                    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
                    public final void onSensorReset() {
                    }

                    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
                    public final void onSensorStart() {
                    }

                    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
                    public final void onSensorStop() {
                    }

                    @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
                    public final void onSuccess(ALBiometricsResult aLBiometricsResult) {
                        WVResult wVResult = new WVResult();
                        List<ABActionResult> as = aLBiometricsResult.getAs();
                        String k = aLBiometricsResult.getK();
                        String a2 = com.alibaba.security.common.d.g.a(j.this.ao, k, aLBiometricsResult.getQi().getP());
                        Pair<String, String> putIdCardImage = RPWebViewMediaCacheManager.getInstance().putIdCardImage(j.this.ao, a2);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("imageId", putIdCardImage.first);
                            jSONObject.put("imageUrl", putIdCardImage.second);
                            if (i > 0 && a2 != null) {
                                jSONObject.put("base64Image", com.alibaba.security.common.d.g.a(com.alibaba.security.common.d.g.b(a2)));
                            }
                        } catch (JSONException e) {
                            a.d(j.as, e.getLocalizedMessage());
                        }
                        wVResult.addData(com.alibaba.security.realidentity.a.a.K, jSONObject);
                        for (int i = 0; i < as.size(); i++) {
                            JSONObject jSONObject2 = new JSONObject();
                            String a3 = j.a(as.get(i).getAt());
                            List<ABImageResult> is = as.get(i).getIs();
                            for (int i2 = 0; i2 < is.size(); i2++) {
                                String putIdCardImage2 = RPWebViewMediaCacheManager.getInstance().putIdCardImage(j.this.ao, is.get(i2).getP(), k);
                                JSONObject jSONObject3 = new JSONObject();
                                try {
                                    jSONObject3.put("imageId", putIdCardImage2);
                                    jSONObject2.put("actionType", a3);
                                    jSONObject2.put("image_".concat(String.valueOf(i2)), jSONObject3);
                                } catch (JSONException unused) {
                                    a.b();
                                }
                            }
                            wVResult.addData("movement_".concat(String.valueOf(i)), jSONObject2);
                        }
                        wVResult.setSuccess();
                        hVar.b(wVResult);
                        j.this.a(new WVResult("success"), true);
                    }

                    @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
                    public final String sign(String str) {
                        return null;
                    }
                };
            }

            @Override // com.alibaba.security.biometrics.ALBiometricsNavigator
            public final Bundle getParams() {
                return bundle;
            }
        }.start(this.ao);
        return true;
    }
}
