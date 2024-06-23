package cn.damai.baseview.abcpullrefresh.actionbarcompat;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher;
import cn.damai.baseview.abcpullrefresh.library.d;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PullToRefreshLayout extends cn.damai.baseview.abcpullrefresh.library.PullToRefreshLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    public PullToRefreshLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshLayout
    public PullToRefreshAttacher createPullToRefreshAttacher(Activity activity, d dVar) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1501682505")) {
            return new a(activity, dVar);
        }
        return (PullToRefreshAttacher) ipChange.ipc$dispatch("1501682505", new Object[]{this, activity, dVar});
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
