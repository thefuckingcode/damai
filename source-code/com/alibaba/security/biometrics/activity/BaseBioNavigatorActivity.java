package com.alibaba.security.biometrics.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.WindowManager;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.c.c.a;
import com.alibaba.security.biometrics.c.c.c;
import com.alibaba.security.biometrics.transition.TransitionMode;
import com.alibaba.security.common.d.p;

/* compiled from: Taobao */
public abstract class BaseBioNavigatorActivity extends BaseAlBioActivity {
    private static final String a = "BaseActivity";
    public static final int g = 10002;
    public static final int h = 10004;
    public static final int i = 10005;
    public static final int j = 10009;
    public static final int k = 10010;
    public static final int l = 10012;
    public static final int m = 10013;
    public static final int n = 20002;
    public static final int o = 20003;
    public static final int p = 20004;
    public static final int q = 20005;
    public static final int r = 20006;
    public static final int s = 20007;
    public static final int t = 20008;
    protected static TransitionMode u;

    /* access modifiers changed from: package-private */
    /* renamed from: com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[TransitionMode.values().length];
            a = iArr;
            iArr[TransitionMode.NULL.ordinal()] = 1;
            a[TransitionMode.LEFT.ordinal()] = 2;
            a[TransitionMode.RIGHT.ordinal()] = 3;
            a[TransitionMode.TOP.ordinal()] = 4;
            a[TransitionMode.BOTTOM.ordinal()] = 5;
        }
    }

    public static void a(Activity activity, TransitionMode transitionMode) {
        if (transitionMode == null) {
            activity.overridePendingTransition(0, 0);
            return;
        }
        int i2 = AnonymousClass1.a[transitionMode.ordinal()];
        if (i2 == 1) {
            activity.overridePendingTransition(0, 0);
        } else if (i2 == 2) {
            activity.overridePendingTransition(R.anim.rp_anim_face_right_in, R.anim.rp_anim_face_right_out);
        } else if (i2 == 3) {
            activity.overridePendingTransition(R.anim.rp_anim_face_left_in, R.anim.rp_anim_face_left_out);
        } else if (i2 == 4) {
            activity.overridePendingTransition(R.anim.rp_anim_face_bottom_in, R.anim.rp_anim_face_bottom_out);
        } else if (i2 == 5) {
            activity.overridePendingTransition(R.anim.rp_anim_face_top_in, R.anim.rp_anim_face_top_out);
        }
    }

    private void c() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            } else if (p.a() && a.a(this)) {
                a.a(getWindow());
            } else if (p.c() && c.a(this)) {
                c.a(getWindow());
            }
        } catch (Exception unused) {
            com.alibaba.security.common.c.a.b();
        }
    }

    private void d() {
        getWindow().getDecorView().setSystemUiVisibility(3846);
    }

    public void finish() {
        super.finish();
        try {
            a(this, u);
        } catch (Throwable unused) {
            com.alibaba.security.common.c.a.b();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.activity.BaseAlBioActivity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            } else if (p.a() && a.a(this)) {
                a.a(getWindow());
            } else if (p.c() && c.a(this)) {
                c.a(getWindow());
            }
        } catch (Exception unused) {
            com.alibaba.security.common.c.a.b();
        }
        setVolumeControlStream(3);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        getWindow().setBackgroundDrawableResource(R.drawable.rpsdk_face_win_bg);
        getWindow().addFlags(128);
        getWindow().setFlags(1024, 1024);
        com.alibaba.security.biometrics.c.b.a.b();
        com.alibaba.security.biometrics.c.b.a.c();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.security.biometrics.activity.BaseAlBioActivity
    public void onDestroy() {
        super.onDestroy();
        com.alibaba.security.biometrics.c.b.a.b();
        com.alibaba.security.biometrics.c.b.a.c();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }
}
