package com.taobao.weex.ui.flat;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.taobao.weex.ui.flat.widget.Widget;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* compiled from: Taobao */
public interface FlatComponent<T extends Widget> {
    @NonNull
    T getOrCreateFlatWidget();

    boolean promoteToView(boolean z);
}
