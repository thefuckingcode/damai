package com.huawei.secure.android.common.ssl.hostname;

import com.youku.upsplayer.util.YKUpsConvert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import tb.jl1;

/* compiled from: Taobao */
public class a {
    private final String a;
    private final int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private char[] g;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.b = name.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0095, code lost:
        r1 = r8.g;
        r2 = r8.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a1, code lost:
        return new java.lang.String(r1, r2, r8.f - r2);
     */
    private String a() {
        char[] cArr;
        int i;
        int i2;
        int i3 = this.c;
        this.d = i3;
        this.e = i3;
        while (true) {
            int i4 = this.c;
            if (i4 < this.b) {
                cArr = this.g;
                char c2 = cArr[i4];
                if (c2 == ' ') {
                    int i5 = this.e;
                    this.f = i5;
                    this.c = i4 + 1;
                    this.e = i5 + 1;
                    cArr[i5] = ' ';
                    while (true) {
                        i = this.c;
                        i2 = this.b;
                        if (i >= i2) {
                            break;
                        }
                        char[] cArr2 = this.g;
                        if (cArr2[i] != ' ') {
                            break;
                        }
                        int i6 = this.e;
                        this.e = i6 + 1;
                        cArr2[i6] = ' ';
                        this.c = i + 1;
                    }
                    if (i == i2) {
                        break;
                    }
                    char[] cArr3 = this.g;
                    if (cArr3[i] == ',' || cArr3[i] == '+' || cArr3[i] == ';') {
                        break;
                    }
                } else if (c2 == ';') {
                    break;
                } else if (c2 != '\\') {
                    if (c2 == '+' || c2 == ',') {
                        break;
                    }
                    int i7 = this.e;
                    this.e = i7 + 1;
                    cArr[i7] = cArr[i4];
                    this.c = i4 + 1;
                } else {
                    int i8 = this.e;
                    this.e = i8 + 1;
                    cArr[i8] = b();
                    this.c++;
                }
            } else {
                char[] cArr4 = this.g;
                int i9 = this.d;
                return new String(cArr4, i9, this.e - i9);
            }
        }
        int i10 = this.d;
        return new String(cArr, i10, this.e - i10);
    }

