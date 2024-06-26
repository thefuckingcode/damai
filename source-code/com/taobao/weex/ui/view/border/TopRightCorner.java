package com.taobao.weex.ui.view.border;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class TopRightCorner extends BorderCorner {
    TopRightCorner() {
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.view.border.BorderCorner
    public void prepareOval() {
        if (hasInnerCorner()) {
            setOvalLeft(getBorderBox().width() - ((getOuterCornerRadius() * 2.0f) - (getPostBorderWidth() / 2.0f)));
            setOvalTop(getPreBorderWidth() / 2.0f);
            setOvalRight(getBorderBox().width() - (getPostBorderWidth() / 2.0f));
            setOvalBottom((getOuterCornerRadius() * 2.0f) - (getPreBorderWidth() / 2.0f));
            return;
        }
        setOvalLeft(getBorderBox().width() - (getOuterCornerRadius() * 1.5f));
        setOvalTop(getOuterCornerRadius() / 2.0f);
        setOvalRight(getBorderBox().width() - (getOuterCornerRadius() / 2.0f));
        setOvalBottom(getOuterCornerRadius() * 1.5f);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.view.border.BorderCorner
    public void prepareRoundCorner() {
        if (hasOuterCorner()) {
            setRoundCornerStartX(getBorderBox().width() - getOuterCornerRadius());
            setRoundCornerStartY(getPreBorderWidth() / 2.0f);
            setRoundCornerEndX(getBorderBox().width() - (getPostBorderWidth() / 2.0f));
            setRoundCornerEndY(getOuterCornerRadius());
            return;
        }
        float width = getBorderBox().width() - (getPostBorderWidth() / 2.0f);
        float preBorderWidth = getPreBorderWidth() / 2.0f;
        setRoundCornerStartX(width);
        setRoundCornerStartY(preBorderWidth);
        setRoundCornerEndX(width);
        setRoundCornerEndY(preBorderWidth);
    }

    /* access modifiers changed from: package-private */
    public void set(float f, float f2, float f3, @NonNull RectF rectF) {
        set(f, f2, f3, rectF, 315.0f);
    }
}
