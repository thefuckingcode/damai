package tb;

import android.database.Cursor;
import cn.damai.common.db.DbManager;
import cn.damai.common.db.db.annotation.Table;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
public final class si2<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final DbManager a;
    private final String b;
    private final String c;
    private ak d;
    private Class<T> e;
    private Constructor<T> f;
    private volatile boolean g;
    private final LinkedHashMap<String, ak> h;

    si2(DbManager dbManager, Class<T> cls) throws Throwable {
        this.a = dbManager;
        this.e = cls;
        Constructor<T> constructor = cls.getConstructor(new Class[0]);
        this.f = constructor;
        constructor.setAccessible(true);
        Table table = (Table) cls.getAnnotation(Table.class);
        this.b = table.name();
        this.c = table.onCreated();
        LinkedHashMap<String, ak> b2 = ti2.b(cls);
        this.h = b2;
        for (ak akVar : b2.values()) {
            if (akVar.g()) {
                this.d = akVar;
                return;
            }
        }
    }

    public T a() throws Throwable {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1320086611")) {
            return this.f.newInstance(new Object[0]);
        }
        return (T) ipChange.ipc$dispatch("-1320086611", new Object[]{this});
    }

    public LinkedHashMap<String, ak> b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1994435792")) {
            return this.h;
        }
        return (LinkedHashMap) ipChange.ipc$dispatch("-1994435792", new Object[]{this});
    }

    public DbManager c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1777029324")) {
            return this.a;
        }
        return (DbManager) ipChange.ipc$dispatch("1777029324", new Object[]{this});
    }

    public Class<T> d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "967213664")) {
            return this.e;
        }
        return (Class) ipChange.ipc$dispatch("967213664", new Object[]{this});
    }

    public ak e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1347350989")) {
            return this.d;
        }
        return (ak) ipChange.ipc$dispatch("1347350989", new Object[]{this});
    }

    public String f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1941873957")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("-1941873957", new Object[]{this});
    }

    public String g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-721736593")) {
            return this.c;
        }
        return (String) ipChange.ipc$dispatch("-721736593", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1928446738")) {
            return this.g;
        }
        return ((Boolean) ipChange.ipc$dispatch("1928446738", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public void i(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-962162288")) {
            ipChange.ipc$dispatch("-962162288", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.g = z;
    }

    public boolean j() throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404480535")) {
            return ((Boolean) ipChange.ipc$dispatch("-404480535", new Object[]{this})).booleanValue();
        } else if (h()) {
            return true;
        } else {
            DbManager dbManager = this.a;
            Cursor execQuery = dbManager.execQuery("SELECT COUNT(*) AS c FROM sqlite_master WHERE type='table' AND name='" + this.b + "'");
            if (execQuery != null) {
                try {
                    if (!execQuery.moveToNext() || execQuery.getInt(0) <= 0) {
                        iz0.a(execQuery);
                    } else {
                        i(true);
                        iz0.a(execQuery);
                        return true;
                    }
                } catch (Throwable th) {
                    iz0.a(execQuery);
                    throw th;
                }
            }
            return false;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1557653624")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("-1557653624", new Object[]{this});
    }
}
