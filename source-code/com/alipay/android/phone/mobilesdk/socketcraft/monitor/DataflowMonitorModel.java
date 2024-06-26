package com.alipay.android.phone.mobilesdk.socketcraft.monitor;

/* compiled from: Taobao */
public class DataflowMonitorModel {
    public static final String METHOD_NAME_CLOSE = "close";
    public static final String METHOD_NAME_CONNECTION = "connect";
    public static final String METHOD_NAME_RECEIVE = "receive";
    public static final String METHOD_NAME_SEND = "send";
    public String methodName;
    public String ownerId;
    public int receiveSize = 0;
    public int sendSize = 0;
    public String url;

    public DataflowMonitorModel(String str, String str2, String str3, int i, int i2) {
        this.url = str;
        this.ownerId = str2;
        this.methodName = str3;
        this.sendSize = i;
        this.receiveSize = i2;
    }

    public String toString() {
        return "DataflowMonitorModel{url='" + this.url + '\'' + ", ownerId=" + this.ownerId + ", methodName=" + this.methodName + ", sendSize=" + this.sendSize + ", receiveSize=" + this.receiveSize + '}';
    }
}
