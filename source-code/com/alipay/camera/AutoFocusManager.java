package com.alipay.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.camera.base.AntCamera;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Taobao */
public final class AutoFocusManager implements Camera.AutoFocusCallback {
    private static final Collection<String> m;
    private boolean a;
    private boolean b;
    private boolean c;
    private final boolean d;
    private final Camera e;
    private AsyncTask<?, ?, ?> f;
    private AsyncTask<?, ?, ?> g;
    private long h;
    private long i;
    private Handler j;
    private boolean k;
    private long l;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class AutoFocusTask extends AsyncTask<Object, Object, Object> {
        private AutoFocusTask() {
        }

        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(AutoFocusManager.this.h);
            } catch (InterruptedException unused) {
            }
            AutoFocusManager.this.k();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class CheckAutoFocusTask extends AsyncTask<Object, Object, Object> {
        private CheckAutoFocusTask() {
        }

        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(AutoFocusManager.this.i);
            } catch (InterruptedException unused) {
                MPaasLogger.e("AutoFocusManager", new Object[]{"InterruptedException"});
            }
            if (!AutoFocusManager.this.c) {
                return null;
            }
            try {
                AutoFocusManager.this.e.cancelAutoFocus();
            } catch (RuntimeException e) {
                MPaasLogger.e("AutoFocusManager", new Object[]{"exception while cancel autofocus:"}, e);
            }
            AutoFocusManager.this.b = false;
            AutoFocusManager.this.c = false;
            AutoFocusManager.this.k();
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        m = arrayList;
        arrayList.add("auto");
        arrayList.add(BQCCameraParam.FOCUS_TYPE_MACRO);
    }

    public AutoFocusManager(Context context, Camera camera) {
        this(context, camera, (String) null, false);
    }

    private synchronized void h() {
        if (!this.a && this.f == null) {
            AutoFocusTask autoFocusTask = new AutoFocusTask();
            try {
                autoFocusTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f = autoFocusTask;
            } catch (RejectedExecutionException e2) {
                MPaasLogger.e("AutoFocusManager", new Object[]{"Could not request auto focus:"}, e2);
            }
        }
    }

    private synchronized void i() {
        AsyncTask<?, ?, ?> asyncTask = this.g;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.g.cancel(true);
            }
            this.g = null;
        }
    }

    private synchronized void j() {
        AsyncTask<?, ?, ?> asyncTask = this.f;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.f.cancel(true);
            }
            this.f = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void k() {
        if (this.d) {
            this.f = null;
            if (!this.a && !this.b) {
                try {
                    MPaasLogger.d("AutoFocusManager", new Object[]{"camera.autoFocus"});
                    this.l = System.currentTimeMillis();
                    this.e.autoFocus(this);
                    this.b = true;
                    if (this.c) {
                        CheckAutoFocusTask checkAutoFocusTask = new CheckAutoFocusTask();
                        this.g = checkAutoFocusTask;
                        try {
                            checkAutoFocusTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                        } catch (RejectedExecutionException e2) {
                            MPaasLogger.e("AutoFocusManager", new Object[]{"CheckAutoFocusTask exception:"}, e2);
                        }
                    }
                } catch (RuntimeException unused) {
                    MPaasLogger.e("AutoFocusManager", new Object[]{"Unexpected exception while focusing"});
                    h();
                }
            }
        }
    }

    public void init(Camera camera) {
    }

    public void init(AntCamera antCamera) {
    }

    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.b = false;
        this.c = false;
        MPaasLogger.d("AutoFocusManager", new Object[]{"AutoFocusManager.onAutoFocus(): success= ", Boolean.valueOf(z)});
        if (this.k) {
            long currentTimeMillis = System.currentTimeMillis() - this.l;
            MPaasLogger.d("AutoFocusManager", new Object[]{"focus During time: " + currentTimeMillis + " success: ", Boolean.valueOf(z)});
            WalletBury.addWalletBury("recordFirstAutoFocus", new Class[]{Boolean.TYPE, Long.TYPE}, new Object[]{Boolean.valueOf(z), Long.valueOf(currentTimeMillis)});
            this.k = false;
        }
        h();
    }

    public synchronized void restart() {
        this.a = false;
        k();
    }

    public void setAutoFocusInterval(long j2) {
        if (j2 >= 0) {
            this.h = j2;
        }
    }

    public void setCheckAutoFocusInterval(long j2) {
        if (j2 >= 0) {
            this.i = j2;
        }
    }

    public void startAutoFocus() {
        Handler handler = this.j;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }

    public synchronized void stop() {
        this.a = true;
        if (this.d) {
            j();
            i();
            try {
                this.e.cancelAutoFocus();
                this.b = false;
            } catch (RuntimeException e2) {
                MPaasLogger.e("AutoFocusManager", new Object[]{"Unexpected exception while cancelling focusing:"}, e2);
            }
        }
    }

    public AutoFocusManager(Context context, Camera camera, String str) {
        this(context, camera, str, false);
    }

    public AutoFocusManager(Context context, AntCamera antCamera) {
        this(context, antCamera, (String) null, false);
    }

    public AutoFocusManager(Context context, AntCamera antCamera, String str) {
        this(context, antCamera, str, false);
    }

    public AutoFocusManager(Context context, AntCamera antCamera, String str, boolean z) {
        this(context, antCamera.getCamera(), str, z);
    }

    public AutoFocusManager(Context context, Camera camera, String str, boolean z) {
        this.c = true;
        this.h = 2000;
        this.i = 2000;
        this.e = camera;
        this.j = new Handler(context.getMainLooper()) {
            /* class com.alipay.camera.AutoFocusManager.AnonymousClass1 */

            public void handleMessage(Message message) {
                MPaasLogger.d("AutoFocusManager", new Object[]{"AutoFocusManager start autoFocus"});
                AutoFocusManager.this.k();
            }
        };
        str = TextUtils.isEmpty(str) ? camera.getParameters().getFocusMode() : str;
        boolean z2 = m.contains(str) || z;
        this.d = z2;
        this.k = true;
        MPaasLogger.i("AutoFocusManager", new Object[]{"AutoFocusManager Current focus mode '", str, "'; use auto focus? ", Boolean.valueOf(z2), " requestAutoFocus: ", Boolean.valueOf(z)});
    }
}
