package cn.damai.uikit.banner.loader;

import android.content.Context;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class ImageLoader implements ImageLoaderInterface<ImageView> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.banner.loader.ImageLoaderInterface
    public ImageView createImageView(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "529788236")) {
            return new ImageView(context);
        }
        return (ImageView) ipChange.ipc$dispatch("529788236", new Object[]{this, context});
    }
}
