package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import anet.channel.a;
import anet.channel.appmonitor.DefaultAppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.fulltrace.a;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.d;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.c;
import anetwork.channel.cache.CachePrediction;
import com.taobao.accs.common.Constants;
import com.taobao.android.ab.api.ABGlobal;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.mtop.intf.MtopUnitStrategy;
import org.json.JSONArray;
import tb.a92;
import tb.ag2;
import tb.c50;
import tb.d92;
import tb.gi2;
import tb.h0;
import tb.h9;
import tb.he;
import tb.ke1;
import tb.nl1;
import tb.rh1;
import tb.sh1;
import tb.ss0;
import tb.u40;
import tb.v40;
import tb.w6;
import tb.yy0;

/* compiled from: Taobao */
public class TaobaoNetworkAdapter implements Serializable {
    private static final String TAG = "awcn.TaobaoNetworkAdapter";
    public static AtomicBoolean isInited = new AtomicBoolean();

    public static void init(Context context, HashMap<String, Object> hashMap) {
        String str;
        String str2;
        boolean z;
        if (isInited.compareAndSet(false, true)) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            h9.s0(defaultSharedPreferences.getBoolean(h9.IPV6_RATE_OPTIMIZE_EANBLE, true));
            if (hashMap != null && "com.taobao.taobao".equals(hashMap.get("process"))) {
                h9.V(true);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put("liveng-bfrtc.alibabausercontent.com");
                jSONArray.put("livecb-bfrtc.alibabausercontent.com");
                jSONArray.put("liveca-bfrtc.alibabausercontent.com");
                h9.j0(jSONArray.toString());
                if (h9.E()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(MtopUnitStrategy.GUIDE_ONLINE_DOMAIN);
                    arrayList.add(MtopUnitStrategy.TRADE_ONLINE_DOMAIN);
                    arrayList.add("heic.alicdn.com");
                    arrayList.add("gw.alicdn.com");
                    arrayList.add("img.alicdn.com");
                    arrayList.add("g.alicdn.com");
                    arrayList.add("tbm-auth.alicdn.com");
                    arrayList.add("daren-auth.alicdn.com");
                    arrayList.add("bizsec-auth.alicdn.com");
                    HttpDispatcher.f().a(arrayList);
                }
                if (h9.p()) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(MtopUnitStrategy.GUIDE_ONLINE_DOMAIN);
                    jSONArray2.put(MtopUnitStrategy.TRADE_ONLINE_DOMAIN);
                    jSONArray2.put("gw.alicdn.com");
                    jSONArray2.put("heic.alicdn.com");
                    jSONArray2.put("ossgw.alicdn.com");
                    jSONArray2.put("dorangesource.alicdn.com");
                    h9.Z(jSONArray2.toString());
                }
            }
            if (hashMap == null || ((!sh1.m() || !Constants.CHANNEL_PROCESS_NAME.equals(hashMap.get("process"))) && (!sh1.I() || (!"com.taobao.taobao:widget".equals(hashMap.get("process")) && !"com.taobao.taobao:widgetProvider".equals(hashMap.get("process")))))) {
                str = "dorangesource.alicdn.com";
                str2 = "ossgw.alicdn.com";
            } else {
                str2 = "ossgw.alicdn.com";
                str = "dorangesource.alicdn.com";
                ALog.e(TAG, "localInstanceEnable", null, new Object[0]);
                sh1.g0(false);
            }
            if (hashMap != null && Constants.CHANNEL_PROCESS_NAME.equals(hashMap.get("process")) && isABGlobalFeatureOpened(context, "channelCookieOpt").booleanValue()) {
                ALog.e(TAG, "ChannelNoCookieEnable", null, new Object[0]);
                sh1.S(true);
            }
            ALog.h(new gi2());
            sh1.f0(new nl1());
            w6.d(new DefaultAppMonitor());
            rh1.b(new c50());
            a.g(new u40());
            a.h(new v40());
            ThreadPoolExecutorFactory.g(new Runnable() {
                /* class anet.channel.TaobaoNetworkAdapter.AnonymousClass1 */

                /* renamed from: anet.channel.TaobaoNetworkAdapter$1$a */
                /* compiled from: Taobao */
                class a implements CachePrediction {
                    a(AnonymousClass1 r1) {
                    }

                    @Override // anetwork.channel.cache.CachePrediction
                    public boolean handleCache(String str, Map<String, String> map) {
                        return "weex".equals(map.get(HttpHeaderConstant.F_REFER));
                    }
                }

                public void run() {
                    try {
                        h0 h0Var = new h0();
                        h0Var.b();
                        he.a(h0Var, new a(this), 1);
                    } catch (Exception unused) {
                    }
                }
            }, ThreadPoolExecutorFactory.b.b);
            if (hashMap != null) {
                try {
                    if ("com.taobao.taobao".equals(hashMap.get("process")) && ((Boolean) hashMap.get(com.taobao.android.launcher.common.Constants.PARAMETER_IS_DEBUGGABLE)).booleanValue()) {
                        c.i("com.taobao.android.request.analysis.RequestRecorder", UCCore.LEGACY_EVENT_INIT, new Class[]{Context.class}, context);
                    }
                } catch (Exception e) {
                    ALog.d(TAG, "RequestRecorder error.", null, e, new Object[0]);
                }
            }
            if (hashMap != null) {
                try {
                    if (!hashMap.containsKey(com.taobao.android.launcher.common.Constants.PARAMETER_IS_NEXT_LAUNCH) || defaultSharedPreferences.getBoolean(h9.NEXT_LAUNCH_FORBID, false)) {
                        z = false;
                    } else {
                        ss0.a(com.taobao.android.launcher.common.Constants.PARAMETER_IS_NEXT_LAUNCH, "true");
                        z = true;
                    }
                    h9.B0(z);
                } catch (Exception unused) {
                }
            }
            h9.g0(defaultSharedPreferences.getBoolean(h9.HTTP3_ENABLE, true));
            h9.f0(defaultSharedPreferences.getString(h9.HTTP3_BLACK_LIST_KEY, null));
            boolean z2 = defaultSharedPreferences.getBoolean(h9.DETECT_CENTER_ENABLE, true);
            h9.b0(z2);
            h9.p0(defaultSharedPreferences.getBoolean(h9.IPV6_DETECT_KEY, true));
            Boolean isABGlobalFeatureOpened = isABGlobalFeatureOpened(context, h9.TICKET_STORE_KEY);
            if (isABGlobalFeatureOpened != null) {
                h9.C0(isABGlobalFeatureOpened.booleanValue());
            }
            if (hashMap != null) {
                try {
                    boolean containsKey = hashMap.containsKey(com.taobao.android.launcher.common.Constants.PARAMETER_IS_NG_LAUNCH);
                    if ("com.taobao.taobao".equals((String) hashMap.get("process"))) {
                        boolean z3 = true;
                        if (defaultSharedPreferences.getBoolean(sh1.SERVICE_OPTIMIZE, true)) {
                            sh1.P(true);
                            ALog.e(TAG, "bindservice optimize enabled.", null, new Object[0]);
                        }
                        Boolean isABGlobalFeatureOpened2 = isABGlobalFeatureOpened(context, "network_multi_path");
                        if (isABGlobalFeatureOpened2 != null) {
                            sh1.Z(isABGlobalFeatureOpened2.booleanValue());
                        }
                        Boolean isABGlobalFeatureOpened3 = isABGlobalFeatureOpened(context, "network_session_async");
                        if (isABGlobalFeatureOpened3 != null) {
                            sh1.U(isABGlobalFeatureOpened3.booleanValue());
                        }
                        Boolean isABGlobalFeatureOpened4 = isABGlobalFeatureOpened(context, "network_mtu_optimize");
                        if (isABGlobalFeatureOpened4 != null) {
                            h9.v0(isABGlobalFeatureOpened4.booleanValue());
                        }
                        Boolean isABGlobalFeatureOpened5 = isABGlobalFeatureOpened(context, "network_0rtt_optimize");
                        if (isABGlobalFeatureOpened5 != null) {
                            h9.S(isABGlobalFeatureOpened5.booleanValue());
                        }
                        Boolean isABGlobalFeatureOpened6 = isABGlobalFeatureOpened(context, "network_check_session_available");
                        if (isABGlobalFeatureOpened6 != null) {
                            h9.W(isABGlobalFeatureOpened6.booleanValue());
                        }
                        Boolean isABGlobalFeatureOpened7 = isABGlobalFeatureOpened(context, "network_http_detect");
                        if (isABGlobalFeatureOpened7 != null) {
                            h9.h0(isABGlobalFeatureOpened7.booleanValue());
                        }
                        String str3 = (String) hashMap.get("onlineAppKey");
                        ConnProtocol valueOf = ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, ConnType.PK_ACS);
                        if (z2) {
                            z3 = false;
                        }
                        registerPresetSession(MtopUnitStrategy.GUIDE_ONLINE_DOMAIN, str3, valueOf, z3, containsKey);
                        ConnProtocol valueOf2 = ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, ConnType.PK_CDN);
                        registerPresetSession("gw.alicdn.com", str3, valueOf2, false, containsKey);
                        registerPresetSession(str, str3, valueOf2, false, containsKey);
                        registerPresetSession(str2, str3, valueOf2, false, containsKey);
                        if (z2) {
                            c.l(new a.C0000a().c(str3).e(ENV.ONLINE).a());
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    private static Boolean isABGlobalFeatureOpened(Context context, String str) {
        try {
            boolean isFeatureOpened = ABGlobal.isFeatureOpened(context, str);
            ALog.e(TAG, "[isABGlobalFeatureOpened]", null, "featureName", str, "status", Boolean.valueOf(isFeatureOpened));
            return Boolean.valueOf(isFeatureOpened);
        } catch (Throwable unused) {
            ALog.e(TAG, "ABGlobal get error", null, new Object[0]);
            return null;
        }
    }

    private static void registerPresetSession(String str, String str2, ConnProtocol connProtocol, boolean z, boolean z2) {
        d.b().c(str, connProtocol);
        if (!z) {
            return;
        }
        if (!z2) {
            c.l(new a.C0000a().c(str2).e(ENV.ONLINE).a()).C(a92.a(str, z, false, null, null, null));
            return;
        }
        c.l(new a.C0000a().c(str2).e(ENV.ONLINE).a()).j(yy0.g(ag2.e("https", ke1.SCHEME_SLASH, str)), d92.a, 0);
    }
}
