package tb;

import android.text.TextUtils;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.datasource.local.UpdateInfo;

/* compiled from: Taobao */
public class ms2 {
    private boolean a;

    public void finishUpdate() {
        this.a = false;
    }

    public boolean isLocalDataValid(UpdateInfo updateInfo) {
        String config = UpdateDataSource.sUpdateAdapter.getConfig(js2.UPDATE_CONFIG_GROUP, js2.UPDATE_CACHE_HOUR, "3");
        long intValue = (TextUtils.isEmpty(config) || !TextUtils.isDigitsOnly(config)) ? 0 : (long) (Integer.valueOf(config).intValue() * 60 * 60 * 1000);
        if (0 != intValue && updateInfo != null && updateInfo.lastUpdateTime > 0 && ns2.getVersionName().equals(updateInfo.appVersion) && updateInfo.updateList.size() != 0 && System.currentTimeMillis() - updateInfo.lastUpdateTime < intValue) {
            return true;
        }
        return false;
    }

    public boolean isUpdating() {
        return this.a;
    }

    public void startUpdate() {
        this.a = true;
    }
}
