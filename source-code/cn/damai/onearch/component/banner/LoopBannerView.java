package cn.damai.onearch.component.banner;

import android.view.View;
import cn.damai.commonbusiness.R$id;
import cn.damai.onearch.component.banner.LoopBannerContract;
import cn.damai.onearch.component.banner.widget.Banner;
import cn.damai.onearch.component.banner.widget.IndicatorView;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class LoopBannerView extends AbsView<GenericItem<ItemValue>, LoopBannerModel, LoopBannerPresenter> implements LoopBannerContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Banner banner;
    @NotNull
    private final IndicatorView indicator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoopBannerView(@NotNull View view) {
        super(view);
        k21.i(view, "view");
        View findViewById = view.findViewById(R$id.banner);
        k21.h(findViewById, "view.findViewById(R.id.banner)");
        this.banner = (Banner) findViewById;
        View findViewById2 = view.findViewById(R$id.indicator);
        k21.h(findViewById2, "view.findViewById(R.id.indicator)");
        this.indicator = (IndicatorView) findViewById2;
    }

    @NotNull
    public final Banner getBanner() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1536811064")) {
            return this.banner;
        }
        return (Banner) ipChange.ipc$dispatch("1536811064", new Object[]{this});
    }

    @NotNull
    public final IndicatorView getIndicator() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "609794917")) {
            return this.indicator;
        }
        return (IndicatorView) ipChange.ipc$dispatch("609794917", new Object[]{this});
    }

    @Override // cn.damai.onearch.component.banner.LoopBannerContract.View
    public void setAdapter(@Nullable VBaseAdapter<?, ?> vBaseAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1743907834")) {
            ipChange.ipc$dispatch("1743907834", new Object[]{this, vBaseAdapter});
            return;
        }
        this.indicator.setIndicatorStyle(0);
        this.indicator.setIndicatorColor(-1711276033);
        this.indicator.setIndicatorSelectorColor(-1);
        this.banner.setIndicator(this.indicator, false);
        this.banner.setAdapter(vBaseAdapter);
    }
}
