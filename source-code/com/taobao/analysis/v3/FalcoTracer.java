package com.taobao.analysis.v3;

import com.taobao.opentracing.api.SpanContext;
import com.taobao.opentracing.api.Tracer;
import java.util.Map;

/* compiled from: Taobao */
public interface FalcoTracer extends Tracer {

    /* compiled from: Taobao */
    public interface FalcoSpanBuilder extends Tracer.SpanBuilder {
        FalcoAbilitySpan startAbilitySpan();

        FalcoBusinessSpan startBusinessSpan();

        FalcoContainerSpan startContainerSpan();

        FalcoNetworkAbilitySpan startNetworkAbilitySpan();
    }

    FalcoSpanBuilder buildSpan(String str, String str2);

    SpanContext extractMapToContext(Map<String, String> map);

    Map<String, String> injectContextToMap(SpanContext spanContext);
}
