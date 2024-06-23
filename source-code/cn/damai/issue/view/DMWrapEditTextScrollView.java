package cn.damai.issue.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DMWrapEditTextScrollView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange;

    public DMWrapEditTextScrollView(Context context) {
        super(context);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1147459774")) {
            return view instanceof EditText;
        }
        return ((Boolean) ipChange.ipc$dispatch("1147459774", new Object[]{this, view, rect, Boolean.valueOf(z)})).booleanValue();
    }

    public DMWrapEditTextScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMWrapEditTextScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
