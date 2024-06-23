package com.taobao.opentracing.api;

import java.util.Map;

/* compiled from: Taobao */
public interface SpanContext {
    Iterable<Map.Entry<String, String>> baggageItems();

    String toSpanId();

    String toTraceId();
}
