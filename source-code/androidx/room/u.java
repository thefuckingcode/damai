package androidx.room;

import java.util.List;

/* compiled from: Taobao */
public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    public /* synthetic */ u(QueryInterceptorDatabase queryInterceptorDatabase, String str, List list) {
        this.a = queryInterceptorDatabase;
        this.b = str;
        this.c = list;
    }

    public final void run() {
        this.a.lambda$query$7(this.b, this.c);
    }
}
