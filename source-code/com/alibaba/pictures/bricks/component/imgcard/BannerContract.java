package com.alibaba.pictures.bricks.component.imgcard;

import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class BannerContract implements IContract {

    /* compiled from: Taobao */
    public interface Model {
        @NotNull
        BannerBean getContent();
    }

    /* compiled from: Taobao */
    public interface Presenter {
    }

    /* compiled from: Taobao */
    public interface View {
        void renderImage(@NotNull BannerBean bannerBean);
    }
}
