package android.taobao.windvane.config;

import android.os.Handler;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventId;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: Taobao */
public class WVUCPrecacheManager implements WVEventListener {
    private static final String TAG = "WVUCPrecacheManager";
    private static WVUCPrecacheManager mInstance = null;
    private static boolean sCanClearByCommonConfig = false;
    private static boolean sCanClearByZcacheUpdate = false;
    private static boolean sCanPrecacheByCommonConfig = false;
    private static boolean sCanPrecacheByZcacheUpdate = false;
    private static boolean sHasInitUrlSet = false;
    private static boolean sHasPrecache = false;
    private static boolean sLastEnableUCPrecache = false;
    private static String sLastPrecachePackageName = "";
    private static long sLastPrecacheTime = -1;
    private static final long sMaxPrecacheTime = 3600000;
    private static HashSet<String> sPreMemCacheUrlSet = new HashSet<>();
    private static HashSet<String> sPrecacheDocResMap = new HashSet<>();
    private Handler mPrecacheHandler;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class WVUCPrecacheManagerHolder {
        static final WVUCPrecacheManager sInstance = new WVUCPrecacheManager();

        private WVUCPrecacheManagerHolder() {
        }
    }

    public static boolean canClearPrecache() {
        if (!sHasPrecache) {
            return false;
        }
        if (sCanClearByCommonConfig || sCanClearByZcacheUpdate) {
            return true;
        }
        if (sLastPrecacheTime <= 0 || System.currentTimeMillis() - sLastPrecacheTime <= 3600000) {
            return false;
        }
        return true;
    }

    public static boolean canPrecache() {
        if (WVCommonConfig.commonConfig.enableUCPrecache && !TextUtils.isEmpty(sLastPrecachePackageName)) {
            if (!sHasInitUrlSet) {
                sHasInitUrlSet = true;
                updatePreMemCacheUrls();
            }
            HashSet<String> hashSet = sPreMemCacheUrlSet;
            if (hashSet != null && hashSet.size() > 0) {
                if (sCanPrecacheByCommonConfig || sCanPrecacheByZcacheUpdate || !sHasPrecache) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static WVUCPrecacheManager getInstance() {
        return WVUCPrecacheManagerHolder.sInstance;
    }

    private void init() {
        WVEventService.getInstance().addEventListener(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    private static void notifyUpdateCommonConfig() {
        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
        boolean z = wVCommonConfigData.enableUCPrecache;
        String str = wVCommonConfigData.precachePackageName;
        boolean z2 = sLastEnableUCPrecache;
        boolean z3 = false;
        boolean z4 = true;
        if (!z2 || z) {
            if (!z2 && z) {
                sCanClearByCommonConfig = true;
                sCanPrecacheByCommonConfig = true;
            }
            if (sLastPrecachePackageName.equals(str)) {
                sCanClearByCommonConfig = true;
                if (!TextUtils.isEmpty(str)) {
                    sCanPrecacheByCommonConfig = true;
                }
            } else {
                z4 = z3;
            }
            sLastEnableUCPrecache = z;
            sLastPrecachePackageName = str;
            if (!z4 || !sHasInitUrlSet) {
                updatePreMemCacheUrls();
            }
            return;
        }
        sCanClearByCommonConfig = true;
        sCanPrecacheByCommonConfig = false;
        z3 = true;
        if (sLastPrecachePackageName.equals(str)) {
        }
        sLastEnableUCPrecache = z;
        sLastPrecachePackageName = str;
        if (!z4) {
        }
        updatePreMemCacheUrls();
    }

    private static void notifyUpdateZcache(String str) {
        if (!TextUtils.isEmpty(str) && str.equals(sLastPrecachePackageName)) {
            sCanClearByZcacheUpdate = true;
            sCanPrecacheByZcacheUpdate = true;
            updatePreMemCacheUrls();
        }
    }

    public static HashSet<String> preMemCacheUrlSet() {
        return sPreMemCacheUrlSet;
    }

    public static void resetClearConfig() {
        sCanClearByCommonConfig = false;
        sCanClearByZcacheUpdate = false;
    }

    public static void resetPrecacheConfig() {
        sCanPrecacheByCommonConfig = false;
        sCanPrecacheByZcacheUpdate = false;
    }

    private void sendClearPrecacheDocMessage(final String str) {
        if (sPrecacheDocResMap.size() > 0) {
            if (this.mPrecacheHandler == null) {
                this.mPrecacheHandler = new Handler();
            }
            this.mPrecacheHandler.postDelayed(new Runnable() {
                /* class android.taobao.windvane.config.WVUCPrecacheManager.AnonymousClass1 */

                public void run() {
                    WVUCPrecacheManager.this.clearPrecacheDoc(str);
                }
            }, 10000);
        }
    }

    public static void setHasPrecache(boolean z) {
        sHasPrecache = z;
        if (z) {
            sLastPrecacheTime = System.currentTimeMillis();
        } else {
            sLastPrecacheTime = -1;
        }
    }

    private static void updatePreMemCacheUrls() {
        Object obj;
        if (!WVCommonConfig.commonConfig.enableUCPrecache || TextUtils.isEmpty(sLastPrecachePackageName)) {
            sPreMemCacheUrlSet = new HashSet<>();
            return;
        }
        WVEventResult onEvent = WVEventService.getInstance().onEvent(WVEventId.GET_URLS_BY_APP_NAME, sLastPrecachePackageName);
        if (onEvent.isSuccess && (obj = onEvent.resultObj) != null && (obj instanceof HashSet)) {
            sPreMemCacheUrlSet = (HashSet) obj;
            sHasInitUrlSet = true;
        }
    }

    public void addPrecacheDoc(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) > 0) {
                str = str.substring(0, str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX));
            }
            sPrecacheDocResMap.add(str);
            sendClearPrecacheDocMessage(str);
        }
    }

    public boolean canPrecacheDoc(String str) {
        if (!WVCommonConfig.commonConfig.enableUCPrecacheDoc || TextUtils.isEmpty(str)) {
            return false;
        }
        if (sPreMemCacheUrlSet.isEmpty()) {
            return true;
        }
        Iterator<String> it = sPreMemCacheUrlSet.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void clearPrecacheDoc(String str) {
        if (str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) > 0) {
            str = str.substring(0, str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX));
        }
        sPrecacheDocResMap.remove(str);
    }

    public boolean hasPrecacheDoc(String str) {
        if (str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) > 0) {
            str = str.substring(0, str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX));
        }
        return sPrecacheDocResMap.contains(str);
    }

    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        if (i == 6008) {
            notifyUpdateZcache((String) objArr[0]);
            return null;
        } else if (i != 6012) {
            return null;
        } else {
            notifyUpdateCommonConfig();
            return null;
        }
    }

    private WVUCPrecacheManager() {
        this.mPrecacheHandler = null;
        init();
    }
}
