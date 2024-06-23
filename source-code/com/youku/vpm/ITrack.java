package com.youku.vpm;

/* compiled from: Taobao */
public interface ITrack {
    String getId();

    String getString(String str);

    IVpmFullInfo getVpmFullInfo();

    IVpmInfo getVpmInfo();

    void putString(String str, String str2);
}
