package tb;

import com.taobao.android.dinamic.DViewGenerator;
import com.taobao.android.dinamic.tempate.DTemplateManager;

/* compiled from: Taobao */
public class bf1 {
    public DViewGenerator a;
    public DTemplateManager b;

    public static bf1 a(String str) {
        bf1 bf1 = new bf1();
        bf1.a = new DViewGenerator(str);
        bf1.b = new DTemplateManager(str);
        return bf1;
    }
}
