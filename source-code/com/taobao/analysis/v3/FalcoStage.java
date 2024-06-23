package com.taobao.analysis.v3;

/* compiled from: Taobao */
public interface FalcoStage {
    String errorCode();

    void finish(Long l);

    void finish(Long l, String str);

    String name();

    void start(Long l);
}
