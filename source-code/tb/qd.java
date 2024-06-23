package tb;

import android.database.Cursor;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class qd implements ColumnConverter<byte[]> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public Object fieldValue2DbValue(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2010730531")) {
            return bArr;
        }
        return ipChange.ipc$dispatch("-2010730531", new Object[]{this, bArr});
    }

    /* renamed from: b */
    public byte[] getFieldValue(Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566576294")) {
            return (byte[]) ipChange.ipc$dispatch("-1566576294", new Object[]{this, cursor, Integer.valueOf(i)});
        } else if (cursor.isNull(i)) {
            return null;
        } else {
            return cursor.getBlob(i);
        }
    }

    @Override // cn.damai.common.db.db.converter.ColumnConverter
    public ColumnDbType getColumnDbType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-625107447")) {
            return ColumnDbType.BLOB;
        }
        return (ColumnDbType) ipChange.ipc$dispatch("-625107447", new Object[]{this});
    }
}
