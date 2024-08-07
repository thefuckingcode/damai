package cn.damai.uikit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.lang.reflect.Field;

/* compiled from: Taobao */
public class CompatPtrFrameLayout extends PtrFrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    public CompatPtrFrameLayout(Context context) {
        this(context, null);
    }

    private void reflectSetTouchSlop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840031116")) {
            ipChange.ipc$dispatch("-840031116", new Object[]{this});
            return;
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mPagingTouchSlop");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(ViewConfiguration.get(getContext()).getScaledTouchSlop()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CompatPtrFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CompatPtrFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        reflectSetTouchSlop();
    }
}
