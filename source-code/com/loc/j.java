package com.loc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.v13;
import tb.x13;

/* compiled from: Taobao */
public final class j {
    private static Map<Class<? extends aq>, aq> d = new HashMap();
    private x13 a;
    private SQLiteDatabase b;
    private aq c;

    public j(Context context, aq aqVar) {
        try {
            this.a = new x13(context.getApplicationContext(), aqVar.a(), aqVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = aqVar;
    }

    private static ContentValues a(Object obj, as asVar) {
        ContentValues contentValues = new ContentValues();
        Field[] l = l(obj.getClass(), asVar.b());
        for (Field field : l) {
            field.setAccessible(true);
            j(obj, field, contentValues);
        }
        return contentValues;
    }

    private SQLiteDatabase b() {
        try {
            if (this.b == null) {
                this.b = this.a.getReadableDatabase();
            }
        } catch (Throwable th) {
            v13.e(th, "dbs", "grd");
        }
        return this.b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.util.Map<java.lang.Class<? extends com.loc.aq>, com.loc.aq> */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized aq c(Class<? extends aq> cls) throws IllegalAccessException, InstantiationException {
        aq aqVar;
        synchronized (j.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            aqVar = d.get(cls);
        }
        return aqVar;
    }

    private static <T> T d(Cursor cursor, Class<T> cls, as asVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj;
        Field[] l = l(cls, asVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : l) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(at.class);
            if (annotation != null) {
                at atVar = (at) annotation;
                int b2 = atVar.b();
                int columnIndex = cursor.getColumnIndex(atVar.a());
                switch (b2) {
                    case 1:
                        obj = Short.valueOf(cursor.getShort(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 2:
                        obj = Integer.valueOf(cursor.getInt(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 3:
                        obj = Float.valueOf(cursor.getFloat(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 4:
                        obj = Double.valueOf(cursor.getDouble(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 5:
                        obj = Long.valueOf(cursor.getLong(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 6:
                        obj = cursor.getString(columnIndex);
                        field.set(newInstance, obj);
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return newInstance;
    }

    private static <T> String e(as asVar) {
        if (asVar == null) {
            return null;
        }
        return asVar.a();
    }

    private static <T> void g(SQLiteDatabase sQLiteDatabase, T t) {
        as n = n(t.getClass());
        String e = e(n);
        if (!TextUtils.isEmpty(e) && sQLiteDatabase != null) {
            sQLiteDatabase.insert(e, null, a(t, n));
        }
    }

    private <T> void h(T t) {
        p(t);
    }

    private static void j(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(at.class);
        if (annotation != null) {
            at atVar = (at) annotation;
            switch (atVar.b()) {
                case 1:
                    contentValues.put(atVar.a(), Short.valueOf(field.getShort(obj)));
                    return;
                case 2:
                    contentValues.put(atVar.a(), Integer.valueOf(field.getInt(obj)));
                    return;
                case 3:
                    contentValues.put(atVar.a(), Float.valueOf(field.getFloat(obj)));
                    return;
                case 4:
                    contentValues.put(atVar.a(), Double.valueOf(field.getDouble(obj)));
                    return;
                case 5:
                    contentValues.put(atVar.a(), Long.valueOf(field.getLong(obj)));
                    return;
                case 6:
                    contentValues.put(atVar.a(), (String) field.get(obj));
                    return;
                case 7:
                    try {
                        contentValues.put(atVar.a(), (byte[]) field.get(obj));
                        return;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private <T> void k(String str, Object obj) {
        synchronized (this.c) {
            if (obj != null) {
                as n = n(obj.getClass());
                String e = e(n);
                if (!TextUtils.isEmpty(e)) {
                    ContentValues a2 = a(obj, n);
                    SQLiteDatabase m = m();
                    this.b = m;
                    if (m != null) {
                        try {
                            m.update(e, a2, str, null);
                            SQLiteDatabase sQLiteDatabase = this.b;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                                this.b = null;
                            }
                        } catch (Throwable th) {
                            SQLiteDatabase sQLiteDatabase2 = this.b;
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                                this.b = null;
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }

    private static Field[] l(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        return z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private SQLiteDatabase m() {
        try {
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase2 = this.b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.b = this.a.getWritableDatabase();
            }
        } catch (Throwable th) {
            v13.e(th, "dbs", "gwd");
        }
        return this.b;
    }

    private static <T> as n(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(as.class);
        if (!(annotation != null)) {
            return null;
        }
        return (as) annotation;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x009a A[SYNTHETIC, Splitter:B:51:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa A[Catch:{ all -> 0x00b0 }] */
    private <T> List<T> o(String str, Class<T> cls) {
        Throwable th;
        Cursor cursor;
        String str2;
        String str3;
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            ArrayList arrayList = new ArrayList();
            as n = n(cls);
            String e = e(n);
            if (this.b == null) {
                this.b = b();
            }
            if (this.b == null || TextUtils.isEmpty(e) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.b.query(e, null, str, null, null, null, null);
                if (cursor == null) {
                    try {
                        this.b.close();
                        this.b = null;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th2) {
                                v13.e(th2, "dbs", "sld");
                            }
                        }
                        try {
                            SQLiteDatabase sQLiteDatabase2 = this.b;
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                                this.b = null;
                            }
                        } catch (Throwable th3) {
                            v13.e(th3, "dbs", "sld");
                        }
                        return arrayList;
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            v13.e(th, "dbs", "sld");
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable th5) {
                                    v13.e(th5, "dbs", "sld");
                                }
                            }
                            try {
                                sQLiteDatabase = this.b;
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                    this.b = null;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                str2 = "dbs";
                                str3 = "sld";
                                v13.e(th, str2, str3);
                                return arrayList;
                            }
                            return arrayList;
                        } catch (Throwable th7) {
                            v13.e(th7, "dbs", "sld");
                        }
                    }
                } else {
                    while (cursor.moveToNext()) {
                        arrayList.add(d(cursor, cls, n));
                    }
                    try {
                        cursor.close();
                    } catch (Throwable th8) {
                        v13.e(th8, "dbs", "sld");
                    }
                    try {
                        SQLiteDatabase sQLiteDatabase3 = this.b;
                        if (sQLiteDatabase3 != null) {
                            sQLiteDatabase3.close();
                            this.b = null;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        str2 = "dbs";
                        str3 = "sld";
                        v13.e(th, str2, str3);
                        return arrayList;
                    }
                    return arrayList;
                }
            } catch (Throwable th10) {
                th = th10;
                cursor = null;
                v13.e(th, "dbs", "sld");
                if (cursor != null) {
                }
                sQLiteDatabase = this.b;
                if (sQLiteDatabase != null) {
                }
                return arrayList;
            }
        }
        SQLiteDatabase sQLiteDatabase4 = this.b;
        if (sQLiteDatabase4 != null) {
            sQLiteDatabase4.close();
            this.b = null;
        }
        throw th;
        throw th;
    }

    private <T> void p(T t) {
        synchronized (this.c) {
            SQLiteDatabase m = m();
            this.b = m;
            if (m != null) {
                try {
                    g(m, t);
                    SQLiteDatabase sQLiteDatabase = this.b;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        this.b = null;
                    }
                } catch (Throwable th) {
                    SQLiteDatabase sQLiteDatabase2 = this.b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                        this.b = null;
                    }
                    throw th;
                }
            }
        }
    }

    private <T> void q(String str, Object obj) {
        k(str, obj);
    }

    public final <T> List<T> f(String str, Class<T> cls) {
        return o(str, cls);
    }

    public final void i(Object obj, String str) {
        synchronized (this.c) {
            List f = f(str, obj.getClass());
            if (f != null) {
                if (f.size() != 0) {
                    q(str, obj);
                }
            }
            h(obj);
        }
    }
}
