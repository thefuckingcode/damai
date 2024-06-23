package com.squareup.okhttp.internal.tls;

import com.youku.upsplayer.util.YKUpsConvert;
import javax.security.auth.x500.X500Principal;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.dn = name;
        this.length = name.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0095, code lost:
        r1 = r8.chars;
        r2 = r8.beg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a1, code lost:
        return new java.lang.String(r1, r2, r8.cur - r2);
     */
    private String escapedAV() {
        char[] cArr;
        int i;
        int i2;
        int i3 = this.pos;
        this.beg = i3;
        this.end = i3;
        while (true) {
            int i4 = this.pos;
            if (i4 < this.length) {
                cArr = this.chars;
                char c = cArr[i4];
                if (c == ' ') {
                    int i5 = this.end;
                    this.cur = i5;
                    this.pos = i4 + 1;
                    this.end = i5 + 1;
                    cArr[i5] = ' ';
                    while (true) {
                        i = this.pos;
                        i2 = this.length;
                        if (i >= i2) {
                            break;
                        }
                        char[] cArr2 = this.chars;
                        if (cArr2[i] != ' ') {
                            break;
                        }
                        int i6 = this.end;
                        this.end = i6 + 1;
                        cArr2[i6] = ' ';
                        this.pos = i + 1;
                    }
                    if (i == i2) {
                        break;
                    }
                    char[] cArr3 = this.chars;
                    if (cArr3[i] == ',' || cArr3[i] == '+' || cArr3[i] == ';') {
                        break;
                    }
                } else if (c == ';') {
                    break;
                } else if (c != '\\') {
                    if (c == '+' || c == ',') {
                        break;
                    }
                    int i7 = this.end;
                    this.end = i7 + 1;
                    cArr[i7] = cArr[i4];
                    this.pos = i4 + 1;
                } else {
                    int i8 = this.end;
                    this.end = i8 + 1;
                    cArr[i8] = getEscaped();
                    this.pos++;
                }
            } else {
                char[] cArr4 = this.chars;
                int i9 = this.beg;
                return new String(cArr4, i9, this.end - i9);
            }
        }
        int i10 = this.beg;
        return new String(cArr, i10, this.end - i10);
    }

    private int getByte(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.length) {
            char[] cArr = this.chars;
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                i2 = c - YKUpsConvert.CHAR_ZERO;
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            } else {
                i2 = c - '7';
            }
            char c2 = cArr[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - YKUpsConvert.CHAR_ZERO;
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }

    private char getEscaped() {
        int i = this.pos + 1;
        this.pos = i;
        if (i != this.length) {
            char[] cArr = this.chars;
            char c = cArr[i];
            if (!(c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#')) {
                switch (c) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return getUTF8();
                        }
                }
            }
            return cArr[i];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private char getUTF8() {
        int i;
        int i2;
        int i3 = getByte(this.pos);
        this.pos++;
        if (i3 < 128) {
            return (char) i3;
        }
        if (i3 < 192 || i3 > 247) {
            return jl1.CONDITION_IF;
        }
        if (i3 <= 223) {
            i2 = i3 & 31;
            i = 1;
        } else if (i3 <= 239) {
            i = 2;
            i2 = i3 & 15;
        } else {
            i = 3;
            i2 = i3 & 7;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = this.pos + 1;
            this.pos = i5;
            if (i5 == this.length || this.chars[i5] != '\\') {
                return jl1.CONDITION_IF;
            }
            int i6 = i5 + 1;
            this.pos = i6;
            int i7 = getByte(i6);
            this.pos++;
            if ((i7 & 192) != 128) {
                return jl1.CONDITION_IF;
            }
            i2 = (i2 << 6) + (i7 & 63);
        }
        return (char) i2;
    }

    private String hexAV() {
        int i;
        int i2 = this.pos;
        if (i2 + 4 < this.length) {
            this.beg = i2;
            this.pos = i2 + 1;
            while (true) {
                i = this.pos;
                if (i == this.length) {
                    break;
                }
                char[] cArr = this.chars;
                if (cArr[i] == '+' || cArr[i] == ',' || cArr[i] == ';') {
                    break;
                } else if (cArr[i] == ' ') {
                    this.end = i;
                    this.pos = i + 1;
                    while (true) {
                        int i3 = this.pos;
                        if (i3 >= this.length || this.chars[i3] != ' ') {
                            break;
                        }
                        this.pos = i3 + 1;
                    }
                } else {
                    if (cArr[i] >= 'A' && cArr[i] <= 'F') {
                        cArr[i] = (char) (cArr[i] + ' ');
                    }
                    this.pos = i + 1;
                }
            }
            this.end = i;
            int i4 = this.end;
            int i5 = this.beg;
            int i6 = i4 - i5;
            if (i6 < 5 || (i6 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
            int i7 = i6 / 2;
            byte[] bArr = new byte[i7];
            int i8 = i5 + 1;
            for (int i9 = 0; i9 < i7; i9++) {
                bArr[i9] = (byte) getByte(i8);
                i8 += 2;
            }
            return new String(this.chars, this.beg, i6);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    private String nextAT() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        while (true) {
            i = this.pos;
            i2 = this.length;
            if (i < i2 && this.chars[i] == ' ') {
                this.pos = i + 1;
            } else if (i != i2) {
                return null;
            } else {
                this.beg = i;
                this.pos = i + 1;
                while (true) {
                    i3 = this.pos;
                    i4 = this.length;
                    if (i3 >= i4) {
                        break;
                    }
                    char[] cArr = this.chars;
                    if (cArr[i3] == '=' || cArr[i3] == ' ') {
                        break;
                    }
                    this.pos = i3 + 1;
                }
                if (i3 < i4) {
                    this.end = i3;
                    if (this.chars[i3] == ' ') {
                        while (true) {
                            i5 = this.pos;
                            i6 = this.length;
                            if (i5 >= i6) {
                                break;
                            }
                            char[] cArr2 = this.chars;
                            if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                                break;
                            }
                            this.pos = i5 + 1;
                        }
                        if (this.chars[i5] != '=' || i5 == i6) {
                            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
                        }
                    }
                    this.pos++;
                    while (true) {
                        int i7 = this.pos;
                        if (i7 >= this.length || this.chars[i7] != ' ') {
                            int i8 = this.end;
                            int i9 = this.beg;
                        } else {
                            this.pos = i7 + 1;
                        }
                    }
                    int i82 = this.end;
                    int i92 = this.beg;
                    if (i82 - i92 > 4) {
                        char[] cArr3 = this.chars;
                        if (cArr3[i92 + 3] == '.' && ((cArr3[i92] == 'O' || cArr3[i92] == 'o') && ((cArr3[i92 + 1] == 'I' || cArr3[i92 + 1] == 'i') && (cArr3[i92 + 2] == 'D' || cArr3[i92 + 2] == 'd')))) {
                            this.beg = i92 + 4;
                        }
                    }
                    char[] cArr4 = this.chars;
                    int i10 = this.beg;
                    return new String(cArr4, i10, i82 - i10);
                }
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
        if (i != i2) {
        }
    }

    private String quotedAV() {
        int i = this.pos + 1;
        this.pos = i;
        this.beg = i;
        this.end = i;
        while (true) {
            int i2 = this.pos;
            if (i2 != this.length) {
                char[] cArr = this.chars;
                if (cArr[i2] == '\"') {
                    this.pos = i2 + 1;
                    while (true) {
                        int i3 = this.pos;
                        if (i3 >= this.length || this.chars[i3] != ' ') {
                            char[] cArr2 = this.chars;
                            int i4 = this.beg;
                        } else {
                            this.pos = i3 + 1;
                        }
                    }
                    char[] cArr22 = this.chars;
                    int i42 = this.beg;
                    return new String(cArr22, i42, this.end - i42);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.end] = getEscaped();
                } else {
                    cArr[this.end] = cArr[i2];
                }
                this.pos++;
                this.end++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
    }

    public String findMostSpecific(String str) {
        String str2;
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String nextAT = nextAT();
        if (nextAT == null) {
            return null;
        }
        do {
            int i = this.pos;
            if (i == this.length) {
                return null;
            }
            char c = this.chars[i];
            if (c == '\"') {
                str2 = quotedAV();
            } else if (c != '#') {
                str2 = (c == '+' || c == ',' || c == ';') ? "" : escapedAV();
            } else {
                str2 = hexAV();
            }
            if (str.equalsIgnoreCase(nextAT)) {
                return str2;
            }
            int i2 = this.pos;
            if (i2 >= this.length) {
                return null;
            }
            char[] cArr = this.chars;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.pos = i2 + 1;
                nextAT = nextAT();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
        } while (nextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}
