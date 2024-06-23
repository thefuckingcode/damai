package org.jetbrains.anko.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006Jk\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lorg/jetbrains/anko/db/AndroidSdkDatabaseSelectQueryBuilder;", "Lorg/jetbrains/anko/db/SelectQueryBuilder;", "db", "Landroid/database/sqlite/SQLiteDatabase;", "tableName", "", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V", "execQuery", "Landroid/database/Cursor;", "distinct", "", "columns", "", "selection", "selectionArgs", "groupBy", "having", "orderBy", "limit", "(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "sqlite-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: SelectQueryBuilder.kt */
public final class AndroidSdkDatabaseSelectQueryBuilder extends SelectQueryBuilder {
    private final SQLiteDatabase db;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidSdkDatabaseSelectQueryBuilder(SQLiteDatabase sQLiteDatabase, String str) {
        super(str);
        Intrinsics.checkParameterIsNotNull(sQLiteDatabase, "db");
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        this.db = sQLiteDatabase;
    }

    /* access modifiers changed from: protected */
    @Override // org.jetbrains.anko.db.SelectQueryBuilder
    public Cursor execQuery(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkParameterIsNotNull(str, "tableName");
        Intrinsics.checkParameterIsNotNull(strArr, "columns");
        Intrinsics.checkParameterIsNotNull(str3, "groupBy");
        Intrinsics.checkParameterIsNotNull(str5, "orderBy");
        Cursor query = this.db.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
        Intrinsics.checkExpressionValueIsNotNull(query, "db.query(distinct, table…, having, orderBy, limit)");
        return query;
    }
}
