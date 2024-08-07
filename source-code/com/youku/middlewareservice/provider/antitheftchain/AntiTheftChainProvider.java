package com.youku.middlewareservice.provider.antitheftchain;

import android.content.Context;
import java.util.HashMap;

/* compiled from: Taobao */
public interface AntiTheftChainProvider {

    /* compiled from: Taobao */
    public enum AntiTheftChainClientType {
        Unknown,
        Internal,
        External
    }

    String getAntiTheftChainKey(AntiTheftChainClientType antiTheftChainClientType, String str, String str2, Context context, HashMap hashMap);
}
