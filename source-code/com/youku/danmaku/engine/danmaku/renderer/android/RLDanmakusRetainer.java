package com.youku.danmaku.engine.danmaku.renderer.android;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;
import com.youku.danmaku.engine.danmaku.util.Log;

/* compiled from: Taobao */
public class RLDanmakusRetainer implements DanmakusRetainer.IDanmakusRetainer {
    boolean mCancelFixingFlag = false;
    private RetainerConsumer mConsumer = new RetainerConsumer();
    private Danmakus mVisibleDanmakus = new Danmakus(1);

    /* compiled from: Taobao */
    protected class RetainerConsumer extends IDanmakus.Consumer<BaseDanmaku, DanmakusRetainer.RetainerState> {
        IDisplayer disp;
        BaseDanmaku drawItem = null;
        BaseDanmaku firstItem = null;
        BaseDanmaku insertItem = null;
        BaseDanmaku lastItem = null;
        int lines = 0;
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
        }

        public int accept(BaseDanmaku baseDanmaku) {
            if (RLDanmakusRetainer.this.mCancelFixingFlag) {
                return 1;
            }
            this.lines++;
            BaseDanmaku baseDanmaku2 = this.drawItem;
            if (baseDanmaku == baseDanmaku2) {
                this.insertItem = baseDanmaku;
                this.lastItem = null;
                this.shown = true;
                this.willHit = false;
                return 1;
            }
            if (this.firstItem == null) {
                this.firstItem = baseDanmaku;
            }
            if (baseDanmaku2.paintHeight + baseDanmaku.getTop() > ((float) this.disp.getHeight())) {
                this.overwriteInsert = true;
                return 1;
            }
            BaseDanmaku baseDanmaku3 = this.minRightRow;
            if (baseDanmaku3 == null) {
                this.minRightRow = baseDanmaku;
            } else if (baseDanmaku3.getRight() >= baseDanmaku.getRight()) {
                this.minRightRow = baseDanmaku;
            }
            IDisplayer iDisplayer = this.disp;
            BaseDanmaku baseDanmaku4 = this.drawItem;
            boolean willHitInDuration = DanmakuUtils.willHitInDuration(iDisplayer, baseDanmaku, baseDanmaku4, baseDanmaku4.getDuration(), this.drawItem.getTimer().currMillisecond);
            this.willHit = willHitInDuration;
            if (!willHitInDuration) {
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

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void clear() {
        this.mCancelFixingFlag = true;
        this.mVisibleDanmakus.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00df  */
    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
    public void fix(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, DanmakusRetainer.Verifier verifier) {
        boolean z;
        boolean z2;
        int i;
        BaseDanmaku baseDanmaku2;
        BaseDanmaku baseDanmaku3;
        BaseDanmaku baseDanmaku4;
        BaseDanmaku baseDanmaku5;
        boolean z3;
        boolean z4;
        float f;
        BaseDanmaku baseDanmaku6;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean isOutVerticalEdge;
        float dispTopEdge;
        if (!baseDanmaku.isOutside()) {
            float dispTopEdge2 = getDispTopEdge(baseDanmaku, iDisplayer);
            boolean isShown = baseDanmaku.isShown();
            int i2 = 0;
            boolean z8 = !isShown && !this.mVisibleDanmakus.isEmpty();
            BaseDanmaku baseDanmaku7 = null;
            if (!isShown) {
                this.mCancelFixingFlag = false;
                RetainerConsumer retainerConsumer = this.mConsumer;
                retainerConsumer.disp = iDisplayer;
                retainerConsumer.drawItem = baseDanmaku;
                this.mVisibleDanmakus.forEachSync(retainerConsumer);
                DanmakusRetainer.RetainerState result = this.mConsumer.result();
                if (result != null) {
                    int i3 = result.lines;
                    baseDanmaku5 = result.insertItem;
                    BaseDanmaku baseDanmaku8 = result.firstItem;
                    BaseDanmaku baseDanmaku9 = result.lastItem;
                    BaseDanmaku baseDanmaku10 = result.minRightRow;
                    boolean z9 = result.overwriteInsert;
                    z2 = result.shown;
                    z4 = result.willHit;
                    i = i3;
                    z3 = z9;
                    baseDanmaku3 = baseDanmaku8;
                    baseDanmaku4 = baseDanmaku10;
                    baseDanmaku2 = baseDanmaku9;
                } else {
                    z2 = isShown;
                    z4 = z8;
                    baseDanmaku5 = null;
                    baseDanmaku4 = null;
                    baseDanmaku3 = null;
                    baseDanmaku2 = null;
                    z3 = false;
                    i = 0;
                }
                if (baseDanmaku5 != null) {
                    if (baseDanmaku2 != null) {
                        dispTopEdge = baseDanmaku2.getBottom();
                    } else {
                        dispTopEdge = baseDanmaku5.getTop();
                    }
                    if (baseDanmaku5 != baseDanmaku) {
                        z6 = z4;
                        baseDanmaku6 = baseDanmaku5;
                        f = dispTopEdge;
                        z7 = true;
                        z5 = false;
                        isOutVerticalEdge = z7 ? isOutVerticalEdge(z3, baseDanmaku, iDisplayer, f, baseDanmaku3, baseDanmaku2) : false;
                        if (isOutVerticalEdge) {
                            f = getDispTopEdge(baseDanmaku, iDisplayer);
                            z8 = true;
                            i = 1;
                        } else {
                            if (baseDanmaku6 != null) {
                                i--;
                            }
                            z8 = z6;
                        }
                        z = isOutVerticalEdge;
                        i2 = i;
                        if (f == getDispTopEdge(baseDanmaku, iDisplayer)) {
                            baseDanmaku7 = baseDanmaku6;
                            dispTopEdge2 = f;
                            isShown = false;
                        } else {
                            isShown = z5;
                            baseDanmaku7 = baseDanmaku6;
                            dispTopEdge2 = f;
                        }
                    }
                } else if (z3 && baseDanmaku4 != null) {
                    z6 = z4;
                    baseDanmaku6 = null;
                    f = baseDanmaku4.getTop();
                    z7 = false;
                    z5 = false;
                    if (z7) {
                    }
                    if (isOutVerticalEdge) {
                    }
                    z = isOutVerticalEdge;
                    i2 = i;
                    if (f == getDispTopEdge(baseDanmaku, iDisplayer)) {
                    }
                } else if (baseDanmaku2 != null) {
                    baseDanmaku6 = null;
                    f = baseDanmaku2.getBottom();
                    z5 = z2;
                    z7 = true;
                    z6 = false;
                    if (z7) {
                    }
                    if (isOutVerticalEdge) {
                    }
                    z = isOutVerticalEdge;
                    i2 = i;
                    if (f == getDispTopEdge(baseDanmaku, iDisplayer)) {
                    }
                } else if (baseDanmaku3 != null) {
                    z6 = z4;
                    f = baseDanmaku3.getTop();
                    baseDanmaku6 = baseDanmaku3;
                    z7 = true;
                    z5 = false;
                    if (z7) {
                    }
                    if (isOutVerticalEdge) {
                    }
                    z = isOutVerticalEdge;
                    i2 = i;
                    if (f == getDispTopEdge(baseDanmaku, iDisplayer)) {
                    }
                } else {
                    dispTopEdge = getDispTopEdge(baseDanmaku, iDisplayer);
                }
                baseDanmaku6 = null;
                f = dispTopEdge;
                z5 = z2;
                z6 = z4;
                z7 = true;
                if (z7) {
                }
                if (isOutVerticalEdge) {
                }
                z = isOutVerticalEdge;
                i2 = i;
                if (f == getDispTopEdge(baseDanmaku, iDisplayer)) {
                }
            } else {
                z = false;
            }
            if (verifier == null || !verifier.skipLayout(baseDanmaku, dispTopEdge2, i2, z8)) {
                if (z) {
                    if (Log.isDebug()) {
                        Log.d("DrawTask", "text=" + ((Object) baseDanmaku.text));
                    }
                    if (baseDanmaku.priority < 1) {
                        clear();
                    }
                }
                baseDanmaku.layout(iDisplayer, baseDanmaku.getLeft(), dispTopEdge2);
                if (isShown) {
                    return;
                }
                if (!z || baseDanmaku.priority <= 0) {
                    this.mVisibleDanmakus.removeItem(baseDanmaku7);
                    this.mVisibleDanmakus.addItem(baseDanmaku);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public float getDispTopEdge(BaseDanmaku baseDanmaku, IDisplayer iDisplayer) {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public boolean isOutVerticalEdge(boolean z, BaseDanmaku baseDanmaku, IDisplayer iDisplayer, float f, BaseDanmaku baseDanmaku2, BaseDanmaku baseDanmaku3) {
        return f < getDispTopEdge(baseDanmaku, iDisplayer) || (baseDanmaku2 != null && baseDanmaku2.getTop() > getDispTopEdge(baseDanmaku, iDisplayer)) || f + baseDanmaku.paintHeight > ((float) iDisplayer.getHeight());
    }
}
