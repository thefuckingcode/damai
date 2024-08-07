package com.real.android.nativehtml.common.layout;

/* compiled from: Taobao */
public interface Layout {

    /* compiled from: Taobao */
    public enum Directive {
        MINIMUM,
        FIT_CONTENT,
        STRETCH
    }

    float layout(ComponentElement componentElement, float f, float f2, float f3, boolean z);

    float measureWidth(ComponentElement componentElement, Directive directive, float f);
}
