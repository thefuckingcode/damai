package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.commons.lang3.CharUtils;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class b extends JsonReader {
    private static final ByteString n = ByteString.encodeUtf8("'\\");
    private static final ByteString o = ByteString.encodeUtf8("\"\\");
    private static final ByteString p = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString q = ByteString.encodeUtf8("\n\r");
    private static final ByteString r = ByteString.encodeUtf8("*/");
    private final BufferedSource h;
    private final Buffer i;
    private int j = 0;
    private long k;
    private int l;
    @Nullable
    private String m;

    b(BufferedSource bufferedSource) {
        Objects.requireNonNull(bufferedSource, "source == null");
        this.h = bufferedSource;
        this.i = bufferedSource.buffer();
        r(6);
    }

    private boolean A(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (!(i2 == 47 || i2 == 61)) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        x();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r6.i.skip((long) (r3 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r1 != 47) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.h.request(2) != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        x();
        r3 = r6.i.getByte(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r3 == 42) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r3 == 47) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        r6.i.readByte();
        r6.i.readByte();
        J();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r6.i.readByte();
        r6.i.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (I() == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        throw w("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (r1 != 35) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        x();
        J();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
        return r1;
     */
    private int B(boolean z) throws IOException {
        while (true) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (this.h.request((long) i3)) {
                    byte b = this.i.getByte((long) i2);
                    if (b != 10 && b != 32 && b != 13 && b != 9) {
                        break;
                    }
                    i2 = i3;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input");
                }
            }
        }
    }

    private String C(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.h.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw w("Unterminated string");
            } else if (this.i.getByte(indexOfElement) == 92) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.i.readUtf8(indexOfElement));
                this.i.readByte();
                sb.append(G());
            } else if (sb == null) {
                String readUtf8 = this.i.readUtf8(indexOfElement);
                this.i.readByte();
                return readUtf8;
            } else {
                sb.append(this.i.readUtf8(indexOfElement));
                this.i.readByte();
                return sb.toString();
            }
        }
    }

    private String D() throws IOException {
        long indexOfElement = this.h.indexOfElement(p);
        return indexOfElement != -1 ? this.i.readUtf8(indexOfElement) : this.i.readUtf8();
    }

    private int E() throws IOException {
        String str;
        String str2;
        int i2;
        byte b = this.i.getByte(0);
        if (b == 116 || b == 84) {
            i2 = 5;
            str2 = "true";
            str = "TRUE";
        } else if (b == 102 || b == 70) {
            i2 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (b != 110 && b != 78) {
            return 0;
        } else {
            i2 = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.h.request((long) i4)) {
                return 0;
            }
            byte b2 = this.i.getByte((long) i3);
            if (b2 != str2.charAt(i3) && b2 != str.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.h.request((long) (length + 1)) && A(this.i.getByte((long) length))) {
            return 0;
        }
        this.i.skip((long) length);
        this.j = i2;
        return i2;
    }

    private int F() throws IOException {
        byte b;
        char c = 1;
        int i2 = 0;
        long j2 = 0;
        int i3 = 0;
        char c2 = 0;
        boolean z = true;
        boolean z2 = false;
        while (true) {
            int i4 = i3 + 1;
            if (!this.h.request((long) i4)) {
                break;
            }
            b = this.i.getByte((long) i3);
            if (b != 43) {
                if (b != 69 && b != 101) {
                    if (b != 45) {
                        if (b != 46) {
                            if (b >= 48 && b <= 57) {
                                if (c2 == c || c2 == 0) {
                                    j2 = (long) (-(b - 48));
                                    i2 = 0;
                                    c2 = 2;
                                } else {
                                    if (c2 == 2) {
                                        if (j2 == 0) {
                                            return i2;
                                        }
                                        long j3 = (10 * j2) - ((long) (b - 48));
                                        int i5 = (j2 > -922337203685477580L ? 1 : (j2 == -922337203685477580L ? 0 : -1));
                                        z &= i5 > 0 || (i5 == 0 && j3 < j2);
                                        j2 = j3;
                                    } else if (c2 == 3) {
                                        i2 = 0;
                                        c2 = 4;
                                    } else if (c2 == 5 || c2 == 6) {
                                        i2 = 0;
                                        c2 = 7;
                                    }
                                    i2 = 0;
                                }
                            }
                        } else if (c2 != 2) {
                            return i2;
                        } else {
                            c2 = 3;
                        }
                    } else if (c2 == 0) {
                        c2 = 1;
                        z2 = true;
                    } else if (c2 != 5) {
                        return i2;
                    }
                    i3 = i4;
                    c = 1;
                } else if (c2 != 2 && c2 != 4) {
                    return i2;
                } else {
                    c2 = 5;
                    i3 = i4;
                    c = 1;
                }
            } else if (c2 != 5) {
                return i2;
            }
            c2 = 6;
            i3 = i4;
            c = 1;
        }
        if (A(b)) {
            return 0;
        }
        if (c2 == 2 && z && ((j2 != Long.MIN_VALUE || z2) && (j2 != 0 || !z2))) {
            if (!z2) {
                j2 = -j2;
            }
            this.k = j2;
            this.i.skip((long) i3);
            this.j = 16;
            return 16;
        } else if (c2 != 2 && c2 != 4 && c2 != 7) {
            return 0;
        } else {
            this.l = i3;
            this.j = 17;
            return 17;
        }
    }

    private char G() throws IOException {
        int i2;
        int i3;
        if (this.h.request(1)) {
            byte readByte = this.i.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return '\b';
            }
            if (readByte == 102) {
                return '\f';
            }
            if (readByte == 110) {
                return '\n';
            }
            if (readByte == 114) {
                return CharUtils.CR;
            }
            if (readByte == 116) {
                return '\t';
            }
            if (readByte != 117) {
                if (this.e) {
                    return (char) readByte;
                }
                throw w("Invalid escape sequence: \\" + ((char) readByte));
            } else if (this.h.request(4)) {
                char c = 0;
                for (int i4 = 0; i4 < 4; i4++) {
                    byte b = this.i.getByte((long) i4);
                    char c2 = (char) (c << 4);
                    if (b < 48 || b > 57) {
                        if (b >= 97 && b <= 102) {
                            i2 = b - 97;
                        } else if (b < 65 || b > 70) {
                            throw w("\\u" + this.i.readUtf8(4));
                        } else {
                            i2 = b - 65;
                        }
                        i3 = i2 + 10;
                    } else {
                        i3 = b - 48;
                    }
                    c = (char) (c2 + i3);
                }
                this.i.skip(4);
                return c;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + getPath());
            }
        } else {
            throw w("Unterminated escape sequence");
        }
    }

    private void H(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.h.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw w("Unterminated string");
            } else if (this.i.getByte(indexOfElement) == 92) {
                this.i.skip(indexOfElement + 1);
                G();
            } else {
                this.i.skip(indexOfElement + 1);
                return;
            }
        }
    }

    private boolean I() throws IOException {
        BufferedSource bufferedSource = this.h;
        ByteString byteString = r;
        long indexOf = bufferedSource.indexOf(byteString);
        boolean z = indexOf != -1;
        Buffer buffer = this.i;
        buffer.skip(z ? indexOf + ((long) byteString.size()) : buffer.size());
        return z;
    }

    private void J() throws IOException {
        long indexOfElement = this.h.indexOfElement(q);
        Buffer buffer = this.i;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    private void K() throws IOException {
        long indexOfElement = this.h.indexOfElement(p);
        Buffer buffer = this.i;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    private void x() throws IOException {
        if (!this.e) {
            throw w("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int y() throws IOException {
        int[] iArr = this.b;
        int i2 = this.a;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int B = B(true);
            this.i.readByte();
            if (B != 44) {
                if (B == 59) {
                    x();
                } else if (B == 93) {
                    this.j = 4;
                    return 4;
                } else {
                    throw w("Unterminated array");
                }
            }
        } else if (i3 == 3 || i3 == 5) {
            iArr[i2 - 1] = 4;
            if (i3 == 5) {
                int B2 = B(true);
                this.i.readByte();
                if (B2 != 44) {
                    if (B2 == 59) {
                        x();
                    } else if (B2 == 125) {
                        this.j = 2;
                        return 2;
                    } else {
                        throw w("Unterminated object");
                    }
                }
            }
            int B3 = B(true);
            if (B3 == 34) {
                this.i.readByte();
                this.j = 13;
                return 13;
            } else if (B3 == 39) {
                this.i.readByte();
                x();
                this.j = 12;
                return 12;
            } else if (B3 != 125) {
                x();
                if (A((char) B3)) {
                    this.j = 14;
                    return 14;
                }
                throw w("Expected name");
            } else if (i3 != 5) {
                this.i.readByte();
                this.j = 2;
                return 2;
            } else {
                throw w("Expected name");
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int B4 = B(true);
            this.i.readByte();
            if (B4 != 58) {
                if (B4 == 61) {
                    x();
                    if (this.h.request(1) && this.i.getByte(0) == 62) {
                        this.i.readByte();
                    }
                } else {
                    throw w("Expected ':'");
                }
            }
        } else if (i3 == 6) {
            iArr[i2 - 1] = 7;
        } else if (i3 == 7) {
            if (B(false) == -1) {
                this.j = 18;
                return 18;
            }
            x();
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int B5 = B(true);
        if (B5 == 34) {
            this.i.readByte();
            this.j = 9;
            return 9;
        } else if (B5 != 39) {
            if (!(B5 == 44 || B5 == 59)) {
                if (B5 == 91) {
                    this.i.readByte();
                    this.j = 3;
                    return 3;
                } else if (B5 != 93) {
                    if (B5 != 123) {
                        int E = E();
                        if (E != 0) {
                            return E;
                        }
                        int F = F();
                        if (F != 0) {
                            return F;
                        }
                        if (A(this.i.getByte(0))) {
                            x();
                            this.j = 10;
                            return 10;
                        }
                        throw w("Expected value");
                    }
                    this.i.readByte();
                    this.j = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.i.readByte();
                    this.j = 4;
                    return 4;
                }
            }
            if (i3 == 1 || i3 == 2) {
                x();
                this.j = 7;
                return 7;
            }
            throw w("Unexpected value");
        } else {
            x();
            this.i.readByte();
            this.j = 8;
            return 8;
        }
    }

    private int z(String str, JsonReader.a aVar) {
        int length = aVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.a[i2])) {
                this.j = 0;
                this.c[this.a - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void c() throws IOException {
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        if (i2 == 3) {
            r(1);
            this.d[this.a - 1] = 0;
            this.j = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + q() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j = 0;
        this.b[0] = 8;
        this.a = 1;
        this.i.clear();
        this.h.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void e() throws IOException {
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        if (i2 == 1) {
            r(3);
            this.j = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + q() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void f() throws IOException {
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        if (i2 == 4) {
            int i3 = this.a - 1;
            this.a = i3;
            int[] iArr = this.d;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.j = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + q() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void g() throws IOException {
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        if (i2 == 2) {
            int i3 = this.a - 1;
            this.a = i3;
            this.c[i3] = null;
            int[] iArr = this.d;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.j = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + q() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean j() throws IOException {
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        return (i2 == 2 || i2 == 4 || i2 == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean k() throws IOException {
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        if (i2 == 5) {
            this.j = 0;
            int[] iArr = this.d;
            int i3 = this.a - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.j = 0;
            int[] iArr2 = this.d;
            int i4 = this.a - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + q() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double l() throws IOException {
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        if (i2 == 16) {
            this.j = 0;
            int[] iArr = this.d;
            int i3 = this.a - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.k;
        }
        if (i2 == 17) {
            this.m = this.i.readUtf8((long) this.l);
        } else if (i2 == 9) {
            this.m = C(o);
        } else if (i2 == 8) {
            this.m = C(n);
        } else if (i2 == 10) {
            this.m = D();
        } else if (i2 != 11) {
            throw new JsonDataException("Expected a double but was " + q() + " at path " + getPath());
        }
        this.j = 11;
        try {
            double parseDouble = Double.parseDouble(this.m);
            if (this.e || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                this.m = null;
                this.j = 0;
                int[] iArr2 = this.d;
                int i4 = this.a - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.m + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int m() throws IOException {
        String str;
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        if (i2 == 16) {
            long j2 = this.k;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.j = 0;
                int[] iArr = this.d;
                int i4 = this.a - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new JsonDataException("Expected an int but was " + this.k + " at path " + getPath());
        }
        if (i2 == 17) {
            this.m = this.i.readUtf8((long) this.l);
        } else if (i2 == 9 || i2 == 8) {
            if (i2 == 9) {
                str = C(o);
            } else {
                str = C(n);
            }
            this.m = str;
            try {
                int parseInt = Integer.parseInt(str);
                this.j = 0;
                int[] iArr2 = this.d;
                int i5 = this.a - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i2 != 11) {
            throw new JsonDataException("Expected an int but was " + q() + " at path " + getPath());
        }
        this.j = 11;
        try {
            double parseDouble = Double.parseDouble(this.m);
            int i6 = (int) parseDouble;
            if (((double) i6) == parseDouble) {
                this.m = null;
                this.j = 0;
                int[] iArr3 = this.d;
                int i7 = this.a - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new JsonDataException("Expected an int but was " + this.m + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.m + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String n() throws IOException {
        String str;
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        if (i2 == 14) {
            str = D();
        } else if (i2 == 13) {
            str = C(o);
        } else if (i2 == 12) {
            str = C(n);
        } else if (i2 == 15) {
            str = this.m;
        } else {
            throw new JsonDataException("Expected a name but was " + q() + " at path " + getPath());
        }
        this.j = 0;
        this.c[this.a - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String o() throws IOException {
        String str;
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        if (i2 == 10) {
            str = D();
        } else if (i2 == 9) {
            str = C(o);
        } else if (i2 == 8) {
            str = C(n);
        } else if (i2 == 11) {
            str = this.m;
            this.m = null;
        } else if (i2 == 16) {
            str = Long.toString(this.k);
        } else if (i2 == 17) {
            str = this.i.readUtf8((long) this.l);
        } else {
            throw new JsonDataException("Expected a string but was " + q() + " at path " + getPath());
        }
        this.j = 0;
        int[] iArr = this.d;
        int i3 = this.a - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token q() throws IOException {
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        switch (i2) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int s(JsonReader.a aVar) throws IOException {
        int i2 = this.j;
        if (i2 == 0) {
            i2 = y();
        }
        if (i2 < 12 || i2 > 15) {
            return -1;
        }
        if (i2 == 15) {
            return z(this.m, aVar);
        }
        int select = this.h.select(aVar.b);
        if (select != -1) {
            this.j = 0;
            this.c[this.a - 1] = aVar.a[select];
            return select;
        }
        String str = this.c[this.a - 1];
        String n2 = n();
        int z = z(n2, aVar);
        if (z == -1) {
            this.j = 15;
            this.m = n2;
            this.c[this.a - 1] = str;
        }
        return z;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void t() throws IOException {
        if (!this.f) {
            int i2 = this.j;
            if (i2 == 0) {
                i2 = y();
            }
            if (i2 == 14) {
                K();
            } else if (i2 == 13) {
                H(o);
            } else if (i2 == 12) {
                H(n);
            } else if (i2 != 15) {
                throw new JsonDataException("Expected a name but was " + q() + " at path " + getPath());
            }
            this.j = 0;
            this.c[this.a - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + q() + " at " + getPath());
    }

    public String toString() {
        return "JsonReader(" + this.h + jl1.BRACKET_END_STR;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void u() throws IOException {
        if (!this.f) {
            int i2 = 0;
            do {
                int i3 = this.j;
                if (i3 == 0) {
                    i3 = y();
                }
                if (i3 == 3) {
                    r(1);
                } else if (i3 == 1) {
                    r(3);
                } else {
                    if (i3 == 4) {
                        i2--;
                        if (i2 >= 0) {
                            this.a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + q() + " at path " + getPath());
                        }
                    } else if (i3 == 2) {
                        i2--;
                        if (i2 >= 0) {
                            this.a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + q() + " at path " + getPath());
                        }
                    } else if (i3 == 14 || i3 == 10) {
                        K();
                    } else if (i3 == 9 || i3 == 13) {
                        H(o);
                    } else if (i3 == 8 || i3 == 12) {
                        H(n);
                    } else if (i3 == 17) {
                        this.i.skip((long) this.l);
                    } else if (i3 == 18) {
                        throw new JsonDataException("Expected a value but was " + q() + " at path " + getPath());
                    }
                    this.j = 0;
                }
                i2++;
                this.j = 0;
            } while (i2 != 0);
            int[] iArr = this.d;
            int i4 = this.a;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
            this.c[i4 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + q() + " at " + getPath());
    }
}
