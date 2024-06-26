package cn.damai.uikit.calendar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.calendar.MaterialCalendarView;
import cn.damai.uikit.calendar.a;
import cn.damai.uikit.calendar.format.DayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* compiled from: Taobao */
public class DayView extends CheckedTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Rect circleDrawableRect = new Rect();
    private Drawable customBackground = null;
    private CalendarDay date;
    private int fadeTime;
    private DayFormatter formatter = DayFormatter.DEFAULT;
    private boolean isDecoratedDisabled = false;
    private boolean isInMonth = true;
    private boolean isInRange = true;
    private Drawable mCircleDrawable;
    private int selectionColor = -7829368;
    private Drawable selectionDrawable;
    @MaterialCalendarView.ShowOtherDates
    private int showOtherDates = 4;
    private final Rect tempRect = new Rect();

    public DayView(Context context) {
        super(context);
        init();
    }

    private void calculateBounds(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-981196102")) {
            ipChange.ipc$dispatch("-981196102", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int min = Math.min(i2, i);
        int abs = Math.abs(i2 - i) / 2;
        int i3 = Build.VERSION.SDK_INT == 21 ? abs / 2 : abs;
        if (i >= i2) {
            this.tempRect.set(abs, 0, min + abs, i2);
            this.circleDrawableRect.set(i3, 0, min + i3, i2);
            return;
        }
        this.tempRect.set(0, abs, i, min + abs);
        this.circleDrawableRect.set(0, i3, i, min + i3);
    }

    private static Drawable generateBackground(int i, int i2, Rect rect) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "301585651")) {
            return (Drawable) ipChange.ipc$dispatch("301585651", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), rect});
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setExitFadeDuration(i2);
        stateListDrawable.addState(new int[]{16842912}, generateCircleDrawable(i));
        if (Build.VERSION.SDK_INT >= 21) {
            stateListDrawable.addState(new int[]{16842919}, generateRippleDrawable(i, rect));
        } else {
            stateListDrawable.addState(new int[]{16842919}, generateCircleDrawable(i));
        }
        stateListDrawable.addState(new int[0], generateCircleDrawable(0));
        return stateListDrawable;
    }

    private static Drawable generateCircleDrawable(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305654281")) {
            return (Drawable) ipChange.ipc$dispatch("1305654281", new Object[]{Integer.valueOf(i)});
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    @TargetApi(21)
    private static Drawable generateRippleDrawable(int i, Rect rect) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1962793294")) {
            return (Drawable) ipChange.ipc$dispatch("-1962793294", new Object[]{Integer.valueOf(i), rect});
        }
        RippleDrawable rippleDrawable = new RippleDrawable(ColorStateList.valueOf(i), null, generateCircleDrawable(-1));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21) {
            rippleDrawable.setBounds(rect);
        }
        if (i2 == 22) {
            int i3 = (rect.left + rect.right) / 2;
            rippleDrawable.setHotspotBounds(i3, rect.top, i3, rect.bottom);
        }
        return rippleDrawable;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1916688539")) {
            ipChange.ipc$dispatch("-1916688539", new Object[]{this});
            return;
        }
        this.fadeTime = getResources().getInteger(17694720);
        setSelectionColor(this.selectionColor);
        setGravity(17);
        if (Build.VERSION.SDK_INT >= 17) {
            setTextAlignment(4);
        }
    }

    private void regenerateBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264004929")) {
            ipChange.ipc$dispatch("-264004929", new Object[]{this});
            return;
        }
        Drawable drawable = this.selectionDrawable;
        if (drawable != null) {
            setBackgroundDrawable(drawable);
            return;
        }
        Drawable generateBackground = generateBackground(this.selectionColor, this.fadeTime, this.circleDrawableRect);
        this.mCircleDrawable = generateBackground;
        setBackgroundDrawable(generateBackground);
    }

    private void setEnabled() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1652503146")) {
            ipChange.ipc$dispatch("-1652503146", new Object[]{this});
            return;
        }
        boolean z = this.isInMonth && this.isInRange && !this.isDecoratedDisabled;
        super.setEnabled(this.isInRange && !this.isDecoratedDisabled);
        boolean showOtherMonths = MaterialCalendarView.showOtherMonths(this.showOtherDates);
        boolean z2 = MaterialCalendarView.showOutOfRange(this.showOtherDates) || showOtherMonths;
        boolean showDecoratedDisabled = MaterialCalendarView.showDecoratedDisabled(this.showOtherDates);
        boolean z3 = this.isInMonth;
        if (!z3 && showOtherMonths) {
            z = true;
        }
        boolean z4 = this.isInRange;
        if (!z4 && z2) {
            z |= z3;
        }
        if (this.isDecoratedDisabled && showDecoratedDisabled) {
            z |= z3 && z4;
        }
        if (!z3 && z) {
            setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
        }
        if (!z) {
            i = 4;
        }
        setVisibility(i);
    }

    /* access modifiers changed from: package-private */
    public void applyFacade(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "202633762")) {
            ipChange.ipc$dispatch("202633762", new Object[]{this, aVar});
            return;
        }
        this.isDecoratedDisabled = aVar.c();
        setEnabled();
        setCustomBackground(aVar.d());
        setSelectionDrawable(aVar.l());
        List<a.C0058a> m = aVar.m();
        if (!m.isEmpty()) {
            String label = getLabel();
            SpannableString spannableString = new SpannableString(getLabel());
            for (a.C0058a aVar2 : m) {
                spannableString.setSpan(aVar2.a, 0, label.length(), 33);
            }
            setText(spannableString);
            return;
        }
        setText(getLabel());
    }

    public CalendarDay getDate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "152019213")) {
            return this.date;
        }
        return (CalendarDay) ipChange.ipc$dispatch("152019213", new Object[]{this});
    }

    @NonNull
    public String getLabel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1665057033")) {
            return this.formatter.format(this.date);
        }
        return (String) ipChange.ipc$dispatch("1665057033", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public boolean isInMonth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "406681352")) {
            return this.isInMonth;
        }
        return ((Boolean) ipChange.ipc$dispatch("406681352", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean isInRange() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "978553643")) {
            return this.isInRange;
        }
        return ((Boolean) ipChange.ipc$dispatch("978553643", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-761887277")) {
            ipChange.ipc$dispatch("-761887277", new Object[]{this, canvas});
            return;
        }
        Drawable drawable = this.customBackground;
        if (drawable != null) {
            drawable.setBounds(this.circleDrawableRect);
            this.customBackground.setState(getDrawableState());
            this.customBackground.draw(canvas);
        }
        this.mCircleDrawable.setBounds(this.circleDrawableRect);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-483162840")) {
            ipChange.ipc$dispatch("-483162840", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        calculateBounds(i3 - i, i4 - i2);
        regenerateBackground();
    }

    public void setCustomBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1900687880")) {
            ipChange.ipc$dispatch("-1900687880", new Object[]{this, drawable});
            return;
        }
        if (drawable == null) {
            this.customBackground = null;
        } else {
            this.customBackground = drawable.getConstantState().newDrawable(getResources());
        }
        invalidate();
    }

    public void setDay(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389547921")) {
            ipChange.ipc$dispatch("389547921", new Object[]{this, calendarDay});
            return;
        }
        this.date = calendarDay;
        setText(getLabel());
    }

    public void setDayFormatter(DayFormatter dayFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1141757089")) {
            ipChange.ipc$dispatch("-1141757089", new Object[]{this, dayFormatter});
            return;
        }
        if (dayFormatter == null) {
            dayFormatter = DayFormatter.DEFAULT;
        }
        this.formatter = dayFormatter;
        CharSequence text = getText();
        Object[] objArr = null;
        if (text instanceof Spanned) {
            objArr = ((Spanned) text).getSpans(0, text.length(), Object.class);
        }
        SpannableString spannableString = new SpannableString(getLabel());
        if (objArr != null) {
            for (Object obj : objArr) {
                spannableString.setSpan(obj, 0, spannableString.length(), 33);
            }
        }
        setText(spannableString);
    }

    public void setSelectionColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463821081")) {
            ipChange.ipc$dispatch("-463821081", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.selectionColor = i;
        regenerateBackground();
    }

    public void setSelectionDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1686625297")) {
            ipChange.ipc$dispatch("1686625297", new Object[]{this, drawable});
            return;
        }
        if (!this.isInMonth) {
            this.selectionDrawable = getResources().getDrawable(R$drawable.transparent_bg);
        } else if (drawable == null) {
            this.selectionDrawable = null;
        } else {
            this.selectionDrawable = drawable.getConstantState().newDrawable(getResources());
        }
        regenerateBackground();
    }

    /* access modifiers changed from: protected */
    public void setupSelection(@MaterialCalendarView.ShowOtherDates int i, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "710282877")) {
            ipChange.ipc$dispatch("710282877", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        this.showOtherDates = i;
        this.isInMonth = z2;
        this.isInRange = z;
        setEnabled();
    }

    public DayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
