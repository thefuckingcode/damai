package androidx.room;

/* compiled from: Taobao */
public final /* synthetic */ class v implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;

    public /* synthetic */ v(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.a = queryInterceptorDatabase;
    }

    public final void run() {
        this.a.lambda$beginTransactionNonExclusive$1();
    }
}
