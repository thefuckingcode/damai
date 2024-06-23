package com.youku.css.dto;

import java.io.Serializable;

/* compiled from: Taobao */
public class Border implements Serializable {
    public String color;
    public String radius;
    public String width;

    @Override // java.lang.Object
    public Border clone() {
        Border border = new Border();
        border.width = this.width;
        border.color = this.color;
        border.radius = this.radius;
        return border;
    }
}
