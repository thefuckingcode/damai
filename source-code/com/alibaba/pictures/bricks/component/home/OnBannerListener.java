package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import com.alibaba.pictures.bricks.bean.NestedBannerBean;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface OnBannerListener {
    void onBannerItemClick(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i);

    void onBannerViewExpose(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i);
}
