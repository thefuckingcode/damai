package com.meizu.cloud.pushsdk.c.e;

import com.meizu.cloud.pushsdk.c.c.g;
import com.meizu.cloud.pushsdk.c.c.j;
import com.meizu.cloud.pushsdk.c.d.a;
import com.meizu.cloud.pushsdk.c.g.c;
import com.meizu.cloud.pushsdk.c.g.f;
import com.meizu.cloud.pushsdk.c.g.l;
import java.io.IOException;

/* compiled from: Taobao */
public class b extends j {
    private final j a;
    private c b;
    private d c;

    public b(j jVar, a aVar) {
        this.a = jVar;
        if (aVar != null) {
            this.c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) {
            /* class com.meizu.cloud.pushsdk.c.e.b.AnonymousClass1 */
            long a = 0;
            long b = 0;

            @Override // com.meizu.cloud.pushsdk.c.g.l, com.meizu.cloud.pushsdk.c.g.f
            public void a(com.meizu.cloud.pushsdk.c.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.b == 0) {
                    this.b = b.this.b();
                }
                this.a += j;
                if (b.this.c != null) {
                    b.this.c.obtainMessage(1, new com.meizu.cloud.pushsdk.c.f.a(this.a, this.b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public g a() {
        return this.a.a();
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(c cVar) throws IOException {
        if (this.b == null) {
            this.b = com.meizu.cloud.pushsdk.c.g.g.a(a((l) cVar));
        }
        this.a.a(this.b);
        this.b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() throws IOException {
        return this.a.b();
    }
}
