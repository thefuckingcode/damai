package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.StatConfig;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.User;
import com.tencent.stat.event.Event;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.youku.arch.v3.core.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
public class StatStore {
    private static StatStore instance = null;
    private static StatLogger logger = StatCommonHelper.getLogger();
    Handler handler = null;
    private StatStoreHelper helper;
    private HashMap<String, String> kvMap = new HashMap<>();
    volatile int numStoredEvents = 0;
    User user = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class StatStoreHelper extends SQLiteOpenHelper {
        private static String DATABASE_NAME = "tencent_analysis.db";
        private static int DATABASE_VERSION = 3;

        public StatStoreHelper(Context context) {
            super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, DATABASE_VERSION);
        }

        private void upgradeEventsToVer3(SQLiteDatabase sQLiteDatabase) {
            Cursor query = sQLiteDatabase.query("events", null, null, null, null, null, null);
            ArrayList<StoredEvent> arrayList = new ArrayList();
            while (query.moveToNext()) {
                arrayList.add(new StoredEvent(query.getLong(0), query.getString(1), query.getInt(2), query.getInt(3)));
            }
            ContentValues contentValues = new ContentValues();
            for (StoredEvent storedEvent : arrayList) {
                contentValues.put("content", StatCommonHelper.encode(storedEvent.content));
                sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(storedEvent.id)});
            }
        }

        private void upgradeUserToVer3(SQLiteDatabase sQLiteDatabase) {
            String str;
            Cursor query = sQLiteDatabase.query("user", null, null, null, null, null, null);
            ContentValues contentValues = new ContentValues();
            if (query.moveToNext()) {
                str = query.getString(0);
                query.getInt(1);
                query.getString(2);
                query.getLong(3);
                contentValues.put("uid", StatCommonHelper.encode(str));
            } else {
                str = null;
            }
            if (str != null) {
                sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{str});
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
            sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
            sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            StatLogger statLogger = StatStore.logger;
            statLogger.debug("upgrade DB from oldVersion " + i + " to newVersion " + i2);
            if (i == 1) {
                sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
                upgradeUserToVer3(sQLiteDatabase);
                upgradeEventsToVer3(sQLiteDatabase);
            }
            if (i == 2) {
                upgradeUserToVer3(sQLiteDatabase);
                upgradeEventsToVer3(sQLiteDatabase);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class StoredEvent {
        String content;
        long id;
        int send_count;
        int status;

        public StoredEvent(long j, String str, int i, int i2) {
            this.id = j;
            this.content = str;
            this.status = i;
            this.send_count = i2;
        }
    }

    private StatStore(Context context) {
        try {
            HandlerThread handlerThread = new HandlerThread("StatStore");
            handlerThread.start();
            StatLogger statLogger = logger;
            statLogger.w("Launch store thread:" + handlerThread);
            this.handler = new Handler(handlerThread.getLooper());
            Context applicationContext = context.getApplicationContext();
            StatStoreHelper statStoreHelper = new StatStoreHelper(applicationContext);
            this.helper = statStoreHelper;
            statStoreHelper.getWritableDatabase();
            this.helper.getReadableDatabase();
            getUser(applicationContext);
            loadConfig();
            loadKeyValues();
            this.handler.post(new Runnable() {
                /* class com.tencent.stat.StatStore.AnonymousClass1 */

                public void run() {
                    StatStore.this.loadUnsentEventCount();
                }
            });
        } catch (Throwable th) {
            logger.e(th);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void directDeleteEvents(List<StoredEvent> list) {
        logger.i("Delete " + list.size() + " sent events in thread:" + Thread.currentThread());
        try {
            this.helper.getWritableDatabase().beginTransaction();
            Iterator<StoredEvent> it = list.iterator();
            while (it.hasNext()) {
                this.numStoredEvents -= this.helper.getWritableDatabase().delete("events", "event_id = ?", new String[]{Long.toString(it.next().id)});
            }
            this.helper.getWritableDatabase().setTransactionSuccessful();
            this.numStoredEvents = (int) DatabaseUtils.queryNumEntries(this.helper.getReadableDatabase(), "events");
            try {
                this.helper.getWritableDatabase().endTransaction();
            } catch (SQLiteException e) {
                logger.e((Exception) e);
            }
        } catch (SQLiteException e2) {
            logger.e((Exception) e2);
            this.helper.getWritableDatabase().endTransaction();
        } catch (Throwable th) {
            try {
                this.helper.getWritableDatabase().endTransaction();
            } catch (SQLiteException e3) {
                logger.e((Exception) e3);
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void directUpdateEvents(List<StoredEvent> list, int i) {
        logger.i("Update " + list.size() + " sending events to status:" + i + " in thread:" + Thread.currentThread());
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.toString(i));
            this.helper.getWritableDatabase().beginTransaction();
            for (StoredEvent storedEvent : list) {
                if (storedEvent.send_count + 1 > StatConfig.getMaxSendRetryCount()) {
                    this.numStoredEvents -= this.helper.getWritableDatabase().delete("events", "event_id=?", new String[]{Long.toString(storedEvent.id)});
                } else {
                    contentValues.put("send_count", Integer.valueOf(storedEvent.send_count + 1));
                    logger.i("Update event:" + storedEvent.id + " for content:" + contentValues);
                    int update = this.helper.getWritableDatabase().update("events", contentValues, "event_id=?", new String[]{Long.toString(storedEvent.id)});
                    if (update <= 0) {
                        logger.e("Failed to update db, error code:" + Integer.toString(update));
                    }
                }
            }
            this.helper.getWritableDatabase().setTransactionSuccessful();
            this.numStoredEvents = (int) DatabaseUtils.queryNumEntries(this.helper.getReadableDatabase(), "events");
            try {
                this.helper.getWritableDatabase().endTransaction();
            } catch (SQLiteException e) {
                logger.e((Exception) e);
            }
        } catch (SQLiteException e2) {
            logger.e((Exception) e2);
            this.helper.getWritableDatabase().endTransaction();
        } catch (Throwable th) {
            try {
                this.helper.getWritableDatabase().endTransaction();
            } catch (SQLiteException e3) {
                logger.e((Exception) e3);
            }
            throw th;
        }
    }

    public static StatStore getInstance() {
        return instance;
    }

    public static StatStore getInstance(Context context) {
        if (instance == null) {
            instance = new StatStore(context);
        }
        return instance;
    }

    private void loadKeyValues() {
        Cursor cursor = null;
        try {
            cursor = this.helper.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                this.kvMap.put(cursor.getString(0), cursor.getString(1));
            }
        } catch (SQLiteException e) {
            logger.e((Exception) e);
            if (0 == 0) {
                return;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadUnsentEventCount() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        this.helper.getWritableDatabase().update("events", contentValues, "status=?", new String[]{Long.toString(2)});
        this.numStoredEvents = (int) DatabaseUtils.queryNumEntries(this.helper.getReadableDatabase(), "events");
        StatLogger statLogger = logger;
        statLogger.i("Total " + this.numStoredEvents + " unsent events.");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void peekEvents(List<StoredEvent> list, int i) {
        Cursor cursor = null;
        try {
            cursor = this.helper.getReadableDatabase().query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, UTDataCollectorNodeColumn.EVENT_ID, Integer.toString(i));
            while (cursor.moveToNext()) {
                list.add(new StoredEvent(cursor.getLong(0), StatCommonHelper.decode(cursor.getString(1)), cursor.getInt(2), cursor.getInt(3)));
            }
        } catch (SQLiteException e) {
            logger.e((Exception) e);
            if (0 == 0) {
                return;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    /* access modifiers changed from: package-private */
    public void deleteEvents(final List<StoredEvent> list) {
        try {
            if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
                directDeleteEvents(list);
            } else {
                this.handler.post(new Runnable() {
                    /* class com.tencent.stat.StatStore.AnonymousClass3 */

                    public void run() {
                        StatStore.this.directDeleteEvents(list);
                    }
                });
            }
        } catch (SQLiteException e) {
            logger.e((Exception) e);
        }
    }

    /* access modifiers changed from: package-private */
    public void directStoreEvent(Event event, StatDispatchCallback statDispatchCallback) {
        if (StatConfig.getMaxStoreEventCount() > 0) {
            if (this.numStoredEvents > StatConfig.getMaxStoreEventCount()) {
                logger.warn("Too many events stored in db.");
                this.numStoredEvents -= this.helper.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
            }
            ContentValues contentValues = new ContentValues();
            String encode = StatCommonHelper.encode(event.toJsonString());
            contentValues.put("content", encode);
            contentValues.put("send_count", "0");
            contentValues.put("status", Integer.toString(1));
            contentValues.put("timestamp", Long.valueOf(event.getTimestamp()));
            if (this.helper.getWritableDatabase().insert("events", null, contentValues) == -1) {
                logger.error("Failed to store event:" + encode);
                return;
            }
            this.numStoredEvents++;
            if (statDispatchCallback != null) {
                statDispatchCallback.onDispatchSuccess();
            }
        }
    }

    public int getNumStoredEvents() {
        return this.numStoredEvents;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01a7 A[DONT_GENERATE] */
    public User getUser(Context context) {
        Cursor cursor;
        Object th;
        boolean z;
        String str;
        String str2;
        boolean z2;
        boolean z3;
        String str3;
        boolean z4;
        String deviceID;
        User user2 = this.user;
        if (user2 != null) {
            return user2;
        }
        try {
            Cursor query = this.helper.getReadableDatabase().query("user", null, null, null, null, null, null, null);
            try {
                if (query.moveToNext()) {
                    String string = query.getString(0);
                    String decode = StatCommonHelper.decode(string);
                    int i = query.getInt(1);
                    String string2 = query.getString(2);
                    long j = query.getLong(3);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    int i2 = (i == 1 || StatCommonHelper.getDateFormat(j * 1000).equals(StatCommonHelper.getDateFormat(currentTimeMillis * 1000))) ? i : 1;
                    if (!string2.equals(StatCommonHelper.getAppVersion(context))) {
                        i2 |= 2;
                    }
                    String[] split = decode.split(",");
                    if (split == null || split.length <= 0) {
                        decode = StatCommonHelper.getUserID(context);
                        str2 = decode;
                    } else {
                        str2 = split[0];
                        if ((str2 == null || str2.length() < 11) && (deviceID = StatCommonHelper.getDeviceID(context)) != null && deviceID.length() > 10) {
                            str2 = deviceID;
                        } else {
                            z2 = false;
                            if (split == null) {
                                z4 = z2;
                                if (split.length >= 2) {
                                    str3 = split[1];
                                    decode = str2 + "," + str3;
                                    z3 = z4;
                                    this.user = new User(str2, str3, i2);
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("uid", StatCommonHelper.encode(decode));
                                    contentValues.put("user_type", Integer.valueOf(i2));
                                    contentValues.put("app_ver", StatCommonHelper.getAppVersion(context));
                                    contentValues.put("ts", Long.valueOf(currentTimeMillis));
                                    if (!z3) {
                                        z = true;
                                        this.helper.getWritableDatabase().update("user", contentValues, "uid=?", new String[]{string});
                                    } else {
                                        z = true;
                                    }
                                    if (i2 != i) {
                                        this.helper.getWritableDatabase().replace("user", null, contentValues);
                                    }
                                }
                            } else {
                                z4 = z2;
                            }
                            str3 = StatCommonHelper.getMacId(context);
                            if (str3 != null && str3.length() > 0) {
                                decode = str2 + "," + str3;
                                z3 = true;
                                this.user = new User(str2, str3, i2);
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("uid", StatCommonHelper.encode(decode));
                                contentValues2.put("user_type", Integer.valueOf(i2));
                                contentValues2.put("app_ver", StatCommonHelper.getAppVersion(context));
                                contentValues2.put("ts", Long.valueOf(currentTimeMillis));
                                if (!z3) {
                                }
                                if (i2 != i) {
                                }
                            }
                            z3 = z4;
                            this.user = new User(str2, str3, i2);
                            ContentValues contentValues22 = new ContentValues();
                            contentValues22.put("uid", StatCommonHelper.encode(decode));
                            contentValues22.put("user_type", Integer.valueOf(i2));
                            contentValues22.put("app_ver", StatCommonHelper.getAppVersion(context));
                            contentValues22.put("ts", Long.valueOf(currentTimeMillis));
                            if (!z3) {
                            }
                            if (i2 != i) {
                            }
                        }
                    }
                    z2 = true;
                    if (split == null) {
                    }
                    str3 = StatCommonHelper.getMacId(context);
                    decode = str2 + "," + str3;
                    z3 = true;
                    this.user = new User(str2, str3, i2);
                    ContentValues contentValues222 = new ContentValues();
                    contentValues222.put("uid", StatCommonHelper.encode(decode));
                    contentValues222.put("user_type", Integer.valueOf(i2));
                    contentValues222.put("app_ver", StatCommonHelper.getAppVersion(context));
                    contentValues222.put("ts", Long.valueOf(currentTimeMillis));
                    if (!z3) {
                    }
                    if (i2 != i) {
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    String userID = StatCommonHelper.getUserID(context);
                    String macId = StatCommonHelper.getMacId(context);
                    if (macId == null || macId.length() <= 0) {
                        str = userID;
                    } else {
                        str = userID + "," + macId;
                    }
                    String appVersion = StatCommonHelper.getAppVersion(context);
                    ContentValues contentValues3 = new ContentValues();
                    contentValues3.put("uid", StatCommonHelper.encode(str));
                    contentValues3.put("user_type", (Integer) 0);
                    contentValues3.put("app_ver", appVersion);
                    contentValues3.put("ts", Long.valueOf(System.currentTimeMillis() / 1000));
                    this.helper.getWritableDatabase().insert("user", null, contentValues3);
                    this.user = new User(userID, macId, 0);
                }
                query.close();
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                try {
                    logger.e(th);
                    return this.user;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            logger.e(th);
            return this.user;
        }
        return this.user;
    }

    /* access modifiers changed from: package-private */
    public void loadConfig() {
        this.handler.post(new Runnable() {
            /* class com.tencent.stat.StatStore.AnonymousClass6 */

            public void run() {
                Cursor cursor = null;
                try {
                    cursor = StatStore.this.helper.getReadableDatabase().query(Constants.CONFIG, null, null, null, null, null, null);
                    while (cursor.moveToNext()) {
                        int i = cursor.getInt(0);
                        String string = cursor.getString(1);
                        String string2 = cursor.getString(2);
                        int i2 = cursor.getInt(3);
                        StatConfig.OnlineConfig onlineConfig = new StatConfig.OnlineConfig(i);
                        onlineConfig.type = i;
                        onlineConfig.props = new JSONObject(string);
                        onlineConfig.md5sum = string2;
                        onlineConfig.version = i2;
                        StatConfig.setConfig(onlineConfig);
                    }
                } catch (Exception e) {
                    StatStore.logger.e(e);
                    if (0 == 0) {
                        return;
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th;
                }
                cursor.close();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void loadEvents(final int i) {
        this.handler.post(new Runnable() {
            /* class com.tencent.stat.StatStore.AnonymousClass7 */

            public void run() {
                if (StatStore.this.numStoredEvents != 0) {
                    StatStore.logger.i("Load " + Integer.toString(StatStore.this.numStoredEvents) + " unsent events");
                    ArrayList arrayList = new ArrayList();
                    final ArrayList<StoredEvent> arrayList2 = new ArrayList();
                    final int i = i;
                    if (i == -1 || i > StatConfig.getMaxLoadEventCount()) {
                        i = StatConfig.getMaxLoadEventCount();
                    }
                    StatStore.this.numStoredEvents -= i;
                    StatStore.this.peekEvents(arrayList2, i);
                    StatStore.logger.i("Peek " + Integer.toString(arrayList2.size()) + " unsent events.");
                    if (!arrayList2.isEmpty()) {
                        StatStore.this.directUpdateEvents(arrayList2, 2);
                        for (StoredEvent storedEvent : arrayList2) {
                            arrayList.add(storedEvent.content);
                        }
                        StatDispatcher.getInstance().send(arrayList, new StatDispatchCallback() {
                            /* class com.tencent.stat.StatStore.AnonymousClass7.AnonymousClass1 */

                            @Override // com.tencent.stat.StatDispatchCallback
                            public void onDispatchFailure() {
                                StatStore.this.numStoredEvents += i;
                                StatStore.this.updateEvents(arrayList2, 1);
                            }

                            @Override // com.tencent.stat.StatDispatchCallback
                            public void onDispatchSuccess() {
                                StatStore.this.deleteEvents(arrayList2);
                                int i = i;
                                if (i != -1) {
                                    i -= arrayList2.size();
                                }
                                if (i == -1 || i > 0) {
                                    StatStore.this.loadEvents(i);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void storeCfg(final StatConfig.OnlineConfig onlineConfig) {
        if (onlineConfig != null) {
            try {
                this.handler.post(new Runnable() {
                    /* class com.tencent.stat.StatStore.AnonymousClass5 */

                    /* JADX WARNING: Removed duplicated region for block: B:20:0x007b  */
                    /* JADX WARNING: Removed duplicated region for block: B:24:0x0083  */
                    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2  */
                    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ca  */
                    /* JADX WARNING: Removed duplicated region for block: B:29:0x00dd  */
                    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f4  */
                    public void run() {
                        Throwable th;
                        boolean z;
                        long j;
                        int i;
                        StringBuilder sb;
                        Exception e;
                        Cursor cursor;
                        String jsonString = onlineConfig.toJsonString();
                        String md5sum = StatCommonHelper.md5sum(jsonString);
                        if (!md5sum.equals(onlineConfig.md5sum)) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("content", onlineConfig.props.toString());
                            contentValues.put("md5sum", md5sum);
                            StatConfig.OnlineConfig onlineConfig = onlineConfig;
                            onlineConfig.md5sum = md5sum;
                            contentValues.put("version", Integer.valueOf(onlineConfig.version));
                            Cursor cursor2 = null;
                            try {
                                cursor = StatStore.this.helper.getReadableDatabase().query(Constants.CONFIG, null, null, null, null, null, null);
                                while (true) {
                                    try {
                                        if (cursor.moveToNext()) {
                                            if (cursor.getInt(0) == onlineConfig.type) {
                                                z = true;
                                                break;
                                            }
                                        } else {
                                            z = false;
                                            break;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        try {
                                            StatStore.logger.e(e);
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            z = false;
                                            if (true == z) {
                                            }
                                            i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
                                            StatLogger statLogger = StatStore.logger;
                                            if (i == 0) {
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor2 = cursor;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            throw th;
                                        }
                                    }
                                }
                                cursor.close();
                            } catch (Exception e3) {
                                e = e3;
                                cursor = null;
                                StatStore.logger.e(e);
                                if (cursor != null) {
                                }
                                z = false;
                                if (true == z) {
                                }
                                i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
                                StatLogger statLogger2 = StatStore.logger;
                                if (i == 0) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (cursor2 != null) {
                                }
                                throw th;
                            }
                            if (true == z) {
                                j = (long) StatStore.this.helper.getWritableDatabase().update(Constants.CONFIG, contentValues, "type=?", new String[]{Integer.toString(onlineConfig.type)});
                            } else {
                                contentValues.put("type", Integer.valueOf(onlineConfig.type));
                                j = StatStore.this.helper.getWritableDatabase().insert(Constants.CONFIG, null, contentValues);
                            }
                            i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
                            StatLogger statLogger22 = StatStore.logger;
                            if (i == 0) {
                                sb.append("Failed to store cfg:");
                                sb.append(jsonString);
                                statLogger22.error(sb.toString());
                                return;
                            }
                            sb = new StringBuilder();
                            sb.append("Sucessed to store cfg:");
                            sb.append(jsonString);
                            statLogger22.i(sb.toString());
                        }
                    }
                });
            } catch (Exception e) {
                logger.e(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void storeEvent(final Event event, final StatDispatchCallback statDispatchCallback) {
        if (StatConfig.isEnableStatService()) {
            try {
                if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
                    directStoreEvent(event, statDispatchCallback);
                } else {
                    this.handler.post(new Runnable() {
                        /* class com.tencent.stat.StatStore.AnonymousClass4 */

                        public void run() {
                            StatStore.this.directStoreEvent(event, statDispatchCallback);
                        }
                    });
                }
            } catch (SQLiteException e) {
                logger.e((Exception) e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateEvents(final List<StoredEvent> list, final int i) {
        try {
            if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
                directUpdateEvents(list, i);
            } else {
                this.handler.post(new Runnable() {
                    /* class com.tencent.stat.StatStore.AnonymousClass2 */

                    public void run() {
                        StatStore.this.directUpdateEvents(list, i);
                    }
                });
            }
        } catch (SQLiteException e) {
            logger.e((Exception) e);
        }
    }
}
