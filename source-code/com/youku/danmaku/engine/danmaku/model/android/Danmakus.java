package com.youku.danmaku.engine.danmaku.model.android;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDanmakuIterator;
import com.youku.danmaku.engine.danmaku.model.IDanmakus;
import com.youku.danmaku.engine.danmaku.model.danmaku.Danmaku;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class Danmakus implements IDanmakus {
    private BaseDanmaku endItem;
    private BaseDanmaku endSubItem;
    public Collection<BaseDanmaku> items;
    private DanmakuIterator iterator;
    private IDanmakus.BaseComparator mComparator;
    private boolean mDuplicateMergingEnabled;
    private Object mLockObject;
    private volatile AtomicInteger mSize;
    private int mSortType;
    private BaseDanmaku startItem;
    private BaseDanmaku startSubItem;
    private Danmakus subItems;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class DanmakuIterator implements IDanmakuIterator {
        private Iterator<BaseDanmaku> it;
        private Collection<BaseDanmaku> mData;
        private boolean mIteratorUsed;

        public DanmakuIterator(Collection<BaseDanmaku> collection) {
            setDatas(collection);
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakuIterator
        public synchronized boolean hasNext() {
            Iterator<BaseDanmaku> it2;
            it2 = this.it;
            return it2 != null && it2.hasNext();
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakuIterator
        public synchronized BaseDanmaku next() {
            Iterator<BaseDanmaku> it2;
            this.mIteratorUsed = true;
            it2 = this.it;
            return it2 != null ? it2.next() : null;
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakuIterator
        public synchronized void remove() {
            this.mIteratorUsed = true;
            Iterator<BaseDanmaku> it2 = this.it;
            if (it2 != null) {
                it2.remove();
                Danmakus.this.mSize.decrementAndGet();
            }
        }

        @Override // com.youku.danmaku.engine.danmaku.model.IDanmakuIterator
        public synchronized void reset() {
            if (this.mIteratorUsed || this.it == null) {
                if (this.mData == null || Danmakus.this.mSize.get() <= 0) {
                    this.it = null;
                } else {
                    this.it = this.mData.iterator();
                }
                this.mIteratorUsed = false;
            }
        }

        public synchronized void setDatas(Collection<BaseDanmaku> collection) {
            if (this.mData != collection) {
                this.mIteratorUsed = false;
                this.it = null;
            }
            this.mData = collection;
        }
    }

    public Danmakus() {
        this(0, false);
    }

    private BaseDanmaku createItem(String str) {
        return new Danmaku(str);
    }

    private void setDuplicateMergingEnabled(boolean z) {
        this.mComparator.setDuplicateMergingEnabled(z);
        this.mDuplicateMergingEnabled = z;
    }

    private Collection<BaseDanmaku> subset(long j, long j2) {
        Collection<BaseDanmaku> collection;
        if (this.mSortType == 4 || (collection = this.items) == null || collection.size() == 0) {
            return null;
        }
        if (this.subItems == null) {
            Danmakus danmakus = new Danmakus(this.mDuplicateMergingEnabled);
            this.subItems = danmakus;
            danmakus.mLockObject = this.mLockObject;
        }
        if (this.startSubItem == null) {
            this.startSubItem = createItem("start");
        }
        if (this.endSubItem == null) {
            this.endSubItem = createItem("end");
        }
        try {
            BaseDanmaku baseDanmaku = this.startSubItem;
            baseDanmaku.time = j;
            BaseDanmaku baseDanmaku2 = this.endSubItem;
            baseDanmaku2.time = j2;
            if (j > j2) {
                return new ArrayList();
            }
            return ((SortedSet) this.items).subSet(baseDanmaku, baseDanmaku2);
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public boolean addItem(BaseDanmaku baseDanmaku) {
        synchronized (this.mLockObject) {
            Collection<BaseDanmaku> collection = this.items;
            if (collection != null) {
                try {
                    if (collection.add(baseDanmaku)) {
                        this.mSize.incrementAndGet();
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public void clear() {
        synchronized (this.mLockObject) {
            Collection<BaseDanmaku> collection = this.items;
            if (collection != null) {
                collection.clear();
                this.mSize.set(0);
            }
        }
        if (this.subItems != null) {
            this.subItems = null;
            this.startItem = createItem("start");
            this.endItem = createItem("end");
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public boolean contains(BaseDanmaku baseDanmaku) {
        Collection<BaseDanmaku> collection = this.items;
        return collection != null && collection.contains(baseDanmaku);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public BaseDanmaku first() {
        Collection<BaseDanmaku> collection = this.items;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        if (this.mSortType == 4) {
            return (BaseDanmaku) ((ArrayList) this.items).get(0);
        }
        return (BaseDanmaku) ((SortedSet) this.items).first();
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public void forEach(IDanmakus.Consumer<? super BaseDanmaku, ?> consumer) {
        consumer.before();
        Iterator<BaseDanmaku> it = this.items.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BaseDanmaku next = it.next();
            if (next != null) {
                int accept = consumer.accept(next);
                if (accept == 1) {
                    break;
                } else if (accept == 2) {
                    it.remove();
                    this.mSize.decrementAndGet();
                } else if (accept == 3) {
                    it.remove();
                    this.mSize.decrementAndGet();
                    break;
                }
            }
        }
        consumer.after();
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public void forEachSync(IDanmakus.Consumer<? super BaseDanmaku, ?> consumer) {
        synchronized (this.mLockObject) {
            forEach(consumer);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public boolean isEmpty() {
        Collection<BaseDanmaku> collection = this.items;
        return collection == null || collection.isEmpty();
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public IDanmakuIterator iterator() {
        this.iterator.reset();
        return this.iterator;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public BaseDanmaku last() {
        Collection<BaseDanmaku> collection = this.items;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        if (this.mSortType != 4) {
            return (BaseDanmaku) ((SortedSet) this.items).last();
        }
        Collection<BaseDanmaku> collection2 = this.items;
        return (BaseDanmaku) ((ArrayList) collection2).get(collection2.size() - 1);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public Object obtainSynchronizer() {
        return this.mLockObject;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public boolean removeItem(BaseDanmaku baseDanmaku) {
        if (baseDanmaku == null) {
            return false;
        }
        if (baseDanmaku.isOutside()) {
            baseDanmaku.setVisibility(false);
        }
        synchronized (this.mLockObject) {
            if (!this.items.remove(baseDanmaku)) {
                return false;
            }
            this.mSize.decrementAndGet();
            return true;
        }
    }

    public void setItems(Collection<BaseDanmaku> collection) {
        if (!this.mDuplicateMergingEnabled || this.mSortType == 4) {
            this.items = collection;
        } else {
            synchronized (this.mLockObject) {
                this.items.clear();
                this.items.addAll(collection);
                collection = this.items;
            }
        }
        if (collection instanceof List) {
            this.mSortType = 4;
        }
        this.mSize.set(collection == null ? 0 : collection.size());
        DanmakuIterator danmakuIterator = this.iterator;
        if (danmakuIterator == null) {
            this.iterator = new DanmakuIterator(collection);
        } else {
            danmakuIterator.setDatas(collection);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public void setSubItemsDuplicateMergingEnabled(boolean z) {
        this.mDuplicateMergingEnabled = z;
        this.endItem = null;
        this.startItem = null;
        if (this.subItems == null) {
            Danmakus danmakus = new Danmakus(z);
            this.subItems = danmakus;
            danmakus.mLockObject = this.mLockObject;
        }
        this.subItems.setDuplicateMergingEnabled(z);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public int size() {
        return this.mSize.get();
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public IDanmakus sub(long j, long j2) {
        Collection<BaseDanmaku> collection = this.items;
        if (collection == null || collection.size() == 0) {
            return null;
        }
        if (this.subItems == null) {
            if (this.mSortType == 4) {
                Danmakus danmakus = new Danmakus(4);
                this.subItems = danmakus;
                danmakus.mLockObject = this.mLockObject;
                synchronized (this.mLockObject) {
                    this.subItems.setItems(this.items);
                }
            } else {
                Danmakus danmakus2 = new Danmakus(this.mDuplicateMergingEnabled);
                this.subItems = danmakus2;
                danmakus2.mLockObject = this.mLockObject;
            }
        }
        if (this.mSortType == 4) {
            return this.subItems;
        }
        if (this.startItem == null) {
            this.startItem = createItem("start");
        }
        if (this.endItem == null) {
            this.endItem = createItem("end");
        }
        Danmakus danmakus3 = this.subItems;
        if (danmakus3 != null && j - this.startItem.time >= 0 && j2 <= this.endItem.time) {
            return danmakus3;
        }
        this.startItem.time = j;
        this.endItem.time = j2;
        synchronized (this.mLockObject) {
            this.subItems.setItems(((SortedSet) this.items).subSet(this.startItem, this.endItem));
        }
        return this.subItems;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.IDanmakus
    public IDanmakus subnew(long j, long j2) {
        Collection<BaseDanmaku> subset = subset(j, j2);
        if (subset == null || subset.isEmpty()) {
            return null;
        }
        return new Danmakus(new ArrayList(subset));
    }

    public Danmakus(int i) {
        this(i, false);
    }

    public Danmakus(int i, boolean z) {
        IDanmakus.BaseComparator baseComparator;
        this.mSize = new AtomicInteger(0);
        this.mSortType = 0;
        this.mLockObject = new Object();
        if (i == 0) {
            baseComparator = new IDanmakus.TimeComparator(z);
        } else if (i == 1) {
            baseComparator = new IDanmakus.YPosComparator(z);
        } else if (i == 2) {
            baseComparator = new IDanmakus.YPosDescComparator(z);
        } else if (i == 5) {
            baseComparator = new IDanmakus.XRightComparator(z);
        } else {
            baseComparator = i == 6 ? new IDanmakus.TopTypeComparator(z) : null;
        }
        if (i == 4) {
            this.items = new ArrayList();
        } else {
            this.mDuplicateMergingEnabled = z;
            if (baseComparator != null) {
                baseComparator.setDuplicateMergingEnabled(z);
            }
            this.items = new ObservableTreeSet(baseComparator);
            this.mComparator = baseComparator;
        }
        this.mSortType = i;
        this.mSize.set(0);
        this.iterator = new DanmakuIterator(this.items);
    }

    public Danmakus(Collection<BaseDanmaku> collection) {
        this.mSize = new AtomicInteger(0);
        this.mSortType = 0;
        this.mLockObject = new Object();
        setItems(collection);
    }

    public Danmakus(boolean z) {
        this(0, z);
    }
}
