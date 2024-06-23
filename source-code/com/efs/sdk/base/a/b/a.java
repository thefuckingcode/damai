package com.efs.sdk.base.a.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.Constants;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import tb.g23;
import tb.g63;
import tb.k53;
import tb.n13;
import tb.r03;
import tb.t43;
import tb.w23;

/* compiled from: Taobao */
public final class a {
    public boolean a;
    public boolean b;
    public b c;
    public C0151a d;

    /* renamed from: com.efs.sdk.base.a.b.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0151a implements Comparator<File> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            int i = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i == 0 ? 0 : -1;
        }
    }

    /* compiled from: Taobao */
    public static class b {
        private static final a a = new a((byte) 0);
    }

    private a() {
        this.a = false;
        this.b = true;
        this.c = new b();
        this.d = new C0151a();
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    static boolean c(String str) {
        try {
            long parseLong = Long.parseLong(str.substring(str.lastIndexOf(JSMethod.NOT_SET) + 1));
            r03.c();
            return Math.abs(r03.e() - parseLong) >= 604800000;
        } catch (Throwable unused) {
            return true;
        }
    }

    static void d(@NonNull File file) {
        if (!file.getName().startsWith("wa_")) {
            k53.a.a.c.e();
        }
        w23.i(file);
    }

    static void e(File file) {
        StringBuilder sb = new StringBuilder("file is expire: ");
        sb.append(file.getName());
        sb.append(", now is ");
        r03.c();
        sb.append(r03.e());
        t43.a("efs.cache", sb.toString());
        if (!file.getName().startsWith("wa_")) {
            k53.a.a.c.d();
        }
        w23.i(file);
    }

    @Nullable
    public final g23 a(File file) {
        try {
            if (!file.exists()) {
                return null;
            }
            if (c(file.getName())) {
                e(file);
                return null;
            }
            g23 h = w23.h(file.getName());
            if (h == null) {
                d(file);
                return null;
            }
            e a2 = this.c.a(h.a.b);
            if (a2 == null) {
                d(file);
                return null;
            } else if (a2.a(file, h)) {
                return h;
            } else {
                d(file);
                return null;
            }
        } catch (Throwable th) {
            t43.b(Constants.TAG, "efs.cache", th);
            d(file);
            return null;
        }
    }

    public final void b() {
        String[] list;
        e a2;
        File e = n13.e(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a);
        if (e.exists() && e.isDirectory() && (list = e.list()) != null && list.length > 0) {
            for (String str : list) {
                if (!g63.b(com.efs.sdk.base.a.d.a.a().c, str)) {
                    File file = new File(e, str);
                    List<File> k = w23.k(file);
                    if (!k.isEmpty()) {
                        for (File file2 : k) {
                            if (c(file2.getName())) {
                                e(file2);
                            } else {
                                g23 h = w23.h(file2.getName());
                                if (h == null || (a2 = this.c.a(h.a.b)) == null) {
                                    d(file2);
                                } else {
                                    a2.a(file2);
                                }
                            }
                        }
                    }
                    w23.i(file);
                }
            }
        }
    }
}
