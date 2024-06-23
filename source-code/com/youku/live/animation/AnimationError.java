package com.youku.live.animation;

/* compiled from: Taobao */
public class AnimationError {
    public static final int CODE_NO_RESOURCE = 10001;
    public static final String MSG_NO_RESOURCE = "resource no found";
    public int errorCode = 10001;
    public String errorMessage = MSG_NO_RESOURCE;

    public AnimationError() {
    }

    public AnimationError(int i, String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }
}
