package com.alibaba.security.biometrics.c;

import android.view.View;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;

/* compiled from: Taobao */
public final class b {

    /* renamed from: com.alibaba.security.biometrics.c.b$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
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
            a[ABDetectType.POS_PITCH_UP.ordinal()] = 5;
            a[ABDetectType.PITCH_STILL.ordinal()] = 6;
            a[ABDetectType.POS_PITCH_DOWN.ordinal()] = 7;
            a[ABDetectType.POS_YAW_RIGHT.ordinal()] = 8;
            a[ABDetectType.POS_YAW_LEFT.ordinal()] = 9;
            a[ABDetectType.POS_YAW.ordinal()] = 10;
            a[ABDetectType.YAW_STILL.ordinal()] = 11;
            a[ABDetectType.NONE.ordinal()] = 12;
        }
    }

    private static String a(View view, ABDetectType aBDetectType) {
        if (aBDetectType == null) {
            return "";
        }
        switch (AnonymousClass1.a[aBDetectType.ordinal()]) {
            case 1:
            case 2:
                return view.getResources().getString(R.string.face_detect_action_blink);
            case 3:
            case 4:
                return view.getResources().getString(R.string.face_detect_action_mounth);
            case 5:
            case 6:
                return view.getResources().getString(R.string.face_detect_action_raise_head);
            case 7:
                return view.getResources().getString(R.string.face_detect_action_pitch_down_head);
            case 8:
                return view.getResources().getString(R.string.face_detect_action_turn_right);
            case 9:
                return view.getResources().getString(R.string.face_detect_action_turn_left);
            case 10:
            case 11:
                return view.getResources().getString(R.string.face_detect_action_turn_right_or_left);
            case 12:
            default:
                return "";
        }
    }

    private static int a(ABDetectType aBDetectType) {
        if (aBDetectType == null) {
            return -1;
        }
        switch (AnonymousClass1.a[aBDetectType.ordinal()]) {
            case 1:
            case 2:
                return R.drawable.rp_face_guide_blink_anim;
            case 3:
            case 4:
                return R.drawable.rp_face_guide_mouth_anim;
            case 5:
            case 6:
            case 7:
                return R.drawable.rp_face_guide_pitch_anim;
            case 8:
            case 9:
            case 10:
            case 11:
                return R.drawable.rp_face_guide_yaw_anim;
            default:
                return -1;
        }
    }
}
