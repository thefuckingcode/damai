package cn.damai.tetris.component.ip;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.ip.IpBottomBarContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IpBottomBarView extends AbsView<IpBottomBarContract.Presenter> implements IpBottomBarContract.View<IpBottomBarContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    TextView buy;
    TextView desc;
    private Context mContext;

    public IpBottomBarView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.desc = (TextView) view.findViewById(R$id.ip_bottombar_text);
        this.buy = (TextView) view.findViewById(R$id.ip_bottombar_buy);
    }

    @Override // cn.damai.tetris.component.ip.IpBottomBarContract.View
    public TextView getBuyView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-767311329")) {
            return this.buy;
        }
        return (TextView) ipChange.ipc$dispatch("-767311329", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.ip.IpBottomBarContract.View
    public TextView getDescView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1951338514")) {
            return this.desc;
        }
        return (TextView) ipChange.ipc$dispatch("1951338514", new Object[]{this});
    }
}
