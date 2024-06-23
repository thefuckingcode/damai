package com.alibaba.verificationsdk.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: Taobao */
public class ALiLoadingView extends View {
    private final int ROTATE_STEP = 10;
    private boolean mClockwise = true;
    private Context mContext;
    private Bitmap mForeBitmap;
    private int mHeight;
    private boolean mIsAnimation;
    private Matrix mMatrix = new Matrix();
    private PaintFlagsDrawFilter mPaintFlagsDrawFilter;
    private int mType = 0;
    private int mWidth;
    private int rotate;

    public ALiLoadingView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private int getResID() {
        int i = this.mType;
        if (i == 0) {
            return getResources().getIdentifier("ali_vsdk_shadu_icon_dengdai", "drawable", this.mContext.getPackageName());
        }
        if (i != 1) {
            return getResources().getIdentifier("ali_vsdk_shadu_icon_dengdai", "drawable", this.mContext.getPackageName());
        }
        return getResources().getIdentifier("ali_vsdk_button_icon_dengdai", "drawable", this.mContext.getPackageName());
    }

    private static Object getResourceId(Context context, String str, String str2) {
        try {
            Class<?>[] classes = Class.forName(context.getPackageName() + ".R").getClasses();
            for (Class<?> cls : classes) {
                if (cls.getSimpleName().equals(str2)) {
                    Field[] fields = cls.getFields();
                    for (Field field : fields) {
                        String name = field.getName();
                        if (name.equals(str)) {
                            System.out.println(name);
                            return field.get(null);
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getStyleable(Context context, String str) {
        return ((Integer) getResourceId(context, str, "styleable")).intValue();
    }

    public static int[] getStyleableArray(Context context, String str) {
        return (int[]) getResourceId(context, str, "styleable");
    }

    private void init() {
        this.mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
        this.mForeBitmap = ((BitmapDrawable) this.mContext.getResources().getDrawable(getResID())).getBitmap();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDeAttachedToWindow() {
        stopRotationAnimation();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mForeBitmap.isRecycled() && this.mIsAnimation) {
            init();
        }
        if (!this.mForeBitmap.isRecycled()) {
            this.mMatrix.setRotate((float) this.rotate, (float) (this.mForeBitmap.getWidth() / 2), (float) (this.mForeBitmap.getHeight() / 2));
            canvas.setDrawFilter(this.mPaintFlagsDrawFilter);
            canvas.drawBitmap(this.mForeBitmap, this.mMatrix, null);
            if (this.mIsAnimation) {
                int i = this.rotate;
                int i2 = i + 10 > 360 ? 0 : i + 10;
                this.rotate = i2;
                if (!this.mClockwise) {
                    i2 = -i2;
                }
                this.rotate = i2;
                postInvalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = this.mForeBitmap.getWidth();
        int height = this.mForeBitmap.getHeight();
        this.mHeight = height;
        setMeasuredDimension(this.mWidth, height);
    }

    public void startRotationAnimation() {
        this.mIsAnimation = true;
        invalidate();
    }

    public void stopRotationAnimation() {
        this.mIsAnimation = false;
    }

    public ALiLoadingView(Context context, int i) {
        super(context);
        this.mContext = context;
        this.mType = i;
        init();
    }

    public ALiLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mType = 0;
        init();
    }
}
