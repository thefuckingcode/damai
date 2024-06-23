package com.alibaba.pictures.bricks.component.scriptmurder;

import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface ShopInfoContract {

    /* compiled from: Taobao */
    public interface Model {
        @NotNull
        ShopInfoBean getShopInfo();
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        @NotNull
        ShopInfoViewHolder getViewHolder();
    }
}
