package tb;

import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.extplugin.IExtInitiator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class dg0 implements IExtInitiator {
    private Map<String, ISubscriber> a = new HashMap();

    public Map<String, ISubscriber> a() {
        return this.a;
    }

    @Override // com.alibaba.android.ultron.trade.extplugin.IExtInitiator
    public void registerSubscriber(String str, ISubscriber iSubscriber) {
        if (str != null && iSubscriber != null) {
            this.a.put(str, iSubscriber);
        }
    }

    @Override // com.alibaba.android.ultron.trade.extplugin.IExtInitiator
    public void registerSubscribers(Map<String, ISubscriber> map) {
        if (map != null && !map.isEmpty()) {
            this.a.putAll(map);
        }
    }
}
