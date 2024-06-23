package tb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.fluttercommon.DMBaseFlutterActivity;
import cn.damai.fluttercommon.DMNFCActivity;
import cn.damai.solid.bean.SoGroupEnum;
import cn.damai.solid.listener.SoInstallListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.c;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class t4 extends sk {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements SoInstallListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ Intent b;
        final /* synthetic */ Context c;

        a(String str, Intent intent, Context context) {
            this.a = str;
            this.b = intent;
            this.c = context;
        }

        @Override // cn.damai.solid.listener.SoInstallListener
        public Map<String, String> alarmExtraMap() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "666302120")) {
                return null;
            }
            return (Map) ipChange.ipc$dispatch("666302120", new Object[]{this});
        }

        @Override // cn.damai.solid.listener.SoInstallListener
        public void onInstallFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "360135498")) {
                ipChange.ipc$dispatch("360135498", new Object[]{this, str, str2});
                return;
            }
            ToastUtil.a().j(xs0.a(), str2);
        }

        @Override // cn.damai.solid.listener.SoInstallListener
        public void onInstallSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-98402669")) {
                ipChange.ipc$dispatch("-98402669", new Object[]{this});
                return;
            }
            t4.this.c(this.a, this.b, this.c);
        }
    }

    private boolean b(Intent intent, Context context) {
        Uri data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1854728467")) {
            return ((Boolean) ipChange.ipc$dispatch("-1854728467", new Object[]{this, intent, context})).booleanValue();
        }
        if (intent == null || context == null || (data = intent.getData()) == null) {
            return true;
        }
        try {
            String uri = data.toString();
            if (!d(uri)) {
                return false;
            }
            if (!uri.contains("un_flutter=")) {
                uri = uri + "&" + "un_flutter=true";
            }
            cn.damai.solid.a.d().b(context, SoGroupEnum.FLUTTER, new a(uri, intent, context));
            return true;
        } catch (Exception unused) {
            g91.c("FlutterNav", "flutter not 不满足跳转逻辑");
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(@NonNull String str, Intent intent, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1342586777")) {
            ipChange.ipc$dispatch("1342586777", new Object[]{this, str, intent, context});
            return;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("flutter_path");
        if (Build.VERSION.SDK_INT >= 11) {
            f(parse);
            if (!TextUtils.isEmpty(queryParameter) && parse.getBooleanQueryParameter("un_flutter", false)) {
                if (gm0.f().c()) {
                    jm0.g().f(null, "buildFlutterBoost_success", "flutterengine");
                } else {
                    jm0.g().f(null, "buildFlutterBoost_need_init", "flutterengine");
                    gm0.f().d();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("_f_origin_url", parse.toString());
                e(parse, hashMap);
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String str2 : extras.keySet()) {
                        hashMap.put(str2, extras.get(str2));
                    }
                }
                FlutterBoost.h().j(new c.b().i(queryParameter).f(hashMap).j(intent.getIntExtra(DMNav.KRequestCodeReferrer, -1)).g());
            }
        }
    }

    private boolean d(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1675972094")) {
            return !TextUtils.isEmpty(str) && str.startsWith("damai://V1/Flutter");
        }
        return ((Boolean) ipChange.ipc$dispatch("1675972094", new Object[]{this, str})).booleanValue();
    }

    @RequiresApi(api = 11)
    private void e(Uri uri, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637834876")) {
            ipChange.ipc$dispatch("1637834876", new Object[]{this, uri, map});
        } else if (uri != null && map != null) {
            try {
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (!(queryParameterNames == null || queryParameterNames.iterator() == null)) {
                    for (String str : queryParameterNames) {
                        try {
                            map.put(str, URLDecoder.decode(uri.getQueryParameter(str)));
                        } catch (Exception unused) {
                            map.put(str, uri.getQueryParameter(str));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("DMNav", "DMNav setUriParamToIntent param error");
            }
        }
    }

    private Class<? extends DMBaseFlutterActivity> f(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2026364834")) {
            return (Class) ipChange.ipc$dispatch("-2026364834", new Object[]{this, uri});
        } else if (Build.VERSION.SDK_INT < 11) {
            return null;
        } else {
            String queryParameter = uri.getQueryParameter("flutter_path");
            if (TextUtils.isEmpty(queryParameter) || !"dm_ticket_nfc".equals(queryParameter)) {
                return DMBaseFlutterActivity.class;
            }
            return DMNFCActivity.class;
        }
    }

    @Override // cn.damai.common.nav.DMNav.NavPreprocessor
    public boolean beforeNavTo(Intent intent, Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1702535025")) {
            return b(intent, context);
        }
        return ((Boolean) ipChange.ipc$dispatch("1702535025", new Object[]{this, intent, context})).booleanValue();
    }
}
