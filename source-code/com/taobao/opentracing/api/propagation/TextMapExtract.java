package com.taobao.opentracing.api.propagation;

import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
public interface TextMapExtract extends Iterable<Map.Entry<String, String>> {
    @Override // java.lang.Iterable
    Iterator<Map.Entry<String, String>> iterator();
}
