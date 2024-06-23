package com.meizu.cloud.pushsdk.d.c;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushsdk.d.a.c;
import com.meizu.cloud.pushsdk.d.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
public class b extends a {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final int i;

    /* compiled from: Taobao */
    public static abstract class a<T extends a<T>> extends a.AbstractC0188a<T> {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private int i = 0;

        public T a(int i2) {
            this.i = i2;
            return (T) ((a) a());
        }

        public T a(String str) {
            this.a = str;
            return (T) ((a) a());
        }

        public T b(String str) {
            this.b = str;
            return (T) ((a) a());
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.c = str;
            return (T) ((a) a());
        }

        public T d(String str) {
            this.d = str;
            return (T) ((a) a());
        }

        public T e(String str) {
            this.e = str;
            return (T) ((a) a());
        }

        public T f(String str) {
            this.f = str;
            return (T) ((a) a());
        }

        public T g(String str) {
            this.g = str;
            return (T) ((a) a());
        }

        public T h(String str) {
            this.h = str;
            return (T) ((a) a());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.meizu.cloud.pushsdk.d.c.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0189b extends a<C0189b> {
        private C0189b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public C0189b a() {
            return this;
        }
    }

    protected b(a<?> aVar) {
        super(aVar);
        this.b = ((a) aVar).b;
        this.c = ((a) aVar).c;
        this.a = ((a) aVar).a;
        this.d = ((a) aVar).d;
        this.e = ((a) aVar).e;
        this.f = ((a) aVar).f;
        this.g = ((a) aVar).g;
        this.h = ((a) aVar).h;
        this.i = ((a) aVar).i;
    }

    public static a<?> d() {
        return new C0189b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.a);
        cVar.a(IRequestConst.TI, this.b);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.c);
        cVar.a(XStateConstants.KEY_PV, this.d);
        cVar.a(IRequestConst.PN, this.e);
        cVar.a("si", this.f);
        cVar.a("ms", this.g);
        cVar.a("ect", this.h);
        cVar.a(BrightRemindSetting.BRIGHT_REMIND, Integer.valueOf(this.i));
        return a(cVar);
    }
}
