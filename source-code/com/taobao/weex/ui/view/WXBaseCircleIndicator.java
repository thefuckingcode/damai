package com.taobao.weex.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: Taobao */
public class WXBaseCircleIndicator extends FrameLayout implements WXGestureObservable {
    private float circlePadding;
    private int fillColor = -12303292;
    private WXCircleViewPager mCircleViewPager;
    private ViewPager.OnPageChangeListener mListener;
    private final Paint mPaintFill = new Paint();
    private final Paint mPaintPage = new Paint();
    private int pageColor = -3355444;
    private float radius;
    private int realCurrentItem;
    private WXGesture wxGesture;

    public WXBaseCircleIndicator(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.radius = (float) WXViewUtils.dip2px(5.0f);
        this.circlePadding = (float) WXViewUtils.dip2px(5.0f);
        this.pageColor = -3355444;
        this.fillColor = -12303292;
        this.mPaintFill.setStyle(Paint.Style.FILL);
        this.mPaintFill.setAntiAlias(true);
        this.mPaintPage.setAntiAlias(true);
        this.mPaintPage.setColor(this.pageColor);
        this.mPaintFill.setStyle(Paint.Style.FILL);
        this.mPaintFill.setColor(this.fillColor);
        setWillNotDraw(false);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? dispatchTouchEvent | wXGesture.onTouch(this, motionEvent) : dispatchTouchEvent;
    }

    public int getCount() {
        WXCircleViewPager wXCircleViewPager = this.mCircleViewPager;
        if (wXCircleViewPager == null || wXCircleViewPager.getAdapter() == null) {
            return 0;
        }
        return this.mCircleViewPager.getRealCount();
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.wxGesture;
    }

    public int getRealCurrentItem() {
        return this.realCurrentItem;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (this.circlePadding + this.radius) * 2.0f;
        float width = ((float) (getWidth() / 2)) - ((((float) (getCount() - 1)) * f) / 2.0f);
        float height = (float) ((getHeight() / 2) + getPaddingTop());
        for (int i = 0; i < getCount(); i++) {
            float f2 = (((float) i) * f) + width;
            if (i != this.realCurrentItem) {
                canvas.drawCircle(f2, height, this.radius, this.mPaintPage);
            } else {
                canvas.drawCircle(f2, height, this.radius, this.mPaintFill);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = ((int) (((float) getPaddingLeft()) + (this.radius * 2.0f * ((float) getCount())) + (this.circlePadding * ((float) (getCount() - 1))) + ((float) getPaddingRight()))) + 1;
        }
        if (mode2 != 1073741824) {
            size2 = ((int) (((float) getPaddingTop()) + (this.radius * 2.0f) + ((float) getPaddingBottom()))) + 1;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    public void setCircleViewPager(WXCircleViewPager wXCircleViewPager) {
        this.mCircleViewPager = wXCircleViewPager;
        if (wXCircleViewPager != null) {
            if (this.mListener == null) {
                this.mListener = new ViewPager.SimpleOnPageChangeListener() {
                    /* class com.taobao.weex.ui.view.WXBaseCircleIndicator.AnonymousClass1 */

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener, androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener
                    public void onPageSelected(int i) {
                        WXBaseCircleIndicator wXBaseCircleIndicator = WXBaseCircleIndicator.this;
                        wXBaseCircleIndicator.realCurrentItem = wXBaseCircleIndicator.mCircleViewPager.getRealCurrentItem();
                        WXBaseCircleIndicator.this.invalidate();
                    }
                };
            }
            this.mCircleViewPager.addOnPageChangeListener(this.mListener);
            int realCurrentItem2 = this.mCircleViewPager.getRealCurrentItem();
            this.realCurrentItem = realCurrentItem2;
            if (realCurrentItem2 < 0) {
                this.realCurrentItem = 0;
            }
        }
        requestLayout();
    }

    public void setFillColor(int i) {
        this.fillColor = i;
        this.mPaintFill.setColor(i);
    }

    public void setPageColor(int i) {
        this.pageColor = i;
        this.mPaintPage.setColor(i);
    }

    public void setRadius(float f) {
        this.radius = f;
    }

    public void setRealCurrentItem(int i) {
        this.realCurrentItem = i;
        invalidate();
    }

    public WXBaseCircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
