package com.taobao.weex.ui.view.border;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class TopLeftCorner extends BorderCorner {
    TopLeftCorner() {
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.view.border.BorderCorner
    public void prepareOval() {
        if (hasInnerCorner()) {
            setOvalLeft(getPreBorderWidth() / 2.0f);
            setOvalTop(getPostBorderWidth() / 2.0f);
            setOvalRight((getOuterCornerRadius() * 2.0f) - (getPreBorderWidth() / 2.0f));
            setOvalBottom((getOuterCornerRadius() * 2.0f) - (getPostBorderWidth() / 2.0f));
            return;
        }
        setOvalLeft(getOuterCornerRadius() / 2.0f);
        setOvalTop(getOuterCornerRadius() / 2.0f);
        setOvalRight(getOuterCornerRadius() * 1.5f);
        setOvalBottom(getOuterCornerRadius() * 1.5f);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.view.border.BorderCorner
    public void prepareRoundCorner() {
        if (hasOuterCorner()) {
            setRoundCornerStartX(getPreBorderWidth() / 2.0f);
            setRoundCornerStartY(getOuterCornerRadius());
            setRoundCornerEndX(getOuterCornerRadius());
            setRoundCornerEndY(getPostBorderWidth() / 2.0f);
            return;
        }
        float preBorderWidth = getPreBorderWidth() / 2.0f;
        float postBorderWidth = getPostBorderWidth() / 2.0f;
        setRoundCornerStartX(preBorderWidth);
        setRoundCornerStartY(postBorderWidth);
        setRoundCornerEndX(preBorderWidth);
        setRoundCornerEndY(postBorderWidth);
    }

    /* access modifiers changed from: package-private */
    public void set(float f, float f2, float f3, @NonNull RectF rectF) {
        set(f, f2, f3, rectF, 225.0f);
    }
}
