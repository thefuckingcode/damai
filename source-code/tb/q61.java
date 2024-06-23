package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.poplayer.factory.PLViewInfo;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import java.lang.reflect.Constructor;
import java.util.HashMap;

/* compiled from: Taobao */
public class q61 {
    public static final String TAG = "q61";
    private final HashMap<String, Class<? extends PopLayerBaseView>> a;
    private Class<? extends PopLayerBaseView> b;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static q61 a = new q61();
    }

    public static q61 b() {
        return b.a;
    }

    public PopLayerBaseView a(Context context, String str) {
        Class<? extends PopLayerBaseView> cls;
        Class<? extends PopLayerBaseView> cls2 = this.a.get(str);
        if (cls2 == null && TextUtils.isEmpty(str) && (cls = this.b) != null) {
            cr1.b("%s.create:use baseItem.", TAG);
            cls2 = cls;
        }
        if (cls2 == null) {
            cr1.b("%s.create:can't find type.", TAG);
            return null;
        }
        try {
            Constructor<? extends PopLayerBaseView> declaredConstructor = cls2.getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            return (PopLayerBaseView) declaredConstructor.newInstance(context);
        } catch (Throwable th) {
            cr1.c(TAG + ".newInstance fail!", th);
            return null;
        }
    }

    public void c(Class<? extends PopLayerBaseView> cls) {
        if (cls != null) {
            PLViewInfo pLViewInfo = (PLViewInfo) cls.getAnnotation(PLViewInfo.class);
            if (pLViewInfo == null) {
                throw new RuntimeException("no annotation " + PLViewInfo.class.getName() + " found for " + cls);
            } else if (!this.a.containsKey(pLViewInfo.type())) {
                this.a.put(pLViewInfo.type(), cls);
                if (pLViewInfo.isDefaultType()) {
                    this.b = cls;
                }
            } else {
                throw new RuntimeException("type:" + pLViewInfo.type() + " already registered.");
            }
        } else {
            throw new RuntimeException("class is null;");
        }
    }

    private q61() {
        this.a = new HashMap<>();
    }
}
