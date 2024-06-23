package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class i implements Function {
    public final /* synthetic */ long a;

    public /* synthetic */ i(long j) {
        this.a = j;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setMaximumSize$2(this.a, (SupportSQLiteDatabase) obj);
    }
}
