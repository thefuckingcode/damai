package androidx.room;

/* compiled from: Taobao */
public final /* synthetic */ class w implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;

    public /* synthetic */ w(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.a = queryInterceptorDatabase;
    }

    public final void run() {
        this.a.lambda$setTransactionSuccessful$5();
    }
}
