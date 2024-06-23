package com.youku.danmaku.engine.danmaku.model;

import com.youku.danmaku.engine.danmaku.model.danmaku.FTDanmaku;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;
import java.util.Comparator;

/* compiled from: Taobao */
public interface IDanmakus {
    public static final int ST_BY_DANMU_TYPE = 6;
    public static final int ST_BY_LIST = 4;
    public static final int ST_BY_TIME = 0;
    public static final int ST_BY_X_RIGHT = 5;
    public static final int ST_BY_YPOS = 1;
    public static final int ST_BY_YPOS_DESC = 2;

    /* compiled from: Taobao */
    public static class BaseComparator implements Comparator<BaseDanmaku> {
        protected boolean mDuplicateMergingEnable;

        public BaseComparator(boolean z) {
            setDuplicateMergingEnabled(z);
        }

        public void setDuplicateMergingEnabled(boolean z) {
            this.mDuplicateMergingEnable = z;
        }

        public int compare(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            if (!this.mDuplicateMergingEnable || !DanmakuUtils.isDuplicate(baseDanmaku, baseDanmaku2)) {
                return DanmakuUtils.compare(baseDanmaku, baseDanmaku2);
            }
            return 0;
        }
    }

    /* compiled from: Taobao */
    public static abstract class Consumer<Progress, Result> {
        public static final int ACTION_BREAK = 1;
        public static final int ACTION_CONTINUE = 0;
        public static final int ACTION_REMOVE = 2;
        public static final int ACTION_REMOVE_AND_BREAK = 3;

        public abstract int accept(Progress progress);

        public void after() {
        }

        public void before() {
        }

        public Result result() {
            return null;
        }
    }

    /* compiled from: Taobao */
    public static abstract class DefaultConsumer<Progress> extends Consumer<Progress, Void> {
    }

    /* compiled from: Taobao */
    public static class TimeComparator extends BaseComparator {
        public TimeComparator(boolean z) {
            super(z);
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.BaseComparator
        public int compare(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            return super.compare(baseDanmaku, baseDanmaku2);
        }
    }

    /* compiled from: Taobao */
    public static class TopTypeComparator extends BaseComparator {
        public TopTypeComparator(boolean z) {
            super(z);
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.BaseComparator
        public int compare(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            if (!this.mDuplicateMergingEnable || !DanmakuUtils.isDuplicate(baseDanmaku, baseDanmaku2)) {
                return (!(baseDanmaku2 instanceof FTDanmaku) || (baseDanmaku instanceof FTDanmaku)) ? -1 : 1;
            }
            return 0;
        }
    }

    /* compiled from: Taobao */
    public static class XRightComparator extends BaseComparator {
        public XRightComparator(boolean z) {
            super(z);
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.BaseComparator
        public int compare(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            if (!this.mDuplicateMergingEnable || !DanmakuUtils.isDuplicate(baseDanmaku, baseDanmaku2)) {
                return Float.compare(baseDanmaku.getRight(), baseDanmaku2.getRight());
            }
            return 0;
        }
    }

    /* compiled from: Taobao */
    public static class YPosComparator extends BaseComparator {
        public YPosComparator(boolean z) {
            super(z);
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.BaseComparator
        public int compare(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            if (!this.mDuplicateMergingEnable || !DanmakuUtils.isDuplicate(baseDanmaku, baseDanmaku2)) {
                return Float.compare(baseDanmaku.getTop(), baseDanmaku2.getTop());
            }
            return 0;
        }
    }

    /* compiled from: Taobao */
    public static class YPosDescComparator extends BaseComparator {
        public YPosDescComparator(boolean z) {
            super(z);
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus.BaseComparator
        public int compare(BaseDanmaku baseDanmaku, BaseDanmaku baseDanmaku2) {
            if (!this.mDuplicateMergingEnable || !DanmakuUtils.isDuplicate(baseDanmaku, baseDanmaku2)) {
                return Float.compare(baseDanmaku2.getTop(), baseDanmaku.getTop());
            }
            return 0;
        }
    }

    boolean addItem(BaseDanmaku baseDanmaku);

    void clear();

    boolean contains(BaseDanmaku baseDanmaku);

    BaseDanmaku first();

    void forEach(Consumer<? super BaseDanmaku, ?> consumer);

    void forEachSync(Consumer<? super BaseDanmaku, ?> consumer);

    boolean isEmpty();

    IDanmakuIterator iterator();

    BaseDanmaku last();

    Object obtainSynchronizer();

    boolean removeItem(BaseDanmaku baseDanmaku);

    void setSubItemsDuplicateMergingEnabled(boolean z);

    int size();

    IDanmakus sub(long j, long j2);

    IDanmakus subnew(long j, long j2);
}
