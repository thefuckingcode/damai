package com.youku.middlewareservice.provider.darkmode;

/* compiled from: Taobao */
public interface DarkModeProvider {
    String getDarkModeStatus();

    boolean isDarkMode();

    void onConfigureChanged();

    boolean showdDarkmodeSwitch();
}
