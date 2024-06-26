package com.alibaba.pictures.bricks.component.script;

import android.view.View;
import android.widget.TextView;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.SearchScriptCouponBean;
import com.alibaba.pictures.bricks.component.script.ScriptCouponContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alibaba.pictures.bricks.view.HighlightTextView;
import com.alibaba.pictures.bricks.view.RoundRadiusImageView;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.u42;

/* compiled from: Taobao */
public final class ScriptCouponView extends AbsView<GenericItem<ItemValue>, ScriptCouponModel, ScriptCouponPresent> implements ScriptCouponContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HighlightTextView couponDescTv;
    private final HighlightTextView couponNameTv;
    private final View couponPriceTagView;
    private final TextView couponPriceTv;
    private final View couponPriceView;
    @NotNull
    private View divline;
    @NotNull
    private final View itemView;
    private final RoundRadiusImageView posterImg;
    @NotNull
    private final DMCategroyTagView posterTag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScriptCouponView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        this.posterImg = (RoundRadiusImageView) view.findViewById(R$id.script_coupon_poster);
        View findViewById = view.findViewById(R$id.script_tag);
        k21.h(findViewById, "itemView.findViewById(R.id.script_tag)");
        this.posterTag = (DMCategroyTagView) findViewById;
        this.couponNameTv = (HighlightTextView) view.findViewById(R$id.script_coupon_name);
        this.couponDescTv = (HighlightTextView) view.findViewById(R$id.script_coupon_desc);
        this.couponPriceView = view.findViewById(R$id.script_coupon_price);
        this.couponPriceTv = (TextView) view.findViewById(R$id.tv_script_coupon_price);
        this.couponPriceTagView = view.findViewById(R$id.script_price_tag);
        View findViewById2 = view.findViewById(R$id.ll_search_bottom_div);
        k21.h(findViewById2, "itemView.findViewById(R.id.ll_search_bottom_div)");
        this.divline = findViewById2;
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-0  reason: not valid java name */
    public static final void m137bindData$lambda0(ScriptCouponView scriptCouponView, SearchScriptCouponBean searchScriptCouponBean, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348128848")) {
            ipChange.ipc$dispatch("-1348128848", new Object[]{scriptCouponView, searchScriptCouponBean, view});
            return;
        }
        k21.i(scriptCouponView, "this$0");
        ScriptCouponPresent scriptCouponPresent = (ScriptCouponPresent) scriptCouponView.getPresenter();
        if (scriptCouponPresent != null) {
            scriptCouponPresent.onItemClick(searchScriptCouponBean, 0);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.script.ScriptCouponContract.View
    public void bindData(@Nullable SearchScriptCouponBean searchScriptCouponBean) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "784789251")) {
            ipChange.ipc$dispatch("784789251", new Object[]{this, searchScriptCouponBean});
        } else if (searchScriptCouponBean != null) {
            ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
            String projectPic = searchScriptCouponBean.getProjectPic();
            RoundRadiusImageView roundRadiusImageView = this.posterImg;
            int i = R$drawable.bricks_uikit_default_image_bg_gradient;
            proxy.loadinto(projectPic, roundRadiusImageView, i, i);
            this.posterTag.setTagName(ErrControlViewInfo.TYPE_SCRIPT);
            this.posterTag.setTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_DEFAULT);
            this.couponNameTv.setText(searchScriptCouponBean.getProjectName(), searchScriptCouponBean.getHighlightWord());
            String buildDesc = searchScriptCouponBean.buildDesc();
            int i2 = 8;
            if (buildDesc == null || buildDesc.length() == 0) {
                this.couponDescTv.setVisibility(8);
            } else {
                this.couponDescTv.setVisibility(0);
                this.couponDescTv.setText(buildDesc, searchScriptCouponBean.getHighlightWord());
            }
            String priceLow = searchScriptCouponBean.getPriceLow();
            if (!(priceLow == null || priceLow.length() == 0)) {
                z = false;
            }
            if (z) {
                this.couponPriceView.setVisibility(8);
            } else {
                this.couponPriceView.setVisibility(0);
                String priceLow2 = searchScriptCouponBean.getPriceLow();
                boolean z2 = priceLow2 != null ? StringsKt__StringsKt.Q(priceLow2, "待定", false, 2, null) : false;
                this.couponPriceTv.setText(z2 ? "价格待定" : searchScriptCouponBean.getPriceLow());
                View view = this.couponPriceTagView;
                if (!z2) {
                    i2 = 0;
                }
                view.setVisibility(i2);
            }
            this.itemView.setOnClickListener(new u42(this, searchScriptCouponBean));
            ScriptCouponPresent scriptCouponPresent = (ScriptCouponPresent) getPresenter();
            if (scriptCouponPresent != null) {
                scriptCouponPresent.onItemExpose(this.itemView, searchScriptCouponBean, 0);
            }
        }
    }

    @NotNull
    public final View getDivline() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1278507628")) {
            return this.divline;
        }
        return (View) ipChange.ipc$dispatch("-1278507628", new Object[]{this});
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2091490141")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("2091490141", new Object[]{this});
    }

    public final void setDivline(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1437436876")) {
            ipChange.ipc$dispatch("-1437436876", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.divline = view;
    }
}
