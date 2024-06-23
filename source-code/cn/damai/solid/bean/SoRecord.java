package cn.damai.solid.bean;

import java.io.Serializable;

/* compiled from: Taobao */
public class SoRecord implements Serializable {
    public volatile boolean isSkipAppSystemLoad = false;
    public volatile boolean isSystemLoaded = false;
    public final String soLibName;

    public SoRecord(String str) {
        this.soLibName = str;
    }
}
