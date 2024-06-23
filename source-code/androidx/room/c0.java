package androidx.room;

/* compiled from: Taobao */
public final /* synthetic */ class c0 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;
    public final /* synthetic */ String b;

    public /* synthetic */ c0(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.a = queryInterceptorDatabase;
        this.b = str;
    }

    public final void run() {
        this.a.lambda$execSQL$10(this.b);
    }
}
