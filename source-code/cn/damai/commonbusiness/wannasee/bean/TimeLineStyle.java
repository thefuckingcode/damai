package cn.damai.commonbusiness.wannasee.bean;

import java.io.Serializable;

/* compiled from: Taobao */
public class TimeLineStyle implements Serializable {
    public boolean isFirst;
    public String title;

    public TimeLineStyle(boolean z, String str) {
        this.isFirst = z;
        this.title = str;
    }
}
