package tb;

import android.view.View;
import com.alibaba.android.ultron.vfw.event.OnDynamicEventListener;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.a;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
public class m80 extends a {
    public static final String DISPATCHER_TAG = "handleDinamicXEvent";

    @Override // com.taobao.android.dinamicx.IDXEventHandler
    public void handleEvent(lx lxVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        wv2 wv2;
        OnDynamicEventListener onDynamicEventListener;
        ArrayList arrayList;
        tr2.b("DinamicXEventDispatcherV3", "handleEvent", String.valueOf(objArr));
        if (dXRuntimeContext != null && dXRuntimeContext.getDxUserContext() != null) {
            Object dxUserContext = dXRuntimeContext.getDxUserContext();
            if ((dxUserContext instanceof Map) && (wv2 = (wv2) ((Map) dxUserContext).get(wv2.KEY_VIEW_ENGINE)) != null && (onDynamicEventListener = (OnDynamicEventListener) wv2.getService(OnDynamicEventListener.class)) != null) {
                ArrayList arrayList2 = new ArrayList();
                View nativeView = dXRuntimeContext.getNativeView();
                if (nativeView != null) {
                    Object tag = nativeView.getTag(jw2.DINAMICX_3_CUSTOM_INPUT_KEY);
                    if (tag instanceof ArrayList) {
                        arrayList = (ArrayList) tag;
                        onDynamicEventListener.onReceiveEvent(dXRuntimeContext.getRootView(), "", objArr, null, dxUserContext, arrayList);
                    }
                }
                arrayList = arrayList2;
                onDynamicEventListener.onReceiveEvent(dXRuntimeContext.getRootView(), "", objArr, null, dxUserContext, arrayList);
            }
        }
    }
}
