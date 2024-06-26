package com.alimm.xadsdk.base.expose;

import android.content.Context;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.connectivity.NetworkStateObserver;
import com.alimm.xadsdk.base.core.AdThreadPoolExecutor;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.base.utils.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class RetryExposeManager {
    private static final int DEFAULT_EXPIRE_TIME = 86400000;
    private static final int DELAY_START_TIME = 15000;
    private static final String TAG = "RetryExposeManager";
    private Context mAppContext;
    private RetryMonitorDbHelper mDbHelper;
    private long mExpireTime;
    private ExposeManager mExposeManager;
    private int mMaxRetryTimes;
    private long mPeriodMinutes;
    private ScheduledExecutorService mScheduledExecutor;

    /* compiled from: Taobao */
    private class RetryMonitorTask implements Runnable {
        private RetryMonitorTask() {
        }

        public void run() {
            RetryExposeManager.this.sendRetryMonitor(System.currentTimeMillis());
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SingletonHolder {
        static final RetryExposeManager INSTANCE = new RetryExposeManager();

        private SingletonHolder() {
        }
    }

    private RetryExposeManager() {
        this.mExpireTime = 86400000;
    }

    private void delayToStartRetry() {
        AdThreadPoolExecutor.postDelayed(new Runnable() {
            /* class com.alimm.xadsdk.base.expose.RetryExposeManager.AnonymousClass1 */

            public void run() {
                RetryExposeManager.this.ensureDbHelperNotNull();
                RetryExposeManager.this.mDbHelper.delete(Utils.formatTimeInMillis(System.currentTimeMillis(), RetryMonitorDbHelper.DATE_FORMAT), RetryExposeManager.this.mMaxRetryTimes);
                if (RetryExposeManager.this.mScheduledExecutor == null) {
                    RetryExposeManager.this.mScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                }
                RetryExposeManager.this.mScheduledExecutor.scheduleWithFixedDelay(new RetryMonitorTask(), 0, RetryExposeManager.this.mPeriodMinutes, TimeUnit.MINUTES);
            }
        }, 15000);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void ensureDbHelperNotNull() {
        if (this.mDbHelper == null) {
            this.mDbHelper = new RetryMonitorDbHelper(this.mAppContext);
        }
    }

    public static RetryExposeManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static void recordRetryExposeEnd(int i, @NonNull RetryMonitorInfo retryMonitorInfo) {
        HashMap hashMap = new HashMap(16);
        hashMap.put(AdUtConstants.XAD_UT_ARG_CA, retryMonitorInfo.getGroupId());
        hashMap.put(AdUtConstants.XAD_UT_ARG_IE, retryMonitorInfo.getCreativeId());
        hashMap.put(AdUtConstants.XAD_UT_ARG_IMP_ID, retryMonitorInfo.getImpressionId());
        hashMap.put(AdUtConstants.XAD_UT_ARG_RETRY, String.valueOf(retryMonitorInfo.getRetryTimes()));
        hashMap.put(AdUtConstants.XAD_UT_ARG_EXPOSURE_TYPE, retryMonitorInfo.getMonitorType());
        hashMap.put(AdUtConstants.XAD_UT_ARG_EXPOSURE_SDK, retryMonitorInfo.getMonitorSdk());
        hashMap.put(AdUtConstants.XAD_UT_ARG_EXPOSURE_URL, retryMonitorInfo.getMonitorUrl());
        AdSdkManager.getInstance().getUserTracker().track(AdUtConstants.XAD_ARG1_RETRY_EXPOSE_END, String.valueOf(retryMonitorInfo.getAdType()), String.valueOf(i), hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendRetryMonitor(long j) {
        if (NetworkStateObserver.getInstance().hasInternet()) {
            ensureDbHelperNotNull();
            List<RetryMonitorInfo> query = this.mDbHelper.query(Utils.formatTimeInMillis(j, RetryMonitorDbHelper.DATE_FORMAT));
            if (!query.isEmpty()) {
                int size = query.size();
                if (LogUtils.DEBUG) {
                    LogUtils.d(TAG, "sendRetryMonitor: count = " + size);
                }
                for (int i = 0; i < size; i++) {
                    final RetryMonitorInfo retryMonitorInfo = query.get(i);
                    this.mExposeManager.exposeRetry(retryMonitorInfo, new ExposeCallback() {
                        /* class com.alimm.xadsdk.base.expose.RetryExposeManager.AnonymousClass2 */

                        @Override // com.alimm.xadsdk.base.expose.ExposeCallback
                        public void onFail(int i, String str) {
                            if (LogUtils.DEBUG) {
                                LogUtils.d(RetryExposeManager.TAG, "sendRetryMonitor: fail, code = " + i + ", info = " + retryMonitorInfo);
                            }
                            RetryExposeManager.recordRetryExposeEnd(i, retryMonitorInfo);
                            retryMonitorInfo.incRetryTimes();
                            if (retryMonitorInfo.getRetryTimes() < RetryExposeManager.this.mMaxRetryTimes) {
                                RetryExposeManager.this.mDbHelper.update(retryMonitorInfo.getId(), retryMonitorInfo.getRetryTimes());
                            } else {
                                RetryExposeManager.this.mDbHelper.delete(retryMonitorInfo.getId());
                            }
                        }

                        @Override // com.alimm.xadsdk.base.expose.ExposeCallback
                        public void onSucceed(int i) {
                            if (LogUtils.DEBUG) {
                                LogUtils.d(RetryExposeManager.TAG, "sendRetryMonitor: success, info = " + retryMonitorInfo);
                            }
                            RetryExposeManager.this.mDbHelper.delete(retryMonitorInfo.getId());
                            RetryExposeManager.recordRetryExposeEnd(i, retryMonitorInfo);
                        }
                    });
                }
            } else if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "sendRetryMonitor return because no retry monitor info.");
            }
        } else if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "sendRetryMonitor return because no net.");
        }
    }

    public void addRetryMonitorInfo(BidInfo bidInfo, String str, String str2, String str3) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "addRetryMonitorInfo: type = " + str + ", sdk = " + str2 + ", url = " + str3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        ensureDbHelperNotNull();
        this.mDbHelper.insert(bidInfo, str, str2, str3, 0, currentTimeMillis, currentTimeMillis + this.mExpireTime);
    }

    public void dispose() {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "dispose: mScheduledExecutor = " + this.mScheduledExecutor);
        }
        ScheduledExecutorService scheduledExecutorService = this.mScheduledExecutor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.mScheduledExecutor = null;
        }
    }

    public void init(@NonNull Context context, ExposeManager exposeManager) {
        this.mAppContext = context.getApplicationContext();
        this.mExposeManager = exposeManager;
        ExposeConfig exposeConfig = AdSdkManager.getInstance().getConfig().getExposeConfig();
        this.mMaxRetryTimes = exposeConfig.getMaxRetryTimes();
        this.mPeriodMinutes = exposeConfig.getPeriodMinutes();
        delayToStartRetry();
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "init: context = " + context + ", mPeriodMinutes = " + this.mPeriodMinutes);
        }
    }
}
