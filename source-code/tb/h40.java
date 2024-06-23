package tb;

import com.taobao.monitor.performance.IApmAdapterFactory;
import com.taobao.monitor.performance.IWXApmAdapter;

/* compiled from: Taobao */
public class h40 implements IApmAdapterFactory {
    @Override // com.taobao.monitor.performance.IApmAdapterFactory
    public IWXApmAdapter createApmAdapter() {
        return new j50();
    }

    @Override // com.taobao.monitor.performance.IApmAdapterFactory
    public IWXApmAdapter createApmAdapterByType(String str) {
        return createApmAdapter();
    }
}
