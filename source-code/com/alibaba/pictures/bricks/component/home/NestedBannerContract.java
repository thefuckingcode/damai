package com.alibaba.pictures.bricks.component.home;

import com.alibaba.pictures.bricks.bean.NestedBannerBean;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface NestedBannerContract {

    /* compiled from: Taobao */
    public interface Model {
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        void bind(@Nullable List<? extends NestedBannerBean> list);

        boolean isLargeScreenMode();

        void setScreenMode(boolean z);
    }
}
