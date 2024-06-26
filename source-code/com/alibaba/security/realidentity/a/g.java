package com.alibaba.security.realidentity.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import android.util.Pair;
import cn.wh.auth.OnCallBack;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.biometrics.skin.RPSkinManager;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.RPConfig;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPEnv;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.i;
import com.alibaba.security.realidentity.activity.RPWebViewActivity;
import com.alibaba.security.realidentity.b;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.dynamic.model.CtidConfig;
import com.alibaba.security.realidentity.business.dynamic.model.ScConfig;
import com.alibaba.security.realidentity.jsbridge.RP;
import com.alibaba.security.realidentity.utils.c;
import java.util.HashMap;
import tb.ax2;
import tb.j12;
import tb.zw2;

public final class g implements com.alibaba.security.realidentity.e.a {
    private static final String q;
    final RPSkinManager a;
    final Handler b;
    public Context c;
    public String d;
    public RPEnv e;
    public String f;
    public RPConfig g;
    public b h;
    public com.alibaba.security.realidentity.d.b i;
    public final SensorGetter j;
    volatile boolean k;
    public long l;
    public String m;
    public ScConfig n;
    public boolean o;
    public CtidConfig p;

    public static final class a {
        private static final g a = new g((byte) 0);

        private a() {
        }
    }

    /* synthetic */ g(byte b2) {
        this();
    }

    private static boolean A() {
        return false;
    }

    private static boolean B() {
        return false;
    }

    private static String C() {
        return null;
    }

    private static String D() {
        return VersionKey.RP_SDK_VERSION;
    }

    private RPEnv E() {
        return this.e;
    }

    private ScConfig F() {
        return this.n;
    }

    private static Pair<Boolean, String> h() {
        return new Pair<>(Boolean.TRUE, "");
    }

