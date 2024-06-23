package android.taobao.windvane.monitor;

/* compiled from: Taobao */
public interface WVErrorMonitorInterface {
    void didOccurJSError(String str, String str2, String str3, String str4);

    void didOccurNativeError(String str, int i, String str2);
}
