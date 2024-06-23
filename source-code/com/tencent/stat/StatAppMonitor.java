package com.tencent.stat;

/* compiled from: Taobao */
public class StatAppMonitor {
    public static final int FAILURE_RESULT_TYPE = 1;
    public static final int LOGIC_FAILURE_RESULT_TYPE = 2;
    public static final int SUCCESS_RESULT_TYPE = 0;
    private String interfaceName = null;
    private long millisecondsConsume = 0;
    private long reqSize = 0;
    private long respSize = 0;
    private int resultType = 0;
    private int returnCode = 0;
    private int sampling = 1;

    public StatAppMonitor(String str) {
        this.interfaceName = str;
    }

    public StatAppMonitor(String str, int i, int i2, long j, long j2, long j3, int i3) {
        this.interfaceName = str;
        this.reqSize = j;
        this.respSize = j2;
        this.resultType = i;
        this.millisecondsConsume = j3;
        this.returnCode = i2;
        this.sampling = i3;
    }

    public String getInterfaceName() {
        return this.interfaceName;
    }

    public long getMillisecondsConsume() {
        return this.millisecondsConsume;
    }

    public long getReqSize() {
        return this.reqSize;
    }

    public long getRespSize() {
        return this.respSize;
    }

    public int getResultType() {
        return this.resultType;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public int getSampling() {
        return this.sampling;
    }

    public void setInterfaceName(String str) {
        this.interfaceName = str;
    }

    public void setMillisecondsConsume(long j) {
        this.millisecondsConsume = j;
    }

    public void setReqSize(long j) {
        this.reqSize = j;
    }

    public void setRespSize(long j) {
        this.respSize = j;
    }

    public void setResultType(int i) {
        this.resultType = i;
    }

    public void setReturnCode(int i) {
        this.returnCode = i;
    }

    public void setSampling(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.sampling = i;
    }
}
