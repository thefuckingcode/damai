package com.alibaba.pictures.dolores.login;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;
import tb.ua0;
import tb.vp;

/* compiled from: Taobao */
public final class DoloresLoginHandler extends Handler implements IDoloresLoginListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final int LOGIN = 0;
    public static final int LOGIN_RET_CANCEL = 3;
    public static final int LOGIN_RET_FAIL = 2;
    public static final int LOGIN_RET_INIT = 0;
    public static final int LOGIN_RET_SUCCESS = 1;
    @NotNull
    private static final String b;
    @NotNull
    private static final AtomicBoolean c = new AtomicBoolean();
    @NotNull
    private static final Lazy d = b.b(DoloresLoginHandler$Companion$sInstance$2.INSTANCE);
    private static final ReentrantLock e;
    private static Condition f;
    private int a;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @NotNull
        public final DoloresLoginHandler a() {
            Object value;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2126724172")) {
                value = ipChange.ipc$dispatch("2126724172", new Object[]{this});
            } else {
                Lazy lazy = DoloresLoginHandler.d;
                a aVar = DoloresLoginHandler.Companion;
                value = lazy.getValue();
            }
            return (DoloresLoginHandler) value;
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    static {
        String simpleName = DoloresLoginHandler.class.getSimpleName();
        k21.h(simpleName, "DoloresLoginHandler::class.java.simpleName");
        b = simpleName;
        ReentrantLock reentrantLock = new ReentrantLock();
        e = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        k21.h(newCondition, "lock.newCondition()");
        f = newCondition;
    }

    private DoloresLoginHandler(Looper looper) {
        super(looper);
    }

    /* JADX INFO: finally extract failed */
    public final int b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1970798375")) {
            return ((Integer) ipChange.ipc$dispatch("-1970798375", new Object[]{this})).intValue();
        }
        d();
        e.lock();
        try {
            AtomicBoolean atomicBoolean = c;
            if (!atomicBoolean.get()) {
                atomicBoolean.set(true);
                this.a = 0;
                sendEmptyMessage(0);
            }
            try {
                String str = b;
                vp.a(str, this + " wait");
                f.await();
                vp.a(str, this + " wakeup");
            } catch (Exception e2) {
                vp.b(b, e2);
            }
            e.unlock();
            return this.a;
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    public final boolean c() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1916304416")) {
            return ((Boolean) ipChange.ipc$dispatch("1916304416", new Object[]{this})).booleanValue();
        }
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            IDoloresLoginDelegate d2 = ua0.Companion.d();
            if (d2 != null && d2.isSessionValid()) {
                z = true;
            }
        } catch (Exception unused) {
            reentrantLock = e;
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
        reentrantLock.unlock();
        return z;
    }

    public final void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-847952401")) {
            ipChange.ipc$dispatch("-847952401", new Object[]{this});
            return;
        }
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            String str = b;
            vp.a(str, this + " onLoginCancel");
            this.a = 3;
            f.signalAll();
            c.set(false);
            reentrantLock.unlock();
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    public void handleMessage(@NotNull Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2022227118")) {
            ipChange.ipc$dispatch("-2022227118", new Object[]{this, message});
            return;
        }
        k21.i(message, "msg");
        if (message.what == 0) {
            String str = b;
            vp.a(str, this + " handleMessage login");
            IDoloresLoginDelegate d2 = ua0.Companion.d();
            if (d2 != null) {
                d2.doLogin(true, this);
                return;
            }
            vp.c(str, this + " loginDelegate==null");
            onLoginFail();
        }
    }

    @Override // com.alibaba.pictures.dolores.login.IDoloresLoginListener
    public void onLoginCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649263558")) {
            ipChange.ipc$dispatch("-649263558", new Object[]{this});
            return;
        }
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            String str = b;
            vp.a(str, this + " onLoginCancel");
            this.a = 3;
            f.signalAll();
            c.set(false);
            reentrantLock.unlock();
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    @Override // com.alibaba.pictures.dolores.login.IDoloresLoginListener
    public void onLoginFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1896759594")) {
            ipChange.ipc$dispatch("-1896759594", new Object[]{this});
            return;
        }
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            String str = b;
            vp.a(str, this + " onLoginFail");
            this.a = 2;
            f.signalAll();
            c.set(false);
            reentrantLock.unlock();
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    @Override // com.alibaba.pictures.dolores.login.IDoloresLoginListener
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273281293")) {
            ipChange.ipc$dispatch("-1273281293", new Object[]{this});
            return;
        }
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            String str = b;
            vp.a(str, this + " onLoginSuccess");
            this.a = 1;
            f.signalAll();
            c.set(false);
            reentrantLock.unlock();
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    public /* synthetic */ DoloresLoginHandler(Looper looper, m40 m40) {
        this(looper);
    }
}
