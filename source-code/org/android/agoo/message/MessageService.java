package org.android.agoo.message;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UTMini;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class MessageService {
    private static final String ACCS_SPACE_NAME = "accs_message";
    private static final String ADD_MESSAGE = "accs.add_agoo_message";
    private static final String BODY_CODE = "body_code";
    private static final String CREATE_TIME = "create_time";
    private static final String DATABASE_NAME = "message_accs_db";
    private static final int DATABASE_VERSION = 3;
    private static final String DEAL_MESSAGE = "accs.dealMessage";
    private static final String ID = "id";
    private static final String MESSAGE = "message";
    private static final String MESSAGE_TARGET_TIME = "target_time";
    private static final String MESSAGE_TARGET_TIME_INTERVAL = "interval";
    public static final String MSG_ACCS_NOTIFY_CLICK = "8";
    public static final String MSG_ACCS_NOTIFY_DISMISS = "9";
    public static final String MSG_ACCS_READY_REPORT = "4";
    public static final String MSG_DB_COMPLETE = "100";
    public static final String MSG_DB_NOTIFY_CLICK = "2";
    public static final String MSG_DB_NOTIFY_DISMISS = "3";
    public static final String MSG_DB_NOTIFY_REACHED = "1";
    public static final String MSG_DB_READY_REPORT = "0";
    private static final int NOTICE = 1;
    private static final String NOTIFY = "notify";
    private static final String REPORT = "report";
    private static final String SPACE_NAME = "message";
    private static final String STATE = "state";
    private static final String TAG = "MessageService";
    private static final String TYPE = "type";
    private static Context mContext;
    private static Map<String, Integer> messageStores;
    private volatile SQLiteOpenHelper sqliteOpenHelper = null;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class MessageDBHelper extends SQLiteOpenHelper {
        public MessageDBHelper(Context context) {
            super(context, MessageService.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 3);
        }

        private String createmMessageTableSQL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table accs_message");
            stringBuffer.append(jl1.BRACKET_START_STR);
            stringBuffer.append("id text UNIQUE not null,");
            stringBuffer.append("state text,");
            stringBuffer.append("message text,");
            stringBuffer.append("create_time date");
            stringBuffer.append(");");
            return stringBuffer.toString();
        }

        private String getCreateBodyCodeIndexSQL() {
            return "CREATE INDEX body_code_index ON message(body_code)";
        }

        private String getCreateIdIndexSQL() {
            return "CREATE INDEX id_index ON message(id)";
        }

        private String getCreateTableSQL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table message");
            stringBuffer.append(jl1.BRACKET_START_STR);
            stringBuffer.append("id text UNIQUE not null,");
            stringBuffer.append("state integer,");
            stringBuffer.append("body_code integer,");
            stringBuffer.append("report long,");
            stringBuffer.append("target_time long,");
            stringBuffer.append("interval integer,");
            stringBuffer.append("type text,");
            stringBuffer.append("message text,");
            stringBuffer.append("notify integer,");
            stringBuffer.append("create_time date");
            stringBuffer.append(");");
            return stringBuffer.toString();
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!AdapterUtilityImpl.checkIsWritable(super.getWritableDatabase().getPath(), 102400)) {
                return null;
            }
            return super.getWritableDatabase();
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL(getCreateTableSQL());
                    sQLiteDatabase.execSQL(getCreateIdIndexSQL());
                    sQLiteDatabase.execSQL(getCreateBodyCodeIndexSQL());
                    sQLiteDatabase.execSQL(createmMessageTableSQL());
                } catch (Throwable th) {
                    ALog.e(MessageService.TAG, "messagedbhelper create", th, new Object[0]);
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
                } catch (Throwable th) {
                    ALog.e(MessageService.TAG, "MessageService onUpgrade is error", th, new Object[0]);
                    return;
                }
            }
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                sQLiteDatabase.execSQL(createmMessageTableSQL());
            } catch (Throwable th2) {
                ALog.e(MessageService.TAG, "MessageService onUpgrade is error", th2, new Object[0]);
            }
        }
    }

    public static final boolean checkPackage(Context context, String str) {
        try {
            if (context.getPackageManager().getApplicationInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    private MsgDO createMsg(String str, String str2) {
        boolean z;
        ALog.Level level = ALog.Level.I;
        if (ALog.isPrintLog(level)) {
            ALog.i(TAG, "msgRecevie,message--->[" + str + jl1.ARRAY_END_STR + ",utdid=" + AdapterUtilityImpl.getDeviceId(mContext), new Object[0]);
        }
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "message==null");
            if (ALog.isPrintLog(level)) {
                ALog.i(TAG, "handleMessage message==null,utdid=" + AdapterUtilityImpl.getDeviceId(mContext), new Object[0]);
            }
            return null;
        }
        MsgDO msgDO = new MsgDO();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            new Bundle();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String string = jSONObject.getString("p");
                    String string2 = jSONObject.getString("i");
                    String string3 = jSONObject.getString("b");
                    long j = jSONObject.getLong("f");
                    if (!jSONObject.isNull("ext")) {
                        str3 = jSONObject.getString("ext");
                    }
                    int i2 = length - 1;
                    msgDO.msgIds = string2;
                    msgDO.extData = str3;
                    msgDO.messageSource = "accs";
                    msgDO.type = "cache";
                    if (TextUtils.isEmpty(string3)) {
                        msgDO.errorCode = "11";
                    } else if (TextUtils.isEmpty(string)) {
                        msgDO.errorCode = "12";
                    } else if (j == -1) {
                        msgDO.errorCode = "13";
                    } else if (!checkPackage(mContext, string)) {
                        ALog.d(TAG, "ondata checkpackage is del,pack=" + string, new Object[0]);
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "deletePack", string);
                        msgDO.removePacks = string;
                    } else {
                        String string4 = getFlag(j, msgDO).getString(AgooConstants.MESSAGE_ENCRYPTED);
                        if (!mContext.getPackageName().equals(string)) {
                            z = true;
                        } else if (TextUtils.equals(Integer.toString(0), string4) || TextUtils.equals(Integer.toString(4), string4)) {
                            z = false;
                        } else {
                            msgDO.errorCode = "15";
                            ALog.e(TAG, "error encrypted: " + string4, new Object[0]);
                        }
                        msgDO.agooFlag = z;
                        if (!TextUtils.isEmpty(str2)) {
                            msgDO.msgStatus = str2;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e(TAG, "createMsg is error,e: " + th, new Object[0]);
            }
        }
        return msgDO;
    }

    private static Bundle getFlag(long j, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString("report", "1");
                        msgDO.reportStr = "1";
                    }
                    if (charArray[7] == '1') {
                        bundle.putString("notify", "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, "1");
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    private String getStackMsg(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement.toString());
                stringBuffer.append(StringUtils.LF);
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009c A[Catch:{ all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00db A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e0 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void addAccsMessage(String str, String str2, String str3) {
        ?? r10;
        Throwable th;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, "addAccsMessage sqlite3--->[" + str + ",message=" + str2 + ",state=" + str3 + jl1.ARRAY_END_STR, new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                SQLiteDatabase writableDatabase = this.sqliteOpenHelper.getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        Cursor rawQuery = writableDatabase.rawQuery("select count(1) from accs_message where id = ?", new String[]{str});
                        if (rawQuery == null || !rawQuery.moveToFirst() || rawQuery.getInt(0) <= 0) {
                            writableDatabase.execSQL("INSERT INTO accs_message VALUES(?,?,?,date('now'))", new Object[]{str, str3, str2});
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            writableDatabase.close();
                            return;
                        }
                        rawQuery.close();
                        rawQuery.close();
                        writableDatabase.close();
                    } catch (Throwable th2) {
                        th = th2;
                        r10 = sQLiteDatabase;
                        sQLiteDatabase = writableDatabase;
                        try {
                            if (ALog.isPrintLog(ALog.Level.E)) {
                            }
                            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addAccsMessageFailed", th.toString());
                        } finally {
                            if (r10 != 0) {
                                r10.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                        }
                    }
                } else if (writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            r10 = sQLiteDatabase;
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e(TAG, "addAccsMessage error,e--->[" + th + jl1.ARRAY_END_STR + ",ex=" + getStackMsg(th), new Object[0]);
            }
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addAccsMessageFailed", th.toString());
        }
    }

    public void addMessage(String str, String str2, String str3, int i) {
        addMessage(str, str2, str3, 1, -1, -1, i);
    }

    public void deleteCacheMessage() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.sqliteOpenHelper.getWritableDatabase();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
                sQLiteDatabase.execSQL("delete from accs_message where create_time< date('now','-1 day') ");
                try {
                    sQLiteDatabase.close();
                } catch (Throwable unused) {
                }
            } else if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    sQLiteDatabase.close();
                } catch (Throwable unused3) {
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x0144 A[Catch:{ all -> 0x0187, all -> 0x018f }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015d A[SYNTHETIC, Splitter:B:68:0x015d] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0165 A[Catch:{ all -> 0x0161 }] */
    public ArrayList<MsgDO> getUnReportMsg() {
        ArrayList<MsgDO> arrayList;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Object th;
        int i;
        int i2;
        String str;
        try {
            sQLiteDatabase = this.sqliteOpenHelper.getReadableDatabase();
            if (sQLiteDatabase == null) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable th2) {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e(TAG, "getUnReportMsg close cursor or db, e: " + th2, new Object[0]);
                        }
                    }
                }
                return null;
            }
            try {
                arrayList = new ArrayList<>();
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                arrayList = null;
                try {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                    }
                    if (cursor != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    return arrayList;
                } catch (Throwable th4) {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e(TAG, "getUnReportMsg close cursor or db, e: " + th4, new Object[0]);
                    }
                    throw th;
                }
            }
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select * from accs_message where state = ? or state = ? or state = ?", new String[]{"0", "2", "3"});
                if (rawQuery != null) {
                    try {
                        int columnIndex = rawQuery.getColumnIndex("id");
                        int columnIndex2 = rawQuery.getColumnIndex("state");
                        int columnIndex3 = rawQuery.getColumnIndex("message");
                        int columnIndex4 = rawQuery.getColumnIndex("create_time");
                        while (rawQuery.moveToNext() && !TextUtils.isEmpty(rawQuery.getString(columnIndex3))) {
                            String string = rawQuery.getString(columnIndex2);
                            String string2 = rawQuery.getString(columnIndex3);
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                StringBuilder sb = new StringBuilder();
                                i2 = columnIndex2;
                                sb.append("state: ");
                                sb.append(string);
                                sb.append(" ,cursor.message:");
                                sb.append(string2);
                                sb.append(" ,cursor.id:");
                                sb.append(rawQuery.getString(columnIndex));
                                sb.append(" ,cursor.time:");
                                sb.append(rawQuery.getString(columnIndex4));
                                i = columnIndex;
                                ALog.i(TAG, sb.toString(), new Object[0]);
                            } else {
                                i = columnIndex;
                                i2 = columnIndex2;
                            }
                            if (TextUtils.equals("0", string)) {
                                str = "4";
                            } else if (TextUtils.equals("2", string)) {
                                str = "8";
                            } else {
                                str = TextUtils.equals("3", string) ? "9" : null;
                            }
                            new MsgDO();
                            if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(str)) {
                                MsgDO createMsg = createMsg(string2, str);
                                createMsg.messageSource = "cache";
                                arrayList.add(createMsg);
                            }
                            columnIndex2 = i2;
                            columnIndex = i;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = rawQuery;
                        if (ALog.isPrintLog(ALog.Level.E)) {
                        }
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        return arrayList;
                    }
                }
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Throwable th6) {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e(TAG, "getUnReportMsg close cursor or db, e: " + th6, new Object[0]);
                        }
                    }
                }
                sQLiteDatabase.close();
            } catch (Throwable th7) {
                th = th7;
                cursor = null;
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e(TAG, "getUnReportMsg, e: " + th, new Object[0]);
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th8) {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e(TAG, "getUnReportMsg close cursor or db, e: " + th8, new Object[0]);
                        }
                    }
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return arrayList;
            }
            return arrayList;
        } catch (Throwable th9) {
            th = th9;
            cursor = null;
            sQLiteDatabase = null;
            arrayList = null;
            if (ALog.isPrintLog(ALog.Level.E)) {
            }
            if (cursor != null) {
            }
            if (sQLiteDatabase != null) {
            }
            return arrayList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0065 A[SYNTHETIC, Splitter:B:37:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006a A[Catch:{ all -> 0x006d }] */
    public boolean hasMessageDuplicate(String str) {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        Cursor cursor = null;
        boolean z2 = false;
        try {
            boolean z3 = true;
            if (messageStores.containsKey(str)) {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e(TAG, "hasMessageDuplicate,msgid=" + str, new Object[0]);
                }
                z = true;
            } else {
                z = false;
            }
            try {
                sQLiteDatabase = this.sqliteOpenHelper.getReadableDatabase();
                if (sQLiteDatabase == null) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return z;
                }
                try {
                    Cursor rawQuery = sQLiteDatabase.rawQuery("select count(1) from message where id = ?", new String[]{str});
                    if (rawQuery == null || !rawQuery.moveToFirst() || rawQuery.getInt(0) <= 0) {
                        z3 = z;
                    }
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Throwable unused2) {
                            return z3;
                        }
                    }
                    sQLiteDatabase.close();
                    return z3;
                } catch (Throwable unused3) {
                    z2 = z;
                    if (0 != 0) {
                        try {
                            cursor.close();
                        } catch (Throwable unused4) {
                            return z2;
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return z2;
                }
            } catch (Throwable unused5) {
                sQLiteDatabase = null;
                z2 = z;
                if (0 != 0) {
                }
                if (sQLiteDatabase != null) {
                }
                return z2;
            }
        } catch (Throwable unused6) {
            sQLiteDatabase = null;
            if (0 != 0) {
            }
            if (sQLiteDatabase != null) {
            }
            return z2;
        }
    }

    public void init(Context context) {
        messageStores = new HashMap();
        mContext = context;
        this.sqliteOpenHelper = new MessageDBHelper(context);
    }

    public void updateAccsMessage(String str, String str2) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, "updateAccsMessage sqlite3--->[" + str + ",state=" + str2 + jl1.ARRAY_END_STR, new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                sQLiteDatabase = this.sqliteOpenHelper.getWritableDatabase();
                if (sQLiteDatabase != null) {
                    if (TextUtils.equals(str2, "1")) {
                        sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ? and state = ?", new Object[]{str2, str, "0"});
                    } else {
                        sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ?", new Object[]{str2, str});
                    }
                    sQLiteDatabase.close();
                } else if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x019e, code lost:
        com.taobao.accs.utl.UTMini.getInstance().commitEvent(org.android.agoo.common.AgooConstants.AGOO_EVENT_ID, org.android.agoo.message.MessageService.ADD_MESSAGE, com.taobao.accs.utl.AdapterUtilityImpl.getDeviceId(org.android.agoo.message.MessageService.mContext), "addMessageDBcloseFailed", r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013c A[Catch:{ all -> 0x01c1, all -> 0x01c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0179 A[SYNTHETIC, Splitter:B:43:0x0179] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    private void addMessage(String str, String str2, String str3, int i, long j, int i2, int i3) {
        Throwable th;
        Throwable th2;
        int i4;
        String str4;
        ALog.d(TAG, "add sqlite3--->[" + str + jl1.ARRAY_END_STR, new Object[0]);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            String str5 = "";
            if (TextUtils.isEmpty(str2)) {
                str4 = str5;
                i4 = -1;
            } else {
                i4 = str2.hashCode();
                str4 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str5 = str3;
            }
            if (!messageStores.containsKey(str)) {
                messageStores.put(str, Integer.valueOf(i4));
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(TAG, "addMessage,messageId=" + str + ",messageStores＝" + messageStores.toString(), new Object[0]);
                }
            }
            try {
                SQLiteDatabase writableDatabase = this.sqliteOpenHelper.getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.execSQL("INSERT INTO message VALUES(?,?,?,?,?,?,?,?,?,date('now'))", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i4), 0, Long.valueOf(j), Integer.valueOf(i2), str5, str4, Integer.valueOf(i3)});
                    try {
                        writableDatabase.close();
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e(TAG, "addMessage,db.close(),error,e--->[" + th + jl1.ARRAY_END_STR, new Object[0]);
                        }
                    }
                } else if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                        return;
                    } catch (Throwable th4) {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e(TAG, "addMessage,db.close(),error,e--->[" + th4 + jl1.ARRAY_END_STR, new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addMessageDBcloseFailed", th4.toString());
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th5) {
                th2 = th5;
                try {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e(TAG, "addMessage error,e--->[" + th2 + jl1.ARRAY_END_STR, new Object[0]);
                    }
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addMessageFailed", th2.toString());
                    if (0 == 0) {
                        try {
                            sQLiteDatabase.close();
                            return;
                        } catch (Throwable th6) {
                            th = th6;
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e(TAG, "addMessage,db.close(),error,e--->[" + th + jl1.ARRAY_END_STR, new Object[0]);
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th7) {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e(TAG, "addMessage,db.close(),error,e--->[" + th7 + jl1.ARRAY_END_STR, new Object[0]);
                    }
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addMessageDBcloseFailed", th7.toString());
                }
            }
        } catch (Throwable th8) {
            th2 = th8;
            if (ALog.isPrintLog(ALog.Level.E)) {
            }
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, ADD_MESSAGE, AdapterUtilityImpl.getDeviceId(mContext), "addMessageFailed", th2.toString());
            if (0 == 0) {
            }
        }
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0085 A[SYNTHETIC, Splitter:B:39:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008a A[Catch:{ all -> 0x008d }] */
    public boolean hasMessageDuplicate(String str, int i) {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        Cursor cursor = null;
        boolean z2 = false;
        try {
            boolean z3 = true;
            if (!messageStores.containsKey(str) || !messageStores.containsValue(Integer.valueOf(i))) {
                z = false;
            } else {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(TAG, "addMessage,messageStores hasMessageDuplicate,msgid=" + str, new Object[0]);
                }
                z = true;
            }
            try {
                sQLiteDatabase = this.sqliteOpenHelper.getReadableDatabase();
                if (sQLiteDatabase == null) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return z;
                }
                try {
                    Cursor rawQuery = sQLiteDatabase.rawQuery("select count(1) from message where id = ? and body_code=? create_time< date('now','-1 day')", new String[]{str, "" + i});
                    if (rawQuery == null || !rawQuery.moveToFirst() || rawQuery.getInt(0) <= 0) {
                        z3 = z;
                    }
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Throwable unused2) {
                            return z3;
                        }
                    }
                    sQLiteDatabase.close();
                    return z3;
                } catch (Throwable unused3) {
                    z2 = z;
                    if (0 != 0) {
                        try {
                            cursor.close();
                        } catch (Throwable unused4) {
                            return z2;
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return z2;
                }
            } catch (Throwable unused5) {
                sQLiteDatabase = null;
                z2 = z;
                if (0 != 0) {
                }
                if (sQLiteDatabase != null) {
                }
                return z2;
            }
        } catch (Throwable unused6) {
            sQLiteDatabase = null;
            if (0 != 0) {
            }
            if (sQLiteDatabase != null) {
            }
            return z2;
        }
    }
}
