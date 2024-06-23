package tb;

import android.view.View;
import com.alibaba.android.ultron.vfw.event.OnDynamicEventListener;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
public class l80 extends w0 {
    public static final String DISPATCHER_TAG = "handleDinamicXEvent";

    @Override // com.taobao.android.dinamic.dinamic.DinamicEventHandler
    public void handleEvent(View view, String str, Object obj, Object obj2, Object obj3, ArrayList arrayList) {
        wv2 wv2;
        OnDynamicEventListener onDynamicEventListener;
        if ((obj3 instanceof Map) && (wv2 = (wv2) ((Map) obj3).get(wv2.KEY_VIEW_ENGINE)) != null && (onDynamicEventListener = (OnDynamicEventListener) wv2.getService(OnDynamicEventListener.class)) != null) {
            onDynamicEventListener.onReceiveEvent(view, str, obj, obj2, obj3, arrayList);
        }
    }
}
