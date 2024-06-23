package com.alibaba.aliweex;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.adapter.IAliPayModuleAdapter;
import com.alibaba.aliweex.adapter.IConfigGeneratorAdapter;
import com.alibaba.aliweex.adapter.IEventModuleAdapter;
import com.alibaba.aliweex.adapter.IFestivalModuleAdapter;
import com.alibaba.aliweex.adapter.IGodEyeStageAdapter;
import com.alibaba.aliweex.adapter.INavigationBarModuleAdapter;
import com.alibaba.aliweex.adapter.IPageInfoModuleAdapter;
import com.alibaba.aliweex.adapter.IShareModuleAdapter;
import com.alibaba.aliweex.adapter.IUserModuleAdapter;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class a {
    private static a c;
    @NonNull
    private Application a;
    private C0069a b;

    /* renamed from: com.alibaba.aliweex.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0069a {
        IShareModuleAdapter a;
        IUserModuleAdapter b;
        IEventModuleAdapter c;
        IPageInfoModuleAdapter d;
        IAliPayModuleAdapter e;
        IConfigGeneratorAdapter f;
        INavigationBarModuleAdapter g;
        IConfigAdapter h;
        IFestivalModuleAdapter i;
        IWXImgLoaderAdapter j;
        IWXHttpAdapter k;
        List<String> l;
        IGodEyeStageAdapter m;
        com.taobao.weex.a n;

        /* renamed from: com.alibaba.aliweex.a$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static class C0070a {
            IShareModuleAdapter a;
            IUserModuleAdapter b;
            IEventModuleAdapter c;
            IPageInfoModuleAdapter d;
            IConfigGeneratorAdapter e;
            IAliPayModuleAdapter f;
            IConfigAdapter g;
            IFestivalModuleAdapter h;
            IWXImgLoaderAdapter i;
            IWXHttpAdapter j;
            List<String> k = new LinkedList();
            com.taobao.weex.a l;
            IGodEyeStageAdapter m;

            public C0069a a() {
                C0069a aVar = new C0069a();
                aVar.a = this.a;
                aVar.b = this.b;
                aVar.c = this.c;
                aVar.d = this.d;
                aVar.e = this.f;
                aVar.f = this.e;
                aVar.h = this.g;
                aVar.i = this.h;
                aVar.j = this.i;
                aVar.k = this.j;
                aVar.n = this.l;
                aVar.l = this.k;
                aVar.m = this.m;
                return aVar;
            }
        }

        /* access modifiers changed from: package-private */
        public IAliPayModuleAdapter a() {
            return this.e;
        }

        /* access modifiers changed from: package-private */
        public IConfigAdapter b() {
            return this.h;
        }

        /* access modifiers changed from: package-private */
        public IConfigGeneratorAdapter c() {
            return this.f;
        }

        /* access modifiers changed from: package-private */
        public IEventModuleAdapter d() {
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public IFestivalModuleAdapter e() {
            return this.i;
        }

        /* access modifiers changed from: package-private */
        public IWXHttpAdapter f() {
            return this.k;
        }

        /* access modifiers changed from: package-private */
        public IWXImgLoaderAdapter g() {
            return this.j;
        }

        /* access modifiers changed from: package-private */
        public com.taobao.weex.a h() {
            return this.n;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Iterable<String> i() {
            if (this.l == null) {
                this.l = new LinkedList();
            }
            return this.l;
        }

        /* access modifiers changed from: package-private */
        public INavigationBarModuleAdapter j() {
            return this.g;
        }

        /* access modifiers changed from: package-private */
        public IPageInfoModuleAdapter k() {
            return this.d;
        }

        /* access modifiers changed from: package-private */
        public IShareModuleAdapter l() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public IUserModuleAdapter m() {
            return this.b;
        }
    }

    public static a l() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public IAliPayModuleAdapter a() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public Application b() {
        return this.a;
    }

    public IConfigAdapter c() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public IConfigGeneratorAdapter d() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public Context e() {
        return this.a.getApplicationContext();
    }

    public IEventModuleAdapter f() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public IFestivalModuleAdapter g() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    public IGodEyeStageAdapter h() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.m;
        }
        return null;
    }

    public IWXHttpAdapter i() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.f();
        }
        return null;
    }

    public IWXImgLoaderAdapter j() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.g();
        }
        return null;
    }

    public com.taobao.weex.a k() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.h();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Iterable<String> m() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.i();
        }
        return null;
    }

    public INavigationBarModuleAdapter n() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.j();
        }
        return null;
    }

    public IPageInfoModuleAdapter o() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.k();
        }
        return null;
    }

    public IShareModuleAdapter p() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.l();
        }
        return null;
    }

    public IUserModuleAdapter q() {
        C0069a aVar = this.b;
        if (aVar != null) {
            return aVar.m();
        }
        return null;
    }

    public void r(Application application, C0069a aVar) {
        this.a = application;
        this.b = aVar;
    }

    public void s(String str, Map<String, Object> map) {
        IGodEyeStageAdapter iGodEyeStageAdapter;
        C0069a aVar = this.b;
        if (aVar != null && (iGodEyeStageAdapter = aVar.m) != null) {
            iGodEyeStageAdapter.onStage(str, map);
        }
    }
}
