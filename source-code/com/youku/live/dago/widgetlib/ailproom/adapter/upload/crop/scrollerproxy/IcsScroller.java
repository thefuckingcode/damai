package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IcsScroller extends GingerScroller {
    private static transient /* synthetic */ IpChange $ipChange;

    public IcsScroller(Context context) {
        super(context);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.GingerScroller, com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public boolean computeScrollOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-225194310")) {
            return this.mScroller.computeScrollOffset();
        }
        return ((Boolean) ipChange.ipc$dispatch("-225194310", new Object[]{this})).booleanValue();
    }
}
