package tb;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

/* compiled from: Taobao */
public final /* synthetic */ class a9 implements Function {
    public static final /* synthetic */ a9 a = new a9();

    private /* synthetic */ a9() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Integer.valueOf(((SupportSQLiteStatement) obj).executeUpdateDelete());
    }
}