    private Pair<Boolean, String> i() {
        com.alibaba.security.realidentity.d.b bVar = this.i;
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    private Context j() {
        return this.c;
    }

    private static void k() {
    }

    private String l() {
        return this.d;
    }

    private RPEnv m() {
        return this.e;
    }

    private String n() {
        return this.f;
    }

    private RPEventListener o() {
        return this.h;
    }

    private void p() {
        this.h = null;
    }

    private boolean q() {
        return this.k;
    }

    private static void r() {
        a.C0102a.a.a(false);
    }

    private String s() {
        return this.i.c();
    }

    private String t() {
        return this.i.d();
    }

    private String u() {
        return this.i.e();
    }

    private String v() {
        return this.i.f();
    }

    private String w() {
        return this.i.g();
    }

    private String x() {
        return this.i.h();
    }

    private static boolean y() {
        return false;
    }

    private static boolean z() {
        return false;
    }

    private g() {
        this.c = null;
        this.d = "";
        this.e = RPEnv.ONLINE;
        this.f = "https://market.m.taobao.com/app/msd/m-rpverify-internal/start.html";
        this.g = null;
        this.h = null;
        this.o = true;
        this.i = new com.alibaba.security.realidentity.d.b(this);
        this.k = false;
        this.b = new Handler(Looper.getMainLooper());
        this.a = RPSkinManager.getInstance();
        this.j = SensorGetter.getDefault();
    }

    private void c(Context context, String str, RPEventListener rPEventListener) {
        com.alibaba.security.realidentity.business.a aVar = new com.alibaba.security.realidentity.business.a(context, str, rPEventListener);
        BusinessHeadParams businessHeadParams = new BusinessHeadParams();
        businessHeadParams.setScConfig(this.n);
        aVar.a(businessHeadParams);
    }

    private void d(String str) {
        this.f = str;
    }

    private static g e() {
        return a.a;
    }

    private static boolean f() {
        WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
        return true;
    }

    private Pair<Boolean, String> g() {
        return this.i.a();
    }

    private boolean a(Context context) {
        RPEnv rPEnv = this.e;
        this.c = context.getApplicationContext();
        this.e = rPEnv;
        i iVar = i.a.a;
        iVar.a = new h();
        iVar.b();
        this.i.a(this.c);
        a.C0102a.a.a(this.c, (RPTrack.TrackStrategy) null);
        a.C0102a.a.d = new com.alibaba.security.realidentity.track.a(this.c);
        this.j.init(context);
        WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
        return true;
    }

    private void b(final Context context, final String str, RPEventListener rPEventListener) {
        a(str, a(), "native");
        this.h = a(rPEventListener);
        if (b(str)) {
            this.m = "native";
            this.d = str;
            this.l = System.currentTimeMillis();
            com.alibaba.security.common.c.a.a(q, "startVerifyByNative token is: ".concat(String.valueOf(str)));
            this.h.onStart();
            GetCacheDataManager.getInstance().setUmidToken(this.i.h());
            a(context, str, this.h, new Runnable() {
                /* class com.alibaba.security.realidentity.a.g.AnonymousClass3 */

                public final void run() {
                    g gVar = g.this;
                    com.alibaba.security.realidentity.business.a aVar = new com.alibaba.security.realidentity.business.a(context, str, gVar.h);
                    BusinessHeadParams businessHeadParams = new BusinessHeadParams();
                    businessHeadParams.setScConfig(gVar.n);
                    aVar.a(businessHeadParams);
                }
            }, this.i);
        }
    }

    private String e(String str) {
        return this.i.a(str);
    }

    private String f(String str) {
        return this.i.b(str);
    }

    public final boolean d() {
        return this.o && com.alibaba.security.common.d.b.a();
    }

    private void c(String str) {
        this.d = str;
    }

    public final Pair<Boolean, String> c() {
        a.C0102a.a.a = null;
        Pair<Boolean, String> i2 = i();
        GetCacheDataManager.getInstance().setUmidToken(this.i.h());
        return i2;
    }

    public final boolean b(String str) {
        Pair<Boolean, String> h2 = h();
        if (!((Boolean) h2.first).booleanValue()) {
            this.h.b(RPResult.AUDIT_NOT, "-10403", (String) h2.second, str);
            return false;
        }
        Pair<Boolean, String> c2 = c();
        if (!((Boolean) c2.first).booleanValue()) {
            this.h.b(RPResult.AUDIT_NOT, "-10403", (String) c2.second, str);
            return false;
        } else if (this.k) {
            this.h.a(RPResult.AUDIT_NOT, "-10404", "重复认证，上一次认证还未结束", str);
            return false;
        } else {
            this.k = true;
            return true;
        }
    }

    private boolean a(Context context, RPEnv rPEnv) {
        this.c = context.getApplicationContext();
        this.e = rPEnv;
        i iVar = i.a.a;
        iVar.a = new h();
        iVar.b();
        this.i.a(this.c);
        a.C0102a.a.a(this.c, (RPTrack.TrackStrategy) null);
        a.C0102a.a.d = new com.alibaba.security.realidentity.track.a(this.c);
        this.j.init(context);
        WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
        return true;
    }

    public final RPConfig b() {
        if (this.g == null) {
            this.g = new RPConfig.Builder().build();
        }
        return this.g;
    }

    private static void b(RPDetail rPDetail) {
        if (rPDetail != null && "1".equals(rPDetail.getCode())) {
            rPDetail.setSubCode("1");
        }
    }

    @Override // com.alibaba.security.realidentity.e.a
    public final void b(TrackLog trackLog) {
        a(trackLog);
    }

    public final void a(final Context context, final String str, String str2, RPEventListener rPEventListener) {
        this.m = str2;
        a(str, a(), str2);
        this.h = a(rPEventListener);
        if (b(str)) {
            this.d = str;
            this.l = System.currentTimeMillis();
            com.alibaba.security.common.c.a.a(q, "startVerify token is: ".concat(String.valueOf(str)));
            GetCacheDataManager.getInstance().setUmidToken(this.i.h());
            a(context, str, this.h, new Runnable() {
                /* class com.alibaba.security.realidentity.a.g.AnonymousClass1 */

                public final void run() {
                    g gVar = g.this;
                    Context context = context;
                    String str = str;
                    gVar.a(context, g.a(g.a(gVar.f, "token", str), "fromSource", "rpsdk"), str);
                }
            }, this.i);
        }
    }

    private void a(Context context, String str) {
        a(context, a(a(this.f, "token", str), "fromSource", "rpsdk"), str);
    }

    public static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str4 = "?";
        if (str.lastIndexOf(str4) >= 0) {
            str4 = "&";
        }
        sb.append(str4);
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        String sb2 = sb.toString();
        com.alibaba.security.common.c.a.a(q, "originalUrl:" + str + "\nnewUrl:" + sb2);
        return sb2;
    }

    public final boolean a() {
        ALBiometricsConfig biometricsConfig = b().getBiometricsConfig();
        if (biometricsConfig == null) {
            return false;
        }
        boolean isSkinInAssets = biometricsConfig.isSkinInAssets();
        String skinPath = biometricsConfig.getSkinPath();
        if (!isSkinInAssets && TextUtils.isEmpty(skinPath)) {
            return false;
        }
        this.a.init(this.c, skinPath, isSkinInAssets);
        return true;
    }

