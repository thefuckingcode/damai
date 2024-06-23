package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public abstract class ErrorResultImpl<R extends Result> extends PendingResult<R> {
    private R a = null;
    private int b;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Runnable {
        final /* synthetic */ ResultCallback a;
        final /* synthetic */ ErrorResultImpl b;

        a(ResultCallback resultCallback, ErrorResultImpl errorResultImpl) {
            this.a = resultCallback;
            this.b = errorResultImpl;
        }

        public void run() {
            ResultCallback resultCallback = this.a;
            ErrorResultImpl errorResultImpl = ErrorResultImpl.this;
            resultCallback.onResult(errorResultImpl.a(errorResultImpl.b, this.b));
        }
    }

    public ErrorResultImpl(int i) {
        this.b = i;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        return await(0, null);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void cancel() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void postRunnable(Looper looper, ResultCallback<R> resultCallback, ErrorResultImpl errorResultImpl) {
        if (looper == null) {
            looper = Looper.myLooper();
        }
        new Handler(looper).post(new a(resultCallback, errorResultImpl));
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(ResultCallback<R> resultCallback) {
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return a(this.b, this);
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private R a(int i, ErrorResultImpl errorResultImpl) {
        Type genericSuperclass = errorResultImpl.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        try {
            R r = (R) ((Result) GenericTypeReflector.getType(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).newInstance());
            this.a = r;
            r.setStatus(new Status(i));
        } catch (InstantiationException unused) {
            HMSLog.e("ErrorResultImpl", "InstantiationException");
        } catch (IllegalAccessException unused2) {
            HMSLog.e("ErrorResultImpl", "IllegalAccessException");
        }
        return this.a;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        postRunnable(looper, resultCallback, this);
    }
}
