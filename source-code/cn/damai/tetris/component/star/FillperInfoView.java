package cn.damai.tetris.component.star;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.component.star.FillperInfoContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FillperInfoView extends AbsView implements FillperInfoContract.View {
    private static transient /* synthetic */ IpChange $ipChange;

    public FillperInfoView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.component.star.FillperInfoContract.View
    public ViewGroup getFillperView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-193067508")) {
            return (ViewGroup) getView();
        }
        return (ViewGroup) ipChange.ipc$dispatch("-193067508", new Object[]{this});
    }
}
