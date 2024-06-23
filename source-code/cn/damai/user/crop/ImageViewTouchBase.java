package cn.damai.user.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w12;

/* compiled from: Taobao */
public abstract class ImageViewTouchBase extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final float SCALE_RATE = 1.25f;
    protected Matrix baseMatrix;
    protected final w12 bitmapDisplayed;
    private final Matrix displayMatrix;
    protected Handler handler;
    private final float[] matrixValues;
    float maxZoom;
    private Runnable onLayoutRunnable;
    private Recycler recycler;
    protected Matrix suppMatrix;
    int thisHeight;
    int thisWidth;

    /* compiled from: Taobao */
    public interface Recycler {
        void recycle(Bitmap bitmap);
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.baseMatrix = new Matrix();
        this.suppMatrix = new Matrix();
        this.displayMatrix = new Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new w12(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new Handler();
        init();
    }

    private float centerHorizontal(RectF rectF, float f, float f2) {
        float f3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237900661")) {
            return ((Float) ipChange.ipc$dispatch("-237900661", new Object[]{this, rectF, Float.valueOf(f), Float.valueOf(f2)})).floatValue();
        }
        float width = (float) getWidth();
        if (f < width) {
            width = (width - f) / 2.0f;
            f3 = rectF.left;
        } else {
            float f4 = rectF.left;
            if (f4 > 0.0f) {
                return -f4;
            }
            f3 = rectF.right;
            if (f3 >= width) {
                return f2;
            }
        }
        return width - f3;
    }

    private float centerVertical(RectF rectF, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-371219271")) {
            return ((Float) ipChange.ipc$dispatch("-371219271", new Object[]{this, rectF, Float.valueOf(f), Float.valueOf(f2)})).floatValue();
        }
        float height = (float) getHeight();
        if (f < height) {
            return ((height - f) / 2.0f) - rectF.top;
        }
        float f3 = rectF.top;
        if (f3 > 0.0f) {
            return -f3;
        }
        return rectF.bottom < height ? ((float) getHeight()) - rectF.bottom : f2;
    }

    private void getProperBaseMatrix(w12 w12, Matrix matrix, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756736074")) {
            ipChange.ipc$dispatch("756736074", new Object[]{this, w12, matrix, Boolean.valueOf(z)});
            return;
        }
        float width = (float) getWidth();
        float height = (float) getHeight();
        float e = (float) w12.e();
        float b = (float) w12.b();
        matrix.reset();
        float min = Math.min(Math.min(width / e, 3.0f), Math.min(height / b, 3.0f));
        if (z) {
            matrix.postConcat(w12.c());
        }
        matrix.postScale(min, min);
        matrix.postTranslate((width - (e * min)) / 2.0f, (height - (b * min)) / 2.0f);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1804868915")) {
            ipChange.ipc$dispatch("1804868915", new Object[]{this});
            return;
        }
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* access modifiers changed from: protected */
    public float calculateMaxZoom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2014138238")) {
            return ((Float) ipChange.ipc$dispatch("-2014138238", new Object[]{this})).floatValue();
        } else if (this.bitmapDisplayed.a() == null) {
            return 1.0f;
        } else {
            return Math.max(((float) this.bitmapDisplayed.e()) / ((float) this.thisWidth), ((float) this.bitmapDisplayed.b()) / ((float) this.thisHeight)) * 4.0f;
        }
    }

    /* access modifiers changed from: protected */
    public void center() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032341426")) {
            ipChange.ipc$dispatch("-1032341426", new Object[]{this});
            return;
        }
        Bitmap a = this.bitmapDisplayed.a();
        if (a != null) {
            Matrix imageViewMatrix = getImageViewMatrix();
            RectF rectF = new RectF(0.0f, 0.0f, (float) a.getWidth(), (float) a.getHeight());
            imageViewMatrix.mapRect(rectF);
            float height = rectF.height();
            float width = rectF.width();
            postTranslate(centerHorizontal(rectF, width, 0.0f), centerVertical(rectF, height, 0.0f));
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "639532794")) {
            ipChange.ipc$dispatch("639532794", new Object[]{this});
            return;
        }
        setImageBitmapResetBase(null, true);
    }

    /* access modifiers changed from: protected */
    public Matrix getImageViewMatrix() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-534243804")) {
            return (Matrix) ipChange.ipc$dispatch("-534243804", new Object[]{this});
        }
        this.displayMatrix.set(this.baseMatrix);
        this.displayMatrix.postConcat(this.suppMatrix);
        return this.displayMatrix;
    }

    /* access modifiers changed from: protected */
    public float getScale(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1183352835")) {
            return getValue(matrix, 0);
        }
        return ((Float) ipChange.ipc$dispatch("-1183352835", new Object[]{this, matrix})).floatValue();
    }

    public Matrix getUnrotatedMatrix() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671835884")) {
            return (Matrix) ipChange.ipc$dispatch("-671835884", new Object[]{this});
        }
        Matrix matrix = new Matrix();
        getProperBaseMatrix(this.bitmapDisplayed, matrix, false);
        matrix.postConcat(this.suppMatrix);
        return matrix;
    }

    /* access modifiers changed from: protected */
    public float getValue(Matrix matrix, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-949380673")) {
            return ((Float) ipChange.ipc$dispatch("-949380673", new Object[]{this, matrix, Integer.valueOf(i)})).floatValue();
        }
        matrix.getValues(this.matrixValues);
        return this.matrixValues[i];
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1644537150")) {
            return ((Boolean) ipChange.ipc$dispatch("-1644537150", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        } else if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        } else {
            keyEvent.startTracking();
            return true;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461171799")) {
            return ((Boolean) ipChange.ipc$dispatch("-1461171799", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        } else if (i != 4 || !keyEvent.isTracking() || keyEvent.isCanceled() || getScale() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        } else {
            zoomTo(1.0f);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787971814")) {
            ipChange.ipc$dispatch("-1787971814", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        this.thisWidth = i3 - i;
        this.thisHeight = i4 - i2;
        Runnable runnable = this.onLayoutRunnable;
        if (runnable != null) {
            this.onLayoutRunnable = null;
            runnable.run();
        }
        if (this.bitmapDisplayed.a() != null) {
            getProperBaseMatrix(this.bitmapDisplayed, this.baseMatrix, true);
            setImageMatrix(getImageViewMatrix());
        }
    }

    /* access modifiers changed from: protected */
    public void panBy(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1816980819")) {
            ipChange.ipc$dispatch("1816980819", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    /* access modifiers changed from: protected */
    public void postTranslate(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369665831")) {
            ipChange.ipc$dispatch("-369665831", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        this.suppMatrix.postTranslate(f, f2);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "353041779")) {
            ipChange.ipc$dispatch("353041779", new Object[]{this, bitmap});
            return;
        }
        setImageBitmap(bitmap, 0);
    }

    public void setImageBitmapResetBase(Bitmap bitmap, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030867563")) {
            ipChange.ipc$dispatch("-1030867563", new Object[]{this, bitmap, Boolean.valueOf(z)});
            return;
        }
        setImageRotateBitmapResetBase(new w12(bitmap, 0), z);
    }

    public void setImageRotateBitmapResetBase(final w12 w12, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1377380061")) {
            ipChange.ipc$dispatch("1377380061", new Object[]{this, w12, Boolean.valueOf(z)});
        } else if (getWidth() <= 0) {
            this.onLayoutRunnable = new Runnable() {
                /* class cn.damai.user.crop.ImageViewTouchBase.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-2041327857")) {
                        ipChange.ipc$dispatch("-2041327857", new Object[]{this});
                        return;
                    }
                    ImageViewTouchBase.this.setImageRotateBitmapResetBase(w12, z);
                }
            };
        } else {
            if (w12.a() != null) {
                getProperBaseMatrix(w12, this.baseMatrix, true);
                setImageBitmap(w12.a(), w12.d());
            } else {
                this.baseMatrix.reset();
                setImageBitmap(null);
            }
            if (z) {
                this.suppMatrix.reset();
            }
            setImageMatrix(getImageViewMatrix());
            this.maxZoom = calculateMaxZoom();
        }
    }

    public void setRecycler(Recycler recycler2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397104536")) {
            ipChange.ipc$dispatch("1397104536", new Object[]{this, recycler2});
            return;
        }
        this.recycler = recycler2;
    }

    /* access modifiers changed from: protected */
    public void zoomIn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1255234923")) {
            ipChange.ipc$dispatch("1255234923", new Object[]{this});
            return;
        }
        zoomIn(SCALE_RATE);
    }

    /* access modifiers changed from: protected */
    public void zoomOut() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "438078348")) {
            ipChange.ipc$dispatch("438078348", new Object[]{this});
            return;
        }
        zoomOut(SCALE_RATE);
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float f, float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328267083")) {
            ipChange.ipc$dispatch("1328267083", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        float f4 = this.maxZoom;
        if (f > f4) {
            f = f4;
        }
        float scale = f / getScale();
        this.suppMatrix.postScale(scale, scale, f2, f3);
        setImageMatrix(getImageViewMatrix());
        center();
    }

    private void setImageBitmap(Bitmap bitmap, int i) {
        Recycler recycler2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1940577296")) {
            ipChange.ipc$dispatch("-1940577296", new Object[]{this, bitmap, Integer.valueOf(i)});
            return;
        }
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap a = this.bitmapDisplayed.a();
        this.bitmapDisplayed.h(bitmap);
        this.bitmapDisplayed.i(i);
        if (a != null && a != bitmap && (recycler2 = this.recycler) != null) {
            recycler2.recycle(a);
        }
    }

    /* access modifiers changed from: protected */
    public float getScale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-375685857")) {
            return getScale(this.suppMatrix);
        }
        return ((Float) ipChange.ipc$dispatch("-375685857", new Object[]{this})).floatValue();
    }

    /* access modifiers changed from: protected */
    public void zoomIn(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "257603509")) {
            ipChange.ipc$dispatch("257603509", new Object[]{this, Float.valueOf(f)});
        } else if (getScale() < this.maxZoom && this.bitmapDisplayed.a() != null) {
            this.suppMatrix.postScale(f, f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    /* access modifiers changed from: protected */
    public void zoomOut(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "695553460")) {
            ipChange.ipc$dispatch("695553460", new Object[]{this, Float.valueOf(f)});
        } else if (this.bitmapDisplayed.a() != null) {
            float width = ((float) getWidth()) / 2.0f;
            float height = ((float) getHeight()) / 2.0f;
            Matrix matrix = new Matrix(this.suppMatrix);
            float f2 = 1.0f / f;
            matrix.postScale(f2, f2, width, height);
            if (getScale(matrix) < 1.0f) {
                this.suppMatrix.setScale(1.0f, 1.0f, width, height);
            } else {
                this.suppMatrix.postScale(f2, f2, width, height);
            }
            setImageMatrix(getImageViewMatrix());
            center();
        }
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float f, final float f2, final float f3, final float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773366827")) {
            ipChange.ipc$dispatch("-1773366827", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        final float scale = (f - getScale()) / f4;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        this.handler.post(new Runnable() {
            /* class cn.damai.user.crop.ImageViewTouchBase.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2057125934")) {
                    ipChange.ipc$dispatch("2057125934", new Object[]{this});
                    return;
                }
                float min = Math.min(f4, (float) (System.currentTimeMillis() - currentTimeMillis));
                ImageViewTouchBase.this.zoomTo(scale2 + (scale * min), f2, f3);
                if (min < f4) {
                    ImageViewTouchBase.this.handler.post(this);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573447691")) {
            ipChange.ipc$dispatch("573447691", new Object[]{this, Float.valueOf(f)});
            return;
        }
        zoomTo(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baseMatrix = new Matrix();
        this.suppMatrix = new Matrix();
        this.displayMatrix = new Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new w12(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new Handler();
        init();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baseMatrix = new Matrix();
        this.suppMatrix = new Matrix();
        this.displayMatrix = new Matrix();
        this.matrixValues = new float[9];
        this.bitmapDisplayed = new w12(null, 0);
        this.thisWidth = -1;
        this.thisHeight = -1;
        this.handler = new Handler();
        init();
    }
}
