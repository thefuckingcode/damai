package com.youku.live.dsl.preloader;

import android.content.Context;

/* compiled from: Taobao */
public interface IPreloaderMananger {
    IPreloader createLivePlayControlPreloader(String str, String str2, Context context);

    boolean createPlayerPreloader();

    IPreloader getLivePlayControlPreloader(String str);
}
