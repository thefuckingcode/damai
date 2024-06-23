package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ShareInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String shareImage;
    @Nullable
    private String shareSubTitle;
    @Nullable
    private String shareTitle;
    @Nullable
    private String shareUrl;

    @Nullable
    public final String getShareImage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1813489087")) {
            return this.shareImage;
        }
        return (String) ipChange.ipc$dispatch("1813489087", new Object[]{this});
    }

    @Nullable
    public final String getShareSubTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "637679882")) {
            return this.shareSubTitle;
        }
        return (String) ipChange.ipc$dispatch("637679882", new Object[]{this});
    }

    @Nullable
    public final String getShareTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1282391612")) {
            return this.shareTitle;
        }
        return (String) ipChange.ipc$dispatch("1282391612", new Object[]{this});
    }

    @Nullable
    public final String getShareUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "142647827")) {
            return this.shareUrl;
        }
        return (String) ipChange.ipc$dispatch("142647827", new Object[]{this});
    }

    public final void setShareImage(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1726296577")) {
            ipChange.ipc$dispatch("-1726296577", new Object[]{this, str});
            return;
        }
        this.shareImage = str;
    }

    public final void setShareSubTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "719543468")) {
            ipChange.ipc$dispatch("719543468", new Object[]{this, str});
            return;
        }
        this.shareSubTitle = str;
    }

    public final void setShareTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010449118")) {
            ipChange.ipc$dispatch("-1010449118", new Object[]{this, str});
            return;
        }
        this.shareTitle = str;
    }

    public final void setShareUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244787499")) {
            ipChange.ipc$dispatch("244787499", new Object[]{this, str});
            return;
        }
        this.shareUrl = str;
    }
}
