package com.alibaba.pictures.bricks.component.home;

import com.alibaba.pictures.bricks.bean.HomeProjectItemBean;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface HomeProjectItemContract {

    /* compiled from: Taobao */
    public interface Model {
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        void bindView(@NotNull HomeProjectItemBean homeProjectItemBean);

        void updateWantSeeBtn(boolean z);
    }
}
