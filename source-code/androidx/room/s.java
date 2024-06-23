package androidx.room;

/* compiled from: Taobao */
public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;

    public /* synthetic */ s(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.a = queryInterceptorDatabase;
    }

    public final void run() {
        this.a.lambda$endTransaction$4();
    }
}
