package cn.damai.fluttercommon;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import com.taobao.weex.ui.component.WXWeb;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import tb.gm0;
import tb.ht0;
import tb.i3;
import tb.jm0;

/* compiled from: Taobao */
public class DMBaseFlutterActivity extends FlutterBoostActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CHANNEL_NATIVE_BACK = "cn.movieshow.app/flutterback";
    a.b builder;

    private void flutterPlugin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1501863640")) {
            ipChange.ipc$dispatch("1501863640", new Object[]{this});
            return;
        }
        new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL_NATIVE_BACK).invokeMethod(WXWeb.GO_BACK, null);
    }

    private String getPageName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1838693751")) {
            return (String) ipChange.ipc$dispatch("-1838693751", new Object[]{this});
        }
        String stringExtra = getIntent().hasExtra("dm_pageName") ? getIntent().getStringExtra("dm_pageName") : "";
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        return getUrl();
    }

    @Override // io.flutter.embedding.android.FlutterEngineConfigurator, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterActivity
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985378257")) {
            ipChange.ipc$dispatch("1985378257", new Object[]{this, flutterEngine});
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1733634412")) {
            ipChange.ipc$dispatch("1733634412", new Object[]{this, bundle});
            return;
        }
        if (gm0.f().c()) {
            jm0.g().f(null, "onCreate_success", "flutterengine");
        } else {
            jm0.g().f(null, "onCreate_need_init", "flutterengine");
            gm0.f().d();
        }
        super.onCreate(bundle);
        i3.b().e(this);
        ht0.g(getActivity(), getActivity().findViewById(16908290));
    }

    /* access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1444878932")) {
            ipChange.ipc$dispatch("-1444878932", new Object[]{this});
            return;
        }
        super.onDestroy();
        i3.b().f(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1272008706")) {
            return ((Boolean) ipChange.ipc$dispatch("1272008706", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            flutterPlugin();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1297430128")) {
            ipChange.ipc$dispatch("1297430128", new Object[]{this});
            return;
        }
        super.onPause();
        c.e().j(this, this.builder);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1081552489")) {
            ipChange.ipc$dispatch("-1081552489", new Object[]{this});
            return;
        }
        super.onResume();
        this.builder = b.getInstance().b(getPageName());
        c.e().k(this, this.builder);
        i3.b().e(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1340534916")) {
            ipChange.ipc$dispatch("1340534916", new Object[]{this});
            return;
        }
        if (gm0.f().c()) {
            jm0.g().f(null, "onStart_success", "flutterengine");
        } else {
            jm0.g().f(null, "onStart_need_init", "flutterengine");
            gm0.f().d();
        }
        super.onStart();
    }
}
