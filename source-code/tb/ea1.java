package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ea1 implements ColumnConverter<Long> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public Object fieldValue2DbValue(Long l) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1279468728")) {
            return l;
        }
        return ipChange.ipc$dispatch("1279468728", new Object[]{this, l});
    }

    /* renamed from: b */
    public Long getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1287058719")) {
            return (Long) ipChange.ipc$dispatch("1287058719", new Object[]{this, cursor, Integer.valueOf(i)});
        } else if (cursor.isNull(i)) {
            return null;
        } else {
            return Long.valueOf(cursor.getLong(i));
        }
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1944466588")) {
            return ColumnDbType.INTEGER;
        }
        return (ColumnDbType) ipChange.ipc$dispatch("1944466588", new Object[]{this});
    }
}
