package tb;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

/* compiled from: Taobao */
public final /* synthetic */ class b9 implements Function {
    public static final /* synthetic */ b9 a = new b9();

    private /* synthetic */ b9() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return ((SupportSQLiteStatement) obj).simpleQueryForString();
    }
}
