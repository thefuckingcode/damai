package cn.damai.tetris.component.star;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.component.star.OfficalMallContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OfficalMallView extends AbsView implements OfficalMallContract.View {
    private static transient /* synthetic */ IpChange $ipChange;

    public OfficalMallView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.component.star.OfficalMallContract.View
    public ViewGroup getMallView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1666677044")) {
            return (ViewGroup) getView();
        }
        return (ViewGroup) ipChange.ipc$dispatch("-1666677044", new Object[]{this});
    }
}
