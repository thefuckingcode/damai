package com.youku.network.a;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.baseproject.utils.Profile;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.android.antiflow.IAntiFlowManager;
import com.youku.d.b.a;
import com.youku.network.c;
import com.youku.network.config.YKNetworkConfig;
import com.youku.network.d;
import com.youku.network.f;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.UUID;
import okhttp3.l;
import okhttp3.o;
import okhttp3.p;
import okhttp3.q;
import okhttp3.r;
import tb.ac1;
import tb.ag2;
import tb.jl1;
import tb.zf2;

/* compiled from: Taobao */
public class e<I extends o, O extends q> extends a<I, O> {
    private c a;
    private IAntiFlowManager b;

    public e(IAntiFlowManager iAntiFlowManager) {
        this.b = iAntiFlowManager;
    }

    private String a(String str, Map<String, String> map, String str2, String str3, String str4, f fVar) {
        if (TextUtils.isEmpty(str) || map == null || map.isEmpty()) {
            return str;
        }
        String a2 = a.a(map, str2);
        if (TextUtils.isEmpty(a2)) {
            return str;
        }
        if (!"GET".equalsIgnoreCase(str3) && (!"POST".equalsIgnoreCase(str3) || str4 == null || fVar == null)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (sb.indexOf("?") == -1) {
            sb.append(jl1.CONDITION_IF);
        } else if (str.charAt(str.length() - 1) != '&') {
            sb.append('&');
        }
        sb.append(a2);
        return sb.toString();
    }

    private l a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        l.a aVar = new l.a();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null && zf2.g(entry.getKey())) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (IRequestConst.USER_AGENT.equalsIgnoreCase(key)) {
                    value = a(value);
                }
                aVar.a(key, value);
            }
        }
        return aVar.e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0051, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0060, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0072 A[SYNTHETIC, Splitter:B:40:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    private void a(d dVar, q qVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        r a2 = qVar.a();
        if (a2 != null) {
            long a3 = YKNetworkConfig.a();
            if (YKNetworkConfig.a(a2.f(), a3)) {
                dVar.a(-3016);
                return;
            }
            boolean z = true;
            InputStream inputStream = null;
            try {
                InputStream c = a2.c();
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[2048];
                    long j = 0;
                    while (true) {
                        int read = c.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                            j += (long) read;
                            if (YKNetworkConfig.a(j, a3)) {
                                dVar.a(-3016);
                                z = false;
                                break;
                            }
                        }
                    }
                    try {
                        c.close();
                        a2.close();
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = c;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                        }
                        a2.close();
                        if (!z) {
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                throw th2;
                            }
                        }
                        a2.close();
                        throw th2;
                    }
                } catch (Throwable th3) {
                }
            } catch (Exception e5) {
                e = e5;
                byteArrayOutputStream = null;
                e.printStackTrace();
                if (inputStream != null) {
                }
                a2.close();
                if (!z) {
                }
            }
            if (!z) {
                dVar.a(byteArrayOutputStream.toByteArray());
            }
        }
    }

    private d b(O o) {
        d a2 = d.a();
        a2.b(o.e());
        try {
            a(a2, o);
        } catch (Throwable th) {
            th.printStackTrace();
            a2.a(AVFSCacheConstants.AVFS_ERROR_FILE_WRITE);
            a2.a(th);
        }
        l j = o.j();
        if (j != null) {
            try {
                a2.a(j.i());
            } catch (Throwable th2) {
                th2.printStackTrace();
                a2.a(-3015);
                a2.a(th2);
            }
        }
        a2.a(o.k());
        this.b.afterCall(a2.d(), a2.f());
        return a2;
    }

    private o b(c cVar) {
        this.a = cVar;
        String antiCookie = this.b.getAntiCookie(cVar.k().get(IRequestConst.COOKIE));
        if (!TextUtils.isEmpty(antiCookie)) {
            cVar.a(IRequestConst.COOKIE, antiCookie);
        }
        p pVar = null;
        String h = cVar.h();
        Map<String, String> l = cVar.l();
        String n = cVar.n();
        String m = cVar.m();
        f L = cVar.L();
        Map<String, String> k = cVar.k();
        if (k != null && k.get(IRequestConst.USER_AGENT) == null && k.get("user-agent") == null && Profile.User_Agent != null) {
            k.put(IRequestConst.USER_AGENT, Profile.User_Agent);
        }
        l a2 = a(k);
        String a3 = a(cVar.e(), l, n, h, m, L);
        if (!com.youku.network.call.a.b) {
            try {
                if (a3.startsWith("https")) {
                    a3 = ag2.e("http", ":", a3.substring(a3.indexOf(WVUtils.URL_SEPARATOR)));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(m)) {
            pVar = p.c(ac1.d("application/json; charset=" + n), m);
        } else if (L != null) {
            pVar = p.d(ac1.d(L.b + "; charset=" + n), L.a);
        } else if (!"GET".equalsIgnoreCase(h)) {
            String a4 = a.a(l, n);
            pVar = p.c(ac1.d("application/x-www-form-urlencoded; charset=" + n), a4);
        }
        o.a j = new o.a().k(a3).f(h, pVar).j(UUID.randomUUID().toString());
        if (a2 != null && a2.h() > 0) {
            j.e(a2);
        }
        return j.b();
    }

    public d a(O o) {
        return b(o);
    }

    public I a(c cVar) {
        return (I) b(cVar);
    }
}
