package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class QueueDrainSubscriberWip extends QueueDrainSubscriberPad0 {
    final AtomicInteger wip = new AtomicInteger();

    QueueDrainSubscriberWip() {
    }
}
