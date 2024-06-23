package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import org.jetbrains.annotations.NotNull;
import tb.og1;
import tb.ww1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaClassMemberScope$enumEntryIndex$1 extends Lambda implements Function0<Map<og1, ? extends JavaField>> {
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$enumEntryIndex$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
    }

    /* Return type fixed from 'java.util.Map<tb.og1, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Map<og1, ? extends JavaField> invoke() {
        Collection<JavaField> fields = this.this$0.n.getFields();
        ArrayList arrayList = new ArrayList();
        for (T t : fields) {
            if (t.isEnumEntry()) {
                arrayList.add(t);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(ww1.a(w.e(n.q(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(((JavaField) obj).getName(), obj);
        }
        return linkedHashMap;
    }
}
