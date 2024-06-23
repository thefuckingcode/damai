package com.youku.asyncview.core;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.youku.asyncview.AsyncViewSetting;
import com.youku.asyncview.IViewCreator;
import com.youku.asyncview.ViewContext;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class AsyncViewMemoryManager implements IMemoryManager {
    private final SparseArray<AsyncViewPool> mAsyncViewPoolMap = new SparseArray<>();
    private IViewCreator mDefaultViewCreator = new IViewCreator() {
        /* class com.youku.asyncview.core.AsyncViewMemoryManager.AnonymousClass1 */

        @Override // com.youku.asyncview.IViewCreator
        public View createView(ViewContext viewContext, int i) {
            if (AsyncViewMemoryManager.this.mLayoutInflater == null) {
                AsyncViewMemoryManager.this.mLayoutInflater = LayoutInflater.from(viewContext).cloneInContext(viewContext);
            }
            try {
                return AsyncViewMemoryManager.this.mLayoutInflater.inflate(i, (ViewGroup) null, false);
            } catch (Throwable unused) {
                return null;
            }
        }
    };
    private boolean mIsDebug;
    private LayoutInflater mLayoutInflater;
    private MemoryMonitor mMemoryMonitor;
    private MemoryStateListener mMemoryStateListener = new MemoryStateListener() {
        /* class com.youku.asyncview.core.AsyncViewMemoryManager.AnonymousClass2 */

        @Override // com.youku.asyncview.core.MemoryStateListener
        public void onLowMemory() {
            AsyncViewMemoryManager.this.innerOnLowMemory();
        }
    };

    AsyncViewMemoryManager(Context context) {
        MemoryMonitor memoryMonitor = new MemoryMonitor(context.getApplicationContext());
        this.mMemoryMonitor = memoryMonitor;
        memoryMonitor.setMemoryStateListener(this.mMemoryStateListener);
        this.mMemoryMonitor.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r0.size() != 0) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        r1 = r0.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (r3 >= r1) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        ((com.youku.asyncview.core.AsyncViewPool) r0.get(r3)).clear();
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
        return;
     */
    private void innerOnLowMemory() {
        ArrayList arrayList = new ArrayList();
        SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
        synchronized (sparseArray) {
            if (sparseArray.size() != 0) {
                int size = sparseArray.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    AsyncViewPool valueAt = sparseArray.valueAt(i2);
                    AsyncViewSetting.AsyncViewPriority priority = valueAt.getPriority();
                    if (AsyncViewSetting.AsyncViewPriority.LOW == priority || AsyncViewSetting.AsyncViewPriority.NORMAL == priority) {
                        arrayList.add(valueAt);
                    }
                }
            }
        }
    }

    private boolean isAsyncView(View view) {
        return view != null && (view.getContext() instanceof ViewContext);
    }

    /* access modifiers changed from: package-private */
    public AsyncViewPool buildAsyncViewPool(ViewContext viewContext, AsyncViewSetting asyncViewSetting) {
        return new AsyncViewPool(viewContext, asyncViewSetting, this.mDefaultViewCreator);
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void gcAllAsyncViews() {
        SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
        synchronized (sparseArray) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                sparseArray.valueAt(i).clear();
            }
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void gcAsyncViews(int i) {
        synchronized (this.mAsyncViewPoolMap) {
            AsyncViewPool asyncViewPool = this.mAsyncViewPoolMap.get(i);
            if (asyncViewPool != null) {
                asyncViewPool.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public View getAsyncView(int i, String str) {
        AsyncViewPool asyncViewPool;
        synchronized (this.mAsyncViewPoolMap) {
            asyncViewPool = this.mAsyncViewPoolMap.get(i);
        }
        if (asyncViewPool == null) {
            return null;
        }
        return asyncViewPool.checkOut(str);
    }

    /* access modifiers changed from: package-private */
    public void putAsyncViewPool(int i, AsyncViewPool asyncViewPool) {
        if (i > 0 && asyncViewPool != null) {
            synchronized (this.mAsyncViewPoolMap) {
                this.mAsyncViewPoolMap.put(i, asyncViewPool);
            }
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerAllAsyncViews() {
        SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            sparseArray.valueAt(i).reset();
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerAsyncView(int i, View view) {
        AsyncViewPool asyncViewPool;
        if (view != null && i > 0 && isAsyncView(view)) {
            synchronized (this.mAsyncViewPoolMap) {
                asyncViewPool = this.mAsyncViewPoolMap.get(i);
            }
            if (asyncViewPool != null) {
                asyncViewPool.checkIn(view);
            }
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerGroupAsyncViews(String str) {
        SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
        synchronized (sparseArray) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                sparseArray.valueAt(i).resetGroup(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setAsyncViewSetting(ViewContext viewContext, AsyncViewSetting asyncViewSetting) {
        if (asyncViewSetting != null && asyncViewSetting.getLayoutId() > 0) {
            int layoutId = asyncViewSetting.getLayoutId();
            SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
            AsyncViewPool asyncViewPool = sparseArray.get(layoutId);
            if (asyncViewPool == null) {
                AsyncViewPool asyncViewPool2 = new AsyncViewPool(viewContext, asyncViewSetting, this.mDefaultViewCreator);
                asyncViewPool2.setDebug(this.mIsDebug);
                sparseArray.put(layoutId, asyncViewPool2);
                return;
            }
            asyncViewPool.setMaxNum(asyncViewSetting.getCacheSize());
            asyncViewPool.setPriority(asyncViewSetting.getPriority());
            asyncViewPool.setViewCreator(asyncViewSetting.getViewCreater());
        }
    }

    public void setDebug(boolean z) {
        this.mIsDebug = z;
        SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
        synchronized (sparseArray) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                sparseArray.valueAt(i).setDebug(z);
            }
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void setDefaultViewCreator(IViewCreator iViewCreator) {
        if (iViewCreator != null) {
            this.mDefaultViewCreator = iViewCreator;
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerAsyncView(int i, List<View> list) {
        AsyncViewPool asyncViewPool;
        if (list != null && list.size() != 0 && i > 0) {
            int i2 = 0;
            if (isAsyncView(list.get(0))) {
                synchronized (this.mAsyncViewPoolMap) {
                    asyncViewPool = this.mAsyncViewPoolMap.get(i);
                }
                if (asyncViewPool != null) {
                    int size = list.size();
                    while (i2 < size && asyncViewPool.checkIn(list.get(i2))) {
                        i2++;
                    }
                }
            }
        }
    }
}
