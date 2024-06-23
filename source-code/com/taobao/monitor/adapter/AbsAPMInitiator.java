package com.taobao.monitor.adapter;

import android.app.Application;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import android.view.View;
import com.ali.ha.datahub.BizSubscriber;
import com.taobao.android.tbexecutor.tbhandler.HandlerThreadFactory;
import com.taobao.android.tbexecutor.threadpool.TBThreadPoolExecutor;
import com.taobao.monitor.APMLauncher;
import com.taobao.monitor.adapter.logger.LoggerAdapter;
import com.taobao.monitor.adapter.network.TBRestSender;
import com.taobao.monitor.adapter.procedure.getter.H5ProcedureGetterBridge;
import com.taobao.monitor.common.IHandlerThreadMaker;
import com.taobao.monitor.impl.data.AbsWebView;
import com.taobao.monitor.impl.data.utsession.IUTSession;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.d;
import com.taobao.monitor.test.APMTestPluginLauncher;
import com.uc.webview.export.WebView;
import com.ut.mini.internal.UTTeamWork;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import tb.az2;
import tb.dm2;
import tb.f20;
import tb.hz2;
import tb.i20;
import tb.jo1;
import tb.mo1;
import tb.qh2;
import tb.qs0;
import tb.t91;
import tb.ts1;
import tb.uk2;
import tb.us1;
import tb.vs1;
import tb.wh1;
import tb.ws0;
import tb.xh2;
import tb.zm2;
import tb.zq2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class AbsAPMInitiator implements Serializable {
    private static final float DEFAULT_SAMPLE = 1.0f;
    private static final String TAG = "AbsAPMInitiator";
    private final long apmStartTime = dm2.a();
    private final long cpuStartTime = SystemClock.currentThreadTimeMillis();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements ThreadFactory {
        final /* synthetic */ AtomicInteger a;

        a(AbsAPMInitiator absAPMInitiator, AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "APM-common-" + this.a.getAndIncrement());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements IHandlerThreadMaker {
        b(AbsAPMInitiator absAPMInitiator) {
        }

        @Override // com.taobao.monitor.common.IHandlerThreadMaker
        public HandlerThread make(String str) {
            return HandlerThreadFactory.handlerThread(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c extends AbsWebView {
        c(AbsAPMInitiator absAPMInitiator) {
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

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements IUTSession {
        d(AbsAPMInitiator absAPMInitiator) {
        }

        @Override // com.taobao.monitor.impl.data.utsession.IUTSession
        public String getUtsid() {
            return UTTeamWork.getInstance().getUtsid();
        }
    }

    AbsAPMInitiator() {
    }

    private void initAPMFunction(Application application, HashMap<String, Object> hashMap) {
        initParams(hashMap);
        initThread();
        initDataLogger();
        jo1.a().f(application, hashMap);
        initAPMLauncher(application, hashMap);
        initNetwork();
        initTbRest(application);
        initDataHub(hashMap);
        initLauncherProcedure();
        initWebView();
        initExpendLauncher(application);
        initUTSession(hashMap);
        initTestPlugin(application, hashMap);
    }

    private void initAPMLauncher(Application application, HashMap<String, Object> hashMap) {
        initPage(application);
        vs1.b(application, hashMap);
        APMLauncher.g(application, hashMap);
    }

    private void initDataHub(HashMap<String, Object> hashMap) {
        if (qh2.h) {
            f20.a().b(new BizSubscriber(this) {
                /* class com.taobao.monitor.adapter.AbsAPMInitiator.AnonymousClass4 */

                private void a(Runnable runnable) {
                    qs0.e().d().post(runnable);
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
                        /* class com.taobao.monitor.adapter.AbsAPMInitiator.AnonymousClass4.AnonymousClass3 */

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
                        /* class com.taobao.monitor.adapter.AbsAPMInitiator.AnonymousClass4.AnonymousClass1 */

                        public void run() {
                            HashMap hashMap;
                            if ("afc".equals(str) && (hashMap = hashMap) != null) {
                                String str = (String) hashMap.get("url");
                                if (!TextUtils.isEmpty(str)) {
                                    az2.b().a(str);
                                }
                                i20.a(AbsAPMInitiator.TAG, str, hashMap);
                            }
                            t91.a(AbsAPMInitiator.TAG, str, hashMap);
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
                        /* class com.taobao.monitor.adapter.AbsAPMInitiator.AnonymousClass4.AnonymousClass2 */

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
                        /* class com.taobao.monitor.adapter.AbsAPMInitiator.AnonymousClass4.AnonymousClass4 */

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

    private void initDataLogger() {
        i20.b(new LoggerAdapter());
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

    private void initNetwork() {
        try {
            xh2.a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void initTbRest(Application application) {
        wh1.b().a(new TBRestSender());
    }

    private void initThread() {
        qs0.e().g(us1.d().b());
        if (qh2.f) {
            uk2.b(new TBThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(this, new AtomicInteger(0)), new ThreadPoolExecutor.AbortPolicy()));
            uk2.c(new b(this));
        }
    }

    private void initUTSession(HashMap<String, Object> hashMap) {
        if (mo1.a(hashMap.get("needUT"), true)) {
            zq2.a().b(new d(this));
        }
    }

    private void initWebView() {
        if (qh2.g) {
            WVPluginManager.registerPlugin(H5ProcedureGetterBridge.class.getSimpleName(), (Class<? extends WVApiPlugin>) H5ProcedureGetterBridge.class, false);
            hz2.INSTANCE.a(new c(this));
        }
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        if (!qh2.b) {
            t91.d(TAG, "init start");
            initAPMFunction(application, hashMap);
            qh2.b = true;
            qh2.a = true;
            t91.d(TAG, "init end");
        }
        t91.d(TAG, "apmStartTime:", Long.valueOf(dm2.a() - this.apmStartTime));
    }

    /* access modifiers changed from: protected */
    public void initExpendLauncher(Application application) {
    }

    /* access modifiers changed from: protected */
    public abstract void initPage(Application application);

    /* access modifiers changed from: protected */
    public void initParams(HashMap<String, Object> hashMap) {
        qh2.h = mo1.a(hashMap.get(qh2.l), true);
    }

    /* access modifiers changed from: protected */
    public void initTestPlugin(final Application application, final HashMap<String, Object> hashMap) {
        qs0.e().d().post(new Runnable() {
            /* class com.taobao.monitor.adapter.AbsAPMInitiator.AnonymousClass6 */

            public void run() {
                try {
                    if ((application.getApplicationInfo().flags & 2) != 0) {
                        t91.e(true);
                    }
                    Class.forName("com.taobao.monitor.test.APMTestPluginLauncher");
                    APMTestPluginLauncher.init(application, hashMap);
                } catch (Throwable th) {
                    t91.b(AbsAPMInitiator.TAG, th);
                }
            }
        });
    }
}
