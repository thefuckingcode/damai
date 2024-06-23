package com.alibaba.verificationsdk.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.verificationsdk.utils.DownloadListener;
import com.alibaba.verificationsdk.utils.ZIPExtracListener;
import com.alibaba.verificationsdk.widgets.ALiLoadingView;
import com.alibaba.verificationsdk.widgets.BallView;
import com.alibaba.verificationsdk.widgets.DrawView;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.youku.arch.v3.data.Constants;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONObject;
import tb.hv2;
import tb.k02;
import tb.th0;
import tb.v81;

/* compiled from: Taobao */
public class VerifyActivity extends Activity {
    public static final int ALIAUTH_CLIENT_ERROR_GENERIC = 50000;
    public static final int ALIAUTH_SERVICE_ERROR_MAXTRY = 60000;
    public static final String APP_DATA = "app_data";
    private static int K = 0;
    private static int L = 0;
    private static String M = null;
    private static String N = null;
    private static String O = "device_type";
    private static String P = "dpi";
    private static String Q = "lang";
    private static String R = "captcha_type";
    private static String S = "phone_number";
    private static String T = "session_id";
    private static String U = "extend_data";
    private static String V = "userInputCaptcha";
    public static final int VERIFY_FAILED = 0;
    public static final int VERIFY_SUCC = 1;
    private static String W = null;
    private static int X = 3;
    private static IActivityCallback Y;
    private static VerifyType Z;
    private static String a0;
    private static String b0;
    private static String c0;
    private Button A = null;
    Runnable B = new Runnable() {
        /* class com.alibaba.verificationsdk.ui.VerifyActivity.AnonymousClass1 */

        public void run() {
            VerifyActivity.this.D.sendEmptyMessage(10000);
        }
    };
    Runnable C = new Runnable() {
        /* class com.alibaba.verificationsdk.ui.VerifyActivity.AnonymousClass2 */

        public void run() {
            VerifyActivity.this.finish();
        }
    };
    Handler D = new h();
    Handler E = new i();
    Handler F = new j();
    Runnable G = new Runnable() {
        /* class com.alibaba.verificationsdk.ui.VerifyActivity.AnonymousClass21 */

        public void run() {
            Message message = new Message();
            String str = null;
            try {
                int i = l.a[VerifyActivity.Z.ordinal()];
                if (i == 2) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put(VerifyActivity.R, "1");
                    hashMap.put(VerifyActivity.S, VerifyActivity.b0);
                    hashMap.put("info_token", VerifyActivity.a0);
                    if (!TextUtils.isEmpty(VerifyActivity.c0)) {
                        hashMap.put("HOSTENV", VerifyActivity.c0);
                    }
                    str = VerifyActivity.this.m.noCaptchaForwardAuth("alibaba.security.jaq.captcha.send", hashMap, VerifyActivity.N, 12);
                } else if (i == 3) {
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    hashMap2.put(VerifyActivity.S, VerifyActivity.b0);
                    hashMap2.put("info_token", VerifyActivity.a0);
                    if (!TextUtils.isEmpty(VerifyActivity.c0)) {
                        hashMap2.put("HOSTENV", VerifyActivity.c0);
                    }
                    str = VerifyActivity.this.m.noCaptchaForwardAuth("alibaba.security.jaq.captcha.audio.send", hashMap2, VerifyActivity.N, 12);
                }
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optBoolean("error", true)) {
                    message.what = 100015;
                    message.arg1 = ERROR_TYPE.ERROR_FROM_SERVER.ordinal();
                    message.arg2 = jSONObject.optInt("code");
                } else {
                    int optInt = jSONObject.optInt("send_status");
                    if (optInt > 0) {
                        message.what = 100014;
                    } else {
                        message.what = 100015;
                        message.arg1 = ERROR_TYPE.ERROR_FROM_BUSSINESS.ordinal();
                        message.arg2 = optInt;
                    }
                }
                message.obj = jSONObject;
            } catch (Exception e) {
                e.printStackTrace();
                message.what = 100015;
                message.arg1 = ERROR_TYPE.ERROR_FROM_CLIENT.ordinal();
                message.arg2 = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
                message.obj = e.getMessage();
            } catch (Throwable th) {
                VerifyActivity.this.F.sendMessage(message);
                throw th;
            }
            VerifyActivity.this.F.sendMessage(message);
        }
    };
    Runnable H = new Runnable() {
        /* class com.alibaba.verificationsdk.ui.VerifyActivity.AnonymousClass22 */

        public void run() {
            Message message = new Message();
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                int i = l.a[VerifyActivity.Z.ordinal()];
                String str = "1";
                if (i != 2 && i == 3) {
                    str = "2";
                }
                hashMap.put(VerifyActivity.R, str);
                hashMap.put(VerifyActivity.S, VerifyActivity.b0);
                hashMap.put(VerifyActivity.T, VerifyActivity.this.v);
                String str2 = null;
                if (VerifyActivity.this.u != null && !TextUtils.isEmpty(VerifyActivity.this.u.getText().toString())) {
                    str2 = VerifyActivity.this.u.getText().toString();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VerifyActivity.V, str2);
                hashMap.put(VerifyActivity.U, jSONObject.toString());
                hashMap.put("info_token", VerifyActivity.a0);
                if (!TextUtils.isEmpty(VerifyActivity.c0)) {
                    hashMap.put("HOSTENV", VerifyActivity.c0);
                }
                JSONObject jSONObject2 = new JSONObject(VerifyActivity.this.m.noCaptchaForwardAuth("alibaba.security.jaq.captcha.verify", hashMap, VerifyActivity.N, 12));
                if (jSONObject2.optBoolean("error", true)) {
                    message.what = 100005;
                    message.arg1 = ERROR_TYPE.ERROR_FROM_SERVER.ordinal();
                    message.arg2 = jSONObject2.optInt("code");
                } else {
                    int optInt = jSONObject2.optInt("verify_status");
                    if (optInt > 0) {
                        message.what = com.taobao.android.dinamicx.e.DX_ERROR_CODE_AST_EVENT_EXECUTE_EXCEPTION;
                    } else {
                        message.what = 100005;
                        message.arg1 = ERROR_TYPE.ERROR_FROM_BUSSINESS.ordinal();
                        message.arg2 = optInt;
                    }
                }
                message.obj = jSONObject2;
            } catch (Exception e) {
                e.printStackTrace();
                message.what = 100005;
                message.arg1 = ERROR_TYPE.ERROR_FROM_CLIENT.ordinal();
                message.arg2 = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
                message.obj = e.getMessage();
            } catch (Throwable th) {
                VerifyActivity.this.E.sendMessage(message);
                throw th;
            }
            VerifyActivity.this.E.sendMessage(message);
        }
    };
    Handler I = new k();
    Runnable J = new Runnable() {
        /* class com.alibaba.verificationsdk.ui.VerifyActivity.AnonymousClass24 */

        public void run() {
            Message message = new Message();
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(VerifyActivity.O, "android");
                int i = VerifyActivity.this.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
                String str = "xhdpi";
                if (i == 120) {
                    str = "ldpi";
                } else if (i == 160) {
                    str = "mdpi";
                } else if (i == 213) {
                    str = "tv";
                } else if (i == 240) {
                    str = "hdpi";
                } else if (i != 320) {
                    if (i == 480) {
                        str = "xxhdpi";
                    } else if (i == 640) {
                        str = "xxxhdpi";
                    }
                }
                hashMap.put(VerifyActivity.P, str);
                hashMap.put(VerifyActivity.Q, Locale.getDefault().toString());
                hashMap.put("info_token", VerifyActivity.a0);
                if (!TextUtils.isEmpty(VerifyActivity.c0)) {
                    hashMap.put("HOSTENV", VerifyActivity.c0);
                }
                String noCaptchaForwardAuth = VerifyActivity.this.m.noCaptchaForwardAuth("alibaba.security.jaq.resource.fetch", hashMap, VerifyActivity.N, 12);
                v81.b("VerifyActivity", "get resource result: " + noCaptchaForwardAuth);
                JSONObject jSONObject = new JSONObject(noCaptchaForwardAuth);
                if (jSONObject.optBoolean("error", true)) {
                    message.what = 100025;
                    message.arg1 = ERROR_TYPE.ERROR_FROM_SERVER.ordinal();
                } else {
                    message.what = 100024;
                }
                message.obj = jSONObject;
            } catch (Exception e) {
                e.printStackTrace();
                message.what = 100025;
                message.arg1 = ERROR_TYPE.ERROR_FROM_CLIENT.ordinal();
                message.obj = e.getMessage();
            } catch (Throwable th) {
                VerifyActivity.this.I.sendMessage(message);
                throw th;
            }
            VerifyActivity.this.I.sendMessage(message);
        }
    };
    private boolean a = false;
    private ALiLoadingView b;
    private LinearLayout c;
    private TextView d = null;
    private TextView e = null;
    private FrameLayout f;
    private BallView g = null;
    private DrawView h = null;
    private ImageView i = null;
    private FrameLayout.LayoutParams j;
    private boolean k = false;
    private View l = null;
    private INoCaptchaComponent m;
    private View n = null;
    private TextView o = null;
    private View p = null;
    private TextView q = null;
    private t r = null;
    private s s = null;
    private EditText t = null;
    private EditText u = null;
    private String v = null;
    private SharedPreferences w = null;
    private k02 x;
    private ALiLoadingView y;
    private FrameLayout z = null;

    /* compiled from: Taobao */
    private enum ERROR_TYPE {
        ERROR_FROM_SERVER,
        ERROR_FROM_CLIENT,
        ERROR_FROM_BUSSINESS
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            if (VerifyActivity.this.r != null) {
                VerifyActivity.this.r.cancel();
            }
            VerifyActivity.this.i0(VerifyType.CALL);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            VerifyActivity.this.p0();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            if (VerifyActivity.Y != null) {
                VerifyActivity.Y.onNotifyBackPressed();
            }
            VerifyActivity.this.finish();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            VerifyActivity.this.e0();
            if (TextUtils.isEmpty(VerifyActivity.this.u.getText().toString())) {
                VerifyActivity verifyActivity = VerifyActivity.this;
                Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
                return;
            }
            VerifyActivity.this.n.setClickable(false);
            VerifyActivity.this.n0();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            VerifyActivity.this.l0();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        final /* synthetic */ Dialog a;

        f(Dialog dialog) {
            this.a = dialog;
        }

        public void onClick(View view) {
            VerifyActivity.this.l0();
            this.a.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class g implements View.OnClickListener {
        final /* synthetic */ Dialog a;

        g(VerifyActivity verifyActivity, Dialog dialog) {
            this.a = dialog;
        }

        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* compiled from: Taobao */
    class h extends Handler {
        h() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0245  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x024b  */
        public void handleMessage(Message message) {
            char c;
            char c2;
            int i;
            int i2;
            int i3;
            Bundle data = message.getData();
            HashMap hashMap = new HashMap();
            int i4 = data.getInt("status");
            int i5 = data.getInt("errorCode");
            float f = data.getFloat("x1");
            float f2 = data.getFloat("y1");
            float f3 = data.getFloat("x2");
            float f4 = data.getFloat("y2");
            String string = data.getString("token");
            String string2 = data.getString("sig");
            String string3 = data.getString("sessionId");
            String format = String.format("nc1-%s-nc2-%s-nc3-%s-nc4-%s", string, string2, string3, VerifyActivity.M);
            int i6 = message.what;
            if (i6 != 1) {
                if (i6 != 2) {
                    switch (i6) {
                        case 10000:
                            v81.b("VerifyActivity", "INIT_START root.getTop(): " + VerifyActivity.this.f.getTop() + " root.getBottom(): " + VerifyActivity.this.f.getBottom());
                            Bitmap decodeResource = BitmapFactory.decodeResource(VerifyActivity.this.getResources(), VerifyActivity.this.getResources().getIdentifier("ali_vsdk_frame", "drawable", VerifyActivity.this.getPackageName()));
                            int i7 = 290;
                            if (decodeResource != null) {
                                i7 = decodeResource.getWidth();
                            }
                            v81.b("VerifyActivity", "INIT_START radius: " + i7);
                            if (VerifyActivity.this.f.getBottom() <= 0) {
                                if ((VerifyActivity.L - VerifyActivity.this.d0()) - 112 > i7) {
                                    i3 = (VerifyActivity.L - VerifyActivity.this.d0()) - 112;
                                } else {
                                    i = (VerifyActivity.L - VerifyActivity.this.d0()) - 112;
                                    if (VerifyActivity.K > i7) {
                                        i2 = VerifyActivity.K - i7;
                                    } else {
                                        i2 = VerifyActivity.K;
                                    }
                                    v81.b("VerifyActivity", "INIT_START width: " + i2 + " height: " + i);
                                    VerifyActivity.this.m.initNoCaptcha(VerifyActivity.M, VerifyActivity.class.getSimpleName(), i2, i, 5, VerifyActivity.this.D, VerifyActivity.N);
                                    return;
                                }
                            } else if (VerifyActivity.this.f.getBottom() - VerifyActivity.this.f.getTop() > i7) {
                                i3 = VerifyActivity.this.f.getBottom() - VerifyActivity.this.f.getTop();
                            } else {
                                i = VerifyActivity.this.f.getBottom() - VerifyActivity.this.f.getTop();
                                if (VerifyActivity.K > i7) {
                                }
                                v81.b("VerifyActivity", "INIT_START width: " + i2 + " height: " + i);
                                VerifyActivity.this.m.initNoCaptcha(VerifyActivity.M, VerifyActivity.class.getSimpleName(), i2, i, 5, VerifyActivity.this.D, VerifyActivity.N);
                                return;
                            }
                            i = i3 - i7;
                            if (VerifyActivity.K > i7) {
                            }
                            v81.b("VerifyActivity", "INIT_START width: " + i2 + " height: " + i);
                            try {
                                VerifyActivity.this.m.initNoCaptcha(VerifyActivity.M, VerifyActivity.class.getSimpleName(), i2, i, 5, VerifyActivity.this.D, VerifyActivity.N);
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        case 10001:
                            VerifyActivity.this.h.setStatus(2);
                            VerifyActivity.this.h.invalidate();
                            VerifyActivity.this.g.setStatus(1);
                            VerifyActivity.this.g.setPositionFinish(VerifyActivity.this.h.getCenterX(), VerifyActivity.this.h.getCenterY());
                            VerifyActivity.this.g.invalidate();
                            sendEmptyMessageDelayed(10002, 200);
                            return;
                        case 10002:
                            VerifyActivity.this.h.setStatus(3);
                            VerifyActivity.this.h.invalidate();
                            VerifyActivity.this.g.setStatus(2);
                            VerifyActivity.this.g.setPositionEnd(VerifyActivity.this.h.getCenterX1(), VerifyActivity.this.h.getCenterY1());
                            VerifyActivity.this.g.invalidate();
                            sendEmptyMessageDelayed(10003, 300);
                            return;
                        case 10003:
                            try {
                                VerifyActivity.this.m.noCaptchaVerification(VerifyActivity.M);
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        default:
                            switch (i6) {
                                case 100001:
                                    VerifyActivity.this.h.setStatus(1);
                                    VerifyActivity.this.h.invalidate();
                                    return;
                                case com.taobao.android.dinamicx.e.DX_ERROR_CODE_METHOD_NODE_EXECUTE_EXCEPTION /*{ENCODED_INT: 100002}*/:
                                    VerifyActivity.this.h.setStatus(0);
                                    VerifyActivity.this.h.invalidate();
                                    return;
                                default:
                                    return;
                            }
                    }
                } else {
                    switch (i4) {
                        case 100:
                            v81.b("VerifyActivity", "SG_NC_VERIFY_START");
                            return;
                        case 101:
                        default:
                            return;
                        case 102:
                            VerifyActivity.this.s.cancel();
                            v81.b("VerifyActivity", String.format("SG_NC_VERI_SUCCEED: status=%d,token =%s,sig=%s,seesionId=%s", Integer.valueOf(i4), string, string2, string3));
                            if (VerifyActivity.Y != null) {
                                hashMap.put(TLogEventConst.PARAM_SESSION_ID, format);
                                VerifyActivity.Y.onResult(VerifyActivity.this.j0(102), hashMap);
                            }
                            VerifyActivity.this.b.setVisibility(4);
                            VerifyActivity.this.b.stopRotationAnimation();
                            VerifyActivity.this.d.setText(VerifyActivity.this.getResources().getIdentifier("ali_vsdk_tips_finish", "string", VerifyActivity.this.getPackageName()));
                            Drawable drawable = VerifyActivity.this.getResources().getDrawable(VerifyActivity.this.getResources().getIdentifier("ali_vsdk_lock_success", "drawable", VerifyActivity.this.getPackageName()));
                            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                            VerifyActivity.this.d.setCompoundDrawables(null, null, null, drawable);
                            VerifyActivity.this.c.setVisibility(0);
                            VerifyActivity verifyActivity = VerifyActivity.this;
                            verifyActivity.D.postDelayed(verifyActivity.C, 300);
                            return;
                        case 103:
                            VerifyActivity.this.s.cancel();
                            VerifyActivity.this.s.start();
                            v81.b("VerifyActivity", "NC_VERI_RETRY");
                            VerifyActivity.this.b.setVisibility(4);
                            VerifyActivity.this.b.stopRotationAnimation();
                            VerifyActivity.this.c.setVisibility(0);
                            v81.b("VerifyActivity", String.format("SG_NC_RETRY:x1=%f,y1=%f,x2=%f,y2=%f", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
                            VerifyActivity.this.f.removeView(VerifyActivity.this.h);
                            VerifyActivity.this.f.removeView(VerifyActivity.this.g);
                            VerifyActivity.this.g.initPostion(f, f2);
                            VerifyActivity.this.h.initPostion(f3, f4);
                            VerifyActivity verifyActivity2 = VerifyActivity.this;
                            verifyActivity2.b0(verifyActivity2.h);
                            VerifyActivity verifyActivity3 = VerifyActivity.this;
                            verifyActivity3.c0(verifyActivity3.g, VerifyActivity.this.j);
                            return;
                        case 104:
                            VerifyActivity.this.s.cancel();
                            v81.b("VerifyActivity", String.format("SG_NC_SERVER_FAULT: status=%d,token =%s,sig=%s,seesionId=%s", Integer.valueOf(i4), string, string2, string3));
                            if (VerifyActivity.Y != null) {
                                hashMap.put(TLogEventConst.PARAM_SESSION_ID, format);
                                VerifyActivity.Y.onResult(VerifyActivity.this.j0(104), hashMap);
                            }
                            VerifyActivity.this.finish();
                            return;
                        case 105:
                            VerifyActivity.this.s.cancel();
                            if (VerifyActivity.Y != null) {
                                hashMap.put("errorCode", String.valueOf(i5));
                                VerifyActivity.Y.onResult(VerifyActivity.this.j0(105), hashMap);
                            }
                            if (1207 == i5) {
                                VerifyActivity verifyActivity4 = VerifyActivity.this;
                                c2 = 1;
                                Toast.makeText(verifyActivity4, verifyActivity4.getString(verifyActivity4.getResources().getIdentifier("ali_vsdk_network_error", "string", VerifyActivity.this.getPackageName())), 1).show();
                            } else {
                                c2 = 1;
                            }
                            VerifyActivity.this.finish();
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(i4);
                            objArr[c2] = Integer.valueOf(i5);
                            v81.b("VerifyActivity", String.format("Verify stage:SG_NC_FAILED: status=%d,errorCode=%d", objArr));
                            return;
                    }
                }
            } else if (i4 == 100) {
                v81.b("VerifyActivity", "SG_NC_INIT_START");
            } else if (i4 == 101) {
                v81.b("VerifyActivity", "NC_VERI_RETRY");
                VerifyActivity.this.b.setVisibility(4);
                VerifyActivity.this.b.stopRotationAnimation();
                VerifyActivity.this.c.setVisibility(0);
                v81.b("VerifyActivity", String.format("x1=%f,y1=%f,x2=%f,y2=%f", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
                VerifyActivity.this.g.init(VerifyActivity.this.x.e("MSA_slide_icon_default", VerifyActivity.this.getResources().getIdentifier("ali_vsdk_ball", "drawable", VerifyActivity.this.getPackageName())), BitmapFactory.decodeResource(VerifyActivity.this.getResources(), VerifyActivity.this.getResources().getIdentifier("ali_vsdk_frame1", "drawable", VerifyActivity.this.getPackageName())));
                VerifyActivity.this.g.initPostion(f, f2);
                VerifyActivity.this.h.initPostion(f3, f4);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 0, f3 + VerifyActivity.this.h.getRadius(), 0, f4 + VerifyActivity.this.h.getRadius());
                scaleAnimation.setDuration(500);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setRepeatCount(-1);
                scaleAnimation.setRepeatMode(2);
                VerifyActivity.this.h.setAnimation(scaleAnimation);
                VerifyActivity verifyActivity5 = VerifyActivity.this;
                verifyActivity5.b0(verifyActivity5.h);
                VerifyActivity verifyActivity6 = VerifyActivity.this;
                verifyActivity6.c0(verifyActivity6.g, VerifyActivity.this.j);
                VerifyActivity.this.s.cancel();
                VerifyActivity.this.s.start();
            } else if (i4 == 104) {
                VerifyActivity.this.s.cancel();
                v81.b("VerifyActivity", "NC_INIT_SERVER_FAULT");
                if (VerifyActivity.Y != null) {
                    hashMap.put(TLogEventConst.PARAM_SESSION_ID, format);
                    VerifyActivity.Y.onResult(VerifyActivity.this.j0(104), hashMap);
                }
                VerifyActivity.this.finish();
                v81.b("VerifyActivity", String.format("SG_NC_INIT_SERVER_FAULT: status=%d,token =%s,sig=%s,seesionId=%s", Integer.valueOf(i4), string, string2, string3));
            } else if (i4 == 105) {
                VerifyActivity.this.s.cancel();
                if (VerifyActivity.Y != null) {
                    hashMap.put("errorCode", String.valueOf(i5));
                    VerifyActivity.Y.onResult(VerifyActivity.this.j0(105), hashMap);
                }
                if (1207 == i5) {
                    VerifyActivity verifyActivity7 = VerifyActivity.this;
                    c = 1;
                    Toast.makeText(verifyActivity7, verifyActivity7.getString(verifyActivity7.getResources().getIdentifier("ali_vsdk_network_error", "string", VerifyActivity.this.getPackageName())), 1).show();
                } else {
                    c = 1;
                }
                VerifyActivity.this.finish();
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(i4);
                objArr2[c] = Integer.valueOf(i5);
                v81.b("VerifyActivity", String.format("Init stage:SG_NC_FAILED: status=%d,errorCode=%d", objArr2));
            }
        }
    }

    /* compiled from: Taobao */
    class i extends Handler {
        i() {
        }

        public void handleMessage(Message message) {
            HashMap hashMap = new HashMap();
            switch (message.what) {
                case com.taobao.android.dinamicx.e.DX_ERROR_CODE_AST_EVENT_HANDLER_NOT_FOUND /*{ENCODED_INT: 100003}*/:
                    VerifyActivity.this.o.setText(VerifyActivity.this.x.h("MSA_submit_button_waiting", VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_in_progress", "string", VerifyActivity.this.getPackageName())));
                    VerifyActivity.this.y.setVisibility(0);
                    VerifyActivity.this.y.startRotationAnimation();
                    new Thread(VerifyActivity.this.H).start();
                    return;
                case com.taobao.android.dinamicx.e.DX_ERROR_CODE_AST_EVENT_EXECUTE_EXCEPTION /*{ENCODED_INT: 100004}*/:
                    VerifyActivity.this.o.setText(VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_submit", "string", VerifyActivity.this.getPackageName()));
                    VerifyActivity.this.y.setVisibility(4);
                    VerifyActivity.this.y.stopRotationAnimation();
                    if (VerifyActivity.Y != null) {
                        hashMap.put(TLogEventConst.PARAM_SESSION_ID, VerifyActivity.this.v);
                        VerifyActivity.Y.onResult(1, hashMap);
                    }
                    VerifyActivity.this.finish();
                    return;
                case 100005:
                    if (VerifyActivity.this.p != null) {
                        VerifyActivity.this.p.setVisibility(0);
                    }
                    VerifyActivity.this.o.setText(VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_submit", "string", VerifyActivity.this.getPackageName()));
                    VerifyActivity.this.y.setVisibility(4);
                    VerifyActivity.this.y.stopRotationAnimation();
                    VerifyActivity.this.n.setClickable(true);
                    if (VerifyActivity.this.q != null) {
                        VerifyActivity.this.q.setClickable(true);
                    }
                    if (VerifyActivity.Z == VerifyType.SMS) {
                        VerifyActivity verifyActivity = VerifyActivity.this;
                        Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_error", "string", VerifyActivity.this.getPackageName()), 1).show();
                    } else if (VerifyActivity.Z == VerifyType.CALL) {
                        VerifyActivity verifyActivity2 = VerifyActivity.this;
                        Toast.makeText(verifyActivity2, verifyActivity2.getResources().getIdentifier("ali_vsdk_verify_error_call", "string", VerifyActivity.this.getPackageName()), 1).show();
                    }
                    ERROR_TYPE error_type = ERROR_TYPE.values()[message.arg1];
                    int i = l.b[error_type.ordinal()];
                    if (i == 1) {
                        JSONObject jSONObject = (JSONObject) message.obj;
                        v81.a("VerifyActivity", jSONObject.optString("msg"));
                        v81.a("VerifyActivity", jSONObject.optString("sub_msg"));
                        hashMap.put("errorMsg", jSONObject.optString("msg") + ": " + jSONObject.optString("sub_msg"));
                    } else if (i == 2) {
                        Object obj = message.obj;
                        if (obj == null) {
                            obj = "";
                        }
                        v81.a("VerifyActivity", (String) obj);
                        hashMap.put("errorMsg", (String) message.obj);
                    } else if (i == 3) {
                        VerifyActivity verifyActivity3 = VerifyActivity.this;
                        v81.a("VerifyActivity", verifyActivity3.getString(verifyActivity3.getResources().getIdentifier("ali_vsdk_verify_error", "string", VerifyActivity.this.getPackageName())));
                        VerifyActivity verifyActivity4 = VerifyActivity.this;
                        hashMap.put("errorMsg", verifyActivity4.getString(verifyActivity4.getResources().getIdentifier("ali_vsdk_verify_error", "string", VerifyActivity.this.getPackageName())));
                    }
                    if (VerifyActivity.Y != null && VerifyActivity.E() <= 0) {
                        hashMap.put("code", String.valueOf(message.arg2));
                        hashMap.put(TLogEventConst.PARAM_SESSION_ID, VerifyActivity.this.v);
                        hashMap.put("errorCode", error_type.name());
                        VerifyActivity.Y.onResult(0, hashMap);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: Taobao */
    class j extends Handler {
        j() {
        }

        public void handleMessage(Message message) {
            HashMap hashMap = new HashMap();
            switch (message.what) {
                case 100013:
                    new Thread(VerifyActivity.this.G).start();
                    return;
                case 100014:
                    VerifyActivity.this.v = ((JSONObject) message.obj).optString("session_id");
                    return;
                case 100015:
                    VerifyActivity.this.v = null;
                    hashMap.put("code", String.valueOf(message.arg2));
                    ERROR_TYPE error_type = ERROR_TYPE.values()[message.arg1];
                    hashMap.put("errorCode", error_type.name());
                    int i = l.b[error_type.ordinal()];
                    if (i == 1) {
                        JSONObject jSONObject = (JSONObject) message.obj;
                        v81.a("VerifyActivity", jSONObject.optString("msg"));
                        v81.a("VerifyActivity", jSONObject.optString("sub_msg"));
                        hashMap.put("errorMsg", jSONObject.optString("msg") + ": " + jSONObject.optString("sub_msg"));
                        return;
                    } else if (i == 2) {
                        v81.a("VerifyActivity", (String) message.obj);
                        hashMap.put("errorMsg", (String) message.obj);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* compiled from: Taobao */
    class k extends Handler {

        /* compiled from: Taobao */
        class a implements DownloadListener {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            /* renamed from: com.alibaba.verificationsdk.ui.VerifyActivity$k$a$a  reason: collision with other inner class name */
            /* compiled from: Taobao */
            class C0111a implements ZIPExtracListener {
                C0111a() {
                }

                @Override // com.alibaba.verificationsdk.utils.ZIPExtracListener
                public void unzipFinished(File file, File file2) {
                    v81.b("VerifyActivity", "update resources finished! " + file2.getAbsolutePath());
                    VerifyActivity.this.w.edit().putString("version", a.this.b).apply();
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    VerifyActivity.this.I.sendEmptyMessage(100026);
                }

                @Override // com.alibaba.verificationsdk.utils.ZIPExtracListener
                public void unzipStart() {
                }
            }

            a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // com.alibaba.verificationsdk.utils.DownloadListener
            public void downloadFinished(File file) {
                if (file == null || !file.exists()) {
                    VerifyActivity.this.I.sendEmptyMessage(100026);
                    return;
                }
                try {
                    MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        } else if (instance != null) {
                            instance.update(bArr, 0, read);
                        }
                    }
                    if (TextUtils.isEmpty(this.a) || instance == null) {
                        VerifyActivity.this.I.sendEmptyMessage(100026);
                    } else if (this.a.equals(VerifyActivity.this.s0(instance.digest()).toLowerCase())) {
                        new com.alibaba.verificationsdk.utils.b(file.getAbsolutePath(), VerifyActivity.W, null, true, new C0111a()).execute(new Void[0]);
                    } else {
                        VerifyActivity.this.I.sendEmptyMessage(100026);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    VerifyActivity.this.I.sendEmptyMessage(100026);
                }
            }

            @Override // com.alibaba.verificationsdk.utils.DownloadListener
            public void downloadStart() {
            }
        }

        k() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 100023:
                    new Thread(VerifyActivity.this.J).start();
                    return;
                case 100024:
                    JSONObject jSONObject = (JSONObject) message.obj;
                    String optString = jSONObject.optString("md5");
                    String optString2 = jSONObject.optString("version");
                    String string = VerifyActivity.this.w.getString("version", "0.0.0.0");
                    if (TextUtils.isEmpty(optString2) || !hv2.b(string, optString2)) {
                        VerifyActivity.this.I.sendEmptyMessage(100026);
                        return;
                    }
                    v81.b("VerifyActivity", "new resource version is coming, upgrading now!");
                    new com.alibaba.verificationsdk.utils.a(jSONObject.optString("url"), VerifyActivity.this.getFilesDir().getAbsolutePath(), null, new a(optString, optString2)).execute(new Void[0]);
                    return;
                case 100025:
                    int i = l.b[ERROR_TYPE.values()[message.arg1].ordinal()];
                    if (i == 1) {
                        JSONObject jSONObject2 = (JSONObject) message.obj;
                        v81.a("VerifyActivity", jSONObject2.optString("msg"));
                        v81.a("VerifyActivity", jSONObject2.optString("sub_msg"));
                    } else if (i == 2) {
                        Object obj = message.obj;
                        if (obj == null) {
                            obj = "";
                        }
                        v81.a("VerifyActivity", (String) obj);
                    }
                    VerifyActivity.this.I.sendEmptyMessage(100026);
                    return;
                case 100026:
                    VerifyActivity.this.k0();
                    VerifyActivity.this.b.setVisibility(4);
                    VerifyActivity.this.b.stopRotationAnimation();
                    VerifyActivity.this.i0(VerifyActivity.Z);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class l {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            int[] iArr = new int[ERROR_TYPE.values().length];
            b = iArr;
            try {
                iArr[ERROR_TYPE.ERROR_FROM_SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ERROR_TYPE.ERROR_FROM_CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ERROR_TYPE.ERROR_FROM_BUSSINESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[VerifyType.values().length];
            a = iArr2;
            iArr2[VerifyType.NOCAPTCHA.ordinal()] = 1;
            a[VerifyType.SMS.ordinal()] = 2;
            a[VerifyType.CALL.ordinal()] = 3;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class m implements View.OnClickListener {
        m() {
        }

        public void onClick(View view) {
            if (VerifyActivity.Y != null) {
                VerifyActivity.Y.onNotifyBackPressed();
            }
            VerifyActivity.this.finish();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class n implements View.OnTouchListener {
        n() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0034, code lost:
            if (r6 != 3) goto L_0x0289;
         */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            v81.b("VerifyActivity", "x: " + motionEvent.getX() + " y: " + motionEvent.getY());
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (motionEvent.getX() < VerifyActivity.this.g.getRadiusTouch() || motionEvent.getX() > ((float) VerifyActivity.K) - VerifyActivity.this.g.getRadiusTouch() || motionEvent.getY() < VerifyActivity.this.g.getRadiusTouch() || motionEvent.getY() > ((float) (VerifyActivity.this.f.getBottom() - VerifyActivity.this.f.getTop())) - VerifyActivity.this.g.getRadiusTouch() || !VerifyActivity.this.k) {
                            return true;
                        }
                        VerifyActivity.this.g.setPosition(motionEvent.getX(), motionEvent.getY());
                        VerifyActivity.this.g.invalidate();
                        try {
                            VerifyActivity.this.m.putNoCaptchaTraceRecord(motionEvent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (motionEvent.getX() < VerifyActivity.this.h.getBoundaryLeft() || motionEvent.getX() > VerifyActivity.this.h.getBoundaryRight() || motionEvent.getY() < VerifyActivity.this.h.getBoundaryTop() || motionEvent.getY() > VerifyActivity.this.h.getBoundaryBottom()) {
                            if (VerifyActivity.this.a) {
                                VerifyActivity.this.a = false;
                                VerifyActivity.this.r0();
                            }
                        } else if (!VerifyActivity.this.k) {
                            return true;
                        } else {
                            VerifyActivity.this.q0();
                            VerifyActivity.this.a = true;
                        }
                    }
                }
                if (motionEvent.getX() < VerifyActivity.this.h.getBoundaryLeft() || motionEvent.getX() > VerifyActivity.this.h.getBoundaryRight() || motionEvent.getY() < VerifyActivity.this.h.getBoundaryTop() || motionEvent.getY() > VerifyActivity.this.h.getBoundaryBottom()) {
                    VerifyActivity.this.g.resetPostion();
                    VerifyActivity.this.g.invalidate();
                } else if (!VerifyActivity.this.k) {
                    return true;
                } else {
                    VerifyActivity.this.o0();
                }
            } else {
                v81.b("VerifyActivity", "draw:  left: " + VerifyActivity.this.g.getLeft() + " right: " + VerifyActivity.this.g.getRight() + " top: " + VerifyActivity.this.g.getTop() + " bottom: " + VerifyActivity.this.g.getBottom());
                if (motionEvent.getX() < VerifyActivity.this.g.getInitLeft() || motionEvent.getX() > VerifyActivity.this.g.getInitRight() || motionEvent.getY() < VerifyActivity.this.g.getInitTop() || motionEvent.getY() > VerifyActivity.this.g.getInitBottom()) {
                    VerifyActivity.this.k = false;
                    v81.b("VerifyActivity", "isFingerValid = " + VerifyActivity.this.k);
                } else {
                    VerifyActivity.this.k = true;
                    v81.b("VerifyActivity", "isFingerValid = " + VerifyActivity.this.k);
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class o implements View.OnClickListener {
        o() {
        }

        public void onClick(View view) {
            if (VerifyActivity.this.f != null) {
                VerifyActivity.this.f.removeView(VerifyActivity.this.z);
                VerifyActivity.this.f.invalidate();
                VerifyActivity.this.i0(VerifyActivity.Z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class p implements View.OnClickListener {
        p() {
        }

        public void onClick(View view) {
            if (VerifyActivity.Y != null) {
                VerifyActivity.Y.onNotifyBackPressed();
            }
            VerifyActivity.this.finish();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class q implements View.OnClickListener {
        q() {
        }

        public void onClick(View view) {
            VerifyActivity.this.e0();
            if (TextUtils.isEmpty(VerifyActivity.this.u.getText().toString())) {
                VerifyActivity verifyActivity = VerifyActivity.this;
                Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
                return;
            }
            VerifyActivity.this.n.setClickable(false);
            VerifyActivity.this.n0();
        }
    }

    /* compiled from: Taobao */
    public class r extends PasswordTransformationMethod {

        /* compiled from: Taobao */
        private class a implements CharSequence {
            private CharSequence a;

            public a(r rVar, CharSequence charSequence) {
                this.a = charSequence;
            }

            public char charAt(int i) {
                if (i <= 2 || i >= 9) {
                    return this.a.charAt(i);
                }
                return '*';
            }

            public int length() {
                return this.a.length();
            }

            public CharSequence subSequence(int i, int i2) {
                return this.a.subSequence(i, i2);
            }
        }

        public r(VerifyActivity verifyActivity) {
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            return new a(this, charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class s extends CountDownTimer {
        public s(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            if (VerifyActivity.this.z != null && VerifyActivity.this.f != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                VerifyActivity verifyActivity = VerifyActivity.this;
                verifyActivity.c0(verifyActivity.z, layoutParams);
            }
        }

        public void onTick(long j) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class t extends CountDownTimer {
        public t(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            if (VerifyActivity.this.q != null) {
                VerifyActivity.this.q.setClickable(true);
                VerifyActivity.this.q.setText(VerifyActivity.this.getResources().getIdentifier("ali_vsdk_verify_sms_send_code", "string", VerifyActivity.this.getPackageName()));
                VerifyActivity.this.q.setTextColor(Color.parseColor("#1475ea"));
            }
            if (VerifyActivity.this.p != null) {
                VerifyActivity.this.p.setVisibility(0);
            }
            VerifyActivity.E();
        }

        public void onTick(long j) {
            if (VerifyActivity.this.q != null) {
                TextView textView = VerifyActivity.this.q;
                VerifyActivity verifyActivity = VerifyActivity.this;
                textView.setText(verifyActivity.getString(verifyActivity.getResources().getIdentifier("ali_vsdk_verify_sms_timeout", "string", VerifyActivity.this.getPackageName()), new Object[]{Long.valueOf(j / 1000)}));
                VerifyActivity.this.q.setTextColor(Color.parseColor("#adadad"));
            }
        }
    }

    static /* synthetic */ int E() {
        int i2 = X - 1;
        X = i2;
        return i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e0() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager.isActive() && getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k0() {
        String a2 = th0.a(new File(W + File.separator + "config.json"));
        if (!TextUtils.isEmpty(a2)) {
            this.x.c(a2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l0() {
        this.n.setAlpha(1.0f);
        this.n.setClickable(true);
        this.n.setEnabled(true);
        this.o.setTextColor(-1);
        TextView textView = (TextView) findViewById(getResources().getIdentifier("tips_sub", "id", getPackageName()));
        this.e = textView;
        textView.setVisibility(0);
        this.q.setClickable(false);
        this.q.setText(getString(getResources().getIdentifier("ali_vsdk_verify_sms_timeout", "string", getPackageName()), new Object[]{60}));
        this.q.setTextColor(Color.parseColor("#adadad"));
        this.r.cancel();
        this.r.start();
        this.F.sendEmptyMessage(100013);
    }

    private void m0() {
        this.I.sendEmptyMessage(100023);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n0() {
        this.E.sendEmptyMessage(com.taobao.android.dinamicx.e.DX_ERROR_CODE_AST_EVENT_HANDLER_NOT_FOUND);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o0() {
        this.D.sendEmptyMessage(10001);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p0() {
        this.q.setClickable(false);
        this.q.setText(getString(getResources().getIdentifier("ali_vsdk_verify_sms_timeout", "string", getPackageName()), new Object[]{60}));
        this.q.setTextColor(Color.parseColor("#adadad"));
        this.r.cancel();
        this.r.start();
        this.F.sendEmptyMessage(100013);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q0() {
        this.D.sendEmptyMessage(100001);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void r0() {
        this.D.sendEmptyMessage(com.taobao.android.dinamicx.e.DX_ERROR_CODE_METHOD_NODE_EXECUTE_EXCEPTION);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String s0(byte[] bArr) {
        char[] cArr = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(cArr[(bArr[i2] & 240) >>> 4]);
            sb.append(cArr[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void b0(View view) {
        try {
            this.f.addView(view);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void c0(View view, FrameLayout.LayoutParams layoutParams) {
        try {
            this.f.addView(view, layoutParams);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public int d0() {
        int dimensionPixelSize = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", Constants.DIMEN, "android"));
        v81.b("VerifyActivity", "get status bar height : " + dimensionPixelSize);
        return dimensionPixelSize;
    }

    /* access modifiers changed from: package-private */
    public void f0() {
        X = 3;
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify_call", "layout", getPackageName()));
        EditText editText = (EditText) findViewById(getResources().getIdentifier("number_et", "id", getPackageName()));
        this.t = editText;
        editText.setText(b0);
        this.t.setTransformationMethod(new r(this));
        this.u = (EditText) findViewById(getResources().getIdentifier("code_et", "id", getPackageName()));
        View findViewById = findViewById(getResources().getIdentifier("left_top_layout", "id", getPackageName()));
        this.l = findViewById;
        findViewById.setOnClickListener(new c());
        View findViewById2 = findViewById(getResources().getIdentifier("btn_submit", "id", getPackageName()));
        this.n = findViewById2;
        findViewById2.setEnabled(false);
        this.n.setClickable(false);
        this.o = (TextView) findViewById(getResources().getIdentifier("submit_tx", "id", getPackageName()));
        this.n.setOnClickListener(new d());
        this.u.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.alibaba.verificationsdk.ui.VerifyActivity.AnonymousClass14 */

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                VerifyActivity.this.e0();
                if (i != VerifyActivity.this.getResources().getIdentifier("submit", "id", VerifyActivity.this.getPackageName()) && i != 0) {
                    return false;
                }
                if (TextUtils.isEmpty(VerifyActivity.this.u.getText().toString())) {
                    VerifyActivity verifyActivity = VerifyActivity.this;
                    Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
                    return true;
                }
                VerifyActivity.this.n.setClickable(false);
                VerifyActivity.this.n0();
                return true;
            }
        });
        this.y = (ALiLoadingView) findViewById(getResources().getIdentifier("submit_loading", "id", getPackageName()));
        this.q = (TextView) findViewById(getResources().getIdentifier("verify_send_code", "id", getPackageName()));
        this.r = new t(DateUtils.MILLIS_PER_MINUTE, 1000);
        this.q.setOnClickListener(new e());
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.show();
        create.getWindow().setContentView(getResources().getIdentifier("ali_vsdk_call_tips", "layout", getPackageName()));
        ((TextView) create.getWindow().findViewById(getResources().getIdentifier("message", "id", getPackageName()))).setText(getResources().getIdentifier("ali_vsdk_verify_call_goto_tips", "string", getPackageName()));
        create.getWindow().findViewById(getResources().getIdentifier("ok", "id", getPackageName())).setOnClickListener(new f(create));
        create.getWindow().findViewById(getResources().getIdentifier("cancel", "id", getPackageName())).setOnClickListener(new g(this, create));
        ImageView imageView = (ImageView) findViewById(getResources().getIdentifier("logo", "id", getPackageName()));
        this.i = imageView;
        this.x.i(imageView, "MSA_logo_power_by", getResources().getIdentifier("ali_vsdk_logo", "drawable", getPackageName()));
    }

    /* access modifiers changed from: package-private */
    public void g0() {
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify_nocaptcha", "layout", getPackageName()));
        ALiLoadingView aLiLoadingView = (ALiLoadingView) findViewById(getResources().getIdentifier("check_login_loading", "id", getPackageName()));
        this.b = aLiLoadingView;
        aLiLoadingView.startRotationAnimation();
        this.f = (FrameLayout) findViewById(getResources().getIdentifier("root", "id", getPackageName()));
        View findViewById = findViewById(getResources().getIdentifier("left_top_layout", "id", getPackageName()));
        this.l = findViewById;
        findViewById.setOnClickListener(new m());
        this.d = (TextView) findViewById(getResources().getIdentifier("tips", "id", getPackageName()));
        this.e = (TextView) findViewById(getResources().getIdentifier("tips_sub", "id", getPackageName()));
        LinearLayout linearLayout = (LinearLayout) findViewById(getResources().getIdentifier("content", "id", getPackageName()));
        this.c = linearLayout;
        linearLayout.setVisibility(4);
        this.g = new BallView(this);
        this.j = new FrameLayout.LayoutParams(-2, -2);
        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        K = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        L = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        v81.b("VerifyActivity", "displayMetrics.widthPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) + " displayMetrics.heightPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics2);
        v81.b("VerifyActivity", "displayMetrics.widthPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2) + " displayMetrics.heightPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2));
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics2);
            v81.b("VerifyActivity", "displayMetrics.widthPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2) + " displayMetrics.heightPixels: " + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        v81.b("VerifyActivity", "displayMetrics.densityDpi: " + displayMetrics2.densityDpi);
        v81.b("VerifyActivity", "onCreate root.getTop(): " + this.f.getTop() + " root.getBottom(): " + this.f.getBottom());
        StringBuilder sb = new StringBuilder();
        sb.append("onCreate orientation: ");
        sb.append(getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait");
        v81.b("VerifyActivity", sb.toString());
        int i2 = K;
        int i3 = L;
        if (i2 > i3) {
            L = i2;
            K = i3;
        }
        ImageView imageView = (ImageView) findViewById(getResources().getIdentifier("logo", "id", getPackageName()));
        this.i = imageView;
        this.x.i(imageView, "MSA_logo_power_by", getResources().getIdentifier("ali_vsdk_logo", "drawable", getPackageName()));
        this.h = new DrawView(this);
        this.g.setOnTouchListener(new n());
        FrameLayout frameLayout = new FrameLayout(this);
        this.z = frameLayout;
        frameLayout.setBackgroundColor(-1);
        this.z.setAlpha(0.94f);
        Button button = new Button(this);
        this.A = button;
        button.setTextColor(Color.parseColor("#56adff"));
        this.A.setTextSize(19.0f);
        this.A.setText(getResources().getIdentifier("ali_vsdk_refresh", "string", getPackageName()));
        this.A.setSingleLine(true);
        this.A.setBackgroundResource(getResources().getIdentifier("ali_vsdk_rect_blue", "drawable", getPackageName()));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.A.setPadding(60, 20, 60, 20);
        this.z.addView(this.A, layoutParams);
        this.z.setClickable(true);
        this.z.setEnabled(true);
        this.A.setOnClickListener(new o());
        getWindow().getDecorView().post(new Runnable() {
            /* class com.alibaba.verificationsdk.ui.VerifyActivity.AnonymousClass6 */

            public void run() {
                VerifyActivity verifyActivity = VerifyActivity.this;
                verifyActivity.D.post(verifyActivity.B);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void h0() {
        X = 3;
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify_sms", "layout", getPackageName()));
        EditText editText = (EditText) findViewById(getResources().getIdentifier("number_et", "id", getPackageName()));
        this.t = editText;
        editText.setText(b0);
        this.t.setTransformationMethod(new r(this));
        this.u = (EditText) findViewById(getResources().getIdentifier("code_et", "id", getPackageName()));
        View findViewById = findViewById(getResources().getIdentifier("left_top_layout", "id", getPackageName()));
        this.l = findViewById;
        findViewById.setOnClickListener(new p());
        this.n = findViewById(getResources().getIdentifier("btn_submit", "id", getPackageName()));
        this.o = (TextView) findViewById(getResources().getIdentifier("submit_tx", "id", getPackageName()));
        this.n.setOnClickListener(new q());
        this.u.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.alibaba.verificationsdk.ui.VerifyActivity.AnonymousClass9 */

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                VerifyActivity.this.e0();
                if (i != VerifyActivity.this.getResources().getIdentifier("submit", "id", VerifyActivity.this.getPackageName()) && i != 0) {
                    return false;
                }
                if (TextUtils.isEmpty(VerifyActivity.this.u.getText().toString())) {
                    VerifyActivity verifyActivity = VerifyActivity.this;
                    Toast.makeText(verifyActivity, verifyActivity.getResources().getIdentifier("ali_vsdk_verify_no_code", "string", VerifyActivity.this.getPackageName()), 1).show();
                    return true;
                }
                VerifyActivity.this.n.setClickable(false);
                VerifyActivity.this.n0();
                return true;
            }
        });
        this.y = (ALiLoadingView) findViewById(getResources().getIdentifier("submit_loading", "id", getPackageName()));
        View findViewById2 = findViewById(getResources().getIdentifier("btn_call", "id", getPackageName()));
        this.p = findViewById2;
        findViewById2.setVisibility(4);
        this.p.setOnClickListener(new a());
        this.q = (TextView) findViewById(getResources().getIdentifier("verify_send_code", "id", getPackageName()));
        this.r = new t(DateUtils.MILLIS_PER_MINUTE, 1000);
        this.q.setOnClickListener(new b());
        ImageView imageView = (ImageView) findViewById(getResources().getIdentifier("logo", "id", getPackageName()));
        this.i = imageView;
        this.x.i(imageView, "MSA_logo_power_by", getResources().getIdentifier("ali_vsdk_logo", "drawable", getPackageName()));
        p0();
    }

    /* access modifiers changed from: package-private */
    public void i0(VerifyType verifyType) {
        Z = verifyType;
        int i2 = l.a[Z.ordinal()];
        if (i2 == 1) {
            g0();
        } else if (i2 == 2) {
            h0();
        } else if (i2 == 3) {
            f0();
        }
    }

    /* access modifiers changed from: package-private */
    public int j0(int i2) {
        return (i2 == 104 || i2 == 105) ? 0 : 1;
    }

    public void onBackPressed() {
        IActivityCallback iActivityCallback = Y;
        if (iActivityCallback != null) {
            iActivityCallback.onNotifyBackPressed();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getResources().getIdentifier("ali_vsdk_activity_verify", "layout", getPackageName()));
        ALiLoadingView aLiLoadingView = (ALiLoadingView) findViewById(getResources().getIdentifier("check_login_loading", "id", getPackageName()));
        this.b = aLiLoadingView;
        aLiLoadingView.startRotationAnimation();
        String str = getFilesDir().getAbsolutePath() + File.separator + "res";
        W = str;
        this.x = new k02(this, str);
        this.w = getPreferences(0);
        m0();
        try {
            this.m = SecurityGuardManager.getInstance(getApplicationContext()).getNoCaptchaComp();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.s = new s(DateUtils.MILLIS_PER_MINUTE, 1000);
    }

    public void onDestroy() {
        super.onDestroy();
        t tVar = this.r;
        if (tVar != null) {
            tVar.cancel();
        }
        s sVar = this.s;
        if (sVar != null) {
            sVar.cancel();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f != null) {
            v81.b("VerifyActivity", "onResume root.getTop(): " + this.f.getTop() + " root.getBottom(): " + this.f.getBottom());
        }
    }

    public void onStart() {
        super.onStart();
        if (this.f != null) {
            v81.b("VerifyActivity", "onStart root.getTop(): " + this.f.getTop() + " root.getBottom(): " + this.f.getBottom());
        }
    }

    public void onStop() {
        super.onStop();
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacks(this.B);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
