package org.jetbrains.anko.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0000¢\u0006\u0002\u0010\t\u001a$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\nH\u0000\u001aG\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0006\"\u00020\u0003¢\u0006\u0002\u0010\u0014\u001aM\u0010\u0015\u001a\u00020\f*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00112*\u0010\u0013\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0007¢\u0006\u0002\u0010\u0017\u001aM\u0010\u0018\u001a\u00020\u0019*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\u001a\u001a\u001c\u0010\u001b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u0011\u001a\u001c\u0010\u001d\u001a\u00020\f*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u0011\u001aG\u0010\u001e\u001a\u00020\u001f*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032.\u0010 \u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006\"\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u0010!\u001aG\u0010\"\u001a\u00020\u001f*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032.\u0010 \u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006\"\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u0010!\u001aG\u0010#\u001a\u00020\u001f*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032.\u0010 \u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006\"\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u0010!\u001aG\u0010$\u001a\u00020\u001f*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032.\u0010 \u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006\"\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u0010!\u001a\u0012\u0010%\u001a\u00020&*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003\u001a+\u0010%\u001a\u00020&*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0006\"\u00020\u0003¢\u0006\u0002\u0010'\u001a'\u0010(\u001a\u00020)*\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006H\u0000¢\u0006\u0002\u0010*\u001a#\u0010+\u001a\u00020\f*\u00020\r2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\f0-¢\u0006\u0002\b.\u001aG\u0010/\u001a\u000200*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032.\u0010 \u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006\"\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u00101\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"ARG_PATTERN", "Ljava/util/regex/Pattern;", "applyArguments", "", "whereClause", "args", "", "Lkotlin/Pair;", "", "(Ljava/lang/String;[Lkotlin/Pair;)Ljava/lang/String;", "", "createIndex", "", "Landroid/database/sqlite/SQLiteDatabase;", "indexName", "tableName", "unique", "", "ifNotExists", "columns", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;ZZ[Ljava/lang/String;)V", "createTable", "Lorg/jetbrains/anko/db/SqlType;", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Z[Lkotlin/Pair;)V", "delete", "", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Lkotlin/Pair;)I", "dropIndex", "ifExists", "dropTable", "insert", "", "values", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Lkotlin/Pair;)J", "insertOrThrow", "replace", "replaceOrThrow", "select", "Lorg/jetbrains/anko/db/SelectQueryBuilder;", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Lorg/jetbrains/anko/db/SelectQueryBuilder;", "toContentValues", "Landroid/content/ContentValues;", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "transaction", "code", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "update", "Lorg/jetbrains/anko/db/UpdateQueryBuilder;", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Lkotlin/Pair;)Lorg/jetbrains/anko/db/UpdateQueryBuilder;", "sqlite-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Database.kt */
public final class DatabaseKt {
    private static final Pattern ARG_PATTERN;

    public static final long insert(SQLiteDatabase sQLiteDatabase, String str, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        return sQLiteDatabase.insert(str, null, toContentValues(pairArr));
    }

    public static final long insertOrThrow(SQLiteDatabase sQLiteDatabase, String str, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        return sQLiteDatabase.insertOrThrow(str, null, toContentValues(pairArr));
    }

    public static final long replace(SQLiteDatabase sQLiteDatabase, String str, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        return sQLiteDatabase.replace(str, null, toContentValues(pairArr));
    }

    public static final long replaceOrThrow(SQLiteDatabase sQLiteDatabase, String str, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        return sQLiteDatabase.replaceOrThrow(str, null, toContentValues(pairArr));
    }

