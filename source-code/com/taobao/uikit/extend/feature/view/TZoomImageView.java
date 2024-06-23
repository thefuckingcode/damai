package com.taobao.uikit.extend.feature.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

/* compiled from: Taobao */
public class TZoomImageView extends TUrlImageView {
    private static final int MAX_SCALE_X = 5;
    private static final int MAX_SCALE_Y = 5;
    private static final int TYPE_DRAG = 1;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_ZOOM = 2;
    private float mBottom;
    private Matrix mCurMatrix;
    private boolean mFirst;
    private boolean mIgnoreUpEvent;
    private float mLeft;
    private Matrix mMatrix;
    private int mMaxHeight;
    private int mMaxWidth;
    private PointF mMidPoint;
    private Matrix mOriginalMatrix;
    private float[] mOriginalValues;
    private boolean mOverMaxScale;
    private Matrix mPreMatrix;
    private Rect mRect;
    private float mRight;
    private boolean mScaleLarge;
    private boolean mScaleSmall;
    private TZoomScroller mScroller;
    private float mStartDist;
    private PointF mStartPoint;
    private float mTop;
    private int mType;

    public TZoomImageView(Context context) {
        super(context);
        this.mType = 0;
        this.mStartPoint = new PointF();
        this.mMidPoint = new PointF();
        this.mOriginalMatrix = new Matrix();
        this.mMatrix = new Matrix();
        this.mCurMatrix = new Matrix();
        this.mPreMatrix = new Matrix();
        this.mFirst = true;
        this.mScaleSmall = false;
        this.mScaleLarge = false;
        this.mOverMaxScale = false;
        this.mIgnoreUpEvent = false;
        this.mOriginalValues = new float[9];
        init();
    }

    private float distance(MotionEvent motionEvent) {
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    private void init() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mScroller = new TZoomScroller(new AccelerateDecelerateInterpolator());
    }

