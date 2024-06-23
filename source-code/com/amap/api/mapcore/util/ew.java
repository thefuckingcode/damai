package com.amap.api.mapcore.util;

/* compiled from: Taobao */
public class ew {
    b a;

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.api.mapcore.util.ew$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            iArr[a.FAIL.ordinal()] = 1;
            a[a.PERFECT.ordinal()] = 2;
            try {
                a[a.FIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum a {
        FAIL,
        PERFECT,
        FIT
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b {
        static final /* synthetic */ boolean e = true;
        String a;
        c b;
        b c = null;
        b d = null;

        b(c cVar) {
            this.b = cVar;
        }

        /* access modifiers changed from: package-private */
        public b a(int i, int i2, String str) {
            if (!a()) {
                b a2 = this.c.a(i, i2, str);
                return a2 == null ? this.d.a(i, i2, str) : a2;
            } else if (this.a != null) {
                return null;
            } else {
                int i3 = AnonymousClass1.a[b(i, i2).ordinal()];
                if (i3 == 1) {
                    return null;
                }
                if (i3 != 2) {
                    if (i3 == 3) {
                        a(i, i2);
                    }
                    return this.c.a(i, i2, str);
                }
                this.a = str;
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.a != null || !a();
        }

        /* access modifiers changed from: package-private */
        public a b(int i, int i2) {
            int i3;
            c cVar = this.b;
            int i4 = cVar.c;
            if (i > i4 || i2 > (i3 = cVar.d)) {
                return a.FAIL;
            }
            if (i == i4 && i2 == i3) {
                return a.PERFECT;
            }
            return a.FIT;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.c == null;
        }

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            if (!a()) {
                boolean a2 = this.c.a(str);
                if (!a2) {
                    a2 = this.d.a(str);
                }
                if (a2 && !this.c.b() && !this.d.b()) {
                    this.c = null;
                    this.d = null;
                }
                return a2;
            } else if (!str.equals(this.a)) {
                return false;
            } else {
                this.a = null;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            c cVar;
            c cVar2;
            c cVar3 = this.b;
            int i3 = cVar3.c;
            int i4 = i3 - i;
            int i5 = cVar3.d;
            int i6 = i5 - i2;
            boolean z = e;
            if (!z && i4 < 0) {
                throw new AssertionError();
            } else if (z || i6 >= 0) {
                if (i4 > i6) {
                    cVar = new c(cVar3.a, cVar3.b, i, i5);
                    c cVar4 = this.b;
                    cVar2 = new c(cVar.a + i, cVar4.b, cVar4.c - i, cVar4.d);
                } else {
                    c cVar5 = new c(cVar3.a, cVar3.b, i3, i2);
                    c cVar6 = this.b;
                    cVar2 = new c(cVar6.a, cVar5.b + i2, cVar6.c, cVar6.d - i2);
                    cVar = cVar5;
                }
                this.c = new b(cVar);
                this.d = new b(cVar2);
            } else {
                throw new AssertionError();
            }
        }
    }

    /* compiled from: Taobao */
    public static class c {
        public int a;
        public int b;
        public int c;
        public int d;

        c(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public String toString() {
            return "[ x: " + this.a + ", y: " + this.b + ", w: " + this.c + ", h: " + this.d + " ]";
        }
    }

    public ew(int i, int i2) {
        this.a = new b(new c(0, 0, i, i2));
    }

    public c a(int i, int i2, String str) {
        b a2 = this.a.a(i, i2, str);
        if (a2 == null) {
            return null;
        }
        c cVar = a2.b;
        return new c(cVar.a, cVar.b, cVar.c, cVar.d);
    }

    public int b() {
        return this.a.b.d;
    }

    public boolean a(String str) {
        return this.a.a(str);
    }

    public int a() {
        return this.a.b.c;
    }
}
