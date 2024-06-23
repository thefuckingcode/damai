package cn.damai.seat.view;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.seat.R$drawable;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.SeatProfile;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.g91;
import tb.h72;
import tb.n42;
import tb.o72;
import tb.xf2;

/* compiled from: Taobao */
public class SeatView extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int ANIMATE_TIME = 300;
    private static final int AUTO_SCALE_LEVEL_SEAT_18 = 3;
    private static final int AUTO_SCALE_LEVEL_SEAT_30 = 2;
    private static final int AUTO_SCALE_LEVEL_SEAT_9 = 4;
    private static final int AUTO_SCALE_LEVEL_SEAT_ALL = 1;
    private static final int OVERVIEW_STAY_TIME = 500;
    private static final String TAG = "QILIN_SEAT";
    private int column;
    private int currentScaleLevel;
    private float defaultImgH;
    private float defaultImgW;
    private float dragMoveCoefficient;
    private boolean firstScale;
    GestureDetector gestureDetector;
    private Handler handler;
    private Runnable hideOverviewRunnable;
    float initialOffsetRectY;
    float initialOffsetY;
    private boolean isDrawOverview;
    private boolean isDrawOverviewBitmap;
    private boolean isFling;
    private boolean isOnClick;
    private boolean isScaling;
    private Paint lineNumberPaint;
    private Paint.FontMetrics lineNumberPaintFontMetrics;
    private Context mContext;
    private float mCurrentScale;
    private float mDefaultImgScaleX;
    private float mDefaultImgScaleY;
    private float mDefaultLeftRightPadding;
    private float mDefaultSeatViewHeight;
    private float mDefaultSeatViewWidth;
    private boolean mFirstDraw;
    private h72 mIconProvider;
    private OnSeatClickListener mListener;
    private Bitmap mLockedSeat;
    private int mMaxMoveOffset;
    private float mMinTranslateX;
    private int mOverViewOffsetX;
    private int mOverViewOffsetY;
    private float mOverviewH;
    private float mOverviewScale;
    private float mOverviewSeatHeight;
    private float mOverviewSeatWidth;
    private float mOverviewSpacing;
    private float mOverviewVerSpacing;
    private float mOverviewW;
    private int mPhoneScreenWidth;
    private float mScale18;
    private List<SeatNew> mSeatList;
    private SeatProfile mSeatProfile;
    private boolean mSelectdSeat;
    private long mSelectedPriceId;
    private float mSpacing;
    private float mVerSpacing;
    private int mViewHeight;
    private int mViewWidth;
    private Matrix matrix;
    private float[] matrixValues;
    private float maxOffsetScale;
    private float maxScale;
    private float minOffsetScale;
    private float minScale;
    private Bitmap noseat;
    private Bitmap noseatAlpha;
    private int numberMargin;
    private int numberWidth;
    private float offsetScale;
    private float overscreenOverviewVerSpacing;
    private int overviewBackgroundColor;
    private Bitmap overviewBitmap;
    private Paint overviewPaint;
    private float overviewSeatBottomVerSpacing;
    private float overviewSeatLeftRightSpacing;
    private Paint paint;
    private Paint pathPaint;
    private RectF rectF;
    private float redBorderBottomBoundary;
    private float redBorderLeftBoundary;
    private Paint redBorderPaint;
    private float redBorderRightBoundary;
    private float redBorderTopBoundary;
    private int row;
    private List<String> rowNumList;
    private SparseArrayCompat<List<String>> rowNumRegionList;
    ScaleGestureDetector scaleGestureDetector;
    private float scaleX;
    private float scaleY;
    private Bitmap screenBitmap;
    private String screenName;
    private Bitmap screenOverviewBitmap;
    private RectF screenRectF;
    private int seatViewPaddingBottom;
    private Matrix tempMatrix;
    private int unavailableSeatColor;
    private float zoom;

    /* compiled from: Taobao */
    public interface OnSeatClickListener {
        void onSeatClick(SeatNew seatNew, boolean z);
    }

    /* compiled from: Taobao */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ec  */
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float f;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1027196550")) {
                return ((Boolean) ipChange.ipc$dispatch("1027196550", new Object[]{this, scaleGestureDetector})).booleanValue();
            }
            SeatView.this.isScaling = true;
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            float matrixScaleX = SeatView.this.getMatrixScaleX();
            if (scaleFactor < 1.0f) {
                if (scaleFactor * matrixScaleX < SeatView.this.minOffsetScale) {
                    f = SeatView.this.minOffsetScale;
                }
                if (SeatView.this.firstScale) {
                    SeatView.this.scaleX = scaleGestureDetector.getFocusX();
                    SeatView.this.scaleY = scaleGestureDetector.getFocusY();
                    SeatView.this.firstScale = false;
                }
                if ((scaleFactor > 1.0f && matrixScaleX < SeatView.this.maxOffsetScale) || (scaleFactor < 1.0f && matrixScaleX > SeatView.this.minOffsetScale)) {
                    float f2 = scaleFactor * matrixScaleX;
                    float f3 = f2 - SeatView.this.maxScale;
                    if (SeatView.this.maxScale == SeatView.this.minScale) {
                        SeatView.this.currentScaleLevel = 4;
                    } else if (Math.abs(f3) < 0.001f || f2 > SeatView.this.maxScale) {
                        SeatView.this.currentScaleLevel = 4;
                    } else if (f3 >= 0.0f || f2 < SeatView.this.mScale18) {
                        SeatView.this.currentScaleLevel = 1;
                    } else {
                        SeatView.this.currentScaleLevel = 3;
                    }
                    SeatView.this.isDrawOverview = true;
                    SeatView.this.zoom(f2);
                }
                return true;
            }
            if (scaleFactor > 1.0f && scaleFactor * matrixScaleX > SeatView.this.maxOffsetScale) {
                f = SeatView.this.maxOffsetScale;
            }
            if (SeatView.this.firstScale) {
            }
            float f22 = scaleFactor * matrixScaleX;
            float f32 = f22 - SeatView.this.maxScale;
            if (SeatView.this.maxScale == SeatView.this.minScale) {
            }
            SeatView.this.isDrawOverview = true;
            SeatView.this.zoom(f22);
            return true;
            scaleFactor = f / matrixScaleX;
            if (SeatView.this.firstScale) {
            }
            float f222 = scaleFactor * matrixScaleX;
            float f322 = f222 - SeatView.this.maxScale;
            if (SeatView.this.maxScale == SeatView.this.minScale) {
            }
            SeatView.this.isDrawOverview = true;
            SeatView.this.zoom(f222);
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-147299547")) {
                return true;
            }
            return ((Boolean) ipChange.ipc$dispatch("-147299547", new Object[]{this, scaleGestureDetector})).booleanValue();
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-532793197")) {
                ipChange.ipc$dispatch("-532793197", new Object[]{this, scaleGestureDetector});
                return;
            }
            SeatView.this.firstScale = true;
            SeatView.this.autoScale();
        }
    }

    /* compiled from: Taobao */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-502597269")) {
                return ((Boolean) ipChange.ipc$dispatch("-502597269", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            } else if (SeatView.this.isScaling) {
                return super.onFling(motionEvent, motionEvent2, f, f2);
            } else {
                SeatView.this.flingAnimate(motionEvent, motionEvent2, f, f2);
                return true;
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1233084754")) {
                return ((Boolean) ipChange.ipc$dispatch("1233084754", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            } else if (SeatView.this.isScaling) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            } else {
                SeatView.this.isDrawOverview = true;
                int i2 = (int) ((-f) * SeatView.this.dragMoveCoefficient);
                int i3 = (int) ((-f2) * SeatView.this.dragMoveCoefficient);
                float f3 = (float) i3;
                if (SeatView.this.getTranslateY() + f3 > ((float) SeatView.this.mMaxMoveOffset) || SeatView.this.getTranslateY() + f3 + SeatView.this.getCurrentBitmapHeight() <= ((float) SeatView.this.mMaxMoveOffset)) {
                    i3 = 0;
                }
                float f4 = (float) i2;
                if (SeatView.this.getTranslateX() + f4 <= ((float) SeatView.this.mMaxMoveOffset) && SeatView.this.getTranslateX() + f4 + SeatView.this.getCurrentBitmapWidth() > ((float) SeatView.this.mMaxMoveOffset)) {
                    i = i2;
                }
                SeatView.this.matrix.postTranslate((float) i, (float) i3);
                SeatView.this.invalidate();
                return true;
            }
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1938388484")) {
                return ((Boolean) ipChange.ipc$dispatch("-1938388484", new Object[]{this, motionEvent})).booleanValue();
            }
            SeatView.this.isOnClick = true;
            if (SeatView.this.column <= 30) {
                SeatView.this.seatTabClickEvent(motionEvent);
                if (SeatView.this.currentScaleLevel != 4) {
                    SeatView.this.currentScaleLevel = 4;
                    SeatView.this.scaleX = (float) ((int) motionEvent.getX());
                    SeatView.this.scaleY = (float) ((int) motionEvent.getY());
                    SeatView seatView = SeatView.this;
                    seatView.zoomAnimate(seatView.getMatrixScaleX(), SeatView.this.maxScale);
                }
                return super.onSingleTapUp(motionEvent);
            }
            if (SeatView.this.column > 30) {
                if (SeatView.this.currentScaleLevel == 1) {
                    SeatView.this.currentScaleLevel = 3;
                    SeatView.this.scaleX = (float) ((int) motionEvent.getX());
                    SeatView.this.scaleY = (float) ((int) motionEvent.getY());
                    SeatView seatView2 = SeatView.this;
                    seatView2.zoomAnimate(seatView2.getMatrixScaleX(), SeatView.this.mScale18);
                    return super.onSingleTapUp(motionEvent);
                } else if (SeatView.this.currentScaleLevel == 3) {
                    SeatView.this.seatTabClickEvent(motionEvent);
                    SeatView.this.currentScaleLevel = 4;
                    SeatView.this.scaleX = (float) ((int) motionEvent.getX());
                    SeatView.this.scaleY = (float) ((int) motionEvent.getY());
                    SeatView seatView3 = SeatView.this;
                    seatView3.zoomAnimate(seatView3.getMatrixScaleX(), SeatView.this.maxScale);
                    return super.onSingleTapUp(motionEvent);
                }
            }
            SeatView.this.seatTabClickEvent(motionEvent);
            return true;
        }
    }

    /* compiled from: Taobao */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1473738615")) {
                ipChange.ipc$dispatch("-1473738615", new Object[]{this, valueAnimator});
                return;
            }
            SeatView.this.move((Point) valueAnimator.getAnimatedValue());
        }
    }

    /* compiled from: Taobao */
    public class d implements TypeEvaluator {
        private static transient /* synthetic */ IpChange $ipChange;

        d(SeatView seatView) {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-831390531")) {
                return ipChange.ipc$dispatch("-831390531", new Object[]{this, Float.valueOf(f), obj, obj2});
            }
            Point point = (Point) obj;
            Point point2 = (Point) obj2;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            return new Point((int) (((float) xVar) + (((float) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) - xVar)) * f)), (int) (((float) yVar) + (f * ((float) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) - yVar)))));
        }
    }

    /* compiled from: Taobao */
    public class e implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1339056167")) {
                ipChange.ipc$dispatch("-1339056167", new Object[]{this, animator});
            }
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-565947914")) {
                ipChange.ipc$dispatch("-565947914", new Object[]{this, animator});
                return;
            }
            SeatView.this.autoScroll();
        }

        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "974519448")) {
                ipChange.ipc$dispatch("974519448", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "140499407")) {
                ipChange.ipc$dispatch("140499407", new Object[]{this, animator});
            }
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "947826887")) {
                ipChange.ipc$dispatch("947826887", new Object[]{this, valueAnimator});
                return;
            }
            SeatView.this.zoom = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SeatView seatView = SeatView.this;
            seatView.zoom(seatView.zoom);
            g91.b(SeatView.TAG, "zoom:" + SeatView.this.zoom);
        }
    }

    public SeatView(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void autoScale() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012762707")) {
            ipChange.ipc$dispatch("-1012762707", new Object[]{this});
            return;
        }
        float matrixScaleX = getMatrixScaleX();
        float f = this.maxScale;
        if (matrixScaleX > f) {
            this.currentScaleLevel = 4;
            zoomAnimate(matrixScaleX, f);
            return;
        }
        float f2 = this.minScale;
        if (matrixScaleX < f2) {
            this.currentScaleLevel = 1;
            zoomAnimate(matrixScaleX, f2);
            return;
        }
        autoScroll();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b9  */
    private void autoScroll() {
        float f;
        float f2;
        float translateY;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "966163462")) {
            ipChange.ipc$dispatch("966163462", new Object[]{this});
            return;
        }
        float currentBitmapWidth = getCurrentBitmapWidth();
        float matrixScaleY = this.mDefaultSeatViewHeight * getMatrixScaleY();
        if (currentBitmapWidth <= ((float) getWidth())) {
            f = this.mMinTranslateX - getTranslateX();
        } else if (getTranslateX() >= 0.0f || getTranslateX() + currentBitmapWidth >= ((float) getWidth())) {
            f = (getTranslateX() < 0.0f || getTranslateX() + currentBitmapWidth <= ((float) getWidth())) ? 0.0f : -getTranslateX();
        } else {
            f = ((float) getWidth()) - (getTranslateX() + currentBitmapWidth);
        }
        float f3 = this.initialOffsetY;
        if (matrixScaleY + f3 <= ((float) getViewUsedHeight())) {
            translateY = getTranslateY();
        } else {
            if (getTranslateY() + matrixScaleY > ((float) getViewUsedHeight())) {
                if (getTranslateY() >= f3) {
                    translateY = getTranslateY();
                }
            } else if (getTranslateY() < 0.0f) {
                f2 = ((float) getViewUsedHeight()) - (getTranslateY() + matrixScaleY);
                if (f == 0.0f || f2 != 0.0f) {
                    Point point = new Point();
                    point.x = (int) getTranslateX();
                    point.y = (int) getTranslateY();
                    Point point2 = new Point();
                    point2.x = (int) (getTranslateX() + f);
                    point2.y = (int) (getTranslateY() + f2);
                    moveAnimate(point, point2);
                }
                return;
            }
            f2 = 0.0f;
            if (f == 0.0f) {
            }
            Point point3 = new Point();
            point3.x = (int) getTranslateX();
            point3.y = (int) getTranslateY();
            Point point22 = new Point();
            point22.x = (int) (getTranslateX() + f);
            point22.y = (int) (getTranslateY() + f2);
            moveAnimate(point3, point22);
        }
        f2 = f3 - translateY;
        if (f == 0.0f) {
        }
        Point point32 = new Point();
        point32.x = (int) getTranslateX();
        point32.y = (int) getTranslateY();
        Point point222 = new Point();
        point222.x = (int) (getTranslateX() + f);
        point222.y = (int) (getTranslateY() + f2);
        moveAnimate(point32, point222);
    }

    private void drawRowNumBar(Canvas canvas, int i, List<String> list) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167553204")) {
            ipChange.ipc$dispatch("1167553204", new Object[]{this, canvas, Integer.valueOf(i), list});
        } else if (i >= 0 && list != null && !list.isEmpty()) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    z = false;
                    break;
                } else if (!TextUtils.isEmpty(list.get(i2))) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                this.lineNumberPaint.setColor(Color.parseColor("#4D000000"));
                float matrixScaleY = getMatrixScaleY();
                float f = this.defaultImgH * matrixScaleY;
                float f2 = this.mVerSpacing * matrixScaleY;
                RectF rectF2 = this.rectF;
                float translateY = (float) ((int) getTranslateY());
                float f3 = (float) i;
                rectF2.top = (((f3 * f) + translateY) + (f3 * f2)) - ((float) n42.a(this.mContext, 10.0f));
                this.rectF.bottom = (((float) (list.size() + i)) * f) + translateY + (f2 * ((float) ((list.size() + i) - 1))) + ((float) n42.a(this.mContext, 10.0f));
                RectF rectF3 = this.rectF;
                float f4 = (float) this.numberMargin;
                rectF3.left = f4;
                rectF3.right = ((float) this.numberWidth) + f4;
                canvas.drawRoundRect(rectF3, (float) n42.a(this.mContext, 42.0f), (float) n42.a(this.mContext, 42.0f), this.lineNumberPaint);
                g91.b(TAG, "--------------------- rowNum right = " + this.rectF.right + " , left = " + this.rectF.left);
                this.lineNumberPaint.setColor(-1);
                for (int i3 = 0; i3 < list.size(); i3++) {
                    int i4 = i3 + i;
                    float f5 = (float) i4;
                    float f6 = this.defaultImgH;
                    float f7 = this.mVerSpacing;
                    float f8 = (((f5 * f6) + (((float) (i4 - 1)) * f7) + f6) * matrixScaleY) + translateY;
                    Paint.FontMetrics fontMetrics = this.lineNumberPaintFontMetrics;
                    float f9 = (((f8 + (((((f5 * f6) + (f5 * f7)) * matrixScaleY) + translateY) + (f / 2.0f))) - fontMetrics.bottom) - fontMetrics.top) / 2.0f;
                    if (!TextUtils.isEmpty(list.get(i3))) {
                        RectF rectF4 = this.rectF;
                        canvas.drawText(list.get(i3), (rectF4.right + rectF4.left) / 2.0f, f9, this.lineNumberPaint);
                    }
                }
                g91.b(TAG, "drawNumberTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private void drawScreen(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628561517")) {
            ipChange.ipc$dispatch("-1628561517", new Object[]{this, canvas});
            return;
        }
        this.pathPaint.setColor(-1);
        canvas.drawRoundRect(this.screenRectF, 0.0f, 0.0f, this.pathPaint);
        Bitmap bitmap = this.screenBitmap;
        canvas.drawBitmap(bitmap, (this.screenRectF.right - ((float) bitmap.getWidth())) / 2.0f, 0.0f, this.paint);
        this.pathPaint.setColor(Color.parseColor("#666666"));
        this.pathPaint.setTextSize((float) n42.a(this.mContext, 12.0f));
        String str = this.screenName;
        Paint paint2 = this.pathPaint;
        float f = this.screenRectF.top;
        canvas.drawText(str, (this.screenRectF.right - this.pathPaint.measureText(str)) / 2.0f, getBaseLine(paint2, f, ((float) this.screenBitmap.getHeight()) + f), this.pathPaint);
    }

    private void drawSeat(Canvas canvas) {
        float f;
        Bitmap bitmap;
        Bitmap bitmap2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1023887508")) {
            ipChange.ipc$dispatch("-1023887508", new Object[]{this, canvas});
            return;
        }
        this.zoom = getMatrixScaleX();
        long currentTimeMillis = System.currentTimeMillis();
        float translateX = getTranslateX();
        float translateY = getTranslateY();
        float f2 = this.zoom;
        float f3 = this.defaultImgH * f2;
        float f4 = this.defaultImgW * f2;
        float f5 = this.mDefaultImgScaleX * f2;
        float f6 = this.mDefaultImgScaleY * f2;
        float f7 = this.mVerSpacing * f2;
        float f8 = this.mSpacing * f2;
        float currentLeftRightPadding = translateX + getCurrentLeftRightPadding();
        int i = this.unavailableSeatColor;
        boolean z = this.mSelectedPriceId != -1;
        int i2 = 0;
        while (i2 < this.mSeatList.size()) {
            SeatNew seatNew = this.mSeatList.get(i2);
            int i3 = seatNew.x;
            SeatProfile seatProfile = this.mSeatProfile;
            float f9 = (((float) (i3 - seatProfile.minX)) * (f3 + f7)) + translateY;
            float f10 = (((float) (seatNew.y - seatProfile.minY)) * (f4 + f8)) + currentLeftRightPadding;
            if (f10 <= ((float) this.mViewWidth) && f10 + f4 >= 0.0f) {
                f = currentLeftRightPadding;
                if (f9 <= ((float) (this.mViewHeight + this.seatViewPaddingBottom)) && f9 + f3 >= translateY) {
                    this.tempMatrix.setTranslate(f10, f9);
                    this.tempMatrix.preScale(f5, f6);
                    int i4 = seatNew.state;
                    if (i4 != 2) {
                        if (i4 == 4) {
                            canvas.drawBitmap(this.mLockedSeat, this.tempMatrix, this.paint);
                        } else if (i4 != 8) {
                            if (seatNew.packageCombinedId == 0) {
                                canvas.drawBitmap(this.mIconProvider.a(i, seatNew.angle, (byte) 10, false), this.tempMatrix, this.paint);
                            } else {
                                canvas.drawBitmap(this.mIconProvider.a(i, seatNew.angle, (byte) 12, false), this.tempMatrix, this.paint);
                            }
                        } else if (z) {
                            canvas.drawBitmap(this.noseatAlpha, this.tempMatrix, this.paint);
                        } else {
                            canvas.drawBitmap(this.noseat, this.tempMatrix, this.paint);
                        }
                    } else if (seatNew.isSelected) {
                        int i5 = seatNew.seatColor;
                        if (seatNew.packageCombinedId == 0) {
                            bitmap2 = this.mIconProvider.a(i5, seatNew.angle, (byte) 11, false);
                        } else {
                            bitmap2 = this.mIconProvider.a(i5, seatNew.angle, (byte) 13, false);
                        }
                        canvas.drawBitmap(bitmap2, this.tempMatrix, this.paint);
                        i = i5;
                    } else {
                        boolean isNeedAddAlpha = isNeedAddAlpha(seatNew);
                        if (seatNew.packageCombinedId == 0) {
                            bitmap = this.mIconProvider.a(seatNew.seatColor, seatNew.angle, (byte) 10, isNeedAddAlpha);
                        } else {
                            bitmap = this.mIconProvider.a(seatNew.seatColor, seatNew.angle, (byte) 12, isNeedAddAlpha);
                        }
                        canvas.drawBitmap(bitmap, this.tempMatrix, this.paint);
                    }
                }
            } else {
                f = currentLeftRightPadding;
            }
            i2++;
            currentTimeMillis = currentTimeMillis;
            currentLeftRightPadding = f;
        }
        g91.b(TAG, "seatDrawTime:" + (System.currentTimeMillis() - currentTimeMillis) + " , transX = " + getTranslateX() + " , transY = " + getTranslateY());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d9, code lost:
        if (r6 > r12) goto L_0x00db;
     */
    private void flingAnimate(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float max;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-119025337")) {
            ipChange.ipc$dispatch("-119025337", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        this.isFling = true;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float x2 = motionEvent2.getX();
        float y2 = motionEvent2.getY();
        if (f > 0.0f && x > x2) {
            autoScroll();
        } else if (f < 0.0f && x < x2) {
            autoScroll();
        } else if (f2 < 0.0f && y < y2) {
            autoScroll();
        } else if (f2 <= 0.0f || y <= y2) {
            float f3 = f * 1.2f;
            float f4 = f2 * 1.2f;
            Point point = new Point();
            point.x = (int) getTranslateX();
            point.y = (int) getTranslateY();
            Point point2 = new Point();
            float currentBitmapWidth = getCurrentBitmapWidth();
            float currentBitmapHeight = getCurrentBitmapHeight();
            float f5 = (float) 400;
            float xVar = ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)) + ((f3 / 1000.0f) * f5 * 0.5f);
            float yVar = ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) + ((f4 / 1000.0f) * f5 * 0.5f);
            if (f3 <= 0.0f) {
                int i = this.mViewWidth;
                xVar = currentBitmapWidth > ((float) i) ? Math.max(xVar, ((float) i) - currentBitmapWidth) : Math.max(this.mMinTranslateX, xVar);
            } else if (xVar > 0.0f) {
                xVar = this.mMinTranslateX;
            }
            if (f4 > 0.0f) {
                max = this.initialOffsetY;
            } else {
                int i2 = this.mViewHeight;
                max = Math.max(yVar, currentBitmapHeight > ((float) i2) ? ((float) i2) - currentBitmapHeight : this.initialOffsetY);
            }
            yVar = max;
            point2.x = (int) xVar;
            point2.y = (int) yVar;
            moveAnimate(point, point2, (long) 400);
        } else {
            autoScroll();
        }
    }

    private float getBaseLine(Paint paint2, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1991208846")) {
            return ((Float) ipChange.ipc$dispatch("-1991208846", new Object[]{this, paint2, Float.valueOf(f), Float.valueOf(f2)})).floatValue();
        }
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        return (float) ((int) ((((f2 + f) - fontMetrics.bottom) - fontMetrics.top) / 2.0f));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float getCurrentBitmapHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1133530265")) {
            return this.mDefaultSeatViewHeight * getMatrixScaleY();
        }
        return ((Float) ipChange.ipc$dispatch("1133530265", new Object[]{this})).floatValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float getCurrentBitmapWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1714174780")) {
            return this.mDefaultSeatViewWidth * getMatrixScaleX();
        }
        return ((Float) ipChange.ipc$dispatch("-1714174780", new Object[]{this})).floatValue();
    }

    private float getCurrentLeftRightPadding() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "803757331")) {
            return getMatrixScaleX() * this.mDefaultLeftRightPadding;
        }
        return ((Float) ipChange.ipc$dispatch("803757331", new Object[]{this})).floatValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float getMatrixScaleX() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205721581")) {
            return ((Float) ipChange.ipc$dispatch("-205721581", new Object[]{this})).floatValue();
        }
        this.matrix.getValues(this.matrixValues);
        return this.matrixValues[0];
    }

    private float getMatrixScaleY() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205691790")) {
            return ((Float) ipChange.ipc$dispatch("-205691790", new Object[]{this})).floatValue();
        }
        this.matrix.getValues(this.matrixValues);
        return this.matrixValues[4];
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float getTranslateX() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766981608")) {
            return ((Float) ipChange.ipc$dispatch("-1766981608", new Object[]{this})).floatValue();
        }
        this.matrix.getValues(this.matrixValues);
        return this.matrixValues[2];
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float getTranslateY() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766951817")) {
            return ((Float) ipChange.ipc$dispatch("-1766951817", new Object[]{this})).floatValue();
        }
        this.matrix.getValues(this.matrixValues);
        return this.matrixValues[5];
    }

    private int getViewUsedHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1122896444")) {
            return getHeight() - this.seatViewPaddingBottom;
        }
        return ((Integer) ipChange.ipc$dispatch("1122896444", new Object[]{this})).intValue();
    }

    private void initData(Context context) {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1407089088")) {
            ipChange.ipc$dispatch("1407089088", new Object[]{this, context});
            return;
        }
        this.mFirstDraw = true;
        this.isDrawOverviewBitmap = true;
        int i = DisplayMetrics.getwidthPixels(n42.b(context));
        this.mPhoneScreenWidth = i;
        this.mMaxMoveOffset = i / 2;
        this.mSpacing = (float) n42.a(context, 4.0f);
        this.mVerSpacing = (float) n42.a(context, 4.0f);
        this.mDefaultLeftRightPadding = (float) n42.a(context, 8.0f);
        float a2 = (float) n42.a(context, 8.0f);
        this.defaultImgW = a2;
        this.defaultImgH = a2 / (((float) this.noseat.getWidth()) / ((float) this.noseat.getHeight()));
        this.mDefaultImgScaleX = this.defaultImgW / ((float) this.noseat.getWidth());
        this.mDefaultImgScaleY = this.defaultImgH / ((float) this.noseat.getHeight());
        int i2 = this.column;
        float f2 = this.defaultImgW;
        float f3 = this.mSpacing;
        float f4 = this.mDefaultLeftRightPadding;
        float f5 = (((float) i2) * f2) + (((float) (i2 - 1)) * f3) + (f4 * 2.0f);
        this.mDefaultSeatViewWidth = f5;
        int i3 = this.row;
        this.mDefaultSeatViewHeight = (((float) i3) * this.defaultImgH) + (((float) (i3 - 1)) * this.mVerSpacing);
        float f6 = (float) this.mPhoneScreenWidth;
        float f7 = f6 / f5;
        this.minScale = f7;
        this.currentScaleLevel = 1;
        if (i2 <= 18) {
            this.mScale18 = f7;
        } else {
            this.mScale18 = f6 / (((18.0f * f2) + (17.0f * f3)) + (f4 * 2.0f));
        }
        float f8 = f6 / (((f2 * 9.0f) + (f3 * 8.0f)) + (f4 * 2.0f));
        this.maxScale = f8;
        if (f8 <= f7) {
            this.minScale = f8;
            this.currentScaleLevel = 4;
        }
        if (i2 <= 9) {
            this.mScale18 = f8;
            this.currentScaleLevel = 4;
        }
        float f9 = this.minScale;
        float f10 = this.offsetScale;
        this.minOffsetScale = (1.0f - f10) * f9;
        this.maxOffsetScale = f8 * (f10 + 1.0f);
        this.mCurrentScale = f9;
        float a3 = (float) n42.a(context, 4.0f);
        float f11 = a3 / this.defaultImgW;
        this.mOverviewScale = f11;
        this.mOverviewSeatHeight = a3;
        this.mOverviewSeatWidth = a3;
        this.mOverviewSpacing = this.mSpacing * f11;
        this.mOverviewVerSpacing = this.mVerSpacing * f11;
        float a4 = (float) n42.a(context, 6.0f);
        this.overviewSeatBottomVerSpacing = a4;
        this.overviewSeatLeftRightSpacing = a4;
        float f12 = this.mOverviewVerSpacing;
        this.overscreenOverviewVerSpacing = ((float) n42.a(context, 2.0f)) + f12;
        int i4 = this.row;
        float height = (((float) i4) * this.mOverviewSeatHeight) + (((float) (i4 - 1)) * f12) + this.overviewSeatBottomVerSpacing + ((float) this.screenOverviewBitmap.getHeight()) + this.overscreenOverviewVerSpacing;
        this.mOverviewH = height;
        int i5 = this.column;
        float f13 = (((float) i5) * this.mOverviewSeatWidth) + (((float) (i5 - 1)) * this.mOverviewSpacing) + (this.overviewSeatLeftRightSpacing * 2.0f);
        this.mOverviewW = f13;
        float f14 = this.overviewSeatLeftRightSpacing;
        float height2 = ((float) this.screenOverviewBitmap.getHeight()) + f14;
        float f15 = f14 * 2.0f;
        float f16 = ((float) this.mPhoneScreenWidth) * 0.4f;
        float f17 = this.mOverviewW;
        if (f17 > f16 || this.mOverviewH > f16) {
            float max = f16 / Math.max(f17, this.mOverviewH);
            this.mOverviewH *= max;
            this.mOverviewW *= max;
        }
        float width = (float) (this.screenOverviewBitmap.getWidth() + n42.a(context, 24.0f));
        float f18 = this.mOverviewW;
        if (f18 < width) {
            float f19 = this.mOverviewH * (width / f18);
            this.mOverviewH = f19;
            this.mOverviewW = width;
            if (f19 > f16) {
                this.mOverviewH = f16;
                f = (f16 - height2) / (height - f15);
            } else {
                f = (width - f15) / (f13 - f15);
            }
        } else {
            f = (f18 - f15) / (f13 - f15);
        }
        float f20 = this.mOverviewScale * f;
        this.mOverviewScale = f20;
        float f21 = a3 * f;
        this.mOverviewSeatHeight = f21;
        this.mOverviewSeatWidth = f21;
        this.mOverviewSpacing = this.mSpacing * f20;
        this.mOverviewVerSpacing = this.mVerSpacing * f20;
        this.overscreenOverviewVerSpacing *= f;
        this.overviewBitmap = Bitmap.createBitmap((int) this.mOverviewW, (int) this.mOverviewH, Bitmap.Config.ARGB_8888);
        this.mOverViewOffsetX = ScreenUtil.dip2px(this.mContext, 9.0f);
        Bitmap bitmap = this.screenBitmap;
        if (bitmap != null) {
            this.mOverViewOffsetY = bitmap.getHeight();
        } else {
            this.mOverViewOffsetY = ScreenUtil.dip2px(this.mContext, 9.0f);
        }
        this.rectF = new RectF();
        this.numberWidth = n42.a(context, 20.0f);
        this.numberMargin = n42.a(context, 10.0f);
        RectF rectF2 = new RectF();
        this.screenRectF = rectF2;
        rectF2.left = 0.0f;
        rectF2.top = 0.0f;
        rectF2.right = (float) this.mPhoneScreenWidth;
        rectF2.bottom = (float) n42.a(context, 30.0f);
        this.screenName = context.getString(R$string.trade_seat_stage);
    }

    private void initPaintData(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-938181160")) {
            ipChange.ipc$dispatch("-938181160", new Object[]{this, context});
            return;
        }
        this.paint = new Paint(1);
        Paint paint2 = new Paint(1);
        this.pathPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.redBorderPaint = paint3;
        paint3.setAntiAlias(true);
        this.redBorderPaint.setColor(Color.parseColor("#fa1155"));
        this.redBorderPaint.setStyle(Paint.Style.STROKE);
        this.redBorderPaint.setStrokeWidth((float) n42.a(context, 2.0f));
        this.overviewBackgroundColor = Color.parseColor("#66000000");
        Paint paint4 = new Paint(1);
        this.lineNumberPaint = paint4;
        paint4.setTextSize(getResources().getDisplayMetrics().density * 12.0f);
        this.lineNumberPaintFontMetrics = this.lineNumberPaint.getFontMetrics();
        this.lineNumberPaint.setTextAlign(Paint.Align.CENTER);
    }

    private void initSeatImageData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "832716152")) {
            ipChange.ipc$dispatch("832716152", new Object[]{this});
            return;
        }
        try {
            this.noseat = this.mIconProvider.d(0.0f, (byte) 14, false);
            this.noseatAlpha = this.mIconProvider.d(0.0f, (byte) 14, true);
            this.mLockedSeat = this.mIconProvider.b(0.0f);
            Resources resources = getResources();
            this.screenBitmap = BitmapFactory.decodeResource(resources, R$drawable.trade_seat_stage);
            this.screenOverviewBitmap = BitmapFactory.decodeResource(resources, R$drawable.trade_seat_overview_screen);
            this.unavailableSeatColor = Color.parseColor("#e9e9e9");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean isNeedAddAlpha(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328260684")) {
            return ((Boolean) ipChange.ipc$dispatch("-328260684", new Object[]{this, seatNew})).booleanValue();
        }
        long j = this.mSelectedPriceId;
        if (j == -1) {
            return false;
        }
        if ((seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel) != j) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void move(Point point) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-98010668")) {
            ipChange.ipc$dispatch("-98010668", new Object[]{this, point});
            return;
        }
        this.matrix.postTranslate(((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point)) - getTranslateX(), ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) - getTranslateY());
        invalidate();
    }

    private void moveAnimate(Point point, Point point2, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319786394")) {
            ipChange.ipc$dispatch("-319786394", new Object[]{this, point, point2, Long.valueOf(j)});
            return;
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new d(this), point, point2);
        ofObject.setInterpolator(new DecelerateInterpolator());
        ofObject.addUpdateListener(new c());
        ofObject.setDuration(j);
        ofObject.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void seatTabClickEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1429514587")) {
            ipChange.ipc$dispatch("1429514587", new Object[]{this, motionEvent});
            return;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        try {
            float translateX = getTranslateX() + getCurrentLeftRightPadding();
            float translateY = getTranslateY();
            float matrixScaleY = getMatrixScaleY();
            float matrixScaleX = getMatrixScaleX();
            float f = this.defaultImgH * matrixScaleY;
            float f2 = this.defaultImgW * matrixScaleX;
            float f3 = this.mVerSpacing * matrixScaleY;
            float f4 = this.mSpacing * matrixScaleX;
            int size = this.mSeatList.size();
            int i = 0;
            while (i < size) {
                SeatNew seatNew = this.mSeatList.get(i);
                int i2 = seatNew.x;
                SeatProfile seatProfile = this.mSeatProfile;
                float f5 = (((float) (i2 - seatProfile.minX)) * (f + f3)) + translateY;
                float f6 = f5 + f;
                float f7 = (((float) (seatNew.y - seatProfile.minY)) * (f2 + f4)) + translateX;
                float f8 = f7 + f2;
                float f9 = (float) x;
                if (f9 >= f7 && f9 <= f8) {
                    float f10 = (float) y;
                    if (f10 >= f5 && f10 <= f6) {
                        if (this.mListener != null && seatNew.state == o72.SEAT_STATUS_AVAILABLE.shortValue()) {
                            boolean z = seatNew.isSelected;
                            if (!z) {
                                this.isDrawOverview = true;
                                this.mSelectdSeat = true;
                            }
                            this.mListener.onSeatClick(seatNew, !z);
                            return;
                        }
                        return;
                    }
                }
                i++;
                translateX = translateX;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setRowNumListWithSeatData(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1685046440")) {
            ipChange.ipc$dispatch("-1685046440", new Object[]{this, list});
            return;
        }
        this.rowNumList.clear();
        this.rowNumRegionList.clear();
        if (!(list == null || list.size() == 0)) {
            int i = -1;
            int i2 = 0;
            for (int size = list.size() - 1; size >= 0; size--) {
                SeatNew seatNew = list.get(size);
                int i3 = seatNew.x;
                if (i != i3) {
                    String str = "";
                    if (i == -1) {
                        i2++;
                        Integer b2 = xf2.b(seatNew.rn);
                        List<String> list2 = this.rowNumList;
                        if (b2 != null) {
                            str = b2 + str;
                        }
                        list2.add(str);
                        this.rowNumRegionList.put(i2, this.rowNumList);
                        i = seatNew.x;
                    } else {
                        int i4 = i3 - i;
                        if (i4 == 1) {
                            i2++;
                            Integer b3 = xf2.b(seatNew.rn);
                            List<String> list3 = this.rowNumList;
                            if (b3 != null) {
                                str = b3 + str;
                            }
                            list3.add(str);
                        } else {
                            for (int i5 = 0; i5 < i4; i5++) {
                                i2++;
                                if (i5 == i4 - 1) {
                                    if (i4 == 2) {
                                        this.rowNumList.add(str);
                                        Integer b4 = xf2.b(seatNew.rn);
                                        this.rowNumList.add(b4 == null ? str : b4 + str);
                                    } else {
                                        this.rowNumList = new ArrayList();
                                        Integer b5 = xf2.b(seatNew.rn);
                                        this.rowNumList.add(b5 == null ? str : b5 + str);
                                        this.rowNumRegionList.put(i2, this.rowNumList);
                                    }
                                }
                            }
                        }
                        i = seatNew.x;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zoom(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1559466575")) {
            ipChange.ipc$dispatch("-1559466575", new Object[]{this, Float.valueOf(f)});
            return;
        }
        float matrixScaleX = f / getMatrixScaleX();
        this.matrix.postScale(matrixScaleX, matrixScaleX, this.scaleX, this.scaleY);
        invalidate();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zoomAnimate(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-376808230")) {
            ipChange.ipc$dispatch("-376808230", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        e eVar = new e();
        ofFloat.addUpdateListener(eVar);
        ofFloat.addListener(eVar);
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* access modifiers changed from: package-private */
    public void drawNumber(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "68058352")) {
            ipChange.ipc$dispatch("68058352", new Object[]{this, canvas});
        } else if (this.rowNumRegionList.size() != 0) {
            for (int i = 0; i < this.rowNumRegionList.size(); i++) {
                drawRowNumBar(canvas, this.rowNumRegionList.keyAt(i) - 1, this.rowNumRegionList.valueAt(i));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Bitmap drawOverview() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2123513981")) {
            return (Bitmap) ipChange.ipc$dispatch("-2123513981", new Object[]{this});
        }
        this.isDrawOverviewBitmap = false;
        this.overviewPaint.setColor(this.overviewBackgroundColor);
        this.overviewPaint.setStyle(Paint.Style.FILL);
        this.overviewBitmap.eraseColor(0);
        Canvas canvas = new Canvas(this.overviewBitmap);
        float dip2px = (float) ScreenUtil.dip2px(this.mContext, 2.0f);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, this.mOverviewW, this.mOverviewH), dip2px, dip2px, this.overviewPaint);
        Bitmap bitmap = this.screenOverviewBitmap;
        canvas.drawBitmap(bitmap, (this.mOverviewW - ((float) bitmap.getWidth())) / 2.0f, 0.0f, this.paint);
        float height = ((float) this.screenOverviewBitmap.getHeight()) + this.overscreenOverviewVerSpacing;
        float f = this.mOverviewSeatWidth;
        int i = this.column;
        float f2 = (this.mOverviewW - ((f * ((float) i)) + (this.mOverviewSpacing * ((float) (i - 1))))) / 2.0f;
        for (int i2 = 0; i2 < this.mSeatList.size(); i2++) {
            SeatNew seatNew = this.mSeatList.get(i2);
            int i3 = seatNew.y;
            SeatProfile seatProfile = this.mSeatProfile;
            float f3 = (((float) (i3 - seatProfile.minY)) * (this.mOverviewSeatWidth + this.mOverviewSpacing)) + f2;
            float f4 = (((float) (seatNew.x - seatProfile.minX)) * (this.mOverviewSeatHeight + this.mOverviewVerSpacing)) + height;
            int i4 = seatNew.state;
            if (i4 != 2) {
                if (i4 == 4) {
                    this.overviewPaint.setColor(this.unavailableSeatColor);
                } else if (i4 != 8) {
                    this.overviewPaint.setColor(this.unavailableSeatColor);
                } else {
                    this.overviewPaint.setColor(this.unavailableSeatColor);
                }
            } else if (seatNew.isSelected) {
                this.overviewPaint.setColor(Color.parseColor("#47A231"));
            } else {
                this.overviewPaint.setColor(seatNew.seatColor);
            }
            canvas.drawRect(f3, f4, this.mOverviewSeatWidth + f3, f4 + this.mOverviewSeatHeight, this.overviewPaint);
        }
        return this.overviewBitmap;
    }

    public void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565854838")) {
            ipChange.ipc$dispatch("565854838", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        initSeatImageData();
        initPaintData(context);
        initData(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        List<SeatNew> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649842298")) {
            ipChange.ipc$dispatch("-1649842298", new Object[]{this, canvas});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mSeatProfile != null && (list = this.mSeatList) != null && !list.isEmpty()) {
            try {
                if (this.mFirstDraw) {
                    this.mViewWidth = getWidth();
                    this.mViewHeight = getViewUsedHeight();
                    this.initialOffsetY = ((float) n42.a(this.mContext, 10.0f)) + this.mVerSpacing + this.screenRectF.bottom;
                    this.initialOffsetRectY = this.mOverviewH + ((float) n42.a(this.mContext, 10.0f));
                    this.mMinTranslateX = 0.0f;
                    if (this.currentScaleLevel == 4) {
                        float f = this.minScale;
                        float f2 = this.maxScale;
                        if (f == f2) {
                            float f3 = this.mDefaultSeatViewWidth * f2;
                            int i = this.mPhoneScreenWidth;
                            if (f3 < ((float) i)) {
                                this.mMinTranslateX = (((float) i) - f3) / 2.0f;
                            }
                        }
                    }
                    this.matrix.setTranslate(this.mMinTranslateX, this.initialOffsetY);
                    float f4 = this.mCurrentScale;
                    if (f4 != 1.0f) {
                        this.matrix.preScale(f4, f4);
                    }
                    float f5 = this.mOverviewSeatWidth;
                    int i2 = this.column;
                    float f6 = this.mOverviewW;
                    this.redBorderLeftBoundary = ((((float) (getWidth() - this.mOverViewOffsetX)) - f6) + ((f6 - ((f5 * ((float) i2)) + (this.mOverviewSpacing * ((float) (i2 - 1))))) / 2.0f)) - this.redBorderPaint.getStrokeWidth();
                    this.redBorderTopBoundary = ((((float) this.screenOverviewBitmap.getHeight()) + this.overscreenOverviewVerSpacing) + ((float) this.mOverViewOffsetY)) - this.redBorderPaint.getStrokeWidth();
                    this.redBorderRightBoundary = (((float) this.column) * (this.mOverviewSeatWidth + this.mOverviewSpacing)) + this.redBorderPaint.getStrokeWidth() + this.redBorderLeftBoundary;
                    this.redBorderBottomBoundary = (((float) this.row) * (this.mOverviewSeatHeight + this.mOverviewVerSpacing)) + this.redBorderPaint.getStrokeWidth() + this.redBorderTopBoundary;
                    this.mFirstDraw = false;
                }
                drawSeat(canvas);
                if (this.currentScaleLevel == 4) {
                    drawNumber(canvas);
                }
                drawScreen(canvas);
                if (this.isDrawOverview) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (this.isDrawOverviewBitmap) {
                        drawOverview();
                    }
                    canvas.drawBitmap(this.overviewBitmap, (((float) getWidth()) - this.mOverviewW) - ((float) this.mOverViewOffsetX), (float) this.mOverViewOffsetY, (Paint) null);
                    drawOverview(canvas);
                    g91.b(TAG, "OverviewDrawTime:" + (System.currentTimeMillis() - currentTimeMillis2));
                }
                g91.b(TAG, "totalDrawTime:" + (System.currentTimeMillis() - currentTimeMillis) + " ,scale = " + getMatrixScaleX() + " ,padding = " + getCurrentLeftRightPadding() + " , seatSize = " + (this.defaultImgW * getMatrixScaleX()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794049119")) {
            return ((Boolean) ipChange.ipc$dispatch("-1794049119", new Object[]{this, motionEvent})).booleanValue();
        }
        this.scaleGestureDetector.onTouchEvent(motionEvent);
        this.gestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mSelectdSeat = false;
            this.handler.removeCallbacks(this.hideOverviewRunnable);
        } else if (action == 1) {
            if (!this.mSelectdSeat) {
                this.handler.postDelayed(this.hideOverviewRunnable, 500);
            }
            if (!this.isScaling && !this.isFling) {
                autoScroll();
            }
            this.isScaling = false;
            this.isFling = false;
            this.isOnClick = false;
        }
        return true;
    }

    public void setData(SeatProfile seatProfile) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2044560055")) {
            ipChange.ipc$dispatch("2044560055", new Object[]{this, seatProfile});
        } else if (seatProfile != null) {
            this.mSeatProfile = seatProfile;
            List<SeatNew> list = seatProfile.seatList;
            this.mSeatList = list;
            this.row = (seatProfile.maxX - seatProfile.minX) + 1;
            this.column = (seatProfile.maxY - seatProfile.minY) + 1;
            setRowNumListWithSeatData(list);
        }
    }

    public void setListener(OnSeatClickListener onSeatClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-329690922")) {
            ipChange.ipc$dispatch("-329690922", new Object[]{this, onSeatClickListener});
            return;
        }
        this.mListener = onSeatClickListener;
    }

    public void setProvider(h72 h72) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814151514")) {
            ipChange.ipc$dispatch("-1814151514", new Object[]{this, h72});
            return;
        }
        this.mIconProvider = h72;
    }

    public void setSelectedPriceId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1050070519")) {
            ipChange.ipc$dispatch("-1050070519", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mSelectedPriceId = j;
    }

    public void setSelectedPriceIdAndZoomToSeat(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2052422911")) {
            ipChange.ipc$dispatch("2052422911", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mSelectedPriceId = j;
        if (j == -1) {
            invalidate();
            return;
        }
        this.isDrawOverview = false;
        float matrixScaleX = getMatrixScaleX();
        this.currentScaleLevel = 1;
        zoomAnimate(matrixScaleX, this.minScale);
    }

    public void updateData(SeatProfile seatProfile) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2019080150")) {
            ipChange.ipc$dispatch("-2019080150", new Object[]{this, seatProfile});
            return;
        }
        this.mSeatProfile = seatProfile;
        invalidate();
    }

    public SeatView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SeatView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFirstDraw = true;
        this.mMinTranslateX = 0.0f;
        this.currentScaleLevel = 3;
        this.offsetScale = 0.25f;
        this.dragMoveCoefficient = 0.75f;
        this.isDrawOverviewBitmap = true;
        this.firstScale = true;
        this.overviewPaint = new Paint();
        this.matrix = new Matrix();
        this.tempMatrix = new Matrix();
        this.matrixValues = new float[9];
        this.mSeatList = new ArrayList();
        this.mSelectedPriceId = -1;
        this.rowNumList = new ArrayList();
        this.rowNumRegionList = new SparseArrayCompat<>();
        this.handler = new Handler();
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), new a());
        this.gestureDetector = new GestureDetector(getContext(), new b());
        this.hideOverviewRunnable = new Runnable() {
            /* class cn.damai.seat.view.SeatView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-431060786")) {
                    ipChange.ipc$dispatch("-431060786", new Object[]{this});
                    return;
                }
                SeatView.this.isDrawOverview = false;
                SeatView.this.invalidate();
            }
        };
        this.seatViewPaddingBottom = n42.a(context, 48.0f);
    }

    private void moveAnimate(Point point, Point point2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "959514654")) {
            ipChange.ipc$dispatch("959514654", new Object[]{this, point, point2});
            return;
        }
        moveAnimate(point, point2, 300);
    }

    private void drawOverview(Canvas canvas) {
        float f;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1372496544")) {
            ipChange.ipc$dispatch("-1372496544", new Object[]{this, canvas});
            return;
        }
        float matrixScaleX = this.redBorderLeftBoundary + (((-getTranslateX()) / getMatrixScaleX()) * this.mOverviewScale);
        float f2 = this.redBorderLeftBoundary;
        if (matrixScaleX < f2) {
            matrixScaleX = f2;
        }
        float translateX = getTranslateX();
        int i2 = this.column;
        int matrixScaleX2 = (int) (translateX + (((((float) i2) * this.defaultImgW) + (this.mSpacing * ((float) (i2 - 1)))) * getMatrixScaleX()));
        float width = this.redBorderRightBoundary - ((((float) (matrixScaleX2 > getWidth() ? matrixScaleX2 - getWidth() : 0)) / getMatrixScaleX()) * this.mOverviewScale);
        if (getTranslateY() > this.screenRectF.bottom) {
            f = 0.0f;
        } else {
            f = -(getTranslateY() - this.screenRectF.bottom);
        }
        float matrixScaleX3 = this.redBorderTopBoundary + ((f / getMatrixScaleX()) * this.mOverviewScale);
        float f3 = this.redBorderTopBoundary;
        if (matrixScaleX3 < f3) {
            matrixScaleX3 = f3;
        }
        float translateY = getTranslateY();
        int i3 = this.row;
        int matrixScaleY = (int) (translateY + (((((float) i3) * this.defaultImgH) + (this.mVerSpacing * ((float) (i3 - 1)))) * getMatrixScaleY()));
        if (matrixScaleY > getHeight()) {
            i = matrixScaleY - getHeight();
        }
        float matrixScaleX4 = this.redBorderBottomBoundary - ((((float) i) / getMatrixScaleX()) * this.mOverviewScale);
        if (matrixScaleX >= width) {
            matrixScaleX = width - this.redBorderPaint.getStrokeWidth();
        }
        canvas.drawRect(matrixScaleX, matrixScaleX4 <= matrixScaleX3 ? matrixScaleX4 - this.redBorderPaint.getStrokeWidth() : matrixScaleX3, width, matrixScaleX4, this.redBorderPaint);
    }
}
