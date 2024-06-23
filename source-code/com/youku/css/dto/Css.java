package com.youku.css.dto;

import java.io.Serializable;

/* compiled from: Taobao */
public class Css implements Serializable {
    public String backgroundColor;
    public Border border;
    public String color;
    public Gradient gradient;

    @Override // java.lang.Object
    public Css clone() {
        Css css = new Css();
        css.color = this.color;
        css.backgroundColor = this.backgroundColor;
        Border border2 = this.border;
        if (border2 != null) {
            css.border = border2.clone();
        }
        Gradient gradient2 = this.gradient;
        if (gradient2 != null) {
            css.gradient = gradient2.clone();
        }
        return css;
    }
}
