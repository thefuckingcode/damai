package com.alibaba.pictures.bricks.component.home.feed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.taobao.windvane.extra.uc.UCNetworkDelegate;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.WaterFlowRecommendItem;
import com.alibaba.pictures.bricks.util.DMRGBUtil;
import com.alibaba.pictures.bricks.util.blur.ImageBlurHelper;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.ct0;
import tb.i01;
import tb.qy2;
import tb.ry2;
import tb.u50;

/* compiled from: Taobao */
public class WaterFlowBrandViewHolder extends BaseViewHolder<WaterFlowRecommendItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int imageViewHeight;
    private int imageViewWidth;
    private Context mContext;
    private ImageView mVenueBgImage = ((ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_image));
    private ImageView mVenueBgShade = ((ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_shade));
    private TextView mVenueDesc;
    private View mVenueDescBottomDashLine;
    private View mVenueDescTopDashLine;
    private ImageView mVenueHeaderIcon = ((ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_header_icon));
    private ImageView mVenueHeaderVIcon = ((ImageView) this.itemView.findViewById(R$id.homepage_waterflow_venues_header_v_icon));
    private TextView mVenueName = ((TextView) this.itemView.findViewById(R$id.homepage_waterflow_venues_name));

    /* compiled from: Taobao */
    public class a implements DMRGBUtil.OnFetchColorListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.pictures.bricks.util.DMRGBUtil.OnFetchColorListener
        public void onFetchColor(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-679221185")) {
                ipChange.ipc$dispatch("-679221185", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ct0.a(WaterFlowBrandViewHolder.this.mVenueBgShade, GradientDrawable.Orientation.LEFT_RIGHT, (float) u50.INSTANCE.b(WaterFlowBrandViewHolder.this.mContext, 6), i);
        }
    }

    /* compiled from: Taobao */
    public class b implements ImageBlurHelper.BlurImageCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.alibaba.pictures.bricks.util.blur.ImageBlurHelper.BlurImageCallback
        public void onBlurResult(String str, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "165497050")) {
                ipChange.ipc$dispatch("165497050", new Object[]{this, str, bitmap});
                return;
            }
            WaterFlowBrandViewHolder.this.mVenueBgImage.setImageBitmap(bitmap);
        }
    }

    public WaterFlowBrandViewHolder(View view) {
        super(view);
        this.mContext = view.getContext();
        View findViewById = this.itemView.findViewById(R$id.homepage_waterflow_venues_desc_top_dash);
        this.mVenueDescTopDashLine = findViewById;
        findViewById.setLayerType(1, null);
        this.mVenueDesc = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_venues_desc);
        View findViewById2 = this.itemView.findViewById(R$id.homepage_waterflow_venues_desc_bottom_dash);
        this.mVenueDescBottomDashLine = findViewById2;
        findViewById2.setLayerType(1, null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$handleView$0(WaterFlowRecommendItem waterFlowRecommendItem, SuccessEvent successEvent) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657884129")) {
            ipChange.ipc$dispatch("-1657884129", new Object[]{this, waterFlowRecommendItem, successEvent});
        } else if (successEvent == null || (bitmap = successEvent.bitmap) == null) {
            this.mVenueBgImage.setImageResource(R$drawable.bricks_homepage_waterflow_venues_default_bg);
            this.mVenueBgShade.setImageResource(R$drawable.bricks_homepage_waterflow_venues_default_shade);
        } else {
            DMRGBUtil.f(0.7f, bitmap, waterFlowRecommendItem.backgroundPic, new a());
            i01.b(this.mContext, waterFlowRecommendItem.backgroundPic, successEvent.bitmap, new b());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$handleView$1(FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431432625")) {
            ipChange.ipc$dispatch("1431432625", new Object[]{this, failEvent});
            return;
        }
        this.mVenueBgImage.setImageResource(R$drawable.bricks_homepage_waterflow_venues_default_bg);
        this.mVenueBgShade.setImageResource(R$drawable.bricks_homepage_waterflow_venues_default_shade);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "603885978")) {
            ipChange.ipc$dispatch("603885978", new Object[]{this, iItem});
            return;
        }
        u50 u50 = u50.INSTANCE;
        int e = u50.e(this.itemView.getContext());
        this.imageViewWidth = e;
        int i = (int) ((((float) (e * UCNetworkDelegate.CHANGE_WEBVIEW_URL)) * 1.0f) / 168.0f);
        this.imageViewHeight = i;
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, i + u50.b(this.mContext, 12)));
        handleView((WaterFlowRecommendItem) getValue());
    }

    public void handleView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468032618")) {
            ipChange.ipc$dispatch("468032618", new Object[]{this, waterFlowRecommendItem});
        } else if (waterFlowRecommendItem != null) {
            ImageLoaderProviderProxy.getProxy().load(com.alibaba.pictures.bricks.util.a.c(waterFlowRecommendItem.backgroundPic, this.imageViewWidth, this.imageViewHeight), new ry2(this, waterFlowRecommendItem), new qy2(this));
            String str = waterFlowRecommendItem.pic;
            u50 u50 = u50.INSTANCE;
            String c = com.alibaba.pictures.bricks.util.a.c(str, u50.b(this.mContext, 50), u50.b(this.mContext, 50));
            ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
            ImageView imageView = this.mVenueHeaderIcon;
            int i = R$drawable.bricks_uikit_user_default_icon_trans_white;
            proxy.loadinto(c, imageView, i, i);
            this.mVenueName.setText(waterFlowRecommendItem.title);
            this.mVenueDesc.setText(waterFlowRecommendItem.subTitle);
            if (TextUtils.isEmpty(waterFlowRecommendItem.subTitle)) {
                this.mVenueDescTopDashLine.setVisibility(8);
                this.mVenueDescBottomDashLine.setVisibility(8);
            } else {
                this.mVenueDescTopDashLine.setVisibility(0);
                this.mVenueDescBottomDashLine.setVisibility(0);
            }
            this.itemView.setTag(waterFlowRecommendItem);
        }
    }
}
