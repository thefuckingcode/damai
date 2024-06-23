package com.taobao.zcache;

import androidx.annotation.NonNull;
import com.taobao.application.common.Apm;
import com.taobao.application.common.b;

/* compiled from: Taobao */
public class ZCacheClientServiceDefaultImpl implements IZCacheClientService {
    @Override // com.taobao.zcache.IZCacheClientService
    public void addClientEventListener(@NonNull final IZCacheClientListener iZCacheClientListener) {
        try {
            b.a(new Apm.OnApmEventListener() {
                /* class com.taobao.zcache.ZCacheClientServiceDefaultImpl.AnonymousClass1 */

                @Override // com.taobao.application.common.IApmEventListener
                public void onEvent(int i) {
                    if (i == 2) {
                        iZCacheClientListener.clientActived();
                    } else if (i == 50) {
                        iZCacheClientListener.clientDeactived();
                    }
                }
            });
        } catch (NoClassDefFoundError unused) {
        }
    }
}
