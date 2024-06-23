package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class kc implements ColumnConverter<Boolean> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public Object fieldValue2DbValue(Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-591671844")) {
            return ipChange.ipc$dispatch("-591671844", new Object[]{this, bool});
        } else if (bool == null) {
            return null;
        } else {
            return Integer.valueOf(bool.booleanValue() ? 1 : 0);
        }
    }

    /* renamed from: b */
    public Boolean getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1192400041")) {
            return (Boolean) ipChange.ipc$dispatch("-1192400041", new Object[]{this, cursor, Integer.valueOf(i)});
        } else if (cursor.isNull(i)) {
            return null;
        } else {
            if (cursor.getInt(i) == 1) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-627540288")) {
            return ColumnDbType.INTEGER;
        }
        return (ColumnDbType) ipChange.ipc$dispatch("-627540288", new Object[]{this});
    }
}
