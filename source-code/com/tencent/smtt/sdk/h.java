package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.Progress;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SqliteDataManager */
public class h {
    public static final String a = CookieManager.LOGTAG;
    static File b;

    public static File a(Context context) {
        if (b == null && context != null) {
            b = new File(context.getDir("webview", 0), "Cookies");
        }
        if (b == null) {
            b = new File("/data/data/" + context.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
        }
        return b;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        f.a(a(context), false);
        return true;
    }

    public static SQLiteDatabase c(Context context) {
        File a2;
        SQLiteDatabase sQLiteDatabase = null;
        if (context == null || (a2 = a(context)) == null) {
            return null;
        }
        try {
            sQLiteDatabase = SQLiteDatabase.openDatabase(a2.getAbsolutePath(), null, 0);
        } catch (Exception unused) {
        }
        if (sQLiteDatabase == null) {
            TbsLog.i(a, "dbPath is not exist!");
        }
        return sQLiteDatabase;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r4.isOpen() != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r4.isOpen() != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        r4.close();
     */
    public static ArrayList<String> a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        if (sQLiteDatabase == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
            if (rawQuery.moveToFirst()) {
                do {
                    String string = rawQuery.getString(1);
                    rawQuery.getString(4);
                    arrayList.add(string);
                    a(sQLiteDatabase, string);
                } while (rawQuery.moveToNext());
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (sQLiteDatabase != null) {
            }
        } catch (Throwable unused) {
            if (0 != 0) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
            }
        }
        return arrayList;
    }

    private static String a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        int count = rawQuery.getCount();
        int columnCount = rawQuery.getColumnCount();
        StringBuilder sb = new StringBuilder();
        sb.append("raws:" + count + ",columns:" + columnCount + "\n");
        if (count <= 0 || !rawQuery.moveToFirst()) {
            return sb.toString();
        }
        do {
            sb.append("\n");
            for (int i = 0; i < columnCount; i++) {
                try {
                    sb.append(rawQuery.getString(i));
                    sb.append(",");
                } catch (Exception unused) {
                }
            }
            sb.append("\n");
        } while (rawQuery.moveToNext());
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        if (r4.isOpen() != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0068, code lost:
        if (r4.isOpen() != false) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0064  */
    public static int d(Context context) {
        SQLiteDatabase sQLiteDatabase;
        System.currentTimeMillis();
        int i = 0;
        Cursor cursor = null;
        try {
            sQLiteDatabase = c(context);
            if (sQLiteDatabase == null) {
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                return -1;
            }
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select * from meta", null);
                int count = rawQuery.getCount();
                rawQuery.getColumnCount();
                if (count > 0 && rawQuery.moveToFirst()) {
                    while (true) {
                        if (!rawQuery.getString(0).equals("version")) {
                            if (!rawQuery.moveToNext()) {
                                break;
                            }
                        } else {
                            i = Integer.parseInt(rawQuery.getString(1));
                            break;
                        }
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (sQLiteDatabase != null) {
                }
            } catch (Throwable unused) {
                if (0 != 0) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                }
                return i;
            }
            return i;
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
            if (0 != 0) {
            }
            if (sQLiteDatabase != null) {
            }
            return i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ba, code lost:
        if (r0.isOpen() != false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bc, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e6, code lost:
        if (r0.isOpen() != false) goto L_0x00bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ef A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0  */
    public static void a(Context context, CookieManager.a aVar, String str, boolean z, boolean z2) {
        String[] split;
        SQLiteDatabase c;
        if (context != null) {
            if ((aVar != CookieManager.a.MODE_KEYS || !TextUtils.isEmpty(str)) && (split = str.split(",")) != null && split.length >= 1 && (c = c(context)) != null) {
                HashMap hashMap = new HashMap();
                Cursor cursor = null;
                try {
                    Cursor rawQuery = c.rawQuery("select * from cookies", null);
                    if (rawQuery.getCount() <= 0 || !rawQuery.moveToFirst()) {
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        if (c != null) {
                        }
                        if (hashMap.isEmpty()) {
                            b(context);
                            for (Map.Entry entry : hashMap.entrySet()) {
                                CookieManager.getInstance().setCookie((String) entry.getKey(), (String) entry.getValue(), true);
                            }
                            if (Build.VERSION.SDK_INT >= 21) {
                                CookieManager.getInstance().flush();
                            } else {
                                CookieSyncManager.getInstance().sync();
                            }
                            if (z) {
                                a(c(context));
                                int d = d(context);
                                if (d != -1) {
                                    CookieManager.getInstance();
                                    CookieManager.setROMCookieDBVersion(context, d);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    do {
                        String string = rawQuery.getString(rawQuery.getColumnIndex("host_key"));
                        if (aVar == CookieManager.a.MODE_KEYS) {
                            int length = split.length;
                            boolean z3 = false;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    break;
                                } else if (string.equals(split[i])) {
                                    z3 = true;
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (!z3) {
                            }
                        }
                        hashMap.put(string, rawQuery.getString(rawQuery.getColumnIndex("value")) + ";" + rawQuery.getString(rawQuery.getColumnIndex(SerializableCookie.NAME)) + ";" + rawQuery.getInt(rawQuery.getColumnIndex("expires_utc")) + ";" + rawQuery.getInt(rawQuery.getColumnIndex(Progress.PRIORITY)));
                    } while (rawQuery.moveToNext());
                    if (rawQuery != null) {
                    }
                    if (c != null) {
                    }
                    if (hashMap.isEmpty()) {
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    if (c != null && c.isOpen()) {
                        c.close();
                    }
                    throw th;
                }
            }
        }
    }
}
