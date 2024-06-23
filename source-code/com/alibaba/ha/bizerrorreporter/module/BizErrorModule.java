package com.alibaba.ha.bizerrorreporter.module;

import java.util.Map;

/* compiled from: Taobao */
public class BizErrorModule {
    public AggregationType aggregationType = null;
    public String businessType = null;
    public String exceptionArg1;
    public String exceptionArg2;
    public String exceptionArg3;
    public Map<String, Object> exceptionArgs;
    public String exceptionCode;
    public String exceptionDetail;
    public String exceptionId;
    public String exceptionVersion;
    public Thread thread;
    public Throwable throwable;
}
