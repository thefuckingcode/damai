package cn.damai.solid.listener;

import java.util.Map;

/* compiled from: Taobao */
public interface SoInstallListener {
    Map<String, String> alarmExtraMap();

    void onInstallFail(String str, String str2);

    void onInstallSuccess();
}
