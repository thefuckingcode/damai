package com.taobao.slide.task;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.slide.api.SlideConfig;
import com.taobao.slide.core.SlideException;
import com.taobao.slide.core.b;
import java.util.HashMap;
import java.util.Map;
import tb.o22;

/* compiled from: Taobao */
public class CheckTask implements Runnable {
    private static final long CHECK_UPDATE_INTERVAL = 20000;
    private static final String TAG = "CheckTask";
    private static final String TAOBAO_PACKAGE_NAME = "com.taobao.taobao";
    private static final String TMALL_PACKAGE_NAME = "com.tmall.wireless";
    private static final String VERSION_PARAM = "since";
    private static volatile long lastIndexUpdTime;
    private static String packageName;
    private b engine;
    private String utdid;

    /* compiled from: Taobao */
    class a extends com.taobao.slide.request.a<String> {
        final /* synthetic */ String i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(CheckTask checkTask, Context context, SlideConfig slideConfig, String str, String str2, String str3, String str4) {
            super(context, slideConfig, str, str2, str3);
            this.i = str4;
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.slide.request.b
        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put(CheckTask.VERSION_PARAM, this.i);
            return hashMap;
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public String d(String str) {
            return str;
        }
    }

    public CheckTask(b bVar, String str) {
        this.engine = bVar;
        this.utdid = str;
    }

    public static synchronized boolean isAllow(Context context) {
        synchronized (CheckTask.class) {
            if (context == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastIndexUpdTime <= CHECK_UPDATE_INTERVAL) {
                return false;
            }
            lastIndexUpdTime = currentTimeMillis;
            return true;
        }
    }

    public void run() {
        String format = String.format("http://%s/probes/_me", this.engine.b().getDcHost());
        String f = this.engine.f();
        o22.c(TAG, "sync", "url", format, "version", f);
        try {
            String str = (String) new a(this, this.engine.c(), this.engine.b(), this.utdid, format, null, f).e();
            if (TextUtils.isEmpty(str)) {
                o22.e(TAG, "sync result is empty", new Object[0]);
            } else {
                new UpdateTask(this.engine, true, true, str).run();
            }
        } catch (SlideException e) {
            o22.d(TAG, "sync", e, new Object[0]);
        }
    }
}
