package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Date;

/* compiled from: Taobao */
public class w20 implements ColumnConverter<Date> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public Object fieldValue2DbValue(Date date) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-709171064")) {
            return ipChange.ipc$dispatch("-709171064", new Object[]{this, date});
        } else if (date == null) {
            return null;
        } else {
            return Long.valueOf(date.getTime());
        }
    }

    /* renamed from: b */
    public Date getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-833518385")) {
            return (Date) ipChange.ipc$dispatch("-833518385", new Object[]{this, cursor, Integer.valueOf(i)});
        } else if (cursor.isNull(i)) {
            return null;
        } else {
            return new Date(cursor.getLong(i));
        }
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-585445810")) {
            return ColumnDbType.INTEGER;
        }
        return (ColumnDbType) ipChange.ipc$dispatch("-585445810", new Object[]{this});
    }
}
