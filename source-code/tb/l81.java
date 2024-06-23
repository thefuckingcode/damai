package tb;

import com.alibaba.aliweex.adapter.module.location.DefaultLocation;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.taobao.weex.WXSDKInstance;

/* compiled from: Taobao */
public class l81 {
    public static ILocatable a(WXSDKInstance wXSDKInstance) {
        return new DefaultLocation(wXSDKInstance);
    }
}
