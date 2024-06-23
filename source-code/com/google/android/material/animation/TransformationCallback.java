package com.google.android.material.animation;

import android.view.View;

/* compiled from: Taobao */
public interface TransformationCallback<T extends View> {
    void onScaleChanged(T t);

    void onTranslationChanged(T t);
}
