package cn.damai.uikit.magicindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import tb.f7;
import tb.gn0;
import tb.sp2;
import tb.sr1;

/* compiled from: Taobao */
public class LinePagerIndicatorEx extends View implements IPagerIndicator {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MODE_EXACTLY = 2;
    public static final int MODE_MATCH_EDGE = 0;
    public static final int MODE_WRAP_CONTENT = 1;
    private List<Integer> mColors;
    private Interpolator mEndInterpolator = new LinearInterpolator();
    private float mLineHeight;
    private RectF mLineRect = new RectF();
    private float mLineWidth;
    private int mMode;
    private Paint mPaint;
    private List<sr1> mPositionDataList;
    private float mRoundRadius;
    private Interpolator mStartInterpolator = new LinearInterpolator();
    private float mXOffset;
    private float mYOffset;

    public LinePagerIndicatorEx(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1540517653")) {
            ipChange.ipc$dispatch("-1540517653", new Object[]{this, context});
            return;
        }
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mLineHeight = (float) sp2.a(context, 3.0d);
        this.mLineWidth = (float) sp2.a(context, 10.0d);
    }

    public List<Integer> getColors() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "137947696")) {
            return this.mColors;
        }
        return (List) ipChange.ipc$dispatch("137947696", new Object[]{this});
    }

    public Interpolator getEndInterpolator() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1364005994")) {
            return this.mEndInterpolator;
        }
        return (Interpolator) ipChange.ipc$dispatch("-1364005994", new Object[]{this});
    }

    public float getLineHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-93132420")) {
            return this.mLineHeight;
        }
        return ((Float) ipChange.ipc$dispatch("-93132420", new Object[]{this})).floatValue();
    }

    public RectF getLineRect() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1183488344")) {
            return this.mLineRect;
        }
        return (RectF) ipChange.ipc$dispatch("1183488344", new Object[]{this});
    }

    public float getLineWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-645365887")) {
            return this.mLineWidth;
        }
        return ((Float) ipChange.ipc$dispatch("-645365887", new Object[]{this})).floatValue();
    }

    public int getMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-496661865")) {
            return this.mMode;
        }
        return ((Integer) ipChange.ipc$dispatch("-496661865", new Object[]{this})).intValue();
    }

    public Paint getPaint() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "797351142")) {
            return this.mPaint;
        }
        return (Paint) ipChange.ipc$dispatch("797351142", new Object[]{this});
    }

    public float getRoundRadius() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2093875277")) {
            return this.mRoundRadius;
        }
        return ((Float) ipChange.ipc$dispatch("-2093875277", new Object[]{this})).floatValue();
    }

    public Interpolator getStartInterpolator() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1280306479")) {
            return this.mStartInterpolator;
        }
        return (Interpolator) ipChange.ipc$dispatch("1280306479", new Object[]{this});
    }

    public float getXOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2061857944")) {
            return this.mXOffset;
        }
        return ((Float) ipChange.ipc$dispatch("-2061857944", new Object[]{this})).floatValue();
    }

    public float getYOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2036595847")) {
            return this.mYOffset;
        }
        return ((Float) ipChange.ipc$dispatch("2036595847", new Object[]{this})).floatValue();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1350757563")) {
            ipChange.ipc$dispatch("1350757563", new Object[]{this, canvas});
            return;
        }
        RectF rectF = this.mLineRect;
        float f = this.mRoundRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1464294636")) {
            ipChange.ipc$dispatch("-1464294636", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1572701107")) {
            ipChange.ipc$dispatch("1572701107", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            return;
        }
        List<sr1> list = this.mPositionDataList;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.mColors;
            if (list2 != null && list2.size() > 0) {
                this.mPaint.setColor(f7.a(f, this.mColors.get(Math.abs(i) % this.mColors.size()).intValue(), this.mColors.get(Math.abs(i + 1) % this.mColors.size()).intValue()));
            }
            sr1 a = gn0.a(this.mPositionDataList, i);
            sr1 a2 = gn0.a(this.mPositionDataList, i + 1);
            int i4 = this.mMode;
            if (i4 == 0) {
                f6 = this.mXOffset;
                f5 = ((float) a.a) + f6;
                f4 = ((float) a2.a) + f6;
                f2 = ((float) a.c) - f6;
                i3 = a2.c;
            } else if (i4 == 1) {
                f6 = this.mXOffset;
                f5 = ((float) a.e) + f6;
                f4 = ((float) a2.e) + f6;
                f2 = ((float) a.g) - f6;
                i3 = a2.g;
            } else {
                f5 = ((float) a.a) + ((((float) a.b()) - this.mLineWidth) / 2.0f);
                float b = ((float) a2.a) + ((((float) a2.b()) - this.mLineWidth) / 2.0f);
                f2 = ((((float) a.b()) + this.mLineWidth) / 2.0f) + ((float) a.a);
                f3 = ((((float) a2.b()) + this.mLineWidth) / 2.0f) + ((float) a2.a);
                f4 = b;
                this.mLineRect.left = f5 + ((f4 - f5) * this.mStartInterpolator.getInterpolation(f));
                this.mLineRect.right = f2 + ((f3 - f2) * this.mEndInterpolator.getInterpolation(f));
                this.mLineRect.top = (((float) getHeight()) - this.mLineHeight) - this.mYOffset;
                this.mLineRect.bottom = ((float) getHeight()) - this.mYOffset;
                invalidate();
            }
            f3 = ((float) i3) - f6;
            this.mLineRect.left = f5 + ((f4 - f5) * this.mStartInterpolator.getInterpolation(f));
            this.mLineRect.right = f2 + ((f3 - f2) * this.mEndInterpolator.getInterpolation(f));
            this.mLineRect.top = (((float) getHeight()) - this.mLineHeight) - this.mYOffset;
            this.mLineRect.bottom = ((float) getHeight()) - this.mYOffset;
            invalidate();
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "425823071")) {
            ipChange.ipc$dispatch("425823071", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPositionDataProvide(List<sr1> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63763041")) {
            ipChange.ipc$dispatch("-63763041", new Object[]{this, list});
            return;
        }
        this.mPositionDataList = list;
    }

    public void setColors(Integer... numArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525051411")) {
            ipChange.ipc$dispatch("-525051411", new Object[]{this, numArr});
            return;
        }
        this.mColors = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342618312")) {
            ipChange.ipc$dispatch("-342618312", new Object[]{this, interpolator});
            return;
        }
        this.mEndInterpolator = interpolator;
        if (interpolator == null) {
            this.mEndInterpolator = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467736512")) {
            ipChange.ipc$dispatch("467736512", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mLineHeight = f;
    }

    public void setLineWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362921789")) {
            ipChange.ipc$dispatch("-362921789", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mLineWidth = f;
    }

    public void setMode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694801387")) {
            ipChange.ipc$dispatch("1694801387", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 2 || i == 0 || i == 1) {
            this.mMode = i;
        } else {
            throw new IllegalArgumentException("mode " + i + " not supported.");
        }
    }

    public void setRoundRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434436561")) {
            ipChange.ipc$dispatch("434436561", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mRoundRadius = f;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364741185")) {
            ipChange.ipc$dispatch("-1364741185", new Object[]{this, interpolator});
            return;
        }
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setXOffset(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264795972")) {
            ipChange.ipc$dispatch("-1264795972", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mXOffset = f;
    }

    public void setYOffset(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1233219965")) {
            ipChange.ipc$dispatch("1233219965", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mYOffset = f;
    }
}
