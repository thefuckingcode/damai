package com.taobao.weex.dom;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.Enum;
import java.util.Arrays;

/* compiled from: Taobao */
public class CSSShorthand<T extends Enum<? extends CSSProperty>> implements Cloneable {
    private float[] values;

    /* compiled from: Taobao */
    public enum CORNER implements CSSProperty {
        BORDER_TOP_LEFT,
        BORDER_TOP_RIGHT,
        BORDER_BOTTOM_RIGHT,
        BORDER_BOTTOM_LEFT,
        ALL
    }

    /* compiled from: Taobao */
    interface CSSProperty {
    }

    /* compiled from: Taobao */
    public enum EDGE implements CSSProperty {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        ALL
    }

    /* compiled from: Taobao */
    public enum TYPE {
        MARGIN,
        PADDING,
        BORDER
    }

    public CSSShorthand(float[] fArr) {
        replace(fArr);
    }

    private float getInternal(@NonNull Enum<? extends CSSProperty> r2) {
        if (r2 == EDGE.ALL || r2 == CORNER.ALL) {
            return 0.0f;
        }
        return this.values[r2.ordinal()];
    }

    private void setInternal(@NonNull Enum<? extends CSSProperty> r2, float f) {
        if (r2 == EDGE.ALL || r2 == CORNER.ALL) {
            Arrays.fill(this.values, f);
        } else {
            this.values[r2.ordinal()] = f;
        }
    }

    public float get(@NonNull EDGE edge) {
        return getInternal(edge);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void replace(float[] fArr) {
        this.values = fArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void set(@NonNull EDGE edge, float f) {
        setInternal(edge, f);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String toString() {
        return TextUtils.isEmpty(this.values.toString()) ? "" : Arrays.toString(this.values);
    }

    @Override // java.lang.Object
    public CSSShorthand clone() throws CloneNotSupportedException {
        return (CSSShorthand) super.clone();
    }

    public float get(@NonNull CORNER corner) {
        return getInternal(corner);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void set(@NonNull CORNER corner, float f) {
        setInternal(corner, f);
    }

    public CSSShorthand() {
        this(false);
    }

    CSSShorthand(boolean z) {
        float[] fArr = new float[Math.max(EDGE.values().length, CORNER.values().length)];
        this.values = fArr;
        if (z) {
            Arrays.fill(fArr, Float.NaN);
        }
    }
}
