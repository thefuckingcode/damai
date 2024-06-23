package tb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import cn.damai.common.db.DbManager;
import cn.damai.common.db.commonutil.util.KeyValue;
import cn.damai.common.db.db.sqlite.a;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public final class j30 extends h30 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final HashMap<DbManager.a, j30> f = new HashMap<>();
    private SQLiteDatabase b;
    private DbManager.a c;
    private boolean d;
    private Context e;

    private j30(DbManager.a aVar, Context context) {
        if (aVar != null) {
            this.e = context;
            this.c = aVar;
            this.d = aVar.g();
            this.b = e(aVar);
            DbManager.DbOpenListener c2 = aVar.c();
            if (c2 != null) {
                c2.onDbOpened(this);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("daoConfig may not be null");
    }

    private void beginTransaction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12012498")) {
            ipChange.ipc$dispatch("-12012498", new Object[]{this});
        } else if (!this.d) {
        } else {
            if (Build.VERSION.SDK_INT < 16 || !this.b.isWriteAheadLoggingEnabled()) {
                this.b.beginTransaction();
            } else {
                this.b.beginTransactionNonExclusive();
            }
        }
    }

    public static synchronized DbManager c(DbManager.a aVar, Context context) {
        synchronized (j30.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "114247146")) {
                return (DbManager) ipChange.ipc$dispatch("114247146", new Object[]{aVar, context});
            }
            if (aVar == null) {
                aVar = new DbManager.a();
            }
            HashMap<DbManager.a, j30> hashMap = f;
            j30 j30 = hashMap.get(aVar);
            if (j30 == null) {
                j30 = new j30(aVar, context);
                hashMap.put(aVar, j30);
            } else {
                j30.c = aVar;
            }
            SQLiteDatabase sQLiteDatabase = j30.b;
            int version = sQLiteDatabase.getVersion();
            int e2 = aVar.e();
            if (version != e2) {
                if (version != 0) {
                    DbManager.DbUpgradeListener d2 = aVar.d();
                    if (d2 != null) {
                        d2.onUpgrade(j30, version, e2);
                    } else {
                        try {
                            j30.dropDb();
                        } catch (DbException e3) {
                            k91.c(e3.getMessage(), e3);
                        }
                    }
                }
                sQLiteDatabase.setVersion(e2);
            }
            return j30;
        }
    }

    private long d(String str) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994091118")) {
            return ((Long) ipChange.ipc$dispatch("-994091118", new Object[]{this, str})).longValue();
        }
        long j = -1;
        Cursor execQuery = execQuery("SELECT seq FROM sqlite_sequence WHERE name='" + str + "' LIMIT 1");
        if (execQuery != null) {
            try {
                if (execQuery.moveToNext()) {
                    j = execQuery.getLong(0);
                }
                iz0.a(execQuery);
            } catch (Throwable th) {
                iz0.a(execQuery);
                throw th;
            }
        }
        return j;
    }

    private SQLiteDatabase e(DbManager.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002202280")) {
            return (SQLiteDatabase) ipChange.ipc$dispatch("-1002202280", new Object[]{this, aVar});
        }
        File a = aVar.a();
        if (a == null || (!a.exists() && !a.mkdirs())) {
            return this.e.openOrCreateDatabase(aVar.b(), 0, null);
        }
        return SQLiteDatabase.openOrCreateDatabase(new File(a, aVar.b()), (SQLiteDatabase.CursorFactory) null);
    }

    private void endTransaction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1103232928")) {
            ipChange.ipc$dispatch("-1103232928", new Object[]{this});
        } else if (this.d) {
            this.b.endTransaction();
        }
    }

    private boolean f(si2<?> si2, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786603980")) {
            return ((Boolean) ipChange.ipc$dispatch("786603980", new Object[]{this, si2, obj})).booleanValue();
        }
        ak e2 = si2.e();
        if (e2.f()) {
            execNonQuery(a.e(si2, obj));
            long d2 = d(si2.f());
            if (d2 == -1) {
                return false;
            }
            e2.h(obj, d2);
            return true;
        }
        execNonQuery(a.e(si2, obj));
        return true;
    }

    private void g(si2<?> si2, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-640899566")) {
            ipChange.ipc$dispatch("-640899566", new Object[]{this, si2, obj});
            return;
        }
        ak e2 = si2.e();
        if (!e2.f()) {
            execNonQuery(a.f(si2, obj));
        } else if (e2.b(obj) != null) {
            execNonQuery(a.g(si2, obj, new String[0]));
        } else {
            f(si2, obj);
        }
    }

    private void setTransactionSuccessful() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1252512723")) {
            ipChange.ipc$dispatch("-1252512723", new Object[]{this});
        } else if (this.d) {
            this.b.setTransactionSuccessful();
        }
    }

    @Override // cn.damai.common.db.DbManager, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-80410641")) {
            ipChange.ipc$dispatch("-80410641", new Object[]{this});
            return;
        }
        HashMap<DbManager.a, j30> hashMap = f;
        if (hashMap.containsKey(this.c)) {
            hashMap.remove(this.c);
            this.b.close();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void delete(Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-91069292")) {
            ipChange.ipc$dispatch("-91069292", new Object[]{this, obj});
            return;
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (!list.isEmpty()) {
                    si2 table = getTable(list.get(0).getClass());
                    if (!table.j()) {
                        endTransaction();
                        return;
                    }
                    for (Object obj2 : list) {
                        execNonQuery(a.b(table, obj2));
                    }
                } else {
                    return;
                }
            } else {
                si2 table2 = getTable(obj.getClass());
                if (!table2.j()) {
                    endTransaction();
                    return;
                }
                execNonQuery(a.b(table2, obj));
            }
            setTransactionSuccessful();
            endTransaction();
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void deleteById(Class<?> cls, Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1432975379")) {
            ipChange.ipc$dispatch("1432975379", new Object[]{this, cls, obj});
            return;
        }
        si2 table = getTable(cls);
        if (table.j()) {
            try {
                beginTransaction();
                execNonQuery(a.d(table, obj));
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void execNonQuery(qd2 qd2) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632050052")) {
            ipChange.ipc$dispatch("1632050052", new Object[]{this, qd2});
            return;
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = qd2.c(this.b);
            sQLiteStatement.execute();
            try {
                sQLiteStatement.releaseReference();
            } catch (Throwable th) {
                k91.c(th.getMessage(), th);
            }
        } catch (Throwable th2) {
            if (sQLiteStatement != null) {
                try {
                    sQLiteStatement.releaseReference();
                } catch (Throwable th3) {
                    k91.c(th3.getMessage(), th3);
                }
            }
            throw th2;
        }
    }

    @Override // cn.damai.common.db.DbManager
    public Cursor execQuery(qd2 qd2) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2055090300")) {
            return (Cursor) ipChange.ipc$dispatch("-2055090300", new Object[]{this, qd2});
        }
        try {
            return this.b.rawQuery(qd2.e(), qd2.d());
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public int executeUpdateDelete(qd2 qd2) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948907134")) {
            return ((Integer) ipChange.ipc$dispatch("1948907134", new Object[]{this, qd2})).intValue();
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = qd2.c(this.b);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            try {
                sQLiteStatement.releaseReference();
            } catch (Throwable th) {
                k91.c(th.getMessage(), th);
            }
            return executeUpdateDelete;
        } catch (Throwable th2) {
            if (sQLiteStatement != null) {
                try {
                    sQLiteStatement.releaseReference();
                } catch (Throwable th3) {
                    k91.c(th3.getMessage(), th3);
                }
            }
            throw th2;
        }
    }

    @Override // cn.damai.common.db.DbManager
    public <T> List<T> findAll(Class<T> cls) throws DbException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "866220969")) {
            return selector(cls).c();
        }
        return (List) ipChange.ipc$dispatch("866220969", new Object[]{this, cls});
    }

    @Override // cn.damai.common.db.DbManager
    public <T> T findById(Class<T> cls, Object obj) throws DbException {
        Cursor execQuery;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1313042993")) {
            return (T) ipChange.ipc$dispatch("1313042993", new Object[]{this, cls, obj});
        }
        si2<T> table = getTable(cls);
        if (table.j() && (execQuery = execQuery(g82.e(table).o(table.e().d(), "=", obj).k(1).toString())) != null) {
            try {
                if (execQuery.moveToNext()) {
                    T t = (T) np.b(table, execQuery);
                    iz0.a(execQuery);
                    return t;
                }
                iz0.a(execQuery);
            } catch (Throwable th) {
                iz0.a(execQuery);
                throw th;
            }
        }
        return null;
    }

    @Override // cn.damai.common.db.DbManager
    public List<k30> findDbModelAll(qd2 qd2) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-415257082")) {
            return (List) ipChange.ipc$dispatch("-415257082", new Object[]{this, qd2});
        }
        ArrayList arrayList = new ArrayList();
        Cursor execQuery = execQuery(qd2);
        if (execQuery != null) {
            while (execQuery.moveToNext()) {
                try {
                    arrayList.add(np.a(execQuery));
                } catch (Throwable th) {
                    iz0.a(execQuery);
                    throw th;
                }
            }
            iz0.a(execQuery);
        }
        return arrayList;
    }

    @Override // cn.damai.common.db.DbManager
    public k30 findDbModelFirst(qd2 qd2) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "273072386")) {
            return (k30) ipChange.ipc$dispatch("273072386", new Object[]{this, qd2});
        }
        Cursor execQuery = execQuery(qd2);
        if (execQuery == null) {
            return null;
        }
        try {
            if (execQuery.moveToNext()) {
                k30 a = np.a(execQuery);
                iz0.a(execQuery);
                return a;
            }
            iz0.a(execQuery);
            return null;
        } catch (Throwable th) {
            iz0.a(execQuery);
            throw th;
        }
    }

    @Override // cn.damai.common.db.DbManager
    public <T> T findFirst(Class<T> cls) throws DbException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1342292571")) {
            return selector(cls).d();
        }
        return (T) ipChange.ipc$dispatch("-1342292571", new Object[]{this, cls});
    }

    @Override // cn.damai.common.db.DbManager
    public DbManager.a getDaoConfig() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-557811063")) {
            return this.c;
        }
        return (DbManager.a) ipChange.ipc$dispatch("-557811063", new Object[]{this});
    }

    @Override // cn.damai.common.db.DbManager
    public SQLiteDatabase getDatabase() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "471447161")) {
            return this.b;
        }
        return (SQLiteDatabase) ipChange.ipc$dispatch("471447161", new Object[]{this});
    }

    @Override // cn.damai.common.db.DbManager
    public void replace(Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "41401935")) {
            ipChange.ipc$dispatch("41401935", new Object[]{this, obj});
            return;
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (!list.isEmpty()) {
                    si2<?> table = getTable(list.get(0).getClass());
                    a(table);
                    for (Object obj2 : list) {
                        execNonQuery(a.f(table, obj2));
                    }
                } else {
                    return;
                }
            } else {
                si2<?> table2 = getTable(obj.getClass());
                a(table2);
                execNonQuery(a.f(table2, obj));
            }
            setTransactionSuccessful();
            endTransaction();
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void save(Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204413826")) {
            ipChange.ipc$dispatch("204413826", new Object[]{this, obj});
            return;
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (!list.isEmpty()) {
                    si2<?> table = getTable(list.get(0).getClass());
                    a(table);
                    for (Object obj2 : list) {
                        execNonQuery(a.e(table, obj2));
                    }
                } else {
                    return;
                }
            } else {
                si2<?> table2 = getTable(obj.getClass());
                a(table2);
                execNonQuery(a.e(table2, obj));
            }
            setTransactionSuccessful();
            endTransaction();
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public boolean saveBindingId(Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-518843036")) {
            return ((Boolean) ipChange.ipc$dispatch("-518843036", new Object[]{this, obj})).booleanValue();
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (list.isEmpty()) {
                    return false;
                }
                si2<?> table = getTable(list.get(0).getClass());
                a(table);
                for (Object obj2 : list) {
                    if (!f(table, obj2)) {
                        throw new DbException("saveBindingId error, transaction will not commit!");
                    }
                }
            } else {
                si2<?> table2 = getTable(obj.getClass());
                a(table2);
                z = f(table2, obj);
            }
            setTransactionSuccessful();
            endTransaction();
            return z;
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void saveOrUpdate(Object obj) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427695446")) {
            ipChange.ipc$dispatch("427695446", new Object[]{this, obj});
            return;
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (!list.isEmpty()) {
                    si2<?> table = getTable(list.get(0).getClass());
                    a(table);
                    for (Object obj2 : list) {
                        g(table, obj2);
                    }
                } else {
                    return;
                }
            } else {
                si2<?> table2 = getTable(obj.getClass());
                a(table2);
                g(table2, obj);
            }
            setTransactionSuccessful();
            endTransaction();
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public <T> g82<T> selector(Class<T> cls) throws DbException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1320667108")) {
            return g82.e(getTable(cls));
        }
        return (g82) ipChange.ipc$dispatch("1320667108", new Object[]{this, cls});
    }

    @Override // cn.damai.common.db.DbManager
    public void update(Object obj, String... strArr) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883290839")) {
            ipChange.ipc$dispatch("-883290839", new Object[]{this, obj, strArr});
            return;
        }
        try {
            beginTransaction();
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                if (!list.isEmpty()) {
                    si2 table = getTable(list.get(0).getClass());
                    if (!table.j()) {
                        endTransaction();
                        return;
                    }
                    for (Object obj2 : list) {
                        execNonQuery(a.g(table, obj2, strArr));
                    }
                } else {
                    return;
                }
            } else {
                si2 table2 = getTable(obj.getClass());
                if (!table2.j()) {
                    endTransaction();
                    return;
                }
                execNonQuery(a.g(table2, obj, strArr));
            }
            setTransactionSuccessful();
            endTransaction();
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public Cursor execQuery(String str) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1471963615")) {
            return (Cursor) ipChange.ipc$dispatch("-1471963615", new Object[]{this, str});
        }
        try {
            return this.b.rawQuery(str, null);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void execNonQuery(String str) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708882593")) {
            ipChange.ipc$dispatch("1708882593", new Object[]{this, str});
            return;
        }
        try {
            this.b.execSQL(str);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    @Override // cn.damai.common.db.DbManager
    public int executeUpdateDelete(String str) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1001316123")) {
            return ((Integer) ipChange.ipc$dispatch("1001316123", new Object[]{this, str})).intValue();
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = this.b.compileStatement(str);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            try {
                sQLiteStatement.releaseReference();
            } catch (Throwable th) {
                k91.c(th.getMessage(), th);
            }
            return executeUpdateDelete;
        } catch (Throwable th2) {
            if (sQLiteStatement != null) {
                try {
                    sQLiteStatement.releaseReference();
                } catch (Throwable th3) {
                    k91.c(th3.getMessage(), th3);
                }
            }
            throw th2;
        }
    }

    @Override // cn.damai.common.db.DbManager
    public void delete(Class<?> cls) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "460417925")) {
            ipChange.ipc$dispatch("460417925", new Object[]{this, cls});
            return;
        }
        delete(cls, null);
    }

    @Override // cn.damai.common.db.DbManager
    public int update(Class<?> cls, nz2 nz2, KeyValue... keyValueArr) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1438632214")) {
            return ((Integer) ipChange.ipc$dispatch("-1438632214", new Object[]{this, cls, nz2, keyValueArr})).intValue();
        }
        si2 table = getTable(cls);
        if (!table.j()) {
            return 0;
        }
        try {
            beginTransaction();
            int executeUpdateDelete = executeUpdateDelete(a.h(table, nz2, keyValueArr));
            setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            endTransaction();
        }
    }

    @Override // cn.damai.common.db.DbManager
    public int delete(Class<?> cls, nz2 nz2) throws DbException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2062621441")) {
            return ((Integer) ipChange.ipc$dispatch("2062621441", new Object[]{this, cls, nz2})).intValue();
        }
        si2 table = getTable(cls);
        if (!table.j()) {
            return 0;
        }
        try {
            beginTransaction();
            int executeUpdateDelete = executeUpdateDelete(a.c(table, nz2));
            setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            endTransaction();
        }
    }
}
