package com.taobao.weex.ui.view.refresh.wrapper;

import android.annotation.SuppressLint;
import android.content.Context;
import com.taobao.weex.ui.component.WXScroller;
import com.taobao.weex.ui.view.WXScrollView;

@SuppressLint({"ViewConstructor"})
/* compiled from: Taobao */
public class BounceScrollerView extends BaseBounceView<WXScrollView> {
    public BounceScrollerView(Context context, int i, WXScroller wXScroller) {
        super(context, i);
        init(context);
        if (getInnerView() != null) {
            ((WXScrollView) getInnerView()).setWAScroller(wXScroller);
        }
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onLoadmoreComplete() {
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onRefreshingComplete() {
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public WXScrollView setInnerView(Context context) {
        return new WXScrollView(context);
    }
}
