package tb;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.quic.Http3ConnectionDetector;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anetwork.channel.config.IRemoteConfig;
import anetwork.channel.cookie.CookieManager;
import anetwork.channel.http.NetworkSdkSetting;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import java.util.ArrayList;
import org.json.JSONArray;

/* compiled from: Taobao */
public class nl1 implements IRemoteConfig {
    private static boolean a = true;

    /* compiled from: Taobao */
    class a implements OrangeConfigListenerV1 {
        a() {
        }

        @Override // com.taobao.orange.OrangeConfigListenerV1
        public void onConfigUpdate(String str, boolean z) {
            nl1.this.onConfigUpdate(str);
        }
    }

    private void a(String str) {
        try {
            String config = getConfig(str, "amdc_control_mode", null);
            String config2 = getConfig(str, "amdc_control_list", null);
            if (!TextUtils.isEmpty(config) && !TextUtils.isEmpty(config2)) {
                int intValue = Integer.valueOf(config).intValue();
                JSONArray jSONArray = new JSONArray(config2);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                AmdcRuntimeInfo.h(intValue, arrayList);
            }
        } catch (Exception e) {
            ALog.d("awcn.OrangeConfigImpl", "[updateAmdcConfig]", null, e, new Object[0]);
        }
        try {
            String config3 = getConfig(str, "amdc_update_mode_enable_switch", null);
            if (!TextUtils.isEmpty(config3)) {
                AmdcRuntimeInfo.j(Boolean.parseBoolean(config3));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(207:0|1|2|3|4|5|6|7|9|10|(1:12)|13|14|15|16|(1:18)|19|20|21|22|(1:24)|25|26|27|28|(1:30)|31|32|(1:34)|35|36|37|38|39|40|41|(1:43)(1:44)|45|46|47|48|(1:50)|51|52|(3:54|(1:56)|57)|58|59|(1:61)|62|63|(1:65)|66|67|(1:69)|70|71|(1:73)|74|75|(1:77)|78|79|(1:81)|82|83|(1:85)|86|87|(1:89)|90|91|(1:93)|94|95|(1:97)|98|99|(1:101)|102|103|(1:105)|106|107|(1:109)|110|111|(1:113)|114|115|(1:117)|118|119|(1:121)|122|123|(1:125)|126|127|(1:129)|130|131|(1:133)|134|135|(1:137)|138|139|(1:141)|142|143|(1:145)|146|147|(1:149)|150|151|152|(1:154)(1:155)|156|157|158|(1:160)|161|162|(1:164)|165|166|(1:168)|169|170|(1:172)|173|174|175|(1:177)(1:178)|179|180|181|(1:183)(1:184)|185|186|187|(1:189)(1:190)|191|192|193|(1:195)(1:196)|197|198|199|(1:201)(1:202)|203|204|205|(1:207)(1:208)|209|210|211|(1:213)(1:214)|215|216|(1:218)|219|220|(1:222)|223|224|(1:226)|227|228|229|(1:231)(1:232)|233|234|235|236|(1:238)(1:239)|240|241|242|(1:244)|245|246|(1:248)|249|250|(1:252)|253|254|(1:256)|257|258|259|(1:261)(1:262)|263|264|265|(1:267)|268|269|(1:271)|272|273|274|(1:276)(1:277)|278|280) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:102:0x0352 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:106:0x0371 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:110:0x0390 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:114:0x03af */
    /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x03ce */
    /* JADX WARNING: Missing exception handler attribute for start block: B:122:0x03e5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:126:0x0404 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:130:0x0423 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:134:0x0442 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:138:0x0461 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0072 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:142:0x0480 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:146:0x0497 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:150:0x04b6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:157:0x04ed */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x008b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:161:0x050c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:165:0x052b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:169:0x054a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:173:0x0569 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:179:0x05a5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:185:0x05d9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:191:0x060d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:197:0x0641 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x00aa */
    /* JADX WARNING: Missing exception handler attribute for start block: B:203:0x067d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:209:0x06b1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:215:0x06e3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:219:0x0702 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00c5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:223:0x0719 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:227:0x0730 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:234:0x0767 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:241:0x079e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:245:0x07bd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:249:0x07d4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:253:0x07f3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:257:0x080a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00e4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:264:0x0841 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:268:0x0860 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:272:0x087f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00f5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x010c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0123 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x013c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0156 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0024 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0190 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x01a9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x01d9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x01fb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x003d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x021a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x0239 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:70:0x0250 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x0267 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:78:0x027e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:82:0x029d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:86:0x02bc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:90:0x02d3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:94:0x02f2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:98:0x0322 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0336 A[Catch:{ Exception -> 0x0352 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0366 A[Catch:{ Exception -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0385 A[Catch:{ Exception -> 0x0390 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03a4 A[Catch:{ Exception -> 0x03af }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03c3 A[Catch:{ Exception -> 0x03ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x03e2 A[Catch:{ Exception -> 0x03e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03f9 A[Catch:{ Exception -> 0x0404 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0418 A[Catch:{ Exception -> 0x0423 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0067 A[Catch:{ Exception -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0437 A[Catch:{ Exception -> 0x0442 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0456 A[Catch:{ Exception -> 0x0461 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0475 A[Catch:{ Exception -> 0x0480 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0494 A[Catch:{ Exception -> 0x0497 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x04ab A[Catch:{ Exception -> 0x04b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x04d8  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x04e7  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0501 A[Catch:{ Exception -> 0x050c }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0520 A[Catch:{ Exception -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x053f A[Catch:{ Exception -> 0x054a }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x055e A[Catch:{ Exception -> 0x0569 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x058b  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x059e  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x05c7  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x05fb  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009f A[Catch:{ Exception -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0606  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x062f  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x063a  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0663  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0676  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x069f  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x06aa  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x06d3  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x06dd  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x06f7 A[Catch:{ Exception -> 0x0702 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0716 A[Catch:{ Exception -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x072d A[Catch:{ Exception -> 0x0730 }] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x0752  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0761  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0789  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0798  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x07b2 A[Catch:{ Exception -> 0x07bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x07d1 A[Catch:{ Exception -> 0x07d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d9 A[Catch:{ Exception -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x07e8 A[Catch:{ Exception -> 0x07f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0807 A[Catch:{ Exception -> 0x080a }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x082c  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x083b  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0855 A[Catch:{ Exception -> 0x0860 }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0874 A[Catch:{ Exception -> 0x087f }] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x08a1  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x08b0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0109 A[Catch:{ Exception -> 0x010c }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0120 A[Catch:{ Exception -> 0x0123 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01bd A[Catch:{ Exception -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01ed A[Catch:{ Exception -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x020f A[Catch:{ Exception -> 0x021a }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x022e A[Catch:{ Exception -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x024d A[Catch:{ Exception -> 0x0250 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0264 A[Catch:{ Exception -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x027b A[Catch:{ Exception -> 0x027e }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0292 A[Catch:{ Exception -> 0x029d }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02b1 A[Catch:{ Exception -> 0x02bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02d0 A[Catch:{ Exception -> 0x02d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02e7 A[Catch:{ Exception -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0306 A[Catch:{ Exception -> 0x0322 }] */
    private void b(String str) {
        h42.a().d(Boolean.valueOf(getConfig(str, "network_empty_scheme_https_switch", "true")).booleanValue());
        sh1.l0(Boolean.valueOf(getConfig(str, "network_spdy_enable_switch", "true")).booleanValue());
        sh1.V(Boolean.valueOf(getConfig(str, "network_http_cache_switch", "true")).booleanValue());
        String config = getConfig(str, "network_http_cache_flag", null);
        if (config != null) {
            sh1.Q(Long.valueOf(config).longValue());
        }
        h9.k0(Boolean.valueOf(getConfig(str, "network_https_sni_enable_switch", "true")).booleanValue());
        String config2 = getConfig(str, "network_accs_session_bg_switch", null);
        if (!TextUtils.isEmpty(config2)) {
            h9.V(Boolean.valueOf(config2).booleanValue());
        }
        sh1.i0(Integer.valueOf(getConfig(str, "network_request_statistic_sample_rate", "10000")).intValue());
        String config3 = getConfig(str, "network_request_forbidden_bg", null);
        if (!TextUtils.isEmpty(config3)) {
            sh1.O(Boolean.valueOf(config3).booleanValue());
        }
        sh1.o0(getConfig(str, "network_url_white_list_bg", null));
        String config4 = getConfig(str, "network_biz_white_list_bg", null);
        if (!TextUtils.isEmpty(config4)) {
            sh1.n0(config4);
        }
        String config5 = getConfig(str, "network_amdc_preset_hosts", null);
        if (!TextUtils.isEmpty(config5)) {
            sh1.M(config5);
        }
        h9.e0(Boolean.valueOf(getConfig(str, "network_horse_race_switch", "true")).booleanValue());
        h9.D0(Boolean.valueOf(getConfig(str, "tnet_enable_header_cache", "true")).booleanValue());
        String config6 = getConfig(str, "network_http3_enable_switch", null);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
        if (!TextUtils.isEmpty(config6)) {
            boolean booleanValue = Boolean.valueOf(config6).booleanValue();
            edit.putBoolean(h9.HTTP3_ENABLE, booleanValue);
            edit.apply();
            h9.g0(booleanValue);
        } else {
            edit.remove(h9.HTTP3_ENABLE);
            edit.apply();
        }
        sh1.j0(Boolean.valueOf(getConfig(str, "network_response_buffer_switch", "true")).booleanValue());
        String config7 = getConfig(str, "network_get_session_async_switch", null);
        if (!TextUtils.isEmpty(config7)) {
            boolean booleanValue2 = Boolean.valueOf(config7).booleanValue();
            SharedPreferences.Editor edit2 = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
            edit2.putBoolean(sh1.SESSION_ASYNC_OPTIMIZE, booleanValue2);
            edit2.apply();
        }
        String config8 = getConfig(str, "network_bg_forbid_request_threshold", null);
        if (!TextUtils.isEmpty(config8)) {
            int intValue = Integer.valueOf(config8).intValue();
            if (intValue < 0) {
                intValue = 0;
            }
            sh1.N(intValue);
        }
        String config9 = getConfig(str, "network_normal_thread_pool_executor_size", null);
        if (!TextUtils.isEmpty(config9)) {
            ThreadPoolExecutorFactory.b(Integer.valueOf(config9).intValue());
        }
        String config10 = getConfig(str, "network_idle_session_close_switch", null);
        if (!TextUtils.isEmpty(config10)) {
            h9.l0(Boolean.valueOf(config10).booleanValue());
        }
        String config11 = getConfig(str, "network_monitor_requests", null);
        if (!TextUtils.isEmpty(config11)) {
            sh1.Y(config11);
        }
        String config12 = getConfig(str, "network_biz_monitor_requests", null);
        if (!TextUtils.isEmpty(config12)) {
            sh1.X(config12);
        }
        String config13 = getConfig(str, "network_session_preset_hosts", null);
        if (!TextUtils.isEmpty(config13)) {
            h9.R(config13);
        }
        String config14 = getConfig(str, "network_ipv6_blacklist_switch", null);
        if (!TextUtils.isEmpty(config14)) {
            h9.n0(Boolean.valueOf(config14).booleanValue());
        }
        String config15 = getConfig(str, "network_ipv6_blacklist_ttl", null);
        if (!TextUtils.isEmpty(config15)) {
            h9.o0(Long.valueOf(config15).longValue());
        }
        String config16 = getConfig(str, "network_url_degrade_list", null);
        if (!TextUtils.isEmpty(config16)) {
            sh1.T(config16);
        }
        String config17 = getConfig(str, "network_delay_retry_request_no_network", null);
        if (!TextUtils.isEmpty(config17)) {
            sh1.h0(Boolean.valueOf(config17).booleanValue());
        }
        String config18 = getConfig(str, "network_bind_service_optimize", null);
        if (!TextUtils.isEmpty(config18)) {
            boolean booleanValue3 = Boolean.valueOf(config18).booleanValue();
            SharedPreferences.Editor edit3 = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
            edit3.putBoolean(sh1.SERVICE_OPTIMIZE, booleanValue3);
            edit3.apply();
        }
        String config19 = getConfig(str, "network_forbid_next_launch_optimize", null);
        if (!TextUtils.isEmpty(config19)) {
            boolean booleanValue4 = Boolean.valueOf(config19).booleanValue();
            SharedPreferences.Editor edit4 = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
            edit4.putBoolean(h9.NEXT_LAUNCH_FORBID, booleanValue4);
            edit4.apply();
        }
        String config20 = getConfig(str, "network_detect_enable_switch", null);
        if (!TextUtils.isEmpty(config20)) {
            h9.y0(Boolean.valueOf(config20).booleanValue());
        }
        String config21 = getConfig(str, "network_ipv6_global_enable_swtich", null);
        if (!TextUtils.isEmpty(config21)) {
            h9.q0(Boolean.valueOf(config21).booleanValue());
        }
        String config22 = getConfig(str, "network_xquic_cong_control", null);
        if (!TextUtils.isEmpty(config22)) {
            h9.E0(Integer.valueOf(config22).intValue());
        }
        String config23 = getConfig(str, "network_http3_detect_valid_time", null);
        if (!TextUtils.isEmpty(config23)) {
            Http3ConnectionDetector.n(Long.valueOf(config23).longValue());
        }
        String config24 = getConfig(str, "network_cookie_monitor", null);
        if (!TextUtils.isEmpty(config24)) {
            CookieManager.m(config24);
        }
        String config25 = getConfig(str, "network_cookie_header_redundant_fix", null);
        if (!TextUtils.isEmpty(config25)) {
            h9.a0(Boolean.valueOf(config25).booleanValue());
        }
        String config26 = getConfig(str, "network_channel_local_instance_enable_switch", null);
        if (!TextUtils.isEmpty(config26)) {
            sh1.R(Boolean.valueOf(config26).booleanValue());
        }
        String config27 = getConfig(str, "network_widget_local_instance_enable_switch", null);
        if (!TextUtils.isEmpty(config27)) {
            sh1.m0(Boolean.valueOf(config27).booleanValue());
        }
        String config28 = getConfig(str, "network_allow_spdy_when_bind_service_failed", null);
        if (!TextUtils.isEmpty(config28)) {
            sh1.L(Boolean.valueOf(config28).booleanValue());
        }
        String config29 = getConfig(str, "network_send_connect_info_by_service", null);
        if (!TextUtils.isEmpty(config29)) {
            h9.z0(Boolean.valueOf(config29).booleanValue());
        }
        String config30 = getConfig(str, "network_http_dns_notify_white_list", null);
        if (!TextUtils.isEmpty(config30)) {
            h9.j0(config30);
        }
        String config31 = getConfig(str, "network_long_request_monitor_enable_switch", null);
        if (!TextUtils.isEmpty(config31)) {
            sh1.W(Boolean.valueOf(config31).booleanValue());
        }
        String config32 = getConfig(str, "network_ipv6_rate_optimize_enable_switch", null);
        SharedPreferences.Editor edit5 = PreferenceManager.getDefaultSharedPreferences(ss0.c()).edit();
        if (TextUtils.isEmpty(config32)) {
            boolean booleanValue5 = Boolean.valueOf(config32).booleanValue();
            h9.s0(booleanValue5);
            edit5.putBoolean(h9.IPV6_RATE_OPTIMIZE_EANBLE, booleanValue5);
        } else {
            edit5.remove(h9.IPV6_RATE_OPTIMIZE_EANBLE);
        }
        edit5.apply();
        String config33 = getConfig(str, "network_allow_add_ab_header_in_mtop", null);
        if (!TextUtils.isEmpty(config33)) {
            sh1.J(Boolean.valueOf(config33).booleanValue());
        }
        String config34 = getConfig(str, "network_ipv6_only_enable_switch", null);
        if (!TextUtils.isEmpty(config34)) {
            h9.r0(Boolean.valueOf(config34).booleanValue());
        }
        String config35 = getConfig(str, "network_allow_convert_ipv4_to_ipv6_enable_switch", null);
        if (!TextUtils.isEmpty(config35)) {
            h9.u0(Boolean.valueOf(config35).booleanValue());
        }
        String config36 = getConfig(str, "network_strategy_new_unique_id_enable_switch", null);
        if (!TextUtils.isEmpty(config36)) {
            h9.A0(Boolean.valueOf(config36).booleanValue());
        }
        SharedPreferences.Editor edit6 = PreferenceManager.getDefaultSharedPreferences(ss0.c()).edit();
        String config37 = getConfig(str, "network_multi_path_trigger_time", null);
        if (!TextUtils.isEmpty(config37)) {
            long longValue = Long.valueOf(config37).longValue();
            sh1.b0(longValue);
            edit6.putLong(sh1.MULTI_PATH_TRIGGER_TIME, longValue).apply();
        } else {
            edit6.remove(sh1.MULTI_PATH_TRIGGER_TIME).apply();
        }
        SharedPreferences.Editor edit7 = PreferenceManager.getDefaultSharedPreferences(ss0.c()).edit();
        String config38 = getConfig(str, "network_multi_path_biz_white_list", null);
        if (TextUtils.isEmpty(config38)) {
            sh1.c0(config38);
            edit7.putString(sh1.MULTI_PATH_WHITE_BIZ, config38).apply();
        } else {
            edit7.remove(sh1.MULTI_PATH_WHITE_BIZ).apply();
        }
        SharedPreferences.Editor edit8 = PreferenceManager.getDefaultSharedPreferences(ss0.c()).edit();
        String config39 = getConfig(str, "network_multi_path_url_white_list", null);
        if (!TextUtils.isEmpty(config39)) {
            sh1.d0(config39);
            edit8.putString(sh1.MULTI_PATH_WHITE_URL, config39).apply();
        } else {
            edit8.remove(sh1.MULTI_PATH_WHITE_URL).apply();
        }
        SharedPreferences.Editor edit9 = PreferenceManager.getDefaultSharedPreferences(ss0.c()).edit();
        String config40 = getConfig(str, "network_multi_path_ab_white_list", null);
        if (TextUtils.isEmpty(config40)) {
            sh1.a0(config40);
            edit9.putString(sh1.MULTI_PATH_WHITE_AB, config40).apply();
        } else {
            edit9.remove(sh1.MULTI_PATH_WHITE_AB).apply();
        }
        SharedPreferences.Editor edit10 = PreferenceManager.getDefaultSharedPreferences(ss0.c()).edit();
        String config41 = getConfig(str, "network_multi_path_monitor_enable_switch", null);
        if (!TextUtils.isEmpty(config41)) {
            boolean booleanValue6 = Boolean.valueOf(config41).booleanValue();
            h9.x0(booleanValue6);
            edit10.putBoolean(h9.MULTI_PATH_MONITOR_KEY, booleanValue6).apply();
        } else {
            edit10.remove(h9.MULTI_PATH_MONITOR_KEY).apply();
        }
        SharedPreferences.Editor edit11 = PreferenceManager.getDefaultSharedPreferences(ss0.c()).edit();
        String config42 = getConfig(str, "network_multi_path_harmony_white_list", null);
        if (TextUtils.isEmpty(config42)) {
            h9.d0(config42);
            edit11.putString(h9.MULTI_PATH_HARMONY_WHITE_LIST, config42).apply();
        } else {
            edit11.remove(h9.MULTI_PATH_HARMONY_WHITE_LIST).apply();
        }
        String config43 = getConfig(str, "network_http3_black_list_switch", null);
        SharedPreferences.Editor edit12 = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
        if (!TextUtils.isEmpty(config43)) {
            h9.f0(config43);
            edit12.putString(h9.HTTP3_BLACK_LIST_KEY, config43);
            edit12.apply();
        } else {
            edit12.remove(h9.HTTP3_BLACK_LIST_KEY);
            edit12.apply();
        }
        String config44 = getConfig(str, "network_diagnosis_enable", null);
        if (!TextUtils.isEmpty(config44)) {
            sh1.e0(Boolean.valueOf(config44).booleanValue());
        }
        String config45 = getConfig(str, "network_exception_detect_url", null);
        if (!TextUtils.isEmpty(config45)) {
            h9.c0(config45);
        }
        String config46 = getConfig(str, "network_http_detect_white_list", null);
        if (!TextUtils.isEmpty(config46)) {
            h9.i0(config46);
        }
        String config47 = getConfig(str, "network_detect_center_enable_switch", null);
        SharedPreferences.Editor edit13 = PreferenceManager.getDefaultSharedPreferences(ss0.c()).edit();
        if (!TextUtils.isEmpty(config47)) {
            boolean booleanValue7 = Boolean.valueOf(config47).booleanValue();
            edit13.putBoolean(h9.DETECT_CENTER_ENABLE, booleanValue7);
            h9.b0(booleanValue7);
        } else {
            edit13.remove(h9.DETECT_CENTER_ENABLE);
        }
        edit13.apply();
        String config48 = getConfig(str, "network_amdc_version_degraded_switch", null);
        SharedPreferences.Editor edit14 = PreferenceManager.getDefaultSharedPreferences(ss0.c()).edit();
        if (TextUtils.isEmpty(config48)) {
            boolean booleanValue8 = Boolean.valueOf(config48).booleanValue();
            h9.T(booleanValue8);
            edit14.putBoolean(h9.AMDC_VERSION_DEGRADED_KEY, booleanValue8);
        } else {
            edit14.remove(h9.AMDC_VERSION_DEGRADED_KEY);
        }
        edit14.apply();
        String config49 = getConfig(str, "network_complex_connect_enable_switch", null);
        if (!TextUtils.isEmpty(config49)) {
            h9.Y(Boolean.valueOf(config49).booleanValue());
        }
        String config50 = getConfig(str, "network_complex_connect_white_list", null);
        if (!TextUtils.isEmpty(config50)) {
            h9.Z(config50);
        }
        String config51 = getConfig(str, "network_delay_complex_connect", null);
        if (!TextUtils.isEmpty(config51)) {
            h9.X(Long.valueOf(config51).longValue());
        }
        String config52 = getConfig(str, "network_fast_degrade_white_list", null);
        if (!TextUtils.isEmpty(config52)) {
            sh1.K(config52);
        }
        String config53 = getConfig(str, "network_ipv6_detect_enable_switch", null);
        SharedPreferences.Editor edit15 = PreferenceManager.getDefaultSharedPreferences(ss0.c()).edit();
        if (!TextUtils.isEmpty(config53)) {
            boolean booleanValue9 = Boolean.valueOf(config53).booleanValue();
            h9.p0(booleanValue9);
            edit15.putBoolean(h9.IPV6_DETECT_KEY, booleanValue9);
        } else {
            edit15.remove(h9.IPV6_DETECT_KEY);
        }
        edit15.apply();
        String config54 = getConfig(str, "network_ip_sort_enable_switch", null);
        if (!TextUtils.isEmpty(config54)) {
            h9.m0(Boolean.valueOf(config54).booleanValue());
        }
        String config55 = getConfig(str, "network_mtu_detect_enable_switch", null);
        if (!TextUtils.isEmpty(config55)) {
            h9.w0(Boolean.valueOf(config55).booleanValue());
        }
        try {
            String config56 = getConfig(str, "network_ipv6_rectification_enable_switch", null);
            SharedPreferences.Editor edit16 = PreferenceManager.getDefaultSharedPreferences(ss0.c()).edit();
            if (TextUtils.isEmpty(config56)) {
                boolean booleanValue10 = Boolean.valueOf(config56).booleanValue();
                h9.t0(booleanValue10);
                edit16.putBoolean(h9.IPV6_RECTIFICATION_KEY, booleanValue10);
            } else {
                edit16.remove(h9.IPV6_RECTIFICATION_KEY);
            }
            edit16.apply();
        } catch (Exception unused) {
        }
    }

    @Override // anetwork.channel.config.IRemoteConfig
    public String getConfig(String... strArr) {
        if (!a) {
            ALog.k("awcn.OrangeConfigImpl", "no orange sdk", null, new Object[0]);
            return null;
        }
        try {
            return OrangeConfig.getInstance().getConfig(strArr[0], strArr[1], strArr[2]);
        } catch (Exception e) {
            ALog.d("awcn.OrangeConfigImpl", "get config failed!", null, e, new Object[0]);
            return null;
        }
    }

    @Override // anetwork.channel.config.IRemoteConfig
    public void onConfigUpdate(String str) {
        ALog.f("awcn.OrangeConfigImpl", "onConfigUpdate", null, "namespace", str);
        if ("networkSdk".equals(str)) {
            b(str);
        } else if ("amdc".equals(str)) {
            a(str);
        }
    }

    @Override // anetwork.channel.config.IRemoteConfig
    public void register() {
        if (!a) {
            ALog.k("awcn.OrangeConfigImpl", "no orange sdk", null, new Object[0]);
            return;
        }
        try {
            OrangeConfig.getInstance().registerListener(new String[]{"networkSdk", "amdc"}, new a());
            getConfig("networkSdk", "network_empty_scheme_https_switch", "true");
            getConfig("amdc", "amdc_control_mode", null);
        } catch (Exception e) {
            ALog.d("awcn.OrangeConfigImpl", "register fail", null, e, new Object[0]);
        }
    }

    @Override // anetwork.channel.config.IRemoteConfig
    public void unRegister() {
        if (!a) {
            ALog.k("awcn.OrangeConfigImpl", "no orange sdk", null, new Object[0]);
        } else {
            OrangeConfig.getInstance().unregisterListener(new String[]{"networkSdk"});
        }
    }
}
