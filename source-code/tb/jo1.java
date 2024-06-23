package tb;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.android.launcher.common.Constants;
import com.taobao.android.speed.TBSpeed;
import com.taobao.monitor.impl.common.PageVisibleAlgorithm;
import java.util.HashMap;
import java.util.Random;

/* compiled from: Taobao */
public class jo1 {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final jo1 a = new jo1();
    }

    public static jo1 a() {
        return b.a;
    }

    private void b(Application application, SharedPreferences sharedPreferences, HashMap<String, Object> hashMap) {
        if (mo1.a(hashMap.get(qh2.k), true)) {
            boolean z = sharedPreferences.getBoolean("isApm", true);
            z6.b().c("isApm", z);
            z6.b().c("isApmSpeed", TBSpeed.isSpeedEdition(application, xs1.DEFAULT_SAVE_DIR) & z);
        }
    }

    private void c(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            Object obj = hashMap.get(Constants.PARAMETER_SPEED_DESC);
            if (obj instanceof String) {
                uu0.r = (String) obj;
            } else {
                uu0.r = "normal";
            }
        }
    }

    private void d(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(l6.SPECIAL_PAGE_SAMPLE, "");
        try {
            if (!TextUtils.isEmpty(string)) {
                float nextFloat = new Random(System.currentTimeMillis()).nextFloat();
                i20.a("ParamCache", "computeRandomSample", Float.valueOf(nextFloat));
                String[] split = string.split(",");
                if (split.length > 0) {
                    for (String str : split) {
                        String[] split2 = str.split(":");
                        if (split2.length == 2 && nextFloat < Float.parseFloat(split2[1])) {
                            x32.c(split2[0]);
                            i20.a("ParamCache", l6.SPECIAL_PAGE_SAMPLE, split2[0]);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void e(SharedPreferences sharedPreferences, HashMap<String, Object> hashMap) {
        boolean z = sharedPreferences.getBoolean(l6.GLOBAL_SAMPLE, true);
        i20.a("ParamCache", l6.GLOBAL_SAMPLE, Boolean.valueOf(z));
        boolean z2 = sharedPreferences.getBoolean(l6.UT_NETWORK_SAMPLE, qh2.d);
        qh2.d = z2;
        i20.a("ParamCache", l6.UT_NETWORK_SAMPLE, Boolean.valueOf(z2));
        boolean z3 = sharedPreferences.getBoolean(l6.NEED_ACTIVITY_PAGE, true);
        lc0.a = z3;
        i20.a("ParamCache", l6.NEED_ACTIVITY_PAGE, Boolean.valueOf(z3));
        boolean z4 = z && sharedPreferences.getBoolean(l6.PAGE_LOAD_SAMPLE, lc0.b);
        lc0.b = z4;
        i20.a("ParamCache", l6.PAGE_LOAD_SAMPLE, Boolean.valueOf(z4));
        boolean z5 = z && sharedPreferences.getBoolean(l6.FRAGMENT_PAGE_LOAD_SAMPLE, lc0.j);
        lc0.j = z5;
        i20.a("ParamCache", l6.FRAGMENT_PAGE_LOAD_SAMPLE, Boolean.valueOf(z5));
        boolean z6 = z && sharedPreferences.getBoolean(l6.CUSTOM_PAGE_SAMPLE, lc0.g);
        lc0.g = z6;
        i20.a("ParamCache", l6.CUSTOM_PAGE_SAMPLE, Boolean.valueOf(z6));
        ss1.a = z && sharedPreferences.getBoolean(l6.NEED_PROCEDURE_PARAM_MAP_COPY, false);
        if (qh2.h) {
            g20.a = ss1.a;
        }
        i20.a("ParamCache", l6.NEED_PROCEDURE_PARAM_MAP_COPY, Boolean.valueOf(ss1.a));
        PageVisibleAlgorithm valueOf = PageVisibleAlgorithm.valueOf(sharedPreferences.getInt(l6.DEFAULT_ALGORITHM, qh2.i.ordinal()));
        lc0.n = valueOf;
        i20.a("ParamCache", l6.DEFAULT_ALGORITHM, valueOf);
        lc0.h = z && sharedPreferences.getBoolean(l6.OPEN_BAD_TOKEN_HOOK, true);
        boolean z7 = z && sharedPreferences.getBoolean(l6.NEED_CANVAS_ALGORITHM, lc0.q);
        lc0.q = z7;
        i20.a("ParamCache", l6.NEED_CANVAS_ALGORITHM, Boolean.valueOf(z7));
        boolean z8 = z && sharedPreferences.getBoolean(l6.NEED_SPECIFIC_VIEW_AREA_ALGORITHM, lc0.o);
        lc0.o = z8;
        i20.a("ParamCache", l6.NEED_SPECIFIC_VIEW_AREA_ALGORITHM, Boolean.valueOf(z8));
        boolean z9 = z && sharedPreferences.getBoolean(l6.NEED_SHADOW_ALGORITHM, lc0.p);
        lc0.p = z9;
        i20.a("ParamCache", l6.NEED_SHADOW_ALGORITHM, Boolean.valueOf(z9));
        boolean z10 = z && sharedPreferences.getBoolean(l6.NEED_FPS, lc0.w);
        lc0.w = z10;
        i20.a("ParamCache", l6.NEED_FPS, Boolean.valueOf(z10));
        boolean z11 = z && sharedPreferences.getBoolean(l6.BLOCK_WATCHER_SAMPLE, lc0.x);
        lc0.x = z11;
        i20.a("ParamCache", l6.BLOCK_WATCHER_SAMPLE, Boolean.valueOf(z11));
        boolean z12 = z && sharedPreferences.getBoolean(l6.LOOPER_MONITOR_SAMPLE, lc0.y);
        lc0.y = z12;
        i20.a("ParamCache", l6.LOOPER_MONITOR_SAMPLE, Boolean.valueOf(z12));
        boolean z13 = !z || sharedPreferences.getBoolean(l6.NEED_WEEX_PROCEDURE_PARENT, false);
        lc0.s = z13;
        i20.a("ParamCache", l6.NEED_WEEX_PROCEDURE_PARENT, Boolean.valueOf(z13));
        boolean z14 = !z || sharedPreferences.getBoolean(l6.END_WEEX_PROCEDURE_F2B, false);
        lc0.t = z14;
        i20.a("ParamCache", l6.END_WEEX_PROCEDURE_F2B, Boolean.valueOf(z14));
        boolean z15 = !z || sharedPreferences.getBoolean(l6.SUPPORT_MASTER_VIEW, false);
        lc0.u = z15;
        i20.a("ParamCache", l6.SUPPORT_MASTER_VIEW, Boolean.valueOf(z15));
        boolean z16 = z && sharedPreferences.getBoolean(l6.NEED_DISPATCH_RENDER_STANDARD, true);
        lc0.v = z16;
        i20.a("ParamCache", l6.NEED_DISPATCH_RENDER_STANDARD, Boolean.valueOf(z16));
        boolean z17 = z && sharedPreferences.getBoolean(l6.NEED_FRAME_METRICS, lc0.A);
        lc0.A = z17;
        i20.a("ParamCache", l6.NEED_FRAME_METRICS, Boolean.valueOf(z17));
        boolean z18 = !z || sharedPreferences.getBoolean(l6.NEED_ROLLBACK_FPS, lc0.B);
        lc0.B = z18;
        i20.a("ParamCache", l6.NEED_ROLLBACK_FPS, Boolean.valueOf(z18));
        boolean z19 = z && sharedPreferences.getBoolean(l6.NEED_FIX_WINDOW_HOOK_ERROR, lc0.C);
        lc0.C = z19;
        i20.a("ParamCache", l6.NEED_FIX_WINDOW_HOOK_ERROR, Boolean.valueOf(z19));
        boolean z20 = z && sharedPreferences.getBoolean(l6.NEED_LAUNCH_VISIBLE_CALCULATE_CHANGE, qh2.j);
        qh2.j = z20;
        i20.a("ParamCache", l6.NEED_LAUNCH_VISIBLE_CALCULATE_CHANGE, Boolean.valueOf(z20));
        boolean z21 = z && sharedPreferences.getBoolean(l6.NEED_FIRST_FRAME, lc0.D);
        lc0.D = z21;
        i20.a("ParamCache", l6.NEED_FIRST_FRAME, Boolean.valueOf(z21));
        boolean z22 = z && sharedPreferences.getBoolean(l6.NEXT_LAUNCH_UPLOAD_SAMPLE, lc0.E);
        lc0.E = z22;
        i20.a("ParamCache", l6.NEXT_LAUNCH_UPLOAD_SAMPLE, Boolean.valueOf(z22));
    }

    public void f(Application application, HashMap<String, Object> hashMap) {
        c(hashMap);
        SharedPreferences sharedPreferences = application.getSharedPreferences(xs1.DEFAULT_SAVE_DIR, 0);
        b(application, sharedPreferences, hashMap);
        e(sharedPreferences, hashMap);
        d(sharedPreferences);
    }

    private jo1() {
    }
}
