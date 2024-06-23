package org.jetbrains.anko.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001d\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\u001a\u001e\u0010\u001f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001e0 *\u00020\u001b\u001a\u0018\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00180 *\u00020\u001b\u001a\u0016\u0010\"\u001a\u0004\u0018\u00010\u0019*\u00020\u001b2\u0006\u0010#\u001a\u00020\fH\u0002\u001a \u0010$\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001e0 *\u00020\u001bH\u0007\u001a(\u0010%\u001a\b\u0012\u0004\u0012\u0002H'0&\"\b\b\u0000\u0010'*\u00020\u0019*\u00020\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)\u001a(\u0010%\u001a\b\u0012\u0004\u0012\u0002H'0&\"\b\b\u0000\u0010'*\u00020\u0019*\u00020\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0\u0001\u001a)\u0010*\u001a\u0004\u0018\u0001H'\"\b\b\u0000\u0010'*\u00020\u0019*\u00020\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)¢\u0006\u0002\u0010+\u001a)\u0010*\u001a\u0004\u0018\u0001H'\"\b\b\u0000\u0010'*\u00020\u0019*\u00020\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0\u0001¢\u0006\u0002\u0010,\u001a'\u0010-\u001a\u0002H'\"\b\b\u0000\u0010'*\u00020\u0019*\u00020\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)¢\u0006\u0002\u0010+\u001a'\u0010-\u001a\u0002H'\"\b\b\u0000\u0010'*\u00020\u0019*\u00020\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0\u0001¢\u0006\u0002\u0010,\u001a\u001a\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00180 *\u00020\u001bH\u0007\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0004\"\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0004\"\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0004\"\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0004¨\u0006/"}, d2 = {"BlobParser", "Lorg/jetbrains/anko/db/RowParser;", "", "getBlobParser", "()Lorg/jetbrains/anko/db/RowParser;", "DoubleParser", "", "getDoubleParser", "FloatParser", "", "getFloatParser", "IntParser", "", "getIntParser", "LongParser", "", "getLongParser", "ShortParser", "", "getShortParser", "StringParser", "", "getStringParser", "readColumnsArray", "", "", "cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)[Ljava/lang/Object;", "readColumnsMap", "", "asMapSequence", "Lkotlin/sequences/Sequence;", "asSequence", "getColumnValue", "index", "mapSequence", "parseList", "", "T", "parser", "Lorg/jetbrains/anko/db/MapRowParser;", "parseOpt", "(Landroid/database/Cursor;Lorg/jetbrains/anko/db/MapRowParser;)Ljava/lang/Object;", "(Landroid/database/Cursor;Lorg/jetbrains/anko/db/RowParser;)Ljava/lang/Object;", "parseSingle", "sequence", "sqlite-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: SqlParsers.kt */
public final class SqlParsersKt {
    private static final RowParser<byte[]> BlobParser = new SingleColumnParser();
    private static final RowParser<Double> DoubleParser = new SingleColumnParser();
    private static final RowParser<Float> FloatParser = new ScalarColumnParser(SqlParsersKt$FloatParser$1.INSTANCE);
    private static final RowParser<Integer> IntParser = new ScalarColumnParser(SqlParsersKt$IntParser$1.INSTANCE);
    private static final RowParser<Long> LongParser = new SingleColumnParser();
    private static final RowParser<Short> ShortParser = new ScalarColumnParser(SqlParsersKt$ShortParser$1.INSTANCE);
    private static final RowParser<String> StringParser = new SingleColumnParser();

    public static final RowParser<Short> getShortParser() {
        return ShortParser;
    }

    public static final RowParser<Integer> getIntParser() {
        return IntParser;
    }

    public static final RowParser<Long> getLongParser() {
        return LongParser;
    }

    public static final RowParser<Float> getFloatParser() {
        return FloatParser;
    }

    public static final RowParser<Double> getDoubleParser() {
        return DoubleParser;
    }

    public static final RowParser<String> getStringParser() {
        return StringParser;
    }

    public static final RowParser<byte[]> getBlobParser() {
        return BlobParser;
    }

    @Deprecated(message = "Use asSequence() instead", replaceWith = @ReplaceWith(expression = "asSequence()", imports = {}))
    public static final Sequence<Object[]> sequence(Cursor cursor) {
        Intrinsics.checkParameterIsNotNull(cursor, "$receiver");
        return new CursorSequence(cursor);
    }

    @Deprecated(message = "Use asMapSequence() instead", replaceWith = @ReplaceWith(expression = "asMapSequence()", imports = {}))
    public static final Sequence<Map<String, Object>> mapSequence(Cursor cursor) {
        Intrinsics.checkParameterIsNotNull(cursor, "$receiver");
        return new CursorMapSequence(cursor);
    }

    public static final Sequence<Object[]> asSequence(Cursor cursor) {
        Intrinsics.checkParameterIsNotNull(cursor, "$receiver");
        return new CursorSequence(cursor);
    }

    public static final Sequence<Map<String, Object>> asMapSequence(Cursor cursor) {
        Intrinsics.checkParameterIsNotNull(cursor, "$receiver");
        return new CursorMapSequence(cursor);
    }

    private static final Object getColumnValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        int type = cursor.getType(i);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            return null;
        }
        return (Serializable) cursor.getBlob(i);
    }

    /* access modifiers changed from: private */
    public static final Object[] readColumnsArray(Cursor cursor) {
        int columnCount = cursor.getColumnCount();
        Object[] objArr = new Object[columnCount];
        int i = columnCount - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                objArr[i2] = getColumnValue(cursor, i2);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        return objArr;
    }

    /* access modifiers changed from: private */
    public static final Map<String, Object> readColumnsMap(Cursor cursor) {
        int columnCount = cursor.getColumnCount();
        HashMap hashMap = new HashMap();
        int i = columnCount - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                hashMap.put(cursor.getColumnName(i2), getColumnValue(cursor, i2));
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        throw r6;
     */
    public static final <T> T parseSingle(Cursor cursor, RowParser<? extends T> rowParser) {
        Intrinsics.checkParameterIsNotNull(cursor, "$receiver");
        Intrinsics.checkParameterIsNotNull(rowParser, "parser");
        if (Build.VERSION.SDK_INT >= 16) {
            Cursor cursor2 = cursor;
            Throwable th = null;
            Cursor cursor3 = cursor2;
            if (cursor.getCount() == 1) {
                cursor.moveToFirst();
                T t = (T) rowParser.parseRow(readColumnsArray(cursor));
                CloseableKt.closeFinally(cursor2, th);
                return t;
            }
            throw new SQLiteException("parseSingle accepts only cursors with a single entry");
        }
        try {
            if (cursor.getCount() == 1) {
                cursor.moveToFirst();
                return (T) rowParser.parseRow(readColumnsArray(cursor));
            }
            throw new SQLiteException("parseSingle accepts only cursors with a single entry");
        } finally {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        throw r7;
     */
    public static final <T> T parseOpt(Cursor cursor, RowParser<? extends T> rowParser) {
        Intrinsics.checkParameterIsNotNull(cursor, "$receiver");
        Intrinsics.checkParameterIsNotNull(rowParser, "parser");
        if (Build.VERSION.SDK_INT >= 16) {
            Cursor cursor2 = cursor;
            Throwable th = null;
            Cursor cursor3 = cursor2;
            if (cursor.getCount() > 1) {
                throw new SQLiteException("parseSingle accepts only cursors with a single entry or empty cursors");
            } else if (cursor.getCount() == 0) {
                CloseableKt.closeFinally(cursor2, th);
                return null;
            } else {
                cursor.moveToFirst();
                T t = (T) rowParser.parseRow(readColumnsArray(cursor));
                CloseableKt.closeFinally(cursor2, th);
                return t;
            }
        } else {
            try {
                if (cursor.getCount() > 1) {
                    throw new SQLiteException("parseSingle accepts only cursors with a single entry or empty cursors");
                } else if (cursor.getCount() == 0) {
                    return null;
                } else {
                    cursor.moveToFirst();
                    T t2 = (T) rowParser.parseRow(readColumnsArray(cursor));
                    try {
                        cursor.close();
                    } catch (Exception unused) {
                    }
                    return t2;
                }
            } finally {
                try {
                    cursor.close();
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        throw r5;
     */
    public static final <T> List<T> parseList(Cursor cursor, RowParser<? extends T> rowParser) {
        Intrinsics.checkParameterIsNotNull(cursor, "$receiver");
        Intrinsics.checkParameterIsNotNull(rowParser, "parser");
        if (Build.VERSION.SDK_INT >= 16) {
            Cursor cursor2 = cursor;
            Throwable th = null;
            Cursor cursor3 = cursor2;
            ArrayList arrayList = new ArrayList(cursor.getCount());
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add(rowParser.parseRow(readColumnsArray(cursor)));
                cursor.moveToNext();
            }
            ArrayList arrayList2 = arrayList;
            CloseableKt.closeFinally(cursor2, th);
            return arrayList2;
        }
        try {
            ArrayList arrayList3 = new ArrayList(cursor.getCount());
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList3.add(rowParser.parseRow(readColumnsArray(cursor)));
                cursor.moveToNext();
            }
            ArrayList arrayList4 = arrayList3;
            try {
                cursor.close();
            } catch (Exception unused) {
            }
            return arrayList4;
        } catch (Throwable th2) {
            try {
                cursor.close();
            } catch (Exception unused2) {
            }
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        throw r6;
     */
    public static final <T> T parseSingle(Cursor cursor, MapRowParser<? extends T> mapRowParser) {
        Intrinsics.checkParameterIsNotNull(cursor, "$receiver");
        Intrinsics.checkParameterIsNotNull(mapRowParser, "parser");
        if (Build.VERSION.SDK_INT >= 16) {
            Cursor cursor2 = cursor;
            Throwable th = null;
            Cursor cursor3 = cursor2;
            if (cursor.getCount() == 1) {
                cursor.moveToFirst();
                T t = (T) mapRowParser.parseRow(readColumnsMap(cursor));
                CloseableKt.closeFinally(cursor2, th);
                return t;
            }
            throw new SQLiteException("parseSingle accepts only cursors with getCount() == 1");
        }
        try {
            if (cursor.getCount() == 1) {
                cursor.moveToFirst();
                return (T) mapRowParser.parseRow(readColumnsMap(cursor));
            }
            throw new SQLiteException("parseSingle accepts only cursors with getCount() == 1");
        } finally {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        throw r7;
     */
    public static final <T> T parseOpt(Cursor cursor, MapRowParser<? extends T> mapRowParser) {
        Intrinsics.checkParameterIsNotNull(cursor, "$receiver");
        Intrinsics.checkParameterIsNotNull(mapRowParser, "parser");
        if (Build.VERSION.SDK_INT >= 16) {
            Cursor cursor2 = cursor;
            Throwable th = null;
            Cursor cursor3 = cursor2;
            if (cursor.getCount() > 1) {
                throw new SQLiteException("parseSingle accepts only cursors with getCount() == 1 or empty cursors");
            } else if (cursor.getCount() == 0) {
                CloseableKt.closeFinally(cursor2, th);
                return null;
            } else {
                cursor.moveToFirst();
                T t = (T) mapRowParser.parseRow(readColumnsMap(cursor));
                CloseableKt.closeFinally(cursor2, th);
                return t;
            }
        } else {
            try {
                if (cursor.getCount() > 1) {
                    throw new SQLiteException("parseSingle accepts only cursors with getCount() == 1 or empty cursors");
                } else if (cursor.getCount() == 0) {
                    return null;
                } else {
                    cursor.moveToFirst();
                    T t2 = (T) mapRowParser.parseRow(readColumnsMap(cursor));
                    try {
                        cursor.close();
                    } catch (Exception unused) {
                    }
                    return t2;
                }
            } finally {
                try {
                    cursor.close();
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        throw r5;
     */
    public static final <T> List<T> parseList(Cursor cursor, MapRowParser<? extends T> mapRowParser) {
        Intrinsics.checkParameterIsNotNull(cursor, "$receiver");
        Intrinsics.checkParameterIsNotNull(mapRowParser, "parser");
        if (Build.VERSION.SDK_INT >= 16) {
            Cursor cursor2 = cursor;
            Throwable th = null;
            Cursor cursor3 = cursor2;
            ArrayList arrayList = new ArrayList(cursor.getCount());
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList.add(mapRowParser.parseRow(readColumnsMap(cursor)));
                cursor.moveToNext();
            }
            ArrayList arrayList2 = arrayList;
            CloseableKt.closeFinally(cursor2, th);
            return arrayList2;
        }
        try {
            ArrayList arrayList3 = new ArrayList(cursor.getCount());
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                arrayList3.add(mapRowParser.parseRow(readColumnsMap(cursor)));
                cursor.moveToNext();
            }
            ArrayList arrayList4 = arrayList3;
            try {
                cursor.close();
            } catch (Exception unused) {
            }
            return arrayList4;
        } catch (Throwable th2) {
            try {
                cursor.close();
            } catch (Exception unused2) {
            }
            throw th2;
        }
    }
}
