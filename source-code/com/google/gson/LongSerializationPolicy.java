package com.google.gson;

/* compiled from: Taobao */
public enum LongSerializationPolicy {
    DEFAULT {
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive((Number) l);
        }
    },
    STRING {
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive(String.valueOf(l));
        }
    };

    public abstract JsonElement serialize(Long l);
}