    public static final void transaction(SQLiteDatabase sQLiteDatabase, Function1<? super SQLiteDatabase, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "code");
        try {
            sQLiteDatabase.beginTransaction();
            function1.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (TransactionAbortException unused) {
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    public static final SelectQueryBuilder select(SQLiteDatabase sQLiteDatabase, String str) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        return new AndroidSdkDatabaseSelectQueryBuilder(sQLiteDatabase, str);
    }

    public static final SelectQueryBuilder select(SQLiteDatabase sQLiteDatabase, String str, String... strArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(strArr, "columns");
        AndroidSdkDatabaseSelectQueryBuilder androidSdkDatabaseSelectQueryBuilder = new AndroidSdkDatabaseSelectQueryBuilder(sQLiteDatabase, str);
        androidSdkDatabaseSelectQueryBuilder.columns((String[]) Arrays.copyOf(strArr, strArr.length));
        return androidSdkDatabaseSelectQueryBuilder;
    }

    public static final UpdateQueryBuilder update(SQLiteDatabase sQLiteDatabase, String str, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        return new AndroidSdkDatabaseUpdateQueryBuilder(sQLiteDatabase, str, pairArr);
    }

    public static /* bridge */ /* synthetic */ int delete$default(SQLiteDatabase sQLiteDatabase, String str, String str2, Pair[] pairArr, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return delete(sQLiteDatabase, str, str2, pairArr);
    }

    public static final int delete(SQLiteDatabase sQLiteDatabase, String str, String str2, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(str2, "whereClause");
        Intrinsics.checkParameterIsNotNull(pairArr, "args");
        return sQLiteDatabase.delete(str, applyArguments(str2, (Pair[]) Arrays.copyOf(pairArr, pairArr.length)), null);
    }

    public static /* bridge */ /* synthetic */ void createTable$default(SQLiteDatabase sQLiteDatabase, String str, boolean z, Pair[] pairArr, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        createTable(sQLiteDatabase, str, z, pairArr);
    }

    public static final void createTable(SQLiteDatabase sQLiteDatabase, String str, boolean z, Pair<String, ? extends SqlType>... pairArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "columns");
        String replace$default = StringsKt.replace$default(str, "`", "``", false, 4, (Object) null);
        String str2 = z ? "IF NOT EXISTS" : "";
        ArrayList arrayList = new ArrayList(pairArr.length);
        for (Pair<String, ? extends SqlType> pair : pairArr) {
            arrayList.add(pair.getFirst() + ' ' + ((SqlType) pair.getSecond()).render());
        }
        sQLiteDatabase.execSQL(CollectionsKt.joinToString$default(arrayList, ", ", "CREATE TABLE " + str2 + " `" + replace$default + "`(", ");", 0, null, null, 56, null));
    }

    public static /* bridge */ /* synthetic */ void dropTable$default(SQLiteDatabase sQLiteDatabase, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        dropTable(sQLiteDatabase, str, z);
    }

    public static final void dropTable(SQLiteDatabase sQLiteDatabase, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        String replace$default = StringsKt.replace$default(str, "`", "``", false, 4, (Object) null);
        String str2 = z ? "IF EXISTS" : "";
        sQLiteDatabase.execSQL("DROP TABLE " + str2 + " `" + replace$default + "`;");
    }

    public static /* bridge */ /* synthetic */ void createIndex$default(SQLiteDatabase sQLiteDatabase, String str, String str2, boolean z, boolean z2, String[] strArr, int i, Object obj) {
        createIndex(sQLiteDatabase, str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, strArr);
    }

