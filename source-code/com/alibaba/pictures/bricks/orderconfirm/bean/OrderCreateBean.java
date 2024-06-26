package com.alibaba.pictures.bricks.orderconfirm.bean;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class OrderCreateBean implements Serializable {
    private static final long serialVersionUID = -1;
    public JSONObject data;
    public List<GaiaxRender> render;
    public String templateId;

    /* compiled from: Taobao */
    public static class GaiaxRender implements Serializable {
        private static final long serialVersionUID = -1;
        public String type;
        public String url;
    }
}
