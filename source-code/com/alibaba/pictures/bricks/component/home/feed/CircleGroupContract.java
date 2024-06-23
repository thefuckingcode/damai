package com.alibaba.pictures.bricks.component.home.feed;

import com.alibaba.pictures.bricks.bean.CircleCard;
import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface CircleGroupContract extends IContract {

    /* compiled from: Taobao */
    public interface Model {
    }

    /* compiled from: Taobao */
    public interface Present {
        void onClick();
    }

    /* compiled from: Taobao */
    public interface View {
        void bindView(@NotNull CircleCard circleCard);
    }
}
