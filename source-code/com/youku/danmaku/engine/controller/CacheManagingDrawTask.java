package com.youku.danmaku.engine.controller;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.youku.danmaku.engine.controller.IDrawTask;
import com.youku.danmaku.engine.danmaku.model.AbsDisplayer;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.ICacheManager;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDrawingCache;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.model.android.DrawingCache;
import com.youku.danmaku.engine.danmaku.model.android.DrawingCachePoolManager;
import com.youku.danmaku.engine.danmaku.model.objectpool.Pool;
import com.youku.danmaku.engine.danmaku.model.objectpool.Pools;
import com.youku.danmaku.engine.danmaku.renderer.IRenderer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.engine.danmaku.util.SystemClock;
import tv.cjump.jni.NativeBitmapFactory;

/* compiled from: Taobao */
public class CacheManagingDrawTask extends DrawTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_CACHE_SCREEN_SIZE = 3;
    private CacheManager mCacheManager;
    private DanmakuTimer mCacheTimer;
    private final Object mDrawingNotify = new Object();
    private int mMaxCacheSize = 2;
    private int mRemainingCacheCount;

    /* compiled from: Taobao */
    public class CacheManager implements ICacheManager {
        public static final byte RESULT_FAILED = 1;
        public static final byte RESULT_FAILED_OVERSIZE = 2;
        public static final byte RESULT_SUCCESS = 0;
        private static final String TAG = "CacheManager";
        Pool<DrawingCache> mCachePool;
        DrawingCachePoolManager mCachePoolManager;
        Danmakus mCaches = new Danmakus();
        private boolean mEndFlag;
        private CacheHandler mHandler;
        private int mMaxSize;
        private int mRealSize;
        private int mScreenSize;
        public HandlerThread mThread;

        /* compiled from: Taobao */
        public class CacheHandler extends Handler {
            public static final int ADD_DANMAKKU = 2;
            public static final int BUILD_CACHES = 3;
            public static final int CLEAR_ALL_CACHES = 7;
            public static final int CLEAR_OUTSIDE_CACHES = 8;
            public static final int CLEAR_OUTSIDE_CACHES_AND_RESET = 9;
            public static final int CLEAR_TIMEOUT_CACHES = 4;
            public static final int DISABLE_CANCEL_FLAG = 18;
            public static final int DISPATCH_ACTIONS = 16;
            private static final int PREPARE = 1;
            public static final int QUIT = 6;
            public static final int REBUILD_CACHE = 17;
            public static final int SEEK = 5;
            private boolean mCancelFlag;
            private boolean mIsPlayerPause;
            private boolean mPause;
            private boolean mSeekedFlag;

            public CacheHandler(Looper looper) {
                super(looper);
            }

            private void addDanmakuAndBuildCache(BaseDanmaku baseDanmaku) {
                if (baseDanmaku.isTimeOut()) {
                    return;
                }
                if (baseDanmaku.time > CacheManagingDrawTask.this.mCacheTimer.currMillisecond + CacheManagingDrawTask.this.mContext.mDanmakuFactory.mMaxDanmakuDuration && !baseDanmaku.isLive) {
                    return;
                }
                if (baseDanmaku.flags == null) {
                    if (Log.isDebug()) {
                        Log.d(CacheManager.TAG, "danmaku flags is null, text=" + ((Object) baseDanmaku.text) + ", time=" + baseDanmaku.minute + "," + baseDanmaku.second);
                    }
                } else if ((baseDanmaku.priority != 0 || !baseDanmaku.isFiltered()) && !baseDanmaku.hasDrawingCache()) {
                    buildCache(baseDanmaku, true);
                }
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private byte buildCache(BaseDanmaku baseDanmaku, boolean z) {
                if (!baseDanmaku.isMeasured()) {
                    baseDanmaku.measure(CacheManagingDrawTask.this.mDisp, true);
                }
                DrawingCache drawingCache = null;
                try {
                    CacheManager cacheManager = CacheManager.this;
                    BaseDanmaku findReuseableCache = cacheManager.findReuseableCache(baseDanmaku, true, CacheManagingDrawTask.this.mContext.cachingPolicy.maxTimesOfStrictReusableFinds);
                    DrawingCache drawingCache2 = findReuseableCache != null ? (DrawingCache) findReuseableCache.cache : null;
                    if (drawingCache2 != null) {
                        try {
                            drawingCache2.increaseReference();
                            baseDanmaku.cache = drawingCache2;
                            CacheManagingDrawTask.this.mCacheManager.push(baseDanmaku, 0, z);
                            return 0;
                        } catch (OutOfMemoryError unused) {
                            drawingCache = drawingCache2;
                            releaseDanmakuCache(baseDanmaku, drawingCache);
                            return 1;
                        } catch (Exception unused2) {
                            drawingCache = drawingCache2;
                            releaseDanmakuCache(baseDanmaku, drawingCache);
                            return 1;
                        }
                    } else {
                        CacheManager cacheManager2 = CacheManager.this;
                        BaseDanmaku findReuseableCache2 = cacheManager2.findReuseableCache(baseDanmaku, false, CacheManagingDrawTask.this.mContext.cachingPolicy.maxTimesOfReusableFinds);
                        if (findReuseableCache2 != null) {
                            drawingCache2 = (DrawingCache) findReuseableCache2.cache;
                        }
                        if (drawingCache2 != null) {
                            findReuseableCache2.cache = null;
                            CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                            baseDanmaku.cache = DanmakuUtils.buildDanmakuDrawingCache(baseDanmaku, cacheManagingDrawTask.mDisp, drawingCache2, cacheManagingDrawTask.mContext.cachingPolicy.bitsPerPixelOfCache);
                            CacheManagingDrawTask.this.mCacheManager.push(baseDanmaku, 0, z);
                            return 0;
                        }
                        int cacheSize = DanmakuUtils.getCacheSize((int) baseDanmaku.paintWidth, (int) baseDanmaku.paintHeight, CacheManagingDrawTask.this.mContext.cachingPolicy.bitsPerPixelOfCache / 8);
                        if (cacheSize * 2 > CacheManagingDrawTask.this.mMaxCacheSize) {
                            return 1;
                        }
                        if (z || CacheManager.this.mRealSize + cacheSize <= CacheManager.this.mMaxSize) {
                            CacheManagingDrawTask cacheManagingDrawTask2 = CacheManagingDrawTask.this;
                            DrawingCache buildDanmakuDrawingCache = DanmakuUtils.buildDanmakuDrawingCache(baseDanmaku, cacheManagingDrawTask2.mDisp, CacheManager.this.mCachePool.acquire(), cacheManagingDrawTask2.mContext.cachingPolicy.bitsPerPixelOfCache);
                            baseDanmaku.cache = buildDanmakuDrawingCache;
                            boolean push = CacheManagingDrawTask.this.mCacheManager.push(baseDanmaku, CacheManager.this.sizeOf(baseDanmaku), z);
                            if (!push) {
                                releaseDanmakuCache(baseDanmaku, buildDanmakuDrawingCache);
                            }
                            return !push ? 1 : 0 ? (byte) 1 : 0;
                        }
                        CacheManagingDrawTask.this.mCacheManager.clearTimeOutAndFilteredCaches(cacheSize, false);
                        return 1;
                    }
                } catch (OutOfMemoryError unused3) {
                    releaseDanmakuCache(baseDanmaku, drawingCache);
                    return 1;
                } catch (Exception unused4) {
                    releaseDanmakuCache(baseDanmaku, drawingCache);
                    return 1;
                }
            }

            private long dispatchAction() {
                long j = CacheManagingDrawTask.this.mCacheTimer.currMillisecond;
                CacheManager cacheManager = CacheManager.this;
                CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                long j2 = cacheManagingDrawTask.mTimer.currMillisecond;
                DanmakuContext danmakuContext = cacheManagingDrawTask.mContext;
                if (j <= j2 - danmakuContext.mDanmakuFactory.mMaxDanmakuDuration) {
                    if (danmakuContext.cachingPolicy.periodOfRecycle != -1) {
                        cacheManager.evictAllNotInScreen();
                    }
                    CacheManagingDrawTask.this.mCacheTimer.update(CacheManagingDrawTask.this.mTimer.currMillisecond);
                    sendEmptyMessage(3);
                    if (Log.isDebug()) {
                        Log.d(CacheManager.TAG, "handle dispatchAction BUILD_CACHES");
                    }
                    return 0;
                }
                float poolPercent = cacheManager.getPoolPercent();
                if (Log.isDebug()) {
                    Log.d(CacheManager.TAG, "getPoolPercent=" + poolPercent + ", mRealSize=" + CacheManager.this.mRealSize + ", mMaxSize=" + CacheManager.this.mMaxSize);
                }
                BaseDanmaku first = CacheManager.this.mCaches.first();
                long j3 = first != null ? first.time - CacheManagingDrawTask.this.mTimer.currMillisecond : 0;
                CacheManagingDrawTask cacheManagingDrawTask2 = CacheManagingDrawTask.this;
                long j4 = cacheManagingDrawTask2.mContext.mDanmakuFactory.mMaxDanmakuDuration;
                long j5 = 2 * j4;
                if (poolPercent < 0.6f && j3 > j4) {
                    cacheManagingDrawTask2.mCacheTimer.update(CacheManagingDrawTask.this.mTimer.currMillisecond);
                    removeMessages(3);
                    sendEmptyMessage(3);
                    if (Log.isDebug()) {
                        Log.d(CacheManager.TAG, "handle dispatchAction level < 0.6f BUILD_CACHES");
                    }
                    return 0;
                } else if (poolPercent > 0.4f && j3 < (-j5)) {
                    removeMessages(4);
                    sendEmptyMessage(4);
                    if (Log.isDebug()) {
                        Log.d(CacheManager.TAG, "handle dispatchAction CLEAR_TIMEOUT_CACHES");
                    }
                    return 0;
                } else if (poolPercent >= 0.9f) {
                    return 0;
                } else {
                    long j6 = cacheManagingDrawTask2.mCacheTimer.currMillisecond - CacheManagingDrawTask.this.mTimer.currMillisecond;
                    if (first != null && first.isTimeOut()) {
                        CacheManagingDrawTask cacheManagingDrawTask3 = CacheManagingDrawTask.this;
                        if (j6 < (-cacheManagingDrawTask3.mContext.mDanmakuFactory.mMaxDanmakuDuration)) {
                            cacheManagingDrawTask3.mCacheTimer.update(CacheManagingDrawTask.this.mTimer.currMillisecond);
                            sendEmptyMessage(8);
                            sendEmptyMessage(3);
                            return 0;
                        }
                    }
                    if (j6 > j5) {
                        return 0;
                    }
                    removeMessages(3);
                    sendEmptyMessage(3);
                    if (Log.isDebug()) {
                        Log.d(CacheManager.TAG, "handle dispatchAction end BUILD_CACHES");
                    }
                    return 0;
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
            private long prepareCaches(final boolean z) {
                IDanmakus iDanmakus;
                boolean z2;
                long j;
                final long j2 = CacheManagingDrawTask.this.mCacheTimer.currMillisecond - 30;
                CacheManager cacheManager = CacheManager.this;
                long j3 = j2 + (CacheManagingDrawTask.this.mContext.mDanmakuFactory.mMaxDanmakuDuration * ((long) cacheManager.mScreenSize));
                final long j4 = 0;
                if (j3 < CacheManagingDrawTask.this.mTimer.currMillisecond) {
                    return 0;
                }
                final long uptimeMillis = SystemClock.uptimeMillis();
                IDanmakus iDanmakus2 = null;
                int i = 0;
                boolean z3 = false;
                while (true) {
                    try {
                        iDanmakus = CacheManagingDrawTask.this.danmakuList.subnew(j2, j3);
                        z2 = z3;
                    } catch (Exception unused) {
                        SystemClock.sleep(10);
                        iDanmakus = iDanmakus2;
                        z2 = true;
                    }
                    i++;
                    if (i < 3 && iDanmakus == null && z2) {
                        z3 = z2;
                        iDanmakus2 = iDanmakus;
                    } else if (iDanmakus != null) {
                        CacheManagingDrawTask.this.mCacheTimer.update(j3);
                        return 0;
                    } else {
                        BaseDanmaku first = iDanmakus.first();
                        final BaseDanmaku last = iDanmakus.last();
                        if (first == null || last == null) {
                            CacheManagingDrawTask.this.mCacheTimer.update(j3);
                            return 0;
                        }
                        long j5 = first.time;
                        CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                        long j6 = j5 - cacheManagingDrawTask.mTimer.currMillisecond;
                        if (j6 < 0) {
                            j = 30;
                        } else {
                            j = ((j6 * 10) / cacheManagingDrawTask.mContext.mDanmakuFactory.mMaxDanmakuDuration) + 30;
                        }
                        long min = Math.min(100L, j);
                        if (!z) {
                            j4 = min;
                        }
                        final int size = iDanmakus.size();
                        iDanmakus.forEach(new IDanmakus.DefaultConsumer<BaseDanmaku>() {
                            /* class com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.CacheHandler.AnonymousClass1 */
                            int currScreenIndex = 0;
                            int orderInScreen = 0;

                            public int accept(BaseDanmaku baseDanmaku) {
                                if (CacheHandler.this.mPause || CacheHandler.this.mCancelFlag || last.time < CacheManagingDrawTask.this.mTimer.currMillisecond) {
                                    return 1;
                                }
                                IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
                                if (iDrawingCache != null && iDrawingCache.get() != null) {
                                    return 0;
                                }
                                if (!z && (baseDanmaku.isTimeOut() || !baseDanmaku.isOutside())) {
                                    return 0;
                                }
                                if (!baseDanmaku.hasPassedFilter()) {
                                    DanmakuContext danmakuContext = CacheManagingDrawTask.this.mContext;
                                    danmakuContext.mDanmakuFilters.filter(baseDanmaku, this.orderInScreen, size, null, true, danmakuContext);
                                }
                                if (baseDanmaku.priority == 0 && baseDanmaku.isFiltered()) {
                                    return 0;
                                }
                                if (baseDanmaku.getType() == 1) {
                                    int i = (int) ((baseDanmaku.time - j2) / CacheManagingDrawTask.this.mContext.mDanmakuFactory.mMaxDanmakuDuration);
                                    if (this.currScreenIndex == i) {
                                        this.orderInScreen++;
                                    } else {
                                        this.orderInScreen = 0;
                                        this.currScreenIndex = i;
                                    }
                                }
                                if (!z && !CacheHandler.this.mIsPlayerPause) {
                                    try {
                                        synchronized (CacheManagingDrawTask.this.mDrawingNotify) {
                                            CacheManagingDrawTask.this.mDrawingNotify.wait(j4);
                                        }
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                        return 1;
                                    }
                                }
                                CacheHandler.this.buildCache(baseDanmaku, false);
                                if (!z) {
                                    CacheManager cacheManager = CacheManager.this;
                                    if (SystemClock.uptimeMillis() - uptimeMillis >= CacheManagingDrawTask.this.mContext.mDanmakuFactory.mMaxDanmakuDuration * ((long) cacheManager.mScreenSize)) {
                                        return 1;
                                    }
                                }
                                return 0;
                            }
                        });
                        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                        CacheManagingDrawTask.this.mCacheTimer.update(j3);
                        return uptimeMillis2;
                    }
                }
                if (iDanmakus != null) {
                }
            }

            private void releaseDanmakuCache(BaseDanmaku baseDanmaku, DrawingCache drawingCache) {
                if (drawingCache == null) {
                    drawingCache = (DrawingCache) baseDanmaku.cache;
                }
                baseDanmaku.cache = null;
                if (drawingCache != null) {
                    drawingCache.destroy();
                    CacheManager.this.mCachePool.release(drawingCache);
                }
            }

            public void begin() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, CacheManagingDrawTask.this.mContext.mDanmakuFactory.mMaxDanmakuDuration);
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0043  */
            public boolean createCache(BaseDanmaku baseDanmaku) {
                DrawingCache drawingCache;
                if (!baseDanmaku.isMeasured()) {
                    baseDanmaku.measure(CacheManagingDrawTask.this.mDisp, true);
                }
                try {
                    DrawingCache acquire = CacheManager.this.mCachePool.acquire();
                    try {
                        CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                        drawingCache = DanmakuUtils.buildDanmakuDrawingCache(baseDanmaku, cacheManagingDrawTask.mDisp, acquire, cacheManagingDrawTask.mContext.cachingPolicy.bitsPerPixelOfCache);
                        baseDanmaku.cache = drawingCache;
                        return true;
                    } catch (OutOfMemoryError unused) {
                        if (drawingCache != null) {
                        }
                        baseDanmaku.cache = null;
                        return false;
                    } catch (Exception unused2) {
                        if (drawingCache != null) {
                        }
                        baseDanmaku.cache = null;
                        return false;
                    }
                } catch (OutOfMemoryError unused3) {
                    drawingCache = null;
                    if (drawingCache != null) {
                        CacheManager.this.mCachePool.release(drawingCache);
                    }
                    baseDanmaku.cache = null;
                    return false;
                } catch (Exception unused4) {
                    drawingCache = null;
                    if (drawingCache != null) {
                        CacheManager.this.mCachePool.release(drawingCache);
                    }
                    baseDanmaku.cache = null;
                    return false;
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:46:0x0159  */
            /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
            public void handleMessage(Message message) {
                int i = message.what;
                switch (i) {
                    case 1:
                        CacheManager.this.evictAllNotInScreen();
                        for (int i2 = 0; i2 < 300; i2++) {
                            CacheManager.this.mCachePool.release(new DrawingCache());
                        }
                        break;
                    case 2:
                        addDanmakuAndBuildCache((BaseDanmaku) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        CacheManagingDrawTask cacheManagingDrawTask = CacheManagingDrawTask.this;
                        boolean z = (cacheManagingDrawTask.mTaskListener != null && !cacheManagingDrawTask.mReadyState) || this.mSeekedFlag;
                        prepareCaches(z);
                        if (z) {
                            this.mSeekedFlag = false;
                        }
                        CacheManagingDrawTask cacheManagingDrawTask2 = CacheManagingDrawTask.this;
                        IDrawTask.TaskListener taskListener = cacheManagingDrawTask2.mTaskListener;
                        if (taskListener != null && !cacheManagingDrawTask2.mReadyState) {
                            taskListener.ready();
                            CacheManagingDrawTask.this.mReadyState = true;
                        }
                        if (Log.isDebug()) {
                            Log.d(CacheManager.TAG, "handleMessage BUILD_CACHES");
                            return;
                        }
                        return;
                    case 4:
                        CacheManager.this.clearTimeOutCaches();
                        if (Log.isDebug()) {
                            Log.d(CacheManager.TAG, "handleMessage CLEAR_TIMEOUT_CACHES");
                            return;
                        }
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long longValue = l.longValue();
                            long j = CacheManagingDrawTask.this.mCacheTimer.currMillisecond;
                            CacheManagingDrawTask.this.mCacheTimer.update(longValue);
                            this.mSeekedFlag = true;
                            long firstCacheTime = CacheManager.this.getFirstCacheTime();
                            if (longValue <= j) {
                                CacheManager cacheManager = CacheManager.this;
                                if (firstCacheTime - longValue <= CacheManagingDrawTask.this.mContext.mDanmakuFactory.mMaxDanmakuDuration) {
                                    cacheManager.clearTimeOutCaches();
                                    prepareCaches(true);
                                    resume();
                                    if (!Log.isDebug()) {
                                        Log.d(CacheManager.TAG, "handleMessage SEEK");
                                        return;
                                    }
                                    return;
                                }
                            }
                            CacheManager.this.evictAllNotInScreen();
                            prepareCaches(true);
                            resume();
                            if (!Log.isDebug()) {
                            }
                        } else {
                            return;
                        }
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.mPause = true;
                        CacheManager.this.evictAll();
                        CacheManager.this.clearCachePool();
                        getLooper().quit();
                        return;
                    case 7:
                        CacheManager.this.evictAll();
                        DanmakuTimer danmakuTimer = CacheManagingDrawTask.this.mCacheTimer;
                        CacheManagingDrawTask cacheManagingDrawTask3 = CacheManagingDrawTask.this;
                        danmakuTimer.update(cacheManagingDrawTask3.mTimer.currMillisecond - cacheManagingDrawTask3.mContext.mDanmakuFactory.mMaxDanmakuDuration);
                        this.mSeekedFlag = true;
                        if (Log.isDebug()) {
                            Log.d(CacheManager.TAG, "handleMessage CLEAR_ALL_CACHES");
                            return;
                        }
                        return;
                    case 8:
                        CacheManager.this.evictAllNotInScreen();
                        CacheManagingDrawTask.this.mCacheTimer.update(CacheManagingDrawTask.this.mTimer.currMillisecond);
                        if (Log.isDebug()) {
                            Log.d(CacheManager.TAG, "handleMessage CLEAR_OUTSIDE_CACHES");
                            return;
                        }
                        return;
                    case 9:
                        CacheManager.this.evictAllNotInScreen();
                        CacheManagingDrawTask.this.mCacheTimer.update(CacheManagingDrawTask.this.mTimer.currMillisecond);
                        CacheManagingDrawTask.this.requestClear();
                        if (Log.isDebug()) {
                            Log.d(CacheManager.TAG, "handleMessage CLEAR_OUTSIDE_CACHES_AND_RESET");
                            return;
                        }
                        return;
                    default:
                        switch (i) {
                            case 16:
                                break;
                            case 17:
                                BaseDanmaku baseDanmaku = (BaseDanmaku) message.obj;
                                if (baseDanmaku != null) {
                                    IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
                                    if (!((baseDanmaku.requestFlags & 1) != 0) && iDrawingCache != null && iDrawingCache.get() != null && !iDrawingCache.hasReferences()) {
                                        CacheManagingDrawTask cacheManagingDrawTask4 = CacheManagingDrawTask.this;
                                        baseDanmaku.cache = DanmakuUtils.buildDanmakuDrawingCache(baseDanmaku, cacheManagingDrawTask4.mDisp, (DrawingCache) baseDanmaku.cache, cacheManagingDrawTask4.mContext.cachingPolicy.bitsPerPixelOfCache);
                                        CacheManager.this.push(baseDanmaku, 0, true);
                                        return;
                                    } else if (baseDanmaku.isLive) {
                                        CacheManager.this.clearCache(baseDanmaku);
                                        createCache(baseDanmaku);
                                        return;
                                    } else {
                                        if (iDrawingCache != null && iDrawingCache.hasReferences()) {
                                            iDrawingCache.destroy();
                                        }
                                        CacheManager.this.entryRemoved(true, baseDanmaku, null);
                                        addDanmakuAndBuildCache(baseDanmaku);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            case 18:
                                this.mCancelFlag = false;
                                return;
                            default:
                                return;
                        }
                }
                long dispatchAction = dispatchAction();
                if (dispatchAction <= 0) {
                    dispatchAction = CacheManagingDrawTask.this.mContext.mDanmakuFactory.mMaxDanmakuDuration / 2;
                }
                sendEmptyMessageDelayed(16, dispatchAction);
                if (Log.isDebug()) {
                    Log.d(CacheManager.TAG, "handleMessage DISPATCH_ACTIONS");
                }
            }

            public boolean isPause() {
                return this.mPause;
            }

            public void onPlayStateChanged(boolean z) {
                this.mIsPlayerPause = !z;
            }

            public void pause() {
                this.mPause = true;
                removeCallbacksAndMessages(null);
                sendEmptyMessage(6);
            }

            public void requestBuildCacheAndDraw(long j) {
                removeMessages(3);
                this.mSeekedFlag = true;
                sendEmptyMessage(18);
                CacheManagingDrawTask.this.mCacheTimer.update(CacheManagingDrawTask.this.mTimer.currMillisecond + j);
                sendEmptyMessage(3);
            }

            public void requestCancelCaching() {
                this.mCancelFlag = true;
            }

            public void resume() {
                sendEmptyMessage(18);
                this.mPause = false;
                removeMessages(16);
                sendEmptyMessage(16);
                sendEmptyMessageDelayed(4, CacheManagingDrawTask.this.mContext.mDanmakuFactory.mMaxDanmakuDuration);
            }
        }

        public CacheManager(int i, int i2) {
            DrawingCachePoolManager drawingCachePoolManager = new DrawingCachePoolManager();
            this.mCachePoolManager = drawingCachePoolManager;
            this.mCachePool = Pools.finitePool(drawingCachePoolManager, 800);
            this.mScreenSize = 3;
            this.mEndFlag = false;
            this.mRealSize = 0;
            this.mMaxSize = i;
            this.mScreenSize = i2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private long clearCache(BaseDanmaku baseDanmaku) {
            IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
            if (iDrawingCache == null) {
                return 0;
            }
            if (iDrawingCache.hasReferences()) {
                iDrawingCache.decreaseReference();
                baseDanmaku.cache = null;
                return 0;
            }
            long sizeOf = (long) sizeOf(baseDanmaku);
            iDrawingCache.destroy();
            baseDanmaku.cache = null;
            return sizeOf;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void clearCachePool() {
            while (true) {
                DrawingCache acquire = this.mCachePool.acquire();
                if (acquire != null) {
                    acquire.destroy();
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void clearTimeOutAndFilteredCaches(final int i, final boolean z) {
            this.mCaches.forEach(new IDanmakus.DefaultConsumer<BaseDanmaku>() {
                /* class com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.AnonymousClass5 */

                public int accept(BaseDanmaku baseDanmaku) {
                    if (CacheManager.this.mEndFlag || CacheManager.this.mRealSize + i <= CacheManager.this.mMaxSize) {
                        return 1;
                    }
                    if (baseDanmaku.isTimeOut() || baseDanmaku.isFiltered()) {
                        CacheManager.this.entryRemoved(false, baseDanmaku, null);
                        return 2;
                    } else if (z) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void clearTimeOutCaches() {
            this.mCaches.forEach(new IDanmakus.DefaultConsumer<BaseDanmaku>() {
                /* class com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.AnonymousClass3 */

                public int accept(BaseDanmaku baseDanmaku) {
                    if (!baseDanmaku.isTimeOut()) {
                        return 1;
                    }
                    IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
                    if (CacheManagingDrawTask.this.mContext.cachingPolicy.periodOfRecycle == -1 && iDrawingCache != null && !iDrawingCache.hasReferences() && ((float) iDrawingCache.size()) / ((float) CacheManagingDrawTask.this.mMaxCacheSize) < CacheManagingDrawTask.this.mContext.cachingPolicy.forceRecyleThreshold) {
                        return 0;
                    }
                    if (!CacheManager.this.mEndFlag) {
                        synchronized (CacheManagingDrawTask.this.mDrawingNotify) {
                            try {
                                CacheManagingDrawTask.this.mDrawingNotify.wait(30);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return 1;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    CacheManager.this.entryRemoved(false, baseDanmaku, null);
                    return 2;
                }
            });
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void evictAll() {
            Danmakus danmakus = this.mCaches;
            if (danmakus != null) {
                danmakus.forEachSync(new IDanmakus.DefaultConsumer<BaseDanmaku>() {
                    /* class com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.AnonymousClass1 */

                    public int accept(BaseDanmaku baseDanmaku) {
                        CacheManager.this.entryRemoved(true, baseDanmaku, null);
                        return 0;
                    }
                });
                this.mCaches.clear();
            }
            this.mRealSize = 0;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void evictAllNotInScreen() {
            Danmakus danmakus = this.mCaches;
            if (danmakus != null) {
                danmakus.forEach(new IDanmakus.DefaultConsumer<BaseDanmaku>() {
                    /* class com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.AnonymousClass2 */

                    public int accept(BaseDanmaku baseDanmaku) {
                        if (!baseDanmaku.isOutside()) {
                            return 0;
                        }
                        CacheManager.this.entryRemoved(true, baseDanmaku, null);
                        return 2;
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private BaseDanmaku findReuseableCache(final BaseDanmaku baseDanmaku, final boolean z, final int i) {
            final int slopPixel = (!z ? CacheManagingDrawTask.this.mDisp.getSlopPixel() * 2 : 0) + CacheManagingDrawTask.this.mContext.cachingPolicy.reusableOffsetPixel;
            AnonymousClass4 r0 = new IDanmakus.Consumer<BaseDanmaku, BaseDanmaku>() {
                /* class com.youku.danmaku.engine.controller.CacheManagingDrawTask.CacheManager.AnonymousClass4 */
                int count = 0;
                BaseDanmaku mResult;

                public int accept(BaseDanmaku baseDanmaku) {
                    IDrawingCache<?> iDrawingCache;
                    int i = this.count;
                    this.count = i + 1;
                    if (i >= i) {
                        return 1;
                    }
                    if (!(baseDanmaku.priority == 2 || (iDrawingCache = baseDanmaku.cache) == null || iDrawingCache.get() == null)) {
                        float f = baseDanmaku.paintWidth;
                        BaseDanmaku baseDanmaku2 = baseDanmaku;
                        if (f == baseDanmaku2.paintWidth && baseDanmaku.paintHeight == baseDanmaku2.paintHeight && baseDanmaku.underlineColor == baseDanmaku2.underlineColor && baseDanmaku.borderColor == baseDanmaku2.borderColor && baseDanmaku.ykHasBorder == baseDanmaku2.ykHasBorder && baseDanmaku.textColor == baseDanmaku2.textColor && baseDanmaku.text.equals(baseDanmaku2.text) && baseDanmaku.tag == baseDanmaku.tag) {
                            this.mResult = baseDanmaku;
                            return 1;
                        } else if (z) {
                            return 0;
                        } else {
                            if (!baseDanmaku.isTimeOut()) {
                                return 1;
                            }
                            if (iDrawingCache.hasReferences()) {
                                return 0;
                            }
                            float width = ((float) iDrawingCache.width()) - baseDanmaku.paintWidth;
                            float height = ((float) iDrawingCache.height()) - baseDanmaku.paintHeight;
                            if (width >= 0.0f) {
                                int i2 = slopPixel;
                                if (width <= ((float) i2) && height >= 0.0f && height <= ((float) i2)) {
                                    this.mResult = baseDanmaku;
                                    return 1;
                                }
                            }
                        }
                    }
                    return 0;
                }

                @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
                public BaseDanmaku result() {
                    return this.mResult;
                }
            };
            this.mCaches.forEach(r0);
            return (BaseDanmaku) r0.result();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean push(BaseDanmaku baseDanmaku, int i, boolean z) {
            int i2 = 0;
            int i3 = 0;
            do {
                if (this.mRealSize + i > this.mMaxSize && this.mCaches.size() > 0) {
                    BaseDanmaku first = this.mCaches.first();
                    if (first != null && first.isTimeOut()) {
                        if (entryRemoved(false, first, baseDanmaku) <= 0) {
                            i2++;
                        }
                        if (i2 > 5) {
                            return false;
                        }
                        if (!this.mCaches.removeItem(first)) {
                            Log.d(TAG, "push remove cache failed");
                            i3++;
                        }
                    } else if (!z) {
                        return false;
                    }
                }
                this.mCaches.addItem(baseDanmaku);
                this.mRealSize += i;
                return true;
            } while (i3 <= 3);
            Log.d(TAG, "push remove cache retry more than 3");
            return false;
        }

        @Override // com.youku.danmaku.engine.danmaku.model.ICacheManager
        public void addDanmaku(BaseDanmaku baseDanmaku) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler == null) {
                return;
            }
            if (!baseDanmaku.isLive) {
                cacheHandler.obtainMessage(2, baseDanmaku).sendToTarget();
            } else if (!baseDanmaku.isTimeOut()) {
                this.mHandler.createCache(baseDanmaku);
            }
        }

        public void begin() {
            this.mEndFlag = false;
            if (this.mThread == null) {
                HandlerThread handlerThread = new HandlerThread("DMCache-BuildingThread");
                this.mThread = handlerThread;
                handlerThread.start();
            }
            if (this.mHandler == null) {
                this.mHandler = new CacheHandler(this.mThread.getLooper());
            }
            this.mHandler.begin();
        }

        public void end() {
            this.mEndFlag = true;
            synchronized (CacheManagingDrawTask.this.mDrawingNotify) {
                CacheManagingDrawTask.this.mDrawingNotify.notifyAll();
            }
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.removeCallbacksAndMessages(null);
                this.mHandler.pause();
                this.mHandler = null;
            }
            HandlerThread handlerThread = this.mThread;
            if (handlerThread != null) {
                try {
                    handlerThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.mThread.quit();
                this.mThread = null;
            }
        }

        /* access modifiers changed from: protected */
        public long entryRemoved(boolean z, BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
            if (iDrawingCache == null) {
                return 0;
            }
            long clearCache = clearCache(baseDanmaku);
            if (baseDanmaku.isTimeOut()) {
                CacheManagingDrawTask.this.mContext.getDisplayer().getCacheStuffer().releaseResource(baseDanmaku);
            }
            if (clearCache <= 0) {
                return 0;
            }
            this.mRealSize = (int) (((long) this.mRealSize) - clearCache);
            this.mCachePool.release((DrawingCache) iDrawingCache);
            return clearCache;
        }

        public long getFirstCacheTime() {
            BaseDanmaku first;
            Danmakus danmakus = this.mCaches;
            if (danmakus == null || danmakus.size() <= 0 || (first = this.mCaches.first()) == null) {
                return 0;
            }
            return first.time;
        }

        public float getPoolPercent() {
            int i = this.mMaxSize;
            if (i == 0) {
                return 0.0f;
            }
            return ((float) this.mRealSize) / ((float) i);
        }

        public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.requestCancelCaching();
                this.mHandler.obtainMessage(17, baseDanmaku).sendToTarget();
                this.mHandler.sendEmptyMessage(18);
                requestBuild(0);
            }
        }

        public void onPlayStateChanged(int i) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                cacheHandler.onPlayStateChanged(z);
            }
        }

        public void post(Runnable runnable) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.post(runnable);
            }
        }

        public void requestBuild(long j) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.requestBuildCacheAndDraw(j);
            }
        }

        public void requestClearAll() {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.removeMessages(3);
                this.mHandler.removeMessages(18);
                this.mHandler.requestCancelCaching();
                this.mHandler.removeMessages(7);
                this.mHandler.sendEmptyMessage(7);
            }
        }

        public void requestClearTimeout() {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.removeMessages(4);
                this.mHandler.sendEmptyMessage(4);
            }
        }

        public void requestClearUnused() {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.removeMessages(9);
                this.mHandler.sendEmptyMessage(9);
            }
        }

        public void resume() {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.resume();
            } else {
                begin();
            }
        }

        public void seek(long j) {
            CacheHandler cacheHandler = this.mHandler;
            if (cacheHandler != null) {
                cacheHandler.requestCancelCaching();
                this.mHandler.removeMessages(3);
                this.mHandler.obtainMessage(5, Long.valueOf(j)).sendToTarget();
            }
        }

        /* access modifiers changed from: protected */
        public int sizeOf(BaseDanmaku baseDanmaku) {
            try {
                IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
                if (iDrawingCache == null || iDrawingCache.hasReferences()) {
                    return 0;
                }
                return baseDanmaku.cache.size();
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public CacheManagingDrawTask(DanmakuTimer danmakuTimer, DanmakuContext danmakuContext, IDrawTask.TaskListener taskListener, int i) {
        super(danmakuTimer, danmakuContext, taskListener);
        NativeBitmapFactory.g();
        this.mMaxCacheSize = i;
        if (NativeBitmapFactory.f()) {
            this.mMaxCacheSize = i * 2;
        }
        if (Log.isDebug()) {
            Log.d("CacheManagingDrawTask", "maxCacheSize=" + this.mMaxCacheSize);
        }
        CacheManager cacheManager = new CacheManager(this.mMaxCacheSize, 3);
        this.mCacheManager = cacheManager;
        this.mRenderer.setCacheManager(cacheManager);
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask, com.youku.danmaku.engine.controller.DrawTask
    public void addDanmaku(BaseDanmaku baseDanmaku) {
        super.addDanmaku(baseDanmaku);
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.addDanmaku(baseDanmaku);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask, com.youku.danmaku.engine.controller.DrawTask
    public IRenderer.RenderingState draw(AbsDisplayer absDisplayer) {
        CacheManager cacheManager;
        IRenderer.RenderingState draw = super.draw(absDisplayer);
        synchronized (this.mDrawingNotify) {
            this.mDrawingNotify.notify();
        }
        if (!(draw == null || (cacheManager = this.mCacheManager) == null || draw.totalDanmakuCount - draw.lastTotalDanmakuCount >= -20)) {
            cacheManager.requestClearTimeout();
            this.mCacheManager.requestBuild(-this.mContext.mDanmakuFactory.mMaxDanmakuDuration);
        }
        return draw;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.danmaku.engine.controller.DrawTask
    public void initTimer(DanmakuTimer danmakuTimer) {
        this.mTimer = danmakuTimer;
        DanmakuTimer danmakuTimer2 = new DanmakuTimer();
        this.mCacheTimer = danmakuTimer2;
        danmakuTimer2.update(danmakuTimer.currMillisecond);
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask, com.youku.danmaku.engine.controller.DrawTask
    public void invalidateDanmaku(BaseDanmaku baseDanmaku, boolean z) {
        super.invalidateDanmaku(baseDanmaku, z);
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.invalidateDanmaku(baseDanmaku, z);
        }
    }

    @Override // com.youku.danmaku.engine.controller.DrawTask
    public boolean onDanmakuConfigChanged(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        CacheManager cacheManager;
        CacheManager cacheManager2;
        if (!super.handleOnDanmakuConfigChanged(danmakuContext, danmakuConfigTag, objArr)) {
            if (DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag)) {
                this.mDisp.resetSlopPixel(this.mContext.scaleTextSize);
                requestClear();
            } else if (danmakuConfigTag.isVisibilityRelatedTag()) {
                if (objArr != null && objArr.length > 0 && objArr[0] != null && ((!(objArr[0] instanceof Boolean) || ((Boolean) objArr[0]).booleanValue()) && (cacheManager2 = this.mCacheManager) != null)) {
                    cacheManager2.requestBuild(0);
                }
                requestClear();
            } else if (DanmakuContext.DanmakuConfigTag.TRANSPARENCY.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE.equals(danmakuConfigTag)) {
                if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag)) {
                    this.mDisp.resetSlopPixel(this.mContext.scaleTextSize);
                }
                CacheManager cacheManager3 = this.mCacheManager;
                if (cacheManager3 != null) {
                    cacheManager3.requestClearAll();
                    this.mCacheManager.requestBuild(-this.mContext.mDanmakuFactory.mMaxDanmakuDuration);
                }
            } else {
                CacheManager cacheManager4 = this.mCacheManager;
                if (cacheManager4 != null) {
                    cacheManager4.requestClearUnused();
                    this.mCacheManager.requestBuild(0);
                }
            }
        }
        if (this.mTaskListener == null || (cacheManager = this.mCacheManager) == null) {
            return true;
        }
        cacheManager.post(new Runnable() {
            /* class com.youku.danmaku.engine.controller.CacheManagingDrawTask.AnonymousClass1 */

            public void run() {
                CacheManagingDrawTask.this.mTaskListener.onDanmakuConfigChanged();
            }
        });
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.danmaku.engine.controller.DrawTask
    public void onDanmakuRemoved(BaseDanmaku baseDanmaku) {
        super.onDanmakuRemoved(baseDanmaku);
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            int i = this.mRemainingCacheCount + 1;
            this.mRemainingCacheCount = i;
            if (i > 5) {
                cacheManager.requestClearTimeout();
                this.mRemainingCacheCount = 0;
                return;
            }
            return;
        }
        IDrawingCache<?> iDrawingCache = baseDanmaku.cache;
        if (iDrawingCache != null) {
            if (iDrawingCache.hasReferences()) {
                baseDanmaku.cache.decreaseReference();
            } else {
                baseDanmaku.cache.destroy();
            }
            baseDanmaku.cache = null;
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask, com.youku.danmaku.engine.controller.DrawTask
    public void onPlayStateChanged(int i) {
        super.onPlayStateChanged(i);
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.onPlayStateChanged(i);
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask, com.youku.danmaku.engine.controller.DrawTask
    public void prepare() {
        loadDanmakus(this.mParser);
        this.mCacheManager.begin();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask, com.youku.danmaku.engine.controller.DrawTask
    public void quit() {
        super.quit();
        reset(0);
        this.mRenderer.setCacheManager(null);
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.end();
            this.mCacheManager = null;
        }
        NativeBitmapFactory.h();
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask, com.youku.danmaku.engine.controller.DrawTask
    public void removeAllDanmakus() {
        super.removeAllDanmakus();
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager != null) {
            cacheManager.requestClearAll();
        }
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask, com.youku.danmaku.engine.controller.DrawTask
    public void seek(long j, int i) {
        super.seek(j, i);
        if (this.mCacheManager == null) {
            start();
        }
        this.mCacheManager.seek(j);
    }

    @Override // com.youku.danmaku.engine.controller.IDrawTask, com.youku.danmaku.engine.controller.DrawTask
    public void start() {
        super.start();
        NativeBitmapFactory.g();
        CacheManager cacheManager = this.mCacheManager;
        if (cacheManager == null) {
            CacheManager cacheManager2 = new CacheManager(this.mMaxCacheSize, 3);
            this.mCacheManager = cacheManager2;
            cacheManager2.begin();
            this.mRenderer.setCacheManager(this.mCacheManager);
            return;
        }
        cacheManager.resume();
    }
}
