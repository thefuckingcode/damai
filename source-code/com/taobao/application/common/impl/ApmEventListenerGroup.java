package com.taobao.application.common.impl;

import com.taobao.application.common.IApmEventListener;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
public class ApmEventListenerGroup implements IApmEventListener, IListenerGroup<IApmEventListener> {
    private final ArrayList<IApmEventListener> a = new ArrayList<>();

    private void c(Runnable runnable) {
        a.g().h(runnable);
    }

    /* renamed from: b */
    public void addListener(final IApmEventListener iApmEventListener) {
        if (iApmEventListener != null) {
            c(new Runnable() {
                /* class com.taobao.application.common.impl.ApmEventListenerGroup.AnonymousClass2 */

                public void run() {
                    if (!ApmEventListenerGroup.this.a.contains(iApmEventListener)) {
                        ApmEventListenerGroup.this.a.add(iApmEventListener);
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: d */
    public void removeListener(final IApmEventListener iApmEventListener) {
        if (iApmEventListener != null) {
            c(new Runnable() {
                /* class com.taobao.application.common.impl.ApmEventListenerGroup.AnonymousClass3 */

                public void run() {
                    ApmEventListenerGroup.this.a.remove(iApmEventListener);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.IApmEventListener
    public void onEvent(final int i) {
        c(new Runnable() {
            /* class com.taobao.application.common.impl.ApmEventListenerGroup.AnonymousClass1 */

            public void run() {
                Iterator it = ApmEventListenerGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((IApmEventListener) it.next()).onEvent(i);
                }
            }
        });
    }
}
