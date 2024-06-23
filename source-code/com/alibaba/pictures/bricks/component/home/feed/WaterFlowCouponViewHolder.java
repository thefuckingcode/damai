package com.alibaba.pictures.bricks.component.home.feed;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.WaterFlowRecommendItem;
import com.alibaba.pictures.bricks.util.a;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.ImageTicket;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.sj;
import tb.u50;
import tb.wf2;

/* compiled from: Taobao */
public class WaterFlowCouponViewHolder extends BaseViewHolder<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int imageViewHeight;
    private int imageViewWidth;
    private ImageView mBackGroundImg = ((ImageView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_image));
    private Context mContext;
    private TextView mCouponGetbutton = ((TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_get_btn));
    private RelativeLayout mCouponLayout = ((RelativeLayout) this.itemView.findViewById(R$id.homepage_waterflow_coupon_layout));
    private TextView mCouponPrice = ((TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_money));
    private TextView mCouponRMBSymbol = ((TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_rmb_symbol));
    private TextView mCouponSubTitle = ((TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_subtitle));
    private TextView mCouponTitle = ((TextView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_title));
    private String mMainTitle;
    private TextView mMarktingPrice = ((TextView) this.itemView.findViewById(R$id.homepage_waterflow_markting_price));

    public WaterFlowCouponViewHolder(View view) {
        super(view);
        this.mContext = view.getContext();
    }

    private void handleMarktingView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582112706")) {
            ipChange.ipc$dispatch("582112706", new Object[]{this, waterFlowRecommendItem});
            return;
        }
        this.mCouponTitle.setVisibility(4);
        this.mCouponSubTitle.setVisibility(4);
        this.mCouponPrice.setVisibility(4);
        this.mCouponRMBSymbol.setVisibility(4);
        this.mMarktingPrice.setVisibility(4);
        if (this.mBackGroundImg.getTag() instanceof ImageTicket) {
            ((ImageTicket) this.mBackGroundImg.getTag()).cancel();
        }
        this.mBackGroundImg.setImageDrawable(null);
        String c = a.c(waterFlowRecommendItem.pic, this.imageViewWidth, this.imageViewHeight);
        ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
        ImageView imageView = this.mBackGroundImg;
        int i = R$drawable.bricks_uikit_default_image_bg_gradient;
        this.mBackGroundImg.setTag(proxy.loadinto(c, imageView, i, i));
        wf2 wf2 = wf2.INSTANCE;
        if (!wf2.c(waterFlowRecommendItem.buttonText)) {
            this.mCouponGetbutton.setText(waterFlowRecommendItem.buttonText);
            this.mCouponGetbutton.setTextColor(sj.a(waterFlowRecommendItem.textColor));
            if (wf2.c(waterFlowRecommendItem.buttonColor1) || wf2.c(waterFlowRecommendItem.buttonColor2)) {
                this.mCouponGetbutton.setBackgroundColor(sj.a(waterFlowRecommendItem.buttonColor1));
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{sj.a(waterFlowRecommendItem.buttonColor1), sj.a(waterFlowRecommendItem.buttonColor2)});
                gradientDrawable.setCornerRadius((float) u50.INSTANCE.b(this.mContext, 15));
                this.mCouponGetbutton.setBackground(gradientDrawable);
            }
            this.mCouponGetbutton.setVisibility(0);
        } else {
            this.mCouponGetbutton.setVisibility(4);
        }
        this.itemView.setTag(waterFlowRecommendItem);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1853067817")) {
            ipChange.ipc$dispatch("-1853067817", new Object[]{this, iItem});
            return;
        }
        u50 u50 = u50.INSTANCE;
        int e = u50.e(this.itemView.getContext());
        this.imageViewWidth = e;
        this.imageViewHeight = (int) ((((float) (e * 214)) * 1.0f) / 160.0f);
        ViewGroup.LayoutParams layoutParams = this.mCouponLayout.getLayoutParams();
        layoutParams.width = this.imageViewWidth;
        layoutParams.height = this.imageViewHeight;
        this.mCouponLayout.setLayoutParams(layoutParams);
        this.itemView.setLayoutParams(new FrameLayout.LayoutParams(-1, ((int) ((((float) (this.imageViewWidth * 214)) * 1.0f) / 160.0f)) + u50.b(this.context, 9)));
        handleView((WaterFlowRecommendItem) getValue());
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1398658713")) {
            ipChange.ipc$dispatch("-1398658713", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem != null) {
            handleMarktingView(waterFlowRecommendItem);
        }
    }
}
