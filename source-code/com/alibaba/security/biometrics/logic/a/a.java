package com.alibaba.security.biometrics.logic.a;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.alibaba.security.biometrics.camera.c;
import com.alibaba.security.biometrics.component.AudioSettingComponent;
import com.alibaba.security.biometrics.component.MediaSystemComponent;
import com.alibaba.security.biometrics.component.b;
import com.alibaba.security.biometrics.component.d;
import com.alibaba.security.biometrics.component.e;
import com.alibaba.security.biometrics.jni.ABJniDetectResult;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.logic.model.DazzleCollectDataUIConfigItem;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView;
import com.alibaba.security.biometrics.logic.view.widget.CameraActivityWidgetParent;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget;
import com.alibaba.security.biometrics.logic.view.widget.GuideWidget;
import com.alibaba.security.biometrics.logic.view.widget.PrivacyWidget;
import com.alibaba.security.biometrics.logic.view.widget.TitleBarWidget;
import com.alibaba.security.biometrics.logic.view.widget.a;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.ALBiometricsServiceEventListener;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.ABDetectFrame;
import com.alibaba.security.biometrics.service.model.ALBiometricsType;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.d.m;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.LastExitTrackMsgPage;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.track.model.a;
import com.uc.webview.export.media.MessageID;
import com.youku.uplayer.AliMediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
public final class a implements GLSurfaceView.Renderer, com.alibaba.security.biometrics.a.a, d, ALBiometricsActivityParentView.a, ALBiometricsServiceEventListener {
    public static final int a = 1010;
    public static final String b = "model_loading_error_code";
    private static final String e = "ALBiometricsPresenter";
    private static final long f = 500;
    private com.alibaba.security.biometrics.logic.view.b.a A;
    private SurfaceTexture B;
    private com.alibaba.security.biometrics.logic.view.widget.a C;
    private final View.OnClickListener D = new View.OnClickListener() {
        /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass6 */

        public final void onClick(View view) {
            a.this.a(a.this.j == null || a.this.j.isShouldAlertOnExit());
        }
    };
    private List<Integer> E;
    private ABJniDetectResult F;
    private SensorGetter G;
    private SensorInfo H;
    private SensorInfo I;
    public int c = 0;
    public ALBiometricsActivityParentView d;
    private final Activity g;
    private c h;
    private ALBiometricsService i;
    private ALBiometricsConfig j;
    private boolean k;
    private ALBiometricsEventListener l;
    private int m;
    private ABDetectType n;
    private final Runnable o = new Runnable() {
        /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass1 */

        public final void run() {
            if (a.this.n != null && a.this.k) {
                ((MediaSystemComponent) e.a(MediaSystemComponent.class)).a(a.this.n);
            }
        }
    };
    private int p;
    private ALBiometricsParams q;
    private String r;
    private List<DazzleCollectDataUIConfigItem> s;
    private ALBiometricsResult t;
    private boolean u;
    private String v;
    private int w;
    private long x;
    private boolean y;
    private boolean z;

    public a(Activity activity) {
        this.g = activity;
    }

    private void A() {
        String string = this.g.getResources().getString(R.string.face_detect_action_mirror);
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
        if (aLBiometricsActivityParentView != null) {
            aLBiometricsActivityParentView.b(string);
        }
    }

    private boolean B() {
        com.alibaba.security.biometrics.logic.view.widget.a aVar = this.C;
        return aVar != null && aVar.a();
    }

    private void C() {
        if (M()) {
            this.q.timeout = 12;
        } else {
            this.q.timeout = 40;
        }
    }

    private static DazzleCollectDataUIConfigItem D() {
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem.setTitle("检测中···");
        dazzleCollectDataUIConfigItem.setScreenLight(1.0f);
        dazzleCollectDataUIConfigItem.setColor("#FFFFFF");
        dazzleCollectDataUIConfigItem.setTextColor("#333333");
        dazzleCollectDataUIConfigItem.setDuration(1.0f);
        return dazzleCollectDataUIConfigItem;
    }

    private static List<DazzleCollectDataUIConfigItem> E() {
        ArrayList arrayList = new ArrayList();
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem.setTitle("即将进行闪屏检测，请正脸看向屏幕");
        dazzleCollectDataUIConfigItem.setScreenLight(0.1f);
        dazzleCollectDataUIConfigItem.setColor("#FFFFFF");
        dazzleCollectDataUIConfigItem.setDuration(1.0f);
        arrayList.add(dazzleCollectDataUIConfigItem);
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem2 = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem2.setTitle("即将进行闪屏检测，请保持姿势不变");
        dazzleCollectDataUIConfigItem2.setScreenLight(0.2f);
        dazzleCollectDataUIConfigItem2.setColor("#000000");
        dazzleCollectDataUIConfigItem2.setDuration(1.0f);
        arrayList.add(dazzleCollectDataUIConfigItem2);
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem3 = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem3.setTitle("即将进行闪屏检测，请保持姿势不变");
        dazzleCollectDataUIConfigItem3.setScreenLight(1.0f);
        dazzleCollectDataUIConfigItem3.setColor("#ADFF2F");
        dazzleCollectDataUIConfigItem3.setDuration(1.0f);
        arrayList.add(dazzleCollectDataUIConfigItem3);
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem4 = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem4.setTitle("即将进行闪屏检测，请保持姿势不变");
        dazzleCollectDataUIConfigItem4.setScreenLight(0.5f);
        dazzleCollectDataUIConfigItem4.setColor("#000000");
        dazzleCollectDataUIConfigItem4.setDuration(1.0f);
        arrayList.add(dazzleCollectDataUIConfigItem4);
        DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem5 = new DazzleCollectDataUIConfigItem();
        dazzleCollectDataUIConfigItem5.setTitle("即将进行闪屏检测，请保持姿势不变");
        dazzleCollectDataUIConfigItem5.setScreenLight(0.5f);
        dazzleCollectDataUIConfigItem5.setColor("#ADFF2F");
        dazzleCollectDataUIConfigItem5.setDuration(1.0f);
        arrayList.add(dazzleCollectDataUIConfigItem5);
        return arrayList;
    }

