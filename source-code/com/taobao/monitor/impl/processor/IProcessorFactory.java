package com.taobao.monitor.impl.processor;

import com.taobao.monitor.impl.processor.IProcessor;

/* compiled from: Taobao */
public interface IProcessorFactory<T extends IProcessor> {
    T createProcessor();
}
