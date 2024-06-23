package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.NonBlockingThread;
import java.util.concurrent.CountDownLatch;
import tb.k22;

/* compiled from: Taobao */
public final class BlockingHelper {
    private BlockingHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static void awaitForComplete(CountDownLatch countDownLatch, Disposable disposable) {
        if (countDownLatch.getCount() != 0) {
            try {
                verifyNonBlocking();
                countDownLatch.await();
            } catch (InterruptedException e) {
                disposable.dispose();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
            }
        }
    }

    public static void verifyNonBlocking() {
        if (!k22.j()) {
            return;
        }
        if ((Thread.currentThread() instanceof NonBlockingThread) || k22.s()) {
            throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
        }
    }
}
