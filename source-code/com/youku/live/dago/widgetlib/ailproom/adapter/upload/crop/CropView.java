package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.GestureDetector;
import com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.OnGestureListener;
import com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.VersionedGestureDetector;
import com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public class CropView extends ImageView implements ViewTreeObserver.OnGlobalLayoutListener, OnGestureListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final float DEFAULT_MAX_SCALE = 6.0f;
    private static final float DEFAULT_MID_SCALE = 3.0f;
    private static final float DEFAULT_MIN_SCALE = 1.0f;
    private static final long DEFAULT_ZOOM_DURATION = 200;
    private static final float OUTLINE_DP = 2.0f;
    private int highlightColor;
    private int mAspectX;
    private int mAspectY;
    private final Matrix mBaseMatrix;
    private RotateBitmap mBitmapDisplayed;
    private RectF mCropRect;
    private FlingRunnable mCurrentFlingRunnable;
    private final RectF mDisplayRect;
    private GestureDetector mDragScaleDetector;
    private final Matrix mDrawMatrix;
    private android.view.GestureDetector mGestureDetector;
    private int mIvBottom;
    private int mIvLeft;
    private int mIvRight;
    private int mIvTop;
    private final float[] mMatrixValues;
    private float mMaxScale;
    private float mMidScale;
    private float mMinScale;
    private int mOutputX;
    private int mOutputY;
    private int mSampleSize;
    private Uri mSource;
    private final Matrix mSuppMatrix;
    private long mZoomDuration;
    private final Paint outlinePaint;
    private final Paint outsidePaint;
    private Path path;
    private Interpolator sInterpolator;
    private Rect viewDrawingRect;

    /* compiled from: Taobao */
    public class AnimatedZoomRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.mZoomStart = f;
            this.mZoomEnd = f2;
            this.mFocalX = f3;
            this.mFocalY = f4;
        }

        private float interpolate() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1451448754")) {
                return ((Float) ipChange.ipc$dispatch("1451448754", new Object[]{this})).floatValue();
            }
            return CropView.this.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / ((float) CropView.this.mZoomDuration)));
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "371352056")) {
                ipChange.ipc$dispatch("371352056", new Object[]{this});
                return;
            }
            float interpolate = interpolate();
            float f = this.mZoomStart;
            CropView.this.onScale((f + ((this.mZoomEnd - f) * interpolate)) / CropView.this.getScale(), this.mFocalX, this.mFocalY);
            if (interpolate < 1.0f) {
                Compat.postOnAnimation(CropView.this, this);
            }
        }
    }

    /* compiled from: Taobao */
    public class DefaultOnDoubleTapListener implements GestureDetector.OnDoubleTapListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private DefaultOnDoubleTapListener() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1422408810")) {
                return ((Boolean) ipChange.ipc$dispatch("-1422408810", new Object[]{this, motionEvent})).booleanValue();
            }
            try {
                float scale = CropView.this.getScale();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (scale < CropView.this.mMidScale) {
                    CropView cropView = CropView.this;
                    cropView.setScale(cropView.mMidScale, x, y, true);
                } else if (scale < CropView.this.mMidScale || scale >= CropView.this.mMaxScale) {
                    CropView cropView2 = CropView.this;
                    cropView2.setScale(cropView2.mMinScale, x, y, true);
                } else {
                    CropView cropView3 = CropView.this;
                    cropView3.setScale(cropView3.mMaxScale, x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1270377420")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("1270377420", new Object[]{this, motionEvent})).booleanValue();
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1516950896")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("-1516950896", new Object[]{this, motionEvent})).booleanValue();
        }
    }

    /* compiled from: Taobao */
    public class FlingRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private int mCurrentX;
        private int mCurrentY;
        private final ScrollerProxy mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = ScrollerProxy.getScroller(context);
        }

        public void cancelFling() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1716193233")) {
                ipChange.ipc$dispatch("1716193233", new Object[]{this});
                return;
            }
            this.mScroller.forceFinished(true);
        }

        public void fling(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1075565481")) {
                ipChange.ipc$dispatch("-1075565481", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            CropView cropView = CropView.this;
            RectF displayRect = cropView.getDisplayRect(cropView.getDrawMatrix());
            if (displayRect != null) {
                int round = Math.round(CropView.this.mCropRect.left - displayRect.left);
                int round2 = Math.round(CropView.this.mCropRect.top - displayRect.top);
                int round3 = Math.round(displayRect.width() - CropView.this.mCropRect.width());
                int round4 = Math.round(displayRect.height() - CropView.this.mCropRect.height());
                this.mCurrentX = round;
                this.mCurrentY = round2;
                this.mScroller.fling(round, round2, i, i2, 0, round3, 0, round4, 0, 0);
            }
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1285529000")) {
                ipChange.ipc$dispatch("1285529000", new Object[]{this});
            } else if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                CropView.this.mSuppMatrix.postTranslate((float) (this.mCurrentX - currX), (float) (this.mCurrentY - currY));
                CropView cropView = CropView.this;
                cropView.setImageMatrix(cropView.getDrawMatrix());
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                Compat.postOnAnimation(CropView.this, this);
            }
        }
    }

    public CropView(Context context) {
        this(context, null);
    }

    private void cancelFling() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1415968326")) {
            ipChange.ipc$dispatch("1415968326", new Object[]{this});
            return;
        }
        FlingRunnable flingRunnable = this.mCurrentFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    private void checkAndDisplayMatrix() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1703999340")) {
            ipChange.ipc$dispatch("-1703999340", new Object[]{this});
        } else if (checkMatrixBounds()) {
            setImageMatrix(getDrawMatrix());
        }
    }

    private boolean checkMatrixBounds() {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48292494")) {
            return ((Boolean) ipChange.ipc$dispatch("48292494", new Object[]{this})).booleanValue();
        }
        RectF displayRect = getDisplayRect(getDrawMatrix());
        if (displayRect == null) {
            return false;
        }
        float f2 = displayRect.top;
        RectF rectF = this.mCropRect;
        float f3 = rectF.top;
        float f4 = 0.0f;
        if (f2 >= f3) {
            f = (-f2) + f3;
        } else {
            float f5 = displayRect.bottom;
            float f6 = rectF.bottom;
            f = f5 <= f6 ? f6 - f5 : 0.0f;
        }
        float f7 = displayRect.left;
        float f8 = rectF.left;
        if (f7 >= f8) {
            f4 = (-f7) + f8;
        } else {
            float f9 = displayRect.right;
            float f10 = rectF.right;
            if (f9 <= f10) {
                f4 = f10 - f9;
            }
        }
        this.mSuppMatrix.postTranslate(f4, f);
        return true;
    }

    private void cleanup() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177680156")) {
            ipChange.ipc$dispatch("-177680156", new Object[]{this});
            return;
        }
        cancelFling();
        android.view.GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.setOnDoubleTapListener(null);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
        setImageBitmap(null);
        this.mBitmapDisplayed.recycle();
    }

    private float dpToPx(float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "104847997")) {
            return f * getContext().getResources().getDisplayMetrics().density;
        }
        return ((Float) ipChange.ipc$dispatch("104847997", new Object[]{this, Float.valueOf(f)})).floatValue();
    }

    private void drawOutsideFallback(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672192032")) {
            ipChange.ipc$dispatch("1672192032", new Object[]{this, canvas});
            return;
        }
        canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), this.mCropRect.top, this.outsidePaint);
        canvas.drawRect(0.0f, this.mCropRect.bottom, (float) canvas.getWidth(), (float) canvas.getHeight(), this.outsidePaint);
        RectF rectF = this.mCropRect;
        canvas.drawRect(0.0f, rectF.top, rectF.left, rectF.bottom, this.outsidePaint);
        RectF rectF2 = this.mCropRect;
        canvas.drawRect(rectF2.right, rectF2.top, (float) canvas.getWidth(), this.mCropRect.bottom, this.outsidePaint);
    }

    private int getCropViewHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1638841641")) {
            return (getHeight() - getPaddingTop()) - getPaddingBottom();
        }
        return ((Integer) ipChange.ipc$dispatch("1638841641", new Object[]{this})).intValue();
    }

    private int getCropViewWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1559327078")) {
            return (getWidth() - getPaddingLeft()) - getPaddingRight();
        }
        return ((Integer) ipChange.ipc$dispatch("-1559327078", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private RectF getDisplayRect(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691483011")) {
            return (RectF) ipChange.ipc$dispatch("-691483011", new Object[]{this, matrix});
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        this.mDisplayRect.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Matrix getDrawMatrix() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289215143")) {
            return (Matrix) ipChange.ipc$dispatch("-1289215143", new Object[]{this});
        }
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float getScale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-154015970")) {
            return (float) Math.sqrt((double) (((float) Math.pow((double) getValue(this.mSuppMatrix, 0), 2.0d)) + ((float) Math.pow((double) getValue(this.mSuppMatrix, 3), 2.0d))));
        }
        return ((Float) ipChange.ipc$dispatch("-154015970", new Object[]{this})).floatValue();
    }

    private float getValue(Matrix matrix, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1958638334")) {
            return ((Float) ipChange.ipc$dispatch("1958638334", new Object[]{this, matrix, Integer.valueOf(i)})).floatValue();
        }
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    private boolean isClipPathSupported(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1444752144")) {
            return ((Boolean) ipChange.ipc$dispatch("-1444752144", new Object[]{this, canvas})).booleanValue();
        }
        int i = Build.VERSION.SDK_INT;
        if (i == 17) {
            return false;
        }
        if (i < 14 || i > 15) {
            return true;
        }
        return !canvas.isHardwareAccelerated();
    }

    private void setImageRotateBitmap(RotateBitmap rotateBitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-810446200")) {
            ipChange.ipc$dispatch("-810446200", new Object[]{this, rotateBitmap});
            return;
        }
        Bitmap bitmap = this.mBitmapDisplayed.getBitmap();
        this.mBitmapDisplayed = rotateBitmap;
        setImageBitmap(rotateBitmap.getBitmap());
        if (bitmap != null) {
            bitmap.recycle();
        }
        updateBaseMatrix();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setScale(float f, float f2, float f3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192482382")) {
            ipChange.ipc$dispatch("1192482382", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)});
        } else if (f >= this.mMinScale && f <= this.mMaxScale) {
            if (z) {
                post(new AnimatedZoomRunnable(getScale(), f, f2, f3));
                return;
            }
            this.mSuppMatrix.setScale(f, f, f2, f3);
            checkAndDisplayMatrix();
        }
    }

    private void updateBaseMatrix() {
        float f;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50868025")) {
            ipChange.ipc$dispatch("-50868025", new Object[]{this});
        } else if (this.mBitmapDisplayed.getBitmap() != null) {
            float cropViewWidth = (float) getCropViewWidth();
            float cropViewHeight = (float) getCropViewHeight();
            float width = (float) this.mBitmapDisplayed.getWidth();
            float height = (float) this.mBitmapDisplayed.getHeight();
            this.mBaseMatrix.reset();
            float min = Math.min(Math.min(cropViewWidth / width, 3.0f), Math.min(cropViewHeight / height, 3.0f));
            float min2 = ((Math.min(width, height) * 4.0f) / 5.0f) * min;
            int i2 = this.mAspectX;
            if (i2 == 0 || (i = this.mAspectY) == 0) {
                f = min2;
            } else if (i2 > i) {
                f = (((float) i) * min2) / ((float) i2);
            } else {
                float f2 = (((float) i2) * min2) / ((float) i);
                f = min2;
                min2 = f2;
            }
            float min3 = Math.min((cropViewWidth / min2) * 0.6f, (cropViewHeight / f) * 0.6f);
            if (min3 > 1.0f) {
                min *= min3;
                min2 *= min3;
                f *= min3;
            }
            float f3 = (cropViewWidth - min2) / OUTLINE_DP;
            float f4 = (cropViewHeight - f) / OUTLINE_DP;
            this.mCropRect = new RectF(f3, f4, min2 + f3, f + f4);
            this.mBaseMatrix.postConcat(this.mBitmapDisplayed.getRotateMatrix());
            this.mBaseMatrix.postScale(min, min);
            this.mBaseMatrix.postTranslate((cropViewWidth - (width * min)) / OUTLINE_DP, (cropViewHeight - (height * min)) / OUTLINE_DP);
            this.mSuppMatrix.reset();
            setImageMatrix(getDrawMatrix());
            RectF displayRect = getDisplayRect(this.mBaseMatrix);
            this.mMinScale = Math.max(this.mCropRect.width() / displayRect.width(), this.mCropRect.height() / displayRect.height());
        }
    }

    public CropView asSquare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1902024511")) {
            return (CropView) ipChange.ipc$dispatch("1902024511", new Object[]{this});
        }
        this.mAspectX = 1;
        this.mAspectY = 1;
        return this;
    }

    public Bitmap getOutput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460271567")) {
            return (Bitmap) ipChange.ipc$dispatch("1460271567", new Object[]{this});
        } else if (getDrawable() == null || this.mCropRect == null) {
            return null;
        } else {
            Matrix drawMatrix = getDrawMatrix();
            RectF displayRect = getDisplayRect(drawMatrix);
            RectF rectF = this.mCropRect;
            float f = rectF.left;
            float f2 = rectF.top;
            if (displayRect != null) {
                f -= displayRect.left;
                f2 -= displayRect.top;
            }
            float sqrt = (float) Math.sqrt((double) (((float) Math.pow((double) getValue(drawMatrix, 0), 2.0d)) + ((float) Math.pow((double) getValue(drawMatrix, 3), 2.0d))));
            int i = this.mSampleSize;
            return CropUtil.decodeRegionCrop(getContext(), this.mSource, new Rect((int) ((f / sqrt) * ((float) i)), (int) ((f2 / sqrt) * ((float) i)), (int) (((f + this.mCropRect.width()) / sqrt) * ((float) this.mSampleSize)), (int) (((f2 + this.mCropRect.height()) / sqrt) * ((float) this.mSampleSize))), this.mOutputX, this.mOutputY, this.mBitmapDisplayed.getRotation());
        }
    }

    public void initialize(Context context) {
        Throwable th;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693379178")) {
            ipChange.ipc$dispatch("-1693379178", new Object[]{this, context});
            return;
        }
        Uri uri = this.mSource;
        if (uri != null) {
            File fromMediaUri = CropUtil.getFromMediaUri(context, uri);
            InputStream inputStream = null;
            try {
                this.mSampleSize = CropUtil.calculateBitmapSampleSize(context, this.mSource);
                InputStream openInputStream = context.getContentResolver().openInputStream(this.mSource);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.mSampleSize;
                    setImageRotateBitmap(new RotateBitmap(BitmapFactory.decodeStream(openInputStream, null, options), CropUtil.getExifRotation(fromMediaUri)));
                    CropUtil.closeSilently(openInputStream);
                } catch (IOException | OutOfMemoryError unused) {
                    inputStream = openInputStream;
                    CropUtil.closeSilently(inputStream);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = openInputStream;
                    CropUtil.closeSilently(inputStream);
                    throw th;
                }
            } catch (IOException | OutOfMemoryError unused2) {
                CropUtil.closeSilently(inputStream);
            } catch (Throwable th3) {
                th = th3;
                CropUtil.closeSilently(inputStream);
                throw th;
            }
        }
    }

    public CropView of(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "394136232")) {
            return (CropView) ipChange.ipc$dispatch("394136232", new Object[]{this, uri});
        }
        this.mSource = uri;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990049705")) {
            ipChange.ipc$dispatch("-990049705", new Object[]{this});
            return;
        }
        cleanup();
        super.onDetachedFromWindow();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.OnGestureListener
    public void onDrag(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1734291921")) {
            ipChange.ipc$dispatch("-1734291921", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        } else if (!this.mDragScaleDetector.isScaling()) {
            this.mSuppMatrix.postTranslate(f, f2);
            checkAndDisplayMatrix();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1363650150")) {
            ipChange.ipc$dispatch("1363650150", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (this.mCropRect != null) {
            this.path.reset();
            Path path2 = this.path;
            RectF rectF = this.mCropRect;
            path2.addRect(rectF.left, rectF.top, rectF.right, rectF.bottom, Path.Direction.CW);
            drawOutsideFallback(canvas);
            canvas.drawPath(this.path, this.outlinePaint);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.OnGestureListener
    public void onFling(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "575472811")) {
            ipChange.ipc$dispatch("575472811", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        FlingRunnable flingRunnable = new FlingRunnable(getContext());
        this.mCurrentFlingRunnable = flingRunnable;
        flingRunnable.fling((int) f3, (int) f4);
        post(this.mCurrentFlingRunnable);
    }

    public void onGlobalLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-572657194")) {
            ipChange.ipc$dispatch("-572657194", new Object[]{this});
            return;
        }
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft();
        int right = getRight();
        if (top != this.mIvTop || bottom != this.mIvBottom || left != this.mIvLeft || right != this.mIvRight) {
            updateBaseMatrix();
            this.mIvTop = top;
            this.mIvBottom = bottom;
            this.mIvLeft = left;
            this.mIvRight = right;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0044, code lost:
        if (r5 <= r1) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
        if (r5 >= r1) goto L_0x0046;
     */
    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.OnGestureListener
    public void onScale(float f, float f2, float f3) {
        float f4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-874747101")) {
            ipChange.ipc$dispatch("-874747101", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        float scale = getScale();
        if (f > 1.0f) {
            f4 = this.mMaxScale / scale;
        } else {
            if (f < 1.0f) {
                f4 = this.mMinScale / scale;
            }
            this.mSuppMatrix.postScale(f, f, f2, f3);
            checkAndDisplayMatrix();
        }
        f = f4;
        this.mSuppMatrix.postScale(f, f, f2, f3);
        checkAndDisplayMatrix();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1583857471")) {
            return ((Boolean) ipChange.ipc$dispatch("-1583857471", new Object[]{this, motionEvent})).booleanValue();
        } else if (getDrawable() == null || this.mCropRect == null) {
            return false;
        } else {
            if (motionEvent.getAction() == 0) {
                cancelFling();
            }
            com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.GestureDetector gestureDetector = this.mDragScaleDetector;
            if (gestureDetector != null) {
                z = gestureDetector.onTouchEvent(motionEvent);
            }
            android.view.GestureDetector gestureDetector2 = this.mGestureDetector;
            if (gestureDetector2 == null || !gestureDetector2.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
    }

    public CropView withAspect(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2094843984")) {
            return (CropView) ipChange.ipc$dispatch("-2094843984", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mAspectX = i;
        this.mAspectY = i2;
        return this;
    }

    public CropView withOutputSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-832348378")) {
            return (CropView) ipChange.ipc$dispatch("-832348378", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mOutputX = i;
        this.mOutputY = i2;
        return this;
    }

    public CropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMinScale = 1.0f;
        this.mMidScale = 3.0f;
        this.mMaxScale = 6.0f;
        this.mZoomDuration = DEFAULT_ZOOM_DURATION;
        this.mBaseMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.mDisplayRect = new RectF();
        this.mMatrixValues = new float[9];
        this.sInterpolator = new AccelerateDecelerateInterpolator();
        this.mBitmapDisplayed = new RotateBitmap(null, 0);
        Paint paint = new Paint();
        this.outlinePaint = paint;
        Paint paint2 = new Paint();
        this.outsidePaint = paint2;
        this.highlightColor = -1;
        this.path = new Path();
        this.viewDrawingRect = new Rect();
        this.mAspectX = 1;
        this.mAspectY = 1;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mDragScaleDetector = VersionedGestureDetector.newInstance(context, this);
        android.view.GestureDetector gestureDetector = new android.view.GestureDetector(context, new GestureDetector.SimpleOnGestureListener());
        this.mGestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener());
        paint.setAntiAlias(true);
        paint.setColor(this.highlightColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPx(OUTLINE_DP));
        paint2.setARGB(125, 50, 50, 50);
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
    }
}
