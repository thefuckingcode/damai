package cn.damai.common.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import cn.damai.common.db.commonutil.util.KeyValue;
import cn.damai.common.db.ex.DbException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import tb.g82;
import tb.k30;
import tb.nz2;
import tb.qd2;
import tb.si2;

/* compiled from: Taobao */
public interface DbManager extends Closeable {

    /* compiled from: Taobao */
    public interface DbOpenListener {
        void onDbOpened(DbManager dbManager);
    }

    /* compiled from: Taobao */
    public interface DbUpgradeListener {
        void onUpgrade(DbManager dbManager, int i, int i2);
    }

    /* compiled from: Taobao */
    public interface TableCreateListener {
        void onTableCreated(DbManager dbManager, si2<?> si2);
    }

    /* compiled from: Taobao */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        private File a;
        private String b = "xUtils.db";
        private int c = 1;
        private boolean d = true;
        private DbUpgradeListener e;
        private TableCreateListener f;
        private DbOpenListener g;

        public File a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2099872570")) {
                return this.a;
            }
            return (File) ipChange.ipc$dispatch("2099872570", new Object[]{this});
        }

        public String b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-794124031")) {
                return this.b;
            }
            return (String) ipChange.ipc$dispatch("-794124031", new Object[]{this});
        }

        public DbOpenListener c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-152925372")) {
                return this.g;
            }
            return (DbOpenListener) ipChange.ipc$dispatch("-152925372", new Object[]{this});
        }

        public DbUpgradeListener d() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-428246240")) {
                return this.e;
            }
            return (DbUpgradeListener) ipChange.ipc$dispatch("-428246240", new Object[]{this});
        }

        public int e() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1871655173")) {
                return this.c;
            }
            return ((Integer) ipChange.ipc$dispatch("-1871655173", new Object[]{this})).intValue();
        }

        public boolean equals(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1540508403")) {
                return ((Boolean) ipChange.ipc$dispatch("-1540508403", new Object[]{this, obj})).booleanValue();
            } else if (this == obj) {
                return true;
            } else {
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                if (!this.b.equals(aVar.b)) {
                    return false;
                }
                File file = this.a;
                File file2 = aVar.a;
                if (file != null) {
                    return file.equals(file2);
                }
                if (file2 == null) {
                    return true;
                }
                return false;
            }
        }

        public TableCreateListener f() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1301030880")) {
                return this.f;
            }
            return (TableCreateListener) ipChange.ipc$dispatch("-1301030880", new Object[]{this});
        }

        public boolean g() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1408492177")) {
                return this.d;
            }
            return ((Boolean) ipChange.ipc$dispatch("1408492177", new Object[]{this})).booleanValue();
        }

        public a h(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-99204911")) {
                return (a) ipChange.ipc$dispatch("-99204911", new Object[]{this, str});
            }
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
            }
            return this;
        }

        public int hashCode() {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1725391556")) {
                return ((Integer) ipChange.ipc$dispatch("1725391556", new Object[]{this})).intValue();
            }
            int hashCode = this.b.hashCode() * 31;
            File file = this.a;
            if (file != null) {
                i = file.hashCode();
            }
            return hashCode + i;
        }

        public a i(DbOpenListener dbOpenListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2045217638")) {
                return (a) ipChange.ipc$dispatch("2045217638", new Object[]{this, dbOpenListener});
            }
            this.g = dbOpenListener;
            return this;
        }

        public a j(DbUpgradeListener dbUpgradeListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "220492088")) {
                return (a) ipChange.ipc$dispatch("220492088", new Object[]{this, dbUpgradeListener});
            }
            this.e = dbUpgradeListener;
            return this;
        }

        public a k(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-81203681")) {
                return (a) ipChange.ipc$dispatch("-81203681", new Object[]{this, Integer.valueOf(i)});
            }
            this.c = i;
            return this;
        }

        public a l(TableCreateListener tableCreateListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1970886704")) {
                return (a) ipChange.ipc$dispatch("-1970886704", new Object[]{this, tableCreateListener});
            }
            this.f = tableCreateListener;
            return this;
        }

        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "600555968")) {
                return (String) ipChange.ipc$dispatch("600555968", new Object[]{this});
            }
            return String.valueOf(this.a) + "/" + this.b;
        }
    }

    void addColumn(Class<?> cls, String str) throws DbException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    int delete(Class<?> cls, nz2 nz2) throws DbException;

    void delete(Class<?> cls) throws DbException;

    void delete(Object obj) throws DbException;

    void deleteById(Class<?> cls, Object obj) throws DbException;

    void dropDb() throws DbException;

    void dropTable(Class<?> cls) throws DbException;

    void execNonQuery(String str) throws DbException;

    void execNonQuery(qd2 qd2) throws DbException;

    Cursor execQuery(String str) throws DbException;

    Cursor execQuery(qd2 qd2) throws DbException;

    int executeUpdateDelete(String str) throws DbException;

    int executeUpdateDelete(qd2 qd2) throws DbException;

    <T> List<T> findAll(Class<T> cls) throws DbException;

    <T> T findById(Class<T> cls, Object obj) throws DbException;

    List<k30> findDbModelAll(qd2 qd2) throws DbException;

    k30 findDbModelFirst(qd2 qd2) throws DbException;

    <T> T findFirst(Class<T> cls) throws DbException;

    a getDaoConfig();

    SQLiteDatabase getDatabase();

    <T> si2<T> getTable(Class<T> cls) throws DbException;

    void replace(Object obj) throws DbException;

    void save(Object obj) throws DbException;

    boolean saveBindingId(Object obj) throws DbException;

    void saveOrUpdate(Object obj) throws DbException;

    <T> g82<T> selector(Class<T> cls) throws DbException;

    int update(Class<?> cls, nz2 nz2, KeyValue... keyValueArr) throws DbException;

    void update(Object obj, String... strArr) throws DbException;
}
