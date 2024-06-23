package com.taobao.update.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taobao.tao.update.common.R$drawable;
import tb.bu2;

/* compiled from: Taobao */
public class ButtonFlat extends Button {
    TextView textButton;

    public ButtonFlat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.taobao.update.dialog.Button
    public String getText() {
        return this.textButton.getText().toString();
    }

    @Override // com.taobao.update.dialog.Button
    public TextView getTextView() {
        return this.textButton;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.update.dialog.Button
    public int makePressColor() {
        return Color.parseColor("#88DDDDDD");
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.update.dialog.CustomView
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.x != -1.0f) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(makePressColor());
            canvas.drawCircle(this.x, this.y, this.radius, paint);
            if (this.radius > ((float) (getHeight() / this.rippleSize))) {
                this.radius += this.rippleSpeed;
            }
            if (this.radius >= ((float) getWidth())) {
                this.x = -1.0f;
                this.y = -1.0f;
                this.radius = (float) (getHeight() / this.rippleSize);
                View.OnClickListener onClickListener = this.onClickListener;
                if (onClickListener != null && this.clickAfterRipple) {
                    onClickListener.onClick(this);
                }
            }
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.update.dialog.Button
    public void setAttributes(AttributeSet attributeSet) {
        String str;
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "text", -1);
        if (attributeResourceValue != -1) {
            str = getResources().getString(attributeResourceValue);
        } else {
            str = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        }
        if (str != null) {
            TextView textView = new TextView(getContext());
            this.textButton = textView;
            textView.setText(str.toUpperCase());
            this.textButton.setTextColor(this.backgroundColor);
            this.textButton.setTypeface(null, 1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            this.textButton.setLayoutParams(layoutParams);
            addView(this.textButton);
        }
        int attributeResourceValue2 = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", -1);
        if (attributeResourceValue2 != -1) {
            setBackgroundColor(getResources().getColor(attributeResourceValue2));
            return;
        }
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "background", -1);
        this.background = attributeIntValue;
        if (attributeIntValue != -1) {
            setBackgroundColor(attributeIntValue);
        }
    }

    @Override // com.taobao.update.dialog.Button
    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
        if (isEnabled()) {
            this.beforeBackground = this.backgroundColor;
        }
        this.textButton.setTextColor(i);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.update.dialog.Button
    public void setDefaultProperties() {
        this.minHeight = 36;
        this.minWidth = 88;
        this.rippleSize = 3;
        setMinimumHeight(bu2.dpToPx((float) 36, getResources()));
        setMinimumWidth(bu2.dpToPx((float) this.minWidth, getResources()));
        setBackgroundResource(R$drawable.background_transparent);
    }

    @Override // com.taobao.update.dialog.Button
    public void setText(String str) {
        this.textButton.setText(str.toUpperCase());
    }
}
