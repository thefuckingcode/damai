package cn.damai.homepage.ui.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ScrollSpeedLinearLayoutManger extends LinearLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange;

    public ScrollSpeedLinearLayoutManger(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "183063332")) {
            ipChange.ipc$dispatch("183063332", new Object[]{this, recyclerView, state, Integer.valueOf(i)});
            return;
        }
        AnonymousClass1 r6 = new LinearSmoothScroller(recyclerView.getContext()) {
            /* class cn.damai.homepage.ui.view.ScrollSpeedLinearLayoutManger.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* access modifiers changed from: protected */
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-724492939")) {
                    return 2.0f;
                }
                return ((Float) ipChange.ipc$dispatch("-724492939", new Object[]{this, displayMetrics})).floatValue();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1184432691")) {
                    return ScrollSpeedLinearLayoutManger.this.computeScrollVectorForPosition(i);
                }
                return (PointF) ipChange.ipc$dispatch("-1184432691", new Object[]{this, Integer.valueOf(i)});
            }
        };
        r6.setTargetPosition(i);
        startSmoothScroll(r6);
    }
}
