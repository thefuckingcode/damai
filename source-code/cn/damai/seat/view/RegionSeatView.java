package cn.damai.seat.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.RegionBound;
import cn.damai.seat.listener.RegionSeatRequestChecker;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tb.cc0;
import tb.f92;
import tb.g72;
import tb.g91;
import tb.h72;
import tb.kz1;
import tb.lr;
import tb.n42;
import tb.o72;
import tb.oa;
import tb.qx1;
import tb.u62;
import tb.u72;

/* compiled from: Taobao */
public class RegionSeatView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    public static boolean isShowSvgRegionBound;
    private float bestRegionImageWidth;
    private float bigVenueInitRegionImageWidth;
    private c drawSeat = new c();
    private Runnable hideOverviewRunnable = new Runnable() {
        /* class cn.damai.seat.view.RegionSeatView.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-972654020")) {
                ipChange.ipc$dispatch("-972654020", new Object[]{this});
                return;
            }
            RegionSeatView.this.isDrawOverview = false;
            RegionSeatView.this.invalidate();
            RegionSeatView.this.notifyOverViewChanged(true);
        }
    };
    private boolean isDrawOverview = false;
    private boolean isFirstDraw = true;
    private boolean isReportDrawError = false;
    private boolean isSeatStateChanged = true;
    private boolean isShow;
    private boolean isShowOverview = true;
    private boolean isSmallVenueStyle;
    private boolean isVenueMode;
    private boolean mAlwaysInTapRegion;
    private Rect mBackgroundRect;
    private float mBigVenueScale36Width;
    private int mClickScaleOffset;
    private Picture mColorRegionPicture;
    private Context mContext;
    private float mDLeft;
    private float mDTop;
    private float mDWidth;
    private float mDownX;
    private float mDownY;
    private Handler mHandler = new Handler();
    private h72 mIconProvider;
    private ArrayMap<String, List<SeatNew>> mInScreenSeatData;
    private float mLastFocusX;
    private float mLastFocusY;
    private OnSeatViewListener mListener;
    private List<Picture> mLocationPics4Test = new ArrayList();
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private cc0 mMonitor = new cc0();
    private int mOverViewOffset;
    private RectF mOverviewRect;
    private final Map<String, List<Picture>> mPackageSeatWrapLineMap = new HashMap();
    private Paint mPaint;
    private Paint mPaintJust4Test;
    private TbParams mParams;
    private List<RegionBound> mRegionBounds;
    private RegionData mRegionData;
    private ArrayMap<String, String> mRegionVid2IdMap;
    private Picture mSVGVenueLayerPicture;
    private float mScale09;
    private float mScale18;
    private float mScale36;
    private float mScale50;
    private float mScaleDistance;
    private boolean mScaling;
    private SeatBox mSeatBox;
    private RectF mSeatRect;
    private RegionSeatRequestChecker mSeatRequestChecker;
    private PriceLevel mSelectPrice;
    private List<List<PointLocation>> mSvgRegionLocations;
    private float mSvgScale = 1.0f;
    private TextPaint mTextPaintJust4Test;
    private int mTouchSlop;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;
    private int maxOverViewRectWidth;
    private float maxRegionImageWidth;
    private float minRegionImageDrawSeatWidth;
    private float minRegionImageWidth;
    private int overviewBackgroundColor;
    private Bitmap overviewBitmap;
    private Canvas overviewCanvas;
    private Paint overviewPaint;
    private float overviewSpacing;
    private Paint packageSeatBorderPaint;
    private float rectH;
    private float rectW;
    private float redBorderBottomBoundary;
    private float redBorderLeftBoundary;
    private Paint redBorderPaint;
    private float redBorderRightBoundary;
    private float redBorderTopBoundary;
    private float regionImageHeight;
    private float regionImageWidth;
    private PictureDrawable regionPictureDataWithoutColor;
    private List<Region> regions;
    private Paint seatPaint;
    private int seatViewPaddingBottom;
    private int unavailableSeatColor;
    private int viewHeight = 0;
    private int viewWidth = 0;

    /* compiled from: Taobao */
    public interface OnSeatViewListener {
        void onSeatSelectChanged(SeatNew seatNew, boolean z);

        void onShowBack2Venue(boolean z, boolean z2, boolean z3, Bitmap bitmap, int i, int i2);

        void onVenueModeChanged(boolean z);
    }

    /* compiled from: Taobao */
    public class a extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1389391445")) {
                ipChange.ipc$dispatch("-1389391445", new Object[]{this, animator});
                return;
            }
            RegionSeatView.this.isDrawOverview = false;
            RegionSeatView.this.notifyOverViewChanged(true);
        }
    }

    /* compiled from: Taobao */
    public class b extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1397150804")) {
                ipChange.ipc$dispatch("-1397150804", new Object[]{this, animator});
                return;
            }
            RegionSeatView.this.notifyOverViewChanged(false);
        }
    }

    /* compiled from: Taobao */
    public class c {
        private static transient /* synthetic */ IpChange $ipChange;
        float a = 0.0f;
        float b = 0.0f;
        float c = 0.0f;
        float d = 0.0f;
        float e = 1.0f;
        int f = 20;
        int g = 24;

        c() {
        }

        public void a(float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-814038725")) {
                ipChange.ipc$dispatch("-814038725", new Object[]{this, Float.valueOf(f2)});
                return;
            }
            this.a = f2;
            this.e = f2 / RegionSeatView.this.regionImageWidth;
            float f3 = RegionSeatView.this.regionImageHeight;
            float f4 = this.e;
            this.b = f3 * f4;
            this.g = (int) (((float) this.f) * f4);
        }
    }

    /* compiled from: Taobao */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1624042624")) {
                ipChange.ipc$dispatch("-1624042624", new Object[]{this, valueAnimator});
                return;
            }
            f fVar = (f) valueAnimator.getAnimatedValue();
            RegionSeatView.this.scrollView(fVar.a, fVar.b);
        }
    }

    /* compiled from: Taobao */
    public class e implements TypeEvaluator {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1398956461")) {
                return ipChange.ipc$dispatch("1398956461", new Object[]{this, Float.valueOf(f), obj, obj2});
            }
            f fVar = (f) obj;
            f fVar2 = (f) obj2;
            float f2 = fVar.a;
            float f3 = f2 + ((fVar2.a - f2) * f);
            float f4 = fVar.b;
            float f5 = fVar.c;
            return new f(RegionSeatView.this, f3, f4 + ((fVar2.b - f4) * f), f5 + (f * (fVar2.c - f5)));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f {
        public float a;
        public float b;
        public float c;

        f(RegionSeatView regionSeatView, float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }
    }

    /* compiled from: Taobao */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1696637339")) {
                ipChange.ipc$dispatch("1696637339", new Object[]{this, valueAnimator});
                return;
            }
            f fVar = (f) valueAnimator.getAnimatedValue();
            RegionSeatView.this.drawSeat.c = fVar.a;
            RegionSeatView.this.drawSeat.d = fVar.b;
            RegionSeatView.this.drawSeat.a(fVar.c);
            RegionSeatView.this.invalidate();
        }
    }

    public RegionSeatView(Context context, RegionData regionData, h72 h72, TbParams tbParams) {
        super(context);
        this.mContext = context;
        this.mRegionData = regionData;
        this.mIconProvider = h72;
        this.mParams = tbParams;
        initView(context);
        if (u72.c(g72.k(tbParams), false)) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    private void autoScale(MotionEvent motionEvent) {
        float f2;
        float f3;
        float f4;
        float y;
        float y2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463967186")) {
            ipChange.ipc$dispatch("-1463967186", new Object[]{this, motionEvent});
            return;
        }
        c cVar = this.drawSeat;
        float f5 = cVar.c;
        float f6 = cVar.d;
        float f7 = cVar.a;
        float f8 = this.isSmallVenueStyle ? this.bestRegionImageWidth : this.mBigVenueScale36Width;
        if (f7 < f8) {
            f4 = f8 / f7;
            f5 = motionEvent.getX() - ((motionEvent.getX() - f5) * f4);
            y = motionEvent.getY();
            y2 = motionEvent.getY();
        } else {
            f8 = this.maxRegionImageWidth;
            if (f7 < f8) {
                f4 = f8 / f7;
                f5 = motionEvent.getX() - ((motionEvent.getX() - f5) * f4);
                y = motionEvent.getY();
                y2 = motionEvent.getY();
            }
            float x = motionEvent.getX();
            float y3 = motionEvent.getY();
            f2 = ((float) (this.viewWidth / 2)) - x;
            f3 = ((float) (this.viewHeight / 2)) - y3;
            c cVar2 = this.drawSeat;
            f fVar = new f(this, cVar2.c, cVar2.d, cVar2.a);
            if (Math.abs(f2) <= ((float) this.mClickScaleOffset) || Math.abs(f3) > ((float) this.mClickScaleOffset) || Math.abs(f7 - this.drawSeat.a) > 0.0f) {
                zoomAnimate(fVar, new f(this, f5 + f2, f6 + f3, f7));
            }
            return;
        }
        f6 = y - ((y2 - f6) * f4);
        f7 = f8;
        float x2 = motionEvent.getX();
        float y32 = motionEvent.getY();
        f2 = ((float) (this.viewWidth / 2)) - x2;
        f3 = ((float) (this.viewHeight / 2)) - y32;
        c cVar22 = this.drawSeat;
        f fVar2 = new f(this, cVar22.c, cVar22.d, cVar22.a);
        if (Math.abs(f2) <= ((float) this.mClickScaleOffset)) {
        }
        zoomAnimate(fVar2, new f(this, f5 + f2, f6 + f3, f7));
    }

    private void click(float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865825292")) {
            ipChange.ipc$dispatch("865825292", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        try {
            if (!this.isShow) {
                return;
            }
            if (this.mListener != null) {
                int size = this.mInScreenSeatData.size();
                int i = 0;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    List<SeatNew> valueAt = this.mInScreenSeatData.valueAt(i);
                    if (valueAt != null) {
                        int size2 = valueAt.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size2) {
                                break;
                            }
                            SeatNew seatNew = valueAt.get(i2);
                            float f4 = seatNew.currentY;
                            int i3 = this.drawSeat.g;
                            if (f3 >= f4 - ((float) (i3 / 2)) && f3 <= f4 + ((float) (i3 / 2))) {
                                float f5 = seatNew.currentX;
                                if (f2 >= f5 - ((float) (i3 / 2)) && f2 <= f5 + ((float) (i3 / 2))) {
                                    if (seatNew.isSelected) {
                                        this.mListener.onSeatSelectChanged(seatNew, false);
                                    } else if (seatNew.state == 2) {
                                        this.isDrawOverview = true;
                                        this.mListener.onSeatSelectChanged(seatNew, true);
                                        z2 = true;
                                    }
                                    invalidate();
                                    z = true;
                                }
                            }
                            i2++;
                        }
                        if (z) {
                            break;
                        }
                    }
                    i++;
                }
                if (!z || !z2) {
                    this.mHandler.postDelayed(this.hideOverviewRunnable, 500);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void computeOffset2AdjustBounds(float[] fArr) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1784911499")) {
            ipChange.ipc$dispatch("-1784911499", new Object[]{this, fArr});
            return;
        }
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        c cVar = this.drawSeat;
        if (cVar != null) {
            float f2 = cVar.a;
            if (f2 > 0.0f) {
                float f3 = cVar.c;
                float f4 = f2 + f3;
                float f5 = cVar.d;
                float f6 = cVar.b + f5;
                if ((f3 > 0.0f || f4 < ((float) this.viewWidth)) && (f3 < 0.0f || f4 > ((float) this.viewWidth))) {
                    boolean z2 = (f2 / 2.0f) + f3 > ((float) this.viewWidth) / 2.0f;
                    float min = Math.min(Math.abs(f3), Math.abs(f4 - ((float) this.viewWidth)));
                    if (z2) {
                        min = -min;
                    }
                    fArr[0] = min;
                }
                if ((f5 > 0.0f || f6 < ((float) this.viewHeight)) && (f5 < 0.0f || f6 > ((float) this.viewHeight))) {
                    if ((this.drawSeat.b / 2.0f) + f5 > ((float) this.viewHeight) / 2.0f) {
                        z = true;
                    }
                    float min2 = Math.min(Math.abs(f5), Math.abs(f6 - ((float) this.viewHeight)));
                    if (z) {
                        min2 = -min2;
                    }
                    fArr[1] = min2;
                }
            }
        }
    }

    private void flingAnimate(float f2, float f3) {
        float f4;
        float f5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1828560335")) {
            ipChange.ipc$dispatch("-1828560335", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        float f6 = f2 * 1.2f;
        float f7 = f3 * 1.2f;
        c cVar = this.drawSeat;
        f fVar = new f(this, cVar.c, cVar.d, cVar.a);
        c cVar2 = this.drawSeat;
        float f8 = (float) 400;
        float f9 = cVar2.c + ((f6 / 1000.0f) * f8 * 0.5f);
        float f10 = cVar2.d + ((f7 / 1000.0f) * f8 * 0.5f);
        if (f6 > 0.0f) {
            float f11 = cVar2.a;
            int i = this.viewWidth;
            f4 = f11 > ((float) i) ? Math.min(f9, 0.0f) : Math.min(f9, ((float) i) - f11);
        } else {
            float f12 = cVar2.a;
            int i2 = this.viewWidth;
            f4 = f12 > ((float) i2) ? Math.max(f9, ((float) i2) - f12) : Math.max(0.0f, f9);
        }
        if (f7 > 0.0f) {
            float f13 = this.drawSeat.b;
            int i3 = this.viewHeight;
            f5 = f13 > ((float) i3) ? Math.min(f10, 0.0f) : Math.min(f10, ((float) i3) - f13);
        } else {
            float f14 = this.drawSeat.b;
            int i4 = this.viewHeight;
            f5 = f14 > ((float) i4) ? Math.max(f10, ((float) i4) - f14) : Math.max(f10, 0.0f);
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new e(), fVar, new f(this, f4, f5, this.drawSeat.a));
        ofObject.setInterpolator(new DecelerateInterpolator());
        ofObject.addUpdateListener(new d());
        ofObject.setDuration((long) 400);
        ofObject.start();
    }

    private ArrayMap<String, List<SeatNew>> getAllRegion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025888448")) {
            return (ArrayMap) ipChange.ipc$dispatch("2025888448", new Object[]{this});
        } else if (this.mSeatBox == null) {
            return this.mInScreenSeatData;
        } else {
            this.mInScreenSeatData.clear();
            for (int i = 0; i < this.mSeatBox.seatNewMap.size(); i++) {
                this.mInScreenSeatData.put(this.mSeatBox.seatNewMap.keyAt(i), this.mSeatBox.seatNewMap.valueAt(i));
            }
            return this.mInScreenSeatData;
        }
    }

    private ArrayMap<String, List<SeatNew>> getCurrentShownRegion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715727685")) {
            return (ArrayMap) ipChange.ipc$dispatch("1715727685", new Object[]{this});
        } else if (this.mSeatBox == null) {
            return this.mInScreenSeatData;
        } else {
            List<String> currentRegionIdsInScreen = getCurrentRegionIdsInScreen();
            if (currentRegionIdsInScreen == null || currentRegionIdsInScreen.isEmpty()) {
                if (this.mInScreenSeatData.isEmpty()) {
                    this.mInScreenSeatData = getAllRegion();
                }
                return this.mInScreenSeatData;
            }
            this.mInScreenSeatData.clear();
            for (int i = 0; i < currentRegionIdsInScreen.size(); i++) {
                String str = currentRegionIdsInScreen.get(i);
                this.mInScreenSeatData.put(str, this.mSeatBox.seatNewMap.get(str));
            }
            return this.mInScreenSeatData;
        }
    }

    private Bitmap getOverviewBitmap(Picture picture) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1949993367")) {
            return (Bitmap) ipChange.ipc$dispatch("-1949993367", new Object[]{this, picture});
        }
        Bitmap bitmap = this.overviewBitmap;
        if (bitmap == null) {
            this.overviewBitmap = Bitmap.createBitmap((int) this.rectW, (int) this.rectH, Bitmap.Config.ARGB_8888);
        } else {
            bitmap.eraseColor(0);
        }
        if (this.overviewCanvas == null) {
            this.overviewCanvas = new Canvas(this.overviewBitmap);
        }
        this.overviewPaint.setColor(this.overviewBackgroundColor);
        this.overviewPaint.setStyle(Paint.Style.FILL);
        int dip2px = ScreenUtil.dip2px(this.mContext, 6.0f);
        float f2 = (float) dip2px;
        this.overviewCanvas.drawRoundRect(new RectF(0.0f, 0.0f, this.rectW, this.rectH), f2, f2, this.overviewPaint);
        RectF rectF = this.mOverviewRect;
        float f3 = this.overviewSpacing;
        rectF.set(f3, f3, this.rectW - f3, this.rectH - f3);
        this.overviewCanvas.drawPicture(picture, this.mOverviewRect);
        return this.overviewBitmap;
    }

    private int getViewUsedHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "714914792")) {
            return getHeight() - this.seatViewPaddingBottom;
        }
        return ((Integer) ipChange.ipc$dispatch("714914792", new Object[]{this})).intValue();
    }

    private boolean isNeedAddAlpha(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "102640480")) {
            return ((Boolean) ipChange.ipc$dispatch("102640480", new Object[]{this, seatNew})).booleanValue();
        }
        PriceLevel priceLevel = this.mSelectPrice;
        if (priceLevel == null) {
            return false;
        }
        long j = seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
        if (!priceLevel.isSinglePrice() && !this.mSelectPrice.isTaoPiao()) {
            Long valueOf = Long.valueOf(j);
            HashSet<Long> subPriceIds = this.mSelectPrice.getSubPriceIds();
            if (!f92.d(subPriceIds)) {
                return !subPriceIds.contains(valueOf);
            }
            return true;
        } else if (j != this.mSelectPrice.getPriceId()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean needAutoScale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "133093779")) {
            return this.drawSeat.a < this.maxRegionImageWidth;
        }
        return ((Boolean) ipChange.ipc$dispatch("133093779", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if ((r1 - (0.05f * r6)) > r6) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (r1.a >= r11.minRegionImageDrawSeatWidth) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        r1 = false;
     */
    private void notifyOverViewChanged(boolean z) {
        c cVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2067512082")) {
            ipChange.ipc$dispatch("2067512082", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        OnSeatViewListener onSeatViewListener = this.mListener;
        if (onSeatViewListener != null && (cVar = this.drawSeat) != null) {
            boolean z2 = this.isSmallVenueStyle;
            if (z2) {
                float f2 = cVar.a;
                float f3 = this.minRegionImageWidth;
            }
            boolean z3 = true;
            onSeatViewListener.onShowBack2Venue(z2, z3, z && this.isShowOverview, this.overviewBitmap, (int) this.rectW, (int) this.rectH);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scrollView(float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864411492")) {
            ipChange.ipc$dispatch("1864411492", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        int i = this.viewWidth;
        if (f2 > ((float) (i / 2))) {
            this.drawSeat.c = (float) (i / 2);
        } else {
            c cVar = this.drawSeat;
            float f4 = cVar.a;
            if (f2 + f4 < ((float) (i / 2))) {
                cVar.c = ((float) (i / 2)) - f4;
            } else {
                cVar.c = f2;
            }
        }
        int i2 = this.viewHeight;
        if (f3 > ((float) (i2 / 2))) {
            this.drawSeat.d = (float) (i2 / 2);
        } else {
            c cVar2 = this.drawSeat;
            float f5 = cVar2.b;
            if (f3 + f5 < ((float) (i2 / 2))) {
                cVar2.d = ((float) (i2 / 2)) - f5;
            } else {
                cVar2.d = f3;
            }
        }
        invalidate();
    }

    private float spacing(float f2, float f3, float f4, float f5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746433503")) {
            return ((Float) ipChange.ipc$dispatch("-746433503", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})).floatValue();
        }
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }

    private void testDrawSvgLocation(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042080628")) {
            ipChange.ipc$dispatch("1042080628", new Object[]{this, canvas});
            return;
        }
        Rect rect = this.mBackgroundRect;
        c cVar = this.drawSeat;
        float f2 = cVar.c;
        float f3 = cVar.d;
        rect.set((int) f2, (int) f3, (int) (f2 + cVar.a), (int) (f3 + cVar.b));
        canvas.drawRect(this.mBackgroundRect, this.mPaintJust4Test);
        if (!f92.d(this.mLocationPics4Test)) {
            for (Picture picture : this.mLocationPics4Test) {
                canvas.drawPicture(picture, this.mBackgroundRect);
            }
        } else if (!f92.d(this.mSvgRegionLocations)) {
            for (List<PointLocation> list : this.mSvgRegionLocations) {
                Path path = new Path();
                int size = list.size();
                float f4 = 0.0f;
                String str = null;
                float f5 = 0.0f;
                int i = 0;
                while (i < size) {
                    PointLocation pointLocation = list.get(i);
                    String str2 = pointLocation.id;
                    float f6 = pointLocation.x;
                    float f7 = this.mSvgScale;
                    float f8 = f6 * f7;
                    float f9 = pointLocation.y * f7;
                    if (i == 0) {
                        path.moveTo(f8, f9);
                        f5 = f9;
                        f4 = f8;
                    } else {
                        path.lineTo(f8, f9);
                    }
                    i++;
                    str = str2;
                }
                path.lineTo(f4, f5);
                path.close();
                Picture picture2 = new Picture();
                Canvas beginRecording = picture2.beginRecording((int) this.regionImageWidth, (int) this.regionImageHeight);
                beginRecording.drawPath(path, this.mPaintJust4Test);
                if (!TextUtils.isEmpty(str)) {
                    beginRecording.drawTextOnPath(str, path, this.mPaintJust4Test.measureText(str), 16.0f, this.mTextPaintJust4Test);
                }
                this.mLocationPics4Test.add(picture2);
            }
        }
    }

    private void zoom(float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224831971")) {
            ipChange.ipc$dispatch("-224831971", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        float f5 = (((float) this.viewWidth) / 2.0f) - f2;
        float f6 = (((float) this.viewHeight) / 2.0f) - f3;
        c cVar = this.drawSeat;
        float f7 = cVar.c;
        float f8 = f4 - 1.0f;
        float f9 = ((f7 - f2) * f8) + f7 + f5;
        float f10 = cVar.d;
        float f11 = cVar.a;
        zoomAnimate(new f(this, f7, f10, f11), new f(this, f9, ((f10 - f3) * f8) + f10 + f6, f4 * f11), new a());
    }

    private void zoomAnimate(f fVar, f fVar2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399996646")) {
            ipChange.ipc$dispatch("-1399996646", new Object[]{this, fVar, fVar2});
            return;
        }
        zoomAnimate(fVar, fVar2, null);
    }

    public float computeScaleZoom2Region(RectF rectF) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "72116117")) {
            return ((Float) ipChange.ipc$dispatch("72116117", new Object[]{this, rectF})).floatValue();
        }
        if (rectF.width() * ((float) this.viewHeight) <= rectF.height() * ((float) this.viewWidth)) {
            z = false;
        }
        return Math.min(Math.max(((float) (z ? this.viewWidth : this.viewHeight)) / (z ? rectF.width() : rectF.height()), this.mScale50), this.mScale09);
    }

    /* access modifiers changed from: package-private */
    public void drawOverview(Canvas canvas) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "727875852")) {
            ipChange.ipc$dispatch("727875852", new Object[]{this, canvas});
            return;
        }
        c cVar = this.drawSeat;
        float f2 = cVar.a;
        float f3 = f2 / (this.rectW - (this.overviewSpacing * 2.0f));
        float f4 = this.redBorderLeftBoundary;
        float f5 = cVar.c;
        float f6 = f4 - (f5 / f3);
        if (f6 >= f4) {
            f4 = f6;
        }
        int i2 = (int) (f5 + f2);
        int i3 = this.viewWidth;
        float f7 = this.redBorderRightBoundary - (((float) (i2 > i3 ? i2 - i3 : 0)) / f3);
        float f8 = this.redBorderTopBoundary;
        float f9 = cVar.d;
        float f10 = f8 - (f9 / f3);
        if (f10 >= f8) {
            f8 = f10;
        }
        int i4 = (int) (f9 + cVar.b);
        if (i4 > getHeight()) {
            i = i4 - getHeight();
        }
        float f11 = this.redBorderBottomBoundary - (((float) i) / f3);
        if (f4 >= f7) {
            f4 = f7 - this.redBorderPaint.getStrokeWidth();
        }
        canvas.drawRect(f4, f11 <= f8 ? f11 - this.redBorderPaint.getStrokeWidth() : f8, f7, f11, this.redBorderPaint);
    }

    public List<String> getCurrentRegionIdsInScreen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519080741")) {
            return (List) ipChange.ipc$dispatch("519080741", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        ArrayMap<String, String> arrayMap = this.mRegionVid2IdMap;
        if (arrayMap == null || arrayMap.isEmpty() || this.mSvgRegionLocations == null) {
            return arrayList;
        }
        float f2 = ((this.drawSeat.a * 1.0f) / this.regionImageWidth) * this.mSvgScale;
        for (int i = 0; i < this.mSvgRegionLocations.size(); i++) {
            List<PointLocation> list = this.mSvgRegionLocations.get(i);
            if (list != null && !list.isEmpty() && !TextUtils.isEmpty(list.get(0).id) && list.size() >= 2) {
                RectF rectF = list.get(0).rectF;
                c cVar = this.drawSeat;
                float f3 = cVar.c;
                float f4 = (rectF.left * f2) + f3;
                float f5 = cVar.d;
                float f6 = (rectF.top * f2) + f5;
                float f7 = (rectF.right * f2) + f3;
                float f8 = (rectF.bottom * f2) + f5;
                int i2 = this.viewHeight + this.seatViewPaddingBottom;
                if ((f4 >= 0.0f || f7 >= 0.0f) && (f6 >= 0.0f || f8 >= 0.0f)) {
                    int i3 = this.viewWidth;
                    if (f4 <= ((float) i3) || f7 <= ((float) i3)) {
                        float f9 = (float) i2;
                        if (f6 <= f9 || f8 <= f9) {
                            arrayList.add(this.mRegionVid2IdMap.get(list.get(0).id));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public RegionBound getPointRegionBound(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-236197648")) {
            return (RegionBound) ipChange.ipc$dispatch("-236197648", new Object[]{this, motionEvent});
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        c cVar = this.drawSeat;
        float f2 = x - cVar.c;
        float f3 = cVar.e;
        float f4 = this.mSvgScale;
        float f5 = f2 / (f3 * f4);
        float f6 = (y - cVar.d) / (f3 * f4);
        if (f92.d(this.mRegionBounds)) {
            return null;
        }
        for (int i = 0; i < this.mRegionBounds.size(); i++) {
            RegionBound regionBound = this.mRegionBounds.get(i);
            if (regionBound.isPoint(f5, f6)) {
                return regionBound;
            }
        }
        return null;
    }

    public void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120833049")) {
            ipChange.ipc$dispatch("-2120833049", new Object[]{this, context});
            return;
        }
        lr lrVar = new lr();
        this.isSmallVenueStyle = lrVar.f(this.mRegionData);
        this.seatPaint = new Paint();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.overviewPaint = new Paint();
        this.overviewBackgroundColor = Color.parseColor("#99000000");
        Paint paint2 = new Paint();
        this.redBorderPaint = paint2;
        paint2.setAntiAlias(true);
        this.redBorderPaint.setColor(Color.parseColor("#fa1155"));
        this.redBorderPaint.setStyle(Paint.Style.STROKE);
        this.redBorderPaint.setStrokeWidth((float) n42.a(this.mContext, 2.0f));
        this.mBackgroundRect = new Rect();
        this.mSeatRect = new RectF();
        this.mOverviewRect = new RectF();
        this.maxOverViewRectWidth = (int) (((float) DisplayMetrics.getwidthPixels(n42.b(this.mContext))) * 0.4f);
        this.overviewSpacing = (float) n42.a(this.mContext, 10.0f);
        this.isDrawOverview = false;
        Paint paint3 = new Paint();
        this.packageSeatBorderPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.packageSeatBorderPaint.setAntiAlias(true);
        this.packageSeatBorderPaint.setStrokeWidth(1.0f);
        this.packageSeatBorderPaint.setColor(Color.parseColor("#999999"));
        this.packageSeatBorderPaint.setPathEffect(new DashPathEffect(new float[]{6.0f, 4.0f}, 0.0f));
        this.unavailableSeatColor = Color.parseColor("#e9e9e9");
        this.mInScreenSeatData = new ArrayMap<>();
        this.mClickScaleOffset = n42.a(this.mContext, 25.0f);
        oa c2 = lrVar.c(this.mRegionData);
        if (c2 != null) {
            this.mRegionVid2IdMap = c2.c(this.mRegionData);
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.mContext);
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mTouchSlop = scaledTouchSlop;
        this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
        this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mOverViewOffset = ScreenUtil.dip2px(this.mContext, 9.0f);
        Paint paint4 = new Paint(1);
        this.mPaintJust4Test = paint4;
        paint4.setColor(-16776961);
        this.mPaintJust4Test.setStrokeWidth(4.0f);
        this.mPaintJust4Test.setStyle(Paint.Style.STROKE);
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaintJust4Test = textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaintJust4Test.setTextSize(16.0f);
        this.mTextPaintJust4Test.setColor(-16776961);
        this.seatViewPaddingBottom = n42.a(context, 48.0f);
    }

    public void isShowOverView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "433419614")) {
            ipChange.ipc$dispatch("433419614", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isShowOverview = z;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02e4 A[Catch:{ Exception -> 0x04a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02f8 A[Catch:{ Exception -> 0x0407 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x036d A[Catch:{ Exception -> 0x0407 }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03e9 A[Catch:{ Exception -> 0x0407 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03ec A[Catch:{ Exception -> 0x0407 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0423  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0466  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0468  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x047d  */
    public void onDraw(Canvas canvas) {
        int i;
        List<SeatNew> valueAt;
        long j;
        int i2;
        int i3;
        Bitmap bitmap;
        OnSeatViewListener onSeatViewListener;
        boolean z;
        OnSeatViewListener onSeatViewListener2;
        Picture picture;
        Picture picture2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1866875854")) {
            ipChange.ipc$dispatch("-1866875854", new Object[]{this, canvas});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        PictureDrawable pictureDrawable = this.regionPictureDataWithoutColor;
        if (pictureDrawable != null) {
            try {
                float f2 = 1.0f;
                if (this.isFirstDraw) {
                    this.viewWidth = getWidth();
                    this.viewHeight = getViewUsedHeight();
                    this.regionImageWidth = ((float) pictureDrawable.getIntrinsicWidth()) * this.mSvgScale;
                    this.regionImageHeight = ((float) pictureDrawable.getIntrinsicHeight()) * this.mSvgScale;
                    this.drawSeat.f = 24;
                    float f3 = (float) DisplayMetrics.getwidthPixels(n42.b(this.mContext));
                    float f4 = f3 / (((float) (this.drawSeat.f * 18)) + 102.0f);
                    this.mScale18 = f4;
                    this.mScale36 = f4 * 0.5f;
                    this.mScale50 = 0.36f * f4;
                    this.mScale09 = f4 * 2.0f;
                    float f5 = this.regionImageWidth;
                    int i4 = this.viewHeight;
                    float f6 = this.regionImageHeight;
                    float f7 = ((float) i4) * f5 < ((float) this.viewWidth) * f6 ? (((float) i4) * f5) / f6 : f3;
                    if (this.isSmallVenueStyle) {
                        this.minRegionImageWidth = Math.min(f7, f5);
                    } else {
                        this.minRegionImageWidth = f3 * 0.5f;
                    }
                    float f8 = this.regionImageWidth;
                    float f9 = this.mScale36;
                    this.mBigVenueScale36Width = f8 * f9;
                    if (!this.isSmallVenueStyle) {
                        f9 = this.mScale50;
                    }
                    float f10 = f9 * f8;
                    this.minRegionImageDrawSeatWidth = f10;
                    this.bestRegionImageWidth = this.mScale18 * f8;
                    this.maxRegionImageWidth = f8 * this.mScale09;
                    float min = Math.min(f7, f10 - 1.0f);
                    this.bigVenueInitRegionImageWidth = min;
                    boolean z2 = this.isSmallVenueStyle;
                    if (z2) {
                        float f11 = this.minRegionImageWidth;
                        float f12 = this.bestRegionImageWidth;
                        if (f11 > f12) {
                            this.minRegionImageWidth = f12 - 1.0f;
                        }
                    } else if (this.minRegionImageWidth > min) {
                        this.minRegionImageWidth = min - 1.0f;
                    }
                    if (z2) {
                        this.drawSeat.a(this.minRegionImageWidth);
                    } else {
                        this.drawSeat.a(min);
                    }
                    int i5 = this.viewWidth;
                    c cVar = this.drawSeat;
                    float f13 = cVar.c;
                    float f14 = ((float) (i5 / 2)) - ((cVar.a / 2.0f) + f13);
                    float f15 = cVar.d;
                    cVar.c = f13 + f14;
                    cVar.d = f15 + (((float) (this.viewHeight / 2)) - ((cVar.b / 2.0f) + f15));
                    float f16 = (float) this.maxOverViewRectWidth;
                    this.rectW = f16;
                    float f17 = this.overviewSpacing;
                    this.rectH = (((f16 - (f17 * 2.0f)) * this.regionImageHeight) / this.regionImageWidth) + (f17 * 2.0f);
                    float strokeWidth = (((float) i5) - f16) - this.redBorderPaint.getStrokeWidth();
                    float f18 = this.overviewSpacing;
                    this.redBorderLeftBoundary = (strokeWidth + f18) - ((float) this.mOverViewOffset);
                    this.redBorderTopBoundary = (f18 - this.redBorderPaint.getStrokeWidth()) + ((float) this.mOverViewOffset);
                    this.redBorderRightBoundary = ((((float) this.viewWidth) - this.overviewSpacing) + this.redBorderPaint.getStrokeWidth()) - ((float) this.mOverViewOffset);
                    this.redBorderBottomBoundary = (this.rectH - this.overviewSpacing) + this.redBorderPaint.getStrokeWidth() + ((float) this.mOverViewOffset);
                }
                if (this.isSeatStateChanged && (picture2 = this.mColorRegionPicture) != null) {
                    this.overviewBitmap = getOverviewBitmap(picture2);
                }
                Rect rect = this.mBackgroundRect;
                c cVar2 = this.drawSeat;
                float f19 = cVar2.c;
                float f20 = cVar2.d;
                rect.set((int) f19, (int) f20, (int) (f19 + cVar2.a), (int) (f20 + cVar2.b));
                PictureDrawable pictureDrawable2 = this.regionPictureDataWithoutColor;
                if (pictureDrawable2 != null) {
                    if (this.isSmallVenueStyle) {
                        canvas.drawPicture(pictureDrawable2.getPicture(), this.mBackgroundRect);
                    } else if (this.drawSeat.a >= this.minRegionImageDrawSeatWidth) {
                        canvas.drawPicture(pictureDrawable2.getPicture(), this.mBackgroundRect);
                    } else if (this.mSelectPrice == null || (picture = this.mSVGVenueLayerPicture) == null) {
                        canvas.drawPicture(this.mColorRegionPicture, this.mBackgroundRect);
                    } else {
                        canvas.drawPicture(picture, this.mBackgroundRect);
                    }
                }
                if (this.drawSeat.a < this.minRegionImageDrawSeatWidth) {
                    if (!this.isSmallVenueStyle) {
                        this.isShow = false;
                        if (this.isFirstDraw) {
                            this.isFirstDraw = false;
                        }
                        if (this.isShowOverview && this.isDrawOverview && this.mSeatBox != null) {
                            Bitmap bitmap2 = this.overviewBitmap;
                            float f21 = ((float) this.viewWidth) - this.rectW;
                            int i6 = this.mOverViewOffset;
                            canvas.drawBitmap(bitmap2, f21 - ((float) i6), (float) i6, (Paint) null);
                            drawOverview(canvas);
                            onSeatViewListener2 = this.mListener;
                            if (onSeatViewListener2 != null) {
                                onSeatViewListener2.onShowBack2Venue(this.isSmallVenueStyle, false, true, null, 0, 0);
                            }
                        }
                        if (!this.isSmallVenueStyle && (onSeatViewListener = this.mListener) != null) {
                            z = this.drawSeat.a >= this.minRegionImageDrawSeatWidth;
                            if (this.isFirstDraw || this.isVenueMode != z) {
                                onSeatViewListener.onVenueModeChanged(z);
                            }
                            this.isVenueMode = z;
                        }
                        this.isSeatStateChanged = false;
                        if (isShowSvgRegionBound) {
                            testDrawSvgLocation(canvas);
                        }
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        this.mMonitor.k(currentTimeMillis2);
                        g91.g("SVG parse", "ZWSeat svg seat render cost = " + currentTimeMillis2);
                    }
                }
                this.isShow = true;
                if (this.isSmallVenueStyle) {
                    this.mInScreenSeatData = getAllRegion();
                } else {
                    this.mInScreenSeatData = getCurrentShownRegion();
                }
                int size = this.mInScreenSeatData.size();
                c cVar3 = this.drawSeat;
                float f22 = (float) cVar3.g;
                float f23 = f22 / 2.0f;
                if (!this.isSmallVenueStyle || !this.isSeatStateChanged) {
                    i = 0;
                } else {
                    f2 = (this.rectW - (this.overviewSpacing * 2.0f)) / this.regionImageWidth;
                    i = ((int) (((float) cVar3.f) * f2)) / 2;
                }
                boolean z3 = this.mSelectPrice != null;
                int i7 = 0;
                while (i7 < size) {
                    String keyAt = this.mInScreenSeatData.keyAt(i7);
                    if (this.mSeatRequestChecker.isRegionSeatRequestFinished(keyAt) && (valueAt = this.mInScreenSeatData.valueAt(i7)) != null) {
                        List<Picture> list = this.mPackageSeatWrapLineMap.get(keyAt);
                        if (!f92.d(list)) {
                            for (Picture picture3 : list) {
                                canvas.drawPicture(picture3, this.mBackgroundRect);
                            }
                        }
                        int size2 = valueAt.size();
                        int i8 = 0;
                        while (i8 < size2) {
                            SeatNew seatNew = valueAt.get(i8);
                            c cVar4 = this.drawSeat;
                            float f24 = cVar4.e;
                            float f25 = (((float) seatNew.y) * f24) + cVar4.d;
                            seatNew.currentY = f25;
                            float f26 = (((float) seatNew.x) * f24) + cVar4.c;
                            seatNew.currentX = f26;
                            if (this.isSeatStateChanged) {
                                if (this.isSmallVenueStyle) {
                                    j = currentTimeMillis;
                                    float f27 = f26 - f23;
                                    float f28 = f25 - f23;
                                    int i9 = cVar4.g;
                                    this.mSeatRect.set(f27, f28, ((float) i9) + f27, ((float) i9) + f28);
                                    if (this.mIconProvider.i()) {
                                        float f29 = seatNew.angle;
                                        if (f29 != 0.0f) {
                                            qx1.a(f29, this.mSeatRect);
                                        }
                                    }
                                    try {
                                        i2 = this.unavailableSeatColor;
                                        i3 = seatNew.state;
                                        if (i3 != 2) {
                                            if (seatNew.isSelected) {
                                                int i10 = seatNew.seatColor;
                                                if (seatNew.packageCombinedId == 0) {
                                                    bitmap = this.mIconProvider.a(i10, seatNew.angle, (byte) 11, false);
                                                } else {
                                                    bitmap = this.mIconProvider.a(i10, seatNew.angle, (byte) 13, false);
                                                }
                                                canvas.drawBitmap(bitmap, (Rect) null, this.mSeatRect, this.seatPaint);
                                            } else {
                                                boolean isNeedAddAlpha = isNeedAddAlpha(seatNew);
                                                if (seatNew.packageCombinedId == 0) {
                                                    canvas.drawBitmap(this.mIconProvider.a(seatNew.seatColor, seatNew.angle, (byte) 10, isNeedAddAlpha), (Rect) null, this.mSeatRect, this.mPaint);
                                                } else {
                                                    canvas.drawBitmap(this.mIconProvider.a(seatNew.seatColor, seatNew.angle, (byte) 12, isNeedAddAlpha), (Rect) null, this.mSeatRect, this.mPaint);
                                                }
                                            }
                                            i2 = seatNew.seatColor;
                                        } else if (i3 == 4) {
                                            canvas.drawBitmap(this.mIconProvider.b(seatNew.angle), (Rect) null, this.mSeatRect, this.mPaint);
                                        } else if (i3 != 8) {
                                            if (seatNew.packageCombinedId == 0) {
                                                canvas.drawBitmap(this.mIconProvider.a(i2, seatNew.angle, (byte) 10, false), (Rect) null, this.mSeatRect, this.mPaint);
                                            } else {
                                                canvas.drawBitmap(this.mIconProvider.a(i2, seatNew.angle, (byte) 12, false), (Rect) null, this.mSeatRect, this.mPaint);
                                            }
                                        } else if (seatNew.packageCombinedId == 0) {
                                            canvas.drawBitmap(this.mIconProvider.d(seatNew.angle, (byte) 14, z3), (Rect) null, this.mSeatRect, this.mPaint);
                                        } else {
                                            canvas.drawBitmap(this.mIconProvider.d(seatNew.angle, (byte) 15, z3), (Rect) null, this.mSeatRect, this.mPaint);
                                        }
                                        if (this.isSmallVenueStyle && this.isSeatStateChanged) {
                                            float f30 = this.overviewSpacing;
                                            int i11 = (int) ((((float) seatNew.x) * f2) + f30);
                                            int i12 = (int) ((((float) seatNew.y) * f2) + f30);
                                            float f31 = i >= 1 ? 0.5f : (float) i;
                                            this.overviewPaint.setColor(i2);
                                            float f32 = (float) i11;
                                            float f33 = (float) i12;
                                            this.overviewCanvas.drawRect(f32 - f31, f33 - f31, f32 + f31, f33 + f31, this.overviewPaint);
                                        }
                                    } catch (Exception unused) {
                                    }
                                    i8++;
                                    size = size;
                                    valueAt = valueAt;
                                    size2 = size2;
                                    currentTimeMillis = j;
                                }
                            }
                            if (f25 + f22 >= 0.0f) {
                                if (f26 + f22 >= 0.0f) {
                                    j = currentTimeMillis;
                                    if (f25 <= ((float) (this.viewHeight + this.seatViewPaddingBottom)) + f22) {
                                        if (f26 > ((float) this.viewWidth) + f22) {
                                        }
                                        float f272 = f26 - f23;
                                        float f282 = f25 - f23;
                                        int i92 = cVar4.g;
                                        this.mSeatRect.set(f272, f282, ((float) i92) + f272, ((float) i92) + f282);
                                        if (this.mIconProvider.i()) {
                                        }
                                        i2 = this.unavailableSeatColor;
                                        i3 = seatNew.state;
                                        if (i3 != 2) {
                                        }
                                        float f302 = this.overviewSpacing;
                                        int i112 = (int) ((((float) seatNew.x) * f2) + f302);
                                        int i122 = (int) ((((float) seatNew.y) * f2) + f302);
                                        if (i >= 1) {
                                        }
                                        this.overviewPaint.setColor(i2);
                                        float f322 = (float) i112;
                                        float f332 = (float) i122;
                                        this.overviewCanvas.drawRect(f322 - f31, f332 - f31, f322 + f31, f332 + f31, this.overviewPaint);
                                    }
                                    i8++;
                                    size = size;
                                    valueAt = valueAt;
                                    size2 = size2;
                                    currentTimeMillis = j;
                                }
                            }
                            j = currentTimeMillis;
                            i8++;
                            size = size;
                            valueAt = valueAt;
                            size2 = size2;
                            currentTimeMillis = j;
                        }
                    }
                    i7++;
                    size = size;
                    currentTimeMillis = currentTimeMillis;
                }
                if (this.isFirstDraw) {
                }
                Bitmap bitmap22 = this.overviewBitmap;
                float f212 = ((float) this.viewWidth) - this.rectW;
                int i62 = this.mOverViewOffset;
                canvas.drawBitmap(bitmap22, f212 - ((float) i62), (float) i62, (Paint) null);
                drawOverview(canvas);
                onSeatViewListener2 = this.mListener;
                if (onSeatViewListener2 != null) {
                }
                if (this.drawSeat.a >= this.minRegionImageDrawSeatWidth) {
                }
                onSeatViewListener.onVenueModeChanged(z);
                this.isVenueMode = z;
                this.isSeatStateChanged = false;
                if (isShowSvgRegionBound) {
                }
                long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                this.mMonitor.k(currentTimeMillis22);
                g91.g("SVG parse", "ZWSeat svg seat render cost = " + currentTimeMillis22);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (!this.isReportDrawError) {
                    this.isReportDrawError = true;
                    long k = g72.k(this.mParams);
                    String str = "msg by try catch:" + e2.getMessage();
                    String str2 = k + "";
                    u62.p("none", "none", str, str2, g72.m(this.mParams) + "");
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        RectF a2;
        VelocityTracker velocityTracker;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107014283")) {
            return ((Boolean) ipChange.ipc$dispatch("-1107014283", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getPointerCount() == 1) {
                float x = motionEvent.getX();
                this.mLastFocusX = x;
                this.mDownX = x;
                float y = motionEvent.getY();
                this.mLastFocusY = y;
                this.mDownY = y;
                c cVar = this.drawSeat;
                this.mDLeft = cVar.c;
                this.mDTop = cVar.d;
                this.mDWidth = cVar.a;
            }
            this.mAlwaysInTapRegion = true;
            this.mHandler.removeCallbacks(this.hideOverviewRunnable);
        } else if (action == 1) {
            if (!this.mAlwaysInTapRegion || this.mScaling) {
                if (!this.mScaling) {
                    float[] fArr = new float[2];
                    computeOffset2AdjustBounds(fArr);
                    if (Math.abs(fArr[0]) >= ((float) this.mTouchSlop) || Math.abs(fArr[1]) >= ((float) this.mTouchSlop)) {
                        c cVar2 = this.drawSeat;
                        f fVar = new f(this, cVar2.c, cVar2.d, cVar2.a);
                        c cVar3 = this.drawSeat;
                        zoomAnimate(fVar, new f(this, cVar3.c + fArr[0], cVar3.d + fArr[1], cVar3.a));
                    } else {
                        VelocityTracker velocityTracker2 = this.mVelocityTracker;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker2.computeCurrentVelocity(1000, (float) this.mMaximumFlingVelocity);
                        float yVelocity = velocityTracker2.getYVelocity(pointerId);
                        float xVelocity = velocityTracker2.getXVelocity(pointerId);
                        if (Math.abs(yVelocity) > ((float) this.mMinimumFlingVelocity) || Math.abs(xVelocity) > ((float) this.mMinimumFlingVelocity)) {
                            flingAnimate(xVelocity, yVelocity);
                        }
                    }
                    this.mHandler.postDelayed(this.hideOverviewRunnable, 500);
                }
            } else if (this.isSmallVenueStyle) {
                if (needAutoScale()) {
                    autoScale(motionEvent);
                }
                click(motionEvent.getX(), motionEvent.getY());
            } else if (this.drawSeat.a >= this.minRegionImageDrawSeatWidth || f92.d(this.mRegionBounds) || this.regions == null) {
                if (needAutoScale()) {
                    autoScale(motionEvent);
                }
                click(motionEvent.getX(), motionEvent.getY());
            } else {
                RegionBound pointRegionBound = getPointRegionBound(motionEvent);
                if (!(pointRegionBound == null || !g72.y(this.regions, pointRegionBound.regionVid) || (a2 = kz1.a(pointRegionBound.pointBounds)) == null)) {
                    translate2SVGScaledRegionRectF(a2);
                    float computeScaleZoom2Region = computeScaleZoom2Region(a2);
                    translate2ViewRegionRectF(a2);
                    zoom(a2.centerX(), a2.centerY(), (this.regionImageWidth * computeScaleZoom2Region) / this.drawSeat.a);
                }
            }
            if (this.mScaling) {
                this.mHandler.postDelayed(this.hideOverviewRunnable, 500);
            }
            VelocityTracker velocityTracker3 = this.mVelocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.mVelocityTracker = null;
            }
            this.mScaling = false;
        } else if (action != 2) {
            if (action == 3 && (velocityTracker = this.mVelocityTracker) != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        } else if (motionEvent.getPointerCount() == 1 && !this.mScaling) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f2 = x2 - this.mDownX;
            float f3 = y2 - this.mDownY;
            float f4 = this.mLastFocusX - x2;
            float f5 = this.mLastFocusY - y2;
            if (!this.isDrawOverview) {
                this.isDrawOverview = Math.abs(f2) >= ((float) this.mTouchSlop) || Math.abs(f3) >= ((float) this.mTouchSlop);
            }
            if (this.mAlwaysInTapRegion) {
                if (((int) ((f2 * f2) + (f3 * f3))) > this.mTouchSlopSquare) {
                    scrollView(f2 + this.mDLeft, f3 + this.mDTop);
                    this.mLastFocusX = x2;
                    this.mLastFocusY = y2;
                    this.mAlwaysInTapRegion = false;
                }
            } else if (Math.abs(f4) >= 1.0f || Math.abs(f5) >= 1.0f) {
                scrollView(f2 + this.mDLeft, f3 + this.mDTop);
                this.mLastFocusX = x2;
                this.mLastFocusY = y2;
            }
        } else if (motionEvent.getPointerCount() == 2) {
            this.isDrawOverview = true;
            if (!this.mScaling) {
                this.mDownX = motionEvent.getX(0);
                this.mDownY = motionEvent.getY(0);
                this.mScaleDistance = spacing(this.mDownX, this.mDownY, motionEvent.getX(1), motionEvent.getY(1));
                this.mScaling = true;
            }
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float x4 = motionEvent.getX(1);
            float y4 = motionEvent.getY(1);
            float spacing = spacing(x3, y3, x4, y4);
            float f6 = (x3 + x4) * 0.5f;
            float f7 = (y3 + y4) * 0.5f;
            c cVar4 = this.drawSeat;
            float f8 = cVar4.c;
            float f9 = cVar4.d;
            float f10 = cVar4.a;
            float f11 = cVar4.b;
            float f12 = this.mDWidth * (spacing / this.mScaleDistance);
            if (f12 > this.maxRegionImageWidth || f12 <= this.minRegionImageWidth) {
                return true;
            }
            cVar4.a(f12);
            c cVar5 = this.drawSeat;
            cVar5.c = f6 - (cVar5.a * ((f6 - f8) / f10));
            cVar5.d = f7 - (cVar5.b * ((f7 - f9) / f11));
            invalidate();
        }
        return true;
    }

    public void setListener(OnSeatViewListener onSeatViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2095988411")) {
            ipChange.ipc$dispatch("-2095988411", new Object[]{this, onSeatViewListener});
            return;
        }
        this.mListener = onSeatViewListener;
    }

    public void setRegionBounds(List<RegionBound> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "571729818")) {
            ipChange.ipc$dispatch("571729818", new Object[]{this, list});
            return;
        }
        this.mRegionBounds = list;
    }

    public void setRegionInitialPictureData(PictureDrawable pictureDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "261085880")) {
            ipChange.ipc$dispatch("261085880", new Object[]{this, pictureDrawable});
            return;
        }
        this.regionPictureDataWithoutColor = pictureDrawable;
    }

    public void setRegionPictureData(Picture picture) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052390905")) {
            ipChange.ipc$dispatch("1052390905", new Object[]{this, picture});
            return;
        }
        this.mColorRegionPicture = picture;
    }

    public void setRegions(List<Region> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679562934")) {
            ipChange.ipc$dispatch("-1679562934", new Object[]{this, list});
            return;
        }
        this.regions = list;
    }

    public void setSVGVenueLayerPicture(@Nullable Picture picture) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453443121")) {
            ipChange.ipc$dispatch("-1453443121", new Object[]{this, picture});
            return;
        }
        this.mSVGVenueLayerPicture = picture;
    }

    public void setSeatData(SeatBox seatBox) {
        Map<String, List<Path>> map;
        PictureDrawable pictureDrawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392984097")) {
            ipChange.ipc$dispatch("1392984097", new Object[]{this, seatBox});
            return;
        }
        this.mSeatBox = seatBox;
        this.isSeatStateChanged = true;
        this.mPackageSeatWrapLineMap.clear();
        SeatBox seatBox2 = this.mSeatBox;
        if (!(seatBox2 == null || (map = seatBox2.packagePathMap) == null || map.size() == 0 || (pictureDrawable = this.regionPictureDataWithoutColor) == null)) {
            int height = (int) (((float) pictureDrawable.getPicture().getHeight()) * this.mSvgScale);
            int width = (int) (((float) this.regionPictureDataWithoutColor.getPicture().getWidth()) * this.mSvgScale);
            for (String str : map.keySet()) {
                for (Path path : map.get(str)) {
                    Picture picture = new Picture();
                    picture.beginRecording(width, height).drawPath(path, this.packageSeatBorderPaint);
                    if (this.mPackageSeatWrapLineMap.get(str) == null) {
                        this.mPackageSeatWrapLineMap.put(str, new ArrayList());
                    }
                    this.mPackageSeatWrapLineMap.get(str).add(picture);
                }
            }
        }
    }

    public void setSeatRequestChecker(RegionSeatRequestChecker regionSeatRequestChecker) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216416079")) {
            ipChange.ipc$dispatch("216416079", new Object[]{this, regionSeatRequestChecker});
            return;
        }
        this.mSeatRequestChecker = regionSeatRequestChecker;
    }

    public void setSelectPrice(PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1717186998")) {
            ipChange.ipc$dispatch("1717186998", new Object[]{this, priceLevel});
            return;
        }
        this.mSelectPrice = priceLevel;
    }

    public void setSvgRegionLocations(List<List<PointLocation>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1406446147")) {
            ipChange.ipc$dispatch("-1406446147", new Object[]{this, list});
            return;
        }
        this.mSvgRegionLocations = list;
    }

    public void setSvgScale(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886004148")) {
            ipChange.ipc$dispatch("886004148", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        this.mSvgScale = f2;
    }

    public void translate2SVGScaledRegionRectF(RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906873741")) {
            ipChange.ipc$dispatch("-906873741", new Object[]{this, rectF});
            return;
        }
        float f2 = rectF.left;
        float f3 = this.mSvgScale;
        rectF.left = f2 * f3;
        rectF.right *= f3;
        rectF.top *= f3;
        rectF.bottom *= f3;
    }

    public void translate2ViewRegionRectF(RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "955220704")) {
            ipChange.ipc$dispatch("955220704", new Object[]{this, rectF});
            return;
        }
        float f2 = rectF.left;
        c cVar = this.drawSeat;
        float f3 = cVar.e;
        float f4 = cVar.c;
        rectF.left = (f2 * f3) + f4;
        rectF.right = (rectF.right * f3) + f4;
        float f5 = cVar.d;
        rectF.top = (rectF.top * f3) + f5;
        rectF.bottom = (rectF.bottom * f3) + f5;
    }

    public boolean zoom2AdaptSeatPrice() {
        c cVar;
        ArrayMap<String, List<SeatNew>> allRegion;
        HashSet<Long> hashSet;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "855089111")) {
            return ((Boolean) ipChange.ipc$dispatch("855089111", new Object[]{this})).booleanValue();
        }
        if (!this.isSmallVenueStyle || (cVar = this.drawSeat) == null || cVar.a <= 0.0f || this.viewWidth <= 0 || this.viewHeight <= 0 || this.mSelectPrice == null || (allRegion = getAllRegion()) == null) {
            return false;
        }
        float f3 = Float.MIN_VALUE;
        float f4 = Float.MIN_VALUE;
        float f5 = Float.MAX_VALUE;
        float f6 = Float.MAX_VALUE;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < allRegion.size(); i2++) {
            List<SeatNew> valueAt = allRegion.valueAt(i2);
            if (!f92.d(valueAt)) {
                if (this.mSelectPrice.isFreeCombineTiaoPiao()) {
                    hashSet = this.mSelectPrice.getSubPriceIds();
                } else {
                    hashSet = new HashSet<>();
                    hashSet.add(Long.valueOf(this.mSelectPrice.getPriceId()));
                }
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                }
                for (SeatNew seatNew : valueAt) {
                    long j = seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
                    if (seatNew.state != o72.SEAT_STATUS_AVAILABLE.shortValue() || !hashSet.contains(Long.valueOf(j))) {
                        f4 = f4;
                    } else {
                        i++;
                        c cVar2 = this.drawSeat;
                        float f7 = cVar2.e;
                        float f8 = (((float) seatNew.x) * f7) + cVar2.c;
                        float f9 = (((float) seatNew.y) * f7) + cVar2.d;
                        if (z) {
                            float min = Math.min(f8, f5);
                            float max = Math.max(f8, f3);
                            float min2 = Math.min(f9, f6);
                            f3 = max;
                            f8 = min;
                            f2 = Math.max(f9, f4);
                            f9 = min2;
                        } else {
                            f3 = f8;
                            f2 = f9;
                        }
                        f5 = f8;
                        f6 = f9;
                        z = true;
                        f4 = f2;
                    }
                    if (i > 10) {
                        return false;
                    }
                }
            }
        }
        if (!z || i > 10) {
            return false;
        }
        c cVar3 = this.drawSeat;
        int i3 = cVar3.g;
        float f10 = (f3 - f5) + ((float) i3);
        float f11 = (f4 - f6) + ((float) i3);
        int i4 = this.viewWidth;
        float f12 = ((float) i4) / 2.0f;
        int i5 = this.viewHeight;
        float f13 = ((float) i5) / 2.0f;
        float f14 = f13 - ((f6 + f4) / 2.0f);
        float f15 = cVar3.c + (f12 - ((f3 + f5) / 2.0f));
        float f16 = cVar3.d + f14;
        float f17 = 1.0f;
        if (f10 > 0.0f && f11 > 0.0f) {
            f17 = f10 / f11 < ((float) i4) / ((float) i5) ? ((float) i5) / f11 : ((float) i4) / f10;
            if (f10 < ((float) i4) && f11 < ((float) i5)) {
                f17 = Math.min(f17, this.maxRegionImageWidth / cVar3.a);
            }
        }
        float f18 = f13 - ((f13 - f16) * f17);
        c cVar4 = this.drawSeat;
        float f19 = cVar4.a;
        f fVar = new f(this, cVar4.c, cVar4.d, f19);
        f fVar2 = new f(this, f12 - ((f12 - f15) * f17), f18, f17 * f19);
        this.isDrawOverview = true;
        zoomAnimate(fVar, fVar2, new b());
        return true;
    }

    public void zoom2FullViewMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389265758")) {
            ipChange.ipc$dispatch("1389265758", new Object[]{this});
            return;
        }
        c cVar = this.drawSeat;
        if (cVar != null) {
            float f2 = cVar.a;
            if (f2 > 0.0f && this.regionImageWidth > 0.0f && this.viewWidth > 0 && this.viewHeight > 0) {
                if (this.isSmallVenueStyle) {
                    f fVar = new f(this, cVar.c, cVar.d, f2);
                    float f3 = this.minRegionImageWidth;
                    float f4 = (float) this.viewHeight;
                    this.isDrawOverview = false;
                    zoomAnimate(fVar, new f(this, (((float) this.viewWidth) - f3) / 2.0f, (f4 - ((this.regionImageHeight / this.regionImageWidth) * f3)) / 2.0f, f3));
                    return;
                }
                f fVar2 = new f(this, cVar.c, cVar.d, f2);
                float f5 = this.bigVenueInitRegionImageWidth;
                f fVar3 = new f(this, (((float) this.viewWidth) - f5) / 2.0f, (((float) this.viewHeight) - ((this.regionImageHeight / this.regionImageWidth) * f5)) / 2.0f, f5);
                this.isDrawOverview = false;
                zoomAnimate(fVar2, fVar3);
            }
        }
    }

    public void zoomWhenSeatPriceChanged(@Nullable PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328088708")) {
            ipChange.ipc$dispatch("1328088708", new Object[]{this, priceLevel});
            return;
        }
        this.mSelectPrice = priceLevel;
        if (priceLevel == null) {
            invalidate();
        } else if (!this.isSmallVenueStyle) {
            zoom2FullViewMode();
        } else if (!zoom2AdaptSeatPrice()) {
            zoom2FullViewMode();
        }
    }

    private void zoomAnimate(f fVar, f fVar2, Animator.AnimatorListener animatorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462066138")) {
            ipChange.ipc$dispatch("1462066138", new Object[]{this, fVar, fVar2, animatorListener});
            return;
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new e(), fVar, fVar2);
        ofObject.setInterpolator(new DecelerateInterpolator());
        ofObject.addUpdateListener(new g());
        if (animatorListener != null) {
            ofObject.addListener(animatorListener);
        }
        ofObject.setDuration(300L);
        ofObject.start();
    }
}
