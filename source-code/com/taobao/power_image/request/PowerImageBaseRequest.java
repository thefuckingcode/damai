package com.taobao.power_image.request;

import com.taobao.power_image.dispatcher.PowerImageDispatcher;
import com.taobao.power_image.loader.PowerImageLoaderProtocol;
import com.taobao.power_image.loader.PowerImageResult;
import java.util.HashMap;
import java.util.Map;
import tb.ur1;
import tb.vr1;

/* compiled from: Taobao */
public abstract class PowerImageBaseRequest {
    public static final String RENDER_TYPE_EXTERNAL = "external";
    public static final String RENDER_TYPE_TEXTURE = "texture";
    private vr1 a;
    String b;
    protected String c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements PowerImageLoaderProtocol.PowerImageResponse {
        a() {
        }

        @Override // com.taobao.power_image.loader.PowerImageLoaderProtocol.PowerImageResponse
        public void onResult(PowerImageResult powerImageResult) {
            PowerImageBaseRequest.this.d(powerImageResult);
        }
    }

    public PowerImageBaseRequest(Map<String, Object> map) {
        this.b = (String) map.get("uniqueKey");
        this.a = vr1.a(map);
    }

    private void f() {
        com.taobao.power_image.loader.a.a().handleRequest(this.a, new a());
    }

    public boolean a() {
        boolean z = this.a != null;
        this.c = z ? "initializeSucceed" : "initializeFailed";
        return z;
    }

    public Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("uniqueKey", this.b);
        hashMap.put("state", this.c);
        return hashMap;
    }

    public void c(final String str) {
        PowerImageDispatcher.c().e(new Runnable() {
            /* class com.taobao.power_image.request.PowerImageBaseRequest.AnonymousClass3 */

            public void run() {
                PowerImageBaseRequest powerImageBaseRequest = PowerImageBaseRequest.this;
                powerImageBaseRequest.c = "loadFailed";
                Map<String, Object> b = powerImageBaseRequest.b();
                String str = str;
                if (str == null) {
                    str = "failed!";
                }
                b.put("errMsg", str);
                ur1.b.a().b(b, false);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public abstract void d(PowerImageResult powerImageResult);

    public void e() {
        PowerImageDispatcher.c().e(new Runnable() {
            /* class com.taobao.power_image.request.PowerImageBaseRequest.AnonymousClass2 */

            public void run() {
                PowerImageBaseRequest.this.c = "loadSucceed";
                ur1.b.a().b(PowerImageBaseRequest.this.b(), true);
            }
        });
    }

    public boolean g() {
        if ((!"initializeSucceed".equals(this.c) && !"loadFailed".equals(this.c)) || this.a == null) {
            return false;
        }
        f();
        return true;
    }

    public boolean h() {
        return false;
    }
}