    private void a(final Context context, String str, RPEventListener rPEventListener) {
        final String a2 = a(str);
        a(a2, a(), "url");
        this.h = a(rPEventListener);
        if (b(a2)) {
            this.m = "url";
            this.d = a2;
            this.l = System.currentTimeMillis();
            GetCacheDataManager.getInstance().setUmidToken(this.i.h());
            final String a3 = a(str, "fromSource", "rpsdk");
            a(context, a2, this.h, new Runnable() {
                /* class com.alibaba.security.realidentity.a.g.AnonymousClass2 */

                public final void run() {
                    g.this.a(context, a3, a2);
                }
            }, this.i);
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            HashMap hashMap = new HashMap();
            String[] split = str.substring(str.indexOf("?") + 1).split("&");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
            return (String) hashMap.get("token");
        } catch (Exception unused) {
            com.alibaba.security.common.c.a.b();
            return "";
        }
    }

    private void a(final Activity activity, final String str, final RPEventListener rPEventListener) {
        if (c.a()) {
            a(str, a(), "ctid");
            this.h = a(rPEventListener);
            if (b(str)) {
                this.m = "ctid";
                this.d = str;
                this.l = System.currentTimeMillis();
                com.alibaba.security.common.c.a.a(q, "startVerifyByNative token is: ".concat(String.valueOf(str)));
                this.h.onStart();
                GetCacheDataManager.getInstance().setUmidToken(this.i.h());
                a(activity, str, rPEventListener, new Runnable() {
                    /* class com.alibaba.security.realidentity.a.g.AnonymousClass4 */

                    public final void run() {
                        g gVar = g.this;
                        if (gVar.p == null) {
                            gVar.k = false;
                            RPResult rPResult = RPResult.AUDIT_FAIL;
                            rPEventListener.onFinish(rPResult, new RPDetail(g.a(rPResult, "-10415"), "-10415", "CTID auth failed", null));
                            return;
                        }
                        final c cVar = new c();
                        CtidConfig ctidConfig = g.this.p;
                        Activity activity = activity;
                        String str = str;
                        AnonymousClass1 r4 = new Runnable() {
                            /* class com.alibaba.security.realidentity.a.g.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                if (cVar.a == -1) {
                                    g.this.k = false;
                                    rPEventListener.onFinish(RPResult.AUDIT_NOT, new RPDetail(g.a(RPResult.AUDIT_FAIL, "-10415"), "-10415", "CTID auth failed by user exit", null));
                                    return;
                                }
                                AnonymousClass4 r1 = AnonymousClass4.this;
                                com.alibaba.security.realidentity.business.a aVar = new com.alibaba.security.realidentity.business.a(activity, str, g.this.h);
                                BusinessHeadParams businessHeadParams = new BusinessHeadParams();
                                businessHeadParams.setCtidParams(cVar.b);
                                businessHeadParams.setCtidCode(cVar.a);
                                businessHeadParams.setCtidCalled(true);
                                aVar.a(businessHeadParams);
                            }
                        };
                        ax2 ax2 = new ax2(ctidConfig.getOrgId(), ctidConfig.getAndroidAppId(), str, ctidConfig.getType());
                        c.a(ctidConfig, str);
                        new zw2(activity, ax2).getAuthResult(new OnCallBack(str, r4) {
                            /* class com.alibaba.security.realidentity.utils.c.AnonymousClass1 */

                            @Override // cn.wh.auth.OnCallBack
                            public final void onResult(j12 j12) {
                                String str = c.c;
                                com.alibaba.security.common.c.a.a(str, "CTID result: " + j12.a() + ", resultDesc: " + j12.c());
                                c.a(j12, r7);
                                c.this.a = c.a(j12.a());
                                c.this.b = j12.b().b();
                                Runnable runnable = r8;
                                if (runnable != null) {
                                    runnable.run();
                                }
                            }
                        });
                    }
                }, this.i);
            }
        } else if (rPEventListener != null) {
            RPResult rPResult = RPResult.AUDIT_FAIL;
            rPEventListener.onFinish(rPResult, new RPDetail(a(rPResult, "-10415"), "-10415", "CTID SDK NOT EXIST", null));
        }
    }

    private void a(CtidConfig ctidConfig) {
        this.p = ctidConfig;
    }

    public final void a(Context context, String str, String str2) {
        this.l = System.currentTimeMillis();
        Intent intent = new Intent();
        if (com.alibaba.security.common.c.a.a()) {
            com.alibaba.security.common.c.a.a(q, "processStartVerifyWithUrl: ".concat(String.valueOf(str)));
        }
        intent.putExtra("url", str);
        intent.putExtra("token", str2);
        intent.setFlags(268435456);
        intent.setClass(context, RPWebViewActivity.class);
        context.startActivity(intent);
    }

    private void a(RPEnv rPEnv) {
        this.e = rPEnv;
        com.alibaba.security.realidentity.d.b bVar = this.i;
        bVar.a = rPEnv;
        bVar.d = null;
        bVar.e = null;
    }

    private void a(RPConfig rPConfig) {
        this.g = rPConfig;
    }

    public final b a(final RPEventListener rPEventListener) {
        return new b() {
            /* class com.alibaba.security.realidentity.a.g.AnonymousClass5 */

            private void a(final RPResult rPResult, final RPDetail rPDetail, String str) {
                g.this.a(rPResult, rPDetail.getCode(), rPDetail.getMsg(), str, rPDetail.getSubCode());
                g.this.i.b();
                RPTrack.a();
                g.this.a.release();
                com.alibaba.security.common.d.i.a();
                g.this.b.post(new Runnable() {
                    /* class com.alibaba.security.realidentity.a.g.AnonymousClass5.AnonymousClass5 */

                    public final void run() {
                        g.this.k = false;
                        rPEventListener.onFinish(rPResult, rPDetail);
                        a.a.h = null;
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.b
            public final void b(RPResult rPResult, String str, String str2, String str3) {
                a(rPResult, new RPDetail(g.a(rPResult, str), str, str2, null), str3);
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onBiometricsFinish(final int i) {
                g.this.b.post(new Runnable() {
                    /* class com.alibaba.security.realidentity.a.g.AnonymousClass5.AnonymousClass3 */

                    public final void run() {
                        g.this.k = false;
                        rPEventListener.onBiometricsFinish(i);
                        a.C0102a.a.a(false);
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onBiometricsStart() {
                g.this.b.post(new Runnable() {
                    /* class com.alibaba.security.realidentity.a.g.AnonymousClass5.AnonymousClass2 */

                    public final void run() {
                        rPEventListener.onBiometricsStart();
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, RPDetail rPDetail) {
                rPDetail.setCode(g.a(rPResult, rPDetail.getSubCode()));
                g.a(rPDetail);
                a(rPResult, rPDetail, g.this.d);
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onStart() {
                super.onStart();
                g.this.b.post(new Runnable() {
                    /* class com.alibaba.security.realidentity.a.g.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        rPEventListener.onStart();
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str, String str2) {
                RPDetail rPDetail = new RPDetail(g.a(rPResult, str), str, str2, null);
                g.a(rPDetail);
                a(rPResult, rPDetail, g.this.d);
            }

            @Override // com.alibaba.security.realidentity.b
            public final void a(final RPResult rPResult, final String str, final String str2, String str3) {
                final String a2 = g.a(rPResult, str);
                g.this.a(rPResult, a2, str2, str3, str);
                g.this.b.post(new Runnable() {
                    /* class com.alibaba.security.realidentity.a.g.AnonymousClass5.AnonymousClass4 */

                    public final void run() {
                        rPEventListener.onFinish(rPResult, new RPDetail(a2, str, str2, null));
                    }
                });
            }
        };
    }

    public static String a(RPResult rPResult, String str) {
        try {
            if (rPResult == RPResult.AUDIT_PASS) {
                return "1";
            }
            return GlobalErrorCode.mappingResultCode(Integer.decode(str).intValue());
        } catch (Exception unused) {
            return "-10000";
        }
    }

    public static void a(String str, TrackLog trackLog) {
        trackLog.setVerifyToken(str);
        trackLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        trackLog.addTag10("Android");
        a.C0102a.a.a(trackLog);
    }

    public final void a(String str, boolean z, String str2) {
        a(str, TrackLog.createStartBeginLog(str2, b().getFromSource(), z));
    }

    public final void a(RPResult rPResult, String str, String str2, String str3, String str4) {
        a(str3, TrackLog.createStartEndLog(this.m, str2, this.l, String.valueOf(rPResult.code), str, str4));
        a.C0102a.a.a(false);
    }

    private void a(com.alibaba.security.realidentity.d.b bVar) {
        this.i = bVar;
    }

    private void a(ScConfig scConfig) {
        this.n = scConfig;
    }

    private void a(boolean z) {
        this.o = z;
    }

    public static void a(Context context, String str, RPEventListener rPEventListener, Runnable runnable, com.alibaba.security.realidentity.d.b bVar) {
        new com.alibaba.security.realidentity.business.dynamic.b(context, str, rPEventListener, runnable, bVar).execute(com.alibaba.security.realidentity.business.dynamic.b.g);
    }

    private void a(String str, Runnable runnable) {
        a(this.c, str, this.h, runnable, this.i);
    }

    public final byte[] a(byte[] bArr, String str) {
        return this.i.a(bArr, str);
    }

    private void a(long j2) {
        this.l = j2;
    }

    public final void a(TrackLog trackLog) {
        a(this.d, trackLog);
    }

    static /* synthetic */ void a(RPDetail rPDetail) {
        if (rPDetail != null && "1".equals(rPDetail.getCode())) {
            rPDetail.setSubCode("1");
        }
    }
}
