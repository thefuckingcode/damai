package cn.damai.uikit.banner.loader;

import android.content.Context;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class ViewLoader implements ImageLoaderInterface<View> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.loader.ImageLoaderInterface
    public View createImageView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "133431450")) {
            return new View(context);
        }
        return (View) ipChange.ipc$dispatch("133431450", new Object[]{this, context});
    }
}
