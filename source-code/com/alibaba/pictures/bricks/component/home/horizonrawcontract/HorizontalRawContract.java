package com.alibaba.pictures.bricks.component.home.horizonrawcontract;

import android.widget.LinearLayout;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface HorizontalRawContract {

    /* compiled from: Taobao */
    public interface Model {
    }

    /* compiled from: Taobao */
    public interface Presenter {
    }

    /* compiled from: Taobao */
    public interface View {
        @NotNull
        LinearLayout getHorizontalRaw();

        void initHorizontalRawSettings(@Nullable Map<String, ? extends Object> map);

        void showComponents(@NotNull List<? extends VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> list);
    }
}
