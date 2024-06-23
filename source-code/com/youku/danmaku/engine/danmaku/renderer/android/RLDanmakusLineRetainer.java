package com.youku.danmaku.engine.danmaku.renderer.android;

import android.util.SparseArray;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuEngineContext;
import com.youku.danmaku.engine.danmaku.model.IDanmakuIterator;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import com.youku.danmaku.engine.danmaku.model.style.BaseExtraStyle;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;
import com.youku.danmaku.engine.danmaku.util.Log;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import java.util.Random;

/* compiled from: Taobao */
public class RLDanmakusLineRetainer implements DanmakusRetainer.IDanmakusRetainer {
    private boolean mCancelFixingFlag = false;
    private RetainerConsumer mConsumer = new RetainerConsumer();
    private final IDanmakuSettingPlugin mDanmakuSettingPlugin;
    private final SparseArray<Float> mLineSpeedArray = new SparseArray<>();
    private float mSpeedFactor = 1.0f;
    private Random mSpeedFactorRandom = new Random();
    private float mVideoSpeed = 1.0f;
    private Danmakus mVisibleDanmakus = new Danmakus(1);

    /* compiled from: Taobao */
    protected class RetainerConsumer extends IDanmakus.Consumer<BaseDanmaku, DanmakusRetainer.RetainerState> {
        IDisplayer disp;
        BaseDanmaku drawItem = null;
        BaseDanmaku firstItem = null;
        BaseDanmaku insertItem = null;
        BaseDanmaku lastItem = null;
        int lines = 0;
        BaseDanmaku minBotttom;
        BaseDanmaku minRightRow = null;
        boolean overwriteInsert = false;
        boolean shown = false;
        boolean willHit = false;

