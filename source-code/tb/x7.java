package tb;

import cn.damai.uikit.calendar.format.WeekDayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class x7 implements WeekDayFormatter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final CharSequence[] a;

    public x7(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            throw new IllegalArgumentException("Cannot be null");
        } else if (charSequenceArr.length == 7) {
            this.a = charSequenceArr;
        } else {
            throw new IllegalArgumentException("Array must contain exactly 7 elements");
        }
    }

    @Override // cn.damai.uikit.calendar.format.WeekDayFormatter
    public CharSequence format(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-841881823")) {
            return this.a[i - 1];
        }
        return (CharSequence) ipChange.ipc$dispatch("-841881823", new Object[]{this, Integer.valueOf(i)});
    }
}
