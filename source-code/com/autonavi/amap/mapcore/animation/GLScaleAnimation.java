package com.autonavi.amap.mapcore.animation;

/* compiled from: Taobao */
public class GLScaleAnimation extends GLAnimation {
    private float mFromX;
    private float mFromY;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    private float mToX;
    private float mToY;

    public GLScaleAnimation(float f, float f2, float f3, float f4) {
        this.mFromX = f;
        this.mToX = f2;
        this.mFromY = f3;
        this.mToY = f4;
    }

    /* access modifiers changed from: protected */
    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f, GLTransformation gLTransformation) {
        float f2;
        float f3 = this.mFromX;
        float f4 = 1.0f;
        if (f3 == 1.0f && this.mToX == 1.0f) {
            f2 = 1.0f;
        } else {
            f2 = f3 + ((this.mToX - f3) * f);
        }
        float f5 = this.mFromY;
        if (!(f5 == 1.0f && this.mToY == 1.0f)) {
            f4 = ((this.mToY - f5) * f) + f5;
        }
        if (this.mPivotX == 0.0f && this.mPivotY == 0.0f) {
            gLTransformation.scaleX = (double) f2;
            gLTransformation.scaleY = (double) f4;
            return;
        }
        gLTransformation.scaleX = (double) f2;
        gLTransformation.scaleY = (double) f4;
    }
}
