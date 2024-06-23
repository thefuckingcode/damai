package cn.damai.tetris.v2.common;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class Node implements Serializable {
    public List<Node> children;
    public JSONObject data;
}
