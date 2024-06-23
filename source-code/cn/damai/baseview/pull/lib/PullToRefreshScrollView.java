package cn.damai.baseview.pull.lib;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import cn.damai.baseview.pull.lib.PullToRefreshBase;
import cn.damai.uikit.view.MyScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PullToRefreshScrollView extends PullToRefreshBase<MyScrollView> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final PullToRefreshBase.OnRefreshListener defaultOnRefreshListener;
    private RefreshListener refreshListener;

    /* compiled from: Taobao */
    public interface RefreshListener {
        void onRefresh(PullToRefreshScrollView pullToRefreshScrollView);
    }

    /* compiled from: Taobao */
    public class a implements PullToRefreshBase.OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.baseview.pull.lib.PullToRefreshBase.OnRefreshListener
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1209124043")) {
                ipChange.ipc$dispatch("-1209124043", new Object[]{this});
            } else if (PullToRefreshScrollView.this.refreshListener != null) {
                PullToRefreshScrollView.this.refreshListener.onRefresh(PullToRefreshScrollView.this);
            }
        }
    }

    public PullToRefreshScrollView(Context context) {
        super(context);
        a aVar = new a();
        this.defaultOnRefreshListener = aVar;
        setOnRefreshListener(aVar);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.baseview.pull.lib.PullToRefreshBase
    public boolean isReadyForPullDown() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1431736697")) {
            return ((MyScrollView) this.refreshableView).getScrollY() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1431736697", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.baseview.pull.lib.PullToRefreshBase
    public boolean isReadyForPullUp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2135574880")) {
            return ((Boolean) ipChange.ipc$dispatch("2135574880", new Object[]{this})).booleanValue();
        }
        ScrollView scrollView = (ScrollView) getRefreshableView();
        if ((scrollView.getScrollY() + scrollView.getHeight()) - scrollView.getChildAt(0).getHeight() == 0) {
            return true;
        }
        return false;
    }

    public void setRefreshListener(RefreshListener refreshListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2102824844")) {
            ipChange.ipc$dispatch("2102824844", new Object[]{this, refreshListener2});
            return;
        }
        this.refreshListener = refreshListener2;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.baseview.pull.lib.PullToRefreshBase
    public MyScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1298004191")) {
            return (MyScrollView) ipChange.ipc$dispatch("1298004191", new Object[]{this, context, attributeSet});
        }
        MyScrollView myScrollView = new MyScrollView(context, attributeSet);
        myScrollView.setFadingEdgeLength(0);
        return myScrollView;
    }

    public PullToRefreshScrollView(Context context, int i) {
        super(context, i);
        a aVar = new a();
        this.defaultOnRefreshListener = aVar;
        setOnRefreshListener(aVar);
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a();
        this.defaultOnRefreshListener = aVar;
        setOnRefreshListener(aVar);
    }
}
