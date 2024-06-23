package com.alimm.xadsdk.business.common;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.business.common.interfaces.IAdController;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public abstract class BaseAdController implements IAdController {
    private static final int CLICK_TIME_INTERVAL = 1000;
    protected static final int STATE_FINISH = 2;
    protected static final int STATE_REQUEST = 0;
    protected static final int STATE_START = 1;
    private static final String TAG = "BaseAdController";
    protected long mAdStartTime;
    protected Map<String, Integer> mAdStateMap = new ConcurrentHashMap();
    protected Map<String, BidInfo> mAdvItemMap = new ConcurrentHashMap();
    private long mLastClickTime;

    @Override // com.alimm.xadsdk.business.common.interfaces.IAdController
    public void dispose() {
        this.mAdvItemMap.clear();
        this.mAdStateMap.clear();
    }

    /* access modifiers changed from: protected */
    public boolean isClickAllowed(@NonNull String str) {
        if (this.mAdStateMap.get(str).intValue() != 1) {
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "isClickAllowed: not allow because the AD is not shown.");
            }
            return false;
        } else if (System.currentTimeMillis() - this.mLastClickTime >= 1000) {
            return true;
        } else {
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "isClickAllowed: not allow because click too fast.");
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isCloseAllowed(@NonNull String str) {
        if (this.mAdStateMap.get(str).intValue() == 1) {
            return true;
        }
        if (!LogUtils.DEBUG) {
            return false;
        }
        LogUtils.d(TAG, "isCloseAllowed: not allow because the AD is not shown.");
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isFinishAllowed(@NonNull String str) {
        if (this.mAdStateMap.get(str).intValue() == 1) {
            return true;
        }
        if (!LogUtils.DEBUG) {
            return false;
        }
        LogUtils.d(TAG, "isFinishAllowed: not allow because the AD is not shown.");
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isRequestAllowed() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isStartAllowed(@NonNull String str) {
        if (this.mAdStateMap.get(str).intValue() == 0) {
            return true;
        }
        if (!LogUtils.DEBUG) {
            return false;
        }
        LogUtils.d(TAG, "isStartAllowed: not allow because the AD is not got from SDK.");
        return false;
    }

    @Override // com.alimm.xadsdk.business.common.interfaces.IAdController
    public void onAdClick(@NonNull String str) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onAdClick: key = " + str + ",bidInfo = " + this.mAdvItemMap.get(str));
        }
        if (isClickAllowed(str)) {
            this.mLastClickTime = System.currentTimeMillis();
            BidInfo bidInfo = this.mAdvItemMap.get(str);
            if (bidInfo != null) {
                AdSdkManager.getInstance().getExposeManager().exposeCum(bidInfo, false, false);
            } else if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "onAdClick: no bid info found.");
            }
        } else if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onAdClick: fast click skipped.");
        }
    }

    @Override // com.alimm.xadsdk.business.common.interfaces.IAdController
    public void onAdError(@NonNull String str, int i, String str2) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onAdError: key = " + str + ", errCode = " + i + ", errMessage = " + str2 + ",bidInfo = " + this.mAdvItemMap.get(str));
        }
    }

    @Override // com.alimm.xadsdk.business.common.interfaces.IAdController
    public void onAdFinish(@NonNull String str) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onAdFinish: key = " + str + ",bidInfo = " + this.mAdvItemMap.get(str));
        }
        if (isFinishAllowed(str)) {
            this.mAdStateMap.put(str, 2);
            BidInfo bidInfo = this.mAdvItemMap.get(str);
            if (bidInfo != null) {
                AdSdkManager.getInstance().getExposeManager().expose(bidInfo, MonitorType.PLAY_END, true, false);
            } else if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "onAdFinish: no bid info found.");
            }
        }
    }

    @Override // com.alimm.xadsdk.business.common.interfaces.IAdController
    public void onAdInteractionClick(@NonNull String str) {
        BidInfo bidInfo = this.mAdvItemMap.get(str);
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onAdInteractionClick: key = " + str + ",bidInfo = " + bidInfo);
        }
        if (bidInfo != null) {
            AdSdkManager.getInstance().getExposeManager().exposeInteraction(bidInfo, MonitorType.INTERACTION_START, false, false);
        }
    }

    @Override // com.alimm.xadsdk.business.common.interfaces.IAdController
    public void onAdInteractionEnd(@NonNull String str) {
        BidInfo bidInfo = this.mAdvItemMap.get(str);
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onAdInteractionEnd: key = " + str + ",bidInfo = " + bidInfo);
        }
        if (bidInfo != null) {
            AdSdkManager.getInstance().getExposeManager().exposeInteraction(bidInfo, MonitorType.INTERACTION_SUCCESS, false, false);
        }
    }

    @Override // com.alimm.xadsdk.business.common.interfaces.IAdController
    public void onAdInteractionStart(@NonNull String str) {
        BidInfo bidInfo = this.mAdvItemMap.get(str);
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onAdInteractionStart: key = " + str + ",bidInfo = " + bidInfo);
        }
        if (bidInfo != null) {
            AdSdkManager.getInstance().getExposeManager().exposeInteraction(bidInfo, MonitorType.INTERACTION_VIEW_SHOW, true, false);
        }
    }

    @Override // com.alimm.xadsdk.business.common.interfaces.IAdController
    public void onAdSkip(@NonNull String str) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onAdSkip: key = " + str + ",bidInfo = " + this.mAdvItemMap.get(str));
        }
        if (isCloseAllowed(str)) {
            this.mAdStateMap.put(str, 2);
            BidInfo bidInfo = this.mAdvItemMap.get(str);
            if (bidInfo != null) {
                AdSdkManager.getInstance().getExposeManager().expose(bidInfo, "close", true, false);
            } else if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "onAdSkip: no bid info.");
            }
        }
    }

    @Override // com.alimm.xadsdk.business.common.interfaces.IAdController
    public void onAdStart(@NonNull String str) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "onAdStart: key = " + str + ",bidInfo = " + this.mAdvItemMap.get(str));
        }
        if (isStartAllowed(str)) {
            this.mAdStateMap.put(str, 1);
            this.mAdStartTime = SystemClock.elapsedRealtime();
            BidInfo bidInfo = this.mAdvItemMap.get(str);
            if (bidInfo != null) {
                AdSdkManager.getInstance().getExposeManager().exposeSus(bidInfo, true, false);
            } else if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "onAdStart: no bid info found.");
            }
        }
    }
}
