package com.youku.upsplayer.module;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* compiled from: Taobao */
public class ProductBuyParam {
    @JSONField(name = "product_id")
    public int product_id;
    @JSONField(name = "selected_promotion_param")
    public List<SelectedPromotionParamBean> selected_promotion_param;
    @JSONField(name = "sku_id")
    public int sku_id;
}
