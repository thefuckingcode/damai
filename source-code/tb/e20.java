package tb;

import android.content.Context;
import cn.damai.commonbusiness.tab.ITabView;
import cn.damai.commonbusiness.tab.TabItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class e20 extends ri2 {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // tb.ri2
    public ITabView a(Context context, TabItem tabItem) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-829342926")) {
            return super.a(context, tabItem);
        }
        return (ITabView) ipChange.ipc$dispatch("-829342926", new Object[]{this, context, tabItem});
    }
}
