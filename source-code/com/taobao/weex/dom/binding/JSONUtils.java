package com.taobao.weex.dom.binding;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class JSONUtils {
    public static boolean isJSON(Object obj) {
        if (obj instanceof JSONObject) {
            return true;
        }
        if (obj instanceof String) {
            return ((String) obj).startsWith(jl1.BLOCK_START_STR);
        }
        return false;
    }

    public static JSONObject toJSON(Object obj) {
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        return JSON.parseObject(obj.toString());
    }

    public static boolean isJSON(String str) {
        return str.startsWith(jl1.BLOCK_START_STR);
    }
}
