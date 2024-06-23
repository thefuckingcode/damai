package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.youku.resource.R;

/* compiled from: Taobao */
public class ParallaxImageView extends YKImageView {
    private boolean DEFAULT_CENTER_CROP = true;
    private final float DEFAULT_PARALLAX_RATIO = 1.0f;
    private ParallaxImageListener listener;
    private boolean needToTranslate = true;
    private float parallaxRatio = 1.0f;
    private int recyclerViewHeight = -1;
    private int recyclerViewYPos = -1;
    private int rowHeight = -1;
    private int rowYPos = -1;
    private boolean shouldCenterCrop = true;

    /* compiled from: Taobao */
    public interface ParallaxImageListener {
        int[] requireValuesForTranslate();
    }

    public ParallaxImageView(Context context) {
        super(context);
        init(context, null);
    }

    private void calculateAndMove() {
        float f;
        float f2 = (float) (((this.recyclerViewYPos + this.recyclerViewHeight) / 2) - this.rowYPos);
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        if (this.shouldCenterCrop) {
            f = recomputeImageMatrix();
            intrinsicHeight = (int) (((float) intrinsicHeight) * f);
        } else {
            f = 1.0f;
        }
        float f3 = (float) (intrinsicHeight - this.rowHeight);
        moveTo(((((f2 / ((float) this.recyclerViewHeight)) * f3) * this.parallaxRatio) / 2.0f) - (f3 / 2.0f), f);
    }

    private boolean ensureTranslate() {
        if (this.needToTranslate) {
            this.needToTranslate = !doTranslate();
        }
        return !this.needToTranslate;
    }

    private boolean getValues() {
        int[] requireValuesForTranslate = getListener().requireValuesForTranslate();
        if (requireValuesForTranslate == null) {
            return false;
        }
        this.rowHeight = requireValuesForTranslate[0];
        this.rowYPos = requireValuesForTranslate[1];
        this.recyclerViewHeight = requireValuesForTranslate[2];
        this.recyclerViewYPos = requireValuesForTranslate[3];
        return true;
    }

    private void init(Context context, AttributeSet attributeSet) {
        setScaleType(ImageView.ScaleType.MATRIX);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ParallaxImageView, 0, 0);
            this.parallaxRatio = obtainStyledAttributes.getFloat(R.styleable.ParallaxImageView_parallax_ratio, 1.0f);
            this.shouldCenterCrop = obtainStyledAttributes.getBoolean(R.styleable.ParallaxImageView_center_crop, this.DEFAULT_CENTER_CROP);
            obtainStyledAttributes.recycle();
        }
    }

    private void moveTo(float f, float f2) {
        Matrix imageMatrix = getImageMatrix();
        if (f2 != 1.0f) {
            imageMatrix.setScale(f2, f2);
        }
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        imageMatrix.postTranslate(0.0f, f - fArr[5]);
        setImageMatrix(imageMatrix);
        invalidate();
    }

    private float recomputeImageMatrix() {
        float f;
        float f2;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        if (intrinsicWidth * height > intrinsicHeight * width) {
            f2 = (float) height;
            f = (float) intrinsicHeight;
        } else {
            f2 = (float) width;
            f = (float) intrinsicWidth;
        }
        return f2 / f;
    }

    public void centerCrop(boolean z) {
        this.shouldCenterCrop = z;
    }

    public synchronized boolean doTranslate() {
        if (getDrawable() == null) {
            return false;
        }
        if (getListener() == null || !getValues()) {
            return false;
        }
        calculateAndMove();
        return true;
    }

    public ParallaxImageListener getListener() {
        return this.listener;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.uikit.feature.view.TImageView
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ensureTranslate();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.resource.widget.YKRatioImageView, com.taobao.uikit.feature.view.TImageView, com.youku.resource.widget.YKImageView
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ensureTranslate();
    }

    public void reuse() {
        this.needToTranslate = true;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        ensureTranslate();
    }

    @Override // com.youku.resource.widget.YKRatioImageView, com.taobao.uikit.extend.feature.view.TUrlImageView, com.taobao.uikit.feature.view.TImageView, com.youku.resource.widget.YKImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        ensureTranslate();
    }

    @Override // com.taobao.uikit.feature.view.TImageView, com.youku.resource.widget.YKImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        ensureTranslate();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        ensureTranslate();
    }

    public void setListener(ParallaxImageListener parallaxImageListener) {
        this.listener = parallaxImageListener;
    }

    public void setParallaxRatio(float f) {
        this.parallaxRatio = f;
    }

    public ParallaxImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }
}
