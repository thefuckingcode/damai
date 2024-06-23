package tb;

import com.alibaba.aliweex.adapter.adapter.WXAPMAdapter;
import com.taobao.weex.performance.IApmGenerator;
import com.taobao.weex.performance.IWXApmMonitorAdapter;

/* compiled from: Taobao */
public class bx2 implements IApmGenerator {
    @Override // com.taobao.weex.performance.IApmGenerator
    public IWXApmMonitorAdapter generateApmInstance(String str) {
        return new WXAPMAdapter();
    }
}
