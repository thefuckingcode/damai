package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import java.util.ArrayList;
import tb.rv1;
import tb.sv1;
import tb.we2;

/* compiled from: Taobao */
public class StoreHouseHeader extends View implements PtrUIHandler {
    private AniController mAniController = new AniController();
    private float mBarDarkAlpha = 0.4f;
    private int mDrawZoneHeight = 0;
    private int mDrawZoneWidth = 0;
    private int mDropHeight = -1;
    private float mFromAlpha = 1.0f;
    private int mHorizontalRandomness = -1;
    private float mInternalAnimationFactor = 0.7f;
    private boolean mIsInLoading = false;
    public ArrayList<StoreHouseBarItem> mItemList = new ArrayList<>();
    private int mLineWidth = -1;
    private int mLoadingAniDuration = 1000;
    private int mLoadingAniItemDuration = 400;
    private int mLoadingAniSegDuration = 1000;
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private float mProgress = 0.0f;
    private float mScale = 1.0f;
    private int mTextColor = -1;
    private float mToAlpha = 0.4f;
    private Transformation mTransformation = new Transformation();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class AniController implements Runnable {
        private int mCountPerSeg;
        private int mInterval;
        private boolean mRunning;
        private int mSegCount;
        private int mTick;

        private AniController() {
            this.mTick = 0;
            this.mCountPerSeg = 0;
            this.mSegCount = 0;
            this.mInterval = 0;
            this.mRunning = true;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void start() {
            this.mRunning = true;
            this.mTick = 0;
            this.mInterval = StoreHouseHeader.this.mLoadingAniDuration / StoreHouseHeader.this.mItemList.size();
            this.mCountPerSeg = StoreHouseHeader.this.mLoadingAniSegDuration / this.mInterval;
            this.mSegCount = (StoreHouseHeader.this.mItemList.size() / this.mCountPerSeg) + 1;
            run();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void stop() {
            this.mRunning = false;
            StoreHouseHeader.this.removeCallbacks(this);
        }

        public void run() {
            int i = this.mTick % this.mCountPerSeg;
            for (int i2 = 0; i2 < this.mSegCount; i2++) {
                int i3 = (this.mCountPerSeg * i2) + i;
                if (i3 <= this.mTick) {
                    StoreHouseBarItem storeHouseBarItem = StoreHouseHeader.this.mItemList.get(i3 % StoreHouseHeader.this.mItemList.size());
                    storeHouseBarItem.setFillAfter(false);
                    storeHouseBarItem.setFillEnabled(true);
                    storeHouseBarItem.setFillBefore(false);
                    storeHouseBarItem.setDuration((long) StoreHouseHeader.this.mLoadingAniItemDuration);
                    storeHouseBarItem.start(StoreHouseHeader.this.mFromAlpha, StoreHouseHeader.this.mToAlpha);
                }
            }
            this.mTick++;
            if (this.mRunning) {
                StoreHouseHeader.this.postDelayed(this, (long) this.mInterval);
            }
        }
    }

    public StoreHouseHeader(Context context) {
        super(context);
        initView();
    }

    private void beginLoading() {
        this.mIsInLoading = true;
        this.mAniController.start();
        invalidate();
    }

    private int getBottomOffset() {
        return getPaddingBottom() + sv1.a(10.0f);
    }

    private int getTopOffset() {
        return getPaddingTop() + sv1.a(10.0f);
    }

    private void initView() {
        sv1.b(getContext());
        this.mLineWidth = sv1.a(1.0f);
        this.mDropHeight = sv1.a(40.0f);
        this.mHorizontalRandomness = sv1.a / 2;
    }

    private void loadFinish() {
        this.mIsInLoading = false;
        this.mAniController.stop();
    }

    private void setProgress(float f) {
        this.mProgress = f;
    }

    public int getLoadingAniDuration() {
        return this.mLoadingAniDuration;
    }

    public float getScale() {
        return this.mScale;
    }

    public void initWithPointList(ArrayList<float[]> arrayList) {
        boolean z = this.mItemList.size() > 0;
        this.mItemList.clear();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            float[] fArr = arrayList.get(i);
            PointF pointF = new PointF(((float) sv1.a(fArr[0])) * this.mScale, ((float) sv1.a(fArr[1])) * this.mScale);
            PointF pointF2 = new PointF(((float) sv1.a(fArr[2])) * this.mScale, ((float) sv1.a(fArr[3])) * this.mScale);
            f = Math.max(Math.max(f, pointF.x), pointF2.x);
            f2 = Math.max(Math.max(f2, pointF.y), pointF2.y);
            StoreHouseBarItem storeHouseBarItem = new StoreHouseBarItem(i, pointF, pointF2, this.mTextColor, this.mLineWidth);
            storeHouseBarItem.resetPosition(this.mHorizontalRandomness);
            this.mItemList.add(storeHouseBarItem);
        }
        this.mDrawZoneWidth = (int) Math.ceil((double) f);
        this.mDrawZoneHeight = (int) Math.ceil((double) f2);
        if (z) {
            requestLayout();
        }
    }

    public void initWithString(String str) {
        initWithString(str, 25);
    }

    public void initWithStringArray(int i) {
        String[] stringArray = getResources().getStringArray(i);
        ArrayList<float[]> arrayList = new ArrayList<>();
        for (String str : stringArray) {
            String[] split = str.split(",");
            float[] fArr = new float[4];
            for (int i2 = 0; i2 < 4; i2++) {
                fArr[i2] = Float.parseFloat(split[i2]);
            }
            arrayList.add(fArr);
        }
        initWithPointList(arrayList);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.mProgress;
        int save = canvas.save();
        int size = this.mItemList.size();
        for (int i = 0; i < size; i++) {
            canvas.save();
            StoreHouseBarItem storeHouseBarItem = this.mItemList.get(i);
            PointF pointF = storeHouseBarItem.midPoint;
            float f2 = ((float) this.mOffsetX) + pointF.x;
            float f3 = ((float) this.mOffsetY) + pointF.y;
            if (this.mIsInLoading) {
                storeHouseBarItem.getTransformation(getDrawingTime(), this.mTransformation);
                canvas.translate(f2, f3);
            } else {
                float f4 = 0.0f;
                if (f == 0.0f) {
                    storeHouseBarItem.resetPosition(this.mHorizontalRandomness);
                } else {
                    float f5 = this.mInternalAnimationFactor;
                    float f6 = ((1.0f - f5) * ((float) i)) / ((float) size);
                    float f7 = (1.0f - f5) - f6;
                    if (f == 1.0f || f >= 1.0f - f7) {
                        canvas.translate(f2, f3);
                        storeHouseBarItem.setAlpha(this.mBarDarkAlpha);
                    } else {
                        if (f > f6) {
                            f4 = Math.min(1.0f, (f - f6) / f5);
                        }
                        float f8 = 1.0f - f4;
                        float f9 = f2 + (storeHouseBarItem.translationX * f8);
                        float f10 = f3 + (((float) (-this.mDropHeight)) * f8);
                        Matrix matrix = new Matrix();
                        matrix.postRotate(360.0f * f4);
                        matrix.postScale(f4, f4);
                        matrix.postTranslate(f9, f10);
                        storeHouseBarItem.setAlpha(this.mBarDarkAlpha * f4);
                        canvas.concat(matrix);
                    }
                }
            }
            storeHouseBarItem.draw(canvas);
            canvas.restore();
        }
        if (this.mIsInLoading) {
            invalidate();
        }
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getTopOffset() + this.mDrawZoneHeight + getBottomOffset(), 1073741824));
        this.mOffsetX = (getMeasuredWidth() - this.mDrawZoneWidth) / 2;
        this.mOffsetY = getTopOffset();
        this.mDropHeight = getTopOffset();
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rv1 rv1) {
        setProgress(Math.min(1.0f, rv1.c()));
        invalidate();
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        beginLoading();
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        loadFinish();
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
        loadFinish();
        for (int i = 0; i < this.mItemList.size(); i++) {
            this.mItemList.get(i).resetPosition(this.mHorizontalRandomness);
        }
    }

    public StoreHouseHeader setDropHeight(int i) {
        this.mDropHeight = i;
        return this;
    }

    public StoreHouseHeader setLineWidth(int i) {
        this.mLineWidth = i;
        for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
            this.mItemList.get(i2).setLineWidth(i);
        }
        return this;
    }

    public void setLoadingAniDuration(int i) {
        this.mLoadingAniDuration = i;
        this.mLoadingAniSegDuration = i;
    }

    public void setScale(float f) {
        this.mScale = f;
    }

    public StoreHouseHeader setTextColor(int i) {
        this.mTextColor = i;
        for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
            this.mItemList.get(i2).setColor(i);
        }
        return this;
    }

    public void initWithString(String str, int i) {
        initWithPointList(we2.b(str, ((float) i) * 0.01f, 14));
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
