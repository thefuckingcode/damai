package tb;

import cn.damai.h5container.UniH5ContainerSwitcher;
import com.taobao.orange.OConfigListener;
import java.util.Map;

/* compiled from: Taobao */
public final /* synthetic */ class rr2 implements OConfigListener {
    public final /* synthetic */ UniH5ContainerSwitcher a;

    public /* synthetic */ rr2(UniH5ContainerSwitcher uniH5ContainerSwitcher) {
        this.a = uniH5ContainerSwitcher;
    }

    @Override // com.taobao.orange.OConfigListener
    public final void onConfigUpdate(String str, Map map) {
        UniH5ContainerSwitcher.m31registerOrangeConfig$lambda0(this.a, str, map);
    }
}
