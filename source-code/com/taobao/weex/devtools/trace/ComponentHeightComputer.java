package com.taobao.weex.devtools.trace;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXScroller;
import com.taobao.weex.ui.component.list.WXListComponent;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ComponentHeightComputer {
    private ComponentHeightComputer() {
    }

    static int computeComponentContentHeight(@NonNull WXComponent wXComponent) {
        View hostView = wXComponent.getHostView();
        if (hostView == null) {
            return 0;
        }
        if (wXComponent instanceof WXListComponent) {
            BounceRecyclerView bounceRecyclerView = (BounceRecyclerView) ((WXListComponent) wXComponent).getHostView();
            if (bounceRecyclerView == null) {
                return 0;
            }
            WXRecyclerView wXRecyclerView = (WXRecyclerView) bounceRecyclerView.getInnerView();
            if (wXRecyclerView == null) {
                return bounceRecyclerView.getMeasuredHeight();
            }
            return wXRecyclerView.computeVerticalScrollRange();
        } else if (!(wXComponent instanceof WXScroller)) {
            return hostView.getMeasuredHeight();
        } else {
            WXScroller wXScroller = (WXScroller) wXComponent;
            if (!ViewUtils.isVerticalScroller(wXScroller)) {
                return hostView.getMeasuredHeight();
            }
            ViewGroup innerView = wXScroller.getInnerView();
            if (innerView == null) {
                return hostView.getMeasuredHeight();
            }
            if (innerView.getChildCount() != 1) {
                return hostView.getMeasuredHeight();
            }
            return innerView.getChildAt(0).getMeasuredHeight();
        }
    }
}
