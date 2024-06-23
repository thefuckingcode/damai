package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class o implements Function {
    public final /* synthetic */ AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement a;
    public final /* synthetic */ Function b;

    public /* synthetic */ o(AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, Function function) {
        this.a = autoClosingSupportSqliteStatement;
        this.b = function;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return this.a.lambda$executeSqliteStatementWithRefCount$0(this.b, (SupportSQLiteDatabase) obj);
    }
}
