package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerClient;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings;

public abstract class ServiceWorkerController {
    public abstract ServiceWorkerWebSettings getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient);

    public static ServiceWorkerController getInstance(Context context) {
        u a = u.a();
        a.a(context);
        if (a.b()) {
            final IX5CoreServiceWorkerController q = u.a().c().q();
            if (q != null) {
                return new ServiceWorkerController() {
                    /* class com.tencent.smtt.sdk.ServiceWorkerController.AnonymousClass1 */

                    @Override // com.tencent.smtt.sdk.ServiceWorkerController
                    public ServiceWorkerWebSettings getServiceWorkerWebSettings() {
                        return q.getServiceWorkerWebSettings();
                    }

                    @Override // com.tencent.smtt.sdk.ServiceWorkerController
                    public void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient) {
                        q.setServiceWorkerClient(serviceWorkerClient);
                    }
                };
            }
            return null;
        } else if (Build.VERSION.SDK_INT >= 24) {
            return new i();
        } else {
            return null;
        }
    }
}
