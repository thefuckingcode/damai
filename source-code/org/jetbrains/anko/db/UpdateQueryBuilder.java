package org.jetbrains.anko.db;

import android.content.ContentValues;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoException;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J9\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0003H\u0007JA\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00032*\u0010\u001d\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0003J?\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00032*\u0010\u001d\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0010\u001eJ'\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003¢\u0006\u0002\u0010 J)\u0010!\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003H\u0007¢\u0006\u0002\u0010 R\u001a\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lorg/jetbrains/anko/db/UpdateQueryBuilder;", "", "tableName", "", "values", "", "Lkotlin/Pair;", "(Ljava/lang/String;[Lkotlin/Pair;)V", "nativeSelectionArgs", "[Ljava/lang/String;", "selection", "selectionApplied", "", "getTableName", "()Ljava/lang/String;", "useNativeSelection", "getValues", "()[Lkotlin/Pair;", "[Lkotlin/Pair;", "exec", "", "execUpdate", "table", "Landroid/content/ContentValues;", "whereClause", "whereArgs", "(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "where", "select", "args", "(Ljava/lang/String;[Lkotlin/Pair;)Lorg/jetbrains/anko/db/UpdateQueryBuilder;", "whereSimple", "(Ljava/lang/String;[Ljava/lang/String;)Lorg/jetbrains/anko/db/UpdateQueryBuilder;", "whereSupport", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: UpdateQueryBuilder.kt */
public abstract class UpdateQueryBuilder {
    private String[] nativeSelectionArgs;
    private String selection;
    private boolean selectionApplied;
    private final String tableName;
    private boolean useNativeSelection;
    private final Pair<String, Object>[] values;

    public abstract int execUpdate(String str, ContentValues contentValues, String str2, String[] strArr);

    public UpdateQueryBuilder(String str, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(pairArr, "values");
        this.tableName = str;
        this.values = pairArr;
    }

    public final String getTableName() {
        return this.tableName;
    }

    public final Pair<String, Object>[] getValues() {
        return this.values;
    }

    @Deprecated(message = "Use whereArgs() instead.", replaceWith = @ReplaceWith(expression = "whereArgs(select, *args)", imports = {}))
    public final UpdateQueryBuilder where(String str, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        Intrinsics.checkParameterIsNotNull(pairArr, "args");
        return whereArgs(str, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public final UpdateQueryBuilder whereArgs(String str, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        Intrinsics.checkParameterIsNotNull(pairArr, "args");
        if (!this.selectionApplied) {
            this.selectionApplied = true;
            this.useNativeSelection = false;
            HashMap hashMap = new HashMap();
            for (Pair<String, ? extends Object> pair : pairArr) {
                hashMap.put(pair.getFirst(), pair.getSecond());
            }
            this.selection = DatabaseKt.applyArguments(str, hashMap);
            return this;
        }
        throw new AnkoException("Query selection was already applied.");
    }

    @Deprecated(message = "Use whereArgs() instead.", replaceWith = @ReplaceWith(expression = "whereArgs(select)", imports = {}))
    public final UpdateQueryBuilder where(String str) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        return whereArgs(str);
    }

    public final UpdateQueryBuilder whereArgs(String str) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        if (!this.selectionApplied) {
            this.selectionApplied = true;
            this.useNativeSelection = false;
            this.selection = str;
            return this;
        }
        throw new AnkoException("Query selection was already applied.");
    }

    public final UpdateQueryBuilder whereSimple(String str, String... strArr) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        Intrinsics.checkParameterIsNotNull(strArr, "args");
        if (!this.selectionApplied) {
            this.selectionApplied = true;
            this.useNativeSelection = true;
            this.selection = str;
            this.nativeSelectionArgs = strArr;
            return this;
        }
        throw new AnkoException("Query selection was already applied.");
    }

    @Deprecated(message = "Use whereSimple() instead", replaceWith = @ReplaceWith(expression = "whereSimple(select, *args)", imports = {}))
    public final UpdateQueryBuilder whereSupport(String str, String... strArr) {
        Intrinsics.checkParameterIsNotNull(str, "select");
        Intrinsics.checkParameterIsNotNull(strArr, "args");
        return whereSimple(str, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final int exec() {
        boolean z = this.selectionApplied;
        String[] strArr = null;
        String str = z ? this.selection : null;
        if (z && this.useNativeSelection) {
            strArr = this.nativeSelectionArgs;
        }
        return execUpdate(this.tableName, DatabaseKt.toContentValues(this.values), str, strArr);
    }
}
