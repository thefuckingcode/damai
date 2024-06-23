package com.alibaba.security.realidentity;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import cn.wh.auth.OnCallBack;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.realidentity.RPConfig;
import com.alibaba.security.realidentity.RPDetail;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.a.i;
import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.dynamic.model.CtidConfig;
import com.alibaba.security.realidentity.d.b;
import com.alibaba.security.realidentity.http.RpcInvoker;
import com.alibaba.security.realidentity.jsbridge.RP;
import com.alibaba.security.realidentity.jsbridge.a;
import com.alibaba.security.realidentity.utils.c;
import java.util.Objects;
import tb.ax2;
import tb.j12;
import tb.zw2;

/* compiled from: Taobao */
public class RPVerify {
    private static final String dailyUrl = "https://market.waptest.taobao.com/app/msd/m-rpverify-internal/start.html";
    private static boolean isInit = false;
    private static final String onlineUrl = "https://market.m.taobao.com/app/msd/m-rpverify-internal/start.html";
    private static final String preUrl = "https://market.wapa.taobao.com/app/msd/m-rpverify-internal/start.html";

    /* access modifiers changed from: package-private */
    /* renamed from: com.alibaba.security.realidentity.RPVerify$5  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[RPEnv.values().length];
            a = iArr;
            iArr[RPEnv.DAILY.ordinal()] = 1;
            a[RPEnv.PRE.ordinal()] = 2;
        }
    }

    private static void a(Context context, String str, RPConfig rPConfig, RPEventListener rPEventListener, Runnable runnable) {
        Objects.requireNonNull(rPEventListener, "RPVerify#start rpEventListener is null");
        if (TextUtils.isEmpty(str)) {
            rPEventListener.onFinish(RPResult.AUDIT_NOT, new RPDetail(GlobalErrorCode.mappingResultCode(GlobalErrorCode.ERROR_TOKEN_EMPTY), "-10401", "verifyToken is null", null));
            return;
        }
        if (!isInit) {
            init(context, RPEnv.ONLINE);
        }
        if (!isInit) {
            rPEventListener.onFinish(RPResult.AUDIT_NOT, new RPDetail(GlobalErrorCode.mappingResultCode(GlobalErrorCode.ERROR_INIT), "-10400", "sdk init fail", null));
            return;
        }
        g.a.a().g = rPConfig;
        runnable.run();
    }

    public static String getDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setVersionTag("");
        jSONObject.put(a.I, (Object) h.a(clientInfo));
        jSONObject.put("wua", (Object) g.a.a().i.f());
        jSONObject.put("miniWua", (Object) g.a.a().i.g());
        return JSON.toJSONString(jSONObject);
    }

    public static void init(Context context, RPEnv rPEnv) {
        init(context, rPEnv, null);
    }

    public static void start(Context context, String str, RPEventListener rPEventListener) {
        start(context, str, null, rPEventListener);
    }

    public static void startByCtidWithVerifyToken(final Activity activity, final String str, RPConfig rPConfig, final RPEventListener rPEventListener) {
        RPConfig rPConfig2;
        if (rPConfig != null) {
            rPConfig2 = new RPConfig.Builder(rPConfig).setNeedFailResultPage(true).build();
        } else {
            rPConfig2 = new RPConfig.Builder().setNeedFailResultPage(true).build();
        }
        a(activity, str, rPConfig2, rPEventListener, new Runnable() {
            /* class com.alibaba.security.realidentity.RPVerify.AnonymousClass4 */

            public final void run() {
                g a2 = g.a.a();
                Activity activity = activity;
                String str = str;
                RPEventListener rPEventListener = rPEventListener;
                if (c.a()) {
                    a2.a(str, a2.a(), "ctid");
                    a2.h = a2.a(rPEventListener);
                    if (a2.b(str)) {
                        a2.m = "ctid";
                        a2.d = str;
                        a2.l = System.currentTimeMillis();
                        com.alibaba.security.common.c.a.a("RPVerifyManager", "startVerifyByNative token is: ".concat(String.valueOf(str)));
                        a2.h.onStart();
                        GetCacheDataManager.getInstance().setUmidToken(a2.i.h());
                        g.a(activity, str, rPEventListener, new Runnable(rPEventListener, activity, str) {
                            /* class com.alibaba.security.realidentity.a.g.AnonymousClass4 */

                            public final void run() {
                                g gVar = g.this;
                                if (gVar.p == null) {
                                    gVar.k = false;
                                    RPResult rPResult = RPResult.AUDIT_FAIL;
                                    r7.onFinish(rPResult, new RPDetail(g.a(rPResult, "-10415"), "-10415", "CTID auth failed", null));
                                    return;
                                }
                                final c cVar = new c();
                                CtidConfig ctidConfig = g.this.p;
                                Activity activity = r5;
                                String str = r6;
                                AnonymousClass1 r4 = new Runnable() {
                                    /* class com.alibaba.security.realidentity.a.g.AnonymousClass4.AnonymousClass1 */

                                    public final void run() {
                                        if (cVar.a == -1) {
                                            g.this.k = false;
                                            r7.onFinish(RPResult.AUDIT_NOT, new RPDetail(g.a(RPResult.AUDIT_FAIL, "-10415"), "-10415", "CTID auth failed by user exit", null));
                                            return;
                                        }
                                        AnonymousClass4 r1 = AnonymousClass4.this;
                                        com.alibaba.security.realidentity.business.a aVar = new com.alibaba.security.realidentity.business.a(r5, r6, g.this.h);
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
                        }, a2.i);
                    }
                } else if (rPEventListener != null) {
                    RPResult rPResult = RPResult.AUDIT_FAIL;
                    rPEventListener.onFinish(rPResult, new RPDetail(g.a(rPResult, "-10415"), "-10415", "CTID SDK NOT EXIST", null));
                }
            }
        });
    }

