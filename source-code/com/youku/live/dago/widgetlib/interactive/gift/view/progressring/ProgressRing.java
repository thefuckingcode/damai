package com.youku.live.dago.widgetlib.interactive.gift.view.progressring;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;

/* compiled from: Taobao */
public class ProgressRing extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MSG_START_COUNTDOWNNUM = 1;
    private boolean antiClockWise = false;
    private int bgEndColor;
    private int bgMidColor;
    private Paint bgPaint = new Paint(5);
    private int bgStartColor;
    private int curProgress = 0;
    private PaintFlagsDrawFilter filter;
    private int mDefaultInterval = 100;
    private Handler mHandler;
    private int mMeasureHeight;
    private int mMeasureWidth;
    private RectF pRectF;
    private int progress;
    private int progressEndColor;
    private int progressMidColor;
    private Paint progressPaint = new Paint(5);
    private int progressStartColor;
    private float progressWidth;
    private boolean showAnim;
    private int startAngle;
    private int sweepAngle;
    private float totalProgress = 100.0f;
    private float unitAngle;

    public ProgressRing(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Dago_Pgc_ProgressRing);
        this.progressStartColor = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_progress_start_color, InputDeviceCompat.SOURCE_ANY);
        this.progressMidColor = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_progress_mid_color, InputDeviceCompat.SOURCE_ANY);
        this.progressEndColor = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_progress_end_color, this.progressStartColor);
        int color = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_bg_start_color, -3355444);
        this.bgStartColor = color;
        this.bgMidColor = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_bg_mid_color, color);
        this.bgEndColor = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_bg_end_color, this.bgStartColor);
        this.progress = obtainStyledAttributes.getInt(R.styleable.Dago_Pgc_ProgressRing_pr_progress, 0);
        this.progressWidth = obtainStyledAttributes.getDimension(R.styleable.Dago_Pgc_ProgressRing_pr_progress_width, 8.0f);
        this.startAngle = obtainStyledAttributes.getInt(R.styleable.Dago_Pgc_ProgressRing_pr_start_angle, 150);
        this.sweepAngle = obtainStyledAttributes.getInt(R.styleable.Dago_Pgc_ProgressRing_pr_sweep_angle, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
        this.showAnim = obtainStyledAttributes.getBoolean(R.styleable.Dago_Pgc_ProgressRing_pr_show_anim, true);
        this.antiClockWise = obtainStyledAttributes.getBoolean(R.styleable.Dago_Pgc_ProgressRing_pr_anti_clock_wise, false);
        obtainStyledAttributes.recycle();
        this.unitAngle = ((float) this.sweepAngle) / this.totalProgress;
        this.bgPaint.setStyle(Paint.Style.STROKE);
        this.bgPaint.setStrokeCap(Paint.Cap.ROUND);
        this.bgPaint.setAntiAlias(true);
        this.bgPaint.setStrokeWidth(this.progressWidth);
        this.progressPaint.setStyle(Paint.Style.STROKE);
        this.progressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.progressPaint.setAntiAlias(true);
        this.progressPaint.setStrokeWidth(this.progressWidth);
        this.filter = new PaintFlagsDrawFilter(0, 7);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doCountDownNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950516213")) {
            ipChange.ipc$dispatch("-1950516213", new Object[]{this});
        } else if (this.progress != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = this.mDefaultInterval;
            this.mHandler.sendEmptyMessageAtTime(1, uptimeMillis + (((long) i) - (uptimeMillis % ((long) i))));
            setProgress(this.progress);
            this.progress--;
        } else {
            reSet();
        }
    }

    private void drawBg(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546588995")) {
            ipChange.ipc$dispatch("1546588995", new Object[]{this, canvas});
            return;
        }
        int i = this.sweepAngle;
        float f = (float) (i / 2);
        int i2 = (int) (((float) this.curProgress) * this.unitAngle);
        while (i > i2) {
            float f2 = (float) i;
            float f3 = f2 - f;
            if (f3 > 0.0f) {
                this.bgPaint.setColor(getGradient(f3 / f, this.bgMidColor, this.bgEndColor));
            } else {
                this.bgPaint.setColor(getGradient((f - f2) / f, this.bgMidColor, this.bgStartColor));
            }
            canvas.drawArc(this.pRectF, (float) (this.startAngle + i), 1.0f, false, this.bgPaint);
            i--;
        }
    }

    private void drawProgress(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "50164395")) {
            ipChange.ipc$dispatch("50164395", new Object[]{this, canvas});
            return;
        }
        float f = (float) (this.sweepAngle / 2);
        int i = (int) (((float) this.curProgress) * this.unitAngle);
        for (int i2 = 0; i2 <= i; i2++) {
            float f2 = (float) i2;
            float f3 = f2 - f;
            if (f3 > 0.0f) {
                this.progressPaint.setColor(getGradient(f3 / f, this.progressMidColor, this.progressStartColor));
            } else {
                this.progressPaint.setColor(getGradient((f - f2) / f, this.progressMidColor, this.progressEndColor));
            }
            if (this.antiClockWise) {
                canvas.drawArc(this.pRectF, (float) (this.startAngle + i2), 1.0f, false, this.progressPaint);
            } else {
                canvas.drawArc(this.pRectF, (float) (this.startAngle - i2), 1.0f, false, this.progressPaint);
            }
        }
    }

    private void initHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58566821")) {
            ipChange.ipc$dispatch("58566821", new Object[]{this});
            return;
        }
        this.mHandler = new Handler(Looper.getMainLooper()) {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.progressring.ProgressRing.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "719250438")) {
                    ipChange.ipc$dispatch("719250438", new Object[]{this, message});
                } else if (message.what == 1) {
                    ProgressRing.this.doCountDownNum();
                }
            }
        };
    }

    private void reSet() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2099255024")) {
            ipChange.ipc$dispatch("2099255024", new Object[]{this});
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
    }

    public int getGradient(float f, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-277605158")) {
            return ((Integer) ipChange.ipc$dispatch("-277605158", new Object[]{this, Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        int alpha = Color.alpha(i);
        int red = Color.red(i);
        int blue = Color.blue(i);
        int green = Color.green(i);
        int alpha2 = Color.alpha(i2);
        int red2 = Color.red(i2);
        int i3 = alpha2 - alpha;
        int i4 = red2 - red;
        int blue2 = Color.blue(i2) - blue;
        return Color.argb((int) (((float) alpha) + (((float) i3) * f)), (int) (((float) red) + (((float) i4) * f)), (int) (((float) green) + (f * ((float) (Color.green(i2) - green)))), (int) (((float) blue) + (((float) blue2) * f)));
    }

    public int getProgress() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1940736111")) {
            return this.progress;
        }
        return ((Integer) ipChange.ipc$dispatch("1940736111", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653165731")) {
            ipChange.ipc$dispatch("-653165731", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (!this.showAnim) {
            this.curProgress = this.progress;
        }
        canvas.setDrawFilter(this.filter);
        drawProgress(canvas);
        int i = this.curProgress;
        if (i < this.progress) {
            this.curProgress = i + 1;
            postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1304987904")) {
            ipChange.ipc$dispatch("-1304987904", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        this.mMeasureWidth = measuredWidth;
        this.mMeasureHeight = measuredWidth;
        if (this.pRectF == null) {
            float f = this.progressWidth / 2.0f;
            this.pRectF = new RectF(((float) getPaddingLeft()) + f, ((float) getPaddingTop()) + f, (((float) this.mMeasureWidth) - f) - ((float) getPaddingRight()), (((float) this.mMeasureHeight) - f) - ((float) getPaddingBottom()));
        }
    }

    public void setAutoCountDown(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "68829099")) {
            ipChange.ipc$dispatch("68829099", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        initHandler();
        setMaxProgress(360.0f);
        float f = this.totalProgress;
        this.mDefaultInterval = (int) (((float) (i * 1000)) / f);
        this.progress = (int) ((((float) i2) * f) / ((float) i));
        ((ILog) Dsl.getService(ILog.class)).i("countdown", "progress = " + this.progress);
        ((ILog) Dsl.getService(ILog.class)).i("countdown", "mDefaultInterval = " + this.mDefaultInterval);
        doCountDownNum();
    }

    public void setMaxProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-127751196")) {
            ipChange.ipc$dispatch("-127751196", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.totalProgress = f;
        this.unitAngle = ((float) this.sweepAngle) / f;
    }

    public void setProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "944059667")) {
            ipChange.ipc$dispatch("944059667", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.progress = i;
        postInvalidate();
    }
}
