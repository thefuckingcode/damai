package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

/* compiled from: Taobao */
public final /* synthetic */ class a0 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase a;
    public final /* synthetic */ SupportSQLiteQuery b;
    public final /* synthetic */ QueryInterceptorProgram c;

    public /* synthetic */ a0(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.a = queryInterceptorDatabase;
        this.b = supportSQLiteQuery;
        this.c = queryInterceptorProgram;
    }

    public final void run() {
        this.a.lambda$query$8(this.b, this.c);
    }
}