    public static final void createIndex(SQLiteDatabase sQLiteDatabase, String str, String str2, boolean z, boolean z2, String... strArr) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "indexName");
        Intrinsics.checkParameterIsNotNull(str2, "tableName");
        Intrinsics.checkParameterIsNotNull(strArr, "columns");
        String replace$default = StringsKt.replace$default(str, "`", "``", false, 4, (Object) null);
        String replace$default2 = StringsKt.replace$default(str2, "`", "``", false, 4, (Object) null);
        String str3 = "";
        String str4 = z2 ? "IF NOT EXISTS" : str3;
        if (z) {
            str3 = "UNIQUE";
        }
        sQLiteDatabase.execSQL(ArraysKt.joinToString$default(strArr, ",", "CREATE " + str3 + " INDEX " + str4 + " `" + replace$default + "` ON `" + replace$default2 + "`(", ");", 0, (CharSequence) null, (Function1) null, 56, (Object) null));
    }

    public static /* bridge */ /* synthetic */ void dropIndex$default(SQLiteDatabase sQLiteDatabase, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        dropIndex(sQLiteDatabase, str, z);
    }

    public static final void dropIndex(SQLiteDatabase sQLiteDatabase, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "indexName");
        String replace$default = StringsKt.replace$default(str, "`", "``", false, 4, (Object) null);
        String str2 = z ? "IF EXISTS" : "";
        sQLiteDatabase.execSQL("DROP INDEX " + str2 + " `" + replace$default + "`;");
    }

    static {
        Pattern compile = Pattern.compile("([^\\\\])\\{([^{}]+)\\}");
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(\"([^\\\\\\\\])\\\\{([^{}]+)\\\\}\")");
        ARG_PATTERN = compile;
    }

    public static final String applyArguments(String str, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(str, "whereClause");
        Intrinsics.checkParameterIsNotNull(pairArr, "args");
        HashMap hashMap = new HashMap();
        for (Pair<String, ? extends Object> pair : pairArr) {
            hashMap.put(pair.getFirst(), pair.getSecond());
        }
        return applyArguments(str, hashMap);
    }

    public static final String applyArguments(String str, Map<String, ? extends Object> map) {
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "whereClause");
        Intrinsics.checkParameterIsNotNull(map, "args");
        Matcher matcher = ARG_PATTERN.matcher(str);
        StringBuffer stringBuffer = new StringBuffer(str.length());
        while (matcher.find()) {
            String group = matcher.group(2);
            Object obj = map.get(group);
            if (obj != null) {
                if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Byte) || (obj instanceof Short)) {
                    str2 = obj.toString();
                } else if (obj instanceof Boolean) {
                    str2 = ((Boolean) obj).booleanValue() ? "1" : "0";
                } else if ((obj instanceof Float) || (obj instanceof Double)) {
                    str2 = obj.toString();
                } else {
                    StringBuilder sb = new StringBuilder();
                    String replace$default = StringsKt.replace$default(obj.toString(), "'", "''", false, 4, (Object) null);
                    sb.append(String.valueOf('\'') + replace$default);
                    sb.append('\'');
                    str2 = sb.toString();
                }
                matcher.appendReplacement(stringBuffer, matcher.group(1) + str2);
            } else {
                throw new IllegalStateException("Can't find a value for key " + group);
            }
        }
        matcher.appendTail(stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "buffer.toString()");
        return stringBuffer2;
    }

    public static final ContentValues toContentValues(Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(pairArr, "$receiver");
        ContentValues contentValues = new ContentValues();
        for (Pair<String, ? extends Object> pair : pairArr) {
            String component1 = pair.component1();
            Object component2 = pair.component2();
            if (component2 == null) {
                contentValues.putNull(component1);
            } else if (component2 instanceof Boolean) {
                contentValues.put(component1, (Boolean) component2);
            } else if (component2 instanceof Byte) {
                contentValues.put(component1, (Byte) component2);
            } else if (component2 instanceof byte[]) {
                contentValues.put(component1, (byte[]) component2);
            } else if (component2 instanceof Double) {
                contentValues.put(component1, (Double) component2);
            } else if (component2 instanceof Float) {
                contentValues.put(component1, (Float) component2);
            } else if (component2 instanceof Integer) {
                contentValues.put(component1, (Integer) component2);
            } else if (component2 instanceof Long) {
                contentValues.put(component1, (Long) component2);
            } else if (component2 instanceof Short) {
                contentValues.put(component1, (Short) component2);
            } else if (component2 instanceof String) {
                contentValues.put(component1, (String) component2);
            } else {
                throw new IllegalArgumentException("Non-supported value type: " + component2.getClass().getName());
            }
        }
        return contentValues;
    }
}
