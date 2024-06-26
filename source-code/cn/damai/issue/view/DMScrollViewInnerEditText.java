package cn.damai.issue.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DMScrollViewInnerEditText extends AppCompatEditText {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean mBottomFlag = false;
    private int mOffsetHeight;

    public DMScrollViewInnerEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2131928602")) {
            ipChange.ipc$dispatch("-2131928602", new Object[]{this});
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-590701766")) {
            return ((Boolean) ipChange.ipc$dispatch("-590701766", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            this.mBottomFlag = false;
        }
        if (this.mBottomFlag) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934983893")) {
            ipChange.ipc$dispatch("1934983893", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int height = getLayout().getHeight();
        int totalPaddingTop = getTotalPaddingTop();
        this.mOffsetHeight = ((height + totalPaddingTop) + getTotalPaddingBottom()) - getHeight();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "290652556")) {
            ipChange.ipc$dispatch("290652556", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        if (i2 == this.mOffsetHeight || i2 == 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.mBottomFlag = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25661707")) {
            return ((Boolean) ipChange.ipc$dispatch("-25661707", new Object[]{this, motionEvent})).booleanValue();
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (!this.mBottomFlag) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return onTouchEvent;
    }

    public DMScrollViewInnerEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DMScrollViewInnerEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
