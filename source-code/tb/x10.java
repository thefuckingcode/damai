package tb;

import android.util.LruCache;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class x10 {
    private final Map<String, LruCache<String, DXWidgetNode>> a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final x10 a = new x10();
    }

    private String a(String str, DXTemplateItem dXTemplateItem) {
        return str + dXTemplateItem.getIdentifier() + JSMethod.NOT_SET + d00.k(DinamicXEngine.i());
    }

    private String c(@NonNull String str) {
        return this.a.get(str) != null ? str : "public_cache";
    }

    public static x10 d() {
        return b.a;
    }

    private void e() {
        this.a.put("public_cache", new LruCache<>(100));
    }

    private void f() {
    }

    public DXWidgetNode b(String str, DXTemplateItem dXTemplateItem) {
        if (!v00.c(str, dXTemplateItem)) {
            return null;
        }
        synchronized (this.a) {
            LruCache<String, DXWidgetNode> lruCache = this.a.get(c(str));
            if (lruCache == null) {
                return null;
            }
            return lruCache.get(a(str, dXTemplateItem));
        }
    }

    public void g(String str, DXTemplateItem dXTemplateItem, DXWidgetNode dXWidgetNode) {
        if (v00.c(str, dXTemplateItem) && dXWidgetNode != null) {
            synchronized (this.a) {
                LruCache<String, DXWidgetNode> lruCache = this.a.get(c(str));
                if (lruCache != null) {
                    lruCache.put(a(str, dXTemplateItem), dXWidgetNode);
                }
            }
        }
    }

    private x10() {
        this.a = new HashMap();
        e();
        f();
    }
}
