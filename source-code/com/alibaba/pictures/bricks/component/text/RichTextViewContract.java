package com.alibaba.pictures.bricks.component.text;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface RichTextViewContract {

    /* compiled from: Taobao */
    public interface Model {
        @NotNull
        String getDesc();
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        @NotNull
        RecyclerView getRichTextView();

        @NotNull
        TextView getShowMoreView();
    }
}
