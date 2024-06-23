package cn.damai.tetris.component.drama.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class FilterMainBean implements Serializable {
    public int id;
    public boolean isSelected = false;
    public List<FilterTagBean> labels;
    public String name;

    public FilterMainBean() {
    }

    public FilterMainBean(String str, boolean z) {
        this.name = str;
        this.isSelected = z;
    }

    public FilterMainBean(int i, String str, boolean z) {
        this.id = i;
        this.name = str;
        this.isSelected = z;
    }
}
