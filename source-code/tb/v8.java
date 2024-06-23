package tb;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
public final /* synthetic */ class v8 implements Function {
    public static final /* synthetic */ v8 a = new v8();

    private /* synthetic */ v8() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDbLockedByCurrentThread());
    }
}
