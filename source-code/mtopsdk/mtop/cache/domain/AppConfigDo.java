package mtopsdk.mtop.cache.domain;

import java.io.Serializable;

/* compiled from: Taobao */
public class AppConfigDo implements Serializable {
    public String appConf;
    public long appConfigVersion;

    public AppConfigDo(String str, long j) {
        this.appConf = str;
        this.appConfigVersion = j;
    }
}
