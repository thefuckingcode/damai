package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class FunGameHitBlockHeader extends FunGameView {
    protected static final int BLOCK_HORIZONTAL_NUM = 3;
    protected static final float BLOCK_POSITION_RATIO = 0.08f;
    protected static final int BLOCK_VERTICAL_NUM = 5;
    protected static final float BLOCK_WIDTH_RATIO = 0.01806f;
    protected static final int DEFAULT_ANGLE = 30;
    static final float DIVIDING_LINE_SIZE = 1.0f;
    protected static final float RACKET_POSITION_RATIO = 0.8f;
    protected static final int SPEED = 3;
    protected float BALL_RADIUS;
    protected int angle;
    protected float blockHeight;
    protected int blockHorizontalNum;
    protected float blockLeft;
    protected Paint blockPaint;
    protected float blockWidth;
    protected float cx;
    protected float cy;
    protected boolean isLeft;
    protected List<Point> pointList;
    protected float racketLeft;
    protected int speed;

    public FunGameHitBlockHeader(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public boolean checkTouchBlock(float f, float f2) {
        int i = (int) ((((f - this.blockLeft) - this.BALL_RADIUS) - ((float) this.speed)) / this.blockWidth);
        if (i == this.blockHorizontalNum) {
            i--;
        }
        int i2 = (int) (f2 / this.blockHeight);
        if (i2 == 5) {
            i2--;
        }
        Point point = new Point();
        point.set(i, i2);
        boolean z = false;
        Iterator<Point> it = this.pointList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().equals(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point))) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            this.pointList.add(point);
        }
        return !z;
    }

    /* access modifiers changed from: protected */
    public boolean checkTouchRacket(float f) {
        float f2 = f - this.controllerPosition;
        return f2 >= 0.0f && f2 <= ((float) this.controllerSize);
    }

    /* access modifiers changed from: protected */
    public void drawBallPath(Canvas canvas, int i) {
        this.mPaint.setColor(this.mModelColor);
        float f = this.cx;
        float f2 = this.blockLeft;
        int i2 = this.blockHorizontalNum;
        if (f <= f2 + (((float) i2) * this.blockWidth) + (((float) (i2 - 1)) * 1.0f) + this.BALL_RADIUS && checkTouchBlock(f, this.cy)) {
            this.isLeft = false;
        }
        float f3 = this.cx;
        float f4 = this.blockLeft;
        float f5 = this.BALL_RADIUS;
        if (f3 <= f4 + f5) {
            this.isLeft = false;
        }
        float f6 = this.racketLeft;
        if (f3 + f5 < f6 || f3 - f5 >= f6 + this.blockWidth) {
            if (f3 > ((float) i)) {
                this.status = 2;
            }
        } else if (checkTouchRacket(this.cy)) {
            if (this.pointList.size() == this.blockHorizontalNum * 5) {
                this.status = 2;
                return;
            }
            this.isLeft = true;
        }
        float f7 = this.cy;
        float f8 = this.BALL_RADIUS;
        if (f7 <= f8 + 1.0f) {
            this.angle = 150;
        } else if (f7 >= (((float) this.mHeaderHeight) - f8) - 1.0f) {
            this.angle = 210;
        }
        if (this.isLeft) {
            this.cx -= (float) this.speed;
        } else {
            this.cx += (float) this.speed;
        }
        float tan = f7 - (((float) Math.tan(Math.toRadians((double) this.angle))) * ((float) this.speed));
        this.cy = tan;
        canvas.drawCircle(this.cx, tan, this.BALL_RADIUS, this.mPaint);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void drawColorBlock(Canvas canvas) {
        boolean z;
        int i = 0;
        while (true) {
            int i2 = this.blockHorizontalNum;
            if (i < i2 * 5) {
                int i3 = i / i2;
                int i4 = i % i2;
                Iterator<Point> it = this.pointList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().equals(i4, i3)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    this.blockPaint.setColor(ColorUtils.setAlphaComponent(this.lModelColor, 255 / (i4 + 1)));
                    float f = this.blockLeft;
                    float f2 = this.blockWidth;
                    float f3 = f + (((float) i4) * (f2 + 1.0f));
                    float f4 = (float) i3;
                    float f5 = this.blockHeight;
                    float f6 = (f4 * (f5 + 1.0f)) + 1.0f;
                    canvas.drawRect(f3, f6, f3 + f2, f6 + f5, this.blockPaint);
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    public void drawGame(Canvas canvas, int i, int i2) {
        drawColorBlock(canvas);
        drawRacket(canvas);
        int i3 = this.status;
        if (i3 == 1 || i3 == 3 || i3 == 4 || isInEditMode()) {
            drawBallPath(canvas, i);
        }
    }

    /* access modifiers changed from: protected */
    public void drawRacket(Canvas canvas) {
        this.mPaint.setColor(this.rModelColor);
        float f = this.racketLeft;
        float f2 = this.controllerPosition;
        canvas.drawRect(f, f2, f + this.blockWidth, f2 + ((float) this.controllerSize), this.mPaint);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal, com.scwang.smartrefresh.header.fungame.FunGameView, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.header.fungame.FunGameBase
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        int measuredWidth = getMeasuredWidth();
        float f = ((float) (i / 5)) - 1.0f;
        this.blockHeight = f;
        float f2 = (float) measuredWidth;
        this.blockWidth = BLOCK_WIDTH_RATIO * f2;
        this.blockLeft = BLOCK_POSITION_RATIO * f2;
        this.racketLeft = f2 * 0.8f;
        this.controllerSize = (int) (f * 1.6f);
        super.onInitialized(refreshKernel, i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    public void resetConfigParams() {
        this.cx = this.racketLeft - (this.BALL_RADIUS * 3.0f);
        this.cy = (float) ((int) (((float) this.mHeaderHeight) * 0.5f));
        this.controllerPosition = 1.0f;
        this.angle = 30;
        this.isLeft = true;
        List<Point> list = this.pointList;
        if (list == null) {
            this.pointList = new ArrayList();
        } else {
            list.clear();
        }
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FunGameHitBlockHeader);
        this.speed = obtainStyledAttributes.getInt(R$styleable.FunGameHitBlockHeader_fghBallSpeed, DensityUtil.dp2px(3.0f));
        this.blockHorizontalNum = obtainStyledAttributes.getInt(R$styleable.FunGameHitBlockHeader_fghBlockHorizontalNum, 3);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.blockPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.BALL_RADIUS = (float) DensityUtil.dp2px(4.0f);
    }
}
