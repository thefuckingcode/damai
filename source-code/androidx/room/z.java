package androidx.room;

/* compiled from: Taobao */
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;

    public /* synthetic */ z(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.a = queryInterceptorDatabase;
    }

    public final void run() {
        this.a.lambda$beginTransactionWithListener$2();
    }
}
