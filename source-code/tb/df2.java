package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class df2 implements ColumnConverter<String> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public Object fieldValue2DbValue(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "602636194")) {
            return str;
        }
        return ipChange.ipc$dispatch("602636194", new Object[]{this, str});
    }

    /* renamed from: b */
    public String getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043236427")) {
            return (String) ipChange.ipc$dispatch("-2043236427", new Object[]{this, cursor, Integer.valueOf(i)});
        } else if (cursor.isNull(i)) {
            return null;
        } else {
            return cursor.getString(i);
        }
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1860095089")) {
            return ColumnDbType.TEXT;
        }
        return (ColumnDbType) ipChange.ipc$dispatch("1860095089", new Object[]{this});
    }
}
