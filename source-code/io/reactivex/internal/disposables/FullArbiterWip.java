package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
class FullArbiterWip extends FullArbiterPad0 {
    final AtomicInteger wip = new AtomicInteger();

    FullArbiterWip() {
    }
}
