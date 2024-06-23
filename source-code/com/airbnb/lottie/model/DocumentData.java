package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* compiled from: Taobao */
public class DocumentData {
    public final String a;
    public final String b;
    public final float c;
    public final Justification d;
    public final int e;
    public final float f;
    public final float g;
    @ColorInt
    public final int h;
    @ColorInt
    public final int i;
    public final float j;
    public final boolean k;

    /* compiled from: Taobao */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f2, Justification justification, int i2, float f3, float f4, @ColorInt int i3, @ColorInt int i4, float f5, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = f2;
        this.d = justification;
        this.e = i2;
        this.f = f3;
        this.g = f4;
        this.h = i3;
        this.i = i4;
        this.j = f5;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) (((float) (((this.a.hashCode() * 31) + this.b.hashCode()) * 31)) + this.c)) * 31) + this.d.ordinal()) * 31) + this.e;
        long floatToRawIntBits = (long) Float.floatToRawIntBits(this.f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.h;
    }
}
