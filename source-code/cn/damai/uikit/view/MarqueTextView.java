package cn.damai.uikit.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

@SuppressLint({"AppCompatCustomView"})
/* compiled from: Taobao */
public class MarqueTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;

    public MarqueTextView(Context context) {
        super(context);
    }

    public boolean isFocused() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1713884683")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1713884683", new Object[]{this})).booleanValue();
    }

    public MarqueTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarqueTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
