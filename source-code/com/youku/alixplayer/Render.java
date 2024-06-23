package com.youku.alixplayer;

import androidx.annotation.Keep;
import com.youku.alixplayer.util.Destructable;
import com.youku.alixplayer.util.SystemSoLoader;

@Keep
/* compiled from: Taobao */
public class Render implements Destructable {
    private long mNativeId = init();

    static {
        SystemSoLoader.load("alixplayer");
    }

    private native void deinit();

    private native long init();

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        deinit();
    }
}
