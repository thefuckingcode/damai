package cn.damai.launcher.splash;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import cn.damai.homepage.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SplashRoundProgressBar extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FILL = 1;
    private static final String LABEL = "跳过";
    public static final int STROKE = 0;
    private Paint.FontMetrics fontMetrics;
    private int max;
    private Paint paint;
    private int progress;
    private int roundColor;
    private int roundProgressColor;
    private float roundWidth;
    private int style;
    private int textColor;
    private boolean textIsDisplayable;
    private float textSize;

    public SplashRoundProgressBar(Context context) {
        this(context, null);
    }

    public int getCricleColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2144058616")) {
            return this.roundColor;
        }
        return ((Integer) ipChange.ipc$dispatch("2144058616", new Object[]{this})).intValue();
    }

    public int getCricleProgressColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1701372741")) {
            return this.roundProgressColor;
        }
        return ((Integer) ipChange.ipc$dispatch("1701372741", new Object[]{this})).intValue();
    }

    public synchronized int getMax() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860389685")) {
            return ((Integer) ipChange.ipc$dispatch("860389685", new Object[]{this})).intValue();
        }
        return this.max;
    }

    public synchronized int getProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1294352630")) {
            return ((Integer) ipChange.ipc$dispatch("-1294352630", new Object[]{this})).intValue();
        }
        return this.progress;
    }

    public float getRoundWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1683695804")) {
            return this.roundWidth;
        }
        return ((Float) ipChange.ipc$dispatch("1683695804", new Object[]{this})).floatValue();
    }

    public int getTextColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1211410019")) {
            return this.textColor;
        }
        return ((Integer) ipChange.ipc$dispatch("1211410019", new Object[]{this})).intValue();
    }

    public float getTextSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1160284474")) {
            return this.textSize;
        }
        return ((Float) ipChange.ipc$dispatch("-1160284474", new Object[]{this})).floatValue();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-335309192")) {
            ipChange.ipc$dispatch("-335309192", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = (float) width;
        int i = (int) (f - (this.roundWidth / 2.0f));
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setAntiAlias(true);
        this.paint.setColor(Color.parseColor("#8A000000"));
        canvas.drawCircle(f, f, (float) i, this.paint);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.getFontSpacing();
        float measureText = this.paint.measureText(LABEL);
        if (this.textIsDisplayable && this.style == 0) {
            this.paint.getFontMetrics(this.fontMetrics);
            Paint.FontMetrics fontMetrics2 = this.fontMetrics;
            float f2 = f - (measureText / 2.0f);
            canvas.drawText(LABEL, f2, (((float) getHeight()) - ((((float) getHeight()) - (fontMetrics2.bottom - fontMetrics2.top)) / 2.0f)) - this.fontMetrics.bottom, this.paint);
        }
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(this.roundProgressColor);
        float f3 = (float) (width - i);
        float f4 = (float) (width + i);
        RectF rectF = new RectF(f3, f3, f4, f4);
        float f5 = (((float) this.progress) * 300.0f) / ((float) this.max);
        int i2 = this.style;
        if (i2 == 0) {
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(rectF, -90.0f, f5, false, this.paint);
        } else if (i2 == 1) {
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.progress != 0) {
                canvas.drawArc(rectF, -90.0f, f5, true, this.paint);
            }
        }
    }

    public void setCricleColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333596142")) {
            ipChange.ipc$dispatch("-1333596142", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.roundColor = i;
    }

    public void setCricleProgressColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575214949")) {
            ipChange.ipc$dispatch("1575214949", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.roundProgressColor = i;
    }

    public synchronized void setMax(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1455855755")) {
            ipChange.ipc$dispatch("-1455855755", new Object[]{this, Integer.valueOf(i)});
        } else if (i >= 0) {
            this.max = i;
        } else {
            throw new IllegalArgumentException("max not less than 0");
        }
    }

    public synchronized void setProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559443496")) {
            ipChange.ipc$dispatch("-559443496", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < 0) {
            i = 0;
        }
        int i2 = this.max;
        if (i > i2) {
            i = i2;
        }
        if (i <= i2) {
            this.progress = i;
            postInvalidate();
        }
    }

    public void setRoundWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285163392")) {
            ipChange.ipc$dispatch("-285163392", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.roundWidth = f;
    }

    public void setTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1362559239")) {
            ipChange.ipc$dispatch("1362559239", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.textColor = i;
    }

    public void setTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698300746")) {
            ipChange.ipc$dispatch("-698300746", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.textSize = f;
    }

    public SplashRoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SplashRoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        this.fontMetrics = new Paint.FontMetrics();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SplashRoundProgressBar);
        this.roundColor = obtainStyledAttributes.getColor(R$styleable.SplashRoundProgressBar_roundColor, 0);
        this.roundProgressColor = obtainStyledAttributes.getColor(R$styleable.SplashRoundProgressBar_roundProgressColor, 0);
        this.textColor = obtainStyledAttributes.getColor(R$styleable.SplashRoundProgressBar_textColor, 0);
        this.textSize = obtainStyledAttributes.getDimension(R$styleable.SplashRoundProgressBar_textSize, 15.0f);
        this.roundWidth = obtainStyledAttributes.getDimension(R$styleable.SplashRoundProgressBar_roundWidthProgressBar, 5.0f);
        this.max = obtainStyledAttributes.getInteger(R$styleable.SplashRoundProgressBar_max, 100);
        this.textIsDisplayable = obtainStyledAttributes.getBoolean(R$styleable.SplashRoundProgressBar_textIsDisplayable, true);
        this.style = obtainStyledAttributes.getInt(R$styleable.SplashRoundProgressBar_style, 0);
        obtainStyledAttributes.recycle();
    }
}
