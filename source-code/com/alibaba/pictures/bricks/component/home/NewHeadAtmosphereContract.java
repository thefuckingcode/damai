package com.alibaba.pictures.bricks.component.home;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.bricks.bean.HeadAtmosphereBean;
import com.youku.kubus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface NewHeadAtmosphereContract {

    /* compiled from: Taobao */
    public interface Model {
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        void bindView(@Nullable RecyclerView recyclerView, boolean z, @NotNull Activity activity, @Nullable EventBus eventBus, @Nullable HeadAtmosphereBean headAtmosphereBean);

        void scrollChanged(@NotNull RecyclerView recyclerView, int i);
    }
}
