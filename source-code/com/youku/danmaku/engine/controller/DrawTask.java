package com.youku.danmaku.engine.controller;

import android.graphics.Canvas;
import com.youku.danmaku.engine.controller.IDrawTask;
import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.GlobalFlagValues;
import com.youku.danmaku.engine.danmaku.model.IDanmakuIterator;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakuRenderer;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.engine.danmaku.util.SystemClock;
import java.util.List;

/* compiled from: Taobao */
public class DrawTask implements IDrawTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean clearRetainerFlag;
    protected IDanmakus danmakuList;
    private IDanmakus danmakus = new Danmakus(4);
    private DanmakuContext.ConfigChangedCallback mConfigChangedCallback = new DanmakuContext.ConfigChangedCallback() {
        /* class com.youku.danmaku.engine.controller.DrawTask.AnonymousClass1 */

        @Override // com.youku.danmaku.engine.danmaku.model.android.DanmakuContext.ConfigChangedCallback
        public boolean onDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
            return DrawTask.this.onDanmakuConfigChanged(danmakuContext, danmakuConfigTag, objArr);
        }
    };
    protected final DanmakuContext mContext;
    final AbsDisplayer mDisp;
    private boolean mIsHidden;
    private long mLastBeginMills;
    private BaseDanmaku mLastDanmaku;
    private long mLastEndMills;
    private Danmakus mLiveDanmakus = new Danmakus(4);
    BaseDanmakuParser mParser;
    boolean mReadyState;
    final IRenderer mRenderer;
    private final IRenderer.RenderingState mRenderingState = new IRenderer.RenderingState();
    private long mStartRenderTime = 0;
    IDrawTask.TaskListener mTaskListener;
    DanmakuTimer mTimer;

    public DrawTask(DanmakuTimer danmakuTimer, DanmakuContext danmakuContext, IDrawTask.TaskListener taskListener) {
        if (danmakuContext != null) {
            this.mContext = danmakuContext;
            this.mDisp = danmakuContext.getDisplayer();
            this.mTaskListener = taskListener;
            DanmakuRenderer danmakuRenderer = new DanmakuRenderer(danmakuContext);
            this.mRenderer = danmakuRenderer;
            danmakuRenderer.setOnDanmakuShownListener(new IRenderer.OnDanmakuShownListener() {
                /* class com.youku.danmaku.engine.controller.DrawTask.AnonymousClass2 */

                @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer.OnDanmakuShownListener
                public void onDanmakuShown(BaseDanmaku baseDanmaku) {
                    IDrawTask.TaskListener taskListener = DrawTask.this.mTaskListener;
                    if (taskListener != null) {
                        taskListener.onDanmakuShown(baseDanmaku);
                    }
                }
            });
            danmakuRenderer.setVerifierEnabled(danmakuContext.isPreventOverlappingEnabled() || danmakuContext.isMaxLinesLimited());
            initTimer(danmakuTimer);
            if (danmakuContext.isDuplicateMergingEnabled()) {
                danmakuContext.mDanmakuFilters.registerFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
            } else {
                danmakuContext.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
            }
        } else {
            throw new IllegalArgumentException("context is null");
        }
    }

    private void beginTracing(IRenderer.RenderingState renderingState, IDanmakus iDanmakus) {
        renderingState.reset();
        renderingState.timer.update(SystemClock.uptimeMillis());
        int i = 0;
        renderingState.indexInScreen = 0;
        if (iDanmakus != null) {
            i = iDanmakus.size();
        }
        renderingState.totalSizeInScreen = i;
    }

    private void endTracing(IRenderer.RenderingState renderingState) {
        boolean z = renderingState.totalDanmakuCount == 0;
        renderingState.nothingRendered = z;
        long j = -1;
        if (z) {
            renderingState.beginTime = -1;
        }
        BaseDanmaku baseDanmaku = renderingState.lastDanmaku;
        renderingState.lastDanmaku = null;
        if (baseDanmaku != null) {
            j = baseDanmaku.time;
        }
        renderingState.endTime = j;
        renderingState.consumingTime = renderingState.timer.update(SystemClock.uptimeMillis());
    }

    private static boolean hasInsideDanmakus(IDanmakus iDanmakus) {
        if (iDanmakus == null || iDanmakus.isEmpty()) {
            return false;
        }
        synchronized (iDanmakus) {
            IDanmakuIterator it = iDanmakus.iterator();
            while (it.hasNext()) {
                if (!it.next().isOutside()) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public synchronized void addDanmaku(BaseDanmaku baseDanmaku) {
        boolean addItem;
        IDrawTask.TaskListener taskListener;
        boolean addItem2;
        if (this.danmakuList != null) {
            if (baseDanmaku.isLive) {
                this.mLiveDanmakus.addItem(baseDanmaku);
                removeUnusedLiveDanmakusIn(10);
            }
            baseDanmaku.index = this.danmakuList.size();
            boolean z = true;
            long j = this.mLastBeginMills;
            long j2 = baseDanmaku.time;
            if (j <= j2 && j2 <= this.mLastEndMills) {
                synchronized (this.danmakus) {
                    addItem2 = this.danmakus.addItem(baseDanmaku);
                }
                z = addItem2;
            } else if (baseDanmaku.isLive) {
                z = false;
            }
            synchronized (this.danmakuList) {
                addItem = this.danmakuList.addItem(baseDanmaku);
            }
            if (!z) {
                this.mLastEndMills = 0;
                this.mLastBeginMills = 0;
            }
            if (addItem && (taskListener = this.mTaskListener) != null) {
                taskListener.onDanmakuAdd(baseDanmaku);
            }
            BaseDanmaku baseDanmaku2 = this.mLastDanmaku;
            if (baseDanmaku2 == null || (baseDanmaku2 != null && baseDanmaku.time > baseDanmaku2.time)) {
                this.mLastDanmaku = baseDanmaku;
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void addDanmakuList(List<BaseDanmaku> list, long j, GlobalFlagValues globalFlagValues, DanmakuTimer danmakuTimer) {
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void clearDanmakusOnScreen(long j) {
        reset(0);
        this.mContext.mGlobalFlagValues.updateVisibleFlag();
        this.mContext.mGlobalFlagValues.updateFirstShownFlag();
        Log.d("clearDanmakusOnScreen, mStartRenderTime=" + j);
        this.mStartRenderTime = j;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public synchronized IRenderer.RenderingState draw(AbsDisplayer absDisplayer) {
        return drawDanmakus(absDisplayer, this.mTimer);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3  */
    public IRenderer.RenderingState drawDanmakus(AbsDisplayer absDisplayer, DanmakuTimer danmakuTimer) {
        List<BaseDanmaku> specialDanmaku;
        IDanmakus iDanmakus;
        if (this.clearRetainerFlag) {
            this.mRenderer.clearRetainer();
            this.clearRetainerFlag = false;
        }
        if (this.danmakuList == null) {
            return null;
        }
        DrawHelper.clearCanvas((Canvas) absDisplayer.getExtraData());
        if (this.mIsHidden) {
            return this.mRenderingState;
        }
        long j = danmakuTimer.currMillisecond;
        long j2 = this.mContext.mDanmakuFactory.mMaxDanmakuDuration;
        long j3 = (j - j2) - 100;
        long j4 = j2 + j;
        long j5 = this.mLastBeginMills;
        if (j5 <= j3) {
            long j6 = this.mLastEndMills;
            if (j <= j6) {
                j3 = j5;
                j4 = j6;
                specialDanmaku = this.mRenderer.getSpecialDanmaku();
                if (specialDanmaku != null && specialDanmaku.size() > 0) {
                    for (BaseDanmaku baseDanmaku : specialDanmaku) {
                        if (baseDanmaku != null && baseDanmaku.isShown() && !baseDanmaku.isTimeOut() && !this.danmakus.contains(baseDanmaku)) {
                            this.danmakus.addItem(baseDanmaku);
                        }
                    }
                }
                beginTracing(this.mRenderingState, this.danmakus);
                iDanmakus = this.danmakus;
                if (iDanmakus != null || iDanmakus.isEmpty()) {
                    IRenderer.RenderingState renderingState = this.mRenderingState;
                    renderingState.nothingRendered = true;
                    renderingState.beginTime = j3;
                    renderingState.endTime = j4;
                    return renderingState;
                }
                this.mRenderer.draw(this.mDisp, this.danmakus, this.mStartRenderTime, this.mRenderingState);
                endTracing(this.mRenderingState);
                if (this.mRenderingState.nothingRendered) {
                    BaseDanmaku baseDanmaku2 = this.mLastDanmaku;
                    if (baseDanmaku2 != null && baseDanmaku2.isTimeOut()) {
                        this.mLastDanmaku = null;
                        IDrawTask.TaskListener taskListener = this.mTaskListener;
                        if (taskListener != null) {
                            taskListener.onDanmakusDrawingFinished();
                        }
                    }
                    IRenderer.RenderingState renderingState2 = this.mRenderingState;
                    if (renderingState2.beginTime == -1) {
                        renderingState2.beginTime = j3;
                    }
                    if (renderingState2.endTime == -1) {
                        renderingState2.endTime = j4;
                    }
                }
                return this.mRenderingState;
            }
        }
        IDanmakus subnew = this.danmakuList.subnew(j3, j4);
        if (subnew != null) {
            this.danmakus = subnew;
        } else {
            this.danmakus.clear();
        }
        if (Log.isDebug()) {
            Log.d("CacheManager", "new danmakus, mLastBeginMills: " + this.mLastBeginMills + ", mLastEndMills: " + this.mLastEndMills + ", beginMills: " + j3 + ", endMills: " + j4);
        }
        this.mLastBeginMills = j3;
        this.mLastEndMills = j4;
        specialDanmaku = this.mRenderer.getSpecialDanmaku();
        while (r13.hasNext()) {
        }
        beginTracing(this.mRenderingState, this.danmakus);
        iDanmakus = this.danmakus;
        if (iDanmakus != null) {
        }
        IRenderer.RenderingState renderingState3 = this.mRenderingState;
        renderingState3.nothingRendered = true;
        renderingState3.beginTime = j3;
        renderingState3.endTime = j4;
        return renderingState3;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public IDanmakus getVisibleDanmakusOnTime(long j) {
        IDanmakus iDanmakus;
        long j2 = this.mContext.mDanmakuFactory.mMaxDanmakuDuration;
        long j3 = (j - j2) - 100;
        long j4 = j2 + j;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 3) {
                iDanmakus = null;
                break;
            }
            try {
                iDanmakus = this.danmakuList.subnew(j3, j4);
                break;
            } catch (Exception unused) {
                i = i2;
            }
        }
        final Danmakus danmakus2 = new Danmakus();
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            iDanmakus.forEachSync(new IDanmakus.DefaultConsumer<BaseDanmaku>() {
                /* class com.youku.danmaku.engine.controller.DrawTask.AnonymousClass5 */

                public int accept(BaseDanmaku baseDanmaku) {
                    if (!baseDanmaku.isShown() || baseDanmaku.isOutside()) {
                        return 0;
                    }
                    danmakus2.addItem(baseDanmaku);
                    return 0;
                }
            });
        }
        if (Log.isDebug()) {
            Log.d("getVisibleDanmakusOnTime current time=" + Log.showTime(j) + ", visible size=" + danmakus2.size());
        }
        return danmakus2;
    }

    /* access modifiers changed from: protected */
    public boolean handleOnDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object[] objArr) {
        boolean z = false;
        if (danmakuConfigTag == null || DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN.equals(danmakuConfigTag)) {
            return true;
        }
        if (DanmakuContext.DanmakuConfigTag.DUPLICATE_MERGING_ENABLED.equals(danmakuConfigTag)) {
            Boolean bool = (Boolean) objArr[0];
            if (bool != null) {
                if (bool.booleanValue()) {
                    this.mContext.mDanmakuFilters.registerFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
                    return true;
                }
                this.mContext.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
                return true;
            }
        } else if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
            requestClearRetainer();
        } else if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
            IRenderer iRenderer = this.mRenderer;
            if (iRenderer == null) {
                return true;
            }
            if (this.mContext.isPreventOverlappingEnabled() || this.mContext.isMaxLinesLimited()) {
                z = true;
            }
            iRenderer.setVerifierEnabled(z);
            return true;
        }
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public boolean hasDanmakusBySecond(long j) {
        DanmakuContext danmakuContext;
        DanmakuFactory danmakuFactory;
        IDanmakus iDanmakus = this.danmakus;
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            return hasInsideDanmakus(this.danmakus);
        }
        IDanmakus iDanmakus2 = this.danmakuList;
        if (!(iDanmakus2 == null || (danmakuContext = this.mContext) == null || (danmakuFactory = danmakuContext.mDanmakuFactory) == null)) {
            long j2 = danmakuFactory.mMaxDanmakuDuration;
            try {
                return hasInsideDanmakus(iDanmakus2.subnew((j - j2) - 100, j + j2));
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void initTimer(DanmakuTimer danmakuTimer) {
        this.mTimer = danmakuTimer;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z) {
        this.mContext.getDisplayer().getCacheStuffer().clearCache(baseDanmaku);
        int i = baseDanmaku.requestFlags | 2;
        baseDanmaku.requestFlags = i;
        if (z) {
            baseDanmaku.paintWidth = -1.0f;
            baseDanmaku.paintHeight = -1.0f;
            baseDanmaku.requestFlags = i | 1;
            baseDanmaku.measureResetFlag++;
        }
    }

    /* access modifiers changed from: protected */
    public void loadDanmakus(BaseDanmakuParser baseDanmakuParser) {
        this.danmakuList = baseDanmakuParser.setConfig(this.mContext).setDisplayer(this.mDisp).setTimer(this.mTimer).getDanmakus();
        this.mContext.mGlobalFlagValues.resetAll();
        IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus != null) {
            this.mLastDanmaku = iDanmakus.last();
        }
    }

    public boolean onDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean handleOnDanmakuConfigChanged = handleOnDanmakuConfigChanged(danmakuContext, danmakuConfigTag, objArr);
        IDrawTask.TaskListener taskListener = this.mTaskListener;
        if (taskListener != null) {
            taskListener.onDanmakuConfigChanged();
        }
        return handleOnDanmakuConfigChanged;
    }

    /* access modifiers changed from: protected */
    public void onDanmakuRemoved(BaseDanmaku baseDanmaku) {
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void onPlayStateChanged(int i) {
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void prepare() {
        loadDanmakus(this.mParser);
        this.mLastEndMills = 0;
        this.mLastBeginMills = 0;
        IDrawTask.TaskListener taskListener = this.mTaskListener;
        if (taskListener != null) {
            taskListener.ready();
            this.mReadyState = true;
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void quit() {
        this.mContext.unregisterAllConfigChangedCallbacks();
        IRenderer iRenderer = this.mRenderer;
        if (iRenderer != null) {
            iRenderer.release();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public synchronized void removeAllDanmakus() {
        IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus != null) {
            if (!iDanmakus.isEmpty()) {
                this.danmakuList.clear();
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public synchronized void removeAllLiveDanmakus() {
        IDanmakus iDanmakus = this.danmakus;
        if (iDanmakus != null) {
            if (!iDanmakus.isEmpty()) {
                synchronized (this.danmakus) {
                    this.danmakus.forEachSync(new IDanmakus.DefaultConsumer<BaseDanmaku>() {
                        /* class com.youku.danmaku.engine.controller.DrawTask.AnonymousClass3 */

                        public int accept(BaseDanmaku baseDanmaku) {
                            if (!baseDanmaku.isLive) {
                                return 0;
                            }
                            DrawTask.this.onDanmakuRemoved(baseDanmaku);
                            return 2;
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void removeUnusedLiveDanmakusIn(final int i) {
        IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus != null && !iDanmakus.isEmpty()) {
            if (!this.mLiveDanmakus.isEmpty()) {
                this.mLiveDanmakus.forEachSync(new IDanmakus.DefaultConsumer<BaseDanmaku>() {
                    /* class com.youku.danmaku.engine.controller.DrawTask.AnonymousClass4 */
                    long startTime = SystemClock.uptimeMillis();

                    public int accept(BaseDanmaku baseDanmaku) {
                        boolean isTimeOut = baseDanmaku.isTimeOut();
                        if (SystemClock.uptimeMillis() - this.startTime > ((long) i) || !isTimeOut) {
                            return 1;
                        }
                        DrawTask.this.danmakuList.removeItem(baseDanmaku);
                        DrawTask.this.onDanmakuRemoved(baseDanmaku);
                        return 2;
                    }
                });
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void requestClear() {
        this.mLastEndMills = 0;
        this.mLastBeginMills = 0;
        this.mIsHidden = false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void requestClearRetainer() {
        this.clearRetainerFlag = true;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void requestHide() {
        this.mIsHidden = true;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void reset(int i) {
        IDanmakus iDanmakus = this.danmakus;
        if (iDanmakus != null) {
            iDanmakus.clear();
        }
        IRenderer iRenderer = this.mRenderer;
        if (iRenderer != null) {
            iRenderer.clear();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public boolean screenHasData() {
        return false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void seek(long j, int i) {
        BaseDanmaku last;
        reset(0);
        this.mContext.mGlobalFlagValues.updateVisibleFlag();
        this.mContext.mGlobalFlagValues.updateFirstShownFlag();
        if (j < 1000) {
            j = 0;
        }
        this.mStartRenderTime = j;
        this.mRenderingState.reset();
        this.mRenderingState.endTime = this.mStartRenderTime;
        this.mLastEndMills = 0;
        this.mLastBeginMills = 0;
        IDanmakus iDanmakus = this.danmakuList;
        if (iDanmakus != null && (last = iDanmakus.last()) != null && !last.isTimeOut()) {
            this.mLastDanmaku = last;
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void setParser(BaseDanmakuParser baseDanmakuParser) {
        this.mParser = baseDanmakuParser;
        this.mReadyState = false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void start() {
        this.mContext.registerConfigChangedCallback(this.mConfigChangedCallback);
    }
}
