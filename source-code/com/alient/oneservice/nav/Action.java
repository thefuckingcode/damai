package com.alient.oneservice.nav;

import android.os.Bundle;
import com.alient.oneservice.ut.TrackInfo;
import java.io.Serializable;

/* compiled from: Taobao */
public class Action implements Serializable {
    private int actionType;
    private String actionUrl;
    private Bundle extra;
    private TrackInfo trackInfo;

    public int getActionType() {
        return this.actionType;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public Bundle getExtra() {
        return this.extra;
    }

    public TrackInfo getTrackInfo() {
        return this.trackInfo;
    }

    public void setActionType(int i) {
        this.actionType = i;
    }

    public void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public void setExtra(Bundle bundle) {
        this.extra = bundle;
    }

    public void setTrackInfo(TrackInfo trackInfo2) {
        this.trackInfo = trackInfo2;
    }
}
