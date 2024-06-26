package tb;

import android.view.View;
import android.widget.ScrollView;
import cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class o52 implements ViewDelegate {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Class[] SUPPORTED_VIEW_CLASSES = {ScrollView.class};

    @Override // cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate
    public boolean isReadyForPull(View view, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "243091548")) {
            return view.getScrollY() <= 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("243091548", new Object[]{this, view, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
    }
}
