package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: Taobao */
public interface JsonDeserializationContext {
    <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException;
}
