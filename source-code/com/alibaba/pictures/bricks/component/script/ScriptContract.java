package com.alibaba.pictures.bricks.component.script;

import com.alibaba.pictures.bricks.bean.SearchScriptBean;
import com.youku.arch.v3.view.IContract;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ScriptContract implements IContract {

    /* compiled from: Taobao */
    public interface Model {
        @Nullable
        SearchScriptBean getData();
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        void bindData(@Nullable SearchScriptBean searchScriptBean);
    }
}
