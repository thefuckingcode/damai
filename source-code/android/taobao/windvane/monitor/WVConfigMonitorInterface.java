package android.taobao.windvane.monitor;

/* compiled from: Taobao */
public interface WVConfigMonitorInterface {
    void didOccurUpdateConfigError(String str, int i, String str2);

    void didOccurUpdateConfigSuccess(String str);

    void didUpdateConfig(String str, int i, long j, int i2, int i3);
}
