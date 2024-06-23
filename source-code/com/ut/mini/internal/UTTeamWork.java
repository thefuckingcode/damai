package com.ut.mini.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.analytics.core.logbuilder.TimeStampAdjustMgr;
import com.alibaba.analytics.utils.Logger;
import com.ta.utdid2.device.UTDevice;
import com.taobao.weex.annotation.JSMethod;
import com.ut.mini.UTAnalytics;
import com.ut.mini.exposure.ExposureUtils;
import com.ut.mini.exposure.TrackerManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.bz0;
import tb.nm2;
import tb.rm2;
import tb.yi;
import tb.zc2;
import tb.zf2;

/* compiled from: Taobao */
public class UTTeamWork {
    private static final String TAG = "UTTeamWork";
    private static UTTeamWork s_instance;
    private List<H5JSCallback> callbacks = new ArrayList();

    /* compiled from: Taobao */
    public interface H5JSCallback {
        void onH5JSCall(Object obj, Map<String, String> map);
    }

    public static synchronized UTTeamWork getInstance() {
        UTTeamWork uTTeamWork;
        synchronized (UTTeamWork.class) {
            if (s_instance == null) {
                s_instance = new UTTeamWork();
            }
            uTTeamWork = s_instance;
        }
        return uTTeamWork;
    }

    public void clearHost4Https(Context context) {
        if (context == null) {
            Log.w("UTAnalytics", "context =null");
        } else {
            zc2.b(context, bz0.TAG_HTTPS_HOST_PORT, null);
        }
    }

    public void clearHost4TimeAdjustService(Context context) {
        if (context == null) {
            Log.w("UTAnalytics", "context =null");
        } else {
            zc2.b(context, TimeStampAdjustMgr.TAG_TIME_ADJUST_HOST_PORT, null);
        }
    }

    public void clearHostPort4Http(Context context) {
        if (context == null) {
            Log.w("UTAnalytics", "context =null");
        } else {
            zc2.b(context, "http_host", null);
        }
    }

    public void clearHostPort4Tnet(Context context) {
        if (context == null) {
            Log.w("UTAnalytics", "context =null");
        } else {
            zc2.b(context, nm2.TAG_TNET_HOST_PORT, null);
        }
    }

    public void clearHostPort4TnetIpv6(Context context) {
        if (context == null) {
            Log.w(TAG, "context is null");
        } else {
            zc2.b(context, "utanalytics_tnet_host_port_ipv6", null);
        }
    }

    public void clearIgnoreTagForExposureView(View view) {
        ExposureUtils.clearIgnoreTagForExposureView(view);
    }

    public void clearStaticHostPort4Tnet(Context context) {
        if (context == null) {
            Log.w("UTAnalytics", "context =null");
        } else {
            zc2.b(context, rm2.TAG_STATIC_TNET_HOST_PORT, null);
        }
    }

    public void clearViewGroupTagForExposureView(View view) {
        ExposureUtils.clearViewGroupTagForExposureView(view);
    }

    public void closeAuto1010Track() {
        yi.c().j();
    }

    public void dispatchH5JSCall(Object obj, Map<String, String> map) {
        int size = this.callbacks.size();
        for (int i = 0; i < size; i++) {
            this.callbacks.get(i).onH5JSCall(obj, map);
        }
    }

    public void dispatchLocalHits() {
        UTAnalytics.getInstance().dispatchLocalHits();
    }

    public ExposureViewHandle getExposureViewHandler(Activity activity) {
        return TrackerManager.getInstance().getExposureViewHandle();
    }

    public String getUtsid() {
        Context b = yi.c().b();
        if (b == null) {
            return null;
        }
        try {
            String K = AnalyticsMgr.K("session_timestamp");
            if (zf2.f(K)) {
                return null;
            }
            long parseLong = Long.parseLong(K);
            String a = yi.c().a();
            String utdid = UTDevice.getUtdid(b);
            if (!zf2.f(a) && !zf2.f(utdid)) {
                return utdid + JSMethod.NOT_SET + a + JSMethod.NOT_SET + parseLong;
            }
            return null;
        } catch (Exception e) {
            Logger.u("", e, new Object[0]);
        }
    }

