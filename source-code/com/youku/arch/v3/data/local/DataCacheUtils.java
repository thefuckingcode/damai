package com.youku.arch.v3.data.local;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\nR\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/youku/arch/v3/data/local/DataCacheUtils;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "type", "", "Lcom/youku/arch/v3/data/local/Item;", "getCacheByType", "getAllCaches", "", "id", "getCacheById", "item", "", RemoteMessageConst.Notification.CHANNEL_ID, "", "updateCache", "removeCacheByType", "removeCacheById", "time", "removeCacheByTime", "TAG", "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", "uri", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class DataCacheUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final DataCacheUtils INSTANCE = new DataCacheUtils();
    @NotNull
    private static final String TAG = "OneArch.DataCacheUtils";

    private DataCacheUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0095, code lost:
        if (r0 != null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0098, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b2, code lost:
        if (0 == 0) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b4, code lost:
        return r1;
     */
    private final List<Item> getCacheByType(Context context, String str) {
        int count;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-360103862")) {
            return (List) ipChange.ipc$dispatch("-360103862", new Object[]{this, context, str});
        }
        Uri parse = Uri.parse(getUri());
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            ContentResolver contentResolver = context.getContentResolver();
            cursor = contentResolver.query(parse, null, "type='" + str + '\'', null, "timestamp desc");
            if (cursor != null && cursor.moveToFirst() && (count = cursor.getCount()) > 0) {
                int i = 0;
                do {
                    i++;
                    Item item = new Item();
                    item.id = Long.valueOf(cursor.getLong(0));
                    item.type = cursor.getString(1);
                    item.content = cursor.getString(2);
                    item.time = Long.valueOf(cursor.getLong(3));
                    item.expire = Long.valueOf(cursor.getLong(4));
                    arrayList.add(item);
                    cursor.moveToNext();
                } while (i < count);
            }
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(TAG, e.getMessage());
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final String getUri() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "822268612")) {
            return (String) ipChange.ipc$dispatch("822268612", new Object[]{this});
        }
        Context appContext = AppInfoProviderProxy.getAppContext();
        if (appContext == null) {
            return "content://com.taobao.movie.android.com.youku.arch.data/data_cache";
        }
        return "content://" + ((Object) appContext.getPackageName()) + ".com.youku.arch.data/data_cache";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0084, code lost:
        if (r0 != null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0087, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a1, code lost:
        if (0 == 0) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a3, code lost:
        return r1;
     */
    @NotNull
    public final List<Item> getAllCaches(@NotNull Context context) {
        int count;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2132862997")) {
            return (List) ipChange.ipc$dispatch("2132862997", new Object[]{this, context});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Uri parse = Uri.parse(getUri());
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = context.getContentResolver().query(parse, null, null, new String[0], "timestamp desc");
            if (cursor != null && cursor.moveToFirst() && (count = cursor.getCount()) > 0) {
                int i = 0;
                do {
                    i++;
                    Item item = new Item();
                    item.id = Long.valueOf(cursor.getLong(0));
                    item.type = cursor.getString(1);
                    item.content = cursor.getString(2);
                    item.time = Long.valueOf(cursor.getLong(3));
                    item.expire = Long.valueOf(cursor.getLong(4));
                    arrayList.add(item);
                    cursor.moveToNext();
                } while (i < count);
            }
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(TAG, e.getMessage());
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a1, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a4, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d0, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a0 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b8 A[Catch:{ all -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d0  */
    @Nullable
    public final Item getCacheById(@NotNull Context context, long j) {
        Item item;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1386735954")) {
            return (Item) ipChange.ipc$dispatch("1386735954", new Object[]{this, context, Long.valueOf(j)});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Cursor cursor = null;
        r1 = null;
        Item item2 = null;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(getUri()), new String[0], "_id='" + j + '\'', new String[0], "timestamp desc");
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        item = new Item();
                        item.id = Long.valueOf(query.getLong(0));
                        item.type = query.getString(1);
                        item.content = query.getString(2);
                        item.time = Long.valueOf(query.getLong(3));
                        item.expire = Long.valueOf(query.getLong(4));
                        item.retMsg = query.getString(6);
                        item.retCode = query.getString(5);
                        item2 = item;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        if (AppInfoProviderProxy.isDebuggable()) {
                        }
                        if (cursor != null) {
                        }
                        return item;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        if (cursor != null) {
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                }
            }
            if (query == null) {
                return item2;
            }
            query.close();
            return item2;
        } catch (Exception e3) {
            e = e3;
            item = null;
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(TAG, e.getMessage());
            }
            if (cursor != null) {
                cursor.close();
            }
            return item;
        }
    }

    public final int removeCacheById(@NotNull Context context, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1634604503")) {
            return ((Integer) ipChange.ipc$dispatch("1634604503", new Object[]{this, context, Long.valueOf(j)})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Uri parse = Uri.parse(getUri());
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return contentResolver.delete(parse, "(_id='" + j + "')", new String[0]);
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(TAG, e.getMessage());
            }
            return -1;
        }
    }

    public final int removeCacheByTime(@NotNull Context context, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011909093")) {
            return ((Integer) ipChange.ipc$dispatch("1011909093", new Object[]{this, context, Long.valueOf(j)})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Uri parse = Uri.parse(getUri());
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return contentResolver.delete(parse, "(timestamp<'" + j + "')", new String[0]);
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(TAG, e.getMessage());
            }
            return -1;
        }
    }

    @Nullable
    public final List<Long> removeCacheByType(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866728222")) {
            return (List) ipChange.ipc$dispatch("866728222", new Object[]{this, context, str});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "type");
        ArrayList arrayList = null;
        List<Item> cacheByType = getCacheByType(context, str);
        if (!cacheByType.isEmpty()) {
            arrayList = new ArrayList(cacheByType.size());
            for (Item item : cacheByType) {
                Long l = item.id;
                k21.h(l, "item.id");
                if (removeCacheById(context, l.longValue()) > 0) {
                    Long l2 = item.id;
                    k21.h(l2, "item.id");
                    arrayList.add(l2);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0107 A[Catch:{ all -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0162 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0164 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x016a  */
    public final boolean updateCache(@NotNull Context context, @NotNull Item item, int i) {
        Cursor cursor;
        Throwable th;
        boolean z;
        int i2;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "859781822")) {
            return ((Boolean) ipChange.ipc$dispatch("859781822", new Object[]{this, context, item, Integer.valueOf(i)})).booleanValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(item, "item");
        Uri parse = Uri.parse(getUri());
        try {
            cursor = context.getContentResolver().query(parse, new String[0], "(_id='" + item.id + "')", new String[0], "timestamp desc");
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        try {
                            long j = cursor.getLong(3);
                            Long l = item.time;
                            k21.h(l, "item.time");
                            if (l.longValue() > j) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("content", item.content);
                                contentValues.put("timestamp", item.time);
                                contentValues.put("expire", item.expire);
                                contentValues.put("ret_code", item.retCode);
                                contentValues.put("ret_msg", item.retMsg);
                                if (!TextUtils.isEmpty(item.type)) {
                                    contentValues.put("type", item.type);
                                }
                                contentValues.put("channel", Integer.valueOf(i));
                                ContentResolver contentResolver = context.getContentResolver();
                                i2 = contentResolver.update(parse, contentValues, "(_id='" + item.id + "')", new String[0]);
                            } else {
                                i2 = 0;
                            }
                            z = false;
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            z = false;
                            try {
                                if (AppInfoProviderProxy.isDebuggable()) {
                                }
                                if (cursor != null) {
                                }
                                i2 = 0;
                                if (z) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                        if (z) {
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("_id", item.id);
                            contentValues2.put("type", item.type);
                            contentValues2.put("content", item.content);
                            contentValues2.put("timestamp", item.time);
                            contentValues2.put("expire", item.expire);
                            contentValues2.put("ret_code", item.retCode);
                            contentValues2.put("ret_msg", item.retMsg);
                            contentValues2.put("channel", Integer.valueOf(i));
                            try {
                                return context.getContentResolver().insert(parse, contentValues2) != null;
                            } catch (Exception unused) {
                            }
                        } else if (i2 > 0) {
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = true;
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.e(TAG, e.getMessage());
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    i2 = 0;
                    if (z) {
                    }
                }
            }
            i2 = 0;
            z = true;
            if (cursor != null) {
            }
        } catch (Exception e4) {
            e = e4;
            z = true;
            cursor = null;
            if (AppInfoProviderProxy.isDebuggable()) {
            }
            if (cursor != null) {
            }
            i2 = 0;
            if (z) {
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (z) {
        }
    }
}
