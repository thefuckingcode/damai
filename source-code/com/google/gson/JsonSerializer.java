package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: Taobao */
public interface JsonSerializer<T> {
    JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext);
}
