package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;
import tb.wr2;

/* access modifiers changed from: package-private */
@GwtCompatible
/* compiled from: Taobao */
public abstract class AggregateFuture<InputT, OutputT> extends AbstractFuture.g<OutputT> {
    private static final Logger b = Logger.getLogger(AggregateFuture.class.getName());
    @NullableDecl
    private AggregateFuture<InputT, OutputT>.RunningState a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public abstract class RunningState extends d implements Runnable {
        private final boolean allMustSucceed;
        private final boolean collectsValues;
        private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;

        RunningState(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z, boolean z2) {
            super(immutableCollection.size());
            this.futures = (ImmutableCollection) ds1.p(immutableCollection);
            this.allMustSucceed = z;
            this.collectsValues = z2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void decrementCountAndMaybeComplete() {
            int decrementRemainingAndGet = decrementRemainingAndGet();
            ds1.x(decrementRemainingAndGet >= 0, "Less than 0 remaining futures");
            if (decrementRemainingAndGet == 0) {
                processCompleted();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        private void handleException(Throwable th) {
            boolean z;
            boolean z2;
            boolean z3;
            ds1.p(th);
            if (this.allMustSucceed) {
                z2 = AggregateFuture.this.setException(th);
                if (z2) {
                    releaseResourcesAfterFailure();
                } else {
                    z = AggregateFuture.d(getOrInitSeenExceptions(), th);
                    z3 = th instanceof Error;
                    if (!((!z2) & this.allMustSucceed & z) && !z3) {
                        AggregateFuture.b.log(Level.SEVERE, z3 ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
                        return;
                    }
                    return;
                }
            } else {
                z2 = false;
            }
            z = true;
            z3 = th instanceof Error;
            if (!((!z2) & this.allMustSucceed & z) && !z3) {
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.util.concurrent.AggregateFuture$RunningState */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void handleOneInputDone(int i, Future<? extends InputT> future) {
            ds1.x(this.allMustSucceed || !AggregateFuture.this.isDone() || AggregateFuture.this.isCancelled(), "Future was done before all dependencies completed");
            try {
                ds1.x(future.isDone(), "Tried to set value from future which is not done");
                if (this.allMustSucceed) {
                    if (future.isCancelled()) {
                        AggregateFuture.this.a = null;
                        AggregateFuture.this.cancel(false);
                        return;
                    }
                    Object d = Futures.d(future);
                    if (this.collectsValues) {
                        collectOneValue(this.allMustSucceed, i, d);
                    }
                } else if (this.collectsValues && !future.isCancelled()) {
                    collectOneValue(this.allMustSucceed, i, Futures.d(future));
                }
            } catch (ExecutionException e) {
                handleException(e.getCause());
            } catch (Throwable th) {
                handleException(th);
            }
        }

        /* access modifiers changed from: private */
        public void init() {
            if (this.futures.isEmpty()) {
                handleAllCompleted();
            } else if (this.allMustSucceed) {
                final int i = 0;
                wr2<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                while (it.hasNext()) {
                    final ListenableFuture listenableFuture = (ListenableFuture) it.next();
                    listenableFuture.addListener(new Runnable() {
                        /* class com.google.common.util.concurrent.AggregateFuture.RunningState.AnonymousClass1 */

                        public void run() {
                            try {
                                RunningState.this.handleOneInputDone(i, listenableFuture);
                            } finally {
                                RunningState.this.decrementCountAndMaybeComplete();
                            }
                        }
                    }, MoreExecutors.a());
                    i++;
                }
            } else {
                wr2<? extends ListenableFuture<? extends InputT>> it2 = this.futures.iterator();
                while (it2.hasNext()) {
                    ((ListenableFuture) it2.next()).addListener(this, MoreExecutors.a());
                }
            }
        }

        private void processCompleted() {
            if (this.collectsValues && (!this.allMustSucceed)) {
                int i = 0;
                wr2<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                while (it.hasNext()) {
                    handleOneInputDone(i, (ListenableFuture) it.next());
                    i++;
                }
            }
            handleAllCompleted();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.d
        public final void addInitialException(Set<Throwable> set) {
            if (!AggregateFuture.this.isCancelled()) {
                AggregateFuture.d(set, AggregateFuture.this.tryInternalFastPathGetFailure());
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void collectOneValue(boolean z, int i, @NullableDecl InputT inputt);

        /* access modifiers changed from: package-private */
        public abstract void handleAllCompleted();

        /* access modifiers changed from: package-private */
        public void interruptTask() {
        }

        /* access modifiers changed from: package-private */
        @ForOverride
        @OverridingMethodsMustInvokeSuper
        public void releaseResourcesAfterFailure() {
            this.futures = null;
        }

        public final void run() {
            decrementCountAndMaybeComplete();
        }
    }

    AggregateFuture() {
    }

    /* access modifiers changed from: private */
    public static boolean d(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        e();
    }

    /* access modifiers changed from: protected */
    public final void e() {
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.a;
        if (runningState != null) {
            this.a = null;
            ImmutableCollection immutableCollection = ((RunningState) runningState).futures;
            boolean wasInterrupted = wasInterrupted();
            if (wasInterrupted) {
                runningState.interruptTask();
            }
            if (isCancelled() && (immutableCollection != null)) {
                wr2 it = immutableCollection.iterator();
                while (it.hasNext()) {
                    ((ListenableFuture) it.next()).cancel(wasInterrupted);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        ImmutableCollection immutableCollection;
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.a;
        if (runningState == null || (immutableCollection = ((RunningState) runningState).futures) == null) {
            return null;
        }
        return "futures=[" + immutableCollection + jl1.ARRAY_END_STR;
    }
}
