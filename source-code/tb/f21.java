package tb;

import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.a;
import okhttp3.g;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.f;
import okhttp3.l;
import okhttp3.o;
import okhttp3.q;

/* compiled from: Taobao */
public abstract class f21 {
    public static f21 a;

    public abstract void a(l.a aVar, String str);

    public abstract void b(l.a aVar, String str, String str2);

    public abstract void c(g gVar, SSLSocket sSLSocket, boolean z);

    public abstract int d(q.a aVar);

    public abstract boolean e(a aVar, a aVar2);

    @Nullable
    public abstract c f(q qVar);

    public abstract void g(q.a aVar, c cVar);

    public abstract Call h(OkHttpClient okHttpClient, o oVar);

    public abstract f i(okhttp3.f fVar);
}
