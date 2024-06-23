package com.baseproject.basecard.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public final class WithMaskImageView extends TUrlImageView {
    private Drawable mCornerDrawable;
    private Set<Drawable> mDrawables = new HashSet(3);
    private Drawable mStripeMiddleDrawable;

    public WithMaskImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void addMask(Drawable drawable) {
        if (drawable != null) {
            this.mDrawables.add(drawable);
        }
    }

    private void removeMask(Drawable drawable) {
        this.mDrawables.remove(drawable);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.uikit.feature.view.TImageView
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mDrawables.isEmpty()) {
            for (Drawable drawable : this.mDrawables) {
                if (drawable != null) {
                    canvas.save();
                    canvas.clipRect(drawable.getBounds());
                    drawable.draw(canvas);
                    canvas.restore();
                }
            }
        }
    }

    public final void removeCornerMask() {
        removeMask(this.mCornerDrawable);
    }

    public final void removeStripeMiddleMask() {
        removeMask(this.mStripeMiddleDrawable);
    }

    public final void setCornerMask(Drawable drawable) {
        removeMask(this.mCornerDrawable);
        this.mCornerDrawable = drawable;
        addMask(drawable);
    }

    public final void setStripeMiddleMask(Drawable drawable) {
        removeMask(this.mStripeMiddleDrawable);
        this.mStripeMiddleDrawable = drawable;
        addMask(drawable);
    }

    public WithMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WithMaskImageView(Context context) {
        super(context);
    }
}
