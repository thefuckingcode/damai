package com.taobao.android.task;

import android.util.Log;
import com.taobao.android.task.Coordinator;
import java.util.ArrayList;

/* compiled from: Taobao */
public class Flow {
    protected static final String TAG = "Flow";
    protected boolean mAbortIfError = false;
    protected boolean mCancel = false;
    protected ArrayList<Coordinator.TaggedRunnable> mTaskList = new ArrayList<>();

    public Flow addTask(Coordinator.TaggedRunnable taggedRunnable) {
        if (taggedRunnable != null) {
            this.mTaskList.add(taggedRunnable);
        }
        return this;
    }

    public void cancel() {
        this.mCancel = true;
    }

    public void start() {
        Coordinator.getDefaultAsyncTaskExecutor().execute(new Runnable() {
            /* class com.taobao.android.task.Flow.AnonymousClass1 */

            public void run() {
                int size = Flow.this.mTaskList.size();
                for (int i = 0; i < size; i++) {
                    Flow flow = Flow.this;
                    if (!flow.mCancel) {
                        Coordinator.TaggedRunnable taggedRunnable = flow.mTaskList.get(i);
                        try {
                            taggedRunnable.run();
                        } catch (Throwable th) {
                            if (!Flow.this.mAbortIfError) {
                                Log.e(Flow.TAG, "task " + taggedRunnable.toString() + " exception " + th.toString());
                            } else {
                                throw new RuntimeException(th.getCause());
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        });
    }
}
