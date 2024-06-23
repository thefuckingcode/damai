package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class c implements Function {
    public final /* synthetic */ boolean a;

    public /* synthetic */ c(boolean z) {
        this.a = z;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.b(this.a, (SupportSQLiteDatabase) obj);
    }
}
