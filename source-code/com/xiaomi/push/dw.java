package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: Taobao */
public final class dw {

    /* compiled from: Taobao */
    public static final class a extends e {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f227a = Collections.emptyList();

        /* renamed from: a  reason: collision with other field name */
        private boolean f228a;
        private int b = 0;

        /* renamed from: b  reason: collision with other field name */
        private boolean f229b;
        private int c = -1;

        /* renamed from: c  reason: collision with other field name */
        private boolean f230c = false;
        private boolean d;
        private boolean e;
        private boolean f = false;

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        public int a() {
            if (this.c < 0) {
                b();
            }
            return this.c;
        }

        public a a(int i) {
            this.f228a = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int a2 = bVar.m260a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(bVar.c());
                } else if (a2 == 16) {
                    a(bVar.m266a());
                } else if (a2 == 24) {
                    b(bVar.m269b());
                } else if (a2 == 32) {
                    b(bVar.m266a());
                } else if (a2 == 42) {
                    a(bVar.m263a());
                } else if (!a(bVar, a2)) {
                    return this;
                }
            }
        }

        public a a(String str) {
            Objects.requireNonNull(str);
            if (this.f227a.isEmpty()) {
                this.f227a = new ArrayList();
            }
            this.f227a.add(str);
            return this;
        }

        public a a(boolean z) {
            this.f229b = true;
            this.f230c = z;
            return this;
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public List<String> m360a() {
            return this.f227a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m361a()) {
                cVar.m318b(1, c());
            }
            if (m363c()) {
                cVar.m310a(2, m362b());
            }
            if (m364d()) {
                cVar.m305a(3, d());
            }
            if (f()) {
                cVar.m310a(4, m365e());
            }
            for (String str : m360a()) {
                cVar.m309a(5, str);
            }
        }

        @Override // com.xiaomi.push.e, com.xiaomi.push.e
        /* renamed from: a  reason: collision with other method in class */
        public boolean m361a() {
            return this.f228a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            int b2 = m361a() ? c.b(1, c()) + 0 : 0;
            if (m363c()) {
                b2 += c.a(2, m362b());
            }
            if (m364d()) {
                b2 += c.a(3, d());
            }
            if (f()) {
                b2 += c.a(4, m365e());
            }
            for (String str : m360a()) {
                i += c.a(str);
            }
            int size = b2 + i + (m360a().size() * 1);
            this.c = size;
            return size;
        }

        public a b(int i) {
            this.d = true;
            this.b = i;
            return this;
        }

        public a b(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        /* renamed from: b  reason: collision with other method in class */
        public boolean m362b() {
            return this.f230c;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m363c() {
            return this.f229b;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m364d() {
            return this.d;
        }

        public int e() {
            return this.f227a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m365e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }
    }
}
