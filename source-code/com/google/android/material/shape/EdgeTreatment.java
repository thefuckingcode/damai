package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
public class EdgeTreatment {
    /* access modifiers changed from: package-private */
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f, float f2, @NonNull ShapePath shapePath) {
        getEdgePath(f, f / 2.0f, f2, shapePath);
    }

    public void getEdgePath(float f, float f2, float f3, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f, 0.0f);
    }
}
