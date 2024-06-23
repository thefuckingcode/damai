package com.alibaba.security.biometrics.logic.view.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.c.b;
import com.alibaba.security.biometrics.logic.model.DazzleCollectDataUIConfigItem;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.skin.model.DetectAnimSkinData;
import com.alibaba.security.common.d.d;
import com.alibaba.security.common.view.GifImageView;

/* compiled from: Taobao */
public class DetectActionWidget extends BaseWidget {
    private static final String c = "DetectActionWidget";
    private static final long d = 500;
    private static final long e = 1000;
    private static final int f = 1;
    private static final int g = 2;
    private static final int h = 3;
    public RPDetectCoreView b;
    private TextView i;
    private TextView j;
    private LinearLayout k;
    private GifImageView l;
    private ImageView m;
    private View n;
    private TextView o;
    private Handler p;
    private Activity q;
    private long r;

    /* compiled from: Taobao */
    public interface a {
        DazzleCollectDataUIConfigItem a(int i);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b extends Handler {
        private final DetectActionWidget a;

        public b(DetectActionWidget detectActionWidget) {
            super(Looper.getMainLooper());
            this.a = detectActionWidget;
        }

        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                DetectActionWidget.b(this.a);
            } else if (i == 2) {
                DetectActionWidget.a(this.a, message);
            } else if (i == 3) {
                this.a.r = 0;
            }
        }
    }

    public DetectActionWidget(Context context) {
        super(context);
        k();
    }

    private void k() {
        this.p = new b(this);
    }

    private void l() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams.setMargins(0, this.b.getCircleBottom() + d.a(getContext(), 80.0f), 0, 0);
        this.l.setLayoutParams(layoutParams);
        this.l.requestLayout();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams2.setMargins(0, this.b.getCircleBottom() + d.a(getContext(), 78.0f), 0, 0);
        this.m.setLayoutParams(layoutParams2);
        this.m.requestLayout();
    }

    private void m() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.setMargins(0, this.b.getCircleBottom() + d.a(getContext(), 20.0f), 0, 0);
        this.i.setLayoutParams(layoutParams);
        this.i.requestLayout();
    }

    private void n() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        int radius = this.b.getRadius();
        layoutParams.height = radius * 2;
        layoutParams.topMargin = this.b.getCircleCenterY() - radius;
        this.o.setLayoutParams(layoutParams);
        this.o.requestLayout();
    }

    private void o() {
        this.r = 0;
    }

    private void p() {
        ALBiometricsActivityParentView.a aVar = this.a;
        if (aVar != null) {
            aVar.g();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void b() {
        b.a(this.i, d("actionTipText"));
        b.a(this.j, d("messageText"));
        DetectAnimSkinData e2 = e("detectAnimation");
        if (e2 != null) {
            this.b.setBreatheColor(com.alibaba.security.biometrics.c.d.a(e2.getWarningColor(), SupportMenu.CATEGORY_MASK));
            this.b.setWaitingColor(com.alibaba.security.biometrics.c.d.a(e2.getLoadingColor(), -16776961));
            return;
        }
        this.b.setBreatheColor(SupportMenu.CATEGORY_MASK);
        this.b.setWaitingColor(-16776961);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
        g();
        this.o.setVisibility(8);
        this.b.b();
        this.p.removeCallbacksAndMessages(null);
    }

    public final void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            b();
            b.a(this.i, d("actionTipText"));
            this.p.removeMessages(1);
            this.p.sendEmptyMessageDelayed(1, 1000);
            if (System.currentTimeMillis() - this.r >= 500) {
                this.i.setText(str);
                this.r = System.currentTimeMillis();
            }
        }
    }

    public final void g() {
        this.l.setVisibility(8);
        this.m.setVisibility(8);
    }

    public int getMaskCircleDisplayY() {
        return this.b.getCircleCenterY();
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public String getSkinParentKey() {
        return "detectPage";
    }

    public final void h() {
        com.alibaba.security.common.c.a.d(c, "stopDazzleCollectView");
        this.p.removeMessages(2);
        this.b.setBackgroundColor(-1);
        this.b.invalidate();
    }

    public final void i() {
        this.i.setText("");
        this.i.setVisibility(4);
    }

    public final void j() {
        b();
        this.k.setVisibility(4);
        this.i.setVisibility(4);
        this.o.setVisibility(0);
        RPDetectCoreView rPDetectCoreView = this.b;
        if (rPDetectCoreView.h == null) {
            ValueAnimator duration = ValueAnimator.ofInt(0, 360).setDuration(2000L);
            rPDetectCoreView.h = duration;
            duration.setRepeatCount(-1);
            rPDetectCoreView.h.addUpdateListener(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0037: INVOKE  
                  (wrap: android.animation.ValueAnimator : 0x0030: IGET  (r1v7 android.animation.ValueAnimator) = (r0v3 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.h android.animation.ValueAnimator)
                  (wrap: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$2 : 0x0034: CONSTRUCTOR  (r2v2 com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$2) = (r0v3 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) call: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.2.<init>(com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.animation.ValueAnimator.addUpdateListener(android.animation.ValueAnimator$AnimatorUpdateListener):void in method: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.j():void, file: classes8.dex
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
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0034: CONSTRUCTOR  (r2v2 com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$2) = (r0v3 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) call: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.2.<init>(com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView):void type: CONSTRUCTOR in method: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.j():void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 21 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 27 more
                */
            /*
                this = this;
                r4.b()
                android.widget.LinearLayout r0 = r4.k
                r1 = 4
                r0.setVisibility(r1)
                android.widget.TextView r0 = r4.i
                r0.setVisibility(r1)
                android.widget.TextView r0 = r4.o
                r1 = 0
                r0.setVisibility(r1)
                com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView r0 = r4.b
                android.animation.ValueAnimator r1 = r0.h
                if (r1 != 0) goto L_0x003f
                r1 = 2
                int[] r1 = new int[r1]
                r1 = {x0040: FILL_ARRAY_DATA  , data: [0, 360} // fill-array
                android.animation.ValueAnimator r1 = android.animation.ValueAnimator.ofInt(r1)
                r2 = 2000(0x7d0, double:9.88E-321)
                android.animation.ValueAnimator r1 = r1.setDuration(r2)
                r0.h = r1
                r2 = -1
                r1.setRepeatCount(r2)
                android.animation.ValueAnimator r1 = r0.h
                com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$2 r2 = new com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$2
                r2.<init>()
                r1.addUpdateListener(r2)
                android.animation.ValueAnimator r0 = r0.h
                r0.start()
            L_0x003f:
                return
                fill-array 0x0040: FILL_ARRAY_DATA  , data: [0, 360]
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.j():void");
        }

        public void setActivity(Activity activity) {
            this.q = activity;
        }

        /* access modifiers changed from: protected */
        @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
        public final void a() {
            this.l = (GifImageView) findViewById(R.id.abfl_widget_da_actionGuidance_image);
            this.m = (ImageView) findViewById(R.id.abfl_widget_da_actionGuidance_anim_image);
            this.i = (TextView) findViewById(R.id.abfl_widget_da_mainPrompt);
            this.j = (TextView) findViewById(R.id.widget_da_self_name);
            this.k = (LinearLayout) findViewById(R.id.widget_da_self_name_parent);
            this.n = findViewById(R.id.abfl_widget_da_maskview_blurview);
            this.b = (RPDetectCoreView) findViewById(R.id.abfl_widget_da_maskview);
            this.o = (TextView) findViewById(R.id.abfl_waiting_tip);
        }

        public DetectActionWidget(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            k();
        }

        private void g(String str) {
            this.r = 0;
            b.a(this.i, d("actionTipText"));
            this.p.removeMessages(1);
            this.i.setText(str);
            this.i.setVisibility(0);
        }

        public DetectActionWidget(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            k();
        }

        private void h(String str) {
            b.a(this.i, d("actionTipText"));
            this.p.removeMessages(1);
            this.p.sendEmptyMessageDelayed(1, 1000);
            if (System.currentTimeMillis() - this.r >= 500) {
                this.i.setText(str);
                this.r = System.currentTimeMillis();
            }
        }

        static /* synthetic */ void b(DetectActionWidget detectActionWidget) {
            ALBiometricsActivityParentView.a aVar = detectActionWidget.a;
            if (aVar != null) {
                aVar.g();
            }
        }

        private void a(int i2) {
            this.m.setVisibility(0);
            this.m.setImageDrawable(getResources().getDrawable(i2));
            ((AnimationDrawable) this.m.getDrawable()).start();
        }

        public final void a(String str, ALBiometricsParams aLBiometricsParams) {
            b();
            g(str);
            String str2 = aLBiometricsParams.userName;
            if (!TextUtils.isEmpty(str2)) {
                b.a(this.j, d("messageText"));
                this.k.setVisibility(0);
                this.j.setText(str2);
                return;
            }
            this.k.setVisibility(8);
        }

        public final void a(DazzleCollectDataUIConfigItem dazzleCollectDataUIConfigItem, a aVar, int i2) {
            g(dazzleCollectDataUIConfigItem.getTitle());
            this.k.setVisibility(4);
            try {
                this.i.setTextColor(Color.parseColor(dazzleCollectDataUIConfigItem.getTextColor()));
            } catch (Exception unused) {
                this.i.setTextColor(getContext().getResources().getColor(R.color.rpsdk_color_333333));
            }
            try {
                this.b.setBackgroundColor(Color.parseColor(dazzleCollectDataUIConfigItem.getColor()));
            } catch (Exception unused2) {
                this.b.setBackgroundColor(-1);
            }
            dazzleCollectDataUIConfigItem.setTimeInterval(System.currentTimeMillis());
            d.a(this.q, (int) (dazzleCollectDataUIConfigItem.getScreenLight() * 255.0f));
            if (dazzleCollectDataUIConfigItem.getDuration() <= 0.0f) {
                a(aVar, i2);
                return;
            }
            long duration = (long) (dazzleCollectDataUIConfigItem.getDuration() * 1000.0f);
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = i2;
            obtain.obj = aVar;
            this.p.sendMessageDelayed(obtain, duration);
        }

        private void a(a aVar, int i2) {
            int i3 = i2 + 1;
            DazzleCollectDataUIConfigItem a2 = aVar.a(i3);
            if (a2 != null) {
                a(a2, aVar, i3);
            }
        }

        public final void a(final RPDetectCoreView.a aVar) {
            b();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.setMargins(0, this.b.getCircleBottom() + d.a(getContext(), 20.0f), 0, 0);
            this.i.setLayoutParams(layoutParams);
            this.i.requestLayout();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams2.setMargins(0, this.b.getCircleBottom() + d.a(getContext(), 80.0f), 0, 0);
            this.l.setLayoutParams(layoutParams2);
            this.l.requestLayout();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams3.setMargins(0, this.b.getCircleBottom() + d.a(getContext(), 78.0f), 0, 0);
            this.m.setLayoutParams(layoutParams3);
            this.m.requestLayout();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            int radius = this.b.getRadius();
            layoutParams4.height = radius * 2;
            layoutParams4.topMargin = this.b.getCircleCenterY() - radius;
            this.o.setLayoutParams(layoutParams4);
            this.o.requestLayout();
            setVisibility(0);
            this.n.setVisibility(0);
            RPDetectCoreView rPDetectCoreView = this.b;
            AnonymousClass1 r1 = new RPDetectCoreView.a() {
                /* class com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.AnonymousClass1 */

                @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.a
                public final void a() {
                    RPDetectCoreView.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a();
                    }
                }

                @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.a
                public final void b() {
                    RPDetectCoreView.a aVar = aVar;
                    if (aVar != null) {
                        aVar.b();
                    }
                    DetectActionWidget.this.n.setVisibility(8);
                }
            };
            rPDetectCoreView.d = 2.5f;
            rPDetectCoreView.e = 1.0f;
            rPDetectCoreView.c = 350;
            rPDetectCoreView.a = r1;
            rPDetectCoreView.f = false;
            rPDetectCoreView.b = SystemClock.uptimeMillis();
            rPDetectCoreView.invalidate();
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        public final void a(ABDetectType aBDetectType, ALBiometricsParams aLBiometricsParams) {
            int i2;
            b();
            String str = "";
            if (aBDetectType != null) {
                switch (b.AnonymousClass1.a[aBDetectType.ordinal()]) {
                    case 1:
                    case 2:
                        str = getResources().getString(R.string.face_detect_action_blink);
                        break;
                    case 3:
                    case 4:
                        str = getResources().getString(R.string.face_detect_action_mounth);
                        break;
                    case 5:
                    case 6:
                        str = getResources().getString(R.string.face_detect_action_raise_head);
                        break;
                    case 7:
                        str = getResources().getString(R.string.face_detect_action_pitch_down_head);
                        break;
                    case 8:
                        str = getResources().getString(R.string.face_detect_action_turn_right);
                        break;
                    case 9:
                        str = getResources().getString(R.string.face_detect_action_turn_left);
                        break;
                    case 10:
                    case 11:
                        str = getResources().getString(R.string.face_detect_action_turn_right_or_left);
                        break;
                }
            }
            a(str, aLBiometricsParams);
            if (aBDetectType != null) {
                switch (b.AnonymousClass1.a[aBDetectType.ordinal()]) {
                    case 1:
                    case 2:
                        i2 = R.drawable.rp_face_guide_blink_anim;
                        break;
                    case 3:
                    case 4:
                        i2 = R.drawable.rp_face_guide_mouth_anim;
                        break;
                    case 5:
                    case 6:
                    case 7:
                        i2 = R.drawable.rp_face_guide_pitch_anim;
                        break;
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        i2 = R.drawable.rp_face_guide_yaw_anim;
                        break;
                }
                if (i2 <= 0) {
                    this.m.setVisibility(0);
                    this.m.setImageDrawable(getResources().getDrawable(i2));
                    ((AnimationDrawable) this.m.getDrawable()).start();
                    return;
                }
                return;
            }
            i2 = -1;
            if (i2 <= 0) {
            }
        }

        private void a(boolean z) {
            RPDetectCoreView rPDetectCoreView = this.b;
            if (rPDetectCoreView != null) {
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
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002c: INVOKE  
                          (wrap: android.animation.ValueAnimator : 0x0025: IGET  (r4v6 android.animation.ValueAnimator) = (r0v0 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.g android.animation.ValueAnimator)
                          (wrap: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1 : 0x0029: CONSTRUCTOR  (r1v2 com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1) = (r0v0 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) call: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.1.<init>(com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView):void type: CONSTRUCTOR)
                         type: VIRTUAL call: android.animation.ValueAnimator.addUpdateListener(android.animation.ValueAnimator$AnimatorUpdateListener):void in method: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.a(boolean):void, file: classes8.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0029: CONSTRUCTOR  (r1v2 com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView$1) = (r0v0 'rPDetectCoreView' com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView) call: com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.1.<init>(com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView):void type: CONSTRUCTOR in method: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.a(boolean):void, file: classes8.dex
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
                        com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView r0 = r3.b
                        if (r0 != 0) goto L_0x0005
                        return
                    L_0x0005:
                        if (r4 == 0) goto L_0x000b
                        r0.a()
                        return
                    L_0x000b:
                        android.animation.ValueAnimator r4 = r0.g
                        if (r4 != 0) goto L_0x0034
                        r4 = 2
                        int[] r4 = new int[r4]
                        r4 = {x0038: FILL_ARRAY_DATA  , data: [100, 0} // fill-array
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
                    L_0x0034:
                        r0.invalidate()
                        return
                        fill-array 0x0038: FILL_ARRAY_DATA  , data: [100, 0]
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.a(boolean):void");
                }

                private void a(Message message) {
                    a((a) message.obj, message.arg1);
                }

                static /* synthetic */ void a(DetectActionWidget detectActionWidget, Message message) {
                    detectActionWidget.a((a) message.obj, message.arg1);
                }
            }
