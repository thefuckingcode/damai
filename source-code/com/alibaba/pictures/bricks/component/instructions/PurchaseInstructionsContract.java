package com.alibaba.pictures.bricks.component.instructions;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface PurchaseInstructionsContract {

    /* compiled from: Taobao */
    public interface Model {
        @Nullable
        String getContent();

        @Nullable
        String getTitle();
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        void renderContent(@Nullable String str);

        void renderTitle(@Nullable String str);
    }
}
