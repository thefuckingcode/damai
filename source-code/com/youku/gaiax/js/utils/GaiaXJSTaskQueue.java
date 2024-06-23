package com.youku.gaiax.js.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.taobao.tao.log.TLogConstant;
import com.taobao.weex.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.qr0;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\u0011\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006R\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/youku/gaiax/js/utils/GaiaXJSTaskQueue;", "", "", TLogConstant.PERSIST_TASK_ID, Constants.Name.INTERVAL, "Lkotlin/Function0;", "Ltb/ur2;", "func", "Landroid/os/Message;", "createIntervalMsg", "createDelayMsg", "", "executeIntervalTask", "remoteIntervalTask", "delay", "executeDelayTask", "", "executeTask", "remoteDelayTask", "initTaskQueue", "destroyTaskQueue", "contextId", "J", "getContextId", "()J", "Landroid/os/Handler;", "taskQueue", "Landroid/os/Handler;", "Landroid/os/HandlerThread;", "taskThread", "Landroid/os/HandlerThread;", "<init>", "(J)V", "Companion", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXJSTaskQueue {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int WHAT_DELAY_TASK = 1;
    public static final int WHAT_INTERVAL_TASK = 0;
    private final long contextId;
    @Nullable
    private Handler taskQueue;
    @Nullable
    private HandlerThread taskThread;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/js/utils/GaiaXJSTaskQueue$Companion;", "", "", "contextId", "Lcom/youku/gaiax/js/utils/GaiaXJSTaskQueue;", "create", "", "WHAT_DELAY_TASK", "I", "WHAT_INTERVAL_TASK", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @NotNull
        public final GaiaXJSTaskQueue create(long j) {
            return new GaiaXJSTaskQueue(j, null);
        }
    }

    private GaiaXJSTaskQueue(long j) {
        this.contextId = j;
    }

    public /* synthetic */ GaiaXJSTaskQueue(long j, m40 m40) {
        this(j);
    }

    private final Message createDelayMsg(int i, Function0<ur2> function0) {
        Message message = new Message();
        message.what = i;
        message.arg2 = 1;
        message.obj = function0;
        return message;
    }

    /* access modifiers changed from: private */
    public final Message createIntervalMsg(int i, int i2, Function0<ur2> function0) {
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        message.arg2 = 0;
        message.obj = function0;
        return message;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeTask$lambda-2  reason: not valid java name */
    public static final void m904executeTask$lambda2(Function0 function0) {
        k21.i(function0, "$func");
        function0.invoke();
    }

    public final void destroyTaskQueue() {
        this.taskQueue = null;
        HandlerThread handlerThread = this.taskThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.taskThread = null;
    }

    public final void executeDelayTask(int i, long j, @NotNull Function0<ur2> function0) {
        k21.i(function0, "func");
        Handler handler = this.taskQueue;
        if (handler != null) {
            handler.sendMessageDelayed(createDelayMsg(i, function0), j);
        }
    }

    public final void executeIntervalTask(int i, long j, @NotNull Function0<ur2> function0) {
        k21.i(function0, "func");
        Handler handler = this.taskQueue;
        if (handler != null) {
            handler.sendMessageDelayed(createIntervalMsg(i, (int) j, function0), j);
        }
    }

    public final boolean executeTask(@NotNull Function0<ur2> function0) {
        k21.i(function0, "func");
        Handler handler = this.taskQueue;
        if (handler == null) {
            return false;
        }
        return handler.post(new qr0(function0));
    }

    public final long getContextId() {
        return this.contextId;
    }

    public final void initTaskQueue() {
        String r = k21.r("GaiaXJSQueue-", Long.valueOf(this.contextId));
        HandlerThread handlerThread = new HandlerThread(r);
        this.taskThread = handlerThread;
        k21.f(handlerThread);
        handlerThread.start();
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(k21.r("initTaskQueue() called taskQueueName = ", r));
        }
        HandlerThread handlerThread2 = this.taskThread;
        k21.f(handlerThread2);
        this.taskQueue = new GaiaXJSTaskQueue$initTaskQueue$1(this, handlerThread2.getLooper());
    }

    public final void remoteDelayTask(int i) {
        Handler handler = this.taskQueue;
        if (handler != null) {
            handler.removeMessages(i);
        }
    }

    public final void remoteIntervalTask(int i) {
        Handler handler = this.taskQueue;
        if (handler != null) {
            handler.removeMessages(i);
        }
    }
}
