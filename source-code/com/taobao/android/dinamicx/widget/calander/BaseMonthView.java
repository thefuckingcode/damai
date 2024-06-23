package com.taobao.android.dinamicx.widget.calander;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.taobao.android.dinamicx.widget.calander.CalendarView;
import java.util.List;

/* compiled from: Taobao */
public abstract class BaseMonthView extends BaseView {
    protected int mHeight;
    protected int mLineCount;
    protected int mMonth;
    MonthViewPager mMonthViewPager;
    protected int mNextDiff;
    protected int mYear;

    public BaseMonthView(Context context) {
        super(context);
    }

    @SuppressLint({"WrongConstant"})
    private void initCalendar() {
        b bVar;
        CalendarView.OnCalendarInterceptListener onCalendarInterceptListener;
        this.mNextDiff = a.h(this.mYear, this.mMonth, this.mDelegate.E());
        int l = a.l(this.mYear, this.mMonth, this.mDelegate.E());
        int g = a.g(this.mYear, this.mMonth);
        List<Calendar> n = a.n(this.mYear, this.mMonth, this.mDelegate);
        this.mItems = n;
        if (n.contains(this.mDelegate.g())) {
            this.mCurrentItem = this.mItems.indexOf(this.mDelegate.g());
        } else {
            this.mCurrentItem = this.mItems.indexOf(this.mDelegate.L);
        }
        if (this.mCurrentItem > 0 && (onCalendarInterceptListener = (bVar = this.mDelegate).D) != null && onCalendarInterceptListener.onCalendarIntercept(bVar.L)) {
            this.mCurrentItem = -1;
        }
        if (this.mDelegate.w() == 0) {
            this.mLineCount = 6;
        } else {
            this.mLineCount = ((l + g) + this.mNextDiff) / 7;
        }
        invalidate();
    }

    private void onClickCalendarPadding() {
        b bVar = this.mDelegate;
        if (bVar.C != null) {
            Calendar calendar = null;
            int e = ((int) (this.mX - ((float) bVar.e()))) / this.mItemWidth;
            if (e >= 7) {
                e = 6;
            }
            int i = ((((int) this.mY) / this.mItemHeight) * 7) + e;
            if (i >= 0 && i < this.mItems.size()) {
                calendar = this.mItems.get(i);
            }
            if (calendar != null) {
                CalendarView.OnClickCalendarPaddingListener onClickCalendarPaddingListener = this.mDelegate.C;
                float f = this.mX;
                float f2 = this.mY;
                onClickCalendarPaddingListener.onClickCalendarPadding(f, f2, true, calendar, getClickCalendarPaddingObject(f, f2, calendar));
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object getClickCalendarPaddingObject(float f, float f2, Calendar calendar) {
        return null;
    }

    /* access modifiers changed from: protected */
    public Calendar getIndex() {
        if (!(this.mItemWidth == 0 || this.mItemHeight == 0)) {
            if (this.mX <= ((float) this.mDelegate.e()) || this.mX >= ((float) (getWidth() - this.mDelegate.f()))) {
                onClickCalendarPadding();
            } else {
                int e = ((int) (this.mX - ((float) this.mDelegate.e()))) / this.mItemWidth;
                if (e >= 7) {
                    e = 6;
                }
                int i = ((((int) this.mY) / this.mItemHeight) * 7) + e;
                if (i < 0 || i >= this.mItems.size()) {
                    return null;
                }
                return this.mItems.get(i);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final int getSelectedIndex(Calendar calendar) {
        return this.mItems.indexOf(calendar);
    }

    /* access modifiers changed from: package-private */
    public final void initMonthWithDate(int i, int i2) {
        this.mYear = i;
        this.mMonth = i2;
        initCalendar();
        this.mHeight = a.k(i, i2, this.mItemHeight, this.mDelegate.E(), this.mDelegate.w());
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.calander.BaseView
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onLoopStart(int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.mLineCount != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.calander.BaseView
    public void onPreviewHook() {
    }

    /* access modifiers changed from: package-private */
    public final void setSelectedCalendar(Calendar calendar) {
        this.mCurrentItem = this.mItems.indexOf(calendar);
    }

    /* access modifiers changed from: package-private */
    @Override // com.taobao.android.dinamicx.widget.calander.BaseView
    public void updateCurrentDate() {
        List<Calendar> list = this.mItems;
        if (list != null) {
            if (list.contains(this.mDelegate.g())) {
                for (Calendar calendar : this.mItems) {
                    calendar.setCurrentDay(false);
                }
                this.mItems.get(this.mItems.indexOf(this.mDelegate.g())).setCurrentDay(true);
            }
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.taobao.android.dinamicx.widget.calander.BaseView
    public void updateItemHeight() {
        super.updateItemHeight();
        this.mHeight = a.k(this.mYear, this.mMonth, this.mItemHeight, this.mDelegate.E(), this.mDelegate.w());
    }
}
