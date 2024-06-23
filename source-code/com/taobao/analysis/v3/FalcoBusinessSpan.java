package com.taobao.analysis.v3;

/* compiled from: Taobao */
public interface FalcoBusinessSpan extends FalcoSpan {
    void dataParseStart(Long l);

    void networkRequestStart(Long l);

    void preProcessStart(Long l);

    void viewRenderEnd(Long l);

    void viewRenderStart(Long l);
}
