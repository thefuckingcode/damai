package cn.damai.tetris.component.star.group;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.component.star.group.StarGroupRelateGridContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class StarGroupRelateGridView extends AbsView implements StarGroupRelateGridContract.View {
    private static transient /* synthetic */ IpChange $ipChange;

    public StarGroupRelateGridView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.component.star.group.StarGroupRelateGridContract.View
    public ViewGroup getGridView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "456120946")) {
            return (ViewGroup) getView();
        }
        return (ViewGroup) ipChange.ipc$dispatch("456120946", new Object[]{this});
    }
}
