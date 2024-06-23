package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class hh implements ColumnConverter<Character> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public Object fieldValue2DbValue(Character ch) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1989936153")) {
            return ipChange.ipc$dispatch("-1989936153", new Object[]{this, ch});
        } else if (ch == null) {
            return null;
        } else {
            return Integer.valueOf(ch.charValue());
        }
    }

    /* renamed from: b */
    public Character getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1218065196")) {
            return (Character) ipChange.ipc$dispatch("1218065196", new Object[]{this, cursor, Integer.valueOf(i)});
        } else if (cursor.isNull(i)) {
            return null;
        } else {
            return Character.valueOf((char) cursor.getInt(i));
        }
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1245860874")) {
            return ColumnDbType.INTEGER;
        }
        return (ColumnDbType) ipChange.ipc$dispatch("-1245860874", new Object[]{this});
    }
}
