package tb;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.idlefish.flutterboost.b;
import com.taobao.weex.annotation.JSMethod;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: Taobao */
public class yl0 {
    public static Map<Object, Object> a(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null && !bundle.keySet().isEmpty()) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof Bundle) {
                    hashMap.put(str, a(bundle.getBundle(str)));
                } else if (obj != null) {
                    hashMap.put(str, obj);
                }
            }
        }
        return hashMap;
    }

    public static String b(String str) {
        return UUID.randomUUID().toString() + JSMethod.NOT_SET + str;
    }

    public static FlutterView c(View view) {
        if (view instanceof FlutterView) {
            return (FlutterView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            FlutterView c = c(viewGroup.getChildAt(i));
            if (c != null) {
                return c;
            }
        }
        return null;
    }

    public static b d(FlutterEngine flutterEngine) {
        if (flutterEngine == null) {
            return null;
        }
        try {
            int i = b.i;
            return (b) flutterEngine.getPlugins().get(b.class);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
