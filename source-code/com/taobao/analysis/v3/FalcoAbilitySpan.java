package com.taobao.analysis.v3;

/* compiled from: Taobao */
public interface FalcoAbilitySpan extends FalcoSpan {
    void invokeStart(Long l);

    void postProcessEnd(Long l);

    void postProcessStart(Long l);

    void preProcessStart(Long l);
}
