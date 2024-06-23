package com.taobao.weex.ui.animation;

import android.os.Build;
import android.util.Property;
import android.view.View;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class CameraDistanceProperty extends Property<View, Float> {
    private static final String TAG = "CameraDistance";
    private static CameraDistanceProperty instance;

    private CameraDistanceProperty() {
        super(Float.class, TAG);
    }

    static Property<View, Float> getInstance() {
        return instance;
    }

    public Float get(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Float.valueOf(view.getCameraDistance());
        }
        return Float.valueOf(Float.NaN);
    }

    public void set(View view, Float f) {
        view.setCameraDistance(f.floatValue());
    }
}
