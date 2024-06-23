package tb;

import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.extplugin.ExtPlugInfo;
import com.alibaba.android.ultron.trade.extplugin.IExtInfoGetter;
import com.alibaba.android.ultron.trade.extplugin.IPurchaseInitiatorPlugin;
import com.alibaba.android.ultron.trade.presenter.a;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class fg0 implements IExtInfoGetter {
    private dg0 a = new dg0();

    private IPurchaseInitiatorPlugin b(String str, a aVar) {
        try {
            IPurchaseInitiatorPlugin iPurchaseInitiatorPlugin = (IPurchaseInitiatorPlugin) fb.a(Class.forName(str), new Object[0]);
            iPurchaseInitiatorPlugin.init(this.a, aVar);
            return iPurchaseInitiatorPlugin;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(List<ExtPlugInfo> list, a aVar) {
        if (list != null) {
            for (ExtPlugInfo extPlugInfo : list) {
                b(extPlugInfo.initiatorCls, aVar);
            }
        }
    }

    @Override // com.alibaba.android.ultron.trade.extplugin.IExtInfoGetter
    public Map<String, ISubscriber> getSubscribers() {
        return this.a.a();
    }
}
