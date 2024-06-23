package com.alient.onearch.adapter.component.banner.loop;

import android.view.View;
import com.alient.onearch.adapter.R;
import com.alient.onearch.adapter.component.banner.loop.LoopBannerContract;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.onearch.adapter.widget.banner.Banner;
import com.alient.onearch.adapter.widget.banner.IndicatorView;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hf1;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\f\u001a\u00020\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0010\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\rH\u0016R\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerModel;", "Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerPresenter;", "Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerContract$View;", "", "", "", "params", "Ltb/ur2;", "initBannerSetting", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "innerAdapter", "setAdapter", "Lcom/alient/onearch/adapter/widget/banner/Banner;", hf1.MODULE_BANNER, "Lcom/alient/onearch/adapter/widget/banner/Banner;", "getBanner", "()Lcom/alient/onearch/adapter/widget/banner/Banner;", "Lcom/alient/onearch/adapter/widget/banner/IndicatorView;", WXBasicComponentType.INDICATOR, "Lcom/alient/onearch/adapter/widget/banner/IndicatorView;", "getIndicator", "()Lcom/alient/onearch/adapter/widget/banner/IndicatorView;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class LoopBannerView extends AbsView<GenericItem<ItemValue>, LoopBannerModel, LoopBannerPresenter> implements LoopBannerContract.View {
    @NotNull
    private final Banner banner;
    @Nullable
    private final IndicatorView indicator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoopBannerView(@NotNull View view) {
        super(view);
        k21.i(view, "view");
        View findViewById = view.findViewById(R.id.banner);
        k21.h(findViewById, "view.findViewById(R.id.banner)");
        this.banner = (Banner) findViewById;
        this.indicator = (IndicatorView) view.findViewById(R.id.indicator);
    }

    @NotNull
    public final Banner getBanner() {
        return this.banner;
    }

    @Nullable
    public final IndicatorView getIndicator() {
        return this.indicator;
    }

    @Override // com.alient.onearch.adapter.component.banner.loop.LoopBannerContract.View
    public void initBannerSetting(@Nullable Map<String, ? extends Object> map) {
        if (map != null) {
            if (k21.d(map.get(OneArchConstants.LayoutKey.SHOW_INDICATOR), "false")) {
                IndicatorView indicatorView = this.indicator;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.indicator;
                if (indicatorView2 != null) {
                    indicatorView2.setVisibility(0);
                }
            }
            Object obj = map.get("indicatorType");
            if (k21.d(obj, "0")) {
                IndicatorView indicatorView3 = this.indicator;
                if (indicatorView3 != null) {
                    indicatorView3.setIndicatorStyle(0);
                }
            } else if (k21.d(obj, "1")) {
                IndicatorView indicatorView4 = this.indicator;
                if (indicatorView4 != null) {
                    indicatorView4.setIndicatorStyle(1);
                }
            } else if (k21.d(obj, "2")) {
                IndicatorView indicatorView5 = this.indicator;
                if (indicatorView5 != null) {
                    indicatorView5.setIndicatorStyle(2);
                }
            } else if (k21.d(obj, "3")) {
                IndicatorView indicatorView6 = this.indicator;
                if (indicatorView6 != null) {
                    indicatorView6.setIndicatorStyle(3);
                }
            } else if (k21.d(obj, "4")) {
                IndicatorView indicatorView7 = this.indicator;
                if (indicatorView7 != null) {
                    indicatorView7.setIndicatorStyle(4);
                }
            } else if (k21.d(obj, "5")) {
                IndicatorView indicatorView8 = this.indicator;
                if (indicatorView8 != null) {
                    indicatorView8.setIndicatorStyle(5);
                }
            } else {
                IndicatorView indicatorView9 = this.indicator;
                if (indicatorView9 != null) {
                    indicatorView9.setIndicatorStyle(0);
                }
            }
        }
    }

    @Override // com.alient.onearch.adapter.component.banner.loop.LoopBannerContract.View
    public void setAdapter(@Nullable VBaseAdapter<?, ?> vBaseAdapter) {
        IndicatorView indicatorView = this.indicator;
        if (indicatorView != null) {
            indicatorView.setIndicatorColor((int) 2583691263L);
        }
        IndicatorView indicatorView2 = this.indicator;
        if (indicatorView2 != null) {
            indicatorView2.setIndicatorSelectorColor((int) 4294967295L);
        }
        this.banner.setIndicator(this.indicator, false);
        this.banner.setAdapter(vBaseAdapter);
    }
}
