package com.youku.live.dago.liveplayback.widget.plugins.dmmulti;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class YKGridViewWrapper implements Serializable {
    public String api;
    public Data data;
    public List<String> ret;
    public String v;

    /* compiled from: Taobao */
    public static class Data implements Serializable {
        public GridViewBean data;
        public String msg;
        public int status;
    }
}
