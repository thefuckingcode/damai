package cn.damai.uikit.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

@SuppressLint({"AppCompatCustomView"})
/* compiled from: Taobao */
public class LabelView extends CheckedTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Drawable checkDrawable;
    private Drawable normalDrawable;

    public LabelView(Context context) {
        super(context);
    }

    public void setBackground(Drawable drawable, Drawable drawable2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-214694155")) {
            ipChange.ipc$dispatch("-214694155", new Object[]{this, drawable, drawable2});
            return;
        }
        this.normalDrawable = drawable;
        this.checkDrawable = drawable2;
    }

    public void setChecked(boolean z) {
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654412236")) {
            ipChange.ipc$dispatch("1654412236", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (!z || (drawable = this.checkDrawable) == null) {
            Drawable drawable2 = this.normalDrawable;
            if (drawable2 != null) {
                setBackgroundDrawable(drawable2);
            }
        } else {
            setBackgroundDrawable(drawable);
        }
        super.setChecked(z);
    }

    public LabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
