package com.amap.api.col.s;

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
public final class cw implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final Charset b = Charset.forName("US-ASCII");
    static final Charset c = Charset.forName("UTF-8");
    static ThreadPoolExecutor d;
    private static final ThreadFactory r;
    private static final OutputStream t = new OutputStream() {
        /* class com.amap.api.col.s.cw.AnonymousClass3 */

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
        }
    };
    private final File e;
    private final File f;
    private final File g;
    private final File h;
    private final int i;
    private long j;
    private final int k;
    private long l = 0;
    private Writer m;
    private int n = 1000;
    private final LinkedHashMap<String, c> o = new LinkedHashMap<>(0, 0.75f, true);
    private int p;
    private long q = 0;
    private final Callable<Void> s = new Callable<Void>() {
        /* class com.amap.api.col.s.cw.AnonymousClass2 */

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (cw.this) {
                if (cw.this.m == null) {
                    return null;
                }
                cw.this.k();
                if (cw.this.i()) {
                    cw.this.h();
                    cw.this.p = 0;
                }
                return null;
            }
        }
    };

    /* compiled from: Taobao */
    public final class a {
        private final c b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        /* renamed from: com.amap.api.col.s.cw$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        private class C0143a extends FilterOutputStream {
            /* synthetic */ C0143a(a aVar, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    a.this.d = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    a.this.d = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    a.this.d = true;
                }
            }

            private C0143a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    a.this.d = true;
                }
            }
        }

        /* synthetic */ a(cw cwVar, c cVar, byte b2) {
            this(cVar);
        }

        private a(c cVar) {
            this.b = cVar;
            this.c = cVar.d ? null : new boolean[cw.this.k];
        }

        public final OutputStream a() throws IOException {
            FileOutputStream fileOutputStream;
            C0143a aVar;
            if (cw.this.k > 0) {
                synchronized (cw.this) {
                    if (this.b.e == this) {
                        if (!this.b.d) {
                            this.c[0] = true;
                        }
                        File b2 = this.b.b(0);
                        try {
                            fileOutputStream = new FileOutputStream(b2);
                        } catch (FileNotFoundException unused) {
                            cw.this.e.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(b2);
                            } catch (FileNotFoundException unused2) {
                                return cw.t;
                            }
                        }
                        aVar = new C0143a(this, fileOutputStream, (byte) 0);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return aVar;
            }
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + cw.this.k);
        }

        public final void b() throws IOException {
            if (this.d) {
                cw.this.a((cw) this, (a) false);
                cw.this.c(this.b.b);
            } else {
                cw.this.a((cw) this, (a) true);
            }
            this.e = true;
        }

        public final void c() throws IOException {
            cw.this.a((cw) this, (a) false);
        }
    }

    /* compiled from: Taobao */
    public final class b implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        /* synthetic */ b(cw cwVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b2) {
            this(str, j, inputStreamArr, jArr);
        }

        public final InputStream a() {
            return this.d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.d) {
                cw.a(inputStream);
            }
        }

        private b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
            this.e = jArr;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class c {
        private final String b;
        private final long[] c;
        private boolean d;
        private a e;
        private long f;

        /* synthetic */ c(cw cwVar, String str, byte b2) {
            this(str);
        }

        private c(String str) {
            this.b = str;
            this.c = new long[cw.this.k];
        }

        public final File b(int i) {
            File file = cw.this.e;
            return new File(file, this.b + "." + i + ".tmp");
        }

        public final String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.c;
            for (long j : jArr) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        private static IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File a(int i) {
            File file = cw.this.e;
            return new File(file, this.b + "." + i);
        }

        static /* synthetic */ void a(c cVar, String[] strArr) throws IOException {
            if (strArr.length == cw.this.k) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        cVar.c[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }
    }

    static {
        AnonymousClass1 r8 = new ThreadFactory() {
            /* class com.amap.api.col.s.cw.AnonymousClass1 */
            private final AtomicInteger a = new AtomicInteger(1);

            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "disklrucache#" + this.a.getAndIncrement());
            }
        };
        r = r8;
        d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r8);
    }

    private cw(File file, long j2) {
        this.e = file;
        this.i = 1;
        this.f = new File(file, "journal");
        this.g = new File(file, "journal.tmp");
        this.h = new File(file, "journal.bkp");
        this.k = 1;
        this.j = j2;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void h() throws IOException {
        Writer writer = this.m;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.g), b));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write("1");
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.i));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.k));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(StringUtils.LF);
            for (c cVar : this.o.values()) {
                if (cVar.e != null) {
                    bufferedWriter.write("DIRTY " + cVar.b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.b + cVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f.exists()) {
                a(this.f, this.h, true);
            }
            a(this.g, this.f, false);
            this.h.delete();
            this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f, true), b));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean i() {
        int i2 = this.p;
        return i2 >= 2000 && i2 >= this.o.size();
    }

    private void j() {
        if (this.m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k() throws IOException {
        while (true) {
            if (this.l > this.j || this.o.size() > this.n) {
                c(this.o.entrySet().iterator().next().getKey());
            } else {
                return;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.m != null) {
            Iterator it = new ArrayList(this.o.values()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.e != null) {
                    cVar.e.c();
                }
            }
            k();
            this.m.close();
            this.m = null;
        }
    }

    private static ThreadPoolExecutor e() {
        try {
            ThreadPoolExecutor threadPoolExecutor = d;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return d;
    }

    private void f() throws IOException {
        String a2;
        String str;
        cx cxVar = new cx(new FileInputStream(this.f), b);
        try {
            String a3 = cxVar.a();
            String a4 = cxVar.a();
            String a5 = cxVar.a();
            String a6 = cxVar.a();
            String a7 = cxVar.a();
            if (!"libcore.io.DiskLruCache".equals(a3) || !"1".equals(a4) || !Integer.toString(this.i).equals(a5) || !Integer.toString(this.k).equals(a6) || !"".equals(a7)) {
                throw new IOException("unexpected journal header: [" + a3 + AVFSCacheConstants.COMMA_SEP + a4 + AVFSCacheConstants.COMMA_SEP + a6 + AVFSCacheConstants.COMMA_SEP + a7 + jl1.ARRAY_END_STR);
            }
            int i2 = 0;
            while (true) {
                try {
                    a2 = cxVar.a();
                    int indexOf = a2.indexOf(32);
                    if (indexOf != -1) {
                        int i3 = indexOf + 1;
                        int indexOf2 = a2.indexOf(32, i3);
                        if (indexOf2 == -1) {
                            str = a2.substring(i3);
                            if (indexOf == 6 && a2.startsWith("REMOVE")) {
                                this.o.remove(str);
                                i2++;
                            }
                        } else {
                            str = a2.substring(i3, indexOf2);
                        }
                        c cVar = this.o.get(str);
                        if (cVar == null) {
                            cVar = new c(this, str, (byte) 0);
                            this.o.put(str, cVar);
                        }
                        if (indexOf2 != -1 && indexOf == 5 && a2.startsWith("CLEAN")) {
                            String[] split = a2.substring(indexOf2 + 1).split(" ");
                            cVar.d = true;
                            cVar.e = null;
                            c.a(cVar, split);
                            i2++;
                        } else if (indexOf2 == -1 && indexOf == 5 && a2.startsWith("DIRTY")) {
                            cVar.e = new a(this, cVar, (byte) 0);
                            i2++;
                        } else if (indexOf2 == -1 && indexOf == 4 && a2.startsWith("READ")) {
                            i2++;
                        }
                    } else {
                        throw new IOException("unexpected journal line: ".concat(a2));
                    }
                } catch (EOFException unused) {
                    this.p = i2 - this.o.size();
                    return;
                }
            }
            throw new IOException("unexpected journal line: ".concat(a2));
        } finally {
            a(cxVar);
        }
    }

    private void g() throws IOException {
        a(this.g);
        Iterator<c> it = this.o.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i2 = 0;
            if (next.e == null) {
                while (i2 < this.k) {
                    this.l += next.c[i2];
                    i2++;
                }
            } else {
                next.e = null;
                while (i2 < this.k) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    public final a b(String str) throws IOException {
        return d(str);
    }

    public final synchronized boolean c(String str) throws IOException {
        j();
        e(str);
        c cVar = this.o.get(str);
        if (cVar != null) {
            if (cVar.e == null) {
                for (int i2 = 0; i2 < this.k; i2++) {
                    File a2 = cVar.a(i2);
                    if (a2.exists()) {
                        if (!a2.delete()) {
                            throw new IOException("failed to delete ".concat(String.valueOf(a2)));
                        }
                    }
                    this.l -= cVar.c[i2];
                    cVar.c[i2] = 0;
                }
                this.p++;
                this.m.append((CharSequence) ("REMOVE " + str + '\n'));
                this.o.remove(str);
                if (i()) {
                    e().submit(this.s);
                }
                return true;
            }
        }
        return false;
    }

    private synchronized a d(String str) throws IOException {
        j();
        e(str);
        c cVar = this.o.get(str);
        if (cVar == null) {
            cVar = new c(this, str, (byte) 0);
            this.o.put(str, cVar);
        } else if (cVar.e != null) {
            return null;
        }
        a aVar = new a(this, cVar, (byte) 0);
        cVar.e = aVar;
        Writer writer = this.m;
        writer.write("DIRTY " + str + '\n');
        this.m.flush();
        return aVar;
    }

    public final void a(int i2) {
        if (i2 < 10) {
            i2 = 10;
        } else if (i2 > 10000) {
            i2 = 10000;
        }
        this.n = i2;
    }

    public final synchronized void b() throws IOException {
        j();
        k();
        this.m.flush();
    }

    public static cw a(File file, long j2) throws IOException {
        if (j2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            cw cwVar = new cw(file, j2);
            if (cwVar.f.exists()) {
                try {
                    cwVar.f();
                    cwVar.g();
                    cwVar.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cwVar.f, true), b));
                    return cwVar;
                } catch (Throwable unused) {
                    cwVar.c();
                }
            }
            file.mkdirs();
            cw cwVar2 = new cw(file, j2);
            cwVar2.h();
            return cwVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private static void e(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }

    public final void c() throws IOException {
        close();
        b(this.e);
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized b a(String str) throws IOException {
        j();
        e(str);
        c cVar = this.o.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.d) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.k];
        int i2 = 0;
        for (int i3 = 0; i3 < this.k; i3++) {
            try {
                inputStreamArr[i3] = new FileInputStream(cVar.a(i3));
            } catch (FileNotFoundException unused) {
                while (i2 < this.k && inputStreamArr[i2] != null) {
                    a(inputStreamArr[i2]);
                    i2++;
                }
                return null;
            }
        }
        this.p++;
        this.m.append((CharSequence) ("READ " + str + '\n'));
        if (i()) {
            e().submit(this.s);
        }
        return new b(this, str, cVar.f, inputStreamArr, cVar.c, (byte) 0);
    }

    public final File a() {
        return this.e;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void a(a aVar, boolean z) throws IOException {
        c cVar = aVar.b;
        if (cVar.e == aVar) {
            if (z && !cVar.d) {
                for (int i2 = 0; i2 < this.k; i2++) {
                    if (!aVar.c[i2]) {
                        aVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i2)));
                    } else if (!cVar.b(i2).exists()) {
                        aVar.c();
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < this.k; i3++) {
                File b2 = cVar.b(i3);
                if (!z) {
                    a(b2);
                } else if (b2.exists()) {
                    File a2 = cVar.a(i3);
                    b2.renameTo(a2);
                    long j2 = cVar.c[i3];
                    long length = a2.length();
                    cVar.c[i3] = length;
                    this.l = (this.l - j2) + length;
                }
            }
            this.p++;
            cVar.e = null;
            if (cVar.d || z) {
                cVar.d = true;
                this.m.write("CLEAN " + cVar.b + cVar.a() + '\n');
                if (z) {
                    long j3 = this.q;
                    this.q = 1 + j3;
                    cVar.f = j3;
                }
            } else {
                this.o.remove(cVar.b);
                this.m.write("REMOVE " + cVar.b + '\n');
            }
            this.m.flush();
            if (this.l > this.j || i()) {
                e().submit(this.s);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }
}
