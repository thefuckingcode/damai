package com.taobao.tao.log;

/* compiled from: Taobao */
public enum LogCategory {
    CodeLog("CodeLog", 1),
    TraceEventLog("TraceEventLog", 2),
    SceneLog("SceneLog", 3),
    PageLog("PageLog", 4),
    EventLog("EventLog", 5),
    MetricLog("MetricLog", 6),
    SpanLog("SpanLog", 7);
    
    private int index;
    private String name;

    private LogCategory(String str, int i) {
        this.name = str;
        this.index = i;
    }

    /* access modifiers changed from: protected */
    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    protected static String getName(int i) {
        LogCategory[] values = values();
        for (LogCategory logCategory : values) {
            if (logCategory.getIndex() == i) {
                return logCategory.name;
            }
        }
        return null;
    }
}
