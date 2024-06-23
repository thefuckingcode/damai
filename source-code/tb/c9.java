package tb;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

/* compiled from: Taobao */
public final /* synthetic */ class c9 implements Function {
    public static final /* synthetic */ c9 a = new c9();

    private /* synthetic */ c9() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteStatement) obj).executeInsert());
    }
}
