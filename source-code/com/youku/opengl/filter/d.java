package com.youku.opengl.filter;

/* compiled from: Taobao */
public class d extends h {
    protected float d;

    public void a(float f) {
        this.d = f;
        a(new YkGLGaussianBlurFilter$1(this));
    }

    @Override // com.youku.opengl.filter.b
    public void c() {
        super.c();
        a(this.d);
    }

    @Override // com.youku.opengl.filter.h
    public float p() {
        return this.d;
    }

    @Override // com.youku.opengl.filter.h
    public float q() {
        return this.d;
    }
}
