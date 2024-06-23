package okhttp3.internal.http2;

import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.runtimepermission.PermissionChecker;
import cn.damai.login.authlogin.req.GetAuthorizationTokenRequest;
import com.taobao.weex.adapter.URIAdapter;
import com.youku.network.HttpIntent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import mtopsdk.common.util.HttpHeaderConstant;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.h;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class b {
    static final a[] a;
    static final Map<ByteString, Integer> b = b();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class a {
        private final List<a> a;
        private final BufferedSource b;
        private final int c;
        private int d;
        a[] e;
        int f;
        int g;
        int h;

        a(int i, Source source) {
            this(i, i, source);
        }

        private void a() {
            int i = this.d;
            int i2 = this.h;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                b();
            } else {
                d(i2 - i);
            }
        }

        private void b() {
            Arrays.fill(this.e, (Object) null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private int c(int i) {
            return this.f + 1 + i;
        }

        private int d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.e.length;
                while (true) {
                    length--;
                    i2 = this.f;
                    if (length < i2 || i <= 0) {
                        a[] aVarArr = this.e;
                        System.arraycopy(aVarArr, i2 + 1, aVarArr, i2 + 1 + i3, this.g);
                        this.f += i3;
                    } else {
                        a[] aVarArr2 = this.e;
                        i -= aVarArr2[length].c;
                        this.h -= aVarArr2[length].c;
                        this.g--;
                        i3++;
                    }
                }
                a[] aVarArr3 = this.e;
                System.arraycopy(aVarArr3, i2 + 1, aVarArr3, i2 + 1 + i3, this.g);
                this.f += i3;
            }
            return i3;
        }

        private ByteString f(int i) throws IOException {
            if (h(i)) {
                return b.a[i].a;
            }
            int c2 = c(i - b.a.length);
            if (c2 >= 0) {
                a[] aVarArr = this.e;
                if (c2 < aVarArr.length) {
                    return aVarArr[c2].a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void g(int i, a aVar) {
            this.a.add(aVar);
            int i2 = aVar.c;
            if (i != -1) {
                i2 -= this.e[c(i)].c;
            }
            int i3 = this.d;
            if (i2 > i3) {
                b();
                return;
            }
            int d2 = d((this.h + i2) - i3);
            if (i == -1) {
                int i4 = this.g + 1;
                a[] aVarArr = this.e;
                if (i4 > aVarArr.length) {
                    a[] aVarArr2 = new a[(aVarArr.length * 2)];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f = this.e.length - 1;
                    this.e = aVarArr2;
                }
                int i5 = this.f;
                this.f = i5 - 1;
                this.e[i5] = aVar;
                this.g++;
            } else {
                this.e[i + c(i) + d2] = aVar;
            }
            this.h += i2;
        }

        private boolean h(int i) {
            return i >= 0 && i <= b.a.length - 1;
        }

        private int i() throws IOException {
            return this.b.readByte() & 255;
        }

        private void l(int i) throws IOException {
            if (h(i)) {
                this.a.add(b.a[i]);
                return;
            }
            int c2 = c(i - b.a.length);
            if (c2 >= 0) {
                a[] aVarArr = this.e;
                if (c2 < aVarArr.length) {
                    this.a.add(aVarArr[c2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void n(int i) throws IOException {
            g(-1, new a(f(i), j()));
        }

        private void o() throws IOException {
            g(-1, new a(b.a(j()), j()));
        }

        private void p(int i) throws IOException {
            this.a.add(new a(f(i), j()));
        }

        private void q() throws IOException {
            this.a.add(new a(b.a(j()), j()));
        }

        public List<a> e() {
            ArrayList arrayList = new ArrayList(this.a);
            this.a.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public ByteString j() throws IOException {
            int i = i();
            boolean z = (i & 128) == 128;
            int m = m(i, 127);
            if (z) {
                return ByteString.of(g.f().c(this.b.readByteArray((long) m)));
            }
            return this.b.readByteString((long) m);
        }

        /* access modifiers changed from: package-private */
        public void k() throws IOException {
            while (!this.b.exhausted()) {
                int readByte = this.b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    l(m(readByte, 127) - 1);
                } else if (readByte == 64) {
                    o();
                } else if ((readByte & 64) == 64) {
                    n(m(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m = m(readByte, 31);
                    this.d = m;
                    if (m < 0 || m > this.c) {
                        throw new IOException("Invalid dynamic table size update " + this.d);
                    }
                    a();
                } else if (readByte == 16 || readByte == 0) {
                    q();
                } else {
                    p(m(readByte, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int m(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = i();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        a(int i, int i2, Source source) {
            this.a = new ArrayList();
            a[] aVarArr = new a[8];
            this.e = aVarArr;
            this.f = aVarArr.length - 1;
            this.g = 0;
            this.h = 0;
            this.c = i;
            this.d = i2;
            this.b = h.d(source);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: okhttp3.internal.http2.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0294b {
        private final Buffer a;
        private final boolean b;
        private int c;
        private boolean d;
        int e;
        a[] f;
        int g;
        int h;
        int i;

        C0294b(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void a() {
            int i2 = this.e;
            int i3 = this.i;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                b();
            } else {
                c(i3 - i2);
            }
        }

        private void b() {
            Arrays.fill(this.f, (Object) null);
            this.g = this.f.length - 1;
            this.h = 0;
            this.i = 0;
        }

        private int c(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f.length;
                while (true) {
                    length--;
                    i3 = this.g;
                    if (length < i3 || i2 <= 0) {
                        a[] aVarArr = this.f;
                        System.arraycopy(aVarArr, i3 + 1, aVarArr, i3 + 1 + i4, this.h);
                        a[] aVarArr2 = this.f;
                        int i5 = this.g;
                        Arrays.fill(aVarArr2, i5 + 1, i5 + 1 + i4, (Object) null);
                        this.g += i4;
                    } else {
                        a[] aVarArr3 = this.f;
                        i2 -= aVarArr3[length].c;
                        this.i -= aVarArr3[length].c;
                        this.h--;
                        i4++;
                    }
                }
                a[] aVarArr4 = this.f;
                System.arraycopy(aVarArr4, i3 + 1, aVarArr4, i3 + 1 + i4, this.h);
                a[] aVarArr22 = this.f;
                int i52 = this.g;
                Arrays.fill(aVarArr22, i52 + 1, i52 + 1 + i4, (Object) null);
                this.g += i4;
            }
            return i4;
        }

        private void d(a aVar) {
            int i2 = aVar.c;
            int i3 = this.e;
            if (i2 > i3) {
                b();
                return;
            }
            c((this.i + i2) - i3);
            int i4 = this.h + 1;
            a[] aVarArr = this.f;
            if (i4 > aVarArr.length) {
                a[] aVarArr2 = new a[(aVarArr.length * 2)];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.g = this.f.length - 1;
                this.f = aVarArr2;
            }
            int i5 = this.g;
            this.g = i5 - 1;
            this.f[i5] = aVar;
            this.h++;
            this.i += i2;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2) {
            int min = Math.min(i2, 16384);
            int i3 = this.e;
            if (i3 != min) {
                if (min < i3) {
                    this.c = Math.min(this.c, min);
                }
                this.d = true;
                this.e = min;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void f(ByteString byteString) throws IOException {
            if (!this.b || g.f().e(byteString) >= byteString.size()) {
                h(byteString.size(), 127, 0);
                this.a.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            g.f().d(byteString, buffer);
            ByteString readByteString = buffer.readByteString();
            h(readByteString.size(), 127, 128);
            this.a.write(readByteString);
        }

        /* access modifiers changed from: package-private */
        public void g(List<a> list) throws IOException {
            int i2;
            int i3;
            if (this.d) {
                int i4 = this.c;
                if (i4 < this.e) {
                    h(i4, 31, 32);
                }
                this.d = false;
                this.c = Integer.MAX_VALUE;
                h(this.e, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                a aVar = list.get(i5);
                ByteString asciiLowercase = aVar.a.toAsciiLowercase();
                ByteString byteString = aVar.b;
                Integer num = b.b.get(asciiLowercase);
                if (num != null) {
                    i3 = num.intValue() + 1;
                    if (i3 > 1 && i3 < 8) {
                        a[] aVarArr = b.a;
                        if (Objects.equals(aVarArr[i3 - 1].b, byteString)) {
                            i2 = i3;
                        } else if (Objects.equals(aVarArr[i3].b, byteString)) {
                            i2 = i3;
                            i3++;
                        }
                    }
                    i2 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                if (i3 == -1) {
                    int i6 = this.g + 1;
                    int length = this.f.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (Objects.equals(this.f[i6].a, asciiLowercase)) {
                            if (Objects.equals(this.f[i6].b, byteString)) {
                                i3 = b.a.length + (i6 - this.g);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i6 - this.g) + b.a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i3 != -1) {
                    h(i3, 127, 128);
                } else if (i2 == -1) {
                    this.a.writeByte(64);
                    f(asciiLowercase);
                    f(byteString);
                    d(aVar);
                } else if (!asciiLowercase.startsWith(a.PSEUDO_PREFIX) || a.TARGET_AUTHORITY.equals(asciiLowercase)) {
                    h(i2, 63, 64);
                    f(byteString);
                    d(aVar);
                } else {
                    h(i2, 15, 0);
                    f(byteString);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.a.writeByte(i2 | i4);
                return;
            }
            this.a.writeByte(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.a.writeByte(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.a.writeByte(i5);
        }

        C0294b(int i2, boolean z, Buffer buffer) {
            this.c = Integer.MAX_VALUE;
            a[] aVarArr = new a[8];
            this.f = aVarArr;
            this.g = aVarArr.length - 1;
            this.h = 0;
            this.i = 0;
            this.e = i2;
            this.b = z;
            this.a = buffer;
        }
    }

    static {
        ByteString byteString = a.TARGET_METHOD;
        ByteString byteString2 = a.TARGET_PATH;
        ByteString byteString3 = a.TARGET_SCHEME;
        ByteString byteString4 = a.RESPONSE_STATUS;
        a = new a[]{new a(a.TARGET_AUTHORITY, ""), new a(byteString, "GET"), new a(byteString, "POST"), new a(byteString2, "/"), new a(byteString2, "/index.html"), new a(byteString3, "http"), new a(byteString3, "https"), new a(byteString4, "200"), new a(byteString4, "204"), new a(byteString4, "206"), new a(byteString4, "304"), new a(byteString4, "400"), new a(byteString4, "404"), new a(byteString4, "500"), new a("accept-charset", ""), new a("accept-encoding", "gzip, deflate"), new a("accept-language", ""), new a("accept-ranges", ""), new a("accept", ""), new a("access-control-allow-origin", ""), new a("age", ""), new a(PermissionChecker.PERMISSION_ALLOW, ""), new a(GetAuthorizationTokenRequest.ACTION_AUTHORIZATION, ""), new a("cache-control", ""), new a("content-disposition", ""), new a(HttpHeaderConstant.CONTENT_ENCODING, ""), new a("content-language", ""), new a("content-length", ""), new a("content-location", ""), new a("content-range", ""), new a("content-type", ""), new a(HttpIntent.COOKIE, ""), new a("date", ""), new a("etag", ""), new a("expect", ""), new a(HttpConnector.EXPIRES, ""), new a("from", ""), new a("host", ""), new a("if-match", ""), new a(HttpHeaderConstant.IF_MODIFIED_SINCE, ""), new a(HttpHeaderConstant.IF_NONE_MATCH, ""), new a("if-range", ""), new a("if-unmodified-since", ""), new a("last-modified", ""), new a(URIAdapter.LINK, ""), new a("location", ""), new a("max-forwards", ""), new a("proxy-authenticate", ""), new a("proxy-authorization", ""), new a("range", ""), new a("referer", ""), new a("refresh", ""), new a("retry-after", ""), new a("server", ""), new a("set-cookie", ""), new a("strict-transport-security", ""), new a("transfer-encoding", ""), new a("user-agent", ""), new a("vary", ""), new a("via", ""), new a("www-authenticate", "")};
    }

    static ByteString a(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b2 = byteString.getByte(i);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        int i = 0;
        while (true) {
            a[] aVarArr = a;
            if (i >= aVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(aVarArr[i].a)) {
                linkedHashMap.put(aVarArr[i].a, Integer.valueOf(i));
            }
            i++;
        }
    }
}
