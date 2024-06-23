package com.taobao.login4android.thread;

import android.os.AsyncTask;
import com.taobao.login4android.log.LoginTLogAdapter;

/* compiled from: Taobao */
public abstract class LoginAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public static final String TAG = "login.LoginAsyncTask";

    public void doFinally() {
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Result doInBackground(Params... paramsArr) {
        try {
            Result excuteTask = excuteTask(paramsArr);
            doFinally();
            return excuteTask;
        } catch (Throwable th) {
            doFinally();
            throw th;
        }
    }

    public abstract Result excuteTask(Params... paramsArr) throws Exception;

    public void handleException(Throwable th) {
        th.printStackTrace();
        LoginTLogAdapter.w(TAG, "LoginAsyncTask excute failed", th);
    }
}
