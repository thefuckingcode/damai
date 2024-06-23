package com.google.android.material.expandable;

import androidx.annotation.IdRes;

/* compiled from: Taobao */
public interface ExpandableTransformationWidget extends ExpandableWidget {
    @IdRes
    int getExpandedComponentIdHint();

    void setExpandedComponentIdHint(@IdRes int i);
}
