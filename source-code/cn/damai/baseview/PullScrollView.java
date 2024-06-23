package cn.damai.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s50;

/* compiled from: Taobao */
public class PullScrollView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnScrollListener onScrollListener;

    /* compiled from: Taobao */
    public interface OnScrollListener {
        void isScrollIng(int i);

        void onScroll(PullScrollView pullScrollView);
    }

    public PullScrollView(Context context) {
        this(context, null);
    }

    public int computeVerticalScrollRange() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-501763238")) {
            return super.computeVerticalScrollRange();
        }
        return ((Integer) ipChange.ipc$dispatch("-501763238", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "433961112")) {
            ipChange.ipc$dispatch("433961112", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollListener onScrollListener2 = this.onScrollListener;
        if (onScrollListener2 != null) {
            onScrollListener2.isScrollIng(s50.d(getContext(), (float) getScrollY()));
            if (getHeight() + getScrollY() >= computeVerticalScrollRange()) {
                this.onScrollListener.onScroll(this);
            }
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-930840076")) {
            ipChange.ipc$dispatch("-930840076", new Object[]{this, onScrollListener2});
            return;
        }
        this.onScrollListener = onScrollListener2;
    }

    public PullScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
