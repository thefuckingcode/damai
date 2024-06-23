package com.taobao.weex.ui.component.list.template;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.MessageQueue;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.ui.component.list.WXCell;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class AsyncCellLoadTask extends AsyncTask<Void, Void, Void> {
    private WXCell source;
    private String template;
    private WXRecyclerTemplateList templateList;

    public AsyncCellLoadTask(String str, WXCell wXCell, WXRecyclerTemplateList wXRecyclerTemplateList) {
        this.template = str;
        this.source = wXCell;
        this.templateList = wXRecyclerTemplateList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isDestory() {
        if (this.source.getInstance() == null || this.source.getInstance().isDestroy()) {
            return true;
        }
        return this.templateList.isDestoryed();
    }

    public void startTask() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... voidArr) {
        TemplateCache templateCache = this.templateList.getTemplatesCache().get(this.template);
        if (!(templateCache == null || templateCache.cells == null)) {
            while (templateCache.cells.size() < this.templateList.getTemplateCacheSize()) {
                System.currentTimeMillis();
                WXCell wXCell = (WXCell) this.templateList.copyComponentFromSourceCell(this.source);
                WXEnvironment.isOpenDebugLog();
                if (wXCell == null || isDestory()) {
                    return null;
                }
                templateCache.cells.add(wXCell);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r4 = r3.templateList.getTemplatesCache().get(r3.template);
     */
    public void onPostExecute(Void r4) {
        final TemplateCache templateCache;
        if (!isDestory() && templateCache != null) {
            ConcurrentLinkedQueue<WXCell> concurrentLinkedQueue = templateCache.cells;
            if (concurrentLinkedQueue == null || concurrentLinkedQueue.size() == 0) {
                templateCache.isLoadIng = false;
                return;
            }
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.taobao.weex.ui.component.list.template.AsyncCellLoadTask.AnonymousClass1 */

                public boolean queueIdle() {
                    if (AsyncCellLoadTask.this.isDestory()) {
                        return false;
                    }
                    Iterator<WXCell> it = templateCache.cells.iterator();
                    while (it.hasNext()) {
                        WXCell next = it.next();
                        if (next.isLazy()) {
                            WXRecyclerTemplateList unused = AsyncCellLoadTask.this.templateList;
                            WXRecyclerTemplateList.doCreateCellViewBindData(next, AsyncCellLoadTask.this.template, true);
                            return it.hasNext();
                        }
                    }
                    return false;
                }
            });
            templateCache.isLoadIng = false;
        }
    }
}
