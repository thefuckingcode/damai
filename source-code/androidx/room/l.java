package androidx.room;

import android.content.ContentValues;
import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class l implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ContentValues c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Object[] e;

    public /* synthetic */ l(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        this.a = str;
        this.b = i;
        this.c = contentValues;
        this.d = str2;
        this.e = objArr;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$update$6(this.a, this.b, this.c, this.d, this.e, (SupportSQLiteDatabase) obj);
    }
}
