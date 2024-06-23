package com.youku.danmaku.engine.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import com.youku.danmaku.engine.controller.IDrawTask;
import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import com.youku.danmaku.engine.danmaku.util.AndroidUtils;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.engine.danmaku.util.SystemClock;
import com.youku.danmaku.plugin.IDanmakuMonitorPlugin;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
public class DrawHandler extends Handler implements IDrawHandler {
    private static final int MAX_RECORD_SIZE = 500;
    public IDrawTask drawTask;
    private Callback mCallback;
    private DanmakuContext mContext;
    private long mCordonTime = 30;
    private long mCordonTime2 = 60;
    private IDanmakuMonitorPlugin mDanmakuMonitorPlugin;
    private IDanmakuSettingPlugin mDanmakuSettingPlugin;
    private IDanmakuViewController mDanmakuView;
    private boolean mDanmakusVisible = true;
    private long mDesireSeekingTime;
    private AbsDisplayer mDisp;
    private LinkedList<Long> mDrawTimes = new LinkedList<>();
    private FrameCallback mFrameCallback;
    private long mFrameUpdateRate = 16;
    private boolean mIdleSleep;
    private boolean mInSeekingAction;
    private boolean mInSyncAction;
    private volatile boolean mInWaitingState;
    private long mLastDeltaTime;
    private BaseDanmakuParser mParser;
    private boolean mReady;
    private long mRemainingTime;
    private final IRenderer.RenderingState mRenderingState = new IRenderer.RenderingState();
    private UpdateThread mThread;
    private long mThresholdTime;
    private long mTimeBase;
    private boolean mUpdateInSeparateThread;
    private byte mUpdateMethod = 0;
    private long pausedPosition = 0;
    private boolean quitFlag = true;
    private DanmakuTimer timer = new DanmakuTimer();

    /* compiled from: Taobao */
    public interface Callback {
        void danmakuShown(BaseDanmaku baseDanmaku);

        void drawingFinished();

        void prepared();

        void updateTimer(DanmakuTimer danmakuTimer);
    }

    /* access modifiers changed from: private */
    @TargetApi(16)
    /* compiled from: Taobao */
    public class FrameCallback implements Choreographer.FrameCallback {
        private FrameCallback() {
        }

        public void doFrame(long j) {
            DrawHandler.this.sendEmptyMessage(2);
        }
    }

    public DrawHandler(Looper looper, IDanmakuViewController iDanmakuViewController, boolean z) {
        super(looper);
        chooseUpdateMethod();
        this.mIdleSleep = true ^ DeviceUtils.f();
        bindView(iDanmakuViewController);
        if (z) {
            showDanmakus(null);
        } else {
            hideDanmakus(false);
        }
        this.mDanmakusVisible = z;
    }

    private void addDanmakuForNew(BaseDanmaku baseDanmaku) {
        if (this.drawTask != null) {
            baseDanmaku.flags = this.mContext.mGlobalFlagValues;
            baseDanmaku.setTimer(this.timer);
            baseDanmaku.time = getCurrentTime();
            this.drawTask.addDanmaku(baseDanmaku);
        }
    }

    private void addDanmakuForOld(BaseDanmaku baseDanmaku) {
        if (this.drawTask != null) {
            baseDanmaku.flags = this.mContext.mGlobalFlagValues;
            baseDanmaku.setTimer(this.timer);
            this.drawTask.addDanmaku(baseDanmaku);
            obtainMessage(11).sendToTarget();
        }
    }

    private void bindView(IDanmakuViewController iDanmakuViewController) {
        this.mDanmakuView = iDanmakuViewController;
    }

