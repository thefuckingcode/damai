package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicInteger;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class QueueDrainSubscriberWip extends QueueDrainSubscriberPad0 {
    final AtomicInteger wip = new AtomicInteger();

    QueueDrainSubscriberWip() {
    }
}
