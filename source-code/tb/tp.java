package tb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.db.SqliteHelper;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.analytics.utils.Logger;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class tp {
    private HashMap<String, Boolean> a = new HashMap<>();
    private SqliteHelper b;
    private String c;
    private HashMap<Class<?>, List<Field>> d = new HashMap<>();
    private HashMap<Field, String> e = new HashMap<>();
    private HashMap<Class<?>, String> f = new HashMap<>();

    public tp(Context context, String str) {
        this.b = new SqliteHelper(context, str);
        this.c = str;
    }

    private SQLiteDatabase a(Class<? extends xd0> cls, String str) {
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        Boolean bool = Boolean.TRUE;
        if (this.a.get(str) == null || !this.a.get(str).booleanValue()) {
            bool = Boolean.FALSE;
        }
        if (!(cls == null || bool.booleanValue() || writableDatabase == null)) {
            List<Field> j = j(cls);
            ArrayList<Field> arrayList = new ArrayList<>();
            String str2 = " SELECT * FROM " + str + " LIMIT 0";
            int i = 0;
            if (j != null) {
                Cursor cursor = null;
                int i2 = 1;
                try {
                    cursor = writableDatabase.rawQuery(str2, null);
                } catch (Exception unused) {
                    Logger.f("DBMgr", "has not create table", str);
                }
                if (cursor != null) {
                    i2 = 0;
                }
                while (i < j.size()) {
                    Field field = j.get(i);
                    if (!"_id".equalsIgnoreCase(k(field)) && (i2 != 0 || (cursor != null && cursor.getColumnIndex(k(field)) == -1))) {
                        arrayList.add(field);
                    }
                    i++;
                }
                this.b.e(cursor);
                i = i2;
            }
            if (i != 0) {
                e(writableDatabase, str, arrayList);
            } else if (arrayList.size() > 0) {
                u(writableDatabase, str, arrayList);
            }
            this.a.put(str, Boolean.TRUE);
        }
        return writableDatabase;
    }

    private void e(SQLiteDatabase sQLiteDatabase, String str, ArrayList<Field> arrayList) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS " + str + " (" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT ,");
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                Class<?> type = arrayList.get(i).getType();
                sb.append(" ");
                sb.append(k(arrayList.get(i)));
                sb.append(" ");
                sb.append(o(type));
                sb.append(" ");
                sb.append(n(type));
            }
        }
        sb.append(" );");
        String sb2 = sb.toString();
        Logger.f("DBMgr", "excute sql:", sb2);
        try {
            sQLiteDatabase.execSQL(sb2);
        } catch (Exception e2) {
            Logger.v("DBMgr", "create db error", e2);
        }
    }

    private List<Field> j(Class cls) {
        if (this.d.containsKey(cls)) {
            return this.d.get(cls);
        }
        List<Field> emptyList = Collections.emptyList();
        if (cls != null) {
            emptyList = new ArrayList<>();
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getAnnotation(Ingore.class) == null && !field.isSynthetic()) {
                    field.setAccessible(true);
                    emptyList.add(field);
                }
            }
            if (!(cls.getSuperclass() == null || cls.getSuperclass() == Object.class)) {
                emptyList.addAll(j(cls.getSuperclass()));
            }
            this.d.put(cls, emptyList);
        }
        return emptyList;
    }

    private String k(Field field) {
        String str;
        if (this.e.containsKey(field)) {
            return this.e.get(field);
        }
        Column column = (Column) field.getAnnotation(Column.class);
        if (column == null || TextUtils.isEmpty(column.value())) {
            str = field.getName();
        } else {
            str = column.value();
        }
        this.e.put(field, str);
        return str;
    }

    private String n(Class cls) {
        return (cls == Long.TYPE || cls == Integer.TYPE || cls == Long.class) ? "default 0" : "default \"\"";
    }

    private String o(Class<?> cls) {
        return (cls == Long.TYPE || cls == Integer.TYPE || cls == Long.class) ? "INTEGER" : "TEXT";
    }

    private void u(SQLiteDatabase sQLiteDatabase, String str, ArrayList<Field> arrayList) {
        String str2 = "ALTER TABLE " + str + " ADD COLUMN ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(str2);
            sb.append(k(arrayList.get(i)));
            sb.append(" ");
            sb.append(o(arrayList.get(i).getType()));
            String sb2 = sb.toString();
            try {
                sQLiteDatabase.execSQL(sb2);
            } catch (Exception e2) {
                Logger.v("DBMgr", "update db error...", e2);
            }
            sb.delete(0, sb2.length());
            Logger.f("DBMgr", null, "excute sql:", sb2);
        }
    }

    public synchronized void b(Class<? extends xd0> cls) {
        if (cls != null) {
            c(p(cls));
        }
    }

    public synchronized void c(String str) {
        if (str != null) {
            try {
                SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.delete(str, null, null);
                    this.b.f(writableDatabase);
                }
            } catch (Exception e2) {
                Logger.h("delete db data", e2, new Object[0]);
            }
            return;
        }
        return;
    }

    public synchronized int d(Class<? extends xd0> cls) {
        SqliteHelper sqliteHelper;
        int i = 0;
        if (cls == null) {
            return 0;
        }
        String p = p(cls);
        SQLiteDatabase a2 = a(cls, p);
        if (a2 != null) {
            try {
                Cursor rawQuery = a2.rawQuery("SELECT count(*) FROM " + p, null);
                if (rawQuery != null) {
                    rawQuery.moveToFirst();
                    i = rawQuery.getInt(0);
                }
                this.b.e(rawQuery);
                sqliteHelper = this.b;
            } catch (Throwable th) {
                this.b.e(null);
                this.b.f(a2);
                throw th;
            }
            sqliteHelper.f(a2);
        } else {
            Logger.f("DBMgr", "[count] db is null. tableName", p);
        }
        return i;
    }

    public synchronized int f(Class<? extends xd0> cls, String str, String[] strArr) {
        SqliteHelper sqliteHelper;
        int i = 0;
        if (cls != null) {
            SQLiteDatabase a2 = a(cls, p(cls));
            if (a2 == null) {
                return 0;
            }
            try {
                i = a2.delete(p(cls), str, strArr);
                sqliteHelper = this.b;
            } catch (Throwable th) {
                this.b.f(a2);
                throw th;
            }
            sqliteHelper.f(a2);
        }
        return i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r16v0, resolved type: tb.tp */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:54|55|56|57|58|59|61) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0193 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x01ad */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x01bd */
    public synchronized int g(List<? extends xd0> list) {
        SQLiteDatabase a2;
        SqliteHelper sqliteHelper;
        if (list != null) {
            if (list.size() != 0) {
                String p = p(((xd0) list.get(0)).getClass());
                a2 = a(((xd0) list.get(0)).getClass(), p);
                if (a2 == null) {
                    Logger.f("DBMgr", "[delete] db is null. tableName", p);
                    return 0;
                }
                try {
                    a2.beginTransaction();
                    StringBuffer stringBuffer = new StringBuffer();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        if (arrayList.size() > 0) {
                            stringBuffer.append(" OR ");
                        }
                        stringBuffer.append("_id=?");
                        arrayList.add(String.valueOf(((xd0) list.get(i))._id));
                        if (arrayList.size() == 20) {
                            String[] strArr = new String[arrayList.size()];
                            arrayList.toArray(strArr);
                            long delete = (long) a2.delete(p, stringBuffer.toString(), strArr);
                            if (delete == ((long) arrayList.size())) {
                                Logger.f("DBMgr", "delete success. DbName", this.c, "tableName", p, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(delete));
                            } else {
                                Logger.f("DBMgr", "delete fail. DbName", this.c, "tableName", p, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(delete));
                            }
                            stringBuffer.delete(0, stringBuffer.length());
                            arrayList.clear();
                        }
                    }
                    if (arrayList.size() > 0) {
                        String[] strArr2 = new String[arrayList.size()];
                        arrayList.toArray(strArr2);
                        long delete2 = (long) a2.delete(p, stringBuffer.toString(), strArr2);
                        if (delete2 == ((long) arrayList.size())) {
                            Logger.f("DBMgr", "delete success. DbName", this.c, "tableName", p, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(delete2));
                        } else {
                            Logger.f("DBMgr", "delete fail. DbName", this.c, "tableName", p, "whereArgs size", Integer.valueOf(arrayList.size()), "ret size", Long.valueOf(delete2));
                        }
                    }
                    a2.setTransactionSuccessful();
                    try {
                        a2.endTransaction();
                    } catch (Throwable unused) {
                    }
                    sqliteHelper = this.b;
                } catch (Throwable unused2) {
                }
                sqliteHelper.f(a2);
                return list.size();
            }
        }
        return 0;
        sqliteHelper = this.b;
        sqliteHelper.f(a2);
        return list.size();
    }

    public int h(xd0 xd0) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(xd0);
        return g(arrayList);
    }

    /* JADX INFO: finally extract failed */
    public synchronized List<? extends xd0> i(Class<? extends xd0> cls, String str, String str2, int i) {
        List<? extends xd0> list;
        Object th;
        Object obj;
        List<? extends xd0> list2 = Collections.EMPTY_LIST;
        if (cls == null) {
            return list2;
        }
        String p = p(cls);
        SQLiteDatabase a2 = a(cls, p);
        if (a2 == null) {
            Logger.f("DBMgr", "[find] db is null. tableName", p);
            return list2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(p);
        sb.append(TextUtils.isEmpty(str) ? "" : " WHERE " + str);
        sb.append(TextUtils.isEmpty(str2) ? "" : " ORDER BY " + str2);
        sb.append(i <= 0 ? "" : " LIMIT " + i);
        String sb2 = sb.toString();
        Logger.r("DBMgr", lf1.CACHE_SQL, sb2);
        Cursor cursor = null;
        try {
            cursor = a2.rawQuery(sb2, null);
            list = new ArrayList<>();
            try {
                List<Field> j = j(cls);
                while (cursor != null && cursor.moveToNext()) {
                    xd0 xd0 = (xd0) cls.newInstance();
                    for (int i2 = 0; i2 < j.size(); i2++) {
                        Field field = j.get(i2);
                        Class<?> type = field.getType();
                        String k = k(field);
                        int columnIndex = cursor.getColumnIndex(k);
                        if (columnIndex != -1) {
                            if (type != Long.class) {
                                if (type != Long.TYPE) {
                                    if (type != Integer.class) {
                                        if (type != Integer.TYPE) {
                                            if (type != Double.TYPE) {
                                                if (type != Double.class) {
                                                    obj = cursor.getString(columnIndex);
                                                    field.set(xd0, obj);
                                                }
                                            }
                                            obj = Double.valueOf(cursor.getDouble(columnIndex));
                                            field.set(xd0, obj);
                                        }
                                    }
                                    obj = Integer.valueOf(cursor.getInt(columnIndex));
                                    field.set(xd0, obj);
                                }
                            }
                            obj = Long.valueOf(cursor.getLong(columnIndex));
                            try {
                                field.set(xd0, obj);
                            } catch (Exception e2) {
                                if ((e2 instanceof IllegalArgumentException) && (obj instanceof String)) {
                                    field.set(xd0, Boolean.valueOf((String) obj));
                                }
                            } catch (Throwable unused) {
                            }
                        } else {
                            Logger.v("DBMgr", "can not get field", k);
                        }
                    }
                    list.add(xd0);
                }
                this.b.e(cursor);
                this.b.f(a2);
            } catch (Throwable th2) {
                th = th2;
                list2 = list;
                try {
                    Logger.v("DBMgr", "[get]", th);
                    this.b.e(cursor);
                    this.b.f(a2);
                    list = list2;
                    return list;
                } catch (Throwable th3) {
                    this.b.e(cursor);
                    this.b.f(a2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            Logger.v("DBMgr", "[get]", th);
            this.b.e(cursor);
            this.b.f(a2);
            list = list2;
            return list;
        }
        return list;
    }

    public SQLiteDatabase l() {
        return this.b.getWritableDatabase();
    }

    public double m() {
        File databasePath;
        Context j = Variables.n().j();
        if (j == null || (databasePath = j.getDatabasePath("ut.db")) == null) {
            return 0.0d;
        }
        return (((double) databasePath.length()) / 1024.0d) / 1024.0d;
    }

    public String p(Class<?> cls) {
        String str;
        if (cls == null) {
            Logger.i("DBMgr", "cls is null");
            return null;
        } else if (this.f.containsKey(cls)) {
            return this.f.get(cls);
        } else {
            TableName tableName = (TableName) cls.getAnnotation(TableName.class);
            if (tableName == null || TextUtils.isEmpty(tableName.value())) {
                str = cls.getName().replace(".", JSMethod.NOT_SET);
            } else {
                str = tableName.value();
            }
            this.f.put(cls, str);
            return str;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: tb.tp */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:11|12|13|(7:16|(6:19|20|21|(2:23|60)(2:24|61)|27|17)|58|28|(2:30|(2:32|57)(1:56))(2:33|55)|34|14)|35|36|37|38|39|41|48|49) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:42|43|(2:44|45)|46) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r2.setTransactionSuccessful();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f5, code lost:
        r15 = r14.b;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00e6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00ef */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00f2 */
    public synchronized void q(List<? extends xd0> list) {
        if (list != null) {
            if (list.size() != 0) {
                String p = p(((xd0) list.get(0)).getClass());
                SQLiteDatabase a2 = a(((xd0) list.get(0)).getClass(), p);
                if (a2 == null) {
                    Logger.v("DBMgr", "[insert]can not get available db. tableName", p);
                    return;
                }
                Logger.f("DBMgr", "entities.size", Integer.valueOf(list.size()));
                List<Field> j = j(((xd0) list.get(0)).getClass());
                ContentValues contentValues = new ContentValues();
                a2.beginTransaction();
                for (int i = 0; i < list.size(); i++) {
                    xd0 xd0 = (xd0) list.get(i);
                    for (int i2 = 0; i2 < j.size(); i2++) {
                        Field field = j.get(i2);
                        String k = k(field);
                        try {
                            Object obj = field.get(xd0);
                            if (obj != null) {
                                contentValues.put(k, obj + "");
                            } else {
                                contentValues.put(k, "");
                            }
                        } catch (Exception e2) {
                            Logger.v("DBMgr", "get field failed", e2);
                        }
                    }
                    long j2 = xd0._id;
                    if (j2 == -1) {
                        contentValues.remove("_id");
                        long insert = a2.insert(p, null, contentValues);
                        if (insert != -1) {
                            xd0._id = insert;
                        }
                    } else {
                        a2.update(p, contentValues, "_id=?", new String[]{String.valueOf(j2)});
                    }
                    contentValues.clear();
                }
                a2.setTransactionSuccessful();
                a2.endTransaction();
                SqliteHelper sqliteHelper = this.b;
                sqliteHelper.f(a2);
            }
        }
    }

    public void r(xd0 xd0) {
        if (xd0 != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(xd0);
            q(arrayList);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: tb.tp */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:11|12|(5:15|(6:18|19|20|55|23|16)|53|24|13)|25|26|27|28|29|31|46|47) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:35|36|37|39) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0089, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008a, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r2.setTransactionSuccessful();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c8, code lost:
        r12.b.f(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cd, code lost:
        throw r13;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00b8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00c5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00ce */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00d1 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c1 A[ExcHandler: all (r13v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:11:0x003b] */
    public synchronized void s(List<? extends xd0> list) {
        SQLiteDatabase a2;
        SqliteHelper sqliteHelper;
        if (list != null) {
            if (list.size() != 0) {
                String p = p(((xd0) list.get(0)).getClass());
                a2 = a(((xd0) list.get(0)).getClass(), p);
                if (a2 == null) {
                    Logger.f("DBMgr", "[update] db is null. tableName", p);
                    return;
                }
                try {
                    a2.beginTransaction();
                    List<Field> j = j(((xd0) list.get(0)).getClass());
                    for (int i = 0; i < list.size(); i++) {
                        ContentValues contentValues = new ContentValues();
                        for (int i2 = 0; i2 < j.size(); i2++) {
                            Field field = j.get(i2);
                            field.setAccessible(true);
                            String k = k(field);
                            contentValues.put(k, field.get(list.get(i)) + "");
                        }
                        a2.update(p, contentValues, "_id=?", new String[]{((xd0) list.get(i))._id + ""});
                    }
                    a2.setTransactionSuccessful();
                    a2.endTransaction();
                    sqliteHelper = this.b;
                } catch (Exception unknown) {
                    a2.setTransactionSuccessful();
                    try {
                        a2.endTransaction();
                    } catch (Exception unused) {
                    }
                    sqliteHelper = this.b;
                } catch (Throwable th) {
                }
                sqliteHelper.f(a2);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: tb.tp */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:38|39|40|42) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:43|44|45|46|47) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b5, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b6, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cb, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r2.setTransactionSuccessful();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d2, code lost:
        r13.b.f(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        throw r14;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00c2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00cf */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00db */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cb A[ExcHandler: all (r14v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:11:0x003b] */
    public synchronized void t(List<? extends xd0> list) {
        SQLiteDatabase a2;
        SqliteHelper sqliteHelper;
        if (list != null) {
            if (list.size() != 0) {
                String p = p(((xd0) list.get(0)).getClass());
                a2 = a(((xd0) list.get(0)).getClass(), p);
                if (a2 == null) {
                    Logger.f("DBMgr", "[updateLogPriority] db is null. tableName", p);
                    return;
                }
                try {
                    a2.beginTransaction();
                    List<Field> j = j(((xd0) list.get(0)).getClass());
                    for (int i = 0; i < list.size(); i++) {
                        ContentValues contentValues = new ContentValues();
                        for (int i2 = 0; i2 < j.size(); i2++) {
                            Field field = j.get(i2);
                            String k = k(field);
                            if (k != null && k.equalsIgnoreCase("priority")) {
                                field.setAccessible(true);
                                contentValues.put(k, field.get(list.get(i)) + "");
                                a2.update(p, contentValues, "_id=?", new String[]{((xd0) list.get(i))._id + ""});
                                break;
                            }
                        }
                    }
                    a2.setTransactionSuccessful();
                    try {
                        a2.endTransaction();
                    } catch (Exception unused) {
                    }
                    sqliteHelper = this.b;
                } catch (Exception unknown) {
                    a2.setTransactionSuccessful();
                    a2.endTransaction();
                    sqliteHelper = this.b;
                } catch (Throwable th) {
                }
                sqliteHelper.f(a2);
            }
        }
    }
}
