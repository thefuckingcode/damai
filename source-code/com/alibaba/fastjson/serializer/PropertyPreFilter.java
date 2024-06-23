package com.alibaba.fastjson.serializer;

/* compiled from: Taobao */
public interface PropertyPreFilter extends SerializeFilter {
    boolean apply(JSONSerializer jSONSerializer, Object obj, String str);
}
