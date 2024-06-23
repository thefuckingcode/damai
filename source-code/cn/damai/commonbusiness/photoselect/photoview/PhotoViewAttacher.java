package cn.damai.commonbusiness.photoselect.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.core.view.MotionEventCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.fl;

/* compiled from: Taobao */
public class PhotoViewAttacher implements View.OnLayoutChangeListener, View.OnTouchListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static float E = 3.0f;
    private static float F = 1.75f;
    private static float G = 1.0f;
    private static int H = 200;
    private static int I = 1;
    private float A;
    private boolean B = true;
    private ImageView.ScaleType C = ImageView.ScaleType.FIT_CENTER;
    private OnGestureListener D = new a();
    private Interpolator a = new AccelerateDecelerateInterpolator();
    private int b = H;
    private float c = G;
    private float d = F;
    private float e = E;
    private boolean f = true;
    private boolean g = false;
    private ImageView h;
    private GestureDetector i;
    private a j;
    private final Matrix k = new Matrix();
    private final Matrix l = new Matrix();
    private final Matrix m = new Matrix();
    private final RectF n = new RectF();
    private final float[] o = new float[9];
    private OnMatrixChangedListener p;
    private OnPhotoTapListener q;
    private OnOutsidePhotoTapListener r;
    private OnViewTapListener s;
    private View.OnClickListener t;
    private View.OnLongClickListener u;
    private OnScaleChangedListener v;
    private OnSingleFlingListener w;
    private OnViewDragListener x;
    private FlingRunnable y;
    private int z = 2;

    /* compiled from: Taobao */
    public class AnimatedZoomRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.mFocalX = f3;
            this.mFocalY = f4;
            this.mZoomStart = f;
            this.mZoomEnd = f2;
        }

        private float interpolate() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "498116020")) {
                return ((Float) ipChange.ipc$dispatch("498116020", new Object[]{this})).floatValue();
            }
            return PhotoViewAttacher.this.a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / ((float) PhotoViewAttacher.this.b)));
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1595199482")) {
                ipChange.ipc$dispatch("1595199482", new Object[]{this});
                return;
            }
            float interpolate = interpolate();
            float f = this.mZoomStart;
            PhotoViewAttacher.this.D.onScale((f + ((this.mZoomEnd - f) * interpolate)) / PhotoViewAttacher.this.N(), this.mFocalX, this.mFocalY);
            if (interpolate < 1.0f) {
                fl.a(PhotoViewAttacher.this.h, this);
            }
        }
    }

    /* compiled from: Taobao */
    public class FlingRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private int mCurrentX;
        private int mCurrentY;
        private final OverScroller mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = new OverScroller(context);
        }

        public void cancelFling() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1000757775")) {
                ipChange.ipc$dispatch("1000757775", new Object[]{this});
                return;
            }
            this.mScroller.forceFinished(true);
        }

        public void fling(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1954571083")) {
                ipChange.ipc$dispatch("-1954571083", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                return;
            }
            RectF E = PhotoViewAttacher.this.E();
            if (E != null) {
                int round = Math.round(-E.left);
                float f = (float) i;
                if (f < E.width()) {
                    i5 = Math.round(E.width() - f);
                    i6 = 0;
                } else {
                    i6 = round;
                    i5 = i6;
                }
                int round2 = Math.round(-E.top);
                float f2 = (float) i2;
                if (f2 < E.height()) {
                    i7 = Math.round(E.height() - f2);
                    i8 = 0;
                } else {
                    i8 = round2;
                    i7 = i8;
                }
                this.mCurrentX = round;
                this.mCurrentY = round2;
                if (round != i5 || round2 != i7) {
                    this.mScroller.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "14159334")) {
                ipChange.ipc$dispatch("14159334", new Object[]{this});
            } else if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttacher.this.m.postTranslate((float) (this.mCurrentX - currX), (float) (this.mCurrentY - currY));
                PhotoViewAttacher.this.B();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                fl.a(PhotoViewAttacher.this.h, this);
            }
        }
    }

    /* compiled from: Taobao */
    public class a implements OnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.photoselect.photoview.OnGestureListener
        public void onDrag(float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-439298242")) {
                ipChange.ipc$dispatch("-439298242", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            } else if (!PhotoViewAttacher.this.j.e()) {
                if (PhotoViewAttacher.this.x != null) {
                    PhotoViewAttacher.this.x.onDrag(f, f2);
                }
                PhotoViewAttacher.this.m.postTranslate(f, f2);
                PhotoViewAttacher.this.B();
                ViewParent parent = PhotoViewAttacher.this.h.getParent();
                if (!PhotoViewAttacher.this.f || PhotoViewAttacher.this.j.e() || PhotoViewAttacher.this.g) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((PhotoViewAttacher.this.z == 2 || ((PhotoViewAttacher.this.z == 0 && f >= 1.0f) || (PhotoViewAttacher.this.z == 1 && f <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }

        @Override // cn.damai.commonbusiness.photoselect.photoview.OnGestureListener
        public void onFling(float f, float f2, float f3, float f4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1959056068")) {
                ipChange.ipc$dispatch("-1959056068", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
                return;
            }
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            photoViewAttacher.y = new FlingRunnable(photoViewAttacher.h.getContext());
            FlingRunnable flingRunnable = PhotoViewAttacher.this.y;
            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
            int J = photoViewAttacher2.J(photoViewAttacher2.h);
            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
            flingRunnable.fling(J, photoViewAttacher3.I(photoViewAttacher3.h), (int) f3, (int) f4);
            PhotoViewAttacher.this.h.post(PhotoViewAttacher.this.y);
        }

        @Override // cn.damai.commonbusiness.photoselect.photoview.OnGestureListener
        public void onScale(float f, float f2, float f3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1926337422")) {
                ipChange.ipc$dispatch("-1926337422", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            } else if (PhotoViewAttacher.this.N() >= PhotoViewAttacher.this.e && f >= 1.0f) {
            } else {
                if (PhotoViewAttacher.this.N() > PhotoViewAttacher.this.c || f > 1.0f) {
                    if (PhotoViewAttacher.this.v != null) {
                        PhotoViewAttacher.this.v.onScaleChange(f, f2, f3);
                    }
                    PhotoViewAttacher.this.m.postScale(f, f, f2, f3);
                    PhotoViewAttacher.this.B();
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-260084727")) {
                return ((Boolean) ipChange.ipc$dispatch("-260084727", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            } else if (PhotoViewAttacher.this.w == null || PhotoViewAttacher.this.N() > PhotoViewAttacher.G || MotionEventCompat.getPointerCount(motionEvent) > PhotoViewAttacher.I || MotionEventCompat.getPointerCount(motionEvent2) > PhotoViewAttacher.I) {
                return false;
            } else {
                return PhotoViewAttacher.this.w.onFling(motionEvent, motionEvent2, f, f2);
            }
        }

        public void onLongPress(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1922878533")) {
                ipChange.ipc$dispatch("1922878533", new Object[]{this, motionEvent});
            } else if (PhotoViewAttacher.this.u != null) {
                PhotoViewAttacher.this.u.onLongClick(PhotoViewAttacher.this.h);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements GestureDetector.OnDoubleTapListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "476032669")) {
                return ((Boolean) ipChange.ipc$dispatch("476032669", new Object[]{this, motionEvent})).booleanValue();
            }
            try {
                float N = PhotoViewAttacher.this.N();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (N < PhotoViewAttacher.this.L()) {
                    PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                    photoViewAttacher.n0(photoViewAttacher.L(), x, y, true);
                } else if (N < PhotoViewAttacher.this.L() || N >= PhotoViewAttacher.this.K()) {
                    PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                    photoViewAttacher2.n0(photoViewAttacher2.M(), x, y, true);
                } else {
                    PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                    photoViewAttacher3.n0(photoViewAttacher3.K(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1984082651")) {
                return false;
            }
            return ((Boolean) ipChange.ipc$dispatch("-1984082651", new Object[]{this, motionEvent})).booleanValue();
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1457014935")) {
                return ((Boolean) ipChange.ipc$dispatch("-1457014935", new Object[]{this, motionEvent})).booleanValue();
            }
            if (PhotoViewAttacher.this.t != null) {
                PhotoViewAttacher.this.t.onClick(PhotoViewAttacher.this.h);
            }
            RectF E = PhotoViewAttacher.this.E();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (PhotoViewAttacher.this.s != null) {
                PhotoViewAttacher.this.s.onViewTap(PhotoViewAttacher.this.h, x, y);
            }
            if (E != null) {
                if (E.contains(x, y)) {
                    float width = (x - E.left) / E.width();
                    float height = (y - E.top) / E.height();
                    if (PhotoViewAttacher.this.q != null) {
                        PhotoViewAttacher.this.q.onPhotoTap(PhotoViewAttacher.this.h, width, height);
                    }
                    return true;
                } else if (PhotoViewAttacher.this.r != null) {
                    PhotoViewAttacher.this.r.onOutsidePhotoTap(PhotoViewAttacher.this.h);
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        this.h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (!imageView.isInEditMode()) {
            this.A = 0.0f;
            this.j = new a(imageView.getContext(), this.D);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
            this.i = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new c());
        }
    }

    private void A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154211068")) {
            ipChange.ipc$dispatch("-154211068", new Object[]{this});
            return;
        }
        FlingRunnable flingRunnable = this.y;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.y = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604769326")) {
            ipChange.ipc$dispatch("-1604769326", new Object[]{this});
        } else if (C()) {
            W(G());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094  */
    private boolean C() {
        float f2;
        float J;
        float f3;
        float f4;
        float f5;
        float f6;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1223077172")) {
            return ((Boolean) ipChange.ipc$dispatch("-1223077172", new Object[]{this})).booleanValue();
        }
        RectF F2 = F(G());
        if (F2 == null) {
            return false;
        }
        float height = F2.height();
        float width = F2.width();
        float I2 = (float) I(this.h);
        float f7 = 0.0f;
        if (height <= I2) {
            int i2 = d.a[this.C.ordinal()];
            if (i2 == 2) {
                f5 = F2.top;
                f2 = -f5;
                J = (float) J(this.h);
                if (width > J) {
                    int i3 = d.a[this.C.ordinal()];
                    if (i3 != 2) {
                        if (i3 != 3) {
                            f3 = (J - width) / 2.0f;
                            f4 = F2.left;
                        } else {
                            f3 = J - width;
                            f4 = F2.left;
                        }
                        f7 = f3 - f4;
                    } else {
                        f7 = -F2.left;
                    }
                    this.z = 2;
                } else {
                    float f8 = F2.left;
                    if (f8 > 0.0f) {
                        this.z = 0;
                        f7 = -f8;
                    } else {
                        float f9 = F2.right;
                        if (f9 < J) {
                            f7 = J - f9;
                            this.z = 1;
                        } else {
                            this.z = -1;
                        }
                    }
                }
                this.m.postTranslate(f7, f2);
                return true;
            } else if (i2 != 3) {
                I2 = (I2 - height) / 2.0f;
                f6 = F2.top;
            } else {
                I2 -= height;
                f6 = F2.top;
            }
        } else {
            f5 = F2.top;
            if (f5 <= 0.0f) {
                f6 = F2.bottom;
                if (f6 >= I2) {
                    f2 = 0.0f;
                    J = (float) J(this.h);
                    if (width > J) {
                    }
                    this.m.postTranslate(f7, f2);
                    return true;
                }
            }
            f2 = -f5;
            J = (float) J(this.h);
            if (width > J) {
            }
            this.m.postTranslate(f7, f2);
            return true;
        }
        f2 = I2 - f6;
        J = (float) J(this.h);
        if (width > J) {
        }
        this.m.postTranslate(f7, f2);
        return true;
    }

    private RectF F(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-696603905")) {
            return (RectF) ipChange.ipc$dispatch("-696603905", new Object[]{this, matrix});
        }
        Drawable drawable = this.h.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    private Matrix G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "332662935")) {
            return (Matrix) ipChange.ipc$dispatch("332662935", new Object[]{this});
        }
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int I(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1121871584")) {
            return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        }
        return ((Integer) ipChange.ipc$dispatch("-1121871584", new Object[]{this, imageView})).intValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int J(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1804080183")) {
            return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        }
        return ((Integer) ipChange.ipc$dispatch("1804080183", new Object[]{this, imageView})).intValue();
    }

    private float Q(Matrix matrix, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633915008")) {
            return ((Float) ipChange.ipc$dispatch("633915008", new Object[]{this, matrix, Integer.valueOf(i2)})).floatValue();
        }
        matrix.getValues(this.o);
        return this.o[i2];
    }

    private void T() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143873366")) {
            ipChange.ipc$dispatch("1143873366", new Object[]{this});
            return;
        }
        this.m.reset();
        k0(this.A);
        W(G());
        C();
    }

    private void W(Matrix matrix) {
        RectF F2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "832121239")) {
            ipChange.ipc$dispatch("832121239", new Object[]{this, matrix});
            return;
        }
        this.h.setImageMatrix(matrix);
        if (this.p != null && (F2 = F(matrix)) != null) {
            this.p.onMatrixChanged(F2);
        }
    }

    private void u0(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-172649619")) {
            ipChange.ipc$dispatch("-172649619", new Object[]{this, drawable});
        } else if (drawable != null) {
            float J = (float) J(this.h);
            float I2 = (float) I(this.h);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.k.reset();
            float f2 = (float) intrinsicWidth;
            float f3 = J / f2;
            float f4 = (float) intrinsicHeight;
            float f5 = I2 / f4;
            ImageView.ScaleType scaleType = this.C;
            if (scaleType == ImageView.ScaleType.CENTER) {
                this.k.postTranslate((J - f2) / 2.0f, (I2 - f4) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f3, f5);
                this.k.postScale(max, max);
                this.k.postTranslate((J - (f2 * max)) / 2.0f, (I2 - (f4 * max)) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f3, f5));
                this.k.postScale(min, min);
                this.k.postTranslate((J - (f2 * min)) / 2.0f, (I2 - (f4 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
                RectF rectF2 = new RectF(0.0f, 0.0f, J, I2);
                if (((int) this.A) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, f4, f2);
                }
                int i2 = d.a[this.C.ordinal()];
                if (i2 == 1) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i2 == 2) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            T();
        }
    }

    public void D(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661776251")) {
            ipChange.ipc$dispatch("-1661776251", new Object[]{this, matrix});
            return;
        }
        matrix.set(G());
    }

    public RectF E() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328872819")) {
            return (RectF) ipChange.ipc$dispatch("328872819", new Object[]{this});
        }
        C();
        return F(G());
    }

    public Matrix H() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "34097418")) {
            return this.l;
        }
        return (Matrix) ipChange.ipc$dispatch("34097418", new Object[]{this});
    }

    public float K() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1841055030")) {
            return this.e;
        }
        return ((Float) ipChange.ipc$dispatch("1841055030", new Object[]{this})).floatValue();
    }

    public float L() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1999962101")) {
            return this.d;
        }
        return ((Float) ipChange.ipc$dispatch("1999962101", new Object[]{this})).floatValue();
    }

    public float M() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "730616100")) {
            return this.c;
        }
        return ((Float) ipChange.ipc$dispatch("730616100", new Object[]{this})).floatValue();
    }

    public float N() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1175755040")) {
            return (float) Math.sqrt((double) (((float) Math.pow((double) Q(this.m, 0), 2.0d)) + ((float) Math.pow((double) Q(this.m, 3), 2.0d))));
        }
        return ((Float) ipChange.ipc$dispatch("1175755040", new Object[]{this})).floatValue();
    }

    public ImageView.ScaleType O() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-608238694")) {
            return this.C;
        }
        return (ImageView.ScaleType) ipChange.ipc$dispatch("-608238694", new Object[]{this});
    }

    public void P(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995047729")) {
            ipChange.ipc$dispatch("-1995047729", new Object[]{this, matrix});
            return;
        }
        matrix.set(this.m);
    }

    @Deprecated
    public boolean R() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "179264550")) {
            return this.B;
        }
        return ((Boolean) ipChange.ipc$dispatch("179264550", new Object[]{this})).booleanValue();
    }

    public boolean S() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2138534705")) {
            return this.B;
        }
        return ((Boolean) ipChange.ipc$dispatch("2138534705", new Object[]{this})).booleanValue();
    }

    public void U(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2105593893")) {
            ipChange.ipc$dispatch("-2105593893", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        this.f = z2;
    }

    public boolean V(Matrix matrix) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1073201411")) {
            return ((Boolean) ipChange.ipc$dispatch("-1073201411", new Object[]{this, matrix})).booleanValue();
        } else if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        } else if (this.h.getDrawable() == null) {
            return false;
        } else {
            this.m.set(matrix);
            B();
            return true;
        }
    }

    public void X(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305569722")) {
            ipChange.ipc$dispatch("-305569722", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        b.a(this.c, this.d, f2);
        this.e = f2;
    }

    public void Y(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1505623601")) {
            ipChange.ipc$dispatch("-1505623601", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        b.a(this.c, f2, this.e);
        this.d = f2;
    }

    public void Z(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369438184")) {
            ipChange.ipc$dispatch("-369438184", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        b.a(f2, this.d, this.e);
        this.c = f2;
    }

    public void a0(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1983760624")) {
            ipChange.ipc$dispatch("1983760624", new Object[]{this, onClickListener});
            return;
        }
        this.t = onClickListener;
    }

    public void b0(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278543802")) {
            ipChange.ipc$dispatch("-278543802", new Object[]{this, onDoubleTapListener});
            return;
        }
        this.i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void c0(View.OnLongClickListener onLongClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995093872")) {
            ipChange.ipc$dispatch("1995093872", new Object[]{this, onLongClickListener});
            return;
        }
        this.u = onLongClickListener;
    }

    public void d0(OnMatrixChangedListener onMatrixChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1327188091")) {
            ipChange.ipc$dispatch("1327188091", new Object[]{this, onMatrixChangedListener});
            return;
        }
        this.p = onMatrixChangedListener;
    }

    public void e0(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1408182691")) {
            ipChange.ipc$dispatch("-1408182691", new Object[]{this, onOutsidePhotoTapListener});
            return;
        }
        this.r = onOutsidePhotoTapListener;
    }

    public void f0(OnPhotoTapListener onPhotoTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677503831")) {
            ipChange.ipc$dispatch("-1677503831", new Object[]{this, onPhotoTapListener});
            return;
        }
        this.q = onPhotoTapListener;
    }

    public void g0(OnScaleChangedListener onScaleChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160902599")) {
            ipChange.ipc$dispatch("160902599", new Object[]{this, onScaleChangedListener});
            return;
        }
        this.v = onScaleChangedListener;
    }

    public void h0(OnSingleFlingListener onSingleFlingListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723338467")) {
            ipChange.ipc$dispatch("-723338467", new Object[]{this, onSingleFlingListener});
            return;
        }
        this.w = onSingleFlingListener;
    }

    public void i0(OnViewDragListener onViewDragListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-781537319")) {
            ipChange.ipc$dispatch("-781537319", new Object[]{this, onViewDragListener});
            return;
        }
        this.x = onViewDragListener;
    }

    public void j0(OnViewTapListener onViewTapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2039060573")) {
            ipChange.ipc$dispatch("2039060573", new Object[]{this, onViewTapListener});
            return;
        }
        this.s = onViewTapListener;
    }

    public void k0(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-160215951")) {
            ipChange.ipc$dispatch("-160215951", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        this.m.postRotate(f2 % 360.0f);
        B();
    }

    public void l0(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345873557")) {
            ipChange.ipc$dispatch("345873557", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        this.m.setRotate(f2 % 360.0f);
        B();
    }

    public void m0(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-657279740")) {
            ipChange.ipc$dispatch("-657279740", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        o0(f2, false);
    }

    public void n0(float f2, float f3, float f4, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-238438576")) {
            ipChange.ipc$dispatch("-238438576", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z2)});
        } else if (f2 < this.c || f2 > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        } else if (z2) {
            this.h.post(new AnimatedZoomRunnable(N(), f2, f3, f4));
        } else {
            this.m.setScale(f2, f2, f3, f4);
            B();
        }
    }

    public void o0(float f2, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099210320")) {
            ipChange.ipc$dispatch("1099210320", new Object[]{this, Float.valueOf(f2), Boolean.valueOf(z2)});
            return;
        }
        n0(f2, (float) (this.h.getRight() / 2), (float) (this.h.getBottom() / 2), z2);
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037848839")) {
            ipChange.ipc$dispatch("1037848839", new Object[]{this, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)});
        } else if (i2 != i6 || i3 != i7 || i4 != i8 || i5 != i9) {
            u0(this.h.getDrawable());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d0  */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        a aVar;
        boolean z3;
        GestureDetector gestureDetector;
        RectF E2;
        IpChange ipChange = $ipChange;
        boolean z4 = false;
        if (AndroidInstantRuntime.support(ipChange, "-2027327739")) {
            return ((Boolean) ipChange.ipc$dispatch("-2027327739", new Object[]{this, view, motionEvent})).booleanValue();
        }
        if (!this.B || !b.c((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            A();
        } else if (action == 1 || action == 3) {
            if (N() < this.c) {
                RectF E3 = E();
                if (E3 != null) {
                    view.post(new AnimatedZoomRunnable(N(), this.c, E3.centerX(), E3.centerY()));
                }
            } else if (N() > this.e && (E2 = E()) != null) {
                view.post(new AnimatedZoomRunnable(N(), this.e, E2.centerX(), E2.centerY()));
            }
            z2 = true;
            aVar = this.j;
            if (aVar == null) {
                boolean e2 = aVar.e();
                boolean d2 = this.j.d();
                boolean f2 = this.j.f(motionEvent);
                boolean z5 = !e2 && !this.j.e();
                boolean z6 = !d2 && !this.j.d();
                if (z5 && z6) {
                    z4 = true;
                }
                this.g = z4;
                z3 = f2;
            } else {
                z3 = z2;
            }
            gestureDetector = this.i;
            if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        z2 = false;
        aVar = this.j;
        if (aVar == null) {
        }
        gestureDetector = this.i;
        return gestureDetector == null ? z3 : z3;
    }

    public void p0(float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076981869")) {
            ipChange.ipc$dispatch("-1076981869", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        b.a(f2, f3, f4);
        this.c = f2;
        this.d = f3;
        this.e = f4;
    }

    public void q0(ImageView.ScaleType scaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-470518404")) {
            ipChange.ipc$dispatch("-470518404", new Object[]{this, scaleType});
        } else if (b.d(scaleType) && scaleType != this.C) {
            this.C = scaleType;
            t0();
        }
    }

    public void r0(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "763381115")) {
            ipChange.ipc$dispatch("763381115", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.b = i2;
    }

    public void s0(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1312140547")) {
            ipChange.ipc$dispatch("-1312140547", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        this.B = z2;
        t0();
    }

    public void t0() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639559067")) {
            ipChange.ipc$dispatch("1639559067", new Object[]{this});
        } else if (this.B) {
            u0(this.h.getDrawable());
        } else {
            T();
        }
    }
}
