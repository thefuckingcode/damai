package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.content.Context;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.b.a;
import com.alibaba.security.biometrics.b.c;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.d.l;
import com.taobao.weex.annotation.JSMethod;
import java.util.Locale;

@f
/* compiled from: Taobao */
public class MediaSystemComponent extends a {
    protected a d;

    /* access modifiers changed from: package-private */
    /* renamed from: com.alibaba.security.biometrics.component.MediaSystemComponent$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[ABDetectType.values().length];
            a = iArr;
            iArr[ABDetectType.BLINK.ordinal()] = 1;
            a[ABDetectType.BLINK_STILL.ordinal()] = 2;
            a[ABDetectType.MOUTH.ordinal()] = 3;
            a[ABDetectType.MOUTH_STILL.ordinal()] = 4;
            a[ABDetectType.POS_PITCH.ordinal()] = 5;
            a[ABDetectType.POS_PITCH_DOWN.ordinal()] = 6;
            a[ABDetectType.PITCH_STILL.ordinal()] = 7;
            a[ABDetectType.POS_PITCH_UP.ordinal()] = 8;
            a[ABDetectType.POS_YAW.ordinal()] = 9;
            try {
                a[ABDetectType.YAW_STILL.ordinal()] = 10;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum AudioType {
        BLINK("rp_face_blink"),
        MOUTH("rp_face_open_mouth"),
        POS_PITCH_DOWN("rp_face_pitch_up"),
        POS_PITCH_UP("rp_face_pitch_up"),
        POS_YAW("rp_face_yaw_left_right"),
        DING("rp_face_ding");
        
        String resourceName;

        private AudioType(String str) {
            this.resourceName = str;
        }

        private String getResourceName(String str) {
            if (Locale.getDefault().getLanguage().equals(Locale.CHINA.getLanguage())) {
                return str;
            }
            String language = Locale.getDefault().getLanguage();
            return str + JSMethod.NOT_SET + language;
        }

        public final int getRaw(Context context) {
            if (context == null) {
                return 0;
            }
            return context.getResources().getIdentifier(getResourceName(this.resourceName), "raw", l.a(context));
        }
    }

    private void a(Activity activity) {
        try {
            if (this.d == null) {
                this.d = new c(activity);
            }
        } catch (Exception unused) {
        }
    }

    private static AudioType b(ABDetectType aBDetectType) {
        switch (AnonymousClass1.a[aBDetectType.ordinal()]) {
            case 1:
            case 2:
                return AudioType.BLINK;
            case 3:
            case 4:
                return AudioType.MOUTH;
            case 5:
            case 6:
            case 7:
                return AudioType.POS_PITCH_DOWN;
            case 8:
                return AudioType.POS_PITCH_UP;
            case 9:
            case 10:
                return AudioType.POS_YAW;
            default:
                return null;
        }
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean c() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.b();
            this.d = null;
        }
        return super.c();
    }

    public final void d() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(boolean z) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    @Override // com.alibaba.security.biometrics.component.a, com.alibaba.security.biometrics.component.d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        try {
            if (this.d == null) {
                this.d = new c(activity);
            }
        } catch (Exception unused) {
        }
        a(((AudioSettingComponent) e.a(AudioSettingComponent.class)).d);
        return false;
    }

    public final void a(ABDetectType aBDetectType) {
        a aVar;
        AudioType audioType;
        a aVar2;
        if (aBDetectType != ABDetectType.AIMLESS && (aVar = this.d) != null && !aVar.d()) {
            switch (AnonymousClass1.a[aBDetectType.ordinal()]) {
                case 1:
                case 2:
                    audioType = AudioType.BLINK;
                    break;
                case 3:
                case 4:
                    audioType = AudioType.MOUTH;
                    break;
                case 5:
                case 6:
                case 7:
                    audioType = AudioType.POS_PITCH_DOWN;
                    break;
                case 8:
                    audioType = AudioType.POS_PITCH_UP;
                    break;
                case 9:
                case 10:
                    audioType = AudioType.POS_YAW;
                    break;
                default:
                    audioType = null;
                    break;
            }
            if (audioType != null && (aVar2 = this.d) != null) {
                aVar2.a(audioType);
            }
        }
    }
}
