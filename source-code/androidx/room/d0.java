package androidx.room;

/* compiled from: Taobao */
public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;
    public final /* synthetic */ String b;

    public /* synthetic */ d0(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.a = queryInterceptorDatabase;
        this.b = str;
    }

    public final void run() {
        this.a.lambda$query$6(this.b);
    }
}
