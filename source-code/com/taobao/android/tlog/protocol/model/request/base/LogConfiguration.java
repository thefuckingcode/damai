package com.taobao.android.tlog.protocol.model.request.base;

import java.util.Map;

/* compiled from: Taobao */
public class LogConfiguration {
    private Map<String, RollingFileAppender> appenders;
    private Boolean destroy;
    private Boolean enable;
    private Map<String, Logger> loggers;
}
