package com.alibaba.pictures.bricks.component.scriptcoupon;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import java.util.HashMap;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class CouponInfoPresent$init$3 extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    @NotNull
    private final HashMap<String, Object> b = new HashMap<>();
    final /* synthetic */ Ref$BooleanRef c;
    final /* synthetic */ CouponInfoViewHolder d;
    final /* synthetic */ CouponInfoPresent e;
    final /* synthetic */ GenericItem<ItemValue> f;

    CouponInfoPresent$init$3(Ref$IntRef ref$IntRef, Ref$BooleanRef ref$BooleanRef, CouponInfoViewHolder couponInfoViewHolder, CouponInfoPresent couponInfoPresent, GenericItem<ItemValue> genericItem) {
        this.c = ref$BooleanRef;
        this.d = couponInfoViewHolder;
        this.e = couponInfoPresent;
        this.f = genericItem;
        this.a = ref$IntRef.element;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833372191")) {
            ipChange.ipc$dispatch("-1833372191", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (this.c.element) {
            this.b.put("hasTopBanner", Boolean.TRUE);
        } else {
            this.b.put("hasTopBanner", Boolean.FALSE);
            this.a = 0;
        }
        if (this.d.itemView.getTop() < this.a) {
            if (!k21.d(this.e.getCurrentBannerStatus(), "0")) {
                Activity activity = this.f.getPageContext().getActivity();
                if (activity != null) {
                    this.d.itemView.setBackgroundColor(ContextCompat.getColor(activity, 17170443));
                }
                this.e.setCurrentBannerStatus("0");
                this.b.put("bannerStatus", this.e.getCurrentBannerStatus());
                this.e.disPatch(CouponInfoPresent.CHANGE_BAR_EVENT, this.b);
            }
        } else if (!k21.d(this.e.getCurrentBannerStatus(), "1")) {
            Activity activity2 = this.f.getPageContext().getActivity();
            if (activity2 != null) {
                Ref$BooleanRef ref$BooleanRef = this.c;
                CouponInfoViewHolder couponInfoViewHolder = this.d;
                if (ref$BooleanRef.element) {
                    couponInfoViewHolder.itemView.setBackgroundColor(ContextCompat.getColor(activity2, 17170445));
                } else {
                    couponInfoViewHolder.itemView.setBackgroundColor(ContextCompat.getColor(activity2, R$color.bricks_825542));
                }
            }
            this.e.setCurrentBannerStatus("1");
            this.b.put("bannerStatus", this.e.getCurrentBannerStatus());
            this.e.disPatch(CouponInfoPresent.CHANGE_BAR_EVENT, this.b);
        }
    }
}
