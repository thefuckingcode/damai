package com.taobao.monitor.adapter;

import android.app.Application;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.ali.ha.datahub.BizSubscriber;
import com.taobao.monitor.APMLauncher;
import com.taobao.monitor.adapter.network.TBRestSender;
import com.taobao.monitor.impl.data.AbsWebView;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.d;
import com.uc.webview.export.WebView;
import java.io.Serializable;
import java.util.HashMap;
import tb.dm2;
import tb.f20;
import tb.hz2;
import tb.mo1;
import tb.qh2;
import tb.qs0;
import tb.t91;
import tb.ts1;
import tb.us1;
import tb.vs1;
import tb.wh1;
import tb.ws0;
import tb.zm2;

/* compiled from: Taobao */
public class SimpleApmInitiator implements Serializable {
    private static final String TAG = "TBAPMAdapterLaunchers";
    private long apmStartTime = dm2.a();
    private long cpuStartTime = SystemClock.currentThreadTimeMillis();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends AbsWebView {
        a(SimpleApmInitiator simpleApmInitiator) {
        }

        @Override // com.taobao.monitor.impl.data.AbsWebView
        public int d(View view) {
            return ((WebView) view).getProgress();
        }

        @Override // com.taobao.monitor.impl.data.IWebView
        public boolean isWebView(View view) {
            return view instanceof WebView;
        }
    }

    private void initAPMFunction(Application application, HashMap<String, Object> hashMap) {
        qs0.e().g(us1.d().b());
        initAPMLauncher(application, hashMap);
        initTbRest(application);
        initDataHub(hashMap);
        initLauncherProcedure();
        initWebView();
    }

    private void initAPMLauncher(Application application, HashMap<String, Object> hashMap) {
        vs1.b(application, hashMap);
        APMLauncher.g(application, hashMap);
    }

    private void initDataHub(HashMap<String, Object> hashMap) {
        boolean a2 = mo1.a(hashMap.get(qh2.l), true);
        qh2.h = a2;
        if (a2) {
            f20.a().b(new BizSubscriber(this) {
                /* class com.taobao.monitor.adapter.SimpleApmInitiator.AnonymousClass1 */

                private void a(Runnable runnable) {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        qs0.e().d().post(runnable);
                    } else {
                        runnable.run();
                    }
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void onBizDataReadyStage() {
                    IProcedure a = a.a();
                    if (a != null) {
                        a.stage("onBizDataReadyTime", dm2.a());
                    }
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void onStage(final String str, final String str2, long j) {
                    final long a = dm2.a();
                    a(new Runnable() {
                        /* class com.taobao.monitor.adapter.SimpleApmInitiator.AnonymousClass1.AnonymousClass3 */

                        public void run() {
                            IProcedure a = a.a();
                            if (a != null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(str2, Long.valueOf(a));
                                a.addBizStage(str, hashMap);
                            }
                        }
                    });
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void pub(final String str, final HashMap<String, String> hashMap) {
                    if ("splash".equals(str)) {
                        ws0.c = true;
                    }
                    a(new Runnable() {
                        /* class com.taobao.monitor.adapter.SimpleApmInitiator.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            IProcedure a = a.a();
                            if (a != null) {
                                a.addBiz(str, hashMap);
                            }
                        }
                    });
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void pubAB(final String str, final HashMap<String, String> hashMap) {
                    a(new Runnable() {
                        /* class com.taobao.monitor.adapter.SimpleApmInitiator.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            IProcedure a = a.a();
                            if (a != null) {
                                a.addBizAbTest(str, hashMap);
                            }
                        }
                    });
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void setMainBiz(final String str, final String str2) {
                    a(new Runnable() {
                        /* class com.taobao.monitor.adapter.SimpleApmInitiator.AnonymousClass1.AnonymousClass4 */

                        public void run() {
                            IProcedure a = a.a();
                            if (a != null) {
                                a.addProperty("bizID", str);
                                if (!TextUtils.isEmpty(str2)) {
                                    a.addProperty("bizCode", str2);
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    private void initLauncherProcedure() {
        boolean z = false;
        IProcedure createProcedure = ts1.b.createProcedure(zm2.a("/startup"), new d.b().g(false).k(true).i(false).h(null).f());
        createProcedure.begin();
        us1.PROCEDURE_MANAGER.s(createProcedure);
        IProcedure createProcedure2 = ts1.b.createProcedure("/APMSelf", new d.b().g(false).k(false).i(false).h(createProcedure).f());
        createProcedure2.begin();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            z = true;
        }
        createProcedure2.addProperty("isMainThread", Boolean.valueOf(z));
        createProcedure2.addProperty("threadName", Thread.currentThread().getName());
        createProcedure2.stage("taskStart", this.apmStartTime);
        createProcedure2.stage("cpuStartTime", this.cpuStartTime);
        TBAPMAdapterSubTaskManager.h();
        createProcedure2.stage("taskEnd", dm2.a());
        createProcedure2.stage("cpuEndTime", SystemClock.currentThreadTimeMillis());
        createProcedure2.end();
    }

    private void initTbRest(Application application) {
        wh1.b().a(new TBRestSender());
    }

    private void initWebView() {
        if (qh2.g) {
            hz2.INSTANCE.a(new a(this));
        }
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        if (!qh2.b) {
            t91.d(TAG, "init start");
            qh2.a = true;
            initAPMFunction(application, hashMap);
            t91.d(TAG, "init end");
            qh2.b = true;
        }
        t91.d(TAG, "apmStartTime:", Long.valueOf(dm2.a() - this.apmStartTime));
    }
}
