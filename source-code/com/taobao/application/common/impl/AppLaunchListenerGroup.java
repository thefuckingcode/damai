package com.taobao.application.common.impl;

import com.taobao.application.common.IAppLaunchListener;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class AppLaunchListenerGroup implements IAppLaunchListener, IListenerGroup<IAppLaunchListener> {
    private final List<IAppLaunchListener> a = new ArrayList(2);

    AppLaunchListenerGroup() {
    }

    private void c(Runnable runnable) {
        a.g().h(runnable);
    }

    /* renamed from: b */
    public void addListener(final IAppLaunchListener iAppLaunchListener) {
        if (iAppLaunchListener != null) {
            c(new Runnable() {
                /* class com.taobao.application.common.impl.AppLaunchListenerGroup.AnonymousClass1 */

                public void run() {
                    if (!AppLaunchListenerGroup.this.a.contains(iAppLaunchListener)) {
                        AppLaunchListenerGroup.this.a.add(iAppLaunchListener);
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: d */
    public void removeListener(final IAppLaunchListener iAppLaunchListener) {
        if (iAppLaunchListener != null) {
            c(new Runnable() {
                /* class com.taobao.application.common.impl.AppLaunchListenerGroup.AnonymousClass2 */

                public void run() {
                    AppLaunchListenerGroup.this.a.remove(iAppLaunchListener);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.IAppLaunchListener
    public void onLaunchChanged(final int i, final int i2) {
        c(new Runnable() {
            /* class com.taobao.application.common.impl.AppLaunchListenerGroup.AnonymousClass3 */

            public void run() {
                for (IAppLaunchListener iAppLaunchListener : AppLaunchListenerGroup.this.a) {
                    iAppLaunchListener.onLaunchChanged(i, i2);
                }
            }
        });
    }
}
