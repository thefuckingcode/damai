package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.ae;
import com.amap.api.col.s.df;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.util.Map;

/* compiled from: Taobao */
public abstract class a<T, V> extends br {
    protected boolean a = true;
    protected T b;
    protected int c = 1;
    protected String d = "";
    protected Context e;
    protected String f = "";
    private int k = 1;

    public a(Context context, T t) {
        a(context, t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v4, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0098 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a1 A[SYNTHETIC, Splitter:B:39:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c3 A[SYNTHETIC, Splitter:B:46:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0110 A[SYNTHETIC] */
    private V A() throws AMapException {
        V v;
        Throwable th;
        bj e2;
        AMapException e3;
        ae a2;
        ae.c a3;
        Object obj;
        try {
            ae.b d2 = d();
            boolean b2 = ae.a().b(d2);
            boolean z = false;
            int i = 0;
            V v2 = null;
            boolean z2 = false;
            while (i < this.c) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    int protocol = ServiceSettings.getInstance().getProtocol();
                    bq.a().a(this.e);
                    de b3 = de.b();
                    if (!(!b2 || (a3 = ae.a().a(d2)) == null || (obj = a3.a) == 0)) {
                        try {
                            an.a(this.e, d2.a, a3.b);
                            v2 = obj;
                            z2 = true;
                        } catch (bj e4) {
                            e2 = e4;
                            v2 = obj;
                            z2 = true;
                            an.a(this.e, z(), System.currentTimeMillis() - currentTimeMillis, z);
                            i++;
                            if (i >= this.c) {
                                try {
                                    Thread.sleep((long) (this.k * 1000));
                                    if (b2 && !z2) {
                                        ae.a().a(d2, v2);
                                    }
                                    z = false;
                                } catch (InterruptedException unused) {
                                    if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                                        throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e2.c());
                                    }
                                    throw new AMapException(e2.a(), 1, e2.c());
                                }
                            } else if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(e2.a()) || com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                                throw new AMapException(AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e2.c());
                            } else {
                                throw new AMapException(e2.a(), 1, e2.c());
                            }
                        } catch (AMapException e5) {
                            e3 = e5;
                            v2 = obj;
                            z2 = true;
                            try {
                                an.a(this.e, z(), System.currentTimeMillis() - currentTimeMillis, z);
                                i++;
                                if (i >= this.c) {
                                    if (b2 && !z2) {
                                        a2 = ae.a();
                                        a2.a(d2, v2);
                                    }
                                    z = false;
                                } else {
                                    try {
                                        throw e3;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        v = null;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                v = v2;
                                ae.a().a(d2, v);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            v = obj;
                            z2 = true;
                            if (b2 && !z2) {
                                ae.a().a(d2, v);
                            }
                            throw th;
                        }
                    }
                    if (v2 == null) {
                        byte[] a4 = a(protocol, b3, this);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        v2 = b(a4);
                        an.a(this.e, z(), currentTimeMillis2 - currentTimeMillis, true);
                    }
                    i = this.c;
                    if (b2 && !z2) {
                        a2 = ae.a();
                        a2.a(d2, v2);
                    }
                } catch (bj e6) {
                    e2 = e6;
                    an.a(this.e, z(), System.currentTimeMillis() - currentTimeMillis, z);
                    i++;
                    if (i >= this.c) {
                    }
                } catch (AMapException e7) {
                    e3 = e7;
                    an.a(this.e, z(), System.currentTimeMillis() - currentTimeMillis, z);
                    i++;
                    if (i >= this.c) {
                    }
                }
                z = false;
            }
            return v2;
        } catch (AMapException e8) {
            throw e8;
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    private void a(Context context, T t) {
        this.e = context;
        this.b = t;
        this.c = 1;
        b(ServiceSettings.getInstance().getSoTimeOut());
        a(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    private String j() {
        return this.f;
    }

    private String z() {
        String a2 = a();
        if (a2 == null) {
            return null;
        }
        try {
            int indexOf = a2.indexOf(".com/");
            int indexOf2 = a2.indexOf("?");
            if (indexOf2 == -1) {
                return a2.substring(indexOf + 5);
            }
            return a2.substring(indexOf + 5, indexOf2);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract V a(String str) throws AMapException;

    /* access modifiers changed from: protected */
    public abstract String a_();

    public final V b() throws AMapException {
        if (this.b == null) {
            return null;
        }
        try {
            return A();
        } catch (AMapException e2) {
            an.a(z(), j(), e2);
            throw e2;
        }
    }

    @Override // com.amap.api.col.s.df
    public final String c() {
        return "sea";
    }

    /* access modifiers changed from: protected */
    public ae.b d() {
        return null;
    }

    @Override // com.amap.api.col.s.df
    public Map<String, String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.df
    public Map<String, String> f() {
        return null;
    }

    private V b(byte[] bArr) throws AMapException {
        return a(bArr);
    }

    /* access modifiers changed from: protected */
    public V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e2) {
            i.a(e2, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        i.b(str);
        return a(str);
    }

    private byte[] a(int i, de deVar, br brVar) throws bj {
        dg dgVar;
        a(i == 1 ? df.c.HTTP : df.c.HTTPS);
        if (this.a) {
            dgVar = cz.a(brVar);
        } else {
            dgVar = de.e(brVar);
        }
        if (dgVar == null) {
            return null;
        }
        byte[] bArr = dgVar.a;
        this.f = dgVar.d;
        return bArr;
    }
}
