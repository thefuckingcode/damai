package com.taobao.power_image.loader;

import com.taobao.power_image.loader.PowerImageLoaderProtocol;
import java.util.HashMap;
import java.util.Map;
import tb.vr1;

/* compiled from: Taobao */
public class a implements PowerImageLoaderProtocol {
    private final Map<String, PowerImageLoaderProtocol> a;

    /* compiled from: Taobao */
    private static class b {
        private static final a a = new a();
    }

    public static a a() {
        return b.a;
    }

    @Override // com.taobao.power_image.loader.PowerImageLoaderProtocol
    public void handleRequest(vr1 vr1, PowerImageLoaderProtocol.PowerImageResponse powerImageResponse) {
        PowerImageLoaderProtocol powerImageLoaderProtocol = this.a.get(vr1.b);
        if (powerImageLoaderProtocol != null) {
            powerImageLoaderProtocol.handleRequest(vr1, powerImageResponse);
            return;
        }
        throw new IllegalStateException("PowerImageLoader for " + vr1.b + " has not been registered.");
    }

    private a() {
        this.a = new HashMap();
    }
}