    public static void startByNative(Context context, String str, RPEventListener rPEventListener) {
        RPConfig.Builder builder = new RPConfig.Builder();
        builder.setNeedWaitingForFinish(true);
        startByNative(context, str, builder.build(), rPEventListener);
    }

    @Deprecated
    public static void startWithUrl(Context context, String str, RPEventListener rPEventListener) {
        startWithUrl(context, str, null, rPEventListener);
    }

    public static String version() {
        g.a.a();
        return VersionKey.RP_SDK_VERSION;
    }

    public static void init(Context context, RPEnv rPEnv, String str) {
        String str2 = onlineUrl;
        if (rPEnv != null) {
            int i = AnonymousClass5.a[rPEnv.ordinal()];
            if (i == 1) {
                str2 = dailyUrl;
            } else if (i == 2) {
                str2 = preUrl;
            }
        }
        g.a.a().f = str2;
        g a = g.a.a();
        RPEnv rPEnv2 = a.e;
        a.c = context.getApplicationContext();
        a.e = rPEnv2;
        i a2 = i.a.a();
        a2.a = new com.alibaba.security.realidentity.a.h();
        a2.b();
        a.i.a(a.c);
        a.C0102a.a().a(a.c, (RPTrack.TrackStrategy) null);
        a.C0102a.a().d = new com.alibaba.security.realidentity.track.a(a.c);
        a.j.init(context);
        WVPluginManager.registerPlugin("RP", (Class<? extends WVApiPlugin>) RP.class);
        g a3 = g.a.a();
        a3.e = rPEnv;
        b bVar = a3.i;
        bVar.a = rPEnv;
        bVar.d = null;
        bVar.e = null;
        RpcInvoker.setMtopInstanceId(str);
        isInit = true;
    }

    public static void start(final Context context, final String str, RPConfig rPConfig, final RPEventListener rPEventListener) {
        a(context, str, rPConfig, rPEventListener, new Runnable() {
            /* class com.alibaba.security.realidentity.RPVerify.AnonymousClass1 */

            public final void run() {
                g.a.a().a(context, str, "h5", rPEventListener);
            }
        });
    }

    @Deprecated
    public static void startWithUrl(Context context, String str, RPConfig rPConfig, RPEventListener rPEventListener) {
        if (rPEventListener != null) {
            if (TextUtils.isEmpty(str)) {
                rPEventListener.onFinish(RPResult.AUDIT_NOT, new RPDetail(GlobalErrorCode.mappingResultCode(GlobalErrorCode.ERROR_URL_EMPTY), "-10402", "url is empty", null));
                return;
            }
            if (!isInit) {
                init(context, RPEnv.ONLINE);
            }
            if (!isInit) {
                rPEventListener.onFinish(RPResult.AUDIT_NOT, new RPDetail(GlobalErrorCode.mappingResultCode(GlobalErrorCode.ERROR_INIT), "-10400", "sdk init fail", null));
                return;
            }
            g.a.a().g = rPConfig;
            g a = g.a.a();
            String a2 = g.a(str);
            a.a(a2, a.a(), "url");
            a.h = a.a(rPEventListener);
            if (a.b(a2)) {
                a.m = "url";
                a.d = a2;
                a.l = System.currentTimeMillis();
                GetCacheDataManager.getInstance().setUmidToken(a.i.h());
                g.a(context, a2, a.h, new Runnable(context, g.a(str, "fromSource", "rpsdk"), a2) {
                    /* class com.alibaba.security.realidentity.a.g.AnonymousClass2 */

                    public final void run() {
                        g.this.a(r4, r5, r0);
                    }
                }, a.i);
            }
        }
    }

    public static void start(final Context context, final String str, RPConfig rPConfig, final String str2, final RPEventListener rPEventListener) {
        a(context, str, rPConfig, rPEventListener, new Runnable() {
            /* class com.alibaba.security.realidentity.RPVerify.AnonymousClass2 */

            public final void run() {
                g.a.a().a(context, str, str2, rPEventListener);
            }
        });
    }

    public static void startByNative(final Context context, final String str, RPConfig rPConfig, final RPEventListener rPEventListener) {
        a(context, str, rPConfig, rPEventListener, new Runnable() {
            /* class com.alibaba.security.realidentity.RPVerify.AnonymousClass3 */

            public final void run() {
                g a2 = g.a.a();
                Context context = context;
                String str = str;
                RPEventListener rPEventListener = rPEventListener;
                a2.a(str, a2.a(), "native");
                a2.h = a2.a(rPEventListener);
                if (a2.b(str)) {
                    a2.m = "native";
                    a2.d = str;
                    a2.l = System.currentTimeMillis();
                    com.alibaba.security.common.c.a.a("RPVerifyManager", "startVerifyByNative token is: ".concat(String.valueOf(str)));
                    a2.h.onStart();
                    GetCacheDataManager.getInstance().setUmidToken(a2.i.h());
                    g.a(context, str, a2.h, new Runnable(context, str) {
                        /* class com.alibaba.security.realidentity.a.g.AnonymousClass3 */

                        public final void run() {
                            g gVar = g.this;
                            com.alibaba.security.realidentity.business.a aVar = new com.alibaba.security.realidentity.business.a(r3, r4, gVar.h);
                            BusinessHeadParams businessHeadParams = new BusinessHeadParams();
                            businessHeadParams.setScConfig(gVar.n);
                            aVar.a(businessHeadParams);
                        }
                    }, a2.i);
                }
            }
        });
    }
}
