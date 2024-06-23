package com.youku.resource.utils;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.kvdata.HighPerfSPProviderProxy;

/* compiled from: Taobao */
public class UIMode {
    public static final int CSS_MODE = 4;
    public static final int DARK_MODE = 1;
    public static final int NORMAL_MODE = 0;
    public static final int SKINCHANGED_MODE = 2;
    private static final String TAG = "UIMODE";
    private static final UIMode ourInstance = new UIMode();
    private int uiMode = 0;

    private UIMode() {
        if (AppInfoProviderProxy.getApplication() != null) {
            Log.d(TAG, "app UIMode " + AppInfoProviderProxy.getApplication().getResources().getConfiguration().uiMode + " last UIMode " + HighPerfSPProviderProxy.getInt("ONEARCH_UIMODE", "uimode", this.uiMode));
            getSystemUIMode(AppInfoProviderProxy.getApplication().getResources().getConfiguration().uiMode);
            AppInfoProviderProxy.getApplication().registerComponentCallbacks(new ComponentCallbacks() {
                /* class com.youku.resource.utils.UIMode.AnonymousClass1 */

                public void onConfigurationChanged(Configuration configuration) {
                    Log.d(UIMode.TAG, "onConfigurationChanged " + (configuration.uiMode & 48) + " defaultNightMode " + AppCompatDelegate.getDefaultNightMode());
                    boolean z = false;
                    boolean z2 = AppCompatDelegate.getDefaultNightMode() == 2;
                    if (AppCompatDelegate.getDefaultNightMode() == 1) {
                        z = true;
                    }
                    if (z2 || z) {
                        Log.d(UIMode.TAG, "强制模式，忽略系统变更");
                    } else {
                        UIMode.this.getSystemUIMode(configuration.uiMode);
                    }
                }

                public void onLowMemory() {
                }
            });
        }
    }

    public static UIMode getInstance() {
        return ourInstance;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void getSystemUIMode(int i) {
        int i2 = i & 48;
        if (i2 == 16) {
            setDarkMode(false);
        } else if (i2 == 32) {
            setDarkMode(true);
        }
    }

    public boolean isDarkMode() {
        boolean z = true;
        if ((this.uiMode & 1) <= 0) {
            z = false;
        }
        Log.d(TAG, "is darkMode " + z);
        return z;
    }

    public void setDarkMode(boolean z) {
        Log.d(TAG, "set darkMode " + z);
        if (z != isDarkMode()) {
            if (z) {
                int i = this.uiMode | 1;
                this.uiMode = i;
                HighPerfSPProviderProxy.putInt("ONEARCH_UIMODE", "uimode", i);
            } else {
                int i2 = this.uiMode ^ 1;
                this.uiMode = i2;
                HighPerfSPProviderProxy.putInt("ONEARCH_UIMODE", "uimode", i2);
            }
            ColorConfigureManager.getInstance().onConfigureChanged();
        }
    }
}
