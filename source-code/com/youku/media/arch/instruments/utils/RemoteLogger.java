package com.youku.media.arch.instruments.utils;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public class RemoteLogger {
    private static IRemoteAdapter sRemoteAdaptor;

    /* compiled from: Taobao */
    public interface IRemoteAdapter {
        void log(String str, String str2);
    }

    public static IRemoteAdapter getRemoteAdaptor() {
        return sRemoteAdaptor;
    }

    public static void log(String str, String str2) {
        IRemoteAdapter iRemoteAdapter = sRemoteAdaptor;
        if (iRemoteAdapter != null) {
            iRemoteAdapter.log(str, str2);
        }
    }

    public static void setRemoteAdapter(IRemoteAdapter iRemoteAdapter) {
        sRemoteAdaptor = iRemoteAdapter;
    }
}
