package okhttp3.internal.cache;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.h;
import tb.jl1;
import tb.oq1;

/* compiled from: Taobao */
public final class DiskLruCache implements Closeable, Flushable {
    static final Pattern u = Pattern.compile("[a-z0-9_-]{1,120}");
    final FileSystem a;
    final File b;
    private final File c;
    private final File d;
    private final File e;
    private final int f;
    private long g;
    final int h;
    private long i = 0;
    BufferedSink j;
    final LinkedHashMap<String, c> k = new LinkedHashMap<>(0, 0.75f, true);
    int l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    private long r = 0;
    private final Executor s;
    private final Runnable t = new Runnable() {
        /* class okhttp3.internal.cache.DiskLruCache.AnonymousClass1 */

        public void run() {
            synchronized (DiskLruCache.this) {
                DiskLruCache diskLruCache = DiskLruCache.this;
                if (!(!diskLruCache.n) && !diskLruCache.o) {
                    try {
                        diskLruCache.s();
                    } catch (IOException unused) {
                        DiskLruCache.this.p = true;
                    }
                    try {
                        if (DiskLruCache.this.k()) {
                            DiskLruCache.this.p();
                            DiskLruCache.this.l = 0;
                        }
                    } catch (IOException unused2) {
                        DiskLruCache diskLruCache2 = DiskLruCache.this;
                        diskLruCache2.q = true;
                        diskLruCache2.j = h.c(h.b());
                    }
                }
            }
        }
    };

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends c {
        a(Sink sink) {
            super(sink);
        }

        /* access modifiers changed from: protected */
        @Override // okhttp3.internal.cache.c
        public void onException(IOException iOException) {
            DiskLruCache.this.m = true;
        }
    }

    /* compiled from: Taobao */
    public final class b {
        final c a;
        final boolean[] b;
        private boolean c;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends c {
            a(Sink sink) {
                super(sink);
            }

            /* access modifiers changed from: protected */
            @Override // okhttp3.internal.cache.c
            public void onException(IOException iOException) {
                synchronized (DiskLruCache.this) {
                    b.this.c();
                }
            }
        }

        b(c cVar) {
            this.a = cVar;
            this.b = cVar.e ? null : new boolean[DiskLruCache.this.h];
        }

