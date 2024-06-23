package com.google.android.material.slider;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: Taobao */
public interface BaseOnSliderTouchListener<S> {
    void onStartTrackingTouch(@NonNull S s);

    void onStopTrackingTouch(@NonNull S s);
}
