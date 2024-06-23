package com.alibaba.poplayer.trigger;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.layermanager.e;
import com.alibaba.poplayer.trigger.view.d;
import com.alibaba.poplayer.utils.Monitor;
import java.lang.ref.WeakReference;
import tb.c7;
import tb.cr1;
import tb.eu2;
import tb.fo1;

@Monitor.TargetClass
/* compiled from: Taobao */
public class InternalTriggerController implements Application.ActivityLifecycleCallbacks {
    @Monitor.TargetField(name = "page")
    private WeakReference<Activity> a;
    private boolean b = false;

    /* compiled from: Taobao */
    private static class FragmentSwitchBroadcastReceiver extends BroadcastReceiver {
        private InternalTriggerController a;

        public FragmentSwitchBroadcastReceiver(InternalTriggerController internalTriggerController) {
            this.a = internalTriggerController;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra(PopLayer.EXTRA_KEY_FRAGMENT_NAME);
                String stringExtra2 = intent.getStringExtra(PopLayer.EXTRA_KEY_FRAGMENT_PARAM);
                boolean booleanExtra = intent.getBooleanExtra(PopLayer.EXTRA_KEY_FRAGMENT_NEED_ACTIVITY_PARAM, false);
                if (TextUtils.isEmpty(stringExtra)) {
                    cr1.b("FragmentSwitchBroadcastReceiver.onReceive?fragmentName is empty", new Object[0]);
                    return;
                }
                this.a.g(stringExtra, stringExtra2, booleanExtra);
                cr1.b("FragmentSwitchBroadcastReceiver.onReceive?fragmentName=%s,param=%s,needAcParam=%s", stringExtra, stringExtra2, Boolean.valueOf(booleanExtra));
            } catch (Throwable th) {
                cr1.c("FragmentSwitchBroadcastReceiver.onReceive.fail", th);
            }
        }
    }

    /* compiled from: Taobao */
    private class InternalBroadcastReceiver extends BroadcastReceiver {
        public InternalBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra("event");
                String stringExtra2 = intent.getStringExtra("param");
                String stringExtra3 = intent.getStringExtra(PopLayer.EXTRA_KEY_EXTRA_PARAMS);
                cr1.b("InternalBroadcastReceiver.onReceive?uri=%s&param=%s", stringExtra, stringExtra2);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (InternalTriggerController.this.c() == null) {
                        cr1.b("InternalBroadcastReceiver.onReceive curActivity is empty.", new Object[0]);
                    } else if (stringExtra.startsWith(c7.APP_SCHEME)) {
                        c7.A().x(stringExtra, stringExtra2);
                    } else if (stringExtra.startsWith(fo1.PAGE_SCHEME)) {
                        fo1.A().x(stringExtra, stringExtra2);
                    } else if (stringExtra.startsWith(d.VIEW_SCHEME)) {
                        d.M().C(stringExtra, stringExtra2);
                    } else {
                        if (!TextUtils.isEmpty(stringExtra3) && stringExtra3.contains("clean")) {
                            c7.A().n(InternalTriggerController.this.c(), InternalTriggerController.b(InternalTriggerController.this.c()));
                            fo1.A().n(InternalTriggerController.this.c(), InternalTriggerController.b(InternalTriggerController.this.c()));
                            d.M().n(InternalTriggerController.this.c(), InternalTriggerController.b(InternalTriggerController.this.c()));
                        }
                        c7.A().x(stringExtra, stringExtra2);
                        fo1.A().x(stringExtra, stringExtra2);
                        d.M().C(stringExtra, stringExtra2);
                    }
                }
            } catch (Throwable th) {
                cr1.c("InternalBroadcastReceiver.onReceive.fail", th);
            }
        }
    }

    public InternalTriggerController(Application application) {
        application.registerActivityLifecycleCallbacks(this);
        LocalBroadcastManager.getInstance(application).registerReceiver(new InternalBroadcastReceiver(), new IntentFilter(PopLayer.ACTION_POP));
        LocalBroadcastManager.getInstance(application).registerReceiver(new FragmentSwitchBroadcastReceiver(this), new IntentFilter(PopLayer.ACTION_FRAGMENT_SWITCH));
    }

    public static View a(Activity activity) {
        if (e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
            activity = activity.getParent();
        }
        return activity.getWindow().findViewById(16908290);
    }

    public static String b(Activity activity) {
        if (activity == null) {
            return "";
        }
        String obj = activity.toString();
        return (!e.i || !activity.isChild() || !(activity.getParent() instanceof Activity)) ? obj : activity.getParent().toString();
    }

    private boolean d(Activity activity) {
        return ((PopLayer.PopupAllowedFromFragment) activity.getClass().getAnnotation(PopLayer.PopupAllowedFromFragment.class)) != null;
    }

    private boolean e(Activity activity) {
        PopLayer.PopupOnlyManually popupOnlyManually = (PopLayer.PopupOnlyManually) activity.getClass().getAnnotation(PopLayer.PopupOnlyManually.class);
        boolean isMunualPopPageContains = PopLayer.getReference().isMunualPopPageContains(activity.getClass().getName());
        cr1.b("EventManager.isManaulPopup?contains=%s&popupOnlyManually=%s", Boolean.valueOf(isMunualPopPageContains), popupOnlyManually);
        return isMunualPopPageContains || popupOnlyManually != null;
    }

    private void f(Activity activity, String str, String str2, boolean z) {
        String str3;
        if (activity == null) {
            try {
                cr1.b("EventManager.onActivityOrInnerViewResumed.activity is null", new Object[0]);
            } catch (Throwable th) {
                cr1.c("EventManager.onActivityOrInnerViewResumed.fail.", th);
            }
        } else {
            boolean z2 = !TextUtils.isEmpty(str);
            if (!z2 || d(activity)) {
                boolean e = e(activity);
                Activity activity2 = (Activity) eu2.c(this.a);
                if (!PopLayer.getReference().isSamePage(activity, activity2) || z2) {
                    if (PopLayer.getReference().isValidActivity(activity)) {
                        if (activity2 != null) {
                            fo1.A().n(activity2, b(activity2));
                            d.M().n(activity2, b(activity2));
                            c7.A().n(activity2, b(activity2));
                        }
                        this.a = new WeakReference<>(activity);
                        if (z2) {
                            str3 = activity.getClass().getName() + "." + str;
                        } else {
                            str3 = activity.getClass().getName();
                        }
                        if (z && TextUtils.isEmpty(str2)) {
                            str2 = PopLayer.getReference().getActivityInfo(activity);
                        }
                        PopLayer.getReference().internalNotifyNativeUrlChanged(str2);
                        String b2 = b(activity);
                        e.f().k(activity, b2);
                        c7.A().u(activity, str3, str2, b2);
                        fo1.A().u(activity, str3, str2, b2);
                        d.M().u(activity, str3, str2, b2);
                        if (!e) {
                            c7.A().D();
                            fo1.A().B();
                            d.M().O();
                            cr1.b("EventManager.onActivityOrFragmentResumed.posttoService{uri:%s,param:%s}", str3, str2);
                        }
                    }
                } else if (!e) {
                    c7.A().o();
                    fo1.A().o();
                    d.M().o();
                }
            } else {
                cr1.b("EventManager.onActivityOrFragmentResumed.isAllowedPopupFromFragmentNotice=false", new Object[0]);
            }
        }
    }

    public Activity c() {
        return (Activity) eu2.c(this.a);
    }

    /* access modifiers changed from: package-private */
    public void g(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str)) {
                f((Activity) eu2.c(this.a), str, str2, z);
            }
        } catch (Throwable th) {
            cr1.c("EventManager.onFragmentResumed.fail.", th);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            cr1.b("EventManager.onActivityCreated.activity{%s}.withParam{%s}", activity.getClass().getName(), activity.getIntent() == null ? null : activity.getIntent().getDataString());
        } catch (Throwable th) {
            cr1.c("EventManager.onActivityCreated.error", th);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            fo1.A().y(b(activity));
        }
    }

    public void onActivityPaused(Activity activity) {
        try {
            cr1.b("EventManager.onActivityPaused.activity{%s}", activity.getClass().getName());
            c7.A().s();
            fo1.A().s();
            d.M().s();
            d.M().l(activity);
            fo1.A().l(activity);
            c7.A().l(activity);
        } catch (Throwable th) {
            cr1.c("EventManager.onActivityPaused.removeWebView.error.", th);
        }
    }

    public void onActivityResumed(Activity activity) {
        try {
            f(activity, null, null, true);
            d.M().m(activity);
            fo1.A().m(activity);
            c7.A().m(activity);
            if (!this.b) {
                PopLayer.getReference().onCurActivityInited();
                this.b = true;
            }
        } catch (Throwable th) {
            cr1.c("onActivityResumed error", th);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
