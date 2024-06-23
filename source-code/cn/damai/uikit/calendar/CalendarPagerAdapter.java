package cn.damai.uikit.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.uikit.calendar.CalendarPagerView;
import cn.damai.uikit.calendar.MaterialCalendarView;
import cn.damai.uikit.calendar.format.DayFormatter;
import cn.damai.uikit.calendar.format.TitleFormatter;
import cn.damai.uikit.calendar.format.WeekDayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public abstract class CalendarPagerAdapter<V extends CalendarPagerView> extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ArrayDeque<V> a;
    protected final MaterialCalendarView b;
    private final CalendarDay c;
    private TitleFormatter d = null;
    private Integer e = null;
    private Integer f = null;
    private Integer g = null;
    @MaterialCalendarView.ShowOtherDates
    private int h = 4;
    private CalendarDay i = null;
    private CalendarDay j = null;
    private DateRangeIndex k;
    private List<CalendarDay> l = new ArrayList();
    private WeekDayFormatter m = WeekDayFormatter.DEFAULT;
    private DayFormatter n = DayFormatter.DEFAULT;
    private List<DayViewDecorator> o = new ArrayList();
    private List<b> p = null;
    private boolean q = true;

    CalendarPagerAdapter(MaterialCalendarView materialCalendarView) {
        this.b = materialCalendarView;
        this.c = CalendarDay.today();
        ArrayDeque<V> arrayDeque = new ArrayDeque<>();
        this.a = arrayDeque;
        arrayDeque.iterator();
        t(null, null);
    }

    private void A() {
        CalendarDay calendarDay;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "2115423118")) {
            ipChange.ipc$dispatch("2115423118", new Object[]{this});
            return;
        }
        while (i2 < this.l.size()) {
            CalendarDay calendarDay2 = this.l.get(i2);
            CalendarDay calendarDay3 = this.i;
            if ((calendarDay3 != null && calendarDay3.isAfter(calendarDay2)) || ((calendarDay = this.j) != null && calendarDay.isBefore(calendarDay2))) {
                this.l.remove(i2);
                this.b.onDateUnselected(calendarDay2);
                i2--;
            }
            i2++;
        }
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-672581005")) {
            ipChange.ipc$dispatch("-672581005", new Object[]{this});
            return;
        }
        A();
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setSelectedDates(this.l);
        }
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254937106")) {
            ipChange.ipc$dispatch("-1254937106", new Object[]{this});
            return;
        }
        this.l.clear();
        m();
    }

    /* access modifiers changed from: protected */
    public abstract DateRangeIndex b(CalendarDay calendarDay, CalendarDay calendarDay2);

    /* access modifiers changed from: protected */
    public abstract V c(int i2);

    /* access modifiers changed from: protected */
    public int d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242513824")) {
            return ((Integer) ipChange.ipc$dispatch("-242513824", new Object[]{this})).intValue();
        }
        Integer num = this.f;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "303575083")) {
            ipChange.ipc$dispatch("303575083", new Object[]{this, viewGroup, Integer.valueOf(i2), obj});
            return;
        }
        CalendarPagerView calendarPagerView = (CalendarPagerView) obj;
        this.a.remove(calendarPagerView);
        viewGroup.removeView(calendarPagerView);
    }

    public int e(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3338502")) {
            return ((Integer) ipChange.ipc$dispatch("3338502", new Object[]{this, calendarDay})).intValue();
        } else if (calendarDay == null) {
            return getCount() / 2;
        } else {
            CalendarDay calendarDay2 = this.i;
            if (calendarDay2 != null && calendarDay.isBefore(calendarDay2)) {
                return 0;
            }
            CalendarDay calendarDay3 = this.j;
            if (calendarDay3 == null || !calendarDay.isAfter(calendarDay3)) {
                return this.k.indexOf(calendarDay);
            }
            return getCount() - 1;
        }
    }

    public CalendarDay f(int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "450933510")) {
            return this.k.getItem(i2);
        }
        return (CalendarDay) ipChange.ipc$dispatch("450933510", new Object[]{this, Integer.valueOf(i2)});
    }

    public DateRangeIndex g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-594198942")) {
            return this.k;
        }
        return (DateRangeIndex) ipChange.ipc$dispatch("-594198942", new Object[]{this});
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-773518206")) {
            return this.k.getCount();
        }
        return ((Integer) ipChange.ipc$dispatch("-773518206", new Object[]{this})).intValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: cn.damai.uikit.calendar.CalendarPagerAdapter<V extends cn.damai.uikit.calendar.CalendarPagerView> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int k2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995038655")) {
            return ((Integer) ipChange.ipc$dispatch("1995038655", new Object[]{this, obj})).intValue();
        }
        if (!n(obj)) {
            return -2;
        }
        CalendarPagerView calendarPagerView = (CalendarPagerView) obj;
        if (calendarPagerView.getFirstViewDay() != null && (k2 = k(calendarPagerView)) >= 0) {
            return k2;
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1788725204")) {
            return (CharSequence) ipChange.ipc$dispatch("-1788725204", new Object[]{this, Integer.valueOf(i2)});
        }
        TitleFormatter titleFormatter = this.d;
        return titleFormatter == null ? "" : titleFormatter.format(f(i2));
    }

    @NonNull
    public List<CalendarDay> h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1699584435")) {
            return Collections.unmodifiableList(this.l);
        }
        return (List) ipChange.ipc$dispatch("1699584435", new Object[]{this});
    }

    @MaterialCalendarView.ShowOtherDates
    public int i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1425403789")) {
            return this.h;
        }
        return ((Integer) ipChange.ipc$dispatch("1425403789", new Object[]{this})).intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1444184685")) {
            return ipChange.ipc$dispatch("-1444184685", new Object[]{this, viewGroup, Integer.valueOf(i2)});
        }
        V c2 = c(i2);
        c2.setContentDescription(this.b.getCalendarContentDescription());
        c2.setAlpha(0.0f);
        c2.setSelectionEnabled(this.q);
        c2.setWeekDayFormatter(this.m);
        c2.setDayFormatter(this.n);
        Integer num = this.e;
        if (num != null) {
            c2.setSelectionColor(num.intValue());
        }
        Integer num2 = this.f;
        if (num2 != null) {
            c2.setDateTextAppearance(num2.intValue());
        }
        Integer num3 = this.g;
        if (num3 != null) {
            c2.setWeekDayTextAppearance(num3.intValue());
        }
        c2.setShowOtherDates(this.h);
        c2.setMinimumDate(this.i);
        c2.setMaximumDate(this.j);
        c2.setSelectedDates(this.l);
        viewGroup.addView(c2);
        this.a.add(c2);
        c2.setDayViewDecorators(this.p);
        return c2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "162340226")) {
            return view == obj;
        }
        return ((Boolean) ipChange.ipc$dispatch("162340226", new Object[]{this, view, obj})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public int j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154867528")) {
            return ((Integer) ipChange.ipc$dispatch("-154867528", new Object[]{this})).intValue();
        }
        Integer num = this.g;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public abstract int k(V v);

    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186837493")) {
            ipChange.ipc$dispatch("186837493", new Object[]{this});
            return;
        }
        this.p = new ArrayList();
        for (DayViewDecorator dayViewDecorator : this.o) {
            a aVar = new a();
            dayViewDecorator.decorate(aVar);
            if (aVar.o()) {
                this.p.add(new b(dayViewDecorator, aVar));
            }
        }
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setDayViewDecorators(this.p);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean n(Object obj);

    public CalendarPagerAdapter<?> o(CalendarPagerAdapter<?> calendarPagerAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-823510795")) {
            return (CalendarPagerAdapter) ipChange.ipc$dispatch("-823510795", new Object[]{this, calendarPagerAdapter});
        }
        calendarPagerAdapter.d = this.d;
        calendarPagerAdapter.e = this.e;
        calendarPagerAdapter.f = this.f;
        calendarPagerAdapter.g = this.g;
        calendarPagerAdapter.h = this.h;
        calendarPagerAdapter.i = this.i;
        calendarPagerAdapter.j = this.j;
        calendarPagerAdapter.l = this.l;
        calendarPagerAdapter.m = this.m;
        calendarPagerAdapter.n = this.n;
        calendarPagerAdapter.o = this.o;
        calendarPagerAdapter.p = this.p;
        calendarPagerAdapter.q = this.q;
        return calendarPagerAdapter;
    }

    public void p(CalendarDay calendarDay, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1988346049")) {
            ipChange.ipc$dispatch("-1988346049", new Object[]{this, calendarDay, Boolean.valueOf(z)});
        } else if (z) {
            if (!this.l.contains(calendarDay)) {
                this.l.add(calendarDay);
                m();
            }
        } else if (this.l.contains(calendarDay)) {
            this.l.remove(calendarDay);
            m();
        }
    }

    public void q(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1915327554")) {
            ipChange.ipc$dispatch("1915327554", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 != 0) {
            this.f = Integer.valueOf(i2);
            Iterator<V> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().setDateTextAppearance(i2);
            }
        }
    }

    public void r(DayFormatter dayFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573773298")) {
            ipChange.ipc$dispatch("1573773298", new Object[]{this, dayFormatter});
            return;
        }
        this.n = dayFormatter;
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setDayFormatter(dayFormatter);
        }
    }

    public void s(List<DayViewDecorator> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167590745")) {
            ipChange.ipc$dispatch("1167590745", new Object[]{this, list});
            return;
        }
        this.o = list;
        l();
    }

    public void t(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2122453048")) {
            ipChange.ipc$dispatch("2122453048", new Object[]{this, calendarDay, calendarDay2});
            return;
        }
        this.i = calendarDay;
        this.j = calendarDay2;
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            V next = it.next();
            next.setMinimumDate(calendarDay);
            next.setMaximumDate(calendarDay2);
        }
        if (calendarDay == null) {
            calendarDay = CalendarDay.from(this.c.getYear() - 200, this.c.getMonth(), this.c.getDay());
        }
        if (calendarDay2 == null) {
            calendarDay2 = CalendarDay.from(this.c.getYear() + 200, this.c.getMonth(), this.c.getDay());
        }
        this.k = b(calendarDay, calendarDay2);
        notifyDataSetChanged();
        m();
    }

    public void u(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "696152890")) {
            ipChange.ipc$dispatch("696152890", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.e = Integer.valueOf(i2);
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setSelectionColor(i2);
        }
    }

    public void v(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147273129")) {
            ipChange.ipc$dispatch("2147273129", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.q = z;
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setSelectionEnabled(this.q);
        }
    }

    public void w(@MaterialCalendarView.ShowOtherDates int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-520881995")) {
            ipChange.ipc$dispatch("-520881995", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.h = i2;
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setShowOtherDates(i2);
        }
    }

    public void x(@NonNull TitleFormatter titleFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "816996658")) {
            ipChange.ipc$dispatch("816996658", new Object[]{this, titleFormatter});
            return;
        }
        this.d = titleFormatter;
    }

    public void y(WeekDayFormatter weekDayFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273116942")) {
            ipChange.ipc$dispatch("-1273116942", new Object[]{this, weekDayFormatter});
            return;
        }
        this.m = weekDayFormatter;
        Iterator<V> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().setWeekDayFormatter(weekDayFormatter);
        }
    }

    public void z(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "732232530")) {
            ipChange.ipc$dispatch("732232530", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 != 0) {
            this.g = Integer.valueOf(i2);
            Iterator<V> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().setWeekDayTextAppearance(i2);
            }
        }
    }
}
