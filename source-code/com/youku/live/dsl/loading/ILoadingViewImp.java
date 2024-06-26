package com.youku.live.dsl.loading;

import android.content.Context;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.resource.widget.YKLoading;

/* compiled from: Taobao */
public class ILoadingViewImp implements ILoadingView {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.loading.ILoadingView
    public View getLoadingView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1159375008")) {
            return new YKLoading(context);
        }
        return (View) ipChange.ipc$dispatch("1159375008", new Object[]{this, context});
    }
}
