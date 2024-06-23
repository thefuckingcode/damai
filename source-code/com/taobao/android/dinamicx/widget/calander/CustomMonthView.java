package com.taobao.android.dinamicx.widget.calander;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import com.taobao.android.dinamicx.widget.calander.Calendar;
import tb.d00;

/* compiled from: Taobao */
public class CustomMonthView extends MonthView {
    protected Paint mBackgroundPaint;
    protected Paint mCalendarInfoPaint;
    private Paint mCurDaySelectPaint;
    private Paint mCurDayUnSelectPaint;
    protected float mCurrentDayTextBaseLine;
    protected float mOutRangeTextBaseLine;
    protected Paint mOutRangeTextPaint;
    private int mSelectedCircleRadius;

    public CustomMonthView(Context context) {
        super(context);
    }

    private float[] getRoundRectRadius(float f, boolean z, boolean z2, boolean z3, boolean z4) {
        float[] fArr = new float[8];
        if (z) {
            fArr[0] = f;
            fArr[1] = f;
        }
        if (z2) {
            fArr[2] = f;
            fArr[3] = f;
        }
        if (z3) {
            fArr[4] = f;
            fArr[5] = f;
        }
        if (z4) {
            fArr[6] = f;
            fArr[7] = f;
        }
        return fArr;
    }

