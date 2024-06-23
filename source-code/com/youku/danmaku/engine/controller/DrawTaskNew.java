package com.youku.danmaku.engine.controller;

import android.graphics.Canvas;
import com.youku.danmaku.engine.controller.IDrawTask;
import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuEngineContext;
import com.youku.danmaku.engine.danmaku.model.DanmakuRenderModel;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.GlobalFlagValues;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.model.danmaku.AutoStopR2LDanmaku;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakuRendererNew;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.engine.danmaku.util.SystemClock;
import com.youku.danmaku.plugin.IDanmakuDataPlugin;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class DrawTaskNew implements IDrawTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean clearRetainerFlag;
    private DanmakuContext.ConfigChangedCallback mConfigChangedCallback = new DanmakuContext.ConfigChangedCallback() {
        /* class com.youku.danmaku.engine.controller.DrawTaskNew.AnonymousClass1 */

        @Override // com.youku.danmaku.engine.danmaku.model.android.DanmakuContext.ConfigChangedCallback
        public boolean onDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
            return DrawTaskNew.this.onDanmakuConfigChanged(danmakuContext, danmakuConfigTag, objArr);
        }
    };
    final DanmakuContext mContext;
    private final IDanmakuDataPlugin mDanmakuDataPlugin;
    private final DanmakuRenderModel mDanmakuRenderModel = new DanmakuRenderModel();
    private final IDanmakuSettingPlugin mDanmakuSettingPlugin;
    final AbsDisplayer mDisp;
    private boolean mIsHidden;
    BaseDanmakuParser mParser;
    boolean mReadyState;
    final IRenderer mRenderer;
    private final IRenderer.RenderingState mRenderingState = new IRenderer.RenderingState();
    IDrawTask.TaskListener mTaskListener;
    DanmakuTimer mTimer;

    DrawTaskNew(DanmakuTimer danmakuTimer, DanmakuContext danmakuContext, IDrawTask.TaskListener taskListener) {
        if (danmakuContext != null) {
            this.mContext = danmakuContext;
            this.mDisp = danmakuContext.getDisplayer();
            this.mTaskListener = taskListener;
            this.mDanmakuDataPlugin = danmakuContext.getDanmakuDataPlugin();
            this.mDanmakuSettingPlugin = danmakuContext.getDanmakuSettingPlugin();
            DanmakuRendererNew danmakuRendererNew = new DanmakuRendererNew(danmakuContext);
            this.mRenderer = danmakuRendererNew;
            danmakuRendererNew.setOnDanmakuShownListener(new IRenderer.OnDanmakuShownListener() {
                /* class com.youku.danmaku.engine.controller.DrawTaskNew.AnonymousClass2 */

                @Override // com.youku.danmaku.engine.danmaku.renderer.IRenderer.OnDanmakuShownListener
                public void onDanmakuShown(BaseDanmaku baseDanmaku) {
                    IDrawTask.TaskListener taskListener = DrawTaskNew.this.mTaskListener;
                    if (taskListener != null) {
                        taskListener.onDanmakuShown(baseDanmaku);
                    }
                }
            });
            danmakuRendererNew.setVerifierEnabled(danmakuContext.isPreventOverlappingEnabled() || danmakuContext.isMaxLinesLimited());
            if (danmakuContext.isDuplicateMergingEnabled()) {
                danmakuContext.mDanmakuFilters.registerFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
            } else {
                danmakuContext.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
            }
            initTimer(danmakuTimer);
            initConfig();
            danmakuContext.registerConfigChangedCallback(this.mConfigChangedCallback);
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    private void beginTracing(IRenderer.RenderingState renderingState, List<BaseDanmaku> list) {
        renderingState.reset();
        renderingState.timer.update(SystemClock.uptimeMillis());
        int i = 0;
        renderingState.indexInScreen = 0;
        if (list != null) {
            i = list.size();
        }
        renderingState.totalSizeInScreen = i;
    }

    private void changeDanmakuTopPosition() {
        if (Log.isDebug()) {
            this.mRenderer.showVisibleDanmakuLog();
        }
        synchronized (this.mDanmakuRenderModel.mScreenDanmakuList) {
            if (!this.mDanmakuRenderModel.mScreenDanmakuList.isEmpty()) {
                float lineHeight = getLineHeight() + getLineSpace();
                for (BaseDanmaku baseDanmaku : this.mDanmakuRenderModel.mScreenDanmakuList) {
                    if (baseDanmaku != null && baseDanmaku.getType() == 1) {
                        R2LDanmaku r2LDanmaku = (R2LDanmaku) baseDanmaku;
                        float top = r2LDanmaku.getTop();
                        r2LDanmaku.setTopPosition(((float) r2LDanmaku.getDanmakuLine()) * lineHeight);
                        if (Log.isDebug()) {
                            Log.d("RLDanmakusRetainer", "changeDanmakuTopPosition, text=" + ((Object) baseDanmaku.text) + ", line=" + baseDanmaku.getDanmakuLine() + ", lineHeight=" + lineHeight + ", lastTop=" + top + ", top=" + baseDanmaku.getTop() + ", left=" + baseDanmaku.getLeft());
                        }
                    }
                }
            }
        }
    }

    private void clearAllList(int i) {
        if (Log.isDebug()) {
            Log.d("DrawTaskNew: clearAllList,,mScreenDanmakuList size=" + this.mDanmakuRenderModel.mScreenDanmakuList.size() + ",mHighLevelList size=" + this.mDanmakuRenderModel.mHighLevelList.size() + ",mNormalLevelList size=" + this.mDanmakuRenderModel.mNormalLevelList.size());
        }
        this.mDanmakuRenderModel.clear(i);
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

    private float getLineHeight() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getLineHeight();
        }
        return 24.0f * DanmakuEngineContext.getDensity();
    }

    private float getLineSpace() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getLineSpace();
        }
        return 6.0f * DanmakuEngineContext.getDensity();
    }

    private void initConfig() {
        if (Log.isDebug()) {
            Log.d("DrawTaskNew", "initConfig, Speed=" + this.mContext.getPlaySpeed() + ", SpeedFactor=" + this.mContext.scrollSpeedFactor);
        }
        this.mRenderer.changeSpeed(this.mContext.getPlaySpeed(), this.mContext.scrollSpeedFactor);
    }

    private void resetScreenState(DanmakuContext danmakuContext, Object[] objArr) {
        float f = 1.0f;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    f = ((Float) objArr[0]).floatValue();
                }
            } catch (Exception unused) {
            }
        }
        this.mRenderer.changeSpeed(danmakuContext.getPlaySpeed(), f);
        synchronized (this.mDanmakuRenderModel.mScreenDanmakuList) {
            if (!this.mDanmakuRenderModel.mScreenDanmakuList.isEmpty()) {
                for (BaseDanmaku baseDanmaku : this.mDanmakuRenderModel.mScreenDanmakuList) {
                    if (baseDanmaku != null && baseDanmaku.getType() == 1) {
                        this.mRenderer.changeSpeed((R2LDanmaku) baseDanmaku);
                    }
                }
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void addDanmaku(BaseDanmaku baseDanmaku) {
        if (baseDanmaku != null) {
            if (this.mDanmakuRenderModel.mHighLevelList.size() > 0) {
                this.mDanmakuRenderModel.mHighLevelList.add(0, baseDanmaku);
            } else {
                this.mDanmakuRenderModel.mHighLevelList.add(baseDanmaku);
            }
            if (Log.isDebug()) {
                Log.d("add local high Danmaku= " + ((Object) baseDanmaku.text) + ",size=" + this.mDanmakuRenderModel.mHighLevelList.size());
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void addDanmakuList(List<BaseDanmaku> list, long j, GlobalFlagValues globalFlagValues, DanmakuTimer danmakuTimer) {
        IDanmakuDataPlugin iDanmakuDataPlugin = this.mDanmakuDataPlugin;
        if (iDanmakuDataPlugin == null || iDanmakuDataPlugin.getDanmakuRefreshMode() == 0) {
            this.mDanmakuRenderModel.mNormalLevelList.clear();
        }
        if (list != null && list.size() > 0) {
            for (BaseDanmaku baseDanmaku : list) {
                if (!this.mDanmakuRenderModel.mScreenDanmakuList.contains(baseDanmaku) && baseDanmaku != null && !baseDanmaku.isBombed) {
                    baseDanmaku.time = j;
                    baseDanmaku.flags = globalFlagValues;
                    baseDanmaku.setTimer(danmakuTimer);
                    baseDanmaku.filterResetFlag = -1;
                    baseDanmaku.mFilterParam = 0;
                    baseDanmaku.reset();
                    if (baseDanmaku instanceof AutoStopR2LDanmaku) {
                        ((AutoStopR2LDanmaku) baseDanmaku).resetState();
                    }
                    if (baseDanmaku.priority > 0) {
                        this.mDanmakuRenderModel.mHighLevelList.add(baseDanmaku);
                    } else {
                        this.mDanmakuRenderModel.mNormalLevelList.add(baseDanmaku);
                    }
                }
            }
            if (Log.isDebug()) {
                Log.d("current second list count= " + list.size());
                Log.d("normalLevelList count= " + this.mDanmakuRenderModel.mNormalLevelList.size());
                Log.d("highLevelList count= " + this.mDanmakuRenderModel.mHighLevelList.size());
            }
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void clearDanmakusOnScreen(long j) {
        reset(0);
        this.mContext.mGlobalFlagValues.updateVisibleFlag();
        this.mContext.mGlobalFlagValues.updateFirstShownFlag();
        Log.showDebugLog("clearDanmakusOnScreen, mStartRenderTime=" + j);
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public synchronized IRenderer.RenderingState draw(AbsDisplayer absDisplayer) {
        this.mDanmakuRenderModel.mClearRetainerFlag = false;
        if (this.clearRetainerFlag) {
            this.mRenderer.clearRetainer();
            this.mDanmakuRenderModel.mClearRetainerFlag = true;
            this.clearRetainerFlag = false;
        }
        DrawHelper.clearCanvas((Canvas) absDisplayer.getExtraData());
        if (this.mIsHidden) {
            return this.mRenderingState;
        }
        beginTracing(this.mRenderingState, this.mDanmakuRenderModel.mScreenDanmakuList);
        if (this.mDanmakuRenderModel.hasDanmakuToDraw()) {
            DanmakuRenderModel danmakuRenderModel = this.mDanmakuRenderModel;
            danmakuRenderModel.mCurrentMillisecond = this.mTimer.currMillisecond;
            this.mRenderer.draw(this.mDisp, this.mRenderingState, danmakuRenderModel);
            endTracing(this.mRenderingState);
            return this.mRenderingState;
        }
        IRenderer.RenderingState renderingState = this.mRenderingState;
        renderingState.nothingRendered = true;
        return renderingState;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public IDanmakus getVisibleDanmakusOnTime(long j) {
        ArrayList arrayList;
        synchronized (this.mDanmakuRenderModel.mScreenDanmakuList) {
            arrayList = new ArrayList(this.mDanmakuRenderModel.mScreenDanmakuList);
        }
        Log.showDebugLog("visible size=" + arrayList.size());
        if (arrayList.isEmpty()) {
            return new Danmakus();
        }
        return new Danmakus(arrayList);
    }

    /* access modifiers changed from: package-private */
    public boolean handleOnDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object[] objArr) {
        boolean z = false;
        if (danmakuConfigTag != null && !DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN.equals(danmakuConfigTag)) {
            if (DanmakuContext.DanmakuConfigTag.DUPLICATE_MERGING_ENABLED.equals(danmakuConfigTag)) {
                Boolean bool = (Boolean) objArr[0];
                if (bool == null) {
                    return false;
                }
                if (bool.booleanValue()) {
                    this.mContext.mDanmakuFilters.registerFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
                } else {
                    this.mContext.mDanmakuFilters.unregisterFilter(DanmakuFilters.TAG_DUPLICATE_FILTER);
                }
            } else {
                DanmakuContext.DanmakuConfigTag danmakuConfigTag2 = DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE;
                if (danmakuConfigTag2.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                    IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
                    if (iDanmakuSettingPlugin == null || (!iDanmakuSettingPlugin.isNewCompose() && !this.mDanmakuSettingPlugin.isNewTypesetting())) {
                        requestClearRetainer();
                        return false;
                    } else if (danmakuConfigTag2.equals(danmakuConfigTag)) {
                        changeDanmakuTopPosition();
                        return false;
                    } else if (!DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                        return false;
                    } else {
                        resetScreenState(danmakuContext, objArr);
                    }
                } else if (!DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) && !DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
                    return false;
                } else {
                    IRenderer iRenderer = this.mRenderer;
                    if (iRenderer != null) {
                        if (this.mContext.isPreventOverlappingEnabled() || this.mContext.isMaxLinesLimited()) {
                            z = true;
                        }
                        iRenderer.setVerifierEnabled(z);
                    }
                }
            }
        }
        return true;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public boolean hasDanmakusBySecond(long j) {
        return this.mDanmakuRenderModel.hasDanmakusBySecond();
    }

    /* access modifiers changed from: protected */
    public void initTimer(DanmakuTimer danmakuTimer) {
        this.mTimer = danmakuTimer;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z) {
        this.mDisp.getCacheStuffer().clearCache(baseDanmaku);
        int i = baseDanmaku.requestFlags | 2;
        baseDanmaku.requestFlags = i;
        if (z) {
            baseDanmaku.paintWidth = -1.0f;
            baseDanmaku.paintHeight = -1.0f;
            baseDanmaku.requestFlags = i | 1;
            baseDanmaku.measureResetFlag++;
        }
    }

    /* access modifiers changed from: package-private */
    public void loadDanmaku(BaseDanmakuParser baseDanmakuParser) {
        baseDanmakuParser.setConfig(this.mContext).setDisplayer(this.mDisp).setTimer(this.mTimer).getDanmakus();
        this.mContext.mGlobalFlagValues.resetAll();
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
        loadDanmaku(this.mParser);
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
    public void removeAllDanmakus() {
        clearAllList(0);
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void removeAllLiveDanmakus() {
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void requestClear() {
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
        clearAllList(i);
        IRenderer iRenderer = this.mRenderer;
        if (iRenderer != null) {
            iRenderer.clear();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public boolean screenHasData() {
        return this.mDanmakuRenderModel.screenHasData();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void seek(long j, int i) {
        reset(i);
        this.mContext.mGlobalFlagValues.updateVisibleFlag();
        this.mContext.mGlobalFlagValues.updateFirstShownFlag();
        this.mRenderingState.reset();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void setParser(BaseDanmakuParser baseDanmakuParser) {
        this.mParser = baseDanmakuParser;
        this.mReadyState = false;
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask
    public void start() {
    }
}
