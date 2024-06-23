package com.youku.skinmanager;

import android.content.Context;
import com.youku.skinmanager.impl.SkinManagerImpl;

/* compiled from: Taobao */
public class SkinManager {
    public static Context sContext;

    public static ISkinManager getInstance() {
        return SkinManagerImpl.getInstance();
    }
}
