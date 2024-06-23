package com.youku.live.dsl.image;

import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IImageLoaderVirtualImp implements IImageLoader {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader blur(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1248349367")) {
            return this;
        }
        return (IImageLoader) ipChange.ipc$dispatch("-1248349367", new Object[]{this, Integer.valueOf(i)});
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader circle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1487220735")) {
            return this;
        }
        return (IImageLoader) ipChange.ipc$dispatch("1487220735", new Object[]{this});
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader into(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1848348521")) {
            return this;
        }
        return (IImageLoader) ipChange.ipc$dispatch("1848348521", new Object[]{this, imageView});
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader loadUrl(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "480863722")) {
            return this;
        }
        return (IImageLoader) ipChange.ipc$dispatch("480863722", new Object[]{this, str});
    }

    @Override // com.youku.live.dsl.image.IImageLoader
    public IImageLoader round(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-148768042")) {
            return this;
        }
        return (IImageLoader) ipChange.ipc$dispatch("-148768042", new Object[]{this, Integer.valueOf(i)});
    }
}
