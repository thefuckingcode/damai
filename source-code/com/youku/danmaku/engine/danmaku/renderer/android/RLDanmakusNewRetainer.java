package com.youku.danmaku.engine.danmaku.renderer.android;

import android.util.SparseArray;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuEngineContext;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import java.util.Arrays;
import java.util.Random;

/* compiled from: Taobao */
public class RLDanmakusNewRetainer implements DanmakusRetainer.IDanmakusRetainer {
    private boolean mCancelFixingFlag = false;
    private IDanmakuSettingPlugin mDanmakuSettingPlugin;
    private final SparseArray<Float> mLineSpeedArray = new SparseArray<>();
    private float mSpeedFactor = 1.0f;
    private Random mSpeedFactorRandom = new Random();
    private float mVideoSpeed = 1.0f;
    private final SparseArray<BaseDanmaku> mVisibleDanmakus = new SparseArray<>();

    RLDanmakusNewRetainer(IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        this.mDanmakuSettingPlugin = iDanmakuSettingPlugin;
    }

    private int assignRowForDanmakuInfo(BaseDanmaku baseDanmaku) {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.assignRowForDanmakuInfo(baseDanmaku);
        }
        return -1;
    }

    private boolean checkFix(IDisplayer iDisplayer, BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2, DanmakusRetainer.FixResult fixResult, int i, float f) {
        if (baseDanmaku == null) {
            setResult(fixResult, i, f * ((float) i));
            return true;
        }
        boolean willHitInUniformSpeed = DanmakuUtils.willHitInUniformSpeed(iDisplayer, baseDanmaku, baseDanmaku2, baseDanmaku2.getTimer().currMillisecond);
        fixResult.mWillHit = willHitInUniformSpeed;
        if (willHitInUniformSpeed) {
            return false;
        }
        setResult(fixResult, i, f * ((float) i));
        return true;
    }

    private DanmakusRetainer.FixResult fixDrawItem(BaseDanmaku baseDanmaku, IDisplayer iDisplayer) {
        String str;
        DanmakusRetainer.FixResult fixResult = new DanmakusRetainer.FixResult();
        if (this.mCancelFixingFlag) {
            return fixResult;
        }
        float lineHeight = getLineHeight() + getLineSpace();
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        int lineCount = iDanmakuSettingPlugin != null ? iDanmakuSettingPlugin.getLineCount() : getLineCount();
        boolean z = false;
        int i = 0;
        while (true) {
            String str2 = "RLDanmakusRetainer";
            boolean z2 = true;
            if (i >= this.mVisibleDanmakus.size()) {
                BaseDanmaku baseDanmaku2 = null;
                if (baseDanmaku.mAssignRow) {
                    int assignRowForDanmakuInfo = assignRowForDanmakuInfo(baseDanmaku);
                    if (assignRowForDanmakuInfo < 0 || assignRowForDanmakuInfo >= lineCount) {
                        baseDanmaku.isFilter = true;
                    } else {
                        BaseDanmaku baseDanmaku3 = this.mVisibleDanmakus.get(assignRowForDanmakuInfo, null);
                        if (baseDanmaku3 == baseDanmaku) {
                            fixResult.mLine = assignRowForDanmakuInfo;
                            fixResult.mIsOutOfVerticalEdge = false;
                            fixResult.mTopPos = ((float) assignRowForDanmakuInfo) * lineHeight;
                            fixResult.mWillHit = false;
                            fixResult.shown = true;
                            return fixResult;
                        }
                        z = checkFix(iDisplayer, baseDanmaku3, baseDanmaku, fixResult, assignRowForDanmakuInfo, lineHeight);
                    }
                } else {
                    if (Log.isDebug()) {
                        Log.d(str2, "fixDrawItem begin, maxLine=" + lineCount);
                    }
                    boolean z3 = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= lineCount) {
                            break;
                        }
                        BaseDanmaku baseDanmaku4 = this.mVisibleDanmakus.get(i2, baseDanmaku2);
                        if (baseDanmaku4 == baseDanmaku) {
                            fixResult.mLine = i2;
                            fixResult.mIsOutOfVerticalEdge = z;
                            fixResult.mTopPos = ((float) i2) * lineHeight;
                            fixResult.mWillHit = z;
                            fixResult.shown = z2;
                            break;
                        }
                        z3 = checkFix(iDisplayer, baseDanmaku4, baseDanmaku, fixResult, i2, lineHeight);
                        if (!z3) {
                            i2++;
                            str2 = str2;
                            baseDanmaku2 = null;
                            z2 = true;
                            z = false;
                        } else if (Log.isDebug()) {
                            if (baseDanmaku4 != null) {
                                float[] rectAtTime = baseDanmaku4.getRectAtTime(iDisplayer, baseDanmaku.getTimer().currMillisecond);
                                str = ", reference text=" + ((Object) baseDanmaku4.text) + ", reference top=" + baseDanmaku4.getTop() + ", reference left=" + baseDanmaku4.getLeft() + ", rectArr=" + Arrays.toString(rectAtTime);
                            } else {
                                str = ", reference=null";
                            }
                            Log.d(str2, "fixDrawItem, maxLine=" + lineCount + ", line=" + i2 + ", canDraw=true" + ", text=" + ((Object) baseDanmaku.text) + ", top=" + baseDanmaku.getTop() + ", left=" + baseDanmaku.getLeft() + ", danmaku.show=" + baseDanmaku.isShown() + ", fixResult.show=" + fixResult.shown + str);
                        }
                    }
                    z = z3;
                }
                if (z) {
                    Float f = this.mLineSpeedArray.get(fixResult.mLine, null);
                    if (f != null) {
                        ((R2LDanmaku) baseDanmaku).setStepAndCalculateDuration(f.floatValue());
                    } else {
                        float speed = getSpeed();
                        ((R2LDanmaku) baseDanmaku).setStepAndCalculateDuration(speed);
                        this.mLineSpeedArray.put(fixResult.mLine, Float.valueOf(speed));
                    }
                }
                return fixResult;
            } else if (baseDanmaku == this.mVisibleDanmakus.get(i)) {
                fixResult.mLine = i;
                fixResult.mTopPos = ((float) i) * lineHeight;
                if (i < lineCount) {
                    fixResult.mWillHit = false;
                    fixResult.shown = true;
                    fixResult.mIsOutOfVerticalEdge = false;
                } else {
                    fixResult.mWillHit = true;
                    fixResult.shown = false;
                    fixResult.mIsOutOfVerticalEdge = true;
                }
                if (Log.isDebug()) {
                    Log.d(str2, "mVisibleDanmakus has danmaku, maxLine=" + lineCount + ", line=" + i + ", text=" + ((Object) baseDanmaku.text) + ", top=" + fixResult.mTopPos + ", drawItem.top=" + baseDanmaku.getTop() + ", WillHit=" + fixResult.mWillHit + ", shown=" + fixResult.shown + ", IsOutOfVerticalEdge=" + fixResult.mIsOutOfVerticalEdge);
                }
                return fixResult;
            } else {
                i++;
            }
        }
    }

    private int getLineCount() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getLineCount();
        }
        return 2;
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

    private float getSpeed() {
        return ((getUniformSpeed() * (((float) ((this.mSpeedFactorRandom.nextInt(115) % 31) + 85)) / 100.0f)) / this.mSpeedFactor) * this.mVideoSpeed;
    }

    private float getUniformSpeed() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getUniformSpeed();
        }
        return 0.275f;
    }

    private void setResult(DanmakusRetainer.FixResult fixResult, int i, float f) {
        fixResult.mLine = i;
        fixResult.mWillHit = false;
        fixResult.mIsOutOfVerticalEdge = false;
        fixResult.mTopPos = f;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059 A[LOOP:0: B:16:0x0059->B:25:0x009f, LOOP_START, PHI: r3 
      PHI: (r3v1 int) = (r3v0 int), (r3v2 int) binds: [B:15:0x0057, B:25:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public void changeSpeed(float f, float f2) {
        boolean z;
        Float f3;
        float f4 = this.mVideoSpeed;
        float f5 = this.mSpeedFactor;
        boolean z2 = true;
        if (f != f4) {
            this.mVideoSpeed = f;
        } else if (f2 != f5) {
            this.mSpeedFactor = f2;
            z2 = false;
            z = true;
            if (!z2 || z) {
                if (Log.isDebug()) {
                    Log.d("changeSpeed", "videoSpeed=" + f + ", speedFactor=" + f2 + ", lastVideoSpeed=" + f4 + ", lastSpeedFactor=" + f5);
                }
                if (this.mLineSpeedArray.size() <= 0) {
                    for (int i = 0; i < this.mLineSpeedArray.size(); i++) {
                        int keyAt = this.mLineSpeedArray.keyAt(i);
                        Float f6 = this.mLineSpeedArray.get(keyAt);
                        if (f6 != null) {
                            if (z2) {
                                f3 = Float.valueOf((f6.floatValue() / f4) * this.mVideoSpeed);
                            } else {
                                f3 = Float.valueOf((f6.floatValue() * f5) / f2);
                            }
                            this.mLineSpeedArray.put(keyAt, f3);
                        } else {
                            this.mLineSpeedArray.put(keyAt, Float.valueOf(getSpeed()));
                        }
                    }
                    return;
                }
                return;
            }
            return;
        } else {
            z2 = false;
        }
        z = false;
        if (!z2) {
        }
        if (Log.isDebug()) {
        }
        if (this.mLineSpeedArray.size() <= 0) {
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void clear() {
        this.mCancelFixingFlag = true;
        this.mVisibleDanmakus.clear();
    }

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void fix(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, DanmakusRetainer.Verifier verifier) {
        boolean z;
        int i;
        int i2;
        if (!baseDanmaku.isOutside()) {
            float dispTopEdge = getDispTopEdge(baseDanmaku, iDisplayer);
            boolean isShown = baseDanmaku.isShown();
            int i3 = 0;
            boolean z2 = !isShown && this.mVisibleDanmakus.size() > 0;
            if (!isShown) {
                this.mCancelFixingFlag = false;
                DanmakusRetainer.FixResult fixDrawItem = fixDrawItem(baseDanmaku, iDisplayer);
                if (fixDrawItem != null) {
                    int i4 = fixDrawItem.mLine;
                    boolean z3 = fixDrawItem.mIsOutOfVerticalEdge;
                    float f = fixDrawItem.mTopPos;
                    boolean z4 = fixDrawItem.mWillHit;
                    boolean z5 = fixDrawItem.shown;
                    i3 = z3 ? 1 : 0;
                    dispTopEdge = f;
                    isShown = z5;
                    z = z4;
                    i2 = i4;
                } else {
                    z = z2;
                    i2 = 0;
                }
                if (!baseDanmaku.isOutside()) {
                    i = i3;
                    i3 = i2;
                } else if (Log.isDebug()) {
                    Log.e("RLDanmakusRetainer", "\nisOutside\ndrawItem.time=" + baseDanmaku.time + "\ndrawItem.duration=" + baseDanmaku.getDuration());
                    return;
                } else {
                    return;
                }
            } else {
                z = z2;
                i = 0;
            }
            if (verifier != null && verifier.skipLayout(baseDanmaku, dispTopEdge, i3, z)) {
                return;
            }
            if (i == 0) {
                baseDanmaku.layout(iDisplayer, baseDanmaku.getLeft(), dispTopEdge);
                if (!isShown) {
                    if (Log.isDebug()) {
                        Log.e("RLDanmakusRetainer", "end show\ntext: " + ((Object) baseDanmaku.text) + "\nlines: " + i3 + "\nwillHit：" + z + "\ntop：" + baseDanmaku.getTop() + "\nleft: " + baseDanmaku.getLeft() + "\ntopPos：" + dispTopEdge + "\nmLineSpeedArray: " + this.mLineSpeedArray.toString());
                    }
                    baseDanmaku.setDanmakuLine(i3);
                    this.mVisibleDanmakus.put(i3, baseDanmaku);
                }
            } else if (Log.isDebug()) {
                Log.d("RLDanmakusRetainer", "isOutOfVerticalEdge: text=" + ((Object) baseDanmaku.text));
            }
        }
    }

    /* access modifiers changed from: protected */
    public float getDispTopEdge(BaseDanmaku baseDanmaku, IDisplayer iDisplayer) {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public boolean isOutVerticalEdge(boolean z, BaseDanmaku baseDanmaku, IDisplayer iDisplayer, float f, BaseDanmaku baseDanmaku2, BaseDanmaku baseDanmaku3) {
        return f < getDispTopEdge(baseDanmaku, iDisplayer) || f + baseDanmaku.paintHeight > ((float) iDisplayer.getHeight());
    }

    /* access modifiers changed from: package-private */
    public void showVisibleDanmakuLog() {
        for (int i = 0; i < this.mVisibleDanmakus.size(); i++) {
            BaseDanmaku baseDanmaku = this.mVisibleDanmakus.get(i);
            if (baseDanmaku != null) {
                Log.d("RLDanmakusRetainer", "showScreen, showVisibleDanmakuLog: line=" + i + ", line=" + baseDanmaku.getDanmakuLine() + ", text=" + ((Object) baseDanmaku.text) + ", top=" + baseDanmaku.getTop() + ", left=" + baseDanmaku.getLeft());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void changeSpeed(R2LDanmaku r2LDanmaku) {
        int top = (int) (r2LDanmaku.getTop() / (getLineHeight() + getLineSpace()));
        Float f = this.mLineSpeedArray.get(top);
        float floatValue = f != null ? f.floatValue() : 0.0f;
        if (floatValue <= 0.0f) {
            floatValue = getSpeed();
            this.mLineSpeedArray.put(top, Float.valueOf(floatValue));
        }
        r2LDanmaku.setSpeedAndChangeDuration(floatValue);
    }
}
