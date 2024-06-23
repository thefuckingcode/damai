package tb;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class r8 implements Function {
    public static final /* synthetic */ r8 a = new r8();

    private /* synthetic */ r8() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return ((SupportSQLiteDatabase) obj).getPath();
    }
}
