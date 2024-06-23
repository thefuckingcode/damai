package cn.damai.uikit.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.Date;
import tb.ye;

/* compiled from: Taobao */
public final class CalendarDay implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CalendarDay> CREATOR = new a();
    private transient Calendar _calendar;
    private transient Date _date;
    private final int day;
    private final int month;
    private boolean weekEnd;
    private final int year;

    /* compiled from: Taobao */
    public static final class a implements Parcelable.Creator<CalendarDay> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public CalendarDay createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1578657511")) {
                return new CalendarDay(parcel);
            }
            return (CalendarDay) ipChange.ipc$dispatch("-1578657511", new Object[]{this, parcel});
        }

        /* renamed from: b */
        public CalendarDay[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1392526288")) {
                return new CalendarDay[i];
            }
            return (CalendarDay[]) ipChange.ipc$dispatch("-1392526288", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Deprecated
    public CalendarDay() {
        this(ye.d());
    }

    @NonNull
    public static CalendarDay from(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "100884471")) {
            return new CalendarDay(i, i2, i3);
        }
        return (CalendarDay) ipChange.ipc$dispatch("100884471", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    private static int hashCode(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1348066337")) {
            return (i * 10000) + (i2 * 100) + i3;
        }
        return ((Integer) ipChange.ipc$dispatch("-1348066337", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).intValue();
    }

    @NonNull
    public static CalendarDay today() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-634557421") ? (CalendarDay) ipChange.ipc$dispatch("-634557421", new Object[0]) : from(ye.d());
    }

    public void copyTo(@NonNull Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-470619245")) {
            ipChange.ipc$dispatch("-470619245", new Object[]{this, calendar});
            return;
        }
        calendar.clear();
        calendar.set(this.year, this.month, this.day);
    }

    /* access modifiers changed from: package-private */
    public void copyToMonthOnly(@NonNull Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2019039507")) {
            ipChange.ipc$dispatch("-2019039507", new Object[]{this, calendar});
            return;
        }
        calendar.clear();
        calendar.set(this.year, this.month, 1);
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1400780000")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1400780000", new Object[]{this})).intValue();
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-772625005")) {
            return ((Boolean) ipChange.ipc$dispatch("-772625005", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || CalendarDay.class != obj.getClass()) {
                return false;
            }
            CalendarDay calendarDay = (CalendarDay) obj;
            if (this.day == calendarDay.day && this.month == calendarDay.month && this.year == calendarDay.year) {
                return true;
            }
            return false;
        }
    }

    @NonNull
    public Calendar getCalendar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1159738141")) {
            return (Calendar) ipChange.ipc$dispatch("-1159738141", new Object[]{this});
        }
        if (this._calendar == null) {
            Calendar d = ye.d();
            this._calendar = d;
            copyTo(d);
        }
        return this._calendar;
    }

    @NonNull
    public Date getDate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065996957")) {
            return (Date) ipChange.ipc$dispatch("-2065996957", new Object[]{this});
        }
        if (this._date == null) {
            this._date = getCalendar().getTime();
        }
        return this._date;
    }

    public int getDay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1567722079")) {
            return this.day;
        }
        return ((Integer) ipChange.ipc$dispatch("1567722079", new Object[]{this})).intValue();
    }

    public int getMonth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1145051195")) {
            return this.month;
        }
        return ((Integer) ipChange.ipc$dispatch("1145051195", new Object[]{this})).intValue();
    }

    public boolean getWeekEnd() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "973442149")) {
            return this.weekEnd;
        }
        return ((Boolean) ipChange.ipc$dispatch("973442149", new Object[]{this})).booleanValue();
    }

    public int getYear() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1387960232")) {
            return this.year;
        }
        return ((Integer) ipChange.ipc$dispatch("-1387960232", new Object[]{this})).intValue();
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1371154250")) {
            return hashCode(this.year, this.month, this.day);
        }
        return ((Integer) ipChange.ipc$dispatch("1371154250", new Object[]{this})).intValue();
    }

    public boolean isAfter(@NonNull CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "303577322")) {
            return ((Boolean) ipChange.ipc$dispatch("303577322", new Object[]{this, calendarDay})).booleanValue();
        } else if (calendarDay != null) {
            int i = this.year;
            int i2 = calendarDay.year;
            if (i == i2) {
                int i3 = this.month;
                int i4 = calendarDay.month;
                if (i3 == i4) {
                    if (this.day > calendarDay.day) {
                        return true;
                    }
                } else if (i3 > i4) {
                    return true;
                }
                return false;
            } else if (i > i2) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException("other cannot be null");
        }
    }

    public boolean isBefore(@NonNull CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1123053241")) {
            return ((Boolean) ipChange.ipc$dispatch("-1123053241", new Object[]{this, calendarDay})).booleanValue();
        } else if (calendarDay != null) {
            int i = this.year;
            int i2 = calendarDay.year;
            if (i == i2) {
                int i3 = this.month;
                int i4 = calendarDay.month;
                if (i3 == i4) {
                    if (this.day < calendarDay.day) {
                        return true;
                    }
                } else if (i3 < i4) {
                    return true;
                }
                return false;
            } else if (i < i2) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException("other cannot be null");
        }
    }

    public boolean isInRange(@Nullable CalendarDay calendarDay, @Nullable CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1317587694")) {
            return ((Boolean) ipChange.ipc$dispatch("1317587694", new Object[]{this, calendarDay, calendarDay2})).booleanValue();
        } else if ((calendarDay == null || !calendarDay.isAfter(this)) && (calendarDay2 == null || !calendarDay2.isBefore(this))) {
            return true;
        } else {
            return false;
        }
    }

    public void setWeekEnd(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659755001")) {
            ipChange.ipc$dispatch("-1659755001", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.weekEnd = z;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364862470")) {
            return (String) ipChange.ipc$dispatch("-1364862470", new Object[]{this});
        }
        return "CalendarDay{" + this.year + "-" + this.month + "-" + this.day + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196484523")) {
            ipChange.ipc$dispatch("196484523", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
        parcel.writeInt(this.day);
    }

    @Deprecated
    public CalendarDay(Calendar calendar) {
        this(ye.g(calendar), ye.f(calendar), ye.b(calendar));
    }

    public static CalendarDay from(@Nullable Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1681508853")) {
            return (CalendarDay) ipChange.ipc$dispatch("1681508853", new Object[]{calendar});
        } else if (calendar == null) {
            return null;
        } else {
            return from(ye.g(calendar), ye.f(calendar), ye.b(calendar));
        }
    }

    @Deprecated
    public CalendarDay(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
    }

    public static CalendarDay from(@Nullable Date date) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1882700027")) {
            return (CalendarDay) ipChange.ipc$dispatch("-1882700027", new Object[]{date});
        } else if (date == null) {
            return null;
        } else {
            return from(ye.e(date));
        }
    }

    @Deprecated
    public CalendarDay(Date date) {
        this(ye.e(date));
    }

    public CalendarDay(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
