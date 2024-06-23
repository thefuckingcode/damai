package me.ele.altriax.launcher.bootstrap.ele;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.altriax.launcher.bootstrap.ele.delegate.RegisterDelegate;
import me.ele.altriax.launcher.bootstrap.ele.strategy.Strategy;

/* compiled from: Taobao */
public class OnLineMonitorRegisterDelegate implements RegisterDelegate {
    private AtomicInteger activityCount = new AtomicInteger(0);
    private final Application application;
    private final RegisterDelegate registerDelegate;
    private AtomicBoolean registered = new AtomicBoolean(false);
    private List<Strategy> strategies = new ArrayList();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface ForegroundChangeListener {
        void onForeground(boolean z);
    }

    public OnLineMonitorRegisterDelegate(@NonNull RegisterDelegate registerDelegate2, @NonNull Application application2) {
        this.registerDelegate = registerDelegate2;
        this.application = application2;
    }

    private void registerForegroundChanged(@NonNull Application application2, @NonNull final ForegroundChangeListener foregroundChangeListener) {
        application2.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            /* class me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegisterDelegate.AnonymousClass2 */

            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (OnLineMonitorRegisterDelegate.this.strategies != null && OnLineMonitorRegisterDelegate.this.strategies.size() > 0) {
                    for (Strategy strategy : OnLineMonitorRegisterDelegate.this.strategies) {
                        strategy.activity(activity, activity.getClass().getName(), bundle);
                    }
                }
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
                OnLineMonitorRegisterDelegate.this.activityCount.getAndIncrement();
                if (OnLineMonitorRegisterDelegate.this.activityCount.get() == 1) {
                    foregroundChangeListener.onForeground(true);
                }
            }

            public void onActivityStopped(Activity activity) {
                OnLineMonitorRegisterDelegate.this.activityCount.getAndDecrement();
                if (OnLineMonitorRegisterDelegate.this.activityCount.get() == 0) {
                    foregroundChangeListener.onForeground(false);
                }
            }
        });
    }

    public void addStrategy(@NonNull Strategy strategy) {
        this.strategies.add(strategy);
    }

    @Override // me.ele.altriax.launcher.bootstrap.ele.delegate.RegisterDelegate
    public void register() {
        registerForegroundChanged(this.application, new ForegroundChangeListener() {
            /* class me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegisterDelegate.AnonymousClass1 */

            @Override // me.ele.altriax.launcher.bootstrap.ele.OnLineMonitorRegisterDelegate.ForegroundChangeListener
            public void onForeground(boolean z) {
                if (!OnLineMonitorRegisterDelegate.this.registered.get()) {
                    OnLineMonitorRegisterDelegate.this.registerDelegate.register();
                    OnLineMonitorRegisterDelegate.this.registered.set(true);
                }
            }
        });
    }
}
