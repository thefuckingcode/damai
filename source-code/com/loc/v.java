package com.loc;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import tb.jl1;

/* compiled from: Taobao */
public final class v implements Closeable {
    public static final Charset b = Charset.forName("US-ASCII");
    static final Pattern p = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final ThreadFactory q;
    static ThreadPoolExecutor r;
    private static final OutputStream s = new c();
    private final File a;
    private final File c;
    private final File d;
    private final File e;
    private final int f;
    private long g;
    private final int h;
    private long i = 0;
    private Writer j;
    private int k = 1000;
    private final LinkedHashMap<String, f> l = new LinkedHashMap<>(0, 0.75f, true);
    private int m;
    private long n = 0;
    private final Callable<Void> o = new b();

    /* compiled from: Taobao */
    static class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.a.getAndIncrement());
        }
    }

    /* compiled from: Taobao */
    class b implements Callable<Void> {
        b() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (v.this) {
                if (v.this.j == null) {
                    return null;
                }
                v.this.G();
                if (v.this.E()) {
                    v.this.D();
                    v.this.m = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    static class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
        }
    }

    /* compiled from: Taobao */
    public final class d {
        private final f a;
        private final boolean[] b;
        private boolean c;

        /* compiled from: Taobao */
        private class a extends FilterOutputStream {
            private a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ a(d dVar, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    d.this.c = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    d.this.c = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    d.this.c = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    d.this.c = true;
                }
            }
        }

        private d(f fVar) {
            this.a = fVar;
            this.b = fVar.c ? null : new boolean[v.this.h];
        }

        /* synthetic */ d(v vVar, f fVar, byte b2) {
            this(fVar);
        }

        public final OutputStream b() throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (v.this.h > 0) {
                synchronized (v.this) {
                    if (this.a.d == this) {
                        if (!this.a.c) {
                            this.b[0] = true;
                        }
                        File i = this.a.i(0);
                        try {
                            fileOutputStream = new FileOutputStream(i);
                        } catch (FileNotFoundException unused) {
                            v.this.a.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(i);
                            } catch (FileNotFoundException unused2) {
                                return v.s;
                            }
                        }
                        aVar = new a(this, fileOutputStream, (byte) 0);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return aVar;
            }
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + v.this.h);
        }

        public final void c() throws IOException {
            if (this.c) {
                v.this.g(this, false);
                v.this.r(this.a.a);
                return;
            }
            v.this.g(this, true);
        }

        public final void e() throws IOException {
            v.this.g(this, false);
        }
    }

    /* compiled from: Taobao */
    public final class e implements Closeable {
        private final InputStream[] a;

        private e(v vVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.a = inputStreamArr;
        }

        /* synthetic */ e(v vVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(vVar, str, j, inputStreamArr, jArr);
        }

        public final InputStream a() {
            return this.a[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.a) {
                v.i(inputStream);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class f {
        private final String a;
        private final long[] b;
        private boolean c;
        private d d;
        private long e;

        private f(String str) {
            this.a = str;
            this.b = new long[v.this.h];
        }

        /* synthetic */ f(v vVar, String str, byte b2) {
            this(str);
        }

        private static IOException d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ void f(f fVar, String[] strArr) throws IOException {
            if (strArr.length == v.this.h) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        fVar.b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw d(strArr);
                    }
                }
                return;
            }
            throw d(strArr);
        }

        public final File c(int i) {
            File file = v.this.a;
            return new File(file, this.a + "." + i);
        }

        public final String e() throws IOException {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.b;
            for (long j : jArr) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final File i(int i) {
            File file = v.this.a;
            return new File(file, this.a + "." + i + ".tmp");
        }
    }

    static {
        Charset.forName("UTF-8");
        a aVar = new a();
        q = aVar;
        r = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
    }

    private v(File file, long j2) {
        this.a = file;
        this.f = 1;
        this.c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.e = new File(file, "journal.bkp");
        this.h = 1;
        this.g = j2;
    }

    private void B() throws IOException {
        String a2;
        String str;
        w wVar = new w(new FileInputStream(this.c), b);
        try {
            String a3 = wVar.a();
            String a4 = wVar.a();
            String a5 = wVar.a();
            String a6 = wVar.a();
            String a7 = wVar.a();
            if (!"libcore.io.DiskLruCache".equals(a3) || !"1".equals(a4) || !Integer.toString(this.f).equals(a5) || !Integer.toString(this.h).equals(a6) || !"".equals(a7)) {
                throw new IOException("unexpected journal header: [" + a3 + AVFSCacheConstants.COMMA_SEP + a4 + AVFSCacheConstants.COMMA_SEP + a6 + AVFSCacheConstants.COMMA_SEP + a7 + jl1.ARRAY_END_STR);
            }
            int i2 = 0;
            while (true) {
                try {
                    a2 = wVar.a();
                    int indexOf = a2.indexOf(32);
                    if (indexOf != -1) {
                        int i3 = indexOf + 1;
                        int indexOf2 = a2.indexOf(32, i3);
                        if (indexOf2 == -1) {
                            str = a2.substring(i3);
                            if (indexOf == 6 && a2.startsWith("REMOVE")) {
                                this.l.remove(str);
                                i2++;
                            }
                        } else {
                            str = a2.substring(i3, indexOf2);
                        }
                        f fVar = this.l.get(str);
                        if (fVar == null) {
                            fVar = new f(this, str, (byte) 0);
                            this.l.put(str, fVar);
                        }
                        if (indexOf2 != -1 && indexOf == 5 && a2.startsWith("CLEAN")) {
                            String[] split = a2.substring(indexOf2 + 1).split(" ");
                            fVar.c = true;
                            fVar.d = null;
                            f.f(fVar, split);
                            i2++;
                        } else if (indexOf2 == -1 && indexOf == 5 && a2.startsWith("DIRTY")) {
                            fVar.d = new d(this, fVar, (byte) 0);
                            i2++;
                        } else if (indexOf2 == -1 && indexOf == 4 && a2.startsWith("READ")) {
                            i2++;
                        }
                    } else {
                        throw new IOException("unexpected journal line: ".concat(a2));
                    }
                } catch (EOFException unused) {
                    this.m = i2 - this.l.size();
                    return;
                }
            }
            throw new IOException("unexpected journal line: ".concat(a2));
        } finally {
            i(wVar);
        }
    }

    private void C() throws IOException {
        j(this.d);
        Iterator<f> it = this.l.values().iterator();
        while (it.hasNext()) {
            f next = it.next();
            int i2 = 0;
            if (next.d == null) {
                while (i2 < this.h) {
                    this.i += next.b[i2];
                    i2++;
                }
            } else {
                next.d = null;
                while (i2 < this.h) {
                    j(next.c(i2));
                    j(next.i(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void D() throws IOException {
        Writer writer = this.j;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d), b));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write("1");
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.f));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.h));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(StringUtils.LF);
            for (f fVar : this.l.values()) {
                bufferedWriter.write(fVar.d != null ? "DIRTY " + fVar.a + '\n' : "CLEAN " + fVar.a + fVar.e() + '\n');
            }
            bufferedWriter.close();
            if (this.c.exists()) {
                k(this.c, this.e, true);
            }
            k(this.d, this.c, false);
            this.e.delete();
            this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), b));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean E() {
        int i2 = this.m;
        return i2 >= 2000 && i2 >= this.l.size();
    }

    private void F() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void G() throws IOException {
        while (true) {
            if (this.i > this.g || this.l.size() > this.k) {
                r(this.l.entrySet().iterator().next().getKey());
            } else {
                return;
            }
        }
    }

    public static v b(File file, long j2) throws IOException {
        if (j2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    k(file2, file3, false);
                }
            }
            v vVar = new v(file, j2);
            if (vVar.c.exists()) {
                try {
                    vVar.B();
                    vVar.C();
                    vVar.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(vVar.c, true), b));
                    return vVar;
                } catch (Throwable unused) {
                    vVar.t();
                }
            }
            file.mkdirs();
            v vVar2 = new v(file, j2);
            vVar2.D();
            return vVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void e() {
        ThreadPoolExecutor threadPoolExecutor = r;
        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
            r.shutdown();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void g(d dVar, boolean z) throws IOException {
        f fVar = dVar.a;
        if (fVar.d == dVar) {
            if (z && !fVar.c) {
                for (int i2 = 0; i2 < this.h; i2++) {
                    if (!dVar.b[i2]) {
                        dVar.e();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i2)));
                    } else if (!fVar.i(i2).exists()) {
                        dVar.e();
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < this.h; i3++) {
                File i4 = fVar.i(i3);
                if (!z) {
                    j(i4);
                } else if (i4.exists()) {
                    File c2 = fVar.c(i3);
                    i4.renameTo(c2);
                    long j2 = fVar.b[i3];
                    long length = c2.length();
                    fVar.b[i3] = length;
                    this.i = (this.i - j2) + length;
                }
            }
            this.m++;
            fVar.d = null;
            if (fVar.c || z) {
                fVar.c = true;
                this.j.write("CLEAN " + fVar.a + fVar.e() + '\n');
                if (z) {
                    long j3 = this.n;
                    this.n = 1 + j3;
                    fVar.e = j3;
                }
            } else {
                this.l.remove(fVar.a);
                this.j.write("REMOVE " + fVar.a + '\n');
            }
            this.j.flush();
            if (this.i > this.g || E()) {
                z().submit(this.o);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public static void i(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static void j(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void k(File file, File file2, boolean z) throws IOException {
        if (z) {
            j(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private static void o(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    o(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }

    private synchronized d s(String str) throws IOException {
        F();
        x(str);
        f fVar = this.l.get(str);
        if (fVar == null) {
            fVar = new f(this, str, (byte) 0);
            this.l.put(str, fVar);
        } else if (fVar.d != null) {
            return null;
        }
        d dVar = new d(this, fVar, (byte) 0);
        fVar.d = dVar;
        Writer writer = this.j;
        writer.write("DIRTY " + str + '\n');
        this.j.flush();
        return dVar;
    }

    private static void x(String str) {
        if (!p.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private static ThreadPoolExecutor z() {
        try {
            ThreadPoolExecutor threadPoolExecutor = r;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                r = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), q);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return r;
    }

    public final synchronized e a(String str) throws IOException {
        F();
        x(str);
        f fVar = this.l.get(str);
        if (fVar == null) {
            return null;
        }
        if (!fVar.c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.h];
        int i2 = 0;
        for (int i3 = 0; i3 < this.h; i3++) {
            try {
                inputStreamArr[i3] = new FileInputStream(fVar.c(i3));
            } catch (FileNotFoundException unused) {
                while (i2 < this.h && inputStreamArr[i2] != null) {
                    i(inputStreamArr[i2]);
                    i2++;
                }
                return null;
            }
        }
        this.m++;
        this.j.append((CharSequence) ("READ " + str + '\n'));
        if (E()) {
            z().submit(this.o);
        }
        return new e(this, str, fVar.e, inputStreamArr, fVar.b, (byte) 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.j != null) {
            Iterator it = new ArrayList(this.l.values()).iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (fVar.d != null) {
                    fVar.d.e();
                }
            }
            G();
            this.j.close();
            this.j = null;
        }
    }

    public final void f(int i2) {
        if (i2 < 10) {
            i2 = 10;
        } else if (i2 > 10000) {
            i2 = 10000;
        }
        this.k = i2;
    }

    public final d l(String str) throws IOException {
        return s(str);
    }

    public final File m() {
        return this.a;
    }

    public final synchronized void p() throws IOException {
        F();
        G();
        this.j.flush();
    }

    public final synchronized boolean r(String str) throws IOException {
        F();
        x(str);
        f fVar = this.l.get(str);
        if (fVar != null) {
            if (fVar.d == null) {
                for (int i2 = 0; i2 < this.h; i2++) {
                    File c2 = fVar.c(i2);
                    if (c2.exists()) {
                        if (!c2.delete()) {
                            throw new IOException("failed to delete ".concat(String.valueOf(c2)));
                        }
                    }
                    this.i -= fVar.b[i2];
                    fVar.b[i2] = 0;
                }
                this.m++;
                this.j.append((CharSequence) ("REMOVE " + str + '\n'));
                this.l.remove(str);
                if (E()) {
                    z().submit(this.o);
                }
                return true;
            }
        }
        return false;
    }

    public final void t() throws IOException {
        close();
        o(this.a);
    }
}
