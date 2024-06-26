package cn.damai.homepage.nestedscroll.recyclerview.layoutmanager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t61;

/* compiled from: Taobao */
public class InternalLinearLayoutManager extends LinearLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private RecyclerView a;

    public InternalLinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1210921975")) {
            return ((Integer) ipChange.ipc$dispatch("-1210921975", new Object[]{this, Integer.valueOf(i), recycler, state})).intValue();
        }
        boolean a2 = t61.a(this.a);
        int scrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
        t61.b(this.a, i, scrollVerticallyBy, a2);
        if (t61.c(this.a, i, scrollVerticallyBy) != 0) {
            return 0;
        }
        return scrollVerticallyBy;
    }

    public InternalLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
