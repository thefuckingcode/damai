package io.reactivex.internal.util;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
public final class BlockingIgnoringReceiver extends CountDownLatch implements Consumer<Throwable>, Action {
    public Throwable error;

    public BlockingIgnoringReceiver() {
        super(1);
    }

    @Override // io.reactivex.functions.Action
    public void run() {
        countDown();
    }

    public void accept(Throwable th) {
        this.error = th;
        countDown();
    }
}
