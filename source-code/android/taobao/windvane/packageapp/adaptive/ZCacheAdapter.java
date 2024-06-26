package android.taobao.windvane.packageapp.adaptive;

import android.taobao.windvane.packageapp.WVPackageAppManager;
import com.taobao.zcache.config.IZCacheUpdate;
import com.taobao.zcache.log.ZLog;
import tb.jl1;

/* compiled from: Taobao */
public class ZCacheAdapter implements IZCacheUpdate {
    private static final String TAG = "ZCacheUpdate";

    @Override // com.taobao.zcache.config.IZCacheUpdate
    public void firstUpdateCount(int i) {
        if (WVPackageAppManager.getInstance().getUpdateFinishCallback() != null) {
            WVPackageAppManager.getInstance().getUpdateFinishCallback().updateCount("3", i);
        }
        ZLog.i("ZCache 3.0 首次更新个数[" + i + jl1.ARRAY_END_STR);
    }
}
