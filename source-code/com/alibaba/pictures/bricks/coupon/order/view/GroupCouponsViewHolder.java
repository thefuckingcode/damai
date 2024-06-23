package com.alibaba.pictures.bricks.coupon.order.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.coupon.order.bean.Good;
import com.alibaba.pictures.bricks.coupon.order.bean.Goods;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.it0;
import tb.k21;

/* compiled from: Taobao */
public final class GroupCouponsViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final TextView a;
    @NotNull
    private final CouponsListView b;
    @NotNull
    private final View c;
    @NotNull
    private final TextView d;
    @NotNull
    private final CouponsListViewAdapter e;
    private boolean f;
    @Nullable
    private Goods g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupCouponsViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        View findViewById = view.findViewById(R$id.tv_des);
        k21.h(findViewById, "itemView.findViewById(R.id.tv_des)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.rl_coupons);
        k21.h(findViewById2, "itemView.findViewById(R.id.rl_coupons)");
        CouponsListView couponsListView = (CouponsListView) findViewById2;
        this.b = couponsListView;
        View findViewById3 = view.findViewById(R$id.sp_line2);
        k21.h(findViewById3, "itemView.findViewById(R.id.sp_line2)");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R$id.tv_show_all);
        k21.h(findViewById4, "itemView.findViewById(R.id.tv_show_all)");
        TextView textView = (TextView) findViewById4;
        this.d = textView;
        RecyclerView.Adapter adapter = couponsListView.getAdapter();
        k21.g(adapter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.coupon.order.view.CouponsListViewAdapter");
        this.e = (CouponsListViewAdapter) adapter;
        textView.setOnClickListener(new it0(this));
    }

    /* access modifiers changed from: private */
    public static final void b(GroupCouponsViewHolder groupCouponsViewHolder, View view) {
        List<Good> goodsList;
        String goodsAmount;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204945682")) {
            ipChange.ipc$dispatch("204945682", new Object[]{groupCouponsViewHolder, view});
            return;
        }
        k21.i(groupCouponsViewHolder, "this$0");
        Goods goods = groupCouponsViewHolder.g;
        List<Good> list = null;
        List<Good> goodsList2 = goods != null ? goods.getGoodsList() : null;
        Goods goods2 = groupCouponsViewHolder.g;
        Integer valueOf = (goods2 == null || (goodsAmount = goods2.getGoodsAmount()) == null) ? null : Integer.valueOf(Integer.parseInt(goodsAmount));
        if ((goodsList2 == null || goodsList2.isEmpty()) || goodsList2.size() <= 6) {
            CouponsListViewAdapter couponsListViewAdapter = groupCouponsViewHolder.e;
            Goods goods3 = groupCouponsViewHolder.g;
            if (goods3 != null) {
                list = goods3.getGoodsList();
            }
            couponsListViewAdapter.setData(list);
            groupCouponsViewHolder.d.setVisibility(8);
        } else if (groupCouponsViewHolder.f) {
            CouponsListViewAdapter couponsListViewAdapter2 = groupCouponsViewHolder.e;
            Goods goods4 = groupCouponsViewHolder.g;
            if (!(goods4 == null || (goodsList = goods4.getGoodsList()) == null)) {
                list = goodsList.subList(0, 6);
            }
            couponsListViewAdapter2.setData(list);
            groupCouponsViewHolder.d.setText("展开全部" + valueOf + "个劵码");
        } else {
            CouponsListViewAdapter couponsListViewAdapter3 = groupCouponsViewHolder.e;
            Goods goods5 = groupCouponsViewHolder.g;
            if (goods5 != null) {
                list = goods5.getGoodsList();
            }
            couponsListViewAdapter3.setData(list);
            groupCouponsViewHolder.d.setText("收起");
        }
        groupCouponsViewHolder.f = !groupCouponsViewHolder.f;
    }

    public final void c(@Nullable Goods goods, @NotNull TrackInfo trackInfo) {
        String goodsAmount;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-674779763")) {
            ipChange.ipc$dispatch("-674779763", new Object[]{this, goods, trackInfo});
            return;
        }
        k21.i(trackInfo, "trackInfo");
        this.g = goods;
        this.e.c(trackInfo);
        if (goods != null) {
            this.a.setText(goods.getGoodsUseTitle());
            List<Good> goodsList = goods.getGoodsList();
            if (goodsList == null || goodsList.size() <= 0) {
                this.b.setVisibility(8);
                this.c.setVisibility(8);
                return;
            }
            this.b.setVisibility(0);
            List<Good> list = null;
            r1 = null;
            Integer num = null;
            if (this.f || goodsList.size() <= 6) {
                this.c.setVisibility(8);
                CouponsListViewAdapter couponsListViewAdapter = this.e;
                Goods goods2 = this.g;
                if (goods2 != null) {
                    list = goods2.getGoodsList();
                }
                couponsListViewAdapter.setData(list);
                return;
            }
            this.c.setVisibility(0);
            this.e.setData(goodsList.subList(0, 6));
            Goods goods3 = this.g;
            if (!(goods3 == null || (goodsAmount = goods3.getGoodsAmount()) == null)) {
                num = Integer.valueOf(Integer.parseInt(goodsAmount));
            }
            this.d.setText("展开全部" + num + "个劵码");
            this.d.setVisibility(0);
        }
    }
}
