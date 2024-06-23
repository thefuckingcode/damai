package com.alibaba.pictures.bricks.component.scriptmurder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.view.FiveStarView;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.flexbox.FlexboxLayout;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ia2;
import tb.ja2;
import tb.k21;
import tb.ka2;
import tb.la2;
import tb.ma2;
import tb.wf2;

/* compiled from: Taobao */
public final class ShopInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final TextView a;
    @Nullable
    private final ImageView b;
    @Nullable
    private final TextView c;
    @Nullable
    private final TextView d;
    @NotNull
    private final View e;
    @NotNull
    private final TextView f;
    private final View g;
    @Nullable
    private final FiveStarView h;
    private final TextView i;
    private final View j;
    @Nullable
    private final View k;
    @Nullable
    private final View l;
    @Nullable
    private final TextView m;
    private final FlexboxLayout n;
    @Nullable
    private final TextView o;
    @Nullable
    private final View p;
    @Nullable
    private final View q;
    @Nullable
    private OnShopInfoListener r;
    @Nullable
    private ShopInfoBean s;

    /* compiled from: Taobao */
    public interface OnShopInfoListener {
        void onEvaluateEntranceBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);

        void onShopAuthBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);

        void onShopInfoEntranceClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);

        void onShopInfoViewExpose(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);

        void onShopMapBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);

        void onShopPhoneBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopInfoViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.a = (TextView) view.findViewById(R$id.id_sm_shop_name);
        ImageView imageView = (ImageView) view.findViewById(R$id.id_sm_shop_auth);
        this.b = imageView;
        this.c = (TextView) view.findViewById(R$id.id_sm_shop_ext_info);
        this.d = (TextView) view.findViewById(R$id.id_sm_shop_ext_status);
        View findViewById = view.findViewById(R$id.id_sm_shop_open_evaluate_btn);
        k21.h(findViewById, "itemView.findViewById(R.…m_shop_open_evaluate_btn)");
        this.e = findViewById;
        View findViewById2 = view.findViewById(R$id.id_sm_shop_price_and_count);
        k21.h(findViewById2, "itemView.findViewById(R.…_sm_shop_price_and_count)");
        this.f = (TextView) findViewById2;
        this.g = view.findViewById(R$id.id_sm_score_ext_ui);
        this.h = (FiveStarView) view.findViewById(R$id.id_sm_shop_star_view);
        this.i = (TextView) view.findViewById(R$id.id_sm_shop_score_tv);
        this.j = view.findViewById(R$id.id_sm_shop_score_star_ui);
        View findViewById3 = view.findViewById(R$id.id_sm_shop_call_ui);
        this.k = findViewById3;
        View findViewById4 = view.findViewById(R$id.id_sm_shop_loc_ui);
        this.l = findViewById4;
        this.m = (TextView) view.findViewById(R$id.id_sm_shop_loc_distance);
        this.n = (FlexboxLayout) view.findViewById(R$id.id_sm_shop_tag_flex2);
        this.o = (TextView) view.findViewById(R$id.id_sm_shop_addr);
        View findViewById5 = view.findViewById(R$id.id_sm_shop_info_entrance);
        this.p = findViewById5;
        this.q = view.findViewById(R$id.id_sm_shop_entrance_arrow);
        if (imageView != null) {
            imageView.setOnClickListener(new ka2(this));
        }
        if (findViewById != null) {
            findViewById.setOnClickListener(new ma2(this));
        }
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new la2(this));
        }
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(new ja2(this));
        }
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(new ia2(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void f(ShopInfoViewHolder shopInfoViewHolder, View view) {
        OnShopInfoListener onShopInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-253854913")) {
            ipChange.ipc$dispatch("-253854913", new Object[]{shopInfoViewHolder, view});
            return;
        }
        k21.i(shopInfoViewHolder, "this$0");
        ShopInfoBean shopInfoBean = shopInfoViewHolder.s;
        if (shopInfoBean != null && (onShopInfoListener = shopInfoViewHolder.r) != null) {
            k21.h(view, AdvanceSetting.NETWORK_TYPE);
            onShopInfoListener.onShopAuthBtnClick(view, shopInfoBean);
        }
    }

    /* access modifiers changed from: private */
    public static final void g(ShopInfoViewHolder shopInfoViewHolder, View view) {
        OnShopInfoListener onShopInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1872829827")) {
            ipChange.ipc$dispatch("-1872829827", new Object[]{shopInfoViewHolder, view});
            return;
        }
        k21.i(shopInfoViewHolder, "this$0");
        ShopInfoBean shopInfoBean = shopInfoViewHolder.s;
        if (shopInfoBean != null && (onShopInfoListener = shopInfoViewHolder.r) != null) {
            k21.h(view, AdvanceSetting.NETWORK_TYPE);
            onShopInfoListener.onEvaluateEntranceBtnClick(view, shopInfoBean);
        }
    }

    /* access modifiers changed from: private */
    public static final void h(ShopInfoViewHolder shopInfoViewHolder, View view) {
        OnShopInfoListener onShopInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "803162555")) {
            ipChange.ipc$dispatch("803162555", new Object[]{shopInfoViewHolder, view});
            return;
        }
        k21.i(shopInfoViewHolder, "this$0");
        ShopInfoBean shopInfoBean = shopInfoViewHolder.s;
        if (shopInfoBean != null && (onShopInfoListener = shopInfoViewHolder.r) != null) {
            k21.h(view, AdvanceSetting.NETWORK_TYPE);
            onShopInfoListener.onShopPhoneBtnClick(view, shopInfoBean);
        }
    }

    /* access modifiers changed from: private */
    public static final void i(ShopInfoViewHolder shopInfoViewHolder, View view) {
        OnShopInfoListener onShopInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815812359")) {
            ipChange.ipc$dispatch("-815812359", new Object[]{shopInfoViewHolder, view});
            return;
        }
        k21.i(shopInfoViewHolder, "this$0");
        ShopInfoBean shopInfoBean = shopInfoViewHolder.s;
        if (shopInfoBean != null && (onShopInfoListener = shopInfoViewHolder.r) != null) {
            k21.h(view, AdvanceSetting.NETWORK_TYPE);
            onShopInfoListener.onShopMapBtnClick(view, shopInfoBean);
        }
    }

    /* access modifiers changed from: private */
    public static final void j(ShopInfoViewHolder shopInfoViewHolder, View view) {
        OnShopInfoListener onShopInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860180023")) {
            ipChange.ipc$dispatch("1860180023", new Object[]{shopInfoViewHolder, view});
            return;
        }
        k21.i(shopInfoViewHolder, "this$0");
        ShopInfoBean shopInfoBean = shopInfoViewHolder.s;
        if (shopInfoBean != null && (onShopInfoListener = shopInfoViewHolder.r) != null) {
            k21.h(view, AdvanceSetting.NETWORK_TYPE);
            onShopInfoListener.onShopInfoEntranceClick(view, shopInfoBean);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    public final void k(@NotNull ShopInfoBean shopInfoBean) {
        int i2;
        StringBuilder sb;
        String storeStatus;
        ArrayList<String> openTime;
        TextView textView;
        ArrayList<String> tags;
        View view;
        View view2;
        OnShopInfoListener onShopInfoListener;
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1563603291")) {
            ipChange.ipc$dispatch("1563603291", new Object[]{this, shopInfoBean});
            return;
        }
        k21.i(shopInfoBean, "bean");
        this.s = shopInfoBean;
        TextView textView2 = this.a;
        if (textView2 != null) {
            textView2.setText(shopInfoBean.getName());
        }
        TextView textView3 = this.o;
        if (textView3 != null) {
            textView3.setText(shopInfoBean.getAddress());
        }
        TextView textView4 = this.m;
        if (textView4 != null) {
            String distance = shopInfoBean.getDistance();
            textView4.setText(distance == null || distance.length() == 0 ? "地图" : shopInfoBean.getDistance());
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setVisibility(shopInfoBean.getHasCertificationInfo() ? 0 : 8);
        }
        String certificationIcon = shopInfoBean.getCertificationIcon();
        if (certificationIcon != null) {
            ImageLoaderProvider proxy = ImageLoaderProviderProxy.getProxy();
            ImageView imageView2 = this.b;
            int i4 = R$drawable.bricks_icon_shope_rp;
            proxy.loadinto(certificationIcon, imageView2, i4, i4);
        }
        wf2 wf2 = wf2.INSTANCE;
        double e2 = wf2.e(shopInfoBean.getStoreScore(), 0.0d);
        if (e2 > 0.0d) {
            this.i.setText(shopInfoBean.getStoreScore());
            FiveStarView fiveStarView = this.h;
            if (fiveStarView != null) {
                fiveStarView.updateView(e2);
            }
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        StringBuilder sb2 = new StringBuilder();
        String scriptScore = shopInfoBean.getScriptScore();
        if (scriptScore != null) {
            if (!(wf2.e(scriptScore, 0.0d) > 0.0d)) {
                scriptScore = null;
            }
            if (scriptScore != null) {
                sb2.append("剧本: ");
                sb2.append(scriptScore);
                sb2.append(" ");
            }
        }
        String dmScore = shopInfoBean.getDmScore();
        if (dmScore != null) {
            if (!(wf2.e(dmScore, 0.0d) > 0.0d)) {
                dmScore = null;
            }
            if (dmScore != null) {
                sb2.append("主持人: ");
                sb2.append(dmScore);
                sb2.append(" ");
            }
        }
        String envScore = shopInfoBean.getEnvScore();
        if (envScore != null) {
            if (!(wf2.e(envScore, 0.0d) > 0.0d)) {
                envScore = null;
            }
            if (envScore != null) {
                sb2.append("环境: ");
                sb2.append(envScore);
            }
        }
        TextView textView5 = this.c;
        if (textView5 != null) {
            textView5.setText(sb2.toString());
        }
        TextView textView6 = this.c;
        if (textView6 != null) {
            textView6.setVisibility(sb2.length() > 0 ? 0 : 8);
        }
        long g2 = wf2.g(shopInfoBean.getOrderNum(), -1);
        StringBuilder sb3 = new StringBuilder();
        if (g2 > 0) {
            sb3.append(wf2.d(g2));
            sb3.append("人去玩过");
        }
        String priceLow = shopInfoBean.getPriceLow();
        if (priceLow != null) {
            if (priceLow.length() == 0) {
                priceLow = null;
            }
            if (priceLow != null) {
                if (StringsKt__StringsKt.Q(priceLow, "待定", false, 2, null)) {
                    if (sb3.length() > 0) {
                        sb3.append(" | ");
                    }
                    sb3.append(priceLow);
                } else if (wf2.e(priceLow, 0.0d) > 0.0d) {
                    if (sb3.length() > 0) {
                        sb3.append(" | ");
                    }
                    sb3.append("￥");
                    sb3.append(priceLow);
                    sb3.append("/人");
                }
            }
        }
        this.f.setText(sb3.toString());
        View view3 = this.g;
        if (this.e.getVisibility() != 0) {
            if (!(sb3.length() > 0)) {
                i2 = 8;
                view3.setVisibility(i2);
                sb = new StringBuilder();
                storeStatus = shopInfoBean.getStoreStatus();
                if (storeStatus != null) {
                    sb.append(storeStatus);
                    sb.append(" | ");
                }
                openTime = shopInfoBean.getOpenTime();
                if (openTime != null) {
                    Iterator<T> it = openTime.iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        sb.append(" , ");
                    }
                }
                if (StringsKt__StringsKt.W(sb, " , ", false, 2, null)) {
                    k21.h(sb.delete(sb.length() - 3, sb.length() - 1), "this.delete(startIndex, endIndex)");
                }
                textView = this.d;
                if (textView != null) {
                    textView.setText(sb.toString());
                }
                this.n.removeAllViews();
                FlexboxLayout flexboxLayout = this.n;
                ArrayList<String> tags2 = shopInfoBean.getTags();
                if (tags2 != null && !tags2.isEmpty()) {
                    z = false;
                }
                flexboxLayout.setVisibility(!z ? 8 : 0);
                tags = shopInfoBean.getTags();
                if (tags != null) {
                    Iterator<T> it2 = tags.iterator();
                    while (it2.hasNext()) {
                        View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.item_bricks_one_shop_tag, (ViewGroup) null);
                        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                        ((TextView) inflate.findViewById(R$id.id_bricks_one_shop_tag)).setText(it2.next());
                        FlexboxLayout flexboxLayout2 = this.n;
                        if (flexboxLayout2 != null) {
                            flexboxLayout2.addView(inflate);
                        }
                    }
                }
                view = this.q;
                if (view != null) {
                    view.setVisibility(shopInfoBean.isShopOpened() ? 0 : 4);
                }
                view2 = this.k;
                if (view2 != null) {
                    if (!shopInfoBean.isShopOpened()) {
                        i3 = 8;
                    }
                    view2.setVisibility(i3);
                }
                onShopInfoListener = this.r;
                if (onShopInfoListener == null) {
                    View view4 = this.itemView;
                    k21.h(view4, "itemView");
                    onShopInfoListener.onShopInfoViewExpose(view4, shopInfoBean);
                    return;
                }
                return;
            }
        }
        i2 = 0;
        view3.setVisibility(i2);
        sb = new StringBuilder();
        storeStatus = shopInfoBean.getStoreStatus();
        if (storeStatus != null) {
        }
        openTime = shopInfoBean.getOpenTime();
        if (openTime != null) {
        }
        if (StringsKt__StringsKt.W(sb, " , ", false, 2, null)) {
        }
        textView = this.d;
        if (textView != null) {
        }
        this.n.removeAllViews();
        FlexboxLayout flexboxLayout3 = this.n;
        ArrayList<String> tags22 = shopInfoBean.getTags();
        z = false;
        flexboxLayout3.setVisibility(!z ? 8 : 0);
        tags = shopInfoBean.getTags();
        if (tags != null) {
        }
        view = this.q;
        if (view != null) {
        }
        view2 = this.k;
        if (view2 != null) {
        }
        onShopInfoListener = this.r;
        if (onShopInfoListener == null) {
        }
    }

    public final void l(@Nullable OnShopInfoListener onShopInfoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-55228406")) {
            ipChange.ipc$dispatch("-55228406", new Object[]{this, onShopInfoListener});
            return;
        }
        this.r = onShopInfoListener;
    }
}
