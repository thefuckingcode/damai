package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

/* compiled from: Taobao */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor2) {
        this.constructorConstructor = constructorConstructor2;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (TypeAdapter<T>) getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    /* access modifiers changed from: package-private */
    public TypeAdapter<?> getTypeAdapter(ConstructorConstructor constructorConstructor2, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        TypeAdapter<?> typeAdapter;
        Object construct = constructorConstructor2.get(TypeToken.get((Class) jsonAdapter.value())).construct();
        if (construct instanceof TypeAdapter) {
            typeAdapter = (TypeAdapter) construct;
        } else if (construct instanceof TypeAdapterFactory) {
            typeAdapter = ((TypeAdapterFactory) construct).create(gson, typeToken);
        } else {
            boolean z = construct instanceof JsonSerializer;
            if (z || (construct instanceof JsonDeserializer)) {
                JsonDeserializer jsonDeserializer = null;
                JsonSerializer jsonSerializer = z ? (JsonSerializer) construct : null;
                if (construct instanceof JsonDeserializer) {
                    jsonDeserializer = (JsonDeserializer) construct;
                }
                typeAdapter = new TreeTypeAdapter<>(jsonSerializer, jsonDeserializer, gson, typeToken, null);
            } else {
                throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
            }
        }
        return typeAdapter != null ? typeAdapter.nullSafe() : typeAdapter;
    }
}
