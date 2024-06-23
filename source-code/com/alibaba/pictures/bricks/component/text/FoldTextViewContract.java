package com.alibaba.pictures.bricks.component.text;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface FoldTextViewContract {

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
        FoldTextView getTextView();
    }
}
