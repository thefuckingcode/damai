package com.alibaba.pictures.bricks.component.script;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.bean.TuanItemBean;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.util.a;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alibaba.pictures.bricks.view.DMRatingBar;
import com.alibaba.pictures.bricks.view.HighlightTextView;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jk1;
import tb.k21;
import tb.k52;
import tb.u50;

/* compiled from: Taobao */
public final class ScriptShopView extends AbsView<GenericItem<ItemValue>, ScriptShopModel, ScriptShopPresenter> implements ScriptShopContract$View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private View divline;
    @NotNull
    private View itemView;
    @NotNull
    private TextView mAddressTv;
    @NotNull
    private ImageView mAuthImg;
    @NotNull
    private TextView mDistanceTv;
    @NotNull
    private View mDivider;
    @NotNull
    private ImageView mPicImg;
    @NotNull
    private DMRatingBar mRatingBar;
    @NotNull
    private LinearLayout mScoreLl;
    @NotNull
    private TextView mScoreTv;
    @NotNull
    private DMCategroyTagView mTagView;
    @NotNull
    private HighlightTextView mTitleTv;
    @NotNull
    private TextView mTuanCountTv;
    @NotNull
    private TextView mTuanDescTv;
    @NotNull
    private View mTuanLayout;
    @NotNull
    private View mTuanPriceTagTv;
    @NotNull
    private TextView mTuanPriceTv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScriptShopView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        View findViewById = view.findViewById(R$id.id_script_shop_pic);
        k21.h(findViewById, "itemView.findViewById(R.id.id_script_shop_pic)");
        this.mPicImg = (ImageView) findViewById;
        View findViewById2 = this.itemView.findViewById(R$id.id_script_shop_title_tv);
        k21.h(findViewById2, "itemView.findViewById(R.….id_script_shop_title_tv)");
        this.mTitleTv = (HighlightTextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R$id.script_shop_score);
        k21.h(findViewById3, "itemView.findViewById(R.id.script_shop_score)");
        this.mScoreLl = (LinearLayout) findViewById3;
        View findViewById4 = this.itemView.findViewById(R$id.id_script_shop_score_view);
        k21.h(findViewById4, "itemView.findViewById(R.…d_script_shop_score_view)");
        this.mRatingBar = (DMRatingBar) findViewById4;
        View findViewById5 = this.itemView.findViewById(R$id.id_script_shop_score_tv);
        k21.h(findViewById5, "itemView.findViewById(R.….id_script_shop_score_tv)");
        this.mScoreTv = (TextView) findViewById5;
        View findViewById6 = this.itemView.findViewById(R$id.id_script_shop_line);
        k21.h(findViewById6, "itemView.findViewById(R.id.id_script_shop_line)");
        this.mDivider = findViewById6;
        View findViewById7 = this.itemView.findViewById(R$id.id_script_shop_address_tv);
        k21.h(findViewById7, "itemView.findViewById(R.…d_script_shop_address_tv)");
        this.mAddressTv = (TextView) findViewById7;
        View findViewById8 = this.itemView.findViewById(R$id.id_script_shop_distance_tv);
        k21.h(findViewById8, "itemView.findViewById(R.…_script_shop_distance_tv)");
        this.mDistanceTv = (TextView) findViewById8;
        View findViewById9 = this.itemView.findViewById(R$id.id_script_shop_tuan_auth_icon);
        k21.h(findViewById9, "itemView.findViewById(R.…ript_shop_tuan_auth_icon)");
        this.mAuthImg = (ImageView) findViewById9;
        View findViewById10 = this.itemView.findViewById(R$id.id_script_shop_tuan_layout);
        k21.h(findViewById10, "itemView.findViewById(R.…_script_shop_tuan_layout)");
        this.mTuanLayout = findViewById10;
        View findViewById11 = this.itemView.findViewById(R$id.id_script_shop_tuan_price_tag);
        k21.h(findViewById11, "itemView.findViewById(R.…ript_shop_tuan_price_tag)");
        this.mTuanPriceTagTv = findViewById11;
        View findViewById12 = this.itemView.findViewById(R$id.id_script_shop_tuan_price_tv);
        k21.h(findViewById12, "itemView.findViewById(R.…cript_shop_tuan_price_tv)");
        this.mTuanPriceTv = (TextView) findViewById12;
        View findViewById13 = this.itemView.findViewById(R$id.id_script_shop_tuan_desc_tv);
        k21.h(findViewById13, "itemView.findViewById(R.…script_shop_tuan_desc_tv)");
        this.mTuanDescTv = (TextView) findViewById13;
        View findViewById14 = this.itemView.findViewById(R$id.id_script_shop_tuan_count_tv);
        k21.h(findViewById14, "itemView.findViewById(R.…cript_shop_tuan_count_tv)");
        this.mTuanCountTv = (TextView) findViewById14;
        View findViewById15 = this.itemView.findViewById(R$id.id_script_shop_tag);
        k21.h(findViewById15, "itemView.findViewById(R.id.id_script_shop_tag)");
        this.mTagView = (DMCategroyTagView) findViewById15;
        View findViewById16 = this.itemView.findViewById(R$id.ll_search_bottom_div);
        k21.h(findViewById16, "itemView.findViewById(R.id.ll_search_bottom_div)");
        this.divline = findViewById16;
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-3$lambda-2  reason: not valid java name */
    public static final void m141bindData$lambda3$lambda2(ScriptShopPresenter scriptShopPresenter, ShopInfoBean shopInfoBean, int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1428319424")) {
            ipChange.ipc$dispatch("1428319424", new Object[]{scriptShopPresenter, shopInfoBean, Integer.valueOf(i), view});
            return;
        }
        k21.i(scriptShopPresenter, "$listener");
        k21.i(shopInfoBean, "$this_apply");
        scriptShopPresenter.onItemClick(shopInfoBean, i);
    }

    @Override // com.alibaba.pictures.bricks.component.script.ScriptShopContract$View
    public void bindData(@Nullable ShopInfoBean shopInfoBean, int i, @NotNull ScriptShopPresenter scriptShopPresenter) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1510626415")) {
            ipChange.ipc$dispatch("-1510626415", new Object[]{this, shopInfoBean, Integer.valueOf(i), scriptShopPresenter});
            return;
        }
        k21.i(scriptShopPresenter, "listener");
        if (shopInfoBean != null) {
            this.mTagView.setTagName(ErrControlViewInfo.TYPE_SCRIPT);
            this.mTagView.setTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_DEFAULT);
            this.mTitleTv.setText(shopInfoBean.getName(), shopInfoBean.getHighlightWord());
            double c = jk1.c(shopInfoBean.getStoreScore(), 0.0d);
            int i2 = 8;
            if (c > 0.0d) {
                this.mScoreLl.setVisibility(0);
                this.mScoreTv.setVisibility(0);
                this.mRatingBar.setStarMark(((float) new BigDecimal(c).intValue()) / 2.0f);
                this.mScoreTv.setText(shopInfoBean.getStoreScore());
            } else {
                this.mScoreLl.setVisibility(8);
                this.mScoreTv.setVisibility(8);
            }
            this.mAddressTv.setText(shopInfoBean.getAddress());
            String distance = shopInfoBean.getDistance();
            if (distance == null || distance.length() == 0) {
                this.mDistanceTv.setVisibility(8);
            } else {
                this.mDistanceTv.setVisibility(0);
                this.mDistanceTv.setText("距离" + shopInfoBean.getDistance());
            }
            this.mDivider.setVisibility((this.mDistanceTv.getVisibility() != 0 || TextUtils.isEmpty(shopInfoBean.getAddress())) ? 8 : 0);
            u50 u50 = u50.INSTANCE;
            Context context = this.itemView.getContext();
            k21.h(context, "itemView.context");
            int a = u50.a(context, 63.0f);
            String c2 = a.c(shopInfoBean.getUrl(), a, a);
            k21.h(c2, "getImageUrl(url, picSize,picSize)");
            ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
            ImageView imageView = this.mPicImg;
            int i3 = R$drawable.bricks_uikit_default_image_bg_gradient;
            proxy.loadinto(c2, imageView, i3, i3);
            if (shopInfoBean.getHasCertificationInfo()) {
                this.mAuthImg.setVisibility(0);
                String certificationIcon = shopInfoBean.getCertificationIcon();
                if (certificationIcon != null) {
                    ImageLoaderProvider proxy2 = ImageLoaderProviderProxy.getProxy();
                    ImageView imageView2 = this.mAuthImg;
                    int i4 = R$drawable.bricks_icon_shope_rp;
                    proxy2.loadinto(certificationIcon, imageView2, i4, i4);
                }
            } else {
                this.mAuthImg.setVisibility(8);
            }
            ArrayList<TuanItemBean> scriptItemList = shopInfoBean.getScriptItemList();
            if (scriptItemList == null || scriptItemList.isEmpty()) {
                this.mTuanLayout.setVisibility(8);
            } else {
                this.mTuanLayout.setVisibility(0);
                ArrayList<TuanItemBean> scriptItemList2 = shopInfoBean.getScriptItemList();
                k21.f(scriptItemList2);
                TuanItemBean tuanItemBean = scriptItemList2.get(0);
                this.mTuanPriceTv.setText(tuanItemBean.getPriceLow());
                this.mTuanDescTv.setText(tuanItemBean.getName());
                try {
                    View view = this.mTuanPriceTagTv;
                    if (tuanItemBean.getPriceLow() != null) {
                        String priceLow = tuanItemBean.getPriceLow();
                        k21.f(priceLow);
                        if (!(StringsKt__StringsKt.Q(priceLow, "待定", false, 2, null))) {
                            i2 = 0;
                        }
                    }
                    view.setVisibility(i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String scriptItemSize = shopInfoBean.getScriptItemSize();
                if (scriptItemSize == null || scriptItemSize.length() == 0) {
                    this.mTuanCountTv.setText((CharSequence) null);
                } else {
                    if (jk1.e(shopInfoBean.getScriptItemSize(), 0) > 1) {
                        str = (char) 20849 + shopInfoBean.getScriptItemSize() + "个团购";
                    } else {
                        str = "";
                    }
                    this.mTuanCountTv.setText(str);
                }
            }
            this.itemView.setOnClickListener(new k52(scriptShopPresenter, shopInfoBean, i));
            scriptShopPresenter.onItemExpose(this.itemView, shopInfoBean, i);
        }
    }

    @NotNull
    public final View getDivline() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2033437604")) {
            return this.divline;
        }
        return (View) ipChange.ipc$dispatch("2033437604", new Object[]{this});
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1682577229")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("1682577229", new Object[]{this});
    }

    @NotNull
    public final TextView getMAddressTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1713907250")) {
            return this.mAddressTv;
        }
        return (TextView) ipChange.ipc$dispatch("-1713907250", new Object[]{this});
    }

    @NotNull
    public final ImageView getMAuthImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1043157861")) {
            return this.mAuthImg;
        }
        return (ImageView) ipChange.ipc$dispatch("-1043157861", new Object[]{this});
    }

    @NotNull
    public final TextView getMDistanceTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-827734953")) {
            return this.mDistanceTv;
        }
        return (TextView) ipChange.ipc$dispatch("-827734953", new Object[]{this});
    }

    @NotNull
    public final View getMDivider() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "456244793")) {
            return this.mDivider;
        }
        return (View) ipChange.ipc$dispatch("456244793", new Object[]{this});
    }

    @NotNull
    public final ImageView getMPicImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-718210289")) {
            return this.mPicImg;
        }
        return (ImageView) ipChange.ipc$dispatch("-718210289", new Object[]{this});
    }

    @NotNull
    public final DMRatingBar getMRatingBar() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1484491972")) {
            return this.mRatingBar;
        }
        return (DMRatingBar) ipChange.ipc$dispatch("1484491972", new Object[]{this});
    }

    @NotNull
    public final LinearLayout getMScoreLl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "317104853")) {
            return this.mScoreLl;
        }
        return (LinearLayout) ipChange.ipc$dispatch("317104853", new Object[]{this});
    }

    @NotNull
    public final TextView getMScoreTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1803733328")) {
            return this.mScoreTv;
        }
        return (TextView) ipChange.ipc$dispatch("-1803733328", new Object[]{this});
    }

    @NotNull
    public final DMCategroyTagView getMTagView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1814641448")) {
            return this.mTagView;
        }
        return (DMCategroyTagView) ipChange.ipc$dispatch("1814641448", new Object[]{this});
    }

    @NotNull
    public final HighlightTextView getMTitleTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1097976849")) {
            return this.mTitleTv;
        }
        return (HighlightTextView) ipChange.ipc$dispatch("-1097976849", new Object[]{this});
    }

    @NotNull
    public final TextView getMTuanCountTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "991763169")) {
            return this.mTuanCountTv;
        }
        return (TextView) ipChange.ipc$dispatch("991763169", new Object[]{this});
    }

    @NotNull
    public final TextView getMTuanDescTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "338833005")) {
            return this.mTuanDescTv;
        }
        return (TextView) ipChange.ipc$dispatch("338833005", new Object[]{this});
    }

    @NotNull
    public final View getMTuanLayout() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "445600548")) {
            return this.mTuanLayout;
        }
        return (View) ipChange.ipc$dispatch("445600548", new Object[]{this});
    }

    @NotNull
    public final View getMTuanPriceTagTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1734827397")) {
            return this.mTuanPriceTagTv;
        }
        return (View) ipChange.ipc$dispatch("-1734827397", new Object[]{this});
    }

    @NotNull
    public final TextView getMTuanPriceTv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2095029479")) {
            return this.mTuanPriceTv;
        }
        return (TextView) ipChange.ipc$dispatch("2095029479", new Object[]{this});
    }

    public final void setDivline(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1846349788")) {
            ipChange.ipc$dispatch("-1846349788", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.divline = view;
    }

    public final void setItemView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920996557")) {
            ipChange.ipc$dispatch("-1920996557", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.itemView = view;
    }

    public final void setMAddressTv(@NotNull TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-564698058")) {
            ipChange.ipc$dispatch("-564698058", new Object[]{this, textView});
            return;
        }
        k21.i(textView, "<set-?>");
        this.mAddressTv = textView;
    }

    public final void setMAuthImg(@NotNull ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "147868291")) {
            ipChange.ipc$dispatch("147868291", new Object[]{this, imageView});
            return;
        }
        k21.i(imageView, "<set-?>");
        this.mAuthImg = imageView;
    }

    public final void setMDistanceTv(@NotNull TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83838005")) {
            ipChange.ipc$dispatch("83838005", new Object[]{this, textView});
            return;
        }
        k21.i(textView, "<set-?>");
        this.mDistanceTv = textView;
    }

    public final void setMDivider(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1282596409")) {
            ipChange.ipc$dispatch("-1282596409", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.mDivider = view;
    }

    public final void setMPicImg(@NotNull ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1210050777")) {
            ipChange.ipc$dispatch("-1210050777", new Object[]{this, imageView});
            return;
        }
        k21.i(imageView, "<set-?>");
        this.mPicImg = imageView;
    }

    public final void setMRatingBar(@NotNull DMRatingBar dMRatingBar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471948310")) {
            ipChange.ipc$dispatch("471948310", new Object[]{this, dMRatingBar});
            return;
        }
        k21.i(dMRatingBar, "<set-?>");
        this.mRatingBar = dMRatingBar;
    }

    public final void setMScoreLl(@NotNull LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084962869")) {
            ipChange.ipc$dispatch("1084962869", new Object[]{this, linearLayout});
            return;
        }
        k21.i(linearLayout, "<set-?>");
        this.mScoreLl = linearLayout;
    }

    public final void setMScoreTv(@NotNull TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216479380")) {
            ipChange.ipc$dispatch("216479380", new Object[]{this, textView});
            return;
        }
        k21.i(textView, "<set-?>");
        this.mScoreTv = textView;
    }

    public final void setMTagView(@NotNull DMCategroyTagView dMCategroyTagView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239229128")) {
            ipChange.ipc$dispatch("239229128", new Object[]{this, dMCategroyTagView});
            return;
        }
        k21.i(dMCategroyTagView, "<set-?>");
        this.mTagView = dMCategroyTagView;
    }

    public final void setMTitleTv(@NotNull HighlightTextView highlightTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1593084729")) {
            ipChange.ipc$dispatch("1593084729", new Object[]{this, highlightTextView});
            return;
        }
        k21.i(highlightTextView, "<set-?>");
        this.mTitleTv = highlightTextView;
    }

    public final void setMTuanCountTv(@NotNull TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924566397")) {
            ipChange.ipc$dispatch("-1924566397", new Object[]{this, textView});
            return;
        }
        k21.i(textView, "<set-?>");
        this.mTuanCountTv = textView;
    }

    public final void setMTuanDescTv(@NotNull TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887706335")) {
            ipChange.ipc$dispatch("1887706335", new Object[]{this, textView});
            return;
        }
        k21.i(textView, "<set-?>");
        this.mTuanDescTv = textView;
    }

    public final void setMTuanLayout(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "750517924")) {
            ipChange.ipc$dispatch("750517924", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.mTuanLayout = view;
    }

    public final void setMTuanPriceTagTv(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "307052589")) {
            ipChange.ipc$dispatch("307052589", new Object[]{this, view});
            return;
        }
        k21.i(view, "<set-?>");
        this.mTuanPriceTagTv = view;
    }

    public final void setMTuanPriceTv(@NotNull TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083049155")) {
            ipChange.ipc$dispatch("-2083049155", new Object[]{this, textView});
            return;
        }
        k21.i(textView, "<set-?>");
        this.mTuanPriceTv = textView;
    }
}
