package com.youku.live.dsl.image;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IImageLoaderFactoryVirtualImp implements IImageLoaderFactory {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.image.IImageLoaderFactory
    public IImageLoader createInstance() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1101800820")) {
            return new IImageLoaderVirtualImp();
        }
        return (IImageLoader) ipChange.ipc$dispatch("-1101800820", new Object[]{this});
    }
}
