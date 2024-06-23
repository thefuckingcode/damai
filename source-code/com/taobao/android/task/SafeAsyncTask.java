package com.taobao.android.task;

import android.os.AsyncTask;
import com.taobao.android.compat.ActionBarActivityCompat;

/* compiled from: Taobao */
public abstract class SafeAsyncTask<Params, Result> extends AsyncTask<Params, Void, Result> {
    private final ActionBarActivityCompat mActivity;

    public SafeAsyncTask(ActionBarActivityCompat actionBarActivityCompat) {
        this.mActivity = actionBarActivityCompat;
    }

    public static void execute(Runnable runnable) {
        Coordinator.getDefaultAsyncTaskExecutor().execute(runnable);
    }

    public static final void init() {
    }

    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final void onPostExecute(Result result) {
        if (!this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            onResult(result);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onResult(Result result);
}
