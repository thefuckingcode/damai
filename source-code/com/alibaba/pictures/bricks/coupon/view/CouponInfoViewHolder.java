package com.alibaba.pictures.bricks.coupon.view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.CouponOrderInfoBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.qm1;
import tb.um2;

/* compiled from: Taobao */
public final class CouponInfoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final TextView a;
    @NotNull
    private final View b;
    @Nullable
    private CouponOrderInfoBean c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponInfoViewHolder(@NotNull ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_coupon_info_view, viewGroup, false));
        k21.i(viewGroup, "parent");
        View findViewById = this.itemView.findViewById(R$id.id_bricks_ci_info);
        k21.h(findViewById, "itemView.findViewById(R.id.id_bricks_ci_info)");
        this.a = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R$id.id_bricks_ci_copy);
        k21.h(findViewById2, "itemView.findViewById(R.id.id_bricks_ci_copy)");
        this.b = findViewById2;
    }

    public final void a(@NotNull CouponOrderInfoBean couponOrderInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1256406342")) {
            ipChange.ipc$dispatch("1256406342", new Object[]{this, couponOrderInfoBean});
            return;
        }
        k21.i(couponOrderInfoBean, "orderInfoBean");
        this.c = couponOrderInfoBean;
        this.a.setText(couponOrderInfoBean.formatOrderInfoText());
        this.b.setOnClickListener(this);
        qm1 qm1 = qm1.INSTANCE;
        View view = this.b;
        CouponOrderInfoBean couponOrderInfoBean2 = this.c;
        qm1.c(view, couponOrderInfoBean2 != null ? couponOrderInfoBean2.getOrderId() : null);
    }

    public void onClick(@Nullable View view) {
        String orderId;
        Context context;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1696428752")) {
            ipChange.ipc$dispatch("1696428752", new Object[]{this, view});
            return;
        }
        CouponOrderInfoBean couponOrderInfoBean = this.c;
        if (couponOrderInfoBean != null && (orderId = couponOrderInfoBean.getOrderId()) != null && view != null && (context = view.getContext()) != null) {
            try {
                qm1.INSTANCE.o(view, orderId);
                Object systemService = context.getSystemService("clipboard");
                k21.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("订单编号", orderId));
                um2.INSTANCE.i(context, "已成功复制到剪切板");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
