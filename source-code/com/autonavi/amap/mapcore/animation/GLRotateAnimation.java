package com.autonavi.amap.mapcore.animation;

/* compiled from: Taobao */
public class GLRotateAnimation extends GLAnimation {
    private float mFromDegrees = 0.0f;
    private float mToDegrees = 1.0f;

    public GLRotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.mFromDegrees = f;
        this.mToDegrees = f2;
    }

    /* access modifiers changed from: protected */
    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f, GLTransformation gLTransformation) {
        float f2 = this.mFromDegrees;
        gLTransformation.rotate = (double) (f2 + ((this.mToDegrees - f2) * f));
    }
}
