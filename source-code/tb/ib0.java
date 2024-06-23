package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ib0 implements ColumnConverter<Double> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public Object fieldValue2DbValue(Double d) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1852745506")) {
            return d;
        }
        return ipChange.ipc$dispatch("1852745506", new Object[]{this, d});
    }

    /* renamed from: b */
    public Double getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-99678155")) {
            return (Double) ipChange.ipc$dispatch("-99678155", new Object[]{this, cursor, Integer.valueOf(i)});
        } else if (cursor.isNull(i)) {
            return null;
        } else {
            return Double.valueOf(cursor.getDouble(i));
        }
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1878566863")) {
            return ColumnDbType.REAL;
        }
        return (ColumnDbType) ipChange.ipc$dispatch("-1878566863", new Object[]{this});
    }
}
