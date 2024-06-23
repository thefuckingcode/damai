package com.youku.danmaku.engine.danmaku.renderer.android;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDanmakuIterator;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;

/* compiled from: Taobao */
public class FBDanmakusRetainer extends FTDanmakusRetainer {
    private Danmakus mVisibleDanmakus = new Danmakus(2);

    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer, com.youku.danmaku.engine.danmaku.renderer.android.RLDanmakusRetainer
    public void clear() {
        this.mCancelFixingFlag = true;
        this.mVisibleDanmakus.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ae, code lost:
        r20 = null;
     */
    @Override // com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer, com.youku.danmaku.engine.danmaku.renderer.android.RLDanmakusRetainer
    public void fix(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, DanmakusRetainer.Verifier verifier) {
        boolean z;
        BaseDanmaku baseDanmaku2;
        int i;
        boolean z2;
        BaseDanmaku baseDanmaku3;
        BaseDanmaku baseDanmaku4;
        if (!baseDanmaku.isOutside()) {
            boolean isShown = baseDanmaku.isShown();
            float top = baseDanmaku.getTop();
            boolean z3 = true;
            int i2 = 0;
            boolean z4 = !baseDanmaku.isShown() && !this.mVisibleDanmakus.isEmpty();
            if (top < getDispTopEdge(baseDanmaku, iDisplayer)) {
                top = ((float) iDisplayer.getHeight()) - baseDanmaku.paintHeight;
            }
            BaseDanmaku baseDanmaku5 = null;
            if (!isShown) {
                this.mCancelFixingFlag = false;
                IDanmakuIterator it = this.mVisibleDanmakus.iterator();
                float f = top;
                BaseDanmaku baseDanmaku6 = null;
                int i3 = 0;
                while (true) {
                    if (this.mCancelFixingFlag || !it.hasNext()) {
                        i = i3;
                        baseDanmaku3 = baseDanmaku6;
                    } else {
                        i = i3 + 1;
                        baseDanmaku3 = it.next();
                        if (baseDanmaku3 == baseDanmaku) {
                            baseDanmaku3 = baseDanmaku6;
                            baseDanmaku2 = null;
                            z2 = false;
                            break;
                        }
                        if (baseDanmaku6 != null) {
                            baseDanmaku4 = baseDanmaku6;
                        } else if (baseDanmaku3.getBottom() != ((float) iDisplayer.getHeight())) {
                            break;
                        } else {
                            baseDanmaku4 = baseDanmaku3;
                        }
                        if (f < getDispTopEdge(baseDanmaku, iDisplayer)) {
                            baseDanmaku2 = null;
                            baseDanmaku3 = baseDanmaku4;
                            break;
                        }
                        baseDanmaku2 = baseDanmaku3;
                        z4 = DanmakuUtils.willHitInDuration(iDisplayer, baseDanmaku3, baseDanmaku, baseDanmaku.getDuration(), baseDanmaku.getTimer().currMillisecond);
                        if (!z4) {
                            z2 = z4;
                            baseDanmaku3 = baseDanmaku4;
                            break;
                        }
                        f = baseDanmaku2.getTop() - baseDanmaku.paintHeight;
                        i3 = i;
                        baseDanmaku6 = baseDanmaku4;
                    }
                }
                z2 = z4;
                boolean isOutVerticalEdge = isOutVerticalEdge(false, baseDanmaku, iDisplayer, f, baseDanmaku3, null);
                if (isOutVerticalEdge) {
                    i2 = i;
                    baseDanmaku5 = baseDanmaku2;
                    z = isOutVerticalEdge;
                    top = ((float) iDisplayer.getHeight()) - baseDanmaku.paintHeight;
                } else if (f >= getDispTopEdge(baseDanmaku, iDisplayer)) {
                    z = isOutVerticalEdge;
                    top = f;
                    i2 = i;
                    baseDanmaku5 = baseDanmaku2;
                    z3 = false;
                } else {
                    z = isOutVerticalEdge;
                    z3 = z2;
                    top = f;
                    i2 = i;
                    baseDanmaku5 = baseDanmaku2;
                }
            } else {
                z3 = z4;
                z = false;
            }
            if (verifier == null || !verifier.skipLayout(baseDanmaku, top, i2, z3)) {
                if (z) {
                    clear();
                }
                baseDanmaku.layout(iDisplayer, baseDanmaku.getLeft(), top);
                if (!isShown) {
                    this.mVisibleDanmakus.removeItem(baseDanmaku5);
                    this.mVisibleDanmakus.addItem(baseDanmaku);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.danmaku.engine.danmaku.renderer.android.FTDanmakusRetainer, com.youku.danmaku.engine.danmaku.renderer.android.RLDanmakusRetainer
    public boolean isOutVerticalEdge(boolean z, BaseDanmaku baseDanmaku, IDisplayer iDisplayer, float f, BaseDanmaku baseDanmaku2, BaseDanmaku baseDanmaku3) {
        return f < getDispTopEdge(baseDanmaku, iDisplayer) || !(baseDanmaku2 == null || baseDanmaku2.getBottom() == ((float) iDisplayer.getHeight()));
    }
}
