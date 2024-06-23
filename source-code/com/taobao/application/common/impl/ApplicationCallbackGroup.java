package com.taobao.application.common.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* access modifiers changed from: package-private */
@TargetApi(14)
/* compiled from: Taobao */
public class ApplicationCallbackGroup implements Application.ActivityLifecycleCallbacks, ICallbackGroup<Application.ActivityLifecycleCallbacks> {
    private final ArrayList<Application.ActivityLifecycleCallbacks> a = new ArrayList<>();

    ApplicationCallbackGroup() {
    }

    private void c(Runnable runnable) {
        a.g().h(runnable);
    }

    /* renamed from: b */
    public void addCallback(final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            c(new Runnable() {
                /* class com.taobao.application.common.impl.ApplicationCallbackGroup.AnonymousClass8 */

                public void run() {
                    if (!ApplicationCallbackGroup.this.a.contains(activityLifecycleCallbacks)) {
                        ApplicationCallbackGroup.this.a.add(activityLifecycleCallbacks);
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: d */
    public void removeCallback(final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            c(new Runnable() {
                /* class com.taobao.application.common.impl.ApplicationCallbackGroup.AnonymousClass9 */

                public void run() {
                    ApplicationCallbackGroup.this.a.remove(activityLifecycleCallbacks);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    public void onActivityCreated(final Activity activity, final Bundle bundle) {
        c(new Runnable() {
            /* class com.taobao.application.common.impl.ApplicationCallbackGroup.AnonymousClass1 */

            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityCreated(activity, bundle);
                }
            }
        });
    }

    public void onActivityDestroyed(final Activity activity) {
        c(new Runnable() {
            /* class com.taobao.application.common.impl.ApplicationCallbackGroup.AnonymousClass7 */

            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityDestroyed(activity);
                }
            }
        });
    }

    public void onActivityPaused(final Activity activity) {
        c(new Runnable() {
            /* class com.taobao.application.common.impl.ApplicationCallbackGroup.AnonymousClass4 */

            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityPaused(activity);
                }
            }
        });
    }

    public void onActivityResumed(final Activity activity) {
        c(new Runnable() {
            /* class com.taobao.application.common.impl.ApplicationCallbackGroup.AnonymousClass3 */

            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityResumed(activity);
                }
            }
        });
    }

    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        c(new Runnable() {
            /* class com.taobao.application.common.impl.ApplicationCallbackGroup.AnonymousClass6 */

            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivitySaveInstanceState(activity, bundle);
                }
            }
        });
    }

    public void onActivityStarted(final Activity activity) {
        c(new Runnable() {
            /* class com.taobao.application.common.impl.ApplicationCallbackGroup.AnonymousClass2 */

            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityStarted(activity);
                }
            }
        });
    }

    public void onActivityStopped(final Activity activity) {
        c(new Runnable() {
            /* class com.taobao.application.common.impl.ApplicationCallbackGroup.AnonymousClass5 */

            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityStopped(activity);
                }
            }
        });
    }
}
