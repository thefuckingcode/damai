package cn.damai.commonbusiness.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewFlipper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class StopAbleViewFlipper extends ViewFlipper {
    private static transient /* synthetic */ IpChange $ipChange;
    private ChangeListener changeListener;

    /* compiled from: Taobao */
    public interface ChangeListener {
        void onViewEnd();
    }

    public StopAbleViewFlipper(Context context) {
        super(context);
    }

    public void setChangeListener(ChangeListener changeListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-899407706")) {
            ipChange.ipc$dispatch("-899407706", new Object[]{this, changeListener2});
            return;
        }
        this.changeListener = changeListener2;
    }

    public void showNext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804237453")) {
            ipChange.ipc$dispatch("-1804237453", new Object[]{this});
            return;
        }
        int displayedChild = getDisplayedChild() + 1;
        if (displayedChild >= getChildCount()) {
            ChangeListener changeListener2 = this.changeListener;
            if (changeListener2 != null) {
                changeListener2.onViewEnd();
                return;
            }
            return;
        }
        setDisplayedChild(displayedChild);
    }

    public StopAbleViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
