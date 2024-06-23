package com.youku.alixplayer.middleware;

import androidx.annotation.Keep;
import com.youku.alixplayer.util.Destructable;
import com.youku.alixplayer.util.SystemSoLoader;
import java.util.Map;

@Keep
/* compiled from: Taobao */
public abstract class DefaultRenderMiddleware extends IRenderMiddleware implements Destructable {
    static {
        SystemSoLoader.load("alixplayer");
    }

    private native void deinit();

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        deinit();
    }

    /* access modifiers changed from: protected */
    @Override // com.youku.alixplayer.middleware.IRenderMiddleware
    public native long init();

    public abstract boolean processData(byte[] bArr, Map<Integer, String> map, long j, long j2, long j3, long j4, long j5);
}
