package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    protected final CountDownLatch a = new CountDownLatch(1);
    protected final List<T> b = new VolatileSizeArrayList();
    protected final List<Throwable> c = new VolatileSizeArrayList();
    protected long d;
    protected boolean e;
    protected int f;
    protected int g;

    /* compiled from: Taobao */
    public enum TestWaitStrategy implements Runnable {
        SPIN {
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy
            public void run() {
            }
        },
        YIELD {
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS {
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy
            public void run() {
                TestWaitStrategy.sleep(1);
            }
        },
        SLEEP_10MS {
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy
            public void run() {
                TestWaitStrategy.sleep(10);
            }
        },
        SLEEP_100MS {
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy
            public void run() {
                TestWaitStrategy.sleep(100);
            }
        },
        SLEEP_1000MS {
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy
            public void run() {
                TestWaitStrategy.sleep(1000);
            }
        };

        static void sleep(int i) {
            try {
                Thread.sleep((long) i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public abstract void run();
    }
}
