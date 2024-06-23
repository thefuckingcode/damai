package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.List;
import tb.pa1;
import tb.z51;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* compiled from: Taobao */
public interface KeyPathElement {
    <T> void addValueCallback(T t, @Nullable pa1<T> pa1);

    void resolveKeyPath(z51 z51, int i, List<z51> list, z51 z512);
}
