package com.youku.network.call;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.network.a;
import com.youku.network.c;
import com.youku.network.d;

/* compiled from: Taobao */
public class b {
    private a a;
    private c b;

    public b(a aVar) {
        this.a = aVar;
    }

    private d b() {
        if (com.youku.network.b.a) {
            return null;
        }
        d a2 = d.a();
        a2.a(AVFSCacheConstants.AVFS_ERROR_FILE_READ);
        return a2;
    }

    public d a() {
        d b2 = b();
        return b2 != null ? b2 : this.b.a();
    }

    public void a(a aVar) {
        d b2 = b();
        if (b2 == null) {
            this.b.a(aVar);
        } else if (aVar != null) {
            aVar.a(b2);
        }
    }

    public void a(c cVar) {
        this.a.a(cVar);
        this.b = new c(this.a);
    }

    public void b(a aVar) {
        d b2 = b();
        if (b2 == null) {
            this.b.b(aVar);
        } else if (aVar != null) {
            aVar.a(b2);
        }
    }
}
