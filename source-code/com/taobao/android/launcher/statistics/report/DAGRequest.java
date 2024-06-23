package com.taobao.android.launcher.statistics.report;

import mtopsdk.mtop.domain.IMTOPDataObject;

/* compiled from: Taobao */
public class DAGRequest implements IMTOPDataObject {
    public String API_NAME = "mtop.taobao.tmq.performance.reportPerformance";
    public boolean NEED_ECODE = false;
    public boolean NEED_SESSION = false;
    public String VERSION = "1.0";
    public String performanceData = null;

    public DAGRequest(String str) {
        this.performanceData = str;
    }
}
