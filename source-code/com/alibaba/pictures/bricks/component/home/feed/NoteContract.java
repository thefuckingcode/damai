package com.alibaba.pictures.bricks.component.home.feed;

import com.alibaba.pictures.bricks.bean.NoteBean;
import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface NoteContract extends IContract {

    /* compiled from: Taobao */
    public interface Model {
    }

    /* compiled from: Taobao */
    public interface Present {
        void dnaClick(@NotNull NoteBean noteBean);

        void exposeDna(@NotNull android.view.View view);

        void itemClick(@NotNull NoteBean noteBean);

        void projectClick(@NotNull NoteBean noteBean);

        void projectExpose(@NotNull NoteBean noteBean, @NotNull android.view.View view);
    }

    /* compiled from: Taobao */
    public interface View {
        void bindView(@NotNull NoteBean noteBean);
    }
}
