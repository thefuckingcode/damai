package com.taobao.application.common.impl;

import com.taobao.application.common.IPageListener;
import java.util.ArrayList;
import java.util.Iterator;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class PageListenerGroup implements IPageListener, IListenerGroup<IPageListener> {
    private ArrayList<IPageListener> a = new ArrayList<>();

    PageListenerGroup() {
    }

    private void c(Runnable runnable) {
        a.g().h(runnable);
    }

    /* renamed from: b */
    public void addListener(final IPageListener iPageListener) {
        if (iPageListener != null) {
            c(new Runnable() {
                /* class com.taobao.application.common.impl.PageListenerGroup.AnonymousClass2 */

                public void run() {
                    if (!PageListenerGroup.this.a.contains(iPageListener)) {
                        PageListenerGroup.this.a.add(iPageListener);
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: d */
    public void removeListener(final IPageListener iPageListener) {
        if (iPageListener != null) {
            c(new Runnable() {
                /* class com.taobao.application.common.impl.PageListenerGroup.AnonymousClass3 */

                public void run() {
                    PageListenerGroup.this.a.remove(iPageListener);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.IPageListener
    public void onPageChanged(final String str, final int i, final long j) {
        c(new Runnable() {
            /* class com.taobao.application.common.impl.PageListenerGroup.AnonymousClass1 */

            public void run() {
                Iterator it = PageListenerGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((IPageListener) it.next()).onPageChanged(str, i, j);
                }
            }
        });
    }
}
