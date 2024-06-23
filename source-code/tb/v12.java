package tb;

import androidx.arch.core.util.Function;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class v12 implements Function {
    public final /* synthetic */ RoomDatabase a;

    public /* synthetic */ v12(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return this.a.lambda$endTransaction$1((SupportSQLiteDatabase) obj);
    }
}
