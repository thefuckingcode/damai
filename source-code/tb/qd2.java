package tb;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public final class qd2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private List<a61> b;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[ColumnDbType.values().length];
            a = iArr;
            iArr[ColumnDbType.INTEGER.ordinal()] = 1;
            a[ColumnDbType.REAL.ordinal()] = 2;
            a[ColumnDbType.TEXT.ordinal()] = 3;
            try {
                a[ColumnDbType.BLOB.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public qd2() {
    }

    public void a(a61 a61) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731917181")) {
            ipChange.ipc$dispatch("1731917181", new Object[]{this, a61});
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(a61);
    }

    public void b(List<a61> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875306409")) {
            ipChange.ipc$dispatch("1875306409", new Object[]{this, list});
            return;
        }
        List<a61> list2 = this.b;
        if (list2 == null) {
            this.b = list;
        } else {
            list2.addAll(list);
        }
    }

    public SQLiteStatement c(SQLiteDatabase sQLiteDatabase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "580003372")) {
            return (SQLiteStatement) ipChange.ipc$dispatch("580003372", new Object[]{this, sQLiteDatabase});
        }
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(this.a);
        if (this.b != null) {
            for (int i = 1; i < this.b.size() + 1; i++) {
                Object a2 = ck.a(this.b.get(i - 1).b);
                if (a2 == null) {
                    compileStatement.bindNull(i);
                } else {
                    int i2 = a.a[zj.a(a2.getClass()).getColumnDbType().ordinal()];
                    if (i2 == 1) {
                        compileStatement.bindLong(i, ((Number) a2).longValue());
                    } else if (i2 == 2) {
                        compileStatement.bindDouble(i, ((Number) a2).doubleValue());
                    } else if (i2 == 3) {
                        compileStatement.bindString(i, a2.toString());
                    } else if (i2 != 4) {
                        compileStatement.bindNull(i);
                    } else {
                        compileStatement.bindBlob(i, (byte[]) a2);
                    }
                }
            }
        }
        return compileStatement;
    }

    public String[] d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246640536")) {
            return (String[]) ipChange.ipc$dispatch("246640536", new Object[]{this});
        }
        List<a61> list = this.b;
        if (list == null) {
            return null;
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < this.b.size(); i++) {
            Object a2 = ck.a(this.b.get(i).b);
            strArr[i] = a2 == null ? null : a2.toString();
        }
        return strArr;
    }

    public String e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-331908351")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("-331908351", new Object[]{this});
    }

    public void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280676203")) {
            ipChange.ipc$dispatch("-280676203", new Object[]{this, str});
            return;
        }
        this.a = str;
    }

    public qd2(String str) {
        this.a = str;
    }
}
