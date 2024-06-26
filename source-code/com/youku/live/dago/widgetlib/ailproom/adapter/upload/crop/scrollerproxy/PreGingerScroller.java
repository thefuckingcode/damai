package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy;

import android.content.Context;
import android.widget.Scroller;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PreGingerScroller extends ScrollerProxy {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Scroller mScroller;

    public PreGingerScroller(Context context) {
        this.mScroller = new Scroller(context);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public boolean computeScrollOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1681554488")) {
            return this.mScroller.computeScrollOffset();
        }
        return ((Boolean) ipChange.ipc$dispatch("-1681554488", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-523294337")) {
            ipChange.ipc$dispatch("-523294337", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)});
            return;
        }
        this.mScroller.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public void forceFinished(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1241256182")) {
            ipChange.ipc$dispatch("1241256182", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mScroller.forceFinished(z);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public int getCurrX() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1792767794")) {
            return this.mScroller.getCurrX();
        }
        return ((Integer) ipChange.ipc$dispatch("1792767794", new Object[]{this})).intValue();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public int getCurrY() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1792797585")) {
            return this.mScroller.getCurrY();
        }
        return ((Integer) ipChange.ipc$dispatch("1792797585", new Object[]{this})).intValue();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public boolean isFinished() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1958325193")) {
            return this.mScroller.isFinished();
        }
        return ((Boolean) ipChange.ipc$dispatch("-1958325193", new Object[]{this})).booleanValue();
    }
}
