package com.taobao.update.datasource;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.taobao.update.datasource.UpdateListener;
import com.taobao.update.datasource.logger.Log;
import com.taobao.update.result.BundleUpdateStep;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import tb.js2;
import tb.qs1;
import tb.y91;

/* compiled from: Taobao */
public class TaskManager {
    private static TaskManager e;
    private BlockingQueue<Task> a = new PriorityBlockingQueue(5);
    private boolean b;
    private boolean c;
    private Log d = y91.getLog(TaskManager.class, (Log) null);

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements UpdateListener.PatchListener {
        a() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void hasPatched(boolean z) {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchFailed(String str) {
            Log log = TaskManager.this.d;
            log.w("dexpatch fix:" + str);
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchStart() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchSuccess() {
            TaskManager.this.b = true;
            if (TaskManager.this.a.peek() == null) {
                UpdateDataSource.getInstance().clearCache();
            } else if (TaskManager.this.a.peek() != null && ((qs1) TaskManager.this.a.peek()).getPatchType().getPriority() == 4) {
                TaskManager.this.a.poll();
            }
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patching(BundleUpdateStep bundleUpdateStep) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements UpdateListener.PatchListener {
        b() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void hasPatched(boolean z) {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchFailed(String str) {
            Log log = TaskManager.this.d;
            log.w("Apk update:" + str);
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchStart() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchSuccess() {
            TaskManager.this.a.clear();
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patching(BundleUpdateStep bundleUpdateStep) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements UpdateListener.PatchListener {
        c() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void hasPatched(boolean z) {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchFailed(String str) {
            Log log = TaskManager.this.d;
            log.w("dynamic update:" + str);
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchStart() {
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patchSuccess() {
            TaskManager.this.c = true;
            TaskManager.this.a.clear();
        }

        @Override // com.taobao.update.datasource.UpdateListener.PatchListener
        public void patching(BundleUpdateStep bundleUpdateStep) {
        }
    }

    private TaskManager() {
    }

    private void e(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.taobao.update.datasource.TaskManager.AnonymousClass1 */

            public void run() {
                Toast.makeText(UpdateDataSource.sContext, str, 1).show();
            }
        });
    }

    public static TaskManager instance() {
        if (e == null) {
            synchronized (TaskManager.class) {
                if (e == null) {
                    e = new TaskManager();
                }
            }
        }
        return e;
    }

    public void add(Task task) {
        boolean z = this.c;
        if (z || this.b) {
            UpdateDataSource.sUpdateAdapter.commitSuccess("update_center_all", z ? "update_dynamic_success" : "update_dexpatch_success", "");
            qs1 qs1 = (qs1) task;
            if (qs1.getPatchType().getPriority() == 2 || qs1.getPatchType().getPriority() == 4) {
                if (qs1.from().equals(js2.SCAN)) {
                    e("动态部署或者dexpatch已经成功,杀进程生效,在这期间不能再次操作");
                    return;
                }
                Log log = this.d;
                log.w("dynamic has finished " + this.c + " or dexpatch has finished " + this.b);
                return;
            }
        }
        if (!this.a.contains(task)) {
            this.a.add(task);
        } else if (!((qs1) task).isBackground()) {
            e("正在更新中");
        } else {
            this.d.w("update is in progress....");
        }
    }

    public void run() throws InterruptedException {
        while (true) {
            Task poll = this.a.poll(1000, TimeUnit.MILLISECONDS);
            if (poll != null && (poll instanceof qs1)) {
                qs1 qs1 = (qs1) poll;
                if (qs1.getPatchType().getPriority() == 0) {
                    qs1.asyncRun();
                } else if (qs1.getPatchType().getPriority() == 1) {
                    qs1.asyncRun();
                } else if (qs1.getPatchType().getPriority() == 2) {
                    UpdateDataSource.sUpdateAdapter.commitSuccess("update_center_all", "update_dispatch_dexpatch", "");
                    if (qs1.getRunnable().getUpdateListener() != null) {
                        qs1.getRunnable().getUpdateListener().patchProcessListener(new a());
                    }
                    qs1.syncRun();
                } else if (qs1.getPatchType().getPriority() == 3) {
                    if (qs1.getRunnable().getUpdateListener() != null) {
                        qs1.getRunnable().getUpdateListener().patchProcessListener(new b());
                    }
                    qs1.syncRun();
                } else if (qs1.getPatchType().getPriority() == 4) {
                    if (!this.b) {
                        UpdateDataSource.sUpdateAdapter.commitSuccess("update_center_all", "update_dispatch_dynamic", "");
                        if (qs1.getRunnable().getUpdateListener() != null) {
                            qs1.getRunnable().getUpdateListener().patchProcessListener(new c());
                        }
                        qs1.syncRun();
                    } else {
                        return;
                    }
                } else if (qs1.getPatchType().getPriority() == 5) {
                    qs1.asyncRun();
                    return;
                }
            } else {
                return;
            }
        }
    }
}