    private void chooseUpdateMethod() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mUpdateMethod = 2;
        }
        if (this.mUpdateMethod == 0) {
            this.mFrameCallback = new FrameCallback();
        }
        boolean z = true;
        if (this.mUpdateMethod != 1) {
            z = false;
        }
        this.mUpdateInSeparateThread = z;
    }

    private IDrawTask createDrawTask(boolean z, DanmakuTimer danmakuTimer, Context context, int i, int i2, boolean z2, IDrawTask.TaskListener taskListener) {
        AbsDisplayer displayer = this.mContext.getDisplayer();
        this.mDisp = displayer;
        displayer.setSize(i, i2);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDisp.setDensities(displayMetrics.density, displayMetrics.densityDpi, displayMetrics.scaledDensity);
        this.mDisp.resetSlopPixel(this.mContext.scaleTextSize);
        this.mDisp.setHardwareAccelerated(z2);
        IDrawTask drawTask2 = getDrawTask(context, z, danmakuTimer, taskListener);
        drawTask2.setParser(this.mParser);
        drawTask2.prepare();
        obtainMessage(10, Boolean.FALSE).sendToTarget();
        return drawTask2;
    }

    private synchronized long getAverageRenderingTime() {
        int size = this.mDrawTimes.size();
        if (size <= 0) {
            return 0;
        }
        Long peekFirst = this.mDrawTimes.peekFirst();
        Long peekLast = this.mDrawTimes.peekLast();
        if (peekFirst == null || peekLast == null) {
            return 0;
        }
        return (peekLast.longValue() - peekFirst.longValue()) / ((long) size);
    }

    private IDrawTask getDrawTask(Context context, boolean z, DanmakuTimer danmakuTimer, IDrawTask.TaskListener taskListener) {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        return (iDanmakuSettingPlugin == null || !iDanmakuSettingPlugin.isEnableVideoSpeed()) ? z ? new CacheManagingDrawTask(danmakuTimer, this.mContext, taskListener, (AndroidUtils.getMemoryClass(context) * 1048576) / 3) : new DrawTask(danmakuTimer, this.mContext, taskListener) : z ? new CacheDrawTaskNew(danmakuTimer, this.mContext, taskListener) : new DrawTaskNew(danmakuTimer, this.mContext, taskListener);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initRenderingConfigs() {
        long max = Math.max(33L, (long) (((float) 16) * 2.5f));
        this.mCordonTime = max;
        this.mCordonTime2 = (long) (((float) max) * 2.5f);
        long max2 = Math.max(16L, 15L);
        this.mFrameUpdateRate = max2;
        this.mThresholdTime = max2 + 3;
    }

    private void loge(String str, String str2, String str3) {
        IDanmakuMonitorPlugin iDanmakuMonitorPlugin = this.mDanmakuMonitorPlugin;
        if (iDanmakuMonitorPlugin != null) {
            iDanmakuMonitorPlugin.loge(str, str2, str3);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyRendering() {
        if (this.mInWaitingState) {
            IDrawTask iDrawTask = this.drawTask;
            if (iDrawTask != null) {
                iDrawTask.requestClear();
            }
            if (this.mUpdateInSeparateThread) {
                synchronized (this) {
                    this.mDrawTimes.clear();
                }
                synchronized (this.drawTask) {
                    this.drawTask.notifyAll();
                }
            } else {
                this.mDrawTimes.clear();
                removeMessages(2);
                sendEmptyMessage(2);
            }
            this.mInWaitingState = false;
        }
    }

    private void prepare(final Runnable runnable) {
        if (this.drawTask == null) {
            this.drawTask = createDrawTask(this.mDanmakuView.isDanmakuDrawingCacheEnabled(), this.timer, this.mDanmakuView.getContext(), this.mDanmakuView.getWidth(), this.mDanmakuView.getHeight(), this.mDanmakuView.isHardwareAccelerated(), new IDrawTask.TaskListener() {
                /* class com.youku.danmaku.engine.controller.DrawHandler.AnonymousClass3 */

                @Override // com.youku.danmaku.engine.controller.IDrawTask.TaskListener
                public void onDanmakuAdd(BaseDanmaku baseDanmaku) {
                    if (!baseDanmaku.isTimeOut()) {
                        long j = baseDanmaku.time - DrawHandler.this.timer.currMillisecond;
                        if (j < DrawHandler.this.mContext.mDanmakuFactory.mMaxDanmakuDuration && (DrawHandler.this.mInWaitingState || DrawHandler.this.mRenderingState.nothingRendered)) {
                            DrawHandler.this.notifyRendering();
                        } else if (j > 0 && j <= DrawHandler.this.mContext.mDanmakuFactory.mMaxDanmakuDuration) {
                            DrawHandler.this.sendEmptyMessageDelayed(11, j);
                        }
                    }
                }

                @Override // com.youku.danmaku.engine.controller.IDrawTask.TaskListener
                public void onDanmakuConfigChanged() {
                    DrawHandler.this.redrawIfNeeded();
                }

                @Override // com.youku.danmaku.engine.controller.IDrawTask.TaskListener
                public void onDanmakuShown(BaseDanmaku baseDanmaku) {
                    if (DrawHandler.this.mCallback != null) {
                        DrawHandler.this.mCallback.danmakuShown(baseDanmaku);
                    }
                }

                @Override // com.youku.danmaku.engine.controller.IDrawTask.TaskListener
                public void onDanmakusDrawingFinished() {
                    if (DrawHandler.this.mCallback != null) {
                        DrawHandler.this.mCallback.drawingFinished();
                    }
                }

                @Override // com.youku.danmaku.engine.controller.IDrawTask.TaskListener
                public void ready() {
                    DrawHandler.this.initRenderingConfigs();
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    private synchronized void quitUpdateThread() {
        UpdateThread updateThread = this.mThread;
        this.mThread = null;
        if (updateThread != null) {
            synchronized (this.drawTask) {
                this.drawTask.notifyAll();
            }
            updateThread.quit();
            try {
                updateThread.join(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private synchronized void recordRenderingTime() {
        this.mDrawTimes.addLast(Long.valueOf(SystemClock.uptimeMillis()));
        if (this.mDrawTimes.size() > 500) {
            this.mDrawTimes.pollFirst();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void redrawIfNeeded() {
        if (this.quitFlag && this.mDanmakusVisible) {
            removeMessages(12);
            sendEmptyMessageDelayed(12, 100);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long syncTimer(long j) {
        long j2 = 0;
        if (!this.mInSeekingAction && !this.mInSyncAction) {
            this.mInSyncAction = true;
            long j3 = j - this.mTimeBase;
            if (!this.mDanmakusVisible || this.mRenderingState.nothingRendered || this.mInWaitingState) {
                this.timer.update(j3);
                this.mRemainingTime = 0;
            } else {
                long j4 = j3 - this.timer.currMillisecond;
                long max = Math.max(this.mFrameUpdateRate, getAverageRenderingTime());
                if (j4 <= 2000) {
                    long j5 = this.mRenderingState.consumingTime;
                    long j6 = this.mCordonTime;
                    if (j5 <= j6 && max <= j6) {
                        long j7 = this.mFrameUpdateRate;
                        long min = Math.min(this.mCordonTime, Math.max(j7, max + (j4 / j7)));
                        long j8 = this.mLastDeltaTime;
                        long j9 = min - j8;
                        if (j9 > 3 && j9 < 8 && j8 >= this.mFrameUpdateRate && j8 <= this.mCordonTime) {
                            min = j8;
                        }
                        long j10 = j4 - min;
                        this.mLastDeltaTime = min;
                        j4 = min;
                        j2 = j10;
                    }
                }
                this.mRemainingTime = j2;
                this.timer.add(j4);
                j2 = j4;
            }
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.updateTimer(this.timer);
            }
            this.mInSyncAction = false;
        }
        return j2;
    }

    private void syncTimerIfNeeded() {
        if (this.mInWaitingState) {
            syncTimer(SystemClock.uptimeMillis());
        }
    }

    private void updateDanmakus() {
        byte b = this.mUpdateMethod;
        if (b == 0) {
            updateInChoreographer();
        } else if (b == 1) {
            updateInNewThread();
        } else if (b == 2) {
            updateInCurrentThread();
        }
    }

    @TargetApi(16)
    private void updateInChoreographer() {
        if (!this.quitFlag) {
            try {
                Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
                if (syncTimer(SystemClock.uptimeMillis()) < 0) {
                    removeMessages(2);
                    return;
                }
                long drawDanmakus = this.mDanmakuView.drawDanmakus();
                removeMessages(2);
                if (drawDanmakus > this.mCordonTime2) {
                    this.timer.add(drawDanmakus);
                    this.mDrawTimes.clear();
                }
                if (!this.mDanmakusVisible) {
                    waitRendering(10000000);
                    return;
                }
                IRenderer.RenderingState renderingState = this.mRenderingState;
                if (renderingState.nothingRendered && this.mIdleSleep) {
                    long j = renderingState.endTime - this.timer.currMillisecond;
                    if (j > 500) {
                        waitRendering(j - 10);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("DrawHandler", "Choreographer is error! use UPDATE_IN_NEW_THREAD");
                loge("YKDanmaku.update", "Choreographer is error: " + e.getMessage(), "other");
                this.mUpdateMethod = 1;
                this.mUpdateInSeparateThread = true;
                updateInNewThread();
            }
        }
    }

    private void updateInCurrentThread() {
        if (!this.quitFlag) {
            long syncTimer = syncTimer(SystemClock.uptimeMillis());
            if (syncTimer < 0) {
                removeMessages(2);
                sendEmptyMessageDelayed(2, 60 - syncTimer);
                return;
            }
            long drawDanmakus = this.mDanmakuView.drawDanmakus();
            removeMessages(2);
            if (drawDanmakus > this.mCordonTime2) {
                this.timer.add(drawDanmakus);
                this.mDrawTimes.clear();
            }
            if (!this.mDanmakusVisible) {
                waitRendering(10000000);
                return;
            }
            IRenderer.RenderingState renderingState = this.mRenderingState;
            if (renderingState.nothingRendered && this.mIdleSleep) {
                long j = renderingState.endTime - this.timer.currMillisecond;
                if (j > 500) {
                    waitRendering(j - 10);
                    return;
                }
            }
            long j2 = this.mFrameUpdateRate;
            if (drawDanmakus < j2) {
                sendEmptyMessageDelayed(2, j2 - drawDanmakus);
            } else {
                sendEmptyMessage(2);
            }
        }
    }

    private void updateInNewThread() {
        if (this.mThread == null) {
            AnonymousClass2 r0 = new UpdateThread("DFM Update") {
                /* class com.youku.danmaku.engine.controller.DrawHandler.AnonymousClass2 */

                @Override // com.youku.danmaku.engine.controller.UpdateThread
                public void run() {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    while (!isQuited() && !DrawHandler.this.quitFlag) {
                        long uptimeMillis2 = SystemClock.uptimeMillis();
                        if (DrawHandler.this.mFrameUpdateRate - (SystemClock.uptimeMillis() - uptimeMillis) > 1) {
                            SystemClock.sleep(1);
                        } else {
                            long syncTimer = DrawHandler.this.syncTimer(uptimeMillis2);
                            if (syncTimer < 0) {
                                SystemClock.sleep(60 - syncTimer);
                            } else {
                                long drawDanmakus = DrawHandler.this.mDanmakuView.drawDanmakus();
                                if (drawDanmakus > DrawHandler.this.mCordonTime2) {
                                    DrawHandler.this.timer.add(drawDanmakus);
                                    DrawHandler.this.mDrawTimes.clear();
                                }
                                if (!DrawHandler.this.mDanmakusVisible) {
                                    DrawHandler.this.waitRendering(10000000);
                                } else if (DrawHandler.this.mRenderingState.nothingRendered && DrawHandler.this.mIdleSleep) {
                                    long j = DrawHandler.this.mRenderingState.endTime - DrawHandler.this.timer.currMillisecond;
                                    if (j > 500) {
                                        DrawHandler.this.notifyRendering();
                                        DrawHandler.this.waitRendering(j - 10);
                                    }
                                }
                            }
                            uptimeMillis = uptimeMillis2;
                        }
                    }
                }
            };
            this.mThread = r0;
            r0.start();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void waitRendering(long j) {
        if (!isStop() && isPrepared() && !this.mInSeekingAction) {
            this.mRenderingState.sysTime = SystemClock.uptimeMillis();
            this.mInWaitingState = true;
            if (this.mUpdateInSeparateThread) {
                if (this.mThread != null) {
                    try {
                        synchronized (this.drawTask) {
                            if (j == 10000000) {
                                this.drawTask.wait();
                            } else {
                                this.drawTask.wait(j);
                            }
                            sendEmptyMessage(11);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else if (j == 10000000) {
                removeMessages(11);
                removeMessages(2);
            } else {
                removeMessages(11);
                removeMessages(2);
                sendEmptyMessageDelayed(11, j);
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void addDanmaku(BaseDanmaku baseDanmaku) {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin == null || !iDanmakuSettingPlugin.isEnableVideoSpeed()) {
            addDanmakuForOld(baseDanmaku);
        } else {
            addDanmakuForNew(baseDanmaku);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void clearDanmakusOnScreen() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin == null || (!iDanmakuSettingPlugin.isNewTypesetting() && !this.mDanmakuSettingPlugin.isNewCompose())) {
            obtainMessage(13).sendToTarget();
            return;
        }
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            iDrawTask.clearDanmakusOnScreen(getCurrentTime());
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public IRenderer.RenderingState draw(Canvas canvas) {
        if (this.drawTask == null) {
            return this.mRenderingState;
        }
        this.mDisp.setExtraData(canvas);
        this.mRenderingState.set(this.drawTask.draw(this.mDisp));
        recordRenderingTime();
        return this.mRenderingState;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public DanmakuContext getConfig() {
        return this.mContext;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public long getCurrentTime() {
        long j;
        long j2;
        if (!this.mReady) {
            return 0;
        }
        if (this.mInSeekingAction) {
            return this.mDesireSeekingTime;
        }
        if (this.quitFlag || !this.mInWaitingState) {
            j = this.timer.currMillisecond;
            j2 = this.mRemainingTime;
        } else {
            j = SystemClock.uptimeMillis();
            j2 = this.mTimeBase;
        }
        return j - j2;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public IDanmakus getCurrentVisibleDanmakus() {
        if (this.drawTask == null) {
            return null;
        }
        return this.drawTask.getVisibleDanmakusOnTime(getCurrentTime());
    }

    public IDisplayer getDisplayer() {
        return this.mDisp;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public IRenderer.RenderingState getRenderingState() {
        return this.mRenderingState;
    }

    public boolean getVisibility() {
        return this.mDanmakusVisible;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x041a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01b7  */
    public void handleMessage(Message message) {
        long j;
        int i;
        Long l;
        IDrawTask iDrawTask;
        boolean z;
        IDanmakuViewController iDanmakuViewController;
        IDrawTask iDrawTask2;
        int i2 = message.what;
        switch (i2) {
            case 1:
                l = (Long) message.obj;
                loge("YKDanmaku.render", " START: startTime=" + l, "other");
                if (Log.isDebug()) {
                    Log.d("DrawHandler: START: startTime=" + Log.showTime(l.longValue()));
                }
                if (l != null) {
                    this.pausedPosition = l.longValue();
                    j = 0;
                    if (i2 == 4) {
                        this.quitFlag = true;
                        quitUpdateThread();
                        Long valueOf = Long.valueOf(j);
                        Object obj = message.obj;
                        if (obj == null || !(obj instanceof SeekModel)) {
                            i = 0;
                        } else {
                            valueOf = Long.valueOf(((SeekModel) obj).time);
                            i = ((SeekModel) message.obj).type;
                        }
                        long longValue = valueOf.longValue();
                        DanmakuTimer danmakuTimer = this.timer;
                        this.mTimeBase -= longValue - danmakuTimer.currMillisecond;
                        danmakuTimer.update(valueOf, i);
                        this.mContext.mGlobalFlagValues.updateMeasureFlag();
                        IDrawTask iDrawTask3 = this.drawTask;
                        if (iDrawTask3 != null) {
                            iDrawTask3.seek(this.timer.currMillisecond, i);
                        }
                        this.pausedPosition = this.timer.currMillisecond;
                        loge("YKDanmaku.render", " SEEK_POS: position=" + valueOf + ", pausedPosition=timer=" + this.timer.currMillisecond, "other");
                        if (Log.isDebug()) {
                            Log.d("DrawHandler: SEEK_POS: position=" + Log.showTime(valueOf.longValue()) + ", pausedPosition=timer=" + Log.showTime(this.timer.currMillisecond));
                        }
                    }
                    removeMessages(7);
                    this.quitFlag = false;
                    if (!this.mReady) {
                        this.mRenderingState.reset();
                        this.mDrawTimes.clear();
                        long uptimeMillis = SystemClock.uptimeMillis();
                        long j2 = this.pausedPosition;
                        this.mTimeBase = uptimeMillis - j2;
                        this.timer.update(j2);
                        removeMessages(3);
                        sendEmptyMessage(2);
                        this.drawTask.start();
                        notifyRendering();
                        this.mInSeekingAction = false;
                        IDrawTask iDrawTask4 = this.drawTask;
                        if (iDrawTask4 != null) {
                            iDrawTask4.onPlayStateChanged(1);
                        }
                        loge("YKDanmaku.render", " RESUME: timer=" + this.timer.currMillisecond + ", pausedPosition=" + this.pausedPosition, "other");
                        if (Log.isDebug()) {
                            Log.d("DrawHandler: RESUME: timer=" + Log.showTime(this.timer.currMillisecond) + ", pausedPosition=" + Log.showTime(this.pausedPosition));
                            return;
                        }
                        return;
                    }
                    sendEmptyMessageDelayed(3, 100);
                    return;
                }
                j = 0;
                this.pausedPosition = 0;
                if (i2 == 4) {
                }
                removeMessages(7);
                this.quitFlag = false;
                if (!this.mReady) {
                }
                break;
            case 2:
                updateDanmakus();
                return;
            case 3:
                removeMessages(7);
                this.quitFlag = false;
                if (!this.mReady) {
                }
                break;
            case 4:
                j = 0;
                if (i2 == 4) {
                }
                removeMessages(7);
                this.quitFlag = false;
                if (!this.mReady) {
                }
                break;
            case 5:
                if (this.mParser == null || !this.mDanmakuView.isViewReady()) {
                    sendEmptyMessageDelayed(5, 100);
                    return;
                }
                loge("YKDanmaku.render", " PREPARE", "other");
                if (Log.isDebug()) {
                    Log.d("DrawHandler: PREPARE");
                }
                prepare(new Runnable() {
                    /* class com.youku.danmaku.engine.controller.DrawHandler.AnonymousClass1 */

                    public void run() {
                        DrawHandler.this.mReady = true;
                        if (DrawHandler.this.mCallback != null) {
                            DrawHandler.this.mCallback.prepared();
                        }
                    }
                });
                return;
            case 6:
                break;
            case 7:
                loge("YKDanmaku.render", " PAUSE: remove UPDATE, timer=" + this.timer.currMillisecond, "other");
                if (Log.isDebug()) {
                    Log.d("DrawHandler: PAUSE: remove UPDATE, timer=" + Log.showTime(this.timer.currMillisecond));
                }
                removeMessages(3);
                removeMessages(2);
                iDrawTask = this.drawTask;
                if (iDrawTask != null) {
                    iDrawTask.onPlayStateChanged(2);
                    break;
                }
                break;
            case 8:
                this.mDanmakusVisible = true;
                Long l2 = (Long) message.obj;
                loge("YKDanmaku.render", " SHOW_DANMAKUS: timer=" + getCurrentTime(), "other");
                if (Log.isDebug()) {
                    Log.d("DrawHandler: SHOW_DANMAKUS: timer=" + getCurrentTime());
                }
                if (this.drawTask != null) {
                    if (l2 == null) {
                        if (Log.isDebug()) {
                            Log.d("DrawHandler: SHOW_DANMAKUS: start=false");
                        }
                        this.timer.update(getCurrentTime());
                        this.drawTask.requestClear();
                    } else {
                        if (Log.isDebug()) {
                            Log.d("DrawHandler: SHOW_DANMAKUS: start=" + l2);
                        }
                        this.drawTask.start();
                        this.drawTask.seek(l2.longValue(), 0);
                        this.drawTask.requestClear();
                        z = true;
                        if (this.quitFlag && (iDanmakuViewController = this.mDanmakuView) != null) {
                            iDanmakuViewController.drawDanmakus();
                        }
                        notifyRendering();
                        if (!z) {
                            if (Log.isDebug()) {
                                Log.d("DrawHandler: SHOW_DANMAKUS: resume=false");
                                return;
                            }
                            return;
                        }
                        l = (Long) message.obj;
                        loge("YKDanmaku.render", " START: startTime=" + l, "other");
                        if (Log.isDebug()) {
                        }
                        if (l != null) {
                        }
                    }
                }
                z = false;
                iDanmakuViewController.drawDanmakus();
                notifyRendering();
                if (!z) {
                }
                l = (Long) message.obj;
                loge("YKDanmaku.render", " START: startTime=" + l, "other");
                if (Log.isDebug()) {
                }
                if (l != null) {
                }
                break;
            case 9:
                this.mDanmakusVisible = false;
                IDanmakuViewController iDanmakuViewController2 = this.mDanmakuView;
                if (iDanmakuViewController2 != null) {
                    iDanmakuViewController2.clear();
                }
                IDrawTask iDrawTask5 = this.drawTask;
                if (iDrawTask5 != null) {
                    iDrawTask5.requestClear();
                    this.drawTask.requestHide();
                }
                Boolean bool = (Boolean) message.obj;
                if (bool.booleanValue() && (iDrawTask2 = this.drawTask) != null) {
                    iDrawTask2.quit();
                }
                loge("YKDanmaku.render", " HIDE_DANMAKUS: quitDrawTask=" + bool + ", timer=" + this.timer.currMillisecond, "other");
                if (Log.isDebug()) {
                    Log.d("DrawHandler: HIDE_DANMAKUS: quitDrawTask=" + bool + ", timer=" + this.timer.currMillisecond);
                }
                if (!bool.booleanValue()) {
                    return;
                }
                loge("YKDanmaku.render", " PAUSE: remove UPDATE, timer=" + this.timer.currMillisecond, "other");
                if (Log.isDebug()) {
                }
                removeMessages(3);
                removeMessages(2);
                iDrawTask = this.drawTask;
                if (iDrawTask != null) {
                }
                break;
            case 10:
                DanmakuContext danmakuContext = this.mContext;
                danmakuContext.mDanmakuFactory.notifyDispSizeChanged(danmakuContext);
                Boolean bool2 = (Boolean) message.obj;
                if (bool2 != null && bool2.booleanValue()) {
                    this.mContext.mGlobalFlagValues.updateMeasureFlag();
                    return;
                }
                return;
            case 11:
                notifyRendering();
                return;
            case 12:
                if (this.quitFlag && this.mDanmakuView != null) {
                    this.drawTask.requestClear();
                    this.mDanmakuView.drawDanmakus();
                    notifyRendering();
                    return;
                }
                return;
            case 13:
                IDrawTask iDrawTask6 = this.drawTask;
                if (iDrawTask6 != null) {
                    iDrawTask6.clearDanmakusOnScreen(getCurrentTime());
                    return;
                }
                return;
            default:
                return;
        }
        if (i2 == 6) {
            removeCallbacksAndMessages(null);
        }
        this.quitFlag = true;
        syncTimerIfNeeded();
        this.pausedPosition = this.timer.currMillisecond;
        loge("YKDanmaku.render", " QUIT or PAUSE: pausedPosition=" + this.pausedPosition, "other");
        if (Log.isDebug()) {
            Log.d("DrawHandler: QUIT or PAUSE: pausedPosition=" + this.pausedPosition);
        }
        if (this.mUpdateInSeparateThread) {
            notifyRendering();
            quitUpdateThread();
        }
        if (this.mFrameCallback != null && Build.VERSION.SDK_INT >= 16) {
            try {
                Choreographer instance = Choreographer.getInstance();
                instance.removeFrameCallback(this.mFrameCallback);
                Field declaredField = Choreographer.class.getDeclaredField("sThreadInstance");
                declaredField.setAccessible(true);
                ((ThreadLocal) declaredField.get(null)).remove();
                Field declaredField2 = Choreographer.class.getDeclaredField("mDisplayEventReceiver");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(instance);
                obj2.getClass().getMethod("dispose", new Class[0]).invoke(obj2, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (i2 == 6) {
            IDrawTask iDrawTask7 = this.drawTask;
            if (iDrawTask7 != null) {
                iDrawTask7.quit();
            }
            BaseDanmakuParser baseDanmakuParser = this.mParser;
            if (baseDanmakuParser != null) {
                baseDanmakuParser.release();
            }
            if (getLooper() != Looper.getMainLooper()) {
                getLooper().quit();
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean hasDanmakusBySecond(long j) {
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            return iDrawTask.hasDanmakusBySecond(j);
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public long hideDanmakus(boolean z) {
        if (!this.mDanmakusVisible) {
            return this.timer.currMillisecond;
        }
        this.mDanmakusVisible = false;
        removeMessages(8);
        removeMessages(9);
        obtainMessage(9, Boolean.valueOf(z)).sendToTarget();
        return this.timer.currMillisecond;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z) {
        IDrawTask iDrawTask = this.drawTask;
        if (!(iDrawTask == null || baseDanmaku == null)) {
            iDrawTask.invalidateDanmaku(baseDanmaku, z);
        }
        redrawIfNeeded();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean isDanmakusVisible() {
        return this.mDanmakusVisible;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean isPrepared() {
        return this.mReady;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean isResume() {
        return true;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean isStop() {
        return this.quitFlag;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void notifyDispSizeChanged(int i, int i2) {
        AbsDisplayer absDisplayer = this.mDisp;
        if (absDisplayer != null) {
            if (absDisplayer.getWidth() != i || this.mDisp.getHeight() != i2) {
                this.mDisp.setSize(i, i2);
                obtainMessage(10, Boolean.TRUE).sendToTarget();
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void pause() {
        removeMessages(3);
        syncTimerIfNeeded();
        sendEmptyMessage(7);
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void quit() {
        sendEmptyMessage(6);
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void removeAllDanmakus() {
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            iDrawTask.removeAllDanmakus();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void removeAllLiveDanmakus() {
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            iDrawTask.removeAllLiveDanmakus();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void resume() {
        removeMessages(7);
        sendEmptyMessage(3);
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public boolean screenHasData() {
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            return iDrawTask.screenHasData();
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void seekTo(Long l) {
        this.mInSeekingAction = true;
        this.mDesireSeekingTime = l.longValue();
        removeMessages(2);
        removeMessages(3);
        removeMessages(4);
        SeekModel seekModel = new SeekModel();
        seekModel.time = l.longValue();
        seekModel.type = 0;
        obtainMessage(4, seekModel).sendToTarget();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void seekToNoTime(Long l) {
        this.mInSeekingAction = true;
        this.mDesireSeekingTime = l.longValue();
        removeMessages(2);
        removeMessages(3);
        removeMessages(4);
        SeekModel seekModel = new SeekModel();
        seekModel.time = l.longValue();
        seekModel.type = 1;
        obtainMessage(4, seekModel).sendToTarget();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void setConfig(DanmakuContext danmakuContext) {
        this.mContext = danmakuContext;
        this.mDanmakuMonitorPlugin = danmakuContext.getDanmakuMonitorPlugin();
        this.mDanmakuSettingPlugin = this.mContext.getDanmakuSettingPlugin();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void setParser(BaseDanmakuParser baseDanmakuParser) {
        this.mParser = baseDanmakuParser;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void showDanmakus(Long l) {
        if (!this.mDanmakusVisible) {
            this.mDanmakusVisible = true;
            removeMessages(8);
            removeMessages(9);
            obtainMessage(8, l).sendToTarget();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void addDanmaku(List<BaseDanmaku> list) {
        IDrawTask iDrawTask = this.drawTask;
        if (iDrawTask != null) {
            iDrawTask.addDanmakuList(list, getCurrentTime(), this.mContext.mGlobalFlagValues, this.timer);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawHandler
    public void prepare() {
        sendEmptyMessage(5);
    }
}
