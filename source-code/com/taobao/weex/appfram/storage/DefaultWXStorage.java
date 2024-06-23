package com.taobao.weex.appfram.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteStatement;
import androidx.annotation.Nullable;
import com.taobao.weex.appfram.storage.IWXStorageAdapter;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.jl1;
import tb.ve2;

/* compiled from: Taobao */
public class DefaultWXStorage implements IWXStorageAdapter {
    private a a;
    private ExecutorService b;

    public DefaultWXStorage(Context context) {
        this.a = new a(context);
    }

    private void g(@Nullable Runnable runnable) {
        if (this.b == null) {
            this.b = Executors.newSingleThreadExecutor();
        }
        if (runnable != null && !this.b.isShutdown() && !this.b.isTerminated()) {
            this.b.execute(WXThread.secure(runnable));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<String> h() {
        SQLiteDatabase database = this.a.getDatabase();
        if (database == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor query = database.query("default_wx_storage", new String[]{"key"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(query.getString(query.getColumnIndex("key")));
            } catch (Exception e) {
                WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getAllKeys:" + e.getMessage());
                return arrayList;
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String i(String str) {
        SQLiteDatabase database = this.a.getDatabase();
        if (database == null) {
            return null;
        }
        Cursor query = database.query("default_wx_storage", new String[]{"value"}, "key=?", new String[]{str}, null, null, null);
        try {
            if (query.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("timestamp", a.d.format(new Date()));
                int update = this.a.getDatabase().update("default_wx_storage", contentValues, "key= ?", new String[]{str});
                StringBuilder sb = new StringBuilder();
                sb.append("update timestamp ");
                sb.append(update == 1 ? "success" : "failed");
                sb.append(" for operation [getItem(key = ");
                sb.append(str);
                sb.append(")]");
                WXLogUtils.d("weex_storage", sb.toString());
                return query.getString(query.getColumnIndex("value"));
            }
            query.close();
            return null;
        } catch (Exception e) {
            WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getItem:" + e.getMessage());
            return null;
        } finally {
            query.close();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long j() {
        SQLiteDatabase database = this.a.getDatabase();
        if (database == null) {
            return 0;
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = database.compileStatement("SELECT count(key) FROM default_wx_storage");
            long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
            sQLiteStatement.close();
            return simpleQueryForLong;
        } catch (Exception e) {
            WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getLength:" + e.getMessage());
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            return 0;
        } catch (Throwable th) {
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean k(String str) {
        SQLiteDatabase database = this.a.getDatabase();
        if (database == null) {
            return false;
        }
        try {
            if (database.delete("default_wx_storage", "key=?", new String[]{str}) == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute removeItem:" + e.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean l(String str, String str2, boolean z, boolean z2) {
        SQLiteDatabase database = this.a.getDatabase();
        if (database == null) {
            return false;
        }
        WXLogUtils.d("weex_storage", "set k-v to storage(key:" + str + ",value:" + str2 + ",isPersistent:" + z + ",allowRetry:" + z2 + jl1.BRACKET_END_STR);
        SQLiteStatement sQLiteStatement = null;
        String format = a.d.format(new Date());
        try {
            SQLiteStatement compileStatement = database.compileStatement("INSERT OR REPLACE INTO default_wx_storage VALUES (?,?,?,?);");
            compileStatement.clearBindings();
            compileStatement.bindString(1, str);
            compileStatement.bindString(2, str2);
            compileStatement.bindString(3, format);
            compileStatement.bindLong(4, z ? 1 : 0);
            compileStatement.execute();
            compileStatement.close();
            return true;
        } catch (Exception e) {
            WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute setItem :" + e.getMessage());
            if (!(e instanceof SQLiteFullException) || !z2 || !m()) {
                if (0 != 0) {
                    sQLiteStatement.close();
                }
                return false;
            }
            WXLogUtils.d("weex_storage", "retry set k-v to storage(key:" + str + ",value:" + str2 + jl1.BRACKET_END_STR);
            boolean l = l(str, str2, z, false);
            if (0 != 0) {
                sQLiteStatement.close();
            }
            return l;
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteStatement.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007b  */
    private boolean m() {
        int i;
        Exception e;
        SQLiteDatabase database = this.a.getDatabase();
        if (database == null) {
            return false;
        }
        ArrayList<String> arrayList = new ArrayList();
        Cursor query = database.query("default_wx_storage", new String[]{"key", "persistent"}, null, null, null, null, "timestamp ASC");
        try {
            int count = query.getCount() / 10;
            i = 0;
            while (query.moveToNext()) {
                try {
                    String string = query.getString(query.getColumnIndex("key"));
                    if (!(query.getInt(query.getColumnIndex("persistent")) == 1) && string != null) {
                        i++;
                        arrayList.add(string);
                        if (i == count) {
                            break;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute trimToSize:" + e.getMessage());
                        query.close();
                        if (i <= 0) {
                        }
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
            WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute trimToSize:" + e.getMessage());
            query.close();
            if (i <= 0) {
            }
        }
        query.close();
        if (i <= 0) {
            return false;
        }
        for (String str : arrayList) {
            k(str);
        }
        WXLogUtils.e("weex_storage", "remove " + i + " items by lru");
        return true;
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void close() {
        final ExecutorService executorService = this.b;
        g(new Runnable() {
            /* class com.taobao.weex.appfram.storage.DefaultWXStorage.AnonymousClass7 */

            public void run() {
                try {
                    DefaultWXStorage.this.a.a();
                    ExecutorService executorService = executorService;
                    if (executorService != null) {
                        executorService.shutdown();
                    }
                } catch (Exception e) {
                    WXLogUtils.e("weex_storage", e.getMessage());
                }
            }
        });
        this.b = null;
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void getAllKeys(final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() {
            /* class com.taobao.weex.appfram.storage.DefaultWXStorage.AnonymousClass5 */

            public void run() {
                Map<String, Object> a = ve2.a(DefaultWXStorage.this.h());
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener = onResultReceivedListener;
                if (onResultReceivedListener != null) {
                    onResultReceivedListener.onReceived(a);
                }
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void getItem(final String str, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() {
            /* class com.taobao.weex.appfram.storage.DefaultWXStorage.AnonymousClass2 */

            public void run() {
                Map<String, Object> b = ve2.b(DefaultWXStorage.this.i(str));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener = onResultReceivedListener;
                if (onResultReceivedListener != null) {
                    onResultReceivedListener.onReceived(b);
                }
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void length(final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() {
            /* class com.taobao.weex.appfram.storage.DefaultWXStorage.AnonymousClass4 */

            public void run() {
                Map<String, Object> c = ve2.c(DefaultWXStorage.this.j());
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener = onResultReceivedListener;
                if (onResultReceivedListener != null) {
                    onResultReceivedListener.onReceived(c);
                }
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void removeItem(final String str, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() {
            /* class com.taobao.weex.appfram.storage.DefaultWXStorage.AnonymousClass3 */

            public void run() {
                Map<String, Object> g = ve2.g(DefaultWXStorage.this.k(str));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener = onResultReceivedListener;
                if (onResultReceivedListener != null) {
                    onResultReceivedListener.onReceived(g);
                }
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void setItem(final String str, final String str2, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() {
            /* class com.taobao.weex.appfram.storage.DefaultWXStorage.AnonymousClass1 */

            public void run() {
                Map<String, Object> h = ve2.h(DefaultWXStorage.this.l(str, str2, false, true));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener = onResultReceivedListener;
                if (onResultReceivedListener != null) {
                    onResultReceivedListener.onReceived(h);
                }
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void setItemPersistent(final String str, final String str2, final IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        g(new Runnable() {
            /* class com.taobao.weex.appfram.storage.DefaultWXStorage.AnonymousClass6 */

            public void run() {
                Map<String, Object> h = ve2.h(DefaultWXStorage.this.l(str, str2, true, true));
                IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener = onResultReceivedListener;
                if (onResultReceivedListener != null) {
                    onResultReceivedListener.onReceived(h);
                }
            }
        });
    }
}
