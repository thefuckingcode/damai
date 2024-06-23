package com.youku.css.dto;

import java.io.Serializable;

/* compiled from: Taobao */
public class Gradient implements Serializable {
    public String endColor;
    public String startColor;

    @Override // java.lang.Object
    public Gradient clone() {
        Gradient gradient = new Gradient();
        gradient.startColor = this.startColor;
        gradient.endColor = this.endColor;
        return gradient;
    }
}
