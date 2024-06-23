package androidx.core.location;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Preconditions;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
public final class LocationManagerCompat {
    private static final long PRE_N_LOOPER_TIMEOUT_S = 4;
    private static Field sContextField;
    @GuardedBy("sGnssStatusListeners")
    private static final SimpleArrayMap<Object, Object> sGnssStatusListeners = new SimpleArrayMap<>();

    @RequiresApi(28)
    /* compiled from: Taobao */
    private static class Api28Impl {
        private Api28Impl() {
        }

        public static boolean isLocationEnabled(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    /* access modifiers changed from: private */
    @RequiresApi(30)
    /* compiled from: Taobao */
    public static class GnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        GnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        public void onFirstFix(int i) {
            this.mCallback.onFirstFix(i);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        public void onStarted() {
            this.mCallback.onStarted();
        }

        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class GpsStatusTransport implements GpsStatus.Listener {
        final GnssStatusCompat.Callback mCallback;
        @Nullable
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback;
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i) {
            GpsStatus gpsStatus;
            final Executor executor = this.mExecutor;
            if (executor != null) {
                if (i == 1) {
                    executor.execute(new Runnable() {
                        /* class androidx.core.location.LocationManagerCompat.GpsStatusTransport.AnonymousClass1 */

                        public void run() {
                            if (GpsStatusTransport.this.mExecutor == executor) {
                                GpsStatusTransport.this.mCallback.onStarted();
                            }
                        }
                    });
                } else if (i == 2) {
                    executor.execute(new Runnable() {
                        /* class androidx.core.location.LocationManagerCompat.GpsStatusTransport.AnonymousClass2 */

                        public void run() {
                            if (GpsStatusTransport.this.mExecutor == executor) {
                                GpsStatusTransport.this.mCallback.onStopped();
                            }
                        }
                    });
                } else if (i == 3) {
                    GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus(null);
                    if (gpsStatus2 != null) {
                        final int timeToFirstFix = gpsStatus2.getTimeToFirstFix();
                        executor.execute(new Runnable() {
                            /* class androidx.core.location.LocationManagerCompat.GpsStatusTransport.AnonymousClass3 */

                            public void run() {
                                if (GpsStatusTransport.this.mExecutor == executor) {
                                    GpsStatusTransport.this.mCallback.onFirstFix(timeToFirstFix);
                                }
                            }
                        });
                    }
                } else if (i == 4 && (gpsStatus = this.mLocationManager.getGpsStatus(null)) != null) {
                    final GnssStatusCompat wrap = GnssStatusCompat.wrap(gpsStatus);
                    executor.execute(new Runnable() {
                        /* class androidx.core.location.LocationManagerCompat.GpsStatusTransport.AnonymousClass4 */

                        public void run() {
                            if (GpsStatusTransport.this.mExecutor == executor) {
                                GpsStatusTransport.this.mCallback.onSatelliteStatusChanged(wrap);
                            }
                        }
                    });
                }
            }
        }

        public void register(Executor executor) {
            Preconditions.checkState(this.mExecutor == null);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    /* compiled from: Taobao */
    private static class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        InlineHandlerExecutor(@NonNull Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        public void execute(@NonNull Runnable runnable) {
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                runnable.run();
            } else if (!this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }

    /* access modifiers changed from: private */
    @RequiresApi(24)
    /* compiled from: Taobao */
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;
        @Nullable
        volatile Executor mExecutor;

        PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        public void onFirstFix(final int i) {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    /* class androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.AnonymousClass3 */

                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onFirstFix(i);
                        }
                    }
                });
            }
        }

