package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
@GwtIncompatible
/* compiled from: Taobao */
public interface Service {

    @Beta
    /* compiled from: Taobao */
    public enum State {
        NEW {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        STARTING {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        RUNNING {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        STOPPING {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        TERMINATED {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        },
        FAILED {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract boolean isTerminal();
    }

    @Beta
    /* compiled from: Taobao */
    public static abstract class b {
        public void a(State state, Throwable th) {
        }

        public void b() {
        }

        public void c() {
        }

        public void d(State state) {
        }

        public void e(State state) {
        }
    }

    void addListener(b bVar, Executor executor);

    void awaitRunning();

    void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException;

    void awaitTerminated();

    void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException;

    Throwable failureCause();

    boolean isRunning();

    @CanIgnoreReturnValue
    Service startAsync();

    State state();

    @CanIgnoreReturnValue
    Service stopAsync();
}
