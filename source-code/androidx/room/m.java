package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class m implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object[] c;

    public /* synthetic */ m(String str, String str2, Object[] objArr) {
        this.a = str;
        this.b = str2;
        this.c = objArr;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$delete$5(this.a, this.b, this.c, (SupportSQLiteDatabase) obj);
    }
}
