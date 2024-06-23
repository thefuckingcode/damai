package tb;

import com.alibaba.android.ultron.trade.presenter.a;
import com.alibaba.android.ultron.vfw.web.IWebEventBridge;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.vessel.base.ResultCallback;
import java.util.Map;

/* compiled from: Taobao */
public class js0 implements IWebEventBridge {
    public static final String BRIDGE_TAG = "getComponentData";

    public js0(a aVar) {
    }

    @Override // com.alibaba.android.ultron.vfw.web.IWebEventBridge
    public void onEvent(Map<String, Object> map, ResultCallback resultCallback, IDMComponent iDMComponent) {
        if (iDMComponent != null && resultCallback != null) {
            resultCallback.invoke(iDMComponent.getFields());
        }
    }
}
