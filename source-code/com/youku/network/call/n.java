package com.youku.network.call;

import android.os.Handler;
import com.youku.network.a;
import com.youku.network.a.b;
import com.youku.network.a.e;
import com.youku.network.d;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.q;

/* compiled from: Taobao */
public class n implements Callback {
    private Handler a;
    private a b;
    private e c;
    private d d;
    private AtomicBoolean e;

    public n(Handler handler, a aVar, b bVar) {
        this.d = d.a();
        this.e = new AtomicBoolean(false);
        this.a = handler;
        this.b = aVar;
        this.c = (e) bVar;
    }

    public n(a aVar, b bVar) {
        this(null, aVar, bVar);
    }

    public void a(d dVar) {
        a aVar;
        if (this.e.compareAndSet(false, true) && (aVar = this.b) != null) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new OkHttpListener$1(this, dVar));
            } else {
                aVar.a(dVar);
            }
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        this.d.a(iOException);
        d a2 = com.youku.network.config.b.a(this.d, iOException, -3004);
        this.d = a2;
        a(a2);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, q qVar) {
        d a2 = this.c.a(qVar);
        this.d = a2;
        a(a2);
    }
}