    public void initialized() {
    }

    public void registerExposureViewHandler(ExposureViewHandle exposureViewHandle) {
        TrackerManager.getInstance().registerExposureViewHandler(exposureViewHandle);
    }

    public void registerH5JSCallback(H5JSCallback h5JSCallback) {
        if (h5JSCallback != null && !this.callbacks.contains(h5JSCallback)) {
            this.callbacks.add(h5JSCallback);
        }
    }

    public void saveCacheDataToLocal() {
        UTAnalytics.getInstance().saveCacheDataToLocal();
    }

    public void setExposureTagForWeex(View view) {
        ExposureUtils.setExposureForWeex(view);
    }

    public void setHost4Https(Context context, String str) {
        if (context == null) {
            Log.w("UTAnalytics", "context =null");
        } else if (TextUtils.isEmpty(str)) {
            Log.w("UTAnalytics", "host or port is empty");
        } else {
            zc2.b(context, bz0.TAG_HTTPS_HOST_PORT, str);
        }
    }

    public void setHost4TimeAdjustService(Context context, String str) {
        if (context == null) {
            Log.w("UTAnalytics", "context =null");
        } else if (TextUtils.isEmpty(str)) {
            Log.w("UTAnalytics", "host is empty");
        } else {
            zc2.b(context, TimeStampAdjustMgr.TAG_TIME_ADJUST_HOST_PORT, str);
        }
    }

    public void setHostPort4Http(Context context, String str) {
        if (context == null) {
            Log.w("UTAnalytics", "context =null");
        } else if (TextUtils.isEmpty(str)) {
            Log.w("UTAnalytics", "host  is empty");
        } else {
            zc2.b(context, "http_host", str);
        }
    }

    public void setHostPort4Tnet(Context context, String str, int i) {
        if (context == null) {
            Log.w("UTAnalytics", "context =null");
        } else if (TextUtils.isEmpty(str)) {
            Log.w("UTAnalytics", "host or port is empty");
        } else {
            zc2.b(context, nm2.TAG_TNET_HOST_PORT, str + ":" + i);
        }
    }

    public void setHostPort4TnetIpv6(Context context, String str, int i) {
        if (context == null) {
            Log.w(TAG, "context is null");
        } else if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "host or port is empty");
        } else {
            zc2.b(context, "utanalytics_tnet_host_port_ipv6", str + ":" + i);
        }
    }

    public void setIgnoreTagForExposureView(View view) {
        ExposureUtils.setIgnoreTagForExposureView(view);
    }

    public void setStaticHostPort4Tnet(Context context, String str, int i) {
        if (context == null) {
            Log.w("UTAnalytics", "context =null");
        } else if (TextUtils.isEmpty(str)) {
            Log.w("UTAnalytics", "host or port is empty");
        } else {
            zc2.b(context, rm2.TAG_STATIC_TNET_HOST_PORT, str + ":" + i);
        }
    }

    public void setToAliyunOsPlatform() {
        UTAnalytics.getInstance().setToAliyunOsPlatform();
    }

    public void setViewGroupTagForExposureView(View view) {
        ExposureUtils.setViewGroupTagForExposureView(view);
    }

    public boolean startExpoTrack(Activity activity) {
        return TrackerManager.getInstance().addToTrack(activity);
    }

    public boolean stopExpoTrack(Activity activity) {
        return TrackerManager.getInstance().removeToTrack(activity);
    }

    public void turnOffRealTimeDebug() {
        Logger.g();
        UTAnalytics.getInstance().turnOffRealTimeDebug();
    }

    public void turnOnRealTimeDebug(Map<String, String> map) {
        Logger.f(TAG, "", map.entrySet().toArray());
        UTAnalytics.getInstance().turnOnRealTimeDebug(map);
    }

    public void unRegisterExposureViewHandler(ExposureViewHandle exposureViewHandle) {
        TrackerManager.getInstance().unRegisterExposureViewHandler(exposureViewHandle);
    }

    public void unRegisterH5JSCallback(H5JSCallback h5JSCallback) {
        if (h5JSCallback != null) {
            this.callbacks.remove(h5JSCallback);
        }
    }
}
