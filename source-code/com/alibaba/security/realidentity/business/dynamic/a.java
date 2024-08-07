package com.alibaba.security.realidentity.business.dynamic;

import android.content.Context;
import android.os.AsyncTask;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.d.b;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public abstract class a<T> extends AsyncTask<String, Void, T> {
    protected final WeakReference<Context> a;
    protected final String b;
    protected final RPEventListener c;
    protected final Runnable d;
    protected final b e;

    public a(Context context, String str, RPEventListener rPEventListener, Runnable runnable, b bVar) {
        this.a = new WeakReference<>(context);
        this.b = str;
        this.c = rPEventListener;
        this.d = runnable;
        this.e = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public T doInBackground(String... strArr) {
        return null;
    }

    public abstract void a(T t);

    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(T t) {
        super.onPostExecute(t);
        a(t);
    }
}
