package com.amap.api.mapcore.util;

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

/* compiled from: Taobao */
public class hg {
    private static Map<Class<? extends hf>, hf> d = new HashMap();
    private hj a;
    private SQLiteDatabase b;
    private hf c;

    public hg(Context context, hf hfVar) {
        try {
            this.a = new hj(context.getApplicationContext(), hfVar.b(), null, hfVar.c(), hfVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = hfVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.util.Map<java.lang.Class<? extends com.amap.api.mapcore.util.hf>, com.amap.api.mapcore.util.hf> */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized hf a(Class<? extends hf> cls) throws IllegalAccessException, InstantiationException {
        hf hfVar;
        synchronized (hg.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            hfVar = d.get(cls);
        }
        return hfVar;
    }

    private boolean a(Annotation annotation) {
        return annotation != null;
    }

    public <T> List<T> b(String str, Class<T> cls) {
        return a(str, (Class) cls, false);
    }

    private SQLiteDatabase b(boolean z) {
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
            ha.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : map.keySet()) {
            if (z) {
                sb.append(str);
                sb.append(" = '");
                sb.append(map.get(str));
                sb.append("'");
                z = false;
            } else {
                sb.append(" and ");
                sb.append(str);
                sb.append(" = '");
                sb.append(map.get(str));
                sb.append("'");
            }
        }
        return sb.toString();
    }

    private <T> hh b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(hh.class);
        if (!a(annotation)) {
            return null;
        }
        return (hh) annotation;
    }

    public <T> void a(String str, Class<T> cls) {
        synchronized (this.c) {
            String a2 = a(b(cls));
            if (!TextUtils.isEmpty(a2)) {
                SQLiteDatabase b2 = b(false);
                this.b = b2;
                if (b2 != null) {
                    try {
                        b2.delete(a2, str, null);
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

    public <T> void a(String str, Object obj, boolean z) {
        synchronized (this.c) {
            if (obj != null) {
                hh b2 = b(obj.getClass());
                String a2 = a(b2);
                if (!TextUtils.isEmpty(a2)) {
                    ContentValues a3 = a(obj, b2);
                    if (a3 != null) {
                        SQLiteDatabase b3 = b(z);
                        this.b = b3;
                        if (b3 != null) {
                            try {
                                b3.update(a2, a3, str, null);
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
    }

    public <T> void a(String str, Object obj) {
        a(str, obj, false);
    }

    public void a(Object obj, String str) {
        synchronized (this.c) {
            List b2 = b(str, obj.getClass());
            if (b2 != null) {
                if (b2.size() != 0) {
                    a(str, obj);
                }
            }
            a(obj);
        }
    }

    public <T> void a(T t) {
        a((Object) t, false);
    }

    public <T> void a(T t, boolean z) {
        synchronized (this.c) {
            SQLiteDatabase b2 = b(z);
            this.b = b2;
            if (b2 != null) {
                try {
                    a(b2, (Object) t);
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

    private <T> void a(SQLiteDatabase sQLiteDatabase, T t) {
        ContentValues a2;
        hh b2 = b(t.getClass());
        String a3 = a(b2);
        if (!TextUtils.isEmpty(a3) && sQLiteDatabase != null && (a2 = a((Object) t, b2)) != null) {
            sQLiteDatabase.insert(a3, null, a2);
        }
    }

    public <T> void a(List<T> list) {
        String str;
        String str2;
        synchronized (this.c) {
            if (list != null) {
                if (list.size() != 0) {
                    SQLiteDatabase b2 = b(false);
                    this.b = b2;
                    if (b2 != null) {
                        try {
                            b2.beginTransaction();
                            for (T t : list) {
                                a(this.b, (Object) t);
                            }
                            this.b.setTransactionSuccessful();
                            try {
                                if (this.b.inTransaction()) {
                                    this.b.endTransaction();
                                }
                            } catch (Throwable th) {
                                ha.a(th, "dbs", "ild");
                            }
                            try {
                                this.b.close();
                                this.b = null;
                            } catch (Throwable th2) {
                                th = th2;
                                str = "dbs";
                                str2 = "ild";
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            str = "dbs";
                            str2 = "ild";
                        }
                    }
                    return;
                }
            }
            return;
        }
        ha.a(th, str, str2);
        this.b.close();
        this.b = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r13 = r12.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00b6, code lost:
        if (r13 == null) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b8, code lost:
        r13.close();
        r12.b = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c8, code lost:
        throw r14;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00cb A[SYNTHETIC, Splitter:B:71:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dd A[Catch:{ all -> 0x00e3 }] */
    public <T> List<T> a(String str, Class<T> cls, boolean z) {
        Throwable th;
        Cursor cursor;
        String str2;
        String str3;
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            ArrayList arrayList = new ArrayList();
            hh b2 = b(cls);
            String a2 = a(b2);
            if (this.b == null) {
                this.b = a(z);
            }
            if (this.b == null || TextUtils.isEmpty(a2) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.b.query(a2, null, str, null, null, null, null);
                if (cursor == null) {
                    try {
                        this.b.close();
                        this.b = null;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th2) {
                                if (!z) {
                                    ha.a(th2, "dbs", "sld");
                                }
                            }
                        }
                        try {
                            SQLiteDatabase sQLiteDatabase2 = this.b;
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                                this.b = null;
                            }
                        } catch (Throwable th3) {
                            if (!z) {
                                ha.a(th3, "dbs", "sld");
                            }
                        }
                        return arrayList;
                    } catch (Throwable th4) {
                        th = th4;
                        if (!z) {
                            try {
                                ha.a(th, "dbs", "sld");
                            } catch (Throwable th5) {
                                if (!z) {
                                    ha.a(th5, "dbs", "sld");
                                }
                            }
                        }
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th6) {
                                if (!z) {
                                    ha.a(th6, "dbs", "sld");
                                }
                            }
                        }
                        try {
                            sQLiteDatabase = this.b;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                                this.b = null;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            if (!z) {
                                str2 = "dbs";
                                str3 = "sld";
                                ha.a(th, str2, str3);
                            }
                        }
                        return arrayList;
                    }
                } else {
                    while (cursor.moveToNext()) {
                        arrayList.add(a(cursor, cls, b2));
                    }
                    try {
                        cursor.close();
                    } catch (Throwable th8) {
                        if (!z) {
                            ha.a(th8, "dbs", "sld");
                        }
                    }
                    try {
                        SQLiteDatabase sQLiteDatabase3 = this.b;
                        if (sQLiteDatabase3 != null) {
                            sQLiteDatabase3.close();
                            this.b = null;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        if (!z) {
                            str2 = "dbs";
                            str3 = "sld";
                            ha.a(th, str2, str3);
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable th10) {
                th = th10;
                cursor = null;
                if (!z) {
                }
                if (cursor != null) {
                }
                sQLiteDatabase = this.b;
                if (sQLiteDatabase != null) {
                }
                return arrayList;
            }
        }
    }

    private <T> T a(Cursor cursor, Class<T> cls, hh hhVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] a2 = a((Class<?>) cls, hhVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(hi.class);
            if (annotation != null) {
                hi hiVar = (hi) annotation;
                int b2 = hiVar.b();
                int columnIndex = cursor.getColumnIndex(hiVar.a());
                switch (b2) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        continue;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        continue;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        continue;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        continue;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        continue;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        continue;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        continue;
                }
            }
        }
        return newInstance;
    }

    private void a(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(hi.class);
        if (annotation != null) {
            hi hiVar = (hi) annotation;
            switch (hiVar.b()) {
                case 1:
                    contentValues.put(hiVar.a(), Short.valueOf(field.getShort(obj)));
                    return;
                case 2:
                    contentValues.put(hiVar.a(), Integer.valueOf(field.getInt(obj)));
                    return;
                case 3:
                    contentValues.put(hiVar.a(), Float.valueOf(field.getFloat(obj)));
                    return;
                case 4:
                    contentValues.put(hiVar.a(), Double.valueOf(field.getDouble(obj)));
                    return;
                case 5:
                    contentValues.put(hiVar.a(), Long.valueOf(field.getLong(obj)));
                    return;
                case 6:
                    contentValues.put(hiVar.a(), (String) field.get(obj));
                    return;
                case 7:
                    try {
                        contentValues.put(hiVar.a(), (byte[]) field.get(obj));
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

    private ContentValues a(Object obj, hh hhVar) {
        ContentValues contentValues = new ContentValues();
        Field[] a2 = a(obj.getClass(), hhVar.b());
        for (Field field : a2) {
            field.setAccessible(true);
            a(obj, field, contentValues);
        }
        return contentValues;
    }

    private Field[] a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        if (z) {
            return cls.getSuperclass().getDeclaredFields();
        }
        return cls.getDeclaredFields();
    }

    private SQLiteDatabase a(boolean z) {
        try {
            if (this.b == null) {
                this.b = this.a.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (!z) {
                ha.a(th, "dbs", "grd");
            } else {
                th.printStackTrace();
            }
        }
        return this.b;
    }

    private <T> String a(hh hhVar) {
        if (hhVar == null) {
            return null;
        }
        return hhVar.a();
    }
}
