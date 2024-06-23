package com.youku.live.widgets.widgets.weex;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.Constants;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.activity.IActivityBackPressedListener;
import com.youku.live.widgets.protocol.activity.IActivityConfigurationOrientationChangedListener;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
public class WeexWidget extends BaseWidget implements IActivityBackPressedListener, IActivityConfigurationOrientationChangedListener {
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
        if (AndroidInstantRuntime.support(ipChange, "-2021915269")) {
            ipChange.ipc$dispatch("-2021915269", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        WeexWidgetView weexWidgetView = this.mRealView;
        if (weexWidgetView != null) {
            weexWidgetView.setScreenType(i);
        }
    }

    public void debugBindBundle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431100727")) {
            ipChange.ipc$dispatch("-431100727", new Object[]{this, str});
            return;
        }
        this.mDebugBindBundle = str;
    }

    @Override // com.youku.live.widgets.protocol.IWidget, com.youku.live.widgets.protocol.IDestroyable, com.youku.live.widgets.impl.BaseWidget
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189561449")) {
            ipChange.ipc$dispatch("-189561449", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-222033234")) {
            return (View) ipChange.ipc$dispatch("-222033234", new Object[]{this, context});
        }
        this.mRealView = new WeexWidgetView(context);
        String string = getProps().getString(Constants.CONFIG, null);
        if (!(string == null || (configModel = (ConfigModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(string, ConfigModel.class)) == null || TextUtils.isEmpty(configModel.url))) {
            render(configModel.url, getEngineInstance().getOptions().toMap(), "");
        }
        this.mRealView.bindEngineInstance(getEngineInstance());
        return this.mRealView;
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityBackPressedListener
    public boolean onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-774916760")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-774916760", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.widgets.protocol.activity.IActivityConfigurationOrientationChangedListener
    public void onActivityConfigurationOrientationChanged(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "643975358")) {
            ipChange.ipc$dispatch("643975358", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        getEngineInstance().runOnMainThread(new Runnable() {
            /* class com.youku.live.widgets.widgets.weex.WeexWidget.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-319151751")) {
                    ipChange.ipc$dispatch("-319151751", new Object[]{this});
                    return;
                }
                WeexWidget.this.setWeexScreenType(i);
            }
        });
    }

    public void render(String str, Map<String, Object> map, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1848853090")) {
            ipChange.ipc$dispatch("1848853090", new Object[]{this, str, map, str2});
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
}
