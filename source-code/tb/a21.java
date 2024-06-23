package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class a21 implements ColumnConverter<Integer> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public Object fieldValue2DbValue(Integer num) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-981783268")) {
            return num;
        }
        return ipChange.ipc$dispatch("-981783268", new Object[]{this, num});
    }

    /* renamed from: b */
    public Integer getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1992474519")) {
            return (Integer) ipChange.ipc$dispatch("1992474519", new Object[]{this, cursor, Integer.valueOf(i)});
        } else if (cursor.isNull(i)) {
            return null;
        } else {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-301644458")) {
            return ColumnDbType.INTEGER;
        }
        return (ColumnDbType) ipChange.ipc$dispatch("-301644458", new Object[]{this});
    }
}
