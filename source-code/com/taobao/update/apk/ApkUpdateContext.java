package com.taobao.update.apk;

import tb.dj2;
import tb.ns2;

/* compiled from: Taobao */
public class ApkUpdateContext extends dj2 {
    public String apkPath;
    public boolean background;
    public Boolean exceedUpdateTimes = Boolean.FALSE;
    public boolean hasNotified;
    public boolean isDownloadError;
    public MainUpdateData mainUpdate;
    public NotifyPolicy notifyPolicy = NotifyPolicy.DEFAULT;
    public NotifySource updateAlertSource = NotifySource.UPDATE;

    /* compiled from: Taobao */
    enum NotifyPolicy {
        DEFAULT,
        SCENCE
    }

    /* compiled from: Taobao */
    public enum NotifySource {
        UPDATE
    }

    public boolean isDefaultUpdate() {
        int i;
        if (2 != ns2.getNetworkType() && (3 == (i = this.mainUpdate.remindStrategy) || 5 == i)) {
            return true;
        }
        if (2 == ns2.getNetworkType() && 8 == this.mainUpdate.remindStrategy) {
            return true;
        }
        return false;
    }

    public boolean isForceUpdate() {
        if (2 == this.mainUpdate.remindStrategy) {
            return true;
        }
        if (2 == ns2.getNetworkType() && 3 == this.mainUpdate.remindStrategy) {
            return true;
        }
        return false;
    }

    public boolean isSilentUpdate() {
        if (6 == this.mainUpdate.remindStrategy) {
            return true;
        }
        if (2 != ns2.getNetworkType()) {
            return false;
        }
        int i = this.mainUpdate.remindStrategy;
        if (4 == i || 5 == i) {
            return true;
        }
        return false;
    }

    public boolean skipUpdate() {
        if (7 == this.mainUpdate.remindStrategy) {
            return true;
        }
        if (2 == ns2.getNetworkType()) {
            return false;
        }
        int i = this.mainUpdate.remindStrategy;
        if (4 == i || 8 == i) {
            return true;
        }
        return false;
    }
}
