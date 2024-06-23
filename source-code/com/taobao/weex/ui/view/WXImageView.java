package com.taobao.weex.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.weex.ui.component.WXImage;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import com.taobao.weex.utils.ImageDrawable;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;

@SuppressLint({"AppCompatCustomView"})
/* compiled from: Taobao */
public class WXImageView extends ImageView implements WXGestureObservable, IRenderStatus<WXImage>, IRenderResult<WXImage>, WXImage.Measurable {
    private float[] borderRadius;
    private boolean enableBitmapAutoManage = true;
    private boolean gif;
    private boolean isBitmapReleased = false;
    private boolean mOutWindowVisibilityChangedReally;
    private WeakReference<WXImage> mWeakReference;
    private WXGesture wxGesture;

    public WXImageView(Context context) {
        super(context);
    }

    public void autoRecoverImage() {
        if (this.enableBitmapAutoManage && this.isBitmapReleased) {
            WXImage component = getComponent();
            if (component != null) {
                component.autoRecoverImage();
            }
            this.isBitmapReleased = false;
        }
    }

    public void autoReleaseImage() {
        if (this.enableBitmapAutoManage && !this.isBitmapReleased) {
            this.isBitmapReleased = true;
            WXImage component = getComponent();
            if (component != null) {
                component.autoReleaseImage();
            }
        }
    }

    public void dispatchWindowVisibilityChanged(int i) {
        this.mOutWindowVisibilityChangedReally = true;
        super.dispatchWindowVisibilityChanged(i);
        this.mOutWindowVisibilityChangedReally = false;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // com.taobao.weex.ui.component.WXImage.Measurable
    public int getNaturalHeight() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return -1;
        }
        if (drawable instanceof ImageDrawable) {
            return ((ImageDrawable) drawable).getBitmapHeight();
        }
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap != null) {
                return bitmap.getHeight();
            }
            WXLogUtils.w("WXImageView", "Bitmap on " + drawable.toString() + " is null");
            return -1;
        }
        WXLogUtils.w("WXImageView", "Not supported drawable type: " + drawable.getClass().getSimpleName());
        return -1;
    }

    @Override // com.taobao.weex.ui.component.WXImage.Measurable
    public int getNaturalWidth() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return -1;
        }
        if (drawable instanceof ImageDrawable) {
            return ((ImageDrawable) drawable).getBitmapWidth();
        }
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap != null) {
                return bitmap.getWidth();
            }
            WXLogUtils.w("WXImageView", "Bitmap on " + drawable.toString() + " is null");
            return -1;
        }
        WXLogUtils.w("WXImageView", "Not supported drawable type: " + drawable.getClass().getSimpleName());
        return -1;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        autoRecoverImage();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        autoReleaseImage();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        autoRecoverImage();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            setImageDrawable(getDrawable(), this.gif);
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        autoReleaseImage();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? onTouchEvent | wXGesture.onTouch(this, motionEvent) : onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.mOutWindowVisibilityChangedReally) {
            return;
        }
        if (i == 0) {
            autoRecoverImage();
        } else {
            autoReleaseImage();
        }
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    public void setBorderRadius(@NonNull float[] fArr) {
        this.borderRadius = fArr;
    }

    public void setEnableBitmapAutoManage(boolean z) {
        this.enableBitmapAutoManage = z;
    }

    public void setImageBitmap(@Nullable Bitmap bitmap) {
        setImageDrawable(bitmap == null ? null : new BitmapDrawable(getResources(), bitmap));
    }

    public void setImageDrawable(@Nullable Drawable drawable, boolean z) {
        WXImage wXImage;
        this.gif = z;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            Drawable createImageDrawable = ImageDrawable.createImageDrawable(drawable, getScaleType(), this.borderRadius, (layoutParams.width - getPaddingLeft()) - getPaddingRight(), (layoutParams.height - getPaddingTop()) - getPaddingBottom(), z);
            if (createImageDrawable instanceof ImageDrawable) {
                ImageDrawable imageDrawable = (ImageDrawable) createImageDrawable;
                if (!Arrays.equals(imageDrawable.getCornerRadii(), this.borderRadius)) {
                    imageDrawable.setCornerRadii(this.borderRadius);
                }
            }
            super.setImageDrawable(createImageDrawable);
            WeakReference<WXImage> weakReference = this.mWeakReference;
            if (weakReference != null && (wXImage = weakReference.get()) != null) {
                wXImage.readyToRender();
            }
        }
    }

    public void setImageResource(int i) {
        setImageDrawable(getResources().getDrawable(i));
    }

    @Override // com.taobao.weex.ui.view.IRenderResult
    @Nullable
    public WXImage getComponent() {
        WeakReference<WXImage> weakReference = this.mWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void holdComponent(WXImage wXImage) {
        this.mWeakReference = new WeakReference<>(wXImage);
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        setImageDrawable(drawable, this.gif);
    }
}
