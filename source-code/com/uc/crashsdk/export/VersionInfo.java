package com.uc.crashsdk.export;

/* compiled from: Taobao */
public class VersionInfo {
    public String mBuildId = null;
    public String mSubVersion = null;
    public String mVersion = null;

    public VersionInfo() {
    }

    public VersionInfo(VersionInfo versionInfo) {
        this.mVersion = versionInfo.mVersion;
        this.mSubVersion = versionInfo.mSubVersion;
        this.mBuildId = versionInfo.mBuildId;
    }
}
