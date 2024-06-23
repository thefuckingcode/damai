package com.loc;

import android.content.Context;
import android.text.TextUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;
import tb.c33;
import tb.d33;
import tb.f33;
import tb.r23;

/* compiled from: Taobao */
public class bs {
    static boolean a = false;
    static int b = 20;
    private static int c = 20;
    private static WeakReference<r23> d;
    private static int e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends ck {
        static int a = 1;
        static int b = 2;
        static int c = 3;
        private Context d;
        private d0 f;
        private int g;
        private List<d0> h;

        a(Context context, int i) {
            this.d = context;
            this.g = i;
        }

        a(Context context, int i, d0 d0Var) {
            this(context, i);
            this.f = d0Var;
        }

        a(Context context, int i, List<d0> list) {
            this(context, i);
            this.h = list;
        }

        /* JADX WARNING: Removed duplicated region for block: B:60:0x0081 A[SYNTHETIC, Splitter:B:60:0x0081] */
        @Override // com.loc.ck
        public final void a() {
            String str;
            String str2;
            Throwable th;
            Throwable th2;
            int i = this.g;
            if (i == 1) {
                try {
                    if (this.d == null) {
                        return;
                    }
                    if (this.f != null) {
                        synchronized (bs.class) {
                            Context context = this.d;
                            if (context != null) {
                                d0 d0Var = this.f;
                                if (d0Var != null) {
                                    bs.c(context, d0Var.b());
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    str = WPKFactory.CONF_SERVER_TIME;
                    str2 = "as";
                    an.m(th, str, str2);
                    return;
                }
            } else if (i == 2) {
                try {
                    synchronized (bs.class) {
                        if (this.h != null) {
                            if (this.d != null) {
                                ByteArrayOutputStream byteArrayOutputStream = null;
                                byte[] bArr = new byte[0];
                                try {
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    try {
                                        for (d0 d0Var2 : this.h) {
                                            if (d0Var2 != null) {
                                                byteArrayOutputStream2.write(d0Var2.b());
                                            }
                                        }
                                        bArr = byteArrayOutputStream2.toByteArray();
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        try {
                                            an.m(th, WPKFactory.CONF_SERVER_TIME, "aStB");
                                            if (byteArrayOutputStream != null) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Throwable th6) {
                                                    th2 = th6;
                                                }
                                            }
                                            bs.c(this.d, bArr);
                                            return;
                                        } catch (Throwable th7) {
                                            th7.printStackTrace();
                                        }
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    an.m(th, WPKFactory.CONF_SERVER_TIME, "aStB");
                                    if (byteArrayOutputStream != null) {
                                    }
                                    bs.c(this.d, bArr);
                                    return;
                                }
                                bs.c(this.d, bArr);
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    str = WPKFactory.CONF_SERVER_TIME;
                    str2 = "apb";
                    an.m(th, str, str2);
                    return;
                }
            } else if (i == 3) {
                try {
                    if (this.d != null) {
                        r23 d2 = e0.d(bs.d);
                        e0.e(this.d, d2, al.h, 1000, 307200, "2");
                        if (d2.g == null) {
                            d2.g = new f0(new j0(this.d, new g0(new k0(new n0()))));
                        }
                        d2.h = 3600000;
                        if (TextUtils.isEmpty(d2.i)) {
                            d2.i = "cKey";
                        }
                        if (d2.f == null) {
                            Context context2 = this.d;
                            d2.f = new f33(context2, d2.h, d2.i, new c33(d2.a, new d33(context2, bs.a, bs.c * 1024, bs.b * 1024, "staticUpdate", bs.e * 1024)));
                        }
                        b0.a(d2);
                        return;
                    }
                    return;
                } catch (Throwable th10) {
                    an.m(th10, WPKFactory.CONF_SERVER_TIME, "usd");
                    return;
                }
            } else {
                return;
            }
            th2.printStackTrace();
            bs.c(this.d, bArr);
            return;
            throw th;
        }
    }

    public static void b(Context context) {
        o0.f().d(new a(context, a.c));
    }

    static /* synthetic */ void c(Context context, byte[] bArr) throws IOException {
        r23 d2 = e0.d(d);
        e0.e(context, d2, al.h, 1000, 307200, "2");
        if (d2.e == null) {
            d2.e = new n();
        }
        Random random = new Random();
        try {
            b0.c(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, d2);
        } catch (Throwable th) {
            an.m(th, WPKFactory.CONF_SERVER_TIME, "wts");
        }
    }

    public static synchronized void d(d0 d0Var, Context context) {
        synchronized (bs.class) {
            o0.f().d(new a(context, a.a, d0Var));
        }
    }

    public static synchronized void e(List<d0> list, Context context) {
        synchronized (bs.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        o0.f().d(new a(context, a.b, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void f(boolean z, int i) {
        synchronized (bs.class) {
            a = z;
            e = Math.max(0, i);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0012 */
    public static synchronized void h(List<d0> list, Context context) {
        synchronized (bs.class) {
            List<d0> p = y.p();
            if (p != null && p.size() > 0) {
                list.addAll(p);
            }
            e(list, context);
        }
    }
}
