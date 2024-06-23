package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.a.a;
import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.alibaba.security.biometrics.c.c;
import com.alibaba.security.biometrics.c.d;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ALBiometricsType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.skin.model.TextViewSkinData;

/* compiled from: Taobao */
public class DetectActionResultWidget extends BaseWidget {
    private static final String c = "DetectActionResultWidget";
    public int b = 0;
    private ImageView d;
    private TextView e;
    private TextView f;
    private Button g;
    private Button h;
    private a i;

    public DetectActionResultWidget(Context context) {
        super(context);
    }

    private void h() {
        this.b = 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void b() {
        b.a(this.g, c("mainButton"));
        b.a(this.e, d("titleText"));
        b.a(this.f, d("messageText"));
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
        this.b = 0;
    }

    public final void g() {
        b();
        b.a(this.d, a("promptSucceedImageView"), R.drawable.rp_face_result_icon_ok);
        this.e.setText(R.string.face_liveness_success);
        this.f.setVisibility(4);
        this.g.setVisibility(4);
        this.h.setVisibility(4);
        setVisibility(0);
        setAlpha(1.0f);
    }

    public int getDetectResultErrorCode() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public String getSkinParentKey() {
        return "resultPage";
    }

    public void setOnDetectActionResultListener(a aVar) {
        this.i = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void a() {
        this.b = -1;
        this.d = (ImageView) findViewById(R.id.abfl_widget_dar_icon);
        this.e = (TextView) findViewById(R.id.abfl_widget_dar_title);
        this.f = (TextView) findViewById(R.id.abfl_widget_dar_content);
        this.g = (Button) findViewById(R.id.abfl_widget_dar_btn);
        this.h = (Button) findViewById(R.id.abfl_widget_dar_other_btn);
    }

    public DetectActionResultWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DetectActionResultWidget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private void a(final int i2, String str, CharSequence charSequence, String str2, boolean z, final int i3) {
        b();
        if (i3 == 0) {
            b.a(this.d, a("promptSucceedImageView"), R.drawable.rp_face_result_icon_ok);
        } else {
            b.a(this.d, a("promptFailImageView"), R.drawable.rp_face_result_icon_fail);
        }
        this.e.setText(str);
        this.g.setText(str2);
        this.g.setVisibility(0);
        try {
            if (Build.VERSION.SDK_INT < 11) {
                setVisibility(0);
                setAlpha(1.0f);
            } else {
                c.AnonymousClass1 r5 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0041: CONSTRUCTOR  (r5v9 'r5' com.alibaba.security.biometrics.c.c$1) = (r3v0 'this' com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget A[IMMUTABLE_TYPE, THIS]) call: com.alibaba.security.biometrics.c.c.1.<init>(android.view.View):void type: CONSTRUCTOR in method: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.a(int, java.lang.String, java.lang.CharSequence, java.lang.String, boolean, int):void, file: classes8.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.alibaba.security.biometrics.c.c, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 24 more
                    */
                /*
                // Method dump skipped, instructions count: 154
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.a(int, java.lang.String, java.lang.CharSequence, java.lang.String, boolean, int):void");
            }

            public final void a(final int i2, final Runnable runnable, final ALBiometricsParams aLBiometricsParams, String str, final String str2) {
                b();
                a aVar = this.i;
                if (aVar != null) {
                    aVar.onBeforeRetry(new OnRetryListener() {
                        /* class com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.AnonymousClass3 */

                        @Override // com.alibaba.security.biometrics.service.listener.OnRetryListener
                        public final void onRetry(int i) {
                            int i2 = i2;
                            if (i != 0) {
                                i2 = GlobalErrorCode.ERROR_BUSINESS_RETRY_REACH_THRESHOLD;
                            }
                            DetectActionResultWidget.a(DetectActionResultWidget.this, i2, runnable, aLBiometricsParams, str2);
                        }
                    }, str);
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r6v18, resolved type: android.text.SpannableString */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x043e  */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x04b2  */
            /* JADX WARNING: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:75:0x02e6  */
            private void a(int i2, Runnable runnable, ALBiometricsParams aLBiometricsParams, String str) {
                int i3;
                int i4;
                String str2;
                String str3;
                String str4;
                String string;
                String string2;
                String string3;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                ForegroundColorSpan foregroundColorSpan;
                AbsoluteSizeSpan absoluteSizeSpan;
                ForegroundColorSpan foregroundColorSpan2;
                AbsoluteSizeSpan absoluteSizeSpan2;
                ForegroundColorSpan foregroundColorSpan3;
                AbsoluteSizeSpan absoluteSizeSpan3;
                String str10;
                String str11;
                String str12;
                runnable.run();
                this.b = i2;
                Resources resources = getContext().getResources();
                int i5 = R.string.face_detect_dialog_btn_retry;
                resources.getString(i5);
                if (i2 != -10217) {
                    if (i2 != 0) {
                        if (!(i2 == 3001 || i2 == 3206 || i2 == 3208 || i2 == 3203 || i2 == 3204)) {
                            switch (i2) {
                                case GlobalErrorCode.ERROR_INNER_MORTAL:
                                    str5 = resources.getString(R.string.face_detect_dialog_algorithm_init_error);
                                    str6 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                    i4 = i2;
                                    str2 = str6;
                                    str4 = str5;
                                    str3 = "";
                                    i3 = 10010;
                                    break;
                                case GlobalErrorCode.ERROR_BUSINESS_RETRY_REACH_THRESHOLD:
                                    str7 = resources.getString(R.string.face_liveness_business_reach_retry_threshold_1);
                                    str8 = resources.getString(R.string.face_liveness_ok);
                                    i4 = i2;
                                    str2 = str8;
                                    str4 = str7;
                                    str3 = "";
                                    i3 = BaseBioNavigatorActivity.o;
                                    break;
                                case GlobalErrorCode.ERROR_DETECT_INTERRUPT:
                                    String string4 = resources.getString(R.string.face_detect_dialog_interrupt_error);
                                    i4 = i2;
                                    str2 = resources.getString(i5);
                                    str4 = string4;
                                    str3 = "";
                                    i3 = 10004;
                                    break;
                                case GlobalErrorCode.ERROR_USER_RETRY_LIMITED:
                                    str7 = resources.getString(R.string.face_liveness_reach_retry_threshold);
                                    str8 = resources.getString(R.string.face_liveness_retry);
                                    i4 = i2;
                                    str2 = str8;
                                    str4 = str7;
                                    str3 = "";
                                    i3 = BaseBioNavigatorActivity.o;
                                    break;
                                default:
                                    switch (i2) {
                                        case GlobalErrorCode.ERROR_UPLOAD_BIO_DATA:
                                        case GlobalErrorCode.ERROR_VERIFY_BIO_DATA:
                                            string = resources.getString(R.string.face_liveness_recognize_fail);
                                            if (!TextUtils.isEmpty(aLBiometricsParams.userName)) {
                                                String str13 = "请确保是" + aLBiometricsParams.userName + "本人操作，" + resources.getString(R.string.face_liveness_recognize_fail_hint);
                                                SpannableString spannableString = new SpannableString(str13);
                                                TextViewSkinData d2 = d("messageText");
                                                String str14 = "#333333";
                                                if (d2 != null) {
                                                    foregroundColorSpan2 = new ForegroundColorSpan(d.a(TextUtils.isEmpty(d2.getTextColor()) ? str14 : d2.getTextColor(), -7829368));
                                                    absoluteSizeSpan = new AbsoluteSizeSpan(d2.getFontSize());
                                                    if (!TextUtils.isEmpty(d2.getTextColor())) {
                                                        str14 = d2.getTextColor();
                                                    }
                                                    foregroundColorSpan = new ForegroundColorSpan(d.a(str14, -7829368));
                                                    absoluteSizeSpan2 = new AbsoluteSizeSpan(d2.getFontSize());
                                                } else {
                                                    foregroundColorSpan2 = new ForegroundColorSpan(d.a(str14, -7829368));
                                                    absoluteSizeSpan = new AbsoluteSizeSpan(28);
                                                    foregroundColorSpan = new ForegroundColorSpan(d.a(str14, -7829368));
                                                    absoluteSizeSpan2 = new AbsoluteSizeSpan(28);
                                                }
                                                spannableString.setSpan(foregroundColorSpan2, 0, 4, 33);
                                                spannableString.setSpan(absoluteSizeSpan, 0, 4, 33);
                                                spannableString.setSpan(foregroundColorSpan, aLBiometricsParams.userName.length() + 4, str13.length(), 33);
                                                spannableString.setSpan(absoluteSizeSpan2, aLBiometricsParams.userName.length() + 4, str13.length(), 33);
                                                TextViewSkinData d3 = d("markMessageText");
                                                String str15 = "#E76057";
                                                if (d3 != null) {
                                                    if (!TextUtils.isEmpty(d3.getTextColor())) {
                                                        str15 = d3.getTextColor();
                                                    }
                                                    foregroundColorSpan3 = new ForegroundColorSpan(d.a(str15, -7829368));
                                                    absoluteSizeSpan3 = new AbsoluteSizeSpan(d3.getFontSize());
                                                } else {
                                                    foregroundColorSpan3 = new ForegroundColorSpan(d.a(str15, -7829368));
                                                    absoluteSizeSpan3 = new AbsoluteSizeSpan(28);
                                                }
                                                spannableString.setSpan(foregroundColorSpan3, 4, aLBiometricsParams.userName.length() + 4, 33);
                                                spannableString.setSpan(absoluteSizeSpan3, 4, aLBiometricsParams.userName.length() + 4, 33);
                                                str9 = spannableString;
                                            } else {
                                                str9 = resources.getString(R.string.face_liveness_recognize_fail_msg);
                                            }
                                            string3 = resources.getString(i5);
                                            i4 = i2;
                                            str3 = str9;
                                            i3 = BaseBioNavigatorActivity.p;
                                            break;
                                        case GlobalErrorCode.ERROR_UPLOAD_BIO_PIC_ERROR:
                                        case GlobalErrorCode.ERROR_ONLINE_NET_ERROR:
                                            string = resources.getString(R.string.face_liveness_file_upload_fail);
                                            str9 = resources.getString(R.string.face_liveness_upload_fail_msg);
                                            string3 = resources.getString(i5);
                                            i4 = i2;
                                            str3 = str9;
                                            i3 = BaseBioNavigatorActivity.p;
                                            break;
                                        default:
                                            switch (i2) {
                                                case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION:
                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                    str10 = resources.getString(R.string.face_liveness_action_fail_tip_occlusion);
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = str10;
                                                    i3 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_FACE:
                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                    str10 = resources.getString(R.string.face_liveness_action_fail_tip_face_error);
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = str10;
                                                    i3 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_ACTION:
                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                    str10 = resources.getString(R.string.face_liveness_action_fail_tip_action_wrong);
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = str10;
                                                    i3 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE:
                                                    String string5 = resources.getString(R.string.face_detect_dialog_quality_not_enough_error);
                                                    i4 = i2;
                                                    str2 = resources.getString(i5);
                                                    str4 = string5;
                                                    str3 = "";
                                                    i3 = 10009;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_REFLECT_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_REFLECT_NO_FACE:
                                                    string = resources.getString(R.string.face_detect_reflect_fail);
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = "";
                                                    i3 = 20005;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_RECAP_FAIL:
                                                    string = resources.getString(R.string.face_detect_recap_fail);
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = "";
                                                    i3 = 20005;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_ONLINE_RECOGNIZE_ERROR:
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_MODEL_COPY_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_DETECTING_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_CONFIG_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_INIT_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_SO_LOAD_FAIL:
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_MUCH_MINE:
                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                    if (ABDetectContext.getInstance().getLastDetectFailedType() == 0) {
                                                        str10 = resources.getString(R.string.face_liveness_action_fail_tip_action_wrong);
                                                    } else if (ABDetectContext.getInstance().getLastDetectFailedType() == 1) {
                                                        str10 = resources.getString(R.string.face_liveness_action_fail_tip_face_error);
                                                    } else if (ABDetectContext.getInstance().getLastDetectFailedType() == 6) {
                                                        str10 = resources.getString(R.string.face_liveness_action_fail_tip_occlusion);
                                                    } else {
                                                        str10 = resources.getString(R.string.face_liveness_action_fail_tip_common);
                                                    }
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = str10;
                                                    i3 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_TIMEOUT_ADJUST:
                                                case GlobalErrorCode.ERROR_ALGO_TIMEOUT_ACTION:
                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                    string2 = resources.getString(R.string.face_liveness_action_fail_msg_timeout);
                                                    string3 = resources.getString(i5);
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case GlobalErrorCode.ERROR_DEVICE_HW_MAGIC_WINDOW:
                                                            String string6 = resources.getString(R.string.face_detect_camera_is_huawei_magic_window_title);
                                                            String string7 = resources.getString(R.string.face_detect_camera_is_huawei_magic_window_text);
                                                            i4 = i2;
                                                            i3 = 10005;
                                                            str2 = resources.getString(R.string.face_detect_top_back_text);
                                                            str4 = string6;
                                                            str3 = string7;
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_CAMERA_DATA_FAIL:
                                                            str5 = resources.getString(R.string.face_detect_dialog_preview_frame_error);
                                                            str6 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                            i4 = i2;
                                                            str2 = str6;
                                                            str4 = str5;
                                                            str3 = "";
                                                            i3 = 10010;
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_X86:
                                                        case GlobalErrorCode.ERROR_DEVICE_CPU_NOT_SUPPORT:
                                                        case GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_NEON:
                                                            String string8 = resources.getString(R.string.face_detect_camera_configuration_cpu_low_title);
                                                            i4 = i2;
                                                            str2 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                            str4 = string8;
                                                            str3 = "";
                                                            i3 = 10005;
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_CAMERA_NO_PERMISSION:
                                                        case GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT:
                                                            string = resources.getString(R.string.face_detect_camera_no_permission_title);
                                                            String string9 = resources.getString(R.string.face_detect_camera_open_permission_text);
                                                            string3 = resources.getString(R.string.face_detect_alert_dialog_msg_ok_text);
                                                            i4 = i2;
                                                            str3 = string9;
                                                            i3 = 10012;
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_NO_CAMERA:
                                                            string = resources.getString(R.string.face_detect_camera_configuration_nofront_title);
                                                            string3 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                            i4 = i2;
                                                            str3 = "";
                                                            i3 = 10013;
                                                            break;
                                                        default:
                                                            switch (i2) {
                                                                case 2:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    if (!TextUtils.isEmpty(str)) {
                                                                        str9 = str;
                                                                    } else {
                                                                        str9 = resources.getString(R.string.face_detect_verify_not_pass);
                                                                    }
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 3:
                                                                case 4:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_id_blur);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 5:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_id_expired);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 6:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_face_id_inconsistent);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 7:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_face_inconsistent_with_security);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 8:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_invalid_id_photo);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 9:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_not_account_self);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 10:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_not_same_person);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 11:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_abuse_security_photo);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 12:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_security_abnormal);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                default:
                                                                    switch (i2) {
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3101:
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3102:
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3103:
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3104:
                                                                            break;
                                                                        default:
                                                                            switch (i2) {
                                                                                case 4001:
                                                                                    str11 = resources.getString(R.string.rp_ctid_sys_error_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case 4002:
                                                                                    str11 = resources.getString(R.string.rp_ctid_not_install_title);
                                                                                    str3 = resources.getString(R.string.rp_ctid_not_install_msg);
                                                                                    str2 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case 4003:
                                                                                    str11 = resources.getString(R.string.rp_ctid_not_login_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case 4004:
                                                                                    str11 = resources.getString(R.string.rp_ctid_unregister_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_NO_CERT:
                                                                                    str11 = resources.getString(R.string.rp_ctid_no_cert_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_NOT_BINDING:
                                                                                    str11 = resources.getString(R.string.rp_ctid_no_binding_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_APP_ERROR:
                                                                                    str11 = resources.getString(R.string.rp_ctid_app_sys_error_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_DATA_ERROR:
                                                                                    str11 = resources.getString(R.string.rp_ctid_app_data_error_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                default:
                                                                                    string = resources.getString(R.string.face_liveness_recognize_fail);
                                                                                    str9 = resources.getString(R.string.face_detect_unkonwn_error);
                                                                                    string3 = resources.getString(i5);
                                                                                    i4 = i2;
                                                                                    str3 = str9;
                                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                                    break;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                            if (TextUtils.isEmpty(str4)) {
                                a(i3, str4, str3, str2, aLBiometricsParams.showOtherButton, i4);
                                return;
                            }
                            return;
                        }
                        string = resources.getString(R.string.face_liveness_action_fail);
                        string3 = resources.getString(i5);
                        str3 = str;
                        i4 = i2;
                        i3 = BaseBioNavigatorActivity.p;
                    } else {
                        string = resources.getString(R.string.face_liveness_success);
                        String string10 = resources.getString(R.string.rp_thanks_for_your_use);
                        string3 = resources.getString(R.string.face_detect_top_back_text);
                        i4 = i2;
                        str3 = string10;
                        i3 = 20008;
                    }
                    str2 = string3;
                    str4 = string;
                    if (TextUtils.isEmpty(str4)) {
                    }
                } else if (ALBiometricsType.isDazzle(aLBiometricsParams.mBiometricsType)) {
                    string = resources.getString(R.string.face_liveness_action_fail);
                    string2 = resources.getString(R.string.face_liveness_action_fail_msg_timeout);
                    string3 = resources.getString(i5);
                } else {
                    String string11 = resources.getString(R.string.face_liveness_action_fail);
                    String string12 = resources.getString(R.string.face_detect_alert_dialog_msg_timeout);
                    str2 = resources.getString(i5);
                    str4 = string11;
                    str3 = string12;
                    i3 = 20007;
                    i4 = i2;
                    if (TextUtils.isEmpty(str4)) {
                    }
                }
                str3 = string2;
                i3 = 10002;
                i4 = i2;
                str2 = string3;
                str4 = string;
                if (TextUtils.isEmpty(str4)) {
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r6v18, resolved type: android.text.SpannableString */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x043b  */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x04af  */
            /* JADX WARNING: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:75:0x02e3  */
            private void a(int i2, ALBiometricsParams aLBiometricsParams, String str) {
                int i3;
                int i4;
                String str2;
                String str3;
                String str4;
                String string;
                String string2;
                String string3;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                ForegroundColorSpan foregroundColorSpan;
                AbsoluteSizeSpan absoluteSizeSpan;
                ForegroundColorSpan foregroundColorSpan2;
                AbsoluteSizeSpan absoluteSizeSpan2;
                ForegroundColorSpan foregroundColorSpan3;
                AbsoluteSizeSpan absoluteSizeSpan3;
                String str10;
                String str11;
                String str12;
                this.b = i2;
                Resources resources = getContext().getResources();
                int i5 = R.string.face_detect_dialog_btn_retry;
                resources.getString(i5);
                if (i2 != -10217) {
                    if (i2 != 0) {
                        if (!(i2 == 3001 || i2 == 3206 || i2 == 3208 || i2 == 3203 || i2 == 3204)) {
                            switch (i2) {
                                case GlobalErrorCode.ERROR_INNER_MORTAL:
                                    str5 = resources.getString(R.string.face_detect_dialog_algorithm_init_error);
                                    str6 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                    i4 = i2;
                                    str2 = str6;
                                    str4 = str5;
                                    str3 = "";
                                    i3 = 10010;
                                    break;
                                case GlobalErrorCode.ERROR_BUSINESS_RETRY_REACH_THRESHOLD:
                                    str7 = resources.getString(R.string.face_liveness_business_reach_retry_threshold_1);
                                    str8 = resources.getString(R.string.face_liveness_ok);
                                    i4 = i2;
                                    str2 = str8;
                                    str4 = str7;
                                    str3 = "";
                                    i3 = BaseBioNavigatorActivity.o;
                                    break;
                                case GlobalErrorCode.ERROR_DETECT_INTERRUPT:
                                    String string4 = resources.getString(R.string.face_detect_dialog_interrupt_error);
                                    i4 = i2;
                                    str2 = resources.getString(i5);
                                    str4 = string4;
                                    str3 = "";
                                    i3 = 10004;
                                    break;
                                case GlobalErrorCode.ERROR_USER_RETRY_LIMITED:
                                    str7 = resources.getString(R.string.face_liveness_reach_retry_threshold);
                                    str8 = resources.getString(R.string.face_liveness_retry);
                                    i4 = i2;
                                    str2 = str8;
                                    str4 = str7;
                                    str3 = "";
                                    i3 = BaseBioNavigatorActivity.o;
                                    break;
                                default:
                                    switch (i2) {
                                        case GlobalErrorCode.ERROR_UPLOAD_BIO_DATA:
                                        case GlobalErrorCode.ERROR_VERIFY_BIO_DATA:
                                            string = resources.getString(R.string.face_liveness_recognize_fail);
                                            if (!TextUtils.isEmpty(aLBiometricsParams.userName)) {
                                                String str13 = "请确保是" + aLBiometricsParams.userName + "本人操作，" + resources.getString(R.string.face_liveness_recognize_fail_hint);
                                                SpannableString spannableString = new SpannableString(str13);
                                                TextViewSkinData d2 = d("messageText");
                                                String str14 = "#333333";
                                                if (d2 != null) {
                                                    foregroundColorSpan2 = new ForegroundColorSpan(d.a(TextUtils.isEmpty(d2.getTextColor()) ? str14 : d2.getTextColor(), -7829368));
                                                    absoluteSizeSpan = new AbsoluteSizeSpan(d2.getFontSize());
                                                    if (!TextUtils.isEmpty(d2.getTextColor())) {
                                                        str14 = d2.getTextColor();
                                                    }
                                                    foregroundColorSpan = new ForegroundColorSpan(d.a(str14, -7829368));
                                                    absoluteSizeSpan2 = new AbsoluteSizeSpan(d2.getFontSize());
                                                } else {
                                                    foregroundColorSpan2 = new ForegroundColorSpan(d.a(str14, -7829368));
                                                    absoluteSizeSpan = new AbsoluteSizeSpan(28);
                                                    foregroundColorSpan = new ForegroundColorSpan(d.a(str14, -7829368));
                                                    absoluteSizeSpan2 = new AbsoluteSizeSpan(28);
                                                }
                                                spannableString.setSpan(foregroundColorSpan2, 0, 4, 33);
                                                spannableString.setSpan(absoluteSizeSpan, 0, 4, 33);
                                                spannableString.setSpan(foregroundColorSpan, aLBiometricsParams.userName.length() + 4, str13.length(), 33);
                                                spannableString.setSpan(absoluteSizeSpan2, aLBiometricsParams.userName.length() + 4, str13.length(), 33);
                                                TextViewSkinData d3 = d("markMessageText");
                                                String str15 = "#E76057";
                                                if (d3 != null) {
                                                    if (!TextUtils.isEmpty(d3.getTextColor())) {
                                                        str15 = d3.getTextColor();
                                                    }
                                                    foregroundColorSpan3 = new ForegroundColorSpan(d.a(str15, -7829368));
                                                    absoluteSizeSpan3 = new AbsoluteSizeSpan(d3.getFontSize());
                                                } else {
                                                    foregroundColorSpan3 = new ForegroundColorSpan(d.a(str15, -7829368));
                                                    absoluteSizeSpan3 = new AbsoluteSizeSpan(28);
                                                }
                                                spannableString.setSpan(foregroundColorSpan3, 4, aLBiometricsParams.userName.length() + 4, 33);
                                                spannableString.setSpan(absoluteSizeSpan3, 4, aLBiometricsParams.userName.length() + 4, 33);
                                                str9 = spannableString;
                                            } else {
                                                str9 = resources.getString(R.string.face_liveness_recognize_fail_msg);
                                            }
                                            string3 = resources.getString(i5);
                                            i4 = i2;
                                            str3 = str9;
                                            i3 = BaseBioNavigatorActivity.p;
                                            break;
                                        case GlobalErrorCode.ERROR_UPLOAD_BIO_PIC_ERROR:
                                        case GlobalErrorCode.ERROR_ONLINE_NET_ERROR:
                                            string = resources.getString(R.string.face_liveness_file_upload_fail);
                                            str9 = resources.getString(R.string.face_liveness_upload_fail_msg);
                                            string3 = resources.getString(i5);
                                            i4 = i2;
                                            str3 = str9;
                                            i3 = BaseBioNavigatorActivity.p;
                                            break;
                                        default:
                                            switch (i2) {
                                                case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION:
                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                    str10 = resources.getString(R.string.face_liveness_action_fail_tip_occlusion);
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = str10;
                                                    i3 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_FACE:
                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                    str10 = resources.getString(R.string.face_liveness_action_fail_tip_face_error);
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = str10;
                                                    i3 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_ACTION:
                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                    str10 = resources.getString(R.string.face_liveness_action_fail_tip_action_wrong);
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = str10;
                                                    i3 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE:
                                                    String string5 = resources.getString(R.string.face_detect_dialog_quality_not_enough_error);
                                                    i4 = i2;
                                                    str2 = resources.getString(i5);
                                                    str4 = string5;
                                                    str3 = "";
                                                    i3 = 10009;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_REFLECT_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_REFLECT_NO_FACE:
                                                    string = resources.getString(R.string.face_detect_reflect_fail);
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = "";
                                                    i3 = 20005;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_RECAP_FAIL:
                                                    string = resources.getString(R.string.face_detect_recap_fail);
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = "";
                                                    i3 = 20005;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_ONLINE_RECOGNIZE_ERROR:
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_MODEL_COPY_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_DETECTING_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_CONFIG_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_INIT_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_SO_LOAD_FAIL:
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_MUCH_MINE:
                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                    if (ABDetectContext.getInstance().getLastDetectFailedType() == 0) {
                                                        str10 = resources.getString(R.string.face_liveness_action_fail_tip_action_wrong);
                                                    } else if (ABDetectContext.getInstance().getLastDetectFailedType() == 1) {
                                                        str10 = resources.getString(R.string.face_liveness_action_fail_tip_face_error);
                                                    } else if (ABDetectContext.getInstance().getLastDetectFailedType() == 6) {
                                                        str10 = resources.getString(R.string.face_liveness_action_fail_tip_occlusion);
                                                    } else {
                                                        str10 = resources.getString(R.string.face_liveness_action_fail_tip_common);
                                                    }
                                                    string3 = resources.getString(i5);
                                                    i4 = i2;
                                                    str3 = str10;
                                                    i3 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_TIMEOUT_ADJUST:
                                                case GlobalErrorCode.ERROR_ALGO_TIMEOUT_ACTION:
                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                    string2 = resources.getString(R.string.face_liveness_action_fail_msg_timeout);
                                                    string3 = resources.getString(i5);
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case GlobalErrorCode.ERROR_DEVICE_HW_MAGIC_WINDOW:
                                                            String string6 = resources.getString(R.string.face_detect_camera_is_huawei_magic_window_title);
                                                            String string7 = resources.getString(R.string.face_detect_camera_is_huawei_magic_window_text);
                                                            i4 = i2;
                                                            i3 = 10005;
                                                            str2 = resources.getString(R.string.face_detect_top_back_text);
                                                            str4 = string6;
                                                            str3 = string7;
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_CAMERA_DATA_FAIL:
                                                            str5 = resources.getString(R.string.face_detect_dialog_preview_frame_error);
                                                            str6 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                            i4 = i2;
                                                            str2 = str6;
                                                            str4 = str5;
                                                            str3 = "";
                                                            i3 = 10010;
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_X86:
                                                        case GlobalErrorCode.ERROR_DEVICE_CPU_NOT_SUPPORT:
                                                        case GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_NEON:
                                                            String string8 = resources.getString(R.string.face_detect_camera_configuration_cpu_low_title);
                                                            i4 = i2;
                                                            str2 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                            str4 = string8;
                                                            str3 = "";
                                                            i3 = 10005;
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_CAMERA_NO_PERMISSION:
                                                        case GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT:
                                                            string = resources.getString(R.string.face_detect_camera_no_permission_title);
                                                            String string9 = resources.getString(R.string.face_detect_camera_open_permission_text);
                                                            string3 = resources.getString(R.string.face_detect_alert_dialog_msg_ok_text);
                                                            i4 = i2;
                                                            str3 = string9;
                                                            i3 = 10012;
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_NO_CAMERA:
                                                            string = resources.getString(R.string.face_detect_camera_configuration_nofront_title);
                                                            string3 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                            i4 = i2;
                                                            str3 = "";
                                                            i3 = 10013;
                                                            break;
                                                        default:
                                                            switch (i2) {
                                                                case 2:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    if (!TextUtils.isEmpty(str)) {
                                                                        str9 = str;
                                                                    } else {
                                                                        str9 = resources.getString(R.string.face_detect_verify_not_pass);
                                                                    }
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 3:
                                                                case 4:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_id_blur);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 5:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_id_expired);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 6:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_face_id_inconsistent);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 7:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_face_inconsistent_with_security);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 8:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_invalid_id_photo);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 9:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_not_account_self);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 10:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_not_same_person);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 11:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_abuse_security_photo);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 12:
                                                                    string = resources.getString(R.string.face_liveness_action_fail);
                                                                    str9 = resources.getString(R.string.face_detect_security_abnormal);
                                                                    string3 = resources.getString(i5);
                                                                    i4 = i2;
                                                                    str3 = str9;
                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                default:
                                                                    switch (i2) {
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3101:
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3102:
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3103:
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3104:
                                                                            break;
                                                                        default:
                                                                            switch (i2) {
                                                                                case 4001:
                                                                                    str11 = resources.getString(R.string.rp_ctid_sys_error_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case 4002:
                                                                                    str11 = resources.getString(R.string.rp_ctid_not_install_title);
                                                                                    str3 = resources.getString(R.string.rp_ctid_not_install_msg);
                                                                                    str2 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case 4003:
                                                                                    str11 = resources.getString(R.string.rp_ctid_not_login_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case 4004:
                                                                                    str11 = resources.getString(R.string.rp_ctid_unregister_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_NO_CERT:
                                                                                    str11 = resources.getString(R.string.rp_ctid_no_cert_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_NOT_BINDING:
                                                                                    str11 = resources.getString(R.string.rp_ctid_no_binding_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_APP_ERROR:
                                                                                    str11 = resources.getString(R.string.rp_ctid_app_sys_error_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_DATA_ERROR:
                                                                                    str11 = resources.getString(R.string.rp_ctid_app_data_error_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str12;
                                                                                    str3 = "";
                                                                                    i4 = GlobalErrorCode.ERROR_CTID;
                                                                                    i3 = 10005;
                                                                                    str4 = str11;
                                                                                    break;
                                                                                default:
                                                                                    string = resources.getString(R.string.face_liveness_recognize_fail);
                                                                                    str9 = resources.getString(R.string.face_detect_unkonwn_error);
                                                                                    string3 = resources.getString(i5);
                                                                                    i4 = i2;
                                                                                    str3 = str9;
                                                                                    i3 = BaseBioNavigatorActivity.p;
                                                                                    break;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                            if (TextUtils.isEmpty(str4)) {
                                a(i3, str4, str3, str2, aLBiometricsParams.showOtherButton, i4);
                                return;
                            }
                            return;
                        }
                        string = resources.getString(R.string.face_liveness_action_fail);
                        string3 = resources.getString(i5);
                        str3 = str;
                        i4 = i2;
                        i3 = BaseBioNavigatorActivity.p;
                    } else {
                        string = resources.getString(R.string.face_liveness_success);
                        String string10 = resources.getString(R.string.rp_thanks_for_your_use);
                        string3 = resources.getString(R.string.face_detect_top_back_text);
                        i4 = i2;
                        str3 = string10;
                        i3 = 20008;
                    }
                    str2 = string3;
                    str4 = string;
                    if (TextUtils.isEmpty(str4)) {
                    }
                } else if (ALBiometricsType.isDazzle(aLBiometricsParams.mBiometricsType)) {
                    string = resources.getString(R.string.face_liveness_action_fail);
                    string2 = resources.getString(R.string.face_liveness_action_fail_msg_timeout);
                    string3 = resources.getString(i5);
                } else {
                    String string11 = resources.getString(R.string.face_liveness_action_fail);
                    String string12 = resources.getString(R.string.face_detect_alert_dialog_msg_timeout);
                    str2 = resources.getString(i5);
                    str4 = string11;
                    str3 = string12;
                    i3 = 20007;
                    i4 = i2;
                    if (TextUtils.isEmpty(str4)) {
                    }
                }
                str3 = string2;
                i3 = 10002;
                i4 = i2;
                str2 = string3;
                str4 = string;
                if (TextUtils.isEmpty(str4)) {
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r7v10, resolved type: android.text.SpannableString */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x04bd  */
            /* JADX WARNING: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x02f1  */
            /* JADX WARNING: Removed duplicated region for block: B:99:0x0447  */
            static /* synthetic */ void a(DetectActionResultWidget detectActionResultWidget, int i2, Runnable runnable, ALBiometricsParams aLBiometricsParams, String str) {
                int i3;
                String str2;
                String str3;
                String str4;
                int i4;
                String string;
                String string2;
                String str5;
                String str6;
                String str7;
                String str8;
                String string3;
                ForegroundColorSpan foregroundColorSpan;
                AbsoluteSizeSpan absoluteSizeSpan;
                ForegroundColorSpan foregroundColorSpan2;
                AbsoluteSizeSpan absoluteSizeSpan2;
                ForegroundColorSpan foregroundColorSpan3;
                AbsoluteSizeSpan absoluteSizeSpan3;
                String str9;
                String str10;
                String str11;
                String str12;
                String str13;
                runnable.run();
                detectActionResultWidget.b = i2;
                Resources resources = detectActionResultWidget.getContext().getResources();
                int i5 = R.string.face_detect_dialog_btn_retry;
                resources.getString(i5);
                if (i2 != -10217) {
                    if (i2 != 0) {
                        if (!(i2 == 3001 || i2 == 3206 || i2 == 3208 || i2 == 3203 || i2 == 3204)) {
                            switch (i2) {
                                case GlobalErrorCode.ERROR_INNER_MORTAL:
                                    str6 = resources.getString(R.string.face_detect_dialog_algorithm_init_error);
                                    str5 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                    i3 = i2;
                                    str2 = str6;
                                    i4 = 10010;
                                    str3 = str5;
                                    str4 = "";
                                    break;
                                case GlobalErrorCode.ERROR_BUSINESS_RETRY_REACH_THRESHOLD:
                                    str7 = resources.getString(R.string.face_liveness_business_reach_retry_threshold_1);
                                    str5 = resources.getString(R.string.face_liveness_ok);
                                    i3 = i2;
                                    str2 = str7;
                                    i4 = BaseBioNavigatorActivity.o;
                                    str3 = str5;
                                    str4 = "";
                                    break;
                                case GlobalErrorCode.ERROR_DETECT_INTERRUPT:
                                    String string4 = resources.getString(R.string.face_detect_dialog_interrupt_error);
                                    str3 = resources.getString(i5);
                                    str2 = string4;
                                    str4 = "";
                                    i3 = i2;
                                    i4 = 10004;
                                    break;
                                case GlobalErrorCode.ERROR_USER_RETRY_LIMITED:
                                    str7 = resources.getString(R.string.face_liveness_reach_retry_threshold);
                                    str5 = resources.getString(R.string.face_liveness_retry);
                                    i3 = i2;
                                    str2 = str7;
                                    i4 = BaseBioNavigatorActivity.o;
                                    str3 = str5;
                                    str4 = "";
                                    break;
                                default:
                                    switch (i2) {
                                        case GlobalErrorCode.ERROR_UPLOAD_BIO_DATA:
                                        case GlobalErrorCode.ERROR_VERIFY_BIO_DATA:
                                            str2 = resources.getString(R.string.face_liveness_recognize_fail);
                                            if (!TextUtils.isEmpty(aLBiometricsParams.userName)) {
                                                String str14 = "请确保是" + aLBiometricsParams.userName + "本人操作，" + resources.getString(R.string.face_liveness_recognize_fail_hint);
                                                SpannableString spannableString = new SpannableString(str14);
                                                TextViewSkinData d2 = detectActionResultWidget.d("messageText");
                                                String str15 = "#333333";
                                                if (d2 != null) {
                                                    foregroundColorSpan2 = new ForegroundColorSpan(d.a(TextUtils.isEmpty(d2.getTextColor()) ? str15 : d2.getTextColor(), -7829368));
                                                    absoluteSizeSpan = new AbsoluteSizeSpan(d2.getFontSize());
                                                    if (!TextUtils.isEmpty(d2.getTextColor())) {
                                                        str15 = d2.getTextColor();
                                                    }
                                                    foregroundColorSpan = new ForegroundColorSpan(d.a(str15, -7829368));
                                                    absoluteSizeSpan2 = new AbsoluteSizeSpan(d2.getFontSize());
                                                } else {
                                                    foregroundColorSpan2 = new ForegroundColorSpan(d.a(str15, -7829368));
                                                    absoluteSizeSpan = new AbsoluteSizeSpan(28);
                                                    foregroundColorSpan = new ForegroundColorSpan(d.a(str15, -7829368));
                                                    absoluteSizeSpan2 = new AbsoluteSizeSpan(28);
                                                }
                                                spannableString.setSpan(foregroundColorSpan2, 0, 4, 33);
                                                spannableString.setSpan(absoluteSizeSpan, 0, 4, 33);
                                                spannableString.setSpan(foregroundColorSpan, aLBiometricsParams.userName.length() + 4, str14.length(), 33);
                                                spannableString.setSpan(absoluteSizeSpan2, aLBiometricsParams.userName.length() + 4, str14.length(), 33);
                                                TextViewSkinData d3 = detectActionResultWidget.d("markMessageText");
                                                String str16 = "#E76057";
                                                if (d3 != null) {
                                                    if (!TextUtils.isEmpty(d3.getTextColor())) {
                                                        str16 = d3.getTextColor();
                                                    }
                                                    foregroundColorSpan3 = new ForegroundColorSpan(d.a(str16, -7829368));
                                                    absoluteSizeSpan3 = new AbsoluteSizeSpan(d3.getFontSize());
                                                } else {
                                                    foregroundColorSpan3 = new ForegroundColorSpan(d.a(str16, -7829368));
                                                    absoluteSizeSpan3 = new AbsoluteSizeSpan(28);
                                                }
                                                spannableString.setSpan(foregroundColorSpan3, 4, aLBiometricsParams.userName.length() + 4, 33);
                                                spannableString.setSpan(absoluteSizeSpan3, 4, aLBiometricsParams.userName.length() + 4, 33);
                                                str8 = spannableString;
                                            } else {
                                                str8 = resources.getString(R.string.face_liveness_recognize_fail_msg);
                                            }
                                            string3 = resources.getString(i5);
                                            str3 = string3;
                                            str4 = str8;
                                            i3 = i2;
                                            i4 = BaseBioNavigatorActivity.p;
                                            break;
                                        case GlobalErrorCode.ERROR_UPLOAD_BIO_PIC_ERROR:
                                        case GlobalErrorCode.ERROR_ONLINE_NET_ERROR:
                                            str2 = resources.getString(R.string.face_liveness_file_upload_fail);
                                            str8 = resources.getString(R.string.face_liveness_upload_fail_msg);
                                            string3 = resources.getString(i5);
                                            str3 = string3;
                                            str4 = str8;
                                            i3 = i2;
                                            i4 = BaseBioNavigatorActivity.p;
                                            break;
                                        default:
                                            switch (i2) {
                                                case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION:
                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                    str9 = resources.getString(R.string.face_liveness_action_fail_tip_occlusion);
                                                    str10 = resources.getString(i5);
                                                    str3 = str10;
                                                    str4 = str9;
                                                    i3 = i2;
                                                    i4 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_FACE:
                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                    str9 = resources.getString(R.string.face_liveness_action_fail_tip_face_error);
                                                    str10 = resources.getString(i5);
                                                    str3 = str10;
                                                    str4 = str9;
                                                    i3 = i2;
                                                    i4 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_ACTION:
                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                    str9 = resources.getString(R.string.face_liveness_action_fail_tip_action_wrong);
                                                    str10 = resources.getString(i5);
                                                    str3 = str10;
                                                    str4 = str9;
                                                    i3 = i2;
                                                    i4 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_DETECT_NOT_ENOUNGH_IMAGE:
                                                    String string5 = resources.getString(R.string.face_detect_dialog_quality_not_enough_error);
                                                    str3 = resources.getString(i5);
                                                    str2 = string5;
                                                    str4 = "";
                                                    i3 = i2;
                                                    i4 = 10009;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_REFLECT_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_REFLECT_NO_FACE:
                                                    str2 = resources.getString(R.string.face_detect_reflect_fail);
                                                    str11 = resources.getString(i5);
                                                    i3 = i2;
                                                    str3 = str11;
                                                    str4 = "";
                                                    i4 = 20005;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_RECAP_FAIL:
                                                    str2 = resources.getString(R.string.face_detect_recap_fail);
                                                    str11 = resources.getString(i5);
                                                    i3 = i2;
                                                    str3 = str11;
                                                    str4 = "";
                                                    i4 = 20005;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_ONLINE_RECOGNIZE_ERROR:
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_MODEL_COPY_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_DETECTING_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_CONFIG_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_INIT_FAIL:
                                                case GlobalErrorCode.ERROR_ALGO_SO_LOAD_FAIL:
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_MUCH_MINE:
                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                    if (ABDetectContext.getInstance().getLastDetectFailedType() == 0) {
                                                        str9 = resources.getString(R.string.face_liveness_action_fail_tip_action_wrong);
                                                    } else if (ABDetectContext.getInstance().getLastDetectFailedType() == 1) {
                                                        str9 = resources.getString(R.string.face_liveness_action_fail_tip_face_error);
                                                    } else if (ABDetectContext.getInstance().getLastDetectFailedType() == 6) {
                                                        str9 = resources.getString(R.string.face_liveness_action_fail_tip_occlusion);
                                                    } else {
                                                        str9 = resources.getString(R.string.face_liveness_action_fail_tip_common);
                                                    }
                                                    str10 = resources.getString(i5);
                                                    str3 = str10;
                                                    str4 = str9;
                                                    i3 = i2;
                                                    i4 = 20006;
                                                    break;
                                                case GlobalErrorCode.ERROR_ALGO_TIMEOUT_ADJUST:
                                                case GlobalErrorCode.ERROR_ALGO_TIMEOUT_ACTION:
                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                    string = resources.getString(R.string.face_liveness_action_fail_msg_timeout);
                                                    string2 = resources.getString(i5);
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case GlobalErrorCode.ERROR_DEVICE_HW_MAGIC_WINDOW:
                                                            String string6 = resources.getString(R.string.face_detect_camera_is_huawei_magic_window_title);
                                                            String string7 = resources.getString(R.string.face_detect_camera_is_huawei_magic_window_text);
                                                            i3 = i2;
                                                            i4 = 10005;
                                                            str3 = resources.getString(R.string.face_detect_top_back_text);
                                                            str4 = string7;
                                                            str2 = string6;
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_CAMERA_DATA_FAIL:
                                                            str6 = resources.getString(R.string.face_detect_dialog_preview_frame_error);
                                                            str5 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                            i3 = i2;
                                                            str2 = str6;
                                                            i4 = 10010;
                                                            str3 = str5;
                                                            str4 = "";
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_X86:
                                                        case GlobalErrorCode.ERROR_DEVICE_CPU_NOT_SUPPORT:
                                                        case GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_NEON:
                                                            String string8 = resources.getString(R.string.face_detect_camera_configuration_cpu_low_title);
                                                            str5 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                            i3 = i2;
                                                            str2 = string8;
                                                            i4 = 10005;
                                                            str3 = str5;
                                                            str4 = "";
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_CAMERA_NO_PERMISSION:
                                                        case GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT:
                                                            str2 = resources.getString(R.string.face_detect_camera_no_permission_title);
                                                            String string9 = resources.getString(R.string.face_detect_camera_open_permission_text);
                                                            str3 = resources.getString(R.string.face_detect_alert_dialog_msg_ok_text);
                                                            str4 = string9;
                                                            i3 = i2;
                                                            i4 = 10012;
                                                            break;
                                                        case GlobalErrorCode.ERROR_DEVICE_NO_CAMERA:
                                                            str2 = resources.getString(R.string.face_detect_camera_configuration_nofront_title);
                                                            i3 = i2;
                                                            str3 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                            str4 = "";
                                                            i4 = 10013;
                                                            break;
                                                        default:
                                                            switch (i2) {
                                                                case 2:
                                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                                    if (!TextUtils.isEmpty(str)) {
                                                                        str8 = str;
                                                                    } else {
                                                                        str8 = resources.getString(R.string.face_detect_verify_not_pass);
                                                                    }
                                                                    string3 = resources.getString(i5);
                                                                    str3 = string3;
                                                                    str4 = str8;
                                                                    i3 = i2;
                                                                    i4 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 3:
                                                                case 4:
                                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                                    str8 = resources.getString(R.string.face_detect_id_blur);
                                                                    string3 = resources.getString(i5);
                                                                    str3 = string3;
                                                                    str4 = str8;
                                                                    i3 = i2;
                                                                    i4 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 5:
                                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                                    str8 = resources.getString(R.string.face_detect_id_expired);
                                                                    string3 = resources.getString(i5);
                                                                    str3 = string3;
                                                                    str4 = str8;
                                                                    i3 = i2;
                                                                    i4 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 6:
                                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                                    str8 = resources.getString(R.string.face_detect_face_id_inconsistent);
                                                                    string3 = resources.getString(i5);
                                                                    str3 = string3;
                                                                    str4 = str8;
                                                                    i3 = i2;
                                                                    i4 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 7:
                                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                                    str8 = resources.getString(R.string.face_detect_face_inconsistent_with_security);
                                                                    string3 = resources.getString(i5);
                                                                    str3 = string3;
                                                                    str4 = str8;
                                                                    i3 = i2;
                                                                    i4 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 8:
                                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                                    str8 = resources.getString(R.string.face_detect_invalid_id_photo);
                                                                    string3 = resources.getString(i5);
                                                                    str3 = string3;
                                                                    str4 = str8;
                                                                    i3 = i2;
                                                                    i4 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 9:
                                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                                    str8 = resources.getString(R.string.face_detect_not_account_self);
                                                                    string3 = resources.getString(i5);
                                                                    str3 = string3;
                                                                    str4 = str8;
                                                                    i3 = i2;
                                                                    i4 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 10:
                                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                                    str8 = resources.getString(R.string.face_detect_not_same_person);
                                                                    string3 = resources.getString(i5);
                                                                    str3 = string3;
                                                                    str4 = str8;
                                                                    i3 = i2;
                                                                    i4 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 11:
                                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                                    str8 = resources.getString(R.string.face_detect_abuse_security_photo);
                                                                    string3 = resources.getString(i5);
                                                                    str3 = string3;
                                                                    str4 = str8;
                                                                    i3 = i2;
                                                                    i4 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                case 12:
                                                                    str2 = resources.getString(R.string.face_liveness_action_fail);
                                                                    str8 = resources.getString(R.string.face_detect_security_abnormal);
                                                                    string3 = resources.getString(i5);
                                                                    str3 = string3;
                                                                    str4 = str8;
                                                                    i3 = i2;
                                                                    i4 = BaseBioNavigatorActivity.p;
                                                                    break;
                                                                default:
                                                                    switch (i2) {
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3101:
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3102:
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3103:
                                                                        case GlobalErrorCode.ERROR_SERVER_CODE_3104:
                                                                            break;
                                                                        default:
                                                                            switch (i2) {
                                                                                case 4001:
                                                                                    str13 = resources.getString(R.string.rp_ctid_sys_error_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str13;
                                                                                    str3 = str12;
                                                                                    str4 = "";
                                                                                    i4 = 10005;
                                                                                    i3 = GlobalErrorCode.ERROR_CTID;
                                                                                    break;
                                                                                case 4002:
                                                                                    String string10 = resources.getString(R.string.rp_ctid_not_install_title);
                                                                                    String string11 = resources.getString(R.string.rp_ctid_not_install_msg);
                                                                                    String string12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = string10;
                                                                                    i4 = 10005;
                                                                                    i3 = GlobalErrorCode.ERROR_CTID;
                                                                                    str3 = string12;
                                                                                    str4 = string11;
                                                                                    break;
                                                                                case 4003:
                                                                                    str13 = resources.getString(R.string.rp_ctid_not_login_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str13;
                                                                                    str3 = str12;
                                                                                    str4 = "";
                                                                                    i4 = 10005;
                                                                                    i3 = GlobalErrorCode.ERROR_CTID;
                                                                                    break;
                                                                                case 4004:
                                                                                    str13 = resources.getString(R.string.rp_ctid_unregister_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str13;
                                                                                    str3 = str12;
                                                                                    str4 = "";
                                                                                    i4 = 10005;
                                                                                    i3 = GlobalErrorCode.ERROR_CTID;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_NO_CERT:
                                                                                    str13 = resources.getString(R.string.rp_ctid_no_cert_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str13;
                                                                                    str3 = str12;
                                                                                    str4 = "";
                                                                                    i4 = 10005;
                                                                                    i3 = GlobalErrorCode.ERROR_CTID;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_NOT_BINDING:
                                                                                    str13 = resources.getString(R.string.rp_ctid_no_binding_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str13;
                                                                                    str3 = str12;
                                                                                    str4 = "";
                                                                                    i4 = 10005;
                                                                                    i3 = GlobalErrorCode.ERROR_CTID;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_APP_ERROR:
                                                                                    str13 = resources.getString(R.string.rp_ctid_app_sys_error_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str13;
                                                                                    str3 = str12;
                                                                                    str4 = "";
                                                                                    i4 = 10005;
                                                                                    i3 = GlobalErrorCode.ERROR_CTID;
                                                                                    break;
                                                                                case GlobalErrorCode.ERROR_CTID_DATA_ERROR:
                                                                                    str13 = resources.getString(R.string.rp_ctid_app_data_error_title);
                                                                                    str12 = resources.getString(R.string.face_detect_dialog_btn_ok);
                                                                                    str2 = str13;
                                                                                    str3 = str12;
                                                                                    str4 = "";
                                                                                    i4 = 10005;
                                                                                    i3 = GlobalErrorCode.ERROR_CTID;
                                                                                    break;
                                                                                default:
                                                                                    str2 = resources.getString(R.string.face_liveness_recognize_fail);
                                                                                    str8 = resources.getString(R.string.face_detect_unkonwn_error);
                                                                                    string3 = resources.getString(i5);
                                                                                    str3 = string3;
                                                                                    str4 = str8;
                                                                                    i3 = i2;
                                                                                    i4 = BaseBioNavigatorActivity.p;
                                                                                    break;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                        }
                        str2 = resources.getString(R.string.face_liveness_action_fail);
                        i3 = i2;
                        str3 = resources.getString(i5);
                        i4 = BaseBioNavigatorActivity.p;
                        str4 = str;
                    } else {
                        str2 = resources.getString(R.string.face_liveness_success);
                        String string13 = resources.getString(R.string.rp_thanks_for_your_use);
                        str3 = resources.getString(R.string.face_detect_top_back_text);
                        str4 = string13;
                        i3 = i2;
                        i4 = 20008;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        detectActionResultWidget.a(i4, str2, str4, str3, aLBiometricsParams.showOtherButton, i3);
                        return;
                    }
                    return;
                } else if (ALBiometricsType.isDazzle(aLBiometricsParams.mBiometricsType)) {
                    str2 = resources.getString(R.string.face_liveness_action_fail);
                    string = resources.getString(R.string.face_liveness_action_fail_msg_timeout);
                    string2 = resources.getString(i5);
                } else {
                    String string14 = resources.getString(R.string.face_liveness_action_fail);
                    String string15 = resources.getString(R.string.face_detect_alert_dialog_msg_timeout);
                    str3 = resources.getString(i5);
                    str2 = string14;
                    str4 = string15;
                    i3 = i2;
                    i4 = 20007;
                    if (!TextUtils.isEmpty(str2)) {
                    }
                }
                i3 = i2;
                str3 = string2;
                str4 = string;
                i4 = 10002;
                if (!TextUtils.isEmpty(str2)) {
                }
            }
        }
