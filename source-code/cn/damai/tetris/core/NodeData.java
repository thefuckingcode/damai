package cn.damai.tetris.core;

import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
public class NodeData extends JSONObject {
    public NodeData(JSONObject jSONObject) {
        super(jSONObject.getInnerMap());
    }

    public NodeData() {
    }
}
