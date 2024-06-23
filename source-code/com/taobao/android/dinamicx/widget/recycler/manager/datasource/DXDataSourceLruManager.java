package com.taobao.android.dinamicx.widget.recycler.manager.datasource;

import androidx.collection.LruCache;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class DXDataSourceLruManager implements IDXDataSourceManager {
    private DXRecyclerLruCache a;
    private LruKeepPredicate b;
    private List<Object> c;
    private final int d;

    /* compiled from: Taobao */
    public static class DXRecyclerLruCache extends LruCache<Integer, DXWidgetNode> {
        protected final Map<Integer, DXWidgetNode> a = new HashMap();
        protected final LruKeepPredicate b;

        public DXRecyclerLruCache(int i, LruKeepPredicate lruKeepPredicate) {
            super(i);
            this.b = lruKeepPredicate;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void entryRemoved(boolean z, Integer num, DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2) {
            if (z) {
                b(num, dXWidgetNode);
            }
        }

        /* access modifiers changed from: protected */
        public void b(Integer num, DXWidgetNode dXWidgetNode) {
            LruKeepPredicate lruKeepPredicate;
            int i;
            if (dXWidgetNode != null && (lruKeepPredicate = this.b) != null && lruKeepPredicate.shouldKeepWidget(num, dXWidgetNode)) {
                Iterator it = snapshot().entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    i = ((Integer) entry.getKey()).intValue();
                    if (!this.b.shouldKeepWidget(Integer.valueOf(i), (DXWidgetNode) entry.getValue())) {
                        break;
                    }
                }
                if (i != -1) {
                    remove(Integer.valueOf(i));
                    put(num, dXWidgetNode);
                    return;
                }
                this.a.put(num, dXWidgetNode);
            }
        }

        public DXWidgetNode c(Integer num, DXWidgetNode dXWidgetNode) {
            DXWidgetNode dXWidgetNode2 = (DXWidgetNode) put(num, dXWidgetNode);
            if (!this.a.isEmpty()) {
                resize(maxSize() + this.a.size());
                for (Map.Entry<Integer, DXWidgetNode> entry : this.a.entrySet()) {
                    put(entry.getKey(), entry.getValue());
                }
                this.a.clear();
            }
            return dXWidgetNode2;
        }
    }

    /* compiled from: Taobao */
    public interface LruKeepPredicate {
        boolean shouldKeepWidget(Integer num, DXWidgetNode dXWidgetNode);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements LruKeepPredicate {
        a(DXDataSourceLruManager dXDataSourceLruManager) {
        }

        @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.DXDataSourceLruManager.LruKeepPredicate
        public boolean shouldKeepWidget(Integer num, DXWidgetNode dXWidgetNode) {
            return (dXWidgetNode instanceof DXTemplateWidgetNode) && ((DXTemplateWidgetNode) dXWidgetNode).isKeepInRecyclerLru();
        }
    }

    public DXDataSourceLruManager(int i) {
        this.d = i;
    }

    public List<Object> a() {
        return this.c;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addAllItem(int i, Collection<DXWidgetNode> collection) {
        if (!(collection == null || collection.isEmpty())) {
            for (DXWidgetNode dXWidgetNode : collection) {
                setItem(i, dXWidgetNode);
                i++;
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addItem(int i, DXWidgetNode dXWidgetNode) {
        setItem(i, dXWidgetNode);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void addItem(DXWidgetNode dXWidgetNode) {
    }

    public List<DXWidgetNode> b() {
        if (this.a == null) {
            return null;
        }
        return new ArrayList(this.a.snapshot().values());
    }

    /* access modifiers changed from: protected */
    public LruKeepPredicate c() {
        if (this.b == null) {
            this.b = new a(this);
        }
        return this.b;
    }

    public void d(List<Object> list) {
        this.c = list;
    }

    public void e(List<DXWidgetNode> list) {
        if (list != null) {
            this.a = new DXRecyclerLruCache(Math.max(this.d, list.size()), c());
            for (int i = 0; i < list.size(); i++) {
                this.a.c(Integer.valueOf(i), list.get(i));
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public DXWidgetNode getItem(int i) {
        DXRecyclerLruCache dXRecyclerLruCache = this.a;
        if (dXRecyclerLruCache == null) {
            return null;
        }
        return (DXWidgetNode) dXRecyclerLruCache.get(Integer.valueOf(i));
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int getItemSize() {
        DXRecyclerLruCache dXRecyclerLruCache = this.a;
        if (dXRecyclerLruCache == null) {
            return 0;
        }
        return dXRecyclerLruCache.size();
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int getRealCount() {
        List<Object> list = this.c;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.c.size();
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public int indexOfItem(DXWidgetNode dXWidgetNode) {
        DXRecyclerLruCache dXRecyclerLruCache;
        if (dXWidgetNode == null || (dXRecyclerLruCache = this.a) == null) {
            return -1;
        }
        for (Map.Entry entry : dXRecyclerLruCache.snapshot().entrySet()) {
            if (entry != null && entry.getValue() == dXWidgetNode) {
                return ((Integer) entry.getKey()).intValue();
            }
        }
        return -1;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public boolean isItemsEmpty() {
        DXRecyclerLruCache dXRecyclerLruCache = this.a;
        if (dXRecyclerLruCache != null && dXRecyclerLruCache.size() > 0) {
            return false;
        }
        return true;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public boolean isItemsNull() {
        return this.a == null;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public DXWidgetNode removeItem(int i) {
        DXRecyclerLruCache dXRecyclerLruCache = this.a;
        if (dXRecyclerLruCache == null) {
            return null;
        }
        return (DXWidgetNode) dXRecyclerLruCache.remove(Integer.valueOf(i));
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager
    public void setItem(int i, DXWidgetNode dXWidgetNode) {
        DXRecyclerLruCache dXRecyclerLruCache = this.a;
        if (dXRecyclerLruCache != null) {
            dXRecyclerLruCache.c(Integer.valueOf(i), dXWidgetNode);
        }
    }
}
