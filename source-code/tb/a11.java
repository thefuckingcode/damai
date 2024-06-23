package tb;

import java.util.ArrayList;
import java.util.List;

public final class a11<E> {
    public static <E> Object a(Object obj) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, int i, m40 m40) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, E e) {
        if (n30.a() && !(!(e instanceof List))) {
            throw new AssertionError();
        } else if (obj == null) {
            return a(e);
        } else {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(e);
                return a(obj);
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(e);
            return a(arrayList);
        }
    }
}
