package com.xiaomi.push;

import java.util.Objects;

/* compiled from: Taobao */
public final class dx {

    /* compiled from: Taobao */
    public static final class a extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f231a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f232a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f233a;
        private int b = 1;

        /* renamed from: b  reason: collision with other field name */
        private String f234b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f235b;
        private int c = 0;

        /* renamed from: c  reason: collision with other field name */
        private String f236c = "";

        /* renamed from: c  reason: collision with other field name */
        private boolean f237c;
        private int d = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f238d = "";

        /* renamed from: d  reason: collision with other field name */
        private boolean f239d;
        private int e = -1;

        /* renamed from: e  reason: collision with other field name */
        private String f240e = "";

        /* renamed from: e  reason: collision with other field name */
        private boolean f241e;
        private String f = "";

        /* renamed from: f  reason: collision with other field name */
        private boolean f242f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public long m366a() {
            return this.f231a;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public a m367a() {
            this.f242f = false;
            this.f238d = "";
            return this;
        }

        public a a(int i2) {
            this.f233a = true;
            this.a = i2;
            return this;
        }

        public a a(long j2) {
            this.f235b = true;
            this.f231a = j2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                switch (a2) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m269b());
                        break;
                    case 16:
                        a(bVar.m270b());
                        break;
                    case 26:
                        a(bVar.m263a());
                        break;
                    case 34:
                        b(bVar.m263a());
                        break;
                    case 42:
                        c(bVar.m263a());
                        break;
                    case 50:
                        d(bVar.m263a());
                        break;
                    case 58:
                        e(bVar.m263a());
                        break;
                    case 64:
                        b(bVar.m269b());
                        break;
                    case 72:
                        c(bVar.m269b());
                        break;
                    case 80:
                        d(bVar.m269b());
                        break;
                    case 90:
                        f(bVar.m263a());
                        break;
                    default:
                        if (a(bVar, a2)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public a a(String str) {
            this.f237c = true;
            this.f232a = str;
            return this;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String m368a() {
            return this.f232a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m369a()) {
                cVar.m305a(1, c());
            }
            if (m371b()) {
                cVar.m319b(2, m366a());
            }
            if (m373c()) {
                cVar.m309a(3, m368a());
            }
            if (m375d()) {
                cVar.m309a(4, m370b());
            }
            if (m377e()) {
                cVar.m309a(5, m372c());
            }
            if (m379f()) {
                cVar.m309a(6, m374d());
            }
            if (g()) {
                cVar.m309a(7, m376e());
            }
            if (h()) {
                cVar.m305a(8, d());
            }
            if (i()) {
                cVar.m305a(9, e());
            }
            if (j()) {
                cVar.m305a(10, f());
            }
            if (k()) {
                cVar.m309a(11, m378f());
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m369a() {
            return this.f233a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i2 = 0;
            if (m369a()) {
                i2 = 0 + c.a(1, c());
            }
            if (m371b()) {
                i2 += c.b(2, m366a());
            }
            if (m373c()) {
                i2 += c.a(3, m368a());
            }
            if (m375d()) {
                i2 += c.a(4, m370b());
            }
            if (m377e()) {
                i2 += c.a(5, m372c());
            }
            if (m379f()) {
                i2 += c.a(6, m374d());
            }
            if (g()) {
                i2 += c.a(7, m376e());
            }
            if (h()) {
                i2 += c.a(8, d());
            }
            if (i()) {
                i2 += c.a(9, e());
            }
            if (j()) {
                i2 += c.a(10, f());
            }
            if (k()) {
                i2 += c.a(11, m378f());
            }
            this.e = i2;
            return i2;
        }

        public a b(int i2) {
            this.h = true;
            this.b = i2;
            return this;
        }

        public a b(String str) {
            this.f239d = true;
            this.f234b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String m370b() {
            return this.f234b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean m371b() {
            return this.f235b;
        }

        public int c() {
            return this.a;
        }

        public a c(int i2) {
            this.i = true;
            this.c = i2;
            return this;
        }

        public a c(String str) {
            this.f241e = true;
            this.f236c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m372c() {
            return this.f236c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m373c() {
            return this.f237c;
        }

        public int d() {
            return this.b;
        }

        public a d(int i2) {
            this.j = true;
            this.d = i2;
            return this;
        }

        public a d(String str) {
            this.f242f = true;
            this.f238d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m374d() {
            return this.f238d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m375d() {
            return this.f239d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f240e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m376e() {
            return this.f240e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m377e() {
            return this.f241e;
        }

        public int f() {
            return this.d;
        }

        public a f(String str) {
            this.k = true;
            this.f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m378f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m379f() {
            return this.f242f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }
    }

    /* compiled from: Taobao */
    public static final class b extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private boolean f243a;
        private int b = 0;

        /* renamed from: b  reason: collision with other field name */
        private boolean f244b = false;
        private int c = 0;

        /* renamed from: c  reason: collision with other field name */
        private boolean f245c;
        private int d = -1;

        /* renamed from: d  reason: collision with other field name */
        private boolean f246d;
        private boolean e;

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        public b a(int i) {
            this.f245c = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public b a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.m266a());
                } else if (a2 == 24) {
                    a(bVar.m269b());
                } else if (a2 == 32) {
                    b(bVar.m269b());
                } else if (a2 == 40) {
                    c(bVar.m269b());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            this.f243a = true;
            this.f244b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m381b()) {
                cVar.m310a(1, m380a());
            }
            if (m382c()) {
                cVar.m305a(3, c());
            }
            if (m383d()) {
                cVar.m305a(4, d());
            }
            if (m384e()) {
                cVar.m305a(5, e());
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m380a() {
            return this.f244b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m381b()) {
                i = 0 + c.a(1, m380a());
            }
            if (m382c()) {
                i += c.a(3, c());
            }
            if (m383d()) {
                i += c.a(4, d());
            }
            if (m384e()) {
                i += c.a(5, e());
            }
            this.d = i;
            return i;
        }

        public b b(int i) {
            this.f246d = true;
            this.b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean m381b() {
            return this.f243a;
        }

        public int c() {
            return this.a;
        }

        public b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m382c() {
            return this.f245c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m383d() {
            return this.f246d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m384e() {
            return this.e;
        }
    }

    /* compiled from: Taobao */
    public static final class c extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private String f247a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f248a;
        private String b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f249b;
        private String c = "";

        /* renamed from: c  reason: collision with other field name */
        private boolean f250c;
        private String d = "";

        /* renamed from: d  reason: collision with other field name */
        private boolean f251d;
        private String e = "";

        /* renamed from: e  reason: collision with other field name */
        private boolean f252e;
        private String f = "";

        /* renamed from: f  reason: collision with other field name */
        private boolean f253f;

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public c a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m263a());
                } else if (a2 == 18) {
                    b(bVar.m263a());
                } else if (a2 == 26) {
                    c(bVar.m263a());
                } else if (a2 == 34) {
                    d(bVar.m263a());
                } else if (a2 == 42) {
                    e(bVar.m263a());
                } else if (a2 == 50) {
                    f(bVar.m263a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public c a(String str) {
            this.f248a = true;
            this.f247a = str;
            return this;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String m385a() {
            return this.f247a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m386a()) {
                cVar.m309a(1, m385a());
            }
            if (m388b()) {
                cVar.m309a(2, m387b());
            }
            if (m389c()) {
                cVar.m309a(3, c());
            }
            if (m390d()) {
                cVar.m309a(4, d());
            }
            if (m391e()) {
                cVar.m309a(5, e());
            }
            if (m392f()) {
                cVar.m309a(6, f());
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m386a() {
            return this.f248a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m386a()) {
                i = 0 + c.a(1, m385a());
            }
            if (m388b()) {
                i += c.a(2, m387b());
            }
            if (m389c()) {
                i += c.a(3, c());
            }
            if (m390d()) {
                i += c.a(4, d());
            }
            if (m391e()) {
                i += c.a(5, e());
            }
            if (m392f()) {
                i += c.a(6, f());
            }
            this.a = i;
            return i;
        }

        public c b(String str) {
            this.f249b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String m387b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean m388b() {
            return this.f249b;
        }

        public c c(String str) {
            this.f250c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m389c() {
            return this.f250c;
        }

        public c d(String str) {
            this.f251d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m390d() {
            return this.f251d;
        }

        public c e(String str) {
            this.f252e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m391e() {
            return this.f252e;
        }

        public c f(String str) {
            this.f253f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m392f() {
            return this.f253f;
        }
    }

    /* compiled from: Taobao */
    public static final class d extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private String f254a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f255a;
        private String b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f256b = false;
        private String c = "";

        /* renamed from: c  reason: collision with other field name */
        private boolean f257c;
        private boolean d;
        private boolean e;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public d a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.m266a());
                } else if (a2 == 18) {
                    a(bVar.m263a());
                } else if (a2 == 26) {
                    b(bVar.m263a());
                } else if (a2 == 34) {
                    c(bVar.m263a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public d a(String str) {
            this.f257c = true;
            this.f254a = str;
            return this;
        }

        public d a(boolean z) {
            this.f255a = true;
            this.f256b = z;
            return this;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String m393a() {
            return this.f254a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m396b()) {
                cVar.m310a(1, m394a());
            }
            if (m397c()) {
                cVar.m309a(2, m393a());
            }
            if (d()) {
                cVar.m309a(3, m395b());
            }
            if (e()) {
                cVar.m309a(4, c());
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m394a() {
            return this.f256b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m396b()) {
                i = 0 + c.a(1, m394a());
            }
            if (m397c()) {
                i += c.a(2, m393a());
            }
            if (d()) {
                i += c.a(3, m395b());
            }
            if (e()) {
                i += c.a(4, c());
            }
            this.a = i;
            return i;
        }

        public d b(String str) {
            this.d = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String m395b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean m396b() {
            return this.f255a;
        }

        public d c(String str) {
            this.e = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m397c() {
            return this.f257c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }
    }

    /* compiled from: Taobao */
    public static final class e extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private b f258a = null;

        /* renamed from: a  reason: collision with other field name */
        private String f259a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f260a;
        private int b = 0;

        /* renamed from: b  reason: collision with other field name */
        private String f261b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f262b;
        private int c = 0;

        /* renamed from: c  reason: collision with other field name */
        private String f263c = "";

        /* renamed from: c  reason: collision with other field name */
        private boolean f264c;
        private int d = -1;

        /* renamed from: d  reason: collision with other field name */
        private String f265d = "";

        /* renamed from: d  reason: collision with other field name */
        private boolean f266d;
        private String e = "";

        /* renamed from: e  reason: collision with other field name */
        private boolean f267e;
        private String f = "";

        /* renamed from: f  reason: collision with other field name */
        private boolean f268f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public b m398a() {
            return this.f258a;
        }

        public e a(int i2) {
            this.f260a = true;
            this.a = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public e a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                switch (a2) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m263a());
                        break;
                    case 26:
                        b(bVar.m263a());
                        break;
                    case 34:
                        c(bVar.m263a());
                        break;
                    case 40:
                        b(bVar.m269b());
                        break;
                    case 50:
                        d(bVar.m263a());
                        break;
                    case 58:
                        e(bVar.m263a());
                        break;
                    case 66:
                        f(bVar.m263a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m269b());
                        break;
                    default:
                        if (a(bVar, a2)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public e a(b bVar) {
            Objects.requireNonNull(bVar);
            this.i = true;
            this.f258a = bVar;
            return this;
        }

        public e a(String str) {
            this.f262b = true;
            this.f259a = str;
            return this;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String m399a() {
            return this.f259a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m400a()) {
                cVar.m318b(1, c());
            }
            if (m402b()) {
                cVar.m309a(2, m399a());
            }
            if (m404c()) {
                cVar.m309a(3, m401b());
            }
            if (m406d()) {
                cVar.m309a(4, m403c());
            }
            if (m408e()) {
                cVar.m305a(5, d());
            }
            if (m409f()) {
                cVar.m309a(6, m405d());
            }
            if (g()) {
                cVar.m309a(7, m407e());
            }
            if (h()) {
                cVar.m309a(8, f());
            }
            if (i()) {
                cVar.m308a(9, (e) m398a());
            }
            if (j()) {
                cVar.m305a(10, e());
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m400a() {
            return this.f260a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i2 = 0;
            if (m400a()) {
                i2 = 0 + c.b(1, c());
            }
            if (m402b()) {
                i2 += c.a(2, m399a());
            }
            if (m404c()) {
                i2 += c.a(3, m401b());
            }
            if (m406d()) {
                i2 += c.a(4, m403c());
            }
            if (m408e()) {
                i2 += c.a(5, d());
            }
            if (m409f()) {
                i2 += c.a(6, m405d());
            }
            if (g()) {
                i2 += c.a(7, m407e());
            }
            if (h()) {
                i2 += c.a(8, f());
            }
            if (i()) {
                i2 += c.a(9, (e) m398a());
            }
            if (j()) {
                i2 += c.a(10, e());
            }
            this.d = i2;
            return i2;
        }

        public e b(int i2) {
            this.f267e = true;
            this.b = i2;
            return this;
        }

        public e b(String str) {
            this.f264c = true;
            this.f261b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String m401b() {
            return this.f261b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean m402b() {
            return this.f262b;
        }

        public int c() {
            return this.a;
        }

        public e c(int i2) {
            this.j = true;
            this.c = i2;
            return this;
        }

        public e c(String str) {
            this.f266d = true;
            this.f263c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m403c() {
            return this.f263c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m404c() {
            return this.f264c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f268f = true;
            this.f265d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m405d() {
            return this.f265d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m406d() {
            return this.f266d;
        }

        public int e() {
            return this.c;
        }

        public e e(String str) {
            this.g = true;
            this.e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m407e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m408e() {
            return this.f267e;
        }

        public e f(String str) {
            this.h = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m409f() {
            return this.f268f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }
    }

    /* compiled from: Taobao */
    public static final class f extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private b f269a = null;

        /* renamed from: a  reason: collision with other field name */
        private String f270a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f271a;
        private String b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f272b;
        private boolean c;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public b m410a() {
            return this.f269a;
        }

        @Override // com.xiaomi.push.e
        public f a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m263a());
                } else if (a2 == 18) {
                    b(bVar.m263a());
                } else if (a2 == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            Objects.requireNonNull(bVar);
            this.c = true;
            this.f269a = bVar;
            return this;
        }

        public f a(String str) {
            this.f271a = true;
            this.f270a = str;
            return this;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String m411a() {
            return this.f270a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m412a()) {
                cVar.m309a(1, m411a());
            }
            if (m414b()) {
                cVar.m309a(2, m413b());
            }
            if (c()) {
                cVar.m308a(3, (e) m410a());
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m412a() {
            return this.f271a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m412a()) {
                i = 0 + c.a(1, m411a());
            }
            if (m414b()) {
                i += c.a(2, m413b());
            }
            if (c()) {
                i += c.a(3, (e) m410a());
            }
            this.a = i;
            return i;
        }

        public f b(String str) {
            this.f272b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String m413b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean m414b() {
            return this.f272b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* compiled from: Taobao */
    public static final class g extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private String f273a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f274a;
        private String b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f275b;
        private String c = "";

        /* renamed from: c  reason: collision with other field name */
        private boolean f276c;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public g a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m263a());
                } else if (a2 == 18) {
                    b(bVar.m263a());
                } else if (a2 == 26) {
                    c(bVar.m263a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public g a(String str) {
            this.f274a = true;
            this.f273a = str;
            return this;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String m415a() {
            return this.f273a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m416a()) {
                cVar.m309a(1, m415a());
            }
            if (m418b()) {
                cVar.m309a(2, m417b());
            }
            if (m419c()) {
                cVar.m309a(3, c());
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m416a() {
            return this.f274a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m416a()) {
                i = 0 + c.a(1, m415a());
            }
            if (m418b()) {
                i += c.a(2, m417b());
            }
            if (m419c()) {
                i += c.a(3, c());
            }
            this.a = i;
            return i;
        }

        public g b(String str) {
            this.f275b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String m417b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean m418b() {
            return this.f275b;
        }

        public g c(String str) {
            this.f276c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m419c() {
            return this.f276c;
        }
    }

    /* compiled from: Taobao */
    public static final class h extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f277a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f278a;
        private int b = -1;

        /* renamed from: b  reason: collision with other field name */
        private boolean f279b;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        public h a(int i) {
            this.f278a = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public h a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.m269b());
                } else if (a2 == 18) {
                    a(bVar.m263a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public h a(String str) {
            this.f279b = true;
            this.f277a = str;
            return this;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String m420a() {
            return this.f277a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m421a()) {
                cVar.m305a(1, c());
            }
            if (m422b()) {
                cVar.m309a(2, m420a());
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m421a() {
            return this.f278a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m421a()) {
                i = 0 + c.a(1, c());
            }
            if (m422b()) {
                i += c.a(2, m420a());
            }
            this.b = i;
            return i;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean m422b() {
            return this.f279b;
        }

        public int c() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    public static final class i extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private a f280a = a.a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f281a;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public a m423a() {
            return this.f280a;
        }

        public i a(a aVar) {
            this.f281a = true;
            this.f280a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public i a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m262a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m424a()) {
                cVar.m307a(1, m423a());
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m424a() {
            return this.f281a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m424a()) {
                i = 0 + c.a(1, m423a());
            }
            this.a = i;
            return i;
        }
    }

    /* compiled from: Taobao */
    public static final class j extends e {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private a f282a = a.a;

        /* renamed from: a  reason: collision with other field name */
        private b f283a = null;

        /* renamed from: a  reason: collision with other field name */
        private boolean f284a;
        private boolean b;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public a m425a() {
            return this.f282a;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public b m426a() {
            return this.f283a;
        }

        public j a(a aVar) {
            this.f284a = true;
            this.f282a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public j a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m262a());
                } else if (a2 == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            Objects.requireNonNull(bVar);
            this.b = true;
            this.f283a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m427a()) {
                cVar.m307a(1, m425a());
            }
            if (m428b()) {
                cVar.m308a(2, (e) m426a());
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m427a() {
            return this.f284a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m427a()) {
                i = 0 + c.a(1, m425a());
            }
            if (m428b()) {
                i += c.a(2, (e) m426a());
            }
            this.a = i;
            return i;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean m428b() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    public static final class k extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f285a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f286a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f287a;
        private int b = -1;

        /* renamed from: b  reason: collision with other field name */
        private long f288b = 0;

        /* renamed from: b  reason: collision with other field name */
        private String f289b = "";

        /* renamed from: b  reason: collision with other field name */
        private boolean f290b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f = false;
        private boolean g;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public long m429a() {
            return this.f285a;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f285a = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public k a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 10) {
                    a(bVar.m263a());
                } else if (a2 == 18) {
                    b(bVar.m263a());
                } else if (a2 == 24) {
                    a(bVar.m261a());
                } else if (a2 == 32) {
                    b(bVar.m261a());
                } else if (a2 == 40) {
                    a(bVar.m266a());
                } else if (a2 == 48) {
                    a(bVar.m269b());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public k a(String str) {
            this.f287a = true;
            this.f286a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public String m430a() {
            return this.f286a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m431a()) {
                cVar.m309a(1, m430a());
            }
            if (m434b()) {
                cVar.m309a(2, m433b());
            }
            if (m435c()) {
                cVar.m306a(3, m429a());
            }
            if (d()) {
                cVar.m306a(4, m432b());
            }
            if (f()) {
                cVar.m310a(5, e());
            }
            if (g()) {
                cVar.m305a(6, c());
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m431a() {
            return this.f287a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m431a()) {
                i = 0 + c.a(1, m430a());
            }
            if (m434b()) {
                i += c.a(2, m433b());
            }
            if (m435c()) {
                i += c.a(3, m429a());
            }
            if (d()) {
                i += c.a(4, m432b());
            }
            if (f()) {
                i += c.a(5, e());
            }
            if (g()) {
                i += c.a(6, c());
            }
            this.b = i;
            return i;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public long m432b() {
            return this.f288b;
        }

        public k b(long j) {
            this.d = true;
            this.f288b = j;
            return this;
        }

        public k b(String str) {
            this.f290b = true;
            this.f289b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public String m433b() {
            return this.f289b;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean m434b() {
            return this.f290b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m435c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }

        public boolean g() {
            return this.g;
        }
    }
}
