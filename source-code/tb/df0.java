package tb;

import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class df0 {
    private static Map<String, Class<? extends ISubscriber>> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("openUrl", gl1.class);
        a.put("openUrlResult", fl1.class);
        a.put("openPopupWindow", dl1.class);
        a.put("select", f82.class);
        a.put("input", h11.class);
        a.put("closePopupWindow", cj.class);
        a.put("confirmPopupWindow", dm.class);
        a.put("autoJumpOpenUrl", f9.class);
        a.put("autoJumpOpenUrlResult", e9.class);
        a.put("userTrack", ht2.class);
        a.put("openSimplePopup", OpenSimplePopupSubscriber.class);
        a.put("openSimpleGroupPopup", el1.class);
        a.put("popupSelect", mr1.class);
        a.put("confirmSimplePopup", em.class);
    }

    public static Map<String, Class<? extends ISubscriber>> a() {
        return a;
    }
}
