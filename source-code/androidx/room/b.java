package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.Locale;

/* compiled from: Taobao */
public final /* synthetic */ class b implements Function {
    public final /* synthetic */ Locale a;

    public /* synthetic */ b(Locale locale) {
        this.a = locale;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.c(this.a, (SupportSQLiteDatabase) obj);
    }
}
