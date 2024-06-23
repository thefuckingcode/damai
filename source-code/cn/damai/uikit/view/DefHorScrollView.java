package cn.damai.uikit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DefHorScrollView extends HorizontalScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnScrollListener onScrollListener;

    /* compiled from: Taobao */
    public interface OnScrollListener {
        void onScroll(int i);
    }

    public DefHorScrollView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1428901075")) {
            ipChange.ipc$dispatch("1428901075", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollListener onScrollListener2 = this.onScrollListener;
        if (onScrollListener2 != null) {
            onScrollListener2.onScroll(i);
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255006018")) {
            ipChange.ipc$dispatch("-255006018", new Object[]{this, onScrollListener2});
            return;
        }
        this.onScrollListener = onScrollListener2;
    }

    public DefHorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DefHorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
