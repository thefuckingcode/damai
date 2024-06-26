package com.youku.live.dsl.share;

/* compiled from: Taobao */
public enum ShareResult {
    SHARE_RESULT_SUCCESS(0),
    SHARE_RESULT_FAILURE(1),
    SHARE_RESULT_USER_CANCELED(2),
    SHARE_RESULT_UNSUPPORTED(3),
    SHARE_RESULT_NO_IMPLEMENTS(4);
    
    private int shareResult;

    private ShareResult(int i) {
        this.shareResult = i;
    }
}
