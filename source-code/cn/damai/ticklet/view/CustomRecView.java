package cn.damai.ticklet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CustomRecView extends IRecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;

    public CustomRecView(Context context2) {
        super(context2);
        this.context = context2;
    }

    @Override // cn.damai.uikit.irecycler.IRecyclerView, androidx.recyclerview.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-545245982")) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("-545245982", new Object[]{this, motionEvent})).booleanValue();
    }

    public CustomRecView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public CustomRecView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
    }
}
