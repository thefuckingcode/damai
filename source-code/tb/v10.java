package tb;

import android.text.TextUtils;
import androidx.core.util.Pools;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.weex.annotation.JSMethod;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class v10 {
    private final Map<String, Map<String, Pools.Pool<ew2>>> a = new ConcurrentHashMap();
    private final Map<String, Map<String, Pools.Pool<DXRootView>>> b = new ConcurrentHashMap();

    /* compiled from: Taobao */
    private static class a {
        private static final v10 a = new v10();
    }

    public static v10 c() {
        return a.a;
    }

    public static String d(DinamicTemplate dinamicTemplate) {
        if (dinamicTemplate == null) {
            return "";
        }
        return dinamicTemplate.name + JSMethod.NOT_SET + dinamicTemplate.version;
    }

    public void a(ew2 ew2, DinamicTemplate dinamicTemplate, String str) {
        if (ew2 != null && !TextUtils.isEmpty(str) && dinamicTemplate != null) {
            String d = d(dinamicTemplate);
            Map<String, Pools.Pool<ew2>> map = this.a.get(str);
            if (map == null) {
                map = new ConcurrentHashMap<>();
                this.a.put(str, map);
            }
            Pools.Pool<ew2> pool = map.get(d);
            if (pool == null) {
                pool = new Pools.SynchronizedPool<>(6);
                map.put(d, pool);
            }
            pool.release(ew2);
        }
    }

    public void b(DXRootView dXRootView, DXTemplateItem dXTemplateItem, String str) {
        if (dXRootView != null && !TextUtils.isEmpty(str) && dXTemplateItem != null) {
            Map<String, Pools.Pool<DXRootView>> map = this.b.get(str);
            if (map == null) {
                map = new ConcurrentHashMap<>();
                this.b.put(str, map);
            }
            Pools.Pool<DXRootView> pool = map.get(dXTemplateItem.getIdentifier());
            if (pool == null) {
                pool = new Pools.SynchronizedPool<>(6);
                map.put(dXTemplateItem.getIdentifier(), pool);
            }
            pool.release(dXRootView);
        }
    }
}
