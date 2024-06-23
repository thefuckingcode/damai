package com.alibaba.pictures.bricks.coupon.order.bean;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public enum GoodStatus {
    DEFAULT(null),
    NOTHING("0"),
    USABLE("1"),
    REFUNDING("2"),
    REFUNDED("3"),
    USED("4"),
    REFUND_FAILED("5");
    
    @Nullable
    private final String status;

    private GoodStatus(String str) {
        this.status = str;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }
}
