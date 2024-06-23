package cn.damai.trade.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MyRelativerlayout extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    int count;
    public int newhight;
    public int oldhight;

    public MyRelativerlayout(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1929717248")) {
            ipChange.ipc$dispatch("1929717248", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1344917326")) {
            ipChange.ipc$dispatch("1344917326", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "41139449")) {
            ipChange.ipc$dispatch("41139449", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.newhight = i2;
        this.oldhight = i4;
    }

    public MyRelativerlayout(Context context2) {
        super(context2);
    }
}
