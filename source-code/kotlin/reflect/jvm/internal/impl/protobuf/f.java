package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class f extends ByteString {
    private static final int[] g;
    private final int a;
    private final ByteString b;
    private final ByteString c;
    private final int d;
    private final int e;
    private int f;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private final Stack<ByteString> a;

        private b() {
            this.a = new Stack<>();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString pop = this.a.pop();
            while (!this.a.isEmpty()) {
                pop = new f(this.a.pop(), pop);
            }
            return pop;
        }

        private void c(ByteString byteString) {
            if (byteString.j()) {
                e(byteString);
            } else if (byteString instanceof f) {
                f fVar = (f) byteString;
                c(fVar.b);
                c(fVar.c);
            } else {
                String valueOf = String.valueOf(byteString.getClass());
                StringBuilder sb = new StringBuilder(valueOf.length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        private int d(int i) {
            int binarySearch = Arrays.binarySearch(f.g, i);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void e(ByteString byteString) {
            int d = d(byteString.size());
            int i = f.g[d + 1];
            if (this.a.isEmpty() || this.a.peek().size() >= i) {
                this.a.push(byteString);
                return;
            }
            int i2 = f.g[d];
            ByteString pop = this.a.pop();
            while (!this.a.isEmpty() && this.a.peek().size() < i2) {
                pop = new f(this.a.pop(), pop);
            }
            f fVar = new f(pop, byteString);
            while (!this.a.isEmpty()) {
                if (this.a.peek().size() >= f.g[d(fVar.size()) + 1]) {
                    break;
                }
                fVar = new f(this.a.pop(), fVar);
            }
            this.a.push(fVar);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c implements Iterator<e> {
        private final Stack<f> a;
        private e b;

        private e a(ByteString byteString) {
            while (byteString instanceof f) {
                f fVar = (f) byteString;
                this.a.push(fVar);
                byteString = fVar.b;
            }
            return (e) byteString;
        }

        private e b() {
            while (!this.a.isEmpty()) {
                e a2 = a(this.a.pop().c);
                if (!a2.isEmpty()) {
                    return a2;
                }
            }
            return null;
        }

        /* renamed from: c */
        public e next() {
            e eVar = this.b;
            if (eVar != null) {
                this.b = b();
                return eVar;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.b != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private c(ByteString byteString) {
            this.a = new Stack<>();
            this.b = a(byteString);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class d implements ByteString.ByteIterator {
        private final c a;
        private ByteString.ByteIterator b;
        int c;

        /* renamed from: a */
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        public boolean hasNext() {
            return this.c > 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            if (!this.b.hasNext()) {
                this.b = this.a.next().iterator();
            }
            this.c--;
            return this.b.nextByte();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private d(f fVar) {
            c cVar = new c(fVar);
            this.a = cVar;
            this.b = cVar.next().iterator();
            this.c = fVar.size();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        g = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = g;
            if (i4 < iArr.length) {
                iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
                i4++;
            } else {
                return;
            }
        }
    }

    private static e A(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.g(bArr, 0, 0, size);
        byteString2.g(bArr, 0, size, size2);
        return new e(bArr);
    }

    private boolean B(ByteString byteString) {
        c cVar = new c(this);
        e eVar = (e) cVar.next();
        c cVar2 = new c(byteString);
        e eVar2 = (e) cVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = eVar.size() - i;
            int size2 = eVar2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? eVar.x(eVar2, i2, min) : eVar2.x(eVar, i, min))) {
                return false;
            }
            i3 += min;
            int i4 = this.a;
            if (i3 < i4) {
                if (min == size) {
                    eVar = (e) cVar.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    eVar2 = (e) cVar2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    static ByteString z(ByteString byteString, ByteString byteString2) {
        f fVar = byteString instanceof f ? (f) byteString : null;
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() != 0) {
            int size = byteString.size() + byteString2.size();
            if (size < 128) {
                return A(byteString, byteString2);
            }
            if (fVar != null && fVar.c.size() + byteString2.size() < 128) {
                byteString2 = new f(fVar.b, A(fVar.c, byteString2));
            } else if (fVar == null || fVar.b.i() <= fVar.c.i() || fVar.i() <= byteString2.i()) {
                if (size >= g[Math.max(byteString.i(), byteString2.i()) + 1]) {
                    return new f(byteString, byteString2);
                }
                return new b().b(byteString, byteString2);
            } else {
                byteString2 = new f(fVar.b, new f(fVar.c, byteString2));
            }
        }
        return byteString2;
    }

    public boolean equals(Object obj) {
        int q;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.a != byteString.size()) {
            return false;
        }
        if (this.a == 0) {
            return true;
        }
        if (this.f == 0 || (q = byteString.q()) == 0 || this.f == q) {
            return B(byteString);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void h(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.d;
        if (i4 <= i5) {
            this.b.h(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.c.h(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.b.h(bArr, i, i2, i6);
            this.c.h(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    public int hashCode() {
        int i = this.f;
        if (i == 0) {
            int i2 = this.a;
            i = o(i2, 0, i2);
            if (i == 0) {
                i = 1;
            }
            this.f = i;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int i() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean j() {
        return this.a >= g[this.e];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean k() {
        int p = this.b.p(0, 0, this.d);
        ByteString byteString = this.c;
        if (byteString.p(p, 0, byteString.size()) == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    /* renamed from: l */
    public ByteString.ByteIterator iterator() {
        return new d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream m() {
        return CodedInputStream.g(new e());
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int o(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.d;
        if (i4 <= i5) {
            return this.b.o(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.c.o(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.c.o(this.b.o(i, i2, i6), 0, i3 - i6);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int p(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.d;
        if (i4 <= i5) {
            return this.b.p(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.c.p(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.c.p(this.b.p(i, i2, i6), 0, i3 - i6);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int q() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String s(String str) throws UnsupportedEncodingException {
        return new String(r(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void v(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.d;
        if (i3 <= i4) {
            this.b.v(outputStream, i, i2);
        } else if (i >= i4) {
            this.c.v(outputStream, i - i4, i2);
        } else {
            int i5 = i4 - i;
            this.b.v(outputStream, i, i5);
            this.c.v(outputStream, 0, i2 - i5);
        }
    }

    private f(ByteString byteString, ByteString byteString2) {
        this.f = 0;
        this.b = byteString;
        this.c = byteString2;
        int size = byteString.size();
        this.d = size;
        this.a = size + byteString2.size();
        this.e = Math.max(byteString.i(), byteString2.i()) + 1;
    }

    /* compiled from: Taobao */
    private class e extends InputStream {
        private c a;
        private e b;
        private int c;
        private int d;
        private int e;
        private int f;

        public e() {
            c();
        }

        private void a() {
            int i;
            if (this.b != null && this.d == (i = this.c)) {
                this.e += i;
                this.d = 0;
                if (this.a.hasNext()) {
                    e c2 = this.a.next();
                    this.b = c2;
                    this.c = c2.size();
                    return;
                }
                this.b = null;
                this.c = 0;
            }
        }

        private void c() {
            c cVar = new c(f.this);
            this.a = cVar;
            e c2 = cVar.next();
            this.b = c2;
            this.c = c2.size();
            this.d = 0;
            this.e = 0;
        }

        private int d(byte[] bArr, int i, int i2) {
            int i3 = i2;
            while (true) {
                if (i3 <= 0) {
                    break;
                }
                a();
                if (this.b != null) {
                    int min = Math.min(this.c - this.d, i3);
                    if (bArr != null) {
                        this.b.g(bArr, this.d, i, min);
                        i += min;
                    }
                    this.d += min;
                    i3 -= min;
                } else if (i3 == i2) {
                    return -1;
                }
            }
            return i2 - i3;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return f.this.size() - (this.e + this.d);
        }

        public void mark(int i) {
            this.f = this.e + this.d;
        }

        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            Objects.requireNonNull(bArr);
            if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
                return d(bArr, i, i2);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            c();
            d(null, 0, this.f);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (j >= 0) {
                if (j > 2147483647L) {
                    j = 2147483647L;
                }
                return (long) d(null, 0, (int) j);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            a();
            e eVar = this.b;
            if (eVar == null) {
                return -1;
            }
            int i = this.d;
            this.d = i + 1;
            return eVar.w(i) & 255;
        }
    }
}
