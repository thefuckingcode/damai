package com.alibaba.pictures.bricks.component.home.grabhotrecommend;

import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.component.banner.loop.LoopBannerContract;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface HomeGrabHotRecommendContainerContract extends LoopBannerContract {

    /* compiled from: Taobao */
    public interface Model {
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        void bindView(@Nullable JSONObject jSONObject, @Nullable String str);
    }
}
