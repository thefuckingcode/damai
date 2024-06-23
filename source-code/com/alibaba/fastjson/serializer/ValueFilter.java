package com.alibaba.fastjson.serializer;

/* compiled from: Taobao */
public interface ValueFilter extends SerializeFilter {
    Object process(Object obj, String str, Object obj2);
}
