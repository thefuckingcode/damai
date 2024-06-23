package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
/* compiled from: Jsr305State.kt */
public final class Jsr305State$description$2 extends Lambda implements Function0<String[]> {
    final /* synthetic */ Jsr305State this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Jsr305State$description$2(Jsr305State jsr305State) {
        super(0);
        this.this$0 = jsr305State;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String[] invoke() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.this$0.getGlobal().getDescription());
        ReportLevel migration = this.this$0.getMigration();
        if (migration != null) {
            arrayList.add("under-migration:" + migration.getDescription());
        }
        for (Map.Entry<String, ReportLevel> entry : this.this$0.getUser().entrySet()) {
            arrayList.add('@' + entry.getKey() + ':' + entry.getValue().getDescription());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
