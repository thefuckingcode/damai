package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.g.c;
import com.meizu.cloud.pushsdk.c.g.g;
import com.meizu.cloud.pushsdk.c.g.m;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: Taobao */
public abstract class j {
    public static j a(final g gVar, final File file) {
        Objects.requireNonNull(file, "content == null");
        return new j() {
            /* class com.meizu.cloud.pushsdk.c.c.j.AnonymousClass2 */

            @Override // com.meizu.cloud.pushsdk.c.c.j
            public g a() {
                return gVar;
            }

            @Override // com.meizu.cloud.pushsdk.c.c.j
            public void a(c cVar) throws IOException {
                m mVar = null;
                try {
                    mVar = g.a(file);
                    cVar.a(mVar);
                } finally {
                    m.a(mVar);
                }
            }

            @Override // com.meizu.cloud.pushsdk.c.c.j
            public long b() {
                return file.length();
            }
        };
    }

    public static j a(g gVar, String str) {
        Charset charset = m.c;
        if (gVar != null) {
            Charset b = gVar.b();
            if (b == null) {
                gVar = g.a(gVar + "; charset=utf-8");
            } else {
                charset = b;
            }
        }
        return a(gVar, str.getBytes(charset));
    }

    public static j a(g gVar, byte[] bArr) {
        return a(gVar, bArr, 0, bArr.length);
    }

    public static j a(final g gVar, final byte[] bArr, final int i, final int i2) {
        Objects.requireNonNull(bArr, "content == null");
        m.a((long) bArr.length, (long) i, (long) i2);
        return new j() {
            /* class com.meizu.cloud.pushsdk.c.c.j.AnonymousClass1 */

            @Override // com.meizu.cloud.pushsdk.c.c.j
            public g a() {
                return gVar;
            }

            @Override // com.meizu.cloud.pushsdk.c.c.j
            public void a(c cVar) throws IOException {
                cVar.c(bArr, i, i2);
            }

            @Override // com.meizu.cloud.pushsdk.c.c.j
            public long b() {
                return (long) i2;
            }
        };
    }

    public abstract g a();

    public abstract void a(c cVar) throws IOException;

    public long b() throws IOException {
        return -1;
    }
}
