package tb;

import android.database.Cursor;
import android.text.TextUtils;
import cn.damai.common.db.DbManager;
import cn.damai.common.db.db.sqlite.a;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public abstract class h30 implements DbManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HashMap<Class<?>, si2<?>> a = new HashMap<>();

    /* access modifiers changed from: protected */
    public void a(si2<?> si2) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-509562991")) {
            ipChange.ipc$dispatch("-509562991", new Object[]{this, si2});
        } else if (!si2.j()) {
            synchronized (si2.class) {
                if (!si2.j()) {
                    execNonQuery(a.a(si2));
                    String g = si2.g();
                    if (!TextUtils.isEmpty(g)) {
                        execNonQuery(g);
                    }
                    si2.i(true);
                    DbManager.TableCreateListener f = getDaoConfig().f();
                    if (f != null) {
                        f.onTableCreated(this, si2);
                    }
                }
            }
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void addColumn(Class<?> cls, String str) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026621086")) {
            ipChange.ipc$dispatch("-1026621086", new Object[]{this, cls, str});
            return;
        }
        si2 table = getTable(cls);
        ak akVar = table.b().get(str);
        if (akVar != null) {
            execNonQuery("ALTER TABLE " + "\"" + table.f() + "\"" + " ADD COLUMN " + "\"" + akVar.d() + "\"" + " " + akVar.a() + " " + akVar.e());
        }
    }

    /* access modifiers changed from: protected */
    public void b(Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2100280875")) {
            ipChange.ipc$dispatch("2100280875", new Object[]{this, cls});
            return;
        }
        synchronized (this.a) {
            this.a.remove(cls);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void dropDb() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-515650975")) {
            ipChange.ipc$dispatch("-515650975", new Object[]{this});
            return;
        }
        Cursor execQuery = execQuery("SELECT name FROM sqlite_master WHERE type='table' AND name<>'sqlite_sequence'");
        if (execQuery != null) {
            while (execQuery.moveToNext()) {
                try {
                    try {
                        String string = execQuery.getString(0);
                        execNonQuery("DROP TABLE " + string);
                    } catch (Throwable th) {
                        k91.c(th.getMessage(), th);
                    }
                } catch (Throwable th2) {
                    iz0.a(execQuery);
                    throw th2;
                }
            }
            synchronized (this.a) {
                for (si2<?> si2 : this.a.values()) {
                    si2.i(false);
                }
                this.a.clear();
            }
            iz0.a(execQuery);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void dropTable(Class<?> cls) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "108558432")) {
            ipChange.ipc$dispatch("108558432", new Object[]{this, cls});
            return;
        }
        si2 table = getTable(cls);
        if (table.j()) {
            execNonQuery("DROP TABLE \"" + table.f() + "\"");
            table.i(false);
            b(cls);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public <T> si2<T> getTable(Class<T> cls) throws DbException {
        si2<T> si2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1401351633")) {
            return (si2) ipChange.ipc$dispatch("1401351633", new Object[]{this, cls});
        }
        synchronized (this.a) {
            si2 = (si2<T>) this.a.get(cls);
            if (si2 == null) {
                try {
                    si2 = new si2<>(this, cls);
                    this.a.put(cls, si2);
                } catch (Throwable th) {
                    throw new DbException(th);
                }
            }
        }
        return si2;
    }
}
