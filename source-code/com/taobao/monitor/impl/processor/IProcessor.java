package com.taobao.monitor.impl.processor;

/* compiled from: Taobao */
public interface IProcessor {

    /* compiled from: Taobao */
    public interface IProcessorLifeCycle {
        void processorOnEnd(IProcessor iProcessor);

        void processorOnStart(IProcessor iProcessor);
    }
}
