package tb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.loc.aq;

/* compiled from: Taobao */
public final class x13 extends SQLiteOpenHelper {
    private aq a;

    public x13(Context context, String str, aq aqVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.a = aqVar;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.a(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
