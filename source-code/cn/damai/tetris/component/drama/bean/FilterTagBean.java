package cn.damai.tetris.component.drama.bean;

import java.io.Serializable;

/* compiled from: Taobao */
public class FilterTagBean implements Serializable {
    public String groupId;
    public boolean isSelected = false;
    public String name;

    public FilterTagBean(String str) {
        this.name = str;
    }

    public FilterTagBean() {
    }
}