        protected RetainerConsumer() {
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
        public void before() {
            this.lines = 0;
            this.minRightRow = null;
            this.lastItem = null;
            this.firstItem = null;
            this.insertItem = null;
            this.willHit = false;
            this.shown = false;
            this.overwriteInsert = false;
            BaseDanmaku baseDanmaku = this.drawItem;
            if (baseDanmaku != null && baseDanmaku.mAssignRow) {
                this.lines = RLDanmakusLineRetainer.this.assignRowForDanmakuInfo(baseDanmaku);
            }
        }

        public int accept(BaseDanmaku baseDanmaku) {
            if (RLDanmakusLineRetainer.this.mCancelFixingFlag) {
                return 1;
            }
            this.lines = (int) (baseDanmaku.getTop() / (RLDanmakusLineRetainer.this.getLineHeight() + RLDanmakusLineRetainer.this.getLineSpace()));
            BaseDanmaku baseDanmaku2 = this.drawItem;
            if (baseDanmaku == baseDanmaku2) {
                if (Log.isDebug()) {
                    Log.e("RLDanmakusRetainer", "drawItem already in mVisibleDanmakus, text: " + ((Object) this.drawItem.text));
                }
                this.insertItem = baseDanmaku;
                this.lastItem = null;
                this.shown = true;
                this.willHit = false;
                return 1;
            }
            if (this.firstItem == null) {
                this.firstItem = baseDanmaku;
            }
            float f = 0.0f;
            if (baseDanmaku2.mAssignRow) {
                int assignRowForDanmakuInfo = RLDanmakusLineRetainer.this.assignRowForDanmakuInfo(baseDanmaku2);
                if (assignRowForDanmakuInfo != -1) {
                    if (baseDanmaku.getTop() + baseDanmaku.paintHeight <= ((float) this.disp.getHeight())) {
                        float top = this.drawItem.paintHeight + baseDanmaku.getTop();
                        BaseExtraStyle baseExtraStyle = this.drawItem.mExtraStyle;
                        if (baseExtraStyle != null) {
                            f = (float) baseExtraStyle.getTopPadding();
                        }
                        if (top + f > ((float) this.disp.getHeight())) {
                            this.overwriteInsert = true;
                            this.lines = assignRowForDanmakuInfo;
                            this.lastItem = baseDanmaku;
                            return 1;
                        }
                    }
                    if (assignRowForDanmakuInfo == this.lines) {
                        IDisplayer iDisplayer = this.disp;
                        BaseDanmaku baseDanmaku3 = this.drawItem;
                        boolean willHitInUniformSpeed = DanmakuUtils.willHitInUniformSpeed(iDisplayer, baseDanmaku, baseDanmaku3, baseDanmaku3.getTimer().currMillisecond);
                        this.willHit = willHitInUniformSpeed;
                        if (!willHitInUniformSpeed) {
                            this.insertItem = baseDanmaku;
                            return 1;
                        }
                    }
                }
                return 0;
            }
            if (baseDanmaku.getTop() + baseDanmaku.paintHeight <= ((float) this.disp.getHeight())) {
                float top2 = this.drawItem.paintHeight + baseDanmaku.getTop();
                BaseExtraStyle baseExtraStyle2 = this.drawItem.mExtraStyle;
                if (baseExtraStyle2 != null) {
                    f = (float) baseExtraStyle2.getTopPadding();
                }
                if (top2 + f > ((float) this.disp.getHeight())) {
                    if (Log.isDebug()) {
                        Log.d("RLDanmakusRetainer", "accept overwriteInsert, top=" + baseDanmaku.getTop() + ", item.text=" + ((Object) baseDanmaku.text) + ", item.lines=" + this.lines + ", drawItem.text=" + ((Object) this.drawItem.text) + ", drawItem.height=" + this.drawItem.paintHeight);
                    }
                    this.overwriteInsert = true;
                    return 1;
                }
            } else if (Log.isDebug()) {
                Log.d("RLDanmakusRetainer", "item overwriteInsert, top=" + baseDanmaku.getTop() + ", item.text=" + ((Object) baseDanmaku.text) + ", item.lines=" + this.lines + ", drawItem.text=" + ((Object) this.drawItem.text) + ", drawItem.height=" + this.drawItem.paintHeight);
            }
            IDisplayer iDisplayer2 = this.disp;
            BaseDanmaku baseDanmaku4 = this.drawItem;
            boolean willHitInUniformSpeed2 = DanmakuUtils.willHitInUniformSpeed(iDisplayer2, baseDanmaku, baseDanmaku4, baseDanmaku4.getTimer().currMillisecond);
            this.willHit = willHitInUniformSpeed2;
            if (!willHitInUniformSpeed2) {
                this.insertItem = baseDanmaku;
                return 1;
            }
            this.lastItem = baseDanmaku;
            return 0;
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.Consumer
        public DanmakusRetainer.RetainerState result() {
            DanmakusRetainer.RetainerState retainerState = new DanmakusRetainer.RetainerState();
            retainerState.lines = this.lines;
            retainerState.firstItem = this.firstItem;
            retainerState.insertItem = this.insertItem;
            retainerState.lastItem = this.lastItem;
            retainerState.minRightRow = this.minRightRow;
            retainerState.overwriteInsert = this.overwriteInsert;
            retainerState.shown = this.shown;
            retainerState.willHit = this.willHit;
            return retainerState;
        }
    }

    RLDanmakusLineRetainer(IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        this.mDanmakuSettingPlugin = iDanmakuSettingPlugin;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int assignRowForDanmakuInfo(BaseDanmaku baseDanmaku) {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.assignRowForDanmakuInfo(baseDanmaku);
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float getLineHeight() {
        IDanmakuSettingPlugin iDanmakuSettingPlugin = this.mDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null) {
            return iDanmakuSettingPlugin.getLineHeight();
        }
        return 24.0f * DanmakuEngineContext.getDensity();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
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

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x025d  */
    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void fix(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, DanmakusRetainer.Verifier verifier) {
        boolean z;
        BaseDanmaku baseDanmaku2;
        boolean z2;
        boolean z3;
        BaseDanmaku baseDanmaku3;
        BaseDanmaku baseDanmaku4;
        BaseDanmaku baseDanmaku5;
        boolean z4;
        int i;
        boolean z5;
        BaseDanmaku baseDanmaku6;
        boolean z6;
        float f;
        boolean z7;
        int i2;
        int i3;
        boolean z8;
        boolean z9;
        int i4;
        float f2;
        BaseDanmaku baseDanmaku7;
        String str;
        if (!baseDanmaku.isOutside()) {
            float dispTopEdge = getDispTopEdge(baseDanmaku, iDisplayer);
            boolean isShown = baseDanmaku.isShown();
            int i5 = 0;
            boolean z10 = !isShown && !this.mVisibleDanmakus.isEmpty();
            if (!isShown) {
                this.mCancelFixingFlag = false;
                RetainerConsumer retainerConsumer = this.mConsumer;
                retainerConsumer.disp = iDisplayer;
                retainerConsumer.drawItem = baseDanmaku;
                this.mVisibleDanmakus.forEachSync(retainerConsumer);
                DanmakusRetainer.RetainerState result = this.mConsumer.result();
                if (result != null) {
                    int i6 = result.lines;
                    baseDanmaku5 = result.insertItem;
                    BaseDanmaku baseDanmaku8 = result.firstItem;
                    BaseDanmaku baseDanmaku9 = result.lastItem;
                    boolean z11 = result.overwriteInsert;
                    z3 = result.shown;
                    z2 = result.willHit;
                    if (Log.isDebug()) {
                        if (!this.mVisibleDanmakus.isEmpty()) {
                            str = this.mVisibleDanmakus.items.size() + "个";
                        } else {
                            str = "is empty";
                        }
                        Log.e("RLDanmakusRetainer", result.log() + "\ndrawItem: " + ((Object) baseDanmaku.text) + "\ndrawItem.getLeft()=" + baseDanmaku.getLeft() + "\ndrawItem.getTop()=" + baseDanmaku.getTop() + "\nmVisibleDanmakus count: " + str);
                    }
                    i = i6;
                    z4 = z11;
                    baseDanmaku3 = baseDanmaku9;
                    baseDanmaku4 = baseDanmaku8;
                } else {
                    z3 = isShown;
                    z2 = z10;
                    i = 0;
                    z4 = false;
                    baseDanmaku5 = null;
                    baseDanmaku4 = null;
                    baseDanmaku3 = null;
                }
                if (!baseDanmaku.mAssignRow) {
                    z7 = false;
                    if (baseDanmaku5 != null) {
                        if (Log.isDebug()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("\ninsertItem: ");
                            sb.append((Object) baseDanmaku5.text);
                            sb.append("\ninsertItem.getLeft()=");
                            sb.append(baseDanmaku5.getLeft());
                            sb.append("\ninsertItem.getTop()=");
                            sb.append(baseDanmaku5.getTop());
                            sb.append("\nisShown=");
                            sb.append(baseDanmaku5.isShown());
                            sb.append("\ncurrentTime=");
                            baseDanmaku7 = baseDanmaku4;
                            sb.append(baseDanmaku5.getTimer().currMillisecond);
                            sb.append("\ntime=");
                            sb.append(baseDanmaku5.time);
                            Log.e("RLDanmakusRetainer", sb.toString());
                        } else {
                            baseDanmaku7 = baseDanmaku4;
                        }
                        if (baseDanmaku3 != null) {
                            f2 = baseDanmaku3.getBottom();
                        } else {
                            f2 = baseDanmaku5.getTop();
                        }
                        i2 = i;
                        if (baseDanmaku5 != baseDanmaku) {
                            baseDanmaku6 = baseDanmaku5;
                            f = f2;
                            baseDanmaku4 = baseDanmaku7;
                            z8 = true;
                            i3 = -1;
                        } else {
                            baseDanmaku4 = baseDanmaku7;
                            z8 = true;
                            i3 = -1;
                            baseDanmaku6 = null;
                            z5 = z2;
                            z6 = z3;
                            f = f2;
                            if (i2 == i3) {
                            }
                            if (baseDanmaku.isOutside()) {
                            }
                        }
                    } else if (!z4 || baseDanmaku3 == null) {
                        if (baseDanmaku3 == null || baseDanmaku4 == null) {
                            baseDanmaku4 = baseDanmaku4;
                        } else {
                            baseDanmaku4 = baseDanmaku4;
                            if (baseDanmaku4 == baseDanmaku3 && baseDanmaku4.getTop() > 0.0f) {
                                f2 = getDispTopEdge(baseDanmaku, iDisplayer);
                                z6 = z3;
                                z8 = true;
                                i3 = -1;
                                i2 = 0;
                                baseDanmaku6 = null;
                                z5 = false;
                                f = f2;
                                if (i2 == i3) {
                                }
                                if (baseDanmaku.isOutside()) {
                                }
                            }
                        }
                        if (baseDanmaku3 != null) {
                            f2 = baseDanmaku3.getBottom();
                            i2 = i + 1;
                            z6 = z3;
                            z8 = true;
                            i3 = -1;
                            baseDanmaku6 = null;
                            z5 = false;
                            f = f2;
                            if (i2 == i3) {
                            }
                            if (baseDanmaku.isOutside()) {
                            }
                        } else if (baseDanmaku4 != null) {
                            i2 = i;
                            f = baseDanmaku4.getTop();
                            baseDanmaku6 = baseDanmaku4;
                            z5 = z2;
                            z8 = true;
                            i3 = -1;
                            z6 = false;
                            if (i2 == i3) {
                            }
                            if (baseDanmaku.isOutside()) {
                            }
                        } else {
                            f2 = getDispTopEdge(baseDanmaku, iDisplayer);
                            i2 = i;
                            z5 = z2;
                            z8 = true;
                            i3 = -1;
                        }
                    } else {
                        i2 = i;
                        f = baseDanmaku3.getTop();
                        baseDanmaku4 = baseDanmaku4;
                        z8 = false;
                        i3 = -1;
                        baseDanmaku6 = null;
                    }
                    z5 = z2;
                    z6 = false;
                    if (i2 == i3) {
                    }
                    if (baseDanmaku.isOutside()) {
                    }
                } else if (baseDanmaku5 != null) {
                    if (baseDanmaku3 != null) {
                        f2 = baseDanmaku3.getTop();
                    } else {
                        f2 = baseDanmaku5.getTop();
                    }
                    i2 = i;
                    if (baseDanmaku5 != baseDanmaku) {
                        baseDanmaku6 = baseDanmaku5;
                        f = f2;
                        z5 = z2;
                        z8 = false;
                        i3 = -1;
                        z7 = false;
                        z6 = false;
                        if (i2 == i3) {
                            boolean isOutVerticalEdge = z8 ? isOutVerticalEdge(z4, baseDanmaku, iDisplayer, f, baseDanmaku4, baseDanmaku3) : false;
                            if (isOutVerticalEdge) {
                                f = getDispTopEdge(baseDanmaku, iDisplayer);
                                i4 = 1;
                                z9 = true;
                            } else {
                                i4 = i2;
                                z9 = z5;
                            }
                            if (f != getDispTopEdge(baseDanmaku, iDisplayer)) {
                                z7 = z6;
                            }
                            if (!z7 && !isOutVerticalEdge && !z9) {
                                Float f3 = this.mLineSpeedArray.get(i4);
                                if (f3 != null) {
                                    ((R2LDanmaku) baseDanmaku).setStepAndCalculateDuration(f3.floatValue());
                                } else {
                                    float speed = getSpeed();
                                    ((R2LDanmaku) baseDanmaku).setStepAndCalculateDuration(speed);
                                    this.mLineSpeedArray.put(i4, Float.valueOf(speed));
                                }
                            }
                            z10 = z9;
                            i2 = i4;
                            isShown = z7;
                            z7 = isOutVerticalEdge;
                            dispTopEdge = f;
                        } else {
                            dispTopEdge = f;
                            isShown = z6;
                            z10 = z5;
                        }
                        if (baseDanmaku.isOutside()) {
                            if (Log.isDebug()) {
                                Log.e("RLDanmakusRetainer", "\nend show\nisOutOfVerticalEdge: " + z7 + "\nlines: " + i2 + "\ntext: " + ((Object) baseDanmaku.text) + "\nshown: " + isShown + "\nwillHit：" + z10 + "\ntopPos：" + dispTopEdge + "\nfactor: " + this.mSpeedFactor + "\nmLineSpeedArray: " + this.mLineSpeedArray.toString());
                            }
                            z = z7;
                            baseDanmaku2 = baseDanmaku6;
                            i5 = i2;
                        } else if (Log.isDebug()) {
                            Log.e("RLDanmakusRetainer", "\nisOutside\ndrawItem.time=" + baseDanmaku.time + "\ndrawItem.duration=" + baseDanmaku.getDuration());
                            return;
                        } else {
                            return;
                        }
                    } else {
                        z5 = z2;
                        z8 = true;
                        i3 = -1;
                        z7 = false;
                    }
                } else {
                    int assignRowForDanmakuInfo = assignRowForDanmakuInfo(baseDanmaku);
                    if (assignRowForDanmakuInfo == -1) {
                        baseDanmaku.isFilter = true;
                        baseDanmaku.setVisibility(false);
                        return;
                    } else if (!z4 || baseDanmaku3 == null) {
                        z7 = false;
                        i2 = assignRowForDanmakuInfo;
                        f = (getLineHeight() + getLineSpace()) * ((float) assignRowForDanmakuInfo);
                        z5 = z2;
                        z8 = true;
                        i3 = -1;
                        z6 = false;
                        baseDanmaku6 = null;
                        if (i2 == i3) {
                        }
                        if (baseDanmaku.isOutside()) {
                        }
                    } else {
                        baseDanmaku.isFilter = true;
                        baseDanmaku.setVisibility(false);
                        return;
                    }
                }
                baseDanmaku6 = null;
                z6 = z3;
                f = f2;
                if (i2 == i3) {
                }
                if (baseDanmaku.isOutside()) {
                }
            } else {
                baseDanmaku2 = null;
                z = false;
            }
            if (verifier != null && verifier.skipLayout(baseDanmaku, dispTopEdge, i5, z10)) {
                return;
            }
            if (!z) {
                baseDanmaku.layout(iDisplayer, baseDanmaku.getLeft(), dispTopEdge);
                if (!isShown) {
                    baseDanmaku.setDanmakuLine(i5);
                    this.mVisibleDanmakus.removeItem(baseDanmaku2);
                    this.mVisibleDanmakus.addItem(baseDanmaku);
                }
            } else if (Log.isDebug()) {
                Log.d("RLDanmakusRetainer", "text=" + ((Object) baseDanmaku.text));
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
        IDanmakuIterator it = this.mVisibleDanmakus.iterator();
        while (it.hasNext()) {
            BaseDanmaku next = it.next();
            if (next != null) {
                Log.d("RLDanmakusRetainer", "showScreen, showVisibleDanmakuLog: line=" + next.getDanmakuLine() + ", text=" + ((Object) next.text) + ", top=" + next.getTop() + ", left=" + next.getLeft());
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
