package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SmoothScrollLayoutManager extends LinearLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private float MILLISECONDS_PER_INCH = 1.0f;

    public SmoothScrollLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196895134")) {
            ipChange.ipc$dispatch("-1196895134", new Object[]{this, recyclerView, state, Integer.valueOf(i)});
            return;
        }
        AnonymousClass1 r6 = new LinearSmoothScroller(recyclerView.getContext()) {
            /* class com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.SmoothScrollLayoutManager.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* access modifiers changed from: protected */
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1310574797")) {
                    return SmoothScrollLayoutManager.this.MILLISECONDS_PER_INCH / displayMetrics.density;
                }
                return ((Float) ipChange.ipc$dispatch("-1310574797", new Object[]{this, displayMetrics})).floatValue();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "280561803")) {
                    return SmoothScrollLayoutManager.this.computeScrollVectorForPosition(i);
                }
                return (PointF) ipChange.ipc$dispatch("280561803", new Object[]{this, Integer.valueOf(i)});
            }
        };
        r6.setTargetPosition(i);
        startSmoothScroll(r6);
    }
}
