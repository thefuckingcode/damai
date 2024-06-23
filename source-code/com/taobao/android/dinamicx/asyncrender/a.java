package com.taobao.android.dinamicx.asyncrender;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXPreRenderWorkTask;
import com.taobao.android.dinamicx.DXPrefetchTask;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DXSimplePrefetchTask;
import com.taobao.android.dinamicx.DXTemplateManager;
import com.taobao.android.dinamicx.asyncrender.batch.DXBatchAsyncRenderCallback;
import com.taobao.android.dinamicx.asyncrender.batch.DXBatchPreRenderWorkTask;
import com.taobao.android.dinamicx.asyncrender.batch.DXBatchPrefetchWorkTask;
import com.taobao.android.dinamicx.asyncrender.batch.DXBatchRenderWorkTask;
import com.taobao.android.dinamicx.b;
import com.taobao.android.dinamicx.d;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.h;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXPriorityRunnable;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.youku.arch.v3.data.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tb.c00;
import tb.ft;
import tb.ry;
import tb.vx;

/* compiled from: Taobao */
public class a extends b {
    public static final int MSG_ASYNC_RENDER = 3;
    public static final int MSG_BATCH_RENDER = 9;
    public static final int MSG_CACHE_MONITOR = 8;
    public static final int MSG_CANCEL_PREFETCH_SIMPLE = 11;
    public static final int MSG_CANCEL_PREFETCH_TASK = 7;
    public static final int MSG_CLEAR_COMPLETED_SIMPLE_TASKS = 13;
    public static final int MSG_CLEAR_EXECUTOR_TASKS = 4;
    public static final int MSG_CLEAR_SIMPLE_TASKS = 12;
    public static final int MSG_CLEAR_TASKS = 5;
    public static final int MSG_PREFETCH = 2;
    public static final int MSG_PREFETCH_SIMPLE = 10;
    public static final int MSG_PRE_RENDER = 1;
    public static final int MSG_RESTORE_EXECUTOR_TASKS = 6;
    private int d = -1;
    private int e;
    private int f;
    private int g;
    private HashMap<String, DXPrefetchTask> h;
    private HashMap<String, DXSimplePrefetchTask> i;
    private boolean j;
    private HandlerC0203a k;

