package com.alibaba.android.vlayout.layout;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import tb.zi0;

/* compiled from: Taobao */
public abstract class FixAreaLayoutHelper extends BaseLayoutHelper {
    protected zi0 a = zi0.mDefaultAdjuster;

    /* compiled from: Taobao */
    public interface FixViewAnimatorHelper {
        ViewPropertyAnimator onGetFixViewAppearAnimator(View view);

        ViewPropertyAnimator onGetFixViewDisappearAnimator(View view);
    }

    public void a(zi0 zi0) {
        this.a = zi0;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public void adjustLayout(int i, int i2, LayoutManagerHelper layoutManagerHelper) {
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeMarginEnd(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        return 0;
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeMarginStart(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        return 0;
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computePaddingEnd(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        return 0;
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computePaddingStart(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        return 0;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.a
    public boolean isFixLayout() {
        return true;
    }
}
