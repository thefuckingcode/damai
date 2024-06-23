package tb;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.application.common.IAppPreferences;
import com.taobao.application.common.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
public class do1 extends ea {
    private static String W = "";
    private static String X;
    private static final List<String> Y = new ArrayList(4);
    private long F;
    private long G;
    private long H = 0;
    private List<c70> I;
    private int J = 0;
    private long[] K;
    private long[] L = new long[2];
    private long M;
    private boolean N = true;
    public boolean O = true;
    private boolean P = true;
    private boolean Q = false;
    private boolean R = true;
    private boolean S = true;
    private boolean T = true;
    private int U = 1;
    private boolean V = true;

    public do1(on1 on1) {
        super(on1);
    }

    private void m(Map<String, Object> map) {
        if (map != null) {
            try {
                long b = dm2.b(t32.a(map.get("navStartTime"), -1));
                this.M = b;
                ys1.d(this.e, "navStartTime", b);
                ys1.d(this.e, "navStartActivityTime", dm2.b(t32.a(map.get("navStartActivityTime"), -1)));
                this.d.G(this.M);
                if (this.d.a() != null) {
                    this.e.addProperty("isFirstLoad", Boolean.valueOf(ws0.q.a(k3.b(this.d.a()))));
                } else if (this.d.e() != null) {
                    this.e.addProperty("isFirstLoad", Boolean.valueOf(ws0.q.a(jn0.a(this.d.e()))));
                }
                ys1.b(this.e, "fullPageName", map.get("fullPageName"));
                ys1.b(this.e, "activityName", map.get("activityName"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private JSONObject n(Map map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Object obj : map.keySet()) {
                jSONObject.put(String.valueOf(obj), map.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void o(Activity activity) {
        String str;
        if (activity != null) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra("referrer");
                if (!TextUtils.isEmpty(stringExtra)) {
                    try {
                        Uri parse = Uri.parse(stringExtra);
                        str = parse.getHost() + parse.getPath();
                    } catch (Exception e) {
                        str = e.getMessage();
                    }
                    this.e.addProperty("referer", str);
                }
            }
            str = "null";
            this.e.addProperty("referer", str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.monitor.impl.processor.AbsProcessor
    public void d() {
        super.d();
        this.e.stage("procedureStartTime", dm2.a());
        this.e.addProperty("errorCode", 1);
        this.e.addProperty("installType", ws0.g);
        this.e.addProperty("timestampInterval", Long.valueOf(System.currentTimeMillis() - SystemClock.uptimeMillis()));
        this.e.addProperty("leaveType", "other");
        ys1.b(this.e, "groupRelatedId", this.d.i());
        long[] jArr = this.L;
        jArr[0] = 0;
        jArr[1] = 0;
        this.I = new ArrayList();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.monitor.impl.processor.AbsProcessor, tb.ea
    public void e() {
        if (!this.Q && this.e.isAlive()) {
            if (this.N) {
                this.e.addProperty("utSession", zq2.a().getUtsid());
            }
            if (this.d.l() != null) {
                this.e.addProperty("pageCalculateType", "view_manual_calculate");
            }
            this.Q = true;
            IAppPreferences d = b.d();
            i20.a("PageProcessor", "errorCode", Integer.valueOf(this.U));
            this.e.addProperty("totalVisibleDuration", Long.valueOf(this.H));
            this.e.addProperty("deviceLevel", Integer.valueOf(d.getInt("deviceLevel", -1)));
            this.e.addProperty("runtimeLevel", Integer.valueOf(i4.d().f().d));
            this.e.addProperty("cpuUsageOfDevice", Float.valueOf(i4.d().b().d));
            this.e.addProperty("memoryRuntimeLevel", Integer.valueOf(i4.d().e().k));
            ys1.d(this.e, "firstFrameTime", this.d.d());
            this.e.addStatistic("gcCount", Integer.valueOf(this.E));
            this.e.addStatistic("fps", this.z.toString());
            this.e.addStatistic("frozenFrameCount", Integer.valueOf(this.A));
            this.e.addStatistic("slowFrameCount", Integer.valueOf(this.B));
            this.e.addStatistic("jankCount", Integer.valueOf(this.C));
            this.e.addStatistic("image", Integer.valueOf(this.r));
            this.e.addStatistic("imageOnRequest", Integer.valueOf(this.r));
            this.e.addStatistic("imageSuccessCount", Integer.valueOf(this.s));
            this.e.addStatistic("imageFailedCount", Integer.valueOf(this.t));
            this.e.addStatistic("imageCanceledCount", Integer.valueOf(this.u));
            this.e.addStatistic("network", Integer.valueOf(this.v));
            this.e.addStatistic("networkOnRequest", Integer.valueOf(this.v));
            this.e.addStatistic("networkSuccessCount", Integer.valueOf(this.w));
            this.e.addStatistic("networkFailedCount", Integer.valueOf(this.x));
            this.e.addStatistic("networkCanceledCount", Integer.valueOf(this.y));
            this.e.addStatistic("renderFrameCount", Integer.valueOf(this.d.f()));
            this.e.addStatistic("blockRenderFrameCount", Integer.valueOf(this.d.b()));
            this.e.addStatistic("frozenRenderFrameCount", Integer.valueOf(this.d.g()));
            this.e.addStatistic("mainBlockFrameCauses", n(this.d.k()));
            this.e.addStatistic("importantBlockFrameCauses", n(this.d.j()));
            this.e.stage("procedureEndTime", dm2.a());
            this.e.end();
            super.e();
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.ea
    public String f() {
        return "/pageLoad";
    }

    /* access modifiers changed from: protected */
    @Override // tb.ea
    public void j(String str) {
        if (this.P) {
            this.P = false;
            this.e.addProperty("leaveType", str);
            this.e.stage("leaveTime", dm2.a());
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher.BackgroundChangedListener
    public void onChanged(int i, long j) {
        i20.a("PageProcessor", "onChanged", Integer.valueOf(i), Long.valueOf(j));
        if (i == 1) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("timestamp", Long.valueOf(j));
            this.e.event("foreground2Background", hashMap);
            return;
        }
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("timestamp", Long.valueOf(j));
        this.e.event("background2Foreground", hashMap2);
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onKey(Activity activity, KeyEvent keyEvent, long j) {
        if (ow2.a(activity, this.d.o())) {
            int action = keyEvent.getAction();
            int keyCode = keyEvent.getKeyCode();
            if (action != 0) {
                return;
            }
            if (keyCode == 4 || keyCode == 3) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("timestamp", Long.valueOf(j));
                hashMap.put("key", Integer.valueOf(keyEvent.getKeyCode()));
                this.e.event("keyEvent", hashMap);
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher.LowMemoryListener
    public void onLowMemory() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(dm2.a()));
        this.e.event("onLowMemory", hashMap);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageAppear() {
        i20.a("PageProcessor", "onPageAppear", this.d.m());
        long a = dm2.a();
        this.G = a;
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(a));
        this.e.event("onPageAppear", hashMap);
        W = this.d.m();
        if (this.d.t()) {
            X = this.d.m();
        }
        if (this.O && this.K != null) {
            this.O = false;
            long[] a2 = mn2.a();
            long[] jArr = this.L;
            long j = jArr[0];
            long j2 = a2[0];
            long[] jArr2 = this.K;
            jArr[0] = j + (j2 - jArr2[0]);
            jArr[1] = jArr[1] + (a2[1] - jArr2[1]);
        }
        this.K = mn2.a();
        ws0.p = this.d.m();
        ws0.n = a;
        if (lc0.r && this.d.t()) {
            int i = this.J;
            if (i == 0) {
                this.J = i + 1;
            } else {
                this.I.add(c70.a().b("R"));
            }
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageBeginStandard
    public void onPageClickTime(long j) {
        i20.a("PageProcessor", "onPageClickTime", Long.valueOf(j));
        this.e.stage("jumpTime", j);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageCreate(String str, String str2, Map<String, Object> map) {
        i20.a("PageProcessor", "onPageCreate", str, str2, map);
        this.F = dm2.a();
        this.K = mn2.a();
        if (this.d.n() > 0) {
            this.F = this.d.n();
        }
        List<String> list = Y;
        if (list.size() < 10) {
            list.add(str);
        }
        m(map);
        this.e.stage("loadStartTime", this.F);
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(this.F));
        this.e.event("onPageCreate", hashMap);
        ys1.c(this.e, "fromPageName", W);
        ys1.c(this.e, "lastJumpPage", X);
        this.e.addProperty("pageName", str);
        ys1.c(this.e, "schemaUrl", str2);
        this.e.addProperty("isFirstLaunch", Boolean.valueOf(ws0.d));
        this.e.addProperty("lastValidTime", Long.valueOf(ws0.n));
        this.e.addProperty("lastValidLinksPage", list.toString());
        this.e.addProperty("lastValidPage", ws0.p);
        this.e.addProperty("loadType", "push");
        ys1.a(this.e, "jumpTime", ws0.m);
        ws0.m = -1;
        this.e.stage("jumpTime", -1);
        if (lc0.r && this.d.t()) {
            o(this.d.a());
            this.I.add(c70.a().b("C"));
        }
        this.d.w();
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageDestroy() {
        i20.a("PageProcessor", "onPageDestroy");
        long a = dm2.a();
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(a));
        this.e.event("onPageDestroy", hashMap);
        if (this.K != null) {
            long[] a2 = mn2.a();
            long[] jArr = this.L;
            long j = jArr[0];
            long j2 = a2[0];
            long[] jArr2 = this.K;
            jArr[0] = j + (j2 - jArr2[0]);
            jArr[1] = jArr[1] + (a2[1] - jArr2[1]);
        }
        if (lc0.r) {
            this.e.addProperty("runtimeInfo", this.I.toString());
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageDisappear() {
        i20.a("PageProcessor", "onPageDisappear");
        long a = dm2.a();
        this.H += a - this.G;
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(a));
        this.e.event("onPageDisappear", hashMap);
        if (this.K != null) {
            long[] a2 = mn2.a();
            long[] jArr = this.L;
            long j = jArr[0];
            long j2 = a2[0];
            long[] jArr2 = this.K;
            jArr[0] = j + (j2 - jArr2[0]);
            jArr[1] = jArr[1] + (a2[1] - jArr2[1]);
            this.K = a2;
        }
        if (lc0.r && this.d.t()) {
            this.I.add(c70.a().b(ExifInterface.LATITUDE_SOUTH));
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageInteractive(long j) {
        i20.a("PageProcessor", "onPageInteractive", Long.valueOf(j));
        if (this.T) {
            this.T = false;
            this.U = 0;
            this.e.addProperty("interactiveDuration", Long.valueOf(j - this.F));
            this.e.addProperty("loadDuration", Long.valueOf(j - this.F));
            this.e.stage("interactiveTime", j);
            this.e.addProperty("errorCode", 0);
            this.e.addStatistic("totalRx", Long.valueOf(this.L[0]));
            this.e.addStatistic("totalTx", Long.valueOf(this.L[1]));
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageLoadError(int i) {
        i20.a("PageProcessor", "onPageLoadError", Integer.valueOf(i));
        if (this.U == 1) {
            this.e.addProperty("errorCode", Integer.valueOf(i));
            this.U = i;
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageBeginStandard
    public void onPageNavStartTime(long j) {
        i20.a("PageProcessor", "onPageNavStartTime", Long.valueOf(j));
        this.M = j;
        this.e.stage("navStartTime", j);
        this.d.G(j);
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageRenderPercent(float f, long j) {
        i20.a("PageProcessor", "onPageRenderPercent", Float.valueOf(f), Long.valueOf(j));
        if (this.S) {
            this.e.addProperty("onRenderPercent", Float.valueOf(f));
            this.e.addProperty("drawPercentTime", Long.valueOf(j));
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageRenderStart(long j) {
        i20.a("PageProcessor", "onPageRenderStart", Long.valueOf(j));
        if (this.R) {
            this.e.addProperty("pageInitDuration", Long.valueOf(j - this.F));
            this.e.stage("renderStartTime", j);
            this.R = false;
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageVisible(long j) {
        i20.a("PageProcessor", "onPageVisible", Long.valueOf(j));
        if (this.S) {
            this.S = false;
            this.e.addProperty("displayDuration", Long.valueOf(j - this.F));
            this.e.stage("displayedTime", j);
            this.e.stage("firstScreenPaint", j);
            if (this.N && !TextUtils.isEmpty(zq2.a().getUtsid())) {
                this.e.addProperty("utSession", zq2.a().getUtsid());
                this.N = false;
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onTouch(Activity activity, MotionEvent motionEvent, long j) {
        if (ow2.a(activity, this.d.o())) {
            if (this.V) {
                this.e.stage("firstInteractiveTime", j);
                this.e.addProperty("firstInteractiveDuration", Long.valueOf(j - this.F));
                this.V = false;
            }
            List<String> list = Y;
            list.clear();
            list.add(k3.d(activity));
            ws0.p = k3.d(activity);
            ws0.n = j;
        }
    }
}
