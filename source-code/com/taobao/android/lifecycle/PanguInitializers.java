package com.taobao.android.lifecycle;

import android.app.Activity;
import android.os.Build;
import android.os.Debug;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.content.ContextCompat;
import com.taobao.android.lifecycle.PanguApplication;
import com.taobao.android.task.Coordinator;
import com.uc.webview.export.extension.UCCore;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.NonNullByDefault;
import javax.annotation.Nullable;
import tb.u30;

@NonNullByDefault
/* compiled from: Taobao */
public abstract class PanguInitializers {
    @Nullable
    protected PanguApplication mApplication;
    protected final ArrayList<Method> mAsyncInitializers = new ArrayList<>();
    protected final ArrayList<Method> mDelayedInitializers = new ArrayList<>();
    protected final SparseArray<SparseArray<CopyOnWriteArrayList<Method>>> mGlobalFlowInitializers = new SparseArray<>();
    protected final AtomicInteger mMethodCount = new AtomicInteger();
    protected String mPackageName;
    protected String[] mPermission = null;
    protected String mProcessName;
    protected final SparseArray<ArrayList<Method>> mSyncInitializers = new SparseArray<>();
    protected final SparseArray<SparseArray<CopyOnWriteArrayList<Method>>> mUIFlowInitializers = new SparseArray<>();

    /* access modifiers changed from: protected */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface Async {
    }

    /* access modifiers changed from: protected */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface Delayed {
    }

    /* access modifiers changed from: protected */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface Flow {
        int value() default 0;
    }

    /* access modifiers changed from: protected */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface Global {
    }

    /* access modifiers changed from: protected */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface Permission {
        String[] value() default {};
    }

    /* access modifiers changed from: protected */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface Priority {
        int value();
    }

    /* access modifiers changed from: protected */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface Process {
        String[] value() default {};
    }

    /* compiled from: Taobao */
    public static class UnqualifiedInitializerError extends Error {
        private static final long serialVersionUID = 1;

