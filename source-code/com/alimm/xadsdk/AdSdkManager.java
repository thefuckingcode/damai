package com.alimm.xadsdk;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.xadsdk.base.expose.ExposeManager;
import com.alimm.xadsdk.base.expose.IExposer;
import com.alimm.xadsdk.base.ut.UserTracker;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.request.Ipv4Requester;

/* compiled from: Taobao */
public class AdSdkManager {
    private static final String TAG = "AdSdkManager";
    private Application mAppContext;
    private AdSdkConfig mConfig;
    private ExposeManager mExposeManager;
    private boolean mHasInit;
    private UserTracker mUserTracker;

    /* compiled from: Taobao */
    private static class SingletonHolder {
        static final AdSdkManager INSTANCE = new AdSdkManager();

        private SingletonHolder() {
        }
    }

    private AdSdkManager() {
        this.mHasInit = false;
    }

    public static AdSdkManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @NonNull
    public Application getAppContext() {
        if (this.mHasInit) {
            return this.mAppContext;
        }
        throw new RuntimeException("App should call init() to initialize first.");
    }

    @NonNull
    public AdSdkConfig getConfig() {
        AdSdkConfig adSdkConfig = this.mConfig;
        if (adSdkConfig != null) {
            return adSdkConfig;
        }
        throw new RuntimeException("App must call init() to set a NonNull config first!");
    }

    @NonNull
    public ExposeManager getExposeManager() {
        if (this.mHasInit) {
            return this.mExposeManager;
        }
        throw new RuntimeException("App should call init() to initialize first.");
    }

    @Nullable
    public UserTracker getUserTracker() {
        if (this.mUserTracker == null) {
            this.mUserTracker = new UserTracker(this.mConfig.getUserTrackerImpl());
        }
        return this.mUserTracker;
    }

    public boolean hasInit() {
        return this.mHasInit;
    }

    public void init(Application application, AdSdkConfig adSdkConfig) {
        if (LogUtils.DEBUG) {
            LogUtils.i(TAG, "init: appContext = " + application + ", mHasInit = " + this.mHasInit + ", config = " + adSdkConfig);
        }
        if (application == null) {
            throw new RuntimeException("App should set a NonNull context when init().");
        } else if (adSdkConfig != null) {
            this.mHasInit = true;
            this.mAppContext = application;
            this.mConfig = adSdkConfig;
            this.mExposeManager = new ExposeManager(application, adSdkConfig);
            if (adSdkConfig.getNeedGetIpv4()) {
                Ipv4Requester.getIpv4Async();
            }
        } else {
            throw new RuntimeException("App should set a NonNull config when init().");
        }
    }

    public void registerExposer(String str, @NonNull IExposer iExposer) {
        if (!TextUtils.equals("0", str)) {
            getExposeManager().registerExposer(str, iExposer);
            return;
        }
        throw new RuntimeException("App should NOT register default exposer.");
    }
}
