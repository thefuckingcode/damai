package com.alibaba.security.biometrics.logic.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLSurfaceView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.activity.BaseAlBioActivity;
import com.alibaba.security.biometrics.logic.model.DazzleCollectDataUIConfigItem;
import com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView;
import com.alibaba.security.biometrics.logic.view.widget.CameraActivityWidgetParent;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget;
import com.alibaba.security.biometrics.logic.view.widget.GuideWidget;
import com.alibaba.security.biometrics.logic.view.widget.PrivacyWidget;
import com.alibaba.security.biometrics.logic.view.widget.TitleBarWidget;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsCodes;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* compiled from: Taobao */
public class ALBiometricsActivityParentView extends RelativeLayout {
    protected static final long g = 350;
    protected static final String h = "";
    protected static final String i = "guide";
    protected static final String j = "privacy";
    protected static final String k = "bio";
    protected static final String l = "result";
    private static final String p = "ALBiometricsActivityParentView";
    public CameraActivityWidgetParent a;
    public TitleBarWidget b;
    public GuideWidget c;
    public PrivacyWidget d;
    public DetectActionWidget e;
    public DetectActionResultWidget f;
    protected BaseAlBioActivity m;
    protected ALBiometricsParams n;
    protected String o = "";
    private View q;
    private String r = "";
    private a s;

    /* compiled from: Taobao */
    public interface a {
        void c(boolean z);

        void d();

        void e();

        void g();
    }

