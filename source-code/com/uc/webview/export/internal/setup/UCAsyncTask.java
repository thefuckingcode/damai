package com.uc.webview.export.internal.setup;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.utility.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
public class UCAsyncTask<RETURN_TYPE extends UCAsyncTask, CALLBACK_TYPE extends UCAsyncTask> implements Runnable {
    private static final Boolean p = Boolean.FALSE;
    private UCAsyncTask a;
    private ConcurrentLinkedQueue<UCAsyncTask> b;
    private int c;
    private final Object d;
    private final Integer e;
    private final Boolean f;
    private boolean g;
    private boolean h;
    private final bq i;
    private HandlerThread j;
    private Looper k;
    private Handler l;
    private String m;
    public ConcurrentHashMap<String, ValueCallback<CALLBACK_TYPE>> mCallbacks;
    protected UCSetupException mException;
    protected UCSetupException mExtraException;
    protected boolean mHasStarted;
    protected int mPercent;
    private long n;
    private Runnable o;
    private Vector<Pair<String, Pair<Long, Long>>> q;

    /* compiled from: Taobao */
    public class a<CB_TYPE extends UCAsyncTask<CB_TYPE, CB_TYPE>> implements ValueCallback<CB_TYPE> {
        public a() {
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Object obj) {
            UCAsyncTask.this.callback(((UCAsyncTask) obj).getEvent());
        }
    }

    /* compiled from: Taobao */
    public class b<CB_TYPE extends UCAsyncTask<CB_TYPE, CB_TYPE>> implements ValueCallback<CB_TYPE> {
        public b() {
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Object obj) {
            UCAsyncTask.this.stop();
        }
    }

    public UCAsyncTask(Integer num) {
        this(num, Boolean.TRUE);
    }

    static /* synthetic */ int e(UCAsyncTask uCAsyncTask) {
        int i2 = uCAsyncTask.c + 1;
        uCAsyncTask.c = i2;
        return i2;
    }

    static /* synthetic */ int f(UCAsyncTask uCAsyncTask) {
        ConcurrentLinkedQueue<UCAsyncTask> concurrentLinkedQueue = uCAsyncTask.b;
        if (concurrentLinkedQueue == null) {
            return 1;
        }
        return concurrentLinkedQueue.size() + uCAsyncTask.c;
    }

    static /* synthetic */ void j(UCAsyncTask uCAsyncTask) {
        ConcurrentLinkedQueue<UCAsyncTask> concurrentLinkedQueue = uCAsyncTask.b;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        Log.d("UCAsyncTask", "clearSubTasks");
    }

    static /* synthetic */ void n(UCAsyncTask uCAsyncTask) {
        uCAsyncTask.b = null;
        Log.i("UCAsyncTask", "cleanThread mLooper " + uCAsyncTask.k);
        Looper looper = uCAsyncTask.k;
        if (looper != null) {
            looper.quit();
            uCAsyncTask.k = null;
        }
        uCAsyncTask.l = null;
        HandlerThread handlerThread = uCAsyncTask.j;
        if (handlerThread != null) {
            handlerThread.quit();
            uCAsyncTask.j = null;
        }
        Log.d("UCAsyncTask", "cleanThread");
    }

