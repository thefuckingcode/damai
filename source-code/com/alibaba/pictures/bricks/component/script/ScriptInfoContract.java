package com.alibaba.pictures.bricks.component.script;

import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface ScriptInfoContract {

    /* compiled from: Taobao */
    public interface Model {
        @NotNull
        ScriptInfoHeaderBean getScriptInfo();
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        @NotNull
        ViewGroup getHeader();
    }
}
