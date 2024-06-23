package com.google.android.material.timepicker;

import androidx.annotation.IntRange;
import androidx.annotation.StringRes;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
interface TimePickerControls {

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface ActiveSelection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface ClockPeriod {
    }

    void setActiveSelection(int i);

    void setHandRotation(float f);

    void setValues(String[] strArr, @StringRes int i);

    void updateTime(int i, int i2, @IntRange(from = 0) int i3);
}
