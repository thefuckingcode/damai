package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import com.vivo.push.util.p;
import tb.jl1;

/* compiled from: Taobao */
final class c implements Handler.Callback {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final boolean handleMessage(Message message) {
        if (message == null) {
            p.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i = message.what;
        if (i == 1) {
            p.a("AidlManager", "In connect, bind core service time out");
            if (b.a(this.a).get() == 2) {
                b.b(this.a);
            }
        } else if (i != 2) {
            p.b("AidlManager", "unknow msg what [" + message.what + jl1.ARRAY_END_STR);
        } else {
            if (b.a(this.a).get() == 4) {
                b.c(this.a);
            }
            b.b(this.a);
        }
        return true;
    }
}
