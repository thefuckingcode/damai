package com.ali.user.open.core.task;

import android.os.AsyncTask;

/* compiled from: Taobao */
public abstract class AbsAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private static final String TAG = "kernel";

    /* access modifiers changed from: protected */
    public abstract Result asyncExecute(Params... paramsArr);

    /* access modifiers changed from: protected */
    public abstract void doFinally();

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Result doInBackground(Params... paramsArr) {
        try {
            Result asyncExecute = asyncExecute(paramsArr);
            doFinally();
            return asyncExecute;
        } catch (Throwable th) {
            doFinally();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void doWhenException(Throwable th);
}