    private PointF midPoint(MotionEvent motionEvent) {
        return new PointF((motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f, (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f);
    }

    private void startScroll(Matrix matrix, Matrix matrix2) {
        if (matrix != null && matrix2 != null) {
            float[] fArr = new float[9];
            float[] fArr2 = new float[9];
            matrix.getValues(fArr);
            matrix2.getValues(fArr2);
            float f = fArr[2];
            float f2 = fArr2[2];
            float f3 = fArr[5];
            float f4 = fArr2[5];
            float f5 = fArr[0];
            this.mScroller.startScroll(f, f3, f5, f2 - f, f4 - f3, fArr2[0] - f5, 300);
            invalidate();
        }
    }

    @Override // com.taobao.uikit.feature.view.TImageView
    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller.computeScrollOffset()) {
            float[] fArr = new float[9];
            this.mMatrix.getValues(fArr);
            fArr[2] = this.mScroller.getCurrX();
            fArr[5] = this.mScroller.getCurrY();
            fArr[0] = this.mScroller.getCurrZ();
            fArr[4] = this.mScroller.getCurrZ();
            this.mMatrix.setValues(fArr);
            setImageMatrix(this.mMatrix);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.uikit.feature.view.TImageView
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mMaxWidth = i3 - i;
        this.mMaxHeight = i4 - i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r0 != 6) goto L_0x0238;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e1  */
    @Override // com.taobao.uikit.feature.view.TImageView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getDrawable() == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i = this.mType;
                    if (i == 0) {
                        float x = motionEvent.getX() - this.mStartPoint.x;
                        float y = motionEvent.getY() - this.mStartPoint.y;
                        if (Math.abs(x) > 10.0f || Math.abs(y) > 10.0f) {
                            this.mType = 1;
                        }
                    } else if (i == 1 && this.mScaleLarge) {
                        float x2 = motionEvent.getX() - this.mStartPoint.x;
                        float y2 = motionEvent.getY() - this.mStartPoint.y;
                        if (x2 > 0.0f) {
                            if (this.mLeft >= 0.0f) {
                                getParent().requestDisallowInterceptTouchEvent(false);
                            } else {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                float f = this.mLeft;
                                if (f + x2 > 0.0f) {
                                    x2 = -f;
                                }
                                if (y2 > 0.0f) {
                                    float f2 = this.mTop;
                                    if (f2 <= 0.0f) {
                                        if (f2 + y2 > 0.0f) {
                                            y2 = -f2;
                                        }
                                        this.mMatrix.set(this.mCurMatrix);
                                        this.mMatrix.postTranslate(x2, y2);
                                        setScaleType(ImageView.ScaleType.MATRIX);
                                        setImageMatrix(this.mMatrix);
                                    }
                                } else {
                                    float f3 = this.mBottom;
                                    int i2 = this.mMaxHeight;
                                    if (f3 >= ((float) i2)) {
                                        if (f3 + y2 < ((float) i2)) {
                                            y2 = ((float) i2) - f3;
                                        }
                                        this.mMatrix.set(this.mCurMatrix);
                                        this.mMatrix.postTranslate(x2, y2);
                                        setScaleType(ImageView.ScaleType.MATRIX);
                                        setImageMatrix(this.mMatrix);
                                    }
                                }
                                y2 = 0.0f;
                                this.mMatrix.set(this.mCurMatrix);
                                this.mMatrix.postTranslate(x2, y2);
                                setScaleType(ImageView.ScaleType.MATRIX);
                                setImageMatrix(this.mMatrix);
                            }
                        } else if (this.mRight <= ((float) this.mMaxWidth)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            float f4 = this.mRight;
                            int i3 = this.mMaxWidth;
                            if (f4 + x2 < ((float) i3)) {
                                x2 = ((float) i3) - f4;
                            }
                            if (y2 > 0.0f) {
                            }
                            y2 = 0.0f;
                            this.mMatrix.set(this.mCurMatrix);
                            this.mMatrix.postTranslate(x2, y2);
                            setScaleType(ImageView.ScaleType.MATRIX);
                            setImageMatrix(this.mMatrix);
                        }
                        x2 = 0.0f;
                        if (y2 > 0.0f) {
                        }
                        y2 = 0.0f;
                        this.mMatrix.set(this.mCurMatrix);
                        this.mMatrix.postTranslate(x2, y2);
                        setScaleType(ImageView.ScaleType.MATRIX);
                        setImageMatrix(this.mMatrix);
                    } else if (i == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        float distance = distance(motionEvent);
                        if (distance > 10.0f) {
                            this.mMatrix.set(this.mCurMatrix);
                            float f5 = distance / this.mStartDist;
                            Matrix matrix = this.mMatrix;
                            PointF pointF = this.mMidPoint;
                            matrix.postScale(f5, f5, pointF.x, pointF.y);
                            float[] fArr = new float[9];
                            this.mMatrix.getValues(fArr);
                            float f6 = fArr[0];
                            float[] fArr2 = this.mOriginalValues;
                            if (((double) (f6 / fArr2[0])) < 1.0d || ((double) (fArr[4] / fArr2[4])) < 1.0d) {
                                this.mScaleSmall = true;
                                this.mScaleLarge = false;
                            } else {
                                this.mScaleSmall = false;
                                this.mScaleLarge = true;
                            }
                            if (fArr[0] / fArr2[0] > 5.0f || fArr[4] / fArr2[4] > 5.0f) {
                                this.mOverMaxScale = true;
                                this.mPreMatrix.set(this.mCurMatrix);
                            } else {
                                this.mOverMaxScale = false;
                            }
                        }
                        setScaleType(ImageView.ScaleType.MATRIX);
                        setImageMatrix(this.mMatrix);
                    }
                } else if (action == 5) {
                    float distance2 = distance(motionEvent);
                    this.mStartDist = distance2;
                    if (distance2 > 10.0f) {
                        this.mCurMatrix.set(this.mMatrix);
                        this.mType = 2;
                        this.mMidPoint = midPoint(motionEvent);
                    }
                }
            } else if (this.mIgnoreUpEvent) {
                this.mIgnoreUpEvent = false;
                return true;
            }
            int i4 = this.mType;
            if (i4 == 1) {
                this.mType = 0;
                return true;
            } else if (i4 == 2) {
                this.mType = 0;
                this.mIgnoreUpEvent = true;
                getParent().requestDisallowInterceptTouchEvent(false);
                if (this.mScaleSmall) {
                    this.mScaleSmall = false;
                    this.mScaleLarge = false;
                    startScroll(this.mMatrix, this.mOriginalMatrix);
                }
                if (this.mOverMaxScale) {
                    this.mOverMaxScale = false;
                    startScroll(this.mMatrix, this.mPreMatrix);
                }
                return true;
            }
        } else {
            this.mStartPoint.set(motionEvent.getX(), motionEvent.getY());
            if (this.mFirst) {
                this.mOriginalMatrix.set(getImageMatrix());
                this.mMatrix.preConcat(getImageMatrix());
                this.mFirst = false;
                this.mOriginalMatrix.getValues(this.mOriginalValues);
            }
            this.mCurMatrix.set(this.mMatrix);
            this.mType = 0;
            this.mRect = getDrawable().getBounds();
            float[] fArr3 = new float[9];
            this.mCurMatrix.getValues(fArr3);
            float f7 = fArr3[2];
            this.mLeft = f7;
            this.mTop = fArr3[5];
            this.mRight = f7 + (((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mRect)) * fArr3[0]);
            this.mBottom = this.mTop + (((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mRect)) * fArr3[4]);
            if (this.mScaleLarge) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void reset() {
        if (!this.mFirst) {
            this.mFirst = true;
            this.mMatrix = new Matrix();
            this.mPreMatrix = new Matrix();
            this.mCurMatrix = new Matrix();
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public TZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 0;
        this.mStartPoint = new PointF();
        this.mMidPoint = new PointF();
        this.mOriginalMatrix = new Matrix();
        this.mMatrix = new Matrix();
        this.mCurMatrix = new Matrix();
        this.mPreMatrix = new Matrix();
        this.mFirst = true;
        this.mScaleSmall = false;
        this.mScaleLarge = false;
        this.mOverMaxScale = false;
        this.mIgnoreUpEvent = false;
        this.mOriginalValues = new float[9];
        init();
    }

    public TZoomImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 0;
        this.mStartPoint = new PointF();
        this.mMidPoint = new PointF();
        this.mOriginalMatrix = new Matrix();
        this.mMatrix = new Matrix();
        this.mCurMatrix = new Matrix();
        this.mPreMatrix = new Matrix();
        this.mFirst = true;
        this.mScaleSmall = false;
        this.mScaleLarge = false;
        this.mOverMaxScale = false;
        this.mIgnoreUpEvent = false;
        this.mOriginalValues = new float[9];
        init();
    }
}
