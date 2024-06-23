package cn.damai.baseview.pull.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class HeaderView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private View view = null;

    public HeaderView(Context context) {
        super(context);
    }

    public void addView(View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847672483")) {
            ipChange.ipc$dispatch("-1847672483", new Object[]{this, view2});
            return;
        }
        super.addView(view2, new LinearLayout.LayoutParams(-1, -1));
        this.view = view2;
    }

    public View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "353517890")) {
            return this.view;
        }
        return (View) ipChange.ipc$dispatch("353517890", new Object[]{this});
    }

    public HeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
