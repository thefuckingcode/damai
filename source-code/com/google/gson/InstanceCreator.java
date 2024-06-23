package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: Taobao */
public interface InstanceCreator<T> {
    T createInstance(Type type);
}
