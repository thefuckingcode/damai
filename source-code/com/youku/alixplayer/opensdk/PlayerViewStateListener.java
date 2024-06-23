package com.youku.alixplayer.opensdk;

/* compiled from: Taobao */
public interface PlayerViewStateListener {

    /* compiled from: Taobao */
    public interface ScreenMode {
        public static final int MODE_FULL_SCREEN = 1;
        public static final int MODE_FULL_SCREEN_VERTICAL = 2;
        public static final int MODE_SMALL = 0;
    }

    int getScreenMode();

    boolean isPlayerViewShow();
}
