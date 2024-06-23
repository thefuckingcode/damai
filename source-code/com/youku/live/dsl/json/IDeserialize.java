package com.youku.live.dsl.json;

/* compiled from: Taobao */
public interface IDeserialize {
    <T> T deserialize(String str, Class<T> cls);
}
