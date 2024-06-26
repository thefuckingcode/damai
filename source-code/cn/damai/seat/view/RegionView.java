package cn.damai.seat.view;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.g70;
import tb.g91;
import tb.n42;

/* compiled from: Taobao */
public class RegionView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int ANIMATE_TIME = 300;
    private static final int DEFAULT_LEFT_RIGHT_MARGION = 15;
    private static final String TAG = "QILIN_REGION";
    private boolean firstScale = true;
    private Handler handler = new Handler();
    private boolean isScaling;
    private int mClickPosition;
    private Bitmap mContentBitmap;
    private boolean mFirstDraw;
    GestureDetector mGestureDetector = new GestureDetector(getContext(), new b());
    private Paint mInvalidRegionBorderPaint;
    private Paint mInvalidRegionPaint;
    private int mLeftRightPadding;
    private OnRegionClickListener mListener;
    private float mMaxScale;
    private float mMinScale;
    private Paint mPaint;
    private Paint mRegionBorderPaint;
    private Path mRegionBorderPath;
    private c mRegionConfig;
    private int mRegionImageHeight;
    private int mRegionImageWidth;
    private Bitmap mRegionLayerBitmap;
    private Canvas mRegionLayerCanvas;
    private Paint mRegionPaint;
    private Rect mRegionRect;
    private List<Region> mRegions;
    private boolean mReset;
    private int mScrollOffsetHeigh;
    private int mScrollOffsetWidth;
    private long mSelectedPriceId = -1;
    private Rect mSrcBitmapRect;
    private Point mTempPoint;
    private int mViewHeight;
    private int mViewWidth;
    private float maxOffsetScale;
    private float minOffsetScale;
    private float offsetScale = 0.25f;
    ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(getContext(), new a());
    private float scaleX;
    private float scaleY;
    private Runnable updateSelectedRegionRunnable = new Runnable() {
        /* class cn.damai.seat.view.RegionView.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2035531391")) {
                ipChange.ipc$dispatch("-2035531391", new Object[]{this});
                return;
            }
            RegionView.this.mClickPosition = -1;
            RegionView.this.invalidate();
        }
    };

    /* compiled from: Taobao */
    public interface OnRegionClickListener {
        void onRegion(Region region);
    }

    /* compiled from: Taobao */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float f;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1947645834")) {
                return ((Boolean) ipChange.ipc$dispatch("-1947645834", new Object[]{this, scaleGestureDetector})).booleanValue();
            }
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            float currentScale = RegionView.this.getCurrentScale();
            float f2 = scaleFactor * currentScale;
            if (scaleFactor < 1.0f) {
                if (f2 < RegionView.this.minOffsetScale) {
                    f = RegionView.this.minOffsetScale;
                }
                if (RegionView.this.firstScale) {
                    RegionView.this.scaleX = scaleGestureDetector.getFocusX();
                    RegionView.this.scaleY = scaleGestureDetector.getFocusY();
                    RegionView.this.firstScale = false;
                }
                if ((scaleFactor > 1.0f && f2 < RegionView.this.maxOffsetScale) || (scaleFactor < 1.0f && f2 > RegionView.this.minOffsetScale)) {
                    RegionView.this.zoom(f2);
                }
                return true;
            }
            if (scaleFactor > 1.0f && f2 > RegionView.this.maxOffsetScale) {
                f = RegionView.this.maxOffsetScale;
            }
            if (RegionView.this.firstScale) {
            }
            RegionView.this.zoom(f2);
            return true;
            scaleFactor = f / currentScale;
            if (RegionView.this.firstScale) {
            }
            RegionView.this.zoom(f2);
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "949786421")) {
                return ((Boolean) ipChange.ipc$dispatch("949786421", new Object[]{this, scaleGestureDetector})).booleanValue();
            }
            RegionView.this.isScaling = true;
            RegionView.this.firstScale = true;
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1707069277")) {
                ipChange.ipc$dispatch("-1707069277", new Object[]{this, scaleGestureDetector});
            }
        }
    }

    /* compiled from: Taobao */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private float a;
        private float b;

        b() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1276781368")) {
                return ((Boolean) ipChange.ipc$dispatch("1276781368", new Object[]{this, motionEvent})).booleanValue();
            }
            this.a = RegionView.this.mRegionConfig.c;
            this.b = RegionView.this.mRegionConfig.d;
            return super.onDown(motionEvent);
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "331010427")) {
                return ((Boolean) ipChange.ipc$dispatch("331010427", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            } else if (RegionView.this.isScaling) {
                return super.onFling(motionEvent, motionEvent2, f, f2);
            } else {
                return true;
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1305119554")) {
                return ((Boolean) ipChange.ipc$dispatch("1305119554", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            } else if (RegionView.this.isScaling) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            } else {
                RegionView.this.mTempPoint.x = (int) ((this.a + motionEvent2.getX()) - motionEvent.getX());
                RegionView.this.mTempPoint.y = (int) ((this.b + motionEvent2.getY()) - motionEvent.getY());
                RegionView regionView = RegionView.this;
                regionView.move(regionView.mTempPoint);
                return true;
            }
        }

        public void onShowPress(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1336777720")) {
                ipChange.ipc$dispatch("1336777720", new Object[]{this, motionEvent});
                return;
            }
            super.onShowPress(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1927819764")) {
                return ((Boolean) ipChange.ipc$dispatch("-1927819764", new Object[]{this, motionEvent})).booleanValue();
            }
            RegionView.this.click(motionEvent.getX(), motionEvent.getY());
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* compiled from: Taobao */
    public class c {
        private static transient /* synthetic */ IpChange $ipChange;
        float a;
        float b;
        float c;
        float d;
        float e;

        private c() {
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 1.0f;
        }

        public void a(float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1516011549")) {
                ipChange.ipc$dispatch("1516011549", new Object[]{this, Float.valueOf(f2)});
                return;
            }
            this.a = f2;
            this.e = f2 / ((float) RegionView.this.mRegionImageWidth);
            this.b = ((float) RegionView.this.mRegionImageHeight) * this.e;
        }
    }

    /* compiled from: Taobao */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1155390728")) {
                ipChange.ipc$dispatch("-1155390728", new Object[]{this, valueAnimator});
                return;
            }
            RegionView.this.move((Point) valueAnimator.getAnimatedValue());
        }
    }

    /* compiled from: Taobao */
    public class e implements TypeEvaluator {
        private static transient /* synthetic */ IpChange $ipChange;

        e(RegionView regionView) {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1889822892")) {
                return ipChange.ipc$dispatch("1889822892", new Object[]{this, Float.valueOf(f), obj, obj2});
            }
            Point point = (Point) obj;
            Point point2 = (Point) obj2;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            return new Point((int) (((float) xVar) + (((float) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) - xVar)) * f)), (int) (((float) yVar) + (f * ((float) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) - yVar)))));
        }
    }

    /* compiled from: Taobao */
    public class f implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-926090230")) {
                ipChange.ipc$dispatch("-926090230", new Object[]{this, animator});
            }
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2061841563")) {
                ipChange.ipc$dispatch("-2061841563", new Object[]{this, animator});
                return;
            }
            RegionView.this.autoScroll();
        }

        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1387485385")) {
                ipChange.ipc$dispatch("1387485385", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1400746878")) {
                ipChange.ipc$dispatch("1400746878", new Object[]{this, animator});
            }
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1266174774")) {
                ipChange.ipc$dispatch("1266174774", new Object[]{this, valueAnimator});
                return;
            }
            RegionView.this.zoom(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public RegionView(Context context) {
        super(context);
        init(context);
    }

    private boolean autoScale() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-604360158")) {
            return ((Boolean) ipChange.ipc$dispatch("-604360158", new Object[]{this})).booleanValue();
        }
        float currentScale = getCurrentScale();
        float f2 = this.mMaxScale;
        if (currentScale > f2) {
            zoomAnimate(currentScale, f2);
            return true;
        }
        float f3 = this.mMinScale;
        if (currentScale >= f3) {
            return false;
        }
        zoomAnimate(currentScale, f3);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean autoScroll() {
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "741740473")) {
            return ((Boolean) ipChange.ipc$dispatch("741740473", new Object[]{this})).booleanValue();
        }
        float f3 = 0.0f;
        if (this.mRegionConfig.a <= ((float) getWidth())) {
            f2 = (((float) getWidth()) - this.mRegionConfig.a) / 2.0f;
        } else {
            c cVar = this.mRegionConfig;
            float f4 = cVar.c;
            if (f4 >= 0.0f || f4 + cVar.a <= ((float) getWidth())) {
                c cVar2 = this.mRegionConfig;
                f2 = cVar2.c + cVar2.a <= ((float) getWidth()) ? ((float) getWidth()) - this.mRegionConfig.a : 0.0f;
            } else {
                f2 = this.mRegionConfig.c;
            }
        }
        if (this.mRegionConfig.b <= ((float) getHeight())) {
            f3 = (((float) getHeight()) - this.mRegionConfig.b) / 2.0f;
        } else {
            c cVar3 = this.mRegionConfig;
            float f5 = cVar3.d;
            if (f5 >= 0.0f || f5 + cVar3.b <= ((float) getHeight())) {
                c cVar4 = this.mRegionConfig;
                if (cVar4.d + cVar4.b <= ((float) getHeight())) {
                    f3 = ((float) getHeight()) - this.mRegionConfig.b;
                }
            } else {
                f3 = this.mRegionConfig.d;
            }
        }
        c cVar5 = this.mRegionConfig;
        if (f2 == cVar5.c && f3 == cVar5.d) {
            return false;
        }
        Point point = new Point();
        c cVar6 = this.mRegionConfig;
        point.x = (int) cVar6.c;
        point.y = (int) cVar6.d;
        Point point2 = new Point();
        point2.x = (int) f2;
        point2.y = (int) f3;
        moveAnimate(point, point2);
        return true;
    }

    private boolean buildDrawArea() {
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1113198082")) {
            return ((Boolean) ipChange.ipc$dispatch("-1113198082", new Object[]{this})).booleanValue();
        }
        c cVar = this.mRegionConfig;
        if (cVar == null) {
            return false;
        }
        float f3 = 0.0f;
        float max = Math.max(0.0f, cVar.d);
        float max2 = Math.max(0.0f, this.mRegionConfig.c);
        c cVar2 = this.mRegionConfig;
        float min = Math.min((float) this.mViewHeight, cVar2.b + cVar2.d);
        c cVar3 = this.mRegionConfig;
        float min2 = Math.min((float) this.mViewWidth, cVar3.c + cVar3.a);
        c cVar4 = this.mRegionConfig;
        float f4 = cVar4.e;
        float f5 = (min - max) / f4;
        float f6 = (min2 - max2) / f4;
        float f7 = cVar4.d;
        if (max == f7) {
            f2 = 0.0f;
        } else {
            f2 = Math.abs(f7 / f4);
        }
        c cVar5 = this.mRegionConfig;
        float f8 = cVar5.c;
        if (max2 != f8) {
            f3 = Math.abs(f8 / cVar5.e);
        }
        this.mSrcBitmapRect.set((int) f3, (int) f2, (int) (f3 + f6), (int) (f2 + f5));
        this.mRegionRect.set((int) max2, (int) max, (int) min2, (int) min);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void click(float f2, float f3) {
        Region clickedRegion;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1642888209")) {
            ipChange.ipc$dispatch("1642888209", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        try {
            if (this.mListener != null && (clickedRegion = getClickedRegion(f2, f3)) != null) {
                if (clickedRegion.state != 0) {
                    this.mListener.onRegion(getClickedRegion(f2, f3));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void drawLayer(Rect rect, Rect rect2, Canvas canvas, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967269781")) {
            ipChange.ipc$dispatch("1967269781", new Object[]{this, rect, rect2, canvas, bitmap});
            return;
        }
        canvas.drawBitmap(bitmap, rect, rect2, this.mPaint);
        if (!this.mReset) {
            this.mRegionLayerBitmap.eraseColor(0);
            for (Region region : this.mRegions) {
                if (region.state == 0) {
                    ArrayList<RegionLocation> arrayList = region.regionLocationList;
                    this.mRegionBorderPath.reset();
                    for (int i = 0; i < arrayList.size(); i++) {
                        RegionLocation regionLocation = arrayList.get(i);
                        float f2 = regionLocation.x;
                        float f3 = regionLocation.y;
                        if (i == 0) {
                            this.mRegionBorderPath.moveTo(f2, f3);
                        }
                        this.mRegionBorderPath.lineTo(f2, f3);
                    }
                    this.mRegionBorderPath.close();
                    this.mRegionLayerCanvas.drawPath(this.mRegionBorderPath, this.mInvalidRegionPaint);
                    this.mRegionLayerCanvas.drawPath(this.mRegionBorderPath, this.mInvalidRegionBorderPaint);
                } else if (region.priceLevelIdList != null && this.mSelectedPriceId != -1) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= region.priceLevelIdList.size()) {
                            break;
                        } else if (region.priceLevelIdList.get(i2).longValue() == this.mSelectedPriceId) {
                            ArrayList<RegionLocation> arrayList2 = region.regionLocationList;
                            this.mRegionBorderPath.reset();
                            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                                RegionLocation regionLocation2 = arrayList2.get(i3);
                                float f4 = regionLocation2.x;
                                float f5 = regionLocation2.y;
                                if (i3 == 0) {
                                    this.mRegionBorderPath.moveTo(f4, f5);
                                }
                                this.mRegionBorderPath.lineTo(f4, f5);
                            }
                            this.mRegionBorderPath.close();
                            this.mRegionLayerCanvas.drawPath(this.mRegionBorderPath, this.mRegionPaint);
                            this.mRegionLayerCanvas.drawPath(this.mRegionBorderPath, this.mRegionBorderPaint);
                        } else {
                            i2++;
                        }
                    }
                }
            }
            canvas.drawBitmap(this.mRegionLayerBitmap, rect, rect2, this.mPaint);
            this.mReset = true;
            return;
        }
        canvas.drawBitmap(this.mRegionLayerBitmap, rect, rect2, this.mPaint);
    }

    private Region getClickedRegion(float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425424283")) {
            return (Region) ipChange.ipc$dispatch("-1425424283", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
        }
        List<Region> list = this.mRegions;
        if (list == null || list.isEmpty()) {
            return null;
        }
        this.mClickPosition = -1;
        for (int i = 0; i < this.mRegions.size(); i++) {
            Region region = this.mRegions.get(i);
            c cVar = this.mRegionConfig;
            if (Boolean.valueOf(isPointInPolygon2(f2, f3, cVar.c, cVar.d, cVar.e, region.regionLocationList)).booleanValue()) {
                this.mClickPosition = i;
                return region;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private float getCurrentScale() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "754638498")) {
            return ((Float) ipChange.ipc$dispatch("754638498", new Object[]{this})).floatValue();
        }
        c cVar = this.mRegionConfig;
        if (cVar == null) {
            return 1.0f;
        }
        return cVar.e;
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1517640295")) {
            ipChange.ipc$dispatch("1517640295", new Object[]{this, context});
            return;
        }
        setLayerType(1, null);
        initBaseData(context);
        initPaintData();
    }

    private void initBaseData(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190965726")) {
            ipChange.ipc$dispatch("-1190965726", new Object[]{this, context});
            return;
        }
        this.mFirstDraw = true;
        this.mRegionConfig = new c();
        this.mRegionRect = new Rect();
        this.mSrcBitmapRect = new Rect();
        this.mLeftRightPadding = n42.a(context, 15.0f);
        this.mTempPoint = new Point();
    }

    private void initPaintData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1736930785")) {
            ipChange.ipc$dispatch("1736930785", new Object[]{this});
            return;
        }
        this.mPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mRegionPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mRegionPaint.setColor(Color.parseColor("#9A000000"));
        Paint paint2 = new Paint(1);
        this.mRegionBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mRegionBorderPaint.setColor(Color.parseColor("#000000"));
        this.mRegionBorderPaint.setStrokeWidth(2.0f);
        this.mInvalidRegionPaint = new Paint(1);
        Paint paint3 = new Paint(1);
        this.mInvalidRegionPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.mInvalidRegionPaint.setColor(Color.parseColor("#CCCCCCCC"));
        Paint paint4 = new Paint(1);
        this.mInvalidRegionBorderPaint = paint4;
        paint4.setStyle(Paint.Style.STROKE);
        this.mInvalidRegionBorderPaint.setColor(Color.parseColor("#CCAAAAAA"));
        this.mInvalidRegionBorderPaint.setStrokeWidth(2.0f);
        this.mRegionBorderPath = new Path();
    }

    private void invalidateClickRect(Canvas canvas, Paint paint) throws InterruptedException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076697646")) {
            ipChange.ipc$dispatch("-1076697646", new Object[]{this, canvas, paint});
            return;
        }
        int i = this.mClickPosition;
        if (i != -1 && i < this.mRegions.size()) {
            Region region = this.mRegions.get(this.mClickPosition);
            if (region.flag) {
                ArrayList<RegionLocation> arrayList = region.regionLocationList;
                this.mRegionBorderPath.reset();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    Path path = this.mRegionBorderPath;
                    float f2 = arrayList.get(i2).x;
                    c cVar = this.mRegionConfig;
                    float f3 = (f2 * cVar.e) + cVar.c;
                    float f4 = arrayList.get(i2).y;
                    c cVar2 = this.mRegionConfig;
                    path.lineTo(f3, (f4 * cVar2.e) + cVar2.d);
                }
                this.mRegionBorderPath.close();
                paint.setColor(Color.parseColor(region.color));
                canvas.drawPath(this.mRegionBorderPath, paint);
                this.handler.postDelayed(this.updateSelectedRegionRunnable, 50);
            }
        }
    }

    public static boolean isPointInPolygon2(float f2, float f3, float f4, float f5, float f6, List<RegionLocation> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412939745")) {
            return ((Boolean) ipChange.ipc$dispatch("-412939745", new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), list})).booleanValue();
        }
        float f7 = f6 == 0.0f ? 1.0f : f6;
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            RegionLocation regionLocation = list.get(i);
            i++;
            RegionLocation regionLocation2 = list.get(i % size);
            float f8 = (regionLocation.x * f7) + f4;
            float f9 = (regionLocation.y * f7) + f5;
            float f10 = (regionLocation2.x * f7) + f4;
            float f11 = (regionLocation2.y * f7) + f5;
            if (f9 != f11 && f3 >= Math.min(f9, f11) && f3 < Math.max(f9, f11) && (((f3 - f9) * (f10 - f8)) / (f11 - f9)) + f8 > f2) {
                i2++;
            }
        }
        if (i2 % 2 == 1) {
            return true;
        }
        return false;
    }

    private void keydown(float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769748808")) {
            ipChange.ipc$dispatch("-769748808", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        for (int i = 0; i < this.mRegions.size(); i++) {
            try {
                Region region = this.mRegions.get(i);
                c cVar = this.mRegionConfig;
                if (Boolean.valueOf(isPointInPolygon2(f2, f3, cVar.c, cVar.d, cVar.e, region.regionLocationList)).booleanValue()) {
                    region.flag = true;
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    private void keyup() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "376345439")) {
            ipChange.ipc$dispatch("376345439", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mRegions.size(); i++) {
            try {
                this.mRegions.get(i).flag = false;
            } catch (Exception unused) {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void move(Point point) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868423229")) {
            ipChange.ipc$dispatch("-1868423229", new Object[]{this, point});
            return;
        }
        int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
        int i = this.mScrollOffsetWidth;
        if (xVar > i) {
            this.mRegionConfig.c = (float) i;
        } else {
            c cVar = this.mRegionConfig;
            float f2 = cVar.a;
            if (((float) xVar) + f2 < ((float) i)) {
                cVar.c = ((float) i) - f2;
            } else {
                cVar.c = (float) xVar;
            }
        }
        int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
        int i2 = this.mScrollOffsetHeigh;
        if (yVar > i2) {
            this.mRegionConfig.d = (float) i2;
        } else {
            c cVar2 = this.mRegionConfig;
            float f3 = cVar2.b;
            if (((float) yVar) + f3 < ((float) i2)) {
                cVar2.d = ((float) i2) - f3;
            } else {
                cVar2.d = (float) yVar;
            }
        }
        invalidate();
    }

    private void moveAnimate(Point point, Point point2, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-402744235")) {
            ipChange.ipc$dispatch("-402744235", new Object[]{this, point, point2, Long.valueOf(j)});
            return;
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new e(this), point, point2);
        ofObject.setInterpolator(new DecelerateInterpolator());
        ofObject.addUpdateListener(new d());
        ofObject.setDuration(j);
        ofObject.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zoom(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "738003106")) {
            ipChange.ipc$dispatch("738003106", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        c cVar = this.mRegionConfig;
        float f3 = cVar.c;
        float f4 = cVar.d;
        float f5 = cVar.a;
        float f6 = cVar.b;
        cVar.a(((float) this.mRegionImageWidth) * f2);
        c cVar2 = this.mRegionConfig;
        float f7 = this.scaleX;
        cVar2.c = f7 - (cVar2.a * ((f7 - f3) / f5));
        float f8 = this.scaleY;
        cVar2.d = f8 - (cVar2.b * ((f8 - f4) / f6));
        invalidate();
    }

    private void zoomAnimate(float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101887179")) {
            ipChange.ipc$dispatch("1101887179", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        f fVar = new f();
        ofFloat.addUpdateListener(fVar);
        ofFloat.addListener(fVar);
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812052169")) {
            ipChange.ipc$dispatch("-1812052169", new Object[]{this, canvas});
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            List<Region> list = this.mRegions;
            if (list == null) {
                return;
            }
            if (!list.isEmpty()) {
                Bitmap bitmap = this.mContentBitmap;
                if (bitmap == null) {
                    return;
                }
                if (!bitmap.isRecycled()) {
                    if (this.mFirstDraw) {
                        this.mViewWidth = getWidth();
                        int height = getHeight();
                        this.mViewHeight = height;
                        this.mScrollOffsetWidth = this.mViewWidth / 2;
                        this.mScrollOffsetHeigh = height / 2;
                        this.mRegionImageWidth = this.mContentBitmap.getWidth();
                        this.mRegionImageHeight = this.mContentBitmap.getHeight();
                        int i = this.mLeftRightPadding * 2;
                        this.mRegionConfig.a = (float) (g70.d() - i);
                        c cVar = this.mRegionConfig;
                        float f2 = cVar.a;
                        int i2 = this.mRegionImageHeight;
                        int i3 = this.mRegionImageWidth;
                        float f3 = (f2 * ((float) i2)) / ((float) i3);
                        cVar.b = f3;
                        int i4 = this.mViewHeight;
                        if (f3 > ((float) (i4 - i))) {
                            float f4 = (float) (this.mViewWidth - i);
                            cVar.b = f4;
                            cVar.a = (f4 * ((float) i3)) / ((float) i2);
                        }
                        cVar.c = (float) (i / 2);
                        cVar.d = (((float) i4) - cVar.b) / 2.0f;
                        float f5 = cVar.a / ((float) i3);
                        this.mMinScale = f5;
                        cVar.e = f5;
                        float f6 = 3.0f * f5;
                        this.mMaxScale = f6;
                        float f7 = this.offsetScale;
                        this.minOffsetScale = f5 * (1.0f - f7);
                        this.maxOffsetScale = f6 * (f7 + 1.0f);
                    }
                    if (buildDrawArea()) {
                        drawLayer(this.mSrcBitmapRect, this.mRegionRect, canvas, this.mContentBitmap);
                    } else {
                        Rect rect = this.mRegionRect;
                        c cVar2 = this.mRegionConfig;
                        float f8 = cVar2.c;
                        float f9 = cVar2.d;
                        rect.set((int) f8, (int) f9, (int) (f8 + cVar2.a), (int) (f9 + cVar2.b));
                        drawLayer(null, this.mRegionRect, canvas, this.mContentBitmap);
                    }
                    if (this.mFirstDraw) {
                        this.mFirstDraw = false;
                    }
                    g91.b(TAG, "----------------------------- draw region image cost = " + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1862057264")) {
            return ((Boolean) ipChange.ipc$dispatch("-1862057264", new Object[]{this, motionEvent})).booleanValue();
        }
        this.scaleGestureDetector.onTouchEvent(motionEvent);
        this.mGestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.isScaling) {
                this.isScaling = false;
            }
            boolean autoScale = autoScale();
            boolean autoScroll = autoScroll();
            if (!autoScale && !autoScroll) {
                invalidate();
            }
        }
        return true;
    }

    public void setBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516227034")) {
            ipChange.ipc$dispatch("-516227034", new Object[]{this, bitmap});
            return;
        }
        this.mContentBitmap = bitmap;
        this.mRegionLayerBitmap = Bitmap.createBitmap(bitmap.getWidth(), this.mContentBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        this.mRegionLayerCanvas = new Canvas(this.mRegionLayerBitmap);
        this.mFirstDraw = true;
        this.mReset = false;
        invalidate();
    }

    public void setListener(OnRegionClickListener onRegionClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099536229")) {
            ipChange.ipc$dispatch("1099536229", new Object[]{this, onRegionClickListener});
            return;
        }
        this.mListener = onRegionClickListener;
    }

    public void setPriceId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-144212267")) {
            ipChange.ipc$dispatch("-144212267", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mSelectedPriceId = j;
        this.mReset = false;
        invalidate();
    }

    public void setRegions(List<Region> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518062885")) {
            ipChange.ipc$dispatch("1518062885", new Object[]{this, list});
            return;
        }
        this.mRegions = list;
    }

    private void moveAnimate(Point point, Point point2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1372480591")) {
            ipChange.ipc$dispatch("1372480591", new Object[]{this, point, point2});
            return;
        }
        moveAnimate(point, point2, 300);
    }

    public RegionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public RegionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