    /* access modifiers changed from: protected */
    public void callback(String str) {
        UCLogger create;
        UCLogger create2;
        StringBuilder sb;
        String str2;
        this.m = str;
        try {
            UCSetupException exception = getException();
            if (!UCCore.EVENT_STAT.equals(str) && (create2 = UCLogger.create("d", "UCAsyncTask")) != null) {
                String str3 = "";
                if (!"cost".equals(str)) {
                    StringBuilder sb2 = new StringBuilder("callback: ");
                    sb2.append(a(a()));
                    sb2.append(getClass().getSimpleName());
                    sb2.append(".");
                    sb2.append(str);
                    sb2.append(" ");
                    sb2.append("progress".equals(str) ? Integer.valueOf(getPercent()) : str3);
                    if ("exception".equals(str) && exception != null) {
                        str3 = exception.toString();
                    }
                    sb = sb2;
                    str2 = str3;
                } else if (p.booleanValue()) {
                    Pair<String, Pair<Long, Long>> lastElement = this.q.lastElement();
                    sb = new StringBuilder("callback: ");
                    sb.append(a(a()));
                    sb.append(getClass().getSimpleName());
                    sb.append(".");
                    sb.append(str);
                    sb.append(" cost:");
                    sb.append(String.format("%5s", ((Pair) lastElement.second).first));
                    sb.append(" cost_cpu:");
                    sb.append(String.format("%5s", ((Pair) lastElement.second).second));
                    sb.append(" task:");
                    str2 = (String) lastElement.first;
                }
                sb.append(str2);
                create2.print(sb.toString(), new Throwable[0]);
            }
            if ("exception".equals(str) && (this instanceof UCSetupTask) && exception != null && (create = UCLogger.create("e", "UCAsyncTask")) != null) {
                create.print("callback: exception: ", exception);
                if (exception != exception.getRootCause()) {
                    create.print("callback: rootCause: ", exception.getRootCause());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        ValueCallback<CALLBACK_TYPE> callback = getCallback(str);
        if (callback instanceof WeakReference) {
            callback = (ValueCallback<CALLBACK_TYPE>) ((WeakReference) callback).get();
        }
        if (callback instanceof ValueCallback) {
            try {
                callback.onReceiveValue(this);
            } catch (Throwable th2) {
                android.util.Log.e("UCAsyncTask", "callback exception", th2);
            }
        }
    }

    public final ValueCallback<CALLBACK_TYPE> getCallback(String str) {
        ConcurrentHashMap<String, ValueCallback<CALLBACK_TYPE>> concurrentHashMap = this.mCallbacks;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public final Vector<Pair<String, Pair<Long, Long>>> getCosts() {
        return this.q;
    }

    public final String getEvent() {
        return this.m;
    }

    @Reflection
    public UCSetupException getException() {
        return this.mException;
    }

    @Reflection
    public UCSetupException getExtraException() {
        return this.mExtraException;
    }

    /* access modifiers changed from: protected */
    public UCAsyncTask getParent() {
        return this.a;
    }

    public int getPercent() {
        return this.mPercent;
    }

    /* access modifiers changed from: protected */
    public final int getPriority() {
        return this.e.intValue();
    }

    /* access modifiers changed from: protected */
    public boolean inThread() {
        return Thread.currentThread() == this.j;
    }

    public boolean isPaused() {
        boolean a2;
        UCAsyncTask b2 = b();
        synchronized (b2.i) {
            a2 = b2.i.a();
        }
        return a2;
    }

    public boolean isStopped() {
        boolean z;
        synchronized (this.i) {
            z = this.h;
        }
        return z;
    }

    public RETURN_TYPE onEvent(String str, ValueCallback<CALLBACK_TYPE> valueCallback) {
        if (str != null) {
            if (this.mCallbacks == null) {
                synchronized (this) {
                    if (this.mCallbacks == null) {
                        this.mCallbacks = new ConcurrentHashMap<>();
                    }
                }
            }
            if (valueCallback == null) {
                this.mCallbacks.remove(str);
            } else {
                this.mCallbacks.put(str, valueCallback);
            }
        }
        return this;
    }

    public RETURN_TYPE pause() {
        UCAsyncTask b2 = b();
        synchronized (b2.i) {
            if (!b2.i.a()) {
                b2.g = true;
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public final RETURN_TYPE post(UCAsyncTask uCAsyncTask) {
        if (uCAsyncTask.a == this) {
            synchronized (this.d) {
                if (this.b == null) {
                    this.b = new ConcurrentLinkedQueue<>();
                }
                this.b.add(uCAsyncTask);
            }
            return this;
        }
        throw new RuntimeException("Please use \"new UCAsyncTask(parentTask).start()\" instead of \"post(new UCAsyncTask())\" to add sub task.");
    }

    public RETURN_TYPE resume() {
        UCAsyncTask b2 = b();
        synchronized (b2.i) {
            b2.g = false;
            if (b2.i.a()) {
                b2.i.a(0, null);
            }
        }
        return this;
    }

    public void run() {
        Runnable runnable = this.o;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final RETURN_TYPE setCallbacks(ConcurrentHashMap<String, ValueCallback<CALLBACK_TYPE>> concurrentHashMap) {
        for (Map.Entry<String, ValueCallback<CALLBACK_TYPE>> entry : concurrentHashMap.entrySet()) {
            onEvent(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public void setException(UCSetupException uCSetupException) {
        this.mException = uCSetupException;
    }

    public void setExtraException(UCSetupException uCSetupException) {
        this.mExtraException = uCSetupException;
    }

    public final RETURN_TYPE setParent(UCAsyncTask uCAsyncTask) {
        this.a = uCAsyncTask;
        return this;
    }

    public final void setPriority(int i2) {
        Process.setThreadPriority(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    public RETURN_TYPE start() {
        bs bsVar;
        synchronized (this.d) {
            if (!this.mHasStarted || (this.a == null && this.j == null)) {
                this.mHasStarted = true;
                UCAsyncTask uCAsyncTask = this.a;
                if (uCAsyncTask != null) {
                    uCAsyncTask.post(this);
                } else if (this.j == null) {
                    com.uc.webview.export.internal.uc.startup.b.a(225);
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        if (!this.f.booleanValue()) {
                            Log.i("UCAsyncTask", "createThreadIfNeed myLooper " + Looper.myLooper());
                            if (Looper.myLooper() == null) {
                                Looper.prepare();
                                this.k = Looper.myLooper();
                                Log.i("UCAsyncTask", "createThreadIfNeed new myLooper " + this.k);
                                a(this.k);
                                Looper.loop();
                                Log.i("UCAsyncTask", "createThreadIfNeed Looper.loop after");
                            } else {
                                a(Looper.myLooper());
                            }
                            bsVar = null;
                            this.j = bsVar;
                            if (bsVar != null) {
                                bsVar.start();
                            }
                        }
                    }
                    Log.i("UCAsyncTask", "createThreadIfNeed Looper.myLooper() == Looper.getMainLooper ");
                    bsVar = new bs(this, "U4StartupTask_" + hashCode(), this.e.intValue());
                    this.j = bsVar;
                    if (bsVar != null) {
                    }
                } else {
                    com.uc.webview.export.internal.uc.startup.b.a(225);
                    HandlerThread handlerThread = this.j;
                    if (handlerThread != null) {
                        handlerThread.start();
                    }
                }
            }
        }
        return this;
    }

    public RETURN_TYPE stop() {
        synchronized (this.i) {
            resume();
            this.h = true;
        }
        return this;
    }

    public UCAsyncTask(Integer num, Boolean bool) {
        this.c = 0;
        this.d = new Object();
        this.g = false;
        this.h = false;
        this.i = new bq();
        this.n = 0;
        this.mHasStarted = false;
        this.q = p.booleanValue() ? new Vector<>() : null;
        this.e = num;
        this.f = bool;
    }

    private UCAsyncTask b() {
        UCAsyncTask<RETURN_TYPE, CALLBACK_TYPE> uCAsyncTask = this;
        while (uCAsyncTask.getParent() != null) {
            uCAsyncTask = uCAsyncTask.getParent();
        }
        return uCAsyncTask;
    }

    private int a() {
        int i2 = 0;
        for (UCAsyncTask parent = getParent(); parent != null; parent = parent.getParent()) {
            i2++;
        }
        return i2;
    }

    private static String a(int i2) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return sb.toString();
            }
            sb.append("    ");
            i2 = i3;
        }
    }

    /* access modifiers changed from: private */
    public Handler a(Looper looper) {
        com.uc.webview.export.internal.uc.startup.b.a(TypedValues.Position.TYPE_PERCENT_X);
        br brVar = new br(this, looper);
        this.l = brVar;
        brVar.post(this);
        com.uc.webview.export.internal.uc.startup.b.a(TypedValues.Position.TYPE_PERCENT_Y);
        return this.l;
    }

    public UCAsyncTask(Runnable runnable) {
        this((Integer) 0);
        this.o = runnable;
    }

    public UCAsyncTask(UCAsyncTask uCAsyncTask) {
        this((Runnable) null);
        setParent(uCAsyncTask);
    }

    public final RETURN_TYPE start(long j2) {
        this.n = j2;
        return start();
    }
}
