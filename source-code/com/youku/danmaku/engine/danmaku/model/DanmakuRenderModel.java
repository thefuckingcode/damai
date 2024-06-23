package com.youku.danmaku.engine.danmaku.model;

import android.os.Looper;
import com.youku.danmaku.engine.danmaku.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class DanmakuRenderModel {
    public boolean mClearRetainerFlag = false;
    public long mCurrentMillisecond = 0;
    public final List<BaseDanmaku> mHighLevelList = new ArrayList();
    public final List<BaseDanmaku> mNormalLevelList = new ArrayList();
    public final List<BaseDanmaku> mScreenDanmakuList = new ArrayList();
    public final List<BaseDanmaku> mTempList = new ArrayList();

    public void clear(int i) {
        if (Log.isDebug() && Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Log.d("ModelClear", "thread name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId());
            Log.d("ModelClear", android.util.Log.getStackTraceString(new Throwable()));
        }
        if (i == 0) {
            synchronized (this.mScreenDanmakuList) {
                this.mScreenDanmakuList.clear();
            }
        }
        synchronized (this.mHighLevelList) {
            this.mHighLevelList.clear();
        }
        synchronized (this.mNormalLevelList) {
            this.mNormalLevelList.clear();
        }
    }

    public boolean hasDanmakuData() {
        return !this.mNormalLevelList.isEmpty() || !this.mHighLevelList.isEmpty();
    }

    public boolean hasDanmakuToDraw() {
        return !this.mScreenDanmakuList.isEmpty() || !this.mNormalLevelList.isEmpty() || !this.mHighLevelList.isEmpty();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        r1 = r4.mHighLevelList;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r4.mHighLevelList.isEmpty() != false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        r0 = r4.mHighLevelList.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        if (r0.hasNext() == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        r3 = r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        if (r3 == null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r3.isFiltered() != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0050, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0051, code lost:
        return false;
     */
    public boolean hasDanmakusBySecond() {
        synchronized (this.mNormalLevelList) {
            if (!this.mNormalLevelList.isEmpty()) {
                for (BaseDanmaku baseDanmaku : this.mNormalLevelList) {
                    if (!(baseDanmaku == null || baseDanmaku.isFiltered())) {
                        return true;
                    }
                }
            }
        }
    }

    public boolean hasNormalHighLevelDanmaku() {
        if (this.mHighLevelList.size() <= 0) {
            return false;
        }
        for (BaseDanmaku baseDanmaku : this.mHighLevelList) {
            if (baseDanmaku != null && baseDanmaku.duration != null && baseDanmaku.getType() == 1 && baseDanmaku.priority >= 1) {
                return true;
            }
        }
        return false;
    }

    public boolean screenHasData() {
        if (this.mScreenDanmakuList.isEmpty()) {
            return false;
        }
        synchronized (this.mScreenDanmakuList) {
            for (BaseDanmaku baseDanmaku : this.mScreenDanmakuList) {
                if (!baseDanmaku.isFiltered() && baseDanmaku.isShown()) {
                    return true;
                }
            }
            return false;
        }
    }
}
