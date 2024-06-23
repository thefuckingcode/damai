package tb;

import android.text.SpannableStringBuilder;
import cn.damai.uikit.calendar.CalendarDay;
import cn.damai.uikit.calendar.format.TitleFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class qf1 implements TitleFormatter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final CharSequence[] a;

    public qf1(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            throw new IllegalArgumentException("Label array cannot be null");
        } else if (charSequenceArr.length >= 12) {
            this.a = charSequenceArr;
        } else {
            throw new IllegalArgumentException("Label array is too short");
        }
    }

    @Override // cn.damai.uikit.calendar.format.TitleFormatter
    public CharSequence format(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1140196690")) {
            return new SpannableStringBuilder().append(this.a[calendarDay.getMonth()]).append((CharSequence) " ").append((CharSequence) String.valueOf(calendarDay.getYear()));
        }
        return (CharSequence) ipChange.ipc$dispatch("-1140196690", new Object[]{this, calendarDay});
    }
}
