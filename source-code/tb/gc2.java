package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.solid.bean.SoGroupEnum;
import cn.damai.solid.listener.SoInstallListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class gc2 implements DMNav.NavPreprocessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile boolean a;

    /* compiled from: Taobao */
    public class a implements SoInstallListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ Intent b;

        a(Context context, Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // cn.damai.solid.listener.SoInstallListener
        public Map<String, String> alarmExtraMap() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "25214345")) {
                return (Map) ipChange.ipc$dispatch("25214345", new Object[]{this});
            }
            HashMap hashMap = new HashMap();
            hashMap.put("msg2Dev", "直播间跳转失败了");
            try {
                String stringExtra = this.b.getStringExtra("roomId");
                String stringExtra2 = this.b.getStringExtra("itemId");
                hashMap.put("roomId", stringExtra);
                hashMap.put("itemId", stringExtra2);
            } catch (Exception e) {
                e.printStackTrace();
                hashMap.put("alarmExp", e.getMessage());
            }
            return hashMap;
        }

        @Override // cn.damai.solid.listener.SoInstallListener
        public void onInstallFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "346043243")) {
                ipChange.ipc$dispatch("346043243", new Object[]{this, str, str2});
                return;
            }
            ToastUtil.a().j(this.a, str2);
        }

        @Override // cn.damai.solid.listener.SoInstallListener
        public void onInstallSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1804614226")) {
                ipChange.ipc$dispatch("1804614226", new Object[]{this});
                return;
            }
            gc2.this.b();
            if (!(this.a instanceof Activity)) {
                this.b.addFlags(268435456);
            }
            this.a.startActivity(this.b);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "176856796")) {
            ipChange.ipc$dispatch("176856796", new Object[]{this});
        } else if (!a) {
            a = true;
            jz2.a(xs0.a());
        }
    }

    @Override // cn.damai.common.nav.DMNav.NavPreprocessor
    public void addStackUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-992223538")) {
            ipChange.ipc$dispatch("-992223538", new Object[]{this, uri});
        }
    }

    @Override // cn.damai.common.nav.DMNav.NavPreprocessor
    public boolean beforeNavTo(Intent intent, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1772077968")) {
            return ((Boolean) ipChange.ipc$dispatch("-1772077968", new Object[]{this, intent, context})).booleanValue();
        }
        Uri data = intent.getData();
        if (data == null || !TextUtils.equals("liveroom", data.getHost())) {
            return false;
        }
        cn.damai.solid.a.d().b(context, SoGroupEnum.WEEX, new a(context, intent));
        cn.damai.solid.a.f("WeexNavProcessor 启动了 Weex DMNav 拦截");
        return true;
    }
}
