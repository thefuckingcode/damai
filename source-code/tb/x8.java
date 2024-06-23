package tb;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class x8 implements Function {
    public static final /* synthetic */ x8 a = new x8();

    private /* synthetic */ x8() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Boolean.valueOf(((SupportSQLiteDatabase) obj).yieldIfContendedSafely());
    }
}