    private char b() {
        int i = this.c + 1;
        this.c = i;
        if (i != this.b) {
            char[] cArr = this.g;
            char c2 = cArr[i];
            if (!(c2 == ' ' || c2 == '%' || c2 == '\\' || c2 == '_' || c2 == '\"' || c2 == '#')) {
                switch (c2) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c2) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return c();
                        }
                }
            }
            return cArr[i];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    private char c() {
        int i;
        int i2;
        int a2 = a(this.c);
        this.c++;
        if (a2 < 128) {
            return (char) a2;
        }
        if (a2 < 192 || a2 > 247) {
            return jl1.CONDITION_IF;
        }
        if (a2 <= 223) {
            i2 = a2 & 31;
            i = 1;
        } else if (a2 <= 239) {
            i = 2;
            i2 = a2 & 15;
        } else {
            i = 3;
            i2 = a2 & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.c + 1;
            this.c = i4;
            if (i4 == this.b || this.g[i4] != '\\') {
                return jl1.CONDITION_IF;
            }
            int i5 = i4 + 1;
            this.c = i5;
            int a3 = a(i5);
            this.c++;
            if ((a3 & 192) != 128) {
                return jl1.CONDITION_IF;
            }
            i2 = (i2 << 6) + (a3 & 63);
        }
        return (char) i2;
    }

    private String d() {
        int i;
        int i2 = this.c;
        if (i2 + 4 < this.b) {
            this.d = i2;
            this.c = i2 + 1;
            while (true) {
                i = this.c;
                if (i == this.b) {
                    break;
                }
                char[] cArr = this.g;
                if (cArr[i] == '+' || cArr[i] == ',' || cArr[i] == ';') {
                    break;
                } else if (cArr[i] == ' ') {
                    this.e = i;
                    this.c = i + 1;
                    while (true) {
                        int i3 = this.c;
                        if (i3 >= this.b || this.g[i3] != ' ') {
                            break;
                        }
                        this.c = i3 + 1;
                    }
                } else {
                    if (cArr[i] >= 'A' && cArr[i] <= 'F') {
                        cArr[i] = (char) (cArr[i] + ' ');
                    }
                    this.c = i + 1;
                }
            }
            this.e = i;
            int i4 = this.e;
            int i5 = this.d;
            int i6 = i4 - i5;
            if (i6 < 5 || (i6 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            int i7 = i6 / 2;
            byte[] bArr = new byte[i7];
            int i8 = i5 + 1;
            for (int i9 = 0; i9 < i7; i9++) {
                bArr[i9] = (byte) a(i8);
                i8 += 2;
            }
            return new String(this.g, this.d, i6);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    private String e() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        while (true) {
            i = this.c;
            i2 = this.b;
            if (i < i2 && this.g[i] == ' ') {
                this.c = i + 1;
            } else if (i != i2) {
                return null;
            } else {
                this.d = i;
                this.c = i + 1;
                while (true) {
                    i3 = this.c;
                    i4 = this.b;
                    if (i3 >= i4) {
                        break;
                    }
                    char[] cArr = this.g;
                    if (cArr[i3] == '=' || cArr[i3] == ' ') {
                        break;
                    }
                    this.c = i3 + 1;
                }
                if (i3 < i4) {
                    this.e = i3;
                    if (this.g[i3] == ' ') {
                        while (true) {
                            i5 = this.c;
                            i6 = this.b;
                            if (i5 >= i6) {
                                break;
                            }
                            char[] cArr2 = this.g;
                            if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                                break;
                            }
                            this.c = i5 + 1;
                        }
                        if (this.g[i5] != '=' || i5 == i6) {
                            throw new IllegalStateException("Unexpected end of DN: " + this.a);
                        }
                    }
                    this.c++;
                    while (true) {
                        int i7 = this.c;
                        if (i7 >= this.b || this.g[i7] != ' ') {
                            int i8 = this.e;
                            int i9 = this.d;
                        } else {
                            this.c = i7 + 1;
                        }
                    }
                    int i82 = this.e;
                    int i92 = this.d;
                    if (i82 - i92 > 4) {
                        char[] cArr3 = this.g;
                        if (cArr3[i92 + 3] == '.' && (cArr3[i92] == 'O' || cArr3[i92] == 'o')) {
                            int i10 = i92 + 1;
                            if (cArr3[i10] == 'I' || cArr3[i10] == 'i') {
                                int i11 = i92 + 2;
                                if (cArr3[i11] == 'D' || cArr3[i11] == 'd') {
                                    this.d = i92 + 4;
                                }
                            }
                        }
                    }
                    char[] cArr4 = this.g;
                    int i12 = this.d;
                    return new String(cArr4, i12, i82 - i12);
                }
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
        if (i != i2) {
        }
    }

    private String f() {
        int i = this.c + 1;
        this.c = i;
        this.d = i;
        this.e = i;
        while (true) {
            int i2 = this.c;
            if (i2 != this.b) {
                char[] cArr = this.g;
                if (cArr[i2] == '\"') {
                    this.c = i2 + 1;
                    while (true) {
                        int i3 = this.c;
                        if (i3 >= this.b || this.g[i3] != ' ') {
                            char[] cArr2 = this.g;
                            int i4 = this.d;
                        } else {
                            this.c = i3 + 1;
                        }
                    }
                    char[] cArr22 = this.g;
                    int i42 = this.d;
                    return new String(cArr22, i42, this.e - i42);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.e] = b();
                } else {
                    cArr[this.e] = cArr[i2];
                }
                this.c++;
                this.e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
    }

    public List<String> b(String str) {
        String str2;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.a.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String e2 = e();
        if (e2 == null) {
            return emptyList;
        }
        do {
            int i = this.c;
            if (i < this.b) {
                char c2 = this.g[i];
                if (c2 == '\"') {
                    str2 = f();
                } else if (c2 != '#') {
                    str2 = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a();
                } else {
                    str2 = d();
                }
                if (str.equalsIgnoreCase(e2)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(str2);
                }
                int i2 = this.c;
                if (i2 < this.b) {
                    char[] cArr = this.g;
                    if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                        this.c = i2 + 1;
                        e2 = e();
                    } else {
                        throw new IllegalStateException("Malformed DN: " + this.a);
                    }
                }
            }
            return emptyList;
        } while (e2 != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.b) {
            char[] cArr = this.g;
            char c2 = cArr[i];
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - YKUpsConvert.CHAR_ZERO;
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i2 = c2 - '7';
            }
            char c3 = cArr[i4];
            if (c3 >= '0' && c3 <= '9') {
                i3 = c3 - YKUpsConvert.CHAR_ZERO;
            } else if (c3 >= 'a' && c3 <= 'f') {
                i3 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i3 = c3 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.a);
    }

    public String a(String str) {
        String str2;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.a.toCharArray();
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        do {
            int i = this.c;
            if (i == this.b) {
                return null;
            }
            char c2 = this.g[i];
            if (c2 == '\"') {
                str2 = f();
            } else if (c2 != '#') {
                str2 = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a();
            } else {
                str2 = d();
            }
            if (str.equalsIgnoreCase(e2)) {
                return str2;
            }
            int i2 = this.c;
            if (i2 >= this.b) {
                return null;
            }
            char[] cArr = this.g;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.c = i2 + 1;
                e2 = e();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
        } while (e2 != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }
}
