package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.http.c;
import okhttp3.o;
import okhttp3.q;

/* compiled from: Taobao */
public final class a implements Interceptor {
    public a(OkHttpClient okHttpClient) {
    }

    @Override // okhttp3.Interceptor
    public q intercept(Interceptor.Chain chain) throws IOException {
        c cVar = (c) chain;
        o request = cVar.request();
        i c = cVar.c();
        return cVar.b(request, c, c.k(chain, !request.g().equals("GET")));
    }
}
