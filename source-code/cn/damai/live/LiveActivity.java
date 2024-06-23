package cn.damai.live;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.h5container.DMBridge;
import cn.damai.live.util.NetworkBroadcastReceiver;
import cn.damai.live.weex.DMWXMtopModule;
import cn.damai.live.weex.DMWXShareModule;
import cn.damai.live.weex.DMWeexLogModule;
import cn.damai.live.weex.YoukuEventCenterModule;
import cn.damai.login.LoginManager;
import cn.damai.login.havana.HavanaProxy;
import cn.damai.login.havana.ILoginListener;
import cn.damai.message.observer.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.youku.live.livesdk.constants.SchemaConstants;
import com.youku.live.widgets.WidgetActivity;
import tb.b91;
import tb.br;
import tb.ol1;
import tb.yh1;

/* compiled from: Taobao */
public class LiveActivity extends com.youku.live.livesdk.LiveActivity implements ILoginListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String EXTRA_ITEM_ID = "itemId";
    public static final String OPTION_DAMAI_ITEM_ID = "dm_itemId";
    public static final String OPTION_SHARE_URL = "shareUrl";
    public static final String OPTION_TTID = "dmChannel";
    private static final String TTAG_DAMAI = "damai_live";
    private NetworkBroadcastReceiver netChangeReceiver;
    private String notWifiNet = "当前为非WIFI环境，请注意流量消耗";

    /* compiled from: Taobao */
    public class a implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1731776239")) {
                ipChange.ipc$dispatch("-1731776239", new Object[]{this, str});
                return;
            }
            LiveActivity liveActivity = LiveActivity.this;
            b91.c(liveActivity, ((WidgetActivity) liveActivity).root).d(str);
        }
    }

    /* compiled from: Taobao */
    public class b implements NetworkBroadcastReceiver.OnNetworkChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.live.util.NetworkBroadcastReceiver.OnNetworkChangeListener
        public void onNetworkChange() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1849484581")) {
                ipChange.ipc$dispatch("1849484581", new Object[]{this});
            } else if (yh1.a(LiveActivity.this)) {
                ToastUtil.i(LiveActivity.this.notWifiNet);
            }
        }
    }

    private void ensureWeexOption(Intent intent, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "537394475")) {
            ipChange.ipc$dispatch("537394475", new Object[]{this, intent, str});
        } else if (intent != null && !TextUtils.isEmpty(str) && TextUtils.isEmpty(intent.getStringExtra(str)) && intent.getData() != null) {
            String queryParameter = intent.getData().getQueryParameter(str);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(str, queryParameter);
            }
        }
    }

    private String getParam(Intent intent, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "215359672")) {
            return (String) ipChange.ipc$dispatch("215359672", new Object[]{this, intent, str});
        }
        String str2 = null;
        if (intent == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Uri data = intent.getData();
        if (data != null && !TextUtils.isEmpty(data.getQueryParameter(str))) {
            str2 = data.getQueryParameter(str);
        }
        return TextUtils.isEmpty(str2) ? intent.getStringExtra(str) : str2;
    }

    private void onNetworkChangeLister() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "397969640")) {
            ipChange.ipc$dispatch("397969640", new Object[]{this});
            return;
        }
        NetworkBroadcastReceiver networkBroadcastReceiver = new NetworkBroadcastReceiver(this);
        this.netChangeReceiver = networkBroadcastReceiver;
        networkBroadcastReceiver.c(new b());
        this.netChangeReceiver.b();
    }

    private void onUnbind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012291869")) {
            ipChange.ipc$dispatch("-1012291869", new Object[]{this});
            return;
        }
        try {
            HavanaProxy.v().Q(this);
            LoginManager.k().D(this);
        } catch (Exception unused) {
        }
    }

    private void prepareParam() {
        Uri data;
        Uri uri;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1038171886")) {
            ipChange.ipc$dispatch("-1038171886", new Object[]{this});
        } else if (getIntent() != null && (data = getIntent().getData()) != null) {
            String queryParameter = data.getQueryParameter("roomId");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = getIntent().getStringExtra("roomId");
            }
            if (!TextUtils.isEmpty(queryParameter)) {
                String dataString = getIntent().getDataString();
                if (data.getQuery() == null) {
                    Intent intent = getIntent();
                    intent.setData(Uri.parse(dataString + "?id=" + queryParameter));
                } else {
                    Intent intent2 = getIntent();
                    intent2.setData(Uri.parse(dataString + "&id=" + queryParameter));
                }
            }
            String b2 = OrangeConfigCenter.c().b(ol1.LIVE_WEEX_CONFIG, "live_ttag", TTAG_DAMAI);
            Uri data2 = getIntent().getData();
            if (TextUtils.isEmpty(data2.getQueryParameter(SchemaConstants.SCHEMA_QUERY_TPL_TAG))) {
                String stringExtra = getIntent().getStringExtra(SchemaConstants.SCHEMA_QUERY_TPL_TAG);
                if (!TextUtils.isEmpty(stringExtra)) {
                    uri = data2.buildUpon().appendQueryParameter(SchemaConstants.SCHEMA_QUERY_TPL_TAG, stringExtra).build();
                } else {
                    getIntent().putExtra(SchemaConstants.SCHEMA_QUERY_TPL_TAG, b2);
                    uri = data2.buildUpon().appendQueryParameter(SchemaConstants.SCHEMA_QUERY_TPL_TAG, b2).build();
                }
                getIntent().setData(uri);
                return;
            }
            getIntent().putExtra(SchemaConstants.SCHEMA_QUERY_TPL_TAG, b2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, com.youku.live.widgets.WidgetActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809437002")) {
            ipChange.ipc$dispatch("809437002", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.youku.live.livesdk.LiveActivity, androidx.fragment.app.FragmentActivity, com.youku.live.widgets.WidgetActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-466397385")) {
            ipChange.ipc$dispatch("-466397385", new Object[]{this, bundle});
            return;
        }
        prepareParam();
        supportRequestWindowFeature(1);
        WXEnvironment.addCustomOptions(OPTION_TTID, AppConfig.p());
        String param = getParam(getIntent(), "itemId");
        if (!TextUtils.isEmpty(param)) {
            getIntent().putExtra(OPTION_DAMAI_ITEM_ID, param);
        }
        super.onCreate(bundle);
        try {
            registerModulesAndComponents();
        } catch (WXException e) {
            e.printStackTrace();
        }
        if (AppConfig.v()) {
            registerWeexLog();
        }
        onNetworkChangeLister();
        HavanaProxy.v().g(this);
        LoginManager.k().B(this);
    }

    @Override // com.youku.live.livesdk.LiveActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.youku.live.widgets.WidgetActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974370359")) {
            ipChange.ipc$dispatch("1974370359", new Object[]{this});
            return;
        }
        super.onDestroy();
        NetworkBroadcastReceiver networkBroadcastReceiver = this.netChangeReceiver;
        if (networkBroadcastReceiver != null) {
            networkBroadcastReceiver.d();
        }
        onUnbind();
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1816656462")) {
            ipChange.ipc$dispatch("1816656462", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1031624726")) {
            ipChange.ipc$dispatch("-1031624726", new Object[]{this});
        }
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139172001")) {
            ipChange.ipc$dispatch("-2139172001", new Object[]{this});
            return;
        }
        LoginManager.k().t(this);
    }

    @Override // cn.damai.login.havana.ILoginListener
    public void onLogout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139006767")) {
            ipChange.ipc$dispatch("139006767", new Object[]{this});
            return;
        }
        LoginManager.k().G();
    }

    public void registerModulesAndComponents() throws WXException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886275759")) {
            ipChange.ipc$dispatch("1886275759", new Object[]{this});
            return;
        }
        WXSDKEngine.registerModule("YoukuEventCenter", YoukuEventCenterModule.class);
        WXSDKEngine.registerModule("DmConsole", DMWeexLogModule.class);
        WXSDKEngine.registerModule("DMShare", DMWXShareModule.class);
        WXSDKEngine.registerModule("yk-external-mtop", DMWXMtopModule.class);
        DMBridge.registerPlugin(this);
    }

    public void registerWeexLog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1357742610")) {
            ipChange.ipc$dispatch("1357742610", new Object[]{this});
            return;
        }
        new br().b("weexLog", new a());
    }
}