        public void a() throws IOException {
            synchronized (DiskLruCache.this) {
                if (!this.c) {
                    if (this.a.f == this) {
                        DiskLruCache.this.d(this, false);
                    }
                    this.c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        public void b() throws IOException {
            synchronized (DiskLruCache.this) {
                if (!this.c) {
                    if (this.a.f == this) {
                        DiskLruCache.this.d(this, true);
                    }
                    this.c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.a.f == this) {
                int i = 0;
                while (true) {
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    if (i < diskLruCache.h) {
                        try {
                            diskLruCache.a.delete(this.a.d[i]);
                        } catch (IOException unused) {
                        }
                        i++;
                    } else {
                        this.a.f = null;
                        return;
                    }
                }
            }
        }

        public Sink d(int i) {
            synchronized (DiskLruCache.this) {
                if (!this.c) {
                    c cVar = this.a;
                    if (cVar.f != this) {
                        return h.b();
                    }
                    if (!cVar.e) {
                        this.b[i] = true;
                    }
                    try {
                        return new a(DiskLruCache.this.a.sink(cVar.d[i]));
                    } catch (FileNotFoundException unused) {
                        return h.b();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class c {
        final String a;
        final long[] b;
        final File[] c;
        final File[] d;
        boolean e;
        b f;
        long g;

        c(String str) {
            this.a = str;
            int i = DiskLruCache.this.h;
            this.b = new long[i];
            this.c = new File[i];
            this.d = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < DiskLruCache.this.h; i2++) {
                sb.append(i2);
                this.c[i2] = new File(DiskLruCache.this.b, sb.toString());
                sb.append(".tmp");
                this.d[i2] = new File(DiskLruCache.this.b, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.h) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }

        /* access modifiers changed from: package-private */
        public d c() {
            if (Thread.holdsLock(DiskLruCache.this)) {
                Source[] sourceArr = new Source[DiskLruCache.this.h];
                long[] jArr = (long[]) this.b.clone();
                int i = 0;
                int i2 = 0;
                while (true) {
                    try {
                        DiskLruCache diskLruCache = DiskLruCache.this;
                        if (i2 >= diskLruCache.h) {
                            return new d(this.a, this.g, sourceArr, jArr);
                        }
                        sourceArr[i2] = diskLruCache.a.source(this.c[i2]);
                        i2++;
                    } catch (FileNotFoundException unused) {
                        while (true) {
                            DiskLruCache diskLruCache2 = DiskLruCache.this;
                            if (i >= diskLruCache2.h || sourceArr[i] == null) {
                                try {
                                    diskLruCache2.r(this);
                                    return null;
                                } catch (IOException unused2) {
                                    return null;
                                }
                            } else {
                                okhttp3.internal.a.g(sourceArr[i]);
                                i++;
                            }
                        }
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(BufferedSink bufferedSink) throws IOException {
            for (long j : this.b) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }
    }

    /* compiled from: Taobao */
    public final class d implements Closeable {
        private final String a;
        private final long b;
        private final Source[] c;

        d(String str, long j, Source[] sourceArr, long[] jArr) {
            this.a = str;
            this.b = j;
            this.c = sourceArr;
        }

        @Nullable
        public b a() throws IOException {
            return DiskLruCache.this.h(this.a, this.b);
        }

        public Source b(int i) {
            return this.c[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.c) {
                okhttp3.internal.a.g(source);
            }
        }
    }

    DiskLruCache(FileSystem fileSystem, File file, int i2, int i3, long j2, Executor executor) {
        this.a = fileSystem;
        this.b = file;
        this.f = i2;
        this.c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.h = i3;
        this.g = j2;
        this.s = executor;
    }

    private static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    private synchronized void c() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static DiskLruCache e(FileSystem fileSystem, File file, int i2, int i3, long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            return new DiskLruCache(fileSystem, file, i2, i3, j2, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.a.I("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private BufferedSink l() throws FileNotFoundException {
        return h.c(new a(this.a.appendingSink(this.c)));
    }

    private void m() throws IOException {
        this.a.delete(this.d);
        Iterator<c> it = this.k.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i2 = 0;
            if (next.f == null) {
                while (i2 < this.h) {
                    this.i += next.b[i2];
                    i2++;
                }
            } else {
                next.f = null;
                while (i2 < this.h) {
                    this.a.delete(next.c[i2]);
                    this.a.delete(next.d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ab, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ac, code lost:
        if (r1 != null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ae, code lost:
        a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b1, code lost:
        throw r2;
     */
    private void n() throws IOException {
        BufferedSource d2 = h.d(this.a.source(this.c));
        String readUtf8LineStrict = d2.readUtf8LineStrict();
        String readUtf8LineStrict2 = d2.readUtf8LineStrict();
        String readUtf8LineStrict3 = d2.readUtf8LineStrict();
        String readUtf8LineStrict4 = d2.readUtf8LineStrict();
        String readUtf8LineStrict5 = d2.readUtf8LineStrict();
        if (!"libcore.io.DiskLruCache".equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !Integer.toString(this.f).equals(readUtf8LineStrict3) || !Integer.toString(this.h).equals(readUtf8LineStrict4) || !"".equals(readUtf8LineStrict5)) {
            throw new IOException("unexpected journal header: [" + readUtf8LineStrict + AVFSCacheConstants.COMMA_SEP + readUtf8LineStrict2 + AVFSCacheConstants.COMMA_SEP + readUtf8LineStrict4 + AVFSCacheConstants.COMMA_SEP + readUtf8LineStrict5 + jl1.ARRAY_END_STR);
        }
        int i2 = 0;
        while (true) {
            try {
                o(d2.readUtf8LineStrict());
                i2++;
            } catch (EOFException unused) {
                this.l = i2 - this.k.size();
                if (!d2.exhausted()) {
                    p();
                } else {
                    this.j = l();
                }
                a(null, d2);
                return;
            }
        }
    }

    private void o(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            c cVar = this.k.get(str2);
            if (cVar == null) {
                cVar = new c(str2);
                this.k.put(str2, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                cVar.e = true;
                cVar.f = null;
                cVar.b(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f = new b(cVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void t(String str) {
        if (!u.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.n) {
            if (!this.o) {
                for (c cVar : (c[]) this.k.values().toArray(new c[this.k.size()])) {
                    b bVar = cVar.f;
                    if (bVar != null) {
                        bVar.a();
                    }
                }
                s();
                this.j.close();
                this.j = null;
                this.o = true;
                return;
            }
        }
        this.o = true;
    }

    /* access modifiers changed from: package-private */
    public synchronized void d(b bVar, boolean z) throws IOException {
        c cVar = bVar.a;
        if (cVar.f == bVar) {
            if (z && !cVar.e) {
                for (int i2 = 0; i2 < this.h; i2++) {
                    if (!bVar.b[i2]) {
                        bVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    } else if (!this.a.exists(cVar.d[i2])) {
                        bVar.a();
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < this.h; i3++) {
                File file = cVar.d[i3];
                if (!z) {
                    this.a.delete(file);
                } else if (this.a.exists(file)) {
                    File file2 = cVar.c[i3];
                    this.a.rename(file, file2);
                    long j2 = cVar.b[i3];
                    long size = this.a.size(file2);
                    cVar.b[i3] = size;
                    this.i = (this.i - j2) + size;
                }
            }
            this.l++;
            cVar.f = null;
            if (cVar.e || z) {
                cVar.e = true;
                this.j.writeUtf8("CLEAN").writeByte(32);
                this.j.writeUtf8(cVar.a);
                cVar.d(this.j);
                this.j.writeByte(10);
                if (z) {
                    long j3 = this.r;
                    this.r = 1 + j3;
                    cVar.g = j3;
                }
            } else {
                this.k.remove(cVar.a);
                this.j.writeUtf8("REMOVE").writeByte(32);
                this.j.writeUtf8(cVar.a);
                this.j.writeByte(10);
            }
            this.j.flush();
            if (this.i > this.g || k()) {
                this.s.execute(this.t);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void f() throws IOException {
        close();
        this.a.deleteContents(this.b);
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.n) {
            c();
            s();
            this.j.flush();
        }
    }

    @Nullable
    public b g(String str) throws IOException {
        return h(str, -1);
    }

    /* access modifiers changed from: package-private */
    public synchronized b h(String str, long j2) throws IOException {
        j();
        c();
        t(str);
        c cVar = this.k.get(str);
        if (j2 != -1 && (cVar == null || cVar.g != j2)) {
            return null;
        }
        if (cVar != null && cVar.f != null) {
            return null;
        }
        if (this.p || this.q) {
            this.s.execute(this.t);
            return null;
        }
        this.j.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
        this.j.flush();
        if (this.m) {
            return null;
        }
        if (cVar == null) {
            cVar = new c(str);
            this.k.put(str, cVar);
        }
        b bVar = new b(cVar);
        cVar.f = bVar;
        return bVar;
    }

    public synchronized d i(String str) throws IOException {
        j();
        c();
        t(str);
        c cVar = this.k.get(str);
        if (cVar != null) {
            if (cVar.e) {
                d c2 = cVar.c();
                if (c2 == null) {
                    return null;
                }
                this.l++;
                this.j.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
                if (k()) {
                    this.s.execute(this.t);
                }
                return c2;
            }
        }
        return null;
    }

    public synchronized boolean isClosed() {
        return this.o;
    }

    public synchronized void j() throws IOException {
        if (!this.n) {
            if (this.a.exists(this.e)) {
                if (this.a.exists(this.c)) {
                    this.a.delete(this.e);
                } else {
                    this.a.rename(this.e, this.c);
                }
            }
            if (this.a.exists(this.c)) {
                try {
                    n();
                    m();
                    this.n = true;
                    return;
                } catch (IOException e2) {
                    oq1 j2 = oq1.j();
                    j2.q(5, "DiskLruCache " + this.b + " is corrupt: " + e2.getMessage() + ", removing", e2);
                    f();
                    this.o = false;
                } catch (Throwable th) {
                    this.o = false;
                    throw th;
                }
            }
            p();
            this.n = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        int i2 = this.l;
        return i2 >= 2000 && i2 >= this.k.size();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b8, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b9, code lost:
        if (r0 != null) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bb, code lost:
        a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00be, code lost:
        throw r2;
     */
    public synchronized void p() throws IOException {
        BufferedSink bufferedSink = this.j;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        BufferedSink c2 = h.c(this.a.sink(this.d));
        c2.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
        c2.writeUtf8("1").writeByte(10);
        c2.writeDecimalLong((long) this.f).writeByte(10);
        c2.writeDecimalLong((long) this.h).writeByte(10);
        c2.writeByte(10);
        for (c cVar : this.k.values()) {
            if (cVar.f != null) {
                c2.writeUtf8("DIRTY").writeByte(32);
                c2.writeUtf8(cVar.a);
                c2.writeByte(10);
            } else {
                c2.writeUtf8("CLEAN").writeByte(32);
                c2.writeUtf8(cVar.a);
                cVar.d(c2);
                c2.writeByte(10);
            }
        }
        a(null, c2);
        if (this.a.exists(this.c)) {
            this.a.rename(this.c, this.e);
        }
        this.a.rename(this.d, this.c);
        this.a.delete(this.e);
        this.j = l();
        this.m = false;
        this.q = false;
    }

    public synchronized boolean q(String str) throws IOException {
        j();
        c();
        t(str);
        c cVar = this.k.get(str);
        if (cVar == null) {
            return false;
        }
        boolean r2 = r(cVar);
        if (r2 && this.i <= this.g) {
            this.p = false;
        }
        return r2;
    }

    /* access modifiers changed from: package-private */
    public boolean r(c cVar) throws IOException {
        b bVar = cVar.f;
        if (bVar != null) {
            bVar.c();
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            this.a.delete(cVar.c[i2]);
            long j2 = this.i;
            long[] jArr = cVar.b;
            this.i = j2 - jArr[i2];
            jArr[i2] = 0;
        }
        this.l++;
        this.j.writeUtf8("REMOVE").writeByte(32).writeUtf8(cVar.a).writeByte(10);
        this.k.remove(cVar.a);
        if (k()) {
            this.s.execute(this.t);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void s() throws IOException {
        while (this.i > this.g) {
            r(this.k.values().iterator().next());
        }
        this.p = false;
    }
}
