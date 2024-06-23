package com.ut.mini.crashhandler;

import com.alibaba.motu.crashreporter.IUTCrashCaughtListener;
import java.util.Map;

/* compiled from: Taobao */
public class UTCrashHandlerWapper implements IUTCrashCaughtListener {
    private IUTCrashCaughtListener crashCaughtListener;

    public UTCrashHandlerWapper(IUTCrashCaughtListener iUTCrashCaughtListener) {
        this.crashCaughtListener = iUTCrashCaughtListener;
    }

    @Override // com.alibaba.motu.crashreporter.IUTCrashCaughtListener
    public Map<String, Object> onCrashCaught(Thread thread, Throwable th) {
        IUTCrashCaughtListener iUTCrashCaughtListener = this.crashCaughtListener;
        if (iUTCrashCaughtListener != null) {
            return iUTCrashCaughtListener.onCrashCaught(thread, th);
        }
        return null;
    }
}
