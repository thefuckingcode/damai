package com.taobao.update.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.taobao.tao.update.common.R$id;
import tb.bu2;
import tb.o70;

/* compiled from: Taobao */
public abstract class Button extends CustomView {
    static final String ANDROIDXML = "http://schemas.android.com/apk/res/android";
    int background;
    int backgroundColor = Color.parseColor("#1E88E5");
    boolean clickAfterRipple = true;
    int minHeight;
    int minWidth;
    View.OnClickListener onClickListener;
    float radius = -1.0f;
    Integer rippleColor;
    int rippleSize = 3;
    float rippleSpeed = 12.0f;
    TextView textButton;
    float x = -1.0f;
    float y = -1.0f;

    public Button(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDefaultProperties();
        this.clickAfterRipple = attributeSet.getAttributeBooleanValue(o70.RES_AUTO_NAMESPACE, "animate", true);
        setAttributes(attributeSet);
        this.beforeBackground = this.backgroundColor;
        if (this.rippleColor == null) {
            this.rippleColor = Integer.valueOf(makePressColor());
        }
    }

    public float getRippleSpeed() {
        return this.rippleSpeed;
    }

    public String getText() {
        return this.textButton.getText().toString();
    }

    public TextView getTextView() {
        return this.textButton;
    }

    public Bitmap makeCircle() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth() - bu2.dpToPx(6.0f, getResources()), getHeight() - bu2.dpToPx(7.0f, getResources()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.rippleColor.intValue());
        canvas.drawCircle(this.x, this.y, this.radius, paint);
        if (this.radius > ((float) (getHeight() / this.rippleSize))) {
            this.radius += this.rippleSpeed;
        }
        if (this.radius >= ((float) getWidth())) {
            this.x = -1.0f;
            this.y = -1.0f;
            this.radius = (float) (getHeight() / this.rippleSize);
            View.OnClickListener onClickListener2 = this.onClickListener;
            if (onClickListener2 != null && this.clickAfterRipple) {
                onClickListener2.onClick(this);
            }
        }
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public int makePressColor() {
        int i = this.backgroundColor;
        int i2 = (i >> 8) & 255;
        int i3 = 0;
        int i4 = (i >> 0) & 255;
        int i5 = ((i >> 16) & 255) - 30;
        if (i5 < 0) {
            i5 = 0;
        }
        int i6 = i2 - 30;
        if (i6 < 0) {
            i6 = 0;
        }
        int i7 = i4 - 30;
        if (i7 >= 0) {
            i3 = i7;
        }
        return Color.rgb(i5, i6, i3);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (!z) {
            this.x = -1.0f;
            this.y = -1.0f;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener2;
        invalidate();
        if (isEnabled()) {
            this.isLastTouch = true;
            if (motionEvent.getAction() == 0) {
                this.radius = (float) (getHeight() / this.rippleSize);
                this.x = motionEvent.getX();
                this.y = motionEvent.getY();
            } else if (motionEvent.getAction() == 2) {
                this.radius = (float) (getHeight() / this.rippleSize);
                this.x = motionEvent.getX();
                this.y = motionEvent.getY();
                if (motionEvent.getX() > ((float) getWidth()) || motionEvent.getX() < 0.0f || motionEvent.getY() > ((float) getHeight()) || motionEvent.getY() < 0.0f) {
                    this.isLastTouch = false;
                    this.x = -1.0f;
                    this.y = -1.0f;
                }
            } else if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() > ((float) getWidth()) || motionEvent.getX() < 0.0f || motionEvent.getY() > ((float) getHeight()) || motionEvent.getY() < 0.0f) {
                    this.isLastTouch = false;
                    this.x = -1.0f;
                    this.y = -1.0f;
                } else {
                    this.radius += 1.0f;
                    if (!this.clickAfterRipple && (onClickListener2 = this.onClickListener) != null) {
                        onClickListener2.onClick(this);
                    }
                }
            } else if (motionEvent.getAction() == 3) {
                this.isLastTouch = false;
                this.x = -1.0f;
                this.y = -1.0f;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract void setAttributes(AttributeSet attributeSet);

    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
        if (isEnabled()) {
            this.beforeBackground = this.backgroundColor;
        }
        try {
            ((GradientDrawable) ((LayerDrawable) getBackground()).findDrawableByLayerId(R$id.shape_bacground)).setColor(this.backgroundColor);
            this.rippleColor = Integer.valueOf(makePressColor());
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void setDefaultProperties() {
        setMinimumHeight(bu2.dpToPx((float) this.minHeight, getResources()));
        setMinimumWidth(bu2.dpToPx((float) this.minWidth, getResources()));
        setBackgroundResource(this.background);
        setBackgroundColor(this.backgroundColor);
    }

    public void setOnClickListener(View.OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
    }

    public void setRippleSpeed(float f) {
        this.rippleSpeed = f;
    }

    public void setText(String str) {
        this.textButton.setText(str);
    }

    public void setTextColor(int i) {
        this.textButton.setTextColor(i);
    }
}
