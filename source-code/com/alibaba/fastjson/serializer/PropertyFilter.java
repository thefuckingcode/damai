package com.alibaba.fastjson.serializer;

/* compiled from: Taobao */
public interface PropertyFilter extends SerializeFilter {
    boolean apply(Object obj, String str, Object obj2);
}