    /* renamed from: com.taobao.android.dinamicx.asyncrender.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class HandlerC0203a extends Handler {
        private WeakReference<a> a;

        public HandlerC0203a(a aVar, Looper looper) {
            super(looper);
            this.a = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            if (message != null) {
                a aVar = this.a.get();
                if (aVar == null) {
                    removeCallbacksAndMessages(null);
                    return;
                }
                try {
                    switch (message.what) {
                        case 1:
                            ((Runnable) message.obj).run();
                            return;
                        case 2:
                            ((Runnable) message.obj).run();
                            return;
                        case 3:
                        default:
                            return;
                        case 4:
                            aVar.n();
                            return;
                        case 5:
                            aVar.p();
                            return;
                        case 6:
                            aVar.x();
                            return;
                        case 7:
                            aVar.k((DXRuntimeContext) message.obj);
                            return;
                        case 8:
                            aVar.t();
                            return;
                        case 9:
                            ((Runnable) message.obj).run();
                            return;
                        case 10:
                            ((Runnable) message.obj).run();
                            return;
                        case 11:
                            aVar.l((DXRuntimeContext) message.obj);
                            return;
                        case 12:
                            aVar.o();
                            return;
                        case 13:
                            aVar.m();
                            return;
                    }
                } catch (Throwable th) {
                    vx.b(th);
                }
            }
        }
    }

    public a(@NonNull d dVar) {
        super(dVar);
        try {
            this.k = new HandlerC0203a(this, c00.c().getLooper());
        } catch (Throwable th) {
            this.k = new HandlerC0203a(this, Looper.getMainLooper());
            DXAppMonitor.q(this.b, null, "AsyncRender", "Async_Render_3.0_init_Crash", e.V3_ASYNC_RENDER_INIT_CRASH, vx.a(th));
        }
    }

    private void B() {
        Message obtain = Message.obtain();
        obtain.what = 4;
        this.k.sendMessage(obtain);
    }

    private void C() {
        Message obtain = Message.obtain();
        obtain.what = 12;
        this.k.sendMessage(obtain);
    }

    private void D() {
        Message obtain = Message.obtain();
        obtain.what = 5;
        this.k.sendMessage(obtain);
    }

    private void E() {
        Message obtain = Message.obtain();
        obtain.what = 8;
        this.k.sendMessage(obtain);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n() {
        this.j = true;
        c00.b();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o() {
        HashMap<String, DXSimplePrefetchTask> hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p() {
        HashMap<String, DXPrefetchTask> hashMap = this.h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    private String q(@NonNull DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext.getWidgetNode() instanceof DXTemplateWidgetNode) {
            return dXRuntimeContext.getCacheIdentifyWithSubData();
        }
        return dXRuntimeContext.getCacheIdentify();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void t() {
        int i2 = this.d;
        if (i2 != 0) {
            if (i2 > 0) {
                float f2 = ((float) (i2 - this.e)) / ((float) i2);
                HashMap hashMap = new HashMap();
                hashMap.put(Constants.TOTAL_NUM, String.valueOf(this.d));
                hashMap.put("cancelNum", String.valueOf(this.e));
                hashMap.put("fillRate", String.valueOf(f2));
                DXAppMonitor.m(0, this.b, "PreRender", "PreRender_FillRate", hashMap);
                ry.i("DXAsyncRenderManager", "任务填充率=" + f2 + "预加载任务创建=" + this.d + "任务取消=" + this.e);
            }
            int i3 = this.f;
            if (i3 > 0) {
                float f3 = ((float) this.g) / ((float) i3);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(Constants.TOTAL_NUM, String.valueOf(this.f));
                hashMap2.put("hitNum", String.valueOf(this.g));
                hashMap2.put("hitRate", String.valueOf(f3));
                DXAppMonitor.m(0, this.b, "PreRender", "PreRender_HitRate", hashMap2);
                ry.i("DXAsyncRenderManager", "缓存命中率=" + f3 + "模板渲染调用次数=" + this.f + "缓存命中的调用次数=" + this.g);
            }
            if (b().i() > 0) {
                float i4 = ((float) this.d) / ((float) b().i());
                HashMap hashMap3 = new HashMap();
                hashMap3.put("maxNum", String.valueOf(b().i()));
                HashMap<String, DXPrefetchTask> hashMap4 = this.h;
                hashMap3.put("taskNum", String.valueOf(hashMap4 != null ? hashMap4.size() : 0));
                hashMap3.put("hitRate", String.valueOf(i4));
                DXAppMonitor.m(0, this.b, "PreRender", "PreRender_OccupationRate", hashMap3);
                ry.i("DXAsyncRenderManager", "缓存利用率=" + i4 + "缓存最大个数限制=" + b().i() + "预加载的创建任务=" + this.d);
            }
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void x() {
        if (this.j) {
            HashMap<String, DXPrefetchTask> hashMap = this.h;
            if (hashMap != null) {
                for (DXPrefetchTask dXPrefetchTask : hashMap.values()) {
                    if (!dXPrefetchTask.isDone) {
                        c00.i(new DXPriorityRunnable(2, dXPrefetchTask));
                    }
                }
            }
            HashMap<String, DXSimplePrefetchTask> hashMap2 = this.i;
            if (hashMap2 != null) {
                for (DXSimplePrefetchTask dXSimplePrefetchTask : hashMap2.values()) {
                    if (!dXSimplePrefetchTask.isDone) {
                        c00.j(new DXPriorityRunnable(2, dXSimplePrefetchTask));
                    }
                }
            }
            this.j = false;
        }
    }

    private void y(DXRuntimeContext dXRuntimeContext) {
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = dXRuntimeContext;
        this.k.sendMessage(obtain);
    }

    private void z(DXRuntimeContext dXRuntimeContext) {
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = dXRuntimeContext;
        this.k.sendMessage(obtain);
    }

    public void A() {
        Message obtain = Message.obtain();
        obtain.what = 13;
        this.k.sendMessage(obtain);
    }

    public void F(@NonNull Runnable runnable) {
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.obj = runnable;
        this.k.sendMessage(obtain);
    }

    public void h(@NonNull List<DXRuntimeContext> list, @NonNull DXRenderOptions dXRenderOptions, @NonNull DXTemplateManager dXTemplateManager, @NonNull h hVar, @NonNull ft ftVar, @Nullable DXBatchAsyncRenderCallback dXBatchAsyncRenderCallback, boolean z) {
        DXBatchRenderWorkTask dXBatchRenderWorkTask;
        if (dXRenderOptions.e() == 1) {
            dXBatchRenderWorkTask = new DXBatchPrefetchWorkTask(dXTemplateManager, hVar, ftVar, dXRenderOptions, list, dXBatchAsyncRenderCallback, z);
        } else {
            dXBatchRenderWorkTask = dXRenderOptions.e() == 2 ? new DXBatchPreRenderWorkTask(dXTemplateManager, hVar, ftVar, dXRenderOptions, list, dXBatchAsyncRenderCallback, z) : null;
        }
        if (dXBatchRenderWorkTask != null) {
            dXBatchRenderWorkTask.runTasks();
        }
    }

    public void i(DXRuntimeContext dXRuntimeContext) {
        y(dXRuntimeContext);
    }

    public void j(DXRuntimeContext dXRuntimeContext) {
        z(dXRuntimeContext);
    }

    public void k(DXRuntimeContext dXRuntimeContext) {
        DXPrefetchTask dXPrefetchTask;
        this.f++;
        HashMap<String, DXPrefetchTask> hashMap = this.h;
        if (hashMap != null && (dXPrefetchTask = hashMap.get(dXRuntimeContext.getCacheIdentify())) != null) {
            if (!dXPrefetchTask.isDone) {
                dXPrefetchTask.options.k(true);
                dXPrefetchTask.isDone = true;
                this.e++;
            } else if (!dXPrefetchTask.options.i()) {
                this.g++;
            }
        }
    }

    public void l(DXRuntimeContext dXRuntimeContext) {
        DXSimplePrefetchTask remove;
        HashMap<String, DXSimplePrefetchTask> hashMap = this.i;
        if (hashMap != null && (remove = hashMap.remove(q(dXRuntimeContext))) != null) {
            remove.cancel();
        }
    }

    public void m() {
        if (this.i != null) {
            HashSet<String> hashSet = new HashSet();
            for (Map.Entry<String, DXSimplePrefetchTask> entry : this.i.entrySet()) {
                if (entry.getValue().isDone) {
                    hashSet.add(entry.getKey());
                }
            }
            for (String str : hashSet) {
                this.i.remove(str);
            }
        }
    }

    public void r() {
        if (this.d != -1) {
            B();
        }
    }

    public void s(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, h hVar, ft ftVar) {
        c00.h(new DXPriorityRunnable(0, new DXPreRenderWorkTask(dXRuntimeContext, dXRenderOptions, dXTemplateManager, hVar, this.c, ftVar)));
    }

    public void u(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, h hVar, ft ftVar) {
        if (this.h == null) {
            this.h = new HashMap<>(100);
        }
        if (!this.h.containsKey(dXRuntimeContext.getCacheIdentify())) {
            if (this.d == -1) {
                this.d = 0;
            }
            DXPrefetchTask dXPrefetchTask = new DXPrefetchTask(dXRuntimeContext, dXRenderOptions, dXTemplateManager, hVar, this.c, ftVar);
            c00.i(new DXPriorityRunnable(2, dXPrefetchTask));
            this.h.put(dXRuntimeContext.getCacheIdentify(), dXPrefetchTask);
            this.d++;
        }
    }

    public void v(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, h hVar, View view, DXAsyncRenderCallback<DXRuntimeContext> dXAsyncRenderCallback) {
        if (this.i == null) {
            this.i = new HashMap<>();
        }
        String q = q(dXRuntimeContext);
        if (!this.i.containsKey(q)) {
            DXSimplePrefetchTask dXSimplePrefetchTask = new DXSimplePrefetchTask(dXRuntimeContext, dXRenderOptions, this.c, hVar, view, dXAsyncRenderCallback);
            c00.j(new DXPriorityRunnable(2, dXSimplePrefetchTask));
            this.i.put(q, dXSimplePrefetchTask);
        }
    }

    public void w() {
        if (this.d != -1) {
            E();
            B();
            D();
            C();
        }
    }
}