    public ALBiometricsActivityParentView(Context context, ALBiometricsParams aLBiometricsParams) {
        super(context);
        this.m = (BaseAlBioActivity) context;
        this.n = aLBiometricsParams;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rp_face_liveness_activity, this);
        this.q = inflate;
        this.a = (CameraActivityWidgetParent) inflate.findViewById(R.id.abfl_widget_camera);
        this.b = (TitleBarWidget) this.q.findViewById(R.id.widget_title_bar);
        this.e = (DetectActionWidget) this.q.findViewById(R.id.widget_abfl_detectaction);
        this.f = (DetectActionResultWidget) this.q.findViewById(R.id.widget_abfl_detectactionresult);
        this.c = (GuideWidget) this.q.findViewById(R.id.widget_abfl_guide);
        this.d = (PrivacyWidget) this.q.findViewById(R.id.widget_abfl_privacy);
        this.e.setActivity(this.m);
        this.o = "";
        this.r = "";
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rp_face_liveness_activity, this);
        this.q = inflate;
        this.a = (CameraActivityWidgetParent) inflate.findViewById(R.id.abfl_widget_camera);
        this.b = (TitleBarWidget) this.q.findViewById(R.id.widget_title_bar);
        this.e = (DetectActionWidget) this.q.findViewById(R.id.widget_abfl_detectaction);
        this.f = (DetectActionResultWidget) this.q.findViewById(R.id.widget_abfl_detectactionresult);
        this.c = (GuideWidget) this.q.findViewById(R.id.widget_abfl_guide);
        this.d = (PrivacyWidget) this.q.findViewById(R.id.widget_abfl_privacy);
        this.e.setActivity(this.m);
        this.o = "";
        this.r = "";
    }

    private void g() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.a();
        }
    }

    private void h() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.b();
        }
    }

    private void i() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.c();
        }
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.d();
        }
        GuideWidget guideWidget = this.c;
        if (guideWidget != null) {
            guideWidget.d();
        }
        PrivacyWidget privacyWidget = this.d;
        if (privacyWidget != null) {
            privacyWidget.d();
        }
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.d();
        }
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.d();
        }
    }

    private void j() {
        this.a = (CameraActivityWidgetParent) this.q.findViewById(R.id.abfl_widget_camera);
        this.b = (TitleBarWidget) this.q.findViewById(R.id.widget_title_bar);
        this.e = (DetectActionWidget) this.q.findViewById(R.id.widget_abfl_detectaction);
        this.f = (DetectActionResultWidget) this.q.findViewById(R.id.widget_abfl_detectactionresult);
        this.c = (GuideWidget) this.q.findViewById(R.id.widget_abfl_guide);
        this.d = (PrivacyWidget) this.q.findViewById(R.id.widget_abfl_privacy);
        this.e.setActivity(this.m);
    }

    private void k() {
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.c();
        }
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.b = 0;
        }
    }

    private void l() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setVisibility(0);
        }
    }

    private void m() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setVisibility(8);
        }
    }

    private void n() {
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.e();
        }
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            if (!(detectActionWidget.getVisibility() == 0)) {
                this.e.a(new String[0]);
            }
        }
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.setTitle(null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o() {
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.a(new String[0]);
        }
    }

    private void p() {
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.e();
        }
    }

    private static void q() {
    }

    private void r() {
        this.e.h();
    }

    private static boolean s() {
        return false;
    }

    private static void t() {
    }

    public String getCurrentShowView() {
        return this.o;
    }

    public int getDetectResultErrorCode() {
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            return detectActionResultWidget.getDetectResultErrorCode();
        }
        return 0;
    }

    public String getmLastShowView() {
        return this.r;
    }

    public void setALBiometricsParams(ALBiometricsParams aLBiometricsParams) {
        this.n = aLBiometricsParams;
    }

    public void setOnButtonClickListener(a aVar) {
        this.s = aVar;
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.setOnBioMainHandlerListener(aVar);
        }
        GuideWidget guideWidget = this.c;
        if (guideWidget != null) {
            guideWidget.setOnBioMainHandlerListener(aVar);
        }
        PrivacyWidget privacyWidget = this.d;
        if (privacyWidget != null) {
            privacyWidget.setOnBioMainHandlerListener(aVar);
        }
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.setOnBioMainHandlerListener(aVar);
        }
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.b.setOnCloseListener(onClickListener);
    }

    public void setOnDetectActionResultListener(com.alibaba.security.biometrics.a.a aVar) {
        this.f.setOnDetectActionResultListener(aVar);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setRenderer(renderer);
        }
    }

    private void b(final Runnable runnable) {
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.a(new RPDetectCoreView.a() {
                /* class com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.AnonymousClass3 */

                @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.a
                public final void a() {
                    runnable.run();
                }

                @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.a
                public final void b() {
                }
            });
        }
    }

    public final void c() {
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null && detectActionWidget.getVisibility() == 0) {
            this.e.j();
            o();
        }
    }

    public final void d() {
        o();
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setVisibility(0);
        }
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.e();
        }
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            if (!(detectActionWidget.getVisibility() == 0)) {
                this.e.a(new String[0]);
            }
        }
        TitleBarWidget titleBarWidget = this.b;
        if (titleBarWidget != null) {
            titleBarWidget.setTitle(null);
        }
        this.r = this.o;
        this.o = k;
    }

    public final void e() {
        DetectActionResultWidget detectActionResultWidget = this.f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.g();
        }
        this.r = this.o;
        this.o = "result";
    }

    public final boolean f() {
        return "result".equals(this.o);
    }

    public final void b() {
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.i();
            this.e.g();
            this.e.c();
        }
    }

    public final void b(String str) {
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null) {
            detectActionWidget.a(str, this.n);
        }
    }

    private void a(Runnable runnable) {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.a(runnable);
        }
    }

    private void a(boolean z) {
        RPDetectCoreView rPDetectCoreView;
        DetectActionWidget detectActionWidget = this.e;
        if (detectActionWidget != null && (rPDetectCoreView = detectActionWidget.b) != null) {
            if (z) {
                rPDetectCoreView.a();
                return;
            }
            if (rPDetectCoreView.g == null) {
                ValueAnimator duration = ValueAnimator.ofInt(100, 0).setDuration(1000L);
                rPDetectCoreView.g = duration;
                duration.setRepeatCount(-1);
                rPDetectCoreView.g.addUpdateListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002f: INVOKE  
                      (wrap: android.animation.ValueAnimator : 0x0028: IGET  (r4v6 android.animation.ValueAnimator) = (r0v1 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.g android.animation.ValueAnimator)
                      (wrap: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1 : 0x002c: CONSTRUCTOR  (r1v2 com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1) = (r0v1 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) call: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.1.<init>(com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.animation.ValueAnimator.addUpdateListener(android.animation.ValueAnimator$AnimatorUpdateListener):void in method: com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a(boolean):void, file: classes8.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002c: CONSTRUCTOR  (r1v2 com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1) = (r0v1 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) call: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.1.<init>(com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView):void type: CONSTRUCTOR in method: com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a(boolean):void, file: classes8.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 30 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 36 more
                    */
                /*
                    this = this;
                    com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget r0 = r3.e
                    if (r0 == 0) goto L_0x003a
                    com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView r0 = r0.b
                    if (r0 == 0) goto L_0x003a
                    if (r4 == 0) goto L_0x000e
                    r0.a()
                    return
                L_0x000e:
                    android.animation.ValueAnimator r4 = r0.g
                    if (r4 != 0) goto L_0x0037
                    r4 = 2
                    int[] r4 = new int[r4]
                    r4 = {x003c: FILL_ARRAY_DATA  , data: [100, 0} // fill-array
                    android.animation.ValueAnimator r4 = android.animation.ValueAnimator.ofInt(r4)
                    r1 = 1000(0x3e8, double:4.94E-321)
                    android.animation.ValueAnimator r4 = r4.setDuration(r1)
                    r0.g = r4
                    r1 = -1
                    r4.setRepeatCount(r1)
                    android.animation.ValueAnimator r4 = r0.g
                    com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1 r1 = new com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1
                    r1.<init>()
                    r4.addUpdateListener(r1)
                    android.animation.ValueAnimator r4 = r0.g
                    r4.start()
                L_0x0037:
                    r0.invalidate()
                L_0x003a:
                    return
                    fill-array 0x003c: FILL_ARRAY_DATA  , data: [100, 0]
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a(boolean):void");
            }

            public final void a(final List<DazzleCollectDataUIConfigItem> list, final com.alibaba.security.biometrics.logic.view.a.a aVar) {
                if (this.e != null && !list.isEmpty()) {
                    o();
                    final int size = list.size();
                    this.e.a(list.get(0), new DetectActionWidget.a() {
                        /* class com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.AnonymousClass1 */

                        @Override // com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.a
                        public final DazzleCollectDataUIConfigItem a(int i) {
                            if (i >= size) {
                                aVar.a();
                                return null;
                            }
                            if (i == 1) {
                                aVar.b();
                            }
                            return (DazzleCollectDataUIConfigItem) list.get(i);
                        }
                    }, 0);
                }
            }

            public final void a(int i2, String str, String str2) {
                DetectActionResultWidget detectActionResultWidget = this.f;
                if (detectActionResultWidget != null) {
                    detectActionResultWidget.a(i2, new Runnable() {
                        /* class com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.AnonymousClass2 */

                        public final void run() {
                            ALBiometricsActivityParentView.a(ALBiometricsActivityParentView.this);
                            ALBiometricsActivityParentView.this.o();
                            ALBiometricsActivityParentView.this.b();
                            ALBiometricsActivityParentView.this.e.setVisibility(8);
                            ALBiometricsActivityParentView.this.f.setVisibility(0);
                            if (ALBiometricsActivityParentView.this.d != null) {
                                ALBiometricsActivityParentView.this.d.setVisibility(8);
                            }
                            if (ALBiometricsActivityParentView.this.c != null) {
                                ALBiometricsActivityParentView.this.c.setVisibility(8);
                            }
                        }
                    }, this.n, str2, str);
                }
                this.r = this.o;
                this.o = "result";
            }

            public final void a(int i2, int i3) {
                if (this.a != null) {
                    this.a.a(i2, i3, this.e.getMaskCircleDisplayY(), this.n.cameraPreviewSizeSwitch);
                }
            }

            public final void a(String str) {
                GuideWidget guideWidget = this.c;
                if (guideWidget != null) {
                    guideWidget.a(str);
                }
                o();
                this.b.setTitle(getContext().getString(R.string.rp_guide_title));
                this.r = this.o;
                this.o = "guide";
            }

            public final void a() {
                if (this.c != null) {
                    this.d.a(new String[0]);
                }
                o();
                this.b.setTitle(getContext().getString(R.string.rp_privacy_title));
                this.r = this.o;
                this.o = j;
            }

            public final void a(int i2) {
                String str;
                if (this.e != null) {
                    Resources resources = getContext().getResources();
                    if (i2 == -10219) {
                        str = resources.getString(R.string.face_liveness_action_fail_tip_common);
                    } else if (i2 == 1004) {
                        str = resources.getString(R.string.face_detect_toast_too_shake);
                    } else if (i2 == 1013) {
                        str = resources.getString(R.string.face_detect_toast_pitch_angle_not_suitable);
                    } else if (i2 == 1060) {
                        str = resources.getString(R.string.face_liveness_env_too_bright);
                    } else if (i2 == 1001) {
                        str = resources.getString(R.string.face_detect_toast_too_dark);
                    } else if (i2 != 1002) {
                        switch (i2) {
                            case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION:
                                str = resources.getString(R.string.face_liveness_action_fail_tip_occlusion);
                                break;
                            case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_FACE:
                                str = resources.getString(R.string.face_liveness_action_fail_tip_face_error);
                                break;
                            case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_ACTION:
                                str = resources.getString(R.string.face_liveness_action_fail_tip_action_wrong);
                                break;
                            default:
                                switch (i2) {
                                    case 1006:
                                        str = resources.getString(R.string.face_detect_toast_no_dectect_action);
                                        break;
                                    case 1007:
                                        str = resources.getString(R.string.face_detect_toast_too_close);
                                        break;
                                    case 1008:
                                        str = resources.getString(R.string.face_detect_toast_too_far);
                                        break;
                                    default:
                                        switch (i2) {
                                            case ALBiometricsCodes.TIP_ACTION_TOO_SMALL:
                                                str = resources.getString(R.string.face_detect_toast_action_too_small);
                                                break;
                                            case ALBiometricsCodes.TIP_RAISE_PHONE:
                                                str = resources.getString(R.string.face_detect_toast_raise_phone);
                                                break;
                                            case ALBiometricsCodes.TIP_FACE_LIGHT:
                                                str = resources.getString(R.string.face_detect_toast_face_light);
                                                break;
                                            default:
                                                str = "";
                                                break;
                                        }
                                }
                        }
                    } else {
                        str = resources.getString(R.string.face_detect_toast_not_in_region);
                    }
                    this.e.f(str);
                }
            }

            public final void a(ABDetectType aBDetectType) {
                DetectActionWidget detectActionWidget = this.e;
                if (detectActionWidget != null) {
                    detectActionWidget.setVisibility(0);
                    this.e.a(aBDetectType, this.n);
                }
            }

            static /* synthetic */ void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
                CameraActivityWidgetParent cameraActivityWidgetParent = aLBiometricsActivityParentView.a;
                if (cameraActivityWidgetParent != null) {
                    cameraActivityWidgetParent.setVisibility(8);
                }
            }
        }
