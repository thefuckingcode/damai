package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicLong;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class QueueDrainSubscriberPad3 extends QueueDrainSubscriberPad2 {
    final AtomicLong requested = new AtomicLong();

    QueueDrainSubscriberPad3() {
    }
}
