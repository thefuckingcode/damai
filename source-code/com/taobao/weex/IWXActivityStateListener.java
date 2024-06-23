package com.taobao.weex;

@Deprecated
/* compiled from: Taobao */
public interface IWXActivityStateListener {
    boolean onActivityBack();

    void onActivityCreate();

    void onActivityDestroy();

    void onActivityPause();

    void onActivityResume();

    void onActivityStart();

    void onActivityStop();
}
