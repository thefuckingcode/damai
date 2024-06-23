package cn.damai.onearch.component.banner.venue;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.onearch.component.banner.venue.VenueBannerContract;
import cn.damai.tetris.component.home.widget.banner.sub.RoundRadiusImageView;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class VenueBannerView extends AbsView<GenericItem<ItemValue>, VenueBannerModel, VenueBannerPresent> implements VenueBannerContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final RoundRadiusImageView image;
    @NotNull
    private final View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VenueBannerView(@NotNull View view2) {
        super(view2);
        k21.i(view2, "view");
        this.view = view2;
        view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View findViewById = view2.findViewById(R$id.image);
        k21.h(findViewById, "view.findViewById(R.id.image)");
        this.image = (RoundRadiusImageView) findViewById;
    }

    @NotNull
    public final View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-552572969")) {
            return this.view;
        }
        return (View) ipChange.ipc$dispatch("-552572969", new Object[]{this});
    }

    @Override // cn.damai.onearch.component.banner.venue.VenueBannerContract.View
    public void renderBanner(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546605534")) {
            ipChange.ipc$dispatch("-1546605534", new Object[]{this, str});
            return;
        }
        k21.i(str, "picUrl");
        a.b().c(str).g(this.image);
    }
}
