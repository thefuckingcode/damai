package tb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmName;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;

@JvmName(name = "KClasses")
/* compiled from: Taobao */
public final class o51 {
    @NotNull
    public static final List<KClass<?>> a(@NotNull KClass<?> kClass) {
        k21.i(kClass, "$this$superclasses");
        List<KType> supertypes = kClass.getSupertypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            KClassifier classifier = it.next().getClassifier();
            if (!(classifier instanceof KClass)) {
                classifier = null;
            }
            KClass kClass2 = (KClass) classifier;
            if (kClass2 != null) {
                arrayList.add(kClass2);
            }
        }
        return arrayList;
    }
}
