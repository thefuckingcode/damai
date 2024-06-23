package cn.damai.baseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import cn.damai.uikit.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ak2;
import tb.nu2;

/* compiled from: Taobao */
public class CropImageView extends ImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "CropImageView";
    Paint background;
    Paint blackPaint;
    Context context;
    boolean isLock = false;
    boolean isRotated;
    float[] m;
    GestureDetector mGestureDetector;
    ScaleGestureDetector mScaleDetector;
    Matrix matrix;
    float maxScale = 5.0f;
    float minScale = 1.0f;
    int oldMeasuredHeight;
    protected float origHeight;
    protected float origWidth;
    float saveScale = 1.0f;
    Paint semitransparent;
    Paint transparent;
    int viewHeight;
    int viewWidth;
    Paint whitePaint;
    Paint whitetransparent;
    float widthToHeightRatio = 1.0f;
    float y1;
    float y2;

    /* compiled from: Taobao */
    public class a implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-102414755")) {
                return ((Boolean) ipChange.ipc$dispatch("-102414755", new Object[]{this, view, motionEvent})).booleanValue();
            }
            CropImageView cropImageView = CropImageView.this;
            if (!cropImageView.isLock) {
                cropImageView.mScaleDetector.onTouchEvent(motionEvent);
                CropImageView.this.mGestureDetector.onTouchEvent(motionEvent);
                CropImageView cropImageView2 = CropImageView.this;
                cropImageView2.setImageMatrix(cropImageView2.matrix);
            } else if (motionEvent.getAction() == 0) {
                CropImageView cropImageView3 = CropImageView.this;
                Paint paint = cropImageView3.background;
                Paint paint2 = cropImageView3.blackPaint;
                if (paint == paint2) {
                    cropImageView3.background = cropImageView3.whitePaint;
                } else {
                    cropImageView3.background = paint2;
                }
                cropImageView3.invalidate();
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private b() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1043149376")) {
                return true;
            }
            return ((Boolean) ipChange.ipc$dispatch("1043149376", new Object[]{this, motionEvent})).booleanValue();
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1107001203")) {
                return ((Boolean) ipChange.ipc$dispatch("1107001203", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            nu2.d("msg", "onFling");
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-408970166")) {
                return ((Boolean) ipChange.ipc$dispatch("-408970166", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            CropImageView cropImageView = CropImageView.this;
            if (!cropImageView.isLock) {
                cropImageView.translate(-f, -f2);
            }
            return true;
        }

        /* synthetic */ b(CropImageView cropImageView, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    public class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private c() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float f;
            float f2;
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2039487232")) {
                return ((Boolean) ipChange.ipc$dispatch("-2039487232", new Object[]{this, scaleGestureDetector})).booleanValue();
            }
            if (!CropImageView.this.isLock) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                CropImageView cropImageView = CropImageView.this;
                float f3 = cropImageView.saveScale;
                float f4 = f3 * scaleFactor;
                cropImageView.saveScale = f4;
                float f5 = cropImageView.maxScale;
                if (f4 > f5) {
                    cropImageView.saveScale = f5;
                } else {
                    f5 = cropImageView.minScale;
                    if (f4 < f5) {
                        cropImageView.saveScale = f5;
                    }
                    f = cropImageView.origWidth;
                    f2 = cropImageView.saveScale;
                    i = cropImageView.viewWidth;
                    if (f * f2 > ((float) i) || cropImageView.origHeight * f2 <= ((float) cropImageView.viewHeight)) {
                        cropImageView.matrix.postScale(scaleFactor, scaleFactor, (float) (i / 2), (float) (cropImageView.viewHeight / 2));
                    } else {
                        cropImageView.matrix.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    }
                    CropImageView.this.fixScaling();
                }
                scaleFactor = f5 / f3;
                f = cropImageView.origWidth;
                f2 = cropImageView.saveScale;
                i = cropImageView.viewWidth;
                if (f * f2 > ((float) i)) {
                }
                cropImageView.matrix.postScale(scaleFactor, scaleFactor, (float) (i / 2), (float) (cropImageView.viewHeight / 2));
                CropImageView.this.fixScaling();
            }
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "22298859")) {
                return true;
            }
            return ((Boolean) ipChange.ipc$dispatch("22298859", new Object[]{this, scaleGestureDetector})).booleanValue();
        }

        /* synthetic */ c(CropImageView cropImageView, a aVar) {
            this();
        }
    }

    public CropImageView(Context context2) {
        super(context2);
        setup(context2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fixScaling() {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629859037")) {
            ipChange.ipc$dispatch("629859037", new Object[]{this});
            return;
        }
        this.matrix.getValues(this.m);
        float[] fArr = this.m;
        float f3 = fArr[2];
        float f4 = fArr[5];
        float f5 = this.saveScale;
        float f6 = (this.origWidth * f5) + f3;
        float f7 = (f5 * this.origHeight) + f4;
        if (f3 > 0.0f) {
            f = 0.0f - f3;
        } else {
            int i = this.viewWidth;
            f = f6 < ((float) i) ? ((float) i) - f6 : 0.0f;
        }
        float f8 = this.y1;
        if (f4 > f8) {
            f2 = f8 - f4;
        } else {
            float f9 = this.y2;
            f2 = f7 < f9 ? f9 - f7 : 0.0f;
        }
        if (f != 0.0f || f2 != 0.0f) {
            this.matrix.postTranslate(f, f2);
        }
    }

    private void initialize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440749631")) {
            ipChange.ipc$dispatch("1440749631", new Object[]{this});
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.viewWidth;
            float f = (float) intrinsicWidth;
            float f2 = (float) intrinsicHeight;
            float max = Math.max(((float) i) / f, ((float) i) / f2);
            this.matrix.setScale(max, max);
            float f3 = (((float) this.viewHeight) - (f2 * max)) / 2.0f;
            float f4 = (((float) this.viewWidth) - (max * f)) / 2.0f;
            this.matrix.postTranslate(f4, f3);
            this.origWidth = ((float) this.viewWidth) - (f4 * 2.0f);
            this.origHeight = ((float) this.viewHeight) - (f3 * 2.0f);
            fixScaling();
        }
    }

    private void setup(Context context2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "901520458")) {
            ipChange.ipc$dispatch("901520458", new Object[]{this, context2});
            return;
        }
        super.setClickable(true);
        this.context = context2;
        Paint paint = new Paint();
        this.semitransparent = paint;
        paint.setColor(-16777216);
        this.semitransparent.setAlpha(200);
        Paint paint2 = new Paint();
        this.transparent = paint2;
        paint2.setColor(-1);
        this.transparent.setAlpha(0);
        Paint paint3 = new Paint();
        this.whitetransparent = paint3;
        paint3.setColor(14408667);
        this.whitetransparent.setAlpha(200);
        Paint paint4 = new Paint();
        this.whitePaint = paint4;
        paint4.setColor(-1);
        Paint paint5 = new Paint();
        this.blackPaint = paint5;
        paint5.setColor(-16777216);
        this.background = this.blackPaint;
        this.mScaleDetector = new ScaleGestureDetector(context2, new c(this, null));
        this.mGestureDetector = new GestureDetector(context2, new b(this, null));
        Matrix matrix2 = new Matrix();
        this.matrix = matrix2;
        this.m = new float[9];
        setImageMatrix(matrix2);
        setScaleType(ImageView.ScaleType.MATRIX);
        setOnTouchListener(new a());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void translate(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1414475123")) {
            ipChange.ipc$dispatch("-1414475123", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        this.matrix.getValues(this.m);
        float[] fArr = this.m;
        float f3 = fArr[2];
        float f4 = fArr[5];
        float f5 = this.saveScale;
        float f6 = (this.origWidth * f5) + f3;
        float f7 = (f5 * this.origHeight) + f4;
        if (f > 0.0f) {
            if (f3 > 0.0f || f + f3 > 0.0f) {
                f = 0.0f - f3;
            }
        } else if (f < 0.0f) {
            int i = this.viewWidth;
            if (f6 < ((float) i) || f + f6 < ((float) i)) {
                f = ((float) i) - f6;
            }
        } else {
            f = 0.0f;
        }
        if (f2 > 0.0f) {
            float f8 = this.y1;
            if (f4 <= f8) {
                if (f4 > f8 || f2 + f4 > f8) {
                    f2 = f8 - f4;
                }
                if (f == 0.0f || f2 != 0.0f) {
                    this.matrix.postTranslate(f, f2);
                }
                return;
            }
        }
        if (f2 < 0.0f) {
            float f9 = this.y2;
            if (f7 < f9 || f2 + f7 < f9) {
                f2 = f9 - f7;
            }
        } else {
            f2 = 0.0f;
        }
        if (f == 0.0f) {
        }
        this.matrix.postTranslate(f, f2);
    }

    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-579844550")) {
            ipChange.ipc$dispatch("-579844550", new Object[]{this, canvas});
            return;
        }
        RectF rectF = new RectF(0.0f, this.y1, (float) this.viewWidth, this.y2);
        canvas.drawRect(rectF, this.background);
        super.draw(canvas);
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) this.viewWidth, this.y1 - 2.0f);
        float f = this.y1;
        RectF rectF3 = new RectF(0.0f, f - 2.0f, (float) this.viewWidth, f);
        float f2 = this.y2;
        RectF rectF4 = new RectF(0.0f, f2, (float) this.viewWidth, f2 + 2.0f);
        RectF rectF5 = new RectF(0.0f, this.y2 + 2.0f, (float) this.viewWidth, (float) this.viewHeight);
        canvas.drawRect(rectF2, this.semitransparent);
        canvas.drawRect(rectF3, this.whitetransparent);
        canvas.drawRect(rectF5, this.semitransparent);
        canvas.drawRect(rectF4, this.whitetransparent);
        canvas.drawRect(rectF, this.transparent);
    }

    public boolean isLock() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2078112062")) {
            return this.isLock;
        }
        return ((Boolean) ipChange.ipc$dispatch("2078112062", new Object[]{this})).booleanValue();
    }

    public void lock() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806975044")) {
            ipChange.ipc$dispatch("1806975044", new Object[]{this});
            return;
        }
        this.isLock = true;
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            nu2.d("msg", "w:" + intrinsicWidth + "  h:" + intrinsicHeight + " ddd");
            int i = this.viewWidth;
            float f = (float) intrinsicWidth;
            float f2 = (float) intrinsicHeight;
            float min = Math.min(((float) i) / f, ((float) i) / f2);
            this.matrix.setScale(min, min);
            float f3 = (((float) this.viewHeight) - (f2 * min)) / 2.0f;
            float f4 = (((float) this.viewWidth) - (min * f)) / 2.0f;
            this.matrix.postTranslate(f4, f3);
            this.origWidth = ((float) this.viewWidth) - (f4 * 2.0f);
            this.origHeight = ((float) this.viewHeight) - (f3 * 2.0f);
            setImageMatrix(this.matrix);
            this.background = this.blackPaint;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189485660")) {
            ipChange.ipc$dispatch("1189485660", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        this.viewWidth = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.viewHeight = size;
        int i3 = this.viewWidth;
        int i4 = (int) (((float) i3) / this.widthToHeightRatio);
        float f = (float) ((size - i4) / 2);
        this.y1 = f;
        this.y2 = f + ((float) i4);
        int i5 = this.oldMeasuredHeight;
        if ((i5 != i3 || i5 != size) && i3 != 0 && size != 0) {
            this.oldMeasuredHeight = size;
            if (this.saveScale == 1.0f || this.isRotated) {
                if (this.isRotated) {
                    this.isRotated = false;
                    this.saveScale = 1.0f;
                }
                initialize();
                setImageMatrix(this.matrix);
            }
        }
    }

    public Bitmap rotate(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786500147")) {
            return (Bitmap) ipChange.ipc$dispatch("-1786500147", new Object[]{this, Integer.valueOf(i)});
        }
        Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        if (!(i == 0 || bitmap == null)) {
            Matrix matrix2 = new Matrix();
            matrix2.setRotate((float) i, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
                if (bitmap != createBitmap) {
                    bitmap = createBitmap;
                }
            } catch (OutOfMemoryError e) {
                nu2.b(TAG, "fail to rotate bitmap" + e.getMessage());
            }
        }
        this.isRotated = true;
        this.isLock = false;
        setImageBitmap(bitmap);
        return bitmap;
    }

    public void setLock(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687153914")) {
            ipChange.ipc$dispatch("-687153914", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            lock();
            Context context2 = this.context;
            Toast.makeText(context2, ak2.a(context2, R$string.data_string_028), 0).show();
        } else {
            unlock();
            Context context3 = this.context;
            Toast.makeText(context3, ak2.a(context3, R$string.data_string_029), 0).show();
        }
    }

    public void unlock() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "74724619")) {
            ipChange.ipc$dispatch("74724619", new Object[]{this});
            return;
        }
        this.isLock = false;
        initialize();
        this.background = this.blackPaint;
        setImageMatrix(this.matrix);
        invalidate();
    }

    public CropImageView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        setup(context2);
    }

    public Bitmap rotate(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931128057")) {
            return (Bitmap) ipChange.ipc$dispatch("-931128057", new Object[]{this, bitmap, Integer.valueOf(i)});
        }
        if (!(i == 0 || bitmap == null)) {
            Matrix matrix2 = new Matrix();
            matrix2.setRotate((float) i, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
                if (bitmap != createBitmap) {
                    bitmap.recycle();
                    bitmap = createBitmap;
                }
            } catch (OutOfMemoryError e) {
                nu2.b(TAG, "fail to rotate bitmap" + e.getMessage());
            }
        }
        this.isRotated = true;
        setImageBitmap(bitmap);
        return bitmap;
    }
}
