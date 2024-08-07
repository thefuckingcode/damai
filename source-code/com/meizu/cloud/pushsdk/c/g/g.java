package com.meizu.cloud.pushsdk.c.g;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import tb.jl1;

/* compiled from: Taobao */
public final class g {
    private static final Logger a = Logger.getLogger(g.class.getName());

    private g() {
    }

    public static c a(l lVar) {
        if (lVar != null) {
            return new h(lVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static d a(m mVar) {
        if (mVar != null) {
            return new i(mVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static l a(OutputStream outputStream) {
        return a(outputStream, new n());
    }

    private static l a(final OutputStream outputStream, final n nVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (nVar != null) {
            return new l() {
                /* class com.meizu.cloud.pushsdk.c.g.g.AnonymousClass1 */

                @Override // com.meizu.cloud.pushsdk.c.g.l
                public void a(b bVar, long j) throws IOException {
                    o.a(bVar.b, 0, j);
                    while (j > 0) {
                        nVar.a();
                        j jVar = bVar.a;
                        int min = (int) Math.min(j, (long) (jVar.c - jVar.b));
                        outputStream.write(jVar.a, jVar.b, min);
                        int i = jVar.b + min;
                        jVar.b = i;
                        long j2 = (long) min;
                        j -= j2;
                        bVar.b -= j2;
                        if (i == jVar.c) {
                            bVar.a = jVar.a();
                            k.a(jVar);
                        }
                    }
                }

                @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                public String toString() {
                    return "sink(" + outputStream + jl1.BRACKET_END_STR;
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static m a(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static m a(InputStream inputStream) {
        return a(inputStream, new n());
    }

    private static m a(final InputStream inputStream, final n nVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (nVar != null) {
            return new m() {
                /* class com.meizu.cloud.pushsdk.c.g.g.AnonymousClass2 */

                @Override // com.meizu.cloud.pushsdk.c.g.m
                public long b(b bVar, long j) throws IOException {
                    int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (i == 0) {
                        return 0;
                    } else {
                        nVar.a();
                        j c = bVar.c(1);
                        int read = inputStream.read(c.a, c.c, (int) Math.min(j, (long) (2048 - c.c)));
                        if (read == -1) {
                            return -1;
                        }
                        c.c += read;
                        long j2 = (long) read;
                        bVar.b += j2;
                        return j2;
                    }
                }

                @Override // com.meizu.cloud.pushsdk.c.g.m, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                public String toString() {
                    return "source(" + inputStream + jl1.BRACKET_END_STR;
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }
}
