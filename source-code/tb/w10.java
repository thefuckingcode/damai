package tb;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class w10 {
    public static void a(List list) {
        if (list != null) {
            try {
                Iterator it = list.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next instanceof WeakReference) {
                            if (((WeakReference) next).get() == null) {
                                it.remove();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                vx.b(e);
            }
        }
    }
}
