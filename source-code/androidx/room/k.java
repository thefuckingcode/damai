package androidx.room;

import android.content.ContentValues;
import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class k implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ContentValues c;

    public /* synthetic */ k(String str, int i, ContentValues contentValues) {
        this.a = str;
        this.b = i;
        this.c = contentValues;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$insert$4(this.a, this.b, this.c, (SupportSQLiteDatabase) obj);
    }
}
