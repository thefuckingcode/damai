package com.alibaba.analytics.version;

/* compiled from: Taobao */
public interface IUTBuildInfo {
    String getBuildID();

    String getFullSDKVersion();

    String getGitCommitID();

    String getShortSDKVersion();

    boolean isTestMode();
}
