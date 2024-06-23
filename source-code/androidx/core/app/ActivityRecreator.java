package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* access modifiers changed from: package-private */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* compiled from: Taobao */
public final class ActivityRecreator {
    private static final String LOG_TAG = "ActivityRecreator";
    protected static final Class<?> activityThreadClass;
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    protected static final Field mainThreadField = getMainThreadField();
    protected static final Method performStopActivity2ParamsMethod;
    protected static final Method performStopActivity3ParamsMethod;
    protected static final Method requestRelaunchActivityMethod;
    protected static final Field tokenField = getTokenField();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        Object currentlyRecreatingToken;
        private Activity mActivity;
        private boolean mDestroyed = false;
        private final int mRecreatingHashCode;
        private boolean mStarted = false;
        private boolean mStopQueued = false;

        LifecycleCheckCallbacks(@NonNull Activity activity) {
            this.mActivity = activity;
            this.mRecreatingHashCode = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.mActivity == activity) {
                this.mActivity = null;
                this.mDestroyed = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.mDestroyed && !this.mStopQueued && !this.mStarted && ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, activity)) {
                this.mStopQueued = true;
                this.currentlyRecreatingToken = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.mActivity == activity) {
                this.mStarted = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> activityThreadClass2 = getActivityThreadClass();
        activityThreadClass = activityThreadClass2;
        performStopActivity3ParamsMethod = getPerformStopActivity3Params(activityThreadClass2);
        performStopActivity2ParamsMethod = getPerformStopActivity2Params(activityThreadClass2);
        requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(activityThreadClass2);
    }

    private ActivityRecreator() {
    }

    private static Class<?> getActivityThreadClass() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field getMainThreadField() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method getPerformStopActivity2Params(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method getPerformStopActivity3Params(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method getRequestRelaunchActivityMethod(Class<?> cls) {
        if (needsRelaunchCall() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field getTokenField() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean needsRelaunchCall() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    protected static boolean queueOnStopIfNecessary(Object obj, int i, Activity activity) {
        try {
            final Object obj2 = tokenField.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i) {
                    final Object obj3 = mainThreadField.get(activity);
                    mainHandler.postAtFrontOfQueue(new Runnable() {
                        /* class androidx.core.app.ActivityRecreator.AnonymousClass3 */

                        public void run() {
                            try {
                                Method method = ActivityRecreator.performStopActivity3ParamsMethod;
                                if (method != null) {
                                    method.invoke(obj3, obj2, Boolean.FALSE, "AppCompat recreation");
                                    return;
                                }
                                ActivityRecreator.performStopActivity2ParamsMethod.invoke(obj3, obj2, Boolean.FALSE);
                            } catch (RuntimeException e) {
                                if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                                    throw e;
                                }
                            } catch (Throwable th) {
                                Log.e(ActivityRecreator.LOG_TAG, "Exception while invoking performStopActivity", th);
                            }
                        }
                    });
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e(LOG_TAG, "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean recreate(@NonNull Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (needsRelaunchCall() && requestRelaunchActivityMethod == null) {
            return false;
        } else {
            if (performStopActivity2ParamsMethod == null && performStopActivity3ParamsMethod == null) {
                return false;
            }
            try {
                final Object obj2 = tokenField.get(activity);
                if (obj2 == null || (obj = mainThreadField.get(activity)) == null) {
                    return false;
                }
                final Application application = activity.getApplication();
                final LifecycleCheckCallbacks lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
                application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                Handler handler = mainHandler;
                handler.post(new Runnable() {
                    /* class androidx.core.app.ActivityRecreator.AnonymousClass1 */

                    public void run() {
                        LifecycleCheckCallbacks.this.currentlyRecreatingToken = obj2;
                    }
                });
                try {
                    if (needsRelaunchCall()) {
                        Method method = requestRelaunchActivityMethod;
                        Boolean bool = Boolean.FALSE;
                        method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                    } else {
                        activity.recreate();
                    }
                    handler.post(new Runnable() {
                        /* class androidx.core.app.ActivityRecreator.AnonymousClass2 */

                        public void run() {
                            application.unregisterActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                        }
                    });
                    return true;
                } catch (Throwable th) {
                    mainHandler.post(new Runnable() {
                        /* class androidx.core.app.ActivityRecreator.AnonymousClass2 */

                        public void run() {
                            application.unregisterActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                        }
                    });
                    throw th;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
