package com.taobao.android.sopatch.core;

import android.os.SystemClock;
import android.text.TextUtils;
import com.taobao.android.sopatch.download.FileDownloader;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.io.File;
import java.util.List;
import tb.ic2;
import tb.jc2;
import tb.kc2;
import tb.lc2;
import tb.mc2;
import tb.oc2;
import tb.pc2;
import tb.ps0;
import tb.rc2;
import tb.rh0;
import tb.s91;
import tb.sc2;
import tb.ta1;
import tb.tc2;

/* compiled from: Taobao */
public class SoPatchLogicImpl2 implements SoPatchLogic {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements FileDownloader.Callback {
        final /* synthetic */ Runnable a;

        a(SoPatchLogicImpl2 soPatchLogicImpl2, Runnable runnable) {
            this.a = runnable;
        }

        @Override // com.taobao.android.sopatch.download.FileDownloader.Callback
        public void onFail() {
        }

        @Override // com.taobao.android.sopatch.download.FileDownloader.Callback
        public void onSuccess() {
            ps0.d().c().execute(this.a);
        }
    }

    private boolean c(jc2 jc2) {
        return TextUtils.equals(jc2.a(), ps0.d().a());
    }

    private boolean d(sc2 sc2) {
        List<pc2> b = sc2.b();
        if (b == null || b.size() == 0) {
            return false;
        }
        for (pc2 pc2 : b) {
            if (!rc2.a(pc2)) {
                return false;
            }
        }
        return true;
    }

    private void e(final jc2 jc2, final sc2 sc2, final long j) {
        tc2.b(sc2, new a(this, new Runnable() {
            /* class com.taobao.android.sopatch.core.SoPatchLogicImpl2.AnonymousClass1 */

            public void run() {
                File e = rh0.e(sc2);
                if (e == null || !TextUtils.equals(sc2.c(), ta1.a(e))) {
                    oc2.a(false, jc2.e(), "download", SystemClock.uptimeMillis() - j, -1, sc2.g(), (long) sc2.d());
                    return;
                }
                SoPatchLogicImpl2.this.f(jc2, sc2, j);
            }
        }));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(jc2 jc2, sc2 sc2, long j) {
        sc2.e(tc2.d(sc2));
        if (d(sc2)) {
            oc2.a(true, jc2.e(), "download", SystemClock.uptimeMillis() - j, 0, sc2.g(), (long) sc2.d());
            lc2 b = kc2.b(sc2, "remote");
            if (b.f() > 0) {
                mc2.c().d(b);
                oc2.a(true, jc2.e(), "install", 0, 0, b.toString(), (long) sc2.d());
            } else {
                oc2.a(false, jc2.e(), "install", 0, -1, b.toString(), (long) sc2.d());
            }
            s91.b("SoPatchLogicImpl", TLogEventConst.PARAM_UPLOAD_STAGE, "remote", "so patch ready", b.toString());
        } else {
            oc2.a(false, jc2.e(), "download", SystemClock.uptimeMillis() - j, -1, sc2.g(), (long) sc2.d());
        }
        ic2.a(jc2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(jc2 jc2) {
        String str = "remote";
        if (jc2 == null) {
            oc2.a(false, "", "revupdate", 0, -1, "格式出错", 0);
            s91.b("SoPatchLogicImpl", "exception", str, "configure == null");
        } else if (!c(jc2)) {
            rh0.a();
            s91.b("SoPatchLogicImpl", "exception", str, "checkAppVersionValid");
        } else {
            List<sc2> b = jc2.b();
            if (b == null || b.size() == 0) {
                oc2.a(false, jc2.e(), "revupdate", 0, -1, "无patch", 0);
                s91.b("SoPatchLogicImpl", "exception", str, "no zip file");
                return;
            }
            for (sc2 sc2 : b) {
                long uptimeMillis = SystemClock.uptimeMillis();
                oc2.a(true, jc2.e(), "revupdate", 0, 0, sc2.g(), (long) sc2.d());
                if (tc2.a(sc2)) {
                    s91.b("SoPatchLogicImpl", TLogEventConst.PARAM_UPLOAD_STAGE, str, "zip file valid");
                    f(jc2, sc2, uptimeMillis);
                } else {
                    s91.a("SoPatchLogicImpl", "exception", str, "zip file invalid");
                    e(jc2, sc2, uptimeMillis);
                }
                str = str;
            }
        }
    }

    private boolean h(sc2 sc2) {
        List<pc2> b = sc2.b();
        return b == null || b.size() == 0;
    }

    @Override // com.taobao.android.sopatch.core.SoPatchLogic
    public void loadLocalPatch(jc2 jc2) {
        String str = "local";
        if (jc2 == null) {
            oc2.a(false, "", "revupdate", 0, -1, "格式出错", 0);
            s91.b("SoPatchLogicImpl", "exception", str, "configure == null");
        } else if (!c(jc2)) {
            rh0.a();
            s91.b("SoPatchLogicImpl", "exception", str, "checkAppVersionValid");
        } else {
            List<sc2> b = jc2.b();
            if (b == null || b.size() == 0) {
                oc2.a(false, jc2.e(), "revupdate", 0, -1, "无patch", 0);
                s91.b("SoPatchLogicImpl", "exception", str, "no zip file");
                return;
            }
            for (sc2 sc2 : b) {
                oc2.a(true, jc2.e(), "revupdate", 0, 0, sc2.g(), (long) sc2.d());
                if (h(sc2)) {
                    sc2.e(tc2.d(sc2));
                }
                if (d(sc2)) {
                    oc2.a(true, jc2.e(), "download", 0, 0, sc2.g(), (long) sc2.d());
                    lc2 b2 = kc2.b(sc2, jc2.e());
                    if (b2.f() > 0) {
                        mc2.c().d(b2);
                        oc2.a(true, jc2.e(), "install", 0, 0, b2.toString(), (long) sc2.d());
                    } else {
                        oc2.a(false, jc2.e(), "install", 0, -1, b2.toString(), (long) sc2.d());
                    }
                    s91.b("SoPatchLogicImpl", TLogEventConst.PARAM_UPLOAD_STAGE, str, "so patch ready", b2.toString());
                } else {
                    oc2.a(false, jc2.e(), "download", 0, -1, sc2.g(), (long) sc2.d());
                }
                str = str;
            }
            s91.b("SoPatchLogicImpl", "finished loadLocalPatch");
        }
    }

    @Override // com.taobao.android.sopatch.core.SoPatchLogic
    public void loadRemotePatch(final jc2 jc2) {
        ps0.d().c().execute(new Runnable() {
            /* class com.taobao.android.sopatch.core.SoPatchLogicImpl2.AnonymousClass3 */

            public void run() {
                SoPatchLogicImpl2.this.g(jc2);
                s91.b("SoPatchLogicImpl", "finished loadRemotePatch");
            }
        });
    }
}
