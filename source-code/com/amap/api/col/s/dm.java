package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* compiled from: Taobao */
public class dm {
    static boolean a = false;
    static int b = 20;
    private static int c = 20;
    private static WeakReference<dh> d;
    private static int e;

    public static synchronized void a(dl dlVar, Context context) {
        synchronized (dm.class) {
            ed.a().b(new a(context, a.a, dlVar));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends ee {
        static int a = 1;
        static int b = 2;
        static int c = 3;
        private Context d;
        private dl f;
        private int g;
        private List<dl> h;

        a(Context context, int i) {
            this.d = context;
            this.g = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:59:0x0081 A[SYNTHETIC, Splitter:B:59:0x0081] */
        @Override // com.amap.api.col.s.ee
        public final void a() {
            Throwable th;
            Throwable th2;
            int i = this.g;
            if (i == 1) {
                try {
                    if (this.d == null) {
                        return;
                    }
                    if (this.f != null) {
                        synchronized (dm.class) {
                            Context context = this.d;
                            if (context != null) {
                                dl dlVar = this.f;
                                if (dlVar != null) {
                                    dm.a(context, dlVar.a());
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th3) {
                    cl.c(th3, WPKFactory.CONF_SERVER_TIME, "as");
                    return;
                }
            } else if (i == 2) {
                try {
                    synchronized (dm.class) {
                        if (this.h != null) {
                            if (this.d != null) {
                                ByteArrayOutputStream byteArrayOutputStream = null;
                                byte[] bArr = new byte[0];
                                try {
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    try {
                                        for (dl dlVar2 : this.h) {
                                            if (dlVar2 != null) {
                                                byteArrayOutputStream2.write(dlVar2.a());
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
                                            cl.c(th, WPKFactory.CONF_SERVER_TIME, "aStB");
                                            if (byteArrayOutputStream != null) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Throwable th6) {
                                                    th2 = th6;
                                                }
                                            }
                                            dm.a(this.d, bArr);
                                            return;
                                        } catch (Throwable th7) {
                                            th7.printStackTrace();
                                        }
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    cl.c(th, WPKFactory.CONF_SERVER_TIME, "aStB");
                                    if (byteArrayOutputStream != null) {
                                    }
                                    dm.a(this.d, bArr);
                                    return;
                                }
                                dm.a(this.d, bArr);
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th9) {
                    cl.c(th9, WPKFactory.CONF_SERVER_TIME, "apb");
                    return;
                }
            } else if (i == 3) {
                try {
                    if (this.d != null) {
                        dh a2 = dn.a(dm.d);
                        dn.a(this.d, a2, cj.h, 1000, 307200, "2");
                        if (a2.g == null) {
                            a2.g = new Cdo(new ds(this.d, new dp(new dt(new dv()))));
                        }
                        a2.h = 3600000;
                        if (TextUtils.isEmpty(a2.i)) {
                            a2.i = "cKey";
                        }
                        if (a2.f == null) {
                            Context context2 = this.d;
                            a2.f = new dz(context2, a2.h, a2.i, new dw(a2.a, new dx(context2, dm.a, dm.c * 1024, dm.b * 1024, "staticUpdate", dm.e * 1024)));
                        }
                        di.a(a2);
                        return;
                    }
                    return;
                } catch (Throwable th10) {
                    cl.c(th10, WPKFactory.CONF_SERVER_TIME, "usd");
                    return;
                }
            } else {
                return;
            }
            th2.printStackTrace();
            dm.a(this.d, bArr);
            return;
            throw th;
        }

        a(Context context, int i, List<dl> list) {
            this(context, i);
            this.h = list;
        }

        a(Context context, int i, dl dlVar) {
            this(context, i);
            this.f = dlVar;
        }
    }

    public static synchronized void a(List<dl> list, Context context) {
        synchronized (dm.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        ed.a().b(new a(context, a.b, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void a(Context context) {
        ed.a().b(new a(context, a.c));
    }

    static /* synthetic */ void a(Context context, byte[] bArr) throws IOException {
        dh a2 = dn.a(d);
        dn.a(context, a2, cj.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new cp();
        }
        Random random = new Random();
        try {
            di.a(Integer.toString(random.nextInt(100)) + Long.toString(System.nanoTime()), bArr, a2);
        } catch (Throwable th) {
            cl.c(th, WPKFactory.CONF_SERVER_TIME, "wts");
        }
    }
}
