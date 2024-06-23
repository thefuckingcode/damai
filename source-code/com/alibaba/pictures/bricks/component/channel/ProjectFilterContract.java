package com.alibaba.pictures.bricks.component.channel;

import cn.damai.projectfiltercopy.bean.FilterResponse;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface ProjectFilterContract {

    /* compiled from: Taobao */
    public interface Model {
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        void bind(@Nullable FilterResponse filterResponse);
    }
}
