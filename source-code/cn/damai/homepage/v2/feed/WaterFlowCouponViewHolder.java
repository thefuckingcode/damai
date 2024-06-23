package cn.damai.homepage.v2.feed;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.h5container.h5url.VipUrlGetter;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.home.HomeData;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.gw0;
import tb.hf1;
import tb.jh0;
import tb.tj;
import tb.v50;
import tb.xf2;
import tb.zq;

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

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1762051949")) {
                ipChange.ipc$dispatch("-1762051949", new Object[]{this, view});
                return;
            }
            WaterFlowCouponViewHolder.this.vipClick(view);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "349238420")) {
                ipChange.ipc$dispatch("349238420", new Object[]{this, view});
                return;
            }
            WaterFlowCouponViewHolder.this.couponClick(view);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834438507")) {
                ipChange.ipc$dispatch("-1834438507", new Object[]{this, view});
                return;
            }
            WaterFlowCouponViewHolder.this.marktingClick(view);
        }
    }

    public WaterFlowCouponViewHolder(View view) {
        super(view);
        this.mContext = view.getContext();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void couponClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "992083039")) {
            ipChange.ipc$dispatch("992083039", new Object[]{this, view});
            return;
        }
        WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
        gw0.i().m(gw0.g(getComponentActions()), waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", getData().getIndex());
        if (!LoginManager.k().q()) {
            LoginManager.k().v(this.mContext);
            HomeData.isClickRedPacket = true;
        }
    }

    private void handleCouponView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "718387964")) {
            ipChange.ipc$dispatch("718387964", new Object[]{this, waterFlowRecommendItem});
            return;
        }
        if (xf2.j(waterFlowRecommendItem.title)) {
            this.mCouponTitle.setVisibility(4);
        } else {
            this.mCouponTitle.setVisibility(0);
            this.mCouponTitle.setText(waterFlowRecommendItem.title);
            this.mCouponTitle.setTextColor(Color.parseColor("#FFF8D5"));
        }
        if (xf2.j(waterFlowRecommendItem.subTitle)) {
            this.mCouponSubTitle.setVisibility(4);
        } else {
            this.mCouponSubTitle.setVisibility(0);
            this.mCouponSubTitle.setText(waterFlowRecommendItem.subTitle);
            this.mCouponSubTitle.setTextColor(Color.parseColor("#FFF8D5"));
        }
        if (xf2.j(waterFlowRecommendItem.giftsAmount)) {
            this.mCouponPrice.setVisibility(8);
            this.mCouponRMBSymbol.setVisibility(8);
        } else {
            this.mCouponPrice.setVisibility(0);
            this.mCouponRMBSymbol.setVisibility(0);
            this.mCouponPrice.setText(waterFlowRecommendItem.giftsAmount);
        }
        this.mMarktingPrice.setVisibility(4);
        this.mBackGroundImg.setImageResource(R$drawable.homepage_recommend_coupon_bg);
        this.mCouponGetbutton.setBackgroundResource(R$drawable.homepage_recommend_coupon_btn_bg);
        this.mCouponGetbutton.setTextColor(Color.parseColor("#ffffff"));
        this.mCouponGetbutton.setText("立即领取");
        this.itemView.setTag(waterFlowRecommendItem);
        this.itemView.setOnClickListener(new b());
    }

    private void handleMarktingView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846035025")) {
            ipChange.ipc$dispatch("1846035025", new Object[]{this, waterFlowRecommendItem});
            return;
        }
        this.mCouponTitle.setVisibility(4);
        this.mCouponSubTitle.setVisibility(4);
        this.mCouponPrice.setVisibility(4);
        this.mCouponRMBSymbol.setVisibility(4);
        this.mMarktingPrice.setVisibility(4);
        if (this.mBackGroundImg.getTag() instanceof zq) {
            ((zq) this.mBackGroundImg.getTag()).cancel();
        }
        this.mBackGroundImg.setImageDrawable(null);
        DMImageCreator f = cn.damai.common.image.a.b().f(waterFlowRecommendItem.pic, this.imageViewWidth, this.imageViewHeight);
        int i = R$drawable.uikit_default_image_bg_gradient;
        this.mBackGroundImg.setTag(f.i(i).c(i).g(this.mBackGroundImg));
        if (!xf2.j(waterFlowRecommendItem.buttonText)) {
            this.mCouponGetbutton.setText(waterFlowRecommendItem.buttonText);
            this.mCouponGetbutton.setTextColor(tj.a(waterFlowRecommendItem.textColor));
            if (xf2.j(waterFlowRecommendItem.buttonColor1) || xf2.j(waterFlowRecommendItem.buttonColor2)) {
                this.mCouponGetbutton.setBackgroundColor(tj.a(waterFlowRecommendItem.buttonColor1));
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(waterFlowRecommendItem.buttonColor1), Color.parseColor(waterFlowRecommendItem.buttonColor2)});
                gradientDrawable.setCornerRadius((float) v50.a(this.mContext, 15.0f));
                this.mCouponGetbutton.setBackground(gradientDrawable);
            }
            this.mCouponGetbutton.setVisibility(0);
        } else {
            this.mCouponGetbutton.setVisibility(4);
        }
        this.itemView.setTag(waterFlowRecommendItem);
        this.itemView.setOnClickListener(new c());
    }

    private void handleVipView(WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1477905565")) {
            ipChange.ipc$dispatch("-1477905565", new Object[]{this, waterFlowRecommendItem});
            return;
        }
        if (xf2.j(waterFlowRecommendItem.name)) {
            this.mCouponTitle.setVisibility(4);
        } else {
            this.mCouponTitle.setVisibility(0);
            this.mCouponTitle.setText(waterFlowRecommendItem.name);
        }
        if (xf2.j(waterFlowRecommendItem.desc)) {
            this.mCouponSubTitle.setVisibility(4);
        } else {
            this.mCouponSubTitle.setVisibility(0);
            this.mCouponSubTitle.setText(waterFlowRecommendItem.desc);
        }
        if (xf2.j(waterFlowRecommendItem.price)) {
            this.mMarktingPrice.setVisibility(4);
        } else {
            this.mMarktingPrice.setVisibility(0);
            TextView textView = this.mMarktingPrice;
            textView.setText("原价 ¥ " + waterFlowRecommendItem.price);
            this.mMarktingPrice.getPaint().setFlags(16);
        }
        if (xf2.j(waterFlowRecommendItem.priceLow)) {
            this.mCouponPrice.setVisibility(4);
        } else {
            this.mCouponPrice.setVisibility(0);
            this.mCouponPrice.setText(waterFlowRecommendItem.priceLow);
        }
        this.mBackGroundImg.setImageDrawable(null);
        this.mBackGroundImg.setImageResource(R$drawable.homepage_recommend_vip_bg);
        this.mCouponGetbutton.setBackgroundResource(R$drawable.homepage_recommend_vip_btn_bg);
        this.mCouponGetbutton.setText("立即开通");
        this.mCouponGetbutton.setTextColor(Color.parseColor("#11172D"));
        this.itemView.setTag(waterFlowRecommendItem);
        this.itemView.setOnClickListener(new a());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void marktingClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10847190")) {
            ipChange.ipc$dispatch("-10847190", new Object[]{this, view});
            return;
        }
        WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
        gw0.i().m(gw0.g(getComponentActions()), waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", getData().getIndex());
        DMNav.from(this.mContext).toUri(waterFlowRecommendItem.schema);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void vipClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "738939592")) {
            ipChange.ipc$dispatch("738939592", new Object[]{this, view});
            return;
        }
        WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
        gw0.i().m(gw0.g(getComponentActions()), waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", getData().getIndex());
        if (LoginManager.k().q()) {
            DMNav.from(this.mContext).toUri(VipUrlGetter.vipBuyUrl());
        } else {
            LoginManager.k().v(this.mContext);
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-918224700")) {
            ipChange.ipc$dispatch("-918224700", new Object[]{this, iItem});
            return;
        }
        int a2 = jh0.INSTANCE.a(this.itemView.getContext());
        this.imageViewWidth = a2;
        this.imageViewHeight = (int) ((((float) (a2 * 214)) * 1.0f) / 160.0f);
        ViewGroup.LayoutParams layoutParams = this.mCouponLayout.getLayoutParams();
        layoutParams.width = this.imageViewWidth;
        layoutParams.height = this.imageViewHeight;
        this.mCouponLayout.setLayoutParams(layoutParams);
        this.itemView.setLayoutParams(new FrameLayout.LayoutParams(-1, ((int) ((((float) (this.imageViewWidth * 214)) * 1.0f) / 160.0f)) + v50.a(this.context, 9.0f)));
        if (hf1.a.containsKey(((WaterFlowRecommendItem) getValue()).cardType) && (num = hf1.a.get(((WaterFlowRecommendItem) getValue()).cardType)) != null) {
            handleView(num.intValue(), (WaterFlowRecommendItem) getValue());
        }
    }

    public void handleView(int i, WaterFlowRecommendItem waterFlowRecommendItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1789311715")) {
            ipChange.ipc$dispatch("1789311715", new Object[]{this, Integer.valueOf(i), waterFlowRecommendItem});
        } else if (waterFlowRecommendItem != null) {
            if (i == 309) {
                handleVipView(waterFlowRecommendItem);
            } else if (i == 301) {
                handleCouponView(waterFlowRecommendItem);
            } else if (i == 302) {
                handleMarktingView(waterFlowRecommendItem);
            }
            gw0.i().k(gw0.g(getComponentActions()), this.itemView, waterFlowRecommendItem.projectId, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, "", waterFlowRecommendItem.index);
        }
    }
}