    private void F() {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onBusinessOk();
        }
    }

    private void G() {
        ((BaseBioNavigatorActivity) this.g).a(this.o);
        ((BaseBioNavigatorActivity) this.g).b(this.o);
    }

    private void H() {
        ((MediaSystemComponent) e.a(MediaSystemComponent.class)).d();
        ((BaseBioNavigatorActivity) this.g).a(this.o);
    }

    private void I() {
        this.m = 8;
        Activity activity = this.g;
        if (activity != null) {
            activity.finish();
        }
    }

    private void J() {
        h();
    }

    private void K() {
        H();
        ALBiometricsService aLBiometricsService = this.i;
        if (aLBiometricsService != null) {
            aLBiometricsService.release();
        }
    }

    private boolean L() {
        ALBiometricsParams aLBiometricsParams;
        if (M() || (aLBiometricsParams = this.q) == null) {
            return false;
        }
        if (aLBiometricsParams.needSuccessVideo || aLBiometricsParams.needFailVideo) {
            return true;
        }
        return false;
    }

    private boolean M() {
        return ALBiometricsType.isDazzle(this.q.mBiometricsType);
    }

    private static String N() {
        byte[] makeResult = ALBiometricsJni.makeResult(((b) e.a(b.class)).f());
        if (makeResult == null) {
            return null;
        }
        Q();
        return com.alibaba.security.common.d.a.a(makeResult);
    }

    private static void O() {
        ((b) e.a(b.class)).d();
    }

    private static void P() {
        ((b) e.a(b.class)).e();
    }

    private static void Q() {
        ((b) e.a(b.class)).g();
    }

    private static int a(int i2) {
        return (i2 < 4000 || i2 >= 5000) ? i2 : GlobalErrorCode.ERROR_CTID;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p() {
        onCancel(q());
        c();
        I();
    }

    private int q() {
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
        if (aLBiometricsActivityParentView == null || !aLBiometricsActivityParentView.f()) {
            return -1;
        }
        return this.d.getDetectResultErrorCode();
    }

    private boolean r() {
        return q() == 0;
    }

    private LastExitTrackMsg s() {
        if (this.d == null) {
            return null;
        }
        LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
        lastExitTrackMsg.setPage(LastExitTrackMsgPage.BIO.getMsg());
        lastExitTrackMsg.setView(this.d.getCurrentShowView());
        HashMap hashMap = new HashMap();
        hashMap.put("step", Integer.valueOf(this.m));
        hashMap.put("errorCode", Integer.valueOf(this.p));
        hashMap.put("retryCounts", Integer.valueOf(this.c));
        lastExitTrackMsg.setParams(h.a((Object) h.a((Object) hashMap)));
        return lastExitTrackMsg;
    }

    private String t() {
        HashMap hashMap = new HashMap();
        hashMap.put("step", Integer.valueOf(this.m));
        hashMap.put("errorCode", Integer.valueOf(this.p));
        hashMap.put("retryCounts", Integer.valueOf(this.c));
        return h.a((Object) hashMap);
    }

    private void u() {
        b(false);
    }

    private boolean v() {
        int i2 = this.p;
        return i2 == -99999 || i2 == 0;
    }

    private void w() {
        c("view");
        this.d.a();
    }

    private void x() {
        c cVar = this.h;
        if (cVar != null) {
            onLogTrack(TrackLog.createStartCameraParametersLog(cVar.m()));
        }
    }

    private void y() {
        c cVar = this.h;
        if (cVar != null) {
            onLogTrack(TrackLog.createFinishCameraParametersLog(cVar.n()));
        }
    }

    private void z() {
        if (!m.a(this.g, "android.permission.CAMERA")) {
            m.a(this.g, new String[]{"android.permission.CAMERA"}, 1010, "人脸识别服务需要您授权相机权限", new Runnable() {
                /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass11 */

                public final void run() {
                    a.this.b(false);
                }
            }, new Runnable() {
                /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass12 */

                public final void run() {
                    a.f();
                }
            });
        } else {
            b(false);
        }
    }

    @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
    public final void e() {
        this.z = false;
        c("startClick");
        b(false);
    }

    @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
    public final String getAppKey() {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            return aLBiometricsEventListener.getAppKey();
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnActionEndListener
    public final void onActionEnd(ABDetectType aBDetectType, int i2, int i3) {
        ALBiometricsActivityParentView aLBiometricsActivityParentView;
        HashMap hashMap = new HashMap();
        hashMap.put("index", Integer.valueOf(i2));
        hashMap.put("actionType", h.a(aBDetectType));
        ALBiometricsJni.bhL(13, h.a((Object) hashMap));
        onLogTrack(a("finishAction", aBDetectType.getValue(), i2));
        if (aBDetectType != ABDetectType.AIMLESS && (aLBiometricsActivityParentView = this.d) != null) {
            aLBiometricsActivityParentView.b();
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnActionStartListener
    public final void onActionStart(ABDetectType aBDetectType, int i2, int i3) {
        this.m = 4;
        this.n = aBDetectType;
        HashMap hashMap = new HashMap();
        hashMap.put("index", Integer.valueOf(i2));
        hashMap.put("actionType", h.a(aBDetectType));
        ALBiometricsJni.bhL(12, h.a((Object) hashMap));
        onLogTrack(a("startAction", aBDetectType.getValue(), i2));
        a(aBDetectType);
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnAdjustEndListener
    public final void onAdjustEnd() {
        ALBiometricsJni.bhL(11, "");
        onLogTrack(d("didAdjust"));
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnAdjustStartListener
    public final void onAdjustStart() {
        this.m = 3;
        ALBiometricsJni.bhL(10, "");
        onLogTrack(d("willAdjust"));
        A();
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnBeforeRetryListener
    public final void onBeforeRetry(OnRetryListener onRetryListener, String str) {
        ALBiometricsEventListener aLBiometricsEventListener = this.l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onBeforeRetry(onRetryListener, str, N());
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnCancelListener
    public final void onCancel(int i2) {
        LastExitTrackMsg lastExitTrackMsg;
        if (this.d != null) {
            lastExitTrackMsg = new LastExitTrackMsg();
            lastExitTrackMsg.setPage(LastExitTrackMsgPage.BIO.getMsg());
            lastExitTrackMsg.setView(this.d.getCurrentShowView());
            HashMap hashMap = new HashMap();
            hashMap.put("step", Integer.valueOf(this.m));
            hashMap.put("errorCode", Integer.valueOf(this.p));
            hashMap.put("retryCounts", Integer.valueOf(this.c));
            lastExitTrackMsg.setParams(h.a((Object) h.a((Object) hashMap)));
        } else {
            lastExitTrackMsg = null;
        }
        a.C0102a.a().a = lastExitTrackMsg;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errorCode", Integer.valueOf(i2));
        ALBiometricsJni.bhL(21, h.a((Object) hashMap2));
        if (this.l != null) {
            this.l.onCancel(i2, com.alibaba.security.common.d.a.a(ALBiometricsJni.dumpBeh(true)), N());
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnDetectContinueListener
    public final void onDetectContinue(ABImageResult aBImageResult) {
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnDetectStartListener
    public final void onDetectStart() {
        if (L()) {
            f("开始录制活体视频");
        }
    }

    public final void onDrawFrame(GL10 gl10) {
        this.A.onDrawFrame(gl10);
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnFinishListener
    public final void onFinish(int i2, final Bundle bundle) {
        final ALBiometricsResult aLBiometricsResult = (ALBiometricsResult) bundle.getSerializable(ALBiometricsKeys.KEY_RESULT_DATA);
        if (bundle.containsKey(ALBiometricsKeys.KEY_RESULT_LOG_DATA)) {
            Bundle bundle2 = bundle.getBundle(ALBiometricsKeys.KEY_RESULT_LOG_DATA);
            if (bundle2 != null) {
                bundle2.putInt("time_show_nav", this.q.stepNav ? 1 : 0);
            }
            onOldLogRecord(bundle2);
        }
        this.p = i2;
        this.t = aLBiometricsResult;
        if (i2 == 0) {
            ALBiometricsJni.bhL(18, h.a(this.F));
            if (L()) {
                a((com.alibaba.security.common.e.b) new com.alibaba.security.common.e.b() {
                    /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass2 */

                    @Override // com.alibaba.security.common.e.b
                    public final void onFinish(String str, int i) {
                        aLBiometricsResult.setVideoS(str);
                        a.this.a((a) aLBiometricsResult);
                    }
                }, false, "算法检测成功,停止录制活体视频");
            } else {
                a(aLBiometricsResult);
            }
        } else if (L()) {
            a((com.alibaba.security.common.e.b) new com.alibaba.security.common.e.b() {
                /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass3 */

                @Override // com.alibaba.security.common.e.b
                public final void onFinish(String str, int i) {
                    aLBiometricsResult.setVideoF(str);
                    a.this.a((a) bundle.getInt(ALBiometricsKeys.KEY_ERROR_CODE), (int) bundle);
                }
            }, false, "算法检测失败，停止录制活体视频");
        } else {
            a(bundle.getInt(ALBiometricsKeys.KEY_ERROR_CODE), bundle);
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnFrameDetectedListener
    public final void onFrameDetected(ABDetectFrame aBDetectFrame) {
        RPDetectCoreView rPDetectCoreView;
        if (aBDetectFrame != null && this.d != null && this.k) {
            this.F = aBDetectFrame.getDetectResult();
            if (System.currentTimeMillis() - this.x >= 500) {
                this.x = System.currentTimeMillis();
                ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
                boolean hasFace = aBDetectFrame.hasFace();
                DetectActionWidget detectActionWidget = aLBiometricsActivityParentView.e;
                if (!(detectActionWidget == null || (rPDetectCoreView = detectActionWidget.b) == null)) {
                    if (hasFace) {
                        rPDetectCoreView.a();
                    } else {
                        if (rPDetectCoreView.g == null) {
                            ValueAnimator duration = ValueAnimator.ofInt(100, 0).setDuration(1000L);
                            rPDetectCoreView.g = duration;
                            duration.setRepeatCount(-1);
                            rPDetectCoreView.g.addUpdateListener(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005b: INVOKE  
                                  (wrap: android.animation.ValueAnimator : 0x0054: IGET  (r1v9 android.animation.ValueAnimator) = (r0v21 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.g android.animation.ValueAnimator)
                                  (wrap: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1 : 0x0058: CONSTRUCTOR  (r2v5 com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1) = (r0v21 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) call: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.1.<init>(com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: android.animation.ValueAnimator.addUpdateListener(android.animation.ValueAnimator$AnimatorUpdateListener):void in method: com.alibaba.security.biometrics.logic.a.a.onFrameDetected(com.alibaba.security.biometrics.service.model.ABDetectFrame):void, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0058: CONSTRUCTOR  (r2v5 com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1) = (r0v21 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) call: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.1.<init>(com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView):void type: CONSTRUCTOR in method: com.alibaba.security.biometrics.logic.a.a.onFrameDetected(com.alibaba.security.biometrics.service.model.ABDetectFrame):void, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 43 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 49 more
                                */
                            /*
                            // Method dump skipped, instructions count: 188
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.a.a.onFrameDetected(com.alibaba.security.biometrics.service.model.ABDetectFrame):void");
                        }

                        @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
                        public final void onLogTrack(TrackLog trackLog) {
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onLogTrack(trackLog);
                            }
                        }

                        @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnMessageListener
                        public final void onMessage(int i2, Bundle bundle) {
                            if (this.k && this.d != null) {
                                if (i2 == -10213 || i2 == -10214 || i2 == -10215 || i2 == -10219) {
                                    String str = "";
                                    if (bundle != null) {
                                        str = bundle.getString(ALBiometricsKeys.KEY_ERROR_MESSAGE, str);
                                    }
                                    onLogTrack(TrackLog.createBioMonitorExpLog(i2, str));
                                }
                                if (!M()) {
                                    this.d.a(i2);
                                }
                            }
                        }

                        @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
                        public final void onOldLogRecord(Bundle bundle) {
                            try {
                                com.alibaba.security.biometrics.c.b.a.b().a().putAll(bundle);
                            } catch (Exception unused) {
                            }
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onOldLogRecord(bundle);
                            }
                        }

                        @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnRecognizeEndListener
                        public final void onRecognizeEnd() {
                        }

                        @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnRecognizeStartListener
                        public final void onRecognizeStart() {
                        }

                        @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnReflectEndListener
                        public final void onReflectEnd() {
                        }

                        @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnReflectStartListener
                        public final void onReflectStart() {
                            this.m = 5;
                            com.alibaba.security.common.d.d.a(this.g, (int) AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX);
                            ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
                            if (aLBiometricsActivityParentView != null) {
                                aLBiometricsActivityParentView.c();
                            }
                        }

                        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
                        public final void onSensorReset() {
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onSensorReset();
                            }
                        }

                        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
                        public final void onSensorStart() {
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onSensorStart();
                            }
                        }

                        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
                        public final void onSensorStop() {
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onSensorStop();
                            }
                        }

                        public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
                            this.A.onSurfaceChanged(gl10, i2, i3);
                        }

                        public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                            this.A.onSurfaceCreated(gl10, eGLConfig);
                            SurfaceTexture surfaceTexture = this.A.c;
                            this.B = surfaceTexture;
                            this.h.a(surfaceTexture);
                            this.B.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                                /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass13 */

                                public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                                    CameraActivityWidgetParent cameraActivityWidgetParent = a.this.d.a;
                                    if (cameraActivityWidgetParent != null) {
                                        cameraActivityWidgetParent.a();
                                    }
                                }
                            });
                        }

                        @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
                        public final String sign(String str) {
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                return aLBiometricsEventListener.sign(str);
                            }
                            return null;
                        }

                        private void c(String str) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("actionType", str);
                            onLogTrack(TrackLog.createBioPrivacyPageLog(h.a((Map) hashMap)));
                        }

                        public static void f() {
                            ((com.alibaba.security.biometrics.logic.a) e.a(com.alibaba.security.biometrics.logic.a.class)).a(GlobalErrorCode.ERROR_DEVICE_CAMERA_NO_PERMISSION, "CameraPermissionComponent ERROR_DEVICE_CAMERA_NO_PERMISSION", null);
                        }

                        private void h(boolean z2) {
                            this.E.remove((Object) 2);
                            if (this.r == null) {
                                com.alibaba.security.common.c.a.d(e, "mDazzleBizConfig is null");
                                return;
                            }
                            com.alibaba.security.common.d.d.a(this.g, 255);
                            List<DazzleCollectDataUIConfigItem> a2 = h.a(this.r, DazzleCollectDataUIConfigItem.class);
                            if (a2 == null) {
                                com.alibaba.security.common.c.a.d(e, "mDazzleBizConfig is not json:\n" + this.r);
                                return;
                            }
                            for (DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem : a2) {
                                dazzleCollectDataUIConfigItem.setTitle("检测中···");
                            }
                            this.s = a2;
                            this.q.mBiometricsType = 2;
                            C();
                            j(z2);
                            i(false);
                        }

                        private void i() {
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onSensorStart();
                            }
                        }

                        private void j() {
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onSensorStop();
                            }
                        }

                        private void k() {
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onSensorReset();
                            }
                        }

                        private void l() {
                            ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
                            if (aLBiometricsActivityParentView != null) {
                                aLBiometricsActivityParentView.e();
                            }
                        }

                        private void m() {
                            int i2 = this.c + 1;
                            this.c = i2;
                            ALBiometricsParams aLBiometricsParams = this.q;
                            if (i2 > aLBiometricsParams.retryThreshold) {
                                a(GlobalErrorCode.ERROR_USER_RETRY_LIMITED, ALBiometricsKeys.KEY_RETRY_THRESHOLD, (String) null);
                                return;
                            }
                            ALBiometricsService aLBiometricsService = this.i;
                            if (aLBiometricsService != null) {
                                aLBiometricsService.setParams(aLBiometricsParams);
                            }
                            ALBiometricsJni.bhL(20, "");
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onSensorReset();
                            }
                            n();
                            b(true);
                            Q();
                            ((b) e.a(b.class)).d();
                        }

                        private void n() {
                            if (this.q.bioSteps != null) {
                                this.E = new ArrayList(this.q.bioSteps);
                            }
                            if (this.E == null) {
                                this.E = new ArrayList();
                            }
                            if (this.E.isEmpty()) {
                                this.E.add(1);
                            }
                        }

                        private void o() {
                            this.c = 0;
                        }

                        @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
                        public final void d() {
                            this.y = false;
                            b("startClick");
                            b(false);
                        }

                        @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
                        public final void g() {
                            if (this.k && !M()) {
                                int i2 = this.m;
                                if (i2 == 3) {
                                    A();
                                } else if (i2 == 4) {
                                    a(this.n);
                                }
                            }
                        }

                        private void b(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
                            aLBiometricsActivityParentView.setOnButtonClickListener(this);
                            aLBiometricsActivityParentView.setOnCloseListener(this.D);
                            aLBiometricsActivityParentView.setOnDetectActionResultListener(this);
                            aLBiometricsActivityParentView.setRenderer(this);
                        }

                        private void f(boolean z2) {
                            if (this.E.size() == 1 && this.E.contains(2)) {
                                ALBiometricsParams aLBiometricsParams = this.q;
                                aLBiometricsParams.actionCount = 0;
                                aLBiometricsParams.stepAdjust = true;
                                this.E.add(0, 1);
                            }
                            if (this.E.indexOf(2) != 0 || this.r == null) {
                                g(z2);
                            } else {
                                h(z2);
                            }
                        }

                        private void e(boolean z2) {
                            if (!this.k) {
                                this.k = true;
                                this.p = GlobalErrorCode.INIT;
                                ALBiometricsEventListener aLBiometricsEventListener = this.l;
                                if (aLBiometricsEventListener != null) {
                                    aLBiometricsEventListener.onSensorStart();
                                }
                                this.d.d();
                                Point g2 = this.h.g();
                                if (g2 == null) {
                                    com.alibaba.security.common.c.a.d(e, "getCameraPreviewSize is null");
                                    return;
                                }
                                this.d.a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(g2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(g2));
                                this.m = 1;
                                ALBiometricsJni.bhL(2, this.h.f());
                                if (this.E.size() == 1 && this.E.contains(2)) {
                                    ALBiometricsParams aLBiometricsParams = this.q;
                                    aLBiometricsParams.actionCount = 0;
                                    aLBiometricsParams.stepAdjust = true;
                                    this.E.add(0, 1);
                                }
                                if (this.E.indexOf(2) != 0 || this.r == null) {
                                    g(z2);
                                } else {
                                    h(z2);
                                }
                            }
                        }

                        private void i(boolean z2) {
                            if (this.s != null && !this.u) {
                                ArrayList arrayList = new ArrayList(this.s);
                                arrayList.add(0, D());
                                if (z2) {
                                    this.c++;
                                }
                                if (this.c > this.q.retryThreshold) {
                                    a(GlobalErrorCode.ERROR_USER_RETRY_LIMITED, "dazzle retryThreshold", (String) null);
                                    return;
                                }
                                onLogTrack(TrackLog.startShowDazzleView(h.a(this.s), h.a(arrayList), "开始炫彩闪屏"));
                                this.u = true;
                                H();
                                this.i.resetBioTimeOut(12);
                                this.H = new SensorInfo(this.G.getCurrentLightValue(), this.G.getProximityValue());
                                this.d.a(arrayList, new com.alibaba.security.biometrics.logic.view.a.a() {
                                    /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass4 */

                                    @Override // com.alibaba.security.biometrics.logic.view.a.a
                                    public final void a() {
                                        a aVar = a.this;
                                        aVar.I = new SensorInfo(aVar.G.getCurrentLightValue(), a.this.G.getProximityValue());
                                        a.this.u = false;
                                        a.this.a((a) new com.alibaba.security.common.e.b() {
                                            /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass4.AnonymousClass1 */

                                            @Override // com.alibaba.security.common.e.b
                                            public final void onFinish(String str, int i) {
                                                a.this.v = str;
                                                a.this.w = i;
                                                a aVar = a.this;
                                                aVar.a((a) aVar.t);
                                                try {
                                                    a.this.onLogTrack(TrackLog.dazzleFailedTrack("finish record", String.valueOf(new File(a.this.v).length() / 1024), System.currentTimeMillis()));
                                                } catch (Exception unused) {
                                                }
                                            }
                                        }, (com.alibaba.security.common.e.b) false, "停止录制并保存炫彩视频-炫彩闪屏结束");
                                    }

                                    @Override // com.alibaba.security.biometrics.logic.view.a.a
                                    public final void b() {
                                        a.this.f((a) "开始录制炫彩视频");
                                    }

                                    @Override // com.alibaba.security.biometrics.logic.view.a.a
                                    public final void c() {
                                    }
                                });
                            }
                        }

                        private void j(boolean z2) {
                            ALBiometricsService aLBiometricsService = new ALBiometricsService(this.g, this.q, this);
                            this.i = aLBiometricsService;
                            if (z2) {
                                aLBiometricsService.restart();
                            } else {
                                aLBiometricsService.start();
                            }
                        }

                        private void d(final boolean z2) {
                            ALBiometricsParams aLBiometricsParams = this.q;
                            if (aLBiometricsParams.reachBusinessRetryLimit) {
                                a(GlobalErrorCode.ERROR_USER_RETRY_LIMITED, "reachBusinessRetryLimit", (String) null);
                                return;
                            }
                            int i2 = aLBiometricsParams.ctidResultCode;
                            if (i2 != -2 && i2 != 0) {
                                a(i2, "Error on CTID auth, code: ".concat(String.valueOf(i2)), (String) null);
                            } else if (this.y) {
                                b("view");
                                this.d.a(this.q.userName);
                            } else if (this.z) {
                                c("view");
                                this.d.a();
                            } else {
                                this.h.a(new c.a() {
                                    /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass9 */

                                    @Override // com.alibaba.security.biometrics.camera.c.a
                                    public final void a(int i, String str) {
                                        a.this.a(i, str, (String) null);
                                        a.e(a.this);
                                    }

                                    @Override // com.alibaba.security.biometrics.camera.c.a
                                    public final void a() {
                                        a.a(a.this, z2);
                                        a.e(a.this);
                                    }

                                    @Override // com.alibaba.security.biometrics.camera.c.a
                                    public final void a(byte[] bArr, int i, int i2, int i3) {
                                        if (a.this.m == 1) {
                                            a.this.m = 2;
                                        }
                                        if (a.this.i != null) {
                                            a.this.i.process(bArr, i, i2, i3);
                                        }
                                    }
                                });
                                SurfaceTexture surfaceTexture = this.B;
                                if (surfaceTexture != null) {
                                    this.h.a(surfaceTexture);
                                }
                                ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
                                AnonymousClass10 r1 = new Runnable() {
                                    /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass10 */

                                    public final void run() {
                                        if (a.this.h.k()) {
                                            a.a(a.this, z2);
                                        }
                                    }
                                };
                                DetectActionWidget detectActionWidget = aLBiometricsActivityParentView.e;
                                if (detectActionWidget != null) {
                                    detectActionWidget.a(new RPDetectCoreView.a(r1) {
                                        /* class com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.AnonymousClass3 */

                                        @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.a
                                        public final void a() {
                                            r3.run();
                                        }

                                        @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.a
                                        public final void b() {
                                        }
                                    });
                                }
                            }
                        }

                        @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
                        public final void c(boolean z2) {
                            try {
                                int i2 = 1;
                                ((MediaSystemComponent) e.a(MediaSystemComponent.class)).a(!z2);
                                int d2 = ((AudioSettingComponent) e.a(AudioSettingComponent.class)).d();
                                if (z2) {
                                    boolean z3 = d2 == 0;
                                    ((AudioSettingComponent) e.a(AudioSettingComponent.class)).d = z3;
                                    if (z3) {
                                        try {
                                            ((AudioSettingComponent) e.a(AudioSettingComponent.class)).e.setRingerMode(2);
                                        } catch (Throwable unused) {
                                        }
                                    }
                                }
                                HashMap hashMap = new HashMap();
                                if (!z2) {
                                    i2 = 0;
                                }
                                hashMap.put("isOn", Integer.valueOf(i2));
                                onLogTrack(TrackLog.createSoundClickLog(h.a((Map) hashMap)));
                            } catch (Throwable unused2) {
                            }
                        }

                        private void b(String str) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("actionType", str);
                            onLogTrack(TrackLog.createBioGuidePageLog(h.a((Map) hashMap)));
                        }

                        private void g(boolean z2) {
                            com.alibaba.security.common.d.d.a(this.g, 255);
                            this.E.remove((Object) 1);
                            this.q.mBiometricsType = 1;
                            j(z2);
                        }

                        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0059, code lost:
                            if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x005d;
                         */
                        @Override // com.alibaba.security.biometrics.component.d
                        public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
                            String str;
                            byte[] a2;
                            this.l = aLBiometricsEventListener;
                            this.q = aLBiometricsParams;
                            this.j = aLBiometricsConfig;
                            this.h = new com.alibaba.security.biometrics.camera.b(activity, aLBiometricsParams);
                            this.A = new com.alibaba.security.biometrics.logic.view.b.a(activity, this.h, this.q);
                            this.m = 0;
                            this.p = GlobalErrorCode.INIT;
                            ALBiometricsParams aLBiometricsParams2 = this.q;
                            this.y = aLBiometricsParams2.stepNav;
                            this.z = aLBiometricsParams2.stepPrivacy;
                            C();
                            n();
                            if (this.E.contains(2)) {
                                String str2 = aLBiometricsParams.bizConf;
                                if (Build.VERSION.SDK_INT >= 18 && !TextUtils.isEmpty(str2) && (a2 = com.alibaba.security.common.d.a.a(str2)) != null) {
                                    str = ALBiometricsJni.dp(a2);
                                }
                            }
                            str = null;
                            this.r = str;
                            SensorGetter sensorGetter = SensorGetter.getDefault();
                            this.G = sensorGetter;
                            sensorGetter.start();
                            return true;
                        }

                        @Override // com.alibaba.security.biometrics.component.d
                        public final boolean b() {
                            int i2 = this.m;
                            if (!(i2 == 0 || i2 == 6 || i2 == 7 || i2 == 8)) {
                                a(GlobalErrorCode.ERROR_DETECT_INTERRUPT, MessageID.onPause, (String) null);
                            }
                            return true;
                        }

                        /* access modifiers changed from: private */
                        /* access modifiers changed from: public */
                        private void f(String str) {
                            long currentTimeMillis = System.currentTimeMillis();
                            this.h.l();
                            com.alibaba.security.common.c.a.a(e, str + "\ttime:" + (System.currentTimeMillis() - currentTimeMillis));
                            onLogTrack(TrackLog.startRecordVideo(str, Log.getStackTraceString(new Throwable()), String.valueOf(this.h.j()), System.currentTimeMillis() - currentTimeMillis));
                        }

                        public final void b(boolean z2) {
                            if (m.a(this.g, "android.permission.CAMERA")) {
                                d(z2);
                            }
                        }

                        private static TrackLog b(int i2, String str) {
                            TrackLog trackLog = new TrackLog();
                            trackLog.setLayer(a.C0103a.a);
                            trackLog.setService(a.c.e);
                            trackLog.setMethod(a.b.J);
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", Integer.valueOf(i2));
                            hashMap.put(com.alibaba.security.realidentity.jsbridge.a.af, str);
                            trackLog.setParams(h.a((Map) hashMap));
                            return trackLog;
                        }

                        public final void h() {
                            K();
                            if (this.h.k()) {
                                y();
                                this.h.d();
                            }
                            this.k = false;
                        }

                        @Override // com.alibaba.security.biometrics.component.d
                        public final boolean c() {
                            Dialog dialog;
                            this.k = false;
                            this.c = 0;
                            h();
                            ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
                            if (aLBiometricsActivityParentView != null) {
                                DetectActionWidget detectActionWidget = aLBiometricsActivityParentView.e;
                                if (detectActionWidget != null) {
                                    detectActionWidget.c();
                                }
                                DetectActionResultWidget detectActionResultWidget = aLBiometricsActivityParentView.f;
                                if (detectActionResultWidget != null) {
                                    detectActionResultWidget.b = 0;
                                }
                            }
                            ALBiometricsService aLBiometricsService = this.i;
                            if (aLBiometricsService != null) {
                                aLBiometricsService.release();
                            }
                            com.alibaba.security.biometrics.logic.view.widget.a aVar = this.C;
                            if (!(aVar == null || !aVar.a() || (dialog = this.C.a) == null)) {
                                dialog.dismiss();
                            }
                            ALBiometricsActivityParentView aLBiometricsActivityParentView2 = this.d;
                            if (aLBiometricsActivityParentView2 != null) {
                                AnonymousClass5 r1 = new Runnable() {
                                    /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass5 */

                                    public final void run() {
                                        if (a.this.A != null) {
                                            com.alibaba.security.biometrics.logic.view.b.a aVar = a.this.A;
                                            SurfaceTexture surfaceTexture = aVar.c;
                                            if (surfaceTexture != null) {
                                                surfaceTexture.release();
                                                aVar.c = null;
                                            }
                                            aVar.a = -1;
                                            com.alibaba.security.common.a.a aVar2 = aVar.b;
                                            if (aVar2 != null) {
                                                aVar2.a();
                                            }
                                        }
                                    }
                                };
                                CameraActivityWidgetParent cameraActivityWidgetParent = aLBiometricsActivityParentView2.a;
                                if (cameraActivityWidgetParent != null) {
                                    cameraActivityWidgetParent.a(r1);
                                }
                            }
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onBiometricsFinish(this.p);
                            }
                            this.G.stop();
                            return true;
                        }

                        private static TrackLog d(String str) {
                            TrackLog trackLog = new TrackLog();
                            trackLog.setLayer(a.C0103a.a);
                            trackLog.setService(a.c.e);
                            trackLog.setMethod(a.b.I);
                            HashMap hashMap = new HashMap();
                            hashMap.put("action", str);
                            trackLog.setParams(h.a((Map) hashMap));
                            return trackLog;
                        }

                        private void e(String str) {
                            if (this.u) {
                                onLogTrack(TrackLog.stopShowDazzleView("停止炫彩闪屏", h.a(this.s)));
                                this.u = false;
                                if (this.h.j()) {
                                    a((com.alibaba.security.common.e.b) null, true, "停止录制并删除炫彩视频-".concat(String.valueOf(str)));
                                }
                                this.d.e.h();
                            }
                        }

                        private void b(ALBiometricsResult aLBiometricsResult) {
                            this.m = 7;
                            this.k = false;
                            h();
                            this.d.c();
                            aLBiometricsResult.setBh(com.alibaba.security.common.d.a.a(ALBiometricsJni.dumpBeh(true)));
                            ALBiometricsEventListener aLBiometricsEventListener = this.l;
                            if (aLBiometricsEventListener != null) {
                                aLBiometricsEventListener.onSuccess(aLBiometricsResult);
                            }
                        }

                        private static String a(String str) {
                            byte[] a2;
                            if (Build.VERSION.SDK_INT < 18 || TextUtils.isEmpty(str) || (a2 = com.alibaba.security.common.d.a.a(str)) == null) {
                                return null;
                            }
                            String dp = ALBiometricsJni.dp(a2);
                            if (TextUtils.isEmpty(dp)) {
                                return null;
                            }
                            return dp;
                        }

                        static /* synthetic */ void e(a aVar) {
                            c cVar = aVar.h;
                            if (cVar != null) {
                                aVar.onLogTrack(TrackLog.createStartCameraParametersLog(cVar.m()));
                            }
                        }

                        private void b(int i2) {
                            com.alibaba.security.biometrics.c.b.c.a(i2, this.c);
                        }

                        @Override // com.alibaba.security.biometrics.component.d
                        public final void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
                            this.d = aLBiometricsActivityParentView;
                            aLBiometricsActivityParentView.setOnButtonClickListener(this);
                            aLBiometricsActivityParentView.setOnCloseListener(this.D);
                            aLBiometricsActivityParentView.setOnDetectActionResultListener(this);
                            aLBiometricsActivityParentView.setRenderer(this);
                            if (!m.a(this.g, "android.permission.CAMERA")) {
                                m.a(this.g, new String[]{"android.permission.CAMERA"}, 1010, "人脸识别服务需要您授权相机权限", new Runnable() {
                                    /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass11 */

                                    public final void run() {
                                        a.this.b(false);
                                    }
                                }, new Runnable() {
                                    /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass12 */

                                    public final void run() {
                                        a.f();
                                    }
                                });
                            } else {
                                b(false);
                            }
                        }

                        private void a(int i2, String str) {
                            a(i2, str, (String) null);
                        }

                        public final void a(int i2, String str, String str2) {
                            e("活体认证结束:" + i2 + ":" + str);
                            this.k = false;
                            if (i2 == 0) {
                                this.m = 7;
                            } else {
                                this.m = 6;
                            }
                            h();
                            this.p = a(i2);
                            if (this.c > this.q.retryThreshold && (i2 == -10204 || i2 == -10205 || i2 == -10206)) {
                                i2 = GlobalErrorCode.ERROR_USER_RETRY_LIMITED;
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("algoResult", h.a(this.F));
                            hashMap.put("errorCode", Integer.valueOf(i2));
                            hashMap.put("errorMsg", str);
                            ALBiometricsJni.bhL(19, h.a((Object) hashMap));
                            this.d.a(i2, str2, com.alibaba.security.common.d.a.a(ALBiometricsJni.dumpBeh(true)));
                            P();
                        }

                        @Override // com.alibaba.security.biometrics.a.a
                        public final void a(int i2, int i3, int i4) {
                            if (i3 == 0) {
                                a(i2, true, i4);
                            } else if (i3 == 1) {
                                a(i2, false, i4);
                            }
                        }

                        private void a(int i2, int[] iArr) {
                            if (i2 == 1010) {
                                if ((iArr.length > 0 ? iArr[0] : -1) != 0) {
                                    f();
                                } else {
                                    b(false);
                                }
                            }
                        }

                        @Override // com.alibaba.security.biometrics.component.d
                        public final boolean a() {
                            ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
                            if (aLBiometricsActivityParentView == null) {
                                return true;
                            }
                            CameraActivityWidgetParent cameraActivityWidgetParent = aLBiometricsActivityParentView.a;
                            if (cameraActivityWidgetParent != null) {
                                cameraActivityWidgetParent.c();
                            }
                            TitleBarWidget titleBarWidget = aLBiometricsActivityParentView.b;
                            if (titleBarWidget != null) {
                                titleBarWidget.d();
                            }
                            GuideWidget guideWidget = aLBiometricsActivityParentView.c;
                            if (guideWidget != null) {
                                guideWidget.d();
                            }
                            PrivacyWidget privacyWidget = aLBiometricsActivityParentView.d;
                            if (privacyWidget != null) {
                                privacyWidget.d();
                            }
                            DetectActionWidget detectActionWidget = aLBiometricsActivityParentView.e;
                            if (detectActionWidget != null) {
                                detectActionWidget.d();
                            }
                            DetectActionResultWidget detectActionResultWidget = aLBiometricsActivityParentView.f;
                            if (detectActionResultWidget == null) {
                                return true;
                            }
                            detectActionResultWidget.d();
                            return true;
                        }

                        private void a(ABDetectType aBDetectType) {
                            if (aBDetectType != null && aBDetectType != ABDetectType.AIMLESS) {
                                ((MediaSystemComponent) e.a(MediaSystemComponent.class)).a(aBDetectType);
                                G();
                                ALBiometricsActivityParentView aLBiometricsActivityParentView = this.d;
                                if (aLBiometricsActivityParentView != null) {
                                    aLBiometricsActivityParentView.a(aBDetectType);
                                }
                            }
                        }

                        private static TrackLog a(String str, int i2, int i3) {
                            TrackLog trackLog = new TrackLog();
                            trackLog.setLayer(a.C0103a.a);
                            trackLog.setService(a.c.e);
                            trackLog.setMethod("action");
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", Integer.valueOf(i2));
                            hashMap.put("index", Integer.valueOf(i3));
                            hashMap.put("action", str);
                            trackLog.setParams(h.a((Map) hashMap));
                            return trackLog;
                        }

                        private void a(Bundle bundle) {
                            if (bundle != null && bundle.containsKey(ALBiometricsKeys.KEY_RESULT_LOG_DATA)) {
                                Bundle bundle2 = bundle.getBundle(ALBiometricsKeys.KEY_RESULT_LOG_DATA);
                                if (bundle2 != null) {
                                    bundle2.putInt("time_show_nav", this.q.stepNav ? 1 : 0);
                                }
                                onOldLogRecord(bundle2);
                            }
                        }

                        /* access modifiers changed from: private */
                        /* access modifiers changed from: public */
                        private void a(ALBiometricsResult aLBiometricsResult) {
                            if (this.E.contains(1)) {
                                g(false);
                            } else if (this.E.contains(2) && this.r != null) {
                                h(false);
                            } else if (aLBiometricsResult == null) {
                                com.alibaba.security.common.c.a.d(e, "bio result is null");
                            } else {
                                aLBiometricsResult.setDazzleVideoPath(this.v);
                                aLBiometricsResult.setDazzleCollectRotate(this.w);
                                aLBiometricsResult.addDazzleCollectConfigs(this.s);
                                aLBiometricsResult.getDazzleDataConfigs().setLastSensorInfo(this.I);
                                aLBiometricsResult.getDazzleDataConfigs().setFirstSensorInfo(this.H);
                                aLBiometricsResult.setCollectedData(N());
                                b(aLBiometricsResult);
                            }
                        }

                        /* access modifiers changed from: private */
                        /* access modifiers changed from: public */
                        private void a(com.alibaba.security.common.e.b bVar, boolean z2, String str) {
                            long currentTimeMillis = System.currentTimeMillis();
                            this.h.a(bVar, z2);
                            com.alibaba.security.common.c.a.a(e, str + "\tcostTime:" + (System.currentTimeMillis() - currentTimeMillis));
                            onLogTrack(TrackLog.stopRecordVideo(str, Log.getStackTraceString(new Throwable()), String.valueOf(this.h.j()), System.currentTimeMillis() - currentTimeMillis));
                        }

                        /* access modifiers changed from: private */
                        /* access modifiers changed from: public */
                        private void a(int i2, Bundle bundle) {
                            if (i2 == -10211 || i2 == -10210 || i2 == -10209) {
                                com.alibaba.security.common.d.d.a(this.g, 255);
                            }
                            String string = bundle.getString(ALBiometricsKeys.KEY_ERROR_MESSAGE, "");
                            onLogTrack(TrackLog.createBioMonitorExpLog(i2, string));
                            a(i2, string, (String) null);
                        }

                        private void a(int i2, boolean z2, int i3) {
                            if (!(i2 == 10002 || i2 == 10004)) {
                                if (i2 != 10005) {
                                    if (i2 != 10009) {
                                        if (i2 != 10010) {
                                            if (i2 == 10012) {
                                                if (z2) {
                                                    com.alibaba.security.biometrics.c.e.a(this.g);
                                                }
                                                b(i3);
                                                I();
                                                onCancel(i3);
                                                return;
                                            } else if (i2 != 10013) {
                                                switch (i2) {
                                                    case BaseBioNavigatorActivity.n:
                                                    case BaseBioNavigatorActivity.o:
                                                        break;
                                                    case BaseBioNavigatorActivity.p:
                                                        if (z2) {
                                                            m();
                                                            return;
                                                        }
                                                        return;
                                                    case 20005:
                                                    case 20007:
                                                        if (z2) {
                                                            m();
                                                            return;
                                                        }
                                                        return;
                                                    case 20006:
                                                        break;
                                                    case 20008:
                                                        if (z2) {
                                                            I();
                                                            F();
                                                            return;
                                                        }
                                                        return;
                                                    default:
                                                        return;
                                                }
                                            }
                                        }
                                    }
                                }
                                b(i3);
                                I();
                                onCancel(i3);
                                return;
                            }
                            if (z2) {
                                m();
                                return;
                            }
                            b(i3);
                            I();
                            onCancel(i3);
                        }

                        @Override // com.alibaba.security.biometrics.component.d
                        public final boolean a(int i2, KeyEvent keyEvent) {
                            boolean z2 = true;
                            if (i2 != 4) {
                                return true;
                            }
                            ALBiometricsConfig aLBiometricsConfig = this.j;
                            if (aLBiometricsConfig != null && !aLBiometricsConfig.isShouldAlertOnExit()) {
                                z2 = false;
                            }
                            a(z2);
                            return false;
                        }

                        public final void a(boolean z2) {
                            if (q() == 0) {
                                I();
                                F();
                            } else if (z2) {
                                if (M()) {
                                    e("弹出确认对话框（退出活体认证）");
                                }
                                if (this.C == null) {
                                    a.C0101a aVar = new a.C0101a(this.g);
                                    aVar.b = this.g.getResources().getString(R.string.face_dialog_exit_message);
                                    aVar.d = true;
                                    aVar.e = false;
                                    String string = this.g.getResources().getString(R.string.face_dialog_exit_button_confirm);
                                    AnonymousClass8 r1 = new a.c() {
                                        /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass8 */

                                        @Override // com.alibaba.security.biometrics.logic.view.widget.a.c
                                        public final void a(Dialog dialog) {
                                            if (dialog != null) {
                                                dialog.dismiss();
                                            }
                                            a.this.p();
                                        }
                                    };
                                    aVar.f = string;
                                    aVar.h = r1;
                                    String string2 = this.g.getResources().getString(R.string.face_dialog_exit_button_cancel);
                                    AnonymousClass7 r12 = new a.b() {
                                        /* class com.alibaba.security.biometrics.logic.a.a.AnonymousClass7 */

                                        @Override // com.alibaba.security.biometrics.logic.view.widget.a.b
                                        public final void a(Dialog dialog) {
                                            dialog.dismiss();
                                        }
                                    };
                                    aVar.i = string2;
                                    aVar.k = r12;
                                    this.C = new com.alibaba.security.biometrics.logic.view.widget.a(aVar);
                                }
                                com.alibaba.security.biometrics.logic.view.widget.a aVar2 = this.C;
                                Dialog dialog = aVar2.a;
                                if (dialog != null && !dialog.isShowing()) {
                                    aVar2.a.show();
                                }
                            } else {
                                p();
                            }
                        }

                        static /* synthetic */ void a(a aVar, boolean z2) {
                            if (!aVar.k) {
                                aVar.k = true;
                                aVar.p = GlobalErrorCode.INIT;
                                ALBiometricsEventListener aLBiometricsEventListener = aVar.l;
                                if (aLBiometricsEventListener != null) {
                                    aLBiometricsEventListener.onSensorStart();
                                }
                                aVar.d.d();
                                Point g2 = aVar.h.g();
                                if (g2 == null) {
                                    com.alibaba.security.common.c.a.d(e, "getCameraPreviewSize is null");
                                    return;
                                }
                                aVar.d.a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(g2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(g2));
                                aVar.m = 1;
                                ALBiometricsJni.bhL(2, aVar.h.f());
                                if (aVar.E.size() == 1 && aVar.E.contains(2)) {
                                    ALBiometricsParams aLBiometricsParams = aVar.q;
                                    aLBiometricsParams.actionCount = 0;
                                    aLBiometricsParams.stepAdjust = true;
                                    aVar.E.add(0, 1);
                                }
                                if (aVar.E.indexOf(2) != 0 || aVar.r == null) {
                                    aVar.g(z2);
                                } else {
                                    aVar.h(z2);
                                }
                            }
                        }
                    }
