package cn.damai.tetris.gaiax;

import android.view.View;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class GaiaXDefaultView extends AbsView<GaiaXDefaultPresenter> implements GaiaXView<GaiaXDefaultPresenter> {
    private static transient /* synthetic */ IpChange $ipChange;

    public GaiaXDefaultView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.gaiax.GaiaXView
    public View getContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-7064720")) {
            return getRootView();
        }
        return (View) ipChange.ipc$dispatch("-7064720", new Object[]{this});
    }

    @Override // cn.damai.tetris.gaiax.GaiaXView
    public View getGaiaXContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1622168894")) {
            return getRootView();
        }
        return (View) ipChange.ipc$dispatch("-1622168894", new Object[]{this});
    }
}
