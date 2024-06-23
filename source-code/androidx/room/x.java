package androidx.room;

/* compiled from: Taobao */
public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;

    public /* synthetic */ x(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.a = queryInterceptorDatabase;
    }

    public final void run() {
        this.a.lambda$beginTransactionWithListenerNonExclusive$3();
    }
}
