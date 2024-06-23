package com.taobao.android.dinamicx.template.db;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.taobao.android.dinamicx.template.db.DXDataBaseEntry;
import java.lang.reflect.Field;
import java.util.ArrayList;
import tb.d80;
import tb.jl1;
import tb.ry;
import tb.wz;

/* compiled from: Taobao */
public final class a {
    public static final int TYPE_BLOB = 7;
    public static final int TYPE_BOOLEAN = 1;
    public static final int TYPE_DOUBLE = 6;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_INT = 3;
    public static final int TYPE_LONG = 4;
    public static final int TYPE_SHORT = 2;
    public static final int TYPE_STRING = 0;
    private static final String[] c = {"TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "REAL", "REAL", "NONE"};
    private final String a;
    private final C0204a[] b;

    /* renamed from: com.taobao.android.dinamicx.template.db.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0204a {
        public final String a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final String e;
        public final boolean f;

        public C0204a(String str, int i, boolean z, boolean z2, String str2, boolean z3, Field field, int i2) {
            this.a = str.toLowerCase();
            this.b = i;
            this.c = z;
            this.d = z2;
            this.e = str2;
            this.f = z3;
            field.setAccessible(true);
        }

        public boolean a() {
            return "_id".equals(this.a);
        }
    }

    public a(Class<? extends DXDataBaseEntry> cls) {
        C0204a[] f = f(cls);
        this.a = g(cls);
        this.b = f;
        if (f != null) {
            String[] strArr = new String[f.length];
            for (int i = 0; i != f.length; i++) {
                strArr[i] = f[i].a;
            }
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL(str);
    }

    private void e(Class<?> cls, ArrayList<C0204a> arrayList) {
        int i;
        Field[] declaredFields = cls.getDeclaredFields();
        for (int i2 = 0; i2 != declaredFields.length; i2++) {
            Field field = declaredFields[i2];
            DXDataBaseEntry.Column column = (DXDataBaseEntry.Column) field.getAnnotation(DXDataBaseEntry.Column.class);
            if (column != null) {
                Class<?> type = field.getType();
                if (type == String.class) {
                    i = 0;
                } else if (type == Boolean.TYPE) {
                    i = 1;
                } else if (type == Short.TYPE) {
                    i = 2;
                } else if (type == Integer.TYPE) {
                    i = 3;
                } else if (type == Long.TYPE) {
                    i = 4;
                } else if (type == Float.TYPE) {
                    i = 5;
                } else if (type == Double.TYPE) {
                    i = 6;
                } else if (type == byte[].class) {
                    i = 7;
                } else {
                    throw new IllegalArgumentException("Unsupported field type for column: " + type.getName());
                }
                arrayList.add(new C0204a(column.value(), i, column.indexed(), column.primaryKey(), column.defaultValue(), column.notNull(), field, arrayList.size()));
            }
        }
    }

    private C0204a[] f(Class<?> cls) {
        ArrayList<C0204a> arrayList = new ArrayList<>();
        while (cls != null) {
            e(cls, arrayList);
            cls = cls.getSuperclass();
        }
        C0204a[] aVarArr = new C0204a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return aVarArr;
    }

    private String g(Class<?> cls) {
        DXDataBaseEntry.Table table = (DXDataBaseEntry.Table) cls.getAnnotation(DXDataBaseEntry.Table.class);
        if (table == null) {
            return null;
        }
        return table.value();
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        String str = this.a;
        if (TextUtils.isEmpty(str)) {
            wz.d(ry.TAG, "DataBase", "没有用注解定义表名");
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb2.append(str);
        sb2.append(" (_id INTEGER");
        C0204a[] aVarArr = this.b;
        for (C0204a aVar : aVarArr) {
            if (!aVar.a()) {
                sb2.append(',');
                sb2.append(aVar.a);
                sb2.append(' ');
                sb2.append(c[aVar.b]);
                if (!TextUtils.isEmpty(aVar.e)) {
                    sb2.append(" DEFAULT ");
                    sb2.append(aVar.e);
                } else if (aVar.f) {
                    sb2.append(" NOT NULL");
                }
                if (aVar.d) {
                    sb.append(aVar.a);
                    sb.append(",");
                }
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            sb2.append(", PRIMARY KEY(");
            sb2.append(sb.toString());
            sb2.append(jl1.BRACKET_END_STR);
        }
        sb2.append(");");
        d(sQLiteDatabase, sb2.toString());
        sb2.setLength(0);
        sb2.append("CREATE INDEX index_template ON ");
        sb2.append(str);
        sb2.append(jl1.BRACKET_START_STR);
        C0204a[] aVarArr2 = this.b;
        for (C0204a aVar2 : aVarArr2) {
            if (aVar2.c) {
                sb2.append(aVar2.a);
                sb2.append(",");
            }
        }
        sb2.deleteCharAt(sb2.length() - 1);
        sb2.append(");");
        d(sQLiteDatabase, sb2.toString());
        sb2.setLength(0);
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("DROP TABLE IF EXISTS ");
        sb.append(this.a);
        sb.append(d80.TokenSEM);
        d(sQLiteDatabase, sb.toString());
        sb.setLength(0);
    }

    public String c() {
        return this.a;
    }
}
