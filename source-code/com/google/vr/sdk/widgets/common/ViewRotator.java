package com.google.vr.sdk.widgets.common;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ViewRotator {
    private int currentViewOrientation90Inc;
    private final int initialRotationDegrees;
    private OrientationEventListener orientationEventListener;
    private int originalViewHeight;
    private int originalViewWidth;
    private final View view;

    public ViewRotator(Context context, View view2, int i, final boolean z) {
        if (isViewProperlyConfigured(view2)) {
            if (i < 180) {
                this.initialRotationDegrees = i;
            } else {
                this.initialRotationDegrees = i - 180;
            }
            this.view = view2;
            this.orientationEventListener = new OrientationEventListener(context) {
                /* class com.google.vr.sdk.widgets.common.ViewRotator.AnonymousClass1 */

                public void onOrientationChanged(int i) {
                    if (z && i != -1) {
                        int i2 = i + ViewRotator.this.initialRotationDegrees;
                        if (i2 > 180) {
                            i2 -= 360;
                        }
                        int i3 = i2 - ViewRotator.this.currentViewOrientation90Inc;
                        if (i3 > 180) {
                            i3 = 360 - i3;
                        }
                        if (i3 < -180) {
                            i3 += 360;
                        }
                        if (Math.abs(i3) > 70) {
                            ViewRotator.this.rotateView(i2);
                        }
                    }
                }
            };
            return;
        }
        throw new IllegalArgumentException("View should have MATCH_PARENT layout and no translation.");
    }

    static int getNearestOrientationWith90Inc(int i) {
        return (int) (((double) Math.signum((float) i)) * ((double) Math.round(((double) Math.abs(i)) / 90.0d)) * 90.0d);
    }

    private static boolean isViewProperlyConfigured(View view2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if ((layoutParams == null || (layoutParams.height == -1 && layoutParams.width == -1)) && view2.getTranslationX() == 0.0f && view2.getTranslationY() == 0.0f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void rotateView(int i) {
        if (this.view.getParent() != null) {
            if (this.originalViewWidth == 0 || this.originalViewHeight == 0) {
                this.originalViewWidth = this.view.getWidth();
                int height = this.view.getHeight();
                this.originalViewHeight = height;
                if (this.originalViewWidth == 0 || height == 0) {
                    return;
                }
            }
            int nearestOrientationWith90Inc = getNearestOrientationWith90Inc(i);
            this.currentViewOrientation90Inc = nearestOrientationWith90Inc;
            this.view.setRotation((float) (-nearestOrientationWith90Inc));
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (this.currentViewOrientation90Inc % 180 != 0) {
                int i2 = this.originalViewWidth;
                layoutParams.height = i2;
                int i3 = this.originalViewHeight;
                layoutParams.width = i3;
                this.view.setTranslationX((float) ((i2 - i3) / 2));
                this.view.setTranslationY((float) ((this.originalViewHeight - this.originalViewWidth) / 2));
            } else {
                layoutParams.height = this.originalViewHeight;
                layoutParams.width = this.originalViewWidth;
                this.view.setTranslationY(0.0f);
                this.view.setTranslationX(0.0f);
            }
            this.view.requestLayout();
        }
    }

    public void disable() {
        this.orientationEventListener.disable();
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        this.view.setTranslationY(0.0f);
        this.view.setTranslationX(0.0f);
        this.view.setRotation(0.0f);
        this.originalViewWidth = 0;
        this.originalViewHeight = 0;
    }

    public void enable() {
        this.orientationEventListener.enable();
    }
}
