package com.youku.middlewareservice.provider.json;

/* compiled from: Taobao */
public interface JsonProvider {
    <T> T fromJson(String str, Class<T> cls);

    <T> T parseObject(String str, Class<T> cls);

    String toJSONString(Object obj);

    String toJson(Object obj);
}
