package com.alibaba.pictures.bricks.component.home.calendar;

import com.alibaba.pictures.bricks.bean.HomeCalendarBean;
import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface HomeCalendarContract extends IContract {

    /* compiled from: Taobao */
    public interface Model {
    }

    /* compiled from: Taobao */
    public interface Present {
        void expose(@NotNull HomeCalendarBean homeCalendarBean);

        void onClick(@NotNull HomeCalendarBean homeCalendarBean);
    }

    /* compiled from: Taobao */
    public interface View {
        void bindView(@NotNull HomeCalendarBean homeCalendarBean);

        void changeScreenMode(boolean z);
    }
}