        public UnqualifiedInitializerError(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    class a implements PanguApplication.CrossActivityLifecycleCallback {
        final /* synthetic */ PanguApplication a;

        a(PanguApplication panguApplication) {
            this.a = panguApplication;
        }

        @Override // com.taobao.android.lifecycle.PanguApplication.CrossActivityLifecycleCallback
        public void onCreated(Activity activity) {
            PanguInitializers.this.doInitOnFistActivityCreate(activity);
            PanguInitializers.this.startInitializersAnnotatedBy(null);
        }

        @Override // com.taobao.android.lifecycle.PanguApplication.CrossActivityLifecycleCallback
        public void onDestroyed(Activity activity) {
        }

        @Override // com.taobao.android.lifecycle.PanguApplication.CrossActivityLifecycleCallback
        public void onStarted(Activity activity) {
            PanguInitializers.this.doInitOnFistActivityStarted(activity);
            this.a.unregisterCrossActivityLifecycleCallback(this);
            Coordinator.scheduleIdleTasks();
        }

        @Override // com.taobao.android.lifecycle.PanguApplication.CrossActivityLifecycleCallback
        public void onStopped(Activity activity) {
        }
    }

    public PanguInitializers(String str, String str2) {
        this.mProcessName = str;
        this.mPackageName = str2;
    }

    /* access modifiers changed from: protected */
    public void doInitOnFistActivityCreate(Activity activity) {
    }

    /* access modifiers changed from: protected */
    public void doInitOnFistActivityStarted(Activity activity) {
    }

    /* access modifiers changed from: protected */
    public PanguApplication getApplication() {
        return this.mApplication;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Method getInitializer(String str) {
        String str2 = UCCore.LEGACY_EVENT_INIT + str;
        Iterator<Method> it = this.mAsyncInitializers.iterator();
        while (it.hasNext()) {
            Method next = it.next();
            if (str2.equals(next.getName())) {
                return next;
            }
        }
        Iterator<Method> it2 = this.mDelayedInitializers.iterator();
        while (it2.hasNext()) {
            Method next2 = it2.next();
            if (str2.equals(next2.getName())) {
                return next2;
            }
        }
        for (int i = 0; i < this.mSyncInitializers.size(); i++) {
            Iterator<Method> it3 = this.mSyncInitializers.valueAt(i).iterator();
            while (it3.hasNext()) {
                Method next3 = it3.next();
                if (str2.equals(next3.getName())) {
                    return next3;
                }
            }
        }
        if (!u30.b()) {
            return null;
        }
        throw new NoSuchMethodError(str2 + " (used in @Require)");
    }

    /* access modifiers changed from: protected */
    public void invokeInitializer(Method method) {
        Permission permission;
        if (Build.VERSION.SDK_INT >= 23 && (permission = (Permission) method.getAnnotation(Permission.class)) != null) {
            for (String str : permission.value()) {
                if (ContextCompat.checkSelfPermission(this.mApplication, str) != 0) {
                    return;
                }
            }
        }
        long nanoTime = System.nanoTime();
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
        try {
            method.invoke(this, new Object[0]);
            onInitializerTimeing(method.getName().substring(4), (Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000, (System.nanoTime() - nanoTime) / 1000000);
            if (this.mMethodCount.decrementAndGet() != 0) {
                return;
            }
        } catch (Exception e) {
            if (!u30.b()) {
                onInitializerException(method, e);
            } else {
                onInitializerException(method, e);
            }
            Log.e("Pangu", "invoke exception:" + method.getName(), e);
            onInitializerTimeing(method.getName().substring(4), (Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000, (System.nanoTime() - nanoTime) / 1000000);
            if (this.mMethodCount.decrementAndGet() != 0) {
                return;
            }
        } catch (Throwable th) {
            onInitializerTimeing(method.getName().substring(4), (Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000, (System.nanoTime() - nanoTime) / 1000000);
            if (this.mMethodCount.decrementAndGet() == 0) {
                onInitializerFinish();
            }
            throw th;
        }
        onInitializerFinish();
    }

    public abstract void onInitializerException(Method method, Exception exc);

    public void onInitializerFinish() {
    }

    public void onInitializerTimeing(String str, long j, long j2) {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0174  */
    public void parse() {
        boolean z;
        int i;
        int i2;
        SparseArray<CopyOnWriteArrayList<Method>> sparseArray;
        Priority priority;
        int i3;
        CopyOnWriteArrayList<Method> copyOnWriteArrayList;
        SparseArray<CopyOnWriteArrayList<Method>> sparseArray2;
        boolean b = u30.b();
        String str = this.mProcessName;
        Method[] declaredMethods = getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            String name = method.getName();
            if (name.length() >= 5 && name.startsWith(UCCore.LEGACY_EVENT_INIT) && Character.isUpperCase(name.charAt(4))) {
                if (b) {
                    if ((method.getModifiers() & 2) != 0) {
                        throw new UnqualifiedInitializerError("Private: " + name);
                    } else if ((method.getModifiers() & 8) != 0) {
                        throw new UnqualifiedInitializerError("Static: " + name);
                    } else if (method.getParameterTypes().length != 0) {
                        throw new UnqualifiedInitializerError("With parameters: " + name);
                    } else if (method.getReturnType() != Void.TYPE) {
                        throw new UnqualifiedInitializerError("Non-void return type: " + name);
                    }
                }
                Process process = (Process) method.getAnnotation(Process.class);
                if (process != null) {
                    String[] value = process.value();
                    int length = value.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        String str2 = value[i4];
                        if (!(str2 == null || str == null || str2.equalsIgnoreCase(str))) {
                            z = true;
                            break;
                        }
                        i4++;
                    }
                    if (!z && (Build.VERSION.SDK_INT < 23 || this.mPermission == null || method.isAnnotationPresent(Permission.class))) {
                        this.mMethodCount.getAndIncrement();
                        if (!method.isAnnotationPresent(Delayed.class)) {
                            this.mDelayedInitializers.add(method);
                        } else if (method.isAnnotationPresent(Async.class)) {
                            this.mAsyncInitializers.add(method);
                        } else if (method.isAnnotationPresent(Flow.class)) {
                            Flow flow = (Flow) method.getAnnotation(Flow.class);
                            if (flow == null) {
                                i2 = 0;
                            } else {
                                i2 = flow.value();
                            }
                            if (method.isAnnotationPresent(Global.class)) {
                                sparseArray = this.mGlobalFlowInitializers.get(i2);
                                if (sparseArray == null) {
                                    SparseArray<SparseArray<CopyOnWriteArrayList<Method>>> sparseArray3 = this.mGlobalFlowInitializers;
                                    sparseArray2 = new SparseArray<>();
                                    sparseArray3.put(i2, sparseArray2);
                                }
                                priority = (Priority) method.getAnnotation(Priority.class);
                                if (priority == null) {
                                    i3 = 0;
                                } else {
                                    i3 = priority.value();
                                }
                                copyOnWriteArrayList = sparseArray.get(i3);
                                if (copyOnWriteArrayList == null) {
                                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                                    sparseArray.put(i3, copyOnWriteArrayList);
                                }
                                copyOnWriteArrayList.add(method);
                            } else {
                                sparseArray = this.mUIFlowInitializers.get(i2);
                                if (sparseArray == null) {
                                    SparseArray<SparseArray<CopyOnWriteArrayList<Method>>> sparseArray4 = this.mUIFlowInitializers;
                                    sparseArray2 = new SparseArray<>();
                                    sparseArray4.put(i2, sparseArray2);
                                }
                                priority = (Priority) method.getAnnotation(Priority.class);
                                if (priority == null) {
                                }
                                copyOnWriteArrayList = sparseArray.get(i3);
                                if (copyOnWriteArrayList == null) {
                                }
                                copyOnWriteArrayList.add(method);
                            }
                            sparseArray = sparseArray2;
                            priority = (Priority) method.getAnnotation(Priority.class);
                            if (priority == null) {
                            }
                            copyOnWriteArrayList = sparseArray.get(i3);
                            if (copyOnWriteArrayList == null) {
                            }
                            copyOnWriteArrayList.add(method);
                        } else {
                            Priority priority2 = (Priority) method.getAnnotation(Priority.class);
                            if (priority2 == null) {
                                i = 0;
                            } else {
                                i = priority2.value();
                            }
                            ArrayList<Method> arrayList = this.mSyncInitializers.get(i);
                            if (arrayList == null) {
                                SparseArray<ArrayList<Method>> sparseArray5 = this.mSyncInitializers;
                                ArrayList<Method> arrayList2 = new ArrayList<>();
                                sparseArray5.put(i, arrayList2);
                                arrayList = arrayList2;
                            }
                            arrayList.add(method);
                        }
                    }
                }
                z = false;
                this.mMethodCount.getAndIncrement();
                if (!method.isAnnotationPresent(Delayed.class)) {
                }
            }
        }
    }

    public void start(PanguApplication panguApplication) {
        this.mApplication = panguApplication;
        Coordinator.runTask(new Coordinator.TaggedRunnable("initPanguParse") {
            /* class com.taobao.android.lifecycle.PanguInitializers.AnonymousClass1 */

            public void run() {
                PanguInitializers.this.parse();
            }
        });
        startInitializersAnnotatedBy(Global.class);
        panguApplication.registerCrossActivityLifecycleCallback(new a(panguApplication));
    }

    /* access modifiers changed from: protected */
    public void startInitializersAnnotatedBy(@Nullable Class<? extends Annotation> cls) {
        Iterator<Method> it = this.mAsyncInitializers.iterator();
        while (it.hasNext()) {
            final Method next = it.next();
            if (cls == null || next.isAnnotationPresent(cls)) {
                Coordinator.postTask(new Coordinator.TaggedRunnable(next.getName()) {
                    /* class com.taobao.android.lifecycle.PanguInitializers.AnonymousClass3 */

                    public void run() {
                        PanguInitializers.this.invokeInitializer(next);
                    }
                });
                it.remove();
            }
        }
        if (cls == null) {
            for (int i = 0; i < this.mUIFlowInitializers.size(); i++) {
                final int keyAt = this.mUIFlowInitializers.keyAt(i);
                Coordinator.postTask(new Coordinator.TaggedRunnable("UIFlow" + i) {
                    /* class com.taobao.android.lifecycle.PanguInitializers.AnonymousClass4 */

                    public void run() {
                        SparseArray<CopyOnWriteArrayList<Method>> sparseArray = PanguInitializers.this.mUIFlowInitializers.get(keyAt);
                        for (int i = 0; i < sparseArray.size(); i++) {
                            CopyOnWriteArrayList<Method> copyOnWriteArrayList = sparseArray.get(sparseArray.keyAt(i));
                            for (final Method method : copyOnWriteArrayList) {
                                copyOnWriteArrayList.remove(method);
                                Coordinator.runTask(new Coordinator.TaggedRunnable(method.getName()) {
                                    /* class com.taobao.android.lifecycle.PanguInitializers.AnonymousClass4.AnonymousClass1 */

                                    public void run() {
                                        PanguInitializers.this.invokeInitializer(method);
                                    }
                                });
                            }
                        }
                    }
                });
            }
        } else {
            for (int i2 = 0; i2 < this.mGlobalFlowInitializers.size(); i2++) {
                final int keyAt2 = this.mGlobalFlowInitializers.keyAt(i2);
                Coordinator.postTask(new Coordinator.TaggedRunnable("GlobalFlow" + i2) {
                    /* class com.taobao.android.lifecycle.PanguInitializers.AnonymousClass5 */

                    public void run() {
                        SparseArray<CopyOnWriteArrayList<Method>> sparseArray = PanguInitializers.this.mGlobalFlowInitializers.get(keyAt2);
                        for (int i = 0; i < sparseArray.size(); i++) {
                            CopyOnWriteArrayList<Method> copyOnWriteArrayList = sparseArray.get(sparseArray.keyAt(i));
                            for (final Method method : copyOnWriteArrayList) {
                                copyOnWriteArrayList.remove(method);
                                Coordinator.runTask(new Coordinator.TaggedRunnable(method.getName()) {
                                    /* class com.taobao.android.lifecycle.PanguInitializers.AnonymousClass5.AnonymousClass1 */

                                    public void run() {
                                        PanguInitializers.this.invokeInitializer(method);
                                    }
                                });
                            }
                        }
                    }
                });
            }
        }
        for (int i3 = 0; i3 < this.mSyncInitializers.size(); i3++) {
            Iterator<Method> it2 = this.mSyncInitializers.get(this.mSyncInitializers.keyAt(i3)).iterator();
            while (it2.hasNext()) {
                final Method next2 = it2.next();
                if (cls == null || next2.isAnnotationPresent(cls)) {
                    Coordinator.runTask(new Coordinator.TaggedRunnable(next2.getName()) {
                        /* class com.taobao.android.lifecycle.PanguInitializers.AnonymousClass6 */

                        public void run() {
                            PanguInitializers.this.invokeInitializer(next2);
                        }
                    });
                    it2.remove();
                }
            }
        }
        Iterator<Method> it3 = this.mDelayedInitializers.iterator();
        while (it3.hasNext()) {
            final Method next3 = it3.next();
            if (cls == null || next3.isAnnotationPresent(cls)) {
                Coordinator.postIdleTask(new Coordinator.TaggedRunnable(next3.getName()) {
                    /* class com.taobao.android.lifecycle.PanguInitializers.AnonymousClass7 */

                    public void run() {
                        PanguInitializers.this.invokeInitializer(next3);
                    }
                });
                it3.remove();
            }
        }
    }

    public PanguInitializers withPermission(String[] strArr) {
        this.mPermission = strArr;
        return this;
    }
}