    public float getTextBaseLintByPaint(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        if (this.mDelegate.b() == CalendarDateTextGravity.Top) {
            if (this.mSelectedCircleRadius == 0) {
                onPreviewHook();
            }
            float f = fontMetrics.bottom;
            float f2 = fontMetrics.top;
            return ((float) d00.b(getContext(), 3.0f)) + ((((float) this.mSelectedCircleRadius) + ((f - f2) / 2.0f)) - fontMetrics.descent) + ((f2 - fontMetrics.ascent) / 2.0f);
        }
        float f3 = fontMetrics.bottom;
        float f4 = fontMetrics.top;
        return (((((float) this.mItemHeight) / 2.0f) + ((f3 - f4) / 2.0f)) - fontMetrics.descent) + ((f4 - fontMetrics.ascent) / 2.0f);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.calander.BaseView
    public void initPaint() {
        super.initPaint();
        this.mOutRangeTextPaint = new Paint();
        this.mCurDaySelectPaint = new Paint();
        this.mCurDayUnSelectPaint = new Paint();
        this.mCalendarInfoPaint = new Paint();
        initCommonPaintWithTypeFace(this.mOutRangeTextPaint, -3355444, 14);
        initCommonPaintWithTypeFace(this.mCurDaySelectPaint, -1, 16);
        initCommonPaintWithTypeFace(this.mCurDayUnSelectPaint, -15658735, 16);
        initCommonPaint(this.mCalendarInfoPaint, -43776, 11);
        Paint paint = new Paint();
        this.mBackgroundPaint = paint;
        paint.setAntiAlias(true);
        this.mBackgroundPaint.setColor(-2062);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.calander.MonthView
    public void onDrawCalendarInfo(Canvas canvas, Calendar calendar, int i, int i2) {
        int b = d00.b(getContext(), 6.0f);
        Calendar.a calendarInfo = calendar.getCalendarInfo();
        if (calendarInfo != null && !TextUtils.isEmpty(calendarInfo.a)) {
            if (!TextUtils.isEmpty(calendarInfo.b)) {
                try {
                    this.mBackgroundPaint.setColor(Color.parseColor(calendar.getCalendarInfo().b));
                } catch (Throwable unused) {
                }
            }
            if (calendar.roundRectType == Calendar.RoundRectType.ALL) {
                float f = (float) b;
                canvas.drawRoundRect(new RectF((float) i, (float) i2, (float) (this.mItemWidth + i), (float) (this.mItemHeight + i2)), f, f, this.mBackgroundPaint);
            } else {
                Path path = new Path();
                Calendar.RoundRectType roundRectType = calendar.roundRectType;
                boolean z = roundRectType == Calendar.RoundRectType.LEFT;
                boolean z2 = roundRectType == Calendar.RoundRectType.RIGHT;
                path.addRoundRect(new RectF((float) i, (float) i2, (float) (this.mItemWidth + i), (float) (this.mItemHeight + i2)), getRoundRectRadius((float) b, z, z2, z2, z), Path.Direction.CW);
                canvas.drawPath(path, this.mBackgroundPaint);
            }
            float f2 = ((float) i) + (((float) this.mItemWidth) / 2.0f);
            Paint.FontMetrics fontMetrics = this.mCalendarInfoPaint.getFontMetrics();
            canvas.drawText(calendarInfo.a.length() > 4 ? calendarInfo.a.substring(0, 4) : calendarInfo.a, f2, (((float) (this.mItemHeight - d00.b(getContext(), 11.0f))) - fontMetrics.descent) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f) + ((float) i2), this.mCalendarInfoPaint);
        }
        if (calendar.isBooked()) {
            float f3 = ((float) (b * 3)) / 2.0f;
            canvas.drawCircle(((float) (this.mItemWidth + i)) - f3, ((float) i2) + f3, ((float) b) / 2.0f, this.mCalendarInfoPaint);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.calander.MonthView
    public void onDrawSelected(Canvas canvas, Calendar calendar, int i, int i2, boolean z) {
        int i3;
        int i4 = i + (this.mItemWidth / 2);
        if (this.mDelegate.b() == CalendarDateTextGravity.Top) {
            i2 += this.mSelectedCircleRadius;
            i3 = d00.b(getContext(), 3.0f);
        } else {
            i3 = this.mItemHeight / 2;
        }
        int i5 = this.mSelectedCircleRadius;
        float f = (float) (i2 + i3);
        this.mSelectedPaint.setShader(new LinearGradient((float) (i4 - i5), f, (float) (i5 + i4), f, Color.parseColor("#FF8100"), Color.parseColor("#FE560A"), Shader.TileMode.REPEAT));
        canvas.drawCircle((float) i4, f, (float) this.mSelectedCircleRadius, this.mSelectedPaint);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.calander.MonthView
    public void onDrawText(Canvas canvas, Calendar calendar, int i, int i2, boolean z, boolean z2) {
        Paint paint;
        float f = ((float) i) + (((float) this.mItemWidth) / 2.0f);
        String valueOf = calendar.isCurrentDay() ? "今" : String.valueOf(calendar.getDay());
        if (calendar.isCurrentDay()) {
            canvas.drawText(valueOf, f, (!isInRange(calendar) ? this.mOutRangeTextBaseLine : this.mCurrentDayTextBaseLine) + ((float) i2), !isInRange(calendar) ? this.mOutRangeTextPaint : !z2 ? this.mCurDayUnSelectPaint : this.mCurDaySelectPaint);
            return;
        }
        float f2 = (!isInRange(calendar) ? this.mOutRangeTextBaseLine : this.mTextBaseLine) + ((float) i2);
        if (z2) {
            paint = this.mSelectTextPaint;
        } else {
            paint = !isInRange(calendar) ? this.mOutRangeTextPaint : this.mCurMonthTextPaint;
        }
        canvas.drawText(valueOf, f, f2, paint);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.calander.BaseMonthView
    public void onLoopStart(int i, int i2) {
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.calander.BaseMonthView, com.taobao.android.dinamicx.widget.calander.BaseView
    public void onPreviewHook() {
        if (this.mDelegate.b() == CalendarDateTextGravity.Top) {
            this.mSelectedCircleRadius = d00.b(getContext(), 14.0f);
        } else {
            this.mSelectedCircleRadius = (Math.min(this.mItemWidth, this.mItemHeight) / 5) * 2;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.taobao.android.dinamicx.widget.calander.BaseMonthView, com.taobao.android.dinamicx.widget.calander.BaseView
    public void updateItemHeight() {
        super.updateItemHeight();
        this.mTextBaseLine = getTextBaseLintByPaint(this.mCurMonthTextPaint);
        this.mOutRangeTextBaseLine = getTextBaseLintByPaint(this.mOutRangeTextPaint);
        this.mCurrentDayTextBaseLine = getTextBaseLintByPaint(this.mCurDaySelectPaint);
    }

    /* access modifiers changed from: package-private */
    @Override // com.taobao.android.dinamicx.widget.calander.BaseView
    public void updateStyle() {
        super.updateStyle();
        b bVar = this.mDelegate;
        if (bVar != null) {
            this.mOutRangeTextPaint.setTextSize((float) bVar.l());
            if (this.mDelegate.h() > 0) {
                this.mCurDaySelectPaint.setTextSize((float) this.mDelegate.h());
                this.mCurDayUnSelectPaint.setTextSize((float) this.mDelegate.h());
            }
            this.mSelectTextPaint.setColor(this.mDelegate.z());
            this.mCurDaySelectPaint.setColor(this.mDelegate.z());
            this.mCurDayUnSelectPaint.setColor(this.mDelegate.i());
        }
    }
}
