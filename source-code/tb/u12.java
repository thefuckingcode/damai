package tb;

import androidx.arch.core.util.Function;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class u12 implements Function {
    public final /* synthetic */ RoomDatabase a;

    public /* synthetic */ u12(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return this.a.lambda$beginTransaction$0((SupportSQLiteDatabase) obj);
    }
}
