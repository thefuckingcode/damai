package tb;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

/* compiled from: Taobao */
public final /* synthetic */ class d9 implements Function {
    public static final /* synthetic */ d9 a = new d9();

    private /* synthetic */ d9() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteStatement) obj).simpleQueryForLong());
    }
}
