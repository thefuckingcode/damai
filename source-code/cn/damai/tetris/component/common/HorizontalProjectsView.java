package cn.damai.tetris.component.common;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.component.common.HorizontalProjectsContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class HorizontalProjectsView extends AbsView implements HorizontalProjectsContract.View {
    private static transient /* synthetic */ IpChange $ipChange;

    public HorizontalProjectsView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.component.common.HorizontalProjectsContract.View
    public ViewGroup getProjectsView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1713347351")) {
            return (ViewGroup) getView();
        }
        return (ViewGroup) ipChange.ipc$dispatch("1713347351", new Object[]{this});
    }
}
