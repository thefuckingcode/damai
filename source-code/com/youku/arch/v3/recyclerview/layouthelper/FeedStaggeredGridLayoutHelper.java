package com.youku.arch.v3.recyclerview.layouthelper;

import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.DisplayUtils;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
public class FeedStaggeredGridLayoutHelper extends StaggeredGridLayoutHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "GridLayoutHelper";
    private BaseLayoutHelper.LayoutViewBindListener feedViewBindListener;
    protected boolean hasForceOffBackgroundRes = false;
    private View mLayoutView;

    public FeedStaggeredGridLayoutHelper() {
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void bindLayoutView(@NonNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1767865838")) {
            ipChange.ipc$dispatch("1767865838", new Object[]{this, view});
            return;
        }
        if (this.mLayoutView == null) {
            this.mLayoutView = view;
            view.measure(View.MeasureSpec.makeMeasureSpec(Rect.width(this.mLayoutRegion), 1073741824), View.MeasureSpec.makeMeasureSpec(DisplayUtils.getHeightPixels(), 1073741824));
        }
        android.graphics.Rect rect = this.mLayoutRegion;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
        BaseLayoutHelper.LayoutViewBindListener layoutViewBindListener = this.feedViewBindListener;
        if (layoutViewBindListener != null) {
            layoutViewBindListener.onBind(view, this);
        }
        this.mLayoutRegion.set(0, 0, 0, 0);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "442230516")) {
            ipChange.ipc$dispatch("442230516", new Object[]{this, layoutManagerHelper});
            return;
        }
        super.onClear(layoutManagerHelper);
    }

    @Override // com.alibaba.android.vlayout.a, com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper
    public void onOffsetChildrenVertical(int i, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045730886")) {
            ipChange.ipc$dispatch("2045730886", new Object[]{this, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        try {
            super.onOffsetChildrenVertical(i, layoutManagerHelper);
        } catch (Throwable th) {
            if (AppInfoProviderProxy.isDebuggable()) {
                th.printStackTrace();
            }
        }
    }

    public void resetBackgroundResStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2094496187")) {
            ipChange.ipc$dispatch("2094496187", new Object[]{this});
            return;
        }
        this.hasForceOffBackgroundRes = true;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setLayoutViewBindListener(BaseLayoutHelper.LayoutViewBindListener layoutViewBindListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2110251521")) {
            ipChange.ipc$dispatch("2110251521", new Object[]{this, layoutViewBindListener});
            return;
        }
        super.setLayoutViewBindListener(layoutViewBindListener);
        this.feedViewBindListener = layoutViewBindListener;
    }

    public FeedStaggeredGridLayoutHelper(int i) {
        super(i);
    }

    public FeedStaggeredGridLayoutHelper(int i, int i2) {
        super(i, i2);
    }
}
