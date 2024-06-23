package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class n implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ Object[] b;

    public /* synthetic */ n(String str, Object[] objArr) {
        this.a = str;
        this.b = objArr;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$execSQL$8(this.a, this.b, (SupportSQLiteDatabase) obj);
    }
}
