package tb;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.c;
import com.heytap.mcssdk.d.d;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public abstract class y23 implements d {
    public static List<BaseMode> a(Context context, Intent intent) {
        BaseMode a;
        if (intent == null) {
            return null;
        }
        int i = 4096;
        try {
            i = Integer.parseInt(c23.f(intent.getStringExtra("type")));
        } catch (Exception e) {
            w33.b("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
        }
        w33.a("MessageParser--getMessageByIntent--type:" + i);
        ArrayList arrayList = new ArrayList();
        for (d dVar : c.m().q()) {
            if (!(dVar == null || (a = dVar.a(context, i, intent)) == null)) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }
}
