package tb;

import android.content.res.Resources;
import java.util.Map;

/* compiled from: Taobao */
public class vr1 {
    public static final String RENDERING_TYPE_EXTERNAL = "external";
    public static final String RENDERING_TYPE_TEXTURE = "texture";
    public Map<String, Object> a;
    public String b;

    public static vr1 a(Map<String, Object> map) {
        Map<String, Object> map2 = (Map) map.get("src");
        String str = (String) map.get("imageType");
        String str2 = (String) map.get("renderingType");
        if (map.get("width") instanceof Double) {
            ((Double) map.get("width")).doubleValue();
        }
        if (map.get("height") instanceof Double) {
            ((Double) map.get("height")).doubleValue();
        }
        float f = Resources.getSystem().getDisplayMetrics().density;
        vr1 vr1 = new vr1();
        vr1.a = map2;
        vr1.b = str;
        return vr1;
    }
}
