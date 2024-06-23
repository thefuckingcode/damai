package com.youku.live.widgets.protocol.activity;

/* compiled from: Taobao */
public interface IActivityLifecycleStateChangedProxy {
    void onActivityCreate();

    void onActivityDestroy();

    void onActivityPause();

    void onActivityResume();

    void onActivityStart();

    void onActivityStop();
}
