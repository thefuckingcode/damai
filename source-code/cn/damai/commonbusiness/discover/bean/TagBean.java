package cn.damai.commonbusiness.discover.bean;

import java.io.Serializable;

/* compiled from: Taobao */
public class TagBean implements Serializable {
    public int tagColor;
    public String tagName;

    public TagBean(String str, int i) {
        this.tagName = str;
        this.tagColor = i;
    }

    public TagBean() {
    }
}
