package com.taobao.slide.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.fastjson.JSON;
import com.taobao.slide.core.SlideException;
import com.taobao.slide.core.SlideReceiver;
import com.taobao.slide.core.b;
import com.taobao.slide.model.AppDO;
import com.taobao.slide.model.AppUpdateDO;
import com.taobao.slide.request.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tb.d11;
import tb.if1;
import tb.o22;
import tb.uk;

/* compiled from: Taobao */
public class UpdateTask implements Runnable {
    private static final long FAIL_ALLOW_INTERVAL = 180000;
    private static final long FAIL_MAX_COUNTS = 10;
    private static final String KEY_DIG = "dig";
    private static final String KEY_URL = "url";
    private static final String KEY_VER = "ver";
    private static final String TAG = "UpdateTask";
    private static AtomicInteger continueFailCounts = new AtomicInteger(0);
    private static Handler handler;
    private static AtomicBoolean isUpdateAllow = new AtomicBoolean(true);
    private b engine;
    private Boolean fromGateWay;
    private Boolean isJson;
    private String updateInfo;

    /* compiled from: Taobao */
    class a extends c<AppDO> {
        a(UpdateTask updateTask, Context context, String str, String str2) {
            super(context, str, str2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public AppDO d(String str) {
            return (AppDO) JSON.parseObject(str, AppDO.class);
        }
    }

    public UpdateTask(b bVar, boolean z, boolean z2, String str) {
        this.engine = bVar;
        this.isJson = Boolean.valueOf(z);
        this.updateInfo = str;
        this.fromGateWay = Boolean.valueOf(z2);
    }

    public static boolean isAllow() {
        return SlideReceiver.a() && isUpdateAllow.get();
    }

    private AppUpdateDO parse(String str) {
        AppUpdateDO appUpdateDO = new AppUpdateDO();
        for (String str2 : str.split("&")) {
            String[] split = str2.split("=");
            if (split.length == 2) {
                String str3 = split[0];
                String str4 = split[1];
                if ("ver".equals(str3)) {
                    appUpdateDO.ver = uk.d(str4);
                } else if (KEY_DIG.equals(str3)) {
                    appUpdateDO.dig = uk.d(str4);
                } else if ("url".equals(str3)) {
                    appUpdateDO.url = uk.d(str4);
                }
            }
        }
        return appUpdateDO;
    }

    public void run() {
        AppUpdateDO appUpdateDO;
        synchronized (this) {
            if (this.isJson.booleanValue()) {
                appUpdateDO = (AppUpdateDO) JSON.parseObject(this.updateInfo, AppUpdateDO.class);
            } else {
                appUpdateDO = parse(this.updateInfo);
            }
            if (appUpdateDO != null) {
                if (appUpdateDO.isValid()) {
                    if (!appUpdateDO.dig.equals(this.engine.e())) {
                        if (!appUpdateDO.ver.equals(this.engine.f())) {
                            o22.g(TAG, TAG, "updateInfo", this.updateInfo);
                            try {
                                if (appUpdateDO.isValid()) {
                                    o22.g(TAG, "run", "result", appUpdateDO);
                                    try {
                                        AppDO appDO = (AppDO) new a(this, this.engine.c(), appUpdateDO.url, appUpdateDO.dig).e();
                                        if (appDO == null || !appDO.isValid()) {
                                            throw new SlideException(1020, "index invalid");
                                        } else if (!this.engine.b().getAppKey().equals(appDO.f1064app)) {
                                            throw new SlideException(1021, "index appKey invalid");
                                        } else if (!appUpdateDO.ver.equals(appDO.version)) {
                                            throw new SlideException(1022, "index version invalid");
                                        } else if (uk.h(appDO.version, this.engine.f())) {
                                            d11.c(appUpdateDO.ver, 0);
                                            continueFailCounts.set(0);
                                            isUpdateAllow.set(true);
                                            appDO.dig = appUpdateDO.dig;
                                            this.engine.l(appDO, this.fromGateWay.booleanValue());
                                            return;
                                        } else {
                                            throw new SlideException(1023, "index version not higher");
                                        }
                                    } catch (SlideException e) {
                                        throw e;
                                    }
                                } else {
                                    throw new SlideException(1002, "update invalid");
                                }
                            } catch (SlideException e2) {
                                d11.c(appUpdateDO.ver, e2.getCode());
                                o22.j(TAG, "sync", e2, new Object[0]);
                                if (((long) continueFailCounts.get()) == 10) {
                                    if1.a(if1.POINT_MAXFAILS, appUpdateDO.url);
                                    o22.k(TAG, "sync fail exceed max counts so freeze isAllow", new Object[0]);
                                    if (handler == null) {
                                        handler = new Handler(Looper.getMainLooper());
                                    }
                                    handler.postDelayed(new Runnable() {
                                        /* class com.taobao.slide.task.UpdateTask.AnonymousClass2 */

                                        public void run() {
                                            o22.k(UpdateTask.TAG, "sync unfreeze isAllow", new Object[0]);
                                            UpdateTask.continueFailCounts.set(0);
                                            UpdateTask.isUpdateAllow.set(true);
                                        }
                                    }, FAIL_ALLOW_INTERVAL);
                                    isUpdateAllow.set(false);
                                }
                                continueFailCounts.incrementAndGet();
                            }
                        }
                    }
                    return;
                }
            }
            o22.e(TAG, "updateDO invalid", "updateDO", appUpdateDO);
        }
    }
}
