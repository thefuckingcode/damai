package tb;

import java.io.PrintStream;
import java.net.URI;

/* compiled from: Taobao */
public class lp {
    public static final int TT_ATKEYWORD = -3;
    public static final int TT_DASHMATCH = -18;
    public static final int TT_DIMENSION = -9;
    public static final int TT_EOF = -1;
    public static final int TT_FUNCTION = -16;
    public static final int TT_HASH = -6;
    public static final int TT_IDENT = -2;
    public static final int TT_INCLUDES = -17;
    public static final int TT_NUMBER = -7;
    public static final int TT_PERCENTAGE = -8;
    public static final int TT_S = -14;
    public static final int TT_STRING = -4;
    public static final int TT_URI = -10;
    public int a;
    public String b;
    public float c;
    private String d;
    private int e;
    private int f = -99;
    private int g;
    URI h;

    public lp(URI uri, String str) {
        this.d = str;
        c(false);
    }

    private int d() {
        if (this.e >= this.d.length()) {
            return -1;
        }
        String str = this.d;
        int i = this.e;
        this.e = i + 1;
        return str.charAt(i);
    }

    private char e() {
        int i;
        this.f = d();
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6 && (((i = this.f) >= 48 && i <= 57) || ((i >= 97 && i <= 122) || (i >= 65 && i <= 90)))) {
            i2++;
            i3 = (i3 * 16) + Character.digit((char) i, 16);
            this.f = d();
        }
        if (i2 == 0) {
            i3 = this.f;
            this.f = d();
        } else if (this.f <= 32) {
            this.f = d();
        }
        return (char) i3;
    }

    private String f() {
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.f;
            if (i == 92) {
                sb.append(e());
            } else {
                sb.append((char) i);
                this.f = d();
            }
            if ("~|<>+*()[]{}.,;*:%=!@#".indexOf(this.f) != -1) {
                break;
            }
        } while (this.f > 32);
        return sb.toString();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0001 */
    private void g(boolean z) {
        int d2;
        float f2 = 0.0f;
        while (true) {
            int i = this.f;
            if (i == 46) {
                z = true;
            } else {
                f2 = ((f2 * 10.0f) + ((float) i)) - 48.0f;
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                z = i2 * 10;
            }
            d2 = d();
            this.f = d2;
            if ((d2 < 48 || d2 > 57) && d2 != 46) {
                break;
            }
        }
        if (z) {
            f2 /= z ? 1.0f : 0.0f;
        }
        this.c = f2;
        if (d2 == 37) {
            this.a = -8;
            this.f = -99;
            this.b = "%";
        } else if ((d2 < 97 || d2 > 122) && (d2 < 65 || d2 > 90)) {
            this.a = -7;
            this.b = "";
        } else {
            StringBuilder sb = new StringBuilder();
            while (true) {
                sb.append((char) this.f);
                int d3 = d();
                this.f = d3;
                if ((d3 < 97 || d3 > 122) && (d3 < 65 || d3 > 90)) {
                    this.a = -9;
                    this.b = sb.toString();
                }
            }
            this.a = -9;
            this.b = sb.toString();
        }
    }

    private String h(char c2) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = this.f;
            if (i == c2 || i == -1 || i == 10 || i == 13) {
                this.f = -99;
            } else if (i == 92) {
                sb.append(e());
            } else {
                sb.append((char) i);
                this.f = d();
            }
        }
        this.f = -99;
        return sb.toString();
    }

    private void i() {
        while (true) {
            int i = this.f;
            if (i <= 32 && i != -1) {
                if (i == 10) {
                    this.g++;
                }
                this.f = d();
            } else {
                return;
            }
        }
    }

    public void a(int i) {
        if (this.a != i) {
            b("Expected: " + ((char) i));
        }
    }

    public void b(String str) {
        PrintStream printStream = System.out;
        printStream.print(str + " line: " + this.g + "; token: ");
        int i = this.a;
        if (i == -4) {
            PrintStream printStream2 = System.out;
            printStream2.print("string '" + this.b + "'");
        } else if (i != -2) {
            switch (i) {
                case -10:
                    PrintStream printStream3 = System.out;
                    printStream3.print("uri '" + this.b + "'");
                    break;
                case -9:
                case -8:
                case -7:
                    PrintStream printStream4 = System.out;
                    printStream4.print("numeric " + this.c + " unit: " + this.b);
                    break;
                default:
                    if (i > 32) {
                        System.out.print((char) i);
                        break;
                    } else {
                        System.out.print(i);
                        break;
                    }
            }
        } else {
            PrintStream printStream5 = System.out;
            printStream5.print("identifier '" + this.b + "'");
        }
        PrintStream printStream6 = System.out;
        printStream6.println(" url: " + this.h);
    }

    public int c(boolean z) {
        int d2;
        this.b = "";
        this.c = 0.0f;
        if (this.f == -99) {
            this.f = d();
        }
        int i = this.f;
        if (i == -1) {
            this.a = -1;
            return -1;
        }
        if (i <= 32) {
            i();
            if (z) {
                this.a = -14;
                return -14;
            }
        }
        int i2 = this.f;
        if (i2 == 34) {
            this.f = d();
            this.b = h(jl1.QUOTE);
            this.a = -4;
        } else if (i2 == 35) {
            StringBuilder sb = new StringBuilder();
            this.f = d();
            while (true) {
                sb.append((char) this.f);
                int d3 = d();
                this.f = d3;
                if ((d3 < 48 || d3 > 57) && ((d3 < 97 || d3 > 122) && !((d3 >= 65 && d3 <= 90) || d3 == 45 || d3 == 95))) {
                    break;
                }
            }
            this.a = -6;
            this.b = sb.toString();
        } else if (i2 == 39) {
            this.f = d();
            this.b = h('\'');
            this.a = -4;
        } else if (i2 == 64) {
            this.f = d();
            this.b = f();
            this.a = -3;
        } else if (i2 == 124) {
            int d4 = d();
            this.f = d4;
            if (d4 == 61) {
                this.a = -18;
                this.f = -99;
            } else {
                this.a = 126;
            }
        } else if (i2 != 126) {
            switch (i2) {
                case 45:
                    this.f = d();
                    g(false);
                    this.c = -this.c;
                    break;
                case 46:
                    int d5 = d();
                    this.f = d5;
                    if (d5 >= 48 && d5 <= 57) {
                        g(true);
                        break;
                    } else {
                        this.a = 46;
                        break;
                    }
                case 47:
                    int d6 = d();
                    this.f = d6;
                    if (d6 == 42) {
                        this.f = d();
                        while (true) {
                            int i3 = this.f;
                            int d7 = d();
                            this.f = d7;
                            if (d7 == 10) {
                                this.g++;
                            }
                            if (d7 == -1 || (i3 == 42 && d7 == 47)) {
                                this.f = -99;
                            }
                        }
                        this.f = -99;
                        return c(z);
                    } else if (d6 != 47) {
                        this.a = 47;
                        break;
                    } else {
                        do {
                            d2 = d();
                            this.f = d2;
                            if (d2 == 10 || d2 == 13) {
                                return c(z);
                            }
                        } while (d2 != -1);
                        return c(z);
                    }
                    break;
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    g(false);
                    break;
                default:
                    if ("~|<>+*()[]{}.,;*:%=!@#".indexOf((char) i2) == -1) {
                        String f2 = f();
                        this.b = f2;
                        if (this.f == 40) {
                            if (!f2.equals("url")) {
                                this.a = -16;
                                this.f = -99;
                                break;
                            } else {
                                this.f = d();
                                i();
                                int i4 = this.f;
                                if (i4 == 34) {
                                    this.f = d();
                                    this.b = h(jl1.QUOTE);
                                    i();
                                    a(41);
                                    this.f = -99;
                                } else if (i4 != 39) {
                                    this.b = h(')');
                                } else {
                                    this.f = d();
                                    this.b = h('\'');
                                    i();
                                    a(41);
                                    this.f = -99;
                                }
                                this.a = -10;
                                break;
                            }
                        } else {
                            this.a = -2;
                            break;
                        }
                    } else {
                        this.a = this.f;
                        this.f = -99;
                        break;
                    }
            }
        } else {
            int d8 = d();
            this.f = d8;
            if (d8 == 61) {
                this.a = -17;
                this.f = -99;
            } else {
                this.a = 126;
            }
        }
        return this.a;
    }
}