        public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    /* class androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.AnonymousClass4 */

                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
                        }
                    }
                });
            }
        }

        public void onStarted() {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    /* class androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.AnonymousClass1 */

                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onStarted();
                        }
                    }
                });
            }
        }

        public void onStopped() {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    /* class androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.AnonymousClass2 */

                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onStopped();
                        }
                    }
                });
            }
        }

        public void register(Executor executor) {
            boolean z = true;
            Preconditions.checkArgument(executor != null, "invalid null executor");
            if (this.mExecutor != null) {
                z = false;
            }
            Preconditions.checkState(z);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private LocationManagerCompat() {
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return Api28Impl.isLocationEnabled(locationManager);
        }
        if (i <= 19) {
            try {
                if (sContextField == null) {
                    sContextField = LocationManager.class.getDeclaredField("mContext");
                }
                sContextField.setAccessible(true);
                Context context = (Context) sContextField.get(locationManager);
                if (i != 19) {
                    return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
                }
                if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0) {
                    return true;
                }
                return false;
            } catch (ClassCastException | IllegalAccessException | NoSuchFieldException | SecurityException unused) {
            }
        }
        if (locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
            return true;
        }
        return false;
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
        }
        return registerGnssStatusCallback(locationManager, new InlineHandlerExecutor(handler), callback);
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                GnssStatus.Callback callback2 = (GnssStatusTransport) simpleArrayMap.remove(callback);
                if (callback2 != null) {
                    locationManager.unregisterGnssStatusCallback(callback2);
                }
            }
        } else if (i >= 24) {
            SimpleArrayMap<Object, Object> simpleArrayMap2 = sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap2.remove(callback);
                if (preRGnssStatusTransport != null) {
                    preRGnssStatusTransport.unregister();
                    locationManager.unregisterGnssStatusCallback(preRGnssStatusTransport);
                }
            }
        } else {
            SimpleArrayMap<Object, Object> simpleArrayMap3 = sGnssStatusListeners;
            synchronized (simpleArrayMap3) {
                GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) simpleArrayMap3.remove(callback);
                if (gpsStatusTransport != null) {
                    gpsStatusTransport.unregister();
                    locationManager.removeGpsStatusListener(gpsStatusTransport);
                }
            }
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new Handler(myLooper), executor, callback);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:76:0x00d8 */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x010a A[Catch:{ ExecutionException -> 0x0100, TimeoutException -> 0x00e7, all -> 0x00e4, all -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011f A[Catch:{ ExecutionException -> 0x0100, TimeoutException -> 0x00e7, all -> 0x00e4, all -> 0x0126 }] */
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    private static boolean registerGnssStatusCallback(final LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
        Throwable th;
        ExecutionException e;
        TimeoutException e2;
        long nanos;
        boolean z;
        int i = Build.VERSION.SDK_INT;
        boolean z2 = true;
        if (i >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                GnssStatus.Callback callback2 = (GnssStatusTransport) simpleArrayMap.get(callback);
                if (callback2 == null) {
                    callback2 = new GnssStatusTransport(callback);
                }
                if (!locationManager.registerGnssStatusCallback(executor, callback2)) {
                    return false;
                }
                simpleArrayMap.put(callback, callback2);
                return true;
            }
        } else if (i >= 24) {
            Preconditions.checkArgument(handler != null);
            SimpleArrayMap<Object, Object> simpleArrayMap2 = sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap2.get(callback);
                if (preRGnssStatusTransport == null) {
                    preRGnssStatusTransport = new PreRGnssStatusTransport(callback);
                } else {
                    preRGnssStatusTransport.unregister();
                }
                preRGnssStatusTransport.register(executor);
                if (!locationManager.registerGnssStatusCallback(preRGnssStatusTransport, handler)) {
                    return false;
                }
                simpleArrayMap2.put(callback, preRGnssStatusTransport);
                return true;
            }
        } else {
            Preconditions.checkArgument(handler != null);
            SimpleArrayMap<Object, Object> simpleArrayMap3 = sGnssStatusListeners;
            synchronized (simpleArrayMap3) {
                final GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) simpleArrayMap3.get(callback);
                if (gpsStatusTransport == null) {
                    gpsStatusTransport = new GpsStatusTransport(locationManager, callback);
                } else {
                    gpsStatusTransport.unregister();
                }
                gpsStatusTransport.register(executor);
                FutureTask futureTask = new FutureTask(new Callable<Boolean>() {
                    /* class androidx.core.location.LocationManagerCompat.AnonymousClass1 */

                    @Override // java.util.concurrent.Callable
                    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
                    public Boolean call() {
                        return Boolean.valueOf(locationManager.addGpsStatusListener(gpsStatusTransport));
                    }
                });
                if (Looper.myLooper() == handler.getLooper()) {
                    futureTask.run();
                } else if (!handler.post(futureTask)) {
                    throw new IllegalStateException(handler + " is shutting down");
                }
                try {
                    nanos = TimeUnit.SECONDS.toNanos(4);
                    z = false;
                    while (true) {
                        try {
                            break;
                        } catch (InterruptedException unknown) {
                            try {
                                nanos = (System.nanoTime() + nanos) - System.nanoTime();
                                z = true;
                            } catch (ExecutionException e3) {
                                e = e3;
                                if (e.getCause() instanceof RuntimeException) {
                                }
                            } catch (TimeoutException e4) {
                                e2 = e4;
                                throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e2);
                            }
                        } catch (ExecutionException e5) {
                            e = e5;
                            if (e.getCause() instanceof RuntimeException) {
                            }
                        } catch (TimeoutException e6) {
                            e2 = e6;
                            z2 = z;
                            throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e2);
                        } catch (Throwable th2) {
                            th = th2;
                            z2 = z;
                            if (z2) {
                            }
                            throw th;
                        }
                        nanos = (System.nanoTime() + nanos) - System.nanoTime();
                        z = true;
                    }
                    if (((Boolean) futureTask.get(nanos, TimeUnit.NANOSECONDS)).booleanValue()) {
                        sGnssStatusListeners.put(callback, gpsStatusTransport);
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                        return true;
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                } catch (ExecutionException e7) {
                    e = e7;
                    if (e.getCause() instanceof RuntimeException) {
                        throw ((RuntimeException) e.getCause());
                    } else if (e.getCause() instanceof Error) {
                        throw ((Error) e.getCause());
                    } else {
                        throw new IllegalStateException(e);
                    }
                } catch (TimeoutException e8) {
                    e2 = e8;
                    z2 = false;
                    throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e2);
                } catch (Throwable th3) {
                    th = th3;
                    if (z2) {
                    }
                    throw th;
                }
            }
        }
    }
}
