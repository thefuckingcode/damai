package com.youku.live.livesdk.wkit.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.Constants;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.livesdk.wkit.widget.view.WeexWidgetView;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.ISystemEvent;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
public class WeexWidget extends BaseWidget implements ISystemEvent {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mDebugBindBundle;
    private WeexWidgetView mRealView;

    /* compiled from: Taobao */
    private static class ConfigModel implements Serializable {
        public Map<String, String> apperance;
        public Map<String, String> function;
        public boolean safeArea;
        public String url;

        private ConfigModel() {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setWeexScreenType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869286705")) {
            ipChange.ipc$dispatch("-1869286705", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        WeexWidgetView weexWidgetView = this.mRealView;
        if (weexWidgetView != null) {
            weexWidgetView.setScreenType(i);
        }
    }

    public void debugBindBundle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1736823563")) {
            ipChange.ipc$dispatch("-1736823563", new Object[]{this, str});
            return;
        }
        this.mDebugBindBundle = str;
    }

    @Override // com.youku.live.widgets.protocol.IWidget, com.youku.live.widgets.protocol.IDestroyable, com.youku.live.widgets.impl.BaseWidget
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1821793085")) {
            ipChange.ipc$dispatch("-1821793085", new Object[]{this});
            return;
        }
        super.destroy();
        WeexWidgetView weexWidgetView = this.mRealView;
        if (weexWidgetView != null) {
            weexWidgetView.destroy();
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        ConfigModel configModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564040742")) {
            return (View) ipChange.ipc$dispatch("-1564040742", new Object[]{this, context});
        }
        this.mRealView = new WeexWidgetView(context);
        String string = getProps().getString(Constants.CONFIG, null);
        if (!(string == null || (configModel = (ConfigModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(string, ConfigModel.class)) == null || TextUtils.isEmpty(configModel.url))) {
            render(configModel.url, getEngineInstance().getOptions().toMap(), null);
        }
        this.mRealView.bindEngineInstance(getEngineInstance());
        return this.mRealView;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityBackPressedListener
    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2107234196")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2107234196", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityConfigurationChangedListener
    public void onActivityConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        final int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "1082195695")) {
            ipChange.ipc$dispatch("1082195695", new Object[]{this, configuration});
            return;
        }
        if (configuration != null) {
            i = configuration.orientation;
        }
        getEngineInstance().runOnMainThread(new Runnable() {
            /* class com.youku.live.livesdk.wkit.widget.WeexWidget.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-825877595")) {
                    ipChange.ipc$dispatch("-825877595", new Object[]{this});
                    return;
                }
                WeexWidget.this.setWeexScreenType(i);
            }
        });
    }

    @Override // com.youku.live.widgets.protocol.ISystemEvent
    public void onActivityDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2078217073")) {
            ipChange.ipc$dispatch("2078217073", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityLowMemoryListener
    public void onActivityLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1937290602")) {
            ipChange.ipc$dispatch("-1937290602", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773722485")) {
            ipChange.ipc$dispatch("773722485", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityRequestPermissionsResultListener
    public void onActivityRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876134231")) {
            ipChange.ipc$dispatch("1876134231", new Object[]{this, Integer.valueOf(i), strArr, iArr});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResultListener
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734208223")) {
            ipChange.ipc$dispatch("1734208223", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityResumeStateChangedListener
    public void onActivityResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-136620238")) {
            ipChange.ipc$dispatch("-136620238", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStartStateChangedListener
    public void onActivityStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "816827273")) {
            ipChange.ipc$dispatch("816827273", new Object[]{this});
            return;
        }
        WeexWidgetView weexWidgetView = this.mRealView;
        if (weexWidgetView != null) {
            weexWidgetView.onActivityStart();
        }
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityStartStateChangedListener
    public void onActivityStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1008977341")) {
            ipChange.ipc$dispatch("1008977341", new Object[]{this});
            return;
        }
        WeexWidgetView weexWidgetView = this.mRealView;
        if (weexWidgetView != null) {
            weexWidgetView.onActivityStop();
        }
    }

    public boolean onBackPressed() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1789613477")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1789613477", new Object[]{this})).booleanValue();
    }

    public void render(String str, Map<String, Object> map, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "669826702")) {
            ipChange.ipc$dispatch("669826702", new Object[]{this, str, map, str2});
            return;
        }
        String str3 = this.mDebugBindBundle;
        if (!TextUtils.isEmpty(str3)) {
            str = str3;
        }
        WeexWidgetView weexWidgetView = this.mRealView;
        if (weexWidgetView != null) {
            weexWidgetView.render(str, map, str2);
        }
    }

    @Override // com.youku.live.widgets.protocol.ISystemEvent
    public boolean systemEventFilter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "246370590")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("246370590", new Object[]{this})).booleanValue();
    }
}
