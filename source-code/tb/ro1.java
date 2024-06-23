package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ro1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final double[] e = new double[128];
    private final char[] a;
    private final int b;
    private char c;
    public int d;

    static {
        int i = 0;
        while (true) {
            double[] dArr = e;
            if (i < dArr.length) {
                dArr[i] = Math.pow(10.0d, (double) i);
                i++;
            } else {
                return;
            }
        }
    }

    public ro1(String str, int i) {
        try {
            char[] charArray = str.toCharArray();
            this.a = charArray;
            this.d = i;
            this.b = charArray.length;
            this.c = charArray[i];
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static float b(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724886115")) {
            return ((Float) ipChange.ipc$dispatch("-724886115", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).floatValue();
        } else if (i2 < -125 || i == 0) {
            return 0.0f;
        } else {
            if (i2 >= 128) {
                return i > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
            }
            if (i2 == 0) {
                return (float) i;
            }
            if (i >= 67108864) {
                i++;
            }
            double d2 = (double) i;
            double[] dArr = e;
            return (float) (i2 > 0 ? d2 * dArr[i2] : d2 / dArr[-i2]);
        }
    }

    private char f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084592370")) {
            return ((Character) ipChange.ipc$dispatch("2084592370", new Object[]{this})).charValue();
        }
        int i = this.d;
        int i2 = this.b;
        if (i < i2) {
            this.d = i + 1;
        }
        int i3 = this.d;
        if (i3 == i2) {
            return 0;
        }
        return this.a[i3];
    }

    private void g(char c2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2046648678")) {
            ipChange.ipc$dispatch("2046648678", new Object[]{this, Character.valueOf(c2)});
            return;
        }
        throw new RuntimeException("Unexpected char '" + c2 + "'.");
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-647163635")) {
            ipChange.ipc$dispatch("-647163635", new Object[]{this});
            return;
        }
        this.c = f();
    }

    public int c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120130577")) {
            return ((Integer) ipChange.ipc$dispatch("-2120130577", new Object[]{this})).intValue();
        }
        i();
        int i = this.c - '0';
        this.c = f();
        h();
        return i;
    }

    public float d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902009226")) {
            return ((Float) ipChange.ipc$dispatch("-902009226", new Object[]{this})).floatValue();
        }
        i();
        float e2 = e();
        h();
        return e2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041 A[LOOP:0: B:14:0x0041->B:18:0x004d, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00da A[LOOP:4: B:61:0x00da->B:62:0x00e0, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x006f A[SYNTHETIC] */
    public float e() {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        char f;
        char f2;
        char f3;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        int i4 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-888149054")) {
            return ((Float) ipChange.ipc$dispatch("-888149054", new Object[]{this})).floatValue();
        }
        char c2 = this.c;
        if (c2 == '+') {
            z = true;
        } else if (c2 != '-') {
            z = true;
            switch (this.c) {
                case '.':
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                    z2 = false;
                    if (this.c == '.') {
                        char f4 = f();
                        this.c = f4;
                        switch (f4) {
                            case '0':
                                if (i3 == 0) {
                                    while (true) {
                                        char f5 = f();
                                        this.c = f5;
                                        i2--;
                                        switch (f5) {
                                            case '0':
                                                break;
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                            default:
                                                if (!z2) {
                                                    return 0.0f;
                                                }
                                                break;
                                        }
                                    }
                                }
                                break;
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                while (true) {
                                    if (i3 < 9) {
                                        i3++;
                                        i = (i * 10) + (this.c - '0');
                                        i2--;
                                    }
                                    char f6 = f();
                                    this.c = f6;
                                    switch (f6) {
                                    }
                                }
                                break;
                            default:
                                if (!z2) {
                                    g(f4);
                                    return 0.0f;
                                }
                                break;
                        }
                    }
                    char c3 = this.c;
                    if (c3 == 'E' || c3 == 'e') {
                        f = f();
                        this.c = f;
                        if (f != '+') {
                            if (f != '-') {
                                switch (f) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        break;
                                    default:
                                        g(f);
                                        return 0.0f;
                                }
                                switch (this.c) {
                                    case '0':
                                        while (true) {
                                            char f7 = f();
                                            this.c = f7;
                                            switch (f7) {
                                            }
                                        }
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        int i5 = 0;
                                        while (true) {
                                            if (i4 < 3) {
                                                i4++;
                                                i5 = (i5 * 10) + (this.c - '0');
                                            }
                                            char f8 = f();
                                            this.c = f8;
                                            switch (f8) {
                                                case '0':
                                                case '1':
                                                case '2':
                                                case '3':
                                                case '4':
                                                case '5':
                                                case '6':
                                                case '7':
                                                case '8':
                                                case '9':
                                                    break;
                                                default:
                                                    i4 = i5;
                                                    break;
                                            }
                                        }
                                }
                            } else {
                                z3 = false;
                            }
                        }
                        f2 = f();
                        this.c = f2;
                        switch (f2) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                g(f2);
                                return 0.0f;
                        }
                        switch (this.c) {
                        }
                    }
                    if (!z3) {
                        i4 = -i4;
                    }
                    int i6 = i4 + i2;
                    if (!z) {
                        i = -i;
                    }
                    return b(i, i6);
                case '/':
                default:
                    return Float.NaN;
                case '0':
                    while (true) {
                        char f9 = f();
                        this.c = f9;
                        if (f9 == '.' || f9 == 'E' || f9 == 'e') {
                            i3 = 0;
                            i2 = 0;
                            i = 0;
                        } else {
                            switch (f9) {
                                case '0':
                                    break;
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    break;
                                default:
                                    return 0.0f;
                            }
                        }
                    }
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                    while (true) {
                        if (i3 >= 9) {
                            i3++;
                            i = (i * 10) + (this.c - '0');
                        } else {
                            i2++;
                        }
                        f3 = f();
                        this.c = f3;
                        switch (f3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                z2 = true;
                                if (this.c == '.') {
                                }
                                char c32 = this.c;
                                f = f();
                                this.c = f;
                                if (f != '+') {
                                }
                                f2 = f();
                                this.c = f2;
                                switch (f2) {
                                }
                                switch (this.c) {
                                }
                                if (!z3) {
                                }
                                int i62 = i4 + i2;
                                if (!z) {
                                }
                                return b(i, i62);
                        }
                    }
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                    while (true) {
                        if (i3 >= 9) {
                        }
                        f3 = f();
                        this.c = f3;
                        switch (f3) {
                        }
                    }
                    z2 = true;
                    if (this.c == '.') {
                    }
                    char c322 = this.c;
                    f = f();
                    this.c = f;
                    if (f != '+') {
                    }
                    f2 = f();
                    this.c = f2;
                    switch (f2) {
                    }
                    switch (this.c) {
                    }
                    if (!z3) {
                    }
                    int i622 = i4 + i2;
                    if (!z) {
                    }
                    return b(i, i622);
            }
        } else {
            z = false;
        }
        this.c = f();
        switch (this.c) {
        }
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229717358")) {
            ipChange.ipc$dispatch("-229717358", new Object[]{this});
            return;
        }
        while (true) {
            int i = this.d;
            if (i < this.b) {
                char c2 = this.a[i];
                if (c2 == '\t' || c2 == '\n' || c2 == ' ' || c2 == ',') {
                    a();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978916865")) {
            ipChange.ipc$dispatch("-978916865", new Object[]{this});
            return;
        }
        while (true) {
            int i = this.d;
            if (i < this.b && Character.isWhitespace(this.a[i])) {
                a();
            } else {
                return;
            }
        }
    }
}
