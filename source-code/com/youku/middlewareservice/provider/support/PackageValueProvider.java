package com.youku.middlewareservice.provider.support;

/* compiled from: Taobao */
public interface PackageValueProvider {
    <T> T get(String str);

    <T> T get(String str, T t);
}
