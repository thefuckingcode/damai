package com.alibaba.pictures.bricks.component.scriptcoupon;

import com.alibaba.pictures.bricks.bean.CouponInfoBean;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface CouponInfoContract {

    /* compiled from: Taobao */
    public interface Model {
        @NotNull
        CouponInfoBean getCouponInfoBean();
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        @NotNull
        CouponInfoViewHolder getViewHolder();
    }
}
