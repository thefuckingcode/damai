package com.youku.live.livesdk;

import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.utils.AssetUtils;
import com.youku.live.widgets.WidgetActivity;

/* compiled from: Taobao */
public class StreamerActivity extends WidgetActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.widgets.WidgetActivity
    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1866029674")) {
            ipChange.ipc$dispatch("-1866029674", new Object[]{this});
            return;
        }
        super.finish();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.youku.live.widgets.WidgetActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-170422874")) {
            ipChange.ipc$dispatch("-170422874", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getIntent().getExtras();
        LiveSDK.initWithContext(this);
        AssetUtils.readContent(this, "template_laifeng_streamer.json");
    }
}
