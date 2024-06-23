package com.alibaba.pictures.bricks.component.home;

import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.component.horizontal.GenericHorizontalContract;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface HorizontalPageContract extends GenericHorizontalContract {

    /* compiled from: Taobao */
    public interface Model {
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        void bindView(@Nullable JSONObject jSONObject);
    }
}
